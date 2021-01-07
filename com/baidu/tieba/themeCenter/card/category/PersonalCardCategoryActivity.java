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
    private c nCU;
    private PersonalCardCategoryModel nCV;
    private SetPersonalCardModel nCW;
    private PersonalCardItemView.a nCP = new PersonalCardItemView.a() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity.1
        @Override // com.baidu.tieba.themeCenter.card.category.PersonalCardItemView.a
        public void a(com.baidu.tieba.themeCenter.a aVar) {
            if (aVar != null) {
                if (aVar.getCardId() == com.baidu.tieba.themeCenter.a.nAi) {
                    if (aVar.dSy() != 1 && PersonalCardCategoryActivity.this.nCW != null) {
                        PersonalCardCategoryActivity.this.nCW.L(aVar.getCardId(), 1);
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(PersonalCardCategoryActivity.this.getPageContext().getPageActivity(), aVar.getCardId())));
            }
        }
    };
    private PersonalCardCategoryModel.a nCX = new PersonalCardCategoryModel.a() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity.2
        @Override // com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryModel.a
        public void a(int i, String str, e eVar, List<a> list, boolean z) {
            PersonalCardCategoryActivity.this.hideLoadingView(PersonalCardCategoryActivity.this.nCU.getRootView());
            if (i != 0) {
                PersonalCardCategoryActivity.this.showToast(str);
            }
            PersonalCardCategoryActivity.this.nCU.a(i, eVar, list, true);
        }
    };
    private SetPersonalCardModel.a nCY = new SetPersonalCardModel.a() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity.3
        @Override // com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel.a
        public void b(boolean z, long j, int i, String str, int i2) {
            if (z && PersonalCardCategoryActivity.this.nCV != null) {
                PersonalCardCategoryActivity.this.nCV.J(j, i);
            }
        }
    };
    private BdListView.e gDl = new BdListView.e() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PersonalCardCategoryActivity.this.nCV != null) {
                PersonalCardCategoryActivity.this.nCV.dSQ();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nCU = new c(this);
        this.nCU.setOnSrollToBottomListener(this.gDl);
        this.nCU.setCardViewController(this.nCP);
        this.nCV = new PersonalCardCategoryModel(this);
        this.nCV.a(this.nCX);
        this.nCW = new SetPersonalCardModel();
        this.nCW.a(this.nCY);
        showLoadingView(this.nCU.getRootView());
        this.nCV.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nCU != null) {
            this.nCU.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nCV != null) {
            this.nCV.onDestroy();
        }
        if (this.nCW != null) {
            this.nCW.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nCV != null && this.nCU != null) {
            showLoadingView(this.nCU.getRootView());
            this.nCV.LoadData();
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
