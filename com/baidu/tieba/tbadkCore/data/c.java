package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String gXV;
    private ArrayList<a> gXW = new ArrayList<>();
    private ArrayList<b> gXX = new ArrayList<>();

    public String bvg() {
        return this.gXV;
    }

    public List<a> bvh() {
        return this.gXW;
    }

    public List<b> bvi() {
        return this.gXX;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.gXV = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.gXW.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.gXX.add(bVar);
                }
            }
        }
    }
}
