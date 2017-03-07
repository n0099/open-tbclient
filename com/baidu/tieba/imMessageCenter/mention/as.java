package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import tbclient.ReplyMe.DataReq;
import tbclient.ReplyMe.ReplyMeReqIdl;
/* loaded from: classes.dex */
public class as implements com.baidu.tbadk.mvc.b.e, com.baidu.tbadk.mvc.b.h {
    private int dmI;
    private String ids;
    private int mPn = 1;

    public void g(FeedData feedData) {
        if (feedData != null) {
            this.ids = String.format("%s,%s", feedData.getThread_id(), feedData.getPost_id());
        }
    }

    public void toNextPage() {
        this.mPn++;
        this.dmI = 4;
    }

    public void reset() {
        this.mPn = 1;
        this.dmI = 1;
        this.ids = null;
    }

    public int getUpdateType() {
        return this.dmI;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> EL() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
        hashMap.put("pn", String.valueOf(this.mPn));
        if (this.dmI == 4 && !TextUtils.isEmpty(this.ids)) {
            hashMap.put("ids", this.ids);
        }
        return hashMap;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object bN(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pn = Integer.valueOf(this.mPn);
            builder.ids = this.ids;
            if (z) {
                com.baidu.tbadk.util.n.bindCommonParamsToProtobufData(builder, true);
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
    public String EI() {
        return "tb_user_replyme";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean EJ() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return true;
    }
}
