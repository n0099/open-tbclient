package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.HashMap;
import tbclient.AlaLiveInfo;
/* loaded from: classes9.dex */
public class x implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId jML = BdUniqueId.gen();
    public String cover;
    public MetaData dFJ;
    public String description;
    public boolean isChushou;
    public int jMM;
    public long liveId;
    public int liveStatus;
    public String routeType;
    public String thirdLiveType;
    public String thirdRoomId;
    private HashMap<String, MetaData> userMap;
    public String userName;
    private boolean dCL = false;
    public boolean jMN = false;
    public boolean jMO = false;

    public void a(AlaLiveInfo alaLiveInfo) {
        MetaData metaData;
        if (alaLiveInfo != null && alaLiveInfo.user_info != null && alaLiveInfo.live_status.intValue() == 1 && alaLiveInfo.pb_display_type.intValue() == 1) {
            this.userName = alaLiveInfo.user_info.user_name;
            this.description = alaLiveInfo.description;
            this.cover = alaLiveInfo.cover;
            this.jMM = alaLiveInfo.audience_count.intValue();
            this.liveStatus = alaLiveInfo.live_status.intValue();
            this.liveId = alaLiveInfo.live_id.longValue();
            this.isChushou = alaLiveInfo.live_from.intValue() == 1;
            this.thirdLiveType = alaLiveInfo.third_live_type;
            this.thirdRoomId = alaLiveInfo.third_room_id;
            this.routeType = alaLiveInfo.router_type;
            if (alaLiveInfo.user_info.user_id != null && alaLiveInfo.user_info.user_id.longValue() > 0 && this.userMap != null && (metaData = this.userMap.get(alaLiveInfo.user_info.user_id.toString())) != null) {
                this.dFJ = metaData;
                this.dFJ.setIsLike(this.dFJ.hadConcerned());
            }
            this.dCL = true;
        }
    }

    public boolean isValid() {
        return this.dCL;
    }

    public void reset() {
        this.userName = null;
        this.jMM = 0;
        this.description = null;
        this.cover = null;
        this.liveStatus = 0;
        this.liveId = 0L;
        this.dFJ = null;
        this.userMap = null;
        this.isChushou = false;
        this.thirdLiveType = null;
        this.thirdRoomId = null;
        this.routeType = null;
        this.jMO = false;
        this.dCL = false;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return jML;
    }
}
