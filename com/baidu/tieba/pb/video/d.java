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
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout;
import com.baidu.tieba.view.i;
import tbclient.VideoInfo;
/* loaded from: classes16.dex */
public class d {
    private boolean jTf;
    private View.OnTouchListener kEA;
    public TextView kEo;
    public TextView kEp;
    public TextView kEq;
    private TextView kEr;
    private TbImageView kEs;
    private ThreadAgreeAndShareLayout kEt;
    private boolean kEu;
    private boolean kEv;
    private com.baidu.tbadk.core.view.a.a kEw;
    private SpannableStringBuilder kEx;
    private SpannableStringBuilder kEy;
    private View.OnTouchListener kEz;
    public View mRootView;
    public TextView mTitleView;
    private com.baidu.tbadk.widget.richText.f kEB = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.d.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.this.jTf = true;
            d.this.mTitleView.setMaxLines(10);
            d.this.mTitleView.setOnTouchListener(new i(d.this.kEx));
            d.this.mTitleView.setText(d.this.kEx);
            d.this.kEq.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.kEr) {
                Object tag = d.this.kEr.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == d.this.kEq) {
                d.this.jTf = false;
                d.this.mTitleView.setOnTouchListener(d.this.kEA);
                d.this.mTitleView.setText(d.this.kEy);
                d.this.kEq.setVisibility(8);
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
            this.kEo = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.kEp = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.kEq = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.kEr = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.kEt = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.kEs = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (d.this.mTitleView != null && d.this.kEx != null && !d.this.kEv && (layout = d.this.mTitleView.getLayout()) != null) {
                        if (d.this.jTf) {
                            if (!d.this.kEu) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.kEq.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + d.this.kEq.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                d.this.kEq.setLayoutParams(layoutParams);
                                d.this.kEu = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (d.this.kEy == null) {
                                String spannableStringBuilder = d.this.kEx.toString();
                                String cutChineseAndEnglishWithSuffix = as.cutChineseAndEnglishWithSuffix(spannableStringBuilder, as.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                d.this.kEy = new SpannableStringBuilder();
                                d.this.kEy.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : d.this.kEx.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = d.this.kEx.getSpanStart(obj);
                                    int spanEnd = d.this.kEx.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        d.this.kEy.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(d.this.kEB, 0, spannableString.length(), 17);
                                d.this.kEy.insert(length, (CharSequence) spannableString);
                                d.this.kEA = new i(d.this.kEy);
                            }
                            d.this.kEq.setVisibility(8);
                            d.this.mTitleView.setOnTouchListener(d.this.kEA);
                            d.this.mTitleView.setText(d.this.kEy);
                        }
                    }
                }
            });
        }
    }

    private boolean aJ(bv bvVar) {
        if (bvVar == null || this.kEx == null || !bvVar.aXb() || StringUtils.isNull(bvVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.aZP().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bvVar.getTid();
        this.kEx.append((CharSequence) bvVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.d.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new ap("c12841").dn("obj_source", "3"));
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
        bv cKx;
        br brVar;
        Layout c;
        SpannableString aH;
        if (fVar != null && (cKx = fVar.cKx()) != null && cKx.aWD() != null) {
            cKx.aXk();
            this.kEx = new SpannableStringBuilder(cKx.aWV());
            boolean aJ = aJ(cKx);
            VideoInfo aWD = cKx.aWD();
            if (!StringUtils.isNull(aWD.mcn_lead_page) && !aJ) {
                this.kEv = true;
            } else {
                this.kEv = false;
            }
            if (this.kEx != null && !this.kEv && !aJ && (aH = ay.aH(cKx)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aH.getSpans(0, aH.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.kEw = aVarArr[0];
                }
                this.kEx.append((CharSequence) aH);
            }
            if (this.kEw != null && this.kEx != null && (c = ay.c(this.kEx)) != null && c.getLineCount() > 10) {
                int spanStart = this.kEx.getSpanStart(this.kEw);
                int spanEnd = this.kEx.getSpanEnd(this.kEw);
                if (spanStart > 0) {
                    this.kEx.delete(spanStart, spanEnd);
                }
            }
            if (this.kEv) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, cKx.aWV().toString(), aWD.mcn_lead_page, cKx.getTid());
            } else {
                this.mTitleView.setText(this.kEx);
            }
            this.mTitleView.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
            this.kEz = new i(this.kEx);
            this.mTitleView.setOnTouchListener(this.kEz);
            this.kEq.setOnClickListener(this.mOnClickListener);
            this.kEp.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), as.numberUniformFormatExtra(aWD.play_count.intValue())));
            if (fVar.cLa() && fVar.cKX()) {
                if (TextUtils.isEmpty(str)) {
                    str = cKx.aWp();
                }
                if (TextUtils.isEmpty(str) && (brVar = (br) x.getItem(fVar.cKU(), 0)) != null) {
                    str = brVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.kEs.setVisibility(0);
                    this.kEr.setVisibility(0);
                    this.kEr.setOnClickListener(this.mOnClickListener);
                    this.kEr.setText(ay.KN(str));
                    this.kEr.setTag(str);
                } else {
                    this.kEr.setVisibility(8);
                    this.kEs.setVisibility(8);
                }
                this.kEo.setVisibility(8);
                this.kEt.setData(fVar, cKx.aYc());
            } else {
                this.kEs.setVisibility(8);
                this.kEr.setVisibility(8);
                this.kEo.setVisibility(0);
                this.kEo.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), as.numberUniformFormatExtra(cKx.aWc())));
                this.kEt.setVisibility(8);
            }
            bgV();
        }
    }

    public void bgV() {
        ao.setViewTextColor(this.kEq, R.color.cp_link_tip_c, 1);
        ao.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        ao.setViewTextColor(this.kEo, R.color.cp_cont_j, 1);
        ao.setViewTextColor(this.kEp, R.color.cp_cont_j, 1);
        ao.setViewTextColor(this.kEr, R.color.cp_cont_j, 1);
        ao.setImageResource(this.kEs, R.drawable.icon_common_arrow20_right_n);
        if (this.kEt != null) {
            this.kEt.bgV();
        }
    }
}
