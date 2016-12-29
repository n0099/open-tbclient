package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static final String[] dTc = {"com.baidu.adp", "com.baidu.tbadk", TbConfig.MAIN_PACKAGE_NAME};
    private int dTd;
    private String dTe;
    private Map<String, Integer> dTf = new HashMap();
    private String msgContent;
    private int msgType;
    private String toUid;

    public a() {
        this.dTf.put("get", 3);
        this.dTf.put("set", 3);
        this.dTf.put("exe", 3);
        this.dTf.put("shell", 3);
        this.dTf.put("upload", 5);
        this.dTf.put("show", 4);
        this.dTf.put("new", 6);
        this.dTf.put("sendcmd", 7);
    }

    public int aHg() {
        return this.dTd;
    }

    public String aHh() {
        return this.dTe;
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

    public void nv(String str) {
        this.dTe = str;
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
            if (this.dTf.containsKey(trim)) {
                setMsgType(this.dTf.get(trim).intValue());
            }
        }
    }
}
