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
    private bd bXM;
    private int bsF;
    private ForumData fEo;
    private AntiData fEu;
    public Error fEw;
    private int mCurrentPage;
    private int fEs = 20;
    private int fEt = -1;
    private boolean fEv = false;
    private PostData fEp = null;
    private ArrayList<PostData> fEq = new ArrayList<>();
    private int fEr = 1;

    public Error aZs() {
        return this.fEw;
    }

    public PostData aZt() {
        return this.fEp;
    }

    public void d(PostData postData) {
        this.fEp = postData;
    }

    public int aZu() {
        if (this.fEt == -1) {
            this.fEt = this.mCurrentPage;
        }
        return this.fEt;
    }

    public int aZv() {
        return this.fEt;
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.aZB());
            this.fEt = mVar.RW();
            b(mVar.aZA());
            setPageSize(mVar.aZz());
            Q(mVar.VK());
            setTotalCount(mVar.getTotalCount());
            lN(mVar.aZy());
            this.fEq.addAll(0, mVar.aZx());
        }
    }

    public void b(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.aZB());
            b(mVar.aZA());
            d(mVar.aZt());
            Q(mVar.VK());
            if (mVar.aZx() != null && mVar.aZx().size() > 0) {
                eW(mVar.RW());
                setPageSize(mVar.aZz());
                setTotalCount(mVar.getTotalCount());
                lN(mVar.aZy());
            }
            int size = this.fEq.size();
            if (z && size % this.fEs != 0) {
                for (int i = 0; i < size % this.fEs; i++) {
                    this.fEq.remove(this.fEq.size() - 1);
                }
            }
            this.fEq.addAll(mVar.aZx());
        }
    }

    public void c(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.aZB());
            b(mVar.aZA());
            d(mVar.aZt());
            Q(mVar.VK());
            if (mVar.aZx() != null && mVar.aZx().size() > 0) {
                eW(mVar.RW());
                setPageSize(mVar.aZz());
                setTotalCount(mVar.getTotalCount());
                lN(mVar.aZy());
            }
            int size = this.fEq.size();
            if (z && size % this.fEs != 0) {
                for (int i = 0; i < size % this.fEs; i++) {
                    this.fEq.remove(this.fEq.size() - 1);
                }
            }
            this.fEq.addAll(mVar.aZx());
            aZw();
        }
    }

    public void d(m mVar, boolean z) {
        a(mVar, z);
    }

    public void a(m mVar) {
        if (mVar != null) {
            b(mVar.aZB());
            b(mVar.aZA());
            d(mVar.aZt());
            Q(mVar.VK());
            if (mVar.aZx() != null && mVar.aZx().size() > 0) {
                eW(mVar.RW());
                setPageSize(mVar.aZz());
                setTotalCount(mVar.getTotalCount());
                lN(mVar.aZy());
                this.fEt = (this.mCurrentPage - (((mVar.aZx().size() - 1) + this.fEs) / this.fEs)) + 1;
                if (this.fEt < 0) {
                    this.fEt = 0;
                }
            }
            this.fEq.addAll(mVar.aZx());
        }
    }

    public void aZw() {
        if (this.fEt < 0) {
            this.fEt = this.mCurrentPage;
        } else if (this.fEt > this.mCurrentPage) {
            this.fEt = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aZx() {
        return this.fEq;
    }

    public void aj(ArrayList<PostData> arrayList) {
        this.fEq = arrayList;
    }

    public int aZy() {
        return this.fEr;
    }

    public void lN(int i) {
        this.fEr = i;
    }

    public int getTotalCount() {
        return this.bsF;
    }

    public void setTotalCount(int i) {
        this.bsF = i;
    }

    public int aZz() {
        return this.fEs;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.fEs = i;
        }
    }

    public int RW() {
        return this.mCurrentPage;
    }

    public void eW(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.fEo = forumData;
    }

    public ForumData aZA() {
        return this.fEo;
    }

    public void b(AntiData antiData) {
        this.fEu = antiData;
    }

    public AntiData aZB() {
        return this.fEu;
    }

    public void Q(bd bdVar) {
        this.bXM = bdVar;
    }

    public boolean aJJ() {
        return (this.bXM == null || this.fEp == null || this.bXM.yS() == null || this.bXM.yS().getUserId() == null || this.fEp.yS() == null || this.fEp.yS().getUserId() == null || !this.bXM.yS().getUserId().equals(this.fEp.yS().getUserId())) ? false : true;
    }

    public boolean vk() {
        return this.fEv;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fEr;
    }

    public bd VK() {
        return this.bXM;
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
