package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static final String[] dUx = {"com.baidu.adp", "com.baidu.tbadk", TbConfig.MAIN_PACKAGE_NAME};
    private Map<String, Integer> dUA = new HashMap();
    private int dUy;
    private String dUz;
    private String msgContent;
    private int msgType;
    private String toUid;

    public a() {
        this.dUA.put("get", 3);
        this.dUA.put("set", 3);
        this.dUA.put("exe", 3);
        this.dUA.put("shell", 3);
        this.dUA.put("upload", 5);
        this.dUA.put("show", 4);
        this.dUA.put("new", 6);
        this.dUA.put("sendcmd", 7);
    }

    public int aFT() {
        return this.dUy;
    }

    public String aFU() {
        return this.dUz;
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

    public void nJ(String str) {
        this.dUz = str;
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
            if (this.dUA.containsKey(trim)) {
                setMsgType(this.dUA.get(trim).intValue());
            }
        }
    }
}
