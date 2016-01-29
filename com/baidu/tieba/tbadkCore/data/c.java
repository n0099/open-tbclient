package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String dWl;
    private ArrayList<a> dWm = new ArrayList<>();
    private ArrayList<b> dWn = new ArrayList<>();

    public String aLR() {
        return this.dWl;
    }

    public List<a> aLS() {
        return this.dWm;
    }

    public List<b> aLT() {
        return this.dWn;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.dWl = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.dWm.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.dWn.add(bVar);
                }
            }
        }
    }
}
