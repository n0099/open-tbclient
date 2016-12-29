package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String ffK;
    private ArrayList<a> ffL = new ArrayList<>();
    private ArrayList<b> ffM = new ArrayList<>();

    public String bfu() {
        return this.ffK;
    }

    public List<a> bfv() {
        return this.ffL;
    }

    public List<b> bfw() {
        return this.ffM;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.ffK = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.ffL.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.ffM.add(bVar);
                }
            }
        }
    }
}
