package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String dGq;
    private ArrayList<a> dGr = new ArrayList<>();
    private ArrayList<b> dGs = new ArrayList<>();

    public String aEL() {
        return this.dGq;
    }

    public List<a> aEM() {
        return this.dGr;
    }

    public List<b> aEN() {
        return this.dGs;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.dGq = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.dGr.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.dGs.add(bVar);
                }
            }
        }
    }
}
