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
    public TextView lYK;
    public TextView lYL;
    public TextView lYM;
    private TextView lYN;
    private TbImageView lYO;
    private ThreadAgreeAndShareLayout lYP;
    private boolean lYQ;
    private boolean lYR;
    private com.baidu.tbadk.core.view.a.a lYS;
    private SpannableStringBuilder lYT;
    private SpannableStringBuilder lYU;
    private View.OnTouchListener lYV;
    private View.OnTouchListener lYW;
    private boolean lmC;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f lYX = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.lmC = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new i(d.this.lYT));
            d.this.mTitleView.setText(d.this.lYT);
            d.this.lYM.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.lYN) {
                Object tag = d.this.lYN.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.lYM) {
                d.this.lmC = false;
                d.this.mTitleView.setOnTouchListener(d.this.lYW);
                d.this.mTitleView.setText(d.this.lYU);
                d.this.lYM.setVisibility(8);
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
            this.lYK = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.lYL = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.lYM = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.lYN = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.lYP = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.lYO = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.lYT != null && !d.this.lYR && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.lmC) {
                            if (!d.this.lYQ) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.lYM.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.lYM.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.lYM.setLayoutParams(layoutParams);
                                d.this.lYQ = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.lYU == null) {
                                String spannableStringBuilder = d.this.lYT.toString();
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder, au.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.lYU = new SpannableStringBuilder();
                                d.this.lYU.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.lYT.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.lYT.getSpanStart(obj);
                                    int spanEnd = d.this.lYT.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.lYU.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.lYX, 0, spannableString.length(), 17);
                                d.this.lYU.insert(length, (CharSequence) spannableString);
                                d.this.lYW = new i(d.this.lYU);
                            }
                            d.this.lYM.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.lYW);
                            d.this.mTitleView.setText(d.this.lYU);
                        }
                    }
                }
            });
        }
    }

    private boolean aN(by byVar) {
        if (byVar == null || this.lYT == null || !byVar.bpF() || StringUtils.isNull(byVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.bsO().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + byVar.getTid();
        this.lYT.append((CharSequence) byVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
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
        by dmU;
        bu buVar;
        Layout f;
        SpannableString aL;
        if (fVar != null && (dmU = fVar.dmU()) != null && dmU.bph() != null) {
            dmU.bpQ();
            this.lYT = new SpannableStringBuilder(dmU.bpz());
            boolean aN = aN(dmU);
            VideoInfo bph = dmU.bph();
            if (!StringUtils.isNull(bph.mcn_lead_page) && !aN) {
                this.lYR = true;
            } else {
                this.lYR = false;
            }
            if (this.lYT != null && !this.lYR && !aN && (aL = ay.aL(dmU)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aL.getSpans(0, aL.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.lYS = aVarArr[0];
                }
                this.lYT.append((CharSequence) aL);
            }
            if (this.lYS != null && this.lYT != null && (f = ay.f(this.lYT)) != null && f.getLineCount() > 10) {
                int spanStart = this.lYT.getSpanStart(this.lYS);
                int spanEnd = this.lYT.getSpanEnd(this.lYS);
                if (spanStart > 0) {
                    this.lYT.delete(spanStart, spanEnd);
                }
            }
            if (this.lYR) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, dmU.bpz().toString(), bph.mcn_lead_page, dmU.getTid());
            } else {
                this.mTitleView.setText(this.lYT);
            }
            this.mTitleView.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            this.lYV = new i(this.lYT);
            this.mTitleView.setOnTouchListener(this.lYV);
            this.lYM.setOnClickListener(this.mOnClickListener);
            this.lYL.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), au.numberUniformFormatExtra(bph.play_count.intValue())));
            if (fVar.dny() && fVar.dnv()) {
                if (TextUtils.isEmpty(str)) {
                    str = dmU.boT();
                }
                if (TextUtils.isEmpty(str) && (buVar = (bu) y.getItem(fVar.dnr(), 0)) != null) {
                    str = buVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.lYO.setVisibility(0);
                    this.lYN.setVisibility(0);
                    this.lYN.setOnClickListener(this.mOnClickListener);
                    this.lYN.setText(ay.Qq(str));
                    this.lYN.setTag(str);
                } else {
                    this.lYN.setVisibility(8);
                    this.lYO.setVisibility(8);
                }
                this.lYK.setVisibility(8);
                this.lYP.setData(fVar, dmU.bqI());
            } else {
                this.lYO.setVisibility(8);
                this.lYN.setVisibility(8);
                this.lYK.setVisibility(0);
                this.lYK.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), au.numberUniformFormatExtra(dmU.boG())));
                this.lYP.setVisibility(8);
            }
            bAu();
        }
    }

    public void bAu() {
        ap.setViewTextColor(this.lYM, R.color.CAM_X0304, 1);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.lYK, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.lYL, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.lYN, R.color.CAM_X0107, 1);
        ap.setImageResource(this.lYO, R.drawable.icon_common_arrow20_right_n);
        if (this.lYP != null) {
            this.lYP.bAu();
        }
    }
}
