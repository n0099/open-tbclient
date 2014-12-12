package com.baidu.tieba.mention;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import tbclient.ReplyMe.DataReq;
import tbclient.ReplyMe.ReplyMeReqIdl;
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.mvc.b.e, com.baidu.tbadk.mvc.b.h {
    private int aBR = 1;
    private int bsu;
    private String ids;

    public void b(FeedData feedData) {
        if (feedData != null) {
            this.ids = String.format("%s,%s", feedData.getThread_id(), feedData.getPost_id());
        }
    }

    public void OC() {
        this.aBR++;
        this.bsu = 4;
    }

    public void reset() {
        this.aBR = 1;
        this.bsu = 1;
        this.ids = null;
    }

    public int getUpdateType() {
        return this.bsu;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> kQ() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
        hashMap.put("pn", String.valueOf(this.aBR));
        if (this.bsu == 4 && !TextUtils.isEmpty(this.ids)) {
            hashMap.put("ids", this.ids);
        }
        return hashMap;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object X(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pn = Integer.valueOf(this.aBR);
            builder.ids = this.ids;
            if (z) {
                com.baidu.tbadk.util.h.a(builder, true);
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
    public String lq() {
        return "tb_user_replyme";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean xb() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return true;
    }
}
