package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
import tbclient.High;
/* loaded from: classes.dex */
public class r implements v {
    public static final BdUniqueId esu = BdUniqueId.gen();
    private List<High> esv;
    private String esw;
    private boolean hasMore;
    private int sex;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return esu;
    }

    public List<High> aNQ() {
        return this.esv;
    }

    public void cw(List<High> list) {
        this.esv = list;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public String aNR() {
        return this.esw;
    }

    public void oI(String str) {
        this.esw = str;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int i) {
        this.sex = i;
    }
}
