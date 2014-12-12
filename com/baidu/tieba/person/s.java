package com.baidu.tieba.person;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.f {
    private static final String bkk = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/like";
    private static TbHttpMessageTask bkl = new TbHttpMessageTask(CmdConfigHttp.PIC_LIKE_BAR_CMD, bkk);
    private int bFj;
    private f mData;
    private String mId;
    private boolean mIsHost;
    private int mSex;

    static {
        bkl.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(bkl);
    }

    public s(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.mData = new f();
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

    public void hf(int i) {
        this.bFj = i;
    }

    public f aaj() {
        return this.mData;
    }

    public void CK() {
        super.sendMessage(new PersonBarByUidLocalMessage());
    }

    public void a(boolean z, String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_LIKE_BAR_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("friend_uid", str);
        httpMessage.addParam("is_guest", String.valueOf(1));
        httpMessage.addParam("page_size", Integer.valueOf(i2));
        httpMessage.addParam("page_no", Integer.valueOf(i));
        httpMessage.setExtra(str);
        super.sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void hF(String str) {
        if (this.bFj == 1 && this.mIsHost) {
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
            }
            if (str != null) {
                try {
                    com.baidu.adp.lib.cache.t<String> bV = com.baidu.tbadk.core.a.a.nS().bV("tb.my_pages");
                    if (bV != null) {
                        bV.a(str2, str, TbConfig.APP_OVERDUR_DRAFT_BOX);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
