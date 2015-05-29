package com.baidu.tieba.mention;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import tbclient.ReplyMe.DataReq;
import tbclient.ReplyMe.ReplyMeReqIdl;
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.mvc.b.e, com.baidu.tbadk.mvc.b.i {
    private int aLd = 1;
    private int bGu;
    private String ids;

    public void b(FeedData feedData) {
        if (feedData != null) {
            this.ids = String.format("%s,%s", feedData.getThread_id(), feedData.getPost_id());
        }
    }

    public void RR() {
        this.aLd++;
        this.bGu = 4;
    }

    public void reset() {
        this.aLd = 1;
        this.bGu = 1;
        this.ids = null;
    }

    public int getUpdateType() {
        return this.bGu;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oS() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
        hashMap.put("pn", String.valueOf(this.aLd));
        if (this.bGu == 4 && !TextUtils.isEmpty(this.ids)) {
            hashMap.put("ids", this.ids);
        }
        return hashMap;
    }

    @Override // com.baidu.tbadk.mvc.b.l
    public Object Y(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pn = Integer.valueOf(this.aLd);
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
    public String AJ() {
        return "tb_user_replyme";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Bp() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return true;
    }
}
