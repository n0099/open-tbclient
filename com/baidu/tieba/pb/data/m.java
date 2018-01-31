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
public class m {
    private bd bXU;
    private int bsO;
    private ForumData fEJ;
    private AntiData fEP;
    public Error fER;
    private int mCurrentPage;
    private int fEN = 20;
    private int fEO = -1;
    private boolean fEQ = false;
    private PostData fEK = null;
    private ArrayList<PostData> fEL = new ArrayList<>();
    private int fEM = 1;

    public Error aZx() {
        return this.fER;
    }

    public PostData aZy() {
        return this.fEK;
    }

    public void d(PostData postData) {
        this.fEK = postData;
    }

    public int aZz() {
        if (this.fEO == -1) {
            this.fEO = this.mCurrentPage;
        }
        return this.fEO;
    }

    public int aZA() {
        return this.fEO;
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.aZG());
            this.fEO = mVar.RY();
            b(mVar.aZF());
            setPageSize(mVar.aZE());
            Q(mVar.VM());
            setTotalCount(mVar.getTotalCount());
            lN(mVar.aZD());
            this.fEL.addAll(0, mVar.aZC());
        }
    }

    public void b(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.aZG());
            b(mVar.aZF());
            d(mVar.aZy());
            Q(mVar.VM());
            if (mVar.aZC() != null && mVar.aZC().size() > 0) {
                eW(mVar.RY());
                setPageSize(mVar.aZE());
                setTotalCount(mVar.getTotalCount());
                lN(mVar.aZD());
            }
            int size = this.fEL.size();
            if (z && size % this.fEN != 0) {
                for (int i = 0; i < size % this.fEN; i++) {
                    this.fEL.remove(this.fEL.size() - 1);
                }
            }
            this.fEL.addAll(mVar.aZC());
        }
    }

    public void c(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.aZG());
            b(mVar.aZF());
            d(mVar.aZy());
            Q(mVar.VM());
            if (mVar.aZC() != null && mVar.aZC().size() > 0) {
                eW(mVar.RY());
                setPageSize(mVar.aZE());
                setTotalCount(mVar.getTotalCount());
                lN(mVar.aZD());
            }
            int size = this.fEL.size();
            if (z && size % this.fEN != 0) {
                for (int i = 0; i < size % this.fEN; i++) {
                    this.fEL.remove(this.fEL.size() - 1);
                }
            }
            this.fEL.addAll(mVar.aZC());
            aZB();
        }
    }

    public void d(m mVar, boolean z) {
        a(mVar, z);
    }

    public void a(m mVar) {
        if (mVar != null) {
            b(mVar.aZG());
            b(mVar.aZF());
            d(mVar.aZy());
            Q(mVar.VM());
            if (mVar.aZC() != null && mVar.aZC().size() > 0) {
                eW(mVar.RY());
                setPageSize(mVar.aZE());
                setTotalCount(mVar.getTotalCount());
                lN(mVar.aZD());
                this.fEO = (this.mCurrentPage - (((mVar.aZC().size() - 1) + this.fEN) / this.fEN)) + 1;
                if (this.fEO < 0) {
                    this.fEO = 0;
                }
            }
            this.fEL.addAll(mVar.aZC());
        }
    }

    public void aZB() {
        if (this.fEO < 0) {
            this.fEO = this.mCurrentPage;
        } else if (this.fEO > this.mCurrentPage) {
            this.fEO = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aZC() {
        return this.fEL;
    }

    public void aj(ArrayList<PostData> arrayList) {
        this.fEL = arrayList;
    }

    public int aZD() {
        return this.fEM;
    }

    public void lN(int i) {
        this.fEM = i;
    }

    public int getTotalCount() {
        return this.bsO;
    }

    public void setTotalCount(int i) {
        this.bsO = i;
    }

    public int aZE() {
        return this.fEN;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.fEN = i;
        }
    }

    public int RY() {
        return this.mCurrentPage;
    }

    public void eW(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.fEJ = forumData;
    }

    public ForumData aZF() {
        return this.fEJ;
    }

    public void b(AntiData antiData) {
        this.fEP = antiData;
    }

    public AntiData aZG() {
        return this.fEP;
    }

    public void Q(bd bdVar) {
        this.bXU = bdVar;
    }

    public boolean aJO() {
        return (this.bXU == null || this.fEK == null || this.bXU.yT() == null || this.bXU.yT().getUserId() == null || this.fEK.yT() == null || this.fEK.yT().getUserId() == null || !this.bXU.yT().getUserId().equals(this.fEK.yT().getUserId())) ? false : true;
    }

    public boolean vl() {
        return this.fEQ;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fEM;
    }

    public bd VM() {
        return this.bXU;
    }

    public static m a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            m mVar = new m();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            mVar.b(antiData);
            bd bdVar = new bd();
            bdVar.a(dataRes.thread);
            bdVar.eW(2);
            mVar.Q(bdVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            mVar.b(forumData);
            PostData postData = new PostData();
            postData.a(dataRes.post, context);
            mVar.d(postData);
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
            mVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                mVar.eW(intValue3);
                mVar.setPageSize(intValue2);
                mVar.setTotalCount(intValue4);
                mVar.lN(intValue);
            }
            return mVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
