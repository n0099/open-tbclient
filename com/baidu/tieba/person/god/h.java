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
    private int TD;
    private boolean azx;
    private int curPage;
    private int dwW;
    private int dwX;
    private a dwY;
    private final com.baidu.adp.framework.listener.a dwZ;
    private final List<ThreadInfo> mDatas;

    /* loaded from: classes.dex */
    public interface a {
        void d(int i, List<ThreadInfo> list);

        void fC(String str);
    }

    public boolean isLoading() {
        return this.azx;
    }

    public boolean hasMore() {
        return this.TD == 1;
    }

    public void mG(int i) {
        reset();
        this.dwX = i;
        this.curPage = this.dwX;
    }

    public void a(a aVar) {
        this.dwY = aVar;
    }

    public h(com.baidu.adp.base.h<?> hVar) {
        super(hVar);
        this.curPage = 0;
        this.TD = 1;
        this.azx = false;
        this.dwX = 0;
        this.dwZ = new i(this, CmdConfigHttp.CMD_GOD_THREAD_LIST, 309291);
        this.mDatas = new ArrayList();
        hVar.registerListener(this.dwZ);
    }

    @Override // com.baidu.adp.base.e
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.dwZ.setTag(bdUniqueId);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private GodThreadListRequestMessage aCi() {
        return new GodThreadListRequestMessage();
    }

    public void bG(long j) {
        GodThreadListRequestMessage aCi = aCi();
        aCi.setUserId(j);
        aCi.setPn(this.curPage + 1);
        aCi.setNum(20);
        sendMessage(aCi);
        this.azx = true;
    }

    public void j(int i, long j) {
        GodThreadListRequestMessage aCi = aCi();
        aCi.setUserId(j);
        this.curPage = i;
        aCi.setPn(this.curPage);
        aCi.setNum(20);
        sendMessage(aCi);
        this.azx = true;
    }

    public void reset() {
        this.curPage = this.dwX;
        this.dwW = 0;
        this.TD = 1;
        this.mDatas.clear();
        this.azx = false;
    }

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            if (this.dwY != null) {
                this.dwY.fC(aCj());
                return;
            }
            return;
        }
        if (this.curPage == this.dwX) {
            this.mDatas.clear();
        }
        this.mDatas.addAll(dataRes.thread_list);
        if (this.dwY != null) {
            this.dwY.d(this.curPage, dataRes.thread_list);
        }
        this.curPage = dataRes.cur_page.intValue();
        this.TD = dataRes.has_more.intValue();
        this.dwW = dataRes.thread_num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aCj() {
        if (k.jw()) {
            return TbadkCoreApplication.m411getInst().getString(t.j.no_data_text);
        }
        return TbadkCoreApplication.m411getInst().getString(t.j.neterror);
    }
}
