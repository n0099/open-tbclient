package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    private int eoA;
    private String eoB;
    private boolean eoC;
    private int eox;
    private String eoy;
    private String msgContent;
    private int msgType;
    private String toUid;

    public b(a aVar) {
        this();
        this.eox = aVar.aNf();
        this.toUid = aVar.aNg();
        this.msgType = aVar.getMsgType();
        this.eoy = aVar.getToUid();
    }

    public b() {
        this.eoC = !TbadkCoreApplication.m9getInst().isDebugMode();
        om(2);
        oV(TbConfig.getVersion());
        this.eoy = TbadkCoreApplication.getCurrentAccount();
    }

    public String aNg() {
        return this.eoy;
    }

    public String getToUid() {
        return this.toUid;
    }

    public void om(int i) {
        this.eoA = i;
    }

    public void oV(String str) {
        this.eoB = str;
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
