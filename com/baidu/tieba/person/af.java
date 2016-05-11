package com.baidu.tieba.person;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.e {
    private static final String aKM = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/like";
    private static TbHttpMessageTask aKN = new TbHttpMessageTask(CmdConfigHttp.PIC_LIKE_BAR_CMD, aKM);
    private boolean bIW;
    private int dvC;
    private r mData;
    private String mId;
    private int mSex;

    static {
        aKN.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(aKN);
    }

    public af(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.mData = new r();
        this.bIW = z;
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

    public boolean ahN() {
        return this.bIW;
    }

    public void mp(int i) {
        this.dvC = i;
    }

    public r aBF() {
        return this.mData;
    }

    public void arX() {
        super.sendMessage(new PersonBarByUidLocalMessage());
    }

    public void a(boolean z, String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_LIKE_BAR_CMD);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        if (!ahN()) {
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

    public void mr(String str) {
        if (this.dvC == 1 && this.bIW) {
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
            }
            if (str != null) {
                try {
                    com.baidu.adp.lib.cache.o<String> cx = com.baidu.tbadk.core.b.a.rR().cx("tb.my_pages");
                    if (cx != null) {
                        cx.a(str2, str, TbConfig.APP_OVERDUR_DRAFT_BOX);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
