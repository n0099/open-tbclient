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
public class ah extends com.baidu.adp.base.f {
    private static final String ayG = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/like";
    private static TbHttpMessageTask ayH = new TbHttpMessageTask(CmdConfigHttp.PIC_LIKE_BAR_CMD, ayG);
    private int bPw;
    private u mData;
    private String mId;
    private boolean mIsHost;
    private int mSex;

    static {
        ayH.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(ayH);
    }

    public ah(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.mData = new u();
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

    public void hz(int i) {
        this.bPw = i;
    }

    public u acZ() {
        return this.mData;
    }

    public void FY() {
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

    public void hV(String str) {
        if (this.bPw == 1 && this.mIsHost) {
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
            }
            if (str != null) {
                try {
                    com.baidu.adp.lib.cache.t<String> bX = com.baidu.tbadk.core.b.a.rc().bX("tb.my_pages");
                    if (bX != null) {
                        bX.a(str2, str, TbConfig.APP_OVERDUR_DRAFT_BOX);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
