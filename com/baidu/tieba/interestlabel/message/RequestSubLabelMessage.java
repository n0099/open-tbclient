package com.baidu.tieba.interestlabel.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.p;
import java.util.ArrayList;
import java.util.List;
import tbclient.CommonReq;
import tbclient.SubTagList.DataReq;
import tbclient.SubTagList.SubTagListReqIdl;
/* loaded from: classes3.dex */
public class RequestSubLabelMessage extends NetMessage {
    private CommonReq common;
    private List<Integer> labelList;

    public RequestSubLabelMessage() {
        super(CmdConfigHttp.CMD_SUB_INTEREST_LABEL_LIST, 309468);
    }

    public void setCommon(CommonReq commonReq) {
        this.common = commonReq;
    }

    public void setLabelList(List<Integer> list) {
        if (w.A(list)) {
            list = new ArrayList<>();
        }
        this.labelList = list;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.common = this.common;
        builder.arr_tag_id = this.labelList;
        if (z) {
            p.bindCommonParamsToProtobufData(builder, true);
        }
        SubTagListReqIdl.Builder builder2 = new SubTagListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
