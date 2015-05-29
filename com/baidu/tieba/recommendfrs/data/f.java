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
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.mvc.b.b, k {
    private boolean bLg = true;
    private List<String> cbJ;
    private List<a> cca;
    private List<EverydayThread> ccb;
    private List<Hot_Thread> ccc;
    private boolean mHasMore;

    public List<a> ahC() {
        return this.cca;
    }

    public List<Hot_Thread> ahD() {
        return this.ccc;
    }

    public List<EverydayThread> ahE() {
        return this.ccb;
    }

    public List<String> ahF() {
        return this.cbJ;
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void c(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void a(Message message) {
        if (message instanceof FineFrsPageResIdl) {
            FineFrsPageResIdl fineFrsPageResIdl = (FineFrsPageResIdl) message;
            if (fineFrsPageResIdl.error.errorno.intValue() == 0 && fineFrsPageResIdl.data != null) {
                this.cca = new ArrayList();
                List<FineBanner> list = fineFrsPageResIdl.data.fine_banner;
                if (list != null) {
                    for (FineBanner fineBanner : list) {
                        if (fineBanner != null) {
                            a aVar = new a();
                            if (fineBanner.ftid != null) {
                                aVar.setFtid(fineBanner.ftid.longValue());
                            }
                            aVar.iX(fineBanner.link_url);
                            aVar.iZ(fineBanner.pic_url);
                            aVar.iY(fineBanner.title);
                            this.cca.add(aVar);
                        }
                    }
                }
                this.ccb = fineFrsPageResIdl.data.everyday_thread;
                this.mHasMore = fineFrsPageResIdl.data.has_more.intValue() == 1;
                this.ccc = fineFrsPageResIdl.data.hot_thread;
                this.cbJ = fineFrsPageResIdl.data.tag_list;
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Bo() {
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

    public boolean ahG() {
        return this.bLg;
    }
}
