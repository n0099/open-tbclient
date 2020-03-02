package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes9.dex */
public class l {
    private bj NQ;
    private int akj;
    private AntiData dme;
    private ForumData dyQ;
    public boolean gPU;
    public Error iCR;
    private int mTotalCount;
    private int mPageSize = 20;
    private int iCP = -1;
    private boolean iCQ = false;
    private PostData iCM = null;
    private ArrayList<PostData> iCN = new ArrayList<>();
    private int iCO = 1;

    public Error cle() {
        return this.iCR;
    }

    public PostData clf() {
        return this.iCM;
    }

    public void f(PostData postData) {
        this.iCM = postData;
    }

    public int clg() {
        if (this.iCP == -1) {
            this.iCP = this.akj;
        }
        return this.iCP;
    }

    public int clh() {
        return this.iCP;
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            b(lVar.bCY());
            this.iCP = lVar.aVL();
            a(lVar.aPm());
            setPageSize(lVar.getPageSize());
            setThreadData(lVar.aAg());
            setTotalCount(lVar.getTotalCount());
            yC(lVar.clk());
            this.iCN.addAll(0, lVar.clj());
        }
    }

    public void b(l lVar, boolean z) {
        if (lVar != null) {
            b(lVar.bCY());
            a(lVar.aPm());
            f(lVar.clf());
            setThreadData(lVar.aAg());
            if (lVar.clj() != null) {
                setCurrentPage(lVar.aVL());
                setPageSize(lVar.getPageSize());
                setTotalCount(lVar.getTotalCount());
                yC(lVar.clk());
            }
            int size = this.iCN.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.iCN.remove(this.iCN.size() - 1);
                }
            }
            this.iCN.addAll(lVar.clj());
        }
    }

    public void c(l lVar, boolean z) {
        if (lVar != null) {
            b(lVar.bCY());
            a(lVar.aPm());
            f(lVar.clf());
            setThreadData(lVar.aAg());
            if (lVar.clj() != null && lVar.clj().size() > 0) {
                setCurrentPage(lVar.aVL());
                setPageSize(lVar.getPageSize());
                setTotalCount(lVar.getTotalCount());
                yC(lVar.clk());
            }
            int size = this.iCN.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.iCN.remove(this.iCN.size() - 1);
                }
            }
            this.iCN.addAll(lVar.clj());
            cli();
        }
    }

    public void d(l lVar, boolean z) {
        a(lVar, z);
    }

    public void a(l lVar) {
        if (lVar != null) {
            b(lVar.bCY());
            a(lVar.aPm());
            f(lVar.clf());
            setThreadData(lVar.aAg());
            if (lVar.clj() != null && lVar.clj().size() > 0) {
                setCurrentPage(lVar.aVL());
                setPageSize(lVar.getPageSize());
                setTotalCount(lVar.getTotalCount());
                yC(lVar.clk());
                this.iCP = (this.akj - (((lVar.clj().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.iCP < 0) {
                    this.iCP = 0;
                }
            }
            this.iCN.addAll(lVar.clj());
        }
    }

    public void cli() {
        if (this.iCP < 0) {
            this.iCP = this.akj;
        } else if (this.iCP > this.akj) {
            this.iCP = this.akj;
        }
    }

    public ArrayList<PostData> clj() {
        return this.iCN;
    }

    public void aJ(ArrayList<PostData> arrayList) {
        this.iCN = arrayList;
    }

    public int clk() {
        return this.iCO;
    }

    public void yC(int i) {
        this.iCO = i;
    }

    public int getTotalCount() {
        return this.mTotalCount;
    }

    public void setTotalCount(int i) {
        this.mTotalCount = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int aVL() {
        return this.akj;
    }

    public void setCurrentPage(int i) {
        this.akj = i;
    }

    public void a(ForumData forumData) {
        this.dyQ = forumData;
    }

    public ForumData aPm() {
        return this.dyQ;
    }

    public void b(AntiData antiData) {
        this.dme = antiData;
    }

    public AntiData bCY() {
        return this.dme;
    }

    public void setThreadData(bj bjVar) {
        this.NQ = bjVar;
    }

    public boolean bXu() {
        return (this.NQ == null || this.iCM == null || this.NQ.aCo() == null || this.NQ.aCo().getUserId() == null || this.iCM.aCo() == null || this.iCM.aCo().getUserId() == null || !this.NQ.aCo().getUserId().equals(this.iCM.aCo().getUserId())) ? false : true;
    }

    public boolean ayL() {
        return this.iCQ;
    }

    public boolean hasMore() {
        return this.akj < this.iCO;
    }

    public bj aAg() {
        return this.NQ;
    }

    public static l a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            l lVar = new l();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            lVar.b(antiData);
            bj bjVar = new bj();
            bjVar.a(dataRes.thread);
            lVar.setThreadData(bjVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            lVar.a(forumData);
            lVar.gPU = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.sK(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            lVar.f(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.sK(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            lVar.aJ(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            lVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                lVar.setCurrentPage(intValue3);
                lVar.setPageSize(intValue2);
                lVar.setTotalCount(intValue4);
                lVar.yC(intValue);
            }
            return lVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
