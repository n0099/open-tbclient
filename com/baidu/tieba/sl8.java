package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.immessagecenter.arch.utils.IMLog;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.ChatGroupSource;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatGroupInfo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class sl8 extends ol8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ChatRoomInfo> m;
    public ArrayList<ChatRoomInfo> n;
    public final Map<String, oe<String>> o;
    public TbPageContext p;
    @Nullable
    public FastRequest q;
    public boolean r;
    public String s;
    public boolean t;
    public ArrayList<Long> u;
    public o v;
    public CustomMessageListener w;

    /* loaded from: classes8.dex */
    public interface o {
        void a(@Nullable List<ImMessageCenterPojo> list, boolean z);

        void b(@Nullable List<ImMessageCenterPojo> list);
    }

    @Override // com.baidu.tieba.ol8
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a implements cx5<List<ImMessageCenterPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ sl8 b;

        public a(sl8 sl8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sl8Var;
            this.a = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cx5
        /* renamed from: a */
        public void onReturnDataInUI(List<ImMessageCenterPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                if (!ListUtils.isEmpty(list) && this.b.v != null) {
                    TbLog iMLog = IMLog.getInstance();
                    iMLog.i("ChatTabSubscribeGroupMessageDispatcher", "[03-requestGroupList] onLoadedGroupList <传参params> changeGroupInfoList = " + ListUtils.getCount(list) + " | hasGroupList = true");
                    this.b.v.a(list, true);
                }
                this.b.S(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements FastRequest.e<ChatGroupInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl8 a;

        public b(sl8 sl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.e
        @Nullable
        /* renamed from: b */
        public ChatGroupInfo a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) != null) {
                return (ChatGroupInfo) invokeL.objValue;
            }
            return this.a.R(str, true);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ sl8 b;

        public c(sl8 sl8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sl8Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.L().g("group_chat_http_key", this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends xx5<List<ImMessageCenterPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ sl8 b;

        public d(sl8 sl8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sl8Var;
            this.a = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx5
        public List<ImMessageCenterPojo> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b.H(this.a);
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements cx5<List<ImMessageCenterPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl8 a;

        public e(sl8 sl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cx5
        /* renamed from: a */
        public void onReturnDataInUI(List<ImMessageCenterPojo> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && !ListUtils.isEmpty(list) && this.a.v != null) {
                this.a.v.b(list);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(sl8 sl8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl8Var, Integer.valueOf(i)};
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
            this.a = sl8Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            Map map;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921766 && (customResponsedMessage.getData() instanceof Map) && (map = (Map) customResponsedMessage.getData()) != null && !map.isEmpty() && map.entrySet() != null && map.entrySet().iterator() != null) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    if (entry.getValue() != null && !ListUtils.isEmpty(this.a.u) && this.a.u.contains(Long.valueOf(((ChatRoomInfo) entry.getValue()).getRoomId()))) {
                        arrayList.add((ChatRoomInfo) entry.getValue());
                    }
                }
                this.a.a0(arrayList);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes8.dex */
    public class g extends xx5<List<ChatRoomInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl8 a;

        public g(sl8 sl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx5
        public List<ChatRoomInfo> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.m(TbadkCoreApplication.getCurrentAccount());
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class h implements cx5<List<ChatRoomInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl8 a;

        public h(sl8 sl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cx5
        /* renamed from: a */
        public void onReturnDataInUI(List<ChatRoomInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.a.u.clear();
                if (!ListUtils.isEmpty(list)) {
                    for (ChatRoomInfo chatRoomInfo : list) {
                        if (chatRoomInfo != null && chatRoomInfo.isSubscribe()) {
                            this.a.u.add(Long.valueOf(chatRoomInfo.getRoomId()));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i extends xx5<List<ImMessageCenterPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl8 a;

        public i(sl8 sl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx5
        public List<ImMessageCenterPojo> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ChatGroupInfo R = this.a.R(this.a.L().get("group_chat_http_key"), false);
                if (R != null && !ListUtils.isEmpty(R.getRoomInfoList())) {
                    return this.a.H(R.getRoomInfoList());
                }
                return null;
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class j implements cx5<List<ImMessageCenterPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl8 a;

        public j(sl8 sl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cx5
        /* renamed from: a */
        public void onReturnDataInUI(List<ImMessageCenterPojo> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || !this.a.t) {
                return;
            }
            if (!ListUtils.isEmpty(list) && this.a.v != null) {
                TbLog iMLog = IMLog.getInstance();
                iMLog.i("ChatTabSubscribeGroupMessageDispatcher", "[01-requestGroupHistoryList] onLoadedGroupList <传参params> changeGroupInfoList = " + ListUtils.getCount(list) + " | hasGroupList = true");
                this.a.v.a(list, true);
            } else if (this.a.v != null) {
                IMLog.getInstance().i("ChatTabSubscribeGroupMessageDispatcher", "[02-requestGroupHistoryList] onLoadedGroupList <传参params> changeGroupInfoList = null | hasGroupList = false");
                this.a.v.a(null, false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ sl8 b;

        public k(sl8 sl8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sl8Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                cs8.a().c(this.b.m(TbadkCoreApplication.getCurrentAccount()), this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l extends xx5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl8 a;

        public l(sl8 sl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                sl8 sl8Var = this.a;
                return sl8Var.M(sl8Var.N(0));
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class m implements cx5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl8 a;

        public m(sl8 sl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cx5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.a.J(str);
        }
    }

    /* loaded from: classes8.dex */
    public class n extends xx5<List<ImMessageCenterPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ sl8 b;

        public n(sl8 sl8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sl8Var;
            this.a = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx5
        public List<ImMessageCenterPojo> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b.H(this.a);
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class p extends FastRequest.b<ChatGroupInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<sl8> b;

        public p(sl8 sl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new WeakReference<>(sl8Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void b(int i, @NonNull String str, @Nullable ChatGroupInfo chatGroupInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, chatGroupInfo) == null) {
                super.b(i, str, chatGroupInfo);
                sl8 sl8Var = this.b.get();
                if (sl8Var == null) {
                    return;
                }
                sl8Var.P(i, str, chatGroupInfo);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: h */
        public void f(@NonNull ChatGroupInfo chatGroupInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, chatGroupInfo) == null) {
                super.f(chatGroupInfo);
                sl8 sl8Var = this.b.get();
                if (sl8Var != null) {
                    sl8Var.Q(chatGroupInfo);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sl8(TbPageContext tbPageContext, o oVar) {
        super(tbPageContext.getPageActivity(), ChatGroupSource.GROUP_CHAT_TAB);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ChatGroupSource) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new ArrayList<>();
        this.n = new ArrayList<>();
        this.o = new HashMap();
        this.r = false;
        this.s = null;
        this.t = true;
        this.u = new ArrayList<>();
        this.w = new f(this, 2921766);
        this.p = tbPageContext;
        this.v = oVar;
        MessageManager.getInstance().registerListener(this.w);
    }

    public final ChatGroupInfo R(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                this.s = null;
                return null;
            }
            if (z) {
                this.s = str;
            }
            ChatGroupInfo chatGroupInfo = new ChatGroupInfo();
            try {
                chatGroupInfo.parse(new JSONObject(str));
                return chatGroupInfo;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (ChatGroupInfo) invokeLZ.objValue;
    }

    public final void I(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            mg.e(new k(this, list));
        }
    }

    public String M(List<Map<String, Long>> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            String json = DataExt.toJson(list);
            if (TextUtils.isEmpty(json)) {
                return "";
            }
            return json;
        }
        return (String) invokeL.objValue;
    }

    public void X(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) {
            w(j2, 0);
        }
    }

    public void Y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            mg.e(new c(this, str));
        }
    }

    public void Z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            O();
        }
    }

    public final void a0(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, list) == null) && !ListUtils.isEmpty(list) && this.v != null) {
            by5.c(new d(this, Collections.synchronizedList(list)), new e(this));
        }
    }

    public void b0(ChatRoomInfo chatRoomInfo) {
        ArrayList<ChatRoomInfo> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, chatRoomInfo) == null) && chatRoomInfo != null && (arrayList = this.m) != null) {
            arrayList.clear();
            this.m.add(chatRoomInfo);
            a0(this.m);
        }
    }

    @WorkerThread
    public final List<ImMessageCenterPojo> H(List<ChatRoomInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (ChatRoomInfo chatRoomInfo : list) {
                ImMessageCenterPojo T2 = T(chatRoomInfo);
                if (T2 != null) {
                    arrayList.add(T2);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void J(@NonNull String str) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || (tbPageContext = this.p) == null) {
            return;
        }
        if (this.q == null) {
            this.q = new FastRequest(tbPageContext, CmdConfigHttp.CMD_GET_SUBSCRIBE_GROUP_CHAT_LIST, TbConfig.GET_SUBSCRIBE_GROUP_CHAT_LIST);
        }
        FastRequest fastRequest = this.q;
        fastRequest.N("chatroom_new_msg", str);
        fastRequest.S(HttpMessageTask.HTTP_METHOD.POST);
        fastRequest.P(new p(this));
        fastRequest.U(new b(this));
        fastRequest.O();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || !this.r) {
            return;
        }
        h();
        this.r = false;
        IMLog.getInstance().i("ChatTabSubscribeGroupMessageDispatcher", "existChatRoom");
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.u == null) {
                this.u = new ArrayList<>();
            }
            by5.c(new g(this), new h(this));
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            O();
            p();
            this.r = true;
            IMLog.getInstance().i("ChatTabSubscribeGroupMessageDispatcher", "getSubscribeRoomIdList <重新加入> reEnterChatRoom");
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.v != null) {
            this.t = true;
            by5.c(new i(this), new j(this));
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && TbadkCoreApplication.isLogin() && TbSingleton.getInstance().isNeedJoinChatRoom()) {
            by5.c(new l(this), new m(this));
        }
    }

    @Override // com.baidu.tieba.ol8
    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return jo8.a();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.ol8
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.o();
            FastRequest fastRequest = this.q;
            if (fastRequest != null) {
                fastRequest.onDestroy();
            }
            this.v = null;
            K();
            MessageManager.getInstance().unRegisterListener(this.w);
            this.p = null;
        }
    }

    public oe<String> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (this.o.containsKey(currentAccount)) {
                return this.o.get(currentAccount);
            }
            x45.k();
            oe<String> m2 = x45.m("tb.im_group_chat_http", TbadkCoreApplication.getCurrentAccount());
            this.o.put(currentAccount, m2);
            return m2;
        }
        return (oe) invokeV.objValue;
    }

    @WorkerThread
    public List<Map<String, Long>> N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            List<ChatRoomInfo> m2 = m(TbadkCoreApplication.getCurrentAccount());
            if (ListUtils.isEmpty(m2)) {
                return null;
            }
            if (i2 != 0) {
                if (i2 == 1) {
                    for (ChatRoomInfo chatRoomInfo : m2) {
                        if (!chatRoomInfo.isNoDisturb()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("room_id", Long.valueOf(chatRoomInfo.getRoomId()));
                            if (chatRoomInfo.getNewMessage() != null) {
                                hashMap.put("msg_id", Long.valueOf(chatRoomInfo.getNewMessage().getMsgId()));
                            } else {
                                hashMap.put("msg_id", 0L);
                            }
                            arrayList.add(hashMap);
                        }
                    }
                }
            } else {
                for (ChatRoomInfo chatRoomInfo2 : m2) {
                    HashMap hashMap2 = new HashMap();
                    if (chatRoomInfo2 != null && chatRoomInfo2.getLatestMsgId() != 0) {
                        hashMap2.put("room_id", Long.valueOf(chatRoomInfo2.getRoomId()));
                        if (chatRoomInfo2.getNewMessage() != null) {
                            hashMap2.put("msg_id", Long.valueOf(chatRoomInfo2.getNewMessage().getMsgId()));
                            hashMap2.put("time", Long.valueOf(chatRoomInfo2.getNewMessage().getLastExitChatRoomTime()));
                        } else {
                            hashMap2.put("msg_id", 0L);
                            hashMap2.put("time", 1L);
                        }
                        arrayList.add(hashMap2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final void P(int i2, @NonNull String str, @Nullable ChatGroupInfo chatGroupInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str, chatGroupInfo) == null) && this.v != null) {
            TbLog iMLog = IMLog.getInstance();
            iMLog.i("ChatTabSubscribeGroupMessageDispatcher", "[05-requestGroupHistoryList] -> 订阅列表短链请求失败 onError errno =" + i2 + " errMsg = " + str + "onLoadedGroupList <传参params> changeGroupInfoList = null | hasGroupList = false");
            this.v.a(null, false);
        }
    }

    public final void Q(@NonNull ChatGroupInfo chatGroupInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, chatGroupInfo) == null) {
            this.t = false;
            if (this.v == null) {
                return;
            }
            Y(this.s);
            if (!ListUtils.isEmpty(chatGroupInfo.getRoomInfoList())) {
                I(chatGroupInfo.getRoomInfoList());
                List synchronizedList = Collections.synchronizedList(chatGroupInfo.getRoomInfoList());
                by5.c(new n(this, synchronizedList), new a(this, synchronizedList));
                return;
            }
            I(new ArrayList());
            if (this.v != null) {
                IMLog.getInstance().i("ChatTabSubscribeGroupMessageDispatcher", "[04-requestGroupHistoryList] 直接加载私聊数据 onLoadedGroupList <传参params> changeGroupInfoList = null | hasGroupList = false");
                this.v.a(null, false);
            }
        }
    }

    public void S(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, list) == null) && TbSingleton.getInstance().isNeedJoinChatRoom() && this.n != null) {
            O();
            this.n.clear();
            for (ChatRoomInfo chatRoomInfo : list) {
                if (chatRoomInfo != null && chatRoomInfo.getIsShow() == 1) {
                    this.n.add(chatRoomInfo);
                }
            }
            n(this.n);
            IMLog.getInstance().i("ChatTabSubscribeGroupMessageDispatcher", "preEnterGroupChatRoom -> 缓存数据,并加入聊天室");
            this.r = true;
        }
    }

    @WorkerThread
    public final ImMessageCenterPojo T(ChatRoomInfo chatRoomInfo) {
        InterceptResult invokeL;
        long msgTime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, chatRoomInfo)) == null) {
            if (chatRoomInfo == null) {
                return null;
            }
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(String.valueOf(chatRoomInfo.getRoomId()));
            imMessageCenterPojo.setGroup_head(chatRoomInfo.getAvatar());
            imMessageCenterPojo.setGroup_name(chatRoomInfo.getName());
            imMessageCenterPojo.setCustomGroupType(9);
            imMessageCenterPojo.setUnread_count(chatRoomInfo.getUnreadNum());
            imMessageCenterPojo.setGroupJumpUrl(chatRoomInfo.getJumpUrl());
            if (chatRoomInfo.getAtInfo() != null) {
                s25 s25Var = new s25();
                s25Var.a(chatRoomInfo.getAtInfo().getAllMsgCount());
                s25Var.b(chatRoomInfo.getAtInfo().getCountAll());
                s25Var.c(chatRoomInfo.getAtInfo().getSingleMsgCount());
                imMessageCenterPojo.setAtInfoData(s25Var);
            }
            imMessageCenterPojo.setForumName(chatRoomInfo.getForumName());
            imMessageCenterPojo.setForumId(chatRoomInfo.getForumId());
            imMessageCenterPojo.setRoomId(chatRoomInfo.getRoomId());
            if (chatRoomInfo.getIsShow() == 0) {
                return null;
            }
            if (chatRoomInfo.getNewMessage() == null) {
                imMessageCenterPojo.setLast_user_name("");
                imMessageCenterPojo.setLast_content("");
                imMessageCenterPojo.setIs_hidden(0);
                imMessageCenterPojo.setLast_content_time(System.currentTimeMillis());
                return imMessageCenterPojo;
            }
            if (!TextUtils.isEmpty(chatRoomInfo.getNewMessage().getFromUid()) && chatRoomInfo.getUnreadNum() == 1 && chatRoomInfo.getNewMessage().getFromUid().equals(TbadkCoreApplication.getCurrentAccount())) {
                imMessageCenterPojo.setUnread_count(0);
            }
            imMessageCenterPojo.setLast_user_name(chatRoomInfo.getNewMessage().getFromName());
            imMessageCenterPojo.setLast_content(chatRoomInfo.getNewMessage().getContent());
            imMessageCenterPojo.setSpecialMsgText(chatRoomInfo.getNewMessage().getSpecialMsg());
            if (String.valueOf(chatRoomInfo.getNewMessage().getMsgTime()).length() <= 10 && chatRoomInfo.getNewMessage().getMsgTime() != 0) {
                msgTime = chatRoomInfo.getNewMessage().getMsgTime() * 1000;
            } else {
                msgTime = chatRoomInfo.getNewMessage().getMsgTime();
            }
            if (li8.b().c(Long.valueOf(chatRoomInfo.getRoomId()), msgTime)) {
                imMessageCenterPojo.setIs_hidden(1);
            } else {
                imMessageCenterPojo.setIs_hidden(0);
            }
            imMessageCenterPojo.setLast_content_time(msgTime);
            return imMessageCenterPojo;
        }
        return (ImMessageCenterPojo) invokeL.objValue;
    }
}
