package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bXX;
    private String bXY;
    private long ftid;

    public void setFtid(long j) {
        this.ftid = j;
    }

    public String afO() {
        return this.bXX;
    }

    public void ik(String str) {
        this.bXX = str;
    }

    public void il(String str) {
        this.bXY = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bXY;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rt() {
        return String.valueOf(this.ftid);
    }
}
