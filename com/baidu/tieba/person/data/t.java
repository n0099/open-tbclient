package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.personInfo.bq;
import java.util.List;
/* loaded from: classes.dex */
public class t implements v {
    public static final BdUniqueId dzP = BdUniqueId.gen();
    private String dzQ;
    private String dzR;
    private List<bq.a> dzS;
    private String icon;
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String aCw() {
        return this.dzQ;
    }

    public void mv(String str) {
        this.dzQ = str;
    }

    public String aCx() {
        return this.dzR;
    }

    public void mw(String str) {
        this.dzR = str;
    }

    public List<bq.a> aCy() {
        return this.dzS;
    }

    public void bN(List<bq.a> list) {
        this.dzS = list;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dzP;
    }
}
