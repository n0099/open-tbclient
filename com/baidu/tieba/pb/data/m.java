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
    private int aDc;
    private bh bie;
    private ForumData eyX;
    private AntiData ezd;
    public Error ezf;
    private int mCurrentPage;
    private int ezb = 20;
    private int ezc = -1;
    private boolean eze = false;
    private PostData eyY = null;
    private ArrayList<PostData> eyZ = new ArrayList<>();
    private int eza = 1;

    public Error aNE() {
        return this.ezf;
    }

    public PostData aNF() {
        return this.eyY;
    }

    public void e(PostData postData) {
        this.eyY = postData;
    }

    public int aNG() {
        if (this.ezc == -1) {
            this.ezc = this.mCurrentPage;
        }
        return this.ezc;
    }

    public int aNH() {
        return this.ezc;
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aCg());
            this.ezc = mVar.JS();
            b(mVar.aNM());
            setPageSize(mVar.aNL());
            U(mVar.Nd());
            setTotalCount(mVar.getTotalCount());
            hW(mVar.aNK());
            this.eyZ.addAll(0, mVar.aNJ());
        }
    }

    public void b(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aCg());
            b(mVar.aNM());
            e(mVar.aNF());
            U(mVar.Nd());
            if (mVar.aNJ() != null && mVar.aNJ().size() > 0) {
                bX(mVar.JS());
                setPageSize(mVar.aNL());
                setTotalCount(mVar.getTotalCount());
                hW(mVar.aNK());
            }
            int size = this.eyZ.size();
            if (z && size % this.ezb != 0) {
                for (int i = 0; i < size % this.ezb; i++) {
                    this.eyZ.remove(this.eyZ.size() - 1);
                }
            }
            this.eyZ.addAll(mVar.aNJ());
        }
    }

    public void c(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aCg());
            b(mVar.aNM());
            e(mVar.aNF());
            U(mVar.Nd());
            if (mVar.aNJ() != null && mVar.aNJ().size() > 0) {
                bX(mVar.JS());
                setPageSize(mVar.aNL());
                setTotalCount(mVar.getTotalCount());
                hW(mVar.aNK());
            }
            int size = this.eyZ.size();
            if (z && size % this.ezb != 0) {
                for (int i = 0; i < size % this.ezb; i++) {
                    this.eyZ.remove(this.eyZ.size() - 1);
                }
            }
            this.eyZ.addAll(mVar.aNJ());
            aNI();
        }
    }

    public void d(m mVar, boolean z) {
        a(mVar, z);
    }

    public void a(m mVar) {
        if (mVar != null) {
            e(mVar.aCg());
            b(mVar.aNM());
            e(mVar.aNF());
            U(mVar.Nd());
            if (mVar.aNJ() != null && mVar.aNJ().size() > 0) {
                bX(mVar.JS());
                setPageSize(mVar.aNL());
                setTotalCount(mVar.getTotalCount());
                hW(mVar.aNK());
                this.ezc = (this.mCurrentPage - (((mVar.aNJ().size() - 1) + this.ezb) / this.ezb)) + 1;
                if (this.ezc < 0) {
                    this.ezc = 0;
                }
            }
            this.eyZ.addAll(mVar.aNJ());
        }
    }

    public void aNI() {
        if (this.ezc < 0) {
            this.ezc = this.mCurrentPage;
        } else if (this.ezc > this.mCurrentPage) {
            this.ezc = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aNJ() {
        return this.eyZ;
    }

    public void ah(ArrayList<PostData> arrayList) {
        this.eyZ = arrayList;
    }

    public int aNK() {
        return this.eza;
    }

    public void hW(int i) {
        this.eza = i;
    }

    public int getTotalCount() {
        return this.aDc;
    }

    public void setTotalCount(int i) {
        this.aDc = i;
    }

    public int aNL() {
        return this.ezb;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.ezb = i;
        }
    }

    public int JS() {
        return this.mCurrentPage;
    }

    public void bX(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.eyX = forumData;
    }

    public ForumData aNM() {
        return this.eyX;
    }

    public void e(AntiData antiData) {
        this.ezd = antiData;
    }

    public AntiData aCg() {
        return this.ezd;
    }

    public void U(bh bhVar) {
        this.bie = bhVar;
    }

    public boolean ayv() {
        return (this.bie == null || this.eyY == null || this.bie.getAuthor() == null || this.bie.getAuthor().getUserId() == null || this.eyY.getAuthor() == null || this.eyY.getAuthor().getUserId() == null || !this.bie.getAuthor().getUserId().equals(this.eyY.getAuthor().getUserId())) ? false : true;
    }

    public boolean nz() {
        return this.eze;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.eza;
    }

    public bh Nd() {
        return this.bie;
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
                mVar.bX(intValue3);
                mVar.setPageSize(intValue2);
                mVar.setTotalCount(intValue4);
                mVar.hW(intValue);
            }
            return mVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
