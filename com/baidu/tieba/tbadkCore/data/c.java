package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String gyA;
    private ArrayList<a> gyB = new ArrayList<>();
    private ArrayList<b> gyC = new ArrayList<>();

    public String bvM() {
        return this.gyA;
    }

    public List<a> bvN() {
        return this.gyB;
    }

    public List<b> bvO() {
        return this.gyC;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.gyA = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.gyB.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.gyC.add(bVar);
                }
            }
        }
    }
}
