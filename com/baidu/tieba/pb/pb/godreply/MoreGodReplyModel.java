package com.baidu.tieba.pb.pb.godreply;

import b.a.e.a.f;
import b.a.e.m.e.n;
import b.a.r0.k2.r.w;
import b.a.r0.k2.u.f.d0;
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
/* loaded from: classes9.dex */
public class MoreGodReplyModel extends BdBaseModel<f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PbModel f53082e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53083f;

    /* renamed from: g  reason: collision with root package name */
    public int f53084g;

    /* renamed from: h  reason: collision with root package name */
    public int f53085h;

    /* renamed from: i  reason: collision with root package name */
    public d0.b f53086i;
    public final d0.b j;

    /* loaded from: classes9.dex */
    public class a implements d0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MoreGodReplyModel f53087a;

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
            this.f53087a = moreGodReplyModel;
        }

        @Override // b.a.r0.k2.u.f.d0.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                this.f53087a.f53083f = false;
                if (this.f53087a.f53086i != null) {
                    this.f53087a.f53086i.a(i2, str, str2);
                }
            }
        }

        @Override // b.a.r0.k2.u.f.d0.b
        public void onSuccess(List<PostData> list) {
            w T;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.f53087a.f53083f = false;
                if (this.f53087a.f53082e != null && this.f53087a.f53082e.P0() != null && (T = this.f53087a.f53082e.P0().T()) != null) {
                    List<PostData> list2 = T.f20357a;
                    int size = list2.size();
                    if (!ListUtils.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.C(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    this.f53087a.f53082e.V1(this.f53087a.f53082e.P0(), size);
                }
                if (this.f53087a.f53084g > 0) {
                    MoreGodReplyModel moreGodReplyModel = this.f53087a;
                    moreGodReplyModel.f53085h = moreGodReplyModel.f53084g;
                }
                if (this.f53087a.f53086i != null) {
                    this.f53087a.f53086i.onSuccess(list);
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
        this.f53083f = false;
        this.f53084g = -1;
        this.f53085h = -1;
        this.j = new a(this);
        if (pbModel == null) {
            return;
        }
        this.f53082e = pbModel;
        d0 L0 = pbModel.L0();
        if (L0 != null) {
            L0.f(this.j);
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
            PbModel pbModel = this.f53082e;
            ArrayList arrayList = null;
            if (pbModel == null) {
                return null;
            }
            b.a.r0.k2.r.f P0 = pbModel.P0();
            if (P0 != null && P0.T() != null && !ListUtils.isEmpty(P0.T().f20357a)) {
                w T = P0.T();
                arrayList = new ArrayList();
                List<PostData> list = T.f20357a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f53082e : (PbModel) invokeV.objValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        b.a.r0.k2.r.f P0;
        w T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbModel pbModel = this.f53082e;
            if (pbModel == null || (P0 = pbModel.P0()) == null || (T = P0.T()) == null) {
                return false;
            }
            if (this.f53085h < 0) {
                this.f53085h = T.a();
            }
            return T.f20358b.size() > this.f53085h && T.f20357a.size() < 100;
        }
        return invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f53083f : invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        w T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b.a.r0.k2.r.f P0 = this.f53082e.P0();
            if (P0 == null || (T = P0.T()) == null) {
                return false;
            }
            if (this.f53085h < 0) {
                this.f53085h = T.a();
            }
            List<Long> list = T.f20358b;
            int size = list.size();
            int i2 = this.f53085h;
            if (size <= i2 || T.f20357a.size() >= 100) {
                return false;
            }
            int min = Math.min(100, Math.min(i2 + 20, size));
            this.f53084g = min;
            this.f53083f = true;
            this.f53082e.L0().c(list.subList(i2, min));
            String str = "load from " + i2 + " to " + min;
            return true;
        }
        return invokeV.booleanValue;
    }

    public void I(d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f53086i = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.f53083f = false;
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
