package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static final String[] eow = {"com.baidu.adp", "com.baidu.tbadk", TbConfig.MAIN_PACKAGE_NAME};
    private int eox;
    private String eoy;
    private Map<String, Integer> eoz = new HashMap();
    private String msgContent;
    private int msgType;
    private String toUid;

    public a() {
        this.eoz.put("get", 3);
        this.eoz.put("set", 3);
        this.eoz.put("exe", 3);
        this.eoz.put("shell", 3);
        this.eoz.put("upload", 5);
        this.eoz.put("show", 4);
        this.eoz.put("new", 6);
        this.eoz.put("sendcmd", 7);
    }

    public int aNf() {
        return this.eox;
    }

    public String aNg() {
        return this.eoy;
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

    public void oU(String str) {
        this.eoy = str;
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
            if (this.eoz.containsKey(trim)) {
                setMsgType(this.eoz.get(trim).intValue());
            }
        }
    }
}
