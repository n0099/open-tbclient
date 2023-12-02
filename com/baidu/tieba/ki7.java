package com.baidu.tieba;

import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.forum.view.TopCardView;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ki7 extends wh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public TopCardView c;
    public List<i87> d;
    public int e;
    public boolean f;
    public String g;
    public List<? extends PbHistoryData> h;
    public final Object i;
    public final a j;

    /* loaded from: classes7.dex */
    public static final class a implements CacheModel.CacheModelCallback<PbHistoryData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ki7 a;

        @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
        public void onCacheDataWrite(WriteCacheRespMsg<List<PbHistoryData>> writeCacheRespMsg, WriteCacheMessage<PbHistoryData> writeCacheMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeCacheRespMsg, writeCacheMessage) == null) {
            }
        }

        public a(ki7 ki7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ki7Var;
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
        public void onCacheDataGet(ReadCacheRespMsg<List<PbHistoryData>> readCacheRespMsg, ReadCacheMessage<PbHistoryData> readCacheMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, readCacheRespMsg, readCacheMessage) == null) && readCacheRespMsg != null && readCacheRespMsg.getData() != null) {
                ki7 ki7Var = this.a;
                List<PbHistoryData> data = readCacheRespMsg.getData();
                Intrinsics.checkNotNull(data);
                ki7Var.h = data;
                ki7 ki7Var2 = this.a;
                ki7Var2.B(ki7Var2.d);
                TopCardView topCardView = this.a.c;
                if (topCardView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopCardView");
                    topCardView = null;
                }
                topCardView.n(this.a.d, this.a.e, this.a.f, this.a.g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends er6<rh5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ki7 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ki7 ki7Var, Class<rh5> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki7Var, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ki7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.er6
        public void onEvent(rh5 event) {
            TopCardView topCardView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (StringUtils.isNotNull(event.a())) {
                    Iterator it = this.b.d.iterator();
                    while (true) {
                        topCardView = null;
                        String str = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        i87 i87Var = (i87) it.next();
                        String a = event.a();
                        c87 h = i87Var.h();
                        if (h != null) {
                            str = h.c;
                        }
                        if (Intrinsics.areEqual(a, str)) {
                            i87Var.l(true);
                        }
                    }
                    TopCardView topCardView2 = this.b.c;
                    if (topCardView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTopCardView");
                    } else {
                        topCardView = topCardView2;
                    }
                    topCardView.m(this.b.d, event.a());
                }
            }
        }
    }

    public ki7(FragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = activity;
        this.d = new ArrayList();
        this.g = "";
        this.h = new ArrayList();
        this.i = new Object();
        this.j = new a(this);
    }

    public final void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.wh7
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            TopCardView topCardView = this.c;
            if (topCardView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopCardView");
                topCardView = null;
            }
            topCardView.f();
        }
    }

    public final boolean z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            for (PbHistoryData pbHistoryData : this.h) {
                if (pbHistoryData.getThreadId().equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void B(List<i87> list) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            for (i87 i87Var : list) {
                c87 h = i87Var.h();
                if (h != null) {
                    str = h.c;
                } else {
                    str = null;
                }
                i87Var.l(z(str.toString()));
            }
        }
    }

    @Override // com.baidu.tieba.wh7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.l();
            br6.b().a(this.i);
        }
    }

    public final void x(TopCardView topCardView, l57 uiState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, topCardView, uiState) == null) {
            Intrinsics.checkNotNullParameter(topCardView, "topCardView");
            Intrinsics.checkNotNullParameter(uiState, "uiState");
            this.c = topCardView;
            this.d = uiState.n();
            this.e = uiState.l();
            this.f = uiState.o();
            this.g = uiState.m();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(jo7.a(this.b));
            pbHistoryCacheModel.setCallback(this.j);
            pbHistoryCacheModel.loadCache();
            br6.b().b(this.i, new b(this, rh5.class));
        }
    }
}
