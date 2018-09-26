package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes2.dex */
public class j {
    private AntiData aET;
    private ForumData aRE;
    private int aRW;
    private bb bAn;
    public boolean dQX;
    public Error fBc;
    private int mCurrentPage;
    private int ecq = 20;
    private int fBa = -1;
    private boolean fBb = false;
    private PostData fAX = null;
    private ArrayList<PostData> fAY = new ArrayList<>();
    private int fAZ = 1;

    public Error bcp() {
        return this.fBc;
    }

    public PostData bcq() {
        return this.fAX;
    }

    public void e(PostData postData) {
        this.fAX = postData;
    }

    public int bcr() {
        if (this.fBa == -1) {
            this.fBa = this.mCurrentPage;
        }
        return this.fBa;
    }

    public int bcs() {
        return this.fBa;
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.avt());
            this.fBa = jVar.QP();
            a(jVar.bcx());
            setPageSize(jVar.bcw());
            aa(jVar.UT());
            setTotalCount(jVar.getTotalCount());
            jC(jVar.bcv());
            this.fAY.addAll(0, jVar.bcu());
        }
    }

    public void b(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.avt());
            a(jVar.bcx());
            e(jVar.bcq());
            aa(jVar.UT());
            if (jVar.bcu() != null) {
                cj(jVar.QP());
                setPageSize(jVar.bcw());
                setTotalCount(jVar.getTotalCount());
                jC(jVar.bcv());
            }
            int size = this.fAY.size();
            if (z && size % this.ecq != 0) {
                for (int i = 0; i < size % this.ecq; i++) {
                    this.fAY.remove(this.fAY.size() - 1);
                }
            }
            this.fAY.addAll(jVar.bcu());
        }
    }

    public void c(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.avt());
            a(jVar.bcx());
            e(jVar.bcq());
            aa(jVar.UT());
            if (jVar.bcu() != null && jVar.bcu().size() > 0) {
                cj(jVar.QP());
                setPageSize(jVar.bcw());
                setTotalCount(jVar.getTotalCount());
                jC(jVar.bcv());
            }
            int size = this.fAY.size();
            if (z && size % this.ecq != 0) {
                for (int i = 0; i < size % this.ecq; i++) {
                    this.fAY.remove(this.fAY.size() - 1);
                }
            }
            this.fAY.addAll(jVar.bcu());
            bct();
        }
    }

    public void d(j jVar, boolean z) {
        a(jVar, z);
    }

    public void a(j jVar) {
        if (jVar != null) {
            b(jVar.avt());
            a(jVar.bcx());
            e(jVar.bcq());
            aa(jVar.UT());
            if (jVar.bcu() != null && jVar.bcu().size() > 0) {
                cj(jVar.QP());
                setPageSize(jVar.bcw());
                setTotalCount(jVar.getTotalCount());
                jC(jVar.bcv());
                this.fBa = (this.mCurrentPage - (((jVar.bcu().size() - 1) + this.ecq) / this.ecq)) + 1;
                if (this.fBa < 0) {
                    this.fBa = 0;
                }
            }
            this.fAY.addAll(jVar.bcu());
        }
    }

    public void bct() {
        if (this.fBa < 0) {
            this.fBa = this.mCurrentPage;
        } else if (this.fBa > this.mCurrentPage) {
            this.fBa = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bcu() {
        return this.fAY;
    }

    public void an(ArrayList<PostData> arrayList) {
        this.fAY = arrayList;
    }

    public int bcv() {
        return this.fAZ;
    }

    public void jC(int i) {
        this.fAZ = i;
    }

    public int getTotalCount() {
        return this.aRW;
    }

    public void setTotalCount(int i) {
        this.aRW = i;
    }

    public int bcw() {
        return this.ecq;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.ecq = i;
        }
    }

    public int QP() {
        return this.mCurrentPage;
    }

    public void cj(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.aRE = forumData;
    }

    public ForumData bcx() {
        return this.aRE;
    }

    public void b(AntiData antiData) {
        this.aET = antiData;
    }

    public AntiData avt() {
        return this.aET;
    }

    public void aa(bb bbVar) {
        this.bAn = bbVar;
    }

    public boolean aOZ() {
        return (this.bAn == null || this.fAX == null || this.bAn.wm() == null || this.bAn.wm().getUserId() == null || this.fAX.wm() == null || this.fAX.wm().getUserId() == null || !this.bAn.wm().getUserId().equals(this.fAX.wm().getUserId())) ? false : true;
    }

    public boolean sR() {
        return this.fBb;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fAZ;
    }

    public bb UT() {
        return this.bAn;
    }

    public static j a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            j jVar = new j();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            jVar.b(antiData);
            bb bbVar = new bb();
            bbVar.a(dataRes.thread);
            bbVar.cj(2);
            jVar.aa(bbVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            jVar.a(forumData);
            jVar.dQX = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.jT(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            jVar.e(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.jT(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            jVar.an(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            jVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                jVar.cj(intValue3);
                jVar.setPageSize(intValue2);
                jVar.setTotalCount(intValue4);
                jVar.jC(intValue);
            }
            return jVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
