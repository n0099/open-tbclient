package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String fBF;
    private ArrayList<a> fBG = new ArrayList<>();
    private ArrayList<b> fBH = new ArrayList<>();

    public String blF() {
        return this.fBF;
    }

    public List<a> blG() {
        return this.fBG;
    }

    public List<b> blH() {
        return this.fBH;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.fBF = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.fBG.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.fBH.add(bVar);
                }
            }
        }
    }
}
