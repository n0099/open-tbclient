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
    private static final String aHl = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/like";
    private static TbHttpMessageTask aHm = new TbHttpMessageTask(CmdConfigHttp.PIC_LIKE_BAR_CMD, aHl);
    private int cpd;
    private q mData;
    private String mId;
    private boolean mIsHost;
    private int mSex;

    static {
        aHm.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(aHm);
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

    public boolean WG() {
        return this.mIsHost;
    }

    public void je(int i) {
        this.cpd = i;
    }

    public q air() {
        return this.mData;
    }

    public void HB() {
        super.sendMessage(new PersonBarByUidLocalMessage());
    }

    public void a(boolean z, String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_LIKE_BAR_CMD);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        if (!WG()) {
            httpMessage.addParam("friend_uid", str);
            httpMessage.addParam("is_guest", String.valueOf(1));
            httpMessage.setExtra(str);
        }
        httpMessage.addParam("page_size", Integer.valueOf(i2));
        httpMessage.addParam("page_no", Integer.valueOf(i));
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

    public void ka(String str) {
        if (this.cpd == 1 && this.mIsHost) {
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
            }
            if (str != null) {
                try {
                    com.baidu.adp.lib.cache.o<String> cr = com.baidu.tbadk.core.b.a.sL().cr("tb.my_pages");
                    if (cr != null) {
                        cr.a(str2, str, TbConfig.APP_OVERDUR_DRAFT_BOX);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
