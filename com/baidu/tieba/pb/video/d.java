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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.am;
import com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class d {
    public TextView iYD;
    public TextView iYE;
    public TextView iYF;
    private TextView iYG;
    private TbImageView iYH;
    private ThreadAgreeAndShareLayout iYI;
    private boolean iYJ;
    private boolean iYK;
    private com.baidu.tbadk.core.view.a.a iYL;
    private SpannableStringBuilder iYM;
    private SpannableStringBuilder iYN;
    private View.OnTouchListener iYO;
    private View.OnTouchListener iYP;
    private boolean isW;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f iYQ = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.isW = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new com.baidu.tieba.view.h(d.this.iYM));
            d.this.mTitleView.setText(d.this.iYM);
            d.this.iYF.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.iYG) {
                Object tag = d.this.iYG.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.iYF) {
                d.this.isW = false;
                d.this.mTitleView.setOnTouchListener(d.this.iYP);
                d.this.mTitleView.setText(d.this.iYN);
                d.this.iYF.setVisibility(8);
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
            this.iYD = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.iYE = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.iYF = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.iYG = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.iYI = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.iYH = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.iYM != null && !d.this.iYK && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.isW) {
                            if (!d.this.iYJ) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.iYF.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.iYF.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.iYF.setLayoutParams(layoutParams);
                                d.this.iYJ = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.iYN == null) {
                                String spannableStringBuilder = d.this.iYM.toString();
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder, aq.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.iYN = new SpannableStringBuilder();
                                d.this.iYN.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.iYM.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.iYM.getSpanStart(obj);
                                    int spanEnd = d.this.iYM.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.iYN.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.iYQ, 0, spannableString.length(), 17);
                                d.this.iYN.insert(length, (CharSequence) spannableString);
                                d.this.iYP = new com.baidu.tieba.view.h(d.this.iYN);
                            }
                            d.this.iYF.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.iYP);
                            d.this.mTitleView.setText(d.this.iYN);
                        }
                    }
                }
            });
        }
    }

    private boolean aK(bj bjVar) {
        if (bjVar == null || this.iYM == null || !bjVar.aDe() || StringUtils.isNull(bjVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.aFH().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bjVar.getTid();
        this.iYM.append((CharSequence) bjVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new an("c12841").cx("obj_source", "3"));
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
        bj ckP;
        bf bfVar;
        Layout c;
        SpannableString aI;
        if (eVar != null && (ckP = eVar.ckP()) != null && ckP.aCI() != null) {
            ckP.aDn();
            this.iYM = new SpannableStringBuilder(ckP.aCY());
            boolean aK = aK(ckP);
            VideoInfo aCI = ckP.aCI();
            if (!StringUtils.isNull(aCI.mcn_lead_page) && !aK) {
                this.iYK = true;
            } else {
                this.iYK = false;
            }
            if (this.iYM != null && !this.iYK && !aK && (aI = am.aI(ckP)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aI.getSpans(0, aI.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.iYL = aVarArr[0];
                }
                this.iYM.append((CharSequence) aI);
            }
            if (this.iYL != null && this.iYM != null && (c = am.c(this.iYM)) != null && c.getLineCount() > 10) {
                int spanStart = this.iYM.getSpanStart(this.iYL);
                int spanEnd = this.iYM.getSpanEnd(this.iYL);
                if (spanStart > 0) {
                    this.iYM.delete(spanStart, spanEnd);
                }
            }
            if (this.iYK) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, ckP.aCY().toString(), aCI.mcn_lead_page, ckP.getTid());
            } else {
                this.mTitleView.setText(this.iYM);
            }
            this.mTitleView.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.iYO = new com.baidu.tieba.view.h(this.iYM);
            this.mTitleView.setOnTouchListener(this.iYO);
            this.iYF.setOnClickListener(this.mOnClickListener);
            this.iYE.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), aq.numberUniformFormatExtra(aCI.play_count.intValue())));
            if (eVar.cln() && eVar.aHP()) {
                if (TextUtils.isEmpty(str)) {
                    str = ckP.aCw();
                }
                if (TextUtils.isEmpty(str) && (bfVar = (bf) v.getItem(eVar.cli(), 0)) != null) {
                    str = bfVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.iYH.setVisibility(0);
                    this.iYG.setVisibility(0);
                    this.iYG.setOnClickListener(this.mOnClickListener);
                    this.iYG.setText(am.Gc(str));
                    this.iYG.setTag(str);
                } else {
                    this.iYG.setVisibility(8);
                    this.iYH.setVisibility(8);
                }
                this.iYD.setVisibility(8);
                this.iYI.setData(eVar, ckP.aEe());
            } else {
                this.iYH.setVisibility(8);
                this.iYG.setVisibility(8);
                this.iYD.setVisibility(0);
                this.iYD.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), aq.numberUniformFormatExtra(ckP.aCi())));
                this.iYI.setVisibility(8);
            }
            aMG();
        }
    }

    public void aMG() {
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iYF, R.color.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iYD, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iYE, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iYG, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setImageResource(this.iYH, R.drawable.icon_common_arrow20_right_n);
        if (this.iYI != null) {
            this.iYI.aMG();
        }
    }
}
