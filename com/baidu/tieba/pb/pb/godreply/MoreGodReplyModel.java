package com.baidu.tieba.pb.pb.godreply;

import c.a.d.a.f;
import c.a.d.n.e.n;
import c.a.t0.s2.r.w;
import c.a.t0.s2.u.f.d0;
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
/* loaded from: classes12.dex */
public class MoreGodReplyModel extends BdBaseModel<f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PbModel f48219e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48220f;

    /* renamed from: g  reason: collision with root package name */
    public int f48221g;

    /* renamed from: h  reason: collision with root package name */
    public int f48222h;

    /* renamed from: i  reason: collision with root package name */
    public d0.b f48223i;

    /* renamed from: j  reason: collision with root package name */
    public final d0.b f48224j;

    /* loaded from: classes12.dex */
    public class a implements d0.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = moreGodReplyModel;
        }

        @Override // c.a.t0.s2.u.f.d0.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                this.a.f48220f = false;
                if (this.a.f48223i != null) {
                    this.a.f48223i.a(i2, str, str2);
                }
            }
        }

        @Override // c.a.t0.s2.u.f.d0.b
        public void onSuccess(List<PostData> list) {
            w T;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.a.f48220f = false;
                if (this.a.f48219e != null && this.a.f48219e.R0() != null && (T = this.a.f48219e.R0().T()) != null) {
                    List<PostData> list2 = T.a;
                    int size = list2.size();
                    if (!ListUtils.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.C(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    this.a.f48219e.Z1(this.a.f48219e.R0(), size);
                }
                if (this.a.f48221g > 0) {
                    MoreGodReplyModel moreGodReplyModel = this.a;
                    moreGodReplyModel.f48222h = moreGodReplyModel.f48221g;
                }
                if (this.a.f48223i != null) {
                    this.a.f48223i.onSuccess(list);
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
        this.f48220f = false;
        this.f48221g = -1;
        this.f48222h = -1;
        this.f48224j = new a(this);
        if (pbModel == null) {
            return;
        }
        this.f48219e = pbModel;
        d0 N0 = pbModel.N0();
        if (N0 != null) {
            N0.f(this.f48224j);
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
                    if (postData2.G() != null && postData.G() != null && postData2.G().equals(postData.G())) {
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
            PbModel pbModel = this.f48219e;
            ArrayList arrayList = null;
            if (pbModel == null) {
                return null;
            }
            c.a.t0.s2.r.f R0 = pbModel.R0();
            if (R0 != null && R0.T() != null && !ListUtils.isEmpty(R0.T().a)) {
                w T = R0.T();
                arrayList = new ArrayList();
                List<PostData> list = T.a;
                int size = list.size();
                int i2 = 0;
                while (i2 < size) {
                    PostData postData = list.get(i2);
                    if (postData != null) {
                        arrayList.add(postData);
                        postData.R = i2 < size + (-1);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f48219e : (PbModel) invokeV.objValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        c.a.t0.s2.r.f R0;
        w T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbModel pbModel = this.f48219e;
            if (pbModel == null || (R0 = pbModel.R0()) == null || (T = R0.T()) == null) {
                return false;
            }
            if (this.f48222h < 0) {
                this.f48222h = T.a();
            }
            return T.f23100b.size() > this.f48222h && T.a.size() < 100;
        }
        return invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f48220f : invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        w T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.t0.s2.r.f R0 = this.f48219e.R0();
            if (R0 == null || (T = R0.T()) == null) {
                return false;
            }
            if (this.f48222h < 0) {
                this.f48222h = T.a();
            }
            List<Long> list = T.f23100b;
            int size = list.size();
            int i2 = this.f48222h;
            if (size <= i2 || T.a.size() >= 100) {
                return false;
            }
            int min = Math.min(100, Math.min(i2 + 20, size));
            this.f48221g = min;
            this.f48220f = true;
            this.f48219e.N0().c(list.subList(i2, min));
            String str = "load from " + i2 + " to " + min;
            return true;
        }
        return invokeV.booleanValue;
    }

    public void I(d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f48223i = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.f48220f = false;
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
