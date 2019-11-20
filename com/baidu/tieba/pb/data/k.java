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
    private int Zv;
    private ForumData cGF;
    private int cGZ;
    private bh cqG;
    private AntiData cua;
    public boolean fWh;
    public Error hJf;
    private int mPageSize = 20;
    private int hJd = -1;
    private boolean hJe = false;
    private PostData hJa = null;
    private ArrayList<PostData> hJb = new ArrayList<>();
    private int hJc = 1;

    public Error bRf() {
        return this.hJf;
    }

    public PostData bRg() {
        return this.hJa;
    }

    public void e(PostData postData) {
        this.hJa = postData;
    }

    public int bRh() {
        if (this.hJd == -1) {
            this.hJd = this.Zv;
        }
        return this.hJd;
    }

    public int bRi() {
        return this.hJd;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.biX());
            this.hJd = kVar.aBk();
            a(kVar.bRm());
            setPageSize(kVar.getPageSize());
            ai(kVar.agG());
            setTotalCount(kVar.getTotalCount());
            oV(kVar.bRl());
            this.hJb.addAll(0, kVar.bRk());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.biX());
            a(kVar.bRm());
            e(kVar.bRg());
            ai(kVar.agG());
            if (kVar.bRk() != null) {
                setCurrentPage(kVar.aBk());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                oV(kVar.bRl());
            }
            int size = this.hJb.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hJb.remove(this.hJb.size() - 1);
                }
            }
            this.hJb.addAll(kVar.bRk());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.biX());
            a(kVar.bRm());
            e(kVar.bRg());
            ai(kVar.agG());
            if (kVar.bRk() != null && kVar.bRk().size() > 0) {
                setCurrentPage(kVar.aBk());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                oV(kVar.bRl());
            }
            int size = this.hJb.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hJb.remove(this.hJb.size() - 1);
                }
            }
            this.hJb.addAll(kVar.bRk());
            bRj();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.biX());
            a(kVar.bRm());
            e(kVar.bRg());
            ai(kVar.agG());
            if (kVar.bRk() != null && kVar.bRk().size() > 0) {
                setCurrentPage(kVar.aBk());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                oV(kVar.bRl());
                this.hJd = (this.Zv - (((kVar.bRk().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.hJd < 0) {
                    this.hJd = 0;
                }
            }
            this.hJb.addAll(kVar.bRk());
        }
    }

    public void bRj() {
        if (this.hJd < 0) {
            this.hJd = this.Zv;
        } else if (this.hJd > this.Zv) {
            this.hJd = this.Zv;
        }
    }

    public ArrayList<PostData> bRk() {
        return this.hJb;
    }

    public void ay(ArrayList<PostData> arrayList) {
        this.hJb = arrayList;
    }

    public int bRl() {
        return this.hJc;
    }

    public void oV(int i) {
        this.hJc = i;
    }

    public int getTotalCount() {
        return this.cGZ;
    }

    public void setTotalCount(int i) {
        this.cGZ = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int aBk() {
        return this.Zv;
    }

    public void setCurrentPage(int i) {
        this.Zv = i;
    }

    public void a(ForumData forumData) {
        this.cGF = forumData;
    }

    public ForumData bRm() {
        return this.cGF;
    }

    public void b(AntiData antiData) {
        this.cua = antiData;
    }

    public AntiData biX() {
        return this.cua;
    }

    public void ai(bh bhVar) {
        this.cqG = bhVar;
    }

    public boolean bDw() {
        return (this.cqG == null || this.hJa == null || this.cqG.aiE() == null || this.cqG.aiE().getUserId() == null || this.hJa.aiE() == null || this.hJa.aiE().getUserId() == null || !this.cqG.aiE().getUserId().equals(this.hJa.aiE().getUserId())) ? false : true;
    }

    public boolean afk() {
        return this.hJe;
    }

    public boolean hasMore() {
        return this.Zv < this.hJc;
    }

    public bh agG() {
        return this.cqG;
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
            kVar.ai(bhVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            kVar.a(forumData);
            kVar.fWh = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.qM(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            kVar.e(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.qM(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            kVar.ay(arrayList);
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
                kVar.oV(intValue);
            }
            return kVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
