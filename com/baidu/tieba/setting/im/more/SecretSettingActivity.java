package com.baidu.tieba.setting.im.more;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.ForbiddenForumActivityConfig;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.PrivacyPermissionActivityConfig;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.s.n;
import d.a.p0.h3.h0.m;
import d.a.p0.z2.b.a.c;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String POSITION_FRIEND_ONLY_TAG = "friendOnly";
    public static final String POSITION_HIDE_ALL_TAG = "hideAll";
    public static final String POSITION_MYSELF_ONLY_TAG = "myselfOnly";
    public static final String POSITION_REPLY_ATTENTIONS_TAG = "my_attention_reply";
    public static final String POSITION_REPLY_FANS_TAG = "my_fans_reply";
    public static final String POSITION_SHOW_ALL_TAG = "showAll";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean loadSuccess;
    public c.b mCallback;
    public d.a.o0.r.s.e mDialog;
    public ArrayList<n> mMyBar;
    public d.a.c.c.g.a mNetMessageListener;
    public HttpMessageListener mSetPrivateHttpListener;
    public d.a.p0.z2.b.a.a mSetting;
    public CustomMessageListener mThreadPrivacyStatusUpdateListener;
    public d.a.p0.z2.b.a.c mView;
    public CustomMessageListener markUpdateListener;
    public int optionBarSelected;
    public int optionBazhuShowInside;
    public int optionBazhuShowOutside;
    public int optionForumSelected;
    public int optionGroupSelected;
    public int optionLiveSelected;
    public int optionThreadReplySelected;
    public int optionThreadReplyShowMyself;

    /* loaded from: classes4.dex */
    public class a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SecretSettingActivity f20731a;

        public a(SecretSettingActivity secretSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20731a = secretSettingActivity;
        }

        @Override // d.a.p0.z2.b.a.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SecretSettingActivity secretSettingActivity = this.f20731a;
                secretSettingActivity.showResetSettingDialog("reply", secretSettingActivity.getPageContext().getString(R.string.privacy_setting_thread_reply_decs));
            }
        }

        @Override // d.a.p0.z2.b.a.c.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f20731a.sendMessage(new CustomMessage(2002001, new ForbiddenForumActivityConfig(this.f20731a.getPageContext().getPageActivity())));
            }
        }

        @Override // d.a.p0.z2.b.a.c.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                SecretSettingActivity secretSettingActivity = this.f20731a;
                secretSettingActivity.showResetSettingDialog("live", secretSettingActivity.getPageContext().getString(R.string.ala_setting_security_mylive));
            }
        }

        @Override // d.a.p0.z2.b.a.c.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                PrivacyMarkActivityConfig privacyMarkActivityConfig = new PrivacyMarkActivityConfig(this.f20731a.getPageContext().getPageActivity());
                privacyMarkActivityConfig.setMarkState(this.f20731a.optionBazhuShowInside, this.f20731a.optionBazhuShowOutside);
                this.f20731a.sendMessage(new CustomMessage(2002001, privacyMarkActivityConfig));
                TiebaStatic.log(new StatisticItem("c14002").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }

        @Override // d.a.p0.z2.b.a.c.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                SecretSettingActivity secretSettingActivity = this.f20731a;
                secretSettingActivity.showResetSettingDialog("group", secretSettingActivity.getPageContext().getString(R.string.privacy_setting_attention_group));
                TiebaStatic.log("c10652");
            }
        }

        @Override // d.a.p0.z2.b.a.c.b
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f20731a.sendMessage(new CustomMessage(2002001, new PrivacyPermissionActivityConfig(this.f20731a.getPageContext().getPageActivity())));
            }
        }

        @Override // d.a.p0.z2.b.a.c.b
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                SecretSettingActivity secretSettingActivity = this.f20731a;
                secretSettingActivity.showResetSettingDialog("like", secretSettingActivity.getPageContext().getString(R.string.my_attention_bar));
                TiebaStatic.log("c12514");
            }
        }

        @Override // d.a.p0.z2.b.a.c.b
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f20731a.goToBlackListActivity();
            }
        }

        @Override // d.a.p0.z2.b.a.c.b
        public void onBackPressed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.f20731a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SecretSettingActivity f20732a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SecretSettingActivity secretSettingActivity, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20732a = secretSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            this.f20732a.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    BdTopToast bdTopToast = new BdTopToast(this.f20732a);
                    bdTopToast.i(true);
                    bdTopToast.h(this.f20732a.getString(R.string.block_user_success));
                    bdTopToast.j((ViewGroup) this.f20732a.findViewById(16908290));
                    if (TextUtils.equals("location", operation)) {
                        return;
                    }
                    this.f20732a.mSetting.n(operation, type);
                    this.f20732a.mView.t(operation, type);
                    return;
                }
                String string = StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f20732a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString();
                BdTopToast bdTopToast2 = new BdTopToast(this.f20732a);
                bdTopToast2.i(false);
                bdTopToast2.h(string);
                bdTopToast2.j((ViewGroup) this.f20732a.findViewById(16908290));
                SecretSettingActivity secretSettingActivity = this.f20732a;
                secretSettingActivity.updateSelectedOption(secretSettingActivity.mSetting);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SecretSettingActivity f20733a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SecretSettingActivity secretSettingActivity, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f20733a = secretSettingActivity;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f20733a.hideProgressBar();
                if (responsedMessage == null) {
                    return;
                }
                this.f20733a.loadSuccess = true;
                if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    d.a.p0.z2.b.a.a privacyData = responsedMessage instanceof ResponsedPrivacyHttpMessage ? ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData() : null;
                    if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                        privacyData = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                    }
                    if (privacyData == null) {
                        return;
                    }
                    this.f20733a.mSetting.l(privacyData);
                    this.f20733a.mSetting.m();
                    this.f20733a.mView.r(true);
                    this.f20733a.mView.u(this.f20733a.mSetting);
                    SecretSettingActivity secretSettingActivity = this.f20733a;
                    secretSettingActivity.updateSelectedOption(secretSettingActivity.mSetting);
                    TbadkCoreApplication.getInst().setLocationShared(this.f20733a.mSetting.j());
                    return;
                }
                this.f20733a.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.f20733a.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SecretSettingActivity f20734a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SecretSettingActivity secretSettingActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity, Integer.valueOf(i2)};
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
            this.f20734a = secretSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                d.a.o0.r.d0.b j = d.a.o0.r.d0.b.j();
                int k = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
                d.a.o0.r.d0.b j2 = d.a.o0.r.d0.b.j();
                int k2 = j2.k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
                this.f20734a.optionBazhuShowInside = k;
                this.f20734a.optionBazhuShowOutside = k2;
                this.f20734a.mView.s(k, k2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20735e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SecretSettingActivity f20736f;

        public e(SecretSettingActivity secretSettingActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20736f = secretSettingActivity;
            this.f20735e = str;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f20736f.showProgressBar();
                String b2 = ((n) this.f20736f.mMyBar.get(i2)).b();
                int i3 = 7;
                if (SecretSettingActivity.POSITION_SHOW_ALL_TAG.equals(b2)) {
                    this.f20736f.sendSetPrivacyMessage(this.f20735e, 1);
                    i3 = 1;
                } else if (SecretSettingActivity.POSITION_FRIEND_ONLY_TAG.equals(b2)) {
                    this.f20736f.sendSetPrivacyMessage(this.f20735e, 2);
                    i3 = 2;
                } else if (SecretSettingActivity.POSITION_HIDE_ALL_TAG.equals(b2)) {
                    this.f20736f.sendSetPrivacyMessage(this.f20735e, 3);
                    i3 = 3;
                } else if (SecretSettingActivity.POSITION_REPLY_FANS_TAG.equals(b2)) {
                    this.f20736f.sendSetPrivacyMessage(this.f20735e, 5);
                    i3 = 5;
                } else if (SecretSettingActivity.POSITION_REPLY_ATTENTIONS_TAG.equals(b2)) {
                    this.f20736f.sendSetPrivacyMessage(this.f20735e, 6);
                    i3 = 6;
                } else if (SecretSettingActivity.POSITION_MYSELF_ONLY_TAG.equals(b2)) {
                    this.f20736f.sendSetPrivacyMessage(this.f20735e, 7);
                } else {
                    i3 = 0;
                }
                this.f20736f.mDialog.h(i2);
                if ("group".equals(this.f20735e)) {
                    this.f20736f.optionGroupSelected = i3;
                } else if ("post".equals(this.f20735e)) {
                    this.f20736f.optionForumSelected = i3;
                } else if ("like".equals(this.f20735e)) {
                    this.f20736f.optionBarSelected = i3;
                } else if ("live".equals(this.f20735e)) {
                    this.f20736f.optionLiveSelected = i3;
                } else if ("reply".equals(this.f20735e)) {
                    this.f20736f.optionThreadReplySelected = i3;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SecretSettingActivity f20737a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SecretSettingActivity secretSettingActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity, Integer.valueOf(i2)};
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
            this.f20737a = secretSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                this.f20737a.mSetting.y(((Integer) customResponsedMessage.getData()).intValue());
                this.f20737a.mView.u(this.f20737a.mSetting);
            }
        }
    }

    public SecretSettingActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.loadSuccess = false;
        this.mCallback = new a(this);
        this.mSetPrivateHttpListener = new b(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.mNetMessageListener = new c(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
        this.markUpdateListener = new d(this, 2921499);
        this.mThreadPrivacyStatusUpdateListener = new f(this, 2921065);
    }

    private ArrayList<n> createLiveRichDialogList(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, this, i2)) == null) {
            ArrayList<n> arrayList = new ArrayList<>();
            arrayList.add(new n(getPageContext().getString(R.string.info_privacy_all), "", i2 == 1, POSITION_SHOW_ALL_TAG));
            arrayList.add(new n(getPageContext().getString(R.string.info_privacy_hide), "", i2 == 3, POSITION_HIDE_ALL_TAG));
            return arrayList;
        }
        return (ArrayList) invokeI.objValue;
    }

    private ArrayList<n> createRichDialogList(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, this, i2)) == null) {
            ArrayList<n> arrayList = new ArrayList<>();
            arrayList.add(new n(getPageContext().getString(R.string.info_privacy_all), "", i2 == 1, POSITION_SHOW_ALL_TAG));
            arrayList.add(new n(getPageContext().getString(R.string.info_privacy_friend), "", i2 == 2, POSITION_FRIEND_ONLY_TAG));
            arrayList.add(new n(getPageContext().getString(R.string.info_privacy_hide), "", i2 == 3, POSITION_HIDE_ALL_TAG));
            return arrayList;
        }
        return (ArrayList) invokeI.objValue;
    }

    private ArrayList<n> createThreadReplyList(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65558, this, i2, i3)) == null) {
            ArrayList<n> arrayList = new ArrayList<>();
            arrayList.add(new n(getPageContext().getString(R.string.all_person), "", i2 == 1, POSITION_SHOW_ALL_TAG));
            arrayList.add(new n(getPageContext().getString(R.string.my_fans), "", i2 == 5, POSITION_REPLY_FANS_TAG));
            arrayList.add(new n(getPageContext().getString(R.string.my_attentions), "", i2 == 6, POSITION_REPLY_ATTENTIONS_TAG));
            if (i3 == 1) {
                arrayList.add(new n(getPageContext().getString(R.string.myself_only), "", i2 == 7, POSITION_MYSELF_ONLY_TAG));
            }
            return arrayList;
        }
        return (ArrayList) invokeII.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToBlackListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(getPageContext().getPageActivity(), "UserBlacklistPage", null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToUserMuteListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            sendMessage(new CustomMessage(2016302, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSetPrivacyMessage(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65561, this, str, i2) == null) {
            sendMessage(new PrivacySettingMessage(str, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showResetSettingDialog(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65562, this, str, str2) == null) && this.loadSuccess) {
            if ("group".equals(str)) {
                this.mMyBar = createRichDialogList(this.optionGroupSelected);
            } else if ("post".equals(str)) {
                this.mMyBar = createRichDialogList(this.optionForumSelected);
            } else if ("like".equals(str)) {
                this.mMyBar = createRichDialogList(this.optionBarSelected);
            } else if ("live".equals(str)) {
                this.mMyBar = createLiveRichDialogList(this.optionLiveSelected);
            } else if ("reply".equals(str)) {
                this.mMyBar = createThreadReplyList(this.optionThreadReplySelected, this.optionThreadReplyShowMyself);
            }
            d.a.o0.r.s.e eVar = this.mDialog;
            if (eVar != null) {
                eVar.d();
            }
            d.a.o0.r.s.e eVar2 = new d.a.o0.r.s.e(getPageContext());
            this.mDialog = eVar2;
            eVar2.m(str2);
            d.a.o0.r.s.e eVar3 = this.mDialog;
            eVar3.k(this.mMyBar, new e(this, str));
            eVar3.m(str2);
            d.a.o0.r.s.e eVar4 = this.mDialog;
            eVar4.c();
            eVar4.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectedOption(d.a.p0.z2.b.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, aVar) == null) {
            this.optionBarSelected = aVar.c();
            this.optionForumSelected = aVar.i();
            this.optionGroupSelected = aVar.d();
            this.optionLiveSelected = aVar.e();
            this.optionThreadReplySelected = aVar.g();
            this.optionThreadReplyShowMyself = aVar.h();
            this.optionBazhuShowInside = aVar.a();
            this.optionBazhuShowOutside = aVar.b();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.onChangeSkinType(i2);
            d.a.o0.r.s.e eVar = this.mDialog;
            if (eVar != null) {
                eVar.g();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            this.mView = new d.a.p0.z2.b.a.c(this);
            this.mSetting = new d.a.p0.z2.b.a.a();
            this.mView.q(this.mCallback);
            if (this.mSetting.k()) {
                this.mView.r(true);
                this.mView.u(this.mSetting);
                updateSelectedOption(this.mSetting);
            } else {
                this.mView.r(false);
            }
            registerListener(this.mNetMessageListener);
            registerListener(this.mSetPrivateHttpListener);
            registerListener(this.mThreadPrivacyStatusUpdateListener);
            registerListener(this.markUpdateListener);
            sendMessage(new PrivateInfoNetMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            d.a.o0.r.s.e eVar = this.mDialog;
            if (eVar != null) {
                eVar.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResourceRecycle();
            this.mView.p();
        }
    }
}
