package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String hia;
    private ArrayList<a> hib = new ArrayList<>();
    private ArrayList<b> hic = new ArrayList<>();

    public String bBI() {
        return this.hia;
    }

    public List<a> bBJ() {
        return this.hib;
    }

    public List<b> bBK() {
        return this.hic;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.hia = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.hib.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.hic.add(bVar);
                }
            }
        }
    }
}
