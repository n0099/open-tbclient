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
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class d {
    public TextView iXc;
    public TextView iXd;
    public TextView iXe;
    private TextView iXf;
    private TbImageView iXg;
    private ThreadAgreeAndShareLayout iXh;
    private boolean iXi;
    private boolean iXj;
    private com.baidu.tbadk.core.view.a.a iXk;
    private SpannableStringBuilder iXl;
    private SpannableStringBuilder iXm;
    private View.OnTouchListener iXn;
    private View.OnTouchListener iXo;
    private boolean irw;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f iXp = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.irw = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new com.baidu.tieba.view.h(d.this.iXl));
            d.this.mTitleView.setText(d.this.iXl);
            d.this.iXe.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.iXf) {
                Object tag = d.this.iXf.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.iXe) {
                d.this.irw = false;
                d.this.mTitleView.setOnTouchListener(d.this.iXo);
                d.this.mTitleView.setText(d.this.iXm);
                d.this.iXe.setVisibility(8);
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
            this.iXc = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.iXd = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.iXe = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.iXf = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.iXh = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.iXg = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.iXl != null && !d.this.iXj && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.irw) {
                            if (!d.this.iXi) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.iXe.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.iXe.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.iXe.setLayoutParams(layoutParams);
                                d.this.iXi = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.iXm == null) {
                                String spannableStringBuilder = d.this.iXl.toString();
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder, aq.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.iXm = new SpannableStringBuilder();
                                d.this.iXm.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.iXl.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.iXl.getSpanStart(obj);
                                    int spanEnd = d.this.iXl.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.iXm.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.iXp, 0, spannableString.length(), 17);
                                d.this.iXm.insert(length, (CharSequence) spannableString);
                                d.this.iXo = new com.baidu.tieba.view.h(d.this.iXm);
                            }
                            d.this.iXe.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.iXo);
                            d.this.mTitleView.setText(d.this.iXm);
                        }
                    }
                }
            });
        }
    }

    private boolean aJ(bj bjVar) {
        if (bjVar == null || this.iXl == null || !bjVar.aDb() || StringUtils.isNull(bjVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bjVar.getTid();
        this.iXl.append((CharSequence) bjVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new an("c12841").cy("obj_source", "3"));
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
        bj ckv;
        bf bfVar;
        Layout c;
        SpannableString aH;
        if (eVar != null && (ckv = eVar.ckv()) != null && ckv.aCF() != null) {
            ckv.aDk();
            this.iXl = new SpannableStringBuilder(ckv.aCV());
            boolean aJ = aJ(ckv);
            VideoInfo aCF = ckv.aCF();
            if (!StringUtils.isNull(aCF.mcn_lead_page) && !aJ) {
                this.iXj = true;
            } else {
                this.iXj = false;
            }
            if (this.iXl != null && !this.iXj && !aJ && (aH = am.aH(ckv)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aH.getSpans(0, aH.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.iXk = aVarArr[0];
                }
                this.iXl.append((CharSequence) aH);
            }
            if (this.iXk != null && this.iXl != null && (c = am.c(this.iXl)) != null && c.getLineCount() > 10) {
                int spanStart = this.iXl.getSpanStart(this.iXk);
                int spanEnd = this.iXl.getSpanEnd(this.iXk);
                if (spanStart > 0) {
                    this.iXl.delete(spanStart, spanEnd);
                }
            }
            if (this.iXj) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, ckv.aCV().toString(), aCF.mcn_lead_page, ckv.getTid());
            } else {
                this.mTitleView.setText(this.iXl);
            }
            this.mTitleView.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.iXn = new com.baidu.tieba.view.h(this.iXl);
            this.mTitleView.setOnTouchListener(this.iXn);
            this.iXe.setOnClickListener(this.mOnClickListener);
            this.iXd.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), aq.numberUniformFormatExtra(aCF.play_count.intValue())));
            if (eVar.ckT() && eVar.aHL()) {
                if (TextUtils.isEmpty(str)) {
                    str = ckv.aCt();
                }
                if (TextUtils.isEmpty(str) && (bfVar = (bf) v.getItem(eVar.ckO(), 0)) != null) {
                    str = bfVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.iXg.setVisibility(0);
                    this.iXf.setVisibility(0);
                    this.iXf.setOnClickListener(this.mOnClickListener);
                    this.iXf.setText(am.Gc(str));
                    this.iXf.setTag(str);
                } else {
                    this.iXf.setVisibility(8);
                    this.iXg.setVisibility(8);
                }
                this.iXc.setVisibility(8);
                this.iXh.setData(eVar, ckv.aEa());
            } else {
                this.iXg.setVisibility(8);
                this.iXf.setVisibility(8);
                this.iXc.setVisibility(0);
                this.iXc.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), aq.numberUniformFormatExtra(ckv.aCf())));
                this.iXh.setVisibility(8);
            }
            aMC();
        }
    }

    public void aMC() {
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iXe, R.color.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iXc, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iXd, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iXf, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setImageResource(this.iXg, R.drawable.icon_common_arrow20_right_n);
        if (this.iXh != null) {
            this.iXh.aMC();
        }
    }
}
