package com.baidu.tieba.pb.videopb.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.b;
import tbclient.Promotion;
/* loaded from: classes9.dex */
public class a extends b {
    public static final BdUniqueId jca = BdUniqueId.gen();
    private Long appear_time;
    private String image;
    private String link;
    private String link_text;
    private String sub_title;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jca;
    }

    public String getTitle() {
        return this.title;
    }

    public String cuf() {
        return this.sub_title;
    }

    public String getImage() {
        return this.image;
    }

    public String getLink() {
        return this.link;
    }

    public String cug() {
        return this.link_text;
    }

    public Long cuh() {
        return this.appear_time;
    }

    public void a(Promotion promotion) {
        this.title = promotion.title;
        this.sub_title = promotion.sub_title;
        this.image = promotion.image;
        this.link = promotion.link;
        this.link_text = promotion.link_text;
        this.appear_time = promotion.appear_time;
    }
}
