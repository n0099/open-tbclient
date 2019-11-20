package com.baidu.tieba.pb.video;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.view.k;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class d {
    private boolean hxJ;
    public TextView icF;
    public TextView icG;
    public TextView icH;
    private boolean icI;
    private boolean icJ;
    private SpannableStringBuilder icK;
    private SpannableStringBuilder icL;
    private View.OnTouchListener icM;
    private View.OnTouchListener icN;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(R.id.view_video_title);
            this.mTitleView.setTextSize(0, TbConfig.getContentSize());
            this.mTitleView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.mTitleView.getPaint().setFakeBoldText(true);
            this.icF = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.icG = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.icH = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.icK != null && !d.this.icJ && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.hxJ) {
                            if (!d.this.icI) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.icH.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.icH.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.icH.setLayoutParams(layoutParams);
                                d.this.icI = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.icL == null) {
                                String charSequence = d.this.mTitleView.getText().toString();
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(charSequence, aq.getChineseAndEnglishLength(charSequence.substring(0, charSequence.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.icL = new SpannableStringBuilder();
                                d.this.icL.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.icK.getSpans(length, charSequence.length(), Object.class)) {
                                    int spanStart = d.this.icK.getSpanStart(obj);
                                    int spanEnd = d.this.icK.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.icL.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...详情");
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tieba.pb.video.d.1.1
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view2) {
                                        d.this.hxJ = true;
                                        d.this.mTitleView.setMaxLines(10);
                                        d.this.mTitleView.setOnTouchListener(new k(d.this.icK));
                                        d.this.mTitleView.setText(d.this.icK);
                                        d.this.icH.setVisibility(0);
                                    }
                                }, 0, spannableString.length(), 17);
                                d.this.icL.insert(length, (CharSequence) spannableString);
                                d.this.icN = new k(d.this.icL);
                            }
                            d.this.icH.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.icN);
                            d.this.mTitleView.setText(d.this.icL);
                        }
                    }
                }
            });
        }
    }

    public void aw(bh bhVar) {
        if (bhVar != null && bhVar.aiV() != null) {
            bhVar.ajv();
            this.icK = new SpannableStringBuilder(bhVar.ajk());
            if (bhVar.ajr() && !StringUtils.isNull(bhVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.alP().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bhVar.getTid();
                this.icK.append((CharSequence) bhVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.2
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                        TiebaStatic.log(new an("c12841").bS("obj_source", "3"));
                    }

                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                        textPaint.setUnderlineText(false);
                    }
                }));
            }
            this.icM = new k(this.icK);
            this.mTitleView.setOnTouchListener(this.icM);
            VideoInfo aiV = bhVar.aiV();
            if (!StringUtils.isNull(aiV.mcn_lead_page) && !bhVar.ajr()) {
                this.icJ = true;
            } else {
                this.icJ = false;
            }
            if (this.icJ) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, bhVar.ajk().toString(), aiV.mcn_lead_page, bhVar.getTid());
            } else {
                this.mTitleView.setText(this.icK);
            }
            this.mTitleView.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            this.icH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.hxJ = false;
                    d.this.mTitleView.setOnTouchListener(d.this.icN);
                    d.this.mTitleView.setText(d.this.icL);
                    d.this.icH.setVisibility(8);
                }
            });
            this.icF.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), aq.numberUniformFormatExtra(bhVar.aiv())));
            this.icG.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), aq.numberUniformFormatExtra(aiV.play_count.intValue())));
            ask();
        }
    }

    public void ask() {
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.icH, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.icF, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.icG, R.color.cp_cont_d, 1);
    }
}
