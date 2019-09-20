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
    private boolean hzM;
    public TextView ieR;
    public TextView ieS;
    public TextView ieT;
    private boolean ieU;
    private boolean ieV;
    private SpannableStringBuilder ieW;
    private SpannableStringBuilder ieX;
    private View.OnTouchListener ieY;
    private View.OnTouchListener ieZ;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(R.id.view_video_title);
            this.mTitleView.setTextSize(0, TbConfig.getContentSize());
            this.mTitleView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.mTitleView.getPaint().setFakeBoldText(true);
            this.ieR = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.ieS = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.ieT = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.ieW != null && !d.this.ieV && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.hzM) {
                            if (!d.this.ieU) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.ieT.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.ieT.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.ieT.setLayoutParams(layoutParams);
                                d.this.ieU = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.ieX == null) {
                                String charSequence = d.this.mTitleView.getText().toString();
                                String j = aq.j(charSequence, aq.od(charSequence.substring(0, charSequence.length() - ellipsisCount)) - 6, "");
                                int length = j.length();
                                d.this.ieX = new SpannableStringBuilder();
                                d.this.ieX.append((CharSequence) j);
                                for (Object obj : d.this.ieW.getSpans(length, charSequence.length(), Object.class)) {
                                    int spanStart = d.this.ieW.getSpanStart(obj);
                                    int spanEnd = d.this.ieW.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.ieX.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...详情");
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tieba.pb.video.d.1.1
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view2) {
                                        d.this.hzM = true;
                                        d.this.mTitleView.setMaxLines(10);
                                        d.this.mTitleView.setOnTouchListener(new k(d.this.ieW));
                                        d.this.mTitleView.setText(d.this.ieW);
                                        d.this.ieT.setVisibility(0);
                                    }
                                }, 0, spannableString.length(), 17);
                                d.this.ieX.insert(length, (CharSequence) spannableString);
                                d.this.ieZ = new k(d.this.ieX);
                            }
                            d.this.ieT.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.ieZ);
                            d.this.mTitleView.setText(d.this.ieX);
                        }
                    }
                }
            });
        }
    }

    public void ay(bh bhVar) {
        if (bhVar != null && bhVar.aeT() != null) {
            bhVar.aft();
            this.ieW = new SpannableStringBuilder(bhVar.afi());
            if (bhVar.afp() && !StringUtils.isNull(bhVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.ahU().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bhVar.getTid();
                this.ieW.append((CharSequence) bhVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.2
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
            this.ieY = new k(this.ieW);
            this.mTitleView.setOnTouchListener(this.ieY);
            VideoInfo aeT = bhVar.aeT();
            if (!StringUtils.isNull(aeT.mcn_lead_page) && !bhVar.afp()) {
                this.ieV = true;
            } else {
                this.ieV = false;
            }
            if (this.ieV) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, bhVar.afi().toString(), aeT.mcn_lead_page, bhVar.getTid());
            } else {
                this.mTitleView.setText(this.ieW);
            }
            this.mTitleView.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            this.ieT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.hzM = false;
                    d.this.mTitleView.setOnTouchListener(d.this.ieZ);
                    d.this.mTitleView.setText(d.this.ieX);
                    d.this.ieT.setVisibility(8);
                }
            });
            this.ieR.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), aq.aJ(bhVar.aet())));
            this.ieS.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), aq.aJ(aeT.play_count.intValue())));
            aqs();
        }
    }

    public void aqs() {
        am.f(this.mTitleView, R.color.cp_cont_b, 1);
        am.f(this.ieT, R.color.cp_link_tip_c, 1);
        am.f(this.ieR, R.color.cp_cont_d, 1);
        am.f(this.ieS, R.color.cp_cont_d, 1);
    }
}
