package com.baidu.tieba.square.model;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.f;
import b.a.e.l.e.n;
import b.a.r0.i3.d;
import b.a.r0.l3.s0.k;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class ForumSquareModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f54080e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54081f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, b.a.r0.i3.f.c> f54082g;

    /* renamed from: h  reason: collision with root package name */
    public final List<String> f54083h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f54084i;
    public CustomMessageListener j;
    public b.a.e.c.g.a k;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumSquareModel f54085a;

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
            this.f54085a = forumSquareModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                k kVar = (k) customResponsedMessage.getData();
                if (kVar.f20875b) {
                    this.f54085a.P(kVar.f20874a, true);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumSquareModel f54086a;

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
            this.f54086a = forumSquareModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                k kVar = (k) customResponsedMessage.getData();
                if (kVar.f20875b) {
                    this.f54086a.P(kVar.f20874a, false);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumSquareModel f54087a;

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
            this.f54087a = forumSquareModel;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str;
            b.a.r0.i3.f.d data;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f54087a.f54081f = false;
                if (responsedMessage == null) {
                    return;
                }
                this.f54087a.mErrorCode = responsedMessage.getError();
                this.f54087a.mErrorString = responsedMessage.getErrorString();
                if (!StringUtils.isNull(this.f54087a.mErrorString)) {
                    str = this.f54087a.mErrorString;
                } else {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
                }
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.f54087a.mErrorCode);
                errorData.setError_msg(str);
                if (responsedMessage instanceof ForumSquareHttpResponsedMessage) {
                    data = ((ForumSquareHttpResponsedMessage) responsedMessage).getData();
                } else {
                    data = responsedMessage instanceof ForumSquareSocketResponsedMessage ? ((ForumSquareSocketResponsedMessage) responsedMessage).getData() : null;
                }
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                String str2 = extra instanceof ForumSquareRequestMessage ? ((ForumSquareRequestMessage) extra).className : null;
                this.f54087a.M(data);
                if (ListUtils.isEmpty(this.f54087a.f54083h)) {
                    if (this.f54087a.f54080e != null) {
                        this.f54087a.f54080e.b(errorData);
                    }
                } else if (this.f54087a.mErrorCode != 0 || data == null) {
                    if (this.f54087a.f54080e != null) {
                        this.f54087a.f54080e.c(str2, errorData);
                    }
                } else {
                    this.f54087a.N(data);
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
        this.f54081f = false;
        this.f54082g = new HashMap<>();
        this.f54083h = new ArrayList();
        this.f54084i = new a(this, 2001437);
        this.j = new b(this, 2001438);
        c cVar = new c(this, CmdConfigHttp.CMD_FORUM_SQUARE, 309653);
        this.k = cVar;
        this.f54080e = dVar;
        cVar.getHttpMessageListener().setSelfListener(true);
        this.k.getSocketMessageListener().setSelfListener(true);
        registerListener(this.k);
        registerListener(this.f54084i);
        registerListener(this.j);
    }

    public b.a.r0.i3.f.c I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                return null;
            }
            return this.f54082g.get(str);
        }
        return (b.a.r0.i3.f.c) invokeL.objValue;
    }

    public boolean J(String str) {
        InterceptResult invokeL;
        b.a.r0.i3.f.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (cVar = this.f54082g.get(str)) == null) {
                return false;
            }
            return cVar.f18034d;
        }
        return invokeL.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f54081f : invokeV.booleanValue;
    }

    public void L(String str) {
        b.a.r0.i3.f.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            ForumSquareRequestMessage forumSquareRequestMessage = new ForumSquareRequestMessage();
            forumSquareRequestMessage.className = str;
            if (TextUtils.isEmpty(str)) {
                cVar = new b.a.r0.i3.f.c();
            } else {
                b.a.r0.i3.f.c cVar2 = this.f54082g.get(str);
                if (cVar2 == null) {
                    cVar2 = new b.a.r0.i3.f.c();
                    this.f54082g.put(str, cVar2);
                }
                cVar = cVar2;
            }
            forumSquareRequestMessage.pn = cVar.f18035e + 1;
            this.f54081f = true;
            sendMessage(forumSquareRequestMessage);
        }
    }

    public final void M(b.a.r0.i3.f.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) || !ListUtils.isEmpty(this.f54083h) || dVar == null || ListUtils.isEmpty(dVar.f18039b)) {
            return;
        }
        for (String str : dVar.f18039b) {
            if (!TextUtils.isEmpty(str) && !this.f54083h.contains(str)) {
                this.f54083h.add(str);
            }
        }
    }

    public final void N(b.a.r0.i3.f.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            String str = dVar.f18041d;
            if (TextUtils.isEmpty(str)) {
                str = (String) ListUtils.getItem(this.f54083h, 0);
                dVar.f18041d = str;
            }
            b.a.r0.i3.f.c cVar = this.f54082g.get(str);
            if (cVar == null) {
                cVar = new b.a.r0.i3.f.c();
                this.f54082g.put(str, cVar);
            }
            cVar.b(dVar);
            d dVar2 = this.f54080e;
            if (dVar2 != null) {
                dVar2.a(str, this.f54083h, cVar.a());
            }
        }
    }

    public int O(List<n> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, list, i2)) == null) {
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
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            for (Map.Entry<String, b.a.r0.i3.f.c> entry : this.f54082g.entrySet()) {
                b.a.r0.i3.f.c value = entry.getValue();
                if (value != null && !ListUtils.isEmpty(value.a())) {
                    for (n nVar : value.a()) {
                        if (nVar instanceof b.a.r0.i3.f.b) {
                            b.a.r0.i3.f.b bVar = (b.a.r0.i3.f.b) nVar;
                            if (bVar.f18026e == j) {
                                bVar.f18029h = z;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.cancelMessage();
            this.f54081f = false;
        }
    }

    public void clearData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f54083h.clear();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
