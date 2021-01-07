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
/* loaded from: classes9.dex */
public class PersonalCardDetailActivity extends BaseActivity<PersonalCardDetailActivity> {
    private com.baidu.tieba.themeCenter.a cardData;
    private SetPersonalCardModel nCW;
    private PersonalCardDetailModel nDk;
    private a nDl;
    private long nDm;
    private PersonalCardDetailModel.a nDn = new PersonalCardDetailModel.a() { // from class: com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailActivity.1
        @Override // com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailModel.a
        public void b(int i, String str, com.baidu.tieba.themeCenter.a aVar) {
            PersonalCardDetailActivity.this.hideLoadingView(PersonalCardDetailActivity.this.nDl.getRootView());
            if (i != 0) {
                PersonalCardDetailActivity.this.showToast(str);
            }
            PersonalCardDetailActivity.this.cardData = aVar;
            PersonalCardDetailActivity.this.nDl.a(i, aVar);
        }
    };
    private SetPersonalCardModel.a nCY = new SetPersonalCardModel.a() { // from class: com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailActivity.2
        @Override // com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel.a
        public void b(boolean z, long j, int i, String str, int i2) {
            if (z) {
                if (j == PersonalCardDetailActivity.this.nDm) {
                    if (i == 1) {
                        PersonalCardDetailActivity.this.cardData.Lq(1);
                    } else if (i == 2) {
                        PersonalCardDetailActivity.this.cardData.Lq(0);
                    }
                    PersonalCardDetailActivity.this.nDl.c(PersonalCardDetailActivity.this.cardData);
                    return;
                } else if (i == 1) {
                    PersonalCardDetailActivity.this.cardData.Lq(0);
                    PersonalCardDetailActivity.this.nDl.c(PersonalCardDetailActivity.this.cardData);
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
            if (view != null && view == PersonalCardDetailActivity.this.nDl.dSS()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (PersonalCardDetailActivity.this.nCW == null) {
                        PersonalCardDetailActivity.this.nCW = new SetPersonalCardModel();
                    }
                    if (PersonalCardDetailActivity.this.cardData.dSy() == 1) {
                        PersonalCardDetailActivity.this.nCW.L(PersonalCardDetailActivity.this.nDm, 2);
                        return;
                    } else {
                        PersonalCardDetailActivity.this.nCW.L(PersonalCardDetailActivity.this.nDm, 1);
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
        this.nDm = getIntent().getLongExtra(PersonalCardDetailActivityConfig.CARD_ID, 0L);
        this.nDl = new a(this, this.mClickListener);
        this.nDk = new PersonalCardDetailModel();
        this.nDk.a(this.nDn);
        this.nCW = new SetPersonalCardModel();
        this.nCW.a(this.nCY);
        showLoadingView(this.nDl.getRootView(), false);
        this.nDk.hu(this.nDm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            b.bGj().bGk();
            showLoadingView(this.nDl.getRootView(), false);
            this.nDk.hu(this.nDm);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nDk != null) {
            this.nDk.onDestroy();
        }
        if (this.nCW != null) {
            this.nCW.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nDl != null) {
            this.nDl.bxP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nDk != null && this.nDl != null) {
            showLoadingView(this.nDl.getRootView(), false);
            this.nDk.hu(this.nDm);
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
                if (i == c.nAw) {
                    com.baidu.tieba.themeCenter.b.a(getPageContext(), 6, str, i2, MemberPayStatistic.REFER_PAGE_CARDS_TRY, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
                } else if (i == c.nAx) {
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
            pageStayDurationItem.objID = String.valueOf(this.nDm);
        }
        return pageStayDurationItem;
    }
}
