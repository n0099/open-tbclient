package com.baidu.tieba.pb.videopb.c;

import android.support.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.AlaLiveInfo;
import tbclient.Promotion;
/* loaded from: classes22.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId mcD = BdUniqueId.gen();
    private Long appear_time;
    private String image;
    public boolean isChushou;
    private String link;
    private String link_text;
    private long mcF;
    public String routeType;
    private String sub_title;
    public String thirdLiveType;
    public String thirdRoomId;
    private String title;
    public long userId;
    private boolean mcE = false;
    public boolean mcG = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mcD;
    }

    public String getTitle() {
        return this.title;
    }

    public String dwS() {
        return this.sub_title;
    }

    public String getImage() {
        return this.image;
    }

    public String getLink() {
        return this.link;
    }

    public String dwT() {
        return this.link_text;
    }

    public Long dwU() {
        return this.appear_time;
    }

    public boolean dwV() {
        return this.mcE;
    }

    public long dwW() {
        return this.mcF;
    }

    public void a(Promotion promotion) {
        this.title = promotion.title;
        this.sub_title = promotion.sub_title;
        this.image = promotion.image;
        this.link = promotion.link;
        this.link_text = promotion.link_text;
        this.appear_time = promotion.appear_time;
        this.mcE = false;
        this.mcG = false;
    }

    public void parserProtoBuf(@NonNull AlaLiveInfo alaLiveInfo) {
        this.title = alaLiveInfo.first_headline;
        this.sub_title = alaLiveInfo.second_headline;
        this.image = alaLiveInfo.cover;
        this.mcF = alaLiveInfo.live_id.longValue();
        this.userId = alaLiveInfo.user_info != null ? alaLiveInfo.user_info.user_id.longValue() : 0L;
        this.isChushou = alaLiveInfo.live_from.intValue() == 1;
        this.thirdLiveType = alaLiveInfo.third_live_type;
        this.thirdRoomId = alaLiveInfo.third_room_id;
        this.routeType = alaLiveInfo.router_type;
        this.link = "";
        this.link_text = TbadkCoreApplication.getInst().getString(R.string.pb_ala_enter);
        this.appear_time = 1L;
        this.mcE = true;
        this.mcG = false;
    }
}
