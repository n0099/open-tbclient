package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.b.j;
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
public class g implements com.baidu.tbadk.mvc.b.b, j {
    private List<String> cJT;
    private List<a> cKt;
    private List<EverydayThread> cKu;
    private List<Hot_Thread> cKv;
    private boolean chp = true;
    private boolean mHasMore;

    public boolean isEmpty() {
        return this.cJT == null || this.cJT.size() <= 0 || this.cKu == null || this.cKu.size() <= 0;
    }

    public List<a> aqR() {
        return this.cKt;
    }

    public List<Hot_Thread> aqS() {
        return this.cKv;
    }

    public List<EverydayThread> aqT() {
        return this.cKu;
    }

    public List<String> aqU() {
        return this.cJT;
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void g(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
        if (message instanceof FineFrsPageResIdl) {
            FineFrsPageResIdl fineFrsPageResIdl = (FineFrsPageResIdl) message;
            if (fineFrsPageResIdl.error.errorno.intValue() == 0 && fineFrsPageResIdl.data != null) {
                this.cKt = new ArrayList();
                List<FineBanner> list = fineFrsPageResIdl.data.fine_banner;
                if (list != null) {
                    for (FineBanner fineBanner : list) {
                        if (fineBanner != null && fineBanner.ftid != null && fineBanner.ftid.longValue() > 0) {
                            a aVar = new a();
                            aVar.setFtid(fineBanner.ftid.longValue());
                            aVar.lc(fineBanner.link_url);
                            aVar.le(fineBanner.pic_url);
                            aVar.ld(fineBanner.title);
                            this.cKt.add(aVar);
                        }
                    }
                }
                this.cKu = fineFrsPageResIdl.data.everyday_thread;
                this.mHasMore = fineFrsPageResIdl.data.has_more.intValue() == 1;
                this.cKv = fineFrsPageResIdl.data.hot_thread;
                if (fineFrsPageResIdl.data.tag_list != null) {
                    this.cJT = new ArrayList();
                    for (String str : fineFrsPageResIdl.data.tag_list) {
                        if (!StringUtils.isNull(str)) {
                            this.cJT.add(UtilHelper.getFixedText(str, 4, false));
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Cp() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean R(byte[] bArr) {
        try {
            a((FineFrsPageResIdl) new Wire(new Class[0]).parseFrom(bArr, FineFrsPageResIdl.class));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean aqV() {
        return this.chp;
    }
}
