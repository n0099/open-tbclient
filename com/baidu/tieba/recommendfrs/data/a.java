package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String csO;
    private String csP;
    private String csQ;
    private long ftid;

    public void jS(String str) {
        this.csQ = str;
    }

    public String ajs() {
        return this.csQ;
    }

    public void setFtid(long j) {
        this.ftid = j;
    }

    public String ajt() {
        return this.csO;
    }

    public void jT(String str) {
        this.csO = str;
    }

    public String aju() {
        return this.csP;
    }

    public void jU(String str) {
        this.csP = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.csP;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rE() {
        return String.valueOf(this.ftid);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: ajv */
    public a clone() {
        a aVar = new a();
        aVar.ftid = this.ftid;
        aVar.csP = this.csP;
        aVar.csO = this.csO;
        aVar.csQ = this.csQ;
        return aVar;
    }
}
