package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String cbS;
    private String cbT;
    private String cbU;
    private long ftid;

    public void iX(String str) {
        this.cbU = str;
    }

    public String ahs() {
        return this.cbU;
    }

    public void setFtid(long j) {
        this.ftid = j;
    }

    public String aht() {
        return this.cbS;
    }

    public void iY(String str) {
        this.cbS = str;
    }

    public String ahu() {
        return this.cbT;
    }

    public void iZ(String str) {
        this.cbT = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.cbT;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String sd() {
        return String.valueOf(this.ftid);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: ahv */
    public a clone() {
        a aVar = new a();
        aVar.ftid = this.ftid;
        aVar.cbT = this.cbT;
        aVar.cbS = this.cbS;
        aVar.cbU = this.cbU;
        return aVar;
    }
}
