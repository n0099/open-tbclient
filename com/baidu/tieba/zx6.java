package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.downloadmanager.data.DownloadManageModeCardType;
import com.baidu.tieba.downloadmanager.ui.adapter.ItemCardViewWrapperAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class zx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    public BdTypeRecyclerView b;
    public ItemCardViewWrapperAdapter c;
    public List<om> d;
    public int e;
    public int f;

    public zx6(BaseFragment baseFragment, BdTypeRecyclerView bdTypeRecyclerView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, bdTypeRecyclerView, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new ArrayList();
        this.a = baseFragment;
        this.b = bdTypeRecyclerView;
        this.e = i;
        this.f = i2;
        b();
    }

    public void a(DownloadManageModeCardType downloadManageModeCardType) {
        ItemCardViewWrapperAdapter itemCardViewWrapperAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, downloadManageModeCardType) == null) && (itemCardViewWrapperAdapter = this.c) != null) {
            itemCardViewWrapperAdapter.E(downloadManageModeCardType);
        }
    }

    public void d(ItemCardViewWrapperAdapter.b bVar) {
        ItemCardViewWrapperAdapter itemCardViewWrapperAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) && (itemCardViewWrapperAdapter = this.c) != null) {
            itemCardViewWrapperAdapter.H(bVar);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ItemCardViewWrapperAdapter itemCardViewWrapperAdapter = new ItemCardViewWrapperAdapter(this.a.getContext(), ox6.g, this.e, this.b, this.f);
            this.c = itemCardViewWrapperAdapter;
            this.d.add(itemCardViewWrapperAdapter);
            this.b.addAdapters(this.d);
        }
    }

    public void c() {
        ItemCardViewWrapperAdapter itemCardViewWrapperAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (itemCardViewWrapperAdapter = this.c) != null) {
            itemCardViewWrapperAdapter.notifyDataSetChanged();
        }
    }
}
