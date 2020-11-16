package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes21.dex */
public class p {
    private int aYc;
    private bx akt;
    private AntiData fbU;
    private int fpN;
    private ForumData fpv;
    public boolean jnS;
    public Error loT;
    private int mPageSize = 20;
    private int loR = -1;
    private boolean loS = false;
    private PostData loO = null;
    private ArrayList<PostData> loP = new ArrayList<>();
    private int loQ = 1;

    public Error diB() {
        return this.loT;
    }

    public PostData dix() {
        return this.loO;
    }

    public void g(PostData postData) {
        this.loO = postData;
    }

    public int diC() {
        if (this.loR == -1) {
            this.loR = this.aYc;
        }
        return this.loR;
    }

    public int diD() {
        return this.loR;
    }

    public void a(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cwP());
            this.loR = pVar.bHk();
            a(pVar.bzP());
            setPageSize(pVar.getPageSize());
            setThreadData(pVar.bjd());
            setTotalCount(pVar.getTotalCount());
            Gc(pVar.diG());
            this.loP.addAll(0, pVar.diF());
        }
    }

    public void b(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cwP());
            a(pVar.bzP());
            g(pVar.dix());
            setThreadData(pVar.bjd());
            if (pVar.diF() != null) {
                setCurrentPage(pVar.bHk());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                Gc(pVar.diG());
            }
            int size = this.loP.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.loP.remove(this.loP.size() - 1);
                }
            }
            this.loP.addAll(pVar.diF());
        }
    }

    public void c(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cwP());
            a(pVar.bzP());
            g(pVar.dix());
            setThreadData(pVar.bjd());
            if (pVar.diF() != null && pVar.diF().size() > 0) {
                setCurrentPage(pVar.bHk());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                Gc(pVar.diG());
            }
            int size = this.loP.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.loP.remove(this.loP.size() - 1);
                }
            }
            this.loP.addAll(pVar.diF());
            diE();
        }
    }

    public void d(p pVar, boolean z) {
        a(pVar, z);
    }

    public void a(p pVar) {
        if (pVar != null) {
            b(pVar.cwP());
            a(pVar.bzP());
            g(pVar.dix());
            setThreadData(pVar.bjd());
            if (pVar.diF() != null && pVar.diF().size() > 0) {
                setCurrentPage(pVar.bHk());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                Gc(pVar.diG());
                this.loR = (this.aYc - (((pVar.diF().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.loR < 0) {
                    this.loR = 0;
                }
            }
            this.loP.addAll(pVar.diF());
        }
    }

    public void diE() {
        if (this.loR < 0) {
            this.loR = this.aYc;
        } else if (this.loR > this.aYc) {
            this.loR = this.aYc;
        }
    }

    public ArrayList<PostData> diF() {
        return this.loP;
    }

    public void aZ(ArrayList<PostData> arrayList) {
        this.loP = arrayList;
    }

    public int diG() {
        return this.loQ;
    }

    public void Gc(int i) {
        this.loQ = i;
    }

    public int getTotalCount() {
        return this.fpN;
    }

    public void setTotalCount(int i) {
        this.fpN = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bHk() {
        return this.aYc;
    }

    public void setCurrentPage(int i) {
        this.aYc = i;
    }

    public void a(ForumData forumData) {
        this.fpv = forumData;
    }

    public ForumData bzP() {
        return this.fpv;
    }

    public void b(AntiData antiData) {
        this.fbU = antiData;
    }

    public AntiData cwP() {
        return this.fbU;
    }

    public void setThreadData(bx bxVar) {
        this.akt = bxVar;
    }

    public boolean VH() {
        return (this.akt == null || this.loO == null || this.akt.blC() == null || this.akt.blC().getUserId() == null || this.loO.blC() == null || this.loO.blC().getUserId() == null || !this.akt.blC().getUserId().equals(this.loO.blC().getUserId())) ? false : true;
    }

    public boolean bhP() {
        return this.loS;
    }

    public boolean hasMore() {
        return this.aYc < this.loQ;
    }

    public bx bjd() {
        return this.akt;
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
            bx bxVar = new bx();
            bxVar.a(dataRes.thread);
            pVar.setThreadData(bxVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            pVar.a(forumData);
            pVar.jnS = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.xu(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            pVar.g(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.xu(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                if (postData2.bnv() != null && postData2.bnv().baijiahaoData == null && bxVar.getBaijiahaoData() != null) {
                    postData2.bnv().baijiahaoData = bxVar.getBaijiahaoData();
                }
                arrayList.add(postData2);
            }
            pVar.aZ(arrayList);
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
                pVar.Gc(intValue);
            }
            return pVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
