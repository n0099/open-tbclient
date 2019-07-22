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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.view.k;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class d {
    private boolean hwY;
    public TextView ibS;
    public TextView ibT;
    public TextView ibU;
    private boolean ibV;
    private boolean ibW;
    private SpannableStringBuilder ibX;
    private SpannableStringBuilder ibY;
    private View.OnTouchListener ibZ;
    private View.OnTouchListener ica;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(R.id.view_video_title);
            this.mTitleView.setTextSize(0, TbConfig.getContentSize());
            this.mTitleView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.mTitleView.getPaint().setFakeBoldText(true);
            this.ibS = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.ibT = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.ibU = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.ibX != null && !d.this.ibW && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.hwY) {
                            if (!d.this.ibV) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.ibU.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.ibU.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.ibU.setLayoutParams(layoutParams);
                                d.this.ibV = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.ibY == null) {
                                String charSequence = d.this.mTitleView.getText().toString();
                                String j = aq.j(charSequence, aq.ob(charSequence.substring(0, charSequence.length() - ellipsisCount)) - 6, "");
                                int length = j.length();
                                d.this.ibY = new SpannableStringBuilder();
                                d.this.ibY.append((CharSequence) j);
                                for (Object obj : d.this.ibX.getSpans(length, charSequence.length(), Object.class)) {
                                    int spanStart = d.this.ibX.getSpanStart(obj);
                                    int spanEnd = d.this.ibX.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.ibY.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...详情");
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tieba.pb.video.d.1.1
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view2) {
                                        d.this.hwY = true;
                                        d.this.mTitleView.setMaxLines(10);
                                        d.this.mTitleView.setOnTouchListener(new k(d.this.ibX));
                                        d.this.mTitleView.setText(d.this.ibX);
                                        d.this.ibU.setVisibility(0);
                                    }
                                }, 0, spannableString.length(), 17);
                                d.this.ibY.insert(length, (CharSequence) spannableString);
                                d.this.ica = new k(d.this.ibY);
                            }
                            d.this.ibU.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.ica);
                            d.this.mTitleView.setText(d.this.ibY);
                        }
                    }
                }
            });
        }
    }

    public void aw(bg bgVar) {
        if (bgVar != null && bgVar.aeO() != null) {
            bgVar.afo();
            this.ibX = new SpannableStringBuilder(bgVar.afd());
            if (bgVar.afk() && !StringUtils.isNull(bgVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.ahO().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bgVar.getTid();
                this.ibX.append((CharSequence) bgVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.2
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
            this.ibZ = new k(this.ibX);
            this.mTitleView.setOnTouchListener(this.ibZ);
            VideoInfo aeO = bgVar.aeO();
            if (!StringUtils.isNull(aeO.mcn_lead_page) && !bgVar.afk()) {
                this.ibW = true;
            } else {
                this.ibW = false;
            }
            if (this.ibW) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, bgVar.afd().toString(), aeO.mcn_lead_page, bgVar.getTid());
            } else {
                this.mTitleView.setText(this.ibX);
            }
            this.mTitleView.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            this.ibU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.hwY = false;
                    d.this.mTitleView.setOnTouchListener(d.this.ica);
                    d.this.mTitleView.setText(d.this.ibY);
                    d.this.ibU.setVisibility(8);
                }
            });
            this.ibS.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), aq.aJ(bgVar.aeo())));
            this.ibT.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), aq.aJ(aeO.play_count.intValue())));
            aqe();
        }
    }

    public void aqe() {
        am.f(this.mTitleView, R.color.cp_cont_b, 1);
        am.f(this.ibU, R.color.cp_link_tip_c, 1);
        am.f(this.ibS, R.color.cp_cont_d, 1);
        am.f(this.ibT, R.color.cp_cont_d, 1);
    }
}
