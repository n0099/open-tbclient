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
    private final String mTf;
    private TextView mTg;
    private WebView mTh;
    private TBSpecificationBtn mTi;
    private String mTitle;
    private TBSpecificationBtn mTk;
    private TextView mTl;
    private Button mTm;
    private boolean mTn;
    private WindowType mTp;
    private a mTq;
    private WebViewClient webViewClient;

    /* loaded from: classes3.dex */
    public enum WindowType {
        TIP,
        PROTOCOL
    }

    /* loaded from: classes3.dex */
    public interface a {
        void xn(boolean z);
    }

    public EBusinessProtocolView(@NonNull Context context) {
        super(context, R.style.e_business_protocol_dialog);
        this.mTf = "file:///android_asset/protocol.html";
        this.mTn = false;
        this.mSkinType = 0;
        this.webViewClient = new WebViewClient() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                String str2 = "javascript:setContentTextColor(" + EBusinessProtocolView.this.mSkinType + ")";
                if (EBusinessProtocolView.this.mTh != null) {
                    EBusinessProtocolView.this.mTh.loadUrl(str2);
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
        ap.setViewTextColor(this.mTg, R.color.cp_cont_b);
        ap.setBackgroundColor(this.mTh, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.mTi, R.color.cp_cont_c);
        ap.setViewTextColor(this.mTk, R.color.cp_link_tip_b);
        ap.setViewTextColor(this.mTl, R.color.cp_cont_b);
    }

    public void a(a aVar) {
        this.mTq = aVar;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void a(WindowType windowType) {
        this.mTp = windowType;
    }

    private void initView() {
        this.mTg = (TextView) this.mRootView.findViewById(R.id.protocol_title);
        this.mTg.setText(this.mTitle);
        this.mTh = (WebView) this.mRootView.findViewById(R.id.protocol_content);
        this.mTk = (TBSpecificationBtn) this.mRootView.findViewById(R.id.agree_protocol);
        this.mTk.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pb(R.color.cp_link_tip_a);
        this.mTk.setConfig(cVar);
        this.mTk.setTextSize(R.dimen.tbds42);
        this.mTk.setText(this.mContext.getResources().getString(R.string.protocol_agree));
        this.mTi = (TBSpecificationBtn) this.mRootView.findViewById(R.id.cancel_protocol);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pb(R.color.cp_cont_j);
        this.mTi.setConfig(cVar2);
        this.mTi.setTextSize(R.dimen.tbds42);
        this.mTi.setText(this.mContext.getResources().getString(R.string.protocol_cancel));
        this.mTl = (TextView) this.mRootView.findViewById(R.id.tip_content);
        this.mTm = (Button) findViewById(R.id.tip_known);
        this.mTm.setText(R.string.tip_known);
        this.mTm.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        dHm();
        dHl();
        dHk();
        Ey();
    }

    private void dHk() {
        if (WindowType.TIP == this.mTp) {
            this.mTl.setVisibility(0);
            this.mTm.setVisibility(0);
            setCanceledOnTouchOutside(true);
        }
        if (WindowType.PROTOCOL == this.mTp) {
            this.mTh.setVisibility(0);
            this.mTk.setVisibility(0);
            this.mTi.setVisibility(0);
        }
    }

    private void JL(int i) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setColor(ap.getColor(i, R.color.cp_bg_line_k));
        this.mRootView.setBackgroundDrawable(gradientDrawable);
    }

    private void dHl() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_1) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_2) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_3) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_4) + "\n"));
        spannableStringBuilder.append((CharSequence) getContext().getResources().getString(R.string.tip_content_5));
        this.mTl.setText(spannableStringBuilder);
    }

    private void dHm() {
        WebSettings settings = this.mTh.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.mTh.setWebViewClient(this.webViewClient);
        settings.setTextZoom(115);
        this.mTh.loadUrl("file:///android_asset/protocol.html");
    }

    private void Ey() {
        this.mTk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.mTn = true;
                EBusinessProtocolView.this.mTq.xn(EBusinessProtocolView.this.mTn);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.mTi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.mTn = false;
                EBusinessProtocolView.this.mTq.xn(EBusinessProtocolView.this.mTn);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.mTm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.dismiss();
            }
        });
    }
}
