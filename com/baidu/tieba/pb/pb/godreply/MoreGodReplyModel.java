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
import com.repackage.b9;
import com.repackage.dq7;
import com.repackage.jn;
import com.repackage.kp7;
import com.repackage.ys7;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MoreGodReplyModel extends BdBaseModel<b9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbModel a;
    public boolean b;
    public int c;
    public int d;
    public ys7.b e;
    public final ys7.b f;

    /* loaded from: classes3.dex */
    public class a implements ys7.b {
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

        @Override // com.repackage.ys7.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                this.a.b = false;
                if (this.a.e != null) {
                    this.a.e.a(i, str, str2);
                }
            }
        }

        @Override // com.repackage.ys7.b
        public void onSuccess(List<PostData> list) {
            dq7 T;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.a.b = false;
                if (this.a.a != null && this.a.a.P1() != null && (T = this.a.a.P1().T()) != null) {
                    List<PostData> list2 = T.a;
                    int size = list2.size();
                    if (!ListUtils.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.E(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    this.a.a.c3(this.a.a.P1(), size);
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
    public MoreGodReplyModel(b9 b9Var, PbModel pbModel) {
        super(b9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var, pbModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
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
        ys7 L1 = pbModel.L1();
        if (L1 != null) {
            L1.f(this.f);
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
                    if (postData2.I() != null && postData.I() != null && postData2.I().equals(postData.I())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public List<jn> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.a;
            ArrayList arrayList = null;
            if (pbModel == null) {
                return null;
            }
            kp7 P1 = pbModel.P1();
            if (P1 != null && P1.T() != null && !ListUtils.isEmpty(P1.T().a)) {
                dq7 T = P1.T();
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
        kp7 P1;
        dq7 T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || (P1 = pbModel.P1()) == null || (T = P1.T()) == null) {
                return false;
            }
            if (this.d < 0) {
                this.d = T.a();
            }
            return T.b.size() > this.d && T.a.size() < 100;
        }
        return invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        dq7 T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            kp7 P1 = this.a.P1();
            if (P1 == null || (T = P1.T()) == null) {
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
            this.a.L1().c(list.subList(i, min));
            Log.d("more_god_reply", "load from " + i + " to " + min);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void K(ys7.b bVar) {
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
