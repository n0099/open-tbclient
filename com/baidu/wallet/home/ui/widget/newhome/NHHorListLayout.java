package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.listview.BaseListAdapter;
import com.baidu.wallet.base.widget.listview.bind;
import com.baidu.wallet.base.widget.listview.internal.BindLayout;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.HomeLayoutOneTipView;
import com.baidu.wallet.home.ui.widget.inner.HorizontalListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes13.dex */
public class NHHorListLayout extends BaseItemLayout {
    public static /* synthetic */ Interceptable $ic;
    public static boolean TYPE_TWO_ITEM;
    public transient /* synthetic */ FieldHolder $fh;
    public HorizontalListView a;

    /* renamed from: b  reason: collision with root package name */
    public HomeLayoutOneTipView f51292b;

    /* renamed from: c  reason: collision with root package name */
    public a f51293c;

    /* loaded from: classes13.dex */
    public static class a extends BaseListAdapter<HomeCfgResponse.DataItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
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

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter, android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? getItem(i2).empty_view ? 1 : 0 : invokeI.intValue;
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter
        public void onBindViewHolder(List<Class<?>> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                list.add(b.class);
                list.add(c.class);
            }
        }
    }

    @BindLayout("wallet_home_nh_horlistview_item")
    /* loaded from: classes13.dex */
    public static class b extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.DataItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @bind("tv_name")
        public TextView a;
        @bind("tv_value1")

        /* renamed from: b  reason: collision with root package name */
        public TextView f51294b;
        @bind("tv_value2")

        /* renamed from: c  reason: collision with root package name */
        public TextView f51295c;
        @bind("tv_value3")

        /* renamed from: d  reason: collision with root package name */
        public TextView f51296d;
        @bind("framelayout_content")

        /* renamed from: e  reason: collision with root package name */
        public FrameLayout f51297e;
        @bind("divider_view")

        /* renamed from: f  reason: collision with root package name */
        public View f51298f;

        public b() {
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
        public void setView(HomeCfgResponse.DataItem dataItem, int i2, Context context, BaseListAdapter<HomeCfgResponse.DataItem> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, dataItem, i2, context, baseListAdapter) == null) {
                if (!NHHorListLayout.TYPE_TWO_ITEM) {
                    this.f51297e.setLayoutParams(new ViewGroup.LayoutParams(DisplayUtils.dip2px(context, 145.0f), DisplayUtils.dip2px(context, 89.0f)));
                    ((LinearLayout.LayoutParams) this.a.getLayoutParams()).setMargins(DisplayUtils.dip2px(context, 16.0f), 0, 0, 0);
                    ((LinearLayout.LayoutParams) this.f51298f.getLayoutParams()).setMargins(DisplayUtils.dip2px(context, 6.0f), 0, 0, 0);
                } else {
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
                    layoutParams.width = (DisplayUtils.getDisplayWidth(context) - (DisplayUtils.dip2px(context, 16.0f) * 3)) / 2;
                    this.f51297e.setLayoutParams(layoutParams);
                    ((LinearLayout.LayoutParams) this.a.getLayoutParams()).setMargins(DisplayUtils.dip2px(context, 20.0f), 0, 0, 0);
                    ((LinearLayout.LayoutParams) this.f51298f.getLayoutParams()).setMargins(DisplayUtils.dip2px(context, 10.0f), 0, 0, 0);
                }
                this.a.setText(dataItem.name);
                if (!TextUtils.isEmpty(dataItem.value2)) {
                    this.f51295c.setText(dataItem.value2);
                    this.f51295c.setVisibility(0);
                } else {
                    this.f51295c.setVisibility(8);
                }
                if (!TextUtils.isEmpty(dataItem.value3)) {
                    this.f51296d.setText(dataItem.value3);
                    this.f51296d.setVisibility(0);
                } else {
                    this.f51296d.setVisibility(8);
                }
                if (!TextUtils.isEmpty(dataItem.value1)) {
                    this.f51294b.setText(dataItem.value1);
                    this.f51294b.setVisibility(0);
                    return;
                }
                this.f51294b.setVisibility(8);
            }
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes13.dex */
    public static class c extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.DataItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
        public void setView(HomeCfgResponse.DataItem dataItem, int i2, Context context, BaseListAdapter<HomeCfgResponse.DataItem> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, dataItem, i2, context, baseListAdapter) == null) {
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                View view = new View(context);
                view.setLayoutParams(new ViewGroup.LayoutParams(1, DisplayUtils.dip2px(context, 89.0f)));
                return view;
            }
            return (View) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1296113654, "Lcom/baidu/wallet/home/ui/widget/newhome/NHHorListLayout;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1296113654, "Lcom/baidu/wallet/home/ui/widget/newhome/NHHorListLayout;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHHorListLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_horview_layout"), this);
            this.f51292b = (HomeLayoutOneTipView) findViewById(ResUtils.id(getContext(), "tip_view"));
            HorizontalListView horizontalListView = (HorizontalListView) findViewById(ResUtils.id(getContext(), "hor_listview"));
            this.a = horizontalListView;
            horizontalListView.setDividerWidth(DisplayUtils.dip2px(getContext(), 16.0f));
            a aVar = new a(getContext());
            this.f51293c = aVar;
            this.a.setAdapter((ListAdapter) aVar);
            this.a.setOnItemClickListener(new AdapterView.OnItemClickListener(this) { // from class: com.baidu.wallet.home.ui.widget.newhome.NHHorListLayout.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NHHorListLayout a;

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
                    this.a = this;
                }

                /* JADX WARN: Type inference failed for: r5v1, types: [android.widget.Adapter] */
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                        HomeCfgResponse.DataItem dataItem = (HomeCfgResponse.DataItem) adapterView.getAdapter().getItem(i2);
                        this.a.getWalletInterface().jump(dataItem.getName(), dataItem.getType(), dataItem.getLinkAddr(), dataItem.getPrevlogin());
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        InterceptResult invokeV;
        HomeCfgResponse.DataItem[] dataItemArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HomeCfgResponse.ConfigData configData = this.mConfigData;
            return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!TextUtils.isEmpty(this.mConfigData.getGroup_name())) {
                this.f51292b.setData(this.mConfigData, getWalletInterface());
            } else {
                this.f51292b.setVisibility(8);
            }
            ArrayList arrayList = new ArrayList();
            if (this.mConfigData.list.length <= 2) {
                TYPE_TWO_ITEM = true;
                ((LinearLayout.LayoutParams) this.a.getLayoutParams()).setMargins(DisplayUtils.dip2px(getContext(), 16.0f), 0, DisplayUtils.dip2px(getContext(), 16.0f), 0);
                arrayList.addAll(Arrays.asList(this.mConfigData.list));
            } else {
                ((LinearLayout.LayoutParams) this.a.getLayoutParams()).setMargins(0, 0, 0, 0);
                TYPE_TWO_ITEM = false;
                HomeCfgResponse.DataItem dataItem = new HomeCfgResponse.DataItem();
                dataItem.empty_view = true;
                arrayList.add(dataItem);
                arrayList.addAll(Arrays.asList(this.mConfigData.list));
                HomeCfgResponse.DataItem dataItem2 = new HomeCfgResponse.DataItem();
                dataItem2.empty_view = true;
                arrayList.add(dataItem2);
            }
            this.f51293c.initList(arrayList);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHHorListLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}
