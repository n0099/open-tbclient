package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String esc;
    private ArrayList<a> esd = new ArrayList<>();
    private ArrayList<b> ese = new ArrayList<>();

    public String aTm() {
        return this.esc;
    }

    public List<a> aTn() {
        return this.esd;
    }

    public List<b> aTo() {
        return this.ese;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.esc = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.esd.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.ese.add(bVar);
                }
            }
        }
    }
}
