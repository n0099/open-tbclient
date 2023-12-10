package com.baidu.tieba.mainentrance;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.mainentrance.MainEntrance;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.gj9;
import com.baidu.tieba.ii9;
import com.baidu.tieba.ji9;
import com.baidu.tieba.jj9;
import com.baidu.tieba.mainentrance.HotForumModel;
import com.baidu.tieba.mainentrance.searchsuggestlist.SearchListHttpResMessage;
import com.baidu.tieba.mainentrance.searchsuggestlist.SearchListNetMessage;
import com.baidu.tieba.qi9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.SearchSug.DataRes;
/* loaded from: classes7.dex */
public class NewSquareSearchActivity extends BaseActivity<NewSquareSearchActivity> implements HotForumModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotSearchInfoData a;
    public boolean b;
    public boolean c;
    public HotForumModel d;
    public gj9 e;
    public boolean f;
    public final NetMessageListener g;
    public CustomMessageListener h;
    public HotSearchInfoData i;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "a026" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.b
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSquareSearchActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NewSquareSearchActivity newSquareSearchActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSquareSearchActivity, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = newSquareSearchActivity;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || !((z = responsedMessage instanceof SearchListHttpResMessage))) {
                return;
            }
            if (responsedMessage.getError() != 0) {
                if (!this.a.b) {
                    NewSquareSearchActivity newSquareSearchActivity = this.a;
                    newSquareSearchActivity.showToast(newSquareSearchActivity.getActivity().getString(R.string.obfuscated_res_0x7f0f0e70));
                    this.a.b = true;
                    return;
                }
                return;
            }
            DataRes dataRes = null;
            String str = "";
            if (z) {
                dataRes = ((SearchListHttpResMessage) responsedMessage).suggestData;
                if (responsedMessage.getOrginalMessage() != null && responsedMessage.getOrginalMessage().getExtra() != null) {
                    Object extra = responsedMessage.getOrginalMessage().getExtra();
                    if (extra instanceof SearchListNetMessage) {
                        str = ((SearchListNetMessage) extra).mKey;
                    }
                }
            }
            this.a.e.f(dataRes, str);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSquareSearchActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(NewSquareSearchActivity newSquareSearchActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSquareSearchActivity, Integer.valueOf(i)};
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
            this.a = newSquareSearchActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            this.a.M0(customResponsedMessage.getData().toString());
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSquareSearchActivity a;

        public c(NewSquareSearchActivity newSquareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSquareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSquareSearchActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdUtilHelper.showSoftKeyPad(this.a.getPageContext().getPageActivity(), this.a.e.e());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSquareSearchActivity a;

        public d(NewSquareSearchActivity newSquareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSquareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSquareSearchActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.closeActivity();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSquareSearchActivity a;

        public e(NewSquareSearchActivity newSquareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSquareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSquareSearchActivity;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<ShareItem> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof String)) {
                    try {
                        return new CustomResponsedMessage<>(2016568, ShareItem.buildShareItem(new JSONObject(customMessage.getData()), false));
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    public NewSquareSearchActivity() {
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
        this.f = false;
        this.g = new a(this, CmdConfigHttp.CMD_SEARCH_LIST, 309438);
        this.h = new b(this, 2001608);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!getIntent().getBooleanExtra("back_special", false)) {
                finish();
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                MainEntrance.goToMainTab(getPageContext().getPageActivity(), 1);
            } else {
                MainEntrance.goToMainTab(getPageContext().getPageActivity(), 2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            gj9 gj9Var = this.e;
            if (gj9Var != null) {
                gj9Var.onDestroy();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921504, null));
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            TbSingleton.getInstance().setFromWhichSearchSource("");
        }
    }

    public final void R0(HotSearchInfoData hotSearchInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, hotSearchInfoData) == null) && hotSearchInfoData != null) {
            this.a = hotSearchInfoData;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.e.onChangeSkinType(i);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) {
            super.overridePendingTransition(0, 0);
        }
    }

    public final void M0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0e70);
            } else if (StringUtils.isNull(str)) {
            } else {
                if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11013)));
                } else {
                    sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
                }
            }
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String stringExtra = getIntent().getStringExtra(IntentConfig.SEARCH_PAGE_QUERY_CONTENT_KEY);
            if (!StringUtils.isNull(stringExtra)) {
                if (!BdActivityStack.getInst().isActivityExist("MainTabActivity")) {
                    this.f = true;
                    setIsAddSwipeBackLayout(false);
                }
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921595, stringExtra);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2921595, getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    public final void initData() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (intent = getIntent()) != null) {
            this.c = intent.getBooleanExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, false);
            String stringExtra = intent.getStringExtra("search");
            String stringExtra2 = intent.getStringExtra(SquareSearchActivityConfig.SEARCH_VALUE);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.i = new HotSearchInfoData();
                if (StringUtils.isNull(stringExtra2)) {
                    this.i.setName(stringExtra);
                } else {
                    this.i.setName(stringExtra2);
                }
                this.i.S(stringExtra);
            }
        }
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HotSearchInfoData hotSearchInfoData = this.i;
            if (hotSearchInfoData != null && !TextUtils.isEmpty(hotSearchInfoData.P()) && !TextUtils.isEmpty(this.i.getName())) {
                this.e.d(this.i);
                return;
            }
            try {
                this.a = (HotSearchInfoData) OrmObject.objectWithJsonStr(SharedPrefHelper.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            HotSearchInfoData hotSearchInfoData2 = this.a;
            if (hotSearchInfoData2 != null && !TextUtils.isEmpty(hotSearchInfoData2.P()) && !TextUtils.isEmpty(this.a.getName())) {
                this.e.d(this.a);
            } else {
                this.d.Z();
            }
        }
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.b
    public void j(List<ii9> list, List<ji9> list2, HotSearchInfoData hotSearchInfoData, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, list2, hotSearchInfoData, str) == null) {
            R0(hotSearchInfoData);
            this.e.d(this.a);
            if (this.a != null) {
                StatisticItem param = new StatisticItem("c15198").param("obj_name", this.a.getName()).param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (this.c) {
                    i = 2;
                } else {
                    i = 1;
                }
                TiebaStatic.log(param.param("obj_type", i));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            initData();
            getWindow().setSoftInputMode(2);
            addGlobalLayoutListener();
            registerListener(this.g);
            registerListener(this.h);
            if (BrowserHelper.allowedUseNewWebContainer("https://tieba.baidu.com/mo/q/hybrid/search?keyword=")) {
                this.e = new qi9(this, this.c);
            } else {
                this.e = new jj9(this, this.c);
            }
            O0();
            this.d = new HotForumModel(getPageContext(), this);
            Q0();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, keyEvent)) == null) {
            if (i == 4) {
                View c2 = this.e.c();
                if (c2 instanceof TbWebView) {
                    TbWebView tbWebView = (TbWebView) c2;
                    if (tbWebView.getController().a()) {
                        this.e.b();
                        tbWebView.getController().c();
                        return true;
                    }
                }
                SafeHandler.getInst().postDelayed(new d(this), 200L);
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            gj9 gj9Var = this.e;
            if (gj9Var != null) {
                gj9Var.onPause();
            }
            MessageManager.getInstance().unRegisterTask(2016568);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            gj9 gj9Var = this.e;
            if (gj9Var != null) {
                gj9Var.onResume();
            }
            registerGetShareContentTask();
            TbSingleton.getInstance().setFromWhichSearchSource("");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStart();
            SafeHandler.getInst().postDelayed(new c(this), 300L);
        }
    }

    public final void registerGetShareContentTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new e(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }
}
