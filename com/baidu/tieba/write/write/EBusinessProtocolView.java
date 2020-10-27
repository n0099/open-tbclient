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
    private final String nFq;
    private TextView nFr;
    private WebView nFs;
    private TBSpecificationBtn nFt;
    private TBSpecificationBtn nFu;
    private TextView nFv;
    private Button nFw;
    private boolean nFx;
    private WindowType nFy;
    private a nFz;
    private WebViewClient webViewClient;

    /* loaded from: classes3.dex */
    public enum WindowType {
        TIP,
        PROTOCOL
    }

    /* loaded from: classes3.dex */
    public interface a {
        void yw(boolean z);
    }

    public EBusinessProtocolView(@NonNull Context context) {
        super(context, R.style.e_business_protocol_dialog);
        this.nFq = "file:///android_asset/protocol.html";
        this.nFx = false;
        this.mSkinType = 0;
        this.webViewClient = new WebViewClient() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                String str2 = "javascript:setContentTextColor(" + EBusinessProtocolView.this.mSkinType + ")";
                if (EBusinessProtocolView.this.nFs != null) {
                    EBusinessProtocolView.this.nFs.loadUrl(str2);
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
        Lo(i);
        this.mSkinType = i;
        ap.setViewTextColor(this.nFr, R.color.cp_cont_b);
        ap.setBackgroundColor(this.nFs, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.nFt, R.color.cp_cont_c);
        ap.setViewTextColor(this.nFu, R.color.cp_link_tip_b);
        ap.setViewTextColor(this.nFv, R.color.cp_cont_b);
    }

    public void a(a aVar) {
        this.nFz = aVar;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void a(WindowType windowType) {
        this.nFy = windowType;
    }

    private void initView() {
        this.nFr = (TextView) this.mRootView.findViewById(R.id.protocol_title);
        this.nFr.setText(this.mTitle);
        this.nFs = (WebView) this.mRootView.findViewById(R.id.protocol_content);
        this.nFu = (TBSpecificationBtn) this.mRootView.findViewById(R.id.agree_protocol);
        this.nFu.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pY(R.color.cp_link_tip_a);
        this.nFu.setConfig(cVar);
        this.nFu.setTextSize(R.dimen.tbds42);
        this.nFu.setText(this.mContext.getResources().getString(R.string.protocol_agree));
        this.nFt = (TBSpecificationBtn) this.mRootView.findViewById(R.id.cancel_protocol);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pY(R.color.cp_cont_j);
        this.nFt.setConfig(cVar2);
        this.nFt.setTextSize(R.dimen.tbds42);
        this.nFt.setText(this.mContext.getResources().getString(R.string.protocol_cancel));
        this.nFv = (TextView) this.mRootView.findViewById(R.id.tip_content);
        this.nFw = (Button) findViewById(R.id.tip_known);
        this.nFw.setText(R.string.tip_known);
        this.nFw.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        dSk();
        dSj();
        dSi();
        Ga();
    }

    private void dSi() {
        if (WindowType.TIP == this.nFy) {
            this.nFv.setVisibility(0);
            this.nFw.setVisibility(0);
            setCanceledOnTouchOutside(true);
        }
        if (WindowType.PROTOCOL == this.nFy) {
            this.nFs.setVisibility(0);
            this.nFu.setVisibility(0);
            this.nFt.setVisibility(0);
        }
    }

    private void Lo(int i) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setColor(ap.getColor(i, R.color.cp_bg_line_k));
        this.mRootView.setBackgroundDrawable(gradientDrawable);
    }

    private void dSj() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_1) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_2) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_3) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_4) + "\n"));
        spannableStringBuilder.append((CharSequence) getContext().getResources().getString(R.string.tip_content_5));
        this.nFv.setText(spannableStringBuilder);
    }

    private void dSk() {
        WebSettings settings = this.nFs.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.nFs.setWebViewClient(this.webViewClient);
        settings.setTextZoom(115);
        this.nFs.loadUrl("file:///android_asset/protocol.html");
    }

    private void Ga() {
        this.nFu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.nFx = true;
                EBusinessProtocolView.this.nFz.yw(EBusinessProtocolView.this.nFx);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.nFt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.nFx = false;
                EBusinessProtocolView.this.nFz.yw(EBusinessProtocolView.this.nFx);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.nFw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.dismiss();
            }
        });
    }
}
