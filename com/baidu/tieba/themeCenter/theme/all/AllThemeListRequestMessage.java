package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetSkinList.DataReq;
import tbclient.GetSkinList.GetSkinListReqIdl;
/* loaded from: classes.dex */
public class AllThemeListRequestMessage extends NetMessage {
    private int pn;
    private int rn;

    public AllThemeListRequestMessage() {
        super(CmdConfigHttp.CMD_ALL_THEME_LIST, 309011);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        if (z) {
            com.baidu.tbadk.util.i.a(builder, true);
        }
        GetSkinListReqIdl.Builder builder2 = new GetSkinListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getPn() {
        return this.pn;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
    }
}
