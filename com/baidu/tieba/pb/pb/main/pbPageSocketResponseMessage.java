package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import d.b.j0.d2.h.c;
import d.b.j0.d2.h.e;
import d.b.j0.d2.k.e.k;
import d.b.j0.s2.f0.b;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.PbPage.PbPageResIdl;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class pbPageSocketResponseMessage extends SocketResponsedMessage {
    public String cacheKey;
    public Context context;
    public boolean isFromMark;
    public c mAppealInfo;
    public e pbData;
    public int updateType;

    public pbPageSocketResponseMessage() {
        super(302001);
    }

    public c getAppealInfo() {
        return this.mAppealInfo;
    }

    public e getPbData() {
        return this.pbData;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        int i2 = this.updateType;
        if (i2 == 3) {
            k.b().e(this.cacheKey, this.isFromMark, bArr);
        } else if (i2 != 4) {
        } else {
            k.b().f(this.cacheKey, bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        PbPageResIdl pbPageResIdl = (PbPageResIdl) PbPageRequestMessage.WIRE.parseFrom(bArr, PbPageResIdl.class);
        setError(pbPageResIdl.error.errorno.intValue());
        setErrorString(pbPageResIdl.error.usermsg);
        if (getError() != 0) {
            if (getError() != 4 || pbPageResIdl.data == null) {
                return;
            }
            c cVar = new c();
            this.mAppealInfo = cVar;
            AppealInfo appealInfo = pbPageResIdl.data.appeal_info;
            if (appealInfo != null) {
                cVar.f54230a = appealInfo.source;
                cVar.f54232c = appealInfo.appeal_url;
            }
            SimpleForum simpleForum = pbPageResIdl.data.forum;
            if (simpleForum != null) {
                this.mAppealInfo.f54231b = simpleForum.name;
                return;
            }
            return;
        }
        e eVar = new e();
        this.pbData = eVar;
        eVar.k0(2);
        this.pbData.j0(pbPageResIdl.data, this.context);
        DataRes dataRes = pbPageResIdl.data;
        if (dataRes != null) {
            JSONObject b2 = b.b(dataRes.thread);
            ArrayList arrayList = new ArrayList();
            if (b2 != null) {
                arrayList.add(b2);
            }
            b.f().h("PB", arrayList);
        }
        BdLog.detailException(null);
    }
}
