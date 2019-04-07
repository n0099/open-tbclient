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
    private boolean gZq;
    public TextView hDA;
    public TextView hDB;
    public TextView hDC;
    private boolean hDD;
    private boolean hDE;
    private SpannableStringBuilder hDF;
    private SpannableStringBuilder hDG;
    private View.OnTouchListener hDH;
    private View.OnTouchListener hDI;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(d.g.view_video_title);
            this.mTitleView.setTextSize(0, TbConfig.getContentSize());
            this.mTitleView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.mTitleView.getPaint().setFakeBoldText(true);
            this.hDA = (TextView) this.mRootView.findViewById(d.g.pb_video_replay_num);
            this.hDB = (TextView) this.mRootView.findViewById(d.g.pb_video_play_count);
            this.hDC = (TextView) this.mRootView.findViewById(d.g.view_video_title_up);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.hDF != null && !d.this.hDE && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.gZq) {
                            if (!d.this.hDD) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.hDC.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.hDC.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, d.g.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, d.g.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.hDC.setLayoutParams(layoutParams);
                                d.this.hDD = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.hDG == null) {
                                String charSequence = d.this.mTitleView.getText().toString();
                                String g = ap.g(charSequence, ap.mH(charSequence.substring(0, charSequence.length() - ellipsisCount)) - 6, "");
                                int length = g.length();
                                d.this.hDG = new SpannableStringBuilder();
                                d.this.hDG.append((CharSequence) g);
                                for (Object obj : d.this.hDF.getSpans(length, charSequence.length(), Object.class)) {
                                    int spanStart = d.this.hDF.getSpanStart(obj);
                                    int spanEnd = d.this.hDF.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.hDG.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...详情");
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tieba.pb.video.d.1.1
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view2) {
                                        d.this.gZq = true;
                                        d.this.mTitleView.setMaxLines(10);
                                        d.this.mTitleView.setOnTouchListener(new k(d.this.hDF));
                                        d.this.mTitleView.setText(d.this.hDF);
                                        d.this.hDC.setVisibility(0);
                                    }
                                }, 0, spannableString.length(), 17);
                                d.this.hDG.insert(length, (CharSequence) spannableString);
                                d.this.hDI = new k(d.this.hDG);
                            }
                            d.this.hDC.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.hDI);
                            d.this.mTitleView.setText(d.this.hDG);
                        }
                    }
                }
            });
        }
    }

    public void ay(bg bgVar) {
        if (bgVar != null && bgVar.Zf() != null) {
            bgVar.ZF();
            this.hDF = new SpannableStringBuilder(bgVar.Zu());
            if (bgVar.ZB() && !StringUtils.isNull(bgVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bgVar.getTid();
                this.hDF.append((CharSequence) bgVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.2
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                        TiebaStatic.log(new am("c12841").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3"));
                    }

                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0277d.cp_link_tip_c));
                        textPaint.setUnderlineText(false);
                    }
                }));
            }
            this.hDH = new k(this.hDF);
            this.mTitleView.setOnTouchListener(this.hDH);
            VideoInfo Zf = bgVar.Zf();
            if (!StringUtils.isNull(Zf.mcn_lead_page) && !bgVar.ZB()) {
                this.hDE = true;
            } else {
                this.hDE = false;
            }
            if (this.hDE) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, bgVar.Zu().toString(), Zf.mcn_lead_page, bgVar.getTid());
            } else {
                this.mTitleView.setText(this.hDF);
            }
            this.mTitleView.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
            this.hDC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.gZq = false;
                    d.this.mTitleView.setOnTouchListener(d.this.hDI);
                    d.this.mTitleView.setText(d.this.hDG);
                    d.this.hDC.setVisibility(8);
                }
            });
            this.hDA.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.pb_video_header_replay_num), ap.au(bgVar.YF())));
            this.hDB.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.pb_video_header_play_count), ap.au(Zf.play_count.intValue())));
            ajX();
        }
    }

    public void ajX() {
        al.d(this.mTitleView, d.C0277d.cp_cont_b, 1);
        al.d(this.hDC, d.C0277d.cp_link_tip_c, 1);
        al.d(this.hDA, d.C0277d.cp_cont_d, 1);
        al.d(this.hDB, d.C0277d.cp_cont_d, 1);
    }
}
