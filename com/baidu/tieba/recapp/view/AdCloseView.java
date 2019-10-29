package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActionControl;
import tbclient.AdCloseInfo;
/* loaded from: classes3.dex */
public class AdCloseView extends FrameLayout {
    private int dRY;
    private long dcM;
    private RotateAnimation dcO;
    private RotateAnimation dcP;
    protected View.OnClickListener dcQ;
    protected int dcU;
    protected int dcW;
    protected PopupWindow dcZ;
    private PopupWindow.OnDismissListener ddg;
    protected RelativeLayout eKs;
    protected TextView fIx;
    protected LinearLayout iOm;
    protected TextView iOn;
    protected ImageView iOo;
    protected ImageView iOp;
    private List<CheckBox> iOq;
    private AdvertAppInfo iOr;
    private ActionControl iOs;
    private List<String> iOt;
    private String iOu;
    private boolean iOv;
    private View.OnClickListener iOw;
    private View.OnClickListener iOx;
    private final CustomMessageListener iOy;
    private View.OnClickListener iOz;
    private View mContentView;
    protected Context mContext;
    protected PopupWindow mPopupWindow;
    private String mTitle;
    protected TextView mTitleTextView;
    protected int mWindowHeight;
    protected int mXOffset;
    protected int mYOffset;

