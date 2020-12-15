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
import com.baidu.tbadk.a.d;
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
import com.baidu.tieba.lego.card.d.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActionControl;
import tbclient.AdCloseInfo;
/* loaded from: classes26.dex */
public class AdCloseView extends FrameLayout {
    private long aZz;
    protected PopupWindow fWD;
    private PopupWindow.OnDismissListener fWO;
    protected View.OnClickListener fWt;
    protected int fWz;
    private int gZH;
    protected RelativeLayout ihc;
    private View mContentView;
    protected Context mContext;
    protected LinearLayout mNX;
    protected TBSpecificationBtn mNY;
    private b mNZ;
    protected EMTextView mOa;
    protected ImageView mOb;
    public ImageView mOc;
    public int mOd;
    private List<CheckBox> mOe;
    private AdvertAppInfo mOf;
    private ActionControl mOg;
    private List<String> mOh;
    private String mOi;
    private boolean mOj;
    private View.OnClickListener mOk;
    private View.OnClickListener mOl;
    private final CustomMessageListener mOm;
    private View.OnClickListener mOn;
    protected PopupWindow mPopupWindow;
    private String mTitle;
    protected TextView mTitleTextView;
    protected int mWindowHeight;
    protected int mWindowWidth;
    protected int mXOffset;
    protected int mYOffset;

