package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import tbclient.PbPage.PbPageResIdl;
/* loaded from: classes6.dex */
public class PbPageReadLocalResponseMessage extends CustomResponsedMessage<Object> {
    private Context context;
    private boolean markCache;
    private com.baidu.tieba.pb.data.f pbData;
    private String postId;
    private int updateType;

    public int getUpdateType() {
        return this.updateType;
    }

    public void setUpdateType(int i) {
        this.updateType = i;
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.pbData;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.pbData = fVar;
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public boolean isMarkCache() {
        return this.markCache;
    }

    public void setMarkCache(boolean z) {
        this.markCache = z;
    }

    public PbPageReadLocalResponseMessage() {
        super(CmdConfigCustom.PB_PAGE_CACHE_CMD);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        if (bArr != null) {
            PbPageResIdl pbPageResIdl = (PbPageResIdl) PbPageRequestMessage.WIRE.parseFrom(bArr, PbPageResIdl.class);
            setError(pbPageResIdl.error.errorno.intValue());
            setErrorString(pbPageResIdl.error.usermsg);
            if (getError() == 0 && pbPageResIdl.data != null) {
                this.pbData = new com.baidu.tieba.pb.data.f();
                this.pbData.yo(1);
                try {
                    this.pbData.a(pbPageResIdl.data, this.context);
                    if (!this.pbData.isValid()) {
                        this.pbData = null;
                    } else if (isMarkCache() && this.pbData.awc() != null && !this.pbData.awc().equals(this.postId)) {
                        this.pbData = null;
                    }
                } catch (Exception e) {
                }
            }
        }
    }
}
