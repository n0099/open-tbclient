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
    private int HY;
    private TextView Xh;
    private View.OnClickListener bOL;
    private PopupWindow bON;
    private int bOQ;
    private int bOS;
    private PopupWindow bOU;
    private PopupWindow.OnDismissListener bPa;
    private int cLn;
    private TextView dPq;
    private LinearLayout gHR;
    private List<CheckBox> gHS;
    private AdvertAppInfo gHT;
    private List<String> gHU;
    private String gHV;
    private boolean gHW;
    private View.OnClickListener gHX;
    private View.OnClickListener gHY;
    private final CustomMessageListener gHZ;
    private View mContentView;
    private Context mContext;
    private String mTitle;
    private int mWindowHeight;
    private int mYOffset;

    public AdCloseView(Context context) {
        super(context);
        this.mContext = null;
        this.bON = null;
        this.bOU = null;
        this.gHS = null;
        this.gHT = null;
        this.gHU = new ArrayList();
        this.gHW = false;
        this.bOL = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.SZ();
            }
        };
        this.gHX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bpf = AdCloseView.this.bpf();
                if (bpf > 0) {
                    AdCloseView.this.dPq.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = aj.getColor(d.C0141d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bpf));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0141d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.Xh.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dPq.setText(d.j.forbid_ad);
                AdCloseView.this.Xh.setText(AdCloseView.this.mTitle);
            }
        };
        this.gHY = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gHT != null && AdCloseView.this.bON != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gHT.aKv));
                    AdCloseView.this.Ta();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cLn) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.gHT.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.bPa = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.bOU != null) {
                    AdCloseView.this.bOU.dismiss();
                    AdCloseView.this.bOU = null;
                }
            }
        };
        this.gHZ = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
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
        this.bON = null;
        this.bOU = null;
        this.gHS = null;
        this.gHT = null;
        this.gHU = new ArrayList();
        this.gHW = false;
        this.bOL = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.SZ();
            }
        };
        this.gHX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bpf = AdCloseView.this.bpf();
                if (bpf > 0) {
                    AdCloseView.this.dPq.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = aj.getColor(d.C0141d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bpf));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0141d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.Xh.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dPq.setText(d.j.forbid_ad);
                AdCloseView.this.Xh.setText(AdCloseView.this.mTitle);
            }
        };
        this.gHY = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gHT != null && AdCloseView.this.bON != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gHT.aKv));
                    AdCloseView.this.Ta();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cLn) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.gHT.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.bPa = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.bOU != null) {
                    AdCloseView.this.bOU.dismiss();
                    AdCloseView.this.bOU = null;
                }
            }
        };
        this.gHZ = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
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
        this.bON = null;
        this.bOU = null;
        this.gHS = null;
        this.gHT = null;
        this.gHU = new ArrayList();
        this.gHW = false;
        this.bOL = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.SZ();
            }
        };
        this.gHX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bpf = AdCloseView.this.bpf();
                if (bpf > 0) {
                    AdCloseView.this.dPq.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = aj.getColor(d.C0141d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bpf));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0141d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.Xh.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dPq.setText(d.j.forbid_ad);
                AdCloseView.this.Xh.setText(AdCloseView.this.mTitle);
            }
        };
        this.gHY = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gHT != null && AdCloseView.this.bON != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gHT.aKv));
                    AdCloseView.this.Ta();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cLn) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.gHT.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.bPa = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.bOU != null) {
                    AdCloseView.this.bOU.dismiss();
                    AdCloseView.this.bOU = null;
                }
            }
        };
        this.gHZ = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
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
        this.HY = l.t(this.mContext, d.e.ds32);
        this.mYOffset = l.t(this.mContext, d.e.ds10);
        this.mWindowHeight = l.t(this.mContext, d.e.ds278);
        this.bOQ = l.ao(this.mContext) - (this.HY * 2);
        this.bOS = l.t(this.mContext, d.e.ds120);
        setOnClickListener(this.bOL);
        aj.c(this, d.f.icon_home_feedback_selector);
        setPadding(l.t(this.mContext, d.e.ds10), 0, 0, 0);
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.ad_close_popupwindow, (ViewGroup) null);
        this.Xh = (TextView) inflate.findViewById(d.g.head_text);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.Xh.setText(this.mTitle);
        }
        this.dPq = (TextView) inflate.findViewById(d.g.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.gHV)) {
            this.dPq.setText(this.gHV);
        }
        this.dPq.setOnClickListener(this.gHY);
        aj.e(this.Xh, d.C0141d.cp_cont_d, 1);
        aj.e(this.dPq, d.C0141d.cp_cont_i, 1);
        aj.s(this.dPq, d.f.bg_blue_rec_n);
        this.gHR = (LinearLayout) inflate.findViewById(d.g.reason_root_container);
        this.gHS = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SZ() {
        if (this.mContext != null) {
            View contentView = getContentView();
            bpe();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.bON = new PopupWindow(contentView, this.bOQ, this.mWindowHeight);
            this.bON.setFocusable(true);
            this.bON.setTouchable(true);
            this.bON.setOnDismissListener(this.bPa);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bON.setAttachedInDecor(false);
            }
            if (!this.gHW) {
                MessageManager.getInstance().registerListener(this.gHZ);
                this.gHW = true;
            }
            this.bOU = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.bOU.setFocusable(false);
            this.bOU.setTouchable(false);
            this.bOU.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.bOQ, this.bOS, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.bON.setAnimationStyle(d.k.scale_rb2lt_anim);
                    aj.a(this.bON, d.f.bg_home_feedback_under);
                } else {
                    this.bON.setAnimationStyle(d.k.scale_rt2lb_anim);
                    aj.a(this.bON, d.f.bg_home_feedback_top);
                }
                this.bON.showAtLocation(getRootView(), 0, iArr[0] - this.HY, iArr[1]);
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
        if (this.gHU != null && this.gHU.size() > 0) {
            int size = this.gHU.size();
            this.gHR.setVisibility(0);
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
                this.gHR.addView(linearLayout);
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
                    checkBox.setOnClickListener(this.gHX);
                    checkBox.setVisibility(0);
                    this.gHS.add(checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < this.gHU.size(); i5++) {
                this.gHS.get(i5).setText(this.gHU.get(i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ta() {
        if (this.bON != null) {
            this.bON.dismiss();
            this.bON = null;
        }
        if (this.bOU != null) {
            this.bOU.dismiss();
            this.bOU = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gHW) {
            MessageManager.getInstance().unRegisterListener(this.gHZ);
            this.gHW = false;
        }
        if (this.bOU != null) {
            this.bOU.dismiss();
            this.bOU = null;
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
            this.gHT = advertAppInfo;
            this.gHU.clear();
            if (this.gHT.aKH != null && this.gHT.aKH.aLc != null) {
                AdCloseInfo adCloseInfo = this.gHT.aKH.aLc;
                for (String str : adCloseInfo.reasons) {
                    this.gHU.add(str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(d.j.tell_us_reason);
                }
                this.gHV = adCloseInfo.confirm_title;
            }
        }
    }

    public void setPage(int i) {
        this.cLn = i;
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
        if (this.gHT == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.E(this.gHS)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gHS.size()) {
                    break;
                }
                CheckBox checkBox = this.gHS.get(i2);
                if (checkBox != null && checkBox.isChecked() && this.gHU != null && this.gHU.size() > i2) {
                    if (sb.length() != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append(this.gHU.get(i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bpf() {
        if (v.E(this.gHS)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.gHS.size(); i2++) {
            CheckBox checkBox = this.gHS.get(i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
