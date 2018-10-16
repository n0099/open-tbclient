package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String hcp;
    private ArrayList<a> hcq = new ArrayList<>();
    private ArrayList<b> hcr = new ArrayList<>();

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.hcp = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.hcq.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.hcr.add(bVar);
                }
            }
        }
    }
}
