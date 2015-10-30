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
    private List<a> cIX;
    private List<EverydayThread> cIY;
    private List<Hot_Thread> cIZ;
    private List<String> cIx;
    private boolean cgK = true;
    private boolean mHasMore;

    public boolean isEmpty() {
        return this.cIx == null || this.cIx.size() <= 0 || this.cIY == null || this.cIY.size() <= 0;
    }

    public List<a> aql() {
        return this.cIX;
    }

    public List<Hot_Thread> aqm() {
        return this.cIZ;
    }

    public List<EverydayThread> aqn() {
        return this.cIY;
    }

    public List<String> aqo() {
        return this.cIx;
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
                this.cIX = new ArrayList();
                List<FineBanner> list = fineFrsPageResIdl.data.fine_banner;
                if (list != null) {
                    for (FineBanner fineBanner : list) {
                        if (fineBanner != null && fineBanner.ftid != null && fineBanner.ftid.longValue() > 0) {
                            a aVar = new a();
                            aVar.setFtid(fineBanner.ftid.longValue());
                            aVar.kY(fineBanner.link_url);
                            aVar.la(fineBanner.pic_url);
                            aVar.kZ(fineBanner.title);
                            this.cIX.add(aVar);
                        }
                    }
                }
                this.cIY = fineFrsPageResIdl.data.everyday_thread;
                this.mHasMore = fineFrsPageResIdl.data.has_more.intValue() == 1;
                this.cIZ = fineFrsPageResIdl.data.hot_thread;
                if (fineFrsPageResIdl.data.tag_list != null) {
                    this.cIx = new ArrayList();
                    for (String str : fineFrsPageResIdl.data.tag_list) {
                        if (!StringUtils.isNull(str)) {
                            this.cIx.add(UtilHelper.getFixedText(str, 4, false));
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Cw() {
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

    public boolean aqp() {
        return this.cgK;
    }
}
