package com.baidu.tieba.pb.videopb.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.b;
import tbclient.Promotion;
/* loaded from: classes6.dex */
public class a extends b {
    public static final BdUniqueId iVd = BdUniqueId.gen();
    private Long appear_time;
    private String image;
    private String link;
    private String link_text;
    private String sub_title;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iVd;
    }

    public String getTitle() {
        return this.title;
    }

    public String crf() {
        return this.sub_title;
    }

    public String getImage() {
        return this.image;
    }

    public String getLink() {
        return this.link;
    }

    public String crg() {
        return this.link_text;
    }

    public Long crh() {
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
