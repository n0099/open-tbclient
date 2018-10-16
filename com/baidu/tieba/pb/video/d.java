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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.view.k;
/* loaded from: classes6.dex */
public class d {
    private boolean fxr;
    public TextView gbA;
    public TextView gbB;
    private boolean gbC;
    private SpannableStringBuilder gbD;
    private SpannableStringBuilder gbE;
    private View.OnTouchListener gbF;
    private View.OnTouchListener gbG;
    public TextView gbz;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(e.g.view_video_title);
            this.gbz = (TextView) this.mRootView.findViewById(e.g.pb_video_replay_num);
            this.gbA = (TextView) this.mRootView.findViewById(e.g.pb_video_play_count);
            this.gbB = (TextView) this.mRootView.findViewById(e.g.view_video_title_up);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.gbD != null && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.fxr) {
                            if (!d.this.gbC) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.gbB.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.gbB.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, e.g.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, e.g.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.gbB.setLayoutParams(layoutParams);
                                d.this.gbC = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.gbE == null) {
                                String charSequence = d.this.mTitleView.getText().toString();
                                String d = ao.d(charSequence, ao.fp(charSequence.substring(0, charSequence.length() - ellipsisCount)) - 6, "");
                                int length = d.length();
                                d.this.gbE = new SpannableStringBuilder();
                                d.this.gbE.append((CharSequence) d);
                                for (Object obj : d.this.gbD.getSpans(length, charSequence.length(), Object.class)) {
                                    int spanStart = d.this.gbD.getSpanStart(obj);
                                    int spanEnd = d.this.gbD.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.gbE.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...详情");
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tieba.pb.video.d.1.1
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view2) {
                                        d.this.fxr = true;
                                        d.this.mTitleView.setMaxLines(10);
                                        d.this.mTitleView.setOnTouchListener(new k(d.this.gbD));
                                        d.this.mTitleView.setText(d.this.gbD);
                                        d.this.gbB.setVisibility(0);
                                    }
                                }, 0, spannableString.length(), 17);
                                d.this.gbE.insert(length, (CharSequence) spannableString);
                                d.this.gbG = new k(d.this.gbE);
                            }
                            d.this.gbB.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.gbG);
                            d.this.mTitleView.setText(d.this.gbE);
                        }
                    }
                }
            });
        }
    }

    public void an(bb bbVar) {
        if (bbVar != null && bbVar.yN() != null) {
            bbVar.zg();
            this.gbD = new SpannableStringBuilder(bbVar.yV());
            if (bbVar.zc() && !StringUtils.isNull(bbVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bbVar.getTid();
                this.gbD.append((CharSequence) bbVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.2
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                        TiebaStatic.log(new am("c12841").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3"));
                    }

                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                        textPaint.setUnderlineText(false);
                    }
                }));
            }
            this.gbF = new k(this.gbD);
            this.mTitleView.setOnTouchListener(this.gbF);
            this.mTitleView.setText(this.gbD);
            this.mTitleView.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            this.gbB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.fxr = false;
                    d.this.mTitleView.setOnTouchListener(d.this.gbG);
                    d.this.mTitleView.setText(d.this.gbE);
                    d.this.gbB.setVisibility(8);
                }
            });
            this.gbz.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.pb_video_header_replay_num), ao.J(bbVar.ym())));
            this.gbA.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.pb_video_header_play_count), ao.J(bbVar.yN().play_count.intValue())));
            IX();
        }
    }

    public void IX() {
        al.c(this.mTitleView, e.d.cp_cont_b, 1);
        al.c(this.gbB, e.d.cp_link_tip_c, 1);
        al.c(this.gbz, e.d.cp_cont_f, 1);
        al.c(this.gbA, e.d.cp_cont_f, 1);
    }
}
