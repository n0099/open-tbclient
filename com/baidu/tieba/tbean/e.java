package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.e<BuyTBeanActivity> {
    private BuyTBeanActivity eaa;
    private a eab;
    private List<IconInfo> iconInfoList;
    private UserInfo userInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void ht(String str);

        void onSuccess();
    }

    public e(BuyTBeanActivity buyTBeanActivity, a aVar) {
        super(buyTBeanActivity.getPageContext());
        this.eaa = buyTBeanActivity;
        this.eab = aVar;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public List<IconInfo> getIconInfoList() {
        return ce(this.iconInfoList);
    }

    public void aNM() {
        sendMessage(new GetYinJiRequestMessage());
    }

    public void aNN() {
        f fVar = new f(this, 306001);
        fVar.setSelfListener(true);
        registerListener(fVar);
    }

    public void aNO() {
        g gVar = new g(this, CmdConfigHttp.CMD_HTTP_GET_YINJI);
        gVar.setSelfListener(true);
        registerListener(gVar);
    }

    public void aNP() {
        registerListener(new h(this, CmdConfigHttp.GETPAYINFO_CMD));
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private List<IconInfo> ce(List<IconInfo> list) {
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
        Collections.sort(arrayList, new i(this));
        return arrayList;
    }
}
