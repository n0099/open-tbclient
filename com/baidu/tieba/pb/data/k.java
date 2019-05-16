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
    private bg cbg;
    private AntiData ceN;
    private ForumData csU;
    private int cto;
    public boolean fPW;
    public Error hCj;
    private int mCurrentPage;
    private int mPageSize = 20;
    private int hCh = -1;
    private boolean hCi = false;
    private PostData hCe = null;
    private ArrayList<PostData> hCf = new ArrayList<>();
    private int hCg = 1;

    public Error bQq() {
        return this.hCj;
    }

    public PostData bQr() {
        return this.hCe;
    }

    public void e(PostData postData) {
        this.hCe = postData;
    }

    public int bQs() {
        if (this.hCh == -1) {
            this.hCh = this.mCurrentPage;
        }
        return this.hCh;
    }

    public int bQt() {
        return this.hCh;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.biW());
            this.hCh = kVar.azw();
            a(kVar.bQx());
            setPageSize(kVar.getPageSize());
            ai(kVar.abv());
            setTotalCount(kVar.getTotalCount());
            pz(kVar.bQw());
            this.hCf.addAll(0, kVar.bQv());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.biW());
            a(kVar.bQx());
            e(kVar.bQr());
            ai(kVar.abv());
            if (kVar.bQv() != null) {
                setCurrentPage(kVar.azw());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pz(kVar.bQw());
            }
            int size = this.hCf.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hCf.remove(this.hCf.size() - 1);
                }
            }
            this.hCf.addAll(kVar.bQv());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.biW());
            a(kVar.bQx());
            e(kVar.bQr());
            ai(kVar.abv());
            if (kVar.bQv() != null && kVar.bQv().size() > 0) {
                setCurrentPage(kVar.azw());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pz(kVar.bQw());
            }
            int size = this.hCf.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hCf.remove(this.hCf.size() - 1);
                }
            }
            this.hCf.addAll(kVar.bQv());
            bQu();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.biW());
            a(kVar.bQx());
            e(kVar.bQr());
            ai(kVar.abv());
            if (kVar.bQv() != null && kVar.bQv().size() > 0) {
                setCurrentPage(kVar.azw());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pz(kVar.bQw());
                this.hCh = (this.mCurrentPage - (((kVar.bQv().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.hCh < 0) {
                    this.hCh = 0;
                }
            }
            this.hCf.addAll(kVar.bQv());
        }
    }

    public void bQu() {
        if (this.hCh < 0) {
            this.hCh = this.mCurrentPage;
        } else if (this.hCh > this.mCurrentPage) {
            this.hCh = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bQv() {
        return this.hCf;
    }

    public void au(ArrayList<PostData> arrayList) {
        this.hCf = arrayList;
    }

    public int bQw() {
        return this.hCg;
    }

    public void pz(int i) {
        this.hCg = i;
    }

    public int getTotalCount() {
        return this.cto;
    }

    public void setTotalCount(int i) {
        this.cto = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int azw() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.csU = forumData;
    }

    public ForumData bQx() {
        return this.csU;
    }

    public void b(AntiData antiData) {
        this.ceN = antiData;
    }

    public AntiData biW() {
        return this.ceN;
    }

    public void ai(bg bgVar) {
        this.cbg = bgVar;
    }

    public boolean bDa() {
        return (this.cbg == null || this.hCe == null || this.cbg.adv() == null || this.cbg.adv().getUserId() == null || this.hCe.adv() == null || this.hCe.adv().getUserId() == null || !this.cbg.adv().getUserId().equals(this.hCe.adv().getUserId())) ? false : true;
    }

    public boolean ZC() {
        return this.hCi;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.hCg;
    }

    public bg abv() {
        return this.cbg;
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
            kVar.fPW = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.qJ(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            kVar.e(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.qJ(forumData.isBrandForum);
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
                kVar.pz(intValue);
            }
            return kVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
