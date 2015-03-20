package com.baidu.tieba.recommendfrs.data;

import com.baidu.tbadk.mvc.b.k;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.FineFrsPage.EverydayThread;
import tbclient.FineFrsPage.FineBanner;
import tbclient.FineFrsPage.FineFrsPageResIdl;
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.mvc.b.b, k {
    private List<a> bXN;
    private List<EverydayThread> bXO;
    private boolean mHasMore;

    public List<a> afF() {
        return this.bXN;
    }

    public List<EverydayThread> afG() {
        return this.bXO;
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "RecommendFrsData";
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void c(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void a(Message message) {
        if (message instanceof FineFrsPageResIdl) {
            FineFrsPageResIdl fineFrsPageResIdl = (FineFrsPageResIdl) message;
            if (fineFrsPageResIdl.error.errorno.intValue() == 0 && fineFrsPageResIdl.data != null) {
                this.bXN = new ArrayList();
                List<FineBanner> list = fineFrsPageResIdl.data.fine_banner;
                if (list != null) {
                    for (FineBanner fineBanner : list) {
                        if (fineBanner != null) {
                            a aVar = new a();
                            if (fineBanner.ftid != null) {
                                aVar.setFtid(fineBanner.ftid.longValue());
                            }
                            aVar.ii(fineBanner.pic_url);
                            aVar.ih(fineBanner.title);
                            this.bXN.add(aVar);
                        }
                    }
                }
                this.bXO = fineFrsPageResIdl.data.everyday_thread;
                this.mHasMore = fineFrsPageResIdl.data.has_more.intValue() == 1;
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Aw() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean A(byte[] bArr) {
        try {
            a((FineFrsPageResIdl) new Wire(new Class[0]).parseFrom(bArr, FineFrsPageResIdl.class));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
