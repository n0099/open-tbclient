package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes4.dex */
public class k {
    private bg ccj;
    private AntiData cfT;
    private int cuD;
    private ForumData cui;
    public boolean fUW;
    public Error hIA;
    private int mCurrentPage;
    private int mPageSize = 20;
    private int hIy = -1;
    private boolean hIz = false;
    private PostData hIv = null;
    private ArrayList<PostData> hIw = new ArrayList<>();
    private int hIx = 1;

    public Error bTf() {
        return this.hIA;
    }

    public PostData bTg() {
        return this.hIv;
    }

    public void e(PostData postData) {
        this.hIv = postData;
    }

    public int bTh() {
        if (this.hIy == -1) {
            this.hIy = this.mCurrentPage;
        }
        return this.hIy;
    }

    public int bTi() {
        return this.hIy;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.blb());
            this.hIy = kVar.aAL();
            a(kVar.bTm());
            setPageSize(kVar.getPageSize());
            ai(kVar.acx());
            setTotalCount(kVar.getTotalCount());
            pP(kVar.bTl());
            this.hIw.addAll(0, kVar.bTk());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.blb());
            a(kVar.bTm());
            e(kVar.bTg());
            ai(kVar.acx());
            if (kVar.bTk() != null) {
                setCurrentPage(kVar.aAL());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pP(kVar.bTl());
            }
            int size = this.hIw.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hIw.remove(this.hIw.size() - 1);
                }
            }
            this.hIw.addAll(kVar.bTk());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.blb());
            a(kVar.bTm());
            e(kVar.bTg());
            ai(kVar.acx());
            if (kVar.bTk() != null && kVar.bTk().size() > 0) {
                setCurrentPage(kVar.aAL());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pP(kVar.bTl());
            }
            int size = this.hIw.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hIw.remove(this.hIw.size() - 1);
                }
            }
            this.hIw.addAll(kVar.bTk());
            bTj();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.blb());
            a(kVar.bTm());
            e(kVar.bTg());
            ai(kVar.acx());
            if (kVar.bTk() != null && kVar.bTk().size() > 0) {
                setCurrentPage(kVar.aAL());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pP(kVar.bTl());
                this.hIy = (this.mCurrentPage - (((kVar.bTk().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.hIy < 0) {
                    this.hIy = 0;
                }
            }
            this.hIw.addAll(kVar.bTk());
        }
    }

    public void bTj() {
        if (this.hIy < 0) {
            this.hIy = this.mCurrentPage;
        } else if (this.hIy > this.mCurrentPage) {
            this.hIy = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bTk() {
        return this.hIw;
    }

    public void au(ArrayList<PostData> arrayList) {
        this.hIw = arrayList;
    }

    public int bTl() {
        return this.hIx;
    }

    public void pP(int i) {
        this.hIx = i;
    }

    public int getTotalCount() {
        return this.cuD;
    }

    public void setTotalCount(int i) {
        this.cuD = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int aAL() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.cui = forumData;
    }

    public ForumData bTm() {
        return this.cui;
    }

    public void b(AntiData antiData) {
        this.cfT = antiData;
    }

    public AntiData blb() {
        return this.cfT;
    }

    public void ai(bg bgVar) {
        this.ccj = bgVar;
    }

    public boolean bFL() {
        return (this.ccj == null || this.hIv == null || this.ccj.aex() == null || this.ccj.aex().getUserId() == null || this.hIv.aex() == null || this.hIv.aex().getUserId() == null || !this.ccj.aex().getUserId().equals(this.hIv.aex().getUserId())) ? false : true;
    }

    public boolean aaB() {
        return this.hIz;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.hIx;
    }

    public bg acx() {
        return this.ccj;
    }

    public static k a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            k kVar = new k();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            kVar.b(antiData);
            bg bgVar = new bg();
            bgVar.a(dataRes.thread);
            bgVar.setCurrentPage(2);
            kVar.ai(bgVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            kVar.a(forumData);
            kVar.fUW = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.qZ(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            kVar.e(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.qZ(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            kVar.au(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            kVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                kVar.setCurrentPage(intValue3);
                kVar.setPageSize(intValue2);
                kVar.setTotalCount(intValue4);
                kVar.pP(intValue);
            }
            return kVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
