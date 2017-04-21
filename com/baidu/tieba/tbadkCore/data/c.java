package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String fxB;
    private ArrayList<a> fxC = new ArrayList<>();
    private ArrayList<b> fxD = new ArrayList<>();

    public String biJ() {
        return this.fxB;
    }

    public List<a> biK() {
        return this.fxC;
    }

    public List<b> biL() {
        return this.fxD;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.fxB = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.fxC.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.fxD.add(bVar);
                }
            }
        }
    }
}
