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
import com.baidu.adp.lib.safe.UiUtils;
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
public class v19 extends q19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ChatRoomInfo> m;
    public final Map<String, da<String>> n;
    public TbPageContext o;
    @Nullable
    public FastRequest p;
    public boolean q;
    public String r;
    public boolean s;
    public ArrayList<Long> t;
    public o u;
    public CustomMessageListener v;

    /* loaded from: classes8.dex */
    public interface o {
        void a(@Nullable List<ImMessageCenterPojo> list, boolean z);

        void b(@Nullable List<ImMessageCenterPojo> list);
    }

    @Override // com.baidu.tieba.q19
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a implements st5<List<ImMessageCenterPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ v19 b;

        public a(v19 v19Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v19Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v19Var;
            this.a = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(List<ImMessageCenterPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                if (!ListUtils.isEmpty(list) && this.b.u != null) {
                    TbLog iMLog = IMLog.getInstance();
                    iMLog.i("ChatTabSubscribeGroupMessageDispatcher", "[03-requestGroupList] onLoadedGroupList <传参params> changeGroupInfoList = " + ListUtils.getCount(list) + " | hasGroupList = true");
                    this.b.u.a(list, true);
                }
                this.b.S(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements FastRequest.e<ChatGroupInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v19 a;

        public b(v19 v19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v19Var;
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
        public final /* synthetic */ v19 b;

        public c(v19 v19Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v19Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v19Var;
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
    public class d extends nu5<List<ImMessageCenterPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ v19 b;

        public d(v19 v19Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v19Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v19Var;
            this.a = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
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
    public class e implements st5<List<ImMessageCenterPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v19 a;

        public e(v19 v19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(List<ImMessageCenterPojo> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && !ListUtils.isEmpty(list) && this.a.u != null) {
                this.a.u.b(list);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v19 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(v19 v19Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v19Var, Integer.valueOf(i)};
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
            this.a = v19Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            Map map;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921766 && (customResponsedMessage.getData() instanceof Map) && (map = (Map) customResponsedMessage.getData()) != null && !map.isEmpty() && map.entrySet() != null && map.entrySet().iterator() != null) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    if (entry.getValue() != null && !ListUtils.isEmpty(this.a.t) && this.a.t.contains(Long.valueOf(((ChatRoomInfo) entry.getValue()).getRoomId()))) {
                        arrayList.add((ChatRoomInfo) entry.getValue());
                    }
                }
                this.a.Z(arrayList);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes8.dex */
    public class g extends nu5<List<ChatRoomInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v19 a;

        public g(v19 v19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        public List<ChatRoomInfo> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.n(TbadkCoreApplication.getCurrentAccount());
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class h implements st5<List<ChatRoomInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v19 a;

        public h(v19 v19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(List<ChatRoomInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.a.t.clear();
                if (!ListUtils.isEmpty(list)) {
                    for (ChatRoomInfo chatRoomInfo : list) {
                        if (chatRoomInfo != null && chatRoomInfo.isSubscribe()) {
                            this.a.t.add(Long.valueOf(chatRoomInfo.getRoomId()));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i extends nu5<List<ImMessageCenterPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v19 a;

        public i(v19 v19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
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
    public class j implements st5<List<ImMessageCenterPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v19 a;

        public j(v19 v19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(List<ImMessageCenterPojo> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || !this.a.s) {
                return;
            }
            if (!ListUtils.isEmpty(list) && this.a.u != null) {
                TbLog iMLog = IMLog.getInstance();
                iMLog.i("ChatTabSubscribeGroupMessageDispatcher", "[01-requestGroupHistoryList] onLoadedGroupList <传参params> changeGroupInfoList = " + ListUtils.getCount(list) + " | hasGroupList = true");
                this.a.u.a(list, true);
            } else if (this.a.u != null) {
                IMLog.getInstance().i("ChatTabSubscribeGroupMessageDispatcher", "[02-requestGroupHistoryList] onLoadedGroupList <传参params> changeGroupInfoList = null | hasGroupList = false");
                this.a.u.a(null, false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ v19 b;

        public k(v19 v19Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v19Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v19Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d59.a().c(this.b.n(TbadkCoreApplication.getCurrentAccount()), this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l extends nu5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v19 a;

        public l(v19 v19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                v19 v19Var = this.a;
                return v19Var.M(v19Var.N(0));
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class m implements st5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v19 a;

        public m(v19 v19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
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
    public class n extends nu5<List<ImMessageCenterPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ v19 b;

        public n(v19 v19Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v19Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v19Var;
            this.a = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
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
        public final WeakReference<v19> d;

        public p(v19 v19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = new WeakReference<>(v19Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, @NonNull String str, @Nullable ChatGroupInfo chatGroupInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, chatGroupInfo) == null) {
                super.f(i, str, chatGroupInfo);
                v19 v19Var = this.d.get();
                if (v19Var == null) {
                    return;
                }
                v19Var.P(i, str, chatGroupInfo);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(@NonNull ChatGroupInfo chatGroupInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, chatGroupInfo) == null) {
                super.i(chatGroupInfo);
                v19 v19Var = this.d.get();
                if (v19Var != null) {
                    v19Var.Q(chatGroupInfo);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v19(TbPageContext tbPageContext, o oVar) {
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
        new ArrayList();
        this.m = new ArrayList<>();
        this.n = new HashMap();
        this.q = false;
        this.r = null;
        this.s = true;
        this.t = new ArrayList<>();
        this.v = new f(this, 2921766);
        this.o = tbPageContext;
        this.u = oVar;
        MessageManager.getInstance().registerListener(this.v);
    }

    public final ChatGroupInfo R(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                this.r = null;
                return null;
            }
            if (z) {
                this.r = str;
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
            UiUtils.runOnBgThread(new k(this, list));
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

    public void W(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
            w(j2, 0);
        }
    }

    public void X(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            UiUtils.runOnBgThread(new c(this, str));
        }
    }

    public void Y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            O();
        }
    }

    public final void Z(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, list) == null) && !ListUtils.isEmpty(list) && this.u != null) {
            ru5.c(new d(this, Collections.synchronizedList(list)), new e(this));
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
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || (tbPageContext = this.o) == null) {
            return;
        }
        if (this.p == null) {
            this.p = new FastRequest(tbPageContext, CmdConfigHttp.CMD_GET_SUBSCRIBE_GROUP_CHAT_LIST, TbConfig.GET_SUBSCRIBE_GROUP_CHAT_LIST);
        }
        FastRequest fastRequest = this.p;
        fastRequest.P("chatroom_new_msg", str);
        fastRequest.U(HttpMessageTask.HTTP_METHOD.POST);
        fastRequest.R(new p(this));
        fastRequest.W(new b(this));
        fastRequest.Q();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || !this.q) {
            return;
        }
        h();
        this.q = false;
        IMLog.getInstance().i("ChatTabSubscribeGroupMessageDispatcher", "existChatRoom");
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.t == null) {
                this.t = new ArrayList<>();
            }
            ru5.c(new g(this), new h(this));
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.u != null) {
            this.s = true;
            ru5.c(new i(this), new j(this));
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && TbadkCoreApplication.isLogin() && TbSingleton.getInstance().isNeedJoinChatRoom()) {
            ru5.c(new l(this), new m(this));
        }
    }

    @Override // com.baidu.tieba.q19
    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return yv8.a();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.q19
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.p();
            FastRequest fastRequest = this.p;
            if (fastRequest != null) {
                fastRequest.onDestroy();
            }
            this.u = null;
            K();
            MessageManager.getInstance().unRegisterListener(this.v);
            this.o = null;
        }
    }

    public da<String> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (this.n.containsKey(currentAccount)) {
                return this.n.get(currentAccount);
            }
            e05.k();
            da<String> n2 = e05.n("tb.im_group_chat_http", TbadkCoreApplication.getCurrentAccount());
            this.n.put(currentAccount, n2);
            return n2;
        }
        return (da) invokeV.objValue;
    }

    @WorkerThread
    public List<Map<String, Long>> N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            List<ChatRoomInfo> n2 = n(TbadkCoreApplication.getCurrentAccount());
            if (ListUtils.isEmpty(n2)) {
                return null;
            }
            if (i2 != 0) {
                if (i2 == 1) {
                    for (ChatRoomInfo chatRoomInfo : n2) {
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
                for (ChatRoomInfo chatRoomInfo2 : n2) {
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
        if ((interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str, chatGroupInfo) == null) && this.u != null) {
            TbLog iMLog = IMLog.getInstance();
            iMLog.i("ChatTabSubscribeGroupMessageDispatcher", "[05-requestGroupHistoryList] -> 订阅列表短链请求失败 onError errno =" + i2 + " errMsg = " + str + "onLoadedGroupList <传参params> changeGroupInfoList = null | hasGroupList = false");
            this.u.a(null, false);
        }
    }

    public final void Q(@NonNull ChatGroupInfo chatGroupInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, chatGroupInfo) == null) {
            this.s = false;
            if (this.u == null) {
                return;
            }
            X(this.r);
            if (!ListUtils.isEmpty(chatGroupInfo.getRoomInfoList())) {
                I(chatGroupInfo.getRoomInfoList());
                List synchronizedList = Collections.synchronizedList(chatGroupInfo.getRoomInfoList());
                ru5.c(new n(this, synchronizedList), new a(this, synchronizedList));
                return;
            }
            I(new ArrayList());
            if (this.u != null) {
                IMLog.getInstance().i("ChatTabSubscribeGroupMessageDispatcher", "[04-requestGroupHistoryList] 直接加载私聊数据 onLoadedGroupList <传参params> changeGroupInfoList = null | hasGroupList = false");
                this.u.a(null, false);
            }
        }
    }

    public void S(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, list) == null) && TbSingleton.getInstance().isNeedJoinChatRoom() && this.m != null) {
            O();
            this.m.clear();
            for (ChatRoomInfo chatRoomInfo : list) {
                if (chatRoomInfo != null && chatRoomInfo.getIsShow() == 1) {
                    this.m.add(chatRoomInfo);
                }
            }
            o(this.m);
            IMLog.getInstance().i("ChatTabSubscribeGroupMessageDispatcher", "preEnterGroupChatRoom -> 缓存数据,并加入聊天室");
            this.q = true;
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
                xx4 xx4Var = new xx4();
                xx4Var.a(chatRoomInfo.getAtInfo().getAllMsgCount());
                xx4Var.b(chatRoomInfo.getAtInfo().getCountAll());
                xx4Var.c(chatRoomInfo.getAtInfo().getSingleMsgCount());
                imMessageCenterPojo.setAtInfoData(xx4Var);
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
            if (cx8.b().c(Long.valueOf(chatRoomInfo.getRoomId()), msgTime)) {
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
