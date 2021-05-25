package com.baidu.tieba.themeCenter.avatarPendant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantModel;
import com.baidu.tieba.themeCenter.avatarPendant.SetAvatarPendantModel;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.a.m0.t.n;
import d.a.n0.k3.d.c;
import d.a.n0.k3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class AvatarPendantActivity extends BaseActivity implements c.a, SetAvatarPendantModel.b, View.OnClickListener {
    public boolean mHasListData;
    public AvatarPendantModel mModel;
    public SetAvatarPendantModel mSetAvatarPendantModel;
    public c mView;
    public String mCurrentCategory = "";
    public AvatarPendantModel.b mCallback = new a();
    public NoNetworkView.b mNetListener = new b();

    /* loaded from: classes5.dex */
    public class a implements AvatarPendantModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantModel.b
        public void a(int i2, String str, e eVar, List<d.a.n0.k3.d.a> list) {
            AvatarPendantActivity avatarPendantActivity = AvatarPendantActivity.this;
            avatarPendantActivity.hideLoadingView(avatarPendantActivity.mView.g());
            if (i2 == 0) {
                AvatarPendantActivity.this.mView.o(eVar, list);
            } else {
                AvatarPendantActivity.this.showToast(str);
                AvatarPendantActivity.this.mView.n();
            }
            AvatarPendantActivity.this.mHasListData = !ListUtils.isEmpty(list);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NoNetworkView.b {
        public b() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            BdListViewHelper.c(AvatarPendantActivity.this.mView.h(), BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    private boolean checkLogin() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        TiebaStatic.log("c11615");
        TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11041)));
        return false;
    }

    private String getCurrentCategory(DressItemData dressItemData) {
        String str = "";
        if (dressItemData == null) {
            return "";
        }
        List<d.a.n0.k3.d.a> x = this.mModel.x();
        if (x != null && x.size() > 0) {
            int size = x.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (x.get(i2) != null && !ListUtils.isEmpty(x.get(i2).b())) {
                    List<DressItemData> b2 = x.get(i2).b();
                    int size2 = b2.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size2) {
                            break;
                        }
                        if (b2.get(i3) != null && dressItemData.getPropsId() == b2.get(i3).getPropsId()) {
                            str = x.get(i2).a();
                            break;
                        }
                        i3++;
                    }
                }
            }
        }
        return str;
    }

    private void initData() {
        AvatarPendantModel avatarPendantModel = new AvatarPendantModel(this);
        this.mModel = avatarPendantModel;
        avatarPendantModel.z(this.mCallback);
        SetAvatarPendantModel setAvatarPendantModel = new SetAvatarPendantModel();
        this.mSetAvatarPendantModel = setAvatarPendantModel;
        setAvatarPendantModel.z(this);
    }

    private void initUI() {
        c cVar = new c(this);
        this.mView = cVar;
        cVar.d(this.mNetListener);
        this.mView.m(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 11041) {
            this.mModel.LoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        this.mView.j();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mView.f().getButton() && checkLogin()) {
            TiebaStatic.log("c11613");
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 22);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT, MemberPayStatistic.CLICK_ZONE_OPENDE_RENEWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
        showLoadingView(this.mView.g());
        this.mModel.LoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mSetAvatarPendantModel.onDestroy();
        this.mModel.y();
    }

    @Override // d.a.n0.k3.d.c.a
    public void onItemClick(DressItemData dressItemData) {
        if (checkLogin() && dressItemData != null && dressItemData.getPropsId() >= 0 && this.mHasListData) {
            this.mCurrentCategory = getCurrentCategory(dressItemData);
            TiebaStatic.log(new StatisticItem("c11614").param("obj_type", this.mCurrentCategory));
            this.mSetAvatarPendantModel.x(dressItemData.getPropsId(), 1, dressItemData.getFreeUserLevel());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        c cVar;
        if (this.mModel == null || (cVar = this.mView) == null) {
            return;
        }
        showLoadingView(cVar.g());
        this.mModel.LoadData();
    }

    @Override // com.baidu.tieba.themeCenter.avatarPendant.SetAvatarPendantModel.b
    public void onSetPendantCallback(boolean z, long j, int i2, String str, int i3) {
        if (!z) {
            showErrorDialog(i3, str, i2);
            return;
        }
        List<d.a.n0.k3.d.a> x = this.mModel.x();
        if (x == null || x.size() <= 0) {
            return;
        }
        if (i2 == 0) {
            TiebaStatic.log("c11681");
        } else {
            TiebaStatic.log("c11682");
        }
        int size = x.size();
        String str2 = "";
        for (int i4 = 0; i4 < size; i4++) {
            if (x.get(i4) != null && !ListUtils.isEmpty(x.get(i4).b())) {
                List<DressItemData> b2 = x.get(i4).b();
                int size2 = b2.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    if (b2.get(i5) != null && j == b2.get(i5).getPropsId()) {
                        b2.get(i5).setInUse(true);
                        str2 = b2.get(i5).getExampleImgUrl();
                    } else {
                        b2.get(i5).setInUse(false);
                    }
                }
            }
        }
        n nVar = new n();
        nVar.e(j);
        nVar.d(str2);
        this.mView.k(this.mModel.x());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016485, nVar));
    }

    public void showErrorDialog(int i2, String str, int i3) {
        int i4 = i3 == 101 ? 9 : 0;
        if (StringUtils.isNull(str)) {
            return;
        }
        if (i2 == d.a.n0.k3.c.f56957a) {
            d.a.n0.k3.b.d(getPageContext(), 7, str, i4, MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
        } else if (i2 == d.a.n0.k3.c.f56958b) {
            d.a.n0.k3.b.c(getPageContext(), 7, str, i4);
        }
    }
}