    public AdCloseView(Context context) {
        super(context);
        this.mContext = null;
        this.mPopupWindow = null;
        this.fWD = null;
        this.mOd = R.drawable.icon_pure_card_close22;
        this.mOe = null;
        this.mOf = null;
        this.mOh = new ArrayList();
        this.aZz = 0L;
        this.mOj = false;
        this.fWt = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.aZz > 500) {
                    AdCloseView.this.ctt();
                    AdCloseView.this.aZz = currentTimeMillis;
                }
            }
        };
        this.mOk = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dGs = AdCloseView.this.dGs();
                if (dGs > 0) {
                    AdCloseView.this.mNY.setText(AdCloseView.this.mContext.getResources().getString(R.string.confirm));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = ap.getColor(R.color.CAM_X0105);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(dGs));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.mNY.setText(AdCloseView.this.mContext.getResources().getString(R.string.ad_no_interest));
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.mOl = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.mOf != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.mOf.eEd));
                    AdCloseView.this.bLq();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.gZH) {
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
                    httpMessage.addParam("ext", AdCloseView.this.mOf.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.fWO = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.fWD != null) {
                    AdCloseView.this.fWD.dismiss();
                    AdCloseView.this.fWD = null;
                }
            }
        };
        this.mOm = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.bLq();
            }
        };
        this.mOn = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.dGq();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mPopupWindow = null;
        this.fWD = null;
        this.mOd = R.drawable.icon_pure_card_close22;
        this.mOe = null;
        this.mOf = null;
        this.mOh = new ArrayList();
        this.aZz = 0L;
        this.mOj = false;
        this.fWt = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.aZz > 500) {
                    AdCloseView.this.ctt();
                    AdCloseView.this.aZz = currentTimeMillis;
                }
            }
        };
        this.mOk = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dGs = AdCloseView.this.dGs();
                if (dGs > 0) {
                    AdCloseView.this.mNY.setText(AdCloseView.this.mContext.getResources().getString(R.string.confirm));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = ap.getColor(R.color.CAM_X0105);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(dGs));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.mNY.setText(AdCloseView.this.mContext.getResources().getString(R.string.ad_no_interest));
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.mOl = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.mOf != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.mOf.eEd));
                    AdCloseView.this.bLq();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.gZH) {
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
                    httpMessage.addParam("ext", AdCloseView.this.mOf.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.fWO = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.fWD != null) {
                    AdCloseView.this.fWD.dismiss();
                    AdCloseView.this.fWD = null;
                }
            }
        };
        this.mOm = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.bLq();
            }
        };
        this.mOn = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.dGq();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mPopupWindow = null;
        this.fWD = null;
        this.mOd = R.drawable.icon_pure_card_close22;
        this.mOe = null;
        this.mOf = null;
        this.mOh = new ArrayList();
        this.aZz = 0L;
        this.mOj = false;
        this.fWt = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.aZz > 500) {
                    AdCloseView.this.ctt();
                    AdCloseView.this.aZz = currentTimeMillis;
                }
            }
        };
        this.mOk = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dGs = AdCloseView.this.dGs();
                if (dGs > 0) {
                    AdCloseView.this.mNY.setText(AdCloseView.this.mContext.getResources().getString(R.string.confirm));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = ap.getColor(R.color.CAM_X0105);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(dGs));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.mNY.setText(AdCloseView.this.mContext.getResources().getString(R.string.ad_no_interest));
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.mOl = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.mOf != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.mOf.eEd));
                    AdCloseView.this.bLq();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.gZH) {
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
                    httpMessage.addParam("ext", AdCloseView.this.mOf.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.fWO = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.fWD != null) {
                    AdCloseView.this.fWD.dismiss();
                    AdCloseView.this.fWD = null;
                }
            }
        };
        this.mOm = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.bLq();
            }
        };
        this.mOn = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.dGq();
            }
        };
        this.mContext = context;
        init();
    }

    protected void init() {
        this.mOc = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.tbds72), getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
        layoutParams.gravity = 21;
        addView(this.mOc, layoutParams);
        this.mXOffset = d.bkA() ? l.getDimens(this.mContext, R.dimen.M_W_X007) : l.getDimens(this.mContext, R.dimen.M_W_X004);
        this.mYOffset = l.getDimens(this.mContext, R.dimen.ds10);
        this.mWindowHeight = l.getDimens(this.mContext, R.dimen.ds278);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.fWz = l.getDimens(this.mContext, R.dimen.ds120);
        setOnClickListener(this.fWt);
        this.mOc.setImageDrawable(WebPManager.a(this.mOd, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.ad_close_popupwindow, (ViewGroup) null);
        this.mTitleTextView = (TextView) inflate.findViewById(R.id.head_text);
        this.ihc = (RelativeLayout) inflate.findViewById(R.id.top_area);
        View findViewById = inflate.findViewById(R.id.ad_show_reason_wrapper);
        this.mOa = (EMTextView) inflate.findViewById(R.id.ad_show_reason);
        this.mOb = (ImageView) inflate.findViewById(R.id.arrow_right);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
        }
        this.mNY = (TBSpecificationBtn) inflate.findViewById(R.id.forbid_thread_btn);
        this.mNZ = new b();
        this.mNZ.rh(R.color.CAM_X0304);
        this.mNY.setConfig(this.mNZ);
        if (!TextUtils.isEmpty(this.mOi)) {
            this.mNY.setText(this.mOi);
        } else {
            this.mNY.setText(this.mContext.getResources().getString(R.string.ad_no_interest));
        }
        this.mNY.setOnClickListener(this.mOl);
        if (dGr()) {
            this.mOa.setText(this.mOg.name);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this.mOn);
        }
        ap.setViewTextColor(this.mTitleTextView, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.mOa, R.color.CAM_X0107, 1);
        this.mOb.setImageDrawable(ap.getDrawable(R.drawable.icon_ad_dislike_arrow20_right_n));
        this.mNX = (LinearLayout) inflate.findViewById(R.id.reason_root_container);
        this.mOe = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctt() {
        if (this.mContext != null) {
            bLq();
            View contentView = getContentView();
            dGp();
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
            this.mPopupWindow.setOnDismissListener(this.fWO);
            if (Build.VERSION.SDK_INT >= 22) {
                this.mPopupWindow.setAttachedInDecor(false);
            }
            if (!this.mOj) {
                MessageManager.getInstance().registerListener(this.mOm);
                this.mOj = true;
            }
            this.fWD = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.fWD.setFocusable(false);
            this.fWD.setTouchable(false);
            if (Build.VERSION.SDK_INT >= 22) {
                this.fWD.setAttachedInDecor(false);
            }
            this.fWD.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a2 = a(this.mContext, this, this.mWindowHeight, this.mWindowWidth, this.fWz, this.mYOffset, iArr);
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

    private void dGp() {
        if (!a.isEmpty(this.mOh)) {
            int eN = a.eN(this.mOh);
            this.mNX.setVisibility(0);
            int i = 0;
            for (int i2 = 0; i2 < Math.ceil(eN / 2.0d); i2++) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ad_close_row_view, (ViewGroup) null);
                linearLayout.setOrientation(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 1;
                if (i2 != 0) {
                    layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.M_H_X003);
                }
                linearLayout.setLayoutParams(layoutParams);
                this.mNX.addView(linearLayout);
                int i3 = 0;
                while (true) {
                    if (i3 >= linearLayout.getChildCount()) {
                        break;
                    }
                    int i4 = i + 1;
                    if (i4 > eN) {
                        i = i4;
                        break;
                    }
                    CheckBox checkBox = (CheckBox) linearLayout.getChildAt(i3);
                    checkBox.setOnClickListener(this.mOk);
                    checkBox.setVisibility(0);
                    a.a(this.mOe, checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < a.eN(this.mOh); i5++) {
                String str = (String) a.l(this.mOh, i5);
                CheckBox checkBox2 = (CheckBox) a.l(this.mOe, i5);
                if (checkBox2 != null) {
                    checkBox2.setText(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLq() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.fWD != null) {
            this.fWD.dismiss();
            this.fWD = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mOj) {
            MessageManager.getInstance().unRegisterListener(this.mOm);
            this.mOj = false;
        }
        if (this.fWD != null) {
            if (this.mPopupWindow == null || !this.mPopupWindow.isShowing()) {
                this.fWD.dismiss();
                this.fWD = null;
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
            this.mOf = advertAppInfo;
            a.clear(this.mOh);
            if (this.mOf.eEm != null && this.mOf.eEm.adCloseInfo != null) {
                AdCloseInfo adCloseInfo = this.mOf.eEm.adCloseInfo;
                this.mOg = adCloseInfo.action_control;
                for (String str : adCloseInfo.reasons) {
                    a.a(this.mOh, str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(R.string.tell_us_reason);
                }
                this.mOi = adCloseInfo.confirm_title;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGq() {
        if (dGr()) {
            com.baidu.tieba.ad.a.bMn().c(getContext(), new String[]{this.mOg.url});
        }
    }

    private boolean dGr() {
        return (this.mOg == null || TextUtils.isEmpty(this.mOg.url) || TextUtils.isEmpty(this.mOg.name)) ? false : true;
    }

    public void setPage(int i) {
        this.gZH = i;
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
        this.mOc.setImageDrawable(WebPManager.a(this.mOd, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.mOf == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!a.isEmpty(this.mOe)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= a.eN(this.mOe)) {
                    break;
                }
                CheckBox checkBox = (CheckBox) a.l(this.mOe, i2);
                if (checkBox != null && checkBox.isChecked() && a.eN(this.mOh) > i2) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append((String) a.l(this.mOh, i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dGs() {
        if (a.isEmpty(this.mOe)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < a.eN(this.mOe); i2++) {
            CheckBox checkBox = (CheckBox) a.l(this.mOe, i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
