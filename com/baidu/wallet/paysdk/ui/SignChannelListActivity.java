package com.baidu.wallet.paysdk.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.aa;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.SignBank;
import com.baidu.wallet.paysdk.datamodel.SignChannelResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.NFCUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes10.dex */
public class SignChannelListActivity extends PayBaseBeanActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BankPageAdapter f60314a;

    /* renamed from: b  reason: collision with root package name */
    public ViewPager f60315b;

    /* renamed from: c  reason: collision with root package name */
    public List<View> f60316c;

    /* renamed from: d  reason: collision with root package name */
    public ListView f60317d;

    /* renamed from: e  reason: collision with root package name */
    public ListView f60318e;

    /* renamed from: f  reason: collision with root package name */
    public final List<SignBank> f60319f;

    /* renamed from: g  reason: collision with root package name */
    public final List<SignBank> f60320g;

    /* renamed from: h  reason: collision with root package name */
    public String f60321h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60322i;
    public Activity j;
    public BankListAdapter k;
    public BankListAdapter l;
    public BindFastRequest m;
    public aa n;
    public View o;
    public View p;
    public TextView q;
    public TextView r;
    public ViewGroup s;
    public ViewGroup t;
    public View u;
    public View v;
    public TableLayout w;

    /* renamed from: com.baidu.wallet.paysdk.ui.SignChannelListActivity$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public class BankListAdapter extends BaseAdapter implements SectionIndexer, NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SignChannelListActivity f60323a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f60324b;

        /* renamed from: c  reason: collision with root package name */
        public List<SignBank> f60325c;

        /* loaded from: classes10.dex */
        public class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BankListAdapter f60328a;

            /* renamed from: b  reason: collision with root package name */
            public LinearLayout f60329b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f60330c;

            /* renamed from: d  reason: collision with root package name */
            public RelativeLayout f60331d;

            /* renamed from: e  reason: collision with root package name */
            public NetImageView f60332e;

            /* renamed from: f  reason: collision with root package name */
            public TextView f60333f;

            public a(BankListAdapter bankListAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bankListAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f60328a = bankListAdapter;
            }

            public /* synthetic */ a(BankListAdapter bankListAdapter, AnonymousClass1 anonymousClass1) {
                this(bankListAdapter);
            }
        }

        public BankListAdapter(SignChannelListActivity signChannelListActivity, List<SignBank> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signChannelListActivity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60323a = signChannelListActivity;
            this.f60325c = list;
            this.f60324b = LayoutInflater.from(signChannelListActivity.j);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<SignBank> list = this.f60325c;
                if (list != null) {
                    return list.size();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 < this.f60325c.size()) {
                    return this.f60325c.get(i2);
                }
                return null;
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.SectionIndexer
        public int getPositionForSection(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                return -1;
            }
            return invokeI.intValue;
        }

        @Override // android.widget.SectionIndexer
        public int getSectionForPosition(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                return 0;
            }
            return invokeI.intValue;
        }

        @Override // android.widget.SectionIndexer
        public Object[] getSections() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return null;
            }
            return (Object[]) invokeV.objValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
                if (view == null || view.getTag() == null) {
                    view = this.f60324b.inflate(ResUtils.layout(this.f60323a.j, "wallet_cashdesk_sign_bank_info"), (ViewGroup) null);
                    aVar = new a(this, null);
                    aVar.f60329b = (LinearLayout) view.findViewById(ResUtils.id(this.f60323a.j, "bank_item_title_layout"));
                    aVar.f60330c = (TextView) view.findViewById(ResUtils.id(this.f60323a.j, "item_title"));
                    aVar.f60332e = (NetImageView) view.findViewById(ResUtils.id(this.f60323a.j, "bank_logo"));
                    aVar.f60333f = (TextView) view.findViewById(ResUtils.id(this.f60323a.j, "bank_name"));
                    aVar.f60331d = (RelativeLayout) view.findViewById(ResUtils.id(this.f60323a.j, "bank_item_layout"));
                    view.setTag(aVar);
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.f60331d.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.baidu.wallet.paysdk.ui.SignChannelListActivity.BankListAdapter.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f60326a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BankListAdapter f60327b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60327b = this;
                        this.f60326a = i2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && this.f60326a < this.f60327b.f60325c.size() && this.f60327b.f60323a.f60322i) {
                            StatisticManager.onEventWithValue("sdk_frontpage_idauth_type_choice_bank", this.f60327b.f60323a.f60315b.getCurrentItem() == 0 ? "2" : "1");
                            this.f60327b.f60323a.m.setSubBankCode(((SignBank) this.f60327b.f60325c.get(this.f60326a)).bank_code);
                            Intent intent = this.f60327b.f60323a.getIntent();
                            if (intent == null) {
                                intent = new Intent();
                            }
                            intent.putExtra("subbankcode", ((SignBank) this.f60327b.f60325c.get(this.f60326a)).bank_code);
                            this.f60327b.f60323a.setResult(-1, intent);
                            this.f60327b.f60323a.finish();
                        }
                    }
                });
                if (i2 == getPositionForSection(getSectionForPosition(i2))) {
                    aVar.f60329b.setVisibility(0);
                } else {
                    aVar.f60329b.setVisibility(8);
                }
                aVar.f60332e.setVisibility(0);
                aVar.f60332e.setImageResource(ResUtils.drawable(this.f60323a.j, "wallet_base_banklogo_defult"));
                aVar.f60332e.setImageUrl(this.f60325c.get(i2).bank_url);
                aVar.f60333f.setText(this.f60325c.get(i2).bank_name);
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class BankPageAdapter extends PagerAdapter implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SignChannelListActivity f60334a;

        public BankPageAdapter(SignChannelListActivity signChannelListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signChannelListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60334a = signChannelListActivity;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(View view, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, view, i2, obj) == null) {
                ((ViewPager) view).removeView((View) this.f60334a.f60316c.get(i2));
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60334a.f60316c.size() : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(View view, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, view, i2)) == null) {
                View view2 = (View) this.f60334a.f60316c.get(i2);
                if (view2.getParent() != null) {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                }
                ((ViewPager) view).addView(view2);
                return view2;
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, parcelable, classLoader) == null) {
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Parcelable saveState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return null;
            }
            return (Parcelable) invokeV.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public class GuidePageChangeListener implements ViewPager.OnPageChangeListener, NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SignChannelListActivity f60335a;

        public GuidePageChangeListener(SignChannelListActivity signChannelListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signChannelListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60335a = signChannelListActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (i2 == 0) {
                    this.f60335a.a(true);
                } else if (i2 != 1) {
                } else {
                    this.f60335a.a(false);
                }
            }
        }
    }

    public SignChannelListActivity() {
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
        this.f60316c = new ArrayList();
        this.f60319f = new ArrayList();
        this.f60320g = new ArrayList();
        this.f60321h = "0";
        this.f60322i = false;
    }

    @Override // com.dxmpay.wallet.core.BaseActivity
    public void cancleRequest() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.n == null) {
            return;
        }
        BeanManager.getInstance().removeBean(this.n);
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this, -1);
            if (i2 == this.n.getBeanId()) {
                GlobalUtils.toast(this.j, str);
                finish();
                return;
            }
            super.handleFailure(i2, i3, str);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        SignBank[] signBankArr;
        SignBank[] signBankArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this, -1);
            if (i2 == this.n.getBeanId()) {
                this.f60316c.clear();
                this.f60314a.notifyDataSetChanged();
                SignChannelResponse signChannelResponse = (SignChannelResponse) obj;
                if (signChannelResponse != null && (signBankArr2 = signChannelResponse.arr_debit) != null && signBankArr2.length > 0) {
                    this.f60316c.add(this.f60318e);
                    this.f60320g.clear();
                    this.f60320g.addAll(Arrays.asList(signChannelResponse.arr_debit));
                    BankListAdapter bankListAdapter = this.l;
                    if (bankListAdapter != null) {
                        bankListAdapter.notifyDataSetChanged();
                    }
                }
                if (signChannelResponse != null && (signBankArr = signChannelResponse.arr_credit) != null && signBankArr.length > 0) {
                    this.f60316c.add(this.f60317d);
                    this.f60319f.clear();
                    this.f60319f.addAll(Arrays.asList(signChannelResponse.arr_credit));
                    BankListAdapter bankListAdapter2 = this.k;
                    if (bankListAdapter2 != null) {
                        bankListAdapter2.notifyDataSetChanged();
                    }
                }
                TableLayout tableLayout = this.w;
                if (tableLayout == null) {
                    return;
                }
                tableLayout.setVisibility(0);
                this.f60315b.setVisibility(0);
                this.f60314a.notifyDataSetChanged();
                a(signChannelResponse);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.q) {
                this.f60315b.setCurrentItem(1);
            } else if (view == this.r) {
                this.f60315b.setCurrentItem(0);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            if (getIntent() != null && getIntent().getExtras() != null) {
                this.f60322i = getIntent().getExtras().getBoolean("isSelectBank");
            }
            setFlagPaySdk();
            this.j = getActivity();
            c();
            a();
            b();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans("SignChannelListActivity");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            PayRequestCache.BindCategory bindCategory = PayRequestCache.getInstance().isPaying() ? PayRequestCache.BindCategory.Other : PayRequestCache.BindCategory.Initiative;
            BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(bindCategory.name());
            this.m = bindFastRequest;
            if (bindFastRequest == null) {
                this.m = new BindFastRequest();
                PayRequestCache.getInstance().addBeanRequestToCache(bindCategory.name(), this.m);
            }
            WalletGlobalUtils.safeShowDialog(this, -1, "");
            if (this.n == null) {
                this.n = (aa) PayBeanFactory.getInstance().getBean((Context) this.j, 517, "SignChannelListActivity");
            }
            this.n.setResponseCallback(this);
            this.n.execBean();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View inflate = layoutInflater.inflate(ResUtils.layout(this.j, "wallet_cashdesk_sign_channel_page"), (ViewGroup) null);
            this.o = inflate;
            this.f60317d = (ListView) inflate.findViewById(ResUtils.id(this.j, "bd_wallet_bank_listview"));
            View inflate2 = layoutInflater.inflate(ResUtils.layout(this.j, "wallet_cashdesk_sign_channel_page"), (ViewGroup) null);
            this.p = inflate2;
            this.f60318e = (ListView) inflate2.findViewById(ResUtils.id(this.j, "bd_wallet_bank_listview"));
            BankListAdapter bankListAdapter = new BankListAdapter(this, this.f60319f);
            this.k = bankListAdapter;
            this.f60317d.setAdapter((ListAdapter) bankListAdapter);
            BankListAdapter bankListAdapter2 = new BankListAdapter(this, this.f60320g);
            this.l = bankListAdapter2;
            this.f60318e.setAdapter((ListAdapter) bankListAdapter2);
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            setContentView(ResUtils.layout(this.j, "wallet_cashdesk_sign_channel_list_activity"));
            initActionBar(this.f60322i ? "bd_wallet_own_parent_banks" : "bd_wallet_own_support_banks");
            this.q = (TextView) findViewById(ResUtils.id(this.j, "bd_wallet_credit"));
            this.r = (TextView) findViewById(ResUtils.id(this.j, "bd_wallet_debit"));
            this.s = (ViewGroup) findViewById(ResUtils.id(this.j, "bd_wallet_first_tab"));
            this.t = (ViewGroup) findViewById(ResUtils.id(this.j, "bd_wallet_second_tab"));
            this.f60315b = (ViewPager) findViewById(ResUtils.id(this.j, "bd_wallet_viewPager"));
            this.u = findViewById(ResUtils.id(this.j, "bd_wallet_credit_tab"));
            this.v = findViewById(ResUtils.id(this.j, "bd_wallet_debit_tab"));
            this.w = (TableLayout) findViewById(ResUtils.id(this.j, "table_layout"));
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            BankPageAdapter bankPageAdapter = new BankPageAdapter(this);
            this.f60314a = bankPageAdapter;
            this.f60315b.setAdapter(bankPageAdapter);
            this.f60315b.setOnPageChangeListener(new GuidePageChangeListener(this));
        }
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, this, z) == null) {
            if (z) {
                this.s.getChildAt(0).setVisibility(4);
                this.s.getChildAt(1).setVisibility(0);
                this.t.getChildAt(0).setVisibility(0);
                this.t.getChildAt(1).setVisibility(4);
                return;
            }
            this.s.getChildAt(0).setVisibility(0);
            this.s.getChildAt(1).setVisibility(4);
            this.t.getChildAt(0).setVisibility(4);
            this.t.getChildAt(1).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z) == null) {
            if (z) {
                this.q.setTextColor(getResources().getColor(ResUtils.color(this.j, "dxm_wallet_base_font_text3Color")));
                this.r.setTextColor(getResources().getColor(ResUtils.color(this.j, "dxm_wallet_base_mainColor")));
                b(false);
                return;
            }
            this.q.setTextColor(getResources().getColor(ResUtils.color(this.j, "dxm_wallet_base_mainColor")));
            this.r.setTextColor(getResources().getColor(ResUtils.color(this.j, "dxm_wallet_base_font_text3Color")));
            b(true);
        }
    }

    private void a(SignChannelResponse signChannelResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, signChannelResponse) == null) {
            if (signChannelResponse == null) {
                this.v.setVisibility(0);
                this.s.setVisibility(0);
                this.u.setVisibility(0);
                b(true);
                this.f60315b.setCurrentItem(0);
                a(true);
                return;
            }
            SignBank[] signBankArr = signChannelResponse.arr_debit;
            if (signBankArr != null && signBankArr.length > 0) {
                this.v.setVisibility(0);
                this.s.setVisibility(0);
                b(true);
            } else {
                this.v.setVisibility(8);
                this.s.setVisibility(8);
                b(false);
            }
            SignBank[] signBankArr2 = signChannelResponse.arr_credit;
            if (signBankArr2 != null && signBankArr2.length > 0) {
                this.u.setVisibility(0);
                this.t.setVisibility(0);
                b(true);
            } else {
                b(false);
                this.u.setVisibility(8);
                this.t.setVisibility(8);
            }
            if (this.v.getVisibility() == 0) {
                this.f60315b.setCurrentItem(0);
                a(true);
                return;
            }
            this.f60315b.setCurrentItem(1);
            a(false);
        }
    }
}
