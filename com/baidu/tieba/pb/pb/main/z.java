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
    public static final BdUniqueId kqv = BdUniqueId.gen();
    public String cover;
    public MetaData dSF;
    public String description;
    public boolean isChushou;
    public int kqw;
    public com.baidu.tbadk.core.data.aq kqz;
    public long liveId;
    public int liveStatus;
    public String routeType;
    public String thirdLiveType;
    public String thirdRoomId;
    private HashMap<String, MetaData> userMap;
    public String userName;
    private boolean dPr = false;
    public boolean kqx = false;
    public boolean kqy = false;

    public void a(AlaLiveInfo alaLiveInfo) {
        MetaData metaData;
        if (alaLiveInfo != null && alaLiveInfo.user_info != null && alaLiveInfo.live_status.intValue() == 1 && alaLiveInfo.pb_display_type.intValue() == 1) {
            this.userName = alaLiveInfo.user_info.user_name;
            this.description = alaLiveInfo.description;
            this.cover = alaLiveInfo.cover;
            this.kqw = alaLiveInfo.audience_count.intValue();
            this.liveStatus = alaLiveInfo.live_status.intValue();
            this.liveId = alaLiveInfo.live_id.longValue();
            this.isChushou = alaLiveInfo.live_from.intValue() == 1;
            this.thirdLiveType = alaLiveInfo.third_live_type;
            this.thirdRoomId = alaLiveInfo.third_room_id;
            this.routeType = alaLiveInfo.router_type;
            if (alaLiveInfo.user_info.user_id != null && alaLiveInfo.user_info.user_id.longValue() > 0 && this.userMap != null && (metaData = this.userMap.get(alaLiveInfo.user_info.user_id.toString())) != null) {
                this.dSF = metaData;
                this.dSF.setIsLike(this.dSF.hadConcerned());
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
                this.kqz = new com.baidu.tbadk.core.data.aq();
                this.kqz.setFeedBackReasonMap(sparseArray);
                this.kqz.dPE = sparseArray2;
            } else {
                this.kqz = null;
            }
            this.dPr = true;
        }
    }

    public boolean isValid() {
        return this.dPr;
    }

    public void reset() {
        this.userName = null;
        this.kqw = 0;
        this.description = null;
        this.cover = null;
        this.liveStatus = 0;
        this.liveId = 0L;
        this.dSF = null;
        this.userMap = null;
        this.isChushou = false;
        this.thirdLiveType = null;
        this.thirdRoomId = null;
        this.routeType = null;
        this.kqy = false;
        this.dPr = false;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kqv;
    }
}
