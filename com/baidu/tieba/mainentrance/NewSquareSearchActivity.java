package com.baidu.tieba.mainentrance;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
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
import com.baidu.tieba.mainentrance.HotForumModel;
import com.baidu.tieba.mainentrance.searchsuggestlist.SearchListHttpResMessage;
import com.baidu.tieba.mainentrance.searchsuggestlist.SearchListNetMessage;
import com.baidu.tieba.mainentrance.searchsuggestlist.SearchListSocketResMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.SearchSug.DataRes;
/* loaded from: classes10.dex */
public class NewSquareSearchActivity extends BaseActivity<NewSquareSearchActivity> implements HotForumModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasRemindSearchResultForNet;
    public CustomMessageListener mCreateBarListener;
    public HotForumModel mHotForumModel;
    public HotSearchInfoData mHotSearchInfo;
    public boolean mIsFromEnterForum;
    public boolean mIsFromSchema;
    public final c.a.d.c.g.a mSearchSuggestListListener;
    public HotSearchInfoData mTransmitHotSearchInfo;
    public c.a.r0.b2.i.e mViewController;

    /* loaded from: classes10.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSquareSearchActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NewSquareSearchActivity newSquareSearchActivity, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSquareSearchActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = newSquareSearchActivity;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof SearchListHttpResMessage;
                if (z || (responsedMessage instanceof SearchListSocketResMessage)) {
                    if (responsedMessage.getError() != 0) {
                        if (this.a.hasRemindSearchResultForNet) {
                            return;
                        }
                        NewSquareSearchActivity newSquareSearchActivity = this.a;
                        newSquareSearchActivity.showToast(newSquareSearchActivity.getActivity().getString(R.string.neterror));
                        this.a.hasRemindSearchResultForNet = true;
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
                    this.a.mViewController.z(dataRes, str);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSquareSearchActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(NewSquareSearchActivity newSquareSearchActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSquareSearchActivity, Integer.valueOf(i2)};
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
            this.a = newSquareSearchActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.creatBar(customResponsedMessage.getData().toString());
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSquareSearchActivity f46768e;

        public c(NewSquareSearchActivity newSquareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSquareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46768e = newSquareSearchActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l.K(this.f46768e.getPageContext().getPageActivity(), this.f46768e.mViewController.o());
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSquareSearchActivity f46769e;

        public d(NewSquareSearchActivity newSquareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSquareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46769e = newSquareSearchActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46769e.closeActivity();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSquareSearchActivity f46770e;

        public e(NewSquareSearchActivity newSquareSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSquareSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46770e = newSquareSearchActivity;
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
                        shareItem.r = optString;
                        shareItem.t = optString4;
                        shareItem.s = optString2;
                        if (!TextUtils.isEmpty(optString3)) {
                            shareItem.v = Uri.parse(optString3);
                        }
                        shareItem.O = optString5;
                        shareItem.P = optString6;
                        shareItem.Q = optString7;
                        shareItem.Z = jSONObject.optInt("shareimg");
                        shareItem.h0 = jSONObject.optInt("weixin_disable");
                        String optString8 = jSONObject.optString("extdata");
                        if (!StringUtils.isNull(optString8)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(optString8);
                                String optString9 = jSONObject2.optString("activityid");
                                String optString10 = jSONObject2.optString("missionid");
                                if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(optString9, optString10);
                                    shareItem.S = jSONObject3.toString();
                                }
                            } catch (JSONException unused) {
                            }
                        }
                        return new CustomResponsedMessage<>(2016568, shareItem);
                    } catch (JSONException e2) {
                        BdLog.e(e2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hasRemindSearchResultForNet = false;
        this.mIsFromEnterForum = false;
        this.mIsFromSchema = false;
        this.mSearchSuggestListListener = new a(this, CmdConfigHttp.CMD_SEARCH_LIST, 309438);
        this.mCreateBarListener = new b(this, 2001608);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void creatBar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, str) == null) {
            if (!j.z()) {
                showToast(R.string.neterror);
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

    private void doSearchFromOutsideSchema() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            String stringExtra = getIntent().getStringExtra(IntentConfig.SEARCH_PAGE_QUERY_CONTENT_KEY);
            if (StringUtils.isNull(stringExtra)) {
                return;
            }
            if (!c.a.d.a.b.g().i("MainTabActivity")) {
                this.mIsFromSchema = true;
                setIsAddSwipeBackLayout(false);
            }
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921595, stringExtra);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2921595, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void initData() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        this.mIsFromEnterForum = intent.getBooleanExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, false);
        String stringExtra = intent.getStringExtra("search");
        String stringExtra2 = intent.getStringExtra(SquareSearchActivityConfig.SEARCH_VALUE);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.mTransmitHotSearchInfo = new HotSearchInfoData();
        if (StringUtils.isNull(stringExtra2)) {
            this.mTransmitHotSearchInfo.setName(stringExtra);
        } else {
            this.mTransmitHotSearchInfo.setName(stringExtra2);
        }
        this.mTransmitHotSearchInfo.y(stringExtra);
    }

    private void loadHotSearch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            HotSearchInfoData hotSearchInfoData = this.mTransmitHotSearchInfo;
            if (hotSearchInfoData != null && !TextUtils.isEmpty(hotSearchInfoData.w()) && !TextUtils.isEmpty(this.mTransmitHotSearchInfo.getName())) {
                this.mViewController.y(this.mTransmitHotSearchInfo);
                return;
            }
            try {
                this.mHotSearchInfo = (HotSearchInfoData) OrmObject.objectWithJsonStr(c.a.q0.s.e0.b.j().p("hot_search_info", ""), HotSearchInfoData.class);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            HotSearchInfoData hotSearchInfoData2 = this.mHotSearchInfo;
            if (hotSearchInfoData2 != null && !TextUtils.isEmpty(hotSearchInfoData2.w()) && !TextUtils.isEmpty(this.mHotSearchInfo.getName())) {
                this.mViewController.y(this.mHotSearchInfo);
            } else {
                this.mHotForumModel.H();
            }
        }
    }

    private void registerGetShareContentTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new e(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    private void updateHotSearchCache(HotSearchInfoData hotSearchInfoData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, hotSearchInfoData) == null) || this.mIsFromEnterForum || hotSearchInfoData == null) {
            return;
        }
        this.mHotSearchInfo = hotSearchInfoData;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!getIntent().getBooleanExtra("back_special", false)) {
                finish();
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                c.a.q0.s.b0.b.e(getPageContext().getPageActivity(), 1);
            } else {
                c.a.q0.s.b0.b.e(getPageContext().getPageActivity(), 2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.mIsFromSchema) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, c.a.q0.p0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a026" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.mViewController.r(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            initData();
            getWindow().setSoftInputMode(2);
            addGlobalLayoutListener();
            registerListener(this.mSearchSuggestListListener);
            registerListener(this.mCreateBarListener);
            this.mViewController = new c.a.r0.b2.i.e(this, this.mIsFromEnterForum);
            doSearchFromOutsideSchema();
            this.mHotForumModel = new HotForumModel(getPageContext(), this);
            loadHotSearch();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            c.a.r0.b2.i.e eVar = this.mViewController;
            if (eVar != null) {
                eVar.s();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921504, null));
            TbPageExtraHelper.v(getCurrentPageKey());
            TbSingleton.getInstance().setFromWhichSearchSource("");
        }
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.b
    public void onHotForumDataFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.b
    public void onHotForumDataSuccess(List<c.a.r0.b2.b> list, List<c.a.r0.b2.c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, list2, hotSearchInfoData, str) == null) {
            updateHotSearchCache(hotSearchInfoData);
            this.mViewController.y(this.mHotSearchInfo);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                BaseWebView p = this.mViewController.p();
                if (i2 == 4 && p != null && p.canGoBack()) {
                    this.mViewController.u();
                    p.goBack();
                    return true;
                }
                c.a.d.f.m.e.a().postDelayed(new d(this), 200L);
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterTask(2016568);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            c.a.r0.b2.i.e eVar = this.mViewController;
            if (eVar != null) {
                eVar.t();
            }
            registerGetShareContentTask();
            TbSingleton.getInstance().setFromWhichSearchSource("");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onStart();
            c.a.d.f.m.e.a().postDelayed(new c(this), 300L);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            super.overridePendingTransition(0, 0);
        }
    }
}
