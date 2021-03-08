package com.baidu.tieba.pb.videopb.c;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.AlaLiveInfo;
import tbclient.Promotion;
/* loaded from: classes2.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId moG = BdUniqueId.gen();
    private Long appear_time;
    private String image;
    public boolean isChushou;
    private String link;
    private String link_text;
    private long moI;
    public String routeType;
    private String sub_title;
    public String thirdLiveType;
    public String thirdRoomId;
    private String title;
    public long userId;
    private boolean moH = false;
    public boolean moJ = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return moG;
    }

    public String getTitle() {
        return this.title;
    }

    public String dvu() {
        return this.sub_title;
    }

    public String getImage() {
        return this.image;
    }

    public String getLink() {
        return this.link;
    }

    public String dvv() {
        return this.link_text;
    }

    public Long dvw() {
        return this.appear_time;
    }

    public boolean dvx() {
        return this.moH;
    }

    public long dvy() {
        return this.moI;
    }

    public void a(Promotion promotion) {
        this.title = promotion.title;
        this.sub_title = promotion.sub_title;
        this.image = promotion.image;
        this.link = promotion.link;
        this.link_text = promotion.link_text;
        this.appear_time = promotion.appear_time;
        this.moH = false;
        this.moJ = false;
    }

    public void parserProtoBuf(@NonNull AlaLiveInfo alaLiveInfo) {
        this.title = alaLiveInfo.first_headline;
        this.sub_title = alaLiveInfo.second_headline;
        this.image = alaLiveInfo.cover;
        this.moI = alaLiveInfo.live_id.longValue();
        this.userId = alaLiveInfo.user_info != null ? alaLiveInfo.user_info.user_id.longValue() : 0L;
        this.isChushou = alaLiveInfo.live_from.intValue() == 1;
        this.thirdLiveType = alaLiveInfo.third_live_type;
        this.thirdRoomId = alaLiveInfo.third_room_id;
        this.routeType = alaLiveInfo.router_type;
        this.link = "";
        this.link_text = TbadkCoreApplication.getInst().getString(R.string.pb_ala_enter);
        this.appear_time = 1L;
        this.moH = true;
        this.moJ = false;
    }
}
