package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class n {
    private int aCr;
    private bm bdI;
    private ForumData esj;
    private AntiData esp;
    public Error esr;
    private int mCurrentPage;
    private int esn = 20;
    private int eso = -1;
    private boolean esq = false;
    private PostData esk = null;
    private ArrayList<PostData> esl = new ArrayList<>();
    private int esm = 1;

    public Error aNc() {
        return this.esr;
    }

    public PostData aNd() {
        return this.esk;
    }

    public void f(PostData postData) {
        this.esk = postData;
    }

    public int aNe() {
        if (this.eso == -1) {
            this.eso = this.mCurrentPage;
        }
        return this.eso;
    }

    public int aNf() {
        return this.eso;
    }

    public void a(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.azh());
            this.eso = nVar.Jo();
            b(nVar.aNj());
            setPageSize(nVar.aNi());
            O(nVar.Mv());
            setTotalCount(nVar.getTotalCount());
            hu(nVar.aKk());
            this.esl.addAll(0, nVar.aNh());
        }
    }

    public void b(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.azh());
            b(nVar.aNj());
            f(nVar.aNd());
            O(nVar.Mv());
            if (nVar.aNh() != null && nVar.aNh().size() > 0) {
                bW(nVar.Jo());
                setPageSize(nVar.aNi());
                setTotalCount(nVar.getTotalCount());
                hu(nVar.aKk());
            }
            int size = this.esl.size();
            if (z && size % this.esn != 0) {
                for (int i = 0; i < size % this.esn; i++) {
                    this.esl.remove(this.esl.size() - 1);
                }
            }
            this.esl.addAll(nVar.aNh());
        }
    }

    public void c(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.azh());
            b(nVar.aNj());
            f(nVar.aNd());
            O(nVar.Mv());
            if (nVar.aNh() != null && nVar.aNh().size() > 0) {
                bW(nVar.Jo());
                setPageSize(nVar.aNi());
                setTotalCount(nVar.getTotalCount());
                hu(nVar.aKk());
            }
            int size = this.esl.size();
            if (z && size % this.esn != 0) {
                for (int i = 0; i < size % this.esn; i++) {
                    this.esl.remove(this.esl.size() - 1);
                }
            }
            this.esl.addAll(nVar.aNh());
            aNg();
        }
    }

    public void d(n nVar, boolean z) {
        a(nVar, z);
    }

    public void a(n nVar) {
        if (nVar != null) {
            e(nVar.azh());
            b(nVar.aNj());
            f(nVar.aNd());
            O(nVar.Mv());
            if (nVar.aNh() != null && nVar.aNh().size() > 0) {
                bW(nVar.Jo());
                setPageSize(nVar.aNi());
                setTotalCount(nVar.getTotalCount());
                hu(nVar.aKk());
                this.eso = (this.mCurrentPage - (((nVar.aNh().size() - 1) + this.esn) / this.esn)) + 1;
                if (this.eso < 0) {
                    this.eso = 0;
                }
            }
            this.esl.addAll(nVar.aNh());
        }
    }

    public void aNg() {
        if (this.eso < 0) {
            this.eso = this.mCurrentPage;
        } else if (this.eso > this.mCurrentPage) {
            this.eso = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aNh() {
        return this.esl;
    }

    public void ak(ArrayList<PostData> arrayList) {
        this.esl = arrayList;
    }

    public int aKk() {
        return this.esm;
    }

    public void hu(int i) {
        this.esm = i;
    }

    public int getTotalCount() {
        return this.aCr;
    }

    public void setTotalCount(int i) {
        this.aCr = i;
    }

    public int aNi() {
        return this.esn;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.esn = i;
        }
    }

    public int Jo() {
        return this.mCurrentPage;
    }

    public void bW(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.esj = forumData;
    }

    public ForumData aNj() {
        return this.esj;
    }

    public void e(AntiData antiData) {
        this.esp = antiData;
    }

    public AntiData azh() {
        return this.esp;
    }

    public void O(bm bmVar) {
        this.bdI = bmVar;
    }

    public boolean avw() {
        return (this.bdI == null || this.esk == null || this.bdI.getAuthor() == null || this.bdI.getAuthor().getUserId() == null || this.esk.getAuthor() == null || this.esk.getAuthor().getUserId() == null || !this.bdI.getAuthor().getUserId().equals(this.esk.getAuthor().getUserId())) ? false : true;
    }

    public boolean nz() {
        return this.esq;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.esm;
    }

    public bm Mv() {
        return this.bdI;
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
            bm bmVar = new bm();
            bmVar.a(dataRes.thread);
            bmVar.bW(2);
            nVar.O(bmVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            nVar.b(forumData);
            PostData postData = new PostData();
            postData.a(dataRes.post, context);
            nVar.f(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            nVar.ak(arrayList);
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
                nVar.hu(intValue);
            }
            return nVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
