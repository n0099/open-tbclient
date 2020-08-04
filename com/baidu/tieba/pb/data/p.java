package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes16.dex */
public class p {
    private int aMx;
    private bv aii;
    private int eCN;
    private ForumData eCv;
    private AntiData epR;
    public boolean ikq;
    public Error kiV;
    private int mPageSize = 20;
    private int kiT = -1;
    private boolean kiU = false;
    private PostData kiQ = null;
    private ArrayList<PostData> kiR = new ArrayList<>();
    private int kiS = 1;

    public Error cLs() {
        return this.kiV;
    }

    public PostData cLt() {
        return this.kiQ;
    }

    public void g(PostData postData) {
        this.kiQ = postData;
    }

    public int cLu() {
        if (this.kiT == -1) {
            this.kiT = this.aMx;
        }
        return this.kiT;
    }

    public int cLv() {
        return this.kiT;
    }

    public void a(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cax());
            this.kiT = pVar.bqF();
            a(pVar.bjG());
            setPageSize(pVar.getPageSize());
            setThreadData(pVar.aTN());
            setTotalCount(pVar.getTotalCount());
            By(pVar.cLy());
            this.kiR.addAll(0, pVar.cLx());
        }
    }

    public void b(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cax());
            a(pVar.bjG());
            g(pVar.cLt());
            setThreadData(pVar.aTN());
            if (pVar.cLx() != null) {
                setCurrentPage(pVar.bqF());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                By(pVar.cLy());
            }
            int size = this.kiR.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.kiR.remove(this.kiR.size() - 1);
                }
            }
            this.kiR.addAll(pVar.cLx());
        }
    }

    public void c(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cax());
            a(pVar.bjG());
            g(pVar.cLt());
            setThreadData(pVar.aTN());
            if (pVar.cLx() != null && pVar.cLx().size() > 0) {
                setCurrentPage(pVar.bqF());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                By(pVar.cLy());
            }
            int size = this.kiR.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.kiR.remove(this.kiR.size() - 1);
                }
            }
            this.kiR.addAll(pVar.cLx());
            cLw();
        }
    }

    public void d(p pVar, boolean z) {
        a(pVar, z);
    }

    public void a(p pVar) {
        if (pVar != null) {
            b(pVar.cax());
            a(pVar.bjG());
            g(pVar.cLt());
            setThreadData(pVar.aTN());
            if (pVar.cLx() != null && pVar.cLx().size() > 0) {
                setCurrentPage(pVar.bqF());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                By(pVar.cLy());
                this.kiT = (this.aMx - (((pVar.cLx().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.kiT < 0) {
                    this.kiT = 0;
                }
            }
            this.kiR.addAll(pVar.cLx());
        }
    }

    public void cLw() {
        if (this.kiT < 0) {
            this.kiT = this.aMx;
        } else if (this.kiT > this.aMx) {
            this.kiT = this.aMx;
        }
    }

    public ArrayList<PostData> cLx() {
        return this.kiR;
    }

    public void aN(ArrayList<PostData> arrayList) {
        this.kiR = arrayList;
    }

    public int cLy() {
        return this.kiS;
    }

    public void By(int i) {
        this.kiS = i;
    }

    public int getTotalCount() {
        return this.eCN;
    }

    public void setTotalCount(int i) {
        this.eCN = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bqF() {
        return this.aMx;
    }

    public void setCurrentPage(int i) {
        this.aMx = i;
    }

    public void a(ForumData forumData) {
        this.eCv = forumData;
    }

    public ForumData bjG() {
        return this.eCv;
    }

    public void b(AntiData antiData) {
        this.epR = antiData;
    }

    public AntiData cax() {
        return this.epR;
    }

    public void setThreadData(bv bvVar) {
        this.aii = bvVar;
    }

    public boolean cwL() {
        return (this.aii == null || this.kiQ == null || this.aii.aWl() == null || this.aii.aWl().getUserId() == null || this.kiQ.aWl() == null || this.kiQ.aWl().getUserId() == null || !this.aii.aWl().getUserId().equals(this.kiQ.aWl().getUserId())) ? false : true;
    }

    public boolean aSj() {
        return this.kiU;
    }

    public boolean hasMore() {
        return this.aMx < this.kiS;
    }

    public bv aTN() {
        return this.aii;
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
            bv bvVar = new bv();
            bvVar.a(dataRes.thread);
            pVar.setThreadData(bvVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            pVar.a(forumData);
            pVar.ikq = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.vj(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            pVar.g(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.vj(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                if (postData2.aYc() != null && postData2.aYc().baijiahaoData == null && bvVar.getBaijiahaoData() != null) {
                    postData2.aYc().baijiahaoData = bvVar.getBaijiahaoData();
                }
                arrayList.add(postData2);
            }
            pVar.aN(arrayList);
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
                pVar.By(intValue);
            }
            return pVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
