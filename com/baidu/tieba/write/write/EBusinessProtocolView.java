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
    private TextView mTA;
    private WebView mTB;
    private TBSpecificationBtn mTC;
    private TBSpecificationBtn mTD;
    private TextView mTE;
    private Button mTF;
    private boolean mTG;
    private WindowType mTH;
    private a mTI;
    private String mTitle;
    private final String mTz;
    private WebViewClient webViewClient;

    /* loaded from: classes3.dex */
    public enum WindowType {
        TIP,
        PROTOCOL
    }

    /* loaded from: classes3.dex */
    public interface a {
        void xp(boolean z);
    }

    public EBusinessProtocolView(@NonNull Context context) {
        super(context, R.style.e_business_protocol_dialog);
        this.mTz = "file:///android_asset/protocol.html";
        this.mTG = false;
        this.mSkinType = 0;
        this.webViewClient = new WebViewClient() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                String str2 = "javascript:setContentTextColor(" + EBusinessProtocolView.this.mSkinType + ")";
                if (EBusinessProtocolView.this.mTB != null) {
                    EBusinessProtocolView.this.mTB.loadUrl(str2);
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
        JL(i);
        this.mSkinType = i;
        ap.setViewTextColor(this.mTA, R.color.cp_cont_b);
        ap.setBackgroundColor(this.mTB, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.mTC, R.color.cp_cont_c);
        ap.setViewTextColor(this.mTD, R.color.cp_link_tip_b);
        ap.setViewTextColor(this.mTE, R.color.cp_cont_b);
    }

    public void a(a aVar) {
        this.mTI = aVar;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void a(WindowType windowType) {
        this.mTH = windowType;
    }

    private void initView() {
        this.mTA = (TextView) this.mRootView.findViewById(R.id.protocol_title);
        this.mTA.setText(this.mTitle);
        this.mTB = (WebView) this.mRootView.findViewById(R.id.protocol_content);
        this.mTD = (TBSpecificationBtn) this.mRootView.findViewById(R.id.agree_protocol);
        this.mTD.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pb(R.color.cp_link_tip_a);
        this.mTD.setConfig(cVar);
        this.mTD.setTextSize(R.dimen.tbds42);
        this.mTD.setText(this.mContext.getResources().getString(R.string.protocol_agree));
        this.mTC = (TBSpecificationBtn) this.mRootView.findViewById(R.id.cancel_protocol);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pb(R.color.cp_cont_j);
        this.mTC.setConfig(cVar2);
        this.mTC.setTextSize(R.dimen.tbds42);
        this.mTC.setText(this.mContext.getResources().getString(R.string.protocol_cancel));
        this.mTE = (TextView) this.mRootView.findViewById(R.id.tip_content);
        this.mTF = (Button) findViewById(R.id.tip_known);
        this.mTF.setText(R.string.tip_known);
        this.mTF.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        dHv();
        dHu();
        dHt();
        Ey();
    }

    private void dHt() {
        if (WindowType.TIP == this.mTH) {
            this.mTE.setVisibility(0);
            this.mTF.setVisibility(0);
            setCanceledOnTouchOutside(true);
        }
        if (WindowType.PROTOCOL == this.mTH) {
            this.mTB.setVisibility(0);
            this.mTD.setVisibility(0);
            this.mTC.setVisibility(0);
        }
    }

    private void JL(int i) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setColor(ap.getColor(i, R.color.cp_bg_line_k));
        this.mRootView.setBackgroundDrawable(gradientDrawable);
    }

    private void dHu() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_1) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_2) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_3) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_4) + "\n"));
        spannableStringBuilder.append((CharSequence) getContext().getResources().getString(R.string.tip_content_5));
        this.mTE.setText(spannableStringBuilder);
    }

    private void dHv() {
        WebSettings settings = this.mTB.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.mTB.setWebViewClient(this.webViewClient);
        settings.setTextZoom(115);
        this.mTB.loadUrl("file:///android_asset/protocol.html");
    }

    private void Ey() {
        this.mTD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.mTG = true;
                EBusinessProtocolView.this.mTI.xp(EBusinessProtocolView.this.mTG);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.mTC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.mTG = false;
                EBusinessProtocolView.this.mTI.xp(EBusinessProtocolView.this.mTG);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.mTF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.dismiss();
            }
        });
    }
}
