package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    private int cvV;
    private String cvW;
    private int cvY;
    private String cvZ;
    private boolean cwa;
    private String msgContent;
    private int msgType;
    private String toUid;

    public b(a aVar) {
        this();
        this.cvV = aVar.aiD();
        this.toUid = aVar.aiE();
        this.msgType = aVar.getMsgType();
        this.cvW = aVar.getToUid();
    }

    public b() {
        this.cwa = !TbadkCoreApplication.m411getInst().isDebugMode();
        jH(2);
        kg(TbConfig.getVersion());
        this.cvW = TbadkCoreApplication.getCurrentAccount();
    }

    public String aiE() {
        return this.cvW;
    }

    public String getToUid() {
        return this.toUid;
    }

    public void jH(int i) {
        this.cvY = i;
    }

    public void kg(String str) {
        this.cvZ = str;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public String getMsgContent() {
        return this.msgContent;
    }

    public void setMsgContent(String str) {
        this.msgContent = str;
    }
}
