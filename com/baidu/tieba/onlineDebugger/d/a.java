package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static final String[] eix = {"com.baidu.adp", "com.baidu.tbadk", TbConfig.MAIN_PACKAGE_NAME};
    private Map<String, Integer> eiA = new HashMap();
    private int eiy;
    private String eiz;
    private String msgContent;
    private int msgType;
    private String toUid;

    public a() {
        this.eiA.put("get", 3);
        this.eiA.put("set", 3);
        this.eiA.put("exe", 3);
        this.eiA.put("shell", 3);
        this.eiA.put("upload", 5);
        this.eiA.put("show", 4);
        this.eiA.put("new", 6);
        this.eiA.put("sendcmd", 7);
    }

    public int aLm() {
        return this.eiy;
    }

    public String aLn() {
        return this.eiz;
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

    public void oH(String str) {
        this.eiz = str;
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
            if (this.eiA.containsKey(trim)) {
                setMsgType(this.eiA.get(trim).intValue());
            }
        }
    }
}
