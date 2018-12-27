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
    private boolean fIx;
    public TextView gmF;
    public TextView gmG;
    public TextView gmH;
    private boolean gmI;
    private boolean gmJ;
    private SpannableStringBuilder gmK;
    private SpannableStringBuilder gmL;
    private View.OnTouchListener gmM;
    private View.OnTouchListener gmN;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(e.g.view_video_title);
            this.gmF = (TextView) this.mRootView.findViewById(e.g.pb_video_replay_num);
            this.gmG = (TextView) this.mRootView.findViewById(e.g.pb_video_play_count);
            this.gmH = (TextView) this.mRootView.findViewById(e.g.view_video_title_up);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.gmK != null && !d.this.gmJ && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.fIx) {
                            if (!d.this.gmI) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.gmH.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.gmH.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, e.g.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, e.g.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.gmH.setLayoutParams(layoutParams);
                                d.this.gmI = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.gmL == null) {
                                String charSequence = d.this.mTitleView.getText().toString();
                                String d = ao.d(charSequence, ao.fH(charSequence.substring(0, charSequence.length() - ellipsisCount)) - 6, "");
                                int length = d.length();
                                d.this.gmL = new SpannableStringBuilder();
                                d.this.gmL.append((CharSequence) d);
                                for (Object obj : d.this.gmK.getSpans(length, charSequence.length(), Object.class)) {
                                    int spanStart = d.this.gmK.getSpanStart(obj);
                                    int spanEnd = d.this.gmK.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.gmL.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...详情");
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tieba.pb.video.d.1.1
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view2) {
                                        d.this.fIx = true;
                                        d.this.mTitleView.setMaxLines(10);
                                        d.this.mTitleView.setOnTouchListener(new k(d.this.gmK));
                                        d.this.mTitleView.setText(d.this.gmK);
                                        d.this.gmH.setVisibility(0);
                                    }
                                }, 0, spannableString.length(), 17);
                                d.this.gmL.insert(length, (CharSequence) spannableString);
                                d.this.gmN = new k(d.this.gmL);
                            }
                            d.this.gmH.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.gmN);
                            d.this.mTitleView.setText(d.this.gmL);
                        }
                    }
                }
            });
        }
    }

    public void an(bb bbVar) {
        if (bbVar != null && bbVar.zY() != null) {
            bbVar.Ar();
            this.gmK = new SpannableStringBuilder(bbVar.Ag());
            if (bbVar.An() && !StringUtils.isNull(bbVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bbVar.getTid();
                this.gmK.append((CharSequence) bbVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.2
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
            this.gmM = new k(this.gmK);
            this.mTitleView.setOnTouchListener(this.gmM);
            VideoInfo zY = bbVar.zY();
            if (!StringUtils.isNull(zY.mcn_lead_page) && !bbVar.An()) {
                this.gmJ = true;
            } else {
                this.gmJ = false;
            }
            if (this.gmJ) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, bbVar.Ag().toString(), zY.mcn_lead_page, bbVar.getTid());
            } else {
                this.mTitleView.setText(this.gmK);
            }
            this.mTitleView.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            this.gmH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.fIx = false;
                    d.this.mTitleView.setOnTouchListener(d.this.gmN);
                    d.this.mTitleView.setText(d.this.gmL);
                    d.this.gmH.setVisibility(8);
                }
            });
            this.gmF.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.pb_video_header_replay_num), ao.T(bbVar.zx())));
            this.gmG.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.pb_video_header_play_count), ao.T(zY.play_count.intValue())));
            Ko();
        }
    }

    public void Ko() {
        al.c(this.mTitleView, e.d.cp_cont_b, 1);
        al.c(this.gmH, e.d.cp_link_tip_c, 1);
        al.c(this.gmF, e.d.cp_cont_f, 1);
        al.c(this.gmG, e.d.cp_cont_f, 1);
    }
}
