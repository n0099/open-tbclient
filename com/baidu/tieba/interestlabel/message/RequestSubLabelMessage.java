package com.baidu.tieba.interestlabel.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.CommonReq;
import tbclient.SubTagList.DataReq;
import tbclient.SubTagList.SubTagListReqIdl;
/* loaded from: classes8.dex */
public class RequestSubLabelMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    private CommonReq f979common;
    private List<Integer> labelList;

    public RequestSubLabelMessage() {
        super(1003334, CmdConfigSocket.CMD_SUB_INTEREST_LABEL_LIST);
    }

    public void setCommon(CommonReq commonReq) {
        this.f979common = commonReq;
    }

    public void setLabelList(List<Integer> list) {
        if (v.isEmpty(list)) {
            list = new ArrayList<>();
        }
        this.labelList = list;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f1196common = this.f979common;
        builder.arr_tag_id = this.labelList;
        if (z) {
            t.a(builder, true);
        }
        SubTagListReqIdl.Builder builder2 = new SubTagListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
