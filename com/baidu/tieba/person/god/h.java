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
    private int Or;
    private boolean avz;
    private int curPage;
    private int dAc;
    private int dAd;
    private a dAe;
    private final com.baidu.adp.framework.listener.a dAf;
    private final List<ThreadInfo> mDatas;

    /* loaded from: classes.dex */
    public interface a {
        void d(int i, List<ThreadInfo> list);

        void fz(String str);
    }

    public boolean isLoading() {
        return this.avz;
    }

    public boolean hasMore() {
        return this.Or == 1;
    }

    public void my(int i) {
        reset();
        this.dAd = i;
        this.curPage = this.dAd;
    }

    public void a(a aVar) {
        this.dAe = aVar;
    }

    public h(com.baidu.adp.base.h<?> hVar) {
        super(hVar);
        this.curPage = 0;
        this.Or = 1;
        this.avz = false;
        this.dAd = 0;
        this.dAf = new i(this, CmdConfigHttp.CMD_GOD_THREAD_LIST, 309291);
        this.mDatas = new ArrayList();
        hVar.registerListener(this.dAf);
    }

    @Override // com.baidu.adp.base.e
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.dAf.setTag(bdUniqueId);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private GodThreadListRequestMessage aCz() {
        return new GodThreadListRequestMessage();
    }

    public void bG(long j) {
        GodThreadListRequestMessage aCz = aCz();
        aCz.setUserId(j);
        aCz.setPn(this.curPage + 1);
        aCz.setNum(20);
        sendMessage(aCz);
        this.avz = true;
    }

    public void j(int i, long j) {
        GodThreadListRequestMessage aCz = aCz();
        aCz.setUserId(j);
        this.curPage = i;
        aCz.setPn(this.curPage);
        aCz.setNum(20);
        sendMessage(aCz);
        this.avz = true;
    }

    public void reset() {
        this.curPage = this.dAd;
        this.dAc = 0;
        this.Or = 1;
        this.mDatas.clear();
        this.avz = false;
    }

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            if (this.dAe != null) {
                this.dAe.fz(aCA());
                return;
            }
            return;
        }
        if (this.curPage == this.dAd) {
            this.mDatas.clear();
        }
        this.mDatas.addAll(dataRes.thread_list);
        if (this.dAe != null) {
            this.dAe.d(this.curPage, dataRes.thread_list);
        }
        this.curPage = dataRes.cur_page.intValue();
        this.Or = dataRes.has_more.intValue();
        this.dAc = dataRes.thread_num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aCA() {
        if (k.fH()) {
            return TbadkCoreApplication.m11getInst().getString(t.j.no_data_text);
        }
        return TbadkCoreApplication.m11getInst().getString(t.j.neterror);
    }
}
