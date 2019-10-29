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
    private boolean hyA;
    public TextView idA;
    public TextView idB;
    private boolean idC;
    private boolean idD;
    private SpannableStringBuilder idE;
    private SpannableStringBuilder idF;
    private View.OnTouchListener idG;
    private View.OnTouchListener idH;
    public TextView idz;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(R.id.view_video_title);
            this.mTitleView.setTextSize(0, TbConfig.getContentSize());
            this.mTitleView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.mTitleView.getPaint().setFakeBoldText(true);
            this.idz = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.idA = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.idB = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.idE != null && !d.this.idD && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.hyA) {
                            if (!d.this.idC) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.idB.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.idB.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.idB.setLayoutParams(layoutParams);
                                d.this.idC = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.idF == null) {
                                String charSequence = d.this.mTitleView.getText().toString();
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(charSequence, aq.getChineseAndEnglishLength(charSequence.substring(0, charSequence.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.idF = new SpannableStringBuilder();
                                d.this.idF.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.idE.getSpans(length, charSequence.length(), Object.class)) {
                                    int spanStart = d.this.idE.getSpanStart(obj);
                                    int spanEnd = d.this.idE.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.idF.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...详情");
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tieba.pb.video.d.1.1
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view2) {
                                        d.this.hyA = true;
                                        d.this.mTitleView.setMaxLines(10);
                                        d.this.mTitleView.setOnTouchListener(new k(d.this.idE));
                                        d.this.mTitleView.setText(d.this.idE);
                                        d.this.idB.setVisibility(0);
                                    }
                                }, 0, spannableString.length(), 17);
                                d.this.idF.insert(length, (CharSequence) spannableString);
                                d.this.idH = new k(d.this.idF);
                            }
                            d.this.idB.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.idH);
                            d.this.mTitleView.setText(d.this.idF);
                        }
                    }
                }
            });
        }
    }

    public void aw(bh bhVar) {
        if (bhVar != null && bhVar.aiX() != null) {
            bhVar.ajx();
            this.idE = new SpannableStringBuilder(bhVar.ajm());
            if (bhVar.ajt() && !StringUtils.isNull(bhVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.alR().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bhVar.getTid();
                this.idE.append((CharSequence) bhVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.2
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
            this.idG = new k(this.idE);
            this.mTitleView.setOnTouchListener(this.idG);
            VideoInfo aiX = bhVar.aiX();
            if (!StringUtils.isNull(aiX.mcn_lead_page) && !bhVar.ajt()) {
                this.idD = true;
            } else {
                this.idD = false;
            }
            if (this.idD) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, bhVar.ajm().toString(), aiX.mcn_lead_page, bhVar.getTid());
            } else {
                this.mTitleView.setText(this.idE);
            }
            this.mTitleView.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            this.idB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.hyA = false;
                    d.this.mTitleView.setOnTouchListener(d.this.idH);
                    d.this.mTitleView.setText(d.this.idF);
                    d.this.idB.setVisibility(8);
                }
            });
            this.idz.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), aq.numberUniformFormatExtra(bhVar.aix())));
            this.idA.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), aq.numberUniformFormatExtra(aiX.play_count.intValue())));
            asm();
        }
    }

    public void asm() {
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.idB, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.idz, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.idA, R.color.cp_cont_d, 1);
    }
}
