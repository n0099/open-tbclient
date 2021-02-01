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
    private TextView nWW;
    private WebView nWX;
    private TBSpecificationBtn nWY;
    private TBSpecificationBtn nWZ;
    private TextView nXa;
    private TBSpecificationBtn nXb;
    private boolean nXc;
    private CharSequence nXd;
    private String nXe;
    private final WindowType nXf;
    private a nXg;
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
        this.nXc = false;
        this.mSkinType = 0;
        this.webViewClient = new WebViewClient() { // from class: com.baidu.tieba.view.EBusinessProtocolView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                String str2 = "javascript:setContentTextColor(" + EBusinessProtocolView.this.mSkinType + ")";
                if (EBusinessProtocolView.this.nWX != null) {
                    EBusinessProtocolView.this.nWX.loadUrl(str2);
                }
            }
        };
        this.mContext = context;
        this.nXf = windowType;
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
        KV(i);
        this.mSkinType = i;
        ap.setViewTextColor(this.nWW, R.color.CAM_X0105);
        ap.setBackgroundColor(this.nWX, R.color.CAM_X0211);
        ap.setViewTextColor(this.nWY, R.color.CAM_X0108);
        ap.setViewTextColor(this.nWZ, R.color.CAM_X0303);
        ap.setViewTextColor(this.nXa, R.color.CAM_X0105);
    }

    public void a(a aVar) {
        this.nXg = aVar;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void v(CharSequence charSequence) {
        this.nXd = charSequence;
    }

    public void UO(String str) {
        this.nXe = str;
    }

    private void initView() {
        this.nWW = (TextView) this.mRootView.findViewById(R.id.protocol_title);
        this.nWX = (WebView) this.mRootView.findViewById(R.id.protocol_content);
        this.nWZ = (TBSpecificationBtn) this.mRootView.findViewById(R.id.agree_protocol);
        this.nWY = (TBSpecificationBtn) this.mRootView.findViewById(R.id.cancel_protocol);
        this.nXa = (TextView) this.mRootView.findViewById(R.id.tip_content);
        this.nXb = (TBSpecificationBtn) findViewById(R.id.tip_known);
        dVS();
        initListener();
    }

    private void dVS() {
        this.nWW.setText(this.mTitle);
        switch (this.nXf) {
            case TIP:
                this.nXa.setVisibility(0);
                this.nXb.setVisibility(0);
                setCanceledOnTouchOutside(true);
                this.nXa.setText(this.nXd);
                this.nXb.setText(this.mContext.getResources().getString(R.string.tip_known));
                com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
                cVar.pR(R.color.CAM_X0302);
                this.nXb.setTextSize(R.dimen.T_X08);
                this.nXb.setConfig(cVar);
                return;
            case PROTOCOL:
                dVT();
                this.nWX.setVisibility(0);
                this.nWZ.setVisibility(0);
                this.nWY.setVisibility(0);
                this.nWX.loadUrl(this.nXe);
                com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
                cVar2.pR(R.color.CAM_X0107);
                this.nWY.setConfig(cVar2);
                this.nWY.setTextSize(R.dimen.tbds42);
                this.nWY.setText(this.mContext.getResources().getString(R.string.protocol_cancel));
                this.nWZ.setTextSize(R.dimen.tbds42);
                com.baidu.tbadk.core.view.commonBtn.c cVar3 = new com.baidu.tbadk.core.view.commonBtn.c();
                cVar3.pR(R.color.CAM_X0302);
                this.nWZ.setConfig(cVar3);
                this.nWZ.setTextSize(R.dimen.tbds42);
                this.nWZ.setText(this.mContext.getResources().getString(R.string.protocol_agree));
                return;
            default:
                return;
        }
    }

    private void KV(int i) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setColor(ap.getColor(i, R.color.CAM_X0211));
        this.mRootView.setBackgroundDrawable(gradientDrawable);
    }

    private void dVT() {
        WebSettings settings = this.nWX.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.nWX.setWebViewClient(this.webViewClient);
        settings.setTextZoom(115);
    }

    private void initListener() {
        this.nWZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.EBusinessProtocolView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.nXc = true;
                if (EBusinessProtocolView.this.nXg != null) {
                    EBusinessProtocolView.this.nXg.zo(EBusinessProtocolView.this.nXc);
                }
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.nWY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.EBusinessProtocolView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.nXc = false;
                if (EBusinessProtocolView.this.nXg != null) {
                    EBusinessProtocolView.this.nXg.zo(EBusinessProtocolView.this.nXc);
                }
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.nXb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.EBusinessProtocolView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.dismiss();
            }
        });
    }
}
