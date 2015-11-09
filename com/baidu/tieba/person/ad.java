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
    private static final String aGf = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/like";
    private static TbHttpMessageTask aGg = new TbHttpMessageTask(CmdConfigHttp.PIC_LIKE_BAR_CMD, aGf);
    private int cqz;
    private q mData;
    private String mId;
    private boolean mIsHost;
    private int mSex;

    static {
        aGg.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(aGg);
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

    public boolean Xb() {
        return this.mIsHost;
    }

    public void js(int i) {
        this.cqz = i;
    }

    public q aiX() {
        return this.mData;
    }

    public void Hy() {
        super.sendMessage(new PersonBarByUidLocalMessage());
    }

    public void a(boolean z, String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_LIKE_BAR_CMD);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        if (!Xb()) {
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

    public void kd(String str) {
        if (this.cqz == 1 && this.mIsHost) {
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
            }
            if (str != null) {
                try {
                    com.baidu.adp.lib.cache.o<String> cr = com.baidu.tbadk.core.b.a.sO().cr("tb.my_pages");
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
