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
import com.baidu.tieba.setting.ForbiddenForumActivityConfig;
import com.baidu.tieba.setting.PrivacyPermissionActivityConfig;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.as4;
import com.repackage.iu4;
import com.repackage.rr4;
import com.repackage.uc8;
import com.repackage.wa;
import com.repackage.wc8;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String POSITION_FRIEND_ONLY_TAG = "friendOnly";
    public static final String POSITION_HIDE_ALL_TAG = "hideAll";
    public static final String POSITION_MYSELF_ONLY_TAG = "myselfOnly";
    public static final String POSITION_REPLY_ATTENTIONS_TAG = "my_attention_reply";
    public static final String POSITION_REPLY_FANS_TAG = "my_fans_reply";
    public static final String POSITION_SHOW_ALL_TAG = "showAll";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean loadSuccess;
    public wc8.b mCallback;
    public rr4 mDialog;
    public MsgRemindModel mModel;
    public MsgRemindModel.e mMsgRemindModelCallback;
    public ArrayList<as4> mMyBar;
    public wa mNetMessageListener;
    public HttpMessageListener mSetPrivateHttpListener;
    public uc8 mSetting;
    public CustomMessageListener mThreadPrivacyStatusUpdateListener;
    public wc8 mView;
    public CustomMessageListener markUpdateListener;
    public int optionBarSelected;
    public int optionBazhuShowInside;
    public int optionBazhuShowOutside;
    public int optionForumSelected;
    public int optionGroupSelected;
    public int optionLiveSelected;
    public int optionThreadReplySelected;
    public int optionThreadReplyShowMyself;

    /* loaded from: classes3.dex */
    public class a implements wc8.b {
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

        @Override // com.repackage.wc8.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SecretSettingActivity secretSettingActivity = this.a;
                secretSettingActivity.showResetSettingDialog("reply", secretSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ee7));
            }
        }

        @Override // com.repackage.wc8.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.sendMessage(new CustomMessage(2002001, new ForbiddenForumActivityConfig(this.a.getPageContext().getPageActivity())));
            }
        }

        @Override // com.repackage.wc8.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                SecretSettingActivity secretSettingActivity = this.a;
                secretSettingActivity.showResetSettingDialog("live", secretSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0242));
            }
        }

        @Override // com.repackage.wc8.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                PrivacyMarkActivityConfig privacyMarkActivityConfig = new PrivacyMarkActivityConfig(this.a.getPageContext().getPageActivity());
                privacyMarkActivityConfig.setMarkState(this.a.optionBazhuShowInside, this.a.optionBazhuShowOutside);
                this.a.sendMessage(new CustomMessage(2002001, privacyMarkActivityConfig));
                TiebaStatic.log(new StatisticItem("c14002").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }

        @Override // com.repackage.wc8.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                SecretSettingActivity secretSettingActivity = this.a;
                secretSettingActivity.showResetSettingDialog("group", secretSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ee3));
                TiebaStatic.log("c10652");
            }
        }

        @Override // com.repackage.wc8.b
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.a.sendMessage(new CustomMessage(2002001, new PrivacyPermissionActivityConfig(this.a.getPageContext().getPageActivity())));
            }
        }

        @Override // com.repackage.wc8.b
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                SecretSettingActivity secretSettingActivity = this.a;
                secretSettingActivity.showResetSettingDialog("like", secretSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0b31));
                TiebaStatic.log("c12514");
            }
        }

        @Override // com.repackage.wc8.b
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{TbConfig.URL_RECOMMEND_SETTING});
            }
        }

        @Override // com.repackage.wc8.b
        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.a.goToBlackListActivity();
            }
        }

        @Override // com.repackage.wc8.b
        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.getPageContext(), new String[]{iu4.k().q("sync_ad_privacy_url", "")}, false);
            }
        }

        @Override // com.repackage.wc8.b
        public void onBackPressed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            this.a.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    BdTopToast bdTopToast = new BdTopToast(this.a);
                    bdTopToast.i(true);
                    bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f0319));
                    bdTopToast.j((ViewGroup) this.a.findViewById(16908290));
                    if (TextUtils.equals("location", operation)) {
                        return;
                    }
                    this.a.mSetting.n(operation, type);
                    this.a.mView.B(operation, type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.a);
                bdTopToast2.i(false);
                bdTopToast2.h(errorString);
                bdTopToast2.j((ViewGroup) this.a.findViewById(16908290));
                SecretSettingActivity secretSettingActivity = this.a;
                secretSettingActivity.updateSelectedOption(secretSettingActivity.mSetting);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends wa {
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

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.hideProgressBar();
                if (responsedMessage == null) {
                    return;
                }
                this.a.loadSuccess = true;
                if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    uc8 privacyData = responsedMessage instanceof ResponsedPrivacyHttpMessage ? ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData() : null;
                    if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                        privacyData = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                    }
                    if (privacyData == null) {
                        return;
                    }
                    this.a.mSetting.l(privacyData);
                    this.a.mSetting.m();
                    this.a.mView.z(true);
                    this.a.mView.C(this.a.mSetting);
                    SecretSettingActivity secretSettingActivity = this.a;
                    secretSettingActivity.updateSelectedOption(secretSettingActivity.mSetting);
                    TbadkCoreApplication.getInst().setLocationShared(this.a.mSetting.j());
                    return;
                }
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                this.a.showToast(errorString);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                iu4 k = iu4.k();
                int l = k.l(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
                iu4 k2 = iu4.k();
                int l2 = k2.l(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
                this.a.optionBazhuShowInside = l;
                this.a.optionBazhuShowOutside = l2;
                this.a.mView.A(l, l2);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                String b = ((as4) this.b.mMyBar.get(i)).b();
                int i2 = 7;
                if (SecretSettingActivity.POSITION_SHOW_ALL_TAG.equals(b)) {
                    this.b.sendSetPrivacyMessage(this.a, 1);
                    i2 = 1;
                } else if (SecretSettingActivity.POSITION_FRIEND_ONLY_TAG.equals(b)) {
                    this.b.sendSetPrivacyMessage(this.a, 2);
                    i2 = 2;
                } else if (SecretSettingActivity.POSITION_HIDE_ALL_TAG.equals(b)) {
                    this.b.sendSetPrivacyMessage(this.a, 3);
                    i2 = 3;
                } else if (SecretSettingActivity.POSITION_REPLY_FANS_TAG.equals(b)) {
                    this.b.sendSetPrivacyMessage(this.a, 5);
                    i2 = 5;
                } else if (SecretSettingActivity.POSITION_REPLY_ATTENTIONS_TAG.equals(b)) {
                    this.b.sendSetPrivacyMessage(this.a, 6);
                    i2 = 6;
                } else if (SecretSettingActivity.POSITION_MYSELF_ONLY_TAG.equals(b)) {
                    this.b.sendSetPrivacyMessage(this.a, 7);
                } else {
                    i2 = 0;
                }
                this.b.mDialog.h(i);
                if ("group".equals(this.a)) {
                    this.b.optionGroupSelected = i2;
                } else if ("post".equals(this.a)) {
                    this.b.optionForumSelected = i2;
                } else if ("like".equals(this.a)) {
                    this.b.optionBarSelected = i2;
                } else if ("live".equals(this.a)) {
                    this.b.optionLiveSelected = i2;
                } else if ("reply".equals(this.a)) {
                    this.b.optionThreadReplySelected = i2;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.mSetting.y(((Integer) customResponsedMessage.getData()).intValue());
                this.a.mView.C(this.a.mSetting);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements MsgRemindModel.e {
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

        @Override // com.baidu.tieba.setting.model.MsgRemindModel.e
        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (i != 8) {
                    if (i != 9 || z) {
                        return;
                    }
                    if (z2) {
                        this.a.mView.t().k();
                    } else {
                        this.a.mView.t().n();
                    }
                } else if (z) {
                } else {
                    if (z2) {
                        this.a.mView.s().k();
                        this.a.mView.y(false);
                        return;
                    }
                    this.a.mView.s().n();
                    this.a.mView.y(true);
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
        this.loadSuccess = false;
        this.mCallback = new a(this);
        this.mSetPrivateHttpListener = new b(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.mNetMessageListener = new c(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
        this.markUpdateListener = new d(this, 2921499);
        this.mThreadPrivacyStatusUpdateListener = new f(this, 2921065);
        this.mMsgRemindModelCallback = new g(this);
    }

    private ArrayList<as4> createLiveRichDialogList(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, this, i)) == null) {
            ArrayList<as4> arrayList = new ArrayList<>();
            arrayList.add(new as4(getPageContext().getString(R.string.obfuscated_res_0x7f0f08db), "", i == 1, POSITION_SHOW_ALL_TAG));
            arrayList.add(new as4(getPageContext().getString(R.string.obfuscated_res_0x7f0f08dd), "", i == 3, POSITION_HIDE_ALL_TAG));
            return arrayList;
        }
        return (ArrayList) invokeI.objValue;
    }

    private ArrayList<as4> createRichDialogList(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, this, i)) == null) {
            ArrayList<as4> arrayList = new ArrayList<>();
            arrayList.add(new as4(getPageContext().getString(R.string.obfuscated_res_0x7f0f08db), "", i == 1, POSITION_SHOW_ALL_TAG));
            arrayList.add(new as4(getPageContext().getString(R.string.obfuscated_res_0x7f0f08dc), "", i == 2, POSITION_FRIEND_ONLY_TAG));
            arrayList.add(new as4(getPageContext().getString(R.string.obfuscated_res_0x7f0f08dd), "", i == 3, POSITION_HIDE_ALL_TAG));
            return arrayList;
        }
        return (ArrayList) invokeI.objValue;
    }

    private ArrayList<as4> createThreadReplyList(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65558, this, i, i2)) == null) {
            ArrayList<as4> arrayList = new ArrayList<>();
            arrayList.add(new as4(getPageContext().getString(R.string.obfuscated_res_0x7f0f0269), "", i == 1, POSITION_SHOW_ALL_TAG));
            arrayList.add(new as4(getPageContext().getString(R.string.obfuscated_res_0x7f0f0b36), "", i == 5, POSITION_REPLY_FANS_TAG));
            arrayList.add(new as4(getPageContext().getString(R.string.obfuscated_res_0x7f0f0b32), "", i == 6, POSITION_REPLY_ATTENTIONS_TAG));
            if (i2 == 1) {
                arrayList.add(new as4(getPageContext().getString(R.string.obfuscated_res_0x7f0f0b50), "", i == 7, POSITION_MYSELF_ONLY_TAG));
            }
            return arrayList;
        }
        return (ArrayList) invokeII.objValue;
    }

    private void doMsgSwitchStat(BdSwitchView.SwitchState switchState, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65559, this, switchState, i) == null) {
            doMsgSwitchStat(switchState, i, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToBlackListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(getPageContext().getPageActivity(), "UserBlacklistPage", null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToUserMuteListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            sendMessage(new CustomMessage(2016302, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSetPrivacyMessage(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65563, this, str, i) == null) {
            sendMessage(new PrivacySettingMessage(str, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showResetSettingDialog(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65564, this, str, str2) == null) && this.loadSuccess) {
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
            rr4 rr4Var = this.mDialog;
            if (rr4Var != null) {
                rr4Var.d();
            }
            rr4 rr4Var2 = new rr4(getPageContext());
            this.mDialog = rr4Var2;
            rr4Var2.m(str2);
            rr4 rr4Var3 = this.mDialog;
            rr4Var3.k(this.mMyBar, new e(this, str));
            rr4Var3.m(str2);
            rr4 rr4Var4 = this.mDialog;
            rr4Var4.c();
            rr4Var4.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectedOption(uc8 uc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, this, uc8Var) == null) {
            this.optionBarSelected = uc8Var.c();
            this.optionForumSelected = uc8Var.i();
            this.optionGroupSelected = uc8Var.d();
            this.optionLiveSelected = uc8Var.e();
            this.optionThreadReplySelected = uc8Var.g();
            this.optionThreadReplyShowMyself = uc8Var.h();
            this.optionBazhuShowInside = uc8Var.a();
            this.optionBazhuShowOutside = uc8Var.b();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
            if (view2 == this.mView.s()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(8, true, this.mMsgRemindModelCallback);
                    this.mView.y(true);
                } else {
                    this.mModel.B(8, false, this.mMsgRemindModelCallback);
                    this.mView.y(false);
                }
                doMsgSwitchStat(switchState, 5);
            } else if (view2 == this.mView.t()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.B(9, true, this.mMsgRemindModelCallback);
                } else {
                    this.mModel.B(9, false, this.mMsgRemindModelCallback);
                }
                doMsgSwitchStat(switchState, 6);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.onChangeSkinType(i);
            rr4 rr4Var = this.mDialog;
            if (rr4Var != null) {
                rr4Var.g();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            this.mView = new wc8(this);
            this.mSetting = new uc8();
            this.mView.x(this.mCallback);
            this.mModel = new MsgRemindModel(this);
            if (this.mSetting.k()) {
                this.mView.z(true);
                this.mView.C(this.mSetting);
                updateSelectedOption(this.mSetting);
            } else {
                this.mView.z(false);
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
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            rr4 rr4Var = this.mDialog;
            if (rr4Var != null) {
                rr4Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResourceRecycle();
            this.mView.w();
        }
    }

    private void doMsgSwitchStat(BdSwitchView.SwitchState switchState, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65560, this, switchState, i, str) == null) {
            int i2 = switchState == BdSwitchView.SwitchState.ON ? 1 : 2;
            StatisticItem param = new StatisticItem("c13889").param("obj_locate", 2).param("obj_type", NotificationManagerCompat.from(this).areNotificationsEnabled() ? 1 : 2);
            StatisticItem param2 = param.param("obj_source", i + "_" + i2);
            if (i == 9 && !TextUtils.isEmpty(str)) {
                param2.param("obj_param1", str);
            }
            TiebaStatic.log(param2);
        }
    }
}
