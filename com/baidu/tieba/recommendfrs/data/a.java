package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String cIH;
    private String cII;
    private String cIJ;
    private long ftid;

    public void kY(String str) {
        this.cIJ = str;
    }

    public String apU() {
        return this.cIJ;
    }

    public void setFtid(long j) {
        this.ftid = j;
    }

    public String apV() {
        return this.cIH;
    }

    public void kZ(String str) {
        this.cIH = str;
    }

    public String apW() {
        return this.cII;
    }

    public void la(String str) {
        this.cII = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.cII;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String ry() {
        return String.valueOf(this.ftid);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: apX */
    public a clone() {
        a aVar = new a();
        aVar.ftid = this.ftid;
        aVar.cII = this.cII;
        aVar.cIH = this.cIH;
        aVar.cIJ = this.cIJ;
        return aVar;
    }
}
