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
    private c nGf;
    private AvatarPendantModel nGg;
    private SetAvatarPendantModel nGh;
    private boolean nGj;
    private String nGi = "";
    private AvatarPendantModel.a nGk = new AvatarPendantModel.a() { // from class: com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity.1
        @Override // com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantModel.a
        public void a(int i, String str, e eVar, List<a> list) {
            AvatarPendantActivity.this.hideLoadingView(AvatarPendantActivity.this.nGf.getRootView());
            if (i == 0) {
                AvatarPendantActivity.this.nGf.a(eVar, list);
            } else {
                AvatarPendantActivity.this.showToast(str);
                AvatarPendantActivity.this.nGf.cAO();
            }
            AvatarPendantActivity.this.nGj = !y.isEmpty(list);
        }
    };
    private NoNetworkView.a fLS = new NoNetworkView.a() { // from class: com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            BdListViewHelper.a(AvatarPendantActivity.this.nGf.dRj(), BdListViewHelper.HeadType.DEFAULT, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
        showLoadingView(this.nGf.getRootView());
        this.nGg.LoadData();
    }

    private void initUI() {
        this.nGf = new c(this);
        this.nGf.a(this.fLS);
        this.nGf.setAvatarPendantItemClickListener(this);
    }

    private void initData() {
        this.nGg = new AvatarPendantModel(this);
        this.nGg.a(this.nGk);
        this.nGh = new SetAvatarPendantModel();
        this.nGh.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nGg != null && this.nGf != null) {
            showLoadingView(this.nGf.getRootView());
            this.nGg.LoadData();
        }
    }

    @Override // com.baidu.tieba.themeCenter.avatarPendant.c.a
    public void b(DressItemData dressItemData) {
        if (HZ() && dressItemData != null && dressItemData.getPropsId() >= 0 && this.nGj) {
            this.nGi = c(dressItemData);
            TiebaStatic.log(new ar("c11614").dR("obj_type", this.nGi));
            this.nGh.i(dressItemData.getPropsId(), 1, dressItemData.getFreeUserLevel());
        }
    }

    private String c(DressItemData dressItemData) {
        List<a> dRh;
        String str;
        String str2 = "";
        if (dressItemData != null && (dRh = this.nGg.dRh()) != null && dRh.size() > 0) {
            int size = dRh.size();
            int i = 0;
            while (i < size) {
                if (dRh.get(i) != null && !y.isEmpty(dRh.get(i).dRh())) {
                    List<DressItemData> dRh2 = dRh.get(i).dRh();
                    int size2 = dRh2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (dRh2.get(i2) != null && dressItemData.getPropsId() == dRh2.get(i2).getPropsId()) {
                            str = dRh.get(i).dRg();
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
        this.nGh.onDestroy();
        this.nGg.onDestory();
    }

    public void i(int i, String str, int i2) {
        int i3;
        if (i2 == 101) {
            i3 = 9;
        } else {
            i3 = 0;
        }
        if (!StringUtils.isNull(str)) {
            if (i == com.baidu.tieba.themeCenter.c.nGc) {
                com.baidu.tieba.themeCenter.b.a(getPageContext(), 7, str, i3, MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
            } else if (i == com.baidu.tieba.themeCenter.c.nGd) {
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
        List<a> dRh = this.nGg.dRh();
        if (dRh != null && dRh.size() > 0) {
            if (i == 0) {
                TiebaStatic.log("c11681");
            } else {
                TiebaStatic.log("c11682");
            }
            String str3 = "";
            int size = dRh.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (dRh.get(i3) != null && !y.isEmpty(dRh.get(i3).dRh())) {
                    List<DressItemData> dRh2 = dRh.get(i3).dRh();
                    int size2 = dRh2.size();
                    int i4 = 0;
                    while (i4 < size2) {
                        if (dRh2.get(i4) != null && j == dRh2.get(i4).getPropsId()) {
                            dRh2.get(i4).setInUse(true);
                            str2 = dRh2.get(i4).getExampleImgUrl();
                        } else {
                            dRh2.get(i4).setInUse(false);
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
            this.nGf.fT(this.nGg.dRh());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_PENDANT, nVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.nGf.bzn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_AVATAR_PENDANT /* 11041 */:
                    this.nGg.LoadData();
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
        if (view == this.nGf.dRi().getButton() && HZ()) {
            TiebaStatic.log("c11613");
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 22);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT, MemberPayStatistic.CLICK_ZONE_OPENDE_RENEWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }
}
