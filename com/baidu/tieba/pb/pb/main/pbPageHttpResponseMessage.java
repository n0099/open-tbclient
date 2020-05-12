package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbPage.PbPageResIdl;
/* loaded from: classes9.dex */
public class pbPageHttpResponseMessage extends TbHttpResponsedMessage {
    private String cacheKey;
    private Context context;
    private boolean isFromMark;
    private com.baidu.tieba.pb.data.d mAppealInfo;
    private com.baidu.tieba.pb.data.e pbData;
    private int updateType;

    public pbPageHttpResponseMessage(int i) {
        super(i);
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public com.baidu.tieba.pb.data.e getPbData() {
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
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        PbPageResIdl pbPageResIdl = (PbPageResIdl) PbPageRequestMessage.WIRE.parseFrom(bArr, PbPageResIdl.class);
        setError(pbPageResIdl.error.errorno.intValue());
        setErrorString(pbPageResIdl.error.usermsg);
        if (getError() != 0) {
            if (getError() == 4 && pbPageResIdl.data != null) {
                this.mAppealInfo = new com.baidu.tieba.pb.data.d();
                if (pbPageResIdl.data.appeal_info != null) {
                    this.mAppealInfo.source = pbPageResIdl.data.appeal_info.source;
                    this.mAppealInfo.jns = pbPageResIdl.data.appeal_info.appeal_url;
                }
                if (pbPageResIdl.data.forum != null) {
                    this.mAppealInfo.forumName = pbPageResIdl.data.forum.name;
                    return;
                }
                return;
            }
            return;
        }
        this.pbData = new com.baidu.tieba.pb.data.e();
        this.pbData.zj(2);
        this.pbData.a(pbPageResIdl.data, this.context);
        if (pbPageResIdl.data != null) {
            String str = "";
            if (pbPageResIdl.data.forum != null) {
                str = pbPageResIdl.data.forum.name;
            }
            JSONObject a = com.baidu.tieba.recapp.report.b.a(pbPageResIdl.data.thread, str);
            ArrayList arrayList = new ArrayList();
            if (a != null) {
                arrayList.add(a);
            }
            com.baidu.tieba.recapp.report.b.cOd().en(arrayList);
        }
        BdLog.detailException(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        switch (this.updateType) {
            case 3:
                i.cxh().a(this.cacheKey, this.isFromMark, bArr);
                return;
            case 4:
                i.cxh().n(this.cacheKey, bArr);
                return;
            default:
                return;
        }
    }
}
