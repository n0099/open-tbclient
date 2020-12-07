package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes22.dex */
public class p {
    private by alu;
    private int bbx;
    private AntiData fju;
    private ForumData fxa;
    private int fxs;
    public boolean jBu;
    public Error lCp;
    private int mPageSize = 20;
    private int lCn = -1;
    private boolean lCo = false;
    private PostData lCk = null;
    private ArrayList<PostData> lCl = new ArrayList<>();
    private int lCm = 1;

    public Error dnQ() {
        return this.lCp;
    }

    public PostData dnM() {
        return this.lCk;
    }

    public void g(PostData postData) {
        this.lCk = postData;
    }

    public int dnR() {
        if (this.lCn == -1) {
            this.lCn = this.bbx;
        }
        return this.lCn;
    }

    public int dnS() {
        return this.lCn;
    }

    public void a(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cBe());
            this.lCn = pVar.bKK();
            a(pVar.bDp());
            setPageSize(pVar.getPageSize());
            setThreadData(pVar.bmn());
            setTotalCount(pVar.getTotalCount());
            GR(pVar.dnV());
            this.lCl.addAll(0, pVar.dnU());
        }
    }

    public void b(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cBe());
            a(pVar.bDp());
            g(pVar.dnM());
            setThreadData(pVar.bmn());
            if (pVar.dnU() != null) {
                setCurrentPage(pVar.bKK());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                GR(pVar.dnV());
            }
            int size = this.lCl.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.lCl.remove(this.lCl.size() - 1);
                }
            }
            this.lCl.addAll(pVar.dnU());
        }
    }

    public void c(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cBe());
            a(pVar.bDp());
            g(pVar.dnM());
            setThreadData(pVar.bmn());
            if (pVar.dnU() != null && pVar.dnU().size() > 0) {
                setCurrentPage(pVar.bKK());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                GR(pVar.dnV());
            }
            int size = this.lCl.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.lCl.remove(this.lCl.size() - 1);
                }
            }
            this.lCl.addAll(pVar.dnU());
            dnT();
        }
    }

    public void d(p pVar, boolean z) {
        a(pVar, z);
    }

    public void a(p pVar) {
        if (pVar != null) {
            b(pVar.cBe());
            a(pVar.bDp());
            g(pVar.dnM());
            setThreadData(pVar.bmn());
            if (pVar.dnU() != null && pVar.dnU().size() > 0) {
                setCurrentPage(pVar.bKK());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                GR(pVar.dnV());
                this.lCn = (this.bbx - (((pVar.dnU().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.lCn < 0) {
                    this.lCn = 0;
                }
            }
            this.lCl.addAll(pVar.dnU());
        }
    }

    public void dnT() {
        if (this.lCn < 0) {
            this.lCn = this.bbx;
        } else if (this.lCn > this.bbx) {
            this.lCn = this.bbx;
        }
    }

    public ArrayList<PostData> dnU() {
        return this.lCl;
    }

    public void bb(ArrayList<PostData> arrayList) {
        this.lCl = arrayList;
    }

    public int dnV() {
        return this.lCm;
    }

    public void GR(int i) {
        this.lCm = i;
    }

    public int getTotalCount() {
        return this.fxs;
    }

    public void setTotalCount(int i) {
        this.fxs = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bKK() {
        return this.bbx;
    }

    public void setCurrentPage(int i) {
        this.bbx = i;
    }

    public void a(ForumData forumData) {
        this.fxa = forumData;
    }

    public ForumData bDp() {
        return this.fxa;
    }

    public void b(AntiData antiData) {
        this.fju = antiData;
    }

    public AntiData cBe() {
        return this.fju;
    }

    public void setThreadData(by byVar) {
        this.alu = byVar;
    }

    public boolean Yh() {
        return (this.alu == null || this.lCk == null || this.alu.boP() == null || this.alu.boP().getUserId() == null || this.lCk.boP() == null || this.lCk.boP().getUserId() == null || !this.alu.boP().getUserId().equals(this.lCk.boP().getUserId())) ? false : true;
    }

    public boolean bkY() {
        return this.lCo;
    }

    public boolean hasMore() {
        return this.bbx < this.lCm;
    }

    public by bmn() {
        return this.alu;
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
            by byVar = new by();
            byVar.a(dataRes.thread);
            pVar.setThreadData(byVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            pVar.a(forumData);
            pVar.jBu = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.xY(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            pVar.g(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.xY(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                if (postData2.bqI() != null && postData2.bqI().baijiahaoData == null && byVar.getBaijiahaoData() != null) {
                    postData2.bqI().baijiahaoData = byVar.getBaijiahaoData();
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
                pVar.GR(intValue);
            }
            return pVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
