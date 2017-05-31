package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class n {
    private int aBo;
    private bl bbF;
    private ForumData ejl;
    private AntiData ejr;
    public Error ejt;
    private int mCurrentPage;
    private int ejp = 20;
    private int ejq = -1;
    private boolean ejs = false;
    private PostData ejm = null;
    private ArrayList<PostData> ejn = new ArrayList<>();
    private int ejo = 1;

    public Error aJi() {
        return this.ejt;
    }

    public PostData aJj() {
        return this.ejm;
    }

    public void e(PostData postData) {
        this.ejm = postData;
    }

    public int aJk() {
        if (this.ejq == -1) {
            this.ejq = this.mCurrentPage;
        }
        return this.ejq;
    }

    public int aJl() {
        return this.ejq;
    }

    public void a(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.avj());
            this.ejq = nVar.IQ();
            b(nVar.aJp());
            setPageSize(nVar.aJo());
            N(nVar.LH());
            setTotalCount(nVar.getTotalCount());
            hr(nVar.aGr());
            this.ejn.addAll(0, nVar.aJn());
        }
    }

    public void b(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.avj());
            b(nVar.aJp());
            e(nVar.aJj());
            N(nVar.LH());
            if (nVar.aJn() != null && nVar.aJn().size() > 0) {
                bW(nVar.IQ());
                setPageSize(nVar.aJo());
                setTotalCount(nVar.getTotalCount());
                hr(nVar.aGr());
            }
            int size = this.ejn.size();
            if (z && size % this.ejp != 0) {
                for (int i = 0; i < size % this.ejp; i++) {
                    this.ejn.remove(this.ejn.size() - 1);
                }
            }
            this.ejn.addAll(nVar.aJn());
        }
    }

    public void c(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.avj());
            b(nVar.aJp());
            e(nVar.aJj());
            N(nVar.LH());
            if (nVar.aJn() != null && nVar.aJn().size() > 0) {
                bW(nVar.IQ());
                setPageSize(nVar.aJo());
                setTotalCount(nVar.getTotalCount());
                hr(nVar.aGr());
            }
            int size = this.ejn.size();
            if (z && size % this.ejp != 0) {
                for (int i = 0; i < size % this.ejp; i++) {
                    this.ejn.remove(this.ejn.size() - 1);
                }
            }
            this.ejn.addAll(nVar.aJn());
            aJm();
        }
    }

    public void d(n nVar, boolean z) {
        a(nVar, z);
    }

    public void a(n nVar) {
        if (nVar != null) {
            e(nVar.avj());
            b(nVar.aJp());
            e(nVar.aJj());
            N(nVar.LH());
            if (nVar.aJn() != null && nVar.aJn().size() > 0) {
                bW(nVar.IQ());
                setPageSize(nVar.aJo());
                setTotalCount(nVar.getTotalCount());
                hr(nVar.aGr());
                this.ejq = (this.mCurrentPage - (((nVar.aJn().size() - 1) + this.ejp) / this.ejp)) + 1;
                if (this.ejq < 0) {
                    this.ejq = 0;
                }
            }
            this.ejn.addAll(nVar.aJn());
        }
    }

    public void aJm() {
        if (this.ejq < 0) {
            this.ejq = this.mCurrentPage;
        } else if (this.ejq > this.mCurrentPage) {
            this.ejq = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aJn() {
        return this.ejn;
    }

    public void ai(ArrayList<PostData> arrayList) {
        this.ejn = arrayList;
    }

    public int aGr() {
        return this.ejo;
    }

    public void hr(int i) {
        this.ejo = i;
    }

    public int getTotalCount() {
        return this.aBo;
    }

    public void setTotalCount(int i) {
        this.aBo = i;
    }

    public int aJo() {
        return this.ejp;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.ejp = i;
        }
    }

    public int IQ() {
        return this.mCurrentPage;
    }

    public void bW(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.ejl = forumData;
    }

    public ForumData aJp() {
        return this.ejl;
    }

    public void e(AntiData antiData) {
        this.ejr = antiData;
    }

    public AntiData avj() {
        return this.ejr;
    }

    public void N(bl blVar) {
        this.bbF = blVar;
    }

    public boolean arL() {
        return (this.bbF == null || this.ejm == null || this.bbF.getAuthor() == null || this.bbF.getAuthor().getUserId() == null || this.ejm.getAuthor() == null || this.ejm.getAuthor().getUserId() == null || !this.bbF.getAuthor().getUserId().equals(this.ejm.getAuthor().getUserId())) ? false : true;
    }

    public boolean nD() {
        return this.ejs;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.ejo;
    }

    public bl LH() {
        return this.bbF;
    }

    public static n a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            n nVar = new n();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            nVar.e(antiData);
            bl blVar = new bl();
            blVar.a(dataRes.thread);
            blVar.bW(2);
            nVar.N(blVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            nVar.b(forumData);
            PostData postData = new PostData();
            postData.a(dataRes.post, context);
            nVar.e(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            nVar.ai(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            nVar.e(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                nVar.bW(intValue3);
                nVar.setPageSize(intValue2);
                nVar.setTotalCount(intValue4);
                nVar.hr(intValue);
            }
            return nVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
