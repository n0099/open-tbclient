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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
    private boolean hxQ;
    public TextView icP;
    public TextView icQ;
    public TextView icR;
    private boolean icS;
    private boolean icT;
    private SpannableStringBuilder icU;
    private SpannableStringBuilder icV;
    private View.OnTouchListener icW;
    private View.OnTouchListener icX;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(R.id.view_video_title);
            this.mTitleView.setTextSize(0, TbConfig.getContentSize());
            this.mTitleView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.mTitleView.getPaint().setFakeBoldText(true);
            this.icP = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.icQ = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.icR = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.icU != null && !d.this.icT && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.hxQ) {
                            if (!d.this.icS) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.icR.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.icR.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.icR.setLayoutParams(layoutParams);
                                d.this.icS = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.icV == null) {
                                String charSequence = d.this.mTitleView.getText().toString();
                                String j = aq.j(charSequence, aq.ob(charSequence.substring(0, charSequence.length() - ellipsisCount)) - 6, "");
                                int length = j.length();
                                d.this.icV = new SpannableStringBuilder();
                                d.this.icV.append((CharSequence) j);
                                for (Object obj : d.this.icU.getSpans(length, charSequence.length(), Object.class)) {
                                    int spanStart = d.this.icU.getSpanStart(obj);
                                    int spanEnd = d.this.icU.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.icV.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...详情");
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tieba.pb.video.d.1.1
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view2) {
                                        d.this.hxQ = true;
                                        d.this.mTitleView.setMaxLines(10);
                                        d.this.mTitleView.setOnTouchListener(new k(d.this.icU));
                                        d.this.mTitleView.setText(d.this.icU);
                                        d.this.icR.setVisibility(0);
                                    }
                                }, 0, spannableString.length(), 17);
                                d.this.icV.insert(length, (CharSequence) spannableString);
                                d.this.icX = new k(d.this.icV);
                            }
                            d.this.icR.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.icX);
                            d.this.mTitleView.setText(d.this.icV);
                        }
                    }
                }
            });
        }
    }

    public void ax(bh bhVar) {
        if (bhVar != null && bhVar.aeP() != null) {
            bhVar.afp();
            this.icU = new SpannableStringBuilder(bhVar.afe());
            if (bhVar.afl() && !StringUtils.isNull(bhVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bhVar.getTid();
                this.icU.append((CharSequence) bhVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.2
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                        TiebaStatic.log(new an("c12841").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3"));
                    }

                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                        textPaint.setUnderlineText(false);
                    }
                }));
            }
            this.icW = new k(this.icU);
            this.mTitleView.setOnTouchListener(this.icW);
            VideoInfo aeP = bhVar.aeP();
            if (!StringUtils.isNull(aeP.mcn_lead_page) && !bhVar.afl()) {
                this.icT = true;
            } else {
                this.icT = false;
            }
            if (this.icT) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, bhVar.afe().toString(), aeP.mcn_lead_page, bhVar.getTid());
            } else {
                this.mTitleView.setText(this.icU);
            }
            this.mTitleView.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            this.icR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.hxQ = false;
                    d.this.mTitleView.setOnTouchListener(d.this.icX);
                    d.this.mTitleView.setText(d.this.icV);
                    d.this.icR.setVisibility(8);
                }
            });
            this.icP.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), aq.aJ(bhVar.aep())));
            this.icQ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), aq.aJ(aeP.play_count.intValue())));
            aqg();
        }
    }

    public void aqg() {
        am.f(this.mTitleView, R.color.cp_cont_b, 1);
        am.f(this.icR, R.color.cp_link_tip_c, 1);
        am.f(this.icP, R.color.cp_cont_d, 1);
        am.f(this.icQ, R.color.cp_cont_d, 1);
    }
}
