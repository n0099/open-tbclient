package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
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
import d.a.c.a.f;
import d.a.c.k.e.n;
import d.a.s0.h2.h.e;
import d.a.s0.h2.h.t;
import d.a.s0.h2.k.e.e0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class MoreGodReplyModel extends BdBaseModel<f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PbModel f19122e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19123f;

    /* renamed from: g  reason: collision with root package name */
    public int f19124g;

    /* renamed from: h  reason: collision with root package name */
    public int f19125h;

    /* renamed from: i  reason: collision with root package name */
    public e0.b f19126i;
    public final e0.b j;

    /* loaded from: classes5.dex */
    public class a implements e0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MoreGodReplyModel f19127a;

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
            this.f19127a = moreGodReplyModel;
        }

        @Override // d.a.s0.h2.k.e.e0.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                this.f19127a.f19123f = false;
                if (this.f19127a.f19126i != null) {
                    this.f19127a.f19126i.a(i2, str, str2);
                }
            }
        }

        @Override // d.a.s0.h2.k.e.e0.b
        public void onSuccess(List<PostData> list) {
            t S;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.f19127a.f19123f = false;
                if (this.f19127a.f19122e != null && this.f19127a.f19122e.D0() != null && (S = this.f19127a.f19122e.D0().S()) != null) {
                    List<PostData> list2 = S.f60195a;
                    int size = list2.size();
                    if (!ListUtils.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.C(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    this.f19127a.f19122e.D1(this.f19127a.f19122e.D0(), size);
                }
                if (this.f19127a.f19124g > 0) {
                    MoreGodReplyModel moreGodReplyModel = this.f19127a;
                    moreGodReplyModel.f19125h = moreGodReplyModel.f19124g;
                }
                if (this.f19127a.f19126i != null) {
                    this.f19127a.f19126i.onSuccess(list);
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
        this.f19123f = false;
        this.f19124g = -1;
        this.f19125h = -1;
        this.j = new a(this);
        if (pbModel == null) {
            return;
        }
        this.f19122e = pbModel;
        e0 z0 = pbModel.z0();
        if (z0 != null) {
            z0.f(this.j);
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
            PbModel pbModel = this.f19122e;
            ArrayList arrayList = null;
            if (pbModel == null) {
                return null;
            }
            e D0 = pbModel.D0();
            if (D0 != null && D0.S() != null && !ListUtils.isEmpty(D0.S().f60195a)) {
                t S = D0.S();
                arrayList = new ArrayList();
                List<PostData> list = S.f60195a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19122e : (PbModel) invokeV.objValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        e D0;
        t S;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbModel pbModel = this.f19122e;
            if (pbModel == null || (D0 = pbModel.D0()) == null || (S = D0.S()) == null) {
                return false;
            }
            if (this.f19125h < 0) {
                this.f19125h = S.a();
            }
            return S.f60196b.size() > this.f19125h && S.f60195a.size() < 100;
        }
        return invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19123f : invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        t S;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e D0 = this.f19122e.D0();
            if (D0 == null || (S = D0.S()) == null) {
                return false;
            }
            if (this.f19125h < 0) {
                this.f19125h = S.a();
            }
            List<Long> list = S.f60196b;
            int size = list.size();
            int i2 = this.f19125h;
            if (size <= i2 || S.f60195a.size() >= 100) {
                return false;
            }
            int min = Math.min(100, Math.min(i2 + 20, size));
            this.f19124g = min;
            this.f19123f = true;
            this.f19122e.z0().c(list.subList(i2, min));
            Log.d("more_god_reply", "load from " + i2 + " to " + min);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void I(e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f19126i = bVar;
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
            this.f19123f = false;
            return false;
        }
        return invokeV.booleanValue;
    }
}
