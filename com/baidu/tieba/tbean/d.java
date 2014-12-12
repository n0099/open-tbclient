package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.f<BuyTBeanActivity> {
    private BuyTBeanActivity bZZ;
    private i caa;
    private List<IconInfo> iconInfoList;
    private UserInfo userInfo;

    public d(BuyTBeanActivity buyTBeanActivity, i iVar) {
        super(buyTBeanActivity.getPageContext());
        this.bZZ = buyTBeanActivity;
        this.caa = iVar;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public List<IconInfo> getIconInfoList() {
        return aG(this.iconInfoList);
    }

    public void aii() {
        sendMessage(new GetYinJiRequestMessage());
    }

    public void aij() {
        e eVar = new e(this, 306001);
        eVar.setSelfListener(true);
        registerListener(eVar);
    }

    public void aik() {
        f fVar = new f(this, CmdConfigHttp.CMD_HTTP_GET_YINJI);
        fVar.setSelfListener(true);
        registerListener(fVar);
    }

    public void ail() {
        registerListener(new g(this, CmdConfigHttp.GETPAYINFO_CMD));
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    private List<IconInfo> aG(List<IconInfo> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            IconInfo iconInfo = list.get(i2);
            if (iconInfo != null && iconInfo.non_member_t.intValue() > 0) {
                arrayList.add(iconInfo);
            }
            i = i2 + 1;
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        Collections.sort(arrayList, new h(this));
        return arrayList;
    }
}
