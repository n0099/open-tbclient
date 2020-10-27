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
/* loaded from: classes22.dex */
public class d {
    private boolean kSQ;
    private TbImageView lEA;
    private ThreadAgreeAndShareLayout lEB;
    private boolean lEC;
    private boolean lED;
    private com.baidu.tbadk.core.view.a.a lEE;
    private SpannableStringBuilder lEF;
    private SpannableStringBuilder lEG;
    private View.OnTouchListener lEH;
    private View.OnTouchListener lEI;
    public TextView lEw;
    public TextView lEx;
    public TextView lEy;
    private TextView lEz;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f lEJ = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.kSQ = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new i(d.this.lEF));
            d.this.mTitleView.setText(d.this.lEF);
            d.this.lEy.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.lEz) {
                Object tag = d.this.lEz.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.lEy) {
                d.this.kSQ = false;
                d.this.mTitleView.setOnTouchListener(d.this.lEI);
                d.this.mTitleView.setText(d.this.lEG);
                d.this.lEy.setVisibility(8);
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
            this.lEw = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.lEx = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.lEy = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.lEz = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.lEB = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.lEA = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.lEF != null && !d.this.lED && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.kSQ) {
                            if (!d.this.lEC) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.lEy.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.lEy.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.lEy.setLayoutParams(layoutParams);
                                d.this.lEC = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.lEG == null) {
                                String spannableStringBuilder = d.this.lEF.toString();
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder, at.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.lEG = new SpannableStringBuilder();
                                d.this.lEG.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.lEF.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.lEF.getSpanStart(obj);
                                    int spanEnd = d.this.lEF.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.lEG.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.lEJ, 0, spannableString.length(), 17);
                                d.this.lEG.insert(length, (CharSequence) spannableString);
                                d.this.lEI = new i(d.this.lEG);
                            }
                            d.this.lEy.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.lEI);
                            d.this.mTitleView.setText(d.this.lEG);
                        }
                    }
                }
            });
        }
    }

    private boolean aL(bw bwVar) {
        if (bwVar == null || this.lEF == null || !bwVar.bkQ() || StringUtils.isNull(bwVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.bnH().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bwVar.getTid();
        this.lEF.append((CharSequence) bwVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new aq("c12841").dR("obj_source", "3"));
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
        bw dfI;
        bs bsVar;
        Layout d;
        SpannableString aJ;
        if (fVar != null && (dfI = fVar.dfI()) != null && dfI.bks() != null) {
            dfI.bkZ();
            this.lEF = new SpannableStringBuilder(dfI.bkK());
            boolean aL = aL(dfI);
            VideoInfo bks = dfI.bks();
            if (!StringUtils.isNull(bks.mcn_lead_page) && !aL) {
                this.lED = true;
            } else {
                this.lED = false;
            }
            if (this.lEF != null && !this.lED && !aL && (aJ = ay.aJ(dfI)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aJ.getSpans(0, aJ.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.lEE = aVarArr[0];
                }
                this.lEF.append((CharSequence) aJ);
            }
            if (this.lEE != null && this.lEF != null && (d = ay.d(this.lEF)) != null && d.getLineCount() > 10) {
                int spanStart = this.lEF.getSpanStart(this.lEE);
                int spanEnd = this.lEF.getSpanEnd(this.lEE);
                if (spanStart > 0) {
                    this.lEF.delete(spanStart, spanEnd);
                }
            }
            if (this.lED) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, dfI.bkK().toString(), bks.mcn_lead_page, dfI.getTid());
            } else {
                this.mTitleView.setText(this.lEF);
            }
            this.mTitleView.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            this.lEH = new i(this.lEF);
            this.mTitleView.setOnTouchListener(this.lEH);
            this.lEy.setOnClickListener(this.mOnClickListener);
            this.lEx.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), at.numberUniformFormatExtra(bks.play_count.intValue())));
            if (fVar.dgl() && fVar.dgi()) {
                if (TextUtils.isEmpty(str)) {
                    str = dfI.bke();
                }
                if (TextUtils.isEmpty(str) && (bsVar = (bs) y.getItem(fVar.dgf(), 0)) != null) {
                    str = bsVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.lEA.setVisibility(0);
                    this.lEz.setVisibility(0);
                    this.lEz.setOnClickListener(this.mOnClickListener);
                    this.lEz.setText(ay.Pv(str));
                    this.lEz.setTag(str);
                } else {
                    this.lEz.setVisibility(8);
                    this.lEA.setVisibility(8);
                }
                this.lEw.setVisibility(8);
                this.lEB.setData(fVar, dfI.blR());
            } else {
                this.lEA.setVisibility(8);
                this.lEz.setVisibility(8);
                this.lEw.setVisibility(0);
                this.lEw.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), at.numberUniformFormatExtra(dfI.bjR())));
                this.lEB.setVisibility(8);
            }
            bvf();
        }
    }

    public void bvf() {
        ap.setViewTextColor(this.lEy, R.color.cp_link_tip_c, 1);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.lEw, R.color.cp_cont_j, 1);
        ap.setViewTextColor(this.lEx, R.color.cp_cont_j, 1);
        ap.setViewTextColor(this.lEz, R.color.cp_cont_j, 1);
        ap.setImageResource(this.lEA, R.drawable.icon_common_arrow20_right_n);
        if (this.lEB != null) {
            this.lEB.bvf();
        }
    }
}
