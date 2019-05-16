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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.al;
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
    private PopupWindow aOK;
    private long cQT;
    private RotateAnimation cQV;
    private RotateAnimation cQW;
    private View.OnClickListener cQX;
    private int cRb;
    private int cRd;
    private PopupWindow cRg;
    private PopupWindow.OnDismissListener cRn;
    private ImageView dDO;
    private int eht;
    private RelativeLayout euU;
    private TextView fBD;
    private AdvertAppInfo iFA;
    private ActionControl iFB;
    private List<String> iFC;
    private String iFD;
    private boolean iFE;
    private View.OnClickListener iFF;
    private View.OnClickListener iFG;
    private final CustomMessageListener iFH;
    private View.OnClickListener iFI;
    private LinearLayout iFw;
    private TextView iFx;
    private ImageView iFy;
    private List<CheckBox> iFz;
    private View mContentView;
    private Context mContext;
    private String mTitle;
    private TextView mTitleTextView;
    private int mWindowHeight;
    private int mXOffset;
    private int mYOffset;

    public AdCloseView(Context context) {
        super(context);
        this.mContext = null;
        this.aOK = null;
        this.cRg = null;
        this.iFz = null;
        this.iFA = null;
        this.iFC = new ArrayList();
        this.cQT = 0L;
        this.iFE = false;
        this.cQX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cQT > 500) {
                    AdCloseView.this.bwj();
                    AdCloseView.this.cQT = currentTimeMillis;
                }
            }
        };
        this.iFF = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int cfN = AdCloseView.this.cfN();
                if (cfN > 0) {
                    AdCloseView.this.fBD.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = al.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(cfN));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.fBD.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.iFG = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.iFA != null && AdCloseView.this.aOK != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.iFA.bDS));
                    AdCloseView.this.azW();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.eht) {
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
                    httpMessage.addParam("ext", AdCloseView.this.iFA.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cRn = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cRg != null) {
                    AdCloseView.this.cRg.dismiss();
                    AdCloseView.this.cRg = null;
                }
            }
        };
        this.iFH = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.azW();
            }
        };
        this.iFI = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.cfL();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.aOK = null;
        this.cRg = null;
        this.iFz = null;
        this.iFA = null;
        this.iFC = new ArrayList();
        this.cQT = 0L;
        this.iFE = false;
        this.cQX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cQT > 500) {
                    AdCloseView.this.bwj();
                    AdCloseView.this.cQT = currentTimeMillis;
                }
            }
        };
        this.iFF = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int cfN = AdCloseView.this.cfN();
                if (cfN > 0) {
                    AdCloseView.this.fBD.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = al.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(cfN));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.fBD.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.iFG = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.iFA != null && AdCloseView.this.aOK != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.iFA.bDS));
                    AdCloseView.this.azW();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.eht) {
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
                    httpMessage.addParam("ext", AdCloseView.this.iFA.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cRn = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cRg != null) {
                    AdCloseView.this.cRg.dismiss();
                    AdCloseView.this.cRg = null;
                }
            }
        };
        this.iFH = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.azW();
            }
        };
        this.iFI = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.cfL();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.aOK = null;
        this.cRg = null;
        this.iFz = null;
        this.iFA = null;
        this.iFC = new ArrayList();
        this.cQT = 0L;
        this.iFE = false;
        this.cQX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cQT > 500) {
                    AdCloseView.this.bwj();
                    AdCloseView.this.cQT = currentTimeMillis;
                }
            }
        };
        this.iFF = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int cfN = AdCloseView.this.cfN();
                if (cfN > 0) {
                    AdCloseView.this.fBD.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = al.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(cfN));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.fBD.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.iFG = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.iFA != null && AdCloseView.this.aOK != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.iFA.bDS));
                    AdCloseView.this.azW();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.eht) {
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
                    httpMessage.addParam("ext", AdCloseView.this.iFA.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cRn = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cRg != null) {
                    AdCloseView.this.cRg.dismiss();
                    AdCloseView.this.cRg = null;
                }
            }
        };
        this.iFH = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.azW();
            }
        };
        this.iFI = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.cfL();
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.dDO = new ImageView(getContext());
        this.dDO.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.tbds31), getContext().getResources().getDimensionPixelSize(R.dimen.tbds31));
        layoutParams.gravity = 21;
        addView(this.dDO, layoutParams);
        this.mXOffset = l.g(this.mContext, R.dimen.ds32);
        this.mYOffset = l.g(this.mContext, R.dimen.ds10);
        this.mWindowHeight = l.g(this.mContext, R.dimen.ds278);
        this.cRb = l.af(this.mContext) - (this.mXOffset * 2);
        this.cRd = l.g(this.mContext, R.dimen.ds120);
        setOnClickListener(this.cQX);
        al.c(this.dDO, (int) R.drawable.icon_home_card_delete);
        azX();
    }

    private void azX() {
        this.cQV = new RotateAnimation(0.0f, 135.0f, 1, 0.5f, 1, 0.5f);
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
        this.cQV.setInterpolator(overshootInterpolator);
        this.cQV.setDuration(250L);
        this.cQV.setFillAfter(true);
        this.cQW = new RotateAnimation(135.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.cQW.setInterpolator(overshootInterpolator);
        this.cQW.setDuration(250L);
        this.cQW.setFillAfter(true);
    }

    private void setCWRotateAnimation() {
        if (this.dDO != null) {
            this.dDO.clearAnimation();
            this.dDO.startAnimation(this.cQV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setACRotateAnimation() {
        if (this.dDO != null) {
            this.dDO.clearAnimation();
            this.dDO.startAnimation(this.cQW);
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.ad_close_popupwindow, (ViewGroup) null);
        this.mTitleTextView = (TextView) inflate.findViewById(R.id.head_text);
        this.euU = (RelativeLayout) inflate.findViewById(R.id.top_area);
        View findViewById = inflate.findViewById(R.id.ad_show_reason_wrapper);
        this.iFx = (TextView) inflate.findViewById(R.id.ad_show_reason);
        this.iFy = (ImageView) inflate.findViewById(R.id.arrow_right);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
        }
        this.fBD = (TextView) inflate.findViewById(R.id.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.iFD)) {
            this.fBD.setText(this.iFD);
        }
        this.fBD.setOnClickListener(this.iFG);
        if (cfM()) {
            this.iFx.setText(this.iFB.name);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this.iFI);
        }
        al.f(this.mTitleTextView, R.color.cp_cont_b, 1);
        al.f(this.fBD, R.color.cp_btn_a, 1);
        al.f(this.iFx, R.color.cp_other_i, 1);
        al.k(this.fBD, R.drawable.bg_blue_rec_n);
        this.iFy.setImageDrawable(al.getDrawable(R.drawable.icon_ad_dislike_arrow20_right_n));
        this.iFw = (LinearLayout) inflate.findViewById(R.id.reason_root_container);
        this.iFz = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwj() {
        if (this.mContext != null) {
            azW();
            setCWRotateAnimation();
            View contentView = getContentView();
            cfK();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.aOK = new PopupWindow(contentView, this.cRb, this.mWindowHeight);
            this.aOK.setFocusable(true);
            this.aOK.setTouchable(true);
            this.aOK.setOnDismissListener(this.cRn);
            if (Build.VERSION.SDK_INT >= 22) {
                this.aOK.setAttachedInDecor(false);
            }
            if (!this.iFE) {
                MessageManager.getInstance().registerListener(this.iFH);
                this.iFE = true;
            }
            this.cRg = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.cRg.setFocusable(false);
            this.cRg.setTouchable(false);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cRg.setAttachedInDecor(false);
            }
            this.cRg.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.cRb, this.cRd, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aOK.setAnimationStyle(R.style.scale_rb2lt_anim);
                    al.a(this.aOK, (int) R.drawable.bg_tost_feedback_down);
                    if (this.euU != null && this.euU.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.euU.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                    }
                } else {
                    this.aOK.setAnimationStyle(R.style.scale_rt2lb_anim);
                    al.a(this.aOK, (int) R.drawable.bg_tost_feedback_up);
                    if (this.euU != null && this.euU.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.euU.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds84);
                    }
                }
                this.aOK.showAtLocation(getRootView(), 0, iArr[0] - this.mXOffset, iArr[1]);
            }
        }
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        try {
            this.mContentView.measure(0, 0);
            return this.mContentView.getMeasuredHeight() + l.g(this.mContext, R.dimen.ds12);
        } catch (Exception e) {
            return 0;
        }
    }

    private void cfK() {
        if (this.iFC != null && this.iFC.size() > 0) {
            int size = this.iFC.size();
            this.iFw.setVisibility(0);
            int i = 0;
            for (int i2 = 0; i2 < Math.ceil(size / 2.0d); i2++) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ad_close_row_view, (ViewGroup) null);
                linearLayout.setOrientation(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 1;
                if (i2 != 0) {
                    layoutParams.topMargin = l.g(this.mContext, R.dimen.tbds20);
                }
                linearLayout.setLayoutParams(layoutParams);
                this.iFw.addView(linearLayout);
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
                    checkBox.setOnClickListener(this.iFF);
                    checkBox.setVisibility(0);
                    this.iFz.add(checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < this.iFC.size(); i5++) {
                this.iFz.get(i5).setText(this.iFC.get(i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azW() {
        if (this.aOK != null) {
            this.aOK.dismiss();
            this.aOK = null;
        }
        if (this.cRg != null) {
            this.cRg.dismiss();
            this.cRg = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.iFE) {
            MessageManager.getInstance().unRegisterListener(this.iFH);
            this.iFE = false;
        }
        if (this.cRg != null) {
            if (this.aOK == null || !this.aOK.isShowing()) {
                this.cRg.dismiss();
                this.cRg = null;
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
        int ah = l.ah(context);
        int af = l.af(context);
        boolean z = ((ah - iArr2[1]) - height) - i3 < i;
        iArr[0] = af - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    public void setData(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null) {
            this.iFA = advertAppInfo;
            this.iFC.clear();
            if (this.iFA.bEc != null && this.iFA.bEc.adCloseInfo != null) {
                AdCloseInfo adCloseInfo = this.iFA.bEc.adCloseInfo;
                this.iFB = adCloseInfo.action_control;
                for (String str : adCloseInfo.reasons) {
                    this.iFC.add(str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(R.string.tell_us_reason);
                }
                this.iFD = adCloseInfo.confirm_title;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfL() {
        if (cfM()) {
            a.aBH().c(getContext(), new String[]{this.iFB.url});
        }
    }

    private boolean cfM() {
        return (this.iFB == null || TextUtils.isEmpty(this.iFB.url) || TextUtils.isEmpty(this.iFB.name)) ? false : true;
    }

    public void setPage(int i) {
        this.eht = i;
    }

    public int getCloseViewWidth() {
        return l.g(this.mContext, R.dimen.ds96);
    }

    public int getCloseViewHeight() {
        return l.g(this.mContext, R.dimen.ds26);
    }

    public View getAdCloseView() {
        return this;
    }

    public void onChangeSkinType() {
        al.c(this.dDO, (int) R.drawable.icon_home_card_delete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.iFA == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.aa(this.iFz)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iFz.size()) {
                    break;
                }
                CheckBox checkBox = this.iFz.get(i2);
                if (checkBox != null && checkBox.isChecked() && this.iFC != null && this.iFC.size() > i2) {
                    if (sb.length() != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append(this.iFC.get(i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cfN() {
        if (v.aa(this.iFz)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.iFz.size(); i2++) {
            CheckBox checkBox = this.iFz.get(i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
