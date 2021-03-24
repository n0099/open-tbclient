package com.baidu.tieba.square.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import tbclient.GetForumSquare.DataReq;
import tbclient.GetForumSquare.GetForumSquareReqIdl;
/* loaded from: classes5.dex */
public class ForumSquareRequestMessage extends NetMessage {
    public static final int LOAD_RN = 20;
    public String className;
    public int pn;

    public ForumSquareRequestMessage() {
        super(CmdConfigHttp.CMD_FORUM_SQUARE, 309653);
        this.pn = 1;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.class_name = this.className;
            builder.pn = Integer.valueOf(this.pn);
            builder.rn = 20;
            builder.user_id = Long.valueOf(TbadkCoreApplication.getCurrentAccountId());
            if (z) {
                w.a(builder, true);
            }
            GetForumSquareReqIdl.Builder builder2 = new GetForumSquareReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }
}
