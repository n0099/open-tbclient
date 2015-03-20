package com.baidu.tieba.mention;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import tbclient.ReplyMe.DataReq;
import tbclient.ReplyMe.ReplyMeReqIdl;
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.mvc.b.e, com.baidu.tbadk.mvc.b.i {
    private int aIM = 1;
    private int bDm;
    private String ids;

    public void b(FeedData feedData) {
        if (feedData != null) {
            this.ids = String.format("%s,%s", feedData.getThread_id(), feedData.getPost_id());
        }
    }

    public void Qq() {
        this.aIM++;
        this.bDm = 4;
    }

    public void reset() {
        this.aIM = 1;
        this.bDm = 1;
        this.ids = null;
    }

    public int getUpdateType() {
        return this.bDm;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oC() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
        hashMap.put("pn", String.valueOf(this.aIM));
        if (this.bDm == 4 && !TextUtils.isEmpty(this.ids)) {
            hashMap.put("ids", this.ids);
        }
        return hashMap;
    }

    @Override // com.baidu.tbadk.mvc.b.l
    public Object V(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pn = Integer.valueOf(this.aIM);
            builder.ids = this.ids;
            if (z) {
                com.baidu.tbadk.util.j.a(builder, true);
            }
            ReplyMeReqIdl.Builder builder2 = new ReplyMeReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "replyme_cache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String zR() {
        return "tb_user_replyme";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Ax() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return true;
    }
}
