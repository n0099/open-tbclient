package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    private int dIp;
    private String dIq;
    private int dIs;
    private String dIt;
    private boolean dIu;
    private String msgContent;
    private int msgType;
    private String toUid;

    public b(a aVar) {
        this();
        this.dIp = aVar.aCJ();
        this.toUid = aVar.aCK();
        this.msgType = aVar.getMsgType();
        this.dIq = aVar.getToUid();
    }

    public b() {
        this.dIu = !TbadkCoreApplication.m9getInst().isDebugMode();
        mX(2);
        mZ(TbConfig.getVersion());
        this.dIq = TbadkCoreApplication.getCurrentAccount();
    }

    public String aCK() {
        return this.dIq;
    }

    public String getToUid() {
        return this.toUid;
    }

    public void mX(int i) {
        this.dIs = i;
    }

    public void mZ(String str) {
        this.dIt = str;
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
