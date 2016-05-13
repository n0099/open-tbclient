package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    private int dbI;
    private String dbJ;
    private int dbL;
    private String dbM;
    private boolean dbN;
    private String msgContent;
    private int msgType;
    private String toUid;

    public b(a aVar) {
        this();
        this.dbI = aVar.auE();
        this.toUid = aVar.auF();
        this.msgType = aVar.getMsgType();
        this.dbJ = aVar.getToUid();
    }

    public b() {
        this.dbN = !TbadkCoreApplication.m11getInst().isDebugMode();
        lv(2);
        ly(TbConfig.getVersion());
        this.dbJ = TbadkCoreApplication.getCurrentAccount();
    }

    public String auF() {
        return this.dbJ;
    }

    public String getToUid() {
        return this.toUid;
    }

    public void lv(int i) {
        this.dbL = i;
    }

    public void ly(String str) {
        this.dbM = str;
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
