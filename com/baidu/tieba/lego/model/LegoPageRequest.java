package com.baidu.tieba.lego.model;

import android.text.TextUtils;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.t;
import tbclient.Lego.DataReq;
import tbclient.Lego.LegoReqIdl;
/* loaded from: classes8.dex */
public class LegoPageRequest extends NetMessage {
    private String itemId;
    private String lastRank;
    private int pageType;
    private String params;
    private int pn;
    private int rn;
    private long tagCode;

    public LegoPageRequest() {
        super(1003079, CmdConfigSocket.CMD_ENTERTAINMENT);
        this.rn = 30;
        this.tagCode = 0L;
    }

    public int getPageType() {
        return this.pageType;
    }

    public void setPageType(int i) {
        this.pageType = i;
    }

    public int getPn() {
        return this.pn;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public String getParams() {
        return this.params;
    }

    public void setParams(String str) {
        this.params = str;
    }

    public void setTagCode(long j) {
        this.tagCode = j;
    }

    public long getTagCode() {
        return this.tagCode;
    }

    public void setLastRank(String str) {
        this.lastRank = str;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            t.b(builder, true);
        }
        builder.page_type = Integer.valueOf(this.pageType);
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        builder.scr_w = Integer.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        builder.scr_h = Integer.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        builder.scr_dip = Double.valueOf(l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        if (!TextUtils.isEmpty(this.params)) {
            builder.params = this.params;
        }
        builder.flip_id = this.lastRank;
        if (!TextUtils.isEmpty(this.itemId)) {
            builder.item_id = this.itemId;
        }
        if (this.tagCode != 0) {
            builder.page_id = Long.valueOf(this.tagCode);
        }
        LegoReqIdl.Builder builder2 = new LegoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
