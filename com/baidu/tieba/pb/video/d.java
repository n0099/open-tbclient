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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class d {
    public TextView iRR;
    public TextView iRS;
    public TextView iRT;
    private TextView iRU;
    private TbImageView iRV;
    private ThreadAgreeAndShareLayout iRW;
    private boolean iRX;
    private boolean iRY;
    private com.baidu.tbadk.core.view.a.a iRZ;
    private SpannableStringBuilder iSa;
    private SpannableStringBuilder iSb;
    private View.OnTouchListener iSc;
    private View.OnTouchListener iSd;
    private boolean ilH;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f iSe = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.ilH = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new com.baidu.tieba.view.h(d.this.iSa));
            d.this.mTitleView.setText(d.this.iSa);
            d.this.iRT.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.iRU) {
                Object tag = d.this.iRU.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.iRT) {
                d.this.ilH = false;
                d.this.mTitleView.setOnTouchListener(d.this.iSd);
                d.this.mTitleView.setText(d.this.iSb);
                d.this.iRT.setVisibility(8);
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
            this.iRR = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.iRS = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.iRT = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.iRU = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.iRW = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.iRV = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.iSa != null && !d.this.iRY && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.ilH) {
                            if (!d.this.iRX) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.iRT.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.iRT.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.iRT.setLayoutParams(layoutParams);
                                d.this.iRX = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.iSb == null) {
                                String spannableStringBuilder = d.this.iSa.toString();
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder, aq.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.iSb = new SpannableStringBuilder();
                                d.this.iSb.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.iSa.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.iSa.getSpanStart(obj);
                                    int spanEnd = d.this.iSa.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.iSb.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.iSe, 0, spannableString.length(), 17);
                                d.this.iSb.insert(length, (CharSequence) spannableString);
                                d.this.iSd = new com.baidu.tieba.view.h(d.this.iSb);
                            }
                            d.this.iRT.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.iSd);
                            d.this.mTitleView.setText(d.this.iSb);
                        }
                    }
                }
            });
        }
    }

    private boolean aF(bj bjVar) {
        if (bjVar == null || this.iSa == null || !bjVar.aAr() || StringUtils.isNull(bjVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.aCY().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bjVar.getTid();
        this.iSa.append((CharSequence) bjVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new an("c12841").cp("obj_source", "3"));
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

    public void a(com.baidu.tieba.pb.data.f fVar, String str) {
        bj chK;
        bf bfVar;
        Layout c;
        SpannableString aD;
        if (fVar != null && (chK = fVar.chK()) != null && chK.azV() != null) {
            chK.aAB();
            this.iSa = new SpannableStringBuilder(chK.aAl());
            boolean aF = aF(chK);
            VideoInfo azV = chK.azV();
            if (!StringUtils.isNull(azV.mcn_lead_page) && !aF) {
                this.iRY = true;
            } else {
                this.iRY = false;
            }
            if (this.iSa != null && !this.iRY && !aF && (aD = ap.aD(chK)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aD.getSpans(0, aD.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.iRZ = aVarArr[0];
                }
                this.iSa.append((CharSequence) aD);
            }
            if (this.iRZ != null && this.iSa != null && (c = ap.c(this.iSa)) != null && c.getLineCount() > 10) {
                int spanStart = this.iSa.getSpanStart(this.iRZ);
                int spanEnd = this.iSa.getSpanEnd(this.iRZ);
                if (spanStart > 0) {
                    this.iSa.delete(spanStart, spanEnd);
                }
            }
            if (this.iRY) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, chK.aAl().toString(), azV.mcn_lead_page, chK.getTid());
            } else {
                this.mTitleView.setText(this.iSa);
            }
            this.mTitleView.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            this.iSc = new com.baidu.tieba.view.h(this.iSa);
            this.mTitleView.setOnTouchListener(this.iSc);
            this.iRT.setOnClickListener(this.mOnClickListener);
            this.iRS.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), aq.numberUniformFormatExtra(azV.play_count.intValue())));
            if (fVar.cik() && fVar.cih()) {
                if (TextUtils.isEmpty(str)) {
                    str = chK.azJ();
                }
                if (TextUtils.isEmpty(str) && (bfVar = (bf) v.getItem(fVar.cie(), 0)) != null) {
                    str = bfVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.iRV.setVisibility(0);
                    this.iRU.setVisibility(0);
                    this.iRU.setOnClickListener(this.mOnClickListener);
                    this.iRU.setText(ap.FC(str));
                    this.iRU.setTag(str);
                } else {
                    this.iRU.setVisibility(8);
                    this.iRV.setVisibility(8);
                }
                this.iRR.setVisibility(8);
                this.iRW.setData(fVar, chK.aBt());
            } else {
                this.iRV.setVisibility(8);
                this.iRU.setVisibility(8);
                this.iRR.setVisibility(0);
                this.iRR.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), aq.numberUniformFormatExtra(chK.azv())));
                this.iRW.setVisibility(8);
            }
            aJJ();
        }
    }

    public void aJJ() {
        am.setViewTextColor(this.iRT, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.iRR, R.color.cp_cont_j, 1);
        am.setViewTextColor(this.iRS, R.color.cp_cont_j, 1);
        am.setViewTextColor(this.iRU, R.color.cp_cont_j, 1);
        am.setImageResource(this.iRV, R.drawable.icon_common_arrow20_right_n);
        if (this.iRW != null) {
            this.iRW.aJJ();
        }
    }
}
