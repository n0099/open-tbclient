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
/* loaded from: classes7.dex */
public class d {
    public TextView iVA;
    public TextView iVB;
    private TextView iVC;
    private TbImageView iVD;
    private ThreadAgreeAndShareLayout iVE;
    private boolean iVF;
    private boolean iVG;
    private com.baidu.tbadk.core.view.a.a iVH;
    private SpannableStringBuilder iVI;
    private SpannableStringBuilder iVJ;
    private View.OnTouchListener iVK;
    private View.OnTouchListener iVL;
    public TextView iVz;
    private boolean ipn;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f iVM = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.ipn = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new com.baidu.tieba.view.h(d.this.iVI));
            d.this.mTitleView.setText(d.this.iVI);
            d.this.iVB.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.iVC) {
                Object tag = d.this.iVC.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.iVB) {
                d.this.ipn = false;
                d.this.mTitleView.setOnTouchListener(d.this.iVL);
                d.this.mTitleView.setText(d.this.iVJ);
                d.this.iVB.setVisibility(8);
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
            this.iVz = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.iVA = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.iVB = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.iVC = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.iVE = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.iVD = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.iVI != null && !d.this.iVG && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.ipn) {
                            if (!d.this.iVF) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.iVB.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.iVB.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.iVB.setLayoutParams(layoutParams);
                                d.this.iVF = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.iVJ == null) {
                                String spannableStringBuilder = d.this.iVI.toString();
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder, aq.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.iVJ = new SpannableStringBuilder();
                                d.this.iVJ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.iVI.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.iVI.getSpanStart(obj);
                                    int spanEnd = d.this.iVI.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.iVJ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.iVM, 0, spannableString.length(), 17);
                                d.this.iVJ.insert(length, (CharSequence) spannableString);
                                d.this.iVL = new com.baidu.tieba.view.h(d.this.iVJ);
                            }
                            d.this.iVB.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.iVL);
                            d.this.mTitleView.setText(d.this.iVJ);
                        }
                    }
                }
            });
        }
    }

    private boolean aG(bj bjVar) {
        if (bjVar == null || this.iVI == null || !bjVar.aAK() || StringUtils.isNull(bjVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.aDr().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bjVar.getTid();
        this.iVI.append((CharSequence) bjVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
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
        bj ciS;
        bf bfVar;
        Layout c;
        SpannableString aE;
        if (fVar != null && (ciS = fVar.ciS()) != null && ciS.aAo() != null) {
            ciS.aAU();
            this.iVI = new SpannableStringBuilder(ciS.aAE());
            boolean aG = aG(ciS);
            VideoInfo aAo = ciS.aAo();
            if (!StringUtils.isNull(aAo.mcn_lead_page) && !aG) {
                this.iVG = true;
            } else {
                this.iVG = false;
            }
            if (this.iVI != null && !this.iVG && !aG && (aE = ap.aE(ciS)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aE.getSpans(0, aE.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.iVH = aVarArr[0];
                }
                this.iVI.append((CharSequence) aE);
            }
            if (this.iVH != null && this.iVI != null && (c = ap.c(this.iVI)) != null && c.getLineCount() > 10) {
                int spanStart = this.iVI.getSpanStart(this.iVH);
                int spanEnd = this.iVI.getSpanEnd(this.iVH);
                if (spanStart > 0) {
                    this.iVI.delete(spanStart, spanEnd);
                }
            }
            if (this.iVG) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, ciS.aAE().toString(), aAo.mcn_lead_page, ciS.getTid());
            } else {
                this.mTitleView.setText(this.iVI);
            }
            this.mTitleView.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            this.iVK = new com.baidu.tieba.view.h(this.iVI);
            this.mTitleView.setOnTouchListener(this.iVK);
            this.iVB.setOnClickListener(this.mOnClickListener);
            this.iVA.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), aq.numberUniformFormatExtra(aAo.play_count.intValue())));
            if (fVar.cjs() && fVar.cjp()) {
                if (TextUtils.isEmpty(str)) {
                    str = ciS.aAc();
                }
                if (TextUtils.isEmpty(str) && (bfVar = (bf) v.getItem(fVar.cjm(), 0)) != null) {
                    str = bfVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.iVD.setVisibility(0);
                    this.iVC.setVisibility(0);
                    this.iVC.setOnClickListener(this.mOnClickListener);
                    this.iVC.setText(ap.FM(str));
                    this.iVC.setTag(str);
                } else {
                    this.iVC.setVisibility(8);
                    this.iVD.setVisibility(8);
                }
                this.iVz.setVisibility(8);
                this.iVE.setData(fVar, ciS.aBM());
            } else {
                this.iVD.setVisibility(8);
                this.iVC.setVisibility(8);
                this.iVz.setVisibility(0);
                this.iVz.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), aq.numberUniformFormatExtra(ciS.azO())));
                this.iVE.setVisibility(8);
            }
            aKd();
        }
    }

    public void aKd() {
        am.setViewTextColor(this.iVB, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.iVz, R.color.cp_cont_j, 1);
        am.setViewTextColor(this.iVA, R.color.cp_cont_j, 1);
        am.setViewTextColor(this.iVC, R.color.cp_cont_j, 1);
        am.setImageResource(this.iVD, R.drawable.icon_common_arrow20_right_n);
        if (this.iVE != null) {
            this.iVE.aKd();
        }
    }
}
