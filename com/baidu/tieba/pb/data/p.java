package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes2.dex */
public class p {
    private int aYr;
    private bz ale;
    private ForumData fBZ;
    private int fCr;
    private AntiData fos;
    public boolean jJq;
    public Error lCR;
    private int mPageSize = 20;
    private int lCP = -1;
    private boolean lCQ = false;
    private PostData lCM = null;
    private ArrayList<PostData> lCN = new ArrayList<>();
    private int lCO = 1;

    public Error djJ() {
        return this.lCR;
    }

    public PostData djF() {
        return this.lCM;
    }

    public void g(PostData postData) {
        this.lCM = postData;
    }

    public int djK() {
        if (this.lCP == -1) {
            this.lCP = this.aYr;
        }
        return this.lCP;
    }

    public int djL() {
        return this.lCP;
    }

    public void a(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cAh());
            this.lCP = pVar.bJl();
            a(pVar.bBS());
            setPageSize(pVar.getPageSize());
            setThreadData(pVar.bkV());
            setTotalCount(pVar.getTotalCount());
            Fd(pVar.djO());
            this.lCN.addAll(0, pVar.djN());
        }
    }

    public void b(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cAh());
            a(pVar.bBS());
            g(pVar.djF());
            setThreadData(pVar.bkV());
            if (pVar.djN() != null) {
                setCurrentPage(pVar.bJl());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                Fd(pVar.djO());
            }
            int size = this.lCN.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.lCN.remove(this.lCN.size() - 1);
                }
            }
            this.lCN.addAll(pVar.djN());
        }
    }

    public void c(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cAh());
            a(pVar.bBS());
            g(pVar.djF());
            setThreadData(pVar.bkV());
            if (pVar.djN() != null && pVar.djN().size() > 0) {
                setCurrentPage(pVar.bJl());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                Fd(pVar.djO());
            }
            int size = this.lCN.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.lCN.remove(this.lCN.size() - 1);
                }
            }
            this.lCN.addAll(pVar.djN());
            djM();
        }
    }

    public void d(p pVar, boolean z) {
        a(pVar, z);
    }

    public void a(p pVar) {
        if (pVar != null) {
            b(pVar.cAh());
            a(pVar.bBS());
            g(pVar.djF());
            setThreadData(pVar.bkV());
            if (pVar.djN() != null && pVar.djN().size() > 0) {
                setCurrentPage(pVar.bJl());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                Fd(pVar.djO());
                this.lCP = (this.aYr - (((pVar.djN().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.lCP < 0) {
                    this.lCP = 0;
                }
            }
            this.lCN.addAll(pVar.djN());
        }
    }

    public void djM() {
        if (this.lCP < 0) {
            this.lCP = this.aYr;
        } else if (this.lCP > this.aYr) {
            this.lCP = this.aYr;
        }
    }

    public ArrayList<PostData> djN() {
        return this.lCN;
    }

    public void aW(ArrayList<PostData> arrayList) {
        this.lCN = arrayList;
    }

    public int djO() {
        return this.lCO;
    }

    public void Fd(int i) {
        this.lCO = i;
    }

    public int getTotalCount() {
        return this.fCr;
    }

    public void setTotalCount(int i) {
        this.fCr = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bJl() {
        return this.aYr;
    }

    public void setCurrentPage(int i) {
        this.aYr = i;
    }

    public void a(ForumData forumData) {
        this.fBZ = forumData;
    }

    public ForumData bBS() {
        return this.fBZ;
    }

    public void b(AntiData antiData) {
        this.fos = antiData;
    }

    public AntiData cAh() {
        return this.fos;
    }

    public void setThreadData(bz bzVar) {
        this.ale = bzVar;
    }

    public boolean Vx() {
        return (this.ale == null || this.lCM == null || this.ale.bnx() == null || this.ale.bnx().getUserId() == null || this.lCM.bnx() == null || this.lCM.bnx().getUserId() == null || !this.ale.bnx().getUserId().equals(this.lCM.bnx().getUserId())) ? false : true;
    }

    public boolean bjE() {
        return this.lCQ;
    }

    public boolean hasMore() {
        return this.aYr < this.lCO;
    }

    public bz bkV() {
        return this.ale;
    }

    public static p a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            p pVar = new p();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            pVar.b(antiData);
            bz bzVar = new bz();
            bzVar.a(dataRes.thread);
            pVar.setThreadData(bzVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            pVar.a(forumData);
            pVar.jJq = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.xZ(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            pVar.g(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.xZ(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                if (postData2.bpr() != null && postData2.bpr().baijiahaoData == null && bzVar.getBaijiahaoData() != null) {
                    postData2.bpr().baijiahaoData = bzVar.getBaijiahaoData();
                }
                arrayList.add(postData2);
            }
            pVar.aW(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            pVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                pVar.setCurrentPage(intValue3);
                pVar.setPageSize(intValue2);
                pVar.setTotalCount(intValue4);
                pVar.Fd(intValue);
            }
            return pVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
