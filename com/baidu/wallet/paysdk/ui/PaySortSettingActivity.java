package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.listview.BaseListAdapter;
import com.baidu.wallet.base.widget.listview.bind;
import com.baidu.wallet.base.widget.listview.internal.BindLayout;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.ad;
import com.baidu.wallet.paysdk.datamodel.PaySetResponse;
import com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class PaySortSettingActivity extends PayBaseBeanActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_FINISH_SAVE_FAIL = 101;
    public static final int STATE_FINISH_SAVE_SUC = 100;

    /* renamed from: f  reason: collision with root package name */
    public static a f26763f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f26764a;

    /* renamed from: b  reason: collision with root package name */
    public final String f26765b;

    /* renamed from: c  reason: collision with root package name */
    public BdActionBar f26766c;

    /* renamed from: d  reason: collision with root package name */
    public DragSortListView f26767d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26768e;

    /* renamed from: g  reason: collision with root package name */
    public DragSortListView.h f26769g;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
    }

    /* loaded from: classes5.dex */
    public static class b extends BaseListAdapter<PaySetResponse.PayInfoBean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter
        public void onBindViewHolder(List<Class<?>> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                list.add(c.class);
            }
        }
    }

    public PaySortSettingActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26765b = PaySortSettingActivity.class.getSimpleName();
        this.f26768e = false;
        this.f26769g = new DragSortListView.h(this) { // from class: com.baidu.wallet.paysdk.ui.PaySortSettingActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PaySortSettingActivity f26770a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f26770a = this;
            }

            @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.h
            public void drop(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(1048576, this, i4, i5) == null) || i4 == i5) {
                    return;
                }
                this.f26770a.f26768e = true;
                PaySetResponse.PayInfoBean item = this.f26770a.f26764a.getItem(i4);
                if (item != null) {
                    this.f26770a.f26764a.getList().remove(item);
                    this.f26770a.f26764a.getList().add(i5, item);
                    this.f26770a.f26764a.notifyDataSetChanged();
                }
            }
        };
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            c();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            com.baidu.wallet.paysdk.ui.widget.dragListView.a buildController = buildController(this.f26767d);
            this.f26767d.setFloatViewManager(buildController);
            this.f26767d.setOnTouchListener(buildController);
            this.f26767d.setDragEnabled(true);
            this.f26767d.setDropListener(this.f26769g);
            ArrayList<PaySetResponse.PayInfoBean> d2 = d();
            if (d2 == null || d2.size() == 0) {
                return;
            }
            b bVar = new b(getActivity());
            this.f26764a = bVar;
            this.f26767d.setAdapter((ListAdapter) bVar);
            this.f26764a.initList(d2);
        }
    }

    public static void clearOnModifyPaySortListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, aVar) == null) {
            f26763f = null;
        }
    }

    private ArrayList<PaySetResponse.PayInfoBean> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? (ArrayList) getIntent().getSerializableExtra("paymethod_info") : (ArrayList) invokeV.objValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            ad adVar = (ad) PayBeanFactory.getInstance().getBean((Context) this, PayBeanFactory.BEAN_ID_PAY_SORT_SAVE, this.f26765b);
            List<PaySetResponse.PayInfoBean> list = this.f26764a.getList();
            adVar.a((list == null || list.size() <= 0) ? null : JsonUtils.toJson(list));
            adVar.setResponseCallback(this);
            adVar.execBean();
        }
    }

    public static Intent getStartIntent(Context context, PaySetResponse.PayInfoBean[] payInfoBeanArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, context, payInfoBeanArr, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, payInfoBeanArr);
            Intent intent = new Intent(context, PaySortSettingActivity.class);
            intent.putExtra("paymethod_info", arrayList);
            intent.putExtra("paymethod_type", i2);
            return intent;
        }
        return (Intent) invokeLLI.objValue;
    }

    public static void setOnModifyPaySortListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, aVar) == null) {
            f26763f = aVar;
        }
    }

    public com.baidu.wallet.paysdk.ui.widget.dragListView.a buildController(DragSortListView dragSortListView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dragSortListView)) == null) {
            com.baidu.wallet.paysdk.ui.widget.dragListView.a aVar = new com.baidu.wallet.paysdk.ui.widget.dragListView.a(dragSortListView);
            aVar.c(ResUtils.id(this, "bd_wallet_paysort_click_img"));
            aVar.a(true);
            aVar.b(false);
            aVar.e(-1);
            return aVar;
        }
        return (com.baidu.wallet.paysdk.ui.widget.dragListView.a) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) && i2 == 560) {
            if (i3 == -8) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_settings_fail_network"));
            } else {
                super.handleFailure(i2, i3, str);
                PaySettingActivity.toast(getActivity(), "ebpay_setting_fail", false);
            }
            setResult(101);
            a aVar = f26763f;
            if (aVar != null) {
                aVar.a(false);
                f26763f = null;
            }
            super.onBackPressed();
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) && i2 == 560) {
            PaySettingActivity.toast(getActivity(), "ebpay_setting_suc", true);
            setResult(100);
            a aVar = f26763f;
            if (aVar != null) {
                aVar.a(true);
                f26763f = null;
            }
            finish();
        }
    }

    public void initListFoot() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = (TextView) LayoutInflater.from(this).inflate(ResUtils.layout(this, "wallet_cashdesk_paysort_tip_layout"), (ViewGroup) null);
            textView.setText(ResUtils.getString(getActivity(), "ebpay_paysetting_person_checked_tips"));
            this.f26767d.addFooterView(textView);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f26768e) {
                e();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(ResUtils.layout(this, "wallet_cashdesk_pay_sort_set_activity"));
            a();
            b();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans(this.f26765b);
            f26763f = null;
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(this, "bdactionbar"));
            this.f26766c = bdActionBar;
            bdActionBar.setTitle("扣款顺序");
            this.f26766c.setLeftZoneOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PaySortSettingActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PaySortSettingActivity f26771a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f26771a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        GlobalUtils.hideKeyboard(this.f26771a.getActivity());
                        this.f26771a.onBackPressed();
                    }
                }
            });
            this.f26767d = (DragSortListView) findViewById(ResUtils.id(this, "listview_sort"));
            ((TextView) findViewById(ResUtils.id(this, "sort_title"))).setText("扣款方式");
            ((TextView) findViewById(ResUtils.id(this, "sort_desc"))).setText("按住右侧拖动以调整顺序");
            this.f26767d.setOverScrollMode(2);
            initListFoot();
        }
    }

    @BindLayout("wallet_cashdesk_pay_sort_setting_item_view")
    /* loaded from: classes5.dex */
    public static class c extends BaseListAdapter.BaseViewHolder<PaySetResponse.PayInfoBean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @bind("bd_wallet_paysort_item_img")

        /* renamed from: a  reason: collision with root package name */
        public NetImageView f26772a;
        @bind("ebpay_sort_tv")

        /* renamed from: b  reason: collision with root package name */
        public TextView f26773b;

        public c() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(PaySetResponse.PayInfoBean payInfoBean, int i2, Context context, BaseListAdapter<PaySetResponse.PayInfoBean> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payInfoBean, i2, context, baseListAdapter) == null) {
                if (TextUtils.equals(payInfoBean.pay_type, "easypay")) {
                    a(payInfoBean);
                } else {
                    a(payInfoBean, context);
                }
            }
        }

        public void a(PaySetResponse.PayInfoBean payInfoBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, payInfoBean) == null) {
                String str = payInfoBean.account_no;
                String substring = str.substring(str.length() - 4);
                String str2 = payInfoBean.type_name;
                if (TextUtils.isEmpty(str2)) {
                    str2 = ResUtils.getString(this.f26772a.getContext(), payInfoBean.card_type == 1 ? "wallet_base_mode_credit" : "wallet_base_mode_debit");
                }
                this.f26773b.setText(CardData.BondCard.getCardDesc(payInfoBean.name, substring, str2, true));
                this.f26772a.setImageUrl(payInfoBean.bank_url);
            }
        }

        public void a(PaySetResponse.PayInfoBean payInfoBean, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, payInfoBean, context) == null) {
                this.f26772a.setImageResource(ResUtils.drawable(context, "wallet_base_paytype_balance"));
                this.f26772a.setImageUrl("no");
                this.f26773b.setText("余额");
            }
        }
    }
}
