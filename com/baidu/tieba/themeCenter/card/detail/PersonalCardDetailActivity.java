package com.baidu.tieba.themeCenter.card.detail;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailModel;
import com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel;
import d.b.h0.k0.d;
/* loaded from: classes5.dex */
public class PersonalCardDetailActivity extends BaseActivity<PersonalCardDetailActivity> {
    public d.b.i0.i3.a cardData;
    public long mCardId;
    public PersonalCardDetailModel mModel;
    public SetPersonalCardModel mSetCardModel;
    public d.b.i0.i3.g.b.a mView;
    public PersonalCardDetailModel.b mCallback = new a();
    public SetPersonalCardModel.b mSetCardCallback = new b();
    public View.OnClickListener mClickListener = new c();

    /* loaded from: classes5.dex */
    public class a implements PersonalCardDetailModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailModel.b
        public void a(int i, String str, d.b.i0.i3.a aVar) {
            PersonalCardDetailActivity personalCardDetailActivity = PersonalCardDetailActivity.this;
            personalCardDetailActivity.hideLoadingView(personalCardDetailActivity.mView.c());
            if (i != 0) {
                PersonalCardDetailActivity.this.showToast(str);
            }
            PersonalCardDetailActivity.this.cardData = aVar;
            PersonalCardDetailActivity.this.mView.h(i, aVar);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements SetPersonalCardModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel.b
        public void a(boolean z, long j, int i, String str, int i2) {
            if (z) {
                if (j != PersonalCardDetailActivity.this.mCardId) {
                    if (i == 1) {
                        PersonalCardDetailActivity.this.cardData.s(0);
                        PersonalCardDetailActivity.this.mView.i(PersonalCardDetailActivity.this.cardData);
                        return;
                    }
                    return;
                }
                if (i == 1) {
                    PersonalCardDetailActivity.this.cardData.s(1);
                } else if (i == 2) {
                    PersonalCardDetailActivity.this.cardData.s(0);
                }
                PersonalCardDetailActivity.this.mView.i(PersonalCardDetailActivity.this.cardData);
                return;
            }
            PersonalCardDetailActivity personalCardDetailActivity = PersonalCardDetailActivity.this;
            personalCardDetailActivity.showErrorDialog(i2, str, personalCardDetailActivity.cardData);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view == PersonalCardDetailActivity.this.mView.d()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (PersonalCardDetailActivity.this.mSetCardModel == null) {
                        PersonalCardDetailActivity.this.mSetCardModel = new SetPersonalCardModel();
                    }
                    if (PersonalCardDetailActivity.this.cardData.g() == 1) {
                        PersonalCardDetailActivity.this.mSetCardModel.y(PersonalCardDetailActivity.this.mCardId, 2);
                        return;
                    } else {
                        PersonalCardDetailActivity.this.mSetCardModel.y(PersonalCardDetailActivity.this.mCardId, 1);
                        return;
                    }
                }
                ViewHelper.skipToLoginActivity(PersonalCardDetailActivity.this.getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "b013";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.f50238a = true;
            pageStayDurationItem.i = String.valueOf(this.mCardId);
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.i0.i3.g.b.a aVar = this.mView;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mCardId = getIntent().getLongExtra(PersonalCardDetailActivityConfig.CARD_ID, 0L);
        this.mView = new d.b.i0.i3.g.b.a(this, this.mClickListener);
        PersonalCardDetailModel personalCardDetailModel = new PersonalCardDetailModel();
        this.mModel = personalCardDetailModel;
        personalCardDetailModel.w(this.mCallback);
        SetPersonalCardModel setPersonalCardModel = new SetPersonalCardModel();
        this.mSetCardModel = setPersonalCardModel;
        setPersonalCardModel.x(this.mSetCardCallback);
        showLoadingView(this.mView.c(), false);
        this.mModel.v(this.mCardId);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PersonalCardDetailModel personalCardDetailModel = this.mModel;
        if (personalCardDetailModel != null) {
            personalCardDetailModel.onDestroy();
        }
        SetPersonalCardModel setPersonalCardModel = this.mSetCardModel;
        if (setPersonalCardModel != null) {
            setPersonalCardModel.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        d.b.i0.i3.g.b.a aVar;
        if (this.mModel == null || (aVar = this.mView) == null) {
            return;
        }
        showLoadingView(aVar.c(), false);
        this.mModel.v(this.mCardId);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            d.b.h0.z.b.a().d();
            showLoadingView(this.mView.c(), false);
            this.mModel.v(this.mCardId);
        }
    }

    public void showErrorDialog(int i, String str, d.b.i0.i3.a aVar) {
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f() == 101 ? 9 : 0;
        if (StringUtils.isNull(str)) {
            return;
        }
        if (i == d.b.i0.i3.c.f56218a) {
            d.b.i0.i3.b.d(getPageContext(), 6, str, i2, MemberPayStatistic.REFER_PAGE_CARDS_TRY, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
        } else if (i == d.b.i0.i3.c.f56219b) {
            d.b.i0.i3.b.c(getPageContext(), 6, str, i2);
        }
    }
}
