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
    private PopupWindow aPu;
    private int cSB;
    private PopupWindow cSE;
    private PopupWindow.OnDismissListener cSL;
    private long cSr;
    private RotateAnimation cSt;
    private RotateAnimation cSu;
    private View.OnClickListener cSv;
    private int cSz;
    private ImageView dHl;
    private int elY;
    private RelativeLayout ezU;
    private TextView fGC;
    private LinearLayout iLR;
    private TextView iLS;
    private ImageView iLT;
    private List<CheckBox> iLU;
    private AdvertAppInfo iLV;
    private ActionControl iLW;
    private List<String> iLX;
    private String iLY;
    private boolean iLZ;
    private View.OnClickListener iMa;
    private View.OnClickListener iMb;
    private final CustomMessageListener iMc;
    private View.OnClickListener iMd;
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
        this.aPu = null;
        this.cSE = null;
        this.iLU = null;
        this.iLV = null;
        this.iLX = new ArrayList();
        this.cSr = 0L;
        this.iLZ = false;
        this.cSv = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cSr > 500) {
                    AdCloseView.this.byR();
                    AdCloseView.this.cSr = currentTimeMillis;
                }
            }
        };
        this.iMa = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int ciH = AdCloseView.this.ciH();
                if (ciH > 0) {
                    AdCloseView.this.fGC.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = am.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(ciH));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.fGC.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.iMb = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.iLV != null && AdCloseView.this.aPu != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.iLV.bET));
                    AdCloseView.this.aBn();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.elY) {
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
                    httpMessage.addParam("ext", AdCloseView.this.iLV.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cSL = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cSE != null) {
                    AdCloseView.this.cSE.dismiss();
                    AdCloseView.this.cSE = null;
                }
            }
        };
        this.iMc = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.aBn();
            }
        };
        this.iMd = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.ciF();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.aPu = null;
        this.cSE = null;
        this.iLU = null;
        this.iLV = null;
        this.iLX = new ArrayList();
        this.cSr = 0L;
        this.iLZ = false;
        this.cSv = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cSr > 500) {
                    AdCloseView.this.byR();
                    AdCloseView.this.cSr = currentTimeMillis;
                }
            }
        };
        this.iMa = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int ciH = AdCloseView.this.ciH();
                if (ciH > 0) {
                    AdCloseView.this.fGC.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = am.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(ciH));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.fGC.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.iMb = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.iLV != null && AdCloseView.this.aPu != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.iLV.bET));
                    AdCloseView.this.aBn();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.elY) {
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
                    httpMessage.addParam("ext", AdCloseView.this.iLV.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cSL = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cSE != null) {
                    AdCloseView.this.cSE.dismiss();
                    AdCloseView.this.cSE = null;
                }
            }
        };
        this.iMc = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.aBn();
            }
        };
        this.iMd = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.ciF();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.aPu = null;
        this.cSE = null;
        this.iLU = null;
        this.iLV = null;
        this.iLX = new ArrayList();
        this.cSr = 0L;
        this.iLZ = false;
        this.cSv = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cSr > 500) {
                    AdCloseView.this.byR();
                    AdCloseView.this.cSr = currentTimeMillis;
                }
            }
        };
        this.iMa = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int ciH = AdCloseView.this.ciH();
                if (ciH > 0) {
                    AdCloseView.this.fGC.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = am.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(ciH));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.fGC.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.iMb = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.iLV != null && AdCloseView.this.aPu != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.iLV.bET));
                    AdCloseView.this.aBn();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.elY) {
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
                    httpMessage.addParam("ext", AdCloseView.this.iLV.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cSL = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cSE != null) {
                    AdCloseView.this.cSE.dismiss();
                    AdCloseView.this.cSE = null;
                }
            }
        };
        this.iMc = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.aBn();
            }
        };
        this.iMd = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.ciF();
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.dHl = new ImageView(getContext());
        this.dHl.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.tbds31), getContext().getResources().getDimensionPixelSize(R.dimen.tbds31));
        layoutParams.gravity = 21;
        addView(this.dHl, layoutParams);
        this.mXOffset = l.g(this.mContext, R.dimen.ds32);
        this.mYOffset = l.g(this.mContext, R.dimen.ds10);
        this.mWindowHeight = l.g(this.mContext, R.dimen.ds278);
        this.cSz = l.af(this.mContext) - (this.mXOffset * 2);
        this.cSB = l.g(this.mContext, R.dimen.ds120);
        setOnClickListener(this.cSv);
        am.c(this.dHl, (int) R.drawable.icon_home_card_delete);
        aBo();
    }

    private void aBo() {
        this.cSt = new RotateAnimation(0.0f, 135.0f, 1, 0.5f, 1, 0.5f);
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
        this.cSt.setInterpolator(overshootInterpolator);
        this.cSt.setDuration(250L);
        this.cSt.setFillAfter(true);
        this.cSu = new RotateAnimation(135.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.cSu.setInterpolator(overshootInterpolator);
        this.cSu.setDuration(250L);
        this.cSu.setFillAfter(true);
    }

    private void setCWRotateAnimation() {
        if (this.dHl != null) {
            this.dHl.clearAnimation();
            this.dHl.startAnimation(this.cSt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setACRotateAnimation() {
        if (this.dHl != null) {
            this.dHl.clearAnimation();
            this.dHl.startAnimation(this.cSu);
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.ad_close_popupwindow, (ViewGroup) null);
        this.mTitleTextView = (TextView) inflate.findViewById(R.id.head_text);
        this.ezU = (RelativeLayout) inflate.findViewById(R.id.top_area);
        View findViewById = inflate.findViewById(R.id.ad_show_reason_wrapper);
        this.iLS = (TextView) inflate.findViewById(R.id.ad_show_reason);
        this.iLT = (ImageView) inflate.findViewById(R.id.arrow_right);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
        }
        this.fGC = (TextView) inflate.findViewById(R.id.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.iLY)) {
            this.fGC.setText(this.iLY);
        }
        this.fGC.setOnClickListener(this.iMb);
        if (ciG()) {
            this.iLS.setText(this.iLW.name);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this.iMd);
        }
        am.f(this.mTitleTextView, R.color.cp_cont_b, 1);
        am.f(this.fGC, R.color.cp_btn_a, 1);
        am.f(this.iLS, R.color.cp_other_i, 1);
        am.k(this.fGC, R.drawable.bg_blue_rec_n);
        this.iLT.setImageDrawable(am.getDrawable(R.drawable.icon_ad_dislike_arrow20_right_n));
        this.iLR = (LinearLayout) inflate.findViewById(R.id.reason_root_container);
        this.iLU = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byR() {
        if (this.mContext != null) {
            aBn();
            setCWRotateAnimation();
            View contentView = getContentView();
            ciE();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.aPu = new PopupWindow(contentView, this.cSz, this.mWindowHeight);
            this.aPu.setFocusable(true);
            this.aPu.setTouchable(true);
            this.aPu.setOnDismissListener(this.cSL);
            if (Build.VERSION.SDK_INT >= 22) {
                this.aPu.setAttachedInDecor(false);
            }
            if (!this.iLZ) {
                MessageManager.getInstance().registerListener(this.iMc);
                this.iLZ = true;
            }
            this.cSE = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.cSE.setFocusable(false);
            this.cSE.setTouchable(false);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cSE.setAttachedInDecor(false);
            }
            this.cSE.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.cSz, this.cSB, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aPu.setAnimationStyle(R.style.scale_rb2lt_anim);
                    am.a(this.aPu, (int) R.drawable.bg_tost_feedback_down);
                    if (this.ezU != null && this.ezU.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.ezU.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                    }
                } else {
                    this.aPu.setAnimationStyle(R.style.scale_rt2lb_anim);
                    am.a(this.aPu, (int) R.drawable.bg_tost_feedback_up);
                    if (this.ezU != null && this.ezU.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.ezU.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds84);
                    }
                }
                this.aPu.showAtLocation(getRootView(), 0, iArr[0] - this.mXOffset, iArr[1]);
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

    private void ciE() {
        if (this.iLX != null && this.iLX.size() > 0) {
            int size = this.iLX.size();
            this.iLR.setVisibility(0);
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
                this.iLR.addView(linearLayout);
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
                    checkBox.setOnClickListener(this.iMa);
                    checkBox.setVisibility(0);
                    this.iLU.add(checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < this.iLX.size(); i5++) {
                this.iLU.get(i5).setText(this.iLX.get(i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBn() {
        if (this.aPu != null) {
            this.aPu.dismiss();
            this.aPu = null;
        }
        if (this.cSE != null) {
            this.cSE.dismiss();
            this.cSE = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.iLZ) {
            MessageManager.getInstance().unRegisterListener(this.iMc);
            this.iLZ = false;
        }
        if (this.cSE != null) {
            if (this.aPu == null || !this.aPu.isShowing()) {
                this.cSE.dismiss();
                this.cSE = null;
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
            this.iLV = advertAppInfo;
            this.iLX.clear();
            if (this.iLV.bFd != null && this.iLV.bFd.adCloseInfo != null) {
                AdCloseInfo adCloseInfo = this.iLV.bFd.adCloseInfo;
                this.iLW = adCloseInfo.action_control;
                for (String str : adCloseInfo.reasons) {
                    this.iLX.add(str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(R.string.tell_us_reason);
                }
                this.iLY = adCloseInfo.confirm_title;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciF() {
        if (ciG()) {
            a.aCZ().c(getContext(), new String[]{this.iLW.url});
        }
    }

    private boolean ciG() {
        return (this.iLW == null || TextUtils.isEmpty(this.iLW.url) || TextUtils.isEmpty(this.iLW.name)) ? false : true;
    }

    public void setPage(int i) {
        this.elY = i;
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
        am.c(this.dHl, (int) R.drawable.icon_home_card_delete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.iLV == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.aa(this.iLU)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iLU.size()) {
                    break;
                }
                CheckBox checkBox = this.iLU.get(i2);
                if (checkBox != null && checkBox.isChecked() && this.iLX != null && this.iLX.size() > i2) {
                    if (sb.length() != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append(this.iLX.get(i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ciH() {
        if (v.aa(this.iLU)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.iLU.size(); i2++) {
            CheckBox checkBox = this.iLU.get(i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
