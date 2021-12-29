package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.datamodel.BindCardProtocolPreviewResponse;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.walletsdk.pay.R;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.storage.HtmlDataCache;
import com.dxmpay.wallet.paysdk.ui.WebViewActivity;
import com.dxmpay.wallet.utils.StatHelper;
/* loaded from: classes13.dex */
public class BindCardProtocolActivity extends HalfProtocolScreenBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CARD_NO = "card_no";
    public static final String IDENTITY_CODE = "identity_code";
    public static final String IDENTITY_TYPE = "identity_type";
    public static final String MOBILE = "mobile";
    public static final String PROTOCOL_SNAPSHOT_ID = "snapshotId";
    public static final String TRUE_NAME = "true_name";
    public transient /* synthetic */ FieldHolder $fh;
    public BindFastRequest a;

    /* renamed from: b  reason: collision with root package name */
    public String f54303b;

    /* renamed from: c  reason: collision with root package name */
    public String f54304c;

    /* renamed from: d  reason: collision with root package name */
    public String f54305d;

    /* renamed from: e  reason: collision with root package name */
    public String f54306e;

    /* renamed from: f  reason: collision with root package name */
    public String f54307f;

    /* renamed from: g  reason: collision with root package name */
    public String f54308g;

    /* renamed from: h  reason: collision with root package name */
    public String f54309h;

    public BindCardProtocolActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity
    public void addContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesh_bind_card_protocol_activity"), null);
            this.mContentView = viewGroup;
            this.mHalfScreenContainer.addView(viewGroup);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatHelper.statServiceEvent(PayStatServiceEvent.CLOSE_PROTOCOL_PAGE);
            finishWithoutAnim();
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
            WalletGlobalUtils.DismissLoadingDialog();
            super.onBeanExecFailure(i2, i3, str);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) {
            WalletGlobalUtils.DismissLoadingDialog();
            BindCardProtocolPreviewResponse bindCardProtocolPreviewResponse = (BindCardProtocolPreviewResponse) obj;
            if (bindCardProtocolPreviewResponse != null) {
                String str2 = bindCardProtocolPreviewResponse.protocolHtml;
                if (!TextUtils.isEmpty(str2)) {
                    HtmlDataCache.getInstance().setHtml(str2);
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("webview_title_string", this.f54304c);
                    intent.putExtra(WebViewActivity.HTML_DATA_FROM_SCENE, "1");
                    startActivity(intent);
                } else {
                    GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_fp_get_data_fail"));
                }
            }
            super.onBeanExecSuccess(i2, obj, str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && view == this.mLeftImg) {
            onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = (BindFastRequest) PayRequestCache.getInstance().getRequest(PayRequestCache.getInstance().getBindCategoryByIntent(getIntent()));
            this.f54303b = getIntent().getStringExtra(PROTOCOL_SNAPSHOT_ID);
            this.f54305d = getIntent().getStringExtra(TRUE_NAME);
            this.f54307f = getIntent().getStringExtra("identity_code");
            this.f54306e = getIntent().getStringExtra(IDENTITY_TYPE);
            this.f54308g = getIntent().getStringExtra("card_no");
            this.f54309h = getIntent().getStringExtra("mobile");
            StatHelper.statServiceEvent(PayStatServiceEvent.ENTER_PROTOCOL_PAGE);
            a();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            this.a = null;
            BeanManager.getInstance().removeAllBeans("BindCardProtocolActivity");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mLeftImg.setOnClickListener(this);
            TextView textView = (TextView) findViewById(R.id.tv_bindcard_protocol_main_title);
            TextView textView2 = (TextView) findViewById(R.id.tv_bindcard_protocol_tip);
            TextView textView3 = (TextView) findViewById(R.id.tv_bindcard_protocol_subtitle);
            ListView listView = (ListView) findViewById(R.id.list_bindcard_protocol);
            BindFastRequest bindFastRequest = this.a;
            if (bindFastRequest == null || bindFastRequest.getmBankInfo() == null || this.a.getmBankInfo().protocol_platform_info == null || this.a.getmBankInfo().protocol_platform_info.list == null) {
                return;
            }
            GetCardInfoResponse.ProtocolPlatformInfo protocolPlatformInfo = this.a.getmBankInfo().protocol_platform_info;
            textView.setText(protocolPlatformInfo.main_title);
            textView2.setText(protocolPlatformInfo.prompt);
            textView3.setText(protocolPlatformInfo.sub_title);
            com.baidu.wallet.paysdk.ui.widget.a.b bVar = new com.baidu.wallet.paysdk.ui.widget.a.b(this, protocolPlatformInfo.list);
            listView.setAdapter((ListAdapter) bVar);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(this, bVar) { // from class: com.baidu.wallet.paysdk.ui.BindCardProtocolActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.baidu.wallet.paysdk.ui.widget.a.b a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BindCardProtocolActivity f54310b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f54310b = this;
                    this.a = bVar;
                }

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    GetCardInfoResponse.ProtocolPlatformItem item;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (item = this.a.getItem(i2)) == null) {
                        return;
                    }
                    StatHelper.statServiceEvent(PayStatServiceEvent.CLICK_PROTOCOL_ITEM);
                    this.f54310b.f54304c = item.templateName;
                    this.f54310b.a(item.protocolType, item.templateCode);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2) == null) {
            WalletGlobalUtils.showLoadingDialog(this);
            com.baidu.wallet.paysdk.beans.c cVar = (com.baidu.wallet.paysdk.beans.c) PayBeanFactory.getInstance().getBean((Context) this, 605, "BindCardProtocolActivity");
            cVar.d(this.f54305d);
            cVar.e(this.f54306e);
            cVar.f(this.f54307f);
            cVar.h(this.f54309h);
            cVar.g(this.f54308g);
            cVar.b(str);
            cVar.a(this.f54303b);
            cVar.c(str2);
            cVar.setResponseCallback(this);
            cVar.execBean();
        }
    }
}
