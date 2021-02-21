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
/* loaded from: classes9.dex */
public class PersonalCardCategoryActivity extends BaseActivity<PersonalCardCategoryActivity> {
    private c nIA;
    private PersonalCardCategoryModel nIB;
    private SetPersonalCardModel nIC;
    private PersonalCardItemView.a nIv = new PersonalCardItemView.a() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity.1
        @Override // com.baidu.tieba.themeCenter.card.category.PersonalCardItemView.a
        public void a(com.baidu.tieba.themeCenter.a aVar) {
            if (aVar != null) {
                if (aVar.getCardId() == com.baidu.tieba.themeCenter.a.nFO) {
                    if (aVar.dQZ() != 1 && PersonalCardCategoryActivity.this.nIC != null) {
                        PersonalCardCategoryActivity.this.nIC.J(aVar.getCardId(), 1);
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(PersonalCardCategoryActivity.this.getPageContext().getPageActivity(), aVar.getCardId())));
            }
        }
    };
    private PersonalCardCategoryModel.a nID = new PersonalCardCategoryModel.a() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity.2
        @Override // com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryModel.a
        public void a(int i, String str, e eVar, List<a> list, boolean z) {
            PersonalCardCategoryActivity.this.hideLoadingView(PersonalCardCategoryActivity.this.nIA.getRootView());
            if (i != 0) {
                PersonalCardCategoryActivity.this.showToast(str);
            }
            PersonalCardCategoryActivity.this.nIA.a(i, eVar, list, true);
        }
    };
    private SetPersonalCardModel.a nIE = new SetPersonalCardModel.a() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity.3
        @Override // com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel.a
        public void b(boolean z, long j, int i, String str, int i2) {
            if (z && PersonalCardCategoryActivity.this.nIB != null) {
                PersonalCardCategoryActivity.this.nIB.H(j, i);
            }
        }
    };
    private BdListView.e gBC = new BdListView.e() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PersonalCardCategoryActivity.this.nIB != null) {
                PersonalCardCategoryActivity.this.nIB.dRr();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nIA = new c(this);
        this.nIA.setOnSrollToBottomListener(this.gBC);
        this.nIA.setCardViewController(this.nIv);
        this.nIB = new PersonalCardCategoryModel(this);
        this.nIB.a(this.nID);
        this.nIC = new SetPersonalCardModel();
        this.nIC.a(this.nIE);
        showLoadingView(this.nIA.getRootView());
        this.nIB.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nIA != null) {
            this.nIA.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nIB != null) {
            this.nIB.onDestroy();
        }
        if (this.nIC != null) {
            this.nIC.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nIB != null && this.nIA != null) {
            showLoadingView(this.nIA.getRootView());
            this.nIB.LoadData();
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
