package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.inserting.NadImageInsertingView;
import com.baidu.nadcore.business.inserting.NadInsertingBaseView;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.requester.NadRequester;
import com.baidu.nadcore.requester.RequestParameters;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class yh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface c {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(@NonNull NadInsertingBaseView nadInsertingBaseView);

        void onFail();
    }

    /* loaded from: classes8.dex */
    public class a implements NadRequester.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRequester.b a;

        public a(NadRequester.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.nadcore.requester.NadRequester.b
        public void a(@NonNull NadRequester.Error error) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, error) == null) {
                this.a.a(error);
            }
        }

        @Override // com.baidu.nadcore.requester.NadRequester.b
        public void b(@NonNull List<AdBaseModel> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list.size() > 0 && list.get(0) != null) {
                    AdBaseModel adBaseModel = (AdBaseModel) h31.d(list, 0);
                    if (TextUtils.equals(adBaseModel.f.a.value, AdBaseModel.STYLE.BIG_IMAGE.value)) {
                        gr0 gr0Var = (gr0) h31.d(adBaseModel.f.k, 0);
                        if (gr0Var != null && !TextUtils.isEmpty(gr0Var.a)) {
                            zb1.a().d(gr0Var.a);
                        } else {
                            this.a.a(new NadRequester.Error("大图模版数据校验失败，未下发图片"));
                            return;
                        }
                    }
                    this.a.b(list);
                    return;
                }
                this.a.a(new NadRequester.Error("返回数据为空"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ NadInsertingBaseView b;

        public b(d dVar, NadInsertingBaseView nadInsertingBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, nadInsertingBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.b = nadInsertingBaseView;
        }

        @Override // com.baidu.tieba.yh0.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onFail();
            }
        }

        @Override // com.baidu.tieba.yh0.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.a(this.b);
            }
        }
    }

    public static void a(String str, NadRequester.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, str, bVar) == null) {
            RequestParameters.b bVar2 = new RequestParameters.b();
            bVar2.q(str);
            bVar2.p(1);
            NadRequester.a(bVar2.o(), new a(bVar));
        }
    }

    public static void b(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull List<AdBaseModel> list, @NonNull xh0 xh0Var, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, context, viewGroup, list, xh0Var, dVar) == null) {
            if (h31.l(list) < 1) {
                dVar.onFail();
                return;
            }
            AdBaseModel adBaseModel = (AdBaseModel) h31.d(list, 0);
            if (TextUtils.equals(adBaseModel.f.a.value, AdBaseModel.STYLE.BIG_IMAGE.value)) {
                NadImageInsertingView nadImageInsertingView = new NadImageInsertingView(context, viewGroup, xh0Var);
                nadImageInsertingView.setData(adBaseModel, new b(dVar, nadImageInsertingView));
            }
        }
    }
}
