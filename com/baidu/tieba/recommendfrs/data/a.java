package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String cbT;
    private String cbU;
    private String cbV;
    private long ftid;

    public void iX(String str) {
        this.cbV = str;
    }

    public String aht() {
        return this.cbV;
    }

    public void setFtid(long j) {
        this.ftid = j;
    }

    public String ahu() {
        return this.cbT;
    }

    public void iY(String str) {
        this.cbT = str;
    }

    public String ahv() {
        return this.cbU;
    }

    public void iZ(String str) {
        this.cbU = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.cbU;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String sd() {
        return String.valueOf(this.ftid);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: ahw */
    public a clone() {
        a aVar = new a();
        aVar.ftid = this.ftid;
        aVar.cbU = this.cbU;
        aVar.cbT = this.cbT;
        aVar.cbV = this.cbV;
        return aVar;
    }
}
