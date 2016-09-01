package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    private int egE;
    private String egF;
    private int egH;
    private String egI;
    private boolean egJ;
    private String msgContent;
    private int msgType;
    private String toUid;

    public b(a aVar) {
        this();
        this.egE = aVar.aKL();
        this.toUid = aVar.aKM();
        this.msgType = aVar.getMsgType();
        this.egF = aVar.getToUid();
    }

    public b() {
        this.egJ = !TbadkCoreApplication.m9getInst().isDebugMode();
        nS(2);
        ou(TbConfig.getVersion());
        this.egF = TbadkCoreApplication.getCurrentAccount();
    }

    public String aKM() {
        return this.egF;
    }

    public String getToUid() {
        return this.toUid;
    }

    public void nS(int i) {
        this.egH = i;
    }

    public void ou(String str) {
        this.egI = str;
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
