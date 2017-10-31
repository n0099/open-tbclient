package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String goF;
    private ArrayList<a> goG = new ArrayList<>();
    private ArrayList<b> goH = new ArrayList<>();

    public String btS() {
        return this.goF;
    }

    public List<a> btT() {
        return this.goG;
    }

    public List<b> btU() {
        return this.goH;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.goF = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.goG.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.goH.add(bVar);
                }
            }
        }
    }
}
