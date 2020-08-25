package com.baidu.tieba.tbadkCore.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes2.dex */
public class c {
    private String meh;
    private ArrayList<a> mei = new ArrayList<>();
    private ArrayList<b> mej = new ArrayList<>();

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.meh = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.mei.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.mej.add(bVar);
                }
            }
        }
    }
}
