package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bXI;
    private String bXJ;
    private long ftid;

    public void setFtid(long j) {
        this.ftid = j;
    }

    public String afz() {
        return this.bXI;
    }

    public void ih(String str) {
        this.bXI = str;
    }

    public void ii(String str) {
        this.bXJ = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bXJ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rt() {
        return String.valueOf(this.ftid);
    }
}
