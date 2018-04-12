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
import com.baidu.tbadk.core.util.ak;
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
    private View.OnClickListener aYG;
    private PopupWindow aYI;
    private int aYL;
    private int aYN;
    private PopupWindow aYP;
    private PopupWindow.OnDismissListener aYV;
    private int cbx;
    private TextView dhV;
    private LinearLayout gcR;
    private List<CheckBox> gcS;
    private AdvertAppInfo gcT;
    private List<String> gcU;
    private String gcV;
    private boolean gcW;
    private View.OnClickListener gcX;
    private View.OnClickListener gcY;
    private final CustomMessageListener gcZ;
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
        this.aYI = null;
        this.aYP = null;
        this.gcS = null;
        this.gcT = null;
        this.gcU = new ArrayList();
        this.gcW = false;
        this.aYG = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AdCloseView.this.Lw();
            }
        };
        this.gcX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int bkm = AdCloseView.this.bkm();
                if (bkm > 0) {
                    AdCloseView.this.dhV.setText(d.k.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_prefix));
                    int color = ak.getColor(d.C0126d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bkm));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dhV.setText(d.k.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.gcY = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AdCloseView.this.gcT != null && AdCloseView.this.aYI != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gcT.VP));
                    AdCloseView.this.Lx();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cbx) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.gcT.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.aYV = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.aYP != null) {
                    AdCloseView.this.aYP.dismiss();
                    AdCloseView.this.aYP = null;
                }
            }
        };
        this.gcZ = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.Lx();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.aYI = null;
        this.aYP = null;
        this.gcS = null;
        this.gcT = null;
        this.gcU = new ArrayList();
        this.gcW = false;
        this.aYG = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AdCloseView.this.Lw();
            }
        };
        this.gcX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int bkm = AdCloseView.this.bkm();
                if (bkm > 0) {
                    AdCloseView.this.dhV.setText(d.k.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_prefix));
                    int color = ak.getColor(d.C0126d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bkm));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dhV.setText(d.k.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.gcY = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AdCloseView.this.gcT != null && AdCloseView.this.aYI != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gcT.VP));
                    AdCloseView.this.Lx();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cbx) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.gcT.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.aYV = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.aYP != null) {
                    AdCloseView.this.aYP.dismiss();
                    AdCloseView.this.aYP = null;
                }
            }
        };
        this.gcZ = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.Lx();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.aYI = null;
        this.aYP = null;
        this.gcS = null;
        this.gcT = null;
        this.gcU = new ArrayList();
        this.gcW = false;
        this.aYG = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AdCloseView.this.Lw();
            }
        };
        this.gcX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int bkm = AdCloseView.this.bkm();
                if (bkm > 0) {
                    AdCloseView.this.dhV.setText(d.k.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_prefix));
                    int color = ak.getColor(d.C0126d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bkm));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dhV.setText(d.k.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.gcY = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AdCloseView.this.gcT != null && AdCloseView.this.aYI != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gcT.VP));
                    AdCloseView.this.Lx();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cbx) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.gcT.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.aYV = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.aYP != null) {
                    AdCloseView.this.aYP.dismiss();
                    AdCloseView.this.aYP = null;
                }
            }
        };
        this.gcZ = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.Lx();
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mXOffset = l.e(this.mContext, d.e.ds32);
        this.mYOffset = l.e(this.mContext, d.e.ds10);
        this.mWindowHeight = l.e(this.mContext, d.e.ds278);
        this.aYL = l.af(this.mContext) - (this.mXOffset * 2);
        this.aYN = l.e(this.mContext, d.e.ds120);
        setOnClickListener(this.aYG);
        ak.c(this, d.f.icon_home_feedback_selector);
        setPadding(l.e(this.mContext, d.e.ds10), 0, 0, 0);
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.ad_close_popupwindow, (ViewGroup) null);
        this.mTitleTextView = (TextView) inflate.findViewById(d.g.head_text);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
        }
        this.dhV = (TextView) inflate.findViewById(d.g.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.gcV)) {
            this.dhV.setText(this.gcV);
        }
        this.dhV.setOnClickListener(this.gcY);
        ak.c(this.mTitleTextView, d.C0126d.cp_cont_d, 1);
        ak.c(this.dhV, d.C0126d.cp_cont_i, 1);
        ak.i(this.dhV, d.f.bg_blue_rec_n);
        this.gcR = (LinearLayout) inflate.findViewById(d.g.reason_root_container);
        this.gcS = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lw() {
        if (this.mContext != null) {
            View contentView = getContentView();
            bkl();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.aYI = new PopupWindow(contentView, this.aYL, this.mWindowHeight);
            this.aYI.setFocusable(true);
            this.aYI.setTouchable(true);
            this.aYI.setOnDismissListener(this.aYV);
            if (Build.VERSION.SDK_INT >= 22) {
                this.aYI.setAttachedInDecor(false);
            }
            if (!this.gcW) {
                MessageManager.getInstance().registerListener(this.gcZ);
                this.gcW = true;
            }
            this.aYP = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.i.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.aYP.setFocusable(false);
            this.aYP.setTouchable(false);
            this.aYP.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.aYL, this.aYN, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aYI.setAnimationStyle(d.l.scale_rb2lt_anim);
                    ak.a(this.aYI, d.f.bg_home_feedback_under);
                } else {
                    this.aYI.setAnimationStyle(d.l.scale_rt2lb_anim);
                    ak.a(this.aYI, d.f.bg_home_feedback_top);
                }
                this.aYI.showAtLocation(getRootView(), 0, iArr[0] - this.mXOffset, iArr[1]);
            }
        }
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        try {
            this.mContentView.measure(0, 0);
            return this.mContentView.getMeasuredHeight() + l.e(this.mContext, d.e.ds12);
        } catch (Exception e) {
            return 0;
        }
    }

    private void bkl() {
        if (this.gcU != null && this.gcU.size() > 0) {
            int size = this.gcU.size();
            this.gcR.setVisibility(0);
            int i = 0;
            for (int i2 = 0; i2 < Math.ceil(size / 2.0d); i2++) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.i.ad_close_row_view, (ViewGroup) null);
                linearLayout.setOrientation(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 1;
                if (i2 != 0) {
                    layoutParams.topMargin = l.e(this.mContext, d.e.ds16);
                }
                linearLayout.setLayoutParams(layoutParams);
                this.gcR.addView(linearLayout);
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
                    checkBox.setOnClickListener(this.gcX);
                    checkBox.setVisibility(0);
                    this.gcS.add(checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < this.gcU.size(); i5++) {
                this.gcS.get(i5).setText(this.gcU.get(i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lx() {
        if (this.aYI != null) {
            this.aYI.dismiss();
            this.aYI = null;
        }
        if (this.aYP != null) {
            this.aYP.dismiss();
            this.aYP = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gcW) {
            MessageManager.getInstance().unRegisterListener(this.gcZ);
            this.gcW = false;
        }
        if (this.aYP != null) {
            this.aYP.dismiss();
            this.aYP = null;
        }
    }

    private boolean a(Context context, View view2, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view2 == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view2.getLocationOnScreen(iArr2);
        int height = view2.getHeight();
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
            this.gcT = advertAppInfo;
            this.gcU.clear();
            if (this.gcT.Wb != null && this.gcT.Wb.Ww != null) {
                AdCloseInfo adCloseInfo = this.gcT.Wb.Ww;
                for (String str : adCloseInfo.reasons) {
                    this.gcU.add(str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(d.k.tell_us_reason);
                }
                this.gcV = adCloseInfo.confirm_title;
            }
        }
    }

    public void setPage(int i) {
        this.cbx = i;
    }

    public int getCloseViewWidth() {
        return l.e(this.mContext, d.e.ds96);
    }

    public int getCloseViewHeight() {
        return l.e(this.mContext, d.e.ds26);
    }

    public View getAdCloseView() {
        return this;
    }

    public void onChangeSkinType() {
        ak.c(this, d.f.icon_home_feedback_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.gcT == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.w(this.gcS)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gcS.size()) {
                    break;
                }
                CheckBox checkBox = this.gcS.get(i2);
                if (checkBox != null && checkBox.isChecked() && this.gcU != null && this.gcU.size() > i2) {
                    if (sb.length() != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append(this.gcU.get(i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bkm() {
        if (v.w(this.gcS)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.gcS.size(); i2++) {
            CheckBox checkBox = this.gcS.get(i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
