package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.constants.PlaceId;
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.n0.r.f0.m.b;
import d.a.o0.k1.o.k.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActionControl;
import tbclient.AdCloseInfo;
/* loaded from: classes5.dex */
public class AdCloseView extends FrameLayout {
    public int A;
    public int B;
    public long C;
    public boolean D;
    public int E;
    public View.OnClickListener F;
    public View.OnClickListener G;
    public View.OnClickListener H;
    public PopupWindow.OnDismissListener I;
    public final CustomMessageListener J;
    public View.OnClickListener K;

    /* renamed from: e  reason: collision with root package name */
    public Context f20403e;

    /* renamed from: f  reason: collision with root package name */
    public PopupWindow f20404f;

    /* renamed from: g  reason: collision with root package name */
    public PopupWindow f20405g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f20406h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f20407i;
    public b j;
    public TextView k;
    public RelativeLayout l;
    public EMTextView m;
    public ImageView n;
    public ImageView o;
    public int p;
    public List<CheckBox> q;
    public AdvertAppInfo r;
    public ActionControl s;
    public List<String> t;
    public String u;
    public String v;
    public int w;
    public int x;
    public View y;
    public int z;

    public AdCloseView(Context context) {
        super(context);
        this.f20403e = null;
        this.f20404f = null;
        this.f20405g = null;
        this.p = R.drawable.icon_pure_card_close22;
        this.q = null;
        this.r = null;
        this.t = new ArrayList();
        this.C = 0L;
        this.D = false;
        this.F = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.C > 500) {
                    AdCloseView.this.r();
                    AdCloseView.this.C = currentTimeMillis;
                }
            }
        };
        this.G = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int n = AdCloseView.this.n();
                if (n > 0) {
                    AdCloseView adCloseView = AdCloseView.this;
                    adCloseView.f20407i.setText(adCloseView.f20403e.getResources().getString(R.string.confirm));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.f20403e.getString(R.string.ad_close_title_prefix));
                    int color = SkinManager.getColor(R.color.CAM_X0105);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(n));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.f20403e.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.k.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView adCloseView2 = AdCloseView.this;
                adCloseView2.f20407i.setText(adCloseView2.f20403e.getResources().getString(R.string.ad_no_interest));
                AdCloseView adCloseView3 = AdCloseView.this;
                adCloseView3.k.setText(adCloseView3.u);
            }
        };
        this.H = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.r != null) {
                    AdCloseView adCloseView = AdCloseView.this;
                    if (adCloseView.f20404f == null) {
                        return;
                    }
                    String selectedResultJsonObj = adCloseView.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.r.J3));
                    AdCloseView.this.o();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    int i2 = AdCloseView.this.E;
                    if (i2 == 1) {
                        httpMessage.addParam("pi", PlaceId.FRS.value);
                    } else if (i2 == 2 || i2 == 3) {
                        httpMessage.addParam("pi", PlaceId.HOMEPAGE.value);
                    } else if (i2 == 4) {
                        httpMessage.addParam("pi", PlaceId.PB_BANNER.value);
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.r.Q3);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.I = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                PopupWindow popupWindow = AdCloseView.this.f20405g;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                    AdCloseView.this.f20405g = null;
                }
            }
        };
        this.J = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.o();
            }
        };
        this.K = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.p();
            }
        };
        this.f20403e = context;
        q();
    }

    private View getContentView() {
        Context context = this.f20403e;
        if (context == null) {
            return null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.ad_close_popupwindow, (ViewGroup) null);
        this.k = (TextView) inflate.findViewById(R.id.head_text);
        this.l = (RelativeLayout) inflate.findViewById(R.id.top_area);
        View findViewById = inflate.findViewById(R.id.ad_show_reason_wrapper);
        this.m = (EMTextView) inflate.findViewById(R.id.ad_show_reason);
        this.n = (ImageView) inflate.findViewById(R.id.arrow_right);
        if (!TextUtils.isEmpty(this.u)) {
            this.k.setText(this.u);
        }
        this.f20407i = (TBSpecificationBtn) inflate.findViewById(R.id.forbid_thread_btn);
        b bVar = new b();
        this.j = bVar;
        bVar.q(R.color.CAM_X0304);
        this.f20407i.setConfig(this.j);
        if (!TextUtils.isEmpty(this.v)) {
            this.f20407i.setText(this.v);
        } else {
            this.f20407i.setText(this.f20403e.getResources().getString(R.string.ad_no_interest));
        }
        this.f20407i.setOnClickListener(this.H);
        if (m()) {
            this.m.setText(this.s.name);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this.K);
        }
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
        this.n.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_ad_dislike_arrow20_right_n));
        this.f20406h = (LinearLayout) inflate.findViewById(R.id.reason_root_container);
        this.q = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.r == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!a.e(this.q)) {
            for (int i2 = 0; i2 < a.k(this.q); i2++) {
                CheckBox checkBox = (CheckBox) a.d(this.q, i2);
                if (checkBox != null && checkBox.isChecked() && a.k(this.t) > i2) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append((String) a.d(this.t, i2));
                }
            }
        }
        return sb.toString();
    }

    private int getWindowMeasuredHeight() {
        View view = this.y;
        if (view == null) {
            return 0;
        }
        try {
            view.measure(0, 0);
            return this.y.getMeasuredHeight();
        } catch (Exception unused) {
            return 0;
        }
    }

    public View getAdCloseView() {
        return this;
    }

    public int getCloseViewHeight() {
        return l.g(this.f20403e, R.dimen.tbds72);
    }

    public int getCloseViewWidth() {
        return l.g(this.f20403e, R.dimen.tbds72);
    }

    public final void k() {
        if (a.e(this.t)) {
            return;
        }
        int k = a.k(this.t);
        this.f20406h.setVisibility(0);
        int i2 = 0;
        for (int i3 = 0; i3 < Math.ceil(k / 2.0d); i3++) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f20403e).inflate(R.layout.ad_close_row_view, (ViewGroup) null);
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 1;
            if (i3 != 0) {
                layoutParams.topMargin = l.g(this.f20403e, R.dimen.M_H_X003);
            }
            linearLayout.setLayoutParams(layoutParams);
            this.f20406h.addView(linearLayout);
            for (int i4 = 0; i4 < linearLayout.getChildCount() && (i2 = i2 + 1) <= k; i4++) {
                CheckBox checkBox = (CheckBox) linearLayout.getChildAt(i4);
                checkBox.setOnClickListener(this.G);
                checkBox.setVisibility(0);
                a.a(this.q, checkBox);
            }
        }
        for (int i5 = 0; i5 < a.k(this.t); i5++) {
            String str = (String) a.d(this.t, i5);
            CheckBox checkBox2 = (CheckBox) a.d(this.q, i5);
            if (checkBox2 != null) {
                checkBox2.setText(str);
            }
        }
    }

    public final boolean l(Context context, View view, int i2, int i3, int i4, int i5, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int i6 = l.i(context);
        int k = l.k(context);
        boolean z = ((i6 - iArr2[1]) - height) - i4 < i2;
        iArr[0] = k - i3;
        if (z) {
            iArr[1] = (iArr2[1] - i2) - i5;
        } else {
            iArr[1] = iArr2[1] + height + i5;
        }
        return z;
    }

    public final boolean m() {
        ActionControl actionControl = this.s;
        return (actionControl == null || TextUtils.isEmpty(actionControl.url) || TextUtils.isEmpty(this.s.name)) ? false : true;
    }

    public final int n() {
        if (a.e(this.q)) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < a.k(this.q); i3++) {
            CheckBox checkBox = (CheckBox) a.d(this.q, i3);
            if (checkBox != null && checkBox.isChecked()) {
                i2++;
            }
        }
        return i2;
    }

    public final void o() {
        PopupWindow popupWindow = this.f20404f;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.f20404f = null;
        }
        PopupWindow popupWindow2 = this.f20405g;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
            this.f20405g = null;
        }
    }

    public void onChangeSkinType() {
        this.o.setImageDrawable(WebPManager.getPureDrawable(this.p, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.D) {
            MessageManager.getInstance().unRegisterListener(this.J);
            this.D = false;
        }
        if (this.f20405g != null) {
            PopupWindow popupWindow = this.f20404f;
            if (popupWindow == null || !popupWindow.isShowing()) {
                this.f20405g.dismiss();
                this.f20405g = null;
            }
        }
    }

    public final void p() {
        if (m()) {
            d.a.o0.q.a.l().c(getContext(), new String[]{this.s.url}, null);
        }
    }

    public void q() {
        this.o = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.tbds72), getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
        layoutParams.gravity = 21;
        addView(this.o, layoutParams);
        this.A = l.g(this.f20403e, R.dimen.M_W_X004);
        this.B = l.g(this.f20403e, R.dimen.ds10);
        this.w = l.g(this.f20403e, R.dimen.ds278);
        this.x = l.k(this.f20403e) - (this.A * 2);
        this.z = l.g(this.f20403e, R.dimen.ds120);
        setOnClickListener(this.F);
        this.o.setImageDrawable(WebPManager.getPureDrawable(this.p, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public final void r() {
        if (this.f20403e == null || FullBrowseHelper.checkAndShowFullBrowseModeDialog(j.a(getContext()), null)) {
            return;
        }
        o();
        View contentView = getContentView();
        k();
        this.y = contentView;
        this.w = getWindowMeasuredHeight();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0204));
        gradientDrawable.setCornerRadius(l.g(this.f20403e, R.dimen.tbds31));
        this.y.setBackgroundDrawable(gradientDrawable);
        PopupWindow popupWindow = new PopupWindow(contentView, this.x, this.w);
        this.f20404f = popupWindow;
        popupWindow.setFocusable(true);
        this.f20404f.setTouchable(true);
        this.f20404f.setOnDismissListener(this.I);
        if (Build.VERSION.SDK_INT >= 22) {
            this.f20404f.setAttachedInDecor(false);
        }
        if (!this.D) {
            MessageManager.getInstance().registerListener(this.J);
            this.D = true;
        }
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f20403e).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.f20405g = popupWindow2;
        popupWindow2.setFocusable(false);
        this.f20405g.setTouchable(false);
        if (Build.VERSION.SDK_INT >= 22) {
            this.f20405g.setAttachedInDecor(false);
        }
        this.f20405g.showAtLocation(this, 0, 0, 0);
        int[] iArr = new int[2];
        boolean l = l(this.f20403e, this, this.w, this.x, this.z, this.B, iArr);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.f20404f.setBackgroundDrawable(new ColorDrawable(0));
        if (l) {
            this.f20404f.setAnimationStyle(R.style.scale_rb2lt_anim);
        } else {
            this.f20404f.setAnimationStyle(R.style.scale_rt2lb_anim);
        }
        this.f20404f.showAtLocation(getRootView(), 0, iArr[0] - this.A, iArr[1]);
    }

    public void setData(AdvertAppInfo advertAppInfo, AdCloseInfo adCloseInfo) {
        if (advertAppInfo == null) {
            return;
        }
        this.r = advertAppInfo;
        a.c(this.t);
        if (adCloseInfo != null) {
            this.s = adCloseInfo.action_control;
            for (String str : adCloseInfo.reasons) {
                a.a(this.t, str);
            }
            String str2 = adCloseInfo.title;
            this.u = str2;
            if (TextUtils.isEmpty(str2)) {
                this.u = this.f20403e.getString(R.string.tell_us_reason);
            }
            this.v = adCloseInfo.confirm_title;
        }
    }

    public void setPage(int i2) {
        this.E = i2;
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20403e = null;
        this.f20404f = null;
        this.f20405g = null;
        this.p = R.drawable.icon_pure_card_close22;
        this.q = null;
        this.r = null;
        this.t = new ArrayList();
        this.C = 0L;
        this.D = false;
        this.F = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.C > 500) {
                    AdCloseView.this.r();
                    AdCloseView.this.C = currentTimeMillis;
                }
            }
        };
        this.G = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int n = AdCloseView.this.n();
                if (n > 0) {
                    AdCloseView adCloseView = AdCloseView.this;
                    adCloseView.f20407i.setText(adCloseView.f20403e.getResources().getString(R.string.confirm));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.f20403e.getString(R.string.ad_close_title_prefix));
                    int color = SkinManager.getColor(R.color.CAM_X0105);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(n));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.f20403e.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.k.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView adCloseView2 = AdCloseView.this;
                adCloseView2.f20407i.setText(adCloseView2.f20403e.getResources().getString(R.string.ad_no_interest));
                AdCloseView adCloseView3 = AdCloseView.this;
                adCloseView3.k.setText(adCloseView3.u);
            }
        };
        this.H = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.r != null) {
                    AdCloseView adCloseView = AdCloseView.this;
                    if (adCloseView.f20404f == null) {
                        return;
                    }
                    String selectedResultJsonObj = adCloseView.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.r.J3));
                    AdCloseView.this.o();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    int i2 = AdCloseView.this.E;
                    if (i2 == 1) {
                        httpMessage.addParam("pi", PlaceId.FRS.value);
                    } else if (i2 == 2 || i2 == 3) {
                        httpMessage.addParam("pi", PlaceId.HOMEPAGE.value);
                    } else if (i2 == 4) {
                        httpMessage.addParam("pi", PlaceId.PB_BANNER.value);
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.r.Q3);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.I = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                PopupWindow popupWindow = AdCloseView.this.f20405g;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                    AdCloseView.this.f20405g = null;
                }
            }
        };
        this.J = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.o();
            }
        };
        this.K = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.p();
            }
        };
        this.f20403e = context;
        q();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20403e = null;
        this.f20404f = null;
        this.f20405g = null;
        this.p = R.drawable.icon_pure_card_close22;
        this.q = null;
        this.r = null;
        this.t = new ArrayList();
        this.C = 0L;
        this.D = false;
        this.F = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.C > 500) {
                    AdCloseView.this.r();
                    AdCloseView.this.C = currentTimeMillis;
                }
            }
        };
        this.G = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int n = AdCloseView.this.n();
                if (n > 0) {
                    AdCloseView adCloseView = AdCloseView.this;
                    adCloseView.f20407i.setText(adCloseView.f20403e.getResources().getString(R.string.confirm));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.f20403e.getString(R.string.ad_close_title_prefix));
                    int color = SkinManager.getColor(R.color.CAM_X0105);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(n));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.f20403e.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.k.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView adCloseView2 = AdCloseView.this;
                adCloseView2.f20407i.setText(adCloseView2.f20403e.getResources().getString(R.string.ad_no_interest));
                AdCloseView adCloseView3 = AdCloseView.this;
                adCloseView3.k.setText(adCloseView3.u);
            }
        };
        this.H = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.r != null) {
                    AdCloseView adCloseView = AdCloseView.this;
                    if (adCloseView.f20404f == null) {
                        return;
                    }
                    String selectedResultJsonObj = adCloseView.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.r.J3));
                    AdCloseView.this.o();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    int i22 = AdCloseView.this.E;
                    if (i22 == 1) {
                        httpMessage.addParam("pi", PlaceId.FRS.value);
                    } else if (i22 == 2 || i22 == 3) {
                        httpMessage.addParam("pi", PlaceId.HOMEPAGE.value);
                    } else if (i22 == 4) {
                        httpMessage.addParam("pi", PlaceId.PB_BANNER.value);
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.r.Q3);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.I = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                PopupWindow popupWindow = AdCloseView.this.f20405g;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                    AdCloseView.this.f20405g = null;
                }
            }
        };
        this.J = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.o();
            }
        };
        this.K = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.p();
            }
        };
        this.f20403e = context;
        q();
    }
}
