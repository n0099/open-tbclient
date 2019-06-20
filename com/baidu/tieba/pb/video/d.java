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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.view.k;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class d {
    public TextView hVF;
    public TextView hVG;
    public TextView hVH;
    private boolean hVI;
    private boolean hVJ;
    private SpannableStringBuilder hVK;
    private SpannableStringBuilder hVL;
    private View.OnTouchListener hVM;
    private View.OnTouchListener hVN;
    private boolean hqM;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(R.id.view_video_title);
            this.mTitleView.setTextSize(0, TbConfig.getContentSize());
            this.mTitleView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.mTitleView.getPaint().setFakeBoldText(true);
            this.hVF = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.hVG = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.hVH = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.hVK != null && !d.this.hVJ && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.hqM) {
                            if (!d.this.hVI) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.hVH.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.hVH.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.hVH.setLayoutParams(layoutParams);
                                d.this.hVI = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.hVL == null) {
                                String charSequence = d.this.mTitleView.getText().toString();
                                String j = ap.j(charSequence, ap.nO(charSequence.substring(0, charSequence.length() - ellipsisCount)) - 6, "");
                                int length = j.length();
                                d.this.hVL = new SpannableStringBuilder();
                                d.this.hVL.append((CharSequence) j);
                                for (Object obj : d.this.hVK.getSpans(length, charSequence.length(), Object.class)) {
                                    int spanStart = d.this.hVK.getSpanStart(obj);
                                    int spanEnd = d.this.hVK.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.hVL.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...详情");
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tieba.pb.video.d.1.1
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view2) {
                                        d.this.hqM = true;
                                        d.this.mTitleView.setMaxLines(10);
                                        d.this.mTitleView.setOnTouchListener(new k(d.this.hVK));
                                        d.this.mTitleView.setText(d.this.hVK);
                                        d.this.hVH.setVisibility(0);
                                    }
                                }, 0, spannableString.length(), 17);
                                d.this.hVL.insert(length, (CharSequence) spannableString);
                                d.this.hVN = new k(d.this.hVL);
                            }
                            d.this.hVH.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.hVN);
                            d.this.mTitleView.setText(d.this.hVL);
                        }
                    }
                }
            });
        }
    }

    public void aw(bg bgVar) {
        if (bgVar != null && bgVar.adM() != null) {
            bgVar.aem();
            this.hVK = new SpannableStringBuilder(bgVar.aeb());
            if (bgVar.aei() && !StringUtils.isNull(bgVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.agM().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bgVar.getTid();
                this.hVK.append((CharSequence) bgVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.2
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                        TiebaStatic.log(new am("c12841").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3"));
                    }

                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                        textPaint.setUnderlineText(false);
                    }
                }));
            }
            this.hVM = new k(this.hVK);
            this.mTitleView.setOnTouchListener(this.hVM);
            VideoInfo adM = bgVar.adM();
            if (!StringUtils.isNull(adM.mcn_lead_page) && !bgVar.aei()) {
                this.hVJ = true;
            } else {
                this.hVJ = false;
            }
            if (this.hVJ) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, bgVar.aeb().toString(), adM.mcn_lead_page, bgVar.getTid());
            } else {
                this.mTitleView.setText(this.hVK);
            }
            this.mTitleView.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
            this.hVH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.hqM = false;
                    d.this.mTitleView.setOnTouchListener(d.this.hVN);
                    d.this.mTitleView.setText(d.this.hVL);
                    d.this.hVH.setVisibility(8);
                }
            });
            this.hVF.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), ap.aI(bgVar.adm())));
            this.hVG.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), ap.aI(adM.play_count.intValue())));
            aoY();
        }
    }

    public void aoY() {
        al.f(this.mTitleView, R.color.cp_cont_b, 1);
        al.f(this.hVH, R.color.cp_link_tip_c, 1);
        al.f(this.hVF, R.color.cp_cont_d, 1);
        al.f(this.hVG, R.color.cp_cont_d, 1);
    }
}
