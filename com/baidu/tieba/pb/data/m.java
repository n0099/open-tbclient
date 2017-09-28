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
    private int aDp;
    private bh bit;
    private ForumData ezl;
    private AntiData ezr;
    public Error ezt;
    private int mCurrentPage;
    private int ezp = 20;
    private int ezq = -1;
    private boolean ezs = false;
    private PostData ezm = null;
    private ArrayList<PostData> ezn = new ArrayList<>();
    private int ezo = 1;

    public Error aNJ() {
        return this.ezt;
    }

    public PostData aNK() {
        return this.ezm;
    }

    public void e(PostData postData) {
        this.ezm = postData;
    }

    public int aNL() {
        if (this.ezq == -1) {
            this.ezq = this.mCurrentPage;
        }
        return this.ezq;
    }

    public int aNM() {
        return this.ezq;
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aCl());
            this.ezq = mVar.JY();
            b(mVar.aNR());
            setPageSize(mVar.aNQ());
            U(mVar.Nj());
            setTotalCount(mVar.getTotalCount());
            hX(mVar.aNP());
            this.ezn.addAll(0, mVar.aNO());
        }
    }

    public void b(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aCl());
            b(mVar.aNR());
            e(mVar.aNK());
            U(mVar.Nj());
            if (mVar.aNO() != null && mVar.aNO().size() > 0) {
                bY(mVar.JY());
                setPageSize(mVar.aNQ());
                setTotalCount(mVar.getTotalCount());
                hX(mVar.aNP());
            }
            int size = this.ezn.size();
            if (z && size % this.ezp != 0) {
                for (int i = 0; i < size % this.ezp; i++) {
                    this.ezn.remove(this.ezn.size() - 1);
                }
            }
            this.ezn.addAll(mVar.aNO());
        }
    }

    public void c(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aCl());
            b(mVar.aNR());
            e(mVar.aNK());
            U(mVar.Nj());
            if (mVar.aNO() != null && mVar.aNO().size() > 0) {
                bY(mVar.JY());
                setPageSize(mVar.aNQ());
                setTotalCount(mVar.getTotalCount());
                hX(mVar.aNP());
            }
            int size = this.ezn.size();
            if (z && size % this.ezp != 0) {
                for (int i = 0; i < size % this.ezp; i++) {
                    this.ezn.remove(this.ezn.size() - 1);
                }
            }
            this.ezn.addAll(mVar.aNO());
            aNN();
        }
    }

    public void d(m mVar, boolean z) {
        a(mVar, z);
    }

    public void a(m mVar) {
        if (mVar != null) {
            e(mVar.aCl());
            b(mVar.aNR());
            e(mVar.aNK());
            U(mVar.Nj());
            if (mVar.aNO() != null && mVar.aNO().size() > 0) {
                bY(mVar.JY());
                setPageSize(mVar.aNQ());
                setTotalCount(mVar.getTotalCount());
                hX(mVar.aNP());
                this.ezq = (this.mCurrentPage - (((mVar.aNO().size() - 1) + this.ezp) / this.ezp)) + 1;
                if (this.ezq < 0) {
                    this.ezq = 0;
                }
            }
            this.ezn.addAll(mVar.aNO());
        }
    }

    public void aNN() {
        if (this.ezq < 0) {
            this.ezq = this.mCurrentPage;
        } else if (this.ezq > this.mCurrentPage) {
            this.ezq = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aNO() {
        return this.ezn;
    }

    public void ah(ArrayList<PostData> arrayList) {
        this.ezn = arrayList;
    }

    public int aNP() {
        return this.ezo;
    }

    public void hX(int i) {
        this.ezo = i;
    }

    public int getTotalCount() {
        return this.aDp;
    }

    public void setTotalCount(int i) {
        this.aDp = i;
    }

    public int aNQ() {
        return this.ezp;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.ezp = i;
        }
    }

    public int JY() {
        return this.mCurrentPage;
    }

    public void bY(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.ezl = forumData;
    }

    public ForumData aNR() {
        return this.ezl;
    }

    public void e(AntiData antiData) {
        this.ezr = antiData;
    }

    public AntiData aCl() {
        return this.ezr;
    }

    public void U(bh bhVar) {
        this.bit = bhVar;
    }

    public boolean ayA() {
        return (this.bit == null || this.ezm == null || this.bit.getAuthor() == null || this.bit.getAuthor().getUserId() == null || this.ezm.getAuthor() == null || this.ezm.getAuthor().getUserId() == null || !this.bit.getAuthor().getUserId().equals(this.ezm.getAuthor().getUserId())) ? false : true;
    }

    public boolean nG() {
        return this.ezs;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.ezo;
    }

    public bh Nj() {
        return this.bit;
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
            bhVar.bY(2);
            mVar.U(bhVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            mVar.b(forumData);
            PostData postData = new PostData();
            postData.a(dataRes.post, context);
            mVar.e(postData);
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
                mVar.bY(intValue3);
                mVar.setPageSize(intValue2);
                mVar.setTotalCount(intValue4);
                mVar.hX(intValue);
            }
            return mVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
