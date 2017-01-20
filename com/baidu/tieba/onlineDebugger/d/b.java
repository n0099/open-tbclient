package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    private int ebW;
    private String ebX;
    private int ebZ;
    private String eca;
    private boolean ecb;
    private String msgContent;
    private int msgType;
    private String toUid;

    public b(a aVar) {
        this();
        this.ebW = aVar.aIU();
        this.toUid = aVar.aIV();
        this.msgType = aVar.getMsgType();
        this.ebX = aVar.getToUid();
    }

    public b() {
        this.ecb = !TbadkCoreApplication.m9getInst().isDebugMode();
        oh(2);
        nN(TbConfig.getVersion());
        this.ebX = TbadkCoreApplication.getCurrentAccount();
    }

    public String aIV() {
        return this.ebX;
    }

    public String getToUid() {
        return this.toUid;
    }

    public void oh(int i) {
        this.ebZ = i;
    }

    public void nN(String str) {
        this.eca = str;
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
