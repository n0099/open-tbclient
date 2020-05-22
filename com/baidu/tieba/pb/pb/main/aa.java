package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.HashMap;
import tbclient.AlaLiveInfo;
/* loaded from: classes9.dex */
public class aa implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId jNg = BdUniqueId.gen();
    public String cover;
    private boolean dCL;
    public MetaData dFJ;
    public String description;
    public boolean isChushou;
    public int jMM;
    public boolean jMN = false;
    public long liveId;
    public int liveStatus;
    public String routeType;
    public String thirdLiveType;
    public String thirdRoomId;
    private HashMap<String, MetaData> userMap;
    public String userName;

    public void a(AlaLiveInfo alaLiveInfo) {
        MetaData metaData;
        if (alaLiveInfo != null && alaLiveInfo.user_info != null && alaLiveInfo.pb_display_type.intValue() == 3 && alaLiveInfo.live_status.intValue() == 1) {
            this.userName = alaLiveInfo.user_info.user_name;
            this.liveStatus = alaLiveInfo.live_status.intValue();
            this.jMM = alaLiveInfo.audience_count.intValue();
            this.description = alaLiveInfo.description;
            this.cover = alaLiveInfo.cover;
            this.liveId = alaLiveInfo.live_id.longValue();
            this.isChushou = alaLiveInfo.live_from.intValue() == 1;
            this.thirdLiveType = alaLiveInfo.third_live_type;
            this.thirdRoomId = alaLiveInfo.third_room_id;
            this.routeType = alaLiveInfo.router_type;
            if (alaLiveInfo.user_info.user_id != null && alaLiveInfo.user_info.user_id.longValue() > 0 && this.userMap != null && (metaData = this.userMap.get(alaLiveInfo.user_info.user_id.toString())) != null) {
                this.dFJ = metaData;
            }
            this.dCL = true;
            return;
        }
        this.dCL = false;
    }

    public boolean isValid() {
        return this.dCL;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return jNg;
    }
}
