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
/* loaded from: classes16.dex */
public class d {
    public TextView kUc;
    public TextView kUd;
    public TextView kUe;
    private TextView kUf;
    private TbImageView kUg;
    private ThreadAgreeAndShareLayout kUh;
    private boolean kUi;
    private boolean kUj;
    private com.baidu.tbadk.core.view.a.a kUk;
    private SpannableStringBuilder kUl;
    private SpannableStringBuilder kUm;
    private View.OnTouchListener kUn;
    private View.OnTouchListener kUo;
    private boolean kiI;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f kUp = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.kiI = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new i(d.this.kUl));
            d.this.mTitleView.setText(d.this.kUl);
            d.this.kUe.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.kUf) {
                Object tag = d.this.kUf.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.kUe) {
                d.this.kiI = false;
                d.this.mTitleView.setOnTouchListener(d.this.kUo);
                d.this.mTitleView.setText(d.this.kUm);
                d.this.kUe.setVisibility(8);
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
            this.kUc = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.kUd = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.kUe = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.kUf = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.kUh = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.kUg = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.kUl != null && !d.this.kUj && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.kiI) {
                            if (!d.this.kUi) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.kUe.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.kUe.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.kUe.setLayoutParams(layoutParams);
                                d.this.kUi = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.kUm == null) {
                                String spannableStringBuilder = d.this.kUl.toString();
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder, at.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.kUm = new SpannableStringBuilder();
                                d.this.kUm.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.kUl.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.kUl.getSpanStart(obj);
                                    int spanEnd = d.this.kUl.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.kUm.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.kUp, 0, spannableString.length(), 17);
                                d.this.kUm.insert(length, (CharSequence) spannableString);
                                d.this.kUo = new i(d.this.kUm);
                            }
                            d.this.kUe.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.kUo);
                            d.this.mTitleView.setText(d.this.kUm);
                        }
                    }
                }
            });
        }
    }

    private boolean aK(bw bwVar) {
        if (bwVar == null || this.kUl == null || !bwVar.bfu() || StringUtils.isNull(bwVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.bik().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bwVar.getTid();
        this.kUl.append((CharSequence) bwVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new aq("c12841").dD("obj_source", "3"));
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
        bw cVm;
        bs bsVar;
        Layout c;
        SpannableString aI;
        if (fVar != null && (cVm = fVar.cVm()) != null && cVm.beW() != null) {
            cVm.bfD();
            this.kUl = new SpannableStringBuilder(cVm.bfo());
            boolean aK = aK(cVm);
            VideoInfo beW = cVm.beW();
            if (!StringUtils.isNull(beW.mcn_lead_page) && !aK) {
                this.kUj = true;
            } else {
                this.kUj = false;
            }
            if (this.kUl != null && !this.kUj && !aK && (aI = ay.aI(cVm)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aI.getSpans(0, aI.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.kUk = aVarArr[0];
                }
                this.kUl.append((CharSequence) aI);
            }
            if (this.kUk != null && this.kUl != null && (c = ay.c(this.kUl)) != null && c.getLineCount() > 10) {
                int spanStart = this.kUl.getSpanStart(this.kUk);
                int spanEnd = this.kUl.getSpanEnd(this.kUk);
                if (spanStart > 0) {
                    this.kUl.delete(spanStart, spanEnd);
                }
            }
            if (this.kUj) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, cVm.bfo().toString(), beW.mcn_lead_page, cVm.getTid());
            } else {
                this.mTitleView.setText(this.kUl);
            }
            this.mTitleView.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            this.kUn = new i(this.kUl);
            this.mTitleView.setOnTouchListener(this.kUn);
            this.kUe.setOnClickListener(this.mOnClickListener);
            this.kUd.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), at.numberUniformFormatExtra(beW.play_count.intValue())));
            if (fVar.cVP() && fVar.cVM()) {
                if (TextUtils.isEmpty(str)) {
                    str = cVm.beI();
                }
                if (TextUtils.isEmpty(str) && (bsVar = (bs) y.getItem(fVar.cVJ(), 0)) != null) {
                    str = bsVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.kUg.setVisibility(0);
                    this.kUf.setVisibility(0);
                    this.kUf.setOnClickListener(this.mOnClickListener);
                    this.kUf.setText(ay.NH(str));
                    this.kUf.setTag(str);
                } else {
                    this.kUf.setVisibility(8);
                    this.kUg.setVisibility(8);
                }
                this.kUc.setVisibility(8);
                this.kUh.setData(fVar, cVm.bgv());
            } else {
                this.kUg.setVisibility(8);
                this.kUf.setVisibility(8);
                this.kUc.setVisibility(0);
                this.kUc.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), at.numberUniformFormatExtra(cVm.bev())));
                this.kUh.setVisibility(8);
            }
            bpI();
        }
    }

    public void bpI() {
        ap.setViewTextColor(this.kUe, R.color.cp_link_tip_c, 1);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.kUc, R.color.cp_cont_j, 1);
        ap.setViewTextColor(this.kUd, R.color.cp_cont_j, 1);
        ap.setViewTextColor(this.kUf, R.color.cp_cont_j, 1);
        ap.setImageResource(this.kUg, R.drawable.icon_common_arrow20_right_n);
        if (this.kUh != null) {
            this.kUh.bpI();
        }
    }
}
