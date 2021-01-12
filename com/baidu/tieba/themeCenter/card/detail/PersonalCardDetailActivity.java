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
    private PersonalCardDetailModel nyF;
    private a nyG;
    private long nyH;
    private SetPersonalCardModel nyr;
    private PersonalCardDetailModel.a nyI = new PersonalCardDetailModel.a() { // from class: com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailActivity.1
        @Override // com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailModel.a
        public void b(int i, String str, com.baidu.tieba.themeCenter.a aVar) {
            PersonalCardDetailActivity.this.hideLoadingView(PersonalCardDetailActivity.this.nyG.getRootView());
            if (i != 0) {
                PersonalCardDetailActivity.this.showToast(str);
            }
            PersonalCardDetailActivity.this.cardData = aVar;
            PersonalCardDetailActivity.this.nyG.a(i, aVar);
        }
    };
    private SetPersonalCardModel.a nyt = new SetPersonalCardModel.a() { // from class: com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailActivity.2
        @Override // com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel.a
        public void b(boolean z, long j, int i, String str, int i2) {
            if (z) {
                if (j == PersonalCardDetailActivity.this.nyH) {
                    if (i == 1) {
                        PersonalCardDetailActivity.this.cardData.JJ(1);
                    } else if (i == 2) {
                        PersonalCardDetailActivity.this.cardData.JJ(0);
                    }
                    PersonalCardDetailActivity.this.nyG.c(PersonalCardDetailActivity.this.cardData);
                    return;
                } else if (i == 1) {
                    PersonalCardDetailActivity.this.cardData.JJ(0);
                    PersonalCardDetailActivity.this.nyG.c(PersonalCardDetailActivity.this.cardData);
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
            if (view != null && view == PersonalCardDetailActivity.this.nyG.dPa()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (PersonalCardDetailActivity.this.nyr == null) {
                        PersonalCardDetailActivity.this.nyr = new SetPersonalCardModel();
                    }
                    if (PersonalCardDetailActivity.this.cardData.dOG() == 1) {
                        PersonalCardDetailActivity.this.nyr.L(PersonalCardDetailActivity.this.nyH, 2);
                        return;
                    } else {
                        PersonalCardDetailActivity.this.nyr.L(PersonalCardDetailActivity.this.nyH, 1);
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
        this.nyH = getIntent().getLongExtra(PersonalCardDetailActivityConfig.CARD_ID, 0L);
        this.nyG = new a(this, this.mClickListener);
        this.nyF = new PersonalCardDetailModel();
        this.nyF.a(this.nyI);
        this.nyr = new SetPersonalCardModel();
        this.nyr.a(this.nyt);
        showLoadingView(this.nyG.getRootView(), false);
        this.nyF.hu(this.nyH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            b.bCq().bCr();
            showLoadingView(this.nyG.getRootView(), false);
            this.nyF.hu(this.nyH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nyF != null) {
            this.nyF.onDestroy();
        }
        if (this.nyr != null) {
            this.nyr.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nyG != null) {
            this.nyG.btV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nyF != null && this.nyG != null) {
            showLoadingView(this.nyG.getRootView(), false);
            this.nyF.hu(this.nyH);
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
                if (i == c.nvR) {
                    com.baidu.tieba.themeCenter.b.a(getPageContext(), 6, str, i2, MemberPayStatistic.REFER_PAGE_CARDS_TRY, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
                } else if (i == c.nvS) {
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
            pageStayDurationItem.objID = String.valueOf(this.nyH);
        }
        return pageStayDurationItem;
    }
}
