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
    private boolean fyP;
    public TextView gcW;
    public TextView gcX;
    public TextView gcY;
    private boolean gcZ;
    private boolean gda;
    private SpannableStringBuilder gdb;
    private SpannableStringBuilder gdc;
    private View.OnTouchListener gdd;
    private View.OnTouchListener gde;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(e.g.view_video_title);
            this.gcW = (TextView) this.mRootView.findViewById(e.g.pb_video_replay_num);
            this.gcX = (TextView) this.mRootView.findViewById(e.g.pb_video_play_count);
            this.gcY = (TextView) this.mRootView.findViewById(e.g.view_video_title_up);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.gdb != null && !d.this.gda && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.fyP) {
                            if (!d.this.gcZ) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.gcY.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.gcY.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, e.g.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, e.g.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.gcY.setLayoutParams(layoutParams);
                                d.this.gcZ = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.gdc == null) {
                                String charSequence = d.this.mTitleView.getText().toString();
                                String d = ao.d(charSequence, ao.fp(charSequence.substring(0, charSequence.length() - ellipsisCount)) - 6, "");
                                int length = d.length();
                                d.this.gdc = new SpannableStringBuilder();
                                d.this.gdc.append((CharSequence) d);
                                for (Object obj : d.this.gdb.getSpans(length, charSequence.length(), Object.class)) {
                                    int spanStart = d.this.gdb.getSpanStart(obj);
                                    int spanEnd = d.this.gdb.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.gdc.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...详情");
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tieba.pb.video.d.1.1
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view2) {
                                        d.this.fyP = true;
                                        d.this.mTitleView.setMaxLines(10);
                                        d.this.mTitleView.setOnTouchListener(new k(d.this.gdb));
                                        d.this.mTitleView.setText(d.this.gdb);
                                        d.this.gcY.setVisibility(0);
                                    }
                                }, 0, spannableString.length(), 17);
                                d.this.gdc.insert(length, (CharSequence) spannableString);
                                d.this.gde = new k(d.this.gdc);
                            }
                            d.this.gcY.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.gde);
                            d.this.mTitleView.setText(d.this.gdc);
                        }
                    }
                }
            });
        }
    }

    public void an(bb bbVar) {
        if (bbVar != null && bbVar.yU() != null) {
            bbVar.zn();
            this.gdb = new SpannableStringBuilder(bbVar.zc());
            if (bbVar.zj() && !StringUtils.isNull(bbVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bbVar.getTid();
                this.gdb.append((CharSequence) bbVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.2
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
            this.gdd = new k(this.gdb);
            this.mTitleView.setOnTouchListener(this.gdd);
            VideoInfo yU = bbVar.yU();
            if (!StringUtils.isNull(yU.mcn_lead_page) && !bbVar.zj()) {
                this.gda = true;
            } else {
                this.gda = false;
            }
            if (this.gda) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, bbVar.zc().toString(), yU.mcn_lead_page, bbVar.getTid());
            } else {
                this.mTitleView.setText(this.gdb);
            }
            this.mTitleView.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            this.gcY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.fyP = false;
                    d.this.mTitleView.setOnTouchListener(d.this.gde);
                    d.this.mTitleView.setText(d.this.gdc);
                    d.this.gcY.setVisibility(8);
                }
            });
            this.gcW.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.pb_video_header_replay_num), ao.L(bbVar.yt())));
            this.gcX.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.pb_video_header_play_count), ao.L(yU.play_count.intValue())));
            Jj();
        }
    }

    public void Jj() {
        al.c(this.mTitleView, e.d.cp_cont_b, 1);
        al.c(this.gcY, e.d.cp_link_tip_c, 1);
        al.c(this.gcW, e.d.cp_cont_f, 1);
        al.c(this.gcX, e.d.cp_cont_f, 1);
    }
}
