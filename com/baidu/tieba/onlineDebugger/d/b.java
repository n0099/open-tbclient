package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    private int eiB;
    private String eiC;
    private boolean eiD;
    private int eiy;
    private String eiz;
    private String msgContent;
    private int msgType;
    private String toUid;

    public b(a aVar) {
        this();
        this.eiy = aVar.aLm();
        this.toUid = aVar.aLn();
        this.msgType = aVar.getMsgType();
        this.eiz = aVar.getToUid();
    }

    public b() {
        this.eiD = !TbadkCoreApplication.m9getInst().isDebugMode();
        oc(2);
        oI(TbConfig.getVersion());
        this.eiz = TbadkCoreApplication.getCurrentAccount();
    }

    public String aLn() {
        return this.eiz;
    }

    public String getToUid() {
        return this.toUid;
    }

    public void oc(int i) {
        this.eiB = i;
    }

    public void oI(String str) {
        this.eiC = str;
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
