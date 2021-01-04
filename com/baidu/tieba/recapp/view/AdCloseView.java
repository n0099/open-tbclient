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
import com.baidu.tbadk.core.util.ao;
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
    private long bbg;
    private int cea;
    protected View.OnClickListener gfZ;
    protected int ggf;
    protected PopupWindow ggj;
    private PopupWindow.OnDismissListener ggu;
    protected RelativeLayout itx;
    private View mContentView;
    protected Context mContext;
    protected PopupWindow mPopupWindow;
    protected LinearLayout mTh;
    protected TBSpecificationBtn mTi;
    private String mTitle;
    protected TextView mTitleTextView;
    private b mTk;
    protected EMTextView mTl;
    protected ImageView mTm;
    public ImageView mTn;
    public int mTp;
    private List<CheckBox> mTq;
    private AdvertAppInfo mTr;
    private ActionControl mTs;
    private List<String> mTt;
    private String mTu;
    private boolean mTv;
    private View.OnClickListener mTw;
    private View.OnClickListener mTx;
    private final CustomMessageListener mTy;
    private View.OnClickListener mTz;
    protected int mWindowHeight;
    protected int mWindowWidth;
    protected int mXOffset;
    protected int mYOffset;

    public AdCloseView(Context context) {
        super(context);
        this.mContext = null;
        this.mPopupWindow = null;
        this.ggj = null;
        this.mTp = R.drawable.icon_pure_card_close22;
        this.mTq = null;
        this.mTr = null;
        this.mTt = new ArrayList();
        this.bbg = 0L;
        this.mTv = false;
        this.gfZ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.bbg > 500) {
                    AdCloseView.this.cwm();
                    AdCloseView.this.bbg = currentTimeMillis;
                }
            }
        };
        this.mTw = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dGh = AdCloseView.this.dGh();
                if (dGh > 0) {
                    AdCloseView.this.mTi.setText(AdCloseView.this.mContext.getResources().getString(R.string.confirm));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = ao.getColor(R.color.CAM_X0105);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(dGh));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.mTi.setText(AdCloseView.this.mContext.getResources().getString(R.string.ad_no_interest));
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.mTx = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.mTr != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.mTr.eNT));
                    AdCloseView.this.bNI();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.cea) {
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
                    httpMessage.addParam("ext", AdCloseView.this.mTr.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.ggu = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.ggj != null) {
                    AdCloseView.this.ggj.dismiss();
                    AdCloseView.this.ggj = null;
                }
            }
        };
        this.mTy = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.bNI();
            }
        };
        this.mTz = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.dGf();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mPopupWindow = null;
        this.ggj = null;
        this.mTp = R.drawable.icon_pure_card_close22;
        this.mTq = null;
        this.mTr = null;
        this.mTt = new ArrayList();
        this.bbg = 0L;
        this.mTv = false;
        this.gfZ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.bbg > 500) {
                    AdCloseView.this.cwm();
                    AdCloseView.this.bbg = currentTimeMillis;
                }
            }
        };
        this.mTw = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dGh = AdCloseView.this.dGh();
                if (dGh > 0) {
                    AdCloseView.this.mTi.setText(AdCloseView.this.mContext.getResources().getString(R.string.confirm));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = ao.getColor(R.color.CAM_X0105);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(dGh));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.mTi.setText(AdCloseView.this.mContext.getResources().getString(R.string.ad_no_interest));
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.mTx = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.mTr != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.mTr.eNT));
                    AdCloseView.this.bNI();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.cea) {
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
                    httpMessage.addParam("ext", AdCloseView.this.mTr.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.ggu = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.ggj != null) {
                    AdCloseView.this.ggj.dismiss();
                    AdCloseView.this.ggj = null;
                }
            }
        };
        this.mTy = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.bNI();
            }
        };
        this.mTz = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.dGf();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mPopupWindow = null;
        this.ggj = null;
        this.mTp = R.drawable.icon_pure_card_close22;
        this.mTq = null;
        this.mTr = null;
        this.mTt = new ArrayList();
        this.bbg = 0L;
        this.mTv = false;
        this.gfZ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.bbg > 500) {
                    AdCloseView.this.cwm();
                    AdCloseView.this.bbg = currentTimeMillis;
                }
            }
        };
        this.mTw = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dGh = AdCloseView.this.dGh();
                if (dGh > 0) {
                    AdCloseView.this.mTi.setText(AdCloseView.this.mContext.getResources().getString(R.string.confirm));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = ao.getColor(R.color.CAM_X0105);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(dGh));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.mTi.setText(AdCloseView.this.mContext.getResources().getString(R.string.ad_no_interest));
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.mTx = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.mTr != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.mTr.eNT));
                    AdCloseView.this.bNI();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.cea) {
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
                    httpMessage.addParam("ext", AdCloseView.this.mTr.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.ggu = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.ggj != null) {
                    AdCloseView.this.ggj.dismiss();
                    AdCloseView.this.ggj = null;
                }
            }
        };
        this.mTy = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.bNI();
            }
        };
        this.mTz = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.dGf();
            }
        };
        this.mContext = context;
        init();
    }

    protected void init() {
        this.mTn = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.tbds72), getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
        layoutParams.gravity = 21;
        addView(this.mTn, layoutParams);
        this.mXOffset = l.getDimens(this.mContext, R.dimen.M_W_X004);
        this.mYOffset = l.getDimens(this.mContext, R.dimen.ds10);
        this.mWindowHeight = l.getDimens(this.mContext, R.dimen.ds278);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.ggf = l.getDimens(this.mContext, R.dimen.ds120);
        setOnClickListener(this.gfZ);
        this.mTn.setImageDrawable(WebPManager.a(this.mTp, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.ad_close_popupwindow, (ViewGroup) null);
        this.mTitleTextView = (TextView) inflate.findViewById(R.id.head_text);
        this.itx = (RelativeLayout) inflate.findViewById(R.id.top_area);
        View findViewById = inflate.findViewById(R.id.ad_show_reason_wrapper);
        this.mTl = (EMTextView) inflate.findViewById(R.id.ad_show_reason);
        this.mTm = (ImageView) inflate.findViewById(R.id.arrow_right);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
        }
        this.mTi = (TBSpecificationBtn) inflate.findViewById(R.id.forbid_thread_btn);
        this.mTk = new b();
        this.mTk.rs(R.color.CAM_X0304);
        this.mTi.setConfig(this.mTk);
        if (!TextUtils.isEmpty(this.mTu)) {
            this.mTi.setText(this.mTu);
        } else {
            this.mTi.setText(this.mContext.getResources().getString(R.string.ad_no_interest));
        }
        this.mTi.setOnClickListener(this.mTx);
        if (dGg()) {
            this.mTl.setText(this.mTs.name);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this.mTz);
        }
        ao.setViewTextColor(this.mTitleTextView, R.color.CAM_X0105, 1);
        ao.setViewTextColor(this.mTl, R.color.CAM_X0107, 1);
        this.mTm.setImageDrawable(ao.getDrawable(R.drawable.icon_ad_dislike_arrow20_right_n));
        this.mTh = (LinearLayout) inflate.findViewById(R.id.reason_root_container);
        this.mTq = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwm() {
        if (this.mContext != null) {
            bNI();
            View contentView = getContentView();
            dGe();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(ao.getColor(R.color.CAM_X0204));
            gradientDrawable.setCornerRadius(l.getDimens(this.mContext, R.dimen.tbds31));
            this.mContentView.setBackgroundDrawable(gradientDrawable);
            this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.ggu);
            if (Build.VERSION.SDK_INT >= 22) {
                this.mPopupWindow.setAttachedInDecor(false);
            }
            if (!this.mTv) {
                MessageManager.getInstance().registerListener(this.mTy);
                this.mTv = true;
            }
            this.ggj = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.ggj.setFocusable(false);
            this.ggj.setTouchable(false);
            if (Build.VERSION.SDK_INT >= 22) {
                this.ggj.setAttachedInDecor(false);
            }
            this.ggj.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a2 = a(this.mContext, this, this.mWindowHeight, this.mWindowWidth, this.ggf, this.mYOffset, iArr);
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

    private void dGe() {
        if (!a.isEmpty(this.mTt)) {
            int eN = a.eN(this.mTt);
            this.mTh.setVisibility(0);
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
                this.mTh.addView(linearLayout);
                int i3 = i;
                for (int i4 = 0; i4 < linearLayout.getChildCount() && (i3 = i3 + 1) <= eN; i4++) {
                    CheckBox checkBox = (CheckBox) linearLayout.getChildAt(i4);
                    checkBox.setOnClickListener(this.mTw);
                    checkBox.setVisibility(0);
                    a.a(this.mTq, checkBox);
                }
                i = i3;
            }
            for (int i5 = 0; i5 < a.eN(this.mTt); i5++) {
                String str = (String) a.l(this.mTt, i5);
                CheckBox checkBox2 = (CheckBox) a.l(this.mTq, i5);
                if (checkBox2 != null) {
                    checkBox2.setText(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNI() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.ggj != null) {
            this.ggj.dismiss();
            this.ggj = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mTv) {
            MessageManager.getInstance().unRegisterListener(this.mTy);
            this.mTv = false;
        }
        if (this.ggj != null) {
            if (this.mPopupWindow == null || !this.mPopupWindow.isShowing()) {
                this.ggj.dismiss();
                this.ggj = null;
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
            this.mTr = advertAppInfo;
            a.clear(this.mTt);
            if (this.mTr.eOc != null && this.mTr.eOc.adCloseInfo != null) {
                AdCloseInfo adCloseInfo = this.mTr.eOc.adCloseInfo;
                this.mTs = adCloseInfo.action_control;
                for (String str : adCloseInfo.reasons) {
                    a.a(this.mTt, str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(R.string.tell_us_reason);
                }
                this.mTu = adCloseInfo.confirm_title;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGf() {
        if (dGg()) {
            com.baidu.tieba.ad.a.bOF().a(getContext(), new String[]{this.mTs.url}, null);
        }
    }

    private boolean dGg() {
        return (this.mTs == null || TextUtils.isEmpty(this.mTs.url) || TextUtils.isEmpty(this.mTs.name)) ? false : true;
    }

    public void setPage(int i) {
        this.cea = i;
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
        this.mTn.setImageDrawable(WebPManager.a(this.mTp, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.mTr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!a.isEmpty(this.mTq)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= a.eN(this.mTq)) {
                    break;
                }
                CheckBox checkBox = (CheckBox) a.l(this.mTq, i2);
                if (checkBox != null && checkBox.isChecked() && a.eN(this.mTt) > i2) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append((String) a.l(this.mTt, i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dGh() {
        if (a.isEmpty(this.mTq)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < a.eN(this.mTq); i2++) {
            CheckBox checkBox = (CheckBox) a.l(this.mTq, i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
