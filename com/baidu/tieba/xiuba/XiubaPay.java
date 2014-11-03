package com.baidu.tieba.xiuba;

import java.io.Serializable;
/* loaded from: classes.dex */
public class XiubaPay implements Serializable {
    public static final int TYPE_PAY = 0;
    public static final int TYPE_PURCHASE = 1;
    private static final long serialVersionUID = 1;
    private String password;
    private long tdouNum;
    private int type;
    private String xiubaUserId;

    public String getXiubaUserId() {
        return this.xiubaUserId;
    }

    public void setXiubaUserId(String str) {
        this.xiubaUserId = str;
    }

    public long getTdouNum() {
        return this.tdouNum;
    }

    public void setTdouNum(long j) {
        this.tdouNum = j;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
