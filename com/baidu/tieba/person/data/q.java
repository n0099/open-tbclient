package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.personInfo.bp;
import java.util.List;
/* loaded from: classes.dex */
public class q implements u {
    public static final BdUniqueId dce = BdUniqueId.gen();
    private String dcf;
    private String dcg;
    private List<bp.a> dch;
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

    public String aut() {
        return this.dcf;
    }

    public void lb(String str) {
        this.dcf = str;
    }

    public String auu() {
        return this.dcg;
    }

    public void lc(String str) {
        this.dcg = str;
    }

    public List<bp.a> auv() {
        return this.dch;
    }

    public void bp(List<bp.a> list) {
        this.dch = list;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dce;
    }
}
