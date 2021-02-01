package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes2.dex */
public class q {
    private cb akU;
    private int bby;
    private int fEE;
    private ForumData fEm;
    private AntiData fqK;
    public boolean jQn;
    public Error lLG;
    private int mPageSize = 20;
    private int lLE = -1;
    private boolean lLF = false;
    private PostData lLB = null;
    private ArrayList<PostData> lLC = new ArrayList<>();
    private int lLD = 1;

    public Error dlW() {
        return this.lLG;
    }

    public PostData dlR() {
        return this.lLB;
    }

    public void g(PostData postData) {
        this.lLB = postData;
    }

    public int dlX() {
        if (this.lLE == -1) {
            this.lLE = this.bby;
        }
        return this.lLE;
    }

    public int dlY() {
        return this.lLE;
    }

    public void a(q qVar, boolean z) {
        if (qVar != null) {
            b(qVar.cBs());
            this.lLE = qVar.bJF();
            a(qVar.bCk());
            setPageSize(qVar.getPageSize());
            setThreadData(qVar.bln());
            setTotalCount(qVar.getTotalCount());
            Fw(qVar.dmb());
            this.lLC.addAll(0, qVar.dma());
        }
    }

    public void b(q qVar, boolean z) {
        if (qVar != null) {
            b(qVar.cBs());
            a(qVar.bCk());
            g(qVar.dlR());
            setThreadData(qVar.bln());
            if (qVar.dma() != null) {
                setCurrentPage(qVar.bJF());
                setPageSize(qVar.getPageSize());
                setTotalCount(qVar.getTotalCount());
                Fw(qVar.dmb());
            }
            int size = this.lLC.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.lLC.remove(this.lLC.size() - 1);
                }
            }
            this.lLC.addAll(qVar.dma());
        }
    }

    public void c(q qVar, boolean z) {
        if (qVar != null) {
            b(qVar.cBs());
            a(qVar.bCk());
            g(qVar.dlR());
            setThreadData(qVar.bln());
            if (qVar.dma() != null && qVar.dma().size() > 0) {
                setCurrentPage(qVar.bJF());
                setPageSize(qVar.getPageSize());
                setTotalCount(qVar.getTotalCount());
                Fw(qVar.dmb());
            }
            int size = this.lLC.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.lLC.remove(this.lLC.size() - 1);
                }
            }
            this.lLC.addAll(qVar.dma());
            dlZ();
        }
    }

    public void d(q qVar, boolean z) {
        a(qVar, z);
    }

    public void a(q qVar) {
        if (qVar != null) {
            b(qVar.cBs());
            a(qVar.bCk());
            g(qVar.dlR());
            setThreadData(qVar.bln());
            if (qVar.dma() != null && qVar.dma().size() > 0) {
                setCurrentPage(qVar.bJF());
                setPageSize(qVar.getPageSize());
                setTotalCount(qVar.getTotalCount());
                Fw(qVar.dmb());
                this.lLE = (this.bby - (((qVar.dma().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.lLE < 0) {
                    this.lLE = 0;
                }
            }
            this.lLC.addAll(qVar.dma());
        }
    }

    public void dlZ() {
        if (this.lLE < 0) {
            this.lLE = this.bby;
        } else if (this.lLE > this.bby) {
            this.lLE = this.bby;
        }
    }

    public ArrayList<PostData> dma() {
        return this.lLC;
    }

    public void aV(ArrayList<PostData> arrayList) {
        this.lLC = arrayList;
    }

    public int dmb() {
        return this.lLD;
    }

    public void Fw(int i) {
        this.lLD = i;
    }

    public int getTotalCount() {
        return this.fEE;
    }

    public void setTotalCount(int i) {
        this.fEE = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bJF() {
        return this.bby;
    }

    public void setCurrentPage(int i) {
        this.bby = i;
    }

    public void a(ForumData forumData) {
        this.fEm = forumData;
    }

    public ForumData bCk() {
        return this.fEm;
    }

    public void b(AntiData antiData) {
        this.fqK = antiData;
    }

    public AntiData cBs() {
        return this.fqK;
    }

    public void setThreadData(cb cbVar) {
        this.akU = cbVar;
    }

    public boolean Xg() {
        return (this.akU == null || this.lLB == null || this.akU.bnQ() == null || this.akU.bnQ().getUserId() == null || this.lLB.bnQ() == null || this.lLB.bnQ().getUserId() == null || !this.akU.bnQ().getUserId().equals(this.lLB.bnQ().getUserId())) ? false : true;
    }

    public boolean bjZ() {
        return this.lLF;
    }

    public boolean hasMore() {
        return this.bby < this.lLD;
    }

    public cb bln() {
        return this.akU;
    }

    public static q a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            q qVar = new q();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            qVar.b(antiData);
            cb cbVar = new cb();
            cbVar.a(dataRes.thread);
            qVar.setThreadData(cbVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            qVar.a(forumData);
            qVar.jQn = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.ys(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            qVar.g(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.ys(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                if (postData2.bpJ() != null && postData2.bpJ().baijiahaoData == null && cbVar.getBaijiahaoData() != null) {
                    postData2.bpJ().baijiahaoData = cbVar.getBaijiahaoData();
                }
                arrayList.add(postData2);
            }
            qVar.aV(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            qVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                qVar.setCurrentPage(intValue3);
                qVar.setPageSize(intValue2);
                qVar.setTotalCount(intValue4);
                qVar.Fw(intValue);
            }
            return qVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
