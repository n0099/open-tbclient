package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String fpf;
    private ArrayList<a> fpg = new ArrayList<>();
    private ArrayList<b> fph = new ArrayList<>();

    public String bhk() {
        return this.fpf;
    }

    public List<a> bhl() {
        return this.fpg;
    }

    public List<b> bhm() {
        return this.fph;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.fpf = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.fpg.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.fph.add(bVar);
                }
            }
        }
    }
}
