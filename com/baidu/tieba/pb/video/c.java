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
    private boolean lvF;
    public View mRootView;
    public TextView mTitleView;
    public TextView miN;
    public TextView miO;
    public TextView miP;
    private TextView miQ;
    private TbImageView miR;
    private ThreadAgreeAndShareLayout miS;
    private boolean miT;
    private boolean miU;
    private com.baidu.tbadk.core.view.a.a miV;
    private SpannableStringBuilder miW;
    private SpannableStringBuilder miX;
    private View.OnTouchListener miY;
    private View.OnTouchListener miZ;
    private com.baidu.tbadk.widget.richText.f mja = new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.pb.video.c.3
        @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            c.this.lvF = true;
            c.this.mTitleView.setMaxLines(10);
            c.this.mTitleView.setOnTouchListener(new i(c.this.miW));
            c.this.mTitleView.setText(c.this.miW);
            c.this.miP.setVisibility(0);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.miQ) {
                Object tag = c.this.miQ.getTag();
                Context context = view.getContext();
                if ((tag instanceof String) && context != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                }
            } else if (view == c.this.miP) {
                c.this.lvF = false;
                c.this.mTitleView.setOnTouchListener(c.this.miZ);
                c.this.mTitleView.setText(c.this.miX);
                c.this.miP.setVisibility(8);
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
            this.miN = (TextView) this.mRootView.findViewById(R.id.pb_video_replay_num);
            this.miO = (TextView) this.mRootView.findViewById(R.id.pb_video_play_count);
            this.miP = (TextView) this.mRootView.findViewById(R.id.view_video_title_up);
            this.miQ = (TextView) this.mRootView.findViewById(R.id.pb_video_forum);
            this.miS = (ThreadAgreeAndShareLayout) this.mRootView.findViewById(R.id.pb_video_act);
            this.miR = (TbImageView) this.mRootView.findViewById(R.id.arrow_right);
            this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.video.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Layout layout;
                    int ellipsisCount;
                    Object[] spans;
                    if (c.this.mTitleView != null && c.this.miW != null && !c.this.miU && (layout = c.this.mTitleView.getLayout()) != null) {
                        if (c.this.lvF) {
                            if (!c.this.miT) {
                                int lineCount = layout.getLineCount();
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.miP.getLayoutParams();
                                if (layout.getLineWidth(lineCount - 1) + c.this.miP.getWidth() > layout.getWidth()) {
                                    layoutParams.addRule(3, R.id.view_video_title);
                                    layoutParams.addRule(8, 0);
                                } else {
                                    layoutParams.addRule(8, R.id.view_video_title);
                                    layoutParams.addRule(3, 0);
                                }
                                c.this.miP.setLayoutParams(layoutParams);
                                c.this.miT = true;
                                return;
                            }
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                            if (c.this.miX == null) {
                                String spannableStringBuilder = c.this.miW.toString();
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder, au.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                                int length = cutChineseAndEnglishWithSuffix.length();
                                c.this.miX = new SpannableStringBuilder();
                                c.this.miX.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                for (Object obj : c.this.miW.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = c.this.miW.getSpanStart(obj);
                                    int spanEnd = c.this.miW.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        c.this.miX.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                SpannableString spannableString = new SpannableString("...展开");
                                spannableString.setSpan(c.this.mja, 0, spannableString.length(), 17);
                                c.this.miX.insert(length, (CharSequence) spannableString);
                                c.this.miZ = new i(c.this.miX);
                            }
                            c.this.miP.setVisibility(8);
                            c.this.mTitleView.setOnTouchListener(c.this.miZ);
                            c.this.mTitleView.setText(c.this.miX);
                        }
                    }
                }
            });
        }
    }

    private boolean aP(cb cbVar) {
        if (cbVar == null || this.miW == null || !cbVar.boF() || StringUtils.isNull(cbVar.getTid())) {
            return false;
        }
        final String str = com.baidu.tbadk.core.sharedPref.b.brQ().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + cbVar.getTid();
        this.miW.append((CharSequence) cbVar.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.pb.video.c.2
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
        cb dlg;
        bx bxVar;
        Layout i;
        SpannableString aN;
        if (fVar != null && (dlg = fVar.dlg()) != null && dlg.boh() != null) {
            dlg.boQ();
            this.miW = new SpannableStringBuilder(dlg.boz());
            boolean aP = aP(dlg);
            VideoInfo boh = dlg.boh();
            if (!StringUtils.isNull(boh.mcn_lead_page) && !aP) {
                this.miU = true;
            } else {
                this.miU = false;
            }
            if (this.miW != null && !this.miU && !aP && (aN = ao.aN(dlg)) != null) {
                com.baidu.tbadk.core.view.a.a[] aVarArr = (com.baidu.tbadk.core.view.a.a[]) aN.getSpans(0, aN.length(), com.baidu.tbadk.core.view.a.a.class);
                if (aVarArr != null && aVarArr.length > 0) {
                    this.miV = aVarArr[0];
                }
                this.miW.append((CharSequence) aN);
            }
            if (this.miV != null && this.miW != null && (i = ao.i(this.miW)) != null && i.getLineCount() > 10) {
                int spanStart = this.miW.getSpanStart(this.miV);
                int spanEnd = this.miW.getSpanEnd(this.miV);
                if (spanStart > 0) {
                    this.miW.delete(spanStart, spanEnd);
                }
            }
            if (this.miU) {
                com.baidu.tieba.pb.video.a.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mTitleView, dlg.boz().toString(), boh.mcn_lead_page, dlg.getTid());
            } else {
                this.mTitleView.setText(this.miW);
            }
            this.mTitleView.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            this.miY = new i(this.miW);
            this.mTitleView.setOnTouchListener(this.miY);
            this.miP.setOnClickListener(this.mOnClickListener);
            this.miO.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), au.numberUniformFormatExtra(boh.play_count.intValue())));
            if (fVar.dlJ() && fVar.dlG()) {
                if (TextUtils.isEmpty(str)) {
                    str = dlg.bnU();
                }
                if (TextUtils.isEmpty(str) && (bxVar = (bx) y.getItem(fVar.dlD(), 0)) != null) {
                    str = bxVar.forumName;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.miR.setVisibility(0);
                    this.miQ.setVisibility(0);
                    this.miQ.setOnClickListener(this.mOnClickListener);
                    this.miQ.setText(ao.PG(str));
                    this.miQ.setTag(str);
                } else {
                    this.miQ.setVisibility(8);
                    this.miR.setVisibility(8);
                }
                this.miN.setVisibility(8);
                this.miS.setData(fVar, dlg.bpJ());
            } else {
                this.miR.setVisibility(8);
                this.miQ.setVisibility(8);
                this.miN.setVisibility(0);
                this.miN.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), au.numberUniformFormatExtra(dlg.bnH())));
                this.miS.setVisibility(8);
            }
            bzn();
        }
    }

    public void bzn() {
        ap.setViewTextColor(this.miP, R.color.CAM_X0304, 1);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.miN, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.miO, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.miQ, R.color.CAM_X0107, 1);
        ap.setImageResource(this.miR, R.drawable.icon_common_arrow20_right_n);
        if (this.miS != null) {
            this.miS.bzn();
        }
    }
}
