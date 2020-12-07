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
    private final String obc;
    private TextView obd;
    private WebView obe;
    private TBSpecificationBtn obf;
    private TBSpecificationBtn obg;
    private TextView obh;
    private Button obi;
    private boolean obk;
    private WindowType obl;
    private a obm;
    private WebViewClient webViewClient;

    /* loaded from: classes3.dex */
    public enum WindowType {
        TIP,
        PROTOCOL
    }

    /* loaded from: classes3.dex */
    public interface a {
        void zr(boolean z);
    }

    public EBusinessProtocolView(@NonNull Context context) {
        super(context, R.style.e_business_protocol_dialog);
        this.obc = "file:///android_asset/protocol.html";
        this.obk = false;
        this.mSkinType = 0;
        this.webViewClient = new WebViewClient() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                String str2 = "javascript:setContentTextColor(" + EBusinessProtocolView.this.mSkinType + ")";
                if (EBusinessProtocolView.this.obe != null) {
                    EBusinessProtocolView.this.obe.loadUrl(str2);
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
        MW(i);
        this.mSkinType = i;
        ap.setViewTextColor(this.obd, R.color.CAM_X0105);
        ap.setBackgroundColor(this.obe, R.color.CAM_X0211);
        ap.setViewTextColor(this.obf, R.color.CAM_X0108);
        ap.setViewTextColor(this.obg, R.color.CAM_X0303);
        ap.setViewTextColor(this.obh, R.color.CAM_X0105);
    }

    public void a(a aVar) {
        this.obm = aVar;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void a(WindowType windowType) {
        this.obl = windowType;
    }

    private void initView() {
        this.obd = (TextView) this.mRootView.findViewById(R.id.protocol_title);
        this.obd.setText(this.mTitle);
        this.obe = (WebView) this.mRootView.findViewById(R.id.protocol_content);
        this.obg = (TBSpecificationBtn) this.mRootView.findViewById(R.id.agree_protocol);
        this.obg.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.rh(R.color.CAM_X0302);
        this.obg.setConfig(cVar);
        this.obg.setTextSize(R.dimen.tbds42);
        this.obg.setText(this.mContext.getResources().getString(R.string.protocol_agree));
        this.obf = (TBSpecificationBtn) this.mRootView.findViewById(R.id.cancel_protocol);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.rh(R.color.CAM_X0107);
        this.obf.setConfig(cVar2);
        this.obf.setTextSize(R.dimen.tbds42);
        this.obf.setText(this.mContext.getResources().getString(R.string.protocol_cancel));
        this.obh = (TextView) this.mRootView.findViewById(R.id.tip_content);
        this.obi = (Button) findViewById(R.id.tip_known);
        this.obi.setText(R.string.tip_known);
        this.obi.setTextColor(ap.getColor(R.color.CAM_X0302));
        eaf();
        eae();
        ead();
        HH();
    }

    private void ead() {
        if (WindowType.TIP == this.obl) {
            this.obh.setVisibility(0);
            this.obi.setVisibility(0);
            setCanceledOnTouchOutside(true);
        }
        if (WindowType.PROTOCOL == this.obl) {
            this.obe.setVisibility(0);
            this.obg.setVisibility(0);
            this.obf.setVisibility(0);
        }
    }

    private void MW(int i) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setColor(ap.getColor(i, R.color.CAM_X0211));
        this.mRootView.setBackgroundDrawable(gradientDrawable);
    }

    private void eae() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_1) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_2) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_3) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_4) + "\n"));
        spannableStringBuilder.append((CharSequence) getContext().getResources().getString(R.string.tip_content_5));
        this.obh.setText(spannableStringBuilder);
    }

    private void eaf() {
        WebSettings settings = this.obe.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.obe.setWebViewClient(this.webViewClient);
        settings.setTextZoom(115);
        this.obe.loadUrl("file:///android_asset/protocol.html");
    }

    private void HH() {
        this.obg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.obk = true;
                EBusinessProtocolView.this.obm.zr(EBusinessProtocolView.this.obk);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.obf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.obk = false;
                EBusinessProtocolView.this.obm.zr(EBusinessProtocolView.this.obk);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.obi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.dismiss();
            }
        });
    }
}
