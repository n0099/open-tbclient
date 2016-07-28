package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String fjS;
    private ArrayList<a> fjT = new ArrayList<>();
    private ArrayList<b> fjU = new ArrayList<>();

    public String beU() {
        return this.fjS;
    }

    public List<a> beV() {
        return this.fjT;
    }

    public List<b> beW() {
        return this.fjU;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.fjS = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.fjT.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.fjU.add(bVar);
                }
            }
        }
    }
}
