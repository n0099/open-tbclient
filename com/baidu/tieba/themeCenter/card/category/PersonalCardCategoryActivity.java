package com.baidu.tieba.themeCenter.card.category;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.m.d;
import com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryModel;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel;
import com.baidu.tieba.themeCenter.dressCenter.e;
import java.util.List;
/* loaded from: classes8.dex */
public class PersonalCardCategoryActivity extends BaseActivity<PersonalCardCategoryActivity> {
    private c nyq;
    private PersonalCardCategoryModel nyr;
    private SetPersonalCardModel nys;
    private PersonalCardItemView.a nyl = new PersonalCardItemView.a() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity.1
        @Override // com.baidu.tieba.themeCenter.card.category.PersonalCardItemView.a
        public void a(com.baidu.tieba.themeCenter.a aVar) {
            if (aVar != null) {
                if (aVar.getCardId() == com.baidu.tieba.themeCenter.a.nvE) {
                    if (aVar.dOG() != 1 && PersonalCardCategoryActivity.this.nys != null) {
                        PersonalCardCategoryActivity.this.nys.L(aVar.getCardId(), 1);
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(PersonalCardCategoryActivity.this.getPageContext().getPageActivity(), aVar.getCardId())));
            }
        }
    };
    private PersonalCardCategoryModel.a nyt = new PersonalCardCategoryModel.a() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity.2
        @Override // com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryModel.a
        public void a(int i, String str, e eVar, List<a> list, boolean z) {
            PersonalCardCategoryActivity.this.hideLoadingView(PersonalCardCategoryActivity.this.nyq.getRootView());
            if (i != 0) {
                PersonalCardCategoryActivity.this.showToast(str);
            }
            PersonalCardCategoryActivity.this.nyq.a(i, eVar, list, true);
        }
    };
    private SetPersonalCardModel.a nyu = new SetPersonalCardModel.a() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity.3
        @Override // com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel.a
        public void b(boolean z, long j, int i, String str, int i2) {
            if (z && PersonalCardCategoryActivity.this.nyr != null) {
                PersonalCardCategoryActivity.this.nyr.J(j, i);
            }
        }
    };
    private BdListView.e gyE = new BdListView.e() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PersonalCardCategoryActivity.this.nyr != null) {
                PersonalCardCategoryActivity.this.nyr.dOY();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nyq = new c(this);
        this.nyq.setOnSrollToBottomListener(this.gyE);
        this.nyq.setCardViewController(this.nyl);
        this.nyr = new PersonalCardCategoryModel(this);
        this.nyr.a(this.nyt);
        this.nys = new SetPersonalCardModel();
        this.nys.a(this.nyu);
        showLoadingView(this.nyq.getRootView());
        this.nyr.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nyq != null) {
            this.nyq.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nyr != null) {
            this.nyr.onDestroy();
        }
        if (this.nys != null) {
            this.nys.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nyr != null && this.nyq != null) {
            showLoadingView(this.nyq.getRootView());
            this.nyr.LoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.CARD_LIST;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.isRouteStat = true;
        }
        return pageStayDurationItem;
    }
}
