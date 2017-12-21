package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String gBo;
    private ArrayList<a> gBp = new ArrayList<>();
    private ArrayList<b> gBq = new ArrayList<>();

    public String bwt() {
        return this.gBo;
    }

    public List<a> bwu() {
        return this.gBp;
    }

    public List<b> bwv() {
        return this.gBq;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.gBo = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.gBp.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.gBq.add(bVar);
                }
            }
        }
    }
}
