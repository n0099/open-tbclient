package com.baidu.tieba.write.write;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
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
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class EBusinessProtocolView extends Dialog {
    private Context mContext;
    private View mRootView;
    private int mSkinType;
    private String mTitle;
    private final String nYJ;
    private TextView nYK;
    private WebView nYL;
    private TBSpecificationBtn nYM;
    private TBSpecificationBtn nYN;
    private TextView nYO;
    private Button nYP;
    private boolean nYQ;
    private WindowType nYR;
    private a nYS;
    private WebViewClient webViewClient;

    /* loaded from: classes7.dex */
    public enum WindowType {
        TIP,
        PROTOCOL
    }

    /* loaded from: classes7.dex */
    public interface a {
        void zk(boolean z);
    }

    public EBusinessProtocolView(@NonNull Context context) {
        super(context, R.style.e_business_protocol_dialog);
        this.nYJ = "file:///android_asset/protocol.html";
        this.nYQ = false;
        this.mSkinType = 0;
        this.webViewClient = new WebViewClient() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                String str2 = "javascript:setContentTextColor(" + EBusinessProtocolView.this.mSkinType + ")";
                if (EBusinessProtocolView.this.nYL != null) {
                    EBusinessProtocolView.this.nYL.loadUrl(str2);
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
        layoutParams.width = this.mContext.getResources().getDisplayMetrics().widthPixels - l.getDimens(this.mContext, R.dimen.tbds90);
        layoutParams.height = l.getDimens(this.mContext, R.dimen.tbds879);
        setContentView(this.mRootView, layoutParams);
        setCanceledOnTouchOutside(true);
        initView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        Lb(i);
        this.mSkinType = i;
        ao.setViewTextColor(this.nYK, R.color.CAM_X0105);
        ao.setBackgroundColor(this.nYL, R.color.CAM_X0211);
        ao.setViewTextColor(this.nYM, R.color.CAM_X0108);
        ao.setViewTextColor(this.nYN, R.color.CAM_X0303);
        ao.setViewTextColor(this.nYO, R.color.CAM_X0105);
    }

    public void a(a aVar) {
        this.nYS = aVar;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void a(WindowType windowType) {
        this.nYR = windowType;
    }

    private void initView() {
        this.nYK = (TextView) this.mRootView.findViewById(R.id.protocol_title);
        this.nYK.setText(this.mTitle);
        this.nYL = (WebView) this.mRootView.findViewById(R.id.protocol_content);
        this.nYN = (TBSpecificationBtn) this.mRootView.findViewById(R.id.agree_protocol);
        this.nYN.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pM(R.color.CAM_X0302);
        this.nYN.setConfig(cVar);
        this.nYN.setTextSize(R.dimen.tbds42);
        this.nYN.setText(this.mContext.getResources().getString(R.string.protocol_agree));
        this.nYM = (TBSpecificationBtn) this.mRootView.findViewById(R.id.cancel_protocol);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pM(R.color.CAM_X0107);
        this.nYM.setConfig(cVar2);
        this.nYM.setTextSize(R.dimen.tbds42);
        this.nYM.setText(this.mContext.getResources().getString(R.string.protocol_cancel));
        this.nYO = (TextView) this.mRootView.findViewById(R.id.tip_content);
        this.nYP = (Button) findViewById(R.id.tip_known);
        this.nYP.setText(R.string.tip_known);
        this.nYP.setTextColor(ao.getColor(R.color.CAM_X0302));
        dVy();
        dVx();
        dVw();
        Dn();
    }

    private void dVw() {
        if (WindowType.TIP == this.nYR) {
            this.nYO.setVisibility(0);
            this.nYP.setVisibility(0);
            setCanceledOnTouchOutside(true);
        }
        if (WindowType.PROTOCOL == this.nYR) {
            this.nYL.setVisibility(0);
            this.nYN.setVisibility(0);
            this.nYM.setVisibility(0);
        }
    }

    private void Lb(int i) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setColor(ao.getColor(i, R.color.CAM_X0211));
        this.mRootView.setBackgroundDrawable(gradientDrawable);
    }

    private void dVx() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_1) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_2) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_3) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_4) + "\n"));
        spannableStringBuilder.append((CharSequence) getContext().getResources().getString(R.string.tip_content_5));
        this.nYO.setText(spannableStringBuilder);
    }

    private void dVy() {
        WebSettings settings = this.nYL.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.nYL.setWebViewClient(this.webViewClient);
        settings.setTextZoom(115);
        this.nYL.loadUrl("file:///android_asset/protocol.html");
    }

    private void Dn() {
        this.nYN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.nYQ = true;
                EBusinessProtocolView.this.nYS.zk(EBusinessProtocolView.this.nYQ);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.nYM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.nYQ = false;
                EBusinessProtocolView.this.nYS.zk(EBusinessProtocolView.this.nYQ);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.nYP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.dismiss();
            }
        });
    }
}
