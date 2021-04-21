package com.baidu.tieba.themeCenter.card.category;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryModel;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel;
import d.b.j0.j3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class PersonalCardCategoryActivity extends BaseActivity<PersonalCardCategoryActivity> {
    public PersonalCardCategoryModel mModel;
    public SetPersonalCardModel mSetCardModel;
    public d.b.j0.j3.g.a.c mView;
    public PersonalCardItemView.b mCardViewController = new a();
    public PersonalCardCategoryModel.b mDataCallback = new b();
    public SetPersonalCardModel.b mSetCardCallback = new c();
    public BdListView.p mScrollToBottomListener = new d();

    /* loaded from: classes5.dex */
    public class a implements PersonalCardItemView.b {
        public a() {
        }

        @Override // com.baidu.tieba.themeCenter.card.category.PersonalCardItemView.b
        public void a(d.b.j0.j3.a aVar) {
            if (aVar == null) {
                return;
            }
            if (aVar.a() == d.b.j0.j3.a.k) {
                if (aVar.g() == 1 || PersonalCardCategoryActivity.this.mSetCardModel == null) {
                    return;
                }
                PersonalCardCategoryActivity.this.mSetCardModel.y(aVar.a(), 1);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(PersonalCardCategoryActivity.this.getPageContext().getPageActivity(), aVar.a())));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements PersonalCardCategoryModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryModel.b
        public void a(int i, String str, e eVar, List<d.b.j0.j3.g.a.a> list, boolean z) {
            PersonalCardCategoryActivity personalCardCategoryActivity = PersonalCardCategoryActivity.this;
            personalCardCategoryActivity.hideLoadingView(personalCardCategoryActivity.mView.c());
            if (i != 0) {
                PersonalCardCategoryActivity.this.showToast(str);
            }
            PersonalCardCategoryActivity.this.mView.j(i, eVar, list, true);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements SetPersonalCardModel.b {
        public c() {
        }

        @Override // com.baidu.tieba.themeCenter.card.setCard.SetPersonalCardModel.b
        public void a(boolean z, long j, int i, String str, int i2) {
            if (z && PersonalCardCategoryActivity.this.mModel != null) {
                PersonalCardCategoryActivity.this.mModel.B(j, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements BdListView.p {
        public d() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (PersonalCardCategoryActivity.this.mModel != null) {
                PersonalCardCategoryActivity.this.mModel.A();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.b.i0.k0.a
    public String getCurrentPageKey() {
        return "b012";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d.b.i0.k0.d getPageStayDurationItem() {
        d.b.i0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.f50982a = true;
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.j0.j3.g.a.c cVar = this.mView;
        if (cVar != null) {
            cVar.d();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.b.j0.j3.g.a.c cVar = new d.b.j0.j3.g.a.c(this);
        this.mView = cVar;
        cVar.h(this.mScrollToBottomListener);
        this.mView.g(this.mCardViewController);
        PersonalCardCategoryModel personalCardCategoryModel = new PersonalCardCategoryModel(this);
        this.mModel = personalCardCategoryModel;
        personalCardCategoryModel.D(this.mDataCallback);
        SetPersonalCardModel setPersonalCardModel = new SetPersonalCardModel();
        this.mSetCardModel = setPersonalCardModel;
        setPersonalCardModel.x(this.mSetCardCallback);
        showLoadingView(this.mView.c());
        this.mModel.LoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PersonalCardCategoryModel personalCardCategoryModel = this.mModel;
        if (personalCardCategoryModel != null) {
            personalCardCategoryModel.onDestroy();
        }
        SetPersonalCardModel setPersonalCardModel = this.mSetCardModel;
        if (setPersonalCardModel != null) {
            setPersonalCardModel.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        d.b.j0.j3.g.a.c cVar;
        if (this.mModel == null || (cVar = this.mView) == null) {
            return;
        }
        showLoadingView(cVar.c());
        this.mModel.LoadData();
    }
}
