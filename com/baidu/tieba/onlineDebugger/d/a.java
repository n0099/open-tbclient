package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static final String[] cvU = {"com.baidu.adp", "com.baidu.tbadk", TbConfig.MAIN_PACKAGE_NAME};
    private int cvV;
    private String cvW;
    private Map<String, Integer> cvX = new HashMap();
    private String msgContent;
    private int msgType;
    private String toUid;

    public a() {
        this.cvX.put("get", 3);
        this.cvX.put("set", 3);
        this.cvX.put("exe", 3);
        this.cvX.put("shell", 3);
        this.cvX.put("upload", 5);
        this.cvX.put("show", 4);
        this.cvX.put("new", 6);
    }

    public int aiD() {
        return this.cvV;
    }

    public String aiE() {
        return this.cvW;
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

    public void kf(String str) {
        this.cvW = str;
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
            if (this.cvX.containsKey(trim)) {
                setMsgType(this.cvX.get(trim).intValue());
            }
        }
    }
}
