package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import c.a.d.a.f;
import c.a.d.o.e.n;
import c.a.p0.w2.i.x;
import c.a.p0.w2.m.f.k0;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class MoreGodReplyModel extends BdBaseModel<f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbModel a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f34845b;

    /* renamed from: c  reason: collision with root package name */
    public int f34846c;

    /* renamed from: d  reason: collision with root package name */
    public int f34847d;

    /* renamed from: e  reason: collision with root package name */
    public k0.b f34848e;

    /* renamed from: f  reason: collision with root package name */
    public final k0.b f34849f;

    /* loaded from: classes5.dex */
    public class a implements k0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MoreGodReplyModel a;

        public a(MoreGodReplyModel moreGodReplyModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreGodReplyModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = moreGodReplyModel;
        }

        @Override // c.a.p0.w2.m.f.k0.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                this.a.f34845b = false;
                if (this.a.f34848e != null) {
                    this.a.f34848e.a(i, str, str2);
                }
            }
        }

        @Override // c.a.p0.w2.m.f.k0.b
        public void onSuccess(List<PostData> list) {
            x T;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.a.f34845b = false;
                if (this.a.a != null && this.a.a.S0() != null && (T = this.a.a.S0().T()) != null) {
                    List<PostData> list2 = T.a;
                    int size = list2.size();
                    if (!ListUtils.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.E(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    this.a.a.e2(this.a.a.S0(), size);
                }
                if (this.a.f34846c > 0) {
                    MoreGodReplyModel moreGodReplyModel = this.a;
                    moreGodReplyModel.f34847d = moreGodReplyModel.f34846c;
                }
                if (this.a.f34848e != null) {
                    this.a.f34848e.onSuccess(list);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreGodReplyModel(f fVar, PbModel pbModel) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, pbModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34845b = false;
        this.f34846c = -1;
        this.f34847d = -1;
        this.f34849f = new a(this);
        if (pbModel == null) {
            return;
        }
        this.a = pbModel;
        k0 O0 = pbModel.O0();
        if (O0 != null) {
            O0.f(this.f34849f);
        }
    }

    public static boolean E(List<PostData> list, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, postData)) == null) {
            if (list == null || postData == null) {
                return false;
            }
            for (PostData postData2 : list) {
                if (postData2 != null) {
                    if (postData2 == postData) {
                        return true;
                    }
                    if (postData2.G() != null && postData.G() != null && postData2.G().equals(postData.G())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public List<n> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.a;
            ArrayList arrayList = null;
            if (pbModel == null) {
                return null;
            }
            c.a.p0.w2.i.f S0 = pbModel.S0();
            if (S0 != null && S0.T() != null && !ListUtils.isEmpty(S0.T().a)) {
                x T = S0.T();
                arrayList = new ArrayList();
                List<PostData> list = T.a;
                int size = list.size();
                int i = 0;
                while (i < size) {
                    PostData postData = list.get(i);
                    if (postData != null) {
                        arrayList.add(postData);
                        postData.N = i < size + (-1);
                    }
                    i++;
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public PbModel G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (PbModel) invokeV.objValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        c.a.p0.w2.i.f S0;
        x T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || (S0 = pbModel.S0()) == null || (T = S0.T()) == null) {
                return false;
            }
            if (this.f34847d < 0) {
                this.f34847d = T.a();
            }
            return T.f19870b.size() > this.f34847d && T.a.size() < 100;
        }
        return invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34845b : invokeV.booleanValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        x T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.p0.w2.i.f S0 = this.a.S0();
            if (S0 == null || (T = S0.T()) == null) {
                return false;
            }
            if (this.f34847d < 0) {
                this.f34847d = T.a();
            }
            List<Long> list = T.f19870b;
            int size = list.size();
            int i = this.f34847d;
            if (size <= i || T.a.size() >= 100) {
                return false;
            }
            int min = Math.min(100, Math.min(i + 20, size));
            this.f34846c = min;
            this.f34845b = true;
            this.a.O0().c(list.subList(i, min));
            Log.d("more_god_reply", "load from " + i + " to " + min);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void K(k0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f34848e = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.f34845b = false;
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
