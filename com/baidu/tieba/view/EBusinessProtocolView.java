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
    private TextView nZB;
    private WebView nZC;
    private TBSpecificationBtn nZD;
    private TBSpecificationBtn nZE;
    private TextView nZF;
    private TBSpecificationBtn nZG;
    private boolean nZH;
    private CharSequence nZI;
    private String nZJ;
    private final WindowType nZK;
    private a nZL;
    private WebViewClient webViewClient;

    /* loaded from: classes.dex */
    public enum WindowType {
        TIP,
        PROTOCOL
    }

    /* loaded from: classes.dex */
    public interface a {
        void zn(boolean z);
    }

    public EBusinessProtocolView(@NonNull Context context, WindowType windowType) {
        super(context, R.style.e_business_protocol_dialog);
        this.nZH = false;
        this.mSkinType = 0;
        this.webViewClient = new WebViewClient() { // from class: com.baidu.tieba.view.EBusinessProtocolView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                String str2 = "javascript:setContentTextColor(" + EBusinessProtocolView.this.mSkinType + ")";
                if (EBusinessProtocolView.this.nZC != null) {
                    EBusinessProtocolView.this.nZC.loadUrl(str2);
                }
            }
        };
        this.mContext = context;
        this.nZK = windowType;
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
        La(i);
        this.mSkinType = i;
        ap.setViewTextColor(this.nZB, R.color.CAM_X0105);
        ap.setBackgroundColor(this.nZC, R.color.CAM_X0211);
        ap.setViewTextColor(this.nZD, R.color.CAM_X0108);
        ap.setViewTextColor(this.nZE, R.color.CAM_X0303);
        ap.setViewTextColor(this.nZF, R.color.CAM_X0105);
    }

    public void a(a aVar) {
        this.nZL = aVar;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void v(CharSequence charSequence) {
        this.nZI = charSequence;
    }

    public void Vh(String str) {
        this.nZJ = str;
    }

    private void initView() {
        this.nZB = (TextView) this.mRootView.findViewById(R.id.protocol_title);
        this.nZC = (WebView) this.mRootView.findViewById(R.id.protocol_content);
        this.nZE = (TBSpecificationBtn) this.mRootView.findViewById(R.id.agree_protocol);
        this.nZD = (TBSpecificationBtn) this.mRootView.findViewById(R.id.cancel_protocol);
        this.nZF = (TextView) this.mRootView.findViewById(R.id.tip_content);
        this.nZG = (TBSpecificationBtn) findViewById(R.id.tip_known);
        dWi();
        initListener();
    }

    private void dWi() {
        this.nZB.setText(this.mTitle);
        switch (this.nZK) {
            case TIP:
                this.nZF.setVisibility(0);
                this.nZG.setVisibility(0);
                setCanceledOnTouchOutside(true);
                this.nZF.setText(this.nZI);
                this.nZG.setText(this.mContext.getResources().getString(R.string.tip_known));
                com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
                cVar.pS(R.color.CAM_X0302);
                this.nZG.setTextSize(R.dimen.T_X08);
                this.nZG.setConfig(cVar);
                return;
            case PROTOCOL:
                dWj();
                this.nZC.setVisibility(0);
                this.nZE.setVisibility(0);
                this.nZD.setVisibility(0);
                this.nZC.loadUrl(this.nZJ);
                com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
                cVar2.pS(R.color.CAM_X0107);
                this.nZD.setConfig(cVar2);
                this.nZD.setTextSize(R.dimen.tbds42);
                this.nZD.setText(this.mContext.getResources().getString(R.string.protocol_cancel));
                this.nZE.setTextSize(R.dimen.tbds42);
                com.baidu.tbadk.core.view.commonBtn.c cVar3 = new com.baidu.tbadk.core.view.commonBtn.c();
                cVar3.pS(R.color.CAM_X0302);
                this.nZE.setConfig(cVar3);
                this.nZE.setTextSize(R.dimen.tbds42);
                this.nZE.setText(this.mContext.getResources().getString(R.string.protocol_agree));
                return;
            default:
                return;
        }
    }

    private void La(int i) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setColor(ap.getColor(i, R.color.CAM_X0211));
        this.mRootView.setBackgroundDrawable(gradientDrawable);
    }

    private void dWj() {
        WebSettings settings = this.nZC.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.nZC.setWebViewClient(this.webViewClient);
        settings.setTextZoom(115);
    }

    private void initListener() {
        this.nZE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.EBusinessProtocolView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.nZH = true;
                if (EBusinessProtocolView.this.nZL != null) {
                    EBusinessProtocolView.this.nZL.zn(EBusinessProtocolView.this.nZH);
                }
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.nZD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.EBusinessProtocolView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.nZH = false;
                if (EBusinessProtocolView.this.nZL != null) {
                    EBusinessProtocolView.this.nZL.zn(EBusinessProtocolView.this.nZH);
                }
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.nZG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.EBusinessProtocolView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.dismiss();
            }
        });
    }
}
