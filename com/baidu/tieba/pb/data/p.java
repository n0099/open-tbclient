package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes22.dex */
public class p {
    private int aYv;
    private bw akq;
    private AntiData eWX;
    private int fkN;
    private ForumData fkv;
    public boolean jhi;
    public Error liB;
    private int mPageSize = 20;
    private int liz = -1;
    private boolean liA = false;
    private PostData liw = null;
    private ArrayList<PostData> lix = new ArrayList<>();
    private int liy = 1;

    public Error dgC() {
        return this.liB;
    }

    public PostData dgy() {
        return this.liw;
    }

    public void g(PostData postData) {
        this.liw = postData;
    }

    public int dgD() {
        if (this.liz == -1) {
            this.liz = this.aYv;
        }
        return this.liz;
    }

    public int dgE() {
        return this.liz;
    }

    public void a(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cuM());
            this.liz = pVar.bFs();
            a(pVar.bya());
            setPageSize(pVar.getPageSize());
            setThreadData(pVar.bhz());
            setTotalCount(pVar.getTotalCount());
            Fr(pVar.dgH());
            this.lix.addAll(0, pVar.dgG());
        }
    }

    public void b(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cuM());
            a(pVar.bya());
            g(pVar.dgy());
            setThreadData(pVar.bhz());
            if (pVar.dgG() != null) {
                setCurrentPage(pVar.bFs());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                Fr(pVar.dgH());
            }
            int size = this.lix.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.lix.remove(this.lix.size() - 1);
                }
            }
            this.lix.addAll(pVar.dgG());
        }
    }

    public void c(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cuM());
            a(pVar.bya());
            g(pVar.dgy());
            setThreadData(pVar.bhz());
            if (pVar.dgG() != null && pVar.dgG().size() > 0) {
                setCurrentPage(pVar.bFs());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                Fr(pVar.dgH());
            }
            int size = this.lix.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.lix.remove(this.lix.size() - 1);
                }
            }
            this.lix.addAll(pVar.dgG());
            dgF();
        }
    }

    public void d(p pVar, boolean z) {
        a(pVar, z);
    }

    public void a(p pVar) {
        if (pVar != null) {
            b(pVar.cuM());
            a(pVar.bya());
            g(pVar.dgy());
            setThreadData(pVar.bhz());
            if (pVar.dgG() != null && pVar.dgG().size() > 0) {
                setCurrentPage(pVar.bFs());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                Fr(pVar.dgH());
                this.liz = (this.aYv - (((pVar.dgG().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.liz < 0) {
                    this.liz = 0;
                }
            }
            this.lix.addAll(pVar.dgG());
        }
    }

    public void dgF() {
        if (this.liz < 0) {
            this.liz = this.aYv;
        } else if (this.liz > this.aYv) {
            this.liz = this.aYv;
        }
    }

    public ArrayList<PostData> dgG() {
        return this.lix;
    }

    public void aY(ArrayList<PostData> arrayList) {
        this.lix = arrayList;
    }

    public int dgH() {
        return this.liy;
    }

    public void Fr(int i) {
        this.liy = i;
    }

    public int getTotalCount() {
        return this.fkN;
    }

    public void setTotalCount(int i) {
        this.fkN = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bFs() {
        return this.aYv;
    }

    public void setCurrentPage(int i) {
        this.aYv = i;
    }

    public void a(ForumData forumData) {
        this.fkv = forumData;
    }

    public ForumData bya() {
        return this.fkv;
    }

    public void b(AntiData antiData) {
        this.eWX = antiData;
    }

    public AntiData cuM() {
        return this.eWX;
    }

    public void setThreadData(bw bwVar) {
        this.akq = bwVar;
    }

    public boolean TQ() {
        return (this.akq == null || this.liw == null || this.akq.bka() == null || this.akq.bka().getUserId() == null || this.liw.bka() == null || this.liw.bka().getUserId() == null || !this.akq.bka().getUserId().equals(this.liw.bka().getUserId())) ? false : true;
    }

    public boolean bfV() {
        return this.liA;
    }

    public boolean hasMore() {
        return this.aYv < this.liy;
    }

    public bw bhz() {
        return this.akq;
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
            bw bwVar = new bw();
            bwVar.a(dataRes.thread);
            pVar.setThreadData(bwVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            pVar.a(forumData);
            pVar.jhi = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.xh(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            pVar.g(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.xh(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                if (postData2.blR() != null && postData2.blR().baijiahaoData == null && bwVar.getBaijiahaoData() != null) {
                    postData2.blR().baijiahaoData = bwVar.getBaijiahaoData();
                }
                arrayList.add(postData2);
            }
            pVar.aY(arrayList);
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
                pVar.Fr(intValue);
            }
            return pVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
