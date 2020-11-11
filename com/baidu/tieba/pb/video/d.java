package com.baidu.tieba.pb.video;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout;
import com.baidu.tieba.view.i;
import tbclient.VideoInfo;
/* loaded from: classes22.dex */
public class d {
    private boolean kYM;
    private com.baidu.tbadk.core.view.a.a lKA;
    private SpannableStringBuilder lKB;
    private SpannableStringBuilder lKC;
    private View.OnTouchListener lKD;
    private View.OnTouchListener lKE;
    public TextView lKs;
    public TextView lKt;
    public TextView lKu;
    private TextView lKv;
    private TbImageView lKw;
    private ThreadAgreeAndShareLayout lKx;
    private boolean lKy;
    private boolean lKz;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f lKF = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.kYM = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new i(d.this.lKB));
            d.this.mTitleView.setText(d.this.lKB);
            d.this.lKu.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.lKv) {
                Object tag = d.this.lKv.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.lKu) {
                d.this.kYM = false;
                d.this.mTitleView.setOnTouchListener(d.this.lKE);
                d.this.mTitleView.setText(d.this.lKC);
                d.this.lKu.setVisibility(8);
            }
        }
    };

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(R.id.view_video_title);
            this.mTitleView.setTextSize(0, TbConfig.getContentSize());
            this.mTitleView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.mTitleView.getPaint().setFakeBoldText(true);
            this.lKs = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.lKt = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.lKu = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.lKv = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.lKx = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.lKw = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.lKB != null && !d.this.lKz && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.kYM) {
                            if (!d.this.lKy) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.lKu.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.lKu.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.lKu.setLayoutParams(layoutParams);
                                d.this.lKy = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.lKC == null) {
                                String spannableStringBuilder = d.this.lKB.toString();
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder, at.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.lKC = new SpannableStringBuilder();
                                d.this.lKC.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.lKB.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.lKB.getSpanStart(obj);
                                    int spanEnd = d.this.lKB.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.lKC.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.lKF, 0, spannableString.length(), 17);
                                d.this.lKC.insert(length, (CharSequence) spannableString);
                                d.this.lKE = new i(d.this.lKC);
                            }
                            d.this.lKu.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.lKE);
                            d.this.mTitleView.setText(d.this.lKC);
                        }
                    }
                }
            });
        }
    }

    private boolean aL(bw bwVar) {
        if (bwVar == null || this.lKB == null || !bwVar.bnq() || StringUtils.isNull(bwVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.bqh().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bwVar.getTid();
        this.lKB.append((CharSequence) bwVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new aq("c12841").dR("obj_source", "3"));
            }

            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                textPaint.setUnderlineText(false);
            }
        }));
        return true;
    }

    public void a(com.baidu.tieba.pb.data.f fVar, String str) {
        bw dik;
        bs bsVar;
        Layout d;
        SpannableString aJ;
        if (fVar != null && (dik = fVar.dik()) != null && dik.bmS() != null) {
            dik.bnz();
            this.lKB = new SpannableStringBuilder(dik.bnk());
            boolean aL = aL(dik);
            VideoInfo bmS = dik.bmS();
            if (!StringUtils.isNull(bmS.mcn_lead_page) && !aL) {
                this.lKz = true;
            } else {
                this.lKz = false;
            }
            if (this.lKB != null && !this.lKz && !aL && (aJ = ay.aJ(dik)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aJ.getSpans(0, aJ.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.lKA = aVarArr[0];
                }
                this.lKB.append((CharSequence) aJ);
            }
            if (this.lKA != null && this.lKB != null && (d = ay.d(this.lKB)) != null && d.getLineCount() > 10) {
                int spanStart = this.lKB.getSpanStart(this.lKA);
                int spanEnd = this.lKB.getSpanEnd(this.lKA);
                if (spanStart > 0) {
                    this.lKB.delete(spanStart, spanEnd);
                }
            }
            if (this.lKz) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, dik.bnk().toString(), bmS.mcn_lead_page, dik.getTid());
            } else {
                this.mTitleView.setText(this.lKB);
            }
            this.mTitleView.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            this.lKD = new i(this.lKB);
            this.mTitleView.setOnTouchListener(this.lKD);
            this.lKu.setOnClickListener(this.mOnClickListener);
            this.lKt.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), at.numberUniformFormatExtra(bmS.play_count.intValue())));
            if (fVar.diN() && fVar.diK()) {
                if (TextUtils.isEmpty(str)) {
                    str = dik.bmE();
                }
                if (TextUtils.isEmpty(str) && (bsVar = (bs) y.getItem(fVar.diH(), 0)) != null) {
                    str = bsVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.lKw.setVisibility(0);
                    this.lKv.setVisibility(0);
                    this.lKv.setOnClickListener(this.mOnClickListener);
                    this.lKv.setText(ay.PM(str));
                    this.lKv.setTag(str);
                } else {
                    this.lKv.setVisibility(8);
                    this.lKw.setVisibility(8);
                }
                this.lKs.setVisibility(8);
                this.lKx.setData(fVar, dik.bor());
            } else {
                this.lKw.setVisibility(8);
                this.lKv.setVisibility(8);
                this.lKs.setVisibility(0);
                this.lKs.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), at.numberUniformFormatExtra(dik.bmr())));
                this.lKx.setVisibility(8);
            }
            bxE();
        }
    }

    public void bxE() {
        ap.setViewTextColor(this.lKu, R.color.cp_link_tip_c, 1);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.lKs, R.color.cp_cont_j, 1);
        ap.setViewTextColor(this.lKt, R.color.cp_cont_j, 1);
        ap.setViewTextColor(this.lKv, R.color.cp_cont_j, 1);
        ap.setImageResource(this.lKw, R.drawable.icon_common_arrow20_right_n);
        if (this.lKx != null) {
            this.lKx.bxE();
        }
    }
}
