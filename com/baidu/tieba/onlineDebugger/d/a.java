package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static final String[] dIo = {"com.baidu.adp", "com.baidu.tbadk", TbConfig.MAIN_PACKAGE_NAME};
    private int dIp;
    private String dIq;
    private Map<String, Integer> dIr = new HashMap();
    private String msgContent;
    private int msgType;
    private String toUid;

    public a() {
        this.dIr.put("get", 3);
        this.dIr.put("set", 3);
        this.dIr.put("exe", 3);
        this.dIr.put("shell", 3);
        this.dIr.put("upload", 5);
        this.dIr.put("show", 4);
        this.dIr.put("new", 6);
        this.dIr.put("sendcmd", 7);
    }

    public int aCJ() {
        return this.dIp;
    }

    public String aCK() {
        return this.dIq;
    }

    public String getToUid() {
        return this.toUid;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public String getMsgContent() {
        return this.msgContent;
    }

    public void mY(String str) {
        this.dIq = str;
    }

    public void setToUid(String str) {
        this.toUid = str;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public void setMsgContent(String str) {
        int indexOf;
        this.msgContent = str.trim();
        if (this.msgType == 0 && (indexOf = str.indexOf(" ")) != -1) {
            String trim = str.substring(0, indexOf).trim();
            if (this.dIr.containsKey(trim)) {
                setMsgType(this.dIr.get(trim).intValue());
            }
        }
    }
}
