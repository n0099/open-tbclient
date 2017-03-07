package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String ftB;
    private ArrayList<a> ftC = new ArrayList<>();
    private ArrayList<b> ftD = new ArrayList<>();

    public String bgX() {
        return this.ftB;
    }

    public List<a> bgY() {
        return this.ftC;
    }

    public List<b> bgZ() {
        return this.ftD;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.ftB = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.ftC.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.ftD.add(bVar);
                }
            }
        }
    }
}
