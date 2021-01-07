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
/* loaded from: classes8.dex */
public class EBusinessProtocolView extends Dialog {
    private Context mContext;
    private View mRootView;
    private int mSkinType;
    private String mTitle;
    private final String odq;
    private TextView odr;
    private WebView ods;
    private TBSpecificationBtn odt;
    private TBSpecificationBtn odu;
    private TextView odv;
    private Button odw;
    private boolean odx;
    private WindowType ody;
    private a odz;
    private WebViewClient webViewClient;

    /* loaded from: classes8.dex */
    public enum WindowType {
        TIP,
        PROTOCOL
    }

    /* loaded from: classes8.dex */
    public interface a {
        void zo(boolean z);
    }

    public EBusinessProtocolView(@NonNull Context context) {
        super(context, R.style.e_business_protocol_dialog);
        this.odq = "file:///android_asset/protocol.html";
        this.odx = false;
        this.mSkinType = 0;
        this.webViewClient = new WebViewClient() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                String str2 = "javascript:setContentTextColor(" + EBusinessProtocolView.this.mSkinType + ")";
                if (EBusinessProtocolView.this.ods != null) {
                    EBusinessProtocolView.this.ods.loadUrl(str2);
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
        MI(i);
        this.mSkinType = i;
        ao.setViewTextColor(this.odr, R.color.CAM_X0105);
        ao.setBackgroundColor(this.ods, R.color.CAM_X0211);
        ao.setViewTextColor(this.odt, R.color.CAM_X0108);
        ao.setViewTextColor(this.odu, R.color.CAM_X0303);
        ao.setViewTextColor(this.odv, R.color.CAM_X0105);
    }

    public void a(a aVar) {
        this.odz = aVar;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void a(WindowType windowType) {
        this.ody = windowType;
    }

    private void initView() {
        this.odr = (TextView) this.mRootView.findViewById(R.id.protocol_title);
        this.odr.setText(this.mTitle);
        this.ods = (WebView) this.mRootView.findViewById(R.id.protocol_content);
        this.odu = (TBSpecificationBtn) this.mRootView.findViewById(R.id.agree_protocol);
        this.odu.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.rs(R.color.CAM_X0302);
        this.odu.setConfig(cVar);
        this.odu.setTextSize(R.dimen.tbds42);
        this.odu.setText(this.mContext.getResources().getString(R.string.protocol_agree));
        this.odt = (TBSpecificationBtn) this.mRootView.findViewById(R.id.cancel_protocol);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.rs(R.color.CAM_X0107);
        this.odt.setConfig(cVar2);
        this.odt.setTextSize(R.dimen.tbds42);
        this.odt.setText(this.mContext.getResources().getString(R.string.protocol_cancel));
        this.odv = (TextView) this.mRootView.findViewById(R.id.tip_content);
        this.odw = (Button) findViewById(R.id.tip_known);
        this.odw.setText(R.string.tip_known);
        this.odw.setTextColor(ao.getColor(R.color.CAM_X0302));
        dZq();
        dZp();
        dZo();
        Hi();
    }

    private void dZo() {
        if (WindowType.TIP == this.ody) {
            this.odv.setVisibility(0);
            this.odw.setVisibility(0);
            setCanceledOnTouchOutside(true);
        }
        if (WindowType.PROTOCOL == this.ody) {
            this.ods.setVisibility(0);
            this.odu.setVisibility(0);
            this.odt.setVisibility(0);
        }
    }

    private void MI(int i) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setColor(ao.getColor(i, R.color.CAM_X0211));
        this.mRootView.setBackgroundDrawable(gradientDrawable);
    }

    private void dZp() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_1) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_2) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_3) + "\n"));
        spannableStringBuilder.append((CharSequence) (getContext().getResources().getString(R.string.tip_content_4) + "\n"));
        spannableStringBuilder.append((CharSequence) getContext().getResources().getString(R.string.tip_content_5));
        this.odv.setText(spannableStringBuilder);
    }

    private void dZq() {
        WebSettings settings = this.ods.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.ods.setWebViewClient(this.webViewClient);
        settings.setTextZoom(115);
        this.ods.loadUrl("file:///android_asset/protocol.html");
    }

    private void Hi() {
        this.odu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.odx = true;
                EBusinessProtocolView.this.odz.zo(EBusinessProtocolView.this.odx);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.odt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.odx = false;
                EBusinessProtocolView.this.odz.zo(EBusinessProtocolView.this.odx);
                EBusinessProtocolView.this.dismiss();
            }
        });
        this.odw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.EBusinessProtocolView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EBusinessProtocolView.this.dismiss();
            }
        });
    }
}
