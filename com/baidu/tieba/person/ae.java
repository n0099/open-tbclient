package com.baidu.tieba.person;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.e {
    private static final String aOC = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/like";
    private static TbHttpMessageTask aOD = new TbHttpMessageTask(CmdConfigHttp.PIC_LIKE_BAR_CMD, aOC);
    private boolean bIP;
    private int dsg;
    private r mData;
    private String mId;
    private int mSex;

    static {
        aOD.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(aOD);
    }

    public ae(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.mData = new r();
        this.bIP = z;
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

    public boolean ahG() {
        return this.bIP;
    }

    public void my(int i) {
        this.dsg = i;
    }

    public r aBj() {
        return this.mData;
    }

    public void aBh() {
        super.sendMessage(new PersonBarByUidLocalMessage());
    }

    public void a(boolean z, String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_LIKE_BAR_CMD);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        if (!ahG()) {
            httpMessage.addParam("friend_uid", str);
            httpMessage.addParam("is_guest", String.valueOf(1));
            httpMessage.setExtra(str);
        }
        httpMessage.addParam("page_size", i2);
        httpMessage.addParam("page_no", i);
        super.sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void mn(String str) {
        if (this.dsg == 1 && this.bIP) {
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
            }
            if (str != null) {
                try {
                    com.baidu.adp.lib.cache.o<String> cz = com.baidu.tbadk.core.b.a.um().cz("tb.my_pages");
                    if (cz != null) {
                        cz.a(str2, str, TbConfig.APP_OVERDUR_DRAFT_BOX);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
