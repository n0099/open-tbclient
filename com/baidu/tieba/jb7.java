package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.z25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class jb7 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jb7 c;
    public transient /* synthetic */ FieldHolder $fh;
    public List a;
    public final CustomMessageListener b;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jb7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(jb7 jb7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb7Var, Integer.valueOf(i)};
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
            this.a = jb7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                this.a.s(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.r(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.t(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                if (this.a.a != null) {
                    this.a.a.clear();
                }
                o25.h0().g0(new z25());
                o25.h0().b0(0);
                o25.h0().a();
                o25.h0().k();
            } else if (customResponsedMessage.getCmd() == 2016010 && this.a.a != null) {
                this.a.u(false);
            }
        }
    }

    public jb7() {
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
        this.a = new LinkedList();
        this.b = new a(this, 0);
        v();
    }

    public final void g(ImMessageCenterPojo imMessageCenterPojo, z25 z25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterPojo, z25Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && tb7.a().b()) {
            z25Var.Q(imMessageCenterPojo.getUnread_count());
        }
    }

    public final void j(ImMessageCenterPojo imMessageCenterPojo, z25 z25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, imMessageCenterPojo, z25Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && wb7.a().b()) {
            z25Var.V(imMessageCenterPojo.getUnread_count());
        }
    }

    public final void k(ImMessageCenterPojo imMessageCenterPojo, z25 z25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, imMessageCenterPojo, z25Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            z25Var.N(imMessageCenterPojo.getUnread_count());
            z25Var.G(imMessageCenterPojo.getLast_content());
            z25Var.B(imMessageCenterPojo.getGroup_name());
        }
    }

    public final void o(ImMessageCenterPojo imMessageCenterPojo, List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imMessageCenterPojo, list) == null) && imMessageCenterPojo != null && list != null) {
            w(imMessageCenterPojo, list);
            list.add(imMessageCenterPojo);
        }
    }

    public final boolean f(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null) {
                return false;
            }
            if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static jb7 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (c == null) {
                synchronized (jb7.class) {
                    if (c == null) {
                        c = new jb7();
                    }
                }
            }
            return c;
        }
        return (jb7) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(ImMessageCenterPojo imMessageCenterPojo, z25 z25Var) {
        int userType;
        String str;
        String str2;
        String str3;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo, z25Var) != null) || imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != 4 || !ub7.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) || StringUtils.isNull(imMessageCenterPojo.getLast_content()) || imMessageCenterPojo.getUnread_count() <= 0 || (userType = imMessageCenterPojo.getUserType()) == 3) {
            return;
        }
        z25.a aVar = new z25.a();
        aVar.a = imMessageCenterPojo.getGid();
        aVar.e = imMessageCenterPojo.getGroup_name();
        if (userType == 4) {
            String str4 = null;
            try {
                jSONArray = new JSONArray(imMessageCenterPojo.getLastContentRawData());
            } catch (Exception e) {
                e = e;
                str = null;
                str2 = null;
            }
            if (jSONArray.length() == 1) {
                JSONObject jSONObject = jSONArray.getJSONObject(0);
                str = jSONObject.optString("title", null);
                try {
                    str2 = jSONObject.optString("text", null);
                } catch (Exception e2) {
                    e = e2;
                    str2 = null;
                }
                try {
                    str3 = jSONObject.optString(UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY, null);
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e, true);
                    str3 = null;
                    str4 = str;
                    if (str2 == null) {
                    }
                    if (str4 == null) {
                    }
                    aVar.b = str4;
                    aVar.c = str2;
                    aVar.i = str3;
                    aVar.d = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
                    aVar.f = userType;
                    aVar.g = imMessageCenterPojo.getUnread_count();
                    z25Var.g().add(aVar);
                    if (userType == 4) {
                    }
                    z25Var.R(z25Var.u() + imMessageCenterPojo.getUnread_count());
                }
                str4 = str;
                if (str2 == null) {
                    str4 = imMessageCenterPojo.getGroup_name();
                    str2 = imMessageCenterPojo.getLast_content();
                }
                if (str4 == null) {
                    str4 = imMessageCenterPojo.getGroup_name();
                }
                aVar.b = str4;
                aVar.c = str2;
                aVar.i = str3;
                aVar.d = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
            } else {
                str3 = null;
                str2 = null;
                if (str2 == null) {
                }
                if (str4 == null) {
                }
                aVar.b = str4;
                aVar.c = str2;
                aVar.i = str3;
                aVar.d = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
            }
        } else {
            String str5 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f03de, imMessageCenterPojo.getGroup_name()) + ZeusCrashHandler.NAME_SEPERATOR + imMessageCenterPojo.getLast_content();
            aVar.c = str5;
            aVar.d = str5;
        }
        aVar.f = userType;
        aVar.g = imMessageCenterPojo.getUnread_count();
        z25Var.g().add(aVar);
        if (userType == 4) {
            z25Var.P(z25Var.s() + imMessageCenterPojo.getUnread_count());
        }
        z25Var.R(z25Var.u() + imMessageCenterPojo.getUnread_count());
    }

    public final void i(ImMessageCenterPojo imMessageCenterPojo, z25 z25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, imMessageCenterPojo, z25Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && vb7.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                z25Var.F(imMessageCenterPojo.getLast_content());
                String nameShow = imMessageCenterPojo.getNameShow();
                HashMap h = z25Var.h();
                if (h != null) {
                    h.put(imMessageCenterPojo.getGid(), nameShow);
                }
            }
            z25Var.T(z25Var.w() + imMessageCenterPojo.getUnread_count());
        }
    }

    public final void m(List list, List list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, list, list2) == null) && list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                z25.a aVar = (z25.a) it.next();
                if (aVar != null) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        z25.a aVar2 = (z25.a) it2.next();
                        if (aVar2 != null && StringHelper.equals(aVar.a, aVar2.a)) {
                            aVar.h = aVar2.g;
                        }
                    }
                }
            }
        }
    }

    public final void l(ImMessageCenterPojo imMessageCenterPojo, z25 z25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, imMessageCenterPojo, z25Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap a2 = z25Var.a();
            if (!sb7.k().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                z25Var.K(z25Var.l() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    z25Var.E(imMessageCenterPojo.getLast_content());
                } else {
                    z25Var.E(imMessageCenterPojo.getLast_user_name() + ":" + imMessageCenterPojo.getLast_content());
                }
                a2.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            z25Var.J(z25Var.j() + imMessageCenterPojo.getUnread_count());
        }
    }

    public final boolean p(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null) {
                return false;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                return f(imMessageCenterPojo);
            }
            if (imMessageCenterPojo.getCustomGroupType() == -4) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 4) {
                return f(imMessageCenterPojo);
            }
            if (imMessageCenterPojo.getCustomGroupType() == -8) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                return f(imMessageCenterPojo);
            }
            if (imMessageCenterPojo.getCustomGroupType() != -7) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean q(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
                return vb7.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            }
            if (imMessageCenterPojo.getCustomGroupType() == 1 || imMessageCenterPojo.getCustomGroupType() != 4) {
                return false;
            }
            return ub7.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        return invokeL.booleanValue;
    }

    public final void x(z25 z25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, z25Var) != null) || z25Var == null) {
            return;
        }
        for (ImMessageCenterPojo imMessageCenterPojo : this.a) {
            if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && p(imMessageCenterPojo)) {
                l(imMessageCenterPojo, z25Var);
                h(imMessageCenterPojo, z25Var);
                i(imMessageCenterPojo, z25Var);
                k(imMessageCenterPojo, z25Var);
                g(imMessageCenterPojo, z25Var);
                j(imMessageCenterPojo, z25Var);
            }
        }
    }

    public final void r(CustomResponsedMessage customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof MemoryChangedMessage)) {
            return;
        }
        MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
        ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) memoryChangedMessage.getData();
        boolean q = q(imMessageCenterPojo);
        if (memoryChangedMessage.getType() == 1) {
            o(imMessageCenterPojo, this.a);
        } else if (memoryChangedMessage.getType() == 2) {
            w(imMessageCenterPojo, this.a);
        }
        u(q);
    }

    public final void s(CustomResponsedMessage customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((Boolean) ((MemoryInitCompleteMessage) customResponsedMessage).getData()).booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void t(CustomResponsedMessage customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            return;
        }
        ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
        List<ImMessageCenterPojo> list = (List) responsedMemoryListMessage.getData();
        if (responsedMemoryListMessage.getType() == 1) {
            this.a.clear();
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (p(imMessageCenterPojo)) {
                    this.a.add(imMessageCenterPojo);
                }
            }
        }
    }

    public final void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            z25 z25Var = new z25();
            z25Var.I(z);
            x(z25Var);
            z25Var.C();
            z25Var.D();
            z25Var.U(o25.h0().E().w());
            z25Var.L(o25.h0().E().k());
            z25Var.S(o25.h0().E().u());
            z25Var.O(o25.h0().E().q());
            z25Var.M(o25.h0().E().n());
            m(z25Var.g(), o25.h0().E().g());
            if (!q25.d().s()) {
                z25Var.J(0);
            }
            if (!q25.d().u()) {
                z25Var.T(0);
            }
            if (!q25.d().n()) {
                z25Var.R(0);
                z25Var.Q(0);
                z25Var.P(0);
            }
            if (q25.d().f() <= 0) {
                z25Var.J(0);
                z25Var.T(0);
                z25Var.Q(0);
                z25Var.R(0);
                z25Var.P(0);
                z25Var.V(0);
                z25Var.I(false);
            }
            if ((((((z25Var.w() + z25Var.j()) + z25Var.n()) + z25Var.q()) + z25Var.t()) + z25Var.u()) - z25Var.l() <= 0) {
                z25Var.I(false);
            }
            o25.h0().V(z25Var);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageManager.getInstance().registerListener(2016004, this.b);
            MessageManager.getInstance().registerListener(2016007, this.b);
            MessageManager.getInstance().registerListener(2016001, this.b);
            MessageManager.getInstance().registerListener(2016010, this.b);
            MessageManager.getInstance().registerListener(2016002, this.b);
        }
    }

    public final void w(ImMessageCenterPojo imMessageCenterPojo, List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, imMessageCenterPojo, list) == null) && imMessageCenterPojo != null && list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ImMessageCenterPojo imMessageCenterPojo2 = (ImMessageCenterPojo) list.get(i);
                if (imMessageCenterPojo2 != null && imMessageCenterPojo2.getGid().equals(imMessageCenterPojo.getGid()) && imMessageCenterPojo2.getCustomGroupType() == imMessageCenterPojo.getCustomGroupType()) {
                    list.remove(i);
                    return;
                }
            }
        }
    }
}
