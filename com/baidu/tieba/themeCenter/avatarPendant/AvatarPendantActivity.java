package com.baidu.tieba.themeCenter.avatarPendant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.n;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantModel;
import com.baidu.tieba.themeCenter.avatarPendant.SetAvatarPendantModel;
import com.baidu.tieba.themeCenter.avatarPendant.c;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.dressCenter.e;
import java.util.List;
/* loaded from: classes9.dex */
public class AvatarPendantActivity extends BaseActivity implements View.OnClickListener, SetAvatarPendantModel.a, c.a {
    private c nFF;
    private AvatarPendantModel nFG;
    private SetAvatarPendantModel nFH;
    private boolean nFJ;
    private String nFI = "";
    private AvatarPendantModel.a nFK = new AvatarPendantModel.a() { // from class: com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity.1
        @Override // com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantModel.a
        public void a(int i, String str, e eVar, List<a> list) {
            AvatarPendantActivity.this.hideLoadingView(AvatarPendantActivity.this.nFF.getRootView());
            if (i == 0) {
                AvatarPendantActivity.this.nFF.a(eVar, list);
            } else {
                AvatarPendantActivity.this.showToast(str);
                AvatarPendantActivity.this.nFF.cAH();
            }
            AvatarPendantActivity.this.nFJ = !y.isEmpty(list);
        }
    };
    private NoNetworkView.a fLS = new NoNetworkView.a() { // from class: com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            BdListViewHelper.a(AvatarPendantActivity.this.nFF.dRb(), BdListViewHelper.HeadType.DEFAULT, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
        showLoadingView(this.nFF.getRootView());
        this.nFG.LoadData();
    }

    private void initUI() {
        this.nFF = new c(this);
        this.nFF.a(this.fLS);
        this.nFF.setAvatarPendantItemClickListener(this);
    }

    private void initData() {
        this.nFG = new AvatarPendantModel(this);
        this.nFG.a(this.nFK);
        this.nFH = new SetAvatarPendantModel();
        this.nFH.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nFG != null && this.nFF != null) {
            showLoadingView(this.nFF.getRootView());
            this.nFG.LoadData();
        }
    }

    @Override // com.baidu.tieba.themeCenter.avatarPendant.c.a
    public void b(DressItemData dressItemData) {
        if (HZ() && dressItemData != null && dressItemData.getPropsId() >= 0 && this.nFJ) {
            this.nFI = c(dressItemData);
            TiebaStatic.log(new ar("c11614").dR("obj_type", this.nFI));
            this.nFH.i(dressItemData.getPropsId(), 1, dressItemData.getFreeUserLevel());
        }
    }

    private String c(DressItemData dressItemData) {
        List<a> dQZ;
        String str;
        String str2 = "";
        if (dressItemData != null && (dQZ = this.nFG.dQZ()) != null && dQZ.size() > 0) {
            int size = dQZ.size();
            int i = 0;
            while (i < size) {
                if (dQZ.get(i) != null && !y.isEmpty(dQZ.get(i).dQZ())) {
                    List<DressItemData> dQZ2 = dQZ.get(i).dQZ();
                    int size2 = dQZ2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (dQZ2.get(i2) != null && dressItemData.getPropsId() == dQZ2.get(i2).getPropsId()) {
                            str = dQZ.get(i).dQY();
                            break;
                        }
                    }
                }
                str = str2;
                i++;
                str2 = str;
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.nFH.onDestroy();
        this.nFG.onDestory();
    }

    public void i(int i, String str, int i2) {
        int i3;
        if (i2 == 101) {
            i3 = 9;
        } else {
            i3 = 0;
        }
        if (!StringUtils.isNull(str)) {
            if (i == com.baidu.tieba.themeCenter.c.nFC) {
                com.baidu.tieba.themeCenter.b.a(getPageContext(), 7, str, i3, MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
            } else if (i == com.baidu.tieba.themeCenter.c.nFD) {
                com.baidu.tieba.themeCenter.b.a(getPageContext(), 7, str, i3);
            }
        }
    }

    @Override // com.baidu.tieba.themeCenter.avatarPendant.SetAvatarPendantModel.a
    public void a(boolean z, long j, int i, String str, int i2) {
        String str2;
        if (!z) {
            i(i2, str, i);
            return;
        }
        List<a> dQZ = this.nFG.dQZ();
        if (dQZ != null && dQZ.size() > 0) {
            if (i == 0) {
                TiebaStatic.log("c11681");
            } else {
                TiebaStatic.log("c11682");
            }
            String str3 = "";
            int size = dQZ.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (dQZ.get(i3) != null && !y.isEmpty(dQZ.get(i3).dQZ())) {
                    List<DressItemData> dQZ2 = dQZ.get(i3).dQZ();
                    int size2 = dQZ2.size();
                    int i4 = 0;
                    while (i4 < size2) {
                        if (dQZ2.get(i4) != null && j == dQZ2.get(i4).getPropsId()) {
                            dQZ2.get(i4).setInUse(true);
                            str2 = dQZ2.get(i4).getExampleImgUrl();
                        } else {
                            dQZ2.get(i4).setInUse(false);
                            str2 = str3;
                        }
                        i4++;
                        str3 = str2;
                    }
                }
            }
            n nVar = new n();
            nVar.ek(j);
            nVar.Ad(str3);
            this.nFF.fT(this.nFG.dQZ());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_PENDANT, nVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.nFF.bzn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_AVATAR_PENDANT /* 11041 */:
                    this.nFG.LoadData();
                    return;
                default:
                    return;
            }
        }
    }

    private boolean HZ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        TiebaStatic.log("c11615");
        TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_AVATAR_PENDANT)));
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nFF.dRa().getButton() && HZ()) {
            TiebaStatic.log("c11613");
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 22);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT, MemberPayStatistic.CLICK_ZONE_OPENDE_RENEWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }
}
