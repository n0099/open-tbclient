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
    private boolean iVA;
    private boolean iVB;
    private com.baidu.tbadk.core.view.a.a iVC;
    private SpannableStringBuilder iVD;
    private SpannableStringBuilder iVE;
    private View.OnTouchListener iVF;
    private View.OnTouchListener iVG;
    public TextView iVu;
    public TextView iVv;
    public TextView iVw;
    private TextView iVx;
    private TbImageView iVy;
    private ThreadAgreeAndShareLayout iVz;
    private boolean ipn;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f iVH = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.ipn = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new com.baidu.tieba.view.h(d.this.iVD));
            d.this.mTitleView.setText(d.this.iVD);
            d.this.iVw.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.iVx) {
                Object tag = d.this.iVx.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.iVw) {
                d.this.ipn = false;
                d.this.mTitleView.setOnTouchListener(d.this.iVG);
                d.this.mTitleView.setText(d.this.iVE);
                d.this.iVw.setVisibility(8);
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
            this.iVu = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.iVv = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.iVw = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.iVx = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.iVz = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.iVy = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.iVD != null && !d.this.iVB && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.ipn) {
                            if (!d.this.iVA) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.iVw.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.iVw.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.iVw.setLayoutParams(layoutParams);
                                d.this.iVA = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.iVE == null) {
                                String spannableStringBuilder = d.this.iVD.toString();
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder, aq.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.iVE = new SpannableStringBuilder();
                                d.this.iVE.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.iVD.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.iVD.getSpanStart(obj);
                                    int spanEnd = d.this.iVD.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.iVE.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.iVH, 0, spannableString.length(), 17);
                                d.this.iVE.insert(length, (CharSequence) spannableString);
                                d.this.iVG = new com.baidu.tieba.view.h(d.this.iVE);
                            }
                            d.this.iVw.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.iVG);
                            d.this.mTitleView.setText(d.this.iVE);
                        }
                    }
                }
            });
        }
    }

    private boolean aG(bj bjVar) {
        if (bjVar == null || this.iVD == null || !bjVar.aAK() || StringUtils.isNull(bjVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.aDr().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bjVar.getTid();
        this.iVD.append((CharSequence) bjVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
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
            this.iVD = new SpannableStringBuilder(ciS.aAE());
            boolean aG = aG(ciS);
            VideoInfo aAo = ciS.aAo();
            if (!StringUtils.isNull(aAo.mcn_lead_page) && !aG) {
                this.iVB = true;
            } else {
                this.iVB = false;
            }
            if (this.iVD != null && !this.iVB && !aG && (aE = ap.aE(ciS)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aE.getSpans(0, aE.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.iVC = aVarArr[0];
                }
                this.iVD.append((CharSequence) aE);
            }
            if (this.iVC != null && this.iVD != null && (c = ap.c(this.iVD)) != null && c.getLineCount() > 10) {
                int spanStart = this.iVD.getSpanStart(this.iVC);
                int spanEnd = this.iVD.getSpanEnd(this.iVC);
                if (spanStart > 0) {
                    this.iVD.delete(spanStart, spanEnd);
                }
            }
            if (this.iVB) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, ciS.aAE().toString(), aAo.mcn_lead_page, ciS.getTid());
            } else {
                this.mTitleView.setText(this.iVD);
            }
            this.mTitleView.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            this.iVF = new com.baidu.tieba.view.h(this.iVD);
            this.mTitleView.setOnTouchListener(this.iVF);
            this.iVw.setOnClickListener(this.mOnClickListener);
            this.iVv.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), aq.numberUniformFormatExtra(aAo.play_count.intValue())));
            if (fVar.cjs() && fVar.cjp()) {
                if (TextUtils.isEmpty(str)) {
                    str = ciS.aAc();
                }
                if (TextUtils.isEmpty(str) && (bfVar = (bf) v.getItem(fVar.cjm(), 0)) != null) {
                    str = bfVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.iVy.setVisibility(0);
                    this.iVx.setVisibility(0);
                    this.iVx.setOnClickListener(this.mOnClickListener);
                    this.iVx.setText(ap.FM(str));
                    this.iVx.setTag(str);
                } else {
                    this.iVx.setVisibility(8);
                    this.iVy.setVisibility(8);
                }
                this.iVu.setVisibility(8);
                this.iVz.setData(fVar, ciS.aBM());
            } else {
                this.iVy.setVisibility(8);
                this.iVx.setVisibility(8);
                this.iVu.setVisibility(0);
                this.iVu.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), aq.numberUniformFormatExtra(ciS.azO())));
                this.iVz.setVisibility(8);
            }
            aKd();
        }
    }

    public void aKd() {
        am.setViewTextColor(this.iVw, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.iVu, R.color.cp_cont_j, 1);
        am.setViewTextColor(this.iVv, R.color.cp_cont_j, 1);
        am.setViewTextColor(this.iVx, R.color.cp_cont_j, 1);
        am.setImageResource(this.iVy, R.drawable.icon_common_arrow20_right_n);
        if (this.iVz != null) {
            this.iVz.aKd();
        }
    }
}
