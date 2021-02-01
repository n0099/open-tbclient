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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout;
import com.baidu.tieba.view.i;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class c {
    private boolean lvr;
    public View mRootView;
    public TextView mTitleView;
    public TextView miA;
    private TextView miB;
    private TbImageView miC;
    private ThreadAgreeAndShareLayout miD;
    private boolean miE;
    private boolean miF;
    private com.baidu.tbadk.core.view.a.a miG;
    private SpannableStringBuilder miH;
    private SpannableStringBuilder miI;
    private View.OnTouchListener miJ;
    private View.OnTouchListener miK;
    public TextView miy;
    public TextView miz;
    private com.baidu.tbadk.widget.richText.f miL = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.c.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            c.this.lvr = true;
            c.this.mTitleView.setMaxLines(10);
            c.this.mTitleView.setOnTouchListener(new i(c.this.miH));
            c.this.mTitleView.setText(c.this.miH);
            c.this.miA.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.miB) {
                Object tag = c.this.miB.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == c.this.miA) {
                c.this.lvr = false;
                c.this.mTitleView.setOnTouchListener(c.this.miK);
                c.this.mTitleView.setText(c.this.miI);
                c.this.miA.setVisibility(8);
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
            this.miy = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.miz = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.miA = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.miB = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.miD = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.miC = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (c.this.mTitleView != null && c.this.miH != null && !c.this.miF && (layout = c.this.mTitleView.getLayout()) != null) {
                        if (c.this.lvr) {
                            if (!c.this.miE) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.miA.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + c.this.miA.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                c.this.miA.setLayoutParams(layoutParams);
                                c.this.miE = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (c.this.miI == null) {
                                String spannableStringBuilder = c.this.miH.toString();
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder, au.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                c.this.miI = new SpannableStringBuilder();
                                c.this.miI.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : c.this.miH.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = c.this.miH.getSpanStart(obj);
                                    int spanEnd = c.this.miH.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        c.this.miI.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(c.this.miL, 0, spannableString.length(), 17);
                                c.this.miI.insert(length, (CharSequence) spannableString);
                                c.this.miK = new i(c.this.miI);
                            }
                            c.this.miA.setVisibility(8);
                            c.this.mTitleView.setOnTouchListener(c.this.miK);
                            c.this.mTitleView.setText(c.this.miI);
                        }
                    }
                }
            });
        }
    }

    private boolean aP(cb cbVar) {
        if (cbVar == null || this.miH == null || !cbVar.boF() || StringUtils.isNull(cbVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.brQ().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + cbVar.getTid();
        this.miH.append((CharSequence) cbVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.c.2
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
        cb dkZ;
        bx bxVar;
        Layout i;
        SpannableString aN;
        if (fVar != null && (dkZ = fVar.dkZ()) != null && dkZ.boh() != null) {
            dkZ.boQ();
            this.miH = new SpannableStringBuilder(dkZ.boz());
            boolean aP = aP(dkZ);
            VideoInfo boh = dkZ.boh();
            if (!StringUtils.isNull(boh.mcn_lead_page) && !aP) {
                this.miF = true;
            } else {
                this.miF = false;
            }
            if (this.miH != null && !this.miF && !aP && (aN = ao.aN(dkZ)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aN.getSpans(0, aN.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.miG = aVarArr[0];
                }
                this.miH.append((CharSequence) aN);
            }
            if (this.miG != null && this.miH != null && (i = ao.i(this.miH)) != null && i.getLineCount() > 10) {
                int spanStart = this.miH.getSpanStart(this.miG);
                int spanEnd = this.miH.getSpanEnd(this.miG);
                if (spanStart > 0) {
                    this.miH.delete(spanStart, spanEnd);
                }
            }
            if (this.miF) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, dkZ.boz().toString(), boh.mcn_lead_page, dkZ.getTid());
            } else {
                this.mTitleView.setText(this.miH);
            }
            this.mTitleView.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            this.miJ = new i(this.miH);
            this.mTitleView.setOnTouchListener(this.miJ);
            this.miA.setOnClickListener(this.mOnClickListener);
            this.miz.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), au.numberUniformFormatExtra(boh.play_count.intValue())));
            if (fVar.dlC() && fVar.dlz()) {
                if (TextUtils.isEmpty(str)) {
                    str = dkZ.bnU();
                }
                if (TextUtils.isEmpty(str) && (bxVar = (bx) y.getItem(fVar.dlw(), 0)) != null) {
                    str = bxVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.miC.setVisibility(0);
                    this.miB.setVisibility(0);
                    this.miB.setOnClickListener(this.mOnClickListener);
                    this.miB.setText(ao.PF(str));
                    this.miB.setTag(str);
                } else {
                    this.miB.setVisibility(8);
                    this.miC.setVisibility(8);
                }
                this.miy.setVisibility(8);
                this.miD.setData(fVar, dkZ.bpJ());
            } else {
                this.miC.setVisibility(8);
                this.miB.setVisibility(8);
                this.miy.setVisibility(0);
                this.miy.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), au.numberUniformFormatExtra(dkZ.bnH())));
                this.miD.setVisibility(8);
            }
            bzn();
        }
    }

    public void bzn() {
        ap.setViewTextColor(this.miA, R.color.CAM_X0304, 1);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.miy, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.miz, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.miB, R.color.CAM_X0107, 1);
        ap.setImageResource(this.miC, R.drawable.icon_common_arrow20_right_n);
        if (this.miD != null) {
            this.miD.bzn();
        }
    }
}
