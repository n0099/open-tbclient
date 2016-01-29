package com.baidu.tieba.person.god;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodThreadList.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.e {
    private boolean ayQ;
    private int bfj;
    private int curPage;
    private int dct;
    private int dcv;
    private a dcw;
    private final com.baidu.adp.framework.listener.a dcx;
    private final List<ThreadInfo> mDatas;

    /* loaded from: classes.dex */
    public interface a {
        void c(int i, List<ThreadInfo> list);

        void fu(String str);
    }

    public boolean isLoading() {
        return this.ayQ;
    }

    public boolean hasMore() {
        return this.bfj == 1;
    }

    public void lx(int i) {
        reset();
        this.dcv = i;
        this.curPage = this.dcv;
    }

    public void a(a aVar) {
        this.dcw = aVar;
    }

    public h(com.baidu.adp.base.h<?> hVar) {
        super(hVar);
        this.curPage = 0;
        this.bfj = 1;
        this.ayQ = false;
        this.dcv = 0;
        this.dcx = new i(this, CmdConfigHttp.CMD_GOD_THREAD_LIST, 309291);
        this.mDatas = new ArrayList();
        hVar.registerListener(this.dcx);
    }

    @Override // com.baidu.adp.base.e
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.dcx.setTag(bdUniqueId);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private GodThreadListRequestMessage auC() {
        return new GodThreadListRequestMessage();
    }

    public void bp(long j) {
        GodThreadListRequestMessage auC = auC();
        auC.setUserId(j);
        auC.setPn(this.curPage + 1);
        auC.setNum(20);
        sendMessage(auC);
        this.ayQ = true;
    }

    public void i(int i, long j) {
        GodThreadListRequestMessage auC = auC();
        auC.setUserId(j);
        this.curPage = i;
        auC.setPn(this.curPage);
        auC.setNum(20);
        sendMessage(auC);
        this.ayQ = true;
    }

    public void reset() {
        this.curPage = this.dcv;
        this.dct = 0;
        this.bfj = 1;
        this.mDatas.clear();
        this.ayQ = false;
    }

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            if (this.dcw != null) {
                this.dcw.fu(auD());
                return;
            }
            return;
        }
        if (this.curPage == this.dcv) {
            this.mDatas.clear();
        }
        this.mDatas.addAll(dataRes.thread_list);
        if (this.dcw != null) {
            this.dcw.c(this.curPage, dataRes.thread_list);
        }
        this.curPage = dataRes.cur_page.intValue();
        this.bfj = dataRes.has_more.intValue();
        this.dct = dataRes.thread_num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String auD() {
        if (k.jq()) {
            return TbadkCoreApplication.m411getInst().getString(t.j.no_data_text);
        }
        return TbadkCoreApplication.m411getInst().getString(t.j.neterror);
    }
}
