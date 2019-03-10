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
import com.baidu.tieba.d;
import com.baidu.tieba.view.k;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class d {
    private boolean gZE;
    public TextView hDU;
    public TextView hDV;
    public TextView hDW;
    private boolean hDX;
    private boolean hDY;
    private SpannableStringBuilder hDZ;
    private SpannableStringBuilder hEa;
    private View.OnTouchListener hEb;
    private View.OnTouchListener hEc;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(d.g.view_video_title);
            this.mTitleView.setTextSize(0, TbConfig.getContentSize());
            this.mTitleView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.mTitleView.getPaint().setFakeBoldText(true);
            this.hDU = (TextView) this.mRootView.findViewById(d.g.pb_video_replay_num);
            this.hDV = (TextView) this.mRootView.findViewById(d.g.pb_video_play_count);
            this.hDW = (TextView) this.mRootView.findViewById(d.g.view_video_title_up);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.hDZ != null && !d.this.hDY && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.gZE) {
                            if (!d.this.hDX) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.hDW.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.hDW.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, d.g.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, d.g.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.hDW.setLayoutParams(layoutParams);
                                d.this.hDX = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.hEa == null) {
                                String charSequence = d.this.mTitleView.getText().toString();
                                String g = ap.g(charSequence, ap.mG(charSequence.substring(0, charSequence.length() - ellipsisCount)) - 6, "");
                                int length = g.length();
                                d.this.hEa = new SpannableStringBuilder();
                                d.this.hEa.append((CharSequence) g);
                                for (Object obj : d.this.hDZ.getSpans(length, charSequence.length(), Object.class)) {
                                    int spanStart = d.this.hDZ.getSpanStart(obj);
                                    int spanEnd = d.this.hDZ.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.hEa.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...详情");
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tieba.pb.video.d.1.1
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view2) {
                                        d.this.gZE = true;
                                        d.this.mTitleView.setMaxLines(10);
                                        d.this.mTitleView.setOnTouchListener(new k(d.this.hDZ));
                                        d.this.mTitleView.setText(d.this.hDZ);
                                        d.this.hDW.setVisibility(0);
                                    }
                                }, 0, spannableString.length(), 17);
                                d.this.hEa.insert(length, (CharSequence) spannableString);
                                d.this.hEc = new k(d.this.hEa);
                            }
                            d.this.hDW.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.hEc);
                            d.this.mTitleView.setText(d.this.hEa);
                        }
                    }
                }
            });
        }
    }

    public void az(bg bgVar) {
        if (bgVar != null && bgVar.Zi() != null) {
            bgVar.ZI();
            this.hDZ = new SpannableStringBuilder(bgVar.Zx());
            if (bgVar.ZE() && !StringUtils.isNull(bgVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bgVar.getTid();
                this.hDZ.append((CharSequence) bgVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.2
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                        TiebaStatic.log(new am("c12841").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3"));
                    }

                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0236d.cp_link_tip_c));
                        textPaint.setUnderlineText(false);
                    }
                }));
            }
            this.hEb = new k(this.hDZ);
            this.mTitleView.setOnTouchListener(this.hEb);
            VideoInfo Zi = bgVar.Zi();
            if (!StringUtils.isNull(Zi.mcn_lead_page) && !bgVar.ZE()) {
                this.hDY = true;
            } else {
                this.hDY = false;
            }
            if (this.hDY) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, bgVar.Zx().toString(), Zi.mcn_lead_page, bgVar.getTid());
            } else {
                this.mTitleView.setText(this.hDZ);
            }
            this.mTitleView.setLinkTextColor(al.getColor(d.C0236d.cp_link_tip_c));
            this.hDW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.gZE = false;
                    d.this.mTitleView.setOnTouchListener(d.this.hEc);
                    d.this.mTitleView.setText(d.this.hEa);
                    d.this.hDW.setVisibility(8);
                }
            });
            this.hDU.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.pb_video_header_replay_num), ap.au(bgVar.YI())));
            this.hDV.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.pb_video_header_play_count), ap.au(Zi.play_count.intValue())));
            akb();
        }
    }

    public void akb() {
        al.d(this.mTitleView, d.C0236d.cp_cont_b, 1);
        al.d(this.hDW, d.C0236d.cp_link_tip_c, 1);
        al.d(this.hDU, d.C0236d.cp_cont_d, 1);
        al.d(this.hDV, d.C0236d.cp_cont_d, 1);
    }
}
