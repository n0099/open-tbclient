package com.baidu.tieba.pb.main;

import android.content.Context;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.PbPage.PbPageResIdl;
/* loaded from: classes.dex */
public class pbPageSocketResponseMessage extends SocketResponsedMessage {
    private String cacheKey;
    private Context context;
    private boolean hasNetworkError;
    private boolean isFromMark;
    private com.baidu.tieba.tbadkCore.b.i pbData;
    private int updateType;

    public pbPageSocketResponseMessage() {
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
        if (message.getExtra() instanceof pbPageRequestMessage) {
            pbPageRequestMessage pbpagerequestmessage = (pbPageRequestMessage) message.getExtra();
            this.updateType = pbpagerequestmessage.getUpdateType();
            this.cacheKey = pbpagerequestmessage.getCacheKey();
            this.isFromMark = pbpagerequestmessage.getIsFromMark();
            this.hasNetworkError = hasError();
            this.context = pbpagerequestmessage.getContext();
        }
    }

    public com.baidu.tieba.tbadkCore.b.i getPbData() {
        return this.pbData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        PbPageResIdl pbPageResIdl = (PbPageResIdl) new Wire(new Class[0]).parseFrom(bArr, PbPageResIdl.class);
        setError(pbPageResIdl.error.errorno.intValue());
        setErrorString(pbPageResIdl.error.usermsg);
        if (getError() == 0) {
            this.pbData = new com.baidu.tieba.tbadkCore.b.i();
            this.pbData.a(pbPageResIdl.data, this.context);
            BdLog.detailException(null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        switch (this.updateType) {
            case 3:
                bp.XB().a(this.cacheKey, this.isFromMark, bArr);
                return;
            case 4:
                bp.XB().l(this.cacheKey, bArr);
                return;
            default:
                return;
        }
    }
}
