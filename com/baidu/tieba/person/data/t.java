package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.person.bs;
import java.util.List;
/* loaded from: classes.dex */
public class t implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId eit = BdUniqueId.gen();
    private String efv;
    private String efw;
    private List<bs.a> efx;
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

    public String aLp() {
        return this.efv;
    }

    public void ob(String str) {
        this.efv = str;
    }

    public String aLq() {
        return this.efw;
    }

    public void oc(String str) {
        this.efw = str;
    }

    public List<bs.a> aLr() {
        return this.efx;
    }

    public void ck(List<bs.a> list) {
        this.efx = list;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eit;
    }
}
