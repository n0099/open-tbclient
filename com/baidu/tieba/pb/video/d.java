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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout;
import com.baidu.tieba.view.i;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class d {
    private boolean jsi;
    public TextView kaA;
    public TextView kaB;
    public TextView kaC;
    private TextView kaD;
    private TbImageView kaE;
    private ThreadAgreeAndShareLayout kaF;
    private boolean kaG;
    private boolean kaH;
    private com.baidu.tbadk.core.view.a.a kaI;
    private SpannableStringBuilder kaJ;
    private SpannableStringBuilder kaK;
    private View.OnTouchListener kaL;
    private View.OnTouchListener kaM;
    private com.baidu.tbadk.widget.richText.f kaN = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.jsi = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new i(d.this.kaJ));
            d.this.mTitleView.setText(d.this.kaJ);
            d.this.kaC.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.kaD) {
                Object tag = d.this.kaD.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.kaC) {
                d.this.jsi = false;
                d.this.mTitleView.setOnTouchListener(d.this.kaM);
                d.this.mTitleView.setText(d.this.kaK);
                d.this.kaC.setVisibility(8);
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
            this.kaA = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.kaB = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.kaC = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.kaD = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.kaF = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.kaE = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.kaJ != null && !d.this.kaH && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.jsi) {
                            if (!d.this.kaG) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.kaC.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.kaC.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.kaC.setLayoutParams(layoutParams);
                                d.this.kaG = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.kaK == null) {
                                String spannableStringBuilder = d.this.kaJ.toString();
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder, aq.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.kaK = new SpannableStringBuilder();
                                d.this.kaK.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.kaJ.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.kaJ.getSpanStart(obj);
                                    int spanEnd = d.this.kaJ.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.kaK.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.kaN, 0, spannableString.length(), 17);
                                d.this.kaK.insert(length, (CharSequence) spannableString);
                                d.this.kaM = new i(d.this.kaK);
                            }
                            d.this.kaC.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.kaM);
                            d.this.mTitleView.setText(d.this.kaK);
                        }
                    }
                }
            });
        }
    }

    private boolean aL(bk bkVar) {
        if (bkVar == null || this.kaJ == null || !bkVar.aRo() || StringUtils.isNull(bkVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.aTX().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bkVar.getTid();
        this.kaJ.append((CharSequence) bkVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new an("c12841").dh("obj_source", "3"));
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

    public void a(com.baidu.tieba.pb.data.e eVar, String str) {
        bk cCi;
        bg bgVar;
        Layout c;
        SpannableString aJ;
        if (eVar != null && (cCi = eVar.cCi()) != null && cCi.aQQ() != null) {
            cCi.aRx();
            this.kaJ = new SpannableStringBuilder(cCi.aRi());
            boolean aL = aL(cCi);
            VideoInfo aQQ = cCi.aQQ();
            if (!StringUtils.isNull(aQQ.mcn_lead_page) && !aL) {
                this.kaH = true;
            } else {
                this.kaH = false;
            }
            if (this.kaJ != null && !this.kaH && !aL && (aJ = au.aJ(cCi)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aJ.getSpans(0, aJ.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.kaI = aVarArr[0];
                }
                this.kaJ.append((CharSequence) aJ);
            }
            if (this.kaI != null && this.kaJ != null && (c = au.c(this.kaJ)) != null && c.getLineCount() > 10) {
                int spanStart = this.kaJ.getSpanStart(this.kaI);
                int spanEnd = this.kaJ.getSpanEnd(this.kaI);
                if (spanStart > 0) {
                    this.kaJ.delete(spanStart, spanEnd);
                }
            }
            if (this.kaH) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, cCi.aRi().toString(), aQQ.mcn_lead_page, cCi.getTid());
            } else {
                this.mTitleView.setText(this.kaJ);
            }
            this.mTitleView.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            this.kaL = new i(this.kaJ);
            this.mTitleView.setOnTouchListener(this.kaL);
            this.kaC.setOnClickListener(this.mOnClickListener);
            this.kaB.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), aq.numberUniformFormatExtra(aQQ.play_count.intValue())));
            if (eVar.cCJ() && eVar.aWi()) {
                if (TextUtils.isEmpty(str)) {
                    str = cCi.aQC();
                }
                if (TextUtils.isEmpty(str) && (bgVar = (bg) v.getItem(eVar.cCE(), 0)) != null) {
                    str = bgVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.kaE.setVisibility(0);
                    this.kaD.setVisibility(0);
                    this.kaD.setOnClickListener(this.mOnClickListener);
                    this.kaD.setText(au.Jx(str));
                    this.kaD.setTag(str);
                } else {
                    this.kaD.setVisibility(8);
                    this.kaE.setVisibility(8);
                }
                this.kaA.setVisibility(8);
                this.kaF.setData(eVar, cCi.aSp());
            } else {
                this.kaE.setVisibility(8);
                this.kaD.setVisibility(8);
                this.kaA.setVisibility(0);
                this.kaA.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), aq.numberUniformFormatExtra(cCi.aQo())));
                this.kaF.setVisibility(8);
            }
            bbl();
        }
    }

    public void bbl() {
        am.setViewTextColor(this.kaC, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.kaA, R.color.cp_cont_j, 1);
        am.setViewTextColor(this.kaB, R.color.cp_cont_j, 1);
        am.setViewTextColor(this.kaD, R.color.cp_cont_j, 1);
        am.setImageResource(this.kaE, R.drawable.icon_common_arrow20_right_n);
        if (this.kaF != null) {
            this.kaF.bbl();
        }
    }
}
