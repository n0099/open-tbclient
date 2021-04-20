package com.baidu.tieba.lego.model;

import android.text.TextUtils;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.c.e.p.l;
import d.b.h0.z0.w;
import tbclient.Lego.DataReq;
import tbclient.Lego.LegoReqIdl;
/* loaded from: classes4.dex */
public class LegoPageRequest extends NetMessage {
    public String itemId;
    public String lastRank;
    public int pageType;
    public String params;
    public int pn;
    public int rn;
    public long tagCode;

    public LegoPageRequest() {
        super(CmdConfigHttp.CMD_ENTERTAINMENT, 309312);
        this.rn = 30;
        this.tagCode = 0L;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            w.a(builder, true);
        }
        builder.page_type = Integer.valueOf(this.pageType);
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        builder.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst()));
        builder.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst()));
        builder.scr_dip = Double.valueOf(l.h(TbadkCoreApplication.getInst()));
        if (!TextUtils.isEmpty(this.params)) {
            builder.params = this.params;
        }
        builder.flip_id = this.lastRank;
        if (!TextUtils.isEmpty(this.itemId)) {
            builder.item_id = this.itemId;
        }
        long j = this.tagCode;
        if (j != 0) {
            builder.page_id = Long.valueOf(j);
        }
        LegoReqIdl.Builder builder2 = new LegoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public String getItemId() {
        return this.itemId;
    }

    public int getPageType() {
        return this.pageType;
    }

    public String getParams() {
        return this.params;
    }

    public int getPn() {
        return this.pn;
    }

    public long getTagCode() {
        return this.tagCode;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    public void setLastRank(String str) {
        this.lastRank = str;
    }

    public void setPageType(int i) {
        this.pageType = i;
    }

    public void setParams(String str) {
        this.params = str;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public void setTagCode(long j) {
        this.tagCode = j;
    }
}
