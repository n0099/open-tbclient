package com.baidu.tieba.setting.im.more;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.bj9;
import com.baidu.tieba.fb;
import com.baidu.tieba.h25;
import com.baidu.tieba.o65;
import com.baidu.tieba.q25;
import com.baidu.tieba.setting.ForbiddenForumActivityConfig;
import com.baidu.tieba.setting.PrivacyPermissionActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.zi9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bj9 a;
    public zi9 b;
    public boolean c;
    public ArrayList<q25> d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public MsgRemindModel m;
    public h25 n;
    public bj9.b o;
    public HttpMessageListener p;
    public fb q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public MsgRemindModel.f t;

    /* loaded from: classes7.dex */
    public class a implements bj9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecretSettingActivity a;

        public a(SecretSettingActivity secretSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = secretSettingActivity;
        }

        @Override // com.baidu.tieba.bj9.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SecretSettingActivity secretSettingActivity = this.a;
                secretSettingActivity.Y1("reply", secretSettingActivity.getPageContext().getString(R.string.privacy_setting_thread_reply_decs));
            }
        }

        @Override // com.baidu.tieba.bj9.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.sendMessage(new CustomMessage(2002001, new ForbiddenForumActivityConfig(this.a.getPageContext().getPageActivity())));
            }
        }

        @Override // com.baidu.tieba.bj9.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                SecretSettingActivity secretSettingActivity = this.a;
                secretSettingActivity.Y1("live", secretSettingActivity.getPageContext().getString(R.string.ala_setting_security_mylive));
            }
        }

        @Override // com.baidu.tieba.bj9.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                SecretSettingActivity secretSettingActivity = this.a;
                secretSettingActivity.Y1("group", secretSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f10c1));
                TiebaStatic.log("c10652");
            }
        }

        @Override // com.baidu.tieba.bj9.b
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.a.sendMessage(new CustomMessage(2002001, new PrivacyPermissionActivityConfig(this.a.getPageContext().getPageActivity())));
            }
        }

        @Override // com.baidu.tieba.bj9.b
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                SecretSettingActivity secretSettingActivity = this.a;
                secretSettingActivity.Y1("like", secretSettingActivity.getPageContext().getString(R.string.my_attention_bar));
                TiebaStatic.log("c12514");
            }
        }

        @Override // com.baidu.tieba.bj9.b
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{TbConfig.URL_RECOMMEND_SETTING});
            }
        }

        @Override // com.baidu.tieba.bj9.b
        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) {
                return;
            }
            this.a.W1();
        }

        @Override // com.baidu.tieba.bj9.b
        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.getPageContext(), new String[]{o65.m().s("sync_ad_privacy_url", "")}, false);
            }
        }

        @Override // com.baidu.tieba.bj9.b
        public void onBackPressed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.a.finish();
            }
        }

        @Override // com.baidu.tieba.bj9.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                PrivacyMarkActivityConfig privacyMarkActivityConfig = new PrivacyMarkActivityConfig(this.a.getPageContext().getPageActivity());
                privacyMarkActivityConfig.setMarkState(this.a.k, this.a.l);
                this.a.sendMessage(new CustomMessage(2002001, privacyMarkActivityConfig));
                TiebaStatic.log(new StatisticItem("c14002").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecretSettingActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SecretSettingActivity secretSettingActivity, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = secretSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null) {
                return;
            }
            this.a.hideProgressBar();
            if (!(httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                return;
            }
            PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
            String operation = privacySettingMessage.getOperation();
            int type = privacySettingMessage.getType();
            if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                BdTopToast bdTopToast = new BdTopToast(this.a);
                bdTopToast.h(true);
                bdTopToast.g(this.a.getString(R.string.block_user_success));
                bdTopToast.i((ViewGroup) this.a.findViewById(16908290));
                if (!TextUtils.equals("location", operation)) {
                    this.a.b.n(operation, type);
                    this.a.a.e0(operation, type);
                    return;
                }
                return;
            }
            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0db6);
            } else {
                errorString = httpResponsedMessage.getErrorString();
            }
            BdTopToast bdTopToast2 = new BdTopToast(this.a);
            bdTopToast2.h(false);
            bdTopToast2.g(errorString);
            bdTopToast2.i((ViewGroup) this.a.findViewById(16908290));
            SecretSettingActivity secretSettingActivity = this.a;
            secretSettingActivity.Z1(secretSettingActivity.b);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends fb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecretSettingActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SecretSettingActivity secretSettingActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = secretSettingActivity;
        }

        @Override // com.baidu.tieba.fb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.hideProgressBar();
                if (responsedMessage != null) {
                    this.a.c = true;
                    if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                        zi9 zi9Var = null;
                        if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                            zi9Var = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                        }
                        if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                            zi9Var = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                        }
                        if (zi9Var == null) {
                            return;
                        }
                        this.a.b.l(zi9Var);
                        this.a.b.m();
                        this.a.a.c0(true);
                        this.a.a.f0(this.a.b);
                        SecretSettingActivity secretSettingActivity = this.a;
                        secretSettingActivity.Z1(secretSettingActivity.b);
                        TbadkCoreApplication.getInst().setLocationShared(this.a.b.j());
                        return;
                    }
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0db6);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    this.a.showToast(errorString);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecretSettingActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SecretSettingActivity secretSettingActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity, Integer.valueOf(i)};
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
            this.a = secretSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                o65 m = o65.m();
                int n = m.n(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
                o65 m2 = o65.m();
                int n2 = m2.n("bazhu_show_outside" + currentAccount, 0);
                this.a.k = n;
                this.a.l = n2;
                this.a.a.d0(n, n2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ SecretSettingActivity b;

        public e(SecretSettingActivity secretSettingActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = secretSettingActivity;
            this.a = str;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.b.showProgressBar();
                String b = ((q25) this.b.d.get(i)).b();
                int i2 = 7;
                if (!"showAll".equals(b)) {
                    if (!"friendOnly".equals(b)) {
                        if (!"hideAll".equals(b)) {
                            if (!"my_fans_reply".equals(b)) {
                                if (!"my_attention_reply".equals(b)) {
                                    if (!"myselfOnly".equals(b)) {
                                        i2 = 0;
                                    } else {
                                        this.b.X1(this.a, 7);
                                    }
                                } else {
                                    this.b.X1(this.a, 6);
                                    i2 = 6;
                                }
                            } else {
                                this.b.X1(this.a, 5);
                                i2 = 5;
                            }
                        } else {
                            this.b.X1(this.a, 3);
                            i2 = 3;
                        }
                    } else {
                        this.b.X1(this.a, 2);
                        i2 = 2;
                    }
                } else {
                    this.b.X1(this.a, 1);
                    i2 = 1;
                }
                this.b.n.h(i);
                if ("group".equals(this.a)) {
                    this.b.g = i2;
                } else if (CommandUBCHelper.COMMAND_UBC_SOURCE_SEND.equals(this.a)) {
                    this.b.f = i2;
                } else if ("like".equals(this.a)) {
                    this.b.e = i2;
                } else if ("live".equals(this.a)) {
                    this.b.h = i2;
                } else if ("reply".equals(this.a)) {
                    this.b.i = i2;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecretSettingActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SecretSettingActivity secretSettingActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity, Integer.valueOf(i)};
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
            this.a = secretSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.b.y(((Integer) customResponsedMessage.getData()).intValue());
                this.a.a.f0(this.a.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements MsgRemindModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecretSettingActivity a;

        public g(SecretSettingActivity secretSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = secretSettingActivity;
        }

        @Override // com.baidu.tieba.setting.model.MsgRemindModel.f
        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (i == 8) {
                    if (!z) {
                        if (z2) {
                            this.a.a.V().j();
                            this.a.a.b0(false);
                            return;
                        }
                        this.a.a.V().m();
                        this.a.a.b0(true);
                    }
                } else if (i == 9 && !z) {
                    if (z2) {
                        this.a.a.W().j();
                    } else {
                        this.a.a.W().m();
                    }
                }
            }
        }
    }

    public SecretSettingActivity() {
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
        this.c = false;
        this.o = new a(this);
        this.p = new b(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.q = new c(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
        this.r = new d(this, 2921499);
        this.s = new f(this, 2921065);
        this.t = new g(this);
    }

    public final void U1(BdSwitchView.SwitchState switchState, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, switchState, i) == null) {
            V1(switchState, i, "");
        }
    }

    public final void X1(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            sendMessage(new PrivacySettingMessage(str, i));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(i);
            h25 h25Var = this.n;
            if (h25Var != null) {
                h25Var.g();
            }
        }
    }

    public final ArrayList<q25> R1(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            ArrayList<q25> arrayList = new ArrayList<>();
            String string = getPageContext().getString(R.string.info_privacy_all);
            boolean z2 = false;
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            arrayList.add(new q25(string, "", z, "showAll"));
            String string2 = getPageContext().getString(R.string.info_privacy_hide);
            if (i == 3) {
                z2 = true;
            }
            arrayList.add(new q25(string2, "", z2, "hideAll"));
            return arrayList;
        }
        return (ArrayList) invokeI.objValue;
    }

    public final ArrayList<q25> S1(int i) {
        InterceptResult invokeI;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            ArrayList<q25> arrayList = new ArrayList<>();
            String string = getPageContext().getString(R.string.info_privacy_all);
            boolean z3 = false;
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            arrayList.add(new q25(string, "", z, "showAll"));
            String string2 = getPageContext().getString(R.string.info_privacy_friend);
            if (i == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new q25(string2, "", z2, "friendOnly"));
            String string3 = getPageContext().getString(R.string.info_privacy_hide);
            if (i == 3) {
                z3 = true;
            }
            arrayList.add(new q25(string3, "", z3, "hideAll"));
            return arrayList;
        }
        return (ArrayList) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = new bj9(this);
            this.b = new zi9();
            this.a.a0(this.o);
            this.m = new MsgRemindModel(getPageContext());
            if (this.b.k()) {
                this.a.c0(true);
                this.a.f0(this.b);
                Z1(this.b);
            } else {
                this.a.c0(false);
            }
            registerListener(this.q);
            registerListener(this.p);
            registerListener(this.s);
            registerListener(this.r);
            sendMessage(new PrivateInfoNetMessage());
        }
    }

    public final ArrayList<q25> T1(int i, int i2) {
        InterceptResult invokeII;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
            ArrayList<q25> arrayList = new ArrayList<>();
            String string = getPageContext().getString(R.string.all_person);
            boolean z4 = false;
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            arrayList.add(new q25(string, "", z, "showAll"));
            String string2 = getPageContext().getString(R.string.my_fans);
            if (i == 5) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new q25(string2, "", z2, "my_fans_reply"));
            String string3 = getPageContext().getString(R.string.my_attentions);
            if (i == 6) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new q25(string3, "", z3, "my_attention_reply"));
            if (i2 == 1) {
                String string4 = getPageContext().getString(R.string.myself_only);
                if (i == 7) {
                    z4 = true;
                }
                arrayList.add(new q25(string4, "", z4, "myselfOnly"));
            }
            return arrayList;
        }
        return (ArrayList) invokeII.objValue;
    }

    public final void V1(BdSwitchView.SwitchState switchState, int i, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, switchState, i, str) == null) {
            int i3 = 1;
            if (switchState == BdSwitchView.SwitchState.ON) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this).areNotificationsEnabled();
            StatisticItem param = new StatisticItem("c13889").param("obj_locate", 2);
            if (!areNotificationsEnabled) {
                i3 = 2;
            }
            StatisticItem param2 = param.param("obj_type", i3);
            StatisticItem param3 = param2.param("obj_source", i + "_" + i2);
            if (i == 9 && !TextUtils.isEmpty(str)) {
                param3.param("obj_param1", str);
            }
            TiebaStatic.log(param3);
        }
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(getPageContext().getPageActivity(), "UserBlacklistPage", null)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            h25 h25Var = this.n;
            if (h25Var != null) {
                h25Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResourceRecycle();
            this.a.Z();
        }
    }

    public final void Y1(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, str, str2) != null) || !this.c) {
            return;
        }
        if ("group".equals(str)) {
            this.d = S1(this.g);
        } else if (CommandUBCHelper.COMMAND_UBC_SOURCE_SEND.equals(str)) {
            this.d = S1(this.f);
        } else if ("like".equals(str)) {
            this.d = S1(this.e);
        } else if ("live".equals(str)) {
            this.d = R1(this.h);
        } else if ("reply".equals(str)) {
            this.d = T1(this.i, this.j);
        }
        h25 h25Var = this.n;
        if (h25Var != null) {
            h25Var.d();
        }
        h25 h25Var2 = new h25(getPageContext());
        this.n = h25Var2;
        h25Var2.m(str2);
        h25 h25Var3 = this.n;
        h25Var3.k(this.d, new e(this, str));
        h25Var3.m(str2);
        h25 h25Var4 = this.n;
        h25Var4.c();
        h25Var4.n();
    }

    public final void Z1(zi9 zi9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zi9Var) == null) {
            this.e = zi9Var.c();
            this.f = zi9Var.i();
            this.g = zi9Var.d();
            this.h = zi9Var.e();
            this.i = zi9Var.g();
            this.j = zi9Var.h();
            this.k = zi9Var.a();
            this.l = zi9Var.b();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void d0(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view2, switchState) == null) {
            if (view2 == this.a.V()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.m.Z(8, true, this.t);
                    this.a.b0(true);
                } else {
                    this.m.Z(8, false, this.t);
                    this.a.b0(false);
                }
                U1(switchState, 5);
            } else if (view2 == this.a.W()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.m.Z(9, true, this.t);
                } else {
                    this.m.Z(9, false, this.t);
                }
                U1(switchState, 6);
            }
        }
    }
}
