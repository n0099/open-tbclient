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
    public boolean jQB;
    public Error lLV;
    private int mPageSize = 20;
    private int lLT = -1;
    private boolean lLU = false;
    private PostData lLQ = null;
    private ArrayList<PostData> lLR = new ArrayList<>();
    private int lLS = 1;

    public Error dmd() {
        return this.lLV;
    }

    public PostData dlY() {
        return this.lLQ;
    }

    public void g(PostData postData) {
        this.lLQ = postData;
    }

    public int dme() {
        if (this.lLT == -1) {
            this.lLT = this.bby;
        }
        return this.lLT;
    }

    public int dmf() {
        return this.lLT;
    }

    public void a(q qVar, boolean z) {
        if (qVar != null) {
            b(qVar.cBz());
            this.lLT = qVar.bJK();
            a(qVar.bCk());
            setPageSize(qVar.getPageSize());
            setThreadData(qVar.bln());
            setTotalCount(qVar.getTotalCount());
            Fw(qVar.dmi());
            this.lLR.addAll(0, qVar.dmh());
        }
    }

    public void b(q qVar, boolean z) {
        if (qVar != null) {
            b(qVar.cBz());
            a(qVar.bCk());
            g(qVar.dlY());
            setThreadData(qVar.bln());
            if (qVar.dmh() != null) {
                setCurrentPage(qVar.bJK());
                setPageSize(qVar.getPageSize());
                setTotalCount(qVar.getTotalCount());
                Fw(qVar.dmi());
            }
            int size = this.lLR.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.lLR.remove(this.lLR.size() - 1);
                }
            }
            this.lLR.addAll(qVar.dmh());
        }
    }

    public void c(q qVar, boolean z) {
        if (qVar != null) {
            b(qVar.cBz());
            a(qVar.bCk());
            g(qVar.dlY());
            setThreadData(qVar.bln());
            if (qVar.dmh() != null && qVar.dmh().size() > 0) {
                setCurrentPage(qVar.bJK());
                setPageSize(qVar.getPageSize());
                setTotalCount(qVar.getTotalCount());
                Fw(qVar.dmi());
            }
            int size = this.lLR.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.lLR.remove(this.lLR.size() - 1);
                }
            }
            this.lLR.addAll(qVar.dmh());
            dmg();
        }
    }

    public void d(q qVar, boolean z) {
        a(qVar, z);
    }

    public void a(q qVar) {
        if (qVar != null) {
            b(qVar.cBz());
            a(qVar.bCk());
            g(qVar.dlY());
            setThreadData(qVar.bln());
            if (qVar.dmh() != null && qVar.dmh().size() > 0) {
                setCurrentPage(qVar.bJK());
                setPageSize(qVar.getPageSize());
                setTotalCount(qVar.getTotalCount());
                Fw(qVar.dmi());
                this.lLT = (this.bby - (((qVar.dmh().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.lLT < 0) {
                    this.lLT = 0;
                }
            }
            this.lLR.addAll(qVar.dmh());
        }
    }

    public void dmg() {
        if (this.lLT < 0) {
            this.lLT = this.bby;
        } else if (this.lLT > this.bby) {
            this.lLT = this.bby;
        }
    }

    public ArrayList<PostData> dmh() {
        return this.lLR;
    }

    public void aV(ArrayList<PostData> arrayList) {
        this.lLR = arrayList;
    }

    public int dmi() {
        return this.lLS;
    }

    public void Fw(int i) {
        this.lLS = i;
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

    public int bJK() {
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

    public AntiData cBz() {
        return this.fqK;
    }

    public void setThreadData(cb cbVar) {
        this.akU = cbVar;
    }

    public boolean Xg() {
        return (this.akU == null || this.lLQ == null || this.akU.bnQ() == null || this.akU.bnQ().getUserId() == null || this.lLQ.bnQ() == null || this.lLQ.bnQ().getUserId() == null || !this.akU.bnQ().getUserId().equals(this.lLQ.bnQ().getUserId())) ? false : true;
    }

    public boolean bjZ() {
        return this.lLU;
    }

    public boolean hasMore() {
        return this.bby < this.lLS;
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
            qVar.jQB = forumData.isBrandForum;
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
