package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.PbPage.PbPageResIdl;
/* loaded from: classes.dex */
public class PbPageSocketResponseMessage extends SocketResponsedMessage {
    private String cacheKey;
    private Context context;
    private boolean hasNetworkError;
    private boolean isFromMark;
    private com.baidu.tieba.pb.a.b pbData;
    private int updateType;

    public PbPageSocketResponseMessage() {
        super(302001);
    }

    public boolean hasNetworkError() {
        return this.hasNetworkError;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public void setUpdateType(int i) {
        this.updateType = i;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        super.setOrginalMessage(message);
        if (message.getExtra() instanceof PbPageRequestMessage) {
            PbPageRequestMessage pbPageRequestMessage = (PbPageRequestMessage) message.getExtra();
            this.updateType = pbPageRequestMessage.getUpdateType();
            this.cacheKey = pbPageRequestMessage.getCacheKey();
            this.isFromMark = pbPageRequestMessage.getIsFromMark();
            this.hasNetworkError = hasError();
            this.context = pbPageRequestMessage.getContext();
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        return this.pbData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        PbPageResIdl pbPageResIdl = (PbPageResIdl) new Wire(new Class[0]).parseFrom(bArr, PbPageResIdl.class);
        setError(pbPageResIdl.error.errorno.intValue());
        setErrorString(pbPageResIdl.error.usermsg);
        if (getError() == 0) {
            this.pbData = new com.baidu.tieba.pb.a.b();
            this.pbData.a(pbPageResIdl.data, this.context);
            BdLog.detailException(null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        switch (this.updateType) {
            case 3:
                bi.adI().a(this.cacheKey, this.isFromMark, bArr);
                return;
            case 4:
                bi.adI().m(this.cacheKey, bArr);
                return;
            default:
                return;
        }
    }
}
