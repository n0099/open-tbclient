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
    public TextView iWQ;
    public TextView iWR;
    public TextView iWS;
    private TextView iWT;
    private TbImageView iWU;
    private ThreadAgreeAndShareLayout iWV;
    private boolean iWW;
    private boolean iWX;
    private com.baidu.tbadk.core.view.a.a iWY;
    private SpannableStringBuilder iWZ;
    private SpannableStringBuilder iXa;
    private View.OnTouchListener iXb;
    private View.OnTouchListener iXc;
    private boolean irk;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f iXd = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.irk = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new com.baidu.tieba.view.h(d.this.iWZ));
            d.this.mTitleView.setText(d.this.iWZ);
            d.this.iWS.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.iWT) {
                Object tag = d.this.iWT.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.iWS) {
                d.this.irk = false;
                d.this.mTitleView.setOnTouchListener(d.this.iXc);
                d.this.mTitleView.setText(d.this.iXa);
                d.this.iWS.setVisibility(8);
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
            this.iWQ = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.iWR = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.iWS = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.iWT = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.iWV = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.iWU = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.iWZ != null && !d.this.iWX && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.irk) {
                            if (!d.this.iWW) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.iWS.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.iWS.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.iWS.setLayoutParams(layoutParams);
                                d.this.iWW = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.iXa == null) {
                                String spannableStringBuilder = d.this.iWZ.toString();
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder, aq.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.iXa = new SpannableStringBuilder();
                                d.this.iXa.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.iWZ.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.iWZ.getSpanStart(obj);
                                    int spanEnd = d.this.iWZ.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.iXa.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.iXd, 0, spannableString.length(), 17);
                                d.this.iXa.insert(length, (CharSequence) spannableString);
                                d.this.iXc = new com.baidu.tieba.view.h(d.this.iXa);
                            }
                            d.this.iWS.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.iXc);
                            d.this.mTitleView.setText(d.this.iXa);
                        }
                    }
                }
            });
        }
    }

    private boolean aJ(bj bjVar) {
        if (bjVar == null || this.iWZ == null || !bjVar.aDb() || StringUtils.isNull(bjVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bjVar.getTid();
        this.iWZ.append((CharSequence) bjVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
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
        bj cku;
        bf bfVar;
        Layout c;
        SpannableString aH;
        if (eVar != null && (cku = eVar.cku()) != null && cku.aCF() != null) {
            cku.aDk();
            this.iWZ = new SpannableStringBuilder(cku.aCV());
            boolean aJ = aJ(cku);
            VideoInfo aCF = cku.aCF();
            if (!StringUtils.isNull(aCF.mcn_lead_page) && !aJ) {
                this.iWX = true;
            } else {
                this.iWX = false;
            }
            if (this.iWZ != null && !this.iWX && !aJ && (aH = am.aH(cku)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aH.getSpans(0, aH.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.iWY = aVarArr[0];
                }
                this.iWZ.append((CharSequence) aH);
            }
            if (this.iWY != null && this.iWZ != null && (c = am.c(this.iWZ)) != null && c.getLineCount() > 10) {
                int spanStart = this.iWZ.getSpanStart(this.iWY);
                int spanEnd = this.iWZ.getSpanEnd(this.iWY);
                if (spanStart > 0) {
                    this.iWZ.delete(spanStart, spanEnd);
                }
            }
            if (this.iWX) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, cku.aCV().toString(), aCF.mcn_lead_page, cku.getTid());
            } else {
                this.mTitleView.setText(this.iWZ);
            }
            this.mTitleView.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.iXb = new com.baidu.tieba.view.h(this.iWZ);
            this.mTitleView.setOnTouchListener(this.iXb);
            this.iWS.setOnClickListener(this.mOnClickListener);
            this.iWR.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), aq.numberUniformFormatExtra(aCF.play_count.intValue())));
            if (eVar.ckS() && eVar.aHK()) {
                if (TextUtils.isEmpty(str)) {
                    str = cku.aCt();
                }
                if (TextUtils.isEmpty(str) && (bfVar = (bf) v.getItem(eVar.ckN(), 0)) != null) {
                    str = bfVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.iWU.setVisibility(0);
                    this.iWT.setVisibility(0);
                    this.iWT.setOnClickListener(this.mOnClickListener);
                    this.iWT.setText(am.Gb(str));
                    this.iWT.setTag(str);
                } else {
                    this.iWT.setVisibility(8);
                    this.iWU.setVisibility(8);
                }
                this.iWQ.setVisibility(8);
                this.iWV.setData(eVar, cku.aEa());
            } else {
                this.iWU.setVisibility(8);
                this.iWT.setVisibility(8);
                this.iWQ.setVisibility(0);
                this.iWQ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), aq.numberUniformFormatExtra(cku.aCf())));
                this.iWV.setVisibility(8);
            }
            aMB();
        }
    }

    public void aMB() {
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iWS, R.color.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iWQ, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iWR, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iWT, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setImageResource(this.iWU, R.drawable.icon_common_arrow20_right_n);
        if (this.iWV != null) {
            this.iWV.aMB();
        }
    }
}
