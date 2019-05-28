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
    public boolean fPX;
    public Error hCm;
    private int mCurrentPage;
    private int mPageSize = 20;
    private int hCk = -1;
    private boolean hCl = false;
    private PostData hCh = null;
    private ArrayList<PostData> hCi = new ArrayList<>();
    private int hCj = 1;

    public Error bQt() {
        return this.hCm;
    }

    public PostData bQu() {
        return this.hCh;
    }

    public void e(PostData postData) {
        this.hCh = postData;
    }

    public int bQv() {
        if (this.hCk == -1) {
            this.hCk = this.mCurrentPage;
        }
        return this.hCk;
    }

    public int bQw() {
        return this.hCk;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.biZ());
            this.hCk = kVar.azx();
            a(kVar.bQA());
            setPageSize(kVar.getPageSize());
            ai(kVar.abv());
            setTotalCount(kVar.getTotalCount());
            pz(kVar.bQz());
            this.hCi.addAll(0, kVar.bQy());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.biZ());
            a(kVar.bQA());
            e(kVar.bQu());
            ai(kVar.abv());
            if (kVar.bQy() != null) {
                setCurrentPage(kVar.azx());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pz(kVar.bQz());
            }
            int size = this.hCi.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hCi.remove(this.hCi.size() - 1);
                }
            }
            this.hCi.addAll(kVar.bQy());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.biZ());
            a(kVar.bQA());
            e(kVar.bQu());
            ai(kVar.abv());
            if (kVar.bQy() != null && kVar.bQy().size() > 0) {
                setCurrentPage(kVar.azx());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pz(kVar.bQz());
            }
            int size = this.hCi.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hCi.remove(this.hCi.size() - 1);
                }
            }
            this.hCi.addAll(kVar.bQy());
            bQx();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.biZ());
            a(kVar.bQA());
            e(kVar.bQu());
            ai(kVar.abv());
            if (kVar.bQy() != null && kVar.bQy().size() > 0) {
                setCurrentPage(kVar.azx());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pz(kVar.bQz());
                this.hCk = (this.mCurrentPage - (((kVar.bQy().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.hCk < 0) {
                    this.hCk = 0;
                }
            }
            this.hCi.addAll(kVar.bQy());
        }
    }

    public void bQx() {
        if (this.hCk < 0) {
            this.hCk = this.mCurrentPage;
        } else if (this.hCk > this.mCurrentPage) {
            this.hCk = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bQy() {
        return this.hCi;
    }

    public void au(ArrayList<PostData> arrayList) {
        this.hCi = arrayList;
    }

    public int bQz() {
        return this.hCj;
    }

    public void pz(int i) {
        this.hCj = i;
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

    public int azx() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.csU = forumData;
    }

    public ForumData bQA() {
        return this.csU;
    }

    public void b(AntiData antiData) {
        this.ceN = antiData;
    }

    public AntiData biZ() {
        return this.ceN;
    }

    public void ai(bg bgVar) {
        this.cbg = bgVar;
    }

    public boolean bDd() {
        return (this.cbg == null || this.hCh == null || this.cbg.adv() == null || this.cbg.adv().getUserId() == null || this.hCh.adv() == null || this.hCh.adv().getUserId() == null || !this.cbg.adv().getUserId().equals(this.hCh.adv().getUserId())) ? false : true;
    }

    public boolean ZC() {
        return this.hCl;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.hCj;
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
            kVar.fPX = forumData.isBrandForum;
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
