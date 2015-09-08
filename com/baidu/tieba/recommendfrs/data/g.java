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
    private List<String> cAW;
    private List<a> cBw;
    private List<EverydayThread> cBx;
    private List<Hot_Thread> cBy;
    private boolean ccz = true;
    private boolean mHasMore;

    public boolean isEmpty() {
        return this.cAW == null || this.cAW.size() <= 0 || this.cBx == null || this.cBx.size() <= 0;
    }

    public List<a> anR() {
        return this.cBw;
    }

    public List<Hot_Thread> anS() {
        return this.cBy;
    }

    public List<EverydayThread> anT() {
        return this.cBx;
    }

    public List<String> anU() {
        return this.cAW;
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
                this.cBw = new ArrayList();
                List<FineBanner> list = fineFrsPageResIdl.data.fine_banner;
                if (list != null) {
                    for (FineBanner fineBanner : list) {
                        if (fineBanner != null && fineBanner.ftid != null && fineBanner.ftid.longValue() > 0) {
                            a aVar = new a();
                            aVar.setFtid(fineBanner.ftid.longValue());
                            aVar.kx(fineBanner.link_url);
                            aVar.kz(fineBanner.pic_url);
                            aVar.ky(fineBanner.title);
                            this.cBw.add(aVar);
                        }
                    }
                }
                this.cBx = fineFrsPageResIdl.data.everyday_thread;
                this.mHasMore = fineFrsPageResIdl.data.has_more.intValue() == 1;
                this.cBy = fineFrsPageResIdl.data.hot_thread;
                if (fineFrsPageResIdl.data.tag_list != null) {
                    this.cAW = new ArrayList();
                    for (String str : fineFrsPageResIdl.data.tag_list) {
                        if (!StringUtils.isNull(str)) {
                            this.cAW.add(UtilHelper.getFixedText(str, 4, false));
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] CM() {
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

    public boolean anV() {
        return this.ccz;
    }
}
