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
/* loaded from: classes8.dex */
public class AvatarPendantActivity extends BaseActivity implements View.OnClickListener, SetAvatarPendantModel.a, c.a {
    private c nIl;
    private AvatarPendantModel nIm;
    private SetAvatarPendantModel nIn;
    private boolean nIp;
    private String nIo = "";
    private AvatarPendantModel.a nIq = new AvatarPendantModel.a() { // from class: com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity.1
        @Override // com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantModel.a
        public void a(int i, String str, e eVar, List<a> list) {
            AvatarPendantActivity.this.hideLoadingView(AvatarPendantActivity.this.nIl.getRootView());
            if (i == 0) {
                AvatarPendantActivity.this.nIl.a(eVar, list);
            } else {
                AvatarPendantActivity.this.showToast(str);
                AvatarPendantActivity.this.nIl.cAU();
            }
            AvatarPendantActivity.this.nIp = !y.isEmpty(list);
        }
    };
    private NoNetworkView.a fNs = new NoNetworkView.a() { // from class: com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            BdListViewHelper.a(AvatarPendantActivity.this.nIl.dRs(), BdListViewHelper.HeadType.DEFAULT, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
        showLoadingView(this.nIl.getRootView());
        this.nIm.LoadData();
    }

    private void initUI() {
        this.nIl = new c(this);
        this.nIl.a(this.fNs);
        this.nIl.setAvatarPendantItemClickListener(this);
    }

    private void initData() {
        this.nIm = new AvatarPendantModel(this);
        this.nIm.a(this.nIq);
        this.nIn = new SetAvatarPendantModel();
        this.nIn.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nIm != null && this.nIl != null) {
            showLoadingView(this.nIl.getRootView());
            this.nIm.LoadData();
        }
    }

    @Override // com.baidu.tieba.themeCenter.avatarPendant.c.a
    public void b(DressItemData dressItemData) {
        if (Ic() && dressItemData != null && dressItemData.getPropsId() >= 0 && this.nIp) {
            this.nIo = c(dressItemData);
            TiebaStatic.log(new ar("c11614").dR("obj_type", this.nIo));
            this.nIn.i(dressItemData.getPropsId(), 1, dressItemData.getFreeUserLevel());
        }
    }

    private String c(DressItemData dressItemData) {
        List<a> dRq;
        String str;
        String str2 = "";
        if (dressItemData != null && (dRq = this.nIm.dRq()) != null && dRq.size() > 0) {
            int size = dRq.size();
            int i = 0;
            while (i < size) {
                if (dRq.get(i) != null && !y.isEmpty(dRq.get(i).dRq())) {
                    List<DressItemData> dRq2 = dRq.get(i).dRq();
                    int size2 = dRq2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (dRq2.get(i2) != null && dressItemData.getPropsId() == dRq2.get(i2).getPropsId()) {
                            str = dRq.get(i).dRp();
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
        this.nIn.onDestroy();
        this.nIm.onDestory();
    }

    public void i(int i, String str, int i2) {
        int i3;
        if (i2 == 101) {
            i3 = 9;
        } else {
            i3 = 0;
        }
        if (!StringUtils.isNull(str)) {
            if (i == com.baidu.tieba.themeCenter.c.nIi) {
                com.baidu.tieba.themeCenter.b.a(getPageContext(), 7, str, i3, MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
            } else if (i == com.baidu.tieba.themeCenter.c.nIj) {
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
        List<a> dRq = this.nIm.dRq();
        if (dRq != null && dRq.size() > 0) {
            if (i == 0) {
                TiebaStatic.log("c11681");
            } else {
                TiebaStatic.log("c11682");
            }
            String str3 = "";
            int size = dRq.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (dRq.get(i3) != null && !y.isEmpty(dRq.get(i3).dRq())) {
                    List<DressItemData> dRq2 = dRq.get(i3).dRq();
                    int size2 = dRq2.size();
                    int i4 = 0;
                    while (i4 < size2) {
                        if (dRq2.get(i4) != null && j == dRq2.get(i4).getPropsId()) {
                            dRq2.get(i4).setInUse(true);
                            str2 = dRq2.get(i4).getExampleImgUrl();
                        } else {
                            dRq2.get(i4).setInUse(false);
                            str2 = str3;
                        }
                        i4++;
                        str3 = str2;
                    }
                }
            }
            n nVar = new n();
            nVar.ek(j);
            nVar.Ak(str3);
            this.nIl.fT(this.nIm.dRq());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_PENDANT, nVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.nIl.bzq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_AVATAR_PENDANT /* 11041 */:
                    this.nIm.LoadData();
                    return;
                default:
                    return;
            }
        }
    }

    private boolean Ic() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        TiebaStatic.log("c11615");
        TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_AVATAR_PENDANT)));
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nIl.dRr().getButton() && Ic()) {
            TiebaStatic.log("c11613");
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 22);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT, MemberPayStatistic.CLICK_ZONE_OPENDE_RENEWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    }
}
