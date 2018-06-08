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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdCloseInfo;
/* loaded from: classes3.dex */
public class AdCloseView extends ImageView {
    private View.OnClickListener bgR;
    private PopupWindow bgT;
    private int bgW;
    private int bgY;
    private PopupWindow bha;
    private PopupWindow.OnDismissListener bhg;
    private int cku;
    private TextView dsn;
    private LinearLayout gpo;
    private List<CheckBox> gpp;
    private AdvertAppInfo gpq;
    private List<String> gpr;
    private String gps;
    private boolean gpt;
    private View.OnClickListener gpu;
    private View.OnClickListener gpv;
    private final CustomMessageListener gpw;
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
        this.bgT = null;
        this.bha = null;
        this.gpp = null;
        this.gpq = null;
        this.gpr = new ArrayList();
        this.gpt = false;
        this.bgR = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.OT();
            }
        };
        this.gpu = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bpj = AdCloseView.this.bpj();
                if (bpj > 0) {
                    AdCloseView.this.dsn.setText(d.k.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_prefix));
                    int color = al.getColor(d.C0141d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bpj));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0141d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dsn.setText(d.k.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.gpv = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gpq != null && AdCloseView.this.bgT != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gpq.adL));
                    AdCloseView.this.OU();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cku) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.gpq.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.bhg = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.bha != null) {
                    AdCloseView.this.bha.dismiss();
                    AdCloseView.this.bha = null;
                }
            }
        };
        this.gpw = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.OU();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.bgT = null;
        this.bha = null;
        this.gpp = null;
        this.gpq = null;
        this.gpr = new ArrayList();
        this.gpt = false;
        this.bgR = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.OT();
            }
        };
        this.gpu = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bpj = AdCloseView.this.bpj();
                if (bpj > 0) {
                    AdCloseView.this.dsn.setText(d.k.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_prefix));
                    int color = al.getColor(d.C0141d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bpj));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0141d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dsn.setText(d.k.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.gpv = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gpq != null && AdCloseView.this.bgT != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gpq.adL));
                    AdCloseView.this.OU();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cku) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.gpq.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.bhg = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.bha != null) {
                    AdCloseView.this.bha.dismiss();
                    AdCloseView.this.bha = null;
                }
            }
        };
        this.gpw = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.OU();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.bgT = null;
        this.bha = null;
        this.gpp = null;
        this.gpq = null;
        this.gpr = new ArrayList();
        this.gpt = false;
        this.bgR = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.OT();
            }
        };
        this.gpu = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bpj = AdCloseView.this.bpj();
                if (bpj > 0) {
                    AdCloseView.this.dsn.setText(d.k.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_prefix));
                    int color = al.getColor(d.C0141d.cp_cont_d);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bpj));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0141d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.k.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.dsn.setText(d.k.forbid_ad);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.gpv = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.gpq != null && AdCloseView.this.bgT != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.gpq.adL));
                    AdCloseView.this.OU();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.cku) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.gpq.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.bhg = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.bha != null) {
                    AdCloseView.this.bha.dismiss();
                    AdCloseView.this.bha = null;
                }
            }
        };
        this.gpw = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.OU();
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mXOffset = l.e(this.mContext, d.e.ds32);
        this.mYOffset = l.e(this.mContext, d.e.ds10);
        this.mWindowHeight = l.e(this.mContext, d.e.ds278);
        this.bgW = l.ah(this.mContext) - (this.mXOffset * 2);
        this.bgY = l.e(this.mContext, d.e.ds120);
        setOnClickListener(this.bgR);
        al.c(this, d.f.icon_home_feedback_selector);
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
        this.dsn = (TextView) inflate.findViewById(d.g.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.gps)) {
            this.dsn.setText(this.gps);
        }
        this.dsn.setOnClickListener(this.gpv);
        al.c(this.mTitleTextView, d.C0141d.cp_cont_d, 1);
        al.c(this.dsn, d.C0141d.cp_cont_i, 1);
        al.i(this.dsn, d.f.bg_blue_rec_n);
        this.gpo = (LinearLayout) inflate.findViewById(d.g.reason_root_container);
        this.gpp = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OT() {
        if (this.mContext != null) {
            View contentView = getContentView();
            bpi();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.bgT = new PopupWindow(contentView, this.bgW, this.mWindowHeight);
            this.bgT.setFocusable(true);
            this.bgT.setTouchable(true);
            this.bgT.setOnDismissListener(this.bhg);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bgT.setAttachedInDecor(false);
            }
            if (!this.gpt) {
                MessageManager.getInstance().registerListener(this.gpw);
                this.gpt = true;
            }
            this.bha = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.i.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.bha.setFocusable(false);
            this.bha.setTouchable(false);
            this.bha.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.bgW, this.bgY, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.bgT.setAnimationStyle(d.l.scale_rb2lt_anim);
                    al.a(this.bgT, d.f.bg_home_feedback_under);
                } else {
                    this.bgT.setAnimationStyle(d.l.scale_rt2lb_anim);
                    al.a(this.bgT, d.f.bg_home_feedback_top);
                }
                this.bgT.showAtLocation(getRootView(), 0, iArr[0] - this.mXOffset, iArr[1]);
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

    private void bpi() {
        if (this.gpr != null && this.gpr.size() > 0) {
            int size = this.gpr.size();
            this.gpo.setVisibility(0);
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
                this.gpo.addView(linearLayout);
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
                    checkBox.setOnClickListener(this.gpu);
                    checkBox.setVisibility(0);
                    this.gpp.add(checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < this.gpr.size(); i5++) {
                this.gpp.get(i5).setText(this.gpr.get(i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OU() {
        if (this.bgT != null) {
            this.bgT.dismiss();
            this.bgT = null;
        }
        if (this.bha != null) {
            this.bha.dismiss();
            this.bha = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gpt) {
            MessageManager.getInstance().unRegisterListener(this.gpw);
            this.gpt = false;
        }
        if (this.bha != null) {
            this.bha.dismiss();
            this.bha = null;
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
            this.gpq = advertAppInfo;
            this.gpr.clear();
            if (this.gpq.adX != null && this.gpq.adX.aet != null) {
                AdCloseInfo adCloseInfo = this.gpq.adX.aet;
                for (String str : adCloseInfo.reasons) {
                    this.gpr.add(str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(d.k.tell_us_reason);
                }
                this.gps = adCloseInfo.confirm_title;
            }
        }
    }

    public void setPage(int i) {
        this.cku = i;
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
        al.c(this, d.f.icon_home_feedback_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.gpq == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!w.z(this.gpp)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gpp.size()) {
                    break;
                }
                CheckBox checkBox = this.gpp.get(i2);
                if (checkBox != null && checkBox.isChecked() && this.gpr != null && this.gpr.size() > i2) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(this.gpr.get(i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bpj() {
        if (w.z(this.gpp)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.gpp.size(); i2++) {
            CheckBox checkBox = this.gpp.get(i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
