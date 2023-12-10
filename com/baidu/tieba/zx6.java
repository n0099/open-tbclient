package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ForumTagInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumHttpResponseMessage;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumRequestMessage;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecentlyVisitedForumData a;
    public boolean b;
    public boolean c;
    public boolean d;
    public f e;
    public boolean f;
    @Nullable
    public String g;
    public CustomMessageListener h;
    public CustomMessageListener i;
    public NetMessageListener j;

    /* loaded from: classes9.dex */
    public interface f {
        void a(LinkedList<VisitedForumData> linkedList, boolean z);

        void b(int i);

        void onNotify();
    }

    /* loaded from: classes9.dex */
    public class a extends nu5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx6 a;

        public a(zx6 zx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zx6Var;
        }

        @Override // com.baidu.tieba.nu5
        public Object doInBackground() {
            InterceptResult invokeV;
            String j;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                e05.k();
                if (this.a.j() != null) {
                    j = this.a.j();
                } else {
                    j = "local";
                }
                da<String> n = e05.n("tb.recently_visited_forum", j);
                if (n != null && this.a.a != null) {
                    n.g("recently_visited_forum", OrmObject.jsonStrWithObject(this.a.a));
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Void, Void, RecentlyVisitedForumData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx6 a;

        public b(zx6 zx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(RecentlyVisitedForumData recentlyVisitedForumData) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recentlyVisitedForumData) != null) {
                return;
            }
            this.a.b = false;
            if (recentlyVisitedForumData == null) {
                return;
            }
            this.a.D(recentlyVisitedForumData.getForumData(), true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public RecentlyVisitedForumData doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            RecentlyVisitedForumData recentlyVisitedForumData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                e05.k();
                da<String> n = e05.n("tb.recently_visited_forum", "local");
                RecentlyVisitedForumData recentlyVisitedForumData2 = null;
                if (n != null && !rd.isEmpty(n.get("recently_visited_forum"))) {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(n.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                } else {
                    recentlyVisitedForumData = null;
                }
                if (this.a.j() != null) {
                    if (n != null) {
                        n.g("recently_visited_forum", "");
                    }
                    e05.k();
                    da<String> n2 = e05.n("tb.recently_visited_forum", this.a.j());
                    if (n2 != null && !StringUtils.isNull(n2.get("recently_visited_forum"))) {
                        try {
                            recentlyVisitedForumData2 = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(n2.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (recentlyVisitedForumData != null) {
                            recentlyVisitedForumData.mergeForumData(recentlyVisitedForumData2);
                            n2.g("recently_visited_forum", OrmObject.jsonStrWithObject(recentlyVisitedForumData));
                            return recentlyVisitedForumData;
                        }
                        return recentlyVisitedForumData2;
                    }
                    return recentlyVisitedForumData;
                }
                return recentlyVisitedForumData;
            }
            return (RecentlyVisitedForumData) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(zx6 zx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx6Var, Integer.valueOf(i)};
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
            this.a = zx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                this.a.w((VisitedForumData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(zx6 zx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx6Var, Integer.valueOf(i)};
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
            this.a = zx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.r();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(zx6 zx6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = zx6Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            this.a.c = false;
            if (responsedMessage == null || !(responsedMessage instanceof RecentlyVisitedForumHttpResponseMessage)) {
                return;
            }
            this.a.y((RecentlyVisitedForumHttpResponseMessage) responsedMessage);
        }
    }

    /* loaded from: classes9.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public static zx6 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-217022610, "Lcom/baidu/tieba/zx6$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-217022610, "Lcom/baidu/tieba/zx6$g;");
                    return;
                }
            }
            a = new zx6(null);
        }
    }

    public zx6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = false;
        this.h = new c(this, 2016564);
        this.i = new d(this, 2005016);
        this.j = new e(this, CmdConfigHttp.CMD_GET_HISTORY_FORUM, 309601);
        this.a = new RecentlyVisitedForumData();
        z();
        r();
    }

    @NonNull
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            StringBuilder sb = new StringBuilder("");
            RecentlyVisitedForumData recentlyVisitedForumData = this.a;
            if (recentlyVisitedForumData == null || ListUtils.isEmpty(recentlyVisitedForumData.getForumData())) {
                return "";
            }
            List trimToSize = ListUtils.trimToSize(this.a.getForumData(), 5);
            int count = ListUtils.getCount(trimToSize);
            for (int i = 0; i < count; i++) {
                VisitedForumData visitedForumData = (VisitedForumData) trimToSize.get(i);
                if (i < count - 1) {
                    sb.append(visitedForumData.getForumId());
                    sb.append(",");
                } else {
                    sb.append(visitedForumData.getForumId());
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder("");
            RecentlyVisitedForumData recentlyVisitedForumData = this.a;
            if (recentlyVisitedForumData == null || ListUtils.isEmpty(recentlyVisitedForumData.getForumData())) {
                return "";
            }
            List trimToSize = ListUtils.trimToSize(this.a.getForumData(), 5);
            int count = ListUtils.getCount(trimToSize);
            for (int i = 0; i < count; i++) {
                VisitedForumData visitedForumData = (VisitedForumData) trimToSize.get(i);
                if (i < count - 1) {
                    sb.append(visitedForumData.getForumName());
                    sb.append(",");
                } else {
                    sb.append(visitedForumData.getForumName());
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ zx6(a aVar) {
        this();
    }

    public void B(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            this.e = fVar;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f = z;
        }
    }

    public void i(VisitedForumData visitedForumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, visitedForumData) == null) {
            v(visitedForumData);
        }
    }

    public final void v(VisitedForumData visitedForumData) {
        int deleteForumItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, visitedForumData) == null) && visitedForumData != null && (deleteForumItem = this.a.deleteForumItem(visitedForumData)) >= 0) {
            f fVar = this.e;
            if (fVar != null) {
                fVar.b(deleteForumItem);
            }
            A(visitedForumData);
            E();
        }
    }

    public final void y(RecentlyVisitedForumHttpResponseMessage recentlyVisitedForumHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, recentlyVisitedForumHttpResponseMessage) == null) && recentlyVisitedForumHttpResponseMessage != null && recentlyVisitedForumHttpResponseMessage.getForumData() != null) {
            D(recentlyVisitedForumHttpResponseMessage.getForumData(), false);
        }
    }

    public static zx6 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return g.a;
        }
        return (zx6) invokeV.objValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.b) {
            return;
        }
        ru5.b(new a(this), null);
    }

    @Nullable
    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public RecentlyVisitedForumData k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (RecentlyVisitedForumData) invokeV.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.b = true;
            this.g = TbadkCoreApplication.getCurrentAccount();
            b bVar = new b(this);
            bVar.setPriority(3);
            bVar.execute(new Void[0]);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.c) {
            return;
        }
        RecentlyVisitedForumRequestMessage recentlyVisitedForumRequestMessage = new RecentlyVisitedForumRequestMessage();
        recentlyVisitedForumRequestMessage.setForumData(this.a.getForumData());
        this.c = MessageManager.getInstance().sendMessage(recentlyVisitedForumRequestMessage);
    }

    public void u() {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (fVar = this.e) != null) {
            fVar.a(this.a.getForumData(), this.d);
        }
    }

    public void x() {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (fVar = this.e) != null) {
            fVar.onNotify();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            MessageManager.getInstance().registerListener(this.j);
            MessageManager.getInstance().registerListener(this.h);
            MessageManager.getInstance().registerListener(this.i);
        }
    }

    public final void A(VisitedForumData visitedForumData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, visitedForumData) != null) || !TbadkCoreApplication.isLogin()) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_HISTORY_FORUM);
        httpMessage.addParam("forum_id", JavaTypesHelper.toLong(visitedForumData.getForumId(), 0L));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Nullable
    public VisitedForumData q(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            RecentlyVisitedForumData k = k();
            if (k != null && !TextUtils.isEmpty(str)) {
                Iterator<VisitedForumData> it = k.getForumData().iterator();
                while (it.hasNext()) {
                    VisitedForumData next = it.next();
                    if (str.equals(next.getForumId())) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (VisitedForumData) invokeL.objValue;
    }

    public final void w(VisitedForumData visitedForumData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, visitedForumData) != null) || visitedForumData == null) {
            return;
        }
        this.a.addForumItem(visitedForumData);
        this.a.trimSize(20);
        u();
        E();
        o().s();
        f0a.a().d(visitedForumData.getForumId());
    }

    public final void D(LinkedList<VisitedForumData> linkedList, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048579, this, linkedList, z) != null) || linkedList == null) {
            return;
        }
        this.a.setForumData(linkedList);
        this.a.trimSize(20);
        this.d = z;
        if (this.f) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921504, null));
            this.f = false;
        }
        u();
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            RecentlyVisitedForumData recentlyVisitedForumData = this.a;
            if (recentlyVisitedForumData != null && recentlyVisitedForumData.getForumData() != null && this.a.getForumData().size() >= 1) {
                ArrayList<VisitedForumData> arrayList = new ArrayList(this.a.getForumData());
                JSONArray jSONArray = new JSONArray();
                for (VisitedForumData visitedForumData : arrayList) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("forum_id", JavaTypesHelper.toLong(visitedForumData.getForumId(), 0L));
                        jSONObject.put("visit_time", visitedForumData.getVisitedTime());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public JSONArray p() {
        InterceptResult invokeV;
        Object obj;
        Object obj2;
        Object jsonObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            RecentlyVisitedForumData recentlyVisitedForumData = this.a;
            if (recentlyVisitedForumData != null && recentlyVisitedForumData.getForumData() != null && !ListUtils.isEmpty(this.a.getForumData())) {
                ArrayList<VisitedForumData> arrayList = new ArrayList(this.a.getForumData());
                JSONArray jSONArray = new JSONArray();
                for (VisitedForumData visitedForumData : arrayList) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, visitedForumData.getForumName());
                        jSONObject.put("forumId", visitedForumData.getForumId());
                        jSONObject.put("avatar", visitedForumData.getForumImageUrl());
                        jSONObject.put("visitTime", visitedForumData.getVisitedTime());
                        String str = "1";
                        if (visitedForumData.isAlaForum()) {
                            obj = "1";
                        } else {
                            obj = "0";
                        }
                        jSONObject.put("isLiveForum", obj);
                        jSONObject.put("level", visitedForumData.getLevel());
                        jSONObject.put("followNumber", visitedForumData.getFollowNumber());
                        if (visitedForumData.isCanPost()) {
                            obj2 = "1";
                        } else {
                            obj2 = "0";
                        }
                        jSONObject.put("isCanPost", obj2);
                        jSONObject.put("blockInfo", visitedForumData.getBlockInfo());
                        if (visitedForumData.getPostPrefix() == null) {
                            jsonObject = "";
                        } else {
                            jsonObject = visitedForumData.getPostPrefix().toJsonObject();
                        }
                        jSONObject.put("postPrefix", jsonObject);
                        JSONArray jSONArray2 = new JSONArray();
                        if (visitedForumData.getTabInfoList() != null && visitedForumData.getTabInfoList().size() > 0) {
                            for (FrsTabItemData frsTabItemData : visitedForumData.getTabInfoList()) {
                                jSONArray2.put(frsTabItemData.toJsonObject());
                            }
                        }
                        jSONObject.put("tabInfoList", jSONArray2);
                        if (!visitedForumData.isIsLike()) {
                            str = "0";
                        }
                        jSONObject.put("isLike", str);
                        jSONObject.put("dayThreadNum", visitedForumData.getDayThreadNum());
                        jSONObject.put("firstCategory", visitedForumData.firstCategory);
                        jSONObject.put("threadNum", visitedForumData.mThreadNum);
                        jSONObject.put("postNum", visitedForumData.getPostNum());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }
            return new JSONArray();
        }
        return (JSONArray) invokeV.objValue;
    }

    public void t(@Nullable ForumData forumData, @Nullable ForumTagInfo forumTagInfo, @Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048591, this, forumData, forumTagInfo, str) != null) || forumData == null) {
            return;
        }
        VisitedForumData visitedForumData = new VisitedForumData(forumData.getId(), forumData.getName(), forumData.getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(forumData.special_forum_type), forumData.getThemeColorInfo(), forumData.getMember_num(), forumTagInfo, str, forumData.getPost_num());
        visitedForumData.mThreadNum = forumData.getThread_num();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, visitedForumData));
    }
}
