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
    private int aEI;
    private bl bgF;
    private ForumData eEF;
    private AntiData eEL;
    public Error eEN;
    private int mCurrentPage;
    private int eEJ = 20;
    private int eEK = -1;
    private boolean eEM = false;
    private PostData eEG = null;
    private ArrayList<PostData> eEH = new ArrayList<>();
    private int eEI = 1;

    public Error aPQ() {
        return this.eEN;
    }

    public PostData aPR() {
        return this.eEG;
    }

    public void f(PostData postData) {
        this.eEG = postData;
    }

    public int aPS() {
        if (this.eEK == -1) {
            this.eEK = this.mCurrentPage;
        }
        return this.eEK;
    }

    public int aPT() {
        return this.eEK;
    }

    public void a(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.aAV());
            this.eEK = nVar.JG();
            b(nVar.aPX());
            setPageSize(nVar.aPW());
            U(nVar.MF());
            setTotalCount(nVar.getTotalCount());
            hB(nVar.aMY());
            this.eEH.addAll(0, nVar.aPV());
        }
    }

    public void b(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.aAV());
            b(nVar.aPX());
            f(nVar.aPR());
            U(nVar.MF());
            if (nVar.aPV() != null && nVar.aPV().size() > 0) {
                bX(nVar.JG());
                setPageSize(nVar.aPW());
                setTotalCount(nVar.getTotalCount());
                hB(nVar.aMY());
            }
            int size = this.eEH.size();
            if (z && size % this.eEJ != 0) {
                for (int i = 0; i < size % this.eEJ; i++) {
                    this.eEH.remove(this.eEH.size() - 1);
                }
            }
            this.eEH.addAll(nVar.aPV());
        }
    }

    public void c(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.aAV());
            b(nVar.aPX());
            f(nVar.aPR());
            U(nVar.MF());
            if (nVar.aPV() != null && nVar.aPV().size() > 0) {
                bX(nVar.JG());
                setPageSize(nVar.aPW());
                setTotalCount(nVar.getTotalCount());
                hB(nVar.aMY());
            }
            int size = this.eEH.size();
            if (z && size % this.eEJ != 0) {
                for (int i = 0; i < size % this.eEJ; i++) {
                    this.eEH.remove(this.eEH.size() - 1);
                }
            }
            this.eEH.addAll(nVar.aPV());
            aPU();
        }
    }

    public void d(n nVar, boolean z) {
        a(nVar, z);
    }

    public void a(n nVar) {
        if (nVar != null) {
            e(nVar.aAV());
            b(nVar.aPX());
            f(nVar.aPR());
            U(nVar.MF());
            if (nVar.aPV() != null && nVar.aPV().size() > 0) {
                bX(nVar.JG());
                setPageSize(nVar.aPW());
                setTotalCount(nVar.getTotalCount());
                hB(nVar.aMY());
                this.eEK = (this.mCurrentPage - (((nVar.aPV().size() - 1) + this.eEJ) / this.eEJ)) + 1;
                if (this.eEK < 0) {
                    this.eEK = 0;
                }
            }
            this.eEH.addAll(nVar.aPV());
        }
    }

    public void aPU() {
        if (this.eEK < 0) {
            this.eEK = this.mCurrentPage;
        } else if (this.eEK > this.mCurrentPage) {
            this.eEK = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aPV() {
        return this.eEH;
    }

    public void ak(ArrayList<PostData> arrayList) {
        this.eEH = arrayList;
    }

    public int aMY() {
        return this.eEI;
    }

    public void hB(int i) {
        this.eEI = i;
    }

    public int getTotalCount() {
        return this.aEI;
    }

    public void setTotalCount(int i) {
        this.aEI = i;
    }

    public int aPW() {
        return this.eEJ;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.eEJ = i;
        }
    }

    public int JG() {
        return this.mCurrentPage;
    }

    public void bX(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.eEF = forumData;
    }

    public ForumData aPX() {
        return this.eEF;
    }

    public void e(AntiData antiData) {
        this.eEL = antiData;
    }

    public AntiData aAV() {
        return this.eEL;
    }

    public void U(bl blVar) {
        this.bgF = blVar;
    }

    public boolean axm() {
        return (this.bgF == null || this.eEG == null || this.bgF.getAuthor() == null || this.bgF.getAuthor().getUserId() == null || this.eEG.getAuthor() == null || this.eEG.getAuthor().getUserId() == null || !this.bgF.getAuthor().getUserId().equals(this.eEG.getAuthor().getUserId())) ? false : true;
    }

    public boolean nL() {
        return this.eEM;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.eEI;
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
                nVar.hB(intValue);
            }
            return nVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
