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
/* loaded from: classes6.dex */
public class PersonBarModel extends BdBaseModel {
    private static final String djO = TbConfig.SERVER_ADDRESS + Config.FORUM_LIKE_ADDRESS;
    private static TbHttpMessageTask task = new TbHttpMessageTask(1002002, djO);
    private int inp;
    private b mData;
    private String mId;
    private boolean mIsHost;
    private int mSex;

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

    public boolean bDw() {
        return this.mIsHost;
    }

    public void setCurrentPageIndex(int i) {
        this.inp = i;
    }

    public b cac() {
        return this.mData;
    }

    public void caa() {
        super.sendMessage(new PersonBarByUidLocalMessage());
    }

    public void a(boolean z, String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1002002);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        if (!bDw()) {
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

    public void BC(String str) {
        if (this.inp == 1 && this.mIsHost) {
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
            }
            if (str != null) {
                try {
                    l<String> nl = com.baidu.tbadk.core.d.a.akL().nl("tb.my_pages");
                    if (nl != null) {
                        nl.set(str2, str, 604800000L);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
