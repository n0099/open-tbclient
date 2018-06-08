package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes2.dex */
public class k {
    private int aNM;
    private ForumData aNu;
    private bd bso;
    private AntiData fpv;
    public Error fpx;
    private int mCurrentPage;
    private int fpt = 20;
    private int fpu = -1;
    private boolean fpw = false;
    private PostData fpp = null;
    private ArrayList<PostData> fpq = new ArrayList<>();
    private int fpr = 1;

    public Error baX() {
        return this.fpx;
    }

    public PostData baY() {
        return this.fpp;
    }

    public void d(PostData postData) {
        this.fpp = postData;
    }

    public int baZ() {
        if (this.fpu == -1) {
            this.fpu = this.mCurrentPage;
        }
        return this.fpu;
    }

    public int bba() {
        return this.fpu;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.bbg());
            this.fpu = kVar.Ox();
            a(kVar.bbf());
            setPageSize(kVar.bbe());
            T(kVar.Sz());
            setTotalCount(kVar.getTotalCount());
            iU(kVar.bbd());
            this.fpq.addAll(0, kVar.bbc());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.bbg());
            a(kVar.bbf());
            d(kVar.baY());
            T(kVar.Sz());
            if (kVar.bbc() != null && kVar.bbc().size() > 0) {
                bX(kVar.Ox());
                setPageSize(kVar.bbe());
                setTotalCount(kVar.getTotalCount());
                iU(kVar.bbd());
            }
            int size = this.fpq.size();
            if (z && size % this.fpt != 0) {
                for (int i = 0; i < size % this.fpt; i++) {
                    this.fpq.remove(this.fpq.size() - 1);
                }
            }
            this.fpq.addAll(kVar.bbc());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.bbg());
            a(kVar.bbf());
            d(kVar.baY());
            T(kVar.Sz());
            if (kVar.bbc() != null && kVar.bbc().size() > 0) {
                bX(kVar.Ox());
                setPageSize(kVar.bbe());
                setTotalCount(kVar.getTotalCount());
                iU(kVar.bbd());
            }
            int size = this.fpq.size();
            if (z && size % this.fpt != 0) {
                for (int i = 0; i < size % this.fpt; i++) {
                    this.fpq.remove(this.fpq.size() - 1);
                }
            }
            this.fpq.addAll(kVar.bbc());
            bbb();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.bbg());
            a(kVar.bbf());
            d(kVar.baY());
            T(kVar.Sz());
            if (kVar.bbc() != null && kVar.bbc().size() > 0) {
                bX(kVar.Ox());
                setPageSize(kVar.bbe());
                setTotalCount(kVar.getTotalCount());
                iU(kVar.bbd());
                this.fpu = (this.mCurrentPage - (((kVar.bbc().size() - 1) + this.fpt) / this.fpt)) + 1;
                if (this.fpu < 0) {
                    this.fpu = 0;
                }
            }
            this.fpq.addAll(kVar.bbc());
        }
    }

    public void bbb() {
        if (this.fpu < 0) {
            this.fpu = this.mCurrentPage;
        } else if (this.fpu > this.mCurrentPage) {
            this.fpu = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bbc() {
        return this.fpq;
    }

    public void al(ArrayList<PostData> arrayList) {
        this.fpq = arrayList;
    }

    public int bbd() {
        return this.fpr;
    }

    public void iU(int i) {
        this.fpr = i;
    }

    public int getTotalCount() {
        return this.aNM;
    }

    public void setTotalCount(int i) {
        this.aNM = i;
    }

    public int bbe() {
        return this.fpt;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.fpt = i;
        }
    }

    public int Ox() {
        return this.mCurrentPage;
    }

    public void bX(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.aNu = forumData;
    }

    public ForumData bbf() {
        return this.aNu;
    }

    public void b(AntiData antiData) {
        this.fpv = antiData;
    }

    public AntiData bbg() {
        return this.fpv;
    }

    public void T(bd bdVar) {
        this.bso = bdVar;
    }

    public boolean aLg() {
        return (this.bso == null || this.fpp == null || this.bso.vm() == null || this.bso.vm().getUserId() == null || this.fpp.vm() == null || this.fpp.vm().getUserId() == null || !this.bso.vm().getUserId().equals(this.fpp.vm().getUserId())) ? false : true;
    }

    public boolean sc() {
        return this.fpw;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fpr;
    }

    public bd Sz() {
        return this.bso;
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
            bd bdVar = new bd();
            bdVar.a(dataRes.thread);
            bdVar.bX(2);
            kVar.T(bdVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            kVar.a(forumData);
            PostData postData = new PostData();
            postData.a(dataRes.post, context);
            kVar.d(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            kVar.al(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            kVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                kVar.bX(intValue3);
                kVar.setPageSize(intValue2);
                kVar.setTotalCount(intValue4);
                kVar.iU(intValue);
            }
            return kVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
