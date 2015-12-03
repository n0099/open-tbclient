package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String dyW;
    private ArrayList<a> dyX = new ArrayList<>();
    private ArrayList<b> dyY = new ArrayList<>();

    public String aCE() {
        return this.dyW;
    }

    public List<a> aCF() {
        return this.dyX;
    }

    public List<b> aCG() {
        return this.dyY;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.dyW = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.dyX.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.dyY.add(bVar);
                }
            }
        }
    }
}
