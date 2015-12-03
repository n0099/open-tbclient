package com.baidu.tieba.recommendfrs.data;

import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ExcFrsPage.ExcFrsPageResIdl;
import tbclient.ExcFrsPage.ExcellentTagInfo;
import tbclient.ExcFrsPage.ExcellentThreadInfo;
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.mvc.b.b, j {
    private boolean czM = true;
    private List<ExcellentThreadInfo> diM;
    private List<ExcellentTagInfo> dix;
    private boolean mHasMore;
    private int pn;

    public int getPn() {
        return this.pn;
    }

    public boolean isEmpty() {
        return this.dix == null || this.dix.size() <= 0 || this.diM == null || this.diM.size() <= 0;
    }

    public List<ExcellentThreadInfo> getThreadList() {
        return this.diM;
    }

    public List<ExcellentTagInfo> awk() {
        return this.dix;
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
            this.diM = excFrsPageResIdl.data.thread_list;
            this.mHasMore = excFrsPageResIdl.data.has_more.intValue() == 1;
            this.pn = excFrsPageResIdl.data.pn.intValue();
            if (excFrsPageResIdl.data.tag_list != null) {
                this.dix = new ArrayList();
                for (ExcellentTagInfo excellentTagInfo : excFrsPageResIdl.data.tag_list) {
                    if (excellentTagInfo != null) {
                        this.dix.add(excellentTagInfo);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Dq() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean R(byte[] bArr) {
        try {
            a((ExcFrsPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcFrsPageResIdl.class));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean awl() {
        return this.czM;
    }
}
