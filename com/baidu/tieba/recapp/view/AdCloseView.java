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
    protected PopupWindow aPS;
    protected int cTB;
    protected PopupWindow cTE;
    private PopupWindow.OnDismissListener cTL;
    private long cTr;
    private RotateAnimation cTt;
    private RotateAnimation cTu;
    protected View.OnClickListener cTv;
    protected int cTz;
    protected ImageView dJd;
    protected RelativeLayout eBK;
    private int enR;
    protected TextView fJf;
    private View.OnClickListener iPA;
    private View.OnClickListener iPB;
    private final CustomMessageListener iPC;
    private View.OnClickListener iPD;
    protected LinearLayout iPr;
    protected TextView iPs;
    protected ImageView iPt;
    private List<CheckBox> iPu;
    private AdvertAppInfo iPv;
    private ActionControl iPw;
    private List<String> iPx;
    private String iPy;
    private boolean iPz;
    private View mContentView;
    protected Context mContext;
    private String mTitle;
    protected TextView mTitleTextView;
    protected int mWindowHeight;
    protected int mXOffset;
    protected int mYOffset;

    public AdCloseView(Context context) {
        super(context);
        this.mContext = null;
        this.aPS = null;
        this.cTE = null;
        this.iPu = null;
        this.iPv = null;
        this.iPx = new ArrayList();
        this.cTr = 0L;
        this.iPz = false;
        this.cTv = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cTr > 500) {
                    AdCloseView.this.bzT();
                    AdCloseView.this.cTr = currentTimeMillis;
                }
            }
        };
        this.iPA = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int cjN = AdCloseView.this.cjN();
                if (cjN > 0) {
                    AdCloseView.this.fJf.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = am.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(cjN));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.fJf.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.iPB = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.iPv != null && AdCloseView.this.aPS != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.iPv.bFs));
                    AdCloseView.this.aBD();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.enR) {
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
                    httpMessage.addParam("ext", AdCloseView.this.iPv.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cTL = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cTE != null) {
                    AdCloseView.this.cTE.dismiss();
                    AdCloseView.this.cTE = null;
                }
            }
        };
        this.iPC = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.aBD();
            }
        };
        this.iPD = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.cjL();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.aPS = null;
        this.cTE = null;
        this.iPu = null;
        this.iPv = null;
        this.iPx = new ArrayList();
        this.cTr = 0L;
        this.iPz = false;
        this.cTv = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cTr > 500) {
                    AdCloseView.this.bzT();
                    AdCloseView.this.cTr = currentTimeMillis;
                }
            }
        };
        this.iPA = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int cjN = AdCloseView.this.cjN();
                if (cjN > 0) {
                    AdCloseView.this.fJf.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = am.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(cjN));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.fJf.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.iPB = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.iPv != null && AdCloseView.this.aPS != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.iPv.bFs));
                    AdCloseView.this.aBD();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.enR) {
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
                    httpMessage.addParam("ext", AdCloseView.this.iPv.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cTL = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cTE != null) {
                    AdCloseView.this.cTE.dismiss();
                    AdCloseView.this.cTE = null;
                }
            }
        };
        this.iPC = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.aBD();
            }
        };
        this.iPD = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.cjL();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.aPS = null;
        this.cTE = null;
        this.iPu = null;
        this.iPv = null;
        this.iPx = new ArrayList();
        this.cTr = 0L;
        this.iPz = false;
        this.cTv = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cTr > 500) {
                    AdCloseView.this.bzT();
                    AdCloseView.this.cTr = currentTimeMillis;
                }
            }
        };
        this.iPA = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int cjN = AdCloseView.this.cjN();
                if (cjN > 0) {
                    AdCloseView.this.fJf.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = am.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(cjN));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.fJf.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.iPB = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.iPv != null && AdCloseView.this.aPS != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.iPv.bFs));
                    AdCloseView.this.aBD();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.enR) {
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
                    httpMessage.addParam("ext", AdCloseView.this.iPv.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cTL = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cTE != null) {
                    AdCloseView.this.cTE.dismiss();
                    AdCloseView.this.cTE = null;
                }
            }
        };
        this.iPC = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.aBD();
            }
        };
        this.iPD = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.cjL();
            }
        };
        this.mContext = context;
        init();
    }

    protected void init() {
        this.dJd = new ImageView(getContext());
        this.dJd.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.dJd, layoutParams);
        this.mXOffset = l.g(this.mContext, R.dimen.ds32);
        this.mYOffset = l.g(this.mContext, R.dimen.ds10);
        this.mWindowHeight = l.g(this.mContext, R.dimen.ds278);
        this.cTz = l.af(this.mContext) - (this.mXOffset * 2);
        this.cTB = l.g(this.mContext, R.dimen.ds120);
        setOnClickListener(this.cTv);
        SvgManager.ajv().a(this.dJd, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_d, null);
        aBE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aBE() {
        this.cTt = new RotateAnimation(0.0f, 135.0f, 1, 0.5f, 1, 0.5f);
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
        this.cTt.setInterpolator(overshootInterpolator);
        this.cTt.setDuration(250L);
        this.cTt.setFillAfter(true);
        this.cTu = new RotateAnimation(135.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.cTu.setInterpolator(overshootInterpolator);
        this.cTu.setDuration(250L);
        this.cTu.setFillAfter(true);
    }

    private void setCWRotateAnimation() {
        if (this.dJd != null) {
            this.dJd.clearAnimation();
            this.dJd.startAnimation(this.cTt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setACRotateAnimation() {
        if (this.dJd != null) {
            this.dJd.clearAnimation();
            this.dJd.startAnimation(this.cTu);
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.ad_close_popupwindow, (ViewGroup) null);
        this.mTitleTextView = (TextView) inflate.findViewById(R.id.head_text);
        this.eBK = (RelativeLayout) inflate.findViewById(R.id.top_area);
        View findViewById = inflate.findViewById(R.id.ad_show_reason_wrapper);
        this.iPs = (TextView) inflate.findViewById(R.id.ad_show_reason);
        this.iPt = (ImageView) inflate.findViewById(R.id.arrow_right);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
        }
        this.fJf = (TextView) inflate.findViewById(R.id.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.iPy)) {
            this.fJf.setText(this.iPy);
        }
        this.fJf.setOnClickListener(this.iPB);
        if (cjM()) {
            this.iPs.setText(this.iPw.name);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this.iPD);
        }
        am.f(this.mTitleTextView, R.color.cp_cont_b, 1);
        am.f(this.fJf, R.color.cp_cont_a, 1);
        am.f(this.iPs, R.color.cp_other_i, 1);
        am.k(this.fJf, R.drawable.bg_blue_rec_n);
        this.iPt.setImageDrawable(am.getDrawable(R.drawable.icon_ad_dislike_arrow20_right_n));
        this.iPr = (LinearLayout) inflate.findViewById(R.id.reason_root_container);
        this.iPu = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzT() {
        if (this.mContext != null) {
            aBD();
            setCWRotateAnimation();
            View contentView = getContentView();
            cjK();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.aPS = new PopupWindow(contentView, this.cTz, this.mWindowHeight);
            this.aPS.setFocusable(true);
            this.aPS.setTouchable(true);
            this.aPS.setOnDismissListener(this.cTL);
            if (Build.VERSION.SDK_INT >= 22) {
                this.aPS.setAttachedInDecor(false);
            }
            if (!this.iPz) {
                MessageManager.getInstance().registerListener(this.iPC);
                this.iPz = true;
            }
            this.cTE = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.cTE.setFocusable(false);
            this.cTE.setTouchable(false);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cTE.setAttachedInDecor(false);
            }
            this.cTE.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.cTz, this.cTB, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aPS.setAnimationStyle(R.style.scale_rb2lt_anim);
                    am.a(this.aPS, (int) R.drawable.bg_tost_feedback_down);
                    if (this.eBK != null && this.eBK.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.eBK.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                    }
                } else {
                    this.aPS.setAnimationStyle(R.style.scale_rt2lb_anim);
                    am.a(this.aPS, (int) R.drawable.bg_tost_feedback_up);
                    if (this.eBK != null && this.eBK.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.eBK.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds84);
                    }
                }
                this.aPS.showAtLocation(getRootView(), 0, iArr[0] - this.mXOffset, iArr[1]);
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

    private void cjK() {
        if (this.iPx != null && this.iPx.size() > 0) {
            int size = this.iPx.size();
            this.iPr.setVisibility(0);
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
                this.iPr.addView(linearLayout);
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
                    checkBox.setOnClickListener(this.iPA);
                    checkBox.setVisibility(0);
                    this.iPu.add(checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < this.iPx.size(); i5++) {
                this.iPu.get(i5).setText(this.iPx.get(i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBD() {
        if (this.aPS != null) {
            this.aPS.dismiss();
            this.aPS = null;
        }
        if (this.cTE != null) {
            this.cTE.dismiss();
            this.cTE = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.iPz) {
            MessageManager.getInstance().unRegisterListener(this.iPC);
            this.iPz = false;
        }
        if (this.cTE != null) {
            if (this.aPS == null || !this.aPS.isShowing()) {
                this.cTE.dismiss();
                this.cTE = null;
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
            this.iPv = advertAppInfo;
            this.iPx.clear();
            if (this.iPv.bFC != null && this.iPv.bFC.adCloseInfo != null) {
                AdCloseInfo adCloseInfo = this.iPv.bFC.adCloseInfo;
                this.iPw = adCloseInfo.action_control;
                for (String str : adCloseInfo.reasons) {
                    this.iPx.add(str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(R.string.tell_us_reason);
                }
                this.iPy = adCloseInfo.confirm_title;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjL() {
        if (cjM()) {
            a.aDp().c(getContext(), new String[]{this.iPw.url});
        }
    }

    private boolean cjM() {
        return (this.iPw == null || TextUtils.isEmpty(this.iPw.url) || TextUtils.isEmpty(this.iPw.name)) ? false : true;
    }

    public void setPage(int i) {
        this.enR = i;
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
        SvgManager.ajv().a(this.dJd, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_d, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.iPv == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.aa(this.iPu)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iPu.size()) {
                    break;
                }
                CheckBox checkBox = this.iPu.get(i2);
                if (checkBox != null && checkBox.isChecked() && this.iPx != null && this.iPx.size() > i2) {
                    if (sb.length() != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append(this.iPx.get(i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cjN() {
        if (v.aa(this.iPu)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.iPu.size(); i2++) {
            CheckBox checkBox = this.iPu.get(i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
