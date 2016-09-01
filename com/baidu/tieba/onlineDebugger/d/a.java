package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static final String[] egD = {"com.baidu.adp", "com.baidu.tbadk", TbConfig.MAIN_PACKAGE_NAME};
    private int egE;
    private String egF;
    private Map<String, Integer> egG = new HashMap();
    private String msgContent;
    private int msgType;
    private String toUid;

    public a() {
        this.egG.put("get", 3);
        this.egG.put("set", 3);
        this.egG.put("exe", 3);
        this.egG.put("shell", 3);
        this.egG.put("upload", 5);
        this.egG.put("show", 4);
        this.egG.put("new", 6);
        this.egG.put("sendcmd", 7);
    }

    public int aKL() {
        return this.egE;
    }

    public String aKM() {
        return this.egF;
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

    public void ot(String str) {
        this.egF = str;
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
            if (this.egG.containsKey(trim)) {
                setMsgType(this.egG.get(trim).intValue());
            }
        }
    }
}
