package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.HashMap;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.DislikeInfo;
/* loaded from: classes2.dex */
public class x implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lLH = BdUniqueId.gen();
    public String cover;
    public String description;
    private boolean eLO;
    public MetaData ePn;
    public boolean isChushou;
    public int lKX;
    public boolean lKY = false;
    public com.baidu.tbadk.core.data.at lLa;
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
            this.lKX = alaLiveInfo.audience_count.intValue();
            this.description = alaLiveInfo.description;
            this.cover = alaLiveInfo.cover;
            this.liveId = alaLiveInfo.live_id.longValue();
            this.isChushou = alaLiveInfo.live_from.intValue() == 1;
            this.thirdLiveType = alaLiveInfo.third_live_type;
            this.thirdRoomId = alaLiveInfo.third_room_id;
            this.routeType = alaLiveInfo.router_type;
            if (alaLiveInfo.user_info.user_id != null && alaLiveInfo.user_info.user_id.longValue() > 0 && this.userMap != null && (metaData = this.userMap.get(alaLiveInfo.user_info.user_id.toString())) != null) {
                this.ePn = metaData;
            }
            List<DislikeInfo> list = alaLiveInfo.dislike_info;
            if (com.baidu.tbadk.core.util.x.getCount(list) > 0) {
                SparseArray<String> sparseArray = new SparseArray<>();
                SparseArray<String> sparseArray2 = new SparseArray<>();
                for (DislikeInfo dislikeInfo : list) {
                    if (dislikeInfo != null) {
                        sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        sparseArray2.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.extra);
                    }
                }
                this.lLa = new com.baidu.tbadk.core.data.at();
                this.lLa.setFeedBackReasonMap(sparseArray);
                this.lLa.eMc = sparseArray2;
            } else {
                this.lLa = null;
            }
            this.eLO = true;
            return;
        }
        this.eLO = false;
    }

    public boolean isValid() {
        return this.eLO;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lLH;
    }
}
