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
    public TextView mdY;
    public TextView mdZ;
    public TextView mea;
    private TextView meb;
    private TbImageView mec;
    private ThreadAgreeAndShareLayout med;
    private boolean mee;
    private boolean mef;
    private com.baidu.tbadk.core.view.a.a meg;
    private SpannableStringBuilder meh;
    private SpannableStringBuilder mei;
    private View.OnTouchListener mej;
    private View.OnTouchListener mek;
    private com.baidu.tbadk.widget.richText.f mel = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.c.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            c.this.lrU = true;
            c.this.mTitleView.setMaxLines(10);
            c.this.mTitleView.setOnTouchListener(new i(c.this.meh));
            c.this.mTitleView.setText(c.this.meh);
            c.this.mea.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.meb) {
                Object tag = c.this.meb.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == c.this.mea) {
                c.this.lrU = false;
                c.this.mTitleView.setOnTouchListener(c.this.mek);
                c.this.mTitleView.setText(c.this.mei);
                c.this.mea.setVisibility(8);
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
            this.mdY = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.mdZ = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.mea = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.meb = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.med = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.mec = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (c.this.mTitleView != null && c.this.meh != null && !c.this.mef && (layout = c.this.mTitleView.getLayout()) != null) {
                        if (c.this.lrU) {
                            if (!c.this.mee) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.mea.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + c.this.mea.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                c.this.mea.setLayoutParams(layoutParams);
                                c.this.mee = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (c.this.mei == null) {
                                String spannableStringBuilder = c.this.meh.toString();
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder, at.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                c.this.mei = new SpannableStringBuilder();
                                c.this.mei.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : c.this.meh.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = c.this.meh.getSpanStart(obj);
                                    int spanEnd = c.this.meh.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        c.this.mei.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(c.this.mel, 0, spannableString.length(), 17);
                                c.this.mei.insert(length, (CharSequence) spannableString);
                                c.this.mek = new i(c.this.mei);
                            }
                            c.this.mea.setVisibility(8);
                            c.this.mTitleView.setOnTouchListener(c.this.mek);
                            c.this.mTitleView.setText(c.this.mei);
                        }
                    }
                }
            });
        }
    }

    private boolean aO(bz bzVar) {
        if (bzVar == null || this.meh == null || !bzVar.bsh() || StringUtils.isNull(bzVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.bvr().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bzVar.getTid();
        this.meh.append((CharSequence) bzVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.c.2
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
        bz dmF;
        bv bvVar;
        Layout f;
        SpannableString aM;
        if (fVar != null && (dmF = fVar.dmF()) != null && dmF.brI() != null) {
            dmF.bss();
            this.meh = new SpannableStringBuilder(dmF.bsa());
            boolean aO = aO(dmF);
            VideoInfo brI = dmF.brI();
            if (!StringUtils.isNull(brI.mcn_lead_page) && !aO) {
                this.mef = true;
            } else {
                this.mef = false;
            }
            if (this.meh != null && !this.mef && !aO && (aM = ao.aM(dmF)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aM.getSpans(0, aM.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.meg = aVarArr[0];
                }
                this.meh.append((CharSequence) aM);
            }
            if (this.meg != null && this.meh != null && (f = ao.f(this.meh)) != null && f.getLineCount() > 10) {
                int spanStart = this.meh.getSpanStart(this.meg);
                int spanEnd = this.meh.getSpanEnd(this.meg);
                if (spanStart > 0) {
                    this.meh.delete(spanStart, spanEnd);
                }
            }
            if (this.mef) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, dmF.bsa().toString(), brI.mcn_lead_page, dmF.getTid());
            } else {
                this.mTitleView.setText(this.meh);
            }
            this.mTitleView.setLinkTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0304));
            this.mej = new i(this.meh);
            this.mTitleView.setOnTouchListener(this.mej);
            this.mea.setOnClickListener(this.mOnClickListener);
            this.mdZ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), at.numberUniformFormatExtra(brI.play_count.intValue())));
            if (fVar.dni() && fVar.dnf()) {
                if (TextUtils.isEmpty(str)) {
                    str = dmF.brv();
                }
                if (TextUtils.isEmpty(str) && (bvVar = (bv) x.getItem(fVar.dnc(), 0)) != null) {
                    str = bvVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.mec.setVisibility(0);
                    this.meb.setVisibility(0);
                    this.meb.setOnClickListener(this.mOnClickListener);
                    this.meb.setText(ao.PV(str));
                    this.meb.setTag(str);
                } else {
                    this.meb.setVisibility(8);
                    this.mec.setVisibility(8);
                }
                this.mdY.setVisibility(8);
                this.med.setData(fVar, dmF.btl());
            } else {
                this.mec.setVisibility(8);
                this.meb.setVisibility(8);
                this.mdY.setVisibility(0);
                this.mdY.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), at.numberUniformFormatExtra(dmF.bri())));
                this.med.setVisibility(8);
            }
            bCP();
        }
    }

    public void bCP() {
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.mea, R.color.CAM_X0304, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.mdY, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.mdZ, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.meb, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setImageResource(this.mec, R.drawable.icon_common_arrow20_right_n);
        if (this.med != null) {
            this.med.bCP();
        }
    }
}
