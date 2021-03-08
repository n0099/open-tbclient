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
    private boolean lxH;
    public View mRootView;
    public TextView mTitleView;
    public TextView mkP;
    public TextView mkQ;
    public TextView mkR;
    private TextView mkS;
    private TbImageView mkT;
    private ThreadAgreeAndShareLayout mkU;
    private boolean mkV;
    private boolean mkW;
    private com.baidu.tbadk.core.view.a.a mkX;
    private SpannableStringBuilder mkY;
    private SpannableStringBuilder mkZ;
    private View.OnTouchListener mla;
    private View.OnTouchListener mlb;
    private com.baidu.tbadk.widget.richText.f mlc = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.c.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            c.this.lxH = true;
            c.this.mTitleView.setMaxLines(10);
            c.this.mTitleView.setOnTouchListener(new i(c.this.mkY));
            c.this.mTitleView.setText(c.this.mkY);
            c.this.mkR.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.mkS) {
                Object tag = c.this.mkS.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == c.this.mkR) {
                c.this.lxH = false;
                c.this.mTitleView.setOnTouchListener(c.this.mlb);
                c.this.mTitleView.setText(c.this.mkZ);
                c.this.mkR.setVisibility(8);
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
            this.mkP = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.mkQ = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.mkR = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.mkS = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.mkU = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.mkT = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (c.this.mTitleView != null && c.this.mkY != null && !c.this.mkW && (layout = c.this.mTitleView.getLayout()) != null) {
                        if (c.this.lxH) {
                            if (!c.this.mkV) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.mkR.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + c.this.mkR.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                c.this.mkR.setLayoutParams(layoutParams);
                                c.this.mkV = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (c.this.mkZ == null) {
                                String spannableStringBuilder = c.this.mkY.toString();
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder, au.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                c.this.mkZ = new SpannableStringBuilder();
                                c.this.mkZ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : c.this.mkY.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = c.this.mkY.getSpanStart(obj);
                                    int spanEnd = c.this.mkY.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        c.this.mkZ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(c.this.mlc, 0, spannableString.length(), 17);
                                c.this.mkZ.insert(length, (CharSequence) spannableString);
                                c.this.mlb = new i(c.this.mkZ);
                            }
                            c.this.mkR.setVisibility(8);
                            c.this.mTitleView.setOnTouchListener(c.this.mlb);
                            c.this.mTitleView.setText(c.this.mkZ);
                        }
                    }
                }
            });
        }
    }

    private boolean aP(cb cbVar) {
        if (cbVar == null || this.mkY == null || !cbVar.boH() || StringUtils.isNull(cbVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.brR().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + cbVar.getTid();
        this.mkY.append((CharSequence) cbVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.c.2
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
        cb dlp;
        bx bxVar;
        Layout i;
        SpannableString aN;
        if (fVar != null && (dlp = fVar.dlp()) != null && dlp.boj() != null) {
            dlp.boS();
            this.mkY = new SpannableStringBuilder(dlp.boB());
            boolean aP = aP(dlp);
            VideoInfo boj = dlp.boj();
            if (!StringUtils.isNull(boj.mcn_lead_page) && !aP) {
                this.mkW = true;
            } else {
                this.mkW = false;
            }
            if (this.mkY != null && !this.mkW && !aP && (aN = ao.aN(dlp)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aN.getSpans(0, aN.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.mkX = aVarArr[0];
                }
                this.mkY.append((CharSequence) aN);
            }
            if (this.mkX != null && this.mkY != null && (i = ao.i(this.mkY)) != null && i.getLineCount() > 10) {
                int spanStart = this.mkY.getSpanStart(this.mkX);
                int spanEnd = this.mkY.getSpanEnd(this.mkX);
                if (spanStart > 0) {
                    this.mkY.delete(spanStart, spanEnd);
                }
            }
            if (this.mkW) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, dlp.boB().toString(), boj.mcn_lead_page, dlp.getTid());
            } else {
                this.mTitleView.setText(this.mkY);
            }
            this.mTitleView.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            this.mla = new i(this.mkY);
            this.mTitleView.setOnTouchListener(this.mla);
            this.mkR.setOnClickListener(this.mOnClickListener);
            this.mkQ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), au.numberUniformFormatExtra(boj.play_count.intValue())));
            if (fVar.dlS() && fVar.dlP()) {
                if (TextUtils.isEmpty(str)) {
                    str = dlp.bnW();
                }
                if (TextUtils.isEmpty(str) && (bxVar = (bx) y.getItem(fVar.dlM(), 0)) != null) {
                    str = bxVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.mkT.setVisibility(0);
                    this.mkS.setVisibility(0);
                    this.mkS.setOnClickListener(this.mOnClickListener);
                    this.mkS.setText(ao.PM(str));
                    this.mkS.setTag(str);
                } else {
                    this.mkS.setVisibility(8);
                    this.mkT.setVisibility(8);
                }
                this.mkP.setVisibility(8);
                this.mkU.setData(fVar, dlp.bpL());
            } else {
                this.mkT.setVisibility(8);
                this.mkS.setVisibility(8);
                this.mkP.setVisibility(0);
                this.mkP.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), au.numberUniformFormatExtra(dlp.bnJ())));
                this.mkU.setVisibility(8);
            }
            bzq();
        }
    }

    public void bzq() {
        ap.setViewTextColor(this.mkR, R.color.CAM_X0304, 1);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.mkP, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.mkQ, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.mkS, R.color.CAM_X0107, 1);
        ap.setImageResource(this.mkT, R.drawable.icon_common_arrow20_right_n);
        if (this.mkU != null) {
            this.mkU.bzq();
        }
    }
}
