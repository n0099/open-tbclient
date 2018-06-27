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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdCloseInfo;
/* loaded from: classes3.dex */
public class AdCloseView extends ImageView {
    private View.OnClickListener bij;
    private PopupWindow bil;
    private int bio;
    private int biq;
    private PopupWindow bis;
    private PopupWindow.OnDismissListener biy;
    private int cmY;
    private TextView dvw;
    private LinearLayout gtg;
    private List<CheckBox> gth;
    private AdvertAppInfo gti;
    private List<String> gtj;
    private String gtk;
    private boolean gtl;
    private View.OnClickListener gtm;
    private View.OnClickListener gtn;
    private final CustomMessageListener gto;
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
        this.bil = null;
        this.bis = null;
        this.gth = null;
        this.gti = null;
        this.gtj = new ArrayList();
        this.gtl = false;
        this.bij = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.Po();
            }
        };
        this.gtm = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bpK = AdCloseView.this.bpK();
                if (bpK > 0) {
                    AdCloseView.this.dvw.setText(d.k.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_prefix));
                    int color = am.getColor(d.C0142d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bpK));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0142d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dvw.setText(d.k.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.gtn = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gti != null && AdCloseView.this.bil != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gti.aea));
                    AdCloseView.this.Pp();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cmY) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.gti.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.biy = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.bis != null) {
                    AdCloseView.this.bis.dismiss();
                    AdCloseView.this.bis = null;
                }
            }
        };
        this.gto = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.Pp();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.bil = null;
        this.bis = null;
        this.gth = null;
        this.gti = null;
        this.gtj = new ArrayList();
        this.gtl = false;
        this.bij = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.Po();
            }
        };
        this.gtm = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bpK = AdCloseView.this.bpK();
                if (bpK > 0) {
                    AdCloseView.this.dvw.setText(d.k.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_prefix));
                    int color = am.getColor(d.C0142d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bpK));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0142d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dvw.setText(d.k.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.gtn = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gti != null && AdCloseView.this.bil != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gti.aea));
                    AdCloseView.this.Pp();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cmY) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.gti.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.biy = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.bis != null) {
                    AdCloseView.this.bis.dismiss();
                    AdCloseView.this.bis = null;
                }
            }
        };
        this.gto = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.Pp();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.bil = null;
        this.bis = null;
        this.gth = null;
        this.gti = null;
        this.gtj = new ArrayList();
        this.gtl = false;
        this.bij = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.Po();
            }
        };
        this.gtm = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bpK = AdCloseView.this.bpK();
                if (bpK > 0) {
                    AdCloseView.this.dvw.setText(d.k.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_prefix));
                    int color = am.getColor(d.C0142d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bpK));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0142d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dvw.setText(d.k.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.gtn = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gti != null && AdCloseView.this.bil != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gti.aea));
                    AdCloseView.this.Pp();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cmY) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.gti.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.biy = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.bis != null) {
                    AdCloseView.this.bis.dismiss();
                    AdCloseView.this.bis = null;
                }
            }
        };
        this.gto = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.Pp();
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mXOffset = l.e(this.mContext, d.e.ds32);
        this.mYOffset = l.e(this.mContext, d.e.ds10);
        this.mWindowHeight = l.e(this.mContext, d.e.ds278);
        this.bio = l.ah(this.mContext) - (this.mXOffset * 2);
        this.biq = l.e(this.mContext, d.e.ds120);
        setOnClickListener(this.bij);
        am.c(this, d.f.icon_home_feedback_selector);
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
        this.dvw = (TextView) inflate.findViewById(d.g.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.gtk)) {
            this.dvw.setText(this.gtk);
        }
        this.dvw.setOnClickListener(this.gtn);
        am.c(this.mTitleTextView, d.C0142d.cp_cont_d, 1);
        am.c(this.dvw, d.C0142d.cp_cont_i, 1);
        am.i(this.dvw, d.f.bg_blue_rec_n);
        this.gtg = (LinearLayout) inflate.findViewById(d.g.reason_root_container);
        this.gth = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Po() {
        if (this.mContext != null) {
            View contentView = getContentView();
            bpJ();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.bil = new PopupWindow(contentView, this.bio, this.mWindowHeight);
            this.bil.setFocusable(true);
            this.bil.setTouchable(true);
            this.bil.setOnDismissListener(this.biy);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bil.setAttachedInDecor(false);
            }
            if (!this.gtl) {
                MessageManager.getInstance().registerListener(this.gto);
                this.gtl = true;
            }
            this.bis = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.i.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.bis.setFocusable(false);
            this.bis.setTouchable(false);
            this.bis.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.bio, this.biq, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.bil.setAnimationStyle(d.l.scale_rb2lt_anim);
                    am.a(this.bil, d.f.bg_home_feedback_under);
                } else {
                    this.bil.setAnimationStyle(d.l.scale_rt2lb_anim);
                    am.a(this.bil, d.f.bg_home_feedback_top);
                }
                this.bil.showAtLocation(getRootView(), 0, iArr[0] - this.mXOffset, iArr[1]);
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

    private void bpJ() {
        if (this.gtj != null && this.gtj.size() > 0) {
            int size = this.gtj.size();
            this.gtg.setVisibility(0);
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
                this.gtg.addView(linearLayout);
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
                    checkBox.setOnClickListener(this.gtm);
                    checkBox.setVisibility(0);
                    this.gth.add(checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < this.gtj.size(); i5++) {
                this.gth.get(i5).setText(this.gtj.get(i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pp() {
        if (this.bil != null) {
            this.bil.dismiss();
            this.bil = null;
        }
        if (this.bis != null) {
            this.bis.dismiss();
            this.bis = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gtl) {
            MessageManager.getInstance().unRegisterListener(this.gto);
            this.gtl = false;
        }
        if (this.bis != null) {
            this.bis.dismiss();
            this.bis = null;
        }
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int aj = l.aj(context);
        int ah = l.ah(context);
        boolean z = ((aj - iArr2[1]) - height) - i3 < i;
        iArr[0] = ah - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    public void setData(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null) {
            this.gti = advertAppInfo;
            this.gtj.clear();
            if (this.gti.aem != null && this.gti.aem.aeI != null) {
                AdCloseInfo adCloseInfo = this.gti.aem.aeI;
                for (String str : adCloseInfo.reasons) {
                    this.gtj.add(str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(d.k.tell_us_reason);
                }
                this.gtk = adCloseInfo.confirm_title;
            }
        }
    }

    public void setPage(int i) {
        this.cmY = i;
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
        am.c(this, d.f.icon_home_feedback_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.gti == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!w.A(this.gth)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gth.size()) {
                    break;
                }
                CheckBox checkBox = this.gth.get(i2);
                if (checkBox != null && checkBox.isChecked() && this.gtj != null && this.gtj.size() > i2) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(this.gtj.get(i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bpK() {
        if (w.A(this.gth)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.gth.size(); i2++) {
            CheckBox checkBox = this.gth.get(i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
