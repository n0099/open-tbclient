package com.baidu.tieba.themeCenter.card.detail;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.getUserInfo.b;
import com.baidu.tbadk.m.d;
import com.baidu.tieba.themeCenter.c;
import com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailModel;
import com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel;
/* loaded from: classes9.dex */
public class PersonalCardDetailActivity extends BaseActivity<PersonalCardDetailActivity> {
    private com.baidu.tieba.themeCenter.a cardData;
    private SetPersonalCardModel nIc;
    private PersonalCardDetailModel nIq;
    private a nIr;
    private long nIs;
    private PersonalCardDetailModel.a nIt = new PersonalCardDetailModel.a() { // from class: com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailActivity.1
        @Override // com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailModel.a
        public void b(int i, String str, com.baidu.tieba.themeCenter.a aVar) {
            PersonalCardDetailActivity.this.hideLoadingView(PersonalCardDetailActivity.this.nIr.getRootView());
            if (i != 0) {
                PersonalCardDetailActivity.this.showToast(str);
            }
            PersonalCardDetailActivity.this.cardData = aVar;
            PersonalCardDetailActivity.this.nIr.a(i, aVar);
        }
    };
    private SetPersonalCardModel.a nIe = new SetPersonalCardModel.a() { // from class: com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailActivity.2
        @Override // com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel.a
        public void b(boolean z, long j, int i, String str, int i2) {
            if (z) {
                if (j == PersonalCardDetailActivity.this.nIs) {
                    if (i == 1) {
                        PersonalCardDetailActivity.this.cardData.Kd(1);
                    } else if (i == 2) {
                        PersonalCardDetailActivity.this.cardData.Kd(0);
                    }
                    PersonalCardDetailActivity.this.nIr.c(PersonalCardDetailActivity.this.cardData);
                    return;
                } else if (i == 1) {
                    PersonalCardDetailActivity.this.cardData.Kd(0);
                    PersonalCardDetailActivity.this.nIr.c(PersonalCardDetailActivity.this.cardData);
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
            if (view != null && view == PersonalCardDetailActivity.this.nIr.dRl()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (PersonalCardDetailActivity.this.nIc == null) {
                        PersonalCardDetailActivity.this.nIc = new SetPersonalCardModel();
                    }
                    if (PersonalCardDetailActivity.this.cardData.dQR() == 1) {
                        PersonalCardDetailActivity.this.nIc.J(PersonalCardDetailActivity.this.nIs, 2);
                        return;
                    } else {
                        PersonalCardDetailActivity.this.nIc.J(PersonalCardDetailActivity.this.nIs, 1);
                        return;
                    }
                }
                bh.skipToLoginActivity(PersonalCardDetailActivity.this.getPageContext().getPageActivity());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nIs = getIntent().getLongExtra(PersonalCardDetailActivityConfig.CARD_ID, 0L);
        this.nIr = new a(this, this.mClickListener);
        this.nIq = new PersonalCardDetailModel();
        this.nIq.a(this.nIt);
        this.nIc = new SetPersonalCardModel();
        this.nIc.a(this.nIe);
        showLoadingView(this.nIr.getRootView(), false);
        this.nIq.hz(this.nIs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            b.bCI().bCJ();
            showLoadingView(this.nIr.getRootView(), false);
            this.nIq.hz(this.nIs);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nIq != null) {
            this.nIq.onDestroy();
        }
        if (this.nIc != null) {
            this.nIc.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nIr != null) {
            this.nIr.bup();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nIq != null && this.nIr != null) {
            showLoadingView(this.nIr.getRootView(), false);
            this.nIq.hz(this.nIs);
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
                if (i == c.nFC) {
                    com.baidu.tieba.themeCenter.b.a(getPageContext(), 6, str, i2, MemberPayStatistic.REFER_PAGE_CARDS_TRY, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
                } else if (i == c.nFD) {
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
            pageStayDurationItem.objID = String.valueOf(this.nIs);
        }
        return pageStayDurationItem;
    }
}
