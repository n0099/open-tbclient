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
    private int OC;
    private boolean axe;
    private int bQu;
    private int curPage;
    private int esN;
    private a esO;
    private final com.baidu.adp.framework.listener.a esP;
    private final List<ThreadInfo> mDatas;

    /* loaded from: classes.dex */
    public interface a {
        void c(int i, List<ThreadInfo> list);

        void fD(String str);
    }

    public boolean DJ() {
        return this.axe;
    }

    public boolean hasMore() {
        return this.OC == 1;
    }

    public void ok(int i) {
        reset();
        this.bQu = i;
        this.curPage = this.bQu;
    }

    public void a(a aVar) {
        this.esO = aVar;
    }

    public i(com.baidu.adp.base.h<?> hVar) {
        super(hVar);
        this.curPage = 0;
        this.OC = 1;
        this.axe = false;
        this.bQu = 0;
        this.esP = new j(this, CmdConfigHttp.CMD_GOD_THREAD_LIST, 309291);
        this.mDatas = new ArrayList();
        hVar.registerListener(this.esP);
    }

    @Override // com.baidu.adp.base.e
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.esP.setTag(bdUniqueId);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private GodThreadListRequestMessage aOa() {
        return new GodThreadListRequestMessage();
    }

    public void cn(long j) {
        GodThreadListRequestMessage aOa = aOa();
        aOa.setUserId(j);
        aOa.setPn(this.curPage + 1);
        aOa.setNum(20);
        sendMessage(aOa);
        this.axe = true;
    }

    public void k(int i, long j) {
        GodThreadListRequestMessage aOa = aOa();
        aOa.setUserId(j);
        this.curPage = i;
        aOa.setPn(this.curPage);
        aOa.setNum(20);
        sendMessage(aOa);
        this.axe = true;
    }

    public void reset() {
        this.curPage = this.bQu;
        this.esN = 0;
        this.OC = 1;
        this.mDatas.clear();
        this.axe = false;
    }

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            if (this.esO != null) {
                this.esO.fD(ZD());
                return;
            }
            return;
        }
        if (this.curPage == this.bQu) {
            this.mDatas.clear();
        }
        this.mDatas.addAll(dataRes.thread_list);
        if (this.esO != null) {
            this.esO.c(this.curPage, dataRes.thread_list);
        }
        this.curPage = dataRes.cur_page.intValue();
        this.OC = dataRes.has_more.intValue();
        this.esN = dataRes.thread_num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ZD() {
        if (k.fH()) {
            return TbadkCoreApplication.m10getInst().getString(u.j.no_data_text);
        }
        return TbadkCoreApplication.m10getInst().getString(u.j.neterror);
    }
}
