package com.baidu.tieba.square.model;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.square.message.ForumSquareHttpResponsedMessage;
import com.baidu.tieba.square.message.ForumSquareRequestMessage;
import com.baidu.tieba.square.message.ForumSquareSocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
import d.a.d.k.e.n;
import d.a.q0.e3.d;
import d.a.q0.h3.q0.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class ForumSquareModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f21131e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21132f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, d.a.q0.e3.f.c> f21133g;

    /* renamed from: h  reason: collision with root package name */
    public final List<String> f21134h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f21135i;
    public CustomMessageListener j;
    public d.a.d.c.g.a k;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumSquareModel f21136a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumSquareModel forumSquareModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumSquareModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21136a = forumSquareModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                k kVar = (k) customResponsedMessage.getData();
                if (kVar.f58819b) {
                    this.f21136a.P(kVar.f58818a, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumSquareModel f21137a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ForumSquareModel forumSquareModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumSquareModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21137a = forumSquareModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                k kVar = (k) customResponsedMessage.getData();
                if (kVar.f58819b) {
                    this.f21137a.P(kVar.f58818a, false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumSquareModel f21138a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ForumSquareModel forumSquareModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumSquareModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21138a = forumSquareModel;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str;
            d.a.q0.e3.f.d data;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f21138a.f21132f = false;
                if (responsedMessage == null) {
                    return;
                }
                this.f21138a.mErrorCode = responsedMessage.getError();
                this.f21138a.mErrorString = responsedMessage.getErrorString();
                if (!StringUtils.isNull(this.f21138a.mErrorString)) {
                    str = this.f21138a.mErrorString;
                } else {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
                }
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.f21138a.mErrorCode);
                errorData.setError_msg(str);
                if (responsedMessage instanceof ForumSquareHttpResponsedMessage) {
                    data = ((ForumSquareHttpResponsedMessage) responsedMessage).getData();
                } else {
                    data = responsedMessage instanceof ForumSquareSocketResponsedMessage ? ((ForumSquareSocketResponsedMessage) responsedMessage).getData() : null;
                }
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                String str2 = extra instanceof ForumSquareRequestMessage ? ((ForumSquareRequestMessage) extra).className : null;
                this.f21138a.M(data);
                if (ListUtils.isEmpty(this.f21138a.f21134h)) {
                    if (this.f21138a.f21131e != null) {
                        this.f21138a.f21131e.b(errorData);
                    }
                } else if (this.f21138a.mErrorCode != 0 || data == null) {
                    if (this.f21138a.f21131e != null) {
                        this.f21138a.f21131e.c(str2, errorData);
                    }
                } else {
                    this.f21138a.N(data);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumSquareModel(Context context, d dVar) {
        super(UtilHelper.getTbPageContext(context));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dVar};
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
        this.f21132f = false;
        this.f21133g = new HashMap<>();
        this.f21134h = new ArrayList();
        this.f21135i = new a(this, 2001437);
        this.j = new b(this, 2001438);
        c cVar = new c(this, CmdConfigHttp.CMD_FORUM_SQUARE, 309653);
        this.k = cVar;
        this.f21131e = dVar;
        cVar.getHttpMessageListener().setSelfListener(true);
        this.k.getSocketMessageListener().setSelfListener(true);
        registerListener(this.k);
        registerListener(this.f21135i);
        registerListener(this.j);
    }

    public d.a.q0.e3.f.c I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                return null;
            }
            return this.f21133g.get(str);
        }
        return (d.a.q0.e3.f.c) invokeL.objValue;
    }

    public boolean J(String str) {
        InterceptResult invokeL;
        d.a.q0.e3.f.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (cVar = this.f21133g.get(str)) == null) {
                return false;
            }
            return cVar.f56492d;
        }
        return invokeL.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21132f : invokeV.booleanValue;
    }

    public void L(String str) {
        d.a.q0.e3.f.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            ForumSquareRequestMessage forumSquareRequestMessage = new ForumSquareRequestMessage();
            forumSquareRequestMessage.className = str;
            if (TextUtils.isEmpty(str)) {
                cVar = new d.a.q0.e3.f.c();
            } else {
                d.a.q0.e3.f.c cVar2 = this.f21133g.get(str);
                if (cVar2 == null) {
                    cVar2 = new d.a.q0.e3.f.c();
                    this.f21133g.put(str, cVar2);
                }
                cVar = cVar2;
            }
            forumSquareRequestMessage.pn = cVar.f56493e + 1;
            this.f21132f = true;
            sendMessage(forumSquareRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void M(d.a.q0.e3.f.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || !ListUtils.isEmpty(this.f21134h) || dVar == null || ListUtils.isEmpty(dVar.f56497b)) {
            return;
        }
        for (String str : dVar.f56497b) {
            if (!TextUtils.isEmpty(str) && !this.f21134h.contains(str)) {
                this.f21134h.add(str);
            }
        }
    }

    public final void N(d.a.q0.e3.f.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            String str = dVar.f56499d;
            if (TextUtils.isEmpty(str)) {
                str = (String) ListUtils.getItem(this.f21134h, 0);
                dVar.f56499d = str;
            }
            d.a.q0.e3.f.c cVar = this.f21133g.get(str);
            if (cVar == null) {
                cVar = new d.a.q0.e3.f.c();
                this.f21133g.put(str, cVar);
            }
            cVar.b(dVar);
            d dVar2 = this.f21131e;
            if (dVar2 != null) {
                dVar2.a(str, this.f21134h, cVar.a());
            }
        }
    }

    public int O(List<n> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, list, i2)) == null) {
            int count = ListUtils.getCount(list);
            if (count <= i2) {
                return 0;
            }
            int max = Math.max(count - 300, 30);
            int i3 = (count - max) / 2;
            int i4 = i3 + max;
            if (i3 <= 20 || i4 >= count - 20) {
                return 0;
            }
            ListUtils.removeSubList(list, i3, i4);
            return max;
        }
        return invokeLI.intValue;
    }

    public final void P(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            for (Map.Entry<String, d.a.q0.e3.f.c> entry : this.f21133g.entrySet()) {
                d.a.q0.e3.f.c value = entry.getValue();
                if (value != null && !ListUtils.isEmpty(value.a())) {
                    for (n nVar : value.a()) {
                        if (nVar instanceof d.a.q0.e3.f.b) {
                            d.a.q0.e3.f.b bVar = (d.a.q0.e3.f.b) nVar;
                            if (bVar.f56484e == j) {
                                bVar.f56487h = z;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.cancelMessage();
            this.f21132f = false;
        }
    }

    public void clearData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f21134h.clear();
        }
    }
}
