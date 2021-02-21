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
    private SetPersonalCardModel nIC;
    private PersonalCardDetailModel nIQ;
    private a nIR;
    private long nIS;
    private PersonalCardDetailModel.a nIT = new PersonalCardDetailModel.a() { // from class: com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailActivity.1
        @Override // com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailModel.a
        public void b(int i, String str, com.baidu.tieba.themeCenter.a aVar) {
            PersonalCardDetailActivity.this.hideLoadingView(PersonalCardDetailActivity.this.nIR.getRootView());
            if (i != 0) {
                PersonalCardDetailActivity.this.showToast(str);
            }
            PersonalCardDetailActivity.this.cardData = aVar;
            PersonalCardDetailActivity.this.nIR.a(i, aVar);
        }
    };
    private SetPersonalCardModel.a nIE = new SetPersonalCardModel.a() { // from class: com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailActivity.2
        @Override // com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel.a
        public void b(boolean z, long j, int i, String str, int i2) {
            if (z) {
                if (j == PersonalCardDetailActivity.this.nIS) {
                    if (i == 1) {
                        PersonalCardDetailActivity.this.cardData.Kd(1);
                    } else if (i == 2) {
                        PersonalCardDetailActivity.this.cardData.Kd(0);
                    }
                    PersonalCardDetailActivity.this.nIR.c(PersonalCardDetailActivity.this.cardData);
                    return;
                } else if (i == 1) {
                    PersonalCardDetailActivity.this.cardData.Kd(0);
                    PersonalCardDetailActivity.this.nIR.c(PersonalCardDetailActivity.this.cardData);
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
            if (view != null && view == PersonalCardDetailActivity.this.nIR.dRt()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (PersonalCardDetailActivity.this.nIC == null) {
                        PersonalCardDetailActivity.this.nIC = new SetPersonalCardModel();
                    }
                    if (PersonalCardDetailActivity.this.cardData.dQZ() == 1) {
                        PersonalCardDetailActivity.this.nIC.J(PersonalCardDetailActivity.this.nIS, 2);
                        return;
                    } else {
                        PersonalCardDetailActivity.this.nIC.J(PersonalCardDetailActivity.this.nIS, 1);
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
        this.nIS = getIntent().getLongExtra(PersonalCardDetailActivityConfig.CARD_ID, 0L);
        this.nIR = new a(this, this.mClickListener);
        this.nIQ = new PersonalCardDetailModel();
        this.nIQ.a(this.nIT);
        this.nIC = new SetPersonalCardModel();
        this.nIC.a(this.nIE);
        showLoadingView(this.nIR.getRootView(), false);
        this.nIQ.hz(this.nIS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            b.bCI().bCJ();
            showLoadingView(this.nIR.getRootView(), false);
            this.nIQ.hz(this.nIS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nIQ != null) {
            this.nIQ.onDestroy();
        }
        if (this.nIC != null) {
            this.nIC.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nIR != null) {
            this.nIR.bup();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nIQ != null && this.nIR != null) {
            showLoadingView(this.nIR.getRootView(), false);
            this.nIQ.hz(this.nIS);
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
                if (i == c.nGc) {
                    com.baidu.tieba.themeCenter.b.a(getPageContext(), 6, str, i2, MemberPayStatistic.REFER_PAGE_CARDS_TRY, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
                } else if (i == c.nGd) {
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
            pageStayDurationItem.objID = String.valueOf(this.nIS);
        }
        return pageStayDurationItem;
    }
}
