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
/* loaded from: classes.dex */
public class m {
    private int aEA;
    private bd bkq;
    private ForumData eQi;
    private AntiData eQo;
    public Error eQq;
    private int mCurrentPage;
    private int eQm = 20;
    private int eQn = -1;
    private boolean eQp = false;
    private PostData eQj = null;
    private ArrayList<PostData> eQk = new ArrayList<>();
    private int eQl = 1;

    public Error aSb() {
        return this.eQq;
    }

    public PostData aSc() {
        return this.eQj;
    }

    public void d(PostData postData) {
        this.eQj = postData;
    }

    public int aSd() {
        if (this.eQn == -1) {
            this.eQn = this.mCurrentPage;
        }
        return this.eQn;
    }

    public int aSe() {
        return this.eQn;
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.aSk());
            this.eQn = mVar.KJ();
            b(mVar.aSj());
            setPageSize(mVar.aSi());
            R(mVar.Ox());
            setTotalCount(mVar.getTotalCount());
            iM(mVar.aSh());
            this.eQk.addAll(0, mVar.aSg());
        }
    }

    public void b(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.aSk());
            b(mVar.aSj());
            d(mVar.aSc());
            R(mVar.Ox());
            if (mVar.aSg() != null && mVar.aSg().size() > 0) {
                bY(mVar.KJ());
                setPageSize(mVar.aSi());
                setTotalCount(mVar.getTotalCount());
                iM(mVar.aSh());
            }
            int size = this.eQk.size();
            if (z && size % this.eQm != 0) {
                for (int i = 0; i < size % this.eQm; i++) {
                    this.eQk.remove(this.eQk.size() - 1);
                }
            }
            this.eQk.addAll(mVar.aSg());
        }
    }

    public void c(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.aSk());
            b(mVar.aSj());
            d(mVar.aSc());
            R(mVar.Ox());
            if (mVar.aSg() != null && mVar.aSg().size() > 0) {
                bY(mVar.KJ());
                setPageSize(mVar.aSi());
                setTotalCount(mVar.getTotalCount());
                iM(mVar.aSh());
            }
            int size = this.eQk.size();
            if (z && size % this.eQm != 0) {
                for (int i = 0; i < size % this.eQm; i++) {
                    this.eQk.remove(this.eQk.size() - 1);
                }
            }
            this.eQk.addAll(mVar.aSg());
            aSf();
        }
    }

    public void d(m mVar, boolean z) {
        a(mVar, z);
    }

    public void a(m mVar) {
        if (mVar != null) {
            b(mVar.aSk());
            b(mVar.aSj());
            d(mVar.aSc());
            R(mVar.Ox());
            if (mVar.aSg() != null && mVar.aSg().size() > 0) {
                bY(mVar.KJ());
                setPageSize(mVar.aSi());
                setTotalCount(mVar.getTotalCount());
                iM(mVar.aSh());
                this.eQn = (this.mCurrentPage - (((mVar.aSg().size() - 1) + this.eQm) / this.eQm)) + 1;
                if (this.eQn < 0) {
                    this.eQn = 0;
                }
            }
            this.eQk.addAll(mVar.aSg());
        }
    }

    public void aSf() {
        if (this.eQn < 0) {
            this.eQn = this.mCurrentPage;
        } else if (this.eQn > this.mCurrentPage) {
            this.eQn = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aSg() {
        return this.eQk;
    }

    public void ai(ArrayList<PostData> arrayList) {
        this.eQk = arrayList;
    }

    public int aSh() {
        return this.eQl;
    }

    public void iM(int i) {
        this.eQl = i;
    }

    public int getTotalCount() {
        return this.aEA;
    }

    public void setTotalCount(int i) {
        this.aEA = i;
    }

    public int aSi() {
        return this.eQm;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.eQm = i;
        }
    }

    public int KJ() {
        return this.mCurrentPage;
    }

    public void bY(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.eQi = forumData;
    }

    public ForumData aSj() {
        return this.eQi;
    }

    public void b(AntiData antiData) {
        this.eQo = antiData;
    }

    public AntiData aSk() {
        return this.eQo;
    }

    public void R(bd bdVar) {
        this.bkq = bdVar;
    }

    public boolean aCD() {
        return (this.bkq == null || this.eQj == null || this.bkq.rv() == null || this.bkq.rv().getUserId() == null || this.eQj.rv() == null || this.eQj.rv().getUserId() == null || !this.bkq.rv().getUserId().equals(this.eQj.rv().getUserId())) ? false : true;
    }

    public boolean nH() {
        return this.eQp;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.eQl;
    }

    public bd Ox() {
        return this.bkq;
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
            bdVar.bY(2);
            mVar.R(bdVar);
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
            mVar.ai(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            mVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                mVar.bY(intValue3);
                mVar.setPageSize(intValue2);
                mVar.setTotalCount(intValue4);
                mVar.iM(intValue);
            }
            return mVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
