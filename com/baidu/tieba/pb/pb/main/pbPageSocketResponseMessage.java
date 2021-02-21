package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbPage.PbPageResIdl;
/* loaded from: classes2.dex */
public class pbPageSocketResponseMessage extends SocketResponsedMessage {
    private String cacheKey;
    private Context context;
    private boolean isFromMark;
    private com.baidu.tieba.pb.data.d mAppealInfo;
    private com.baidu.tieba.pb.data.f pbData;
    private int updateType;

    public pbPageSocketResponseMessage() {
        super(CmdConfigSocket.CMD_PB_PAGE);
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        super.setOrginalMessage(message);
        if (message.getExtra() instanceof PbPageRequestMessage) {
            PbPageRequestMessage pbPageRequestMessage = (PbPageRequestMessage) message.getExtra();
            this.updateType = pbPageRequestMessage.getUpdateType();
            this.cacheKey = pbPageRequestMessage.getCacheKey();
            this.isFromMark = pbPageRequestMessage.getIsFromMark();
            this.context = pbPageRequestMessage.getContext();
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.pbData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        PbPageResIdl pbPageResIdl = (PbPageResIdl) PbPageRequestMessage.WIRE.parseFrom(bArr, PbPageResIdl.class);
        setError(pbPageResIdl.error.errorno.intValue());
        setErrorString(pbPageResIdl.error.usermsg);
        if (getError() != 0) {
            if (getError() == 4 && pbPageResIdl.data != null) {
                this.mAppealInfo = new com.baidu.tieba.pb.data.d();
                if (pbPageResIdl.data.appeal_info != null) {
                    this.mAppealInfo.source = pbPageResIdl.data.appeal_info.source;
                    this.mAppealInfo.lKe = pbPageResIdl.data.appeal_info.appeal_url;
                }
                if (pbPageResIdl.data.forum != null) {
                    this.mAppealInfo.forumName = pbPageResIdl.data.forum.name;
                    return;
                }
                return;
            }
            return;
        }
        this.pbData = new com.baidu.tieba.pb.data.f();
        this.pbData.Fu(2);
        this.pbData.a(pbPageResIdl.data, this.context);
        if (pbPageResIdl.data != null) {
            JSONObject f = com.baidu.tieba.recapp.report.b.f(pbPageResIdl.data.thread);
            ArrayList arrayList = new ArrayList();
            if (f != null) {
                arrayList.add(f);
            }
            com.baidu.tieba.recapp.report.b.dEt().q("PB", arrayList);
        }
        BdLog.detailException(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        switch (this.updateType) {
            case 3:
                i.dnd().a(this.cacheKey, this.isFromMark, bArr);
                return;
            case 4:
                i.dnd().o(this.cacheKey, bArr);
                return;
            default:
                return;
        }
    }
}
