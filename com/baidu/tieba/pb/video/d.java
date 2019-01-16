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
    private boolean fJr;
    public TextView gnI;
    public TextView gnJ;
    public TextView gnK;
    private boolean gnL;
    private boolean gnM;
    private SpannableStringBuilder gnN;
    private SpannableStringBuilder gnO;
    private View.OnTouchListener gnP;
    private View.OnTouchListener gnQ;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(e.g.view_video_title);
            this.gnI = (TextView) this.mRootView.findViewById(e.g.pb_video_replay_num);
            this.gnJ = (TextView) this.mRootView.findViewById(e.g.pb_video_play_count);
            this.gnK = (TextView) this.mRootView.findViewById(e.g.view_video_title_up);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.gnN != null && !d.this.gnM && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.fJr) {
                            if (!d.this.gnL) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.gnK.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.gnK.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, e.g.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, e.g.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.gnK.setLayoutParams(layoutParams);
                                d.this.gnL = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.gnO == null) {
                                String charSequence = d.this.mTitleView.getText().toString();
                                String d = ao.d(charSequence, ao.fU(charSequence.substring(0, charSequence.length() - ellipsisCount)) - 6, "");
                                int length = d.length();
                                d.this.gnO = new SpannableStringBuilder();
                                d.this.gnO.append((CharSequence) d);
                                for (Object obj : d.this.gnN.getSpans(length, charSequence.length(), Object.class)) {
                                    int spanStart = d.this.gnN.getSpanStart(obj);
                                    int spanEnd = d.this.gnN.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.gnO.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...详情");
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tieba.pb.video.d.1.1
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view2) {
                                        d.this.fJr = true;
                                        d.this.mTitleView.setMaxLines(10);
                                        d.this.mTitleView.setOnTouchListener(new k(d.this.gnN));
                                        d.this.mTitleView.setText(d.this.gnN);
                                        d.this.gnK.setVisibility(0);
                                    }
                                }, 0, spannableString.length(), 17);
                                d.this.gnO.insert(length, (CharSequence) spannableString);
                                d.this.gnQ = new k(d.this.gnO);
                            }
                            d.this.gnK.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.gnQ);
                            d.this.mTitleView.setText(d.this.gnO);
                        }
                    }
                }
            });
        }
    }

    public void an(bb bbVar) {
        if (bbVar != null && bbVar.Al() != null) {
            bbVar.AE();
            this.gnN = new SpannableStringBuilder(bbVar.At());
            if (bbVar.AA() && !StringUtils.isNull(bbVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bbVar.getTid();
                this.gnN.append((CharSequence) bbVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.2
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                        TiebaStatic.log(new am("c12841").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3"));
                    }

                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                        textPaint.setUnderlineText(false);
                    }
                }));
            }
            this.gnP = new k(this.gnN);
            this.mTitleView.setOnTouchListener(this.gnP);
            VideoInfo Al = bbVar.Al();
            if (!StringUtils.isNull(Al.mcn_lead_page) && !bbVar.AA()) {
                this.gnM = true;
            } else {
                this.gnM = false;
            }
            if (this.gnM) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, bbVar.At().toString(), Al.mcn_lead_page, bbVar.getTid());
            } else {
                this.mTitleView.setText(this.gnN);
            }
            this.mTitleView.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            this.gnK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.fJr = false;
                    d.this.mTitleView.setOnTouchListener(d.this.gnQ);
                    d.this.mTitleView.setText(d.this.gnO);
                    d.this.gnK.setVisibility(8);
                }
            });
            this.gnI.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.pb_video_header_replay_num), ao.T(bbVar.zK())));
            this.gnJ.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.pb_video_header_play_count), ao.T(Al.play_count.intValue())));
            KD();
        }
    }

    public void KD() {
        al.c(this.mTitleView, e.d.cp_cont_b, 1);
        al.c(this.gnK, e.d.cp_link_tip_c, 1);
        al.c(this.gnI, e.d.cp_cont_f, 1);
        al.c(this.gnJ, e.d.cp_cont_f, 1);
    }
}
