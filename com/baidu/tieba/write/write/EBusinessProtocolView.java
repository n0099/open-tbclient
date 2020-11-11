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
    private final String nLk;
    private TextView nLl;
    private WebView nLm;
    private TBSpecificationBtn nLn;
    private TBSpecificationBtn nLo;
    private TextView nLp;
    private Button nLq;
    private boolean nLr;
    private WindowType nLs;
    private a nLt;
    private WebViewClient webViewClient;

    /* loaded from: classes3.dex */
    public enum WindowType {
        TIP,
        PROTOCOL
    }

    /* loaded from: classes3.dex */
    public interface a {
        void yF(boolean z);
    }

    public EBusinessProtocolView(@NonNull Context context) {
        super(context, R.style.e_business_protocol_dialog);
        this.nLk = "file:///android_asset/protocol.html";
        this.nLr = false;
        this.mSkinType = 0;
        this.webViewClient = new WebViewClient() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                String str2 = "javascript:setContentTextColor(" + EBusinessProtocolView.this.mSkinType + ")";
                if (EBusinessProtocolView.this.nLm != null) {
                    EBusinessProtocolView.this.nLm.loadUrl(str2);
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
        LB(i);
        this.mSkinType = i;
        ap.setViewTextColor(this.nLl, R.color.cp_cont_b);
        ap.setBackgroundColor(this.nLm, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.nLn, R.color.cp_cont_c);
        ap.setViewTextColor(this.nLo, R.color.cp_link_tip_b);
        ap.setViewTextColor(this.nLp, R.color.cp_cont_b);
    }

    public void a(a aVar) {
        this.nLt = aVar;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void a(WindowType windowType) {
        this.nLs = windowType;
    }

    private void initView() {
        this.nLl = (TextView) this.mRootView.findViewById(R.id.protocol_title);
        this.nLl.setText(this.mTitle);
        this.nLm = (WebView) this.mRootView.findViewById(R.id.protocol_content);
        this.nLo = (TBSpecificationBtn) this.mRootView.findViewById(R.id.agree_protocol);
        this.nLo.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.qi(R.color.cp_link_tip_a);
        this.nLo.setConfig(cVar);
        this.nLo.setTextSize(R.dimen.tbds42);
        this.nLo.setText(this.mContext.getResources().getString(R.string.protocol_agree));
        this.nLn = (TBSpecificationBtn) this.mRootView.findViewById(R.id.cancel_protocol);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.qi(R.color.cp_cont_j);
        this.nLn.setConfig(cVar2);
        this.nLn.setTextSize(R.dimen.tbds42);
        this.nLn.setText(this.mContext.getResources().getString(R.string.protocol_cancel));
        this.nLp = (TextView) this.mRootView.findViewById(R.id.tip_content);
        this.nLq = (Button) findViewById(R.id.tip_known);
        this.nLq.setText(R.string.tip_known);
        this.nLq.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        dUK();
        dUJ();
        dUI();
        GB();
    }

    private void dUI() {
        if (WindowType.TIP == this.nLs) {
            this.nLp.setVisibility(0);
            this.nLq.setVisibility(0);
            setCanceledOnTouchOutside(true);
        }
        if (WindowType.PROTOCOL == this.nLs) {
            this.nLm.setVisibility(0);
            this.nLo.setVisibility(0);
            this.nLn.setVisibility(0);
        }
    }

    private void LB(int i) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setColor(ap.getColor(i, R.color.cp_bg_line_k));
        this.mRootView.setBackgroundDrawable(gradientDrawable);
    }

    private void dUJ() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_1) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_2) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_3) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_4) + "\n"));
        spannableStringBuilder.append((CharSequence) getContext().getResources().getString(R.string.tip_content_5));
        this.nLp.setText(spannableStringBuilder);
    }

    private void dUK() {
        WebSettings settings = this.nLm.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.nLm.setWebViewClient(this.webViewClient);
        settings.setTextZoom(115);
        this.nLm.loadUrl("file:///android_asset/protocol.html");
    }

    private void GB() {
        this.nLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.nLr = true;
                EBusinessProtocolView.this.nLt.yF(EBusinessProtocolView.this.nLr);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.nLn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.nLr = false;
                EBusinessProtocolView.this.nLt.yF(EBusinessProtocolView.this.nLr);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.nLq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.dismiss();
            }
        });
    }
}
