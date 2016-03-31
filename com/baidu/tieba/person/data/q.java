package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.personInfo.bp;
import java.util.List;
/* loaded from: classes.dex */
public class q implements u {
    public static final BdUniqueId dwH = BdUniqueId.gen();
    private String dwI;
    private String dwJ;
    private List<bp.a> dwK;
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

    public String aBZ() {
        return this.dwI;
    }

    public void mq(String str) {
        this.dwI = str;
    }

    public String aCa() {
        return this.dwJ;
    }

    public void mr(String str) {
        this.dwJ = str;
    }

    public List<bp.a> aCb() {
        return this.dwK;
    }

    public void bL(List<bp.a> list) {
        this.dwK = list;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dwH;
    }
}
