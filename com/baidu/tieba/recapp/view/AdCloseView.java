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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdCloseInfo;
/* loaded from: classes3.dex */
public class AdCloseView extends ImageView {
    private int Id;
    private TextView Xn;
    private View.OnClickListener bOV;
    private PopupWindow bOX;
    private int bPa;
    private int bPc;
    private PopupWindow bPe;
    private PopupWindow.OnDismissListener bPk;
    private int cLw;
    private TextView dPx;
    private LinearLayout gHQ;
    private List<CheckBox> gHR;
    private AdvertAppInfo gHS;
    private List<String> gHT;
    private String gHU;
    private boolean gHV;
    private View.OnClickListener gHW;
    private View.OnClickListener gHX;
    private final CustomMessageListener gHY;
    private View mContentView;
    private Context mContext;
    private String mTitle;
    private int mWindowHeight;
    private int mYOffset;

    public AdCloseView(Context context) {
        super(context);
        this.mContext = null;
        this.bOX = null;
        this.bPe = null;
        this.gHR = null;
        this.gHS = null;
        this.gHT = new ArrayList();
        this.gHV = false;
        this.bOV = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.SZ();
            }
        };
        this.gHW = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bpf = AdCloseView.this.bpf();
                if (bpf > 0) {
                    AdCloseView.this.dPx.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = aj.getColor(d.C0140d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bpf));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0140d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.Xn.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dPx.setText(d.j.forbid_ad);
                AdCloseView.this.Xn.setText(AdCloseView.this.mTitle);
            }
        };
        this.gHX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gHS != null && AdCloseView.this.bOX != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gHS.aKF));
                    AdCloseView.this.Ta();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cLw) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.gHS.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.bPk = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.bPe != null) {
                    AdCloseView.this.bPe.dismiss();
                    AdCloseView.this.bPe = null;
                }
            }
        };
        this.gHY = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.Ta();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.bOX = null;
        this.bPe = null;
        this.gHR = null;
        this.gHS = null;
        this.gHT = new ArrayList();
        this.gHV = false;
        this.bOV = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.SZ();
            }
        };
        this.gHW = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bpf = AdCloseView.this.bpf();
                if (bpf > 0) {
                    AdCloseView.this.dPx.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = aj.getColor(d.C0140d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bpf));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0140d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.Xn.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dPx.setText(d.j.forbid_ad);
                AdCloseView.this.Xn.setText(AdCloseView.this.mTitle);
            }
        };
        this.gHX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gHS != null && AdCloseView.this.bOX != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gHS.aKF));
                    AdCloseView.this.Ta();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cLw) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.gHS.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.bPk = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.bPe != null) {
                    AdCloseView.this.bPe.dismiss();
                    AdCloseView.this.bPe = null;
                }
            }
        };
        this.gHY = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.Ta();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.bOX = null;
        this.bPe = null;
        this.gHR = null;
        this.gHS = null;
        this.gHT = new ArrayList();
        this.gHV = false;
        this.bOV = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.SZ();
            }
        };
        this.gHW = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bpf = AdCloseView.this.bpf();
                if (bpf > 0) {
                    AdCloseView.this.dPx.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = aj.getColor(d.C0140d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bpf));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0140d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.Xn.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dPx.setText(d.j.forbid_ad);
                AdCloseView.this.Xn.setText(AdCloseView.this.mTitle);
            }
        };
        this.gHX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gHS != null && AdCloseView.this.bOX != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gHS.aKF));
                    AdCloseView.this.Ta();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cLw) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.gHS.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.bPk = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.bPe != null) {
                    AdCloseView.this.bPe.dismiss();
                    AdCloseView.this.bPe = null;
                }
            }
        };
        this.gHY = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.Ta();
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.Id = l.t(this.mContext, d.e.ds32);
        this.mYOffset = l.t(this.mContext, d.e.ds10);
        this.mWindowHeight = l.t(this.mContext, d.e.ds278);
        this.bPa = l.ao(this.mContext) - (this.Id * 2);
        this.bPc = l.t(this.mContext, d.e.ds120);
        setOnClickListener(this.bOV);
        aj.c(this, d.f.icon_home_feedback_selector);
        setPadding(l.t(this.mContext, d.e.ds10), 0, 0, 0);
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.ad_close_popupwindow, (ViewGroup) null);
        this.Xn = (TextView) inflate.findViewById(d.g.head_text);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.Xn.setText(this.mTitle);
        }
        this.dPx = (TextView) inflate.findViewById(d.g.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.gHU)) {
            this.dPx.setText(this.gHU);
        }
        this.dPx.setOnClickListener(this.gHX);
        aj.e(this.Xn, d.C0140d.cp_cont_d, 1);
        aj.e(this.dPx, d.C0140d.cp_cont_i, 1);
        aj.s(this.dPx, d.f.bg_blue_rec_n);
        this.gHQ = (LinearLayout) inflate.findViewById(d.g.reason_root_container);
        this.gHR = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SZ() {
        if (this.mContext != null) {
            View contentView = getContentView();
            bpe();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.bOX = new PopupWindow(contentView, this.bPa, this.mWindowHeight);
            this.bOX.setFocusable(true);
            this.bOX.setTouchable(true);
            this.bOX.setOnDismissListener(this.bPk);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bOX.setAttachedInDecor(false);
            }
            if (!this.gHV) {
                MessageManager.getInstance().registerListener(this.gHY);
                this.gHV = true;
            }
            this.bPe = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.bPe.setFocusable(false);
            this.bPe.setTouchable(false);
            this.bPe.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.bPa, this.bPc, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.bOX.setAnimationStyle(d.k.scale_rb2lt_anim);
                    aj.a(this.bOX, d.f.bg_home_feedback_under);
                } else {
                    this.bOX.setAnimationStyle(d.k.scale_rt2lb_anim);
                    aj.a(this.bOX, d.f.bg_home_feedback_top);
                }
                this.bOX.showAtLocation(getRootView(), 0, iArr[0] - this.Id, iArr[1]);
            }
        }
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        try {
            this.mContentView.measure(0, 0);
            return this.mContentView.getMeasuredHeight() + l.t(this.mContext, d.e.ds12);
        } catch (Exception e) {
            return 0;
        }
    }

    private void bpe() {
        if (this.gHT != null && this.gHT.size() > 0) {
            int size = this.gHT.size();
            this.gHQ.setVisibility(0);
            int i = 0;
            for (int i2 = 0; i2 < Math.ceil(size / 2.0d); i2++) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.ad_close_row_view, (ViewGroup) null);
                linearLayout.setOrientation(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 1;
                if (i2 != 0) {
                    layoutParams.topMargin = l.t(this.mContext, d.e.ds16);
                }
                linearLayout.setLayoutParams(layoutParams);
                this.gHQ.addView(linearLayout);
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
                    checkBox.setOnClickListener(this.gHW);
                    checkBox.setVisibility(0);
                    this.gHR.add(checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < this.gHT.size(); i5++) {
                this.gHR.get(i5).setText(this.gHT.get(i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ta() {
        if (this.bOX != null) {
            this.bOX.dismiss();
            this.bOX = null;
        }
        if (this.bPe != null) {
            this.bPe.dismiss();
            this.bPe = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gHV) {
            MessageManager.getInstance().unRegisterListener(this.gHY);
            this.gHV = false;
        }
        if (this.bPe != null) {
            this.bPe.dismiss();
            this.bPe = null;
        }
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int aq = l.aq(context);
        int ao = l.ao(context);
        boolean z = ((aq - iArr2[1]) - height) - i3 < i;
        iArr[0] = ao - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    public void setData(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null) {
            this.gHS = advertAppInfo;
            this.gHT.clear();
            if (this.gHS.aKR != null && this.gHS.aKR.aLm != null) {
                AdCloseInfo adCloseInfo = this.gHS.aKR.aLm;
                for (String str : adCloseInfo.reasons) {
                    this.gHT.add(str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(d.j.tell_us_reason);
                }
                this.gHU = adCloseInfo.confirm_title;
            }
        }
    }

    public void setPage(int i) {
        this.cLw = i;
    }

    public int getCloseViewWidth() {
        return l.t(this.mContext, d.e.ds96);
    }

    public int getCloseViewHeight() {
        return l.t(this.mContext, d.e.ds26);
    }

    public View getAdCloseView() {
        return this;
    }

    public void onChangeSkinType() {
        aj.c(this, d.f.icon_home_feedback_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.gHS == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.E(this.gHR)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gHR.size()) {
                    break;
                }
                CheckBox checkBox = this.gHR.get(i2);
                if (checkBox != null && checkBox.isChecked() && this.gHT != null && this.gHT.size() > i2) {
                    if (sb.length() != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append(this.gHT.get(i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bpf() {
        if (v.E(this.gHR)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.gHR.size(); i2++) {
            CheckBox checkBox = this.gHR.get(i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
