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
    private int aDV;
    private bh biZ;
    private AntiData eHA;
    public Error eHC;
    private ForumData eHu;
    private int mCurrentPage;
    private int eHy = 20;
    private int eHz = -1;
    private boolean eHB = false;
    private PostData eHv = null;
    private ArrayList<PostData> eHw = new ArrayList<>();
    private int eHx = 1;

    public Error aQF() {
        return this.eHC;
    }

    public PostData aQG() {
        return this.eHv;
    }

    public void d(PostData postData) {
        this.eHv = postData;
    }

    public int aQH() {
        if (this.eHz == -1) {
            this.eHz = this.mCurrentPage;
        }
        return this.eHz;
    }

    public int aQI() {
        return this.eHz;
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aEF());
            this.eHz = mVar.Km();
            b(mVar.aQN());
            setPageSize(mVar.aQM());
            M(mVar.NA());
            setTotalCount(mVar.getTotalCount());
            in(mVar.aQL());
            this.eHw.addAll(0, mVar.aQK());
        }
    }

    public void b(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aEF());
            b(mVar.aQN());
            d(mVar.aQG());
            M(mVar.NA());
            if (mVar.aQK() != null && mVar.aQK().size() > 0) {
                bX(mVar.Km());
                setPageSize(mVar.aQM());
                setTotalCount(mVar.getTotalCount());
                in(mVar.aQL());
            }
            int size = this.eHw.size();
            if (z && size % this.eHy != 0) {
                for (int i = 0; i < size % this.eHy; i++) {
                    this.eHw.remove(this.eHw.size() - 1);
                }
            }
            this.eHw.addAll(mVar.aQK());
        }
    }

    public void c(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aEF());
            b(mVar.aQN());
            d(mVar.aQG());
            M(mVar.NA());
            if (mVar.aQK() != null && mVar.aQK().size() > 0) {
                bX(mVar.Km());
                setPageSize(mVar.aQM());
                setTotalCount(mVar.getTotalCount());
                in(mVar.aQL());
            }
            int size = this.eHw.size();
            if (z && size % this.eHy != 0) {
                for (int i = 0; i < size % this.eHy; i++) {
                    this.eHw.remove(this.eHw.size() - 1);
                }
            }
            this.eHw.addAll(mVar.aQK());
            aQJ();
        }
    }

    public void d(m mVar, boolean z) {
        a(mVar, z);
    }

    public void a(m mVar) {
        if (mVar != null) {
            e(mVar.aEF());
            b(mVar.aQN());
            d(mVar.aQG());
            M(mVar.NA());
            if (mVar.aQK() != null && mVar.aQK().size() > 0) {
                bX(mVar.Km());
                setPageSize(mVar.aQM());
                setTotalCount(mVar.getTotalCount());
                in(mVar.aQL());
                this.eHz = (this.mCurrentPage - (((mVar.aQK().size() - 1) + this.eHy) / this.eHy)) + 1;
                if (this.eHz < 0) {
                    this.eHz = 0;
                }
            }
            this.eHw.addAll(mVar.aQK());
        }
    }

    public void aQJ() {
        if (this.eHz < 0) {
            this.eHz = this.mCurrentPage;
        } else if (this.eHz > this.mCurrentPage) {
            this.eHz = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aQK() {
        return this.eHw;
    }

    public void ah(ArrayList<PostData> arrayList) {
        this.eHw = arrayList;
    }

    public int aQL() {
        return this.eHx;
    }

    public void in(int i) {
        this.eHx = i;
    }

    public int getTotalCount() {
        return this.aDV;
    }

    public void setTotalCount(int i) {
        this.aDV = i;
    }

    public int aQM() {
        return this.eHy;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.eHy = i;
        }
    }

    public int Km() {
        return this.mCurrentPage;
    }

    public void bX(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.eHu = forumData;
    }

    public ForumData aQN() {
        return this.eHu;
    }

    public void e(AntiData antiData) {
        this.eHA = antiData;
    }

    public AntiData aEF() {
        return this.eHA;
    }

    public void M(bh bhVar) {
        this.biZ = bhVar;
    }

    public boolean aAU() {
        return (this.biZ == null || this.eHv == null || this.biZ.rt() == null || this.biZ.rt().getUserId() == null || this.eHv.rt() == null || this.eHv.rt().getUserId() == null || !this.biZ.rt().getUserId().equals(this.eHv.rt().getUserId())) ? false : true;
    }

    public boolean nC() {
        return this.eHB;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.eHx;
    }

    public bh NA() {
        return this.biZ;
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
                mVar.in(intValue);
            }
            return mVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
