package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes8.dex */
public class PersonBarModel extends BdBaseModel {
    private static final String gjN = TbConfig.SERVER_ADDRESS + Config.FORUM_LIKE_ADDRESS;
    private static TbHttpMessageTask task = new TbHttpMessageTask(1002002, gjN);
    private b mData;
    private String mId;
    private boolean mIsHost;
    private int mSex;
    private int mwP;

    static {
        task.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(task);
    }

    public PersonBarModel(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.mData = new b();
        this.mIsHost = z;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getId() {
        return this.mId;
    }

    public void setSex(int i) {
        this.mSex = i;
    }

    public boolean Xg() {
        return this.mIsHost;
    }

    public void setCurrentPageIndex(int i) {
        this.mwP = i;
    }

    public b dxD() {
        return this.mData;
    }

    public void dxB() {
        super.sendMessage(new PersonBarByUidLocalMessage());
    }

    public void a(boolean z, String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1002002);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        if (!Xg()) {
            httpMessage.addParam("friend_uid", str);
            httpMessage.addParam("is_guest", String.valueOf(1));
            httpMessage.setExtra(str);
        }
        httpMessage.addParam("page_size", i2);
        httpMessage.addParam("page_no", i);
        super.sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void Qs(String str) {
        if (this.mwP == 1 && this.mIsHost) {
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
            }
            if (str != null) {
                try {
                    l<String> As = com.baidu.tbadk.core.c.a.bqr().As("tb.my_pages");
                    if (As != null) {
                        As.set(str2, str, 604800000L);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
