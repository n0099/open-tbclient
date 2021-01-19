package com.baidu.tieba.themeCenter.card.detail;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.getUserInfo.b;
import com.baidu.tbadk.m.d;
import com.baidu.tieba.themeCenter.c;
import com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailModel;
import com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel;
/* loaded from: classes8.dex */
public class PersonalCardDetailActivity extends BaseActivity<PersonalCardDetailActivity> {
    private com.baidu.tieba.themeCenter.a cardData;
    private PersonalCardDetailModel nyG;
    private a nyH;
    private long nyI;
    private SetPersonalCardModel nys;
    private PersonalCardDetailModel.a nyJ = new PersonalCardDetailModel.a() { // from class: com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailActivity.1
        @Override // com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailModel.a
        public void b(int i, String str, com.baidu.tieba.themeCenter.a aVar) {
            PersonalCardDetailActivity.this.hideLoadingView(PersonalCardDetailActivity.this.nyH.getRootView());
            if (i != 0) {
                PersonalCardDetailActivity.this.showToast(str);
            }
            PersonalCardDetailActivity.this.cardData = aVar;
            PersonalCardDetailActivity.this.nyH.a(i, aVar);
        }
    };
    private SetPersonalCardModel.a nyu = new SetPersonalCardModel.a() { // from class: com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailActivity.2
        @Override // com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel.a
        public void b(boolean z, long j, int i, String str, int i2) {
            if (z) {
                if (j == PersonalCardDetailActivity.this.nyI) {
                    if (i == 1) {
                        PersonalCardDetailActivity.this.cardData.JJ(1);
                    } else if (i == 2) {
                        PersonalCardDetailActivity.this.cardData.JJ(0);
                    }
                    PersonalCardDetailActivity.this.nyH.c(PersonalCardDetailActivity.this.cardData);
                    return;
                } else if (i == 1) {
                    PersonalCardDetailActivity.this.cardData.JJ(0);
                    PersonalCardDetailActivity.this.nyH.c(PersonalCardDetailActivity.this.cardData);
                    return;
                } else {
                    return;
                }
            }
            PersonalCardDetailActivity.this.a(i2, str, PersonalCardDetailActivity.this.cardData);
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view == PersonalCardDetailActivity.this.nyH.dPa()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (PersonalCardDetailActivity.this.nys == null) {
                        PersonalCardDetailActivity.this.nys = new SetPersonalCardModel();
                    }
                    if (PersonalCardDetailActivity.this.cardData.dOG() == 1) {
                        PersonalCardDetailActivity.this.nys.L(PersonalCardDetailActivity.this.nyI, 2);
                        return;
                    } else {
                        PersonalCardDetailActivity.this.nys.L(PersonalCardDetailActivity.this.nyI, 1);
                        return;
                    }
                }
                bg.skipToLoginActivity(PersonalCardDetailActivity.this.getPageContext().getPageActivity());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nyI = getIntent().getLongExtra(PersonalCardDetailActivityConfig.CARD_ID, 0L);
        this.nyH = new a(this, this.mClickListener);
        this.nyG = new PersonalCardDetailModel();
        this.nyG.a(this.nyJ);
        this.nys = new SetPersonalCardModel();
        this.nys.a(this.nyu);
        showLoadingView(this.nyH.getRootView(), false);
        this.nyG.hu(this.nyI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            b.bCq().bCr();
            showLoadingView(this.nyH.getRootView(), false);
            this.nyG.hu(this.nyI);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nyG != null) {
            this.nyG.onDestroy();
        }
        if (this.nys != null) {
            this.nys.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nyH != null) {
            this.nyH.btV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nyG != null && this.nyH != null) {
            showLoadingView(this.nyH.getRootView(), false);
            this.nyG.hu(this.nyI);
        }
    }

    public void a(int i, String str, com.baidu.tieba.themeCenter.a aVar) {
        int i2;
        if (aVar != null) {
            if (aVar.getFreeUserLevel() == 101) {
                i2 = 9;
            } else {
                i2 = 0;
            }
            if (!StringUtils.isNull(str)) {
                if (i == c.nvS) {
                    com.baidu.tieba.themeCenter.b.a(getPageContext(), 6, str, i2, MemberPayStatistic.REFER_PAGE_CARDS_TRY, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
                } else if (i == c.nvT) {
                    com.baidu.tieba.themeCenter.b.a(getPageContext(), 6, str, i2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.CARD_DETAIL;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.isRouteStat = true;
            pageStayDurationItem.objID = String.valueOf(this.nyI);
        }
        return pageStayDurationItem;
    }
}
