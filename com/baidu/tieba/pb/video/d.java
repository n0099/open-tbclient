package com.baidu.tieba.pb.video;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.am;
import com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout;
import com.baidu.tieba.view.i;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class d {
    public TextView jIL;
    public TextView jIM;
    public TextView jIN;
    private TextView jIO;
    private TbImageView jIP;
    private ThreadAgreeAndShareLayout jIQ;
    private boolean jIR;
    private boolean jIS;
    private com.baidu.tbadk.core.view.a.a jIT;
    private SpannableStringBuilder jIU;
    private SpannableStringBuilder jIV;
    private View.OnTouchListener jIW;
    private View.OnTouchListener jIX;
    private boolean jdb;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f jIY = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.jdb = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new i(d.this.jIU));
            d.this.mTitleView.setText(d.this.jIU);
            d.this.jIN.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.jIO) {
                Object tag = d.this.jIO.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.jIN) {
                d.this.jdb = false;
                d.this.mTitleView.setOnTouchListener(d.this.jIX);
                d.this.mTitleView.setText(d.this.jIV);
                d.this.jIN.setVisibility(8);
            }
        }
    };

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(R.id.view_video_title);
            this.mTitleView.setTextSize(0, TbConfig.getContentSize());
            this.mTitleView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.mTitleView.getPaint().setFakeBoldText(true);
            this.jIL = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.jIM = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.jIN = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.jIO = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.jIQ = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.jIP = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.jIU != null && !d.this.jIS && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.jdb) {
                            if (!d.this.jIR) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.jIN.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.jIN.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.jIN.setLayoutParams(layoutParams);
                                d.this.jIR = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.jIV == null) {
                                String spannableStringBuilder = d.this.jIU.toString();
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder, aq.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.jIV = new SpannableStringBuilder();
                                d.this.jIV.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.jIU.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.jIU.getSpanStart(obj);
                                    int spanEnd = d.this.jIU.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.jIV.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.jIY, 0, spannableString.length(), 17);
                                d.this.jIV.insert(length, (CharSequence) spannableString);
                                d.this.jIX = new i(d.this.jIV);
                            }
                            d.this.jIN.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.jIX);
                            d.this.mTitleView.setText(d.this.jIV);
                        }
                    }
                }
            });
        }
    }

    private boolean aL(bj bjVar) {
        if (bjVar == null || this.jIU == null || !bjVar.aLr() || StringUtils.isNull(bjVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.aNV().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bjVar.getTid();
        this.jIU.append((CharSequence) bjVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new an("c12841").cI("obj_source", "3"));
            }

            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                textPaint.setUnderlineText(false);
            }
        }));
        return true;
    }

    public void a(com.baidu.tieba.pb.data.e eVar, String str) {
        bj cvu;
        bf bfVar;
        Layout c;
        SpannableString aJ;
        if (eVar != null && (cvu = eVar.cvu()) != null && cvu.aKV() != null) {
            cvu.aLA();
            this.jIU = new SpannableStringBuilder(cvu.aLl());
            boolean aL = aL(cvu);
            VideoInfo aKV = cvu.aKV();
            if (!StringUtils.isNull(aKV.mcn_lead_page) && !aL) {
                this.jIS = true;
            } else {
                this.jIS = false;
            }
            if (this.jIU != null && !this.jIS && !aL && (aJ = am.aJ(cvu)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aJ.getSpans(0, aJ.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.jIT = aVarArr[0];
                }
                this.jIU.append((CharSequence) aJ);
            }
            if (this.jIT != null && this.jIU != null && (c = am.c(this.jIU)) != null && c.getLineCount() > 10) {
                int spanStart = this.jIU.getSpanStart(this.jIT);
                int spanEnd = this.jIU.getSpanEnd(this.jIT);
                if (spanStart > 0) {
                    this.jIU.delete(spanStart, spanEnd);
                }
            }
            if (this.jIS) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, cvu.aLl().toString(), aKV.mcn_lead_page, cvu.getTid());
            } else {
                this.mTitleView.setText(this.jIU);
            }
            this.mTitleView.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.jIW = new i(this.jIU);
            this.mTitleView.setOnTouchListener(this.jIW);
            this.jIN.setOnClickListener(this.mOnClickListener);
            this.jIM.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), aq.numberUniformFormatExtra(aKV.play_count.intValue())));
            if (eVar.cvS() && eVar.aQh()) {
                if (TextUtils.isEmpty(str)) {
                    str = cvu.aKJ();
                }
                if (TextUtils.isEmpty(str) && (bfVar = (bf) v.getItem(eVar.cvN(), 0)) != null) {
                    str = bfVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.jIP.setVisibility(0);
                    this.jIO.setVisibility(0);
                    this.jIO.setOnClickListener(this.mOnClickListener);
                    this.jIO.setText(am.HJ(str));
                    this.jIO.setTag(str);
                } else {
                    this.jIO.setVisibility(8);
                    this.jIP.setVisibility(8);
                }
                this.jIL.setVisibility(8);
                this.jIQ.setData(eVar, cvu.aMs());
            } else {
                this.jIP.setVisibility(8);
                this.jIO.setVisibility(8);
                this.jIL.setVisibility(0);
                this.jIL.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), aq.numberUniformFormatExtra(cvu.aKv())));
                this.jIQ.setVisibility(8);
            }
            aVd();
        }
    }

    public void aVd() {
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jIN, R.color.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jIL, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jIM, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jIO, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setImageResource(this.jIP, R.drawable.icon_common_arrow20_right_n);
        if (this.jIQ != null) {
            this.jIQ.aVd();
        }
    }
}
