package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.High;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId eiq = BdUniqueId.gen();
    private List<High> eir;
    private String eis;
    private boolean hasMore;
    private int sex;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eiq;
    }

    public List<High> aLn() {
        return this.eir;
    }

    public void cj(List<High> list) {
        this.eir = list;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public String aLo() {
        return this.eis;
    }

    public void oa(String str) {
        this.eis = str;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int i) {
        this.sex = i;
    }
}
