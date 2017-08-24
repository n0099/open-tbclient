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
    private int aEK;
    private bl bgG;
    private ForumData eGB;
    private AntiData eGH;
    public Error eGJ;
    private int mCurrentPage;
    private int eGF = 20;
    private int eGG = -1;
    private boolean eGI = false;
    private PostData eGC = null;
    private ArrayList<PostData> eGD = new ArrayList<>();
    private int eGE = 1;

    public Error aQs() {
        return this.eGJ;
    }

    public PostData aQt() {
        return this.eGC;
    }

    public void f(PostData postData) {
        this.eGC = postData;
    }

    public int aQu() {
        if (this.eGG == -1) {
            this.eGG = this.mCurrentPage;
        }
        return this.eGG;
    }

    public int aQv() {
        return this.eGG;
    }

    public void a(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.aBx());
            this.eGG = nVar.JG();
            b(nVar.aQz());
            setPageSize(nVar.aQy());
            U(nVar.MF());
            setTotalCount(nVar.getTotalCount());
            hC(nVar.aNA());
            this.eGD.addAll(0, nVar.aQx());
        }
    }

    public void b(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.aBx());
            b(nVar.aQz());
            f(nVar.aQt());
            U(nVar.MF());
            if (nVar.aQx() != null && nVar.aQx().size() > 0) {
                bX(nVar.JG());
                setPageSize(nVar.aQy());
                setTotalCount(nVar.getTotalCount());
                hC(nVar.aNA());
            }
            int size = this.eGD.size();
            if (z && size % this.eGF != 0) {
                for (int i = 0; i < size % this.eGF; i++) {
                    this.eGD.remove(this.eGD.size() - 1);
                }
            }
            this.eGD.addAll(nVar.aQx());
        }
    }

    public void c(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.aBx());
            b(nVar.aQz());
            f(nVar.aQt());
            U(nVar.MF());
            if (nVar.aQx() != null && nVar.aQx().size() > 0) {
                bX(nVar.JG());
                setPageSize(nVar.aQy());
                setTotalCount(nVar.getTotalCount());
                hC(nVar.aNA());
            }
            int size = this.eGD.size();
            if (z && size % this.eGF != 0) {
                for (int i = 0; i < size % this.eGF; i++) {
                    this.eGD.remove(this.eGD.size() - 1);
                }
            }
            this.eGD.addAll(nVar.aQx());
            aQw();
        }
    }

    public void d(n nVar, boolean z) {
        a(nVar, z);
    }

    public void a(n nVar) {
        if (nVar != null) {
            e(nVar.aBx());
            b(nVar.aQz());
            f(nVar.aQt());
            U(nVar.MF());
            if (nVar.aQx() != null && nVar.aQx().size() > 0) {
                bX(nVar.JG());
                setPageSize(nVar.aQy());
                setTotalCount(nVar.getTotalCount());
                hC(nVar.aNA());
                this.eGG = (this.mCurrentPage - (((nVar.aQx().size() - 1) + this.eGF) / this.eGF)) + 1;
                if (this.eGG < 0) {
                    this.eGG = 0;
                }
            }
            this.eGD.addAll(nVar.aQx());
        }
    }

    public void aQw() {
        if (this.eGG < 0) {
            this.eGG = this.mCurrentPage;
        } else if (this.eGG > this.mCurrentPage) {
            this.eGG = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aQx() {
        return this.eGD;
    }

    public void ak(ArrayList<PostData> arrayList) {
        this.eGD = arrayList;
    }

    public int aNA() {
        return this.eGE;
    }

    public void hC(int i) {
        this.eGE = i;
    }

    public int getTotalCount() {
        return this.aEK;
    }

    public void setTotalCount(int i) {
        this.aEK = i;
    }

    public int aQy() {
        return this.eGF;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.eGF = i;
        }
    }

    public int JG() {
        return this.mCurrentPage;
    }

    public void bX(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.eGB = forumData;
    }

    public ForumData aQz() {
        return this.eGB;
    }

    public void e(AntiData antiData) {
        this.eGH = antiData;
    }

    public AntiData aBx() {
        return this.eGH;
    }

    public void U(bl blVar) {
        this.bgG = blVar;
    }

    public boolean axO() {
        return (this.bgG == null || this.eGC == null || this.bgG.getAuthor() == null || this.bgG.getAuthor().getUserId() == null || this.eGC.getAuthor() == null || this.eGC.getAuthor().getUserId() == null || !this.bgG.getAuthor().getUserId().equals(this.eGC.getAuthor().getUserId())) ? false : true;
    }

    public boolean nM() {
        return this.eGI;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.eGE;
    }

    public bl MF() {
        return this.bgG;
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
            blVar.bX(2);
            nVar.U(blVar);
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
                nVar.bX(intValue3);
                nVar.setPageSize(intValue2);
                nVar.setTotalCount(intValue4);
                nVar.hC(intValue);
            }
            return nVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
