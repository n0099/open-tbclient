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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout;
import com.baidu.tieba.view.i;
import tbclient.VideoInfo;
/* loaded from: classes22.dex */
public class d {
    public TextView lYI;
    public TextView lYJ;
    public TextView lYK;
    private TextView lYL;
    private TbImageView lYM;
    private ThreadAgreeAndShareLayout lYN;
    private boolean lYO;
    private boolean lYP;
    private com.baidu.tbadk.core.view.a.a lYQ;
    private SpannableStringBuilder lYR;
    private SpannableStringBuilder lYS;
    private View.OnTouchListener lYT;
    private View.OnTouchListener lYU;
    private boolean lmA;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f lYV = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.lmA = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new i(d.this.lYR));
            d.this.mTitleView.setText(d.this.lYR);
            d.this.lYK.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.lYL) {
                Object tag = d.this.lYL.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.lYK) {
                d.this.lmA = false;
                d.this.mTitleView.setOnTouchListener(d.this.lYU);
                d.this.mTitleView.setText(d.this.lYS);
                d.this.lYK.setVisibility(8);
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
            this.lYI = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.lYJ = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.lYK = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.lYL = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.lYN = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.lYM = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.lYR != null && !d.this.lYP && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.lmA) {
                            if (!d.this.lYO) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.lYK.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.lYK.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.lYK.setLayoutParams(layoutParams);
                                d.this.lYO = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.lYS == null) {
                                String spannableStringBuilder = d.this.lYR.toString();
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder, au.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.lYS = new SpannableStringBuilder();
                                d.this.lYS.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.lYR.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.lYR.getSpanStart(obj);
                                    int spanEnd = d.this.lYR.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.lYS.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.lYV, 0, spannableString.length(), 17);
                                d.this.lYS.insert(length, (CharSequence) spannableString);
                                d.this.lYU = new i(d.this.lYS);
                            }
                            d.this.lYK.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.lYU);
                            d.this.mTitleView.setText(d.this.lYS);
                        }
                    }
                }
            });
        }
    }

    private boolean aN(by byVar) {
        if (byVar == null || this.lYR == null || !byVar.bpF() || StringUtils.isNull(byVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.bsO().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + byVar.getTid();
        this.lYR.append((CharSequence) byVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new ar("c12841").dY("obj_source", "3"));
            }

            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }));
        return true;
    }

    public void a(com.baidu.tieba.pb.data.f fVar, String str) {
        by dmT;
        bu buVar;
        Layout f;
        SpannableString aL;
        if (fVar != null && (dmT = fVar.dmT()) != null && dmT.bph() != null) {
            dmT.bpQ();
            this.lYR = new SpannableStringBuilder(dmT.bpz());
            boolean aN = aN(dmT);
            VideoInfo bph = dmT.bph();
            if (!StringUtils.isNull(bph.mcn_lead_page) && !aN) {
                this.lYP = true;
            } else {
                this.lYP = false;
            }
            if (this.lYR != null && !this.lYP && !aN && (aL = ay.aL(dmT)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aL.getSpans(0, aL.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.lYQ = aVarArr[0];
                }
                this.lYR.append((CharSequence) aL);
            }
            if (this.lYQ != null && this.lYR != null && (f = ay.f(this.lYR)) != null && f.getLineCount() > 10) {
                int spanStart = this.lYR.getSpanStart(this.lYQ);
                int spanEnd = this.lYR.getSpanEnd(this.lYQ);
                if (spanStart > 0) {
                    this.lYR.delete(spanStart, spanEnd);
                }
            }
            if (this.lYP) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, dmT.bpz().toString(), bph.mcn_lead_page, dmT.getTid());
            } else {
                this.mTitleView.setText(this.lYR);
            }
            this.mTitleView.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            this.lYT = new i(this.lYR);
            this.mTitleView.setOnTouchListener(this.lYT);
            this.lYK.setOnClickListener(this.mOnClickListener);
            this.lYJ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), au.numberUniformFormatExtra(bph.play_count.intValue())));
            if (fVar.dnx() && fVar.dnu()) {
                if (TextUtils.isEmpty(str)) {
                    str = dmT.boT();
                }
                if (TextUtils.isEmpty(str) && (buVar = (bu) y.getItem(fVar.dnq(), 0)) != null) {
                    str = buVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.lYM.setVisibility(0);
                    this.lYL.setVisibility(0);
                    this.lYL.setOnClickListener(this.mOnClickListener);
                    this.lYL.setText(ay.Qq(str));
                    this.lYL.setTag(str);
                } else {
                    this.lYL.setVisibility(8);
                    this.lYM.setVisibility(8);
                }
                this.lYI.setVisibility(8);
                this.lYN.setData(fVar, dmT.bqI());
            } else {
                this.lYM.setVisibility(8);
                this.lYL.setVisibility(8);
                this.lYI.setVisibility(0);
                this.lYI.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), au.numberUniformFormatExtra(dmT.boG())));
                this.lYN.setVisibility(8);
            }
            bAu();
        }
    }

    public void bAu() {
        ap.setViewTextColor(this.lYK, R.color.CAM_X0304, 1);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.lYI, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.lYJ, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.lYL, R.color.CAM_X0107, 1);
        ap.setImageResource(this.lYM, R.drawable.icon_common_arrow20_right_n);
        if (this.lYN != null) {
            this.lYN.bAu();
        }
    }
}
