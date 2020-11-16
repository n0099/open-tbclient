package com.baidu.tieba.write.write;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class EBusinessProtocolView extends Dialog {
    private Context mContext;
    private View mRootView;
    private int mSkinType;
    private String mTitle;
    private final String nML;
    private TextView nMM;
    private WebView nMN;
    private TBSpecificationBtn nMO;
    private TBSpecificationBtn nMP;
    private TextView nMQ;
    private Button nMR;
    private boolean nMS;
    private WindowType nMT;
    private a nMU;
    private WebViewClient webViewClient;

    /* loaded from: classes3.dex */
    public enum WindowType {
        TIP,
        PROTOCOL
    }

    /* loaded from: classes3.dex */
    public interface a {
        void yM(boolean z);
    }

    public EBusinessProtocolView(@NonNull Context context) {
        super(context, R.style.e_business_protocol_dialog);
        this.nML = "file:///android_asset/protocol.html";
        this.nMS = false;
        this.mSkinType = 0;
        this.webViewClient = new WebViewClient() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                String str2 = "javascript:setContentTextColor(" + EBusinessProtocolView.this.mSkinType + ")";
                if (EBusinessProtocolView.this.nMN != null) {
                    EBusinessProtocolView.this.nMN.loadUrl(str2);
                }
            }
        };
        this.mContext = context;
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
        layoutParams.width = this.mContext.getResources().getDisplayMetrics().widthPixels - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds90);
        layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds879);
        setContentView(this.mRootView, layoutParams);
        setCanceledOnTouchOutside(true);
        initView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        Me(i);
        this.mSkinType = i;
        ap.setViewTextColor(this.nMM, R.color.CAM_X0105);
        ap.setBackgroundColor(this.nMN, R.color.CAM_X0211);
        ap.setViewTextColor(this.nMO, R.color.CAM_X0108);
        ap.setViewTextColor(this.nMP, R.color.CAM_X0303);
        ap.setViewTextColor(this.nMQ, R.color.CAM_X0105);
    }

    public void a(a aVar) {
        this.nMU = aVar;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void a(WindowType windowType) {
        this.nMT = windowType;
    }

    private void initView() {
        this.nMM = (TextView) this.mRootView.findViewById(R.id.protocol_title);
        this.nMM.setText(this.mTitle);
        this.nMN = (WebView) this.mRootView.findViewById(R.id.protocol_content);
        this.nMP = (TBSpecificationBtn) this.mRootView.findViewById(R.id.agree_protocol);
        this.nMP.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.qG(R.color.CAM_X0302);
        this.nMP.setConfig(cVar);
        this.nMP.setTextSize(R.dimen.tbds42);
        this.nMP.setText(this.mContext.getResources().getString(R.string.protocol_agree));
        this.nMO = (TBSpecificationBtn) this.mRootView.findViewById(R.id.cancel_protocol);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.qG(R.color.CAM_X0107);
        this.nMO.setConfig(cVar2);
        this.nMO.setTextSize(R.dimen.tbds42);
        this.nMO.setText(this.mContext.getResources().getString(R.string.protocol_cancel));
        this.nMQ = (TextView) this.mRootView.findViewById(R.id.tip_content);
        this.nMR = (Button) findViewById(R.id.tip_known);
        this.nMR.setText(R.string.tip_known);
        this.nMR.setTextColor(ap.getColor(R.color.CAM_X0302));
        dUJ();
        dUI();
        dUH();
        FS();
    }

    private void dUH() {
        if (WindowType.TIP == this.nMT) {
            this.nMQ.setVisibility(0);
            this.nMR.setVisibility(0);
            setCanceledOnTouchOutside(true);
        }
        if (WindowType.PROTOCOL == this.nMT) {
            this.nMN.setVisibility(0);
            this.nMP.setVisibility(0);
            this.nMO.setVisibility(0);
        }
    }

    private void Me(int i) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setColor(ap.getColor(i, R.color.CAM_X0211));
        this.mRootView.setBackgroundDrawable(gradientDrawable);
    }

    private void dUI() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_1) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_2) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_3) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_4) + "\n"));
        spannableStringBuilder.append((CharSequence) getContext().getResources().getString(R.string.tip_content_5));
        this.nMQ.setText(spannableStringBuilder);
    }

    private void dUJ() {
        WebSettings settings = this.nMN.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.nMN.setWebViewClient(this.webViewClient);
        settings.setTextZoom(115);
        this.nMN.loadUrl("file:///android_asset/protocol.html");
    }

    private void FS() {
        this.nMP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.nMS = true;
                EBusinessProtocolView.this.nMU.yM(EBusinessProtocolView.this.nMS);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.nMO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.nMS = false;
                EBusinessProtocolView.this.nMU.yM(EBusinessProtocolView.this.nMS);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.nMR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.dismiss();
            }
        });
    }
}
