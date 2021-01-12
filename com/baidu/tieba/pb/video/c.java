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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout;
import com.baidu.tieba.view.i;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class c {
    private SpannableStringBuilder lZA;
    private SpannableStringBuilder lZB;
    private View.OnTouchListener lZC;
    private View.OnTouchListener lZD;
    public TextView lZr;
    public TextView lZs;
    public TextView lZt;
    private TextView lZu;
    private TbImageView lZv;
    private ThreadAgreeAndShareLayout lZw;
    private boolean lZx;
    private boolean lZy;
    private com.baidu.tbadk.core.view.a.a lZz;
    private boolean lnl;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f lZE = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.c.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            c.this.lnl = true;
            c.this.mTitleView.setMaxLines(10);
            c.this.mTitleView.setOnTouchListener(new i(c.this.lZA));
            c.this.mTitleView.setText(c.this.lZA);
            c.this.lZt.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.lZu) {
                Object tag = c.this.lZu.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == c.this.lZt) {
                c.this.lnl = false;
                c.this.mTitleView.setOnTouchListener(c.this.lZD);
                c.this.mTitleView.setText(c.this.lZB);
                c.this.lZt.setVisibility(8);
            }
        }
    };

    public c(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(R.id.view_video_title);
            this.mTitleView.setTextSize(0, TbConfig.getContentSize());
            this.mTitleView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.mTitleView.getPaint().setFakeBoldText(true);
            this.lZr = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.lZs = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.lZt = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.lZu = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.lZw = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.lZv = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (c.this.mTitleView != null && c.this.lZA != null && !c.this.lZy && (layout = c.this.mTitleView.getLayout()) != null) {
                        if (c.this.lnl) {
                            if (!c.this.lZx) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.lZt.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + c.this.lZt.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                c.this.lZt.setLayoutParams(layoutParams);
                                c.this.lZx = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (c.this.lZB == null) {
                                String spannableStringBuilder = c.this.lZA.toString();
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder, at.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                c.this.lZB = new SpannableStringBuilder();
                                c.this.lZB.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : c.this.lZA.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = c.this.lZA.getSpanStart(obj);
                                    int spanEnd = c.this.lZA.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        c.this.lZB.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(c.this.lZE, 0, spannableString.length(), 17);
                                c.this.lZB.insert(length, (CharSequence) spannableString);
                                c.this.lZD = new i(c.this.lZB);
                            }
                            c.this.lZt.setVisibility(8);
                            c.this.mTitleView.setOnTouchListener(c.this.lZD);
                            c.this.mTitleView.setText(c.this.lZB);
                        }
                    }
                }
            });
        }
    }

    private boolean aO(bz bzVar) {
        if (bzVar == null || this.lZA == null || !bzVar.bon() || StringUtils.isNull(bzVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.brx().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bzVar.getTid();
        this.lZA.append((CharSequence) bzVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.c.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new aq("c12841").dW("obj_source", "3"));
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
        bz diN;
        bv bvVar;
        Layout f;
        SpannableString aM;
        if (fVar != null && (diN = fVar.diN()) != null && diN.bnO() != null) {
            diN.boy();
            this.lZA = new SpannableStringBuilder(diN.bog());
            boolean aO = aO(diN);
            VideoInfo bnO = diN.bnO();
            if (!StringUtils.isNull(bnO.mcn_lead_page) && !aO) {
                this.lZy = true;
            } else {
                this.lZy = false;
            }
            if (this.lZA != null && !this.lZy && !aO && (aM = ao.aM(diN)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aM.getSpans(0, aM.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.lZz = aVarArr[0];
                }
                this.lZA.append((CharSequence) aM);
            }
            if (this.lZz != null && this.lZA != null && (f = ao.f(this.lZA)) != null && f.getLineCount() > 10) {
                int spanStart = this.lZA.getSpanStart(this.lZz);
                int spanEnd = this.lZA.getSpanEnd(this.lZz);
                if (spanStart > 0) {
                    this.lZA.delete(spanStart, spanEnd);
                }
            }
            if (this.lZy) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, diN.bog().toString(), bnO.mcn_lead_page, diN.getTid());
            } else {
                this.mTitleView.setText(this.lZA);
            }
            this.mTitleView.setLinkTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0304));
            this.lZC = new i(this.lZA);
            this.mTitleView.setOnTouchListener(this.lZC);
            this.lZt.setOnClickListener(this.mOnClickListener);
            this.lZs.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), at.numberUniformFormatExtra(bnO.play_count.intValue())));
            if (fVar.djq() && fVar.djn()) {
                if (TextUtils.isEmpty(str)) {
                    str = diN.bnB();
                }
                if (TextUtils.isEmpty(str) && (bvVar = (bv) x.getItem(fVar.djk(), 0)) != null) {
                    str = bvVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.lZv.setVisibility(0);
                    this.lZu.setVisibility(0);
                    this.lZu.setOnClickListener(this.mOnClickListener);
                    this.lZu.setText(ao.ON(str));
                    this.lZu.setTag(str);
                } else {
                    this.lZu.setVisibility(8);
                    this.lZv.setVisibility(8);
                }
                this.lZr.setVisibility(8);
                this.lZw.setData(fVar, diN.bpr());
            } else {
                this.lZv.setVisibility(8);
                this.lZu.setVisibility(8);
                this.lZr.setVisibility(0);
                this.lZr.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), at.numberUniformFormatExtra(diN.bno())));
                this.lZw.setVisibility(8);
            }
            byV();
        }
    }

    public void byV() {
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lZt, R.color.CAM_X0304, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lZr, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lZs, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lZu, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setImageResource(this.lZv, R.drawable.icon_common_arrow20_right_n);
        if (this.lZw != null) {
            this.lZw.byV();
        }
    }
}
