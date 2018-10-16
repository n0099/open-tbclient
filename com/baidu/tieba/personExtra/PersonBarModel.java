package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes3.dex */
public class PersonBarModel extends BdBaseModel {
    private static final String bzA = TbConfig.SERVER_ADDRESS + "c/f/forum/like";
    private static TbHttpMessageTask task = new TbHttpMessageTask(CmdConfigHttp.PIC_LIKE_BAR_CMD, bzA);
    private int glR;
    private a mData;
    private String mId;
    private boolean mIsHost;
    private int mSex;

    static {
        task.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(task);
    }

    public PersonBarModel(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.mData = new a();
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

    public boolean aSn() {
        return this.mIsHost;
    }

    public void sp(int i) {
        this.glR = i;
    }

    public a bog() {
        return this.mData;
    }

    public void boe() {
        super.sendMessage(new PersonBarByUidLocalMessage());
    }

    public void a(boolean z, String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_LIKE_BAR_CMD);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        if (!aSn()) {
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

    public void tc(String str) {
        if (this.glR == 1 && this.mIsHost) {
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
            }
            if (str != null) {
                try {
                    l<String> eg = com.baidu.tbadk.core.c.a.Aq().eg("tb.my_pages");
                    if (eg != null) {
                        eg.a(str2, str, 604800000L);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
