package com.baidu.tieba.person.god;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodThreadList.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.e {
    private int Oq;
    private boolean awp;
    private int bOI;
    private int curPage;
    private int eiJ;
    private a eiK;
    private final com.baidu.adp.framework.listener.a eiL;
    private final List<ThreadInfo> mDatas;

    /* loaded from: classes.dex */
    public interface a {
        void c(int i, List<ThreadInfo> list);

        void fF(String str);
    }

    public boolean DK() {
        return this.awp;
    }

    public boolean hasMore() {
        return this.Oq == 1;
    }

    public void nZ(int i) {
        reset();
        this.bOI = i;
        this.curPage = this.bOI;
    }

    public void a(a aVar) {
        this.eiK = aVar;
    }

    public i(com.baidu.adp.base.h<?> hVar) {
        super(hVar);
        this.curPage = 0;
        this.Oq = 1;
        this.awp = false;
        this.bOI = 0;
        this.eiL = new j(this, CmdConfigHttp.CMD_GOD_THREAD_LIST, 309291);
        this.mDatas = new ArrayList();
        hVar.registerListener(this.eiL);
    }

    @Override // com.baidu.adp.base.e
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.eiL.setTag(bdUniqueId);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private GodThreadListRequestMessage aLx() {
        return new GodThreadListRequestMessage();
    }

    public void co(long j) {
        GodThreadListRequestMessage aLx = aLx();
        aLx.setUserId(j);
        aLx.setPn(this.curPage + 1);
        aLx.setNum(20);
        sendMessage(aLx);
        this.awp = true;
    }

    public void j(int i, long j) {
        GodThreadListRequestMessage aLx = aLx();
        aLx.setUserId(j);
        this.curPage = i;
        aLx.setPn(this.curPage);
        aLx.setNum(20);
        sendMessage(aLx);
        this.awp = true;
    }

    public void reset() {
        this.curPage = this.bOI;
        this.eiJ = 0;
        this.Oq = 1;
        this.mDatas.clear();
        this.awp = false;
    }

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            if (this.eiK != null) {
                this.eiK.fF(Zh());
                return;
            }
            return;
        }
        if (this.curPage == this.bOI) {
            this.mDatas.clear();
        }
        this.mDatas.addAll(dataRes.thread_list);
        if (this.eiK != null) {
            this.eiK.c(this.curPage, dataRes.thread_list);
        }
        this.curPage = dataRes.cur_page.intValue();
        this.Oq = dataRes.has_more.intValue();
        this.eiJ = dataRes.thread_num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Zh() {
        if (k.fI()) {
            return TbadkCoreApplication.m9getInst().getString(u.j.no_data_text);
        }
        return TbadkCoreApplication.m9getInst().getString(u.j.neterror);
    }
}
