package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String eoS;
    private ArrayList<a> eoT = new ArrayList<>();
    private ArrayList<b> eoU = new ArrayList<>();

    public String aSL() {
        return this.eoS;
    }

    public List<a> aSM() {
        return this.eoT;
    }

    public List<b> aSN() {
        return this.eoU;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.eoS = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.eoT.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.eoU.add(bVar);
                }
            }
        }
    }
}
