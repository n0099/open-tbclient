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
    private boolean kGt;
    public TextView lrX;
    public TextView lrY;
    public TextView lrZ;
    private TextView lsa;
    private TbImageView lsb;
    private ThreadAgreeAndShareLayout lsc;
    private boolean lsd;
    private boolean lse;
    private com.baidu.tbadk.core.view.a.a lsf;
    private SpannableStringBuilder lsg;
    private SpannableStringBuilder lsh;
    private View.OnTouchListener lsi;
    private View.OnTouchListener lsj;
    private com.baidu.tbadk.widget.richText.f lsk = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.kGt = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new i(d.this.lsg));
            d.this.mTitleView.setText(d.this.lsg);
            d.this.lrZ.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.lsa) {
                Object tag = d.this.lsa.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.lrZ) {
                d.this.kGt = false;
                d.this.mTitleView.setOnTouchListener(d.this.lsj);
                d.this.mTitleView.setText(d.this.lsh);
                d.this.lrZ.setVisibility(8);
            }
        }
    };
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(R.id.view_video_title);
            this.mTitleView.setTextSize(0, TbConfig.getContentSize());
            this.mTitleView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.mTitleView.getPaint().setFakeBoldText(true);
            this.lrX = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.lrY = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.lrZ = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.lsa = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.lsc = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.lsb = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.lsg != null && !d.this.lse && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.kGt) {
                            if (!d.this.lsd) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.lrZ.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.lrZ.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.lrZ.setLayoutParams(layoutParams);
                                d.this.lsd = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.lsh == null) {
                                String spannableStringBuilder = d.this.lsg.toString();
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder, at.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.lsh = new SpannableStringBuilder();
                                d.this.lsh.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.lsg.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.lsg.getSpanStart(obj);
                                    int spanEnd = d.this.lsg.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.lsh.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.lsk, 0, spannableString.length(), 17);
                                d.this.lsh.insert(length, (CharSequence) spannableString);
                                d.this.lsj = new i(d.this.lsh);
                            }
                            d.this.lrZ.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.lsj);
                            d.this.mTitleView.setText(d.this.lsh);
                        }
                    }
                }
            });
        }
    }

    private boolean aL(bw bwVar) {
        if (bwVar == null || this.lsg == null || !bwVar.biX() || StringUtils.isNull(bwVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.blO().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bwVar.getTid();
        this.lsg.append((CharSequence) bwVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new aq("c12841").dK("obj_source", "3"));
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
        bw dcA;
        bs bsVar;
        Layout c;
        SpannableString aJ;
        if (fVar != null && (dcA = fVar.dcA()) != null && dcA.biz() != null) {
            dcA.bjg();
            this.lsg = new SpannableStringBuilder(dcA.biR());
            boolean aL = aL(dcA);
            VideoInfo biz = dcA.biz();
            if (!StringUtils.isNull(biz.mcn_lead_page) && !aL) {
                this.lse = true;
            } else {
                this.lse = false;
            }
            if (this.lsg != null && !this.lse && !aL && (aJ = ay.aJ(dcA)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aJ.getSpans(0, aJ.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.lsf = aVarArr[0];
                }
                this.lsg.append((CharSequence) aJ);
            }
            if (this.lsf != null && this.lsg != null && (c = ay.c(this.lsg)) != null && c.getLineCount() > 10) {
                int spanStart = this.lsg.getSpanStart(this.lsf);
                int spanEnd = this.lsg.getSpanEnd(this.lsf);
                if (spanStart > 0) {
                    this.lsg.delete(spanStart, spanEnd);
                }
            }
            if (this.lse) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, dcA.biR().toString(), biz.mcn_lead_page, dcA.getTid());
            } else {
                this.mTitleView.setText(this.lsg);
            }
            this.mTitleView.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            this.lsi = new i(this.lsg);
            this.mTitleView.setOnTouchListener(this.lsi);
            this.lrZ.setOnClickListener(this.mOnClickListener);
            this.lrY.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), at.numberUniformFormatExtra(biz.play_count.intValue())));
            if (fVar.ddd() && fVar.dda()) {
                if (TextUtils.isEmpty(str)) {
                    str = dcA.bil();
                }
                if (TextUtils.isEmpty(str) && (bsVar = (bs) y.getItem(fVar.dcX(), 0)) != null) {
                    str = bsVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.lsb.setVisibility(0);
                    this.lsa.setVisibility(0);
                    this.lsa.setOnClickListener(this.mOnClickListener);
                    this.lsa.setText(ay.OX(str));
                    this.lsa.setTag(str);
                } else {
                    this.lsa.setVisibility(8);
                    this.lsb.setVisibility(8);
                }
                this.lrX.setVisibility(8);
                this.lsc.setData(fVar, dcA.bjY());
            } else {
                this.lsb.setVisibility(8);
                this.lsa.setVisibility(8);
                this.lrX.setVisibility(0);
                this.lrX.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), at.numberUniformFormatExtra(dcA.bhY())));
                this.lsc.setVisibility(8);
            }
            btm();
        }
    }

    public void btm() {
        ap.setViewTextColor(this.lrZ, R.color.cp_link_tip_c, 1);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.lrX, R.color.cp_cont_j, 1);
        ap.setViewTextColor(this.lrY, R.color.cp_cont_j, 1);
        ap.setViewTextColor(this.lsa, R.color.cp_cont_j, 1);
        ap.setImageResource(this.lsb, R.drawable.icon_common_arrow20_right_n);
        if (this.lsc != null) {
            this.lsc.btm();
        }
    }
}
