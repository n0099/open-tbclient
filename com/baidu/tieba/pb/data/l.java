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
    private AntiData dmd;
    private ForumData dyP;
    public boolean gPS;
    public Error iCP;
    private int mTotalCount;
    private int mPageSize = 20;
    private int iCN = -1;
    private boolean iCO = false;
    private PostData iCK = null;
    private ArrayList<PostData> iCL = new ArrayList<>();
    private int iCM = 1;

    public Error clc() {
        return this.iCP;
    }

    public PostData cld() {
        return this.iCK;
    }

    public void f(PostData postData) {
        this.iCK = postData;
    }

    public int cle() {
        if (this.iCN == -1) {
            this.iCN = this.akj;
        }
        return this.iCN;
    }

    public int clf() {
        return this.iCN;
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            b(lVar.bCW());
            this.iCN = lVar.aVJ();
            a(lVar.aPk());
            setPageSize(lVar.getPageSize());
            setThreadData(lVar.aAe());
            setTotalCount(lVar.getTotalCount());
            yC(lVar.cli());
            this.iCL.addAll(0, lVar.clh());
        }
    }

    public void b(l lVar, boolean z) {
        if (lVar != null) {
            b(lVar.bCW());
            a(lVar.aPk());
            f(lVar.cld());
            setThreadData(lVar.aAe());
            if (lVar.clh() != null) {
                setCurrentPage(lVar.aVJ());
                setPageSize(lVar.getPageSize());
                setTotalCount(lVar.getTotalCount());
                yC(lVar.cli());
            }
            int size = this.iCL.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.iCL.remove(this.iCL.size() - 1);
                }
            }
            this.iCL.addAll(lVar.clh());
        }
    }

    public void c(l lVar, boolean z) {
        if (lVar != null) {
            b(lVar.bCW());
            a(lVar.aPk());
            f(lVar.cld());
            setThreadData(lVar.aAe());
            if (lVar.clh() != null && lVar.clh().size() > 0) {
                setCurrentPage(lVar.aVJ());
                setPageSize(lVar.getPageSize());
                setTotalCount(lVar.getTotalCount());
                yC(lVar.cli());
            }
            int size = this.iCL.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.iCL.remove(this.iCL.size() - 1);
                }
            }
            this.iCL.addAll(lVar.clh());
            clg();
        }
    }

    public void d(l lVar, boolean z) {
        a(lVar, z);
    }

    public void a(l lVar) {
        if (lVar != null) {
            b(lVar.bCW());
            a(lVar.aPk());
            f(lVar.cld());
            setThreadData(lVar.aAe());
            if (lVar.clh() != null && lVar.clh().size() > 0) {
                setCurrentPage(lVar.aVJ());
                setPageSize(lVar.getPageSize());
                setTotalCount(lVar.getTotalCount());
                yC(lVar.cli());
                this.iCN = (this.akj - (((lVar.clh().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.iCN < 0) {
                    this.iCN = 0;
                }
            }
            this.iCL.addAll(lVar.clh());
        }
    }

    public void clg() {
        if (this.iCN < 0) {
            this.iCN = this.akj;
        } else if (this.iCN > this.akj) {
            this.iCN = this.akj;
        }
    }

    public ArrayList<PostData> clh() {
        return this.iCL;
    }

    public void aJ(ArrayList<PostData> arrayList) {
        this.iCL = arrayList;
    }

    public int cli() {
        return this.iCM;
    }

    public void yC(int i) {
        this.iCM = i;
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

    public int aVJ() {
        return this.akj;
    }

    public void setCurrentPage(int i) {
        this.akj = i;
    }

    public void a(ForumData forumData) {
        this.dyP = forumData;
    }

    public ForumData aPk() {
        return this.dyP;
    }

    public void b(AntiData antiData) {
        this.dmd = antiData;
    }

    public AntiData bCW() {
        return this.dmd;
    }

    public void setThreadData(bj bjVar) {
        this.NQ = bjVar;
    }

    public boolean bXs() {
        return (this.NQ == null || this.iCK == null || this.NQ.aCm() == null || this.NQ.aCm().getUserId() == null || this.iCK.aCm() == null || this.iCK.aCm().getUserId() == null || !this.NQ.aCm().getUserId().equals(this.iCK.aCm().getUserId())) ? false : true;
    }

    public boolean ayJ() {
        return this.iCO;
    }

    public boolean hasMore() {
        return this.akj < this.iCM;
    }

    public bj aAe() {
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
            lVar.gPS = forumData.isBrandForum;
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
