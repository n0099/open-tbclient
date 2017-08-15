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
    private int aEJ;
    private bl bgF;
    private AntiData eGF;
    public Error eGH;
    private ForumData eGz;
    private int mCurrentPage;
    private int eGD = 20;
    private int eGE = -1;
    private boolean eGG = false;
    private PostData eGA = null;
    private ArrayList<PostData> eGB = new ArrayList<>();
    private int eGC = 1;

    public Error aQx() {
        return this.eGH;
    }

    public PostData aQy() {
        return this.eGA;
    }

    public void f(PostData postData) {
        this.eGA = postData;
    }

    public int aQz() {
        if (this.eGE == -1) {
            this.eGE = this.mCurrentPage;
        }
        return this.eGE;
    }

    public int aQA() {
        return this.eGE;
    }

    public void a(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.aBC());
            this.eGE = nVar.JG();
            b(nVar.aQE());
            setPageSize(nVar.aQD());
            U(nVar.MF());
            setTotalCount(nVar.getTotalCount());
            hC(nVar.aNF());
            this.eGB.addAll(0, nVar.aQC());
        }
    }

    public void b(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.aBC());
            b(nVar.aQE());
            f(nVar.aQy());
            U(nVar.MF());
            if (nVar.aQC() != null && nVar.aQC().size() > 0) {
                bX(nVar.JG());
                setPageSize(nVar.aQD());
                setTotalCount(nVar.getTotalCount());
                hC(nVar.aNF());
            }
            int size = this.eGB.size();
            if (z && size % this.eGD != 0) {
                for (int i = 0; i < size % this.eGD; i++) {
                    this.eGB.remove(this.eGB.size() - 1);
                }
            }
            this.eGB.addAll(nVar.aQC());
        }
    }

    public void c(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.aBC());
            b(nVar.aQE());
            f(nVar.aQy());
            U(nVar.MF());
            if (nVar.aQC() != null && nVar.aQC().size() > 0) {
                bX(nVar.JG());
                setPageSize(nVar.aQD());
                setTotalCount(nVar.getTotalCount());
                hC(nVar.aNF());
            }
            int size = this.eGB.size();
            if (z && size % this.eGD != 0) {
                for (int i = 0; i < size % this.eGD; i++) {
                    this.eGB.remove(this.eGB.size() - 1);
                }
            }
            this.eGB.addAll(nVar.aQC());
            aQB();
        }
    }

    public void d(n nVar, boolean z) {
        a(nVar, z);
    }

    public void a(n nVar) {
        if (nVar != null) {
            e(nVar.aBC());
            b(nVar.aQE());
            f(nVar.aQy());
            U(nVar.MF());
            if (nVar.aQC() != null && nVar.aQC().size() > 0) {
                bX(nVar.JG());
                setPageSize(nVar.aQD());
                setTotalCount(nVar.getTotalCount());
                hC(nVar.aNF());
                this.eGE = (this.mCurrentPage - (((nVar.aQC().size() - 1) + this.eGD) / this.eGD)) + 1;
                if (this.eGE < 0) {
                    this.eGE = 0;
                }
            }
            this.eGB.addAll(nVar.aQC());
        }
    }

    public void aQB() {
        if (this.eGE < 0) {
            this.eGE = this.mCurrentPage;
        } else if (this.eGE > this.mCurrentPage) {
            this.eGE = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aQC() {
        return this.eGB;
    }

    public void ak(ArrayList<PostData> arrayList) {
        this.eGB = arrayList;
    }

    public int aNF() {
        return this.eGC;
    }

    public void hC(int i) {
        this.eGC = i;
    }

    public int getTotalCount() {
        return this.aEJ;
    }

    public void setTotalCount(int i) {
        this.aEJ = i;
    }

    public int aQD() {
        return this.eGD;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.eGD = i;
        }
    }

    public int JG() {
        return this.mCurrentPage;
    }

    public void bX(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.eGz = forumData;
    }

    public ForumData aQE() {
        return this.eGz;
    }

    public void e(AntiData antiData) {
        this.eGF = antiData;
    }

    public AntiData aBC() {
        return this.eGF;
    }

    public void U(bl blVar) {
        this.bgF = blVar;
    }

    public boolean axT() {
        return (this.bgF == null || this.eGA == null || this.bgF.getAuthor() == null || this.bgF.getAuthor().getUserId() == null || this.eGA.getAuthor() == null || this.eGA.getAuthor().getUserId() == null || !this.bgF.getAuthor().getUserId().equals(this.eGA.getAuthor().getUserId())) ? false : true;
    }

    public boolean nL() {
        return this.eGG;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.eGC;
    }

    public bl MF() {
        return this.bgF;
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
