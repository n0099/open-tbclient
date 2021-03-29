package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import d.b.i0.c2.h.c;
import d.b.i0.c2.h.e;
import d.b.i0.c2.k.e.i;
import d.b.i0.r2.b0.b;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.PbPage.PbPageResIdl;
import tbclient.SimpleForum;
/* loaded from: classes4.dex */
public class pbPageHttpResponseMessage extends TbHttpResponsedMessage {
    public String cacheKey;
    public Context context;
    public boolean isFromMark;
    public c mAppealInfo;
    public e pbData;
    public int updateType;

    public pbPageHttpResponseMessage(int i) {
        super(i);
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
            i.b().e(this.cacheKey, this.isFromMark, bArr);
        } else if (i2 != 4) {
        } else {
            i.b().f(this.cacheKey, bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
                cVar.f52414a = appealInfo.source;
                cVar.f52416c = appealInfo.appeal_url;
            }
            SimpleForum simpleForum = pbPageResIdl.data.forum;
            if (simpleForum != null) {
                this.mAppealInfo.f52415b = simpleForum.name;
                return;
            }
            return;
        }
        e eVar = new e();
        this.pbData = eVar;
        eVar.j0(2);
        this.pbData.i0(pbPageResIdl.data, this.context);
        DataRes dataRes = pbPageResIdl.data;
        if (dataRes != null) {
            SimpleForum simpleForum2 = dataRes.forum;
            JSONObject c2 = b.c(pbPageResIdl.data.thread, simpleForum2 != null ? simpleForum2.name : "");
            ArrayList arrayList = new ArrayList();
            if (c2 != null) {
                arrayList.add(c2);
            }
            b.f().h("PB", arrayList);
        }
        BdLog.detailException(null);
    }
}
