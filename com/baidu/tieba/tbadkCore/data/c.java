package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String eWQ;
    private ArrayList<a> eWR = new ArrayList<>();
    private ArrayList<b> eWS = new ArrayList<>();

    public String bbF() {
        return this.eWQ;
    }

    public List<a> bbG() {
        return this.eWR;
    }

    public List<b> bbH() {
        return this.eWS;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.eWQ = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.eWR.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.eWS.add(bVar);
                }
            }
        }
    }
}
