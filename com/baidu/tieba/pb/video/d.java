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
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout;
import com.baidu.tieba.view.i;
import tbclient.VideoInfo;
/* loaded from: classes16.dex */
public class d {
    private boolean jTd;
    public TextView kEm;
    public TextView kEn;
    public TextView kEo;
    private TextView kEp;
    private TbImageView kEq;
    private ThreadAgreeAndShareLayout kEr;
    private boolean kEs;
    private boolean kEt;
    private com.baidu.tbadk.core.view.a.a kEu;
    private SpannableStringBuilder kEv;
    private SpannableStringBuilder kEw;
    private View.OnTouchListener kEx;
    private View.OnTouchListener kEy;
    private com.baidu.tbadk.widget.richText.f kEz = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.jTd = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new i(d.this.kEv));
            d.this.mTitleView.setText(d.this.kEv);
            d.this.kEo.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.kEp) {
                Object tag = d.this.kEp.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.kEo) {
                d.this.jTd = false;
                d.this.mTitleView.setOnTouchListener(d.this.kEy);
                d.this.mTitleView.setText(d.this.kEw);
                d.this.kEo.setVisibility(8);
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
            this.kEm = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.kEn = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.kEo = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.kEp = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.kEr = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.kEq = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.kEv != null && !d.this.kEt && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.jTd) {
                            if (!d.this.kEs) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.kEo.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.kEo.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.kEo.setLayoutParams(layoutParams);
                                d.this.kEs = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.kEw == null) {
                                String spannableStringBuilder = d.this.kEv.toString();
                                String cutChineseAndEnglishWithSuffix = as.cutChineseAndEnglishWithSuffix(spannableStringBuilder, as.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.kEw = new SpannableStringBuilder();
                                d.this.kEw.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.kEv.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.kEv.getSpanStart(obj);
                                    int spanEnd = d.this.kEv.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.kEw.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.kEz, 0, spannableString.length(), 17);
                                d.this.kEw.insert(length, (CharSequence) spannableString);
                                d.this.kEy = new i(d.this.kEw);
                            }
                            d.this.kEo.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.kEy);
                            d.this.mTitleView.setText(d.this.kEw);
                        }
                    }
                }
            });
        }
    }

    private boolean aJ(bv bvVar) {
        if (bvVar == null || this.kEv == null || !bvVar.aXb() || StringUtils.isNull(bvVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.aZP().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bvVar.getTid();
        this.kEv.append((CharSequence) bvVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new ap("c12841").dn("obj_source", "3"));
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
        bv cKx;
        br brVar;
        Layout c;
        SpannableString aH;
        if (fVar != null && (cKx = fVar.cKx()) != null && cKx.aWD() != null) {
            cKx.aXk();
            this.kEv = new SpannableStringBuilder(cKx.aWV());
            boolean aJ = aJ(cKx);
            VideoInfo aWD = cKx.aWD();
            if (!StringUtils.isNull(aWD.mcn_lead_page) && !aJ) {
                this.kEt = true;
            } else {
                this.kEt = false;
            }
            if (this.kEv != null && !this.kEt && !aJ && (aH = ay.aH(cKx)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aH.getSpans(0, aH.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.kEu = aVarArr[0];
                }
                this.kEv.append((CharSequence) aH);
            }
            if (this.kEu != null && this.kEv != null && (c = ay.c(this.kEv)) != null && c.getLineCount() > 10) {
                int spanStart = this.kEv.getSpanStart(this.kEu);
                int spanEnd = this.kEv.getSpanEnd(this.kEu);
                if (spanStart > 0) {
                    this.kEv.delete(spanStart, spanEnd);
                }
            }
            if (this.kEt) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, cKx.aWV().toString(), aWD.mcn_lead_page, cKx.getTid());
            } else {
                this.mTitleView.setText(this.kEv);
            }
            this.mTitleView.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
            this.kEx = new i(this.kEv);
            this.mTitleView.setOnTouchListener(this.kEx);
            this.kEo.setOnClickListener(this.mOnClickListener);
            this.kEn.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), as.numberUniformFormatExtra(aWD.play_count.intValue())));
            if (fVar.cLa() && fVar.cKX()) {
                if (TextUtils.isEmpty(str)) {
                    str = cKx.aWp();
                }
                if (TextUtils.isEmpty(str) && (brVar = (br) x.getItem(fVar.cKU(), 0)) != null) {
                    str = brVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.kEq.setVisibility(0);
                    this.kEp.setVisibility(0);
                    this.kEp.setOnClickListener(this.mOnClickListener);
                    this.kEp.setText(ay.KN(str));
                    this.kEp.setTag(str);
                } else {
                    this.kEp.setVisibility(8);
                    this.kEq.setVisibility(8);
                }
                this.kEm.setVisibility(8);
                this.kEr.setData(fVar, cKx.aYc());
            } else {
                this.kEq.setVisibility(8);
                this.kEp.setVisibility(8);
                this.kEm.setVisibility(0);
                this.kEm.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), as.numberUniformFormatExtra(cKx.aWc())));
                this.kEr.setVisibility(8);
            }
            bgV();
        }
    }

    public void bgV() {
        ao.setViewTextColor(this.kEo, R.color.cp_link_tip_c, 1);
        ao.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        ao.setViewTextColor(this.kEm, R.color.cp_cont_j, 1);
        ao.setViewTextColor(this.kEn, R.color.cp_cont_j, 1);
        ao.setViewTextColor(this.kEp, R.color.cp_cont_j, 1);
        ao.setImageResource(this.kEq, R.drawable.icon_common_arrow20_right_n);
        if (this.kEr != null) {
            this.kEr.bgV();
        }
    }
}
