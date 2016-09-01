package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String frL;
    private ArrayList<a> frM = new ArrayList<>();
    private ArrayList<b> frN = new ArrayList<>();

    public String biz() {
        return this.frL;
    }

    public List<a> biA() {
        return this.frM;
    }

    public List<b> biB() {
        return this.frN;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.frL = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.frM.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.frN.add(bVar);
                }
            }
        }
    }
}
