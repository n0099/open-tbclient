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
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout;
import com.baidu.tieba.view.i;
import tbclient.VideoInfo;
/* loaded from: classes21.dex */
public class d {
    private boolean krh;
    public TextView lcG;
    public TextView lcH;
    public TextView lcI;
    private TextView lcJ;
    private TbImageView lcK;
    private ThreadAgreeAndShareLayout lcL;
    private boolean lcM;
    private boolean lcN;
    private com.baidu.tbadk.core.view.a.a lcO;
    private SpannableStringBuilder lcP;
    private SpannableStringBuilder lcQ;
    private View.OnTouchListener lcR;
    private View.OnTouchListener lcS;
    private com.baidu.tbadk.widget.richText.f lcT = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.krh = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new i(d.this.lcP));
            d.this.mTitleView.setText(d.this.lcP);
            d.this.lcI.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.lcJ) {
                Object tag = d.this.lcJ.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.lcI) {
                d.this.krh = false;
                d.this.mTitleView.setOnTouchListener(d.this.lcS);
                d.this.mTitleView.setText(d.this.lcQ);
                d.this.lcI.setVisibility(8);
            }
        }
    };
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(R.id.view_video_title);
            this.mTitleView.setTextSize(0, TbConfig.getContentSize());
            this.mTitleView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.mTitleView.getPaint().setFakeBoldText(true);
            this.lcG = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.lcH = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.lcI = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.lcJ = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.lcL = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.lcK = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.lcP != null && !d.this.lcN && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.krh) {
                            if (!d.this.lcM) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.lcI.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.lcI.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.lcI.setLayoutParams(layoutParams);
                                d.this.lcM = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.lcQ == null) {
                                String spannableStringBuilder = d.this.lcP.toString();
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder, at.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.lcQ = new SpannableStringBuilder();
                                d.this.lcQ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.lcP.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.lcP.getSpanStart(obj);
                                    int spanEnd = d.this.lcP.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.lcQ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.lcT, 0, spannableString.length(), 17);
                                d.this.lcQ.insert(length, (CharSequence) spannableString);
                                d.this.lcS = new i(d.this.lcQ);
                            }
                            d.this.lcI.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.lcS);
                            d.this.mTitleView.setText(d.this.lcQ);
                        }
                    }
                }
            });
        }
    }

    private boolean aL(bw bwVar) {
        if (bwVar == null || this.lcP == null || !bwVar.bgo() || StringUtils.isNull(bwVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.bjf().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bwVar.getTid();
        this.lcP.append((CharSequence) bwVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new aq("c12841").dF("obj_source", "3"));
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
        bw cYR;
        bs bsVar;
        Layout c;
        SpannableString aJ;
        if (fVar != null && (cYR = fVar.cYR()) != null && cYR.bfQ() != null) {
            cYR.bgx();
            this.lcP = new SpannableStringBuilder(cYR.bgi());
            boolean aL = aL(cYR);
            VideoInfo bfQ = cYR.bfQ();
            if (!StringUtils.isNull(bfQ.mcn_lead_page) && !aL) {
                this.lcN = true;
            } else {
                this.lcN = false;
            }
            if (this.lcP != null && !this.lcN && !aL && (aJ = ay.aJ(cYR)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aJ.getSpans(0, aJ.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.lcO = aVarArr[0];
                }
                this.lcP.append((CharSequence) aJ);
            }
            if (this.lcO != null && this.lcP != null && (c = ay.c(this.lcP)) != null && c.getLineCount() > 10) {
                int spanStart = this.lcP.getSpanStart(this.lcO);
                int spanEnd = this.lcP.getSpanEnd(this.lcO);
                if (spanStart > 0) {
                    this.lcP.delete(spanStart, spanEnd);
                }
            }
            if (this.lcN) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, cYR.bgi().toString(), bfQ.mcn_lead_page, cYR.getTid());
            } else {
                this.mTitleView.setText(this.lcP);
            }
            this.mTitleView.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            this.lcR = new i(this.lcP);
            this.mTitleView.setOnTouchListener(this.lcR);
            this.lcI.setOnClickListener(this.mOnClickListener);
            this.lcH.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), at.numberUniformFormatExtra(bfQ.play_count.intValue())));
            if (fVar.cZu() && fVar.cZr()) {
                if (TextUtils.isEmpty(str)) {
                    str = cYR.bfC();
                }
                if (TextUtils.isEmpty(str) && (bsVar = (bs) y.getItem(fVar.cZo(), 0)) != null) {
                    str = bsVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.lcK.setVisibility(0);
                    this.lcJ.setVisibility(0);
                    this.lcJ.setOnClickListener(this.mOnClickListener);
                    this.lcJ.setText(ay.Oi(str));
                    this.lcJ.setTag(str);
                } else {
                    this.lcJ.setVisibility(8);
                    this.lcK.setVisibility(8);
                }
                this.lcG.setVisibility(8);
                this.lcL.setData(fVar, cYR.bhp());
            } else {
                this.lcK.setVisibility(8);
                this.lcJ.setVisibility(8);
                this.lcG.setVisibility(0);
                this.lcG.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), at.numberUniformFormatExtra(cYR.bfp())));
                this.lcL.setVisibility(8);
            }
            bqC();
        }
    }

    public void bqC() {
        ap.setViewTextColor(this.lcI, R.color.cp_link_tip_c, 1);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.lcG, R.color.cp_cont_j, 1);
        ap.setViewTextColor(this.lcH, R.color.cp_cont_j, 1);
        ap.setViewTextColor(this.lcJ, R.color.cp_cont_j, 1);
        ap.setImageResource(this.lcK, R.drawable.icon_common_arrow20_right_n);
        if (this.lcL != null) {
            this.lcL.bqC();
        }
    }
}
