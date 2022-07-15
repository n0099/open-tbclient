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
import com.repackage.cs7;
import com.repackage.d9;
import com.repackage.jr7;
import com.repackage.nn;
import com.repackage.xu7;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MoreGodReplyModel extends BdBaseModel<d9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbModel a;
    public boolean b;
    public int c;
    public int d;
    public xu7.b e;
    public final xu7.b f;

    /* loaded from: classes3.dex */
    public class a implements xu7.b {
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

        @Override // com.repackage.xu7.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                this.a.b = false;
                if (this.a.e != null) {
                    this.a.e.a(i, str, str2);
                }
            }
        }

        @Override // com.repackage.xu7.b
        public void onSuccess(List<PostData> list) {
            cs7 T;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.a.b = false;
                if (this.a.a != null && this.a.a.R1() != null && (T = this.a.a.R1().T()) != null) {
                    List<PostData> list2 = T.a;
                    int size = list2.size();
                    if (!ListUtils.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.G(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    this.a.a.e3(this.a.a.R1(), size);
                }
                if (this.a.c > 0) {
                    MoreGodReplyModel moreGodReplyModel = this.a;
                    moreGodReplyModel.d = moreGodReplyModel.c;
                }
                if (this.a.e != null) {
                    this.a.e.onSuccess(list);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreGodReplyModel(d9 d9Var, PbModel pbModel) {
        super(d9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var, pbModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = -1;
        this.d = -1;
        this.f = new a(this);
        if (pbModel == null) {
            return;
        }
        this.a = pbModel;
        xu7 N1 = pbModel.N1();
        if (N1 != null) {
            N1.f(this.f);
        }
    }

    public static boolean G(List<PostData> list, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, postData)) == null) {
            if (list == null || postData == null) {
                return false;
            }
            for (PostData postData2 : list) {
                if (postData2 != null) {
                    if (postData2 == postData) {
                        return true;
                    }
                    if (postData2.J() != null && postData.J() != null && postData2.J().equals(postData.J())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public List<nn> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.a;
            ArrayList arrayList = null;
            if (pbModel == null) {
                return null;
            }
            jr7 R1 = pbModel.R1();
            if (R1 != null && R1.T() != null && !ListUtils.isEmpty(R1.T().a)) {
                cs7 T = R1.T();
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

    public PbModel I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (PbModel) invokeV.objValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        jr7 R1;
        cs7 T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || (R1 = pbModel.R1()) == null || (T = R1.T()) == null) {
                return false;
            }
            if (this.d < 0) {
                this.d = T.a();
            }
            return T.b.size() > this.d && T.a.size() < 100;
        }
        return invokeV.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        cs7 T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            jr7 R1 = this.a.R1();
            if (R1 == null || (T = R1.T()) == null) {
                return false;
            }
            if (this.d < 0) {
                this.d = T.a();
            }
            List<Long> list = T.b;
            int size = list.size();
            int i = this.d;
            if (size <= i || T.a.size() >= 100) {
                return false;
            }
            int min = Math.min(100, Math.min(i + 20, size));
            this.c = min;
            this.b = true;
            this.a.N1().c(list.subList(i, min));
            Log.d("more_god_reply", "load from " + i + " to " + min);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void M(xu7.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.e = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.b = false;
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
