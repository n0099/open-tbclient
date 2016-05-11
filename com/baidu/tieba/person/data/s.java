package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
import tbclient.High;
/* loaded from: classes.dex */
public class s implements v {
    public static final BdUniqueId dzM = BdUniqueId.gen();
    private List<High> dzN;
    private String dzO;
    private boolean hasMore;
    private int sex;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dzM;
    }

    public List<High> aCr() {
        return this.dzN;
    }

    public void bM(List<High> list) {
        this.dzN = list;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public String aCs() {
        return this.dzO;
    }

    public void mu(String str) {
        this.dzO = str;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int i) {
        this.sex = i;
    }
}
