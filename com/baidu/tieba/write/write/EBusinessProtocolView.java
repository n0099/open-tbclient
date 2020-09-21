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
    private WindowType ndA;
    private a ndB;
    private final String nds;
    private TextView ndt;
    private WebView ndu;
    private TBSpecificationBtn ndv;
    private TBSpecificationBtn ndw;
    private TextView ndx;
    private Button ndy;
    private boolean ndz;
    private WebViewClient webViewClient;

    /* loaded from: classes3.dex */
    public enum WindowType {
        TIP,
        PROTOCOL
    }

    /* loaded from: classes3.dex */
    public interface a {
        void xy(boolean z);
    }

    public EBusinessProtocolView(@NonNull Context context) {
        super(context, R.style.e_business_protocol_dialog);
        this.nds = "file:///android_asset/protocol.html";
        this.ndz = false;
        this.mSkinType = 0;
        this.webViewClient = new WebViewClient() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                String str2 = "javascript:setContentTextColor(" + EBusinessProtocolView.this.mSkinType + ")";
                if (EBusinessProtocolView.this.ndu != null) {
                    EBusinessProtocolView.this.ndu.loadUrl(str2);
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
        Kq(i);
        this.mSkinType = i;
        ap.setViewTextColor(this.ndt, R.color.cp_cont_b);
        ap.setBackgroundColor(this.ndu, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.ndv, R.color.cp_cont_c);
        ap.setViewTextColor(this.ndw, R.color.cp_link_tip_b);
        ap.setViewTextColor(this.ndx, R.color.cp_cont_b);
    }

    public void a(a aVar) {
        this.ndB = aVar;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void a(WindowType windowType) {
        this.ndA = windowType;
    }

    private void initView() {
        this.ndt = (TextView) this.mRootView.findViewById(R.id.protocol_title);
        this.ndt.setText(this.mTitle);
        this.ndu = (WebView) this.mRootView.findViewById(R.id.protocol_content);
        this.ndw = (TBSpecificationBtn) this.mRootView.findViewById(R.id.agree_protocol);
        this.ndw.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pp(R.color.cp_link_tip_a);
        this.ndw.setConfig(cVar);
        this.ndw.setTextSize(R.dimen.tbds42);
        this.ndw.setText(this.mContext.getResources().getString(R.string.protocol_agree));
        this.ndv = (TBSpecificationBtn) this.mRootView.findViewById(R.id.cancel_protocol);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pp(R.color.cp_cont_j);
        this.ndv.setConfig(cVar2);
        this.ndv.setTextSize(R.dimen.tbds42);
        this.ndv.setText(this.mContext.getResources().getString(R.string.protocol_cancel));
        this.ndx = (TextView) this.mRootView.findViewById(R.id.tip_content);
        this.ndy = (Button) findViewById(R.id.tip_known);
        this.ndy.setText(R.string.tip_known);
        this.ndy.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        dLq();
        dLp();
        dLo();
        EP();
    }

    private void dLo() {
        if (WindowType.TIP == this.ndA) {
            this.ndx.setVisibility(0);
            this.ndy.setVisibility(0);
            setCanceledOnTouchOutside(true);
        }
        if (WindowType.PROTOCOL == this.ndA) {
            this.ndu.setVisibility(0);
            this.ndw.setVisibility(0);
            this.ndv.setVisibility(0);
        }
    }

    private void Kq(int i) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setColor(ap.getColor(i, R.color.cp_bg_line_k));
        this.mRootView.setBackgroundDrawable(gradientDrawable);
    }

    private void dLp() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_1) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_2) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_3) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_4) + "\n"));
        spannableStringBuilder.append((CharSequence) getContext().getResources().getString(R.string.tip_content_5));
        this.ndx.setText(spannableStringBuilder);
    }

    private void dLq() {
        WebSettings settings = this.ndu.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.ndu.setWebViewClient(this.webViewClient);
        settings.setTextZoom(115);
        this.ndu.loadUrl("file:///android_asset/protocol.html");
    }

    private void EP() {
        this.ndw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.ndz = true;
                EBusinessProtocolView.this.ndB.xy(EBusinessProtocolView.this.ndz);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.ndv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.ndz = false;
                EBusinessProtocolView.this.ndB.xy(EBusinessProtocolView.this.ndz);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.ndy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.dismiss();
            }
        });
    }
}
