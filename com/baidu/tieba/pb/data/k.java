package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes2.dex */
public class k {
    private AntiData aBW;
    private int aOI;
    private ForumData aOq;
    private bc btP;
    public boolean dHc;
    public Error ftp;
    private int mCurrentPage;
    private int ftm = 20;
    private int ftn = -1;
    private boolean fto = false;
    private PostData ftj = null;
    private ArrayList<PostData> ftk = new ArrayList<>();
    private int ftl = 1;

    public Error bbF() {
        return this.ftp;
    }

    public PostData bbG() {
        return this.ftj;
    }

    public void d(PostData postData) {
        this.ftj = postData;
    }

    public int bbH() {
        if (this.ftn == -1) {
            this.ftn = this.mCurrentPage;
        }
        return this.ftn;
    }

    public int bbI() {
        return this.ftn;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.Cm());
            this.ftn = kVar.OQ();
            a(kVar.bbN());
            setPageSize(kVar.bbM());
            X(kVar.SV());
            setTotalCount(kVar.getTotalCount());
            iS(kVar.bbL());
            this.ftk.addAll(0, kVar.bbK());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.Cm());
            a(kVar.bbN());
            d(kVar.bbG());
            X(kVar.SV());
            if (kVar.bbK() != null && kVar.bbK().size() > 0) {
                bY(kVar.OQ());
                setPageSize(kVar.bbM());
                setTotalCount(kVar.getTotalCount());
                iS(kVar.bbL());
            }
            int size = this.ftk.size();
            if (z && size % this.ftm != 0) {
                for (int i = 0; i < size % this.ftm; i++) {
                    this.ftk.remove(this.ftk.size() - 1);
                }
            }
            this.ftk.addAll(kVar.bbK());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.Cm());
            a(kVar.bbN());
            d(kVar.bbG());
            X(kVar.SV());
            if (kVar.bbK() != null && kVar.bbK().size() > 0) {
                bY(kVar.OQ());
                setPageSize(kVar.bbM());
                setTotalCount(kVar.getTotalCount());
                iS(kVar.bbL());
            }
            int size = this.ftk.size();
            if (z && size % this.ftm != 0) {
                for (int i = 0; i < size % this.ftm; i++) {
                    this.ftk.remove(this.ftk.size() - 1);
                }
            }
            this.ftk.addAll(kVar.bbK());
            bbJ();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.Cm());
            a(kVar.bbN());
            d(kVar.bbG());
            X(kVar.SV());
            if (kVar.bbK() != null && kVar.bbK().size() > 0) {
                bY(kVar.OQ());
                setPageSize(kVar.bbM());
                setTotalCount(kVar.getTotalCount());
                iS(kVar.bbL());
                this.ftn = (this.mCurrentPage - (((kVar.bbK().size() - 1) + this.ftm) / this.ftm)) + 1;
                if (this.ftn < 0) {
                    this.ftn = 0;
                }
            }
            this.ftk.addAll(kVar.bbK());
        }
    }

    public void bbJ() {
        if (this.ftn < 0) {
            this.ftn = this.mCurrentPage;
        } else if (this.ftn > this.mCurrentPage) {
            this.ftn = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bbK() {
        return this.ftk;
    }

    public void ap(ArrayList<PostData> arrayList) {
        this.ftk = arrayList;
    }

    public int bbL() {
        return this.ftl;
    }

    public void iS(int i) {
        this.ftl = i;
    }

    public int getTotalCount() {
        return this.aOI;
    }

    public void setTotalCount(int i) {
        this.aOI = i;
    }

    public int bbM() {
        return this.ftm;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.ftm = i;
        }
    }

    public int OQ() {
        return this.mCurrentPage;
    }

    public void bY(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.aOq = forumData;
    }

    public ForumData bbN() {
        return this.aOq;
    }

    public void b(AntiData antiData) {
        this.aBW = antiData;
    }

    public AntiData Cm() {
        return this.aBW;
    }

    public void X(bc bcVar) {
        this.btP = bcVar;
    }

    public boolean aLM() {
        return (this.btP == null || this.ftj == null || this.btP.vw() == null || this.btP.vw().getUserId() == null || this.ftj.vw() == null || this.ftj.vw().getUserId() == null || !this.btP.vw().getUserId().equals(this.ftj.vw().getUserId())) ? false : true;
    }

    public boolean sc() {
        return this.fto;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.ftl;
    }

    public bc SV() {
        return this.btP;
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
            bc bcVar = new bc();
            bcVar.a(dataRes.thread);
            bcVar.bY(2);
            kVar.X(bcVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            kVar.a(forumData);
            kVar.dHc = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.jG(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            kVar.d(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.jG(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            kVar.ap(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            kVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                kVar.bY(intValue3);
                kVar.setPageSize(intValue2);
                kVar.setTotalCount(intValue4);
                kVar.iS(intValue);
            }
            return kVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
