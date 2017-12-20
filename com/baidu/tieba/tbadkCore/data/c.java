package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String gBj;
    private ArrayList<a> gBk = new ArrayList<>();
    private ArrayList<b> gBl = new ArrayList<>();

    public String bws() {
        return this.gBj;
    }

    public List<a> bwt() {
        return this.gBk;
    }

    public List<b> bwu() {
        return this.gBl;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.gBj = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.gBk.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.gBl.add(bVar);
                }
            }
        }
    }
}
