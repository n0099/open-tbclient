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
    public static final BdUniqueId lIn = BdUniqueId.gen();
    private Long appear_time;
    private String image;
    public boolean isChushou;
    private long lIp;
    private String link;
    private String link_text;
    public String routeType;
    private String sub_title;
    public String thirdLiveType;
    public String thirdRoomId;
    private String title;
    public long userId;
    private boolean lIo = false;
    public boolean lIq = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lIn;
    }

    public String getTitle() {
        return this.title;
    }

    public String dpx() {
        return this.sub_title;
    }

    public String getImage() {
        return this.image;
    }

    public String getLink() {
        return this.link;
    }

    public String dpy() {
        return this.link_text;
    }

    public Long dpz() {
        return this.appear_time;
    }

    public boolean dpA() {
        return this.lIo;
    }

    public long dpB() {
        return this.lIp;
    }

    public void a(Promotion promotion) {
        this.title = promotion.title;
        this.sub_title = promotion.sub_title;
        this.image = promotion.image;
        this.link = promotion.link;
        this.link_text = promotion.link_text;
        this.appear_time = promotion.appear_time;
        this.lIo = false;
        this.lIq = false;
    }

    public void parserProtoBuf(@NonNull AlaLiveInfo alaLiveInfo) {
        this.title = alaLiveInfo.first_headline;
        this.sub_title = alaLiveInfo.second_headline;
        this.image = alaLiveInfo.cover;
        this.lIp = alaLiveInfo.live_id.longValue();
        this.userId = alaLiveInfo.user_info != null ? alaLiveInfo.user_info.user_id.longValue() : 0L;
        this.isChushou = alaLiveInfo.live_from.intValue() == 1;
        this.thirdLiveType = alaLiveInfo.third_live_type;
        this.thirdRoomId = alaLiveInfo.third_room_id;
        this.routeType = alaLiveInfo.router_type;
        this.link = "";
        this.link_text = TbadkCoreApplication.getInst().getString(R.string.pb_ala_enter);
        this.appear_time = 1L;
        this.lIo = true;
        this.lIq = false;
    }
}
