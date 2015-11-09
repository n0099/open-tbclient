package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String dai;
    private ArrayList<a> daj = new ArrayList<>();
    private ArrayList<b> dak = new ArrayList<>();

    public String awS() {
        return this.dai;
    }

    public List<a> awT() {
        return this.daj;
    }

    public List<b> awU() {
        return this.dak;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.dai = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.daj.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.dak.add(bVar);
                }
            }
        }
    }
}
