package com.baidu.tieba.interestlabel.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.j0.z0.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.CommonReq;
import tbclient.SubTagList.DataReq;
import tbclient.SubTagList.SubTagListReqIdl;
/* loaded from: classes4.dex */
public class RequestSubLabelMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f17832common;
    public List<Integer> labelList;

    public RequestSubLabelMessage() {
        super(CmdConfigHttp.CMD_SUB_INTEREST_LABEL_LIST, 309468);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f69517common = this.f17832common;
        builder.arr_tag_id = this.labelList;
        if (z) {
            w.a(builder, true);
        }
        SubTagListReqIdl.Builder builder2 = new SubTagListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setCommon(CommonReq commonReq) {
        this.f17832common = commonReq;
    }

    public void setLabelList(List<Integer> list) {
        if (ListUtils.isEmpty(list)) {
            list = new ArrayList<>();
        }
        this.labelList = list;
    }
}
