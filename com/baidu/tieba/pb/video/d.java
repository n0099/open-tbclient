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
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class d {
    private boolean fFF;
    public TextView gjO;
    public TextView gjP;
    public TextView gjQ;
    private boolean gjR;
    private boolean gjS;
    private SpannableStringBuilder gjT;
    private SpannableStringBuilder gjU;
    private View.OnTouchListener gjV;
    private View.OnTouchListener gjW;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(e.g.view_video_title);
            this.gjO = (TextView) this.mRootView.findViewById(e.g.pb_video_replay_num);
            this.gjP = (TextView) this.mRootView.findViewById(e.g.pb_video_play_count);
            this.gjQ = (TextView) this.mRootView.findViewById(e.g.view_video_title_up);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.gjT != null && !d.this.gjS && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.fFF) {
                            if (!d.this.gjR) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.gjQ.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.gjQ.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, e.g.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, e.g.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.gjQ.setLayoutParams(layoutParams);
                                d.this.gjR = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.gjU == null) {
                                String charSequence = d.this.mTitleView.getText().toString();
                                String d = ao.d(charSequence, ao.fH(charSequence.substring(0, charSequence.length() - ellipsisCount)) - 6, "");
                                int length = d.length();
                                d.this.gjU = new SpannableStringBuilder();
                                d.this.gjU.append((CharSequence) d);
                                for (Object obj : d.this.gjT.getSpans(length, charSequence.length(), Object.class)) {
                                    int spanStart = d.this.gjT.getSpanStart(obj);
                                    int spanEnd = d.this.gjT.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.gjU.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...详情");
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tieba.pb.video.d.1.1
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view2) {
                                        d.this.fFF = true;
                                        d.this.mTitleView.setMaxLines(10);
                                        d.this.mTitleView.setOnTouchListener(new k(d.this.gjT));
                                        d.this.mTitleView.setText(d.this.gjT);
                                        d.this.gjQ.setVisibility(0);
                                    }
                                }, 0, spannableString.length(), 17);
                                d.this.gjU.insert(length, (CharSequence) spannableString);
                                d.this.gjW = new k(d.this.gjU);
                            }
                            d.this.gjQ.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.gjW);
                            d.this.mTitleView.setText(d.this.gjU);
                        }
                    }
                }
            });
        }
    }

    public void an(bb bbVar) {
        if (bbVar != null && bbVar.zY() != null) {
            bbVar.Ar();
            this.gjT = new SpannableStringBuilder(bbVar.Ag());
            if (bbVar.An() && !StringUtils.isNull(bbVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bbVar.getTid();
                this.gjT.append((CharSequence) bbVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.2
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                        TiebaStatic.log(new am("c12841").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3"));
                    }

                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                        textPaint.setUnderlineText(false);
                    }
                }));
            }
            this.gjV = new k(this.gjT);
            this.mTitleView.setOnTouchListener(this.gjV);
            VideoInfo zY = bbVar.zY();
            if (!StringUtils.isNull(zY.mcn_lead_page) && !bbVar.An()) {
                this.gjS = true;
            } else {
                this.gjS = false;
            }
            if (this.gjS) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, bbVar.Ag().toString(), zY.mcn_lead_page, bbVar.getTid());
            } else {
                this.mTitleView.setText(this.gjT);
            }
            this.mTitleView.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            this.gjQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.fFF = false;
                    d.this.mTitleView.setOnTouchListener(d.this.gjW);
                    d.this.mTitleView.setText(d.this.gjU);
                    d.this.gjQ.setVisibility(8);
                }
            });
            this.gjO.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.pb_video_header_replay_num), ao.S(bbVar.zx())));
            this.gjP.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.pb_video_header_play_count), ao.S(zY.play_count.intValue())));
            Kn();
        }
    }

    public void Kn() {
        al.c(this.mTitleView, e.d.cp_cont_b, 1);
        al.c(this.gjQ, e.d.cp_link_tip_c, 1);
        al.c(this.gjO, e.d.cp_cont_f, 1);
        al.c(this.gjP, e.d.cp_cont_f, 1);
    }
}
