package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tbclient.LayoutFactory;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.PageData;
/* loaded from: classes7.dex */
public final class kfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;

    /* loaded from: classes7.dex */
    public static final class a extends bu5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kfa a;

        public a(kfa kfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kfaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bu5
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            PageData pageData;
            List<LayoutFactory> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = "";
                }
                g67.a.b("tb.feed_home_reco_user_state", new f67("tb.feed_home_reco_user_state", currentAccount));
                boolean z = true;
                DataRes build = new DataRes.Builder().build(true);
                Intrinsics.checkNotNullExpressionValue(build, "Builder().build(true)");
                if (!this.a.b()) {
                    return build;
                }
                ca<byte[]> k = yz4.k("tb.reco_feed_space", TbadkCoreApplication.getCurrentAccount());
                if (k != null && (bArr = k.get("0")) != null && bArr.length != 0) {
                    try {
                        DataRes res = (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                        if (res == null || (pageData = res.page_data) == null || (list = pageData.feed_list) == null || !(!list.isEmpty())) {
                            z = false;
                        }
                        if (z) {
                            Intrinsics.checkNotNullExpressionValue(res, "res");
                            return res;
                        }
                        return build;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return build;
                    }
                }
                return build;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends bu5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = "";
                }
                yz4.h("tb.feed_home_reco_user_state", currentAccount);
                g67.a.b("tb.feed_home_reco_user_state", new f67("tb.feed_home_reco_user_state", currentAccount));
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bu5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends bu5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;

        public c(DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = builder;
        }

        @Override // com.baidu.tieba.bu5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    yz4.k("tb.reco_feed_space", TbadkCoreApplication.getCurrentAccount()).g("0", new DataRes.Builder(this.a.build(true)).build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    public kfa() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = SharedPrefHelper.getInstance().getLong("recommend_frs_cache_time", DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) * 1000;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            long j = sharedPrefHelper.getLong("key_recommend_cache_update_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
            if (j > 0 && System.currentTimeMillis() - j > this.a) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void c(final jfa recoFeedCacheListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recoFeedCacheListener) == null) {
            Intrinsics.checkNotNullParameter(recoFeedCacheListener, "recoFeedCacheListener");
            fu5.b(new a(this), new gt5() { // from class: com.baidu.tieba.hfa
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.gt5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        kfa.d(jfa.this, (DataRes) obj);
                    }
                }
            });
        }
    }

    public final void g(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, builder) == null) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            fu5.b(new c(builder), null);
        }
    }

    public static final void d(jfa recoFeedCacheListener, DataRes result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, recoFeedCacheListener, result) == null) {
            Intrinsics.checkNotNullParameter(recoFeedCacheListener, "$recoFeedCacheListener");
            Intrinsics.checkNotNullExpressionValue(result, "result");
            recoFeedCacheListener.a(result);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            fu5.b(new b(), null);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.putLong("key_recommend_cache_update_time" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
        }
    }
}
