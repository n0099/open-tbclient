package com.baidu.tieba.interestlabel.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.CommonReq;
import tbclient.SubTagList.DataReq;
import tbclient.SubTagList.SubTagListReqIdl;
/* loaded from: classes7.dex */
public class RequestSubLabelMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    private CommonReq f3597common;
    private List<Integer> labelList;

    public RequestSubLabelMessage() {
        super(1003334, CmdConfigSocket.CMD_SUB_INTEREST_LABEL_LIST);
    }

    public void setCommon(CommonReq commonReq) {
        this.f3597common = commonReq;
    }

    public void setLabelList(List<Integer> list) {
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
        }
        this.labelList = list;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f8950common = this.f3597common;
        builder.arr_tag_id = this.labelList;
        if (z) {
            v.b(builder, true);
        }
        SubTagListReqIdl.Builder builder2 = new SubTagListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
