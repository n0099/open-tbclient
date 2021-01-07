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
    private bz alW;
    private int bdf;
    private ForumData fGG;
    private int fGY;
    private AntiData ftd;
    public boolean jNW;
    public Error lHw;
    private int mPageSize = 20;
    private int lHu = -1;
    private boolean lHv = false;
    private PostData lHr = null;
    private ArrayList<PostData> lHs = new ArrayList<>();
    private int lHt = 1;

    public Error dnC() {
        return this.lHw;
    }

    public PostData dny() {
        return this.lHr;
    }

    public void g(PostData postData) {
        this.lHr = postData;
    }

    public int dnD() {
        if (this.lHu == -1) {
            this.lHu = this.bdf;
        }
        return this.lHu;
    }

    public int dnE() {
        return this.lHu;
    }

    public void a(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cDZ());
            this.lHu = pVar.bNd();
            a(pVar.bFL());
            setPageSize(pVar.getPageSize());
            setThreadData(pVar.boP());
            setTotalCount(pVar.getTotalCount());
            GJ(pVar.dnH());
            this.lHs.addAll(0, pVar.dnG());
        }
    }

    public void b(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cDZ());
            a(pVar.bFL());
            g(pVar.dny());
            setThreadData(pVar.boP());
            if (pVar.dnG() != null) {
                setCurrentPage(pVar.bNd());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                GJ(pVar.dnH());
            }
            int size = this.lHs.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.lHs.remove(this.lHs.size() - 1);
                }
            }
            this.lHs.addAll(pVar.dnG());
        }
    }

    public void c(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cDZ());
            a(pVar.bFL());
            g(pVar.dny());
            setThreadData(pVar.boP());
            if (pVar.dnG() != null && pVar.dnG().size() > 0) {
                setCurrentPage(pVar.bNd());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                GJ(pVar.dnH());
            }
            int size = this.lHs.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.lHs.remove(this.lHs.size() - 1);
                }
            }
            this.lHs.addAll(pVar.dnG());
            dnF();
        }
    }

    public void d(p pVar, boolean z) {
        a(pVar, z);
    }

    public void a(p pVar) {
        if (pVar != null) {
            b(pVar.cDZ());
            a(pVar.bFL());
            g(pVar.dny());
            setThreadData(pVar.boP());
            if (pVar.dnG() != null && pVar.dnG().size() > 0) {
                setCurrentPage(pVar.bNd());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                GJ(pVar.dnH());
                this.lHu = (this.bdf - (((pVar.dnG().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.lHu < 0) {
                    this.lHu = 0;
                }
            }
            this.lHs.addAll(pVar.dnG());
        }
    }

    public void dnF() {
        if (this.lHu < 0) {
            this.lHu = this.bdf;
        } else if (this.lHu > this.bdf) {
            this.lHu = this.bdf;
        }
    }

    public ArrayList<PostData> dnG() {
        return this.lHs;
    }

    public void bb(ArrayList<PostData> arrayList) {
        this.lHs = arrayList;
    }

    public int dnH() {
        return this.lHt;
    }

    public void GJ(int i) {
        this.lHt = i;
    }

    public int getTotalCount() {
        return this.fGY;
    }

    public void setTotalCount(int i) {
        this.fGY = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bNd() {
        return this.bdf;
    }

    public void setCurrentPage(int i) {
        this.bdf = i;
    }

    public void a(ForumData forumData) {
        this.fGG = forumData;
    }

    public ForumData bFL() {
        return this.fGG;
    }

    public void b(AntiData antiData) {
        this.ftd = antiData;
    }

    public AntiData cDZ() {
        return this.ftd;
    }

    public void setThreadData(bz bzVar) {
        this.alW = bzVar;
    }

    public boolean Zq() {
        return (this.alW == null || this.lHr == null || this.alW.brr() == null || this.alW.brr().getUserId() == null || this.lHr.brr() == null || this.lHr.brr().getUserId() == null || !this.alW.brr().getUserId().equals(this.lHr.brr().getUserId())) ? false : true;
    }

    public boolean bny() {
        return this.lHv;
    }

    public boolean hasMore() {
        return this.bdf < this.lHt;
    }

    public bz boP() {
        return this.alW;
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
            pVar.jNW = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.yd(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            pVar.g(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.yd(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                if (postData2.btl() != null && postData2.btl().baijiahaoData == null && bzVar.getBaijiahaoData() != null) {
                    postData2.btl().baijiahaoData = bzVar.getBaijiahaoData();
                }
                arrayList.add(postData2);
            }
            pVar.bb(arrayList);
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
                pVar.GJ(intValue);
            }
            return pVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
