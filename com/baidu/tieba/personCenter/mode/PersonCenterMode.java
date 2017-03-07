package com.baidu.tieba.personCenter.mode;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.person.ProfileRequestMessage;
/* loaded from: classes.dex */
public class PersonCenterMode extends BdBaseModel<BaseFragmentActivity> {
    private a eDc;
    private final com.baidu.adp.framework.listener.a eDd;

    public PersonCenterMode(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.eDd = new b(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        registerListener(this.eDd);
    }

    public void a(a aVar) {
        this.eDc = aVar;
    }

    public boolean Fe() {
        return LoadData();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        if (i.gS()) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Long.valueOf(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)));
            }
            profileRequestMessage.set_need_post_count(1);
            profileRequestMessage.set_pn(1);
            profileRequestMessage.set_rn(20);
            profileRequestMessage.set_has_plist(1);
            profileRequestMessage.set_from_db(false);
            profileRequestMessage.set_error_hint(true);
            profileRequestMessage.setSelf(true);
            sendMessage(profileRequestMessage);
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }
}
