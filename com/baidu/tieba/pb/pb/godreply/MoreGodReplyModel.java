package com.baidu.tieba.pb.pb.godreply;

import c.a.e.a.f;
import c.a.e.k.e.n;
import c.a.p0.i2.h.e;
import c.a.p0.i2.h.u;
import c.a.p0.i2.k.e.d0;
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
/* loaded from: classes7.dex */
public class MoreGodReplyModel extends BdBaseModel<f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PbModel f54610e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54611f;

    /* renamed from: g  reason: collision with root package name */
    public int f54612g;

    /* renamed from: h  reason: collision with root package name */
    public int f54613h;

    /* renamed from: i  reason: collision with root package name */
    public d0.b f54614i;

    /* renamed from: j  reason: collision with root package name */
    public final d0.b f54615j;

    /* loaded from: classes7.dex */
    public class a implements d0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MoreGodReplyModel f54616a;

        public a(MoreGodReplyModel moreGodReplyModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreGodReplyModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54616a = moreGodReplyModel;
        }

        @Override // c.a.p0.i2.k.e.d0.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                this.f54616a.f54611f = false;
                if (this.f54616a.f54614i != null) {
                    this.f54616a.f54614i.a(i2, str, str2);
                }
            }
        }

        @Override // c.a.p0.i2.k.e.d0.b
        public void onSuccess(List<PostData> list) {
            u T;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.f54616a.f54611f = false;
                if (this.f54616a.f54610e != null && this.f54616a.f54610e.O0() != null && (T = this.f54616a.f54610e.O0().T()) != null) {
                    List<PostData> list2 = T.f18797a;
                    int size = list2.size();
                    if (!ListUtils.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.C(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    this.f54616a.f54610e.P1(this.f54616a.f54610e.O0(), size);
                }
                if (this.f54616a.f54612g > 0) {
                    MoreGodReplyModel moreGodReplyModel = this.f54616a;
                    moreGodReplyModel.f54613h = moreGodReplyModel.f54612g;
                }
                if (this.f54616a.f54614i != null) {
                    this.f54616a.f54614i.onSuccess(list);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54611f = false;
        this.f54612g = -1;
        this.f54613h = -1;
        this.f54615j = new a(this);
        if (pbModel == null) {
            return;
        }
        this.f54610e = pbModel;
        d0 K0 = pbModel.K0();
        if (K0 != null) {
            K0.f(this.f54615j);
        }
    }

    public static boolean C(List<PostData> list, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, list, postData)) == null) {
            if (list == null || postData == null) {
                return false;
            }
            for (PostData postData2 : list) {
                if (postData2 != null) {
                    if (postData2 == postData) {
                        return true;
                    }
                    if (postData2.E() != null && postData.E() != null && postData2.E().equals(postData.E())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public List<n> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.f54610e;
            ArrayList arrayList = null;
            if (pbModel == null) {
                return null;
            }
            e O0 = pbModel.O0();
            if (O0 != null && O0.T() != null && !ListUtils.isEmpty(O0.T().f18797a)) {
                u T = O0.T();
                arrayList = new ArrayList();
                List<PostData> list = T.f18797a;
                int size = list.size();
                int i2 = 0;
                while (i2 < size) {
                    PostData postData = list.get(i2);
                    if (postData != null) {
                        arrayList.add(postData);
                        postData.P = i2 < size + (-1);
                    }
                    i2++;
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public PbModel E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54610e : (PbModel) invokeV.objValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        e O0;
        u T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbModel pbModel = this.f54610e;
            if (pbModel == null || (O0 = pbModel.O0()) == null || (T = O0.T()) == null) {
                return false;
            }
            if (this.f54613h < 0) {
                this.f54613h = T.a();
            }
            return T.f18798b.size() > this.f54613h && T.f18797a.size() < 100;
        }
        return invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f54611f : invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        u T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e O0 = this.f54610e.O0();
            if (O0 == null || (T = O0.T()) == null) {
                return false;
            }
            if (this.f54613h < 0) {
                this.f54613h = T.a();
            }
            List<Long> list = T.f18798b;
            int size = list.size();
            int i2 = this.f54613h;
            if (size <= i2 || T.f18797a.size() >= 100) {
                return false;
            }
            int min = Math.min(100, Math.min(i2 + 20, size));
            this.f54612g = min;
            this.f54611f = true;
            this.f54610e.K0().c(list.subList(i2, min));
            String str = "load from " + i2 + " to " + min;
            return true;
        }
        return invokeV.booleanValue;
    }

    public void I(d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f54614i = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f54611f = false;
            return false;
        }
        return invokeV.booleanValue;
    }
}
