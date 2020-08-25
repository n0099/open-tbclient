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
    public TextView kTV;
    public TextView kTW;
    public TextView kTX;
    private TextView kTY;
    private TbImageView kTZ;
    private ThreadAgreeAndShareLayout kUa;
    private boolean kUb;
    private boolean kUc;
    private com.baidu.tbadk.core.view.a.a kUd;
    private SpannableStringBuilder kUe;
    private SpannableStringBuilder kUf;
    private View.OnTouchListener kUg;
    private View.OnTouchListener kUh;
    private boolean kiB;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f kUi = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.kiB = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new i(d.this.kUe));
            d.this.mTitleView.setText(d.this.kUe);
            d.this.kTX.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.kTY) {
                Object tag = d.this.kTY.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.kTX) {
                d.this.kiB = false;
                d.this.mTitleView.setOnTouchListener(d.this.kUh);
                d.this.mTitleView.setText(d.this.kUf);
                d.this.kTX.setVisibility(8);
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
            this.kTV = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.kTW = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.kTX = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.kTY = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.kUa = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.kTZ = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.kUe != null && !d.this.kUc && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.kiB) {
                            if (!d.this.kUb) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.kTX.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.kTX.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.kTX.setLayoutParams(layoutParams);
                                d.this.kUb = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.kUf == null) {
                                String spannableStringBuilder = d.this.kUe.toString();
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder, at.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.kUf = new SpannableStringBuilder();
                                d.this.kUf.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.kUe.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.kUe.getSpanStart(obj);
                                    int spanEnd = d.this.kUe.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.kUf.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.kUi, 0, spannableString.length(), 17);
                                d.this.kUf.insert(length, (CharSequence) spannableString);
                                d.this.kUh = new i(d.this.kUf);
                            }
                            d.this.kTX.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.kUh);
                            d.this.mTitleView.setText(d.this.kUf);
                        }
                    }
                }
            });
        }
    }

    private boolean aK(bw bwVar) {
        if (bwVar == null || this.kUe == null || !bwVar.bfu() || StringUtils.isNull(bwVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.bik().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bwVar.getTid();
        this.kUe.append((CharSequence) bwVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
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
        bw cVl;
        bs bsVar;
        Layout c;
        SpannableString aI;
        if (fVar != null && (cVl = fVar.cVl()) != null && cVl.beW() != null) {
            cVl.bfD();
            this.kUe = new SpannableStringBuilder(cVl.bfo());
            boolean aK = aK(cVl);
            VideoInfo beW = cVl.beW();
            if (!StringUtils.isNull(beW.mcn_lead_page) && !aK) {
                this.kUc = true;
            } else {
                this.kUc = false;
            }
            if (this.kUe != null && !this.kUc && !aK && (aI = ay.aI(cVl)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aI.getSpans(0, aI.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.kUd = aVarArr[0];
                }
                this.kUe.append((CharSequence) aI);
            }
            if (this.kUd != null && this.kUe != null && (c = ay.c(this.kUe)) != null && c.getLineCount() > 10) {
                int spanStart = this.kUe.getSpanStart(this.kUd);
                int spanEnd = this.kUe.getSpanEnd(this.kUd);
                if (spanStart > 0) {
                    this.kUe.delete(spanStart, spanEnd);
                }
            }
            if (this.kUc) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, cVl.bfo().toString(), beW.mcn_lead_page, cVl.getTid());
            } else {
                this.mTitleView.setText(this.kUe);
            }
            this.mTitleView.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            this.kUg = new i(this.kUe);
            this.mTitleView.setOnTouchListener(this.kUg);
            this.kTX.setOnClickListener(this.mOnClickListener);
            this.kTW.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), at.numberUniformFormatExtra(beW.play_count.intValue())));
            if (fVar.cVO() && fVar.cVL()) {
                if (TextUtils.isEmpty(str)) {
                    str = cVl.beI();
                }
                if (TextUtils.isEmpty(str) && (bsVar = (bs) y.getItem(fVar.cVI(), 0)) != null) {
                    str = bsVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.kTZ.setVisibility(0);
                    this.kTY.setVisibility(0);
                    this.kTY.setOnClickListener(this.mOnClickListener);
                    this.kTY.setText(ay.NG(str));
                    this.kTY.setTag(str);
                } else {
                    this.kTY.setVisibility(8);
                    this.kTZ.setVisibility(8);
                }
                this.kTV.setVisibility(8);
                this.kUa.setData(fVar, cVl.bgv());
            } else {
                this.kTZ.setVisibility(8);
                this.kTY.setVisibility(8);
                this.kTV.setVisibility(0);
                this.kTV.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), at.numberUniformFormatExtra(cVl.bev())));
                this.kUa.setVisibility(8);
            }
            bpH();
        }
    }

    public void bpH() {
        ap.setViewTextColor(this.kTX, R.color.cp_link_tip_c, 1);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.kTV, R.color.cp_cont_j, 1);
        ap.setViewTextColor(this.kTW, R.color.cp_cont_j, 1);
        ap.setViewTextColor(this.kTY, R.color.cp_cont_j, 1);
        ap.setImageResource(this.kTZ, R.drawable.icon_common_arrow20_right_n);
        if (this.kUa != null) {
            this.kUa.bpH();
        }
    }
}
