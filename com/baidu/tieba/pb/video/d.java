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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class d {
    private boolean kZe;
    public TextView lKK;
    public TextView lKL;
    public TextView lKM;
    private TextView lKN;
    private TbImageView lKO;
    private ThreadAgreeAndShareLayout lKP;
    private boolean lKQ;
    private boolean lKR;
    private com.baidu.tbadk.core.view.a.a lKS;
    private SpannableStringBuilder lKT;
    private SpannableStringBuilder lKU;
    private View.OnTouchListener lKV;
    private View.OnTouchListener lKW;
    private com.baidu.tbadk.widget.richText.f lKX = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.kZe = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new i(d.this.lKT));
            d.this.mTitleView.setText(d.this.lKT);
            d.this.lKM.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.lKN) {
                Object tag = d.this.lKN.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.lKM) {
                d.this.kZe = false;
                d.this.mTitleView.setOnTouchListener(d.this.lKW);
                d.this.mTitleView.setText(d.this.lKU);
                d.this.lKM.setVisibility(8);
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
            this.lKK = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.lKL = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.lKM = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.lKN = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.lKP = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.lKO = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.lKT != null && !d.this.lKR && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.kZe) {
                            if (!d.this.lKQ) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.lKM.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.lKM.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.lKM.setLayoutParams(layoutParams);
                                d.this.lKQ = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.lKU == null) {
                                String spannableStringBuilder = d.this.lKT.toString();
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder, au.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.lKU = new SpannableStringBuilder();
                                d.this.lKU.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.lKT.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.lKT.getSpanStart(obj);
                                    int spanEnd = d.this.lKT.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.lKU.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.lKX, 0, spannableString.length(), 17);
                                d.this.lKU.insert(length, (CharSequence) spannableString);
                                d.this.lKW = new i(d.this.lKU);
                            }
                            d.this.lKM.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.lKW);
                            d.this.mTitleView.setText(d.this.lKU);
                        }
                    }
                }
            });
        }
    }

    private boolean aN(bx bxVar) {
        if (bxVar == null || this.lKT == null || !bxVar.bms() || StringUtils.isNull(bxVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.bpu().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bxVar.getTid();
        this.lKT.append((CharSequence) bxVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new ar("c12841").dR("obj_source", "3"));
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
        bx dhH;
        bt btVar;
        Layout d;
        SpannableString aL;
        if (fVar != null && (dhH = fVar.dhH()) != null && dhH.blU() != null) {
            dhH.bmD();
            this.lKT = new SpannableStringBuilder(dhH.bmm());
            boolean aN = aN(dhH);
            VideoInfo blU = dhH.blU();
            if (!StringUtils.isNull(blU.mcn_lead_page) && !aN) {
                this.lKR = true;
            } else {
                this.lKR = false;
            }
            if (this.lKT != null && !this.lKR && !aN && (aL = ay.aL(dhH)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aL.getSpans(0, aL.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.lKS = aVarArr[0];
                }
                this.lKT.append((CharSequence) aL);
            }
            if (this.lKS != null && this.lKT != null && (d = ay.d(this.lKT)) != null && d.getLineCount() > 10) {
                int spanStart = this.lKT.getSpanStart(this.lKS);
                int spanEnd = this.lKT.getSpanEnd(this.lKS);
                if (spanStart > 0) {
                    this.lKT.delete(spanStart, spanEnd);
                }
            }
            if (this.lKR) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, dhH.bmm().toString(), blU.mcn_lead_page, dhH.getTid());
            } else {
                this.mTitleView.setText(this.lKT);
            }
            this.mTitleView.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            this.lKV = new i(this.lKT);
            this.mTitleView.setOnTouchListener(this.lKV);
            this.lKM.setOnClickListener(this.mOnClickListener);
            this.lKL.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), au.numberUniformFormatExtra(blU.play_count.intValue())));
            if (fVar.dik() && fVar.dih()) {
                if (TextUtils.isEmpty(str)) {
                    str = dhH.blG();
                }
                if (TextUtils.isEmpty(str) && (btVar = (bt) y.getItem(fVar.die(), 0)) != null) {
                    str = btVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.lKO.setVisibility(0);
                    this.lKN.setVisibility(0);
                    this.lKN.setOnClickListener(this.mOnClickListener);
                    this.lKN.setText(ay.Pi(str));
                    this.lKN.setTag(str);
                } else {
                    this.lKN.setVisibility(8);
                    this.lKO.setVisibility(8);
                }
                this.lKK.setVisibility(8);
                this.lKP.setData(fVar, dhH.bnv());
            } else {
                this.lKO.setVisibility(8);
                this.lKN.setVisibility(8);
                this.lKK.setVisibility(0);
                this.lKK.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), au.numberUniformFormatExtra(dhH.blt())));
                this.lKP.setVisibility(8);
            }
            bwU();
        }
    }

    public void bwU() {
        ap.setViewTextColor(this.lKM, R.color.CAM_X0304, 1);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.lKK, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.lKL, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.lKN, R.color.CAM_X0107, 1);
        ap.setImageResource(this.lKO, R.drawable.icon_common_arrow20_right_n);
        if (this.lKP != null) {
            this.lKP.bwU();
        }
    }
}
