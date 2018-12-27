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
import com.baidu.tieba.ad.a;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActionControl;
import tbclient.AdCloseInfo;
/* loaded from: classes3.dex */
public class AdCloseView extends ImageView {
    private View.OnClickListener bwT;
    private int bwX;
    private int bwZ;
    private PopupWindow bxb;
    private PopupWindow.OnDismissListener bxh;
    private int cJk;
    private TextView dXn;
    private List<CheckBox> gUA;
    private AdvertAppInfo gUB;
    private ActionControl gUC;
    private List<String> gUD;
    private String gUE;
    private boolean gUF;
    private View.OnClickListener gUG;
    private View.OnClickListener gUH;
    private final CustomMessageListener gUI;
    private View.OnClickListener gUJ;
    private LinearLayout gUx;
    private TextView gUy;
    private ImageView gUz;
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
        this.bxb = null;
        this.gUA = null;
        this.gUB = null;
        this.gUD = new ArrayList();
        this.gUF = false;
        this.bwT = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.UA();
            }
        };
        this.gUG = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bwo = AdCloseView.this.bwo();
                if (bwo > 0) {
                    AdCloseView.this.dXn.setText(e.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(e.j.ad_close_title_prefix));
                    int color = al.getColor(e.d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bwo));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(e.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dXn.setText(e.j.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.gUH = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gUB != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gUB.apq));
                    AdCloseView.this.UB();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cJk) {
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
                    httpMessage.addParam("ext", AdCloseView.this.gUB.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.bxh = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.bxb != null) {
                    AdCloseView.this.bxb.dismiss();
                    AdCloseView.this.bxb = null;
                }
            }
        };
        this.gUI = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.UB();
            }
        };
        this.gUJ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.bwm();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mPopupWindow = null;
        this.bxb = null;
        this.gUA = null;
        this.gUB = null;
        this.gUD = new ArrayList();
        this.gUF = false;
        this.bwT = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.UA();
            }
        };
        this.gUG = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bwo = AdCloseView.this.bwo();
                if (bwo > 0) {
                    AdCloseView.this.dXn.setText(e.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(e.j.ad_close_title_prefix));
                    int color = al.getColor(e.d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bwo));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(e.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dXn.setText(e.j.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.gUH = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gUB != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gUB.apq));
                    AdCloseView.this.UB();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cJk) {
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
                    httpMessage.addParam("ext", AdCloseView.this.gUB.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.bxh = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.bxb != null) {
                    AdCloseView.this.bxb.dismiss();
                    AdCloseView.this.bxb = null;
                }
            }
        };
        this.gUI = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.UB();
            }
        };
        this.gUJ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.bwm();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mPopupWindow = null;
        this.bxb = null;
        this.gUA = null;
        this.gUB = null;
        this.gUD = new ArrayList();
        this.gUF = false;
        this.bwT = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.UA();
            }
        };
        this.gUG = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bwo = AdCloseView.this.bwo();
                if (bwo > 0) {
                    AdCloseView.this.dXn.setText(e.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(e.j.ad_close_title_prefix));
                    int color = al.getColor(e.d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bwo));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(e.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dXn.setText(e.j.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.gUH = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gUB != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gUB.apq));
                    AdCloseView.this.UB();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cJk) {
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
                    httpMessage.addParam("ext", AdCloseView.this.gUB.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.bxh = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.bxb != null) {
                    AdCloseView.this.bxb.dismiss();
                    AdCloseView.this.bxb = null;
                }
            }
        };
        this.gUI = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.UB();
            }
        };
        this.gUJ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.bwm();
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mXOffset = l.h(this.mContext, e.C0210e.ds32);
        this.mYOffset = l.h(this.mContext, e.C0210e.ds10);
        this.mWindowHeight = l.h(this.mContext, e.C0210e.ds278);
        this.bwX = l.aO(this.mContext) - (this.mXOffset * 2);
        this.bwZ = l.h(this.mContext, e.C0210e.ds120);
        setOnClickListener(this.bwT);
        al.c(this, e.f.icon_home_feedback_selector);
        setPadding(l.h(this.mContext, e.C0210e.ds10), 0, 0, 0);
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.ad_close_popupwindow, (ViewGroup) null);
        this.mTitleTextView = (TextView) inflate.findViewById(e.g.head_text);
        View findViewById = inflate.findViewById(e.g.ad_show_reason_wrapper);
        this.gUy = (TextView) inflate.findViewById(e.g.ad_show_reason);
        this.gUz = (ImageView) inflate.findViewById(e.g.arrow_right);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
        }
        this.dXn = (TextView) inflate.findViewById(e.g.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.gUE)) {
            this.dXn.setText(this.gUE);
        }
        this.dXn.setOnClickListener(this.gUH);
        if (bwn()) {
            this.gUy.setText(this.gUC.name);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this.gUJ);
        }
        al.c(this.mTitleTextView, e.d.cp_cont_d, 1);
        al.c(this.dXn, e.d.cp_cont_i, 1);
        al.c(this.gUy, e.d.cp_other_i, 1);
        al.i(this.dXn, e.f.bg_blue_rec_n);
        this.gUz.setImageDrawable(al.getDrawable(e.f.icon_ad_dislike_arrow20_right_n));
        this.gUx = (LinearLayout) inflate.findViewById(e.g.reason_root_container);
        this.gUA = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UA() {
        if (this.mContext != null) {
            UB();
            View contentView = getContentView();
            bwl();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.mPopupWindow = new PopupWindow(contentView, this.bwX, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.bxh);
            if (Build.VERSION.SDK_INT >= 22) {
                this.mPopupWindow.setAttachedInDecor(false);
            }
            if (!this.gUF) {
                MessageManager.getInstance().registerListener(this.gUI);
                this.gUF = true;
            }
            this.bxb = new PopupWindow(LayoutInflater.from(this.mContext).inflate(e.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.bxb.setFocusable(false);
            this.bxb.setTouchable(false);
            this.bxb.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.bwX, this.bwZ, this.mYOffset, iArr);
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
            return this.mContentView.getMeasuredHeight() + l.h(this.mContext, e.C0210e.ds12);
        } catch (Exception e) {
            return 0;
        }
    }

    private void bwl() {
        if (this.gUD != null && this.gUD.size() > 0) {
            int size = this.gUD.size();
            this.gUx.setVisibility(0);
            int i = 0;
            for (int i2 = 0; i2 < Math.ceil(size / 2.0d); i2++) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(e.h.ad_close_row_view, (ViewGroup) null);
                linearLayout.setOrientation(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 1;
                if (i2 != 0) {
                    layoutParams.topMargin = l.h(this.mContext, e.C0210e.ds16);
                }
                linearLayout.setLayoutParams(layoutParams);
                this.gUx.addView(linearLayout);
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
                    checkBox.setOnClickListener(this.gUG);
                    checkBox.setVisibility(0);
                    this.gUA.add(checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < this.gUD.size(); i5++) {
                this.gUA.get(i5).setText(this.gUD.get(i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UB() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.bxb != null) {
            this.bxb.dismiss();
            this.bxb = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gUF) {
            MessageManager.getInstance().unRegisterListener(this.gUI);
            this.gUF = false;
        }
        if (this.bxb != null) {
            if (this.mPopupWindow == null || !this.mPopupWindow.isShowing()) {
                this.bxb.dismiss();
                this.bxb = null;
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
            this.gUB = advertAppInfo;
            this.gUD.clear();
            if (this.gUB.apB != null && this.gUB.apB.adCloseInfo != null) {
                AdCloseInfo adCloseInfo = this.gUB.apB.adCloseInfo;
                this.gUC = adCloseInfo.action_control;
                for (String str : adCloseInfo.reasons) {
                    this.gUD.add(str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(e.j.tell_us_reason);
                }
                this.gUE = adCloseInfo.confirm_title;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwm() {
        if (bwn()) {
            a.Wi().d(getContext(), new String[]{this.gUC.url});
        }
    }

    private boolean bwn() {
        return (this.gUC == null || TextUtils.isEmpty(this.gUC.url) || TextUtils.isEmpty(this.gUC.name)) ? false : true;
    }

    public void setPage(int i) {
        this.cJk = i;
    }

    public int getCloseViewWidth() {
        return l.h(this.mContext, e.C0210e.ds96);
    }

    public int getCloseViewHeight() {
        return l.h(this.mContext, e.C0210e.ds26);
    }

    public View getAdCloseView() {
        return this;
    }

    public void onChangeSkinType() {
        al.c(this, e.f.icon_home_feedback_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.gUB == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.I(this.gUA)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gUA.size()) {
                    break;
                }
                CheckBox checkBox = this.gUA.get(i2);
                if (checkBox != null && checkBox.isChecked() && this.gUD != null && this.gUD.size() > i2) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(this.gUD.get(i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bwo() {
        if (v.I(this.gUA)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.gUA.size(); i2++) {
            CheckBox checkBox = this.gUA.get(i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
