package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import tbclient.ReplyMe.DataReq;
import tbclient.ReplyMe.ReplyMeReqIdl;
/* loaded from: classes2.dex */
public class m implements com.baidu.tbadk.mvc.b.e, com.baidu.tbadk.mvc.b.h {
    private int eTl;
    private String ids;
    private int mPn = 1;

    public void d(FeedData feedData) {
        if (feedData != null) {
            this.ids = String.format("%s,%s", feedData.getThread_id(), feedData.getPost_id());
        }
    }

    public void toNextPage() {
        this.mPn++;
        this.eTl = 4;
    }

    public void reset() {
        this.mPn = 1;
        this.eTl = 1;
        this.ids = null;
    }

    public int getUpdateType() {
        return this.eTl;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> Nb() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
        hashMap.put("pn", String.valueOf(this.mPn));
        hashMap.put("q_type", Integer.valueOf(com.baidu.tbadk.core.i.xo().getViewImageQuality()));
        hashMap.put("scr_dip", Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density));
        hashMap.put("scr_h", Integer.valueOf(com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getApp())));
        hashMap.put("scr_w", Integer.valueOf(com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getApp())));
        if (this.eTl == 4 && !TextUtils.isEmpty(this.ids)) {
            hashMap.put("ids", this.ids);
        }
        return hashMap;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object cs(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pn = Integer.valueOf(this.mPn);
            builder.ids = this.ids;
            builder.q_type = Integer.valueOf(com.baidu.tbadk.core.i.xo().getViewImageQuality());
            builder.scr_dip = Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
            builder.scr_h = Integer.valueOf(com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getApp()));
            builder.scr_w = Integer.valueOf(com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getApp()));
            if (z) {
                com.baidu.tbadk.util.o.bindCommonParamsToProtobufData(builder, true);
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
    public String MY() {
        return "tb_user_replyme";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean MZ() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return true;
    }
}
