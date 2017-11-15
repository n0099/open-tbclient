package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String gpI;
    private ArrayList<a> gpJ = new ArrayList<>();
    private ArrayList<b> gpK = new ArrayList<>();

    public String bue() {
        return this.gpI;
    }

    public List<a> buf() {
        return this.gpJ;
    }

    public List<b> bug() {
        return this.gpK;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.gpI = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.gpJ.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.gpK.add(bVar);
                }
            }
        }
    }
}
