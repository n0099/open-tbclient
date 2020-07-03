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
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout;
import com.baidu.tieba.view.i;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class d {
    private boolean jKF;
    private boolean kvA;
    private com.baidu.tbadk.core.view.a.a kvB;
    private SpannableStringBuilder kvC;
    private SpannableStringBuilder kvD;
    private View.OnTouchListener kvE;
    private View.OnTouchListener kvF;
    public TextView kvt;
    public TextView kvu;
    public TextView kvv;
    private TextView kvw;
    private TbImageView kvx;
    private ThreadAgreeAndShareLayout kvy;
    private boolean kvz;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f kvG = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.jKF = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new i(d.this.kvC));
            d.this.mTitleView.setText(d.this.kvC);
            d.this.kvv.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.kvw) {
                Object tag = d.this.kvw.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.kvv) {
                d.this.jKF = false;
                d.this.mTitleView.setOnTouchListener(d.this.kvF);
                d.this.mTitleView.setText(d.this.kvD);
                d.this.kvv.setVisibility(8);
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
            this.kvt = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.kvu = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.kvv = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.kvw = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.kvy = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.kvx = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.kvC != null && !d.this.kvA && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.jKF) {
                            if (!d.this.kvz) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.kvv.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.kvv.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.kvv.setLayoutParams(layoutParams);
                                d.this.kvz = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.kvD == null) {
                                String spannableStringBuilder = d.this.kvC.toString();
                                String cutChineseAndEnglishWithSuffix = ar.cutChineseAndEnglishWithSuffix(spannableStringBuilder, ar.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.kvD = new SpannableStringBuilder();
                                d.this.kvD.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.kvC.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.kvC.getSpanStart(obj);
                                    int spanEnd = d.this.kvC.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.kvD.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.kvG, 0, spannableString.length(), 17);
                                d.this.kvD.insert(length, (CharSequence) spannableString);
                                d.this.kvF = new i(d.this.kvD);
                            }
                            d.this.kvv.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.kvF);
                            d.this.mTitleView.setText(d.this.kvD);
                        }
                    }
                }
            });
        }
    }

    private boolean aM(bu buVar) {
        if (buVar == null || this.kvC == null || !buVar.aTf() || StringUtils.isNull(buVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.aVP().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + buVar.getTid();
        this.kvC.append((CharSequence) buVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new ao("c12841").dk("obj_source", "3"));
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
        bu cGN;
        bq bqVar;
        Layout c;
        SpannableString aK;
        if (eVar != null && (cGN = eVar.cGN()) != null && cGN.aSH() != null) {
            cGN.aTo();
            this.kvC = new SpannableStringBuilder(cGN.aSZ());
            boolean aM = aM(cGN);
            VideoInfo aSH = cGN.aSH();
            if (!StringUtils.isNull(aSH.mcn_lead_page) && !aM) {
                this.kvA = true;
            } else {
                this.kvA = false;
            }
            if (this.kvC != null && !this.kvA && !aM && (aK = au.aK(cGN)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aK.getSpans(0, aK.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.kvB = aVarArr[0];
                }
                this.kvC.append((CharSequence) aK);
            }
            if (this.kvB != null && this.kvC != null && (c = au.c(this.kvC)) != null && c.getLineCount() > 10) {
                int spanStart = this.kvC.getSpanStart(this.kvB);
                int spanEnd = this.kvC.getSpanEnd(this.kvB);
                if (spanStart > 0) {
                    this.kvC.delete(spanStart, spanEnd);
                }
            }
            if (this.kvA) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, cGN.aSZ().toString(), aSH.mcn_lead_page, cGN.getTid());
            } else {
                this.mTitleView.setText(this.kvC);
            }
            this.mTitleView.setLinkTextColor(an.getColor(R.color.cp_link_tip_c));
            this.kvE = new i(this.kvC);
            this.mTitleView.setOnTouchListener(this.kvE);
            this.kvv.setOnClickListener(this.mOnClickListener);
            this.kvu.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), ar.numberUniformFormatExtra(aSH.play_count.intValue())));
            if (eVar.cHp() && eVar.cHm()) {
                if (TextUtils.isEmpty(str)) {
                    str = cGN.aSt();
                }
                if (TextUtils.isEmpty(str) && (bqVar = (bq) w.getItem(eVar.cHj(), 0)) != null) {
                    str = bqVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.kvx.setVisibility(0);
                    this.kvw.setVisibility(0);
                    this.kvw.setOnClickListener(this.mOnClickListener);
                    this.kvw.setText(au.Ka(str));
                    this.kvw.setTag(str);
                } else {
                    this.kvw.setVisibility(8);
                    this.kvx.setVisibility(8);
                }
                this.kvt.setVisibility(8);
                this.kvy.setData(eVar, cGN.aUg());
            } else {
                this.kvx.setVisibility(8);
                this.kvw.setVisibility(8);
                this.kvt.setVisibility(0);
                this.kvt.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), ar.numberUniformFormatExtra(cGN.aSg())));
                this.kvy.setVisibility(8);
            }
            bdo();
        }
    }

    public void bdo() {
        an.setViewTextColor(this.kvv, R.color.cp_link_tip_c, 1);
        an.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        an.setViewTextColor(this.kvt, R.color.cp_cont_j, 1);
        an.setViewTextColor(this.kvu, R.color.cp_cont_j, 1);
        an.setViewTextColor(this.kvw, R.color.cp_cont_j, 1);
        an.setImageResource(this.kvx, R.drawable.icon_common_arrow20_right_n);
        if (this.kvy != null) {
            this.kvy.bdo();
        }
    }
}
