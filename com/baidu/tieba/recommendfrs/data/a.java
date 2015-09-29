package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String cIi;
    private String cIj;
    private String cIk;
    private long ftid;

    public void kV(String str) {
        this.cIk = str;
    }

    public String apO() {
        return this.cIk;
    }

    public void setFtid(long j) {
        this.ftid = j;
    }

    public String apP() {
        return this.cIi;
    }

    public void kW(String str) {
        this.cIi = str;
    }

    public String apQ() {
        return this.cIj;
    }

    public void kX(String str) {
        this.cIj = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.cIj;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String ry() {
        return String.valueOf(this.ftid);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: apR */
    public a clone() {
        a aVar = new a();
        aVar.ftid = this.ftid;
        aVar.cIj = this.cIj;
        aVar.cIi = this.cIi;
        aVar.cIk = this.cIk;
        return aVar;
    }
}
