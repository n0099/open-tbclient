package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class m {
    private int aDN;
    private bh biQ;
    private ForumData eHa;
    private AntiData eHg;
    public Error eHi;
    private int mCurrentPage;
    private int eHe = 20;
    private int eHf = -1;
    private boolean eHh = false;
    private PostData eHb = null;
    private ArrayList<PostData> eHc = new ArrayList<>();
    private int eHd = 1;

    public Error aQx() {
        return this.eHi;
    }

    public PostData aQy() {
        return this.eHb;
    }

    public void d(PostData postData) {
        this.eHb = postData;
    }

    public int aQz() {
        if (this.eHf == -1) {
            this.eHf = this.mCurrentPage;
        }
        return this.eHf;
    }

    public int aQA() {
        return this.eHf;
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aEB());
            this.eHf = mVar.Kb();
            b(mVar.aQF());
            setPageSize(mVar.aQE());
            M(mVar.Np());
            setTotalCount(mVar.getTotalCount());
            ip(mVar.aQD());
            this.eHc.addAll(0, mVar.aQC());
        }
    }

    public void b(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aEB());
            b(mVar.aQF());
            d(mVar.aQy());
            M(mVar.Np());
            if (mVar.aQC() != null && mVar.aQC().size() > 0) {
                bX(mVar.Kb());
                setPageSize(mVar.aQE());
                setTotalCount(mVar.getTotalCount());
                ip(mVar.aQD());
            }
            int size = this.eHc.size();
            if (z && size % this.eHe != 0) {
                for (int i = 0; i < size % this.eHe; i++) {
                    this.eHc.remove(this.eHc.size() - 1);
                }
            }
            this.eHc.addAll(mVar.aQC());
        }
    }

    public void c(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aEB());
            b(mVar.aQF());
            d(mVar.aQy());
            M(mVar.Np());
            if (mVar.aQC() != null && mVar.aQC().size() > 0) {
                bX(mVar.Kb());
                setPageSize(mVar.aQE());
                setTotalCount(mVar.getTotalCount());
                ip(mVar.aQD());
            }
            int size = this.eHc.size();
            if (z && size % this.eHe != 0) {
                for (int i = 0; i < size % this.eHe; i++) {
                    this.eHc.remove(this.eHc.size() - 1);
                }
            }
            this.eHc.addAll(mVar.aQC());
            aQB();
        }
    }

    public void d(m mVar, boolean z) {
        a(mVar, z);
    }

    public void a(m mVar) {
        if (mVar != null) {
            e(mVar.aEB());
            b(mVar.aQF());
            d(mVar.aQy());
            M(mVar.Np());
            if (mVar.aQC() != null && mVar.aQC().size() > 0) {
                bX(mVar.Kb());
                setPageSize(mVar.aQE());
                setTotalCount(mVar.getTotalCount());
                ip(mVar.aQD());
                this.eHf = (this.mCurrentPage - (((mVar.aQC().size() - 1) + this.eHe) / this.eHe)) + 1;
                if (this.eHf < 0) {
                    this.eHf = 0;
                }
            }
            this.eHc.addAll(mVar.aQC());
        }
    }

    public void aQB() {
        if (this.eHf < 0) {
            this.eHf = this.mCurrentPage;
        } else if (this.eHf > this.mCurrentPage) {
            this.eHf = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aQC() {
        return this.eHc;
    }

    public void ah(ArrayList<PostData> arrayList) {
        this.eHc = arrayList;
    }

    public int aQD() {
        return this.eHd;
    }

    public void ip(int i) {
        this.eHd = i;
    }

    public int getTotalCount() {
        return this.aDN;
    }

    public void setTotalCount(int i) {
        this.aDN = i;
    }

    public int aQE() {
        return this.eHe;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.eHe = i;
        }
    }

    public int Kb() {
        return this.mCurrentPage;
    }

    public void bX(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.eHa = forumData;
    }

    public ForumData aQF() {
        return this.eHa;
    }

    public void e(AntiData antiData) {
        this.eHg = antiData;
    }

    public AntiData aEB() {
        return this.eHg;
    }

    public void M(bh bhVar) {
        this.biQ = bhVar;
    }

    public boolean aAQ() {
        return (this.biQ == null || this.eHb == null || this.biQ.rt() == null || this.biQ.rt().getUserId() == null || this.eHb.rt() == null || this.eHb.rt().getUserId() == null || !this.biQ.rt().getUserId().equals(this.eHb.rt().getUserId())) ? false : true;
    }

    public boolean nC() {
        return this.eHh;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.eHd;
    }

    public bh Np() {
        return this.biQ;
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
            bh bhVar = new bh();
            bhVar.a(dataRes.thread);
            bhVar.bX(2);
            mVar.M(bhVar);
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
            mVar.ah(arrayList);
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
                mVar.ip(intValue);
            }
            return mVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
