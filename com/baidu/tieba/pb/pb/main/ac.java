package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.HashMap;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.DislikeInfo;
/* loaded from: classes16.dex */
public class ac implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kqW = BdUniqueId.gen();
    public String cover;
    private boolean dPr;
    public MetaData dSF;
    public String description;
    public boolean isChushou;
    public com.baidu.tbadk.core.data.aq kqB;
    public int kqy;
    public boolean kqz = false;
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
            this.kqy = alaLiveInfo.audience_count.intValue();
            this.description = alaLiveInfo.description;
            this.cover = alaLiveInfo.cover;
            this.liveId = alaLiveInfo.live_id.longValue();
            this.isChushou = alaLiveInfo.live_from.intValue() == 1;
            this.thirdLiveType = alaLiveInfo.third_live_type;
            this.thirdRoomId = alaLiveInfo.third_room_id;
            this.routeType = alaLiveInfo.router_type;
            if (alaLiveInfo.user_info.user_id != null && alaLiveInfo.user_info.user_id.longValue() > 0 && this.userMap != null && (metaData = this.userMap.get(alaLiveInfo.user_info.user_id.toString())) != null) {
                this.dSF = metaData;
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
                this.kqB = new com.baidu.tbadk.core.data.aq();
                this.kqB.setFeedBackReasonMap(sparseArray);
                this.kqB.dPE = sparseArray2;
            } else {
                this.kqB = null;
            }
            this.dPr = true;
            return;
        }
        this.dPr = false;
    }

    public boolean isValid() {
        return this.dPr;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kqW;
    }
}
