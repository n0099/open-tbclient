package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class m {
    private int aDY;
    private bj bgF;
    private ForumData eFP;
    private AntiData eFV;
    public Error eFX;
    private int mCurrentPage;
    private int eFT = 20;
    private int eFU = -1;
    private boolean eFW = false;
    private PostData eFQ = null;
    private ArrayList<PostData> eFR = new ArrayList<>();
    private int eFS = 1;

    public Error aPP() {
        return this.eFX;
    }

    public PostData aPQ() {
        return this.eFQ;
    }

    public void f(PostData postData) {
        this.eFQ = postData;
    }

    public int aPR() {
        if (this.eFU == -1) {
            this.eFU = this.mCurrentPage;
        }
        return this.eFU;
    }

    public int aPS() {
        return this.eFU;
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aDx());
            this.eFU = mVar.JP();
            b(mVar.aPX());
            setPageSize(mVar.aPW());
            Z(mVar.MR());
            setTotalCount(mVar.getTotalCount());
            hP(mVar.aPV());
            this.eFR.addAll(0, mVar.aPU());
        }
    }

    public void b(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aDx());
            b(mVar.aPX());
            f(mVar.aPQ());
            Z(mVar.MR());
            if (mVar.aPU() != null && mVar.aPU().size() > 0) {
                bX(mVar.JP());
                setPageSize(mVar.aPW());
                setTotalCount(mVar.getTotalCount());
                hP(mVar.aPV());
            }
            int size = this.eFR.size();
            if (z && size % this.eFT != 0) {
                for (int i = 0; i < size % this.eFT; i++) {
                    this.eFR.remove(this.eFR.size() - 1);
                }
            }
            this.eFR.addAll(mVar.aPU());
        }
    }

    public void c(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aDx());
            b(mVar.aPX());
            f(mVar.aPQ());
            Z(mVar.MR());
            if (mVar.aPU() != null && mVar.aPU().size() > 0) {
                bX(mVar.JP());
                setPageSize(mVar.aPW());
                setTotalCount(mVar.getTotalCount());
                hP(mVar.aPV());
            }
            int size = this.eFR.size();
            if (z && size % this.eFT != 0) {
                for (int i = 0; i < size % this.eFT; i++) {
                    this.eFR.remove(this.eFR.size() - 1);
                }
            }
            this.eFR.addAll(mVar.aPU());
            aPT();
        }
    }

    public void d(m mVar, boolean z) {
        a(mVar, z);
    }

    public void a(m mVar) {
        if (mVar != null) {
            e(mVar.aDx());
            b(mVar.aPX());
            f(mVar.aPQ());
            Z(mVar.MR());
            if (mVar.aPU() != null && mVar.aPU().size() > 0) {
                bX(mVar.JP());
                setPageSize(mVar.aPW());
                setTotalCount(mVar.getTotalCount());
                hP(mVar.aPV());
                this.eFU = (this.mCurrentPage - (((mVar.aPU().size() - 1) + this.eFT) / this.eFT)) + 1;
                if (this.eFU < 0) {
                    this.eFU = 0;
                }
            }
            this.eFR.addAll(mVar.aPU());
        }
    }

    public void aPT() {
        if (this.eFU < 0) {
            this.eFU = this.mCurrentPage;
        } else if (this.eFU > this.mCurrentPage) {
            this.eFU = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aPU() {
        return this.eFR;
    }

    public void aj(ArrayList<PostData> arrayList) {
        this.eFR = arrayList;
    }

    public int aPV() {
        return this.eFS;
    }

    public void hP(int i) {
        this.eFS = i;
    }

    public int getTotalCount() {
        return this.aDY;
    }

    public void setTotalCount(int i) {
        this.aDY = i;
    }

    public int aPW() {
        return this.eFT;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.eFT = i;
        }
    }

    public int JP() {
        return this.mCurrentPage;
    }

    public void bX(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.eFP = forumData;
    }

    public ForumData aPX() {
        return this.eFP;
    }

    public void e(AntiData antiData) {
        this.eFV = antiData;
    }

    public AntiData aDx() {
        return this.eFV;
    }

    public void Z(bj bjVar) {
        this.bgF = bjVar;
    }

    public boolean azO() {
        return (this.bgF == null || this.eFQ == null || this.bgF.getAuthor() == null || this.bgF.getAuthor().getUserId() == null || this.eFQ.getAuthor() == null || this.eFQ.getAuthor().getUserId() == null || !this.bgF.getAuthor().getUserId().equals(this.eFQ.getAuthor().getUserId())) ? false : true;
    }

    public boolean nG() {
        return this.eFW;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.eFS;
    }

    public bj MR() {
        return this.bgF;
    }

    public static m a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            m mVar = new m();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            mVar.e(antiData);
            bj bjVar = new bj();
            bjVar.a(dataRes.thread);
            bjVar.bX(2);
            mVar.Z(bjVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            mVar.b(forumData);
            PostData postData = new PostData();
            postData.a(dataRes.post, context);
            mVar.f(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            mVar.aj(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            mVar.e(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                mVar.bX(intValue3);
                mVar.setPageSize(intValue2);
                mVar.setTotalCount(intValue4);
                mVar.hP(intValue);
            }
            return mVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
