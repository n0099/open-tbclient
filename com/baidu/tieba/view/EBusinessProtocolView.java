package com.baidu.tieba.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class EBusinessProtocolView extends Dialog {
    private Context mContext;
    private View mRootView;
    private int mSkinType;
    private String mTitle;
    private TextView nXA;
    private TBSpecificationBtn nXB;
    private boolean nXC;
    private CharSequence nXD;
    private String nXE;
    private final WindowType nXF;
    private a nXG;
    private TextView nXw;
    private WebView nXx;
    private TBSpecificationBtn nXy;
    private TBSpecificationBtn nXz;
    private WebViewClient webViewClient;

    /* loaded from: classes.dex */
    public enum WindowType {
        TIP,
        PROTOCOL
    }

    /* loaded from: classes.dex */
    public interface a {
        void zo(boolean z);
    }

    public EBusinessProtocolView(@NonNull Context context, WindowType windowType) {
        super(context, R.style.e_business_protocol_dialog);
        this.nXC = false;
        this.mSkinType = 0;
        this.webViewClient = new WebViewClient() { // from class: com.baidu.tieba.view.EBusinessProtocolView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                String str2 = "javascript:setContentTextColor(" + EBusinessProtocolView.this.mSkinType + ")";
                if (EBusinessProtocolView.this.nXx != null) {
                    EBusinessProtocolView.this.nXx.loadUrl(str2);
                }
            }
        };
        this.mContext = context;
        this.nXF = windowType;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.e_business_protocol_dialog, (ViewGroup) null);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.width = this.mContext.getResources().getDisplayMetrics().widthPixels - l.getDimens(this.mContext, R.dimen.tbds90);
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds879);
        setContentView(this.mRootView, layoutParams);
        setCanceledOnTouchOutside(true);
        initView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        KW(i);
        this.mSkinType = i;
        ap.setViewTextColor(this.nXw, R.color.CAM_X0105);
        ap.setBackgroundColor(this.nXx, R.color.CAM_X0211);
        ap.setViewTextColor(this.nXy, R.color.CAM_X0108);
        ap.setViewTextColor(this.nXz, R.color.CAM_X0303);
        ap.setViewTextColor(this.nXA, R.color.CAM_X0105);
    }

    public void a(a aVar) {
        this.nXG = aVar;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void v(CharSequence charSequence) {
        this.nXD = charSequence;
    }

    public void Va(String str) {
        this.nXE = str;
    }

    private void initView() {
        this.nXw = (TextView) this.mRootView.findViewById(R.id.protocol_title);
        this.nXx = (WebView) this.mRootView.findViewById(R.id.protocol_content);
        this.nXz = (TBSpecificationBtn) this.mRootView.findViewById(R.id.agree_protocol);
        this.nXy = (TBSpecificationBtn) this.mRootView.findViewById(R.id.cancel_protocol);
        this.nXA = (TextView) this.mRootView.findViewById(R.id.tip_content);
        this.nXB = (TBSpecificationBtn) findViewById(R.id.tip_known);
        dWa();
        initListener();
    }

    private void dWa() {
        this.nXw.setText(this.mTitle);
        switch (this.nXF) {
            case TIP:
                this.nXA.setVisibility(0);
                this.nXB.setVisibility(0);
                setCanceledOnTouchOutside(true);
                this.nXA.setText(this.nXD);
                this.nXB.setText(this.mContext.getResources().getString(R.string.tip_known));
                com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
                cVar.pR(R.color.CAM_X0302);
                this.nXB.setTextSize(R.dimen.T_X08);
                this.nXB.setConfig(cVar);
                return;
            case PROTOCOL:
                dWb();
                this.nXx.setVisibility(0);
                this.nXz.setVisibility(0);
                this.nXy.setVisibility(0);
                this.nXx.loadUrl(this.nXE);
                com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
                cVar2.pR(R.color.CAM_X0107);
                this.nXy.setConfig(cVar2);
                this.nXy.setTextSize(R.dimen.tbds42);
                this.nXy.setText(this.mContext.getResources().getString(R.string.protocol_cancel));
                this.nXz.setTextSize(R.dimen.tbds42);
                com.baidu.tbadk.core.view.commonBtn.c cVar3 = new com.baidu.tbadk.core.view.commonBtn.c();
                cVar3.pR(R.color.CAM_X0302);
                this.nXz.setConfig(cVar3);
                this.nXz.setTextSize(R.dimen.tbds42);
                this.nXz.setText(this.mContext.getResources().getString(R.string.protocol_agree));
                return;
            default:
                return;
        }
    }

    private void KW(int i) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setColor(ap.getColor(i, R.color.CAM_X0211));
        this.mRootView.setBackgroundDrawable(gradientDrawable);
    }

    private void dWb() {
        WebSettings settings = this.nXx.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.nXx.setWebViewClient(this.webViewClient);
        settings.setTextZoom(115);
    }

    private void initListener() {
        this.nXz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.EBusinessProtocolView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.nXC = true;
                if (EBusinessProtocolView.this.nXG != null) {
                    EBusinessProtocolView.this.nXG.zo(EBusinessProtocolView.this.nXC);
                }
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.nXy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.EBusinessProtocolView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.nXC = false;
                if (EBusinessProtocolView.this.nXG != null) {
                    EBusinessProtocolView.this.nXG.zo(EBusinessProtocolView.this.nXC);
                }
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.nXB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.EBusinessProtocolView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.dismiss();
            }
        });
    }
}
