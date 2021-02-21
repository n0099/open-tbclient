package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.c.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActionControl;
import tbclient.AdCloseInfo;
/* loaded from: classes8.dex */
public class AdCloseView extends FrameLayout {
    private long aZy;
    private int cdp;
    protected View.OnClickListener gdK;
    protected int gdQ;
    protected PopupWindow gdU;
    private PopupWindow.OnDismissListener gef;
    protected RelativeLayout iuI;
    private View mContentView;
    protected Context mContext;
    protected PopupWindow mPopupWindow;
    private String mTitle;
    protected TextView mTitleTextView;
    protected int mWindowHeight;
    protected int mWindowWidth;
    protected int mXOffset;
    protected ImageView mYA;
    public ImageView mYB;
    public int mYC;
    private List<CheckBox> mYD;
    private AdvertAppInfo mYE;
    private ActionControl mYF;
    private List<String> mYG;
    private String mYH;
    private boolean mYI;
    private View.OnClickListener mYJ;
    private View.OnClickListener mYK;
    private final CustomMessageListener mYL;
    private View.OnClickListener mYM;
    protected int mYOffset;
    protected LinearLayout mYw;
    protected TBSpecificationBtn mYx;
    private b mYy;
    protected EMTextView mYz;

    public AdCloseView(Context context) {
        super(context);
        this.mContext = null;
        this.mPopupWindow = null;
        this.gdU = null;
        this.mYC = R.drawable.icon_pure_card_close22;
        this.mYD = null;
        this.mYE = null;
        this.mYG = new ArrayList();
        this.aZy = 0L;
        this.mYI = false;
        this.gdK = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.aZy > 500) {
                    AdCloseView.this.ctO();
                    AdCloseView.this.aZy = currentTimeMillis;
                }
            }
        };
        this.mYJ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dEH = AdCloseView.this.dEH();
                if (dEH > 0) {
                    AdCloseView.this.mYx.setText(AdCloseView.this.mContext.getResources().getString(R.string.confirm));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = ap.getColor(R.color.CAM_X0105);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(dEH));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.mYx.setText(AdCloseView.this.mContext.getResources().getString(R.string.ad_no_interest));
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.mYK = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.mYE != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.mYE.eLt));
                    AdCloseView.this.bKq();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.cdp) {
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
                    httpMessage.addParam("ext", AdCloseView.this.mYE.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.gef = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.gdU != null) {
                    AdCloseView.this.gdU.dismiss();
                    AdCloseView.this.gdU = null;
                }
            }
        };
        this.mYL = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.bKq();
            }
        };
        this.mYM = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.dEF();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mPopupWindow = null;
        this.gdU = null;
        this.mYC = R.drawable.icon_pure_card_close22;
        this.mYD = null;
        this.mYE = null;
        this.mYG = new ArrayList();
        this.aZy = 0L;
        this.mYI = false;
        this.gdK = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.aZy > 500) {
                    AdCloseView.this.ctO();
                    AdCloseView.this.aZy = currentTimeMillis;
                }
            }
        };
        this.mYJ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dEH = AdCloseView.this.dEH();
                if (dEH > 0) {
                    AdCloseView.this.mYx.setText(AdCloseView.this.mContext.getResources().getString(R.string.confirm));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = ap.getColor(R.color.CAM_X0105);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(dEH));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.mYx.setText(AdCloseView.this.mContext.getResources().getString(R.string.ad_no_interest));
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.mYK = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.mYE != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.mYE.eLt));
                    AdCloseView.this.bKq();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.cdp) {
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
                    httpMessage.addParam("ext", AdCloseView.this.mYE.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.gef = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.gdU != null) {
                    AdCloseView.this.gdU.dismiss();
                    AdCloseView.this.gdU = null;
                }
            }
        };
        this.mYL = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.bKq();
            }
        };
        this.mYM = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.dEF();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mPopupWindow = null;
        this.gdU = null;
        this.mYC = R.drawable.icon_pure_card_close22;
        this.mYD = null;
        this.mYE = null;
        this.mYG = new ArrayList();
        this.aZy = 0L;
        this.mYI = false;
        this.gdK = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.aZy > 500) {
                    AdCloseView.this.ctO();
                    AdCloseView.this.aZy = currentTimeMillis;
                }
            }
        };
        this.mYJ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dEH = AdCloseView.this.dEH();
                if (dEH > 0) {
                    AdCloseView.this.mYx.setText(AdCloseView.this.mContext.getResources().getString(R.string.confirm));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = ap.getColor(R.color.CAM_X0105);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(dEH));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.mYx.setText(AdCloseView.this.mContext.getResources().getString(R.string.ad_no_interest));
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.mYK = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.mYE != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.mYE.eLt));
                    AdCloseView.this.bKq();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.cdp) {
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
                    httpMessage.addParam("ext", AdCloseView.this.mYE.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.gef = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.gdU != null) {
                    AdCloseView.this.gdU.dismiss();
                    AdCloseView.this.gdU = null;
                }
            }
        };
        this.mYL = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.bKq();
            }
        };
        this.mYM = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.dEF();
            }
        };
        this.mContext = context;
        init();
    }

    protected void init() {
        this.mYB = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.tbds72), getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
        layoutParams.gravity = 21;
        addView(this.mYB, layoutParams);
        this.mXOffset = l.getDimens(this.mContext, R.dimen.M_W_X004);
        this.mYOffset = l.getDimens(this.mContext, R.dimen.ds10);
        this.mWindowHeight = l.getDimens(this.mContext, R.dimen.ds278);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.gdQ = l.getDimens(this.mContext, R.dimen.ds120);
        setOnClickListener(this.gdK);
        this.mYB.setImageDrawable(WebPManager.a(this.mYC, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.ad_close_popupwindow, (ViewGroup) null);
        this.mTitleTextView = (TextView) inflate.findViewById(R.id.head_text);
        this.iuI = (RelativeLayout) inflate.findViewById(R.id.top_area);
        View findViewById = inflate.findViewById(R.id.ad_show_reason_wrapper);
        this.mYz = (EMTextView) inflate.findViewById(R.id.ad_show_reason);
        this.mYA = (ImageView) inflate.findViewById(R.id.arrow_right);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
        }
        this.mYx = (TBSpecificationBtn) inflate.findViewById(R.id.forbid_thread_btn);
        this.mYy = new b();
        this.mYy.pR(R.color.CAM_X0304);
        this.mYx.setConfig(this.mYy);
        if (!TextUtils.isEmpty(this.mYH)) {
            this.mYx.setText(this.mYH);
        } else {
            this.mYx.setText(this.mContext.getResources().getString(R.string.ad_no_interest));
        }
        this.mYx.setOnClickListener(this.mYK);
        if (dEG()) {
            this.mYz.setText(this.mYF.name);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this.mYM);
        }
        ap.setViewTextColor(this.mTitleTextView, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.mYz, R.color.CAM_X0107, 1);
        this.mYA.setImageDrawable(ap.getDrawable(R.drawable.icon_ad_dislike_arrow20_right_n));
        this.mYw = (LinearLayout) inflate.findViewById(R.id.reason_root_container);
        this.mYD = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctO() {
        if (this.mContext != null) {
            bKq();
            View contentView = getContentView();
            dEE();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(ap.getColor(R.color.CAM_X0204));
            gradientDrawable.setCornerRadius(l.getDimens(this.mContext, R.dimen.tbds31));
            this.mContentView.setBackgroundDrawable(gradientDrawable);
            this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.gef);
            if (Build.VERSION.SDK_INT >= 22) {
                this.mPopupWindow.setAttachedInDecor(false);
            }
            if (!this.mYI) {
                MessageManager.getInstance().registerListener(this.mYL);
                this.mYI = true;
            }
            this.gdU = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.gdU.setFocusable(false);
            this.gdU.setTouchable(false);
            if (Build.VERSION.SDK_INT >= 22) {
                this.gdU.setAttachedInDecor(false);
            }
            this.gdU.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a2 = a(this.mContext, this, this.mWindowHeight, this.mWindowWidth, this.gdQ, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
                if (a2) {
                    this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                } else {
                    this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
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
            return this.mContentView.getMeasuredHeight();
        } catch (Exception e) {
            return 0;
        }
    }

    private void dEE() {
        if (!a.isEmpty(this.mYG)) {
            int eL = a.eL(this.mYG);
            this.mYw.setVisibility(0);
            int i = 0;
            for (int i2 = 0; i2 < Math.ceil(eL / 2.0d); i2++) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ad_close_row_view, (ViewGroup) null);
                linearLayout.setOrientation(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 1;
                if (i2 != 0) {
                    layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.M_H_X003);
                }
                linearLayout.setLayoutParams(layoutParams);
                this.mYw.addView(linearLayout);
                int i3 = i;
                for (int i4 = 0; i4 < linearLayout.getChildCount() && (i3 = i3 + 1) <= eL; i4++) {
                    CheckBox checkBox = (CheckBox) linearLayout.getChildAt(i4);
                    checkBox.setOnClickListener(this.mYJ);
                    checkBox.setVisibility(0);
                    a.a(this.mYD, checkBox);
                }
                i = i3;
            }
            for (int i5 = 0; i5 < a.eL(this.mYG); i5++) {
                String str = (String) a.l(this.mYG, i5);
                CheckBox checkBox2 = (CheckBox) a.l(this.mYD, i5);
                if (checkBox2 != null) {
                    checkBox2.setText(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKq() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.gdU != null) {
            this.gdU.dismiss();
            this.gdU = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mYI) {
            MessageManager.getInstance().unRegisterListener(this.mYL);
            this.mYI = false;
        }
        if (this.gdU != null) {
            if (this.mPopupWindow == null || !this.mPopupWindow.isShowing()) {
                this.gdU.dismiss();
                this.gdU = null;
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
            this.mYE = advertAppInfo;
            a.clear(this.mYG);
            if (this.mYE.eLC != null && this.mYE.eLC.adCloseInfo != null) {
                AdCloseInfo adCloseInfo = this.mYE.eLC.adCloseInfo;
                this.mYF = adCloseInfo.action_control;
                for (String str : adCloseInfo.reasons) {
                    a.a(this.mYG, str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(R.string.tell_us_reason);
                }
                this.mYH = adCloseInfo.confirm_title;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEF() {
        if (dEG()) {
            com.baidu.tieba.ad.a.bLn().a(getContext(), new String[]{this.mYF.url}, null);
        }
    }

    private boolean dEG() {
        return (this.mYF == null || TextUtils.isEmpty(this.mYF.url) || TextUtils.isEmpty(this.mYF.name)) ? false : true;
    }

    public void setPage(int i) {
        this.cdp = i;
    }

    public int getCloseViewWidth() {
        return l.getDimens(this.mContext, R.dimen.tbds72);
    }

    public int getCloseViewHeight() {
        return l.getDimens(this.mContext, R.dimen.tbds72);
    }

    public View getAdCloseView() {
        return this;
    }

    public void onChangeSkinType() {
        this.mYB.setImageDrawable(WebPManager.a(this.mYC, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.mYE == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!a.isEmpty(this.mYD)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= a.eL(this.mYD)) {
                    break;
                }
                CheckBox checkBox = (CheckBox) a.l(this.mYD, i2);
                if (checkBox != null && checkBox.isChecked() && a.eL(this.mYG) > i2) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append((String) a.l(this.mYG, i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dEH() {
        if (a.isEmpty(this.mYD)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < a.eL(this.mYD); i2++) {
            CheckBox checkBox = (CheckBox) a.l(this.mYD, i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
