package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes4.dex */
public class k {
    private bh cdk;
    private AntiData cgT;
    private int cvG;
    private ForumData cvm;
    public boolean fXD;
    public Error hLq;
    private int mCurrentPage;
    private int mPageSize = 20;
    private int hLo = -1;
    private boolean hLp = false;
    private PostData hLl = null;
    private ArrayList<PostData> hLm = new ArrayList<>();
    private int hLn = 1;

    public Error bUg() {
        return this.hLq;
    }

    public PostData bUh() {
        return this.hLl;
    }

    public void e(PostData postData) {
        this.hLl = postData;
    }

    public int bUi() {
        if (this.hLo == -1) {
            this.hLo = this.mCurrentPage;
        }
        return this.hLo;
    }

    public int bUj() {
        return this.hLo;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.blT());
            this.hLo = kVar.aBb();
            a(kVar.bUn());
            setPageSize(kVar.getPageSize());
            ak(kVar.acC());
            setTotalCount(kVar.getTotalCount());
            pU(kVar.bUm());
            this.hLm.addAll(0, kVar.bUl());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.blT());
            a(kVar.bUn());
            e(kVar.bUh());
            ak(kVar.acC());
            if (kVar.bUl() != null) {
                setCurrentPage(kVar.aBb());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pU(kVar.bUm());
            }
            int size = this.hLm.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hLm.remove(this.hLm.size() - 1);
                }
            }
            this.hLm.addAll(kVar.bUl());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.blT());
            a(kVar.bUn());
            e(kVar.bUh());
            ak(kVar.acC());
            if (kVar.bUl() != null && kVar.bUl().size() > 0) {
                setCurrentPage(kVar.aBb());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pU(kVar.bUm());
            }
            int size = this.hLm.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hLm.remove(this.hLm.size() - 1);
                }
            }
            this.hLm.addAll(kVar.bUl());
            bUk();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.blT());
            a(kVar.bUn());
            e(kVar.bUh());
            ak(kVar.acC());
            if (kVar.bUl() != null && kVar.bUl().size() > 0) {
                setCurrentPage(kVar.aBb());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pU(kVar.bUm());
                this.hLo = (this.mCurrentPage - (((kVar.bUl().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.hLo < 0) {
                    this.hLo = 0;
                }
            }
            this.hLm.addAll(kVar.bUl());
        }
    }

    public void bUk() {
        if (this.hLo < 0) {
            this.hLo = this.mCurrentPage;
        } else if (this.hLo > this.mCurrentPage) {
            this.hLo = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bUl() {
        return this.hLm;
    }

    public void au(ArrayList<PostData> arrayList) {
        this.hLm = arrayList;
    }

    public int bUm() {
        return this.hLn;
    }

    public void pU(int i) {
        this.hLn = i;
    }

    public int getTotalCount() {
        return this.cvG;
    }

    public void setTotalCount(int i) {
        this.cvG = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int aBb() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.cvm = forumData;
    }

    public ForumData bUn() {
        return this.cvm;
    }

    public void b(AntiData antiData) {
        this.cgT = antiData;
    }

    public AntiData blT() {
        return this.cgT;
    }

    public void ak(bh bhVar) {
        this.cdk = bhVar;
    }

    public boolean bGN() {
        return (this.cdk == null || this.hLl == null || this.cdk.aeC() == null || this.cdk.aeC().getUserId() == null || this.hLl.aeC() == null || this.hLl.aeC().getUserId() == null || !this.cdk.aeC().getUserId().equals(this.hLl.aeC().getUserId())) ? false : true;
    }

    public boolean aaF() {
        return this.hLp;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.hLn;
    }

    public bh acC() {
        return this.cdk;
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
            bh bhVar = new bh();
            bhVar.a(dataRes.thread);
            bhVar.setCurrentPage(2);
            kVar.ak(bhVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            kVar.a(forumData);
            kVar.fXD = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.rd(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            kVar.e(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.rd(forumData.isBrandForum);
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
                kVar.pU(intValue);
            }
            return kVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
