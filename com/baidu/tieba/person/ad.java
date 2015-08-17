package com.baidu.tieba.person;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.base.e {
    private static final String aHU = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/like";
    private static TbHttpMessageTask aHV = new TbHttpMessageTask(CmdConfigHttp.PIC_LIKE_BAR_CMD, aHU);
    private int civ;
    private q mData;
    private String mId;
    private boolean mIsHost;
    private int mSex;

    static {
        aHV.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(aHV);
    }

    public ad(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.mData = new q();
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

    public void iI(int i) {
        this.civ = i;
    }

    public q agg() {
        return this.mData;
    }

    public void HX() {
        super.sendMessage(new PersonBarByUidLocalMessage());
    }

    public void a(boolean z, String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_LIKE_BAR_CMD);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("friend_uid", str);
        httpMessage.addParam("is_guest", String.valueOf(1));
        httpMessage.addParam("page_size", Integer.valueOf(i2));
        httpMessage.addParam("page_no", Integer.valueOf(i));
        httpMessage.setExtra(str);
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

    public void jx(String str) {
        if (this.civ == 1 && this.mIsHost) {
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
            }
            if (str != null) {
                try {
                    com.baidu.adp.lib.cache.o<String> ck = com.baidu.tbadk.core.b.a.sM().ck("tb.my_pages");
                    if (ck != null) {
                        ck.a(str2, str, TbConfig.APP_OVERDUR_DRAFT_BOX);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
