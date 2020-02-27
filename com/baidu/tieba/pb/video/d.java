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
    public TextView iWO;
    public TextView iWP;
    public TextView iWQ;
    private TextView iWR;
    private TbImageView iWS;
    private ThreadAgreeAndShareLayout iWT;
    private boolean iWU;
    private boolean iWV;
    private com.baidu.tbadk.core.view.a.a iWW;
    private SpannableStringBuilder iWX;
    private SpannableStringBuilder iWY;
    private View.OnTouchListener iWZ;
    private View.OnTouchListener iXa;
    private boolean iri;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f iXb = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.iri = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new com.baidu.tieba.view.h(d.this.iWX));
            d.this.mTitleView.setText(d.this.iWX);
            d.this.iWQ.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.iWR) {
                Object tag = d.this.iWR.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.iWQ) {
                d.this.iri = false;
                d.this.mTitleView.setOnTouchListener(d.this.iXa);
                d.this.mTitleView.setText(d.this.iWY);
                d.this.iWQ.setVisibility(8);
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
            this.iWO = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.iWP = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.iWQ = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.iWR = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.iWT = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.iWS = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.iWX != null && !d.this.iWV && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.iri) {
                            if (!d.this.iWU) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.iWQ.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.iWQ.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.iWQ.setLayoutParams(layoutParams);
                                d.this.iWU = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.iWY == null) {
                                String spannableStringBuilder = d.this.iWX.toString();
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder, aq.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.iWY = new SpannableStringBuilder();
                                d.this.iWY.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.iWX.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.iWX.getSpanStart(obj);
                                    int spanEnd = d.this.iWX.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.iWY.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.iXb, 0, spannableString.length(), 17);
                                d.this.iWY.insert(length, (CharSequence) spannableString);
                                d.this.iXa = new com.baidu.tieba.view.h(d.this.iWY);
                            }
                            d.this.iWQ.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.iXa);
                            d.this.mTitleView.setText(d.this.iWY);
                        }
                    }
                }
            });
        }
    }

    private boolean aJ(bj bjVar) {
        if (bjVar == null || this.iWX == null || !bjVar.aCZ() || StringUtils.isNull(bjVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.aFB().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bjVar.getTid();
        this.iWX.append((CharSequence) bjVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new an("c12841").cy("obj_source", "3"));
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
        bj cks;
        bf bfVar;
        Layout c;
        SpannableString aH;
        if (eVar != null && (cks = eVar.cks()) != null && cks.aCD() != null) {
            cks.aDi();
            this.iWX = new SpannableStringBuilder(cks.aCT());
            boolean aJ = aJ(cks);
            VideoInfo aCD = cks.aCD();
            if (!StringUtils.isNull(aCD.mcn_lead_page) && !aJ) {
                this.iWV = true;
            } else {
                this.iWV = false;
            }
            if (this.iWX != null && !this.iWV && !aJ && (aH = am.aH(cks)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aH.getSpans(0, aH.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.iWW = aVarArr[0];
                }
                this.iWX.append((CharSequence) aH);
            }
            if (this.iWW != null && this.iWX != null && (c = am.c(this.iWX)) != null && c.getLineCount() > 10) {
                int spanStart = this.iWX.getSpanStart(this.iWW);
                int spanEnd = this.iWX.getSpanEnd(this.iWW);
                if (spanStart > 0) {
                    this.iWX.delete(spanStart, spanEnd);
                }
            }
            if (this.iWV) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, cks.aCT().toString(), aCD.mcn_lead_page, cks.getTid());
            } else {
                this.mTitleView.setText(this.iWX);
            }
            this.mTitleView.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.iWZ = new com.baidu.tieba.view.h(this.iWX);
            this.mTitleView.setOnTouchListener(this.iWZ);
            this.iWQ.setOnClickListener(this.mOnClickListener);
            this.iWP.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), aq.numberUniformFormatExtra(aCD.play_count.intValue())));
            if (eVar.ckQ() && eVar.aHI()) {
                if (TextUtils.isEmpty(str)) {
                    str = cks.aCr();
                }
                if (TextUtils.isEmpty(str) && (bfVar = (bf) v.getItem(eVar.ckL(), 0)) != null) {
                    str = bfVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.iWS.setVisibility(0);
                    this.iWR.setVisibility(0);
                    this.iWR.setOnClickListener(this.mOnClickListener);
                    this.iWR.setText(am.Gb(str));
                    this.iWR.setTag(str);
                } else {
                    this.iWR.setVisibility(8);
                    this.iWS.setVisibility(8);
                }
                this.iWO.setVisibility(8);
                this.iWT.setData(eVar, cks.aDY());
            } else {
                this.iWS.setVisibility(8);
                this.iWR.setVisibility(8);
                this.iWO.setVisibility(0);
                this.iWO.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), aq.numberUniformFormatExtra(cks.aCd())));
                this.iWT.setVisibility(8);
            }
            aMz();
        }
    }

    public void aMz() {
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iWQ, R.color.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iWO, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iWP, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iWR, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setImageResource(this.iWS, R.drawable.icon_common_arrow20_right_n);
        if (this.iWT != null) {
            this.iWT.aMz();
        }
    }
}
