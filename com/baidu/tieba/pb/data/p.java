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
    public Error lHx;
    private int mPageSize = 20;
    private int lHv = -1;
    private boolean lHw = false;
    private PostData lHs = null;
    private ArrayList<PostData> lHt = new ArrayList<>();
    private int lHu = 1;

    public Error dnB() {
        return this.lHx;
    }

    public PostData dnx() {
        return this.lHs;
    }

    public void g(PostData postData) {
        this.lHs = postData;
    }

    public int dnC() {
        if (this.lHv == -1) {
            this.lHv = this.bdf;
        }
        return this.lHv;
    }

    public int dnD() {
        return this.lHv;
    }

    public void a(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cDY());
            this.lHv = pVar.bNc();
            a(pVar.bFK());
            setPageSize(pVar.getPageSize());
            setThreadData(pVar.boO());
            setTotalCount(pVar.getTotalCount());
            GJ(pVar.dnG());
            this.lHt.addAll(0, pVar.dnF());
        }
    }

    public void b(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cDY());
            a(pVar.bFK());
            g(pVar.dnx());
            setThreadData(pVar.boO());
            if (pVar.dnF() != null) {
                setCurrentPage(pVar.bNc());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                GJ(pVar.dnG());
            }
            int size = this.lHt.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.lHt.remove(this.lHt.size() - 1);
                }
            }
            this.lHt.addAll(pVar.dnF());
        }
    }

    public void c(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cDY());
            a(pVar.bFK());
            g(pVar.dnx());
            setThreadData(pVar.boO());
            if (pVar.dnF() != null && pVar.dnF().size() > 0) {
                setCurrentPage(pVar.bNc());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                GJ(pVar.dnG());
            }
            int size = this.lHt.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.lHt.remove(this.lHt.size() - 1);
                }
            }
            this.lHt.addAll(pVar.dnF());
            dnE();
        }
    }

    public void d(p pVar, boolean z) {
        a(pVar, z);
    }

    public void a(p pVar) {
        if (pVar != null) {
            b(pVar.cDY());
            a(pVar.bFK());
            g(pVar.dnx());
            setThreadData(pVar.boO());
            if (pVar.dnF() != null && pVar.dnF().size() > 0) {
                setCurrentPage(pVar.bNc());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                GJ(pVar.dnG());
                this.lHv = (this.bdf - (((pVar.dnF().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.lHv < 0) {
                    this.lHv = 0;
                }
            }
            this.lHt.addAll(pVar.dnF());
        }
    }

    public void dnE() {
        if (this.lHv < 0) {
            this.lHv = this.bdf;
        } else if (this.lHv > this.bdf) {
            this.lHv = this.bdf;
        }
    }

    public ArrayList<PostData> dnF() {
        return this.lHt;
    }

    public void bb(ArrayList<PostData> arrayList) {
        this.lHt = arrayList;
    }

    public int dnG() {
        return this.lHu;
    }

    public void GJ(int i) {
        this.lHu = i;
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

    public int bNc() {
        return this.bdf;
    }

    public void setCurrentPage(int i) {
        this.bdf = i;
    }

    public void a(ForumData forumData) {
        this.fGG = forumData;
    }

    public ForumData bFK() {
        return this.fGG;
    }

    public void b(AntiData antiData) {
        this.ftd = antiData;
    }

    public AntiData cDY() {
        return this.ftd;
    }

    public void setThreadData(bz bzVar) {
        this.alW = bzVar;
    }

    public boolean Zp() {
        return (this.alW == null || this.lHs == null || this.alW.brq() == null || this.alW.brq().getUserId() == null || this.lHs.brq() == null || this.lHs.brq().getUserId() == null || !this.alW.brq().getUserId().equals(this.lHs.brq().getUserId())) ? false : true;
    }

    public boolean bnx() {
        return this.lHw;
    }

    public boolean hasMore() {
        return this.bdf < this.lHu;
    }

    public bz boO() {
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
                if (postData2.btk() != null && postData2.btk().baijiahaoData == null && bzVar.getBaijiahaoData() != null) {
                    postData2.btk().baijiahaoData = bzVar.getBaijiahaoData();
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
