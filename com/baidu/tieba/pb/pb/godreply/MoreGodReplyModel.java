package com.baidu.tieba.pb.pb.godreply;

import c.a.e.a.f;
import c.a.e.l.e.n;
import c.a.r0.j2.h.e;
import c.a.r0.j2.h.u;
import c.a.r0.j2.k.e.c0;
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
    public PbModel f55038e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55039f;

    /* renamed from: g  reason: collision with root package name */
    public int f55040g;

    /* renamed from: h  reason: collision with root package name */
    public int f55041h;

    /* renamed from: i  reason: collision with root package name */
    public c0.b f55042i;

    /* renamed from: j  reason: collision with root package name */
    public final c0.b f55043j;

    /* loaded from: classes7.dex */
    public class a implements c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MoreGodReplyModel f55044a;

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
            this.f55044a = moreGodReplyModel;
        }

        @Override // c.a.r0.j2.k.e.c0.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                this.f55044a.f55039f = false;
                if (this.f55044a.f55042i != null) {
                    this.f55044a.f55042i.a(i2, str, str2);
                }
            }
        }

        @Override // c.a.r0.j2.k.e.c0.b
        public void onSuccess(List<PostData> list) {
            u T;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.f55044a.f55039f = false;
                if (this.f55044a.f55038e != null && this.f55044a.f55038e.P0() != null && (T = this.f55044a.f55038e.P0().T()) != null) {
                    List<PostData> list2 = T.f19694a;
                    int size = list2.size();
                    if (!ListUtils.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.C(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    this.f55044a.f55038e.R1(this.f55044a.f55038e.P0(), size);
                }
                if (this.f55044a.f55040g > 0) {
                    MoreGodReplyModel moreGodReplyModel = this.f55044a;
                    moreGodReplyModel.f55041h = moreGodReplyModel.f55040g;
                }
                if (this.f55044a.f55042i != null) {
                    this.f55044a.f55042i.onSuccess(list);
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
        this.f55039f = false;
        this.f55040g = -1;
        this.f55041h = -1;
        this.f55043j = new a(this);
        if (pbModel == null) {
            return;
        }
        this.f55038e = pbModel;
        c0 L0 = pbModel.L0();
        if (L0 != null) {
            L0.f(this.f55043j);
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
            PbModel pbModel = this.f55038e;
            ArrayList arrayList = null;
            if (pbModel == null) {
                return null;
            }
            e P0 = pbModel.P0();
            if (P0 != null && P0.T() != null && !ListUtils.isEmpty(P0.T().f19694a)) {
                u T = P0.T();
                arrayList = new ArrayList();
                List<PostData> list = T.f19694a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55038e : (PbModel) invokeV.objValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        e P0;
        u T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbModel pbModel = this.f55038e;
            if (pbModel == null || (P0 = pbModel.P0()) == null || (T = P0.T()) == null) {
                return false;
            }
            if (this.f55041h < 0) {
                this.f55041h = T.a();
            }
            return T.f19695b.size() > this.f55041h && T.f19694a.size() < 100;
        }
        return invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55039f : invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        u T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e P0 = this.f55038e.P0();
            if (P0 == null || (T = P0.T()) == null) {
                return false;
            }
            if (this.f55041h < 0) {
                this.f55041h = T.a();
            }
            List<Long> list = T.f19695b;
            int size = list.size();
            int i2 = this.f55041h;
            if (size <= i2 || T.f19694a.size() >= 100) {
                return false;
            }
            int min = Math.min(100, Math.min(i2 + 20, size));
            this.f55040g = min;
            this.f55039f = true;
            this.f55038e.L0().c(list.subList(i2, min));
            String str = "load from " + i2 + " to " + min;
            return true;
        }
        return invokeV.booleanValue;
    }

    public void I(c0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f55042i = bVar;
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
            this.f55039f = false;
            return false;
        }
        return invokeV.booleanValue;
    }
}
