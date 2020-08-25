package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.HashMap;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.DislikeInfo;
/* loaded from: classes16.dex */
public class z implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kFP = BdUniqueId.gen();
    public String cover;
    public String description;
    public MetaData ecb;
    public boolean isChushou;
    public int kFQ;
    public com.baidu.tbadk.core.data.ar kFT;
    public long liveId;
    public int liveStatus;
    public String routeType;
    public String thirdLiveType;
    public String thirdRoomId;
    private HashMap<String, MetaData> userMap;
    public String userName;
    private boolean dYK = false;
    public boolean kFR = false;
    public boolean kFS = false;

    public void a(AlaLiveInfo alaLiveInfo) {
        MetaData metaData;
        if (alaLiveInfo != null && alaLiveInfo.user_info != null && alaLiveInfo.live_status.intValue() == 1 && alaLiveInfo.pb_display_type.intValue() == 1) {
            this.userName = alaLiveInfo.user_info.user_name;
            this.description = alaLiveInfo.description;
            this.cover = alaLiveInfo.cover;
            this.kFQ = alaLiveInfo.audience_count.intValue();
            this.liveStatus = alaLiveInfo.live_status.intValue();
            this.liveId = alaLiveInfo.live_id.longValue();
            this.isChushou = alaLiveInfo.live_from.intValue() == 1;
            this.thirdLiveType = alaLiveInfo.third_live_type;
            this.thirdRoomId = alaLiveInfo.third_room_id;
            this.routeType = alaLiveInfo.router_type;
            if (alaLiveInfo.user_info.user_id != null && alaLiveInfo.user_info.user_id.longValue() > 0 && this.userMap != null && (metaData = this.userMap.get(alaLiveInfo.user_info.user_id.toString())) != null) {
                this.ecb = metaData;
                this.ecb.setIsLike(this.ecb.hadConcerned());
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
                this.kFT = new com.baidu.tbadk.core.data.ar();
                this.kFT.setFeedBackReasonMap(sparseArray);
                this.kFT.dYX = sparseArray2;
            } else {
                this.kFT = null;
            }
            this.dYK = true;
        }
    }

    public boolean isValid() {
        return this.dYK;
    }

    public void reset() {
        this.userName = null;
        this.kFQ = 0;
        this.description = null;
        this.cover = null;
        this.liveStatus = 0;
        this.liveId = 0L;
        this.ecb = null;
        this.userMap = null;
        this.isChushou = false;
        this.thirdLiveType = null;
        this.thirdRoomId = null;
        this.routeType = null;
        this.kFS = false;
        this.dYK = false;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kFP;
    }
}
