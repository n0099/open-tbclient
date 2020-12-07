package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.HashMap;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.DislikeInfo;
/* loaded from: classes22.dex */
public class ac implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId lKX = BdUniqueId.gen();
    public String cover;
    public String description;
    private boolean eGJ;
    public MetaData eKe;
    public boolean isChushou;
    public int lKl;
    public boolean lKm = false;
    public com.baidu.tbadk.core.data.at lKo;
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
            this.lKl = alaLiveInfo.audience_count.intValue();
            this.description = alaLiveInfo.description;
            this.cover = alaLiveInfo.cover;
            this.liveId = alaLiveInfo.live_id.longValue();
            this.isChushou = alaLiveInfo.live_from.intValue() == 1;
            this.thirdLiveType = alaLiveInfo.third_live_type;
            this.thirdRoomId = alaLiveInfo.third_room_id;
            this.routeType = alaLiveInfo.router_type;
            if (alaLiveInfo.user_info.user_id != null && alaLiveInfo.user_info.user_id.longValue() > 0 && this.userMap != null && (metaData = this.userMap.get(alaLiveInfo.user_info.user_id.toString())) != null) {
                this.eKe = metaData;
            }
            List<DislikeInfo> list = alaLiveInfo.dislike_info;
            if (com.baidu.tbadk.core.util.y.getCount(list) > 0) {
                SparseArray<String> sparseArray = new SparseArray<>();
                SparseArray<String> sparseArray2 = new SparseArray<>();
                for (DislikeInfo dislikeInfo : list) {
                    if (dislikeInfo != null) {
                        sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        sparseArray2.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.extra);
                    }
                }
                this.lKo = new com.baidu.tbadk.core.data.at();
                this.lKo.setFeedBackReasonMap(sparseArray);
                this.lKo.eGW = sparseArray2;
            } else {
                this.lKo = null;
            }
            this.eGJ = true;
            return;
        }
        this.eGJ = false;
    }

    public boolean isValid() {
        return this.eGJ;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lKX;
    }
}
