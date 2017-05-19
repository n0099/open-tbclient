package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class l {
    private int aBB;
    private bk aSs;
    private ForumData edL;
    private AntiData edR;
    public Error edT;
    private int mCurrentPage;
    private int edP = 20;
    private int edQ = -1;
    private boolean edS = false;
    private PostData edM = null;
    private ArrayList<PostData> edN = new ArrayList<>();
    private int edO = 1;

    public Error aIq() {
        return this.edT;
    }

    public PostData aIr() {
        return this.edM;
    }

    public void d(PostData postData) {
        this.edM = postData;
    }

    public int aIs() {
        if (this.edQ == -1) {
            this.edQ = this.mCurrentPage;
        }
        return this.edQ;
    }

    public int aIt() {
        return this.edQ;
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            e(lVar.aup());
            this.edQ = lVar.IU();
            b(lVar.aIx());
            setPageSize(lVar.aIw());
            m(lVar.JB());
            setTotalCount(lVar.getTotalCount());
            gT(lVar.aFu());
            this.edN.addAll(0, lVar.aIv());
        }
    }

    public void b(l lVar, boolean z) {
        if (lVar != null) {
            e(lVar.aup());
            b(lVar.aIx());
            d(lVar.aIr());
            m(lVar.JB());
            if (lVar.aIv() != null && lVar.aIv().size() > 0) {
                bV(lVar.IU());
                setPageSize(lVar.aIw());
                setTotalCount(lVar.getTotalCount());
                gT(lVar.aFu());
            }
            int size = this.edN.size();
            if (z && size % this.edP != 0) {
                for (int i = 0; i < size % this.edP; i++) {
                    this.edN.remove(this.edN.size() - 1);
                }
            }
            this.edN.addAll(lVar.aIv());
        }
    }

    public void c(l lVar, boolean z) {
        if (lVar != null) {
            e(lVar.aup());
            b(lVar.aIx());
            d(lVar.aIr());
            m(lVar.JB());
            if (lVar.aIv() != null && lVar.aIv().size() > 0) {
                bV(lVar.IU());
                setPageSize(lVar.aIw());
                setTotalCount(lVar.getTotalCount());
                gT(lVar.aFu());
            }
            int size = this.edN.size();
            if (z && size % this.edP != 0) {
                for (int i = 0; i < size % this.edP; i++) {
                    this.edN.remove(this.edN.size() - 1);
                }
            }
            this.edN.addAll(lVar.aIv());
            aIu();
        }
    }

    public void d(l lVar, boolean z) {
        a(lVar, z);
    }

    public void a(l lVar) {
        if (lVar != null) {
            e(lVar.aup());
            b(lVar.aIx());
            d(lVar.aIr());
            m(lVar.JB());
            if (lVar.aIv() != null && lVar.aIv().size() > 0) {
                bV(lVar.IU());
                setPageSize(lVar.aIw());
                setTotalCount(lVar.getTotalCount());
                gT(lVar.aFu());
                this.edQ = (this.mCurrentPage - (((lVar.aIv().size() - 1) + this.edP) / this.edP)) + 1;
                if (this.edQ < 0) {
                    this.edQ = 0;
                }
            }
            this.edN.addAll(lVar.aIv());
        }
    }

    public void aIu() {
        if (this.edQ < 0) {
            this.edQ = this.mCurrentPage;
        } else if (this.edQ > this.mCurrentPage) {
            this.edQ = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aIv() {
        return this.edN;
    }

    public void ai(ArrayList<PostData> arrayList) {
        this.edN = arrayList;
    }

    public int aFu() {
        return this.edO;
    }

    public void gT(int i) {
        this.edO = i;
    }

    public int getTotalCount() {
        return this.aBB;
    }

    public void setTotalCount(int i) {
        this.aBB = i;
    }

    public int aIw() {
        return this.edP;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.edP = i;
        }
    }

    public int IU() {
        return this.mCurrentPage;
    }

    public void bV(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.edL = forumData;
    }

    public ForumData aIx() {
        return this.edL;
    }

    public void e(AntiData antiData) {
        this.edR = antiData;
    }

    public AntiData aup() {
        return this.edR;
    }

    public void m(bk bkVar) {
        this.aSs = bkVar;
    }

    public boolean aqM() {
        return (this.aSs == null || this.edM == null || this.aSs.getAuthor() == null || this.aSs.getAuthor().getUserId() == null || this.edM.getAuthor() == null || this.edM.getAuthor().getUserId() == null || !this.aSs.getAuthor().getUserId().equals(this.edM.getAuthor().getUserId())) ? false : true;
    }

    public boolean nL() {
        return this.edS;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.edO;
    }

    public bk JB() {
        return this.aSs;
    }

    public static l a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            l lVar = new l();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            lVar.e(antiData);
            bk bkVar = new bk();
            bkVar.a(dataRes.thread);
            bkVar.bV(2);
            lVar.m(bkVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            lVar.b(forumData);
            PostData postData = new PostData();
            postData.a(dataRes.post, context);
            lVar.d(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            lVar.ai(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            lVar.e(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                lVar.bV(intValue3);
                lVar.setPageSize(intValue2);
                lVar.setTotalCount(intValue4);
                lVar.gT(intValue);
            }
            return lVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
