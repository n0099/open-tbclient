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
    private int aED;
    private bd bku;
    private ForumData eQn;
    private AntiData eQt;
    public Error eQv;
    private int mCurrentPage;
    private int eQr = 20;
    private int eQs = -1;
    private boolean eQu = false;
    private PostData eQo = null;
    private ArrayList<PostData> eQp = new ArrayList<>();
    private int eQq = 1;

    public Error aSb() {
        return this.eQv;
    }

    public PostData aSc() {
        return this.eQo;
    }

    public void d(PostData postData) {
        this.eQo = postData;
    }

    public int aSd() {
        if (this.eQs == -1) {
            this.eQs = this.mCurrentPage;
        }
        return this.eQs;
    }

    public int aSe() {
        return this.eQs;
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.aSk());
            this.eQs = mVar.KJ();
            b(mVar.aSj());
            setPageSize(mVar.aSi());
            R(mVar.Ox());
            setTotalCount(mVar.getTotalCount());
            iM(mVar.aSh());
            this.eQp.addAll(0, mVar.aSg());
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
            int size = this.eQp.size();
            if (z && size % this.eQr != 0) {
                for (int i = 0; i < size % this.eQr; i++) {
                    this.eQp.remove(this.eQp.size() - 1);
                }
            }
            this.eQp.addAll(mVar.aSg());
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
            int size = this.eQp.size();
            if (z && size % this.eQr != 0) {
                for (int i = 0; i < size % this.eQr; i++) {
                    this.eQp.remove(this.eQp.size() - 1);
                }
            }
            this.eQp.addAll(mVar.aSg());
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
                this.eQs = (this.mCurrentPage - (((mVar.aSg().size() - 1) + this.eQr) / this.eQr)) + 1;
                if (this.eQs < 0) {
                    this.eQs = 0;
                }
            }
            this.eQp.addAll(mVar.aSg());
        }
    }

    public void aSf() {
        if (this.eQs < 0) {
            this.eQs = this.mCurrentPage;
        } else if (this.eQs > this.mCurrentPage) {
            this.eQs = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aSg() {
        return this.eQp;
    }

    public void ai(ArrayList<PostData> arrayList) {
        this.eQp = arrayList;
    }

    public int aSh() {
        return this.eQq;
    }

    public void iM(int i) {
        this.eQq = i;
    }

    public int getTotalCount() {
        return this.aED;
    }

    public void setTotalCount(int i) {
        this.aED = i;
    }

    public int aSi() {
        return this.eQr;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.eQr = i;
        }
    }

    public int KJ() {
        return this.mCurrentPage;
    }

    public void bY(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.eQn = forumData;
    }

    public ForumData aSj() {
        return this.eQn;
    }

    public void b(AntiData antiData) {
        this.eQt = antiData;
    }

    public AntiData aSk() {
        return this.eQt;
    }

    public void R(bd bdVar) {
        this.bku = bdVar;
    }

    public boolean aCD() {
        return (this.bku == null || this.eQo == null || this.bku.rv() == null || this.bku.rv().getUserId() == null || this.eQo.rv() == null || this.eQo.rv().getUserId() == null || !this.bku.rv().getUserId().equals(this.eQo.rv().getUserId())) ? false : true;
    }

    public boolean nH() {
        return this.eQu;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.eQq;
    }

    public bd Ox() {
        return this.bku;
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
