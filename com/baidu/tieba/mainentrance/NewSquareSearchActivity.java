package com.baidu.tieba.mainentrance;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
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
/* loaded from: classes6.dex */
public class NewSquareSearchActivity extends BaseActivity<NewSquareSearchActivity> implements HotForumModel.a {
    private HotSearchInfoData hln;
    private HotForumModel hlq;
    private com.baidu.tieba.mainentrance.a.e hlr;
    private HotSearchInfoData mHotSearchInfo;
    private boolean hlo = false;
    private boolean hlp = false;
    private com.baidu.adp.framework.listener.a hls = new com.baidu.adp.framework.listener.a(1003196, CmdConfigSocket.CMD_SEARCH_LIST) { // from class: com.baidu.tieba.mainentrance.NewSquareSearchActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<String> list;
            List<ForumInfo> list2 = null;
            if ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (!NewSquareSearchActivity.this.hlo) {
                        NewSquareSearchActivity.this.showToast(NewSquareSearchActivity.this.getActivity().getString(R.string.neterror));
                        NewSquareSearchActivity.this.hlo = true;
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
                NewSquareSearchActivity.this.hlr.dF(list);
                NewSquareSearchActivity.this.hlr.dG(list2);
            }
        }
    };
    private CustomMessageListener hlt = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_CREATE_BAR) { // from class: com.baidu.tieba.mainentrance.NewSquareSearchActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                NewSquareSearchActivity.this.zh(customResponsedMessage.getData().toString());
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
        registerListener(this.hls);
        registerListener(this.hlt);
        this.hlr = new com.baidu.tieba.mainentrance.a.e(this, this.hlp);
        this.hlq = new HotForumModel(getPageContext(), this);
        this.hlq.bJO();
        bJQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hlr != null) {
            this.hlr.onResume();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.hlp = intent.getBooleanExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hlr != null) {
            this.hlr.onDestroy();
        }
    }

    private void bJQ() {
        this.hln = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.HOT_SEARCH_INFO, ""), HotSearchInfoData.class);
        if (this.hln != null) {
            this.mHotSearchInfo = this.hln;
        }
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void zf(String str) {
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        a(hotSearchInfoData);
        this.hlr.b(this.mHotSearchInfo);
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (!this.hlp && hotSearchInfoData != null) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hlr.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            BaseWebView bKJ = this.hlr.bKJ();
            if (i == 4 && bKJ != null && bKJ.canGoBack()) {
                bKJ.goBack();
                return true;
            }
            closeActivity();
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
            com.baidu.tbadk.core.f.b.m(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.f.b.m(getPageContext().getPageActivity(), 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SEARCH_RESULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(String str) {
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
