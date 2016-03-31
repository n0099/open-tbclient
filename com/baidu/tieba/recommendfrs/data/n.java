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
    protected List<Object> cIf;
    protected List<Object> dWY;
    protected boolean ddo = true;
    protected boolean mHasMore;
    protected int pn;

    public int getPn() {
        return this.pn;
    }

    public boolean isEmpty() {
        return this.cIf == null || this.cIf.size() <= 0 || this.dWY == null || this.dWY.size() <= 0;
    }

    public List<Object> getThreadList() {
        return this.dWY;
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
                this.dWY = new ArrayList();
                this.dWY.addAll(excFrsPageResIdl.data.thread_list);
            }
            this.mHasMore = excFrsPageResIdl.data.has_more.intValue() == 1;
            this.pn = excFrsPageResIdl.data.pn.intValue();
            if (excFrsPageResIdl.data.tag_list != null) {
                this.cIf = new ArrayList();
                for (ExcellentTagInfo excellentTagInfo : excFrsPageResIdl.data.tag_list) {
                    if (excellentTagInfo != null) {
                        this.cIf.add(excellentTagInfo);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Fn() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean x(byte[] bArr) {
        try {
            a((ExcFrsPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcFrsPageResIdl.class));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean aMj() {
        return this.ddo;
    }
}
