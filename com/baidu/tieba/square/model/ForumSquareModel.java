package com.baidu.tieba.square.model;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
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
import com.baidu.tieba.enterForum.data.ForumSquareHttpResponsedMessage;
import com.baidu.tieba.enterForum.data.ForumSquareSocketResponsedMessage;
import com.baidu.tieba.iy6;
import com.baidu.tieba.square.message.ForumSquareRequestMessage;
import com.baidu.tieba.tbadkCore.writeModel.AttentionBarData;
import com.baidu.tieba.u7a;
import com.baidu.tieba.y7a;
import com.baidu.tieba.ym;
import com.baidu.tieba.z7a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.chromium.net.NetError;
/* loaded from: classes8.dex */
public class ForumSquareModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u7a a;
    public boolean b;
    public final HashMap<String, z7a> c;
    public final List<String> d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public NetMessageListener g;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumSquareModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumSquareModel forumSquareModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumSquareModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumSquareModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof AttentionBarData)) {
                AttentionBarData attentionBarData = (AttentionBarData) customResponsedMessage.getData();
                if (attentionBarData.isSuccess) {
                    this.a.g0(attentionBarData.forumId, true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumSquareModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ForumSquareModel forumSquareModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumSquareModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumSquareModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof AttentionBarData)) {
                AttentionBarData attentionBarData = (AttentionBarData) customResponsedMessage.getData();
                if (attentionBarData.isSuccess) {
                    this.a.g0(attentionBarData.forumId, false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumSquareModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ForumSquareModel forumSquareModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumSquareModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumSquareModel;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str;
            iy6 iy6Var;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            this.a.b = false;
            if (responsedMessage == null) {
                return;
            }
            this.a.mErrorCode = responsedMessage.getError();
            this.a.mErrorString = responsedMessage.getErrorString();
            if (StringUtils.isNull(this.a.mErrorString)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e21);
            } else {
                str = this.a.mErrorString;
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.a.mErrorCode);
            errorData.setError_msg(str);
            String str2 = null;
            if (responsedMessage instanceof ForumSquareHttpResponsedMessage) {
                iy6Var = ((ForumSquareHttpResponsedMessage) responsedMessage).getData();
            } else if (responsedMessage instanceof ForumSquareSocketResponsedMessage) {
                iy6Var = ((ForumSquareSocketResponsedMessage) responsedMessage).getData();
            } else {
                iy6Var = null;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof ForumSquareRequestMessage) {
                str2 = ((ForumSquareRequestMessage) extra).className;
            }
            this.a.d0(iy6Var);
            if (ListUtils.isEmpty(this.a.d)) {
                if (this.a.a != null) {
                    this.a.a.onNoData(errorData);
                }
            } else if (this.a.mErrorCode != 0 || iy6Var == null) {
                if (this.a.a != null) {
                    this.a.a.onError(str2, errorData);
                }
            } else {
                this.a.e0(iy6Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumSquareModel(Context context, u7a u7aVar) {
        super(UtilHelper.getTbPageContext(context));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, u7aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = new HashMap<>();
        this.d = new ArrayList();
        this.e = new a(this, 2001437);
        this.f = new b(this, 2001438);
        c cVar = new c(this, CmdConfigHttp.CMD_FORUM_SQUARE, 309653);
        this.g = cVar;
        this.a = u7aVar;
        cVar.getHttpMessageListener().setSelfListener(true);
        this.g.getSocketMessageListener().setSelfListener(true);
        registerListener(this.g);
        registerListener(this.e);
        registerListener(this.f);
    }

    public final void g0(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            for (Map.Entry<String, z7a> entry : this.c.entrySet()) {
                z7a value = entry.getValue();
                if (value != null && !ListUtils.isEmpty(value.a())) {
                    for (ym ymVar : value.a()) {
                        if (ymVar instanceof y7a) {
                            y7a y7aVar = (y7a) ymVar;
                            if (y7aVar.a == j) {
                                y7aVar.d = z;
                            }
                        }
                    }
                }
            }
        }
    }

    public z7a Z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                return null;
            }
            return this.c.get(str);
        }
        return (z7a) invokeL.objValue;
    }

    public boolean a0(String str) {
        InterceptResult invokeL;
        z7a z7aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (z7aVar = this.c.get(str)) == null) {
                return false;
            }
            return z7aVar.d;
        }
        return invokeL.booleanValue;
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.cancelMessage();
            this.b = false;
        }
    }

    public void clearData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.d.clear();
        }
    }

    public void c0(String str) {
        z7a z7aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            ForumSquareRequestMessage forumSquareRequestMessage = new ForumSquareRequestMessage();
            forumSquareRequestMessage.className = str;
            if (TextUtils.isEmpty(str)) {
                z7aVar = new z7a();
            } else {
                z7a z7aVar2 = this.c.get(str);
                if (z7aVar2 == null) {
                    z7aVar2 = new z7a();
                    this.c.put(str, z7aVar2);
                }
                z7aVar = z7aVar2;
            }
            forumSquareRequestMessage.pn = z7aVar.e + 1;
            this.b = true;
            sendMessage(forumSquareRequestMessage);
        }
    }

    public final void d0(iy6 iy6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, iy6Var) == null) && ListUtils.isEmpty(this.d) && iy6Var != null && !ListUtils.isEmpty(iy6Var.b)) {
            for (String str : iy6Var.b) {
                if (!TextUtils.isEmpty(str) && !this.d.contains(str)) {
                    this.d.add(str);
                }
            }
        }
    }

    public final void e0(iy6 iy6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iy6Var) == null) {
            String str = iy6Var.d;
            if (TextUtils.isEmpty(str)) {
                str = (String) ListUtils.getItem(this.d, 0);
                iy6Var.d = str;
            }
            z7a z7aVar = this.c.get(str);
            if (z7aVar == null) {
                z7aVar = new z7a();
                this.c.put(str, z7aVar);
            }
            z7aVar.b(iy6Var);
            u7a u7aVar = this.a;
            if (u7aVar != null) {
                u7aVar.onSucc(str, this.d, z7aVar.a());
            }
        }
    }

    public int f0(List<ym> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, list, i)) == null) {
            int count = ListUtils.getCount(list);
            if (count <= i) {
                return 0;
            }
            int max = Math.max(count + NetError.ERR_INVALID_URL, 30);
            int i2 = (count - max) / 2;
            int i3 = i2 + max;
            if (i2 <= 20 || i3 >= count - 20) {
                return 0;
            }
            ListUtils.removeSubList(list, i2, i3);
            return max;
        }
        return invokeLI.intValue;
    }
}
