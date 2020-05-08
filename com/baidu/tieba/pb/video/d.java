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
    public TextView jIP;
    public TextView jIQ;
    public TextView jIR;
    private TextView jIS;
    private TbImageView jIT;
    private ThreadAgreeAndShareLayout jIU;
    private boolean jIV;
    private boolean jIW;
    private com.baidu.tbadk.core.view.a.a jIX;
    private SpannableStringBuilder jIY;
    private SpannableStringBuilder jIZ;
    private View.OnTouchListener jJa;
    private View.OnTouchListener jJb;
    private boolean jdf;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f jJc = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.jdf = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new i(d.this.jIY));
            d.this.mTitleView.setText(d.this.jIY);
            d.this.jIR.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.jIS) {
                Object tag = d.this.jIS.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.jIR) {
                d.this.jdf = false;
                d.this.mTitleView.setOnTouchListener(d.this.jJb);
                d.this.mTitleView.setText(d.this.jIZ);
                d.this.jIR.setVisibility(8);
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
            this.jIP = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.jIQ = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.jIR = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.jIS = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.jIU = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.jIT = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.jIY != null && !d.this.jIW && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.jdf) {
                            if (!d.this.jIV) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.jIR.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.jIR.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.jIR.setLayoutParams(layoutParams);
                                d.this.jIV = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.jIZ == null) {
                                String spannableStringBuilder = d.this.jIY.toString();
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder, aq.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.jIZ = new SpannableStringBuilder();
                                d.this.jIZ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.jIY.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.jIY.getSpanStart(obj);
                                    int spanEnd = d.this.jIY.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.jIZ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.jJc, 0, spannableString.length(), 17);
                                d.this.jIZ.insert(length, (CharSequence) spannableString);
                                d.this.jJb = new i(d.this.jIZ);
                            }
                            d.this.jIR.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.jJb);
                            d.this.mTitleView.setText(d.this.jIZ);
                        }
                    }
                }
            });
        }
    }

    private boolean aL(bj bjVar) {
        if (bjVar == null || this.jIY == null || !bjVar.aLp() || StringUtils.isNull(bjVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.aNT().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bjVar.getTid();
        this.jIY.append((CharSequence) bjVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
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
        bj cvr;
        bf bfVar;
        Layout c;
        SpannableString aJ;
        if (eVar != null && (cvr = eVar.cvr()) != null && cvr.aKT() != null) {
            cvr.aLy();
            this.jIY = new SpannableStringBuilder(cvr.aLj());
            boolean aL = aL(cvr);
            VideoInfo aKT = cvr.aKT();
            if (!StringUtils.isNull(aKT.mcn_lead_page) && !aL) {
                this.jIW = true;
            } else {
                this.jIW = false;
            }
            if (this.jIY != null && !this.jIW && !aL && (aJ = am.aJ(cvr)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aJ.getSpans(0, aJ.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.jIX = aVarArr[0];
                }
                this.jIY.append((CharSequence) aJ);
            }
            if (this.jIX != null && this.jIY != null && (c = am.c(this.jIY)) != null && c.getLineCount() > 10) {
                int spanStart = this.jIY.getSpanStart(this.jIX);
                int spanEnd = this.jIY.getSpanEnd(this.jIX);
                if (spanStart > 0) {
                    this.jIY.delete(spanStart, spanEnd);
                }
            }
            if (this.jIW) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, cvr.aLj().toString(), aKT.mcn_lead_page, cvr.getTid());
            } else {
                this.mTitleView.setText(this.jIY);
            }
            this.mTitleView.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.jJa = new i(this.jIY);
            this.mTitleView.setOnTouchListener(this.jJa);
            this.jIR.setOnClickListener(this.mOnClickListener);
            this.jIQ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), aq.numberUniformFormatExtra(aKT.play_count.intValue())));
            if (eVar.cvP() && eVar.aQe()) {
                if (TextUtils.isEmpty(str)) {
                    str = cvr.aKH();
                }
                if (TextUtils.isEmpty(str) && (bfVar = (bf) v.getItem(eVar.cvK(), 0)) != null) {
                    str = bfVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.jIT.setVisibility(0);
                    this.jIS.setVisibility(0);
                    this.jIS.setOnClickListener(this.mOnClickListener);
                    this.jIS.setText(am.HM(str));
                    this.jIS.setTag(str);
                } else {
                    this.jIS.setVisibility(8);
                    this.jIT.setVisibility(8);
                }
                this.jIP.setVisibility(8);
                this.jIU.setData(eVar, cvr.aMq());
            } else {
                this.jIT.setVisibility(8);
                this.jIS.setVisibility(8);
                this.jIP.setVisibility(0);
                this.jIP.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), aq.numberUniformFormatExtra(cvr.aKt())));
                this.jIU.setVisibility(8);
            }
            aVb();
        }
    }

    public void aVb() {
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jIR, R.color.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jIP, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jIQ, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jIS, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setImageResource(this.jIT, R.drawable.icon_common_arrow20_right_n);
        if (this.jIU != null) {
            this.jIU.aVb();
        }
    }
}
