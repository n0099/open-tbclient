package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    private int dUB;
    private String dUC;
    private boolean dUD;
    private int dUy;
    private String dUz;
    private String msgContent;
    private int msgType;
    private String toUid;

    public b(a aVar) {
        this();
        this.dUy = aVar.aFT();
        this.toUid = aVar.aFU();
        this.msgType = aVar.getMsgType();
        this.dUz = aVar.getToUid();
    }

    public b() {
        this.dUD = !TbadkCoreApplication.m10getInst().isDebugMode();
        np(2);
        nK(TbConfig.getVersion());
        this.dUz = TbadkCoreApplication.getCurrentAccount();
    }

    public String aFU() {
        return this.dUz;
    }

    public String getToUid() {
        return this.toUid;
    }

    public void np(int i) {
        this.dUB = i;
    }

    public void nK(String str) {
        this.dUC = str;
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
