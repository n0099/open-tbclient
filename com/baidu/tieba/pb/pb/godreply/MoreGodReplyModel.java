package com.baidu.tieba.pb.pb.godreply;

import c.a.e.a.f;
import c.a.e.l.e.n;
import c.a.r0.k2.h.e;
import c.a.r0.k2.h.u;
import c.a.r0.k2.k.e.c0;
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
    public PbModel f54969e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54970f;

    /* renamed from: g  reason: collision with root package name */
    public int f54971g;

    /* renamed from: h  reason: collision with root package name */
    public int f54972h;

    /* renamed from: i  reason: collision with root package name */
    public c0.b f54973i;

    /* renamed from: j  reason: collision with root package name */
    public final c0.b f54974j;

    /* loaded from: classes7.dex */
    public class a implements c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MoreGodReplyModel f54975a;

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
            this.f54975a = moreGodReplyModel;
        }

        @Override // c.a.r0.k2.k.e.c0.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                this.f54975a.f54970f = false;
                if (this.f54975a.f54973i != null) {
                    this.f54975a.f54973i.a(i2, str, str2);
                }
            }
        }

        @Override // c.a.r0.k2.k.e.c0.b
        public void onSuccess(List<PostData> list) {
            u T;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.f54975a.f54970f = false;
                if (this.f54975a.f54969e != null && this.f54975a.f54969e.P0() != null && (T = this.f54975a.f54969e.P0().T()) != null) {
                    List<PostData> list2 = T.f19871a;
                    int size = list2.size();
                    if (!ListUtils.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.C(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    this.f54975a.f54969e.S1(this.f54975a.f54969e.P0(), size);
                }
                if (this.f54975a.f54971g > 0) {
                    MoreGodReplyModel moreGodReplyModel = this.f54975a;
                    moreGodReplyModel.f54972h = moreGodReplyModel.f54971g;
                }
                if (this.f54975a.f54973i != null) {
                    this.f54975a.f54973i.onSuccess(list);
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
        this.f54970f = false;
        this.f54971g = -1;
        this.f54972h = -1;
        this.f54974j = new a(this);
        if (pbModel == null) {
            return;
        }
        this.f54969e = pbModel;
        c0 L0 = pbModel.L0();
        if (L0 != null) {
            L0.f(this.f54974j);
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
            PbModel pbModel = this.f54969e;
            ArrayList arrayList = null;
            if (pbModel == null) {
                return null;
            }
            e P0 = pbModel.P0();
            if (P0 != null && P0.T() != null && !ListUtils.isEmpty(P0.T().f19871a)) {
                u T = P0.T();
                arrayList = new ArrayList();
                List<PostData> list = T.f19871a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54969e : (PbModel) invokeV.objValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        e P0;
        u T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbModel pbModel = this.f54969e;
            if (pbModel == null || (P0 = pbModel.P0()) == null || (T = P0.T()) == null) {
                return false;
            }
            if (this.f54972h < 0) {
                this.f54972h = T.a();
            }
            return T.f19872b.size() > this.f54972h && T.f19871a.size() < 100;
        }
        return invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f54970f : invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        u T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e P0 = this.f54969e.P0();
            if (P0 == null || (T = P0.T()) == null) {
                return false;
            }
            if (this.f54972h < 0) {
                this.f54972h = T.a();
            }
            List<Long> list = T.f19872b;
            int size = list.size();
            int i2 = this.f54972h;
            if (size <= i2 || T.f19871a.size() >= 100) {
                return false;
            }
            int min = Math.min(100, Math.min(i2 + 20, size));
            this.f54971g = min;
            this.f54970f = true;
            this.f54969e.L0().c(list.subList(i2, min));
            String str = "load from " + i2 + " to " + min;
            return true;
        }
        return invokeV.booleanValue;
    }

    public void I(c0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f54973i = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.f54970f = false;
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
