package com.baidu.tieba.pb.videopb.c;

import android.support.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.b;
import tbclient.AlaLiveInfo;
import tbclient.Promotion;
/* loaded from: classes22.dex */
public class a extends b {
    public static final BdUniqueId lvP = BdUniqueId.gen();
    private Long appear_time;
    private String image;
    public boolean isChushou;
    private String link;
    private String link_text;
    private long lvR;
    public String routeType;
    private String sub_title;
    public String thirdLiveType;
    public String thirdRoomId;
    private String title;
    public long userId;
    private boolean lvQ = false;
    public boolean lvS = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lvP;
    }

    public String getTitle() {
        return this.title;
    }

    public String dmp() {
        return this.sub_title;
    }

    public String getImage() {
        return this.image;
    }

    public String getLink() {
        return this.link;
    }

    public String dmq() {
        return this.link_text;
    }

    public Long dmr() {
        return this.appear_time;
    }

    public boolean dms() {
        return this.lvQ;
    }

    public long dmt() {
        return this.lvR;
    }

    public void a(Promotion promotion) {
        this.title = promotion.title;
        this.sub_title = promotion.sub_title;
        this.image = promotion.image;
        this.link = promotion.link;
        this.link_text = promotion.link_text;
        this.appear_time = promotion.appear_time;
        this.lvQ = false;
        this.lvS = false;
    }

    public void parserProtoBuf(@NonNull AlaLiveInfo alaLiveInfo) {
        this.title = alaLiveInfo.first_headline;
        this.sub_title = alaLiveInfo.second_headline;
        this.image = alaLiveInfo.cover;
        this.lvR = alaLiveInfo.live_id.longValue();
        this.userId = alaLiveInfo.user_info != null ? alaLiveInfo.user_info.user_id.longValue() : 0L;
        this.isChushou = alaLiveInfo.live_from.intValue() == 1;
        this.thirdLiveType = alaLiveInfo.third_live_type;
        this.thirdRoomId = alaLiveInfo.third_room_id;
        this.routeType = alaLiveInfo.router_type;
        this.link = "";
        this.link_text = TbadkCoreApplication.getInst().getString(R.string.pb_ala_enter);
        this.appear_time = 1L;
        this.lvQ = true;
        this.lvS = false;
    }
}
