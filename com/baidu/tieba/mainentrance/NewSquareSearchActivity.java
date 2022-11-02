package com.baidu.tieba.mainentrance;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.fy4;
import com.baidu.tieba.ky4;
import com.baidu.tieba.mainentrance.HotForumModel;
import com.baidu.tieba.mainentrance.searchsuggestlist.SearchListHttpResMessage;
import com.baidu.tieba.mainentrance.searchsuggestlist.SearchListNetMessage;
import com.baidu.tieba.mainentrance.searchsuggestlist.SearchListSocketResMessage;
import com.baidu.tieba.n9;
import com.baidu.tieba.pb;
import com.baidu.tieba.sl7;
import com.baidu.tieba.uk7;
import com.baidu.tieba.vk7;
import com.baidu.tieba.xi;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.SearchSug.DataRes;
/* loaded from: classes5.dex */
public class NewSquareSearchActivity extends BaseActivity<NewSquareSearchActivity> implements HotForumModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotSearchInfoData a;
    public boolean b;
    public boolean c;
    public HotForumModel d;
    public sl7 e;
    public boolean f;
    public final pb g;
    public CustomMessageListener h;
    public HotSearchInfoData i;

    @Override // com.baidu.tieba.mainentrance.HotForumModel.b
    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.vd5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "a026" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a extends pb {
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

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof SearchListHttpResMessage;
                if (!z && !(responsedMessage instanceof SearchListSocketResMessage)) {
                    return;
                }
                if (responsedMessage.getError() != 0) {
                    if (!this.a.b) {
                        NewSquareSearchActivity newSquareSearchActivity = this.a;
                        newSquareSearchActivity.showToast(newSquareSearchActivity.getActivity().getString(R.string.obfuscated_res_0x7f0f0c7f));
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
                } else if (responsedMessage instanceof SearchListSocketResMessage) {
                    dataRes = ((SearchListSocketResMessage) responsedMessage).suggestData;
                    if (responsedMessage.getOrginalMessage() != null && responsedMessage.getOrginalMessage().getExtra() != null) {
                        Object extra2 = responsedMessage.getOrginalMessage().getExtra();
                        if (extra2 instanceof SearchListNetMessage) {
                            str = ((SearchListNetMessage) extra2).mKey;
                        }
                    }
                }
                this.a.e.z(dataRes, str);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.B1(customResponsedMessage.getData().toString());
            }
        }
    }

    /* loaded from: classes5.dex */
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
                xi.N(this.a.getPageContext().getPageActivity(), this.a.e.o());
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
                        JSONObject jSONObject = new JSONObject(customMessage.getData());
                        String optString = jSONObject.optString("title");
                        String optString2 = jSONObject.optString("desc");
                        String optString3 = jSONObject.optString("img");
                        String optString4 = jSONObject.optString("url");
                        String optString5 = jSONObject.optString("topic");
                        String optString6 = jSONObject.optString("wbtitle");
                        String optString7 = jSONObject.optString("wbcontent");
                        ShareItem shareItem = new ShareItem();
                        shareItem.v = optString;
                        shareItem.x = optString4;
                        shareItem.w = optString2;
                        if (!TextUtils.isEmpty(optString3)) {
                            shareItem.z = Uri.parse(optString3);
                        }
                        shareItem.S = optString5;
                        shareItem.T = optString6;
                        shareItem.U = optString7;
                        shareItem.h0 = jSONObject.optInt("shareimg");
                        shareItem.p0 = jSONObject.optInt("weixin_disable");
                        String optString8 = jSONObject.optString("extdata");
                        if (!StringUtils.isNull(optString8)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(optString8);
                                String optString9 = jSONObject2.optString("activityid");
                                String optString10 = jSONObject2.optString("missionid");
                                if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(optString9, optString10);
                                    shareItem.W = jSONObject3.toString();
                                }
                            } catch (JSONException unused) {
                            }
                        }
                        return new CustomResponsedMessage<>(2016568, shareItem);
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
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!getIntent().getBooleanExtra("back_special", false)) {
                finish();
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                fy4.e(getPageContext().getPageActivity(), 1);
            } else {
                fy4.e(getPageContext().getPageActivity(), 2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
            sl7 sl7Var = this.e;
            if (sl7Var != null) {
                sl7Var.s();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921504, null));
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            TbSingleton.getInstance().setFromWhichSearchSource("");
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) {
            super.overridePendingTransition(0, 0);
        }
    }

    public final void E1(HotSearchInfoData hotSearchInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, hotSearchInfoData) == null) && !this.c && hotSearchInfoData != null) {
            this.a = hotSearchInfoData;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.e.r(i);
        }
    }

    public final void B1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0c7f);
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

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String stringExtra = getIntent().getStringExtra(IntentConfig.SEARCH_PAGE_QUERY_CONTENT_KEY);
            if (!StringUtils.isNull(stringExtra)) {
                if (!n9.g().i("MainTabActivity")) {
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
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (intent = getIntent()) != null) {
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
                this.i.C(stringExtra);
            }
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HotSearchInfoData hotSearchInfoData = this.i;
            if (hotSearchInfoData != null && !TextUtils.isEmpty(hotSearchInfoData.A()) && !TextUtils.isEmpty(this.i.getName())) {
                this.e.y(this.i);
                return;
            }
            try {
                this.a = (HotSearchInfoData) OrmObject.objectWithJsonStr(ky4.k().q("hot_search_info", ""), HotSearchInfoData.class);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            HotSearchInfoData hotSearchInfoData2 = this.a;
            if (hotSearchInfoData2 != null && !TextUtils.isEmpty(hotSearchInfoData2.A()) && !TextUtils.isEmpty(this.a.getName())) {
                this.e.y(this.a);
            } else {
                this.d.K();
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
            this.e = new sl7(this, this.c);
            C1();
            this.d = new HotForumModel(getPageContext(), this);
            D1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, keyEvent)) == null) {
            if (i == 4) {
                BaseWebView p = this.e.p();
                if (i == 4 && p != null && p.canGoBack()) {
                    this.e.u();
                    p.goBack();
                    return true;
                }
                zg.a().postDelayed(new d(this), 200L);
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
            MessageManager.getInstance().unRegisterTask(2016568);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            sl7 sl7Var = this.e;
            if (sl7Var != null) {
                sl7Var.t();
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
            zg.a().postDelayed(new c(this), 300L);
        }
    }

    public final void registerGetShareContentTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new e(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.b
    public void s(List<uk7> list, List<vk7> list2, HotSearchInfoData hotSearchInfoData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048594, this, list, list2, hotSearchInfoData, str) == null) {
            E1(hotSearchInfoData);
            this.e.y(this.a);
        }
    }
}
