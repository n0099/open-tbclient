package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String cKd;
    private String cKe;
    private String cKf;
    private long ftid;

    public void lc(String str) {
        this.cKf = str;
    }

    public String aqw() {
        return this.cKf;
    }

    public void setFtid(long j) {
        this.ftid = j;
    }

    public String aqx() {
        return this.cKd;
    }

    public void ld(String str) {
        this.cKd = str;
    }

    public String aqy() {
        return this.cKe;
    }

    public void le(String str) {
        this.cKe = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.cKe;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rw() {
        return String.valueOf(this.ftid);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: aqz */
    public a clone() {
        a aVar = new a();
        aVar.ftid = this.ftid;
        aVar.cKe = this.cKe;
        aVar.cKd = this.cKd;
        aVar.cKf = this.cKf;
        return aVar;
    }
}
