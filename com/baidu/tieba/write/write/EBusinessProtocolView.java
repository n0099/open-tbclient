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
    private final String nsR;
    private TextView nsS;
    private WebView nsT;
    private TBSpecificationBtn nsU;
    private TBSpecificationBtn nsV;
    private TextView nsW;
    private Button nsX;
    private boolean nsY;
    private WindowType nsZ;
    private a nta;
    private WebViewClient webViewClient;

    /* loaded from: classes3.dex */
    public enum WindowType {
        TIP,
        PROTOCOL
    }

    /* loaded from: classes3.dex */
    public interface a {
        void yf(boolean z);
    }

    public EBusinessProtocolView(@NonNull Context context) {
        super(context, R.style.e_business_protocol_dialog);
        this.nsR = "file:///android_asset/protocol.html";
        this.nsY = false;
        this.mSkinType = 0;
        this.webViewClient = new WebViewClient() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                String str2 = "javascript:setContentTextColor(" + EBusinessProtocolView.this.mSkinType + ")";
                if (EBusinessProtocolView.this.nsT != null) {
                    EBusinessProtocolView.this.nsT.loadUrl(str2);
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
        KW(i);
        this.mSkinType = i;
        ap.setViewTextColor(this.nsS, R.color.cp_cont_b);
        ap.setBackgroundColor(this.nsT, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.nsU, R.color.cp_cont_c);
        ap.setViewTextColor(this.nsV, R.color.cp_link_tip_b);
        ap.setViewTextColor(this.nsW, R.color.cp_cont_b);
    }

    public void a(a aVar) {
        this.nta = aVar;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void a(WindowType windowType) {
        this.nsZ = windowType;
    }

    private void initView() {
        this.nsS = (TextView) this.mRootView.findViewById(R.id.protocol_title);
        this.nsS.setText(this.mTitle);
        this.nsT = (WebView) this.mRootView.findViewById(R.id.protocol_content);
        this.nsV = (TBSpecificationBtn) this.mRootView.findViewById(R.id.agree_protocol);
        this.nsV.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pN(R.color.cp_link_tip_a);
        this.nsV.setConfig(cVar);
        this.nsV.setTextSize(R.dimen.tbds42);
        this.nsV.setText(this.mContext.getResources().getString(R.string.protocol_agree));
        this.nsU = (TBSpecificationBtn) this.mRootView.findViewById(R.id.cancel_protocol);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pN(R.color.cp_cont_j);
        this.nsU.setConfig(cVar2);
        this.nsU.setTextSize(R.dimen.tbds42);
        this.nsU.setText(this.mContext.getResources().getString(R.string.protocol_cancel));
        this.nsW = (TextView) this.mRootView.findViewById(R.id.tip_content);
        this.nsX = (Button) findViewById(R.id.tip_known);
        this.nsX.setText(R.string.tip_known);
        this.nsX.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        dPc();
        dPb();
        dPa();
        FL();
    }

    private void dPa() {
        if (WindowType.TIP == this.nsZ) {
            this.nsW.setVisibility(0);
            this.nsX.setVisibility(0);
            setCanceledOnTouchOutside(true);
        }
        if (WindowType.PROTOCOL == this.nsZ) {
            this.nsT.setVisibility(0);
            this.nsV.setVisibility(0);
            this.nsU.setVisibility(0);
        }
    }

    private void KW(int i) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setColor(ap.getColor(i, R.color.cp_bg_line_k));
        this.mRootView.setBackgroundDrawable(gradientDrawable);
    }

    private void dPb() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_1) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_2) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_3) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_4) + "\n"));
        spannableStringBuilder.append((CharSequence) getContext().getResources().getString(R.string.tip_content_5));
        this.nsW.setText(spannableStringBuilder);
    }

    private void dPc() {
        WebSettings settings = this.nsT.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.nsT.setWebViewClient(this.webViewClient);
        settings.setTextZoom(115);
        this.nsT.loadUrl("file:///android_asset/protocol.html");
    }

    private void FL() {
        this.nsV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.nsY = true;
                EBusinessProtocolView.this.nta.yf(EBusinessProtocolView.this.nsY);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.nsU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.nsY = false;
                EBusinessProtocolView.this.nta.yf(EBusinessProtocolView.this.nsY);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.nsX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.dismiss();
            }
        });
    }
}
