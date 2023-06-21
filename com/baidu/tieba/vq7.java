package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.h5.FrsTabWebFragment;
import com.baidu.tieba.frs.h5.NewFrsTabWebFragment;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsTabInfo;
/* loaded from: classes8.dex */
public class vq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends fn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment c;
        public final /* synthetic */ FrsTabInfo d;
        public final /* synthetic */ FrsViewData e;
        public final /* synthetic */ int f;

        @Override // com.baidu.tieba.fn5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.fn5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(FrsFragment frsFragment, FrsTabInfo frsTabInfo, FrsViewData frsViewData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, frsTabInfo, frsViewData, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsFragment;
            this.d = frsTabInfo;
            this.e = frsViewData;
            this.f = i;
        }

        @Override // com.baidu.tieba.fn5
        public gn5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                FrsFragment frsFragment = this.c;
                if (frsFragment != null && frsFragment.y1() != null) {
                    frsAllThreadFragment.J1(this.c.y1().Z());
                    this.c.X4(ht7.e(this.d, this.e.showAdsense.intValue()));
                }
                Bundle bundle = new Bundle();
                FrsFragment frsFragment2 = this.c;
                if (frsFragment2 != null) {
                    bundle.putString("forum_id", frsFragment2.w());
                }
                bundle.putInt("tab_id", this.f);
                bundle.putBoolean("isAdded", false);
                frsAllThreadFragment.setArguments(bundle);
                gn5 gn5Var = new gn5();
                gn5Var.a = frsAllThreadFragment;
                gn5Var.e = 1;
                gn5Var.i = gn5.k;
                return gn5Var;
            }
            return (gn5) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends fn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ FrsViewData d;
        public final /* synthetic */ FrsFragment e;
        public final /* synthetic */ int f;

        @Override // com.baidu.tieba.fn5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.fn5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public b(FrsTabInfo frsTabInfo, FrsViewData frsViewData, FrsFragment frsFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabInfo, frsViewData, frsFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsTabInfo;
            this.d = frsViewData;
            this.e = frsFragment;
            this.f = i;
        }

        @Override // com.baidu.tieba.fn5
        public gn5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, ht7.e(this.c, this.d.showAdsense.intValue()));
                bundle.putString("name", this.e.v());
                bundle.putString("from", this.e.getFrom());
                bundle.putBoolean("back_special", false);
                bundle.putBoolean(FrsActivityConfig.GOOD, true);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.e.w());
                bundle.putBoolean("isAdded", false);
                frsGoodFragment.setArguments(bundle);
                gn5 gn5Var = new gn5();
                gn5Var.a = frsGoodFragment;
                gn5Var.e = this.f;
                gn5Var.i = gn5.k;
                return gn5Var;
            }
            return (gn5) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends fn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ FrsViewData d;
        public final /* synthetic */ FrsFragment e;
        public final /* synthetic */ int f;

        @Override // com.baidu.tieba.fn5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.fn5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public c(FrsTabInfo frsTabInfo, FrsViewData frsViewData, FrsFragment frsFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabInfo, frsViewData, frsFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsTabInfo;
            this.d = frsViewData;
            this.e = frsFragment;
            this.f = i;
        }

        @Override // com.baidu.tieba.fn5
        public gn5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, ht7.e(this.c, this.d.showAdsense.intValue()));
                bundle.putString("name", this.e.v());
                bundle.putString("from", this.e.getFrom());
                bundle.putBoolean("back_special", false);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.e.w());
                bundle.putBoolean("isAdded", false);
                frsNewAreaFragment.setArguments(bundle);
                gn5 gn5Var = new gn5();
                gn5Var.a = frsNewAreaFragment;
                gn5Var.e = this.f;
                gn5Var.i = gn5.k;
                return gn5Var;
            }
            return (gn5) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends fn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment c;

        @Override // com.baidu.tieba.fn5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.fn5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public d(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsFragment;
        }

        @Override // com.baidu.tieba.fn5
        public gn5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsADFragment frsADFragment = new FrsADFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.c.v());
                bundle.putString("from", this.c.getFrom());
                bundle.putString("forum_id", this.c.w());
                bundle.putBoolean("isAdded", false);
                frsADFragment.setArguments(bundle);
                gn5 gn5Var = new gn5();
                gn5Var.a = frsADFragment;
                gn5Var.e = 90;
                gn5Var.i = gn5.k;
                return gn5Var;
            }
            return (gn5) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class e extends fn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ FrsViewData d;
        public final /* synthetic */ FrsFragment e;
        public final /* synthetic */ int f;

        @Override // com.baidu.tieba.fn5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.fn5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public e(FrsTabInfo frsTabInfo, FrsViewData frsViewData, FrsFragment frsFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabInfo, frsViewData, frsFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsTabInfo;
            this.d = frsViewData;
            this.e = frsFragment;
            this.f = i;
        }

        @Override // com.baidu.tieba.fn5
        public gn5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, ht7.e(this.c, this.d.showAdsense.intValue()));
                bundle.putString("name", this.e.v());
                bundle.putString("from", this.e.getFrom());
                bundle.putString("forum_id", this.e.w());
                bundle.putInt("tab_id", this.f);
                bundle.putInt("tab_type", this.c.tab_type.intValue());
                bundle.putString("tab_name", this.c.tab_name);
                bundle.putInt("is_general_tab", this.c.is_general_tab.intValue());
                bundle.putBoolean("can_auto_play_video", this.d.isFrsVideoAutoPlay);
                boolean z = true;
                if (this.d.needLog != 1) {
                    z = false;
                }
                bundle.putBoolean(DownloadStatisticConstants.UBC_SOURCE_NEED_LOG, z);
                bundle.putBoolean("is_brand_forum", this.d.isBrandForum);
                bundle.putSerializable("view_data", this.d);
                bundle.putBoolean("isAdded", false);
                frsCommonTabFragment.setArguments(bundle);
                gn5 gn5Var = new gn5();
                gn5Var.a = frsCommonTabFragment;
                gn5Var.e = this.f;
                gn5Var.i = gn5.k;
                return gn5Var;
            }
            return (gn5) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class f extends fn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ FrsViewData d;
        public final /* synthetic */ FrsFragment e;
        public final /* synthetic */ int f;

        @Override // com.baidu.tieba.fn5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.fn5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public f(FrsTabInfo frsTabInfo, FrsViewData frsViewData, FrsFragment frsFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabInfo, frsViewData, frsFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsTabInfo;
            this.d = frsViewData;
            this.e = frsFragment;
            this.f = i;
        }

        @Override // com.baidu.tieba.fn5
        public gn5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, ht7.e(this.c, this.d.showAdsense.intValue()));
                bundle.putString("name", this.e.v());
                bundle.putString("from", this.e.getFrom());
                bundle.putString("forum_id", this.e.w());
                bundle.putInt("tab_id", this.f);
                bundle.putInt("tab_type", this.c.tab_type.intValue());
                bundle.putString("tab_name", this.c.tab_name);
                bundle.putString("tab_url", this.c.tab_url);
                bundle.putInt("is_general_tab", this.c.is_general_tab.intValue());
                bundle.putBoolean("can_auto_play_video", this.d.isFrsVideoAutoPlay);
                boolean z = true;
                if (this.d.needLog != 1) {
                    z = false;
                }
                bundle.putBoolean(DownloadStatisticConstants.UBC_SOURCE_NEED_LOG, z);
                bundle.putBoolean("is_brand_forum", this.d.isBrandForum);
                bundle.putSerializable("view_data", this.d);
                bundle.putBoolean("isAdded", false);
                gn5 gn5Var = new gn5();
                if (vl6.e(this.c.tab_url)) {
                    NewFrsTabWebFragment newFrsTabWebFragment = new NewFrsTabWebFragment();
                    newFrsTabWebFragment.setArguments(bundle);
                    gn5Var.a = newFrsTabWebFragment;
                } else {
                    FrsTabWebFragment frsTabWebFragment = new FrsTabWebFragment();
                    frsTabWebFragment.setArguments(bundle);
                    gn5Var.a = frsTabWebFragment;
                }
                gn5Var.e = this.f;
                gn5Var.i = gn5.k;
                return gn5Var;
            }
            return (gn5) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class g extends fn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabInfo e;
        public final /* synthetic */ FrsViewData f;
        public final /* synthetic */ String g;

        @Override // com.baidu.tieba.fn5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.fn5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public g(FrsFragment frsFragment, int i, FrsTabInfo frsTabInfo, FrsViewData frsViewData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i), frsTabInfo, frsViewData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsFragment;
            this.d = i;
            this.e = frsTabInfo;
            this.f = frsViewData;
            this.g = str;
        }

        @Override // com.baidu.tieba.fn5
        public gn5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsItemTabFragment frsItemTabFragment = new FrsItemTabFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.c.v());
                bundle.putString("from", this.c.getFrom());
                bundle.putString("forum_id", this.c.w());
                bundle.putInt("tab_id", this.d);
                bundle.putInt("tab_type", this.e.tab_type.intValue());
                bundle.putString("tab_name", this.e.tab_name);
                bundle.putString("tab_code", this.e.tab_code);
                boolean z = true;
                if (this.f.needLog != 1) {
                    z = false;
                }
                bundle.putBoolean(DownloadStatisticConstants.UBC_SOURCE_NEED_LOG, z);
                bundle.putString("theme_color", this.g);
                bundle.putBoolean("isAdded", false);
                bundle.putInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, this.c.E3());
                frsItemTabFragment.setArguments(bundle);
                frsItemTabFragment.N1(this.c.getUniqueId());
                gn5 gn5Var = new gn5();
                gn5Var.a = frsItemTabFragment;
                gn5Var.e = this.d;
                gn5Var.i = gn5.k;
                return gn5Var;
            }
            return (gn5) invokeV.objValue;
        }
    }

    public static fn5 a(@NonNull FrsTabInfo frsTabInfo, @NonNull FrsFragment frsFragment, @NonNull FrsViewData frsViewData, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, frsTabInfo, frsFragment, frsViewData, str)) == null) {
            int intValue = frsTabInfo.tab_id.intValue();
            if (intValue == 1) {
                return new a(frsFragment, frsTabInfo, frsViewData, intValue);
            }
            if (intValue == 301) {
                return new b(frsTabInfo, frsViewData, frsFragment, intValue);
            }
            if (intValue == 503) {
                return new c(frsTabInfo, frsViewData, frsFragment, intValue);
            }
            if (intValue == 90) {
                return new d(frsFragment);
            }
            if (frsTabInfo.tab_type.intValue() != 91 && intValue != 89 && intValue != 504 && frsTabInfo.tab_type.intValue() != 15 && frsTabInfo.tab_type.intValue() != 16 && frsTabInfo.tab_type.intValue() != 3 && frsTabInfo.tab_type.intValue() != 100) {
                if (frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_type.intValue() == 102) {
                    return new f(frsTabInfo, frsViewData, frsFragment, intValue);
                }
                if (intValue == 506) {
                    return new g(frsFragment, intValue, frsTabInfo, frsViewData, str);
                }
                return null;
            }
            return new e(frsTabInfo, frsViewData, frsFragment, intValue);
        }
        return (fn5) invokeLLLL.objValue;
    }
}
