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
    private int aEb;
    private bj bgI;
    private ForumData eEV;
    private AntiData eFb;
    public Error eFd;
    private int mCurrentPage;
    private int eEZ = 20;
    private int eFa = -1;
    private boolean eFc = false;
    private PostData eEW = null;
    private ArrayList<PostData> eEX = new ArrayList<>();
    private int eEY = 1;

    public Error aPE() {
        return this.eFd;
    }

    public PostData aPF() {
        return this.eEW;
    }

    public void f(PostData postData) {
        this.eEW = postData;
    }

    public int aPG() {
        if (this.eFa == -1) {
            this.eFa = this.mCurrentPage;
        }
        return this.eFa;
    }

    public int aPH() {
        return this.eFa;
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aDm());
            this.eFa = mVar.JP();
            b(mVar.aPM());
            setPageSize(mVar.aPL());
            Z(mVar.MR());
            setTotalCount(mVar.getTotalCount());
            hN(mVar.aPK());
            this.eEX.addAll(0, mVar.aPJ());
        }
    }

    public void b(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aDm());
            b(mVar.aPM());
            f(mVar.aPF());
            Z(mVar.MR());
            if (mVar.aPJ() != null && mVar.aPJ().size() > 0) {
                bX(mVar.JP());
                setPageSize(mVar.aPL());
                setTotalCount(mVar.getTotalCount());
                hN(mVar.aPK());
            }
            int size = this.eEX.size();
            if (z && size % this.eEZ != 0) {
                for (int i = 0; i < size % this.eEZ; i++) {
                    this.eEX.remove(this.eEX.size() - 1);
                }
            }
            this.eEX.addAll(mVar.aPJ());
        }
    }

    public void c(m mVar, boolean z) {
        if (mVar != null) {
            e(mVar.aDm());
            b(mVar.aPM());
            f(mVar.aPF());
            Z(mVar.MR());
            if (mVar.aPJ() != null && mVar.aPJ().size() > 0) {
                bX(mVar.JP());
                setPageSize(mVar.aPL());
                setTotalCount(mVar.getTotalCount());
                hN(mVar.aPK());
            }
            int size = this.eEX.size();
            if (z && size % this.eEZ != 0) {
                for (int i = 0; i < size % this.eEZ; i++) {
                    this.eEX.remove(this.eEX.size() - 1);
                }
            }
            this.eEX.addAll(mVar.aPJ());
            aPI();
        }
    }

    public void d(m mVar, boolean z) {
        a(mVar, z);
    }

    public void a(m mVar) {
        if (mVar != null) {
            e(mVar.aDm());
            b(mVar.aPM());
            f(mVar.aPF());
            Z(mVar.MR());
            if (mVar.aPJ() != null && mVar.aPJ().size() > 0) {
                bX(mVar.JP());
                setPageSize(mVar.aPL());
                setTotalCount(mVar.getTotalCount());
                hN(mVar.aPK());
                this.eFa = (this.mCurrentPage - (((mVar.aPJ().size() - 1) + this.eEZ) / this.eEZ)) + 1;
                if (this.eFa < 0) {
                    this.eFa = 0;
                }
            }
            this.eEX.addAll(mVar.aPJ());
        }
    }

    public void aPI() {
        if (this.eFa < 0) {
            this.eFa = this.mCurrentPage;
        } else if (this.eFa > this.mCurrentPage) {
            this.eFa = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aPJ() {
        return this.eEX;
    }

    public void aj(ArrayList<PostData> arrayList) {
        this.eEX = arrayList;
    }

    public int aPK() {
        return this.eEY;
    }

    public void hN(int i) {
        this.eEY = i;
    }

    public int getTotalCount() {
        return this.aEb;
    }

    public void setTotalCount(int i) {
        this.aEb = i;
    }

    public int aPL() {
        return this.eEZ;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.eEZ = i;
        }
    }

    public int JP() {
        return this.mCurrentPage;
    }

    public void bX(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.eEV = forumData;
    }

    public ForumData aPM() {
        return this.eEV;
    }

    public void e(AntiData antiData) {
        this.eFb = antiData;
    }

    public AntiData aDm() {
        return this.eFb;
    }

    public void Z(bj bjVar) {
        this.bgI = bjVar;
    }

    public boolean azD() {
        return (this.bgI == null || this.eEW == null || this.bgI.getAuthor() == null || this.bgI.getAuthor().getUserId() == null || this.eEW.getAuthor() == null || this.eEW.getAuthor().getUserId() == null || !this.bgI.getAuthor().getUserId().equals(this.eEW.getAuthor().getUserId())) ? false : true;
    }

    public boolean nG() {
        return this.eFc;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.eEY;
    }

    public bj MR() {
        return this.bgI;
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
                mVar.hN(intValue);
            }
            return mVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
