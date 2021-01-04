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
    private boolean lrU;
    public View mRootView;
    public TextView mTitleView;
    public TextView mdZ;
    public TextView mea;
    public TextView meb;
    private TextView mec;
    private TbImageView med;
    private ThreadAgreeAndShareLayout mee;
    private boolean mef;
    private boolean meg;
    private com.baidu.tbadk.core.view.a.a meh;
    private SpannableStringBuilder mei;
    private SpannableStringBuilder mej;
    private View.OnTouchListener mek;
    private View.OnTouchListener mel;
    private com.baidu.tbadk.widget.richText.f men = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.c.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            c.this.lrU = true;
            c.this.mTitleView.setMaxLines(10);
            c.this.mTitleView.setOnTouchListener(new i(c.this.mei));
            c.this.mTitleView.setText(c.this.mei);
            c.this.meb.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.mec) {
                Object tag = c.this.mec.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == c.this.meb) {
                c.this.lrU = false;
                c.this.mTitleView.setOnTouchListener(c.this.mel);
                c.this.mTitleView.setText(c.this.mej);
                c.this.meb.setVisibility(8);
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
            this.mdZ = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.mea = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.meb = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.mec = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.mee = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.med = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (c.this.mTitleView != null && c.this.mei != null && !c.this.meg && (layout = c.this.mTitleView.getLayout()) != null) {
                        if (c.this.lrU) {
                            if (!c.this.mef) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.meb.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + c.this.meb.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                c.this.meb.setLayoutParams(layoutParams);
                                c.this.mef = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (c.this.mej == null) {
                                String spannableStringBuilder = c.this.mei.toString();
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder, at.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                c.this.mej = new SpannableStringBuilder();
                                c.this.mej.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : c.this.mei.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = c.this.mei.getSpanStart(obj);
                                    int spanEnd = c.this.mei.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        c.this.mej.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(c.this.men, 0, spannableString.length(), 17);
                                c.this.mej.insert(length, (CharSequence) spannableString);
                                c.this.mel = new i(c.this.mej);
                            }
                            c.this.meb.setVisibility(8);
                            c.this.mTitleView.setOnTouchListener(c.this.mel);
                            c.this.mTitleView.setText(c.this.mej);
                        }
                    }
                }
            });
        }
    }

    private boolean aO(bz bzVar) {
        if (bzVar == null || this.mei == null || !bzVar.bsg() || StringUtils.isNull(bzVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.bvq().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bzVar.getTid();
        this.mei.append((CharSequence) bzVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.c.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                TiebaStatic.log(new aq("c12841").dX("obj_source", "3"));
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
        bz dmE;
        bv bvVar;
        Layout f;
        SpannableString aM;
        if (fVar != null && (dmE = fVar.dmE()) != null && dmE.brH() != null) {
            dmE.bsr();
            this.mei = new SpannableStringBuilder(dmE.brZ());
            boolean aO = aO(dmE);
            VideoInfo brH = dmE.brH();
            if (!StringUtils.isNull(brH.mcn_lead_page) && !aO) {
                this.meg = true;
            } else {
                this.meg = false;
            }
            if (this.mei != null && !this.meg && !aO && (aM = ao.aM(dmE)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aM.getSpans(0, aM.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.meh = aVarArr[0];
                }
                this.mei.append((CharSequence) aM);
            }
            if (this.meh != null && this.mei != null && (f = ao.f(this.mei)) != null && f.getLineCount() > 10) {
                int spanStart = this.mei.getSpanStart(this.meh);
                int spanEnd = this.mei.getSpanEnd(this.meh);
                if (spanStart > 0) {
                    this.mei.delete(spanStart, spanEnd);
                }
            }
            if (this.meg) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, dmE.brZ().toString(), brH.mcn_lead_page, dmE.getTid());
            } else {
                this.mTitleView.setText(this.mei);
            }
            this.mTitleView.setLinkTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0304));
            this.mek = new i(this.mei);
            this.mTitleView.setOnTouchListener(this.mek);
            this.meb.setOnClickListener(this.mOnClickListener);
            this.mea.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), at.numberUniformFormatExtra(brH.play_count.intValue())));
            if (fVar.dnh() && fVar.dne()) {
                if (TextUtils.isEmpty(str)) {
                    str = dmE.bru();
                }
                if (TextUtils.isEmpty(str) && (bvVar = (bv) x.getItem(fVar.dnb(), 0)) != null) {
                    str = bvVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.med.setVisibility(0);
                    this.mec.setVisibility(0);
                    this.mec.setOnClickListener(this.mOnClickListener);
                    this.mec.setText(ao.PW(str));
                    this.mec.setTag(str);
                } else {
                    this.mec.setVisibility(8);
                    this.med.setVisibility(8);
                }
                this.mdZ.setVisibility(8);
                this.mee.setData(fVar, dmE.btk());
            } else {
                this.med.setVisibility(8);
                this.mec.setVisibility(8);
                this.mdZ.setVisibility(0);
                this.mdZ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), at.numberUniformFormatExtra(dmE.brh())));
                this.mee.setVisibility(8);
            }
            bCO();
        }
    }

    public void bCO() {
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.meb, R.color.CAM_X0304, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.mdZ, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.mea, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.mec, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setImageResource(this.med, R.drawable.icon_common_arrow20_right_n);
        if (this.mee != null) {
            this.mee.bCO();
        }
    }
}
