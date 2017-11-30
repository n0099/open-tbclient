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
    private int aEv;
    private bd bkp;
    private ForumData ePf;
    private AntiData ePl;
    public Error ePn;
    private int mCurrentPage;
    private int ePj = 20;
    private int ePk = -1;
    private boolean ePm = false;
    private PostData ePg = null;
    private ArrayList<PostData> ePh = new ArrayList<>();
    private int ePi = 1;

    public Error aRS() {
        return this.ePn;
    }

    public PostData aRT() {
        return this.ePg;
    }

    public void d(PostData postData) {
        this.ePg = postData;
    }

    public int aRU() {
        if (this.ePk == -1) {
            this.ePk = this.mCurrentPage;
        }
        return this.ePk;
    }

    public int aRV() {
        return this.ePk;
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.aSb());
            this.ePk = mVar.KJ();
            b(mVar.aSa());
            setPageSize(mVar.aRZ());
            P(mVar.Ox());
            setTotalCount(mVar.getTotalCount());
            iK(mVar.aRY());
            this.ePh.addAll(0, mVar.aRX());
        }
    }

    public void b(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.aSb());
            b(mVar.aSa());
            d(mVar.aRT());
            P(mVar.Ox());
            if (mVar.aRX() != null && mVar.aRX().size() > 0) {
                bY(mVar.KJ());
                setPageSize(mVar.aRZ());
                setTotalCount(mVar.getTotalCount());
                iK(mVar.aRY());
            }
            int size = this.ePh.size();
            if (z && size % this.ePj != 0) {
                for (int i = 0; i < size % this.ePj; i++) {
                    this.ePh.remove(this.ePh.size() - 1);
                }
            }
            this.ePh.addAll(mVar.aRX());
        }
    }

    public void c(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.aSb());
            b(mVar.aSa());
            d(mVar.aRT());
            P(mVar.Ox());
            if (mVar.aRX() != null && mVar.aRX().size() > 0) {
                bY(mVar.KJ());
                setPageSize(mVar.aRZ());
                setTotalCount(mVar.getTotalCount());
                iK(mVar.aRY());
            }
            int size = this.ePh.size();
            if (z && size % this.ePj != 0) {
                for (int i = 0; i < size % this.ePj; i++) {
                    this.ePh.remove(this.ePh.size() - 1);
                }
            }
            this.ePh.addAll(mVar.aRX());
            aRW();
        }
    }

    public void d(m mVar, boolean z) {
        a(mVar, z);
    }

    public void a(m mVar) {
        if (mVar != null) {
            b(mVar.aSb());
            b(mVar.aSa());
            d(mVar.aRT());
            P(mVar.Ox());
            if (mVar.aRX() != null && mVar.aRX().size() > 0) {
                bY(mVar.KJ());
                setPageSize(mVar.aRZ());
                setTotalCount(mVar.getTotalCount());
                iK(mVar.aRY());
                this.ePk = (this.mCurrentPage - (((mVar.aRX().size() - 1) + this.ePj) / this.ePj)) + 1;
                if (this.ePk < 0) {
                    this.ePk = 0;
                }
            }
            this.ePh.addAll(mVar.aRX());
        }
    }

    public void aRW() {
        if (this.ePk < 0) {
            this.ePk = this.mCurrentPage;
        } else if (this.ePk > this.mCurrentPage) {
            this.ePk = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aRX() {
        return this.ePh;
    }

    public void ah(ArrayList<PostData> arrayList) {
        this.ePh = arrayList;
    }

    public int aRY() {
        return this.ePi;
    }

    public void iK(int i) {
        this.ePi = i;
    }

    public int getTotalCount() {
        return this.aEv;
    }

    public void setTotalCount(int i) {
        this.aEv = i;
    }

    public int aRZ() {
        return this.ePj;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.ePj = i;
        }
    }

    public int KJ() {
        return this.mCurrentPage;
    }

    public void bY(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.ePf = forumData;
    }

    public ForumData aSa() {
        return this.ePf;
    }

    public void b(AntiData antiData) {
        this.ePl = antiData;
    }

    public AntiData aSb() {
        return this.ePl;
    }

    public void P(bd bdVar) {
        this.bkp = bdVar;
    }

    public boolean aCu() {
        return (this.bkp == null || this.ePg == null || this.bkp.rx() == null || this.bkp.rx().getUserId() == null || this.ePg.rx() == null || this.ePg.rx().getUserId() == null || !this.bkp.rx().getUserId().equals(this.ePg.rx().getUserId())) ? false : true;
    }

    public boolean nJ() {
        return this.ePm;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.ePi;
    }

    public bd Ox() {
        return this.bkp;
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
            mVar.P(bdVar);
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
                mVar.iK(intValue);
            }
            return mVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
