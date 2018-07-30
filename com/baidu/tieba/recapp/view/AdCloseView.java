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
    private View.OnClickListener biO;
    private PopupWindow biQ;
    private int biT;
    private int biV;
    private PopupWindow biX;
    private PopupWindow.OnDismissListener bjd;
    private int coM;
    private TextView dyj;
    private View.OnClickListener guA;
    private final CustomMessageListener guB;
    private LinearLayout gut;
    private List<CheckBox> guu;
    private AdvertAppInfo guv;
    private List<String> guw;
    private String gux;
    private boolean guy;
    private View.OnClickListener guz;
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
        this.biQ = null;
        this.biX = null;
        this.guu = null;
        this.guv = null;
        this.guw = new ArrayList();
        this.guy = false;
        this.biO = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.Pu();
            }
        };
        this.guz = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bop = AdCloseView.this.bop();
                if (bop > 0) {
                    AdCloseView.this.dyj.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = am.getColor(d.C0140d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bop));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0140d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dyj.setText(d.j.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.guA = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.guv != null && AdCloseView.this.biQ != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.guv.adE));
                    AdCloseView.this.Pv();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.coM) {
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
                    httpMessage.addParam("ext", AdCloseView.this.guv.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.bjd = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.biX != null) {
                    AdCloseView.this.biX.dismiss();
                    AdCloseView.this.biX = null;
                }
            }
        };
        this.guB = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.Pv();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.biQ = null;
        this.biX = null;
        this.guu = null;
        this.guv = null;
        this.guw = new ArrayList();
        this.guy = false;
        this.biO = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.Pu();
            }
        };
        this.guz = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bop = AdCloseView.this.bop();
                if (bop > 0) {
                    AdCloseView.this.dyj.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = am.getColor(d.C0140d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bop));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0140d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dyj.setText(d.j.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.guA = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.guv != null && AdCloseView.this.biQ != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.guv.adE));
                    AdCloseView.this.Pv();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.coM) {
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
                    httpMessage.addParam("ext", AdCloseView.this.guv.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.bjd = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.biX != null) {
                    AdCloseView.this.biX.dismiss();
                    AdCloseView.this.biX = null;
                }
            }
        };
        this.guB = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.Pv();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.biQ = null;
        this.biX = null;
        this.guu = null;
        this.guv = null;
        this.guw = new ArrayList();
        this.guy = false;
        this.biO = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.Pu();
            }
        };
        this.guz = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bop = AdCloseView.this.bop();
                if (bop > 0) {
                    AdCloseView.this.dyj.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = am.getColor(d.C0140d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bop));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0140d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dyj.setText(d.j.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.guA = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.guv != null && AdCloseView.this.biQ != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.guv.adE));
                    AdCloseView.this.Pv();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.coM) {
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
                    httpMessage.addParam("ext", AdCloseView.this.guv.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.bjd = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.biX != null) {
                    AdCloseView.this.biX.dismiss();
                    AdCloseView.this.biX = null;
                }
            }
        };
        this.guB = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.Pv();
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mXOffset = l.f(this.mContext, d.e.ds32);
        this.mYOffset = l.f(this.mContext, d.e.ds10);
        this.mWindowHeight = l.f(this.mContext, d.e.ds278);
        this.biT = l.ah(this.mContext) - (this.mXOffset * 2);
        this.biV = l.f(this.mContext, d.e.ds120);
        setOnClickListener(this.biO);
        am.c(this, d.f.icon_home_feedback_selector);
        setPadding(l.f(this.mContext, d.e.ds10), 0, 0, 0);
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.ad_close_popupwindow, (ViewGroup) null);
        this.mTitleTextView = (TextView) inflate.findViewById(d.g.head_text);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
        }
        this.dyj = (TextView) inflate.findViewById(d.g.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.gux)) {
            this.dyj.setText(this.gux);
        }
        this.dyj.setOnClickListener(this.guA);
        am.c(this.mTitleTextView, d.C0140d.cp_cont_d, 1);
        am.c(this.dyj, d.C0140d.cp_cont_i, 1);
        am.i(this.dyj, d.f.bg_blue_rec_n);
        this.gut = (LinearLayout) inflate.findViewById(d.g.reason_root_container);
        this.guu = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pu() {
        if (this.mContext != null) {
            Pv();
            View contentView = getContentView();
            boo();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.biQ = new PopupWindow(contentView, this.biT, this.mWindowHeight);
            this.biQ.setFocusable(true);
            this.biQ.setTouchable(true);
            this.biQ.setOnDismissListener(this.bjd);
            if (Build.VERSION.SDK_INT >= 22) {
                this.biQ.setAttachedInDecor(false);
            }
            if (!this.guy) {
                MessageManager.getInstance().registerListener(this.guB);
                this.guy = true;
            }
            this.biX = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.biX.setFocusable(false);
            this.biX.setTouchable(false);
            this.biX.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.biT, this.biV, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.biQ.setAnimationStyle(d.k.scale_rb2lt_anim);
                    am.a(this.biQ, d.f.bg_home_feedback_under);
                } else {
                    this.biQ.setAnimationStyle(d.k.scale_rt2lb_anim);
                    am.a(this.biQ, d.f.bg_home_feedback_top);
                }
                this.biQ.showAtLocation(getRootView(), 0, iArr[0] - this.mXOffset, iArr[1]);
            }
        }
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        try {
            this.mContentView.measure(0, 0);
            return this.mContentView.getMeasuredHeight() + l.f(this.mContext, d.e.ds12);
        } catch (Exception e) {
            return 0;
        }
    }

    private void boo() {
        if (this.guw != null && this.guw.size() > 0) {
            int size = this.guw.size();
            this.gut.setVisibility(0);
            int i = 0;
            for (int i2 = 0; i2 < Math.ceil(size / 2.0d); i2++) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.ad_close_row_view, (ViewGroup) null);
                linearLayout.setOrientation(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 1;
                if (i2 != 0) {
                    layoutParams.topMargin = l.f(this.mContext, d.e.ds16);
                }
                linearLayout.setLayoutParams(layoutParams);
                this.gut.addView(linearLayout);
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
                    checkBox.setOnClickListener(this.guz);
                    checkBox.setVisibility(0);
                    this.guu.add(checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < this.guw.size(); i5++) {
                this.guu.get(i5).setText(this.guw.get(i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pv() {
        if (this.biQ != null) {
            this.biQ.dismiss();
            this.biQ = null;
        }
        if (this.biX != null) {
            this.biX.dismiss();
            this.biX = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.guy) {
            MessageManager.getInstance().unRegisterListener(this.guB);
            this.guy = false;
        }
        if (this.biX != null) {
            if (this.biQ == null || !this.biQ.isShowing()) {
                this.biX.dismiss();
                this.biX = null;
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
            this.guv = advertAppInfo;
            this.guw.clear();
            if (this.guv.adQ != null && this.guv.adQ.adCloseInfo != null) {
                AdCloseInfo adCloseInfo = this.guv.adQ.adCloseInfo;
                for (String str : adCloseInfo.reasons) {
                    this.guw.add(str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(d.j.tell_us_reason);
                }
                this.gux = adCloseInfo.confirm_title;
            }
        }
    }

    public void setPage(int i) {
        this.coM = i;
    }

    public int getCloseViewWidth() {
        return l.f(this.mContext, d.e.ds96);
    }

    public int getCloseViewHeight() {
        return l.f(this.mContext, d.e.ds26);
    }

    public View getAdCloseView() {
        return this;
    }

    public void onChangeSkinType() {
        am.c(this, d.f.icon_home_feedback_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.guv == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!w.z(this.guu)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.guu.size()) {
                    break;
                }
                CheckBox checkBox = this.guu.get(i2);
                if (checkBox != null && checkBox.isChecked() && this.guw != null && this.guw.size() > i2) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(this.guw.get(i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bop() {
        if (w.z(this.guu)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.guu.size(); i2++) {
            CheckBox checkBox = this.guu.get(i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
