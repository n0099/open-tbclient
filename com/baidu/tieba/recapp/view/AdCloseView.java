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
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdCloseInfo;
/* loaded from: classes3.dex */
public class AdCloseView extends ImageView {
    private PopupWindow btA;
    private PopupWindow.OnDismissListener btG;
    private View.OnClickListener bts;
    private int btw;
    private int bty;
    private int cEl;
    private TextView dNT;
    private LinearLayout gKP;
    private List<CheckBox> gKQ;
    private AdvertAppInfo gKR;
    private List<String> gKS;
    private String gKT;
    private boolean gKU;
    private View.OnClickListener gKV;
    private View.OnClickListener gKW;
    private final CustomMessageListener gKX;
    private View mContentView;
    private Context mContext;
    private PopupWindow mPopupWindow;
    private String mTitle;
    private TextView mTitleTextView;
    private int mWindowHeight;
    private int mXOffset;
    private int mYOffset;

    public AdCloseView(Context context) {
        super(context);
        this.mContext = null;
        this.mPopupWindow = null;
        this.btA = null;
        this.gKQ = null;
        this.gKR = null;
        this.gKS = new ArrayList();
        this.gKU = false;
        this.bts = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.Ts();
            }
        };
        this.gKV = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int btI = AdCloseView.this.btI();
                if (btI > 0) {
                    AdCloseView.this.dNT.setText(e.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(e.j.ad_close_title_prefix));
                    int color = al.getColor(e.d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(btI));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(e.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dNT.setText(e.j.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.gKW = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gKR != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gKR.alP));
                    AdCloseView.this.Tt();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cEl) {
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
                    httpMessage.addParam("ext", AdCloseView.this.gKR.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.btG = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.btA != null) {
                    AdCloseView.this.btA.dismiss();
                    AdCloseView.this.btA = null;
                }
            }
        };
        this.gKX = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.Tt();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mPopupWindow = null;
        this.btA = null;
        this.gKQ = null;
        this.gKR = null;
        this.gKS = new ArrayList();
        this.gKU = false;
        this.bts = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.Ts();
            }
        };
        this.gKV = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int btI = AdCloseView.this.btI();
                if (btI > 0) {
                    AdCloseView.this.dNT.setText(e.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(e.j.ad_close_title_prefix));
                    int color = al.getColor(e.d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(btI));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(e.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dNT.setText(e.j.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.gKW = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gKR != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gKR.alP));
                    AdCloseView.this.Tt();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cEl) {
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
                    httpMessage.addParam("ext", AdCloseView.this.gKR.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.btG = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.btA != null) {
                    AdCloseView.this.btA.dismiss();
                    AdCloseView.this.btA = null;
                }
            }
        };
        this.gKX = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.Tt();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mPopupWindow = null;
        this.btA = null;
        this.gKQ = null;
        this.gKR = null;
        this.gKS = new ArrayList();
        this.gKU = false;
        this.bts = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.Ts();
            }
        };
        this.gKV = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int btI = AdCloseView.this.btI();
                if (btI > 0) {
                    AdCloseView.this.dNT.setText(e.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(e.j.ad_close_title_prefix));
                    int color = al.getColor(e.d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(btI));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(e.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dNT.setText(e.j.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.gKW = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gKR != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gKR.alP));
                    AdCloseView.this.Tt();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cEl) {
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
                    httpMessage.addParam("ext", AdCloseView.this.gKR.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.btG = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.btA != null) {
                    AdCloseView.this.btA.dismiss();
                    AdCloseView.this.btA = null;
                }
            }
        };
        this.gKX = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.Tt();
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mXOffset = l.h(this.mContext, e.C0200e.ds32);
        this.mYOffset = l.h(this.mContext, e.C0200e.ds10);
        this.mWindowHeight = l.h(this.mContext, e.C0200e.ds278);
        this.btw = l.aO(this.mContext) - (this.mXOffset * 2);
        this.bty = l.h(this.mContext, e.C0200e.ds120);
        setOnClickListener(this.bts);
        al.c(this, e.f.icon_home_feedback_selector);
        setPadding(l.h(this.mContext, e.C0200e.ds10), 0, 0, 0);
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.ad_close_popupwindow, (ViewGroup) null);
        this.mTitleTextView = (TextView) inflate.findViewById(e.g.head_text);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
        }
        this.dNT = (TextView) inflate.findViewById(e.g.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.gKT)) {
            this.dNT.setText(this.gKT);
        }
        this.dNT.setOnClickListener(this.gKW);
        al.c(this.mTitleTextView, e.d.cp_cont_d, 1);
        al.c(this.dNT, e.d.cp_cont_i, 1);
        al.i(this.dNT, e.f.bg_blue_rec_n);
        this.gKP = (LinearLayout) inflate.findViewById(e.g.reason_root_container);
        this.gKQ = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ts() {
        if (this.mContext != null) {
            Tt();
            View contentView = getContentView();
            btH();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.mPopupWindow = new PopupWindow(contentView, this.btw, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.btG);
            if (Build.VERSION.SDK_INT >= 22) {
                this.mPopupWindow.setAttachedInDecor(false);
            }
            if (!this.gKU) {
                MessageManager.getInstance().registerListener(this.gKX);
                this.gKU = true;
            }
            this.btA = new PopupWindow(LayoutInflater.from(this.mContext).inflate(e.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.btA.setFocusable(false);
            this.btA.setTouchable(false);
            this.btA.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.btw, this.bty, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.mPopupWindow.setAnimationStyle(e.k.scale_rb2lt_anim);
                    al.a(this.mPopupWindow, e.f.bg_home_feedback_under);
                } else {
                    this.mPopupWindow.setAnimationStyle(e.k.scale_rt2lb_anim);
                    al.a(this.mPopupWindow, e.f.bg_home_feedback_top);
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
            return this.mContentView.getMeasuredHeight() + l.h(this.mContext, e.C0200e.ds12);
        } catch (Exception e) {
            return 0;
        }
    }

    private void btH() {
        if (this.gKS != null && this.gKS.size() > 0) {
            int size = this.gKS.size();
            this.gKP.setVisibility(0);
            int i = 0;
            for (int i2 = 0; i2 < Math.ceil(size / 2.0d); i2++) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(e.h.ad_close_row_view, (ViewGroup) null);
                linearLayout.setOrientation(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 1;
                if (i2 != 0) {
                    layoutParams.topMargin = l.h(this.mContext, e.C0200e.ds16);
                }
                linearLayout.setLayoutParams(layoutParams);
                this.gKP.addView(linearLayout);
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
                    checkBox.setOnClickListener(this.gKV);
                    checkBox.setVisibility(0);
                    this.gKQ.add(checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < this.gKS.size(); i5++) {
                this.gKQ.get(i5).setText(this.gKS.get(i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tt() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.btA != null) {
            this.btA.dismiss();
            this.btA = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gKU) {
            MessageManager.getInstance().unRegisterListener(this.gKX);
            this.gKU = false;
        }
        if (this.btA != null) {
            if (this.mPopupWindow == null || !this.mPopupWindow.isShowing()) {
                this.btA.dismiss();
                this.btA = null;
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
        int aQ = l.aQ(context);
        int aO = l.aO(context);
        boolean z = ((aQ - iArr2[1]) - height) - i3 < i;
        iArr[0] = aO - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    public void setData(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null) {
            this.gKR = advertAppInfo;
            this.gKS.clear();
            if (this.gKR.ama != null && this.gKR.ama.adCloseInfo != null) {
                AdCloseInfo adCloseInfo = this.gKR.ama.adCloseInfo;
                for (String str : adCloseInfo.reasons) {
                    this.gKS.add(str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(e.j.tell_us_reason);
                }
                this.gKT = adCloseInfo.confirm_title;
            }
        }
    }

    public void setPage(int i) {
        this.cEl = i;
    }

    public int getCloseViewWidth() {
        return l.h(this.mContext, e.C0200e.ds96);
    }

    public int getCloseViewHeight() {
        return l.h(this.mContext, e.C0200e.ds26);
    }

    public View getAdCloseView() {
        return this;
    }

    public void onChangeSkinType() {
        al.c(this, e.f.icon_home_feedback_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.gKR == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.I(this.gKQ)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gKQ.size()) {
                    break;
                }
                CheckBox checkBox = this.gKQ.get(i2);
                if (checkBox != null && checkBox.isChecked() && this.gKS != null && this.gKS.size() > i2) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(this.gKS.get(i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int btI() {
        if (v.I(this.gKQ)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.gKQ.size(); i2++) {
            CheckBox checkBox = this.gKQ.get(i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
