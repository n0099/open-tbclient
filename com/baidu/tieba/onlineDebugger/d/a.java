package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static final String[] dbH = {"com.baidu.adp", "com.baidu.tbadk", TbConfig.MAIN_PACKAGE_NAME};
    private int dbI;
    private String dbJ;
    private Map<String, Integer> dbK = new HashMap();
    private String msgContent;
    private int msgType;
    private String toUid;

    public a() {
        this.dbK.put("get", 3);
        this.dbK.put("set", 3);
        this.dbK.put("exe", 3);
        this.dbK.put("shell", 3);
        this.dbK.put("upload", 5);
        this.dbK.put("show", 4);
        this.dbK.put("new", 6);
    }

    public int auB() {
        return this.dbI;
    }

    public String auC() {
        return this.dbJ;
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

    public void lx(String str) {
        this.dbJ = str;
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
            if (this.dbK.containsKey(trim)) {
                setMsgType(this.dbK.get(trim).intValue());
            }
        }
    }
}
