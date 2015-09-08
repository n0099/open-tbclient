package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String cBg;
    private String cBh;
    private String cBi;
    private long ftid;

    public void kx(String str) {
        this.cBi = str;
    }

    public String anw() {
        return this.cBi;
    }

    public void setFtid(long j) {
        this.ftid = j;
    }

    public String anx() {
        return this.cBg;
    }

    public void ky(String str) {
        this.cBg = str;
    }

    public String any() {
        return this.cBh;
    }

    public void kz(String str) {
        this.cBh = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.cBh;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rD() {
        return String.valueOf(this.ftid);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: anz */
    public a clone() {
        a aVar = new a();
        aVar.ftid = this.ftid;
        aVar.cBh = this.cBh;
        aVar.cBg = this.cBg;
        aVar.cBi = this.cBi;
        return aVar;
    }
}
