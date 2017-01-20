package com.baidu.tieba.onlineDebugger.d;

import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static final String[] ebV = {"com.baidu.adp", "com.baidu.tbadk", TbConfig.MAIN_PACKAGE_NAME};
    private int ebW;
    private String ebX;
    private Map<String, Integer> ebY = new HashMap();
    private String msgContent;
    private int msgType;
    private String toUid;

    public a() {
        this.ebY.put("get", 3);
        this.ebY.put("set", 3);
        this.ebY.put("exe", 3);
        this.ebY.put("shell", 3);
        this.ebY.put("upload", 5);
        this.ebY.put("show", 4);
        this.ebY.put("new", 6);
        this.ebY.put("sendcmd", 7);
    }

    public int aIU() {
        return this.ebW;
    }

    public String aIV() {
        return this.ebX;
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

    public void nM(String str) {
        this.ebX = str;
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
            if (this.ebY.containsKey(trim)) {
                setMsgType(this.ebY.get(trim).intValue());
            }
        }
    }
}
