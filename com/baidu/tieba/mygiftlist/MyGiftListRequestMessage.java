package com.baidu.tieba.mygiftlist;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.GetGiftMyList.DataReq;
import tbclient.GetGiftMyList.GetGiftMyListReqIdl;
/* loaded from: classes.dex */
public class MyGiftListRequestMessage extends TbSocketMessage {
    private int mPageNum;
    private long mUid;
    private String st_type;

    public MyGiftListRequestMessage() {
        super(308002);
        this.mUid = 0L;
    }

    public void setPageNum(int i) {
        this.mPageNum = i;
    }

    public void setUid(long j) {
        this.mUid = j;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.mPageNum);
        if (this.mUid != 0) {
            builder.uid = Long.valueOf(this.mUid);
        }
        builder.st_type = getStType();
        GetGiftMyListReqIdl.Builder builder2 = new GetGiftMyListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public String getStType() {
        return this.st_type;
    }

    public void setStType(String str) {
        this.st_type = str;
    }
}
