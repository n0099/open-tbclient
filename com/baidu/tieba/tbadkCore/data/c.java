package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String fvk;
    private ArrayList<a> fvl = new ArrayList<>();
    private ArrayList<b> fvm = new ArrayList<>();

    public String bhI() {
        return this.fvk;
    }

    public List<a> bhJ() {
        return this.fvl;
    }

    public List<b> bhK() {
        return this.fvm;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.fvk = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.fvl.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.fvm.add(bVar);
                }
            }
        }
    }
}
