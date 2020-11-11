package com.baidu.tieba.mainentrance;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.HotForumModel;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListHttpResMessage;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListSocketResMessage;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes24.dex */
public class NewSquareSearchActivity extends BaseActivity<NewSquareSearchActivity> implements HotForumModel.a {
    private HotForumModel kLZ;
    private com.baidu.tieba.mainentrance.a.e kMa;
    private HotSearchInfoData kMd;
    private HotSearchInfoData mHotSearchInfo;
    private boolean kLX = false;
    private boolean kLY = false;
    private com.baidu.adp.framework.listener.a kMb = new com.baidu.adp.framework.listener.a(1003196, CmdConfigSocket.CMD_SEARCH_LIST) { // from class: com.baidu.tieba.mainentrance.NewSquareSearchActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<String> list;
            List<ForumInfo> list2 = null;
            if ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (!NewSquareSearchActivity.this.kLX) {
                        NewSquareSearchActivity.this.showToast(NewSquareSearchActivity.this.getActivity().getString(R.string.neterror));
                        NewSquareSearchActivity.this.kLX = true;
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof SearchListHttpResMessage) {
                    SearchListHttpResMessage searchListHttpResMessage = (SearchListHttpResMessage) responsedMessage;
                    list = searchListHttpResMessage.suggests;
                    list2 = searchListHttpResMessage.forums;
                } else if (responsedMessage instanceof SearchListSocketResMessage) {
                    SearchListSocketResMessage searchListSocketResMessage = (SearchListSocketResMessage) responsedMessage;
                    list = searchListSocketResMessage.suggests;
                    list2 = searchListSocketResMessage.forums;
                } else {
                    list = null;
                }
                NewSquareSearchActivity.this.kMa.eF(list);
                NewSquareSearchActivity.this.kMa.eG(list2);
            }
        }
    };
    private CustomMessageListener kMc = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_CREATE_BAR) { // from class: com.baidu.tieba.mainentrance.NewSquareSearchActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                NewSquareSearchActivity.this.NZ(customResponsedMessage.getData().toString());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        initData();
        getWindow().setSoftInputMode(0);
        registerListener(this.kMb);
        registerListener(this.kMc);
        this.kMa = new com.baidu.tieba.mainentrance.a.e(this, this.kLY);
        this.kLZ = new HotForumModel(getPageContext(), this);
        dbi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kMa != null) {
            this.kMa.onResume();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.kLY = intent.getBooleanExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, false);
            String stringExtra = intent.getStringExtra("search");
            String stringExtra2 = intent.getStringExtra(SquareSearchActivityConfig.SEARCH_VALUE);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.kMd = new HotSearchInfoData();
                if (StringUtils.isNull(stringExtra2)) {
                    this.kMd.setName(stringExtra);
                } else {
                    this.kMd.setName(stringExtra2);
                }
                this.kMd.NY(stringExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kMa != null) {
            this.kMa.onDestroy();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921504, null));
    }

    private void dbi() {
        if (this.kMd != null && !TextUtils.isEmpty(this.kMd.cra()) && !TextUtils.isEmpty(this.kMd.getName())) {
            this.kMa.b(this.kMd);
            return;
        }
        this.mHotSearchInfo = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.bqh().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
        if (this.mHotSearchInfo != null && !TextUtils.isEmpty(this.mHotSearchInfo.cra()) && !TextUtils.isEmpty(this.mHotSearchInfo.getName())) {
            this.kMa.b(this.mHotSearchInfo);
        } else {
            this.kLZ.dbg();
        }
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void NX(String str) {
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        a(hotSearchInfoData);
        this.kMa.b(this.mHotSearchInfo);
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (!this.kLY && hotSearchInfoData != null) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kMa.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            BaseWebView dce = this.kMa.dce();
            if (i == 4 && dce != null && dce.canGoBack()) {
                dce.goBack();
                return true;
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.mainentrance.NewSquareSearchActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    NewSquareSearchActivity.this.closeActivity();
                }
            }, 200L);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            com.baidu.tbadk.core.e.b.r(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.r(getPageContext().getPageActivity(), 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SEARCH_RESULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NZ(String str) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CREATE_BAR)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
