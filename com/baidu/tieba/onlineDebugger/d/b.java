package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    private int dTd;
    private String dTe;
    private int dTg;
    private String dTh;
    private boolean dTi;
    private String msgContent;
    private int msgType;
    private String toUid;

    public b(a aVar) {
        this();
        this.dTd = aVar.aHg();
        this.toUid = aVar.aHh();
        this.msgType = aVar.getMsgType();
        this.dTe = aVar.getToUid();
    }

    public b() {
        this.dTi = !TbadkCoreApplication.m9getInst().isDebugMode();
        no(2);
        nw(TbConfig.getVersion());
        this.dTe = TbadkCoreApplication.getCurrentAccount();
    }

    public String aHh() {
        return this.dTe;
    }

    public String getToUid() {
        return this.toUid;
    }

    public void no(int i) {
        this.dTg = i;
    }

    public void nw(String str) {
        this.dTh = str;
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
