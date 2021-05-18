package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.k0.d2.h.e;
import tbclient.PbPage.PbPageResIdl;
/* loaded from: classes5.dex */
public class PbPageReadLocalResponseMessage extends CustomResponsedMessage<Object> {
    public Context context;
    public boolean markCache;
    public e pbData;
    public String postId;
    public int updateType;

    public PbPageReadLocalResponseMessage() {
        super(2004003);
    }

    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        if (bArr == null) {
            return;
        }
        PbPageResIdl pbPageResIdl = (PbPageResIdl) PbPageRequestMessage.WIRE.parseFrom(bArr, PbPageResIdl.class);
        setError(pbPageResIdl.error.errorno.intValue());
        setErrorString(pbPageResIdl.error.usermsg);
        if (getError() == 0 && pbPageResIdl.data != null) {
            e eVar = new e();
            this.pbData = eVar;
            eVar.k0(1);
            try {
                this.pbData.j0(pbPageResIdl.data, this.context);
                if (!this.pbData.e0()) {
                    this.pbData = null;
                } else if (!isMarkCache() || this.pbData.t() == null || this.pbData.t().equals(this.postId)) {
                } else {
                    this.pbData = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public e getPbData() {
        return this.pbData;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public boolean isMarkCache() {
        return this.markCache;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setMarkCache(boolean z) {
        this.markCache = z;
    }

    public void setPbData(e eVar) {
        this.pbData = eVar;
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public void setUpdateType(int i2) {
        this.updateType = i2;
    }
}
