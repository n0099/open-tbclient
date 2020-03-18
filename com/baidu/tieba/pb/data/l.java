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
    private bj NR;
    private int aku;
    private AntiData dmE;
    private ForumData dzq;
    public boolean gRn;
    public Error iEE;
    private int mTotalCount;
    private int mPageSize = 20;
    private int iEC = -1;
    private boolean iED = false;
    private PostData iEz = null;
    private ArrayList<PostData> iEA = new ArrayList<>();
    private int iEB = 1;

    public Error clA() {
        return this.iEE;
    }

    public PostData clB() {
        return this.iEz;
    }

    public void f(PostData postData) {
        this.iEz = postData;
    }

    public int clC() {
        if (this.iEC == -1) {
            this.iEC = this.aku;
        }
        return this.iEC;
    }

    public int clD() {
        return this.iEC;
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            b(lVar.bDg());
            this.iEC = lVar.aVQ();
            a(lVar.aPr());
            setPageSize(lVar.getPageSize());
            setThreadData(lVar.aAj());
            setTotalCount(lVar.getTotalCount());
            yK(lVar.clG());
            this.iEA.addAll(0, lVar.clF());
        }
    }

    public void b(l lVar, boolean z) {
        if (lVar != null) {
            b(lVar.bDg());
            a(lVar.aPr());
            f(lVar.clB());
            setThreadData(lVar.aAj());
            if (lVar.clF() != null) {
                setCurrentPage(lVar.aVQ());
                setPageSize(lVar.getPageSize());
                setTotalCount(lVar.getTotalCount());
                yK(lVar.clG());
            }
            int size = this.iEA.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.iEA.remove(this.iEA.size() - 1);
                }
            }
            this.iEA.addAll(lVar.clF());
        }
    }

    public void c(l lVar, boolean z) {
        if (lVar != null) {
            b(lVar.bDg());
            a(lVar.aPr());
            f(lVar.clB());
            setThreadData(lVar.aAj());
            if (lVar.clF() != null && lVar.clF().size() > 0) {
                setCurrentPage(lVar.aVQ());
                setPageSize(lVar.getPageSize());
                setTotalCount(lVar.getTotalCount());
                yK(lVar.clG());
            }
            int size = this.iEA.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.iEA.remove(this.iEA.size() - 1);
                }
            }
            this.iEA.addAll(lVar.clF());
            clE();
        }
    }

    public void d(l lVar, boolean z) {
        a(lVar, z);
    }

    public void a(l lVar) {
        if (lVar != null) {
            b(lVar.bDg());
            a(lVar.aPr());
            f(lVar.clB());
            setThreadData(lVar.aAj());
            if (lVar.clF() != null && lVar.clF().size() > 0) {
                setCurrentPage(lVar.aVQ());
                setPageSize(lVar.getPageSize());
                setTotalCount(lVar.getTotalCount());
                yK(lVar.clG());
                this.iEC = (this.aku - (((lVar.clF().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.iEC < 0) {
                    this.iEC = 0;
                }
            }
            this.iEA.addAll(lVar.clF());
        }
    }

    public void clE() {
        if (this.iEC < 0) {
            this.iEC = this.aku;
        } else if (this.iEC > this.aku) {
            this.iEC = this.aku;
        }
    }

    public ArrayList<PostData> clF() {
        return this.iEA;
    }

    public void aJ(ArrayList<PostData> arrayList) {
        this.iEA = arrayList;
    }

    public int clG() {
        return this.iEB;
    }

    public void yK(int i) {
        this.iEB = i;
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

    public int aVQ() {
        return this.aku;
    }

    public void setCurrentPage(int i) {
        this.aku = i;
    }

    public void a(ForumData forumData) {
        this.dzq = forumData;
    }

    public ForumData aPr() {
        return this.dzq;
    }

    public void b(AntiData antiData) {
        this.dmE = antiData;
    }

    public AntiData bDg() {
        return this.dmE;
    }

    public void setThreadData(bj bjVar) {
        this.NR = bjVar;
    }

    public boolean bXN() {
        return (this.NR == null || this.iEz == null || this.NR.aCr() == null || this.NR.aCr().getUserId() == null || this.iEz.aCr() == null || this.iEz.aCr().getUserId() == null || !this.NR.aCr().getUserId().equals(this.iEz.aCr().getUserId())) ? false : true;
    }

    public boolean ayO() {
        return this.iED;
    }

    public boolean hasMore() {
        return this.aku < this.iEB;
    }

    public bj aAj() {
        return this.NR;
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
            lVar.gRn = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.sQ(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            lVar.f(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.sQ(forumData.isBrandForum);
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
                lVar.yK(intValue);
            }
            return lVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
