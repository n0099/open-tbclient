package com.baidu.tieba;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserTropicGiftBagActivityConfig;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tieba.ov4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes7.dex */
public class p95 {
    public static /* synthetic */ Interceptable $ic;
    public static p95 i;
    public static CustomMessageListener j;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public NewUserRedPackageData f;
    public CustomMessageListener g;
    public final qg<in> h;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p95 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(p95 p95Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p95Var, Integer.valueOf(i)};
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
            this.a = p95Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ShareEvent) && ((ShareEvent) customResponsedMessage.getData()).status == 1) {
                vf5.d(((ShareEvent) customResponsedMessage.getData()).channel);
                this.a.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                TbSingleton.getInstance().setCanWebViewActivityShowProgress(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends qg<in> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p95 a;

        public c(p95 p95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p95Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qg
        public void onLoaded(in inVar, String str, int i) {
            Activity currentActivity;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLI(1048576, this, inVar, str, i) != null) || inVar == null || this.a.f == null || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || this.a.d(currentActivity) == null) {
                return;
            }
            TbSingleton.getInstance().setNewUserRedPackageData(this.a.f);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921532));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948016893, "Lcom/baidu/tieba/p95;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948016893, "Lcom/baidu/tieba/p95;");
                return;
            }
        }
        j = new b(2921440);
    }

    public static p95 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (i == null) {
                synchronized (p95.class) {
                    if (i == null) {
                        i = new p95();
                    }
                }
            }
            return i;
        }
        return (p95) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().registerListener(this.g);
            MessageManager.getInstance().registerListener(j);
        }
    }

    public p95() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new a(this, 2921406);
        this.h = new c(this);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            r95.p().Q("task_share_thread_success_data_total_limit");
            r95.p().Q("task_share_thread_success_data_mission_id");
            r95.p().Q("task_share_thread_success_data_action_id");
            r95.p().Q("task_share_thread_success_data_specific_clear_time");
        }
    }

    public void i() {
        Activity currentActivity;
        TbPageContext d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (d = d(currentActivity)) != null && h9.f().h("MainTabActivity")) {
            d.sendMessage(new CustomMessage(2002001, new UserTropicGiftBagActivityConfig(d.getPageActivity())));
        }
    }

    public final TbPageContext d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(5);
            completeTaskReqMsg.completeId = str;
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            completeTaskReqMsg.extra = new ov4.g();
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        }
    }

    public void g(MissionInfo missionInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, missionInfo) == null) && missionInfo != null && missionInfo.activityid.intValue() != 0 && missionInfo.missionid.intValue() != 0) {
            this.c = missionInfo.activityid.intValue();
            this.a = missionInfo.missionid.intValue();
            this.b = missionInfo.total_limit.intValue();
            this.e = missionInfo.cleartype.intValue();
            this.d = missionInfo.cleartime.intValue();
            hu4 hu4Var = new hu4();
            hu4Var.Y(this.d);
            hu4Var.Z(this.e);
            r95.p().F("task_share_thread_success_data_total_limit", this.b);
            r95.p().F("task_share_thread_success_data_mission_id", this.a);
            r95.p().F("task_share_thread_success_data_action_id", this.c);
            r95.p().H("task_share_thread_success_data_specific_clear_time", hu4Var.c());
        }
    }

    public void j(hv4 hv4Var) {
        Activity currentActivity;
        TbPageContext d;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, hv4Var) != null) || hv4Var == null) {
            return;
        }
        ActiveCenterData activeCenterData = hv4Var.g;
        if ((activeCenterData != null && activeCenterData.is_new_window) || r95.p().q("app_restart_times", 0) <= 1 || !hv4Var.b || StringUtils.isNull(hv4Var.c) || TbSingleton.getInstance().isNewUserRedPackageShowed() || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (d = d(currentActivity)) == null) {
            return;
        }
        this.f = hv4Var.f;
        rg.h().k(this.f.topPicUrl, 10, this.h, 0, 0, d.getUniqueId(), new Object[0]);
    }

    public void k() {
        int q;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !TbadkCoreApplication.isLogin()) {
            return;
        }
        int q2 = r95.p().q("task_share_thread_success_data_mission_id", 0);
        int q3 = r95.p().q("task_share_thread_success_data_action_id", 0);
        long r = r95.p().r("task_share_thread_success_data_specific_clear_time", 0L);
        hu4 hu4Var = new hu4();
        hu4Var.e0(r);
        if (hu4Var.N()) {
            c();
        } else if (q3 != 0 && q2 != 0 && (q = r95.p().q("task_share_thread_success_data_total_limit", 0)) > 0) {
            r95.p().F("task_share_thread_success_data_total_limit", q - 1);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(String.valueOf(q3), String.valueOf(q2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            h(jSONObject.toString());
        }
    }
}