    public AdCloseView(Context context) {
        super(context);
        this.mContext = null;
        this.mPopupWindow = null;
        this.dcZ = null;
        this.iOq = null;
        this.iOr = null;
        this.iOt = new ArrayList();
        this.dcM = 0L;
        this.iOv = false;
        this.dcQ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.dcM > 500) {
                    AdCloseView.this.bwE();
                    AdCloseView.this.dcM = currentTimeMillis;
                }
            }
        };
        this.iOw = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int cgU = AdCloseView.this.cgU();
                if (cgU > 0) {
                    AdCloseView.this.fIx.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = am.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(cgU));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.fIx.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.iOx = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.iOr != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.iOr.bXk));
                    AdCloseView.this.aBO();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.dRY) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                        case 4:
                            httpMessage.addParam("pi", "1527489263072");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.iOr.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.ddg = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.dcZ != null) {
                    AdCloseView.this.dcZ.dismiss();
                    AdCloseView.this.dcZ = null;
                }
            }
        };
        this.iOy = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.aBO();
            }
        };
        this.iOz = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.cgS();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mPopupWindow = null;
        this.dcZ = null;
        this.iOq = null;
        this.iOr = null;
        this.iOt = new ArrayList();
        this.dcM = 0L;
        this.iOv = false;
        this.dcQ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.dcM > 500) {
                    AdCloseView.this.bwE();
                    AdCloseView.this.dcM = currentTimeMillis;
                }
            }
        };
        this.iOw = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int cgU = AdCloseView.this.cgU();
                if (cgU > 0) {
                    AdCloseView.this.fIx.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = am.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(cgU));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.fIx.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.iOx = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.iOr != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.iOr.bXk));
                    AdCloseView.this.aBO();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.dRY) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                        case 4:
                            httpMessage.addParam("pi", "1527489263072");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.iOr.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.ddg = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.dcZ != null) {
                    AdCloseView.this.dcZ.dismiss();
                    AdCloseView.this.dcZ = null;
                }
            }
        };
        this.iOy = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.aBO();
            }
        };
        this.iOz = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.cgS();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mPopupWindow = null;
        this.dcZ = null;
        this.iOq = null;
        this.iOr = null;
        this.iOt = new ArrayList();
        this.dcM = 0L;
        this.iOv = false;
        this.dcQ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.dcM > 500) {
                    AdCloseView.this.bwE();
                    AdCloseView.this.dcM = currentTimeMillis;
                }
            }
        };
        this.iOw = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int cgU = AdCloseView.this.cgU();
                if (cgU > 0) {
                    AdCloseView.this.fIx.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = am.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(cgU));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.fIx.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.iOx = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.iOr != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.iOr.bXk));
                    AdCloseView.this.aBO();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.dRY) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                        case 4:
                            httpMessage.addParam("pi", "1527489263072");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.iOr.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.ddg = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.dcZ != null) {
                    AdCloseView.this.dcZ.dismiss();
                    AdCloseView.this.dcZ = null;
                }
            }
        };
        this.iOy = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.aBO();
            }
        };
        this.iOz = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.cgS();
            }
        };
        this.mContext = context;
        init();
    }

    protected void init() {
        this.iOp = new ImageView(getContext());
        this.iOp.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.iOp, layoutParams);
        this.mXOffset = l.getDimens(this.mContext, R.dimen.ds32);
        this.mYOffset = l.getDimens(this.mContext, R.dimen.ds10);
        this.mWindowHeight = l.getDimens(this.mContext, R.dimen.ds278);
        this.dcU = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.dcW = l.getDimens(this.mContext, R.dimen.ds120);
        setOnClickListener(this.dcQ);
        SvgManager.amN().a(this.iOp, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_d, null);
        aBP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aBP() {
        this.dcO = new RotateAnimation(0.0f, 135.0f, 1, 0.5f, 1, 0.5f);
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
        this.dcO.setInterpolator(overshootInterpolator);
        this.dcO.setDuration(250L);
        this.dcO.setFillAfter(true);
        this.dcP = new RotateAnimation(135.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.dcP.setInterpolator(overshootInterpolator);
        this.dcP.setDuration(250L);
        this.dcP.setFillAfter(true);
    }

    private void setCWRotateAnimation() {
        if (this.iOp != null) {
            this.iOp.clearAnimation();
            this.iOp.startAnimation(this.dcO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setACRotateAnimation() {
        if (this.iOp != null) {
            this.iOp.clearAnimation();
            this.iOp.startAnimation(this.dcP);
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.ad_close_popupwindow, (ViewGroup) null);
        this.mTitleTextView = (TextView) inflate.findViewById(R.id.head_text);
        this.eKs = (RelativeLayout) inflate.findViewById(R.id.top_area);
        View findViewById = inflate.findViewById(R.id.ad_show_reason_wrapper);
        this.iOn = (TextView) inflate.findViewById(R.id.ad_show_reason);
        this.iOo = (ImageView) inflate.findViewById(R.id.arrow_right);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
        }
        this.fIx = (TextView) inflate.findViewById(R.id.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.iOu)) {
            this.fIx.setText(this.iOu);
        }
        this.fIx.setOnClickListener(this.iOx);
        if (cgT()) {
            this.iOn.setText(this.iOs.name);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this.iOz);
        }
        am.setViewTextColor(this.mTitleTextView, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fIx, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.iOn, R.color.cp_other_i, 1);
        am.setBackgroundResource(this.fIx, R.drawable.bg_blue_rec_n);
        this.iOo.setImageDrawable(am.getDrawable(R.drawable.icon_ad_dislike_arrow20_right_n));
        this.iOm = (LinearLayout) inflate.findViewById(R.id.reason_root_container);
        this.iOq = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwE() {
        if (this.mContext != null) {
            aBO();
            setCWRotateAnimation();
            View contentView = getContentView();
            cgR();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.mPopupWindow = new PopupWindow(contentView, this.dcU, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.ddg);
            if (Build.VERSION.SDK_INT >= 22) {
                this.mPopupWindow.setAttachedInDecor(false);
            }
            if (!this.iOv) {
                MessageManager.getInstance().registerListener(this.iOy);
                this.iOv = true;
            }
            this.dcZ = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.dcZ.setFocusable(false);
            this.dcZ.setTouchable(false);
            if (Build.VERSION.SDK_INT >= 22) {
                this.dcZ.setAttachedInDecor(false);
            }
            this.dcZ.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.dcU, this.dcW, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                    am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_down);
                    if (this.eKs != null && this.eKs.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.eKs.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                    }
                } else {
                    this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                    am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_up);
                    if (this.eKs != null && this.eKs.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.eKs.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds84);
                    }
                }
                this.mPopupWindow.showAtLocation(getRootView(), 0, iArr[0] - this.mXOffset, iArr[1]);
            }
        }
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        try {
            this.mContentView.measure(0, 0);
            return this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        } catch (Exception e) {
            return 0;
        }
    }

    private void cgR() {
        if (this.iOt != null && this.iOt.size() > 0) {
            int size = this.iOt.size();
            this.iOm.setVisibility(0);
            int i = 0;
            for (int i2 = 0; i2 < Math.ceil(size / 2.0d); i2++) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ad_close_row_view, (ViewGroup) null);
                linearLayout.setOrientation(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 1;
                if (i2 != 0) {
                    layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                }
                linearLayout.setLayoutParams(layoutParams);
                this.iOm.addView(linearLayout);
                int i3 = 0;
                while (true) {
                    if (i3 >= linearLayout.getChildCount()) {
                        break;
                    }
                    int i4 = i + 1;
                    if (i4 > size) {
                        i = i4;
                        break;
                    }
                    CheckBox checkBox = (CheckBox) linearLayout.getChildAt(i3);
                    checkBox.setOnClickListener(this.iOw);
                    checkBox.setVisibility(0);
                    this.iOq.add(checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < this.iOt.size(); i5++) {
                this.iOq.get(i5).setText(this.iOt.get(i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBO() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.dcZ != null) {
            this.dcZ.dismiss();
            this.dcZ = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.iOv) {
            MessageManager.getInstance().unRegisterListener(this.iOy);
            this.iOv = false;
        }
        if (this.dcZ != null) {
            if (this.mPopupWindow == null || !this.mPopupWindow.isShowing()) {
                this.dcZ.dismiss();
                this.dcZ = null;
            }
        }
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int equipmentHeight = l.getEquipmentHeight(context);
        int equipmentWidth = l.getEquipmentWidth(context);
        boolean z = ((equipmentHeight - iArr2[1]) - height) - i3 < i;
        iArr[0] = equipmentWidth - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    public void setData(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null) {
            this.iOr = advertAppInfo;
            this.iOt.clear();
            if (this.iOr.bXu != null && this.iOr.bXu.adCloseInfo != null) {
                AdCloseInfo adCloseInfo = this.iOr.bXu.adCloseInfo;
                this.iOs = adCloseInfo.action_control;
                for (String str : adCloseInfo.reasons) {
                    this.iOt.add(str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(R.string.tell_us_reason);
                }
                this.iOu = adCloseInfo.confirm_title;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgS() {
        if (cgT()) {
            a.aDy().c(getContext(), new String[]{this.iOs.url});
        }
    }

    private boolean cgT() {
        return (this.iOs == null || TextUtils.isEmpty(this.iOs.url) || TextUtils.isEmpty(this.iOs.name)) ? false : true;
    }

    public void setPage(int i) {
        this.dRY = i;
    }

    public int getCloseViewWidth() {
        return l.getDimens(this.mContext, R.dimen.ds96);
    }

    public int getCloseViewHeight() {
        return l.getDimens(this.mContext, R.dimen.ds26);
    }

    public View getAdCloseView() {
        return this;
    }

    public void onChangeSkinType() {
        SvgManager.amN().a(this.iOp, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_d, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.iOr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.isEmpty(this.iOq)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iOq.size()) {
                    break;
                }
                CheckBox checkBox = this.iOq.get(i2);
                if (checkBox != null && checkBox.isChecked() && this.iOt != null && this.iOt.size() > i2) {
                    if (sb.length() != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append(this.iOt.get(i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cgU() {
        if (v.isEmpty(this.iOq)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.iOq.size(); i2++) {
            CheckBox checkBox = this.iOq.get(i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
