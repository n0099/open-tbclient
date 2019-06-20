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
    private bg cbh;
    private AntiData ceO;
    private ForumData csV;
    private int ctp;
    public boolean fPZ;
    public Error hCn;
    private int mCurrentPage;
    private int mPageSize = 20;
    private int hCl = -1;
    private boolean hCm = false;
    private PostData hCi = null;
    private ArrayList<PostData> hCj = new ArrayList<>();
    private int hCk = 1;

    public Error bQu() {
        return this.hCn;
    }

    public PostData bQv() {
        return this.hCi;
    }

    public void e(PostData postData) {
        this.hCi = postData;
    }

    public int bQw() {
        if (this.hCl == -1) {
            this.hCl = this.mCurrentPage;
        }
        return this.hCl;
    }

    public int bQx() {
        return this.hCl;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.biZ());
            this.hCl = kVar.azx();
            a(kVar.bQB());
            setPageSize(kVar.getPageSize());
            ai(kVar.abv());
            setTotalCount(kVar.getTotalCount());
            pz(kVar.bQA());
            this.hCj.addAll(0, kVar.bQz());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.biZ());
            a(kVar.bQB());
            e(kVar.bQv());
            ai(kVar.abv());
            if (kVar.bQz() != null) {
                setCurrentPage(kVar.azx());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pz(kVar.bQA());
            }
            int size = this.hCj.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hCj.remove(this.hCj.size() - 1);
                }
            }
            this.hCj.addAll(kVar.bQz());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.biZ());
            a(kVar.bQB());
            e(kVar.bQv());
            ai(kVar.abv());
            if (kVar.bQz() != null && kVar.bQz().size() > 0) {
                setCurrentPage(kVar.azx());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pz(kVar.bQA());
            }
            int size = this.hCj.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hCj.remove(this.hCj.size() - 1);
                }
            }
            this.hCj.addAll(kVar.bQz());
            bQy();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.biZ());
            a(kVar.bQB());
            e(kVar.bQv());
            ai(kVar.abv());
            if (kVar.bQz() != null && kVar.bQz().size() > 0) {
                setCurrentPage(kVar.azx());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pz(kVar.bQA());
                this.hCl = (this.mCurrentPage - (((kVar.bQz().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.hCl < 0) {
                    this.hCl = 0;
                }
            }
            this.hCj.addAll(kVar.bQz());
        }
    }

    public void bQy() {
        if (this.hCl < 0) {
            this.hCl = this.mCurrentPage;
        } else if (this.hCl > this.mCurrentPage) {
            this.hCl = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bQz() {
        return this.hCj;
    }

    public void au(ArrayList<PostData> arrayList) {
        this.hCj = arrayList;
    }

    public int bQA() {
        return this.hCk;
    }

    public void pz(int i) {
        this.hCk = i;
    }

    public int getTotalCount() {
        return this.ctp;
    }

    public void setTotalCount(int i) {
        this.ctp = i;
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
        this.csV = forumData;
    }

    public ForumData bQB() {
        return this.csV;
    }

    public void b(AntiData antiData) {
        this.ceO = antiData;
    }

    public AntiData biZ() {
        return this.ceO;
    }

    public void ai(bg bgVar) {
        this.cbh = bgVar;
    }

    public boolean bDe() {
        return (this.cbh == null || this.hCi == null || this.cbh.adv() == null || this.cbh.adv().getUserId() == null || this.hCi.adv() == null || this.hCi.adv().getUserId() == null || !this.cbh.adv().getUserId().equals(this.hCi.adv().getUserId())) ? false : true;
    }

    public boolean ZC() {
        return this.hCm;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.hCk;
    }

    public bg abv() {
        return this.cbh;
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
            kVar.fPZ = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.qK(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            kVar.e(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.qK(forumData.isBrandForum);
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
