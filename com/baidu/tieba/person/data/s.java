package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.person.f;
import java.util.List;
/* loaded from: classes.dex */
public class s implements v {
    public static final BdUniqueId esx = BdUniqueId.gen();
    private String epv;
    private String epw;
    private List<f.a> epx;
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

    public String aNS() {
        return this.epv;
    }

    public void oJ(String str) {
        this.epv = str;
    }

    public String aNT() {
        return this.epw;
    }

    public void oK(String str) {
        this.epw = str;
    }

    public List<f.a> aNU() {
        return this.epx;
    }

    public void cx(List<f.a> list) {
        this.epx = list;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return esx;
    }
}
