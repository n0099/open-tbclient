package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.f<BuyTBeanActivity> {
    private BuyTBeanActivity cuK;
    private i cuL;
    private List<IconInfo> iconInfoList;
    private UserInfo userInfo;

    public d(BuyTBeanActivity buyTBeanActivity, i iVar) {
        super(buyTBeanActivity.getPageContext());
        this.cuK = buyTBeanActivity;
        this.cuL = iVar;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public List<IconInfo> getIconInfoList() {
        return bb(this.iconInfoList);
    }

    public void apN() {
        sendMessage(new GetYinJiRequestMessage());
    }

    public void apO() {
        e eVar = new e(this, 306001);
        eVar.setSelfListener(true);
        registerListener(eVar);
    }

    public void apP() {
        f fVar = new f(this, CmdConfigHttp.CMD_HTTP_GET_YINJI);
        fVar.setSelfListener(true);
        registerListener(fVar);
    }

    public void apQ() {
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

    private List<IconInfo> bb(List<IconInfo> list) {
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
