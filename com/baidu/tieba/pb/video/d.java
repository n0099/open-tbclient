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
    private boolean jto;
    public TextView kbG;
    public TextView kbH;
    public TextView kbI;
    private TextView kbJ;
    private TbImageView kbK;
    private ThreadAgreeAndShareLayout kbL;
    private boolean kbM;
    private boolean kbN;
    private com.baidu.tbadk.core.view.a.a kbO;
    private SpannableStringBuilder kbP;
    private SpannableStringBuilder kbQ;
    private View.OnTouchListener kbR;
    private View.OnTouchListener kbS;
    private com.baidu.tbadk.widget.richText.f kbT = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.jto = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new i(d.this.kbP));
            d.this.mTitleView.setText(d.this.kbP);
            d.this.kbI.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.kbJ) {
                Object tag = d.this.kbJ.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.kbI) {
                d.this.jto = false;
                d.this.mTitleView.setOnTouchListener(d.this.kbS);
                d.this.mTitleView.setText(d.this.kbQ);
                d.this.kbI.setVisibility(8);
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
            this.kbG = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.kbH = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.kbI = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.kbJ = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.kbL = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.kbK = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.kbP != null && !d.this.kbN && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.jto) {
                            if (!d.this.kbM) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.kbI.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.kbI.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.kbI.setLayoutParams(layoutParams);
                                d.this.kbM = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.kbQ == null) {
                                String spannableStringBuilder = d.this.kbP.toString();
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder, aq.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.kbQ = new SpannableStringBuilder();
                                d.this.kbQ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.kbP.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.kbP.getSpanStart(obj);
                                    int spanEnd = d.this.kbP.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.kbQ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.kbT, 0, spannableString.length(), 17);
                                d.this.kbQ.insert(length, (CharSequence) spannableString);
                                d.this.kbS = new i(d.this.kbQ);
                            }
                            d.this.kbI.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.kbS);
                            d.this.mTitleView.setText(d.this.kbQ);
                        }
                    }
                }
            });
        }
    }

    private boolean aL(bk bkVar) {
        if (bkVar == null || this.kbP == null || !bkVar.aRo() || StringUtils.isNull(bkVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.aTX().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bkVar.getTid();
        this.kbP.append((CharSequence) bkVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
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
        bk cCy;
        bg bgVar;
        Layout c;
        SpannableString aJ;
        if (eVar != null && (cCy = eVar.cCy()) != null && cCy.aQQ() != null) {
            cCy.aRx();
            this.kbP = new SpannableStringBuilder(cCy.aRi());
            boolean aL = aL(cCy);
            VideoInfo aQQ = cCy.aQQ();
            if (!StringUtils.isNull(aQQ.mcn_lead_page) && !aL) {
                this.kbN = true;
            } else {
                this.kbN = false;
            }
            if (this.kbP != null && !this.kbN && !aL && (aJ = au.aJ(cCy)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aJ.getSpans(0, aJ.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.kbO = aVarArr[0];
                }
                this.kbP.append((CharSequence) aJ);
            }
            if (this.kbO != null && this.kbP != null && (c = au.c(this.kbP)) != null && c.getLineCount() > 10) {
                int spanStart = this.kbP.getSpanStart(this.kbO);
                int spanEnd = this.kbP.getSpanEnd(this.kbO);
                if (spanStart > 0) {
                    this.kbP.delete(spanStart, spanEnd);
                }
            }
            if (this.kbN) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, cCy.aRi().toString(), aQQ.mcn_lead_page, cCy.getTid());
            } else {
                this.mTitleView.setText(this.kbP);
            }
            this.mTitleView.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            this.kbR = new i(this.kbP);
            this.mTitleView.setOnTouchListener(this.kbR);
            this.kbI.setOnClickListener(this.mOnClickListener);
            this.kbH.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), aq.numberUniformFormatExtra(aQQ.play_count.intValue())));
            if (eVar.cCZ() && eVar.aWj()) {
                if (TextUtils.isEmpty(str)) {
                    str = cCy.aQC();
                }
                if (TextUtils.isEmpty(str) && (bgVar = (bg) v.getItem(eVar.cCU(), 0)) != null) {
                    str = bgVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.kbK.setVisibility(0);
                    this.kbJ.setVisibility(0);
                    this.kbJ.setOnClickListener(this.mOnClickListener);
                    this.kbJ.setText(au.Jy(str));
                    this.kbJ.setTag(str);
                } else {
                    this.kbJ.setVisibility(8);
                    this.kbK.setVisibility(8);
                }
                this.kbG.setVisibility(8);
                this.kbL.setData(eVar, cCy.aSp());
            } else {
                this.kbK.setVisibility(8);
                this.kbJ.setVisibility(8);
                this.kbG.setVisibility(0);
                this.kbG.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), aq.numberUniformFormatExtra(cCy.aQo())));
                this.kbL.setVisibility(8);
            }
            bbm();
        }
    }

    public void bbm() {
        am.setViewTextColor(this.kbI, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.kbG, R.color.cp_cont_j, 1);
        am.setViewTextColor(this.kbH, R.color.cp_cont_j, 1);
        am.setViewTextColor(this.kbJ, R.color.cp_cont_j, 1);
        am.setImageResource(this.kbK, R.drawable.icon_common_arrow20_right_n);
        if (this.kbL != null) {
            this.kbL.bbm();
        }
    }
}
