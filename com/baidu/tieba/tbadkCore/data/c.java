package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String gXB;
    private ArrayList<a> gXC = new ArrayList<>();
    private ArrayList<b> gXD = new ArrayList<>();

    public String bve() {
        return this.gXB;
    }

    public List<a> bvf() {
        return this.gXC;
    }

    public List<b> bvg() {
        return this.gXD;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.gXB = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.gXC.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.gXD.add(bVar);
                }
            }
        }
    }
}
