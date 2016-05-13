package com.baidu.tieba.recommendfrs.data;

import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ExcFrsPage.ExcFrsPageResIdl;
import tbclient.ExcFrsPage.ExcellentTagInfo;
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.mvc.b.b, com.baidu.tbadk.mvc.b.j {
    protected List<Object> cIJ;
    protected boolean dfI = true;
    protected List<Object> eah;
    protected boolean mHasMore;
    protected int pn;

    public int getPn() {
        return this.pn;
    }

    public boolean isEmpty() {
        return this.cIJ == null || this.cIJ.size() <= 0 || this.eah == null || this.eah.size() <= 0;
    }

    public List<Object> getThreadList() {
        return this.eah;
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
        ExcFrsPageResIdl excFrsPageResIdl;
        if ((message instanceof ExcFrsPageResIdl) && (excFrsPageResIdl = (ExcFrsPageResIdl) message) != null && excFrsPageResIdl.error != null && excFrsPageResIdl.error.errorno.intValue() == 0 && excFrsPageResIdl.data != null) {
            if (excFrsPageResIdl.data.thread_list != null) {
                this.eah = new ArrayList();
                this.eah.addAll(excFrsPageResIdl.data.thread_list);
            }
            this.mHasMore = excFrsPageResIdl.data.has_more.intValue() == 1;
            this.pn = excFrsPageResIdl.data.pn.intValue();
            if (excFrsPageResIdl.data.tag_list != null) {
                this.cIJ = new ArrayList();
                for (ExcellentTagInfo excellentTagInfo : excFrsPageResIdl.data.tag_list) {
                    if (excellentTagInfo != null) {
                        this.cIJ.add(excellentTagInfo);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Dg() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean w(byte[] bArr) {
        try {
            a((ExcFrsPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcFrsPageResIdl.class));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean aMx() {
        return this.dfI;
    }
}
