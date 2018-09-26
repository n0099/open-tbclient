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
/* loaded from: classes2.dex */
public class d {
    public TextView fTZ;
    public TextView fUa;
    public TextView fUb;
    private boolean fUc;
    private SpannableStringBuilder fUd;
    private SpannableStringBuilder fUe;
    private View.OnTouchListener fUf;
    private View.OnTouchListener fUg;
    private boolean fpM;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(e.g.view_video_title);
            this.fTZ = (TextView) this.mRootView.findViewById(e.g.pb_video_replay_num);
            this.fUa = (TextView) this.mRootView.findViewById(e.g.pb_video_play_count);
            this.fUb = (TextView) this.mRootView.findViewById(e.g.view_video_title_up);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.fUd != null && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.fpM) {
                            if (!d.this.fUc) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.fUb.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.fUb.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, e.g.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, e.g.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.fUb.setLayoutParams(layoutParams);
                                d.this.fUc = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.fUe == null) {
                                String charSequence = d.this.mTitleView.getText().toString();
                                String d = ao.d(charSequence, ao.fb(charSequence.substring(0, charSequence.length() - ellipsisCount)) - 6, "");
                                int length = d.length();
                                d.this.fUe = new SpannableStringBuilder();
                                d.this.fUe.append((CharSequence) d);
                                for (Object obj : d.this.fUd.getSpans(length, charSequence.length(), Object.class)) {
                                    int spanStart = d.this.fUd.getSpanStart(obj);
                                    int spanEnd = d.this.fUd.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.fUe.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...详情");
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tieba.pb.video.d.1.1
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view2) {
                                        d.this.fpM = true;
                                        d.this.mTitleView.setMaxLines(10);
                                        d.this.mTitleView.setOnTouchListener(new k(d.this.fUd));
                                        d.this.mTitleView.setText(d.this.fUd);
                                        d.this.fUb.setVisibility(0);
                                    }
                                }, 0, spannableString.length(), 17);
                                d.this.fUe.insert(length, (CharSequence) spannableString);
                                d.this.fUg = new k(d.this.fUe);
                            }
                            d.this.fUb.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.fUg);
                            d.this.mTitleView.setText(d.this.fUe);
                        }
                    }
                }
            });
        }
    }

    public void an(bb bbVar) {
        if (bbVar != null && bbVar.wE() != null) {
            bbVar.wX();
            this.fUd = new SpannableStringBuilder(bbVar.wM());
            if (bbVar.wT() && !StringUtils.isNull(bbVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bbVar.getTid();
                this.fUd.append((CharSequence) bbVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.2
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                        TiebaStatic.log(new am("c12841").al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3"));
                    }

                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                        textPaint.setUnderlineText(false);
                    }
                }));
            }
            this.fUf = new k(this.fUd);
            this.mTitleView.setOnTouchListener(this.fUf);
            this.mTitleView.setText(this.fUd);
            this.mTitleView.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            this.fUb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.fpM = false;
                    d.this.mTitleView.setOnTouchListener(d.this.fUg);
                    d.this.mTitleView.setText(d.this.fUe);
                    d.this.fUb.setVisibility(8);
                }
            });
            this.fTZ.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.pb_video_header_replay_num), ao.H(bbVar.wd())));
            this.fUa.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.pb_video_header_play_count), ao.H(bbVar.wE().play_count.intValue())));
            GW();
        }
    }

    public void GW() {
        al.c(this.mTitleView, e.d.cp_cont_b, 1);
        al.c(this.fUb, e.d.cp_link_tip_c, 1);
        al.c(this.fTZ, e.d.cp_cont_f, 1);
        al.c(this.fUa, e.d.cp_cont_f, 1);
    }
}
