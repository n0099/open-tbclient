package com.baidu.tieba.mainentrance;

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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.f;
import com.baidu.tieba.mainentrance.HotForumModel;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListHttpResMessage;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListSocketResMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class NewSquareSearchActivity extends BaseActivity<NewSquareSearchActivity> implements HotForumModel.a {
    private HotForumModel eWd;
    private com.baidu.tieba.mainentrance.a.e eWg;
    private HotSearchInfoData eWj;
    private HotSearchInfoData mHotSearchInfo;
    private boolean eWe = false;
    private boolean eWf = false;
    private com.baidu.adp.framework.listener.a eWh = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_LIST, 309438) { // from class: com.baidu.tieba.mainentrance.NewSquareSearchActivity.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if ((responsedMessage instanceof SearchListHttpResMessage) || (responsedMessage instanceof SearchListSocketResMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (!NewSquareSearchActivity.this.eWe) {
                        NewSquareSearchActivity.this.showToast(NewSquareSearchActivity.this.getActivity().getString(f.j.neterror));
                        NewSquareSearchActivity.this.eWe = true;
                        return;
                    }
                    return;
                }
                List<String> list = null;
                if (responsedMessage instanceof SearchListHttpResMessage) {
                    list = ((SearchListHttpResMessage) responsedMessage).suggests;
                } else if (responsedMessage instanceof SearchListSocketResMessage) {
                    list = ((SearchListSocketResMessage) responsedMessage).suggests;
                }
                NewSquareSearchActivity.this.eWg.cF(list);
            }
        }
    };
    private CustomMessageListener eWi = new CustomMessageListener(2001608) { // from class: com.baidu.tieba.mainentrance.NewSquareSearchActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                NewSquareSearchActivity.this.pF(customResponsedMessage.getData().toString());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        getWindow().setSoftInputMode(4);
        registerListener(this.eWh);
        registerListener(this.eWi);
        this.eWg = new com.baidu.tieba.mainentrance.a.e(this);
        this.eWd = new HotForumModel(getPageContext(), this);
        this.eWd.aSO();
        aSR();
    }

    private void initData() {
        if (getIntent() != null) {
            this.eWf = getIntent().getBooleanExtra(SquareSearchActivityConfig.IS_FROM_ENTER_FROUM, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eWg != null) {
            this.eWg.onDestroy();
        }
    }

    private void aSR() {
        this.eWj = (HotSearchInfoData) OrmObject.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (this.eWj != null) {
            this.mHotSearchInfo = this.eWj;
        }
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void pD(String str) {
    }

    @Override // com.baidu.tieba.mainentrance.HotForumModel.a
    public void a(List<b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str) {
        a(hotSearchInfoData);
        this.eWg.b(this.mHotSearchInfo);
    }

    private void a(HotSearchInfoData hotSearchInfoData) {
        if (!this.eWf && hotSearchInfoData != null) {
            this.mHotSearchInfo = hotSearchInfoData;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eWg.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            BaseWebView aTK = this.eWg.aTK();
            if (i == 4 && aTK != null && aTK.canGoBack()) {
                aTK.goBack();
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
            com.baidu.tbadk.core.e.b.h(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.h(getPageContext().getPageActivity(), 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a026";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pF(String str) {
        if (!j.jE()) {
            showToast(f.j.neterror);
        } else if (!StringUtils.isNull(str)) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), str)));
            }
        }
    }
}
