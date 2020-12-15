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
    private final String obe;
    private TextView obf;
    private WebView obg;
    private TBSpecificationBtn obh;
    private TBSpecificationBtn obi;
    private TextView obk;
    private Button obl;
    private boolean obm;
    private WindowType obn;
    private a obo;
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
        this.obe = "file:///android_asset/protocol.html";
        this.obm = false;
        this.mSkinType = 0;
        this.webViewClient = new WebViewClient() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                String str2 = "javascript:setContentTextColor(" + EBusinessProtocolView.this.mSkinType + ")";
                if (EBusinessProtocolView.this.obg != null) {
                    EBusinessProtocolView.this.obg.loadUrl(str2);
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
        ap.setViewTextColor(this.obf, R.color.CAM_X0105);
        ap.setBackgroundColor(this.obg, R.color.CAM_X0211);
        ap.setViewTextColor(this.obh, R.color.CAM_X0108);
        ap.setViewTextColor(this.obi, R.color.CAM_X0303);
        ap.setViewTextColor(this.obk, R.color.CAM_X0105);
    }

    public void a(a aVar) {
        this.obo = aVar;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void a(WindowType windowType) {
        this.obn = windowType;
    }

    private void initView() {
        this.obf = (TextView) this.mRootView.findViewById(R.id.protocol_title);
        this.obf.setText(this.mTitle);
        this.obg = (WebView) this.mRootView.findViewById(R.id.protocol_content);
        this.obi = (TBSpecificationBtn) this.mRootView.findViewById(R.id.agree_protocol);
        this.obi.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.rh(R.color.CAM_X0302);
        this.obi.setConfig(cVar);
        this.obi.setTextSize(R.dimen.tbds42);
        this.obi.setText(this.mContext.getResources().getString(R.string.protocol_agree));
        this.obh = (TBSpecificationBtn) this.mRootView.findViewById(R.id.cancel_protocol);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.rh(R.color.CAM_X0107);
        this.obh.setConfig(cVar2);
        this.obh.setTextSize(R.dimen.tbds42);
        this.obh.setText(this.mContext.getResources().getString(R.string.protocol_cancel));
        this.obk = (TextView) this.mRootView.findViewById(R.id.tip_content);
        this.obl = (Button) findViewById(R.id.tip_known);
        this.obl.setText(R.string.tip_known);
        this.obl.setTextColor(ap.getColor(R.color.CAM_X0302));
        eag();
        eaf();
        eae();
        HH();
    }

    private void eae() {
        if (WindowType.TIP == this.obn) {
            this.obk.setVisibility(0);
            this.obl.setVisibility(0);
            setCanceledOnTouchOutside(true);
        }
        if (WindowType.PROTOCOL == this.obn) {
            this.obg.setVisibility(0);
            this.obi.setVisibility(0);
            this.obh.setVisibility(0);
        }
    }

    private void MW(int i) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setColor(ap.getColor(i, R.color.CAM_X0211));
        this.mRootView.setBackgroundDrawable(gradientDrawable);
    }

    private void eaf() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_1) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_2) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_3) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_4) + "\n"));
        spannableStringBuilder.append((CharSequence) getContext().getResources().getString(R.string.tip_content_5));
        this.obk.setText(spannableStringBuilder);
    }

    private void eag() {
        WebSettings settings = this.obg.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.obg.setWebViewClient(this.webViewClient);
        settings.setTextZoom(115);
        this.obg.loadUrl("file:///android_asset/protocol.html");
    }

    private void HH() {
        this.obi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.obm = true;
                EBusinessProtocolView.this.obo.zr(EBusinessProtocolView.this.obm);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.obh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.obm = false;
                EBusinessProtocolView.this.obo.zr(EBusinessProtocolView.this.obm);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.obl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.dismiss();
            }
        });
    }
}
