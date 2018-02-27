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
public class k {
    private bd bZR;
    private int buO;
    private ForumData fHV;
    private AntiData fIb;
    public Error fId;
    private int mCurrentPage;
    private int fHZ = 20;
    private int fIa = -1;
    private boolean fIc = false;
    private PostData fHW = null;
    private ArrayList<PostData> fHX = new ArrayList<>();
    private int fHY = 1;

    public Error bbb() {
        return this.fId;
    }

    public PostData bbc() {
        return this.fHW;
    }

    public void d(PostData postData) {
        this.fHW = postData;
    }

    public int bbd() {
        if (this.fIa == -1) {
            this.fIa = this.mCurrentPage;
        }
        return this.fIa;
    }

    public int bbe() {
        return this.fIa;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.bbk());
            this.fIa = kVar.SB();
            b(kVar.bbj());
            setPageSize(kVar.bbi());
            T(kVar.WD());
            setTotalCount(kVar.getTotalCount());
            lJ(kVar.bbh());
            this.fHX.addAll(0, kVar.bbg());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.bbk());
            b(kVar.bbj());
            d(kVar.bbc());
            T(kVar.WD());
            if (kVar.bbg() != null && kVar.bbg().size() > 0) {
                eW(kVar.SB());
                setPageSize(kVar.bbi());
                setTotalCount(kVar.getTotalCount());
                lJ(kVar.bbh());
            }
            int size = this.fHX.size();
            if (z && size % this.fHZ != 0) {
                for (int i = 0; i < size % this.fHZ; i++) {
                    this.fHX.remove(this.fHX.size() - 1);
                }
            }
            this.fHX.addAll(kVar.bbg());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.bbk());
            b(kVar.bbj());
            d(kVar.bbc());
            T(kVar.WD());
            if (kVar.bbg() != null && kVar.bbg().size() > 0) {
                eW(kVar.SB());
                setPageSize(kVar.bbi());
                setTotalCount(kVar.getTotalCount());
                lJ(kVar.bbh());
            }
            int size = this.fHX.size();
            if (z && size % this.fHZ != 0) {
                for (int i = 0; i < size % this.fHZ; i++) {
                    this.fHX.remove(this.fHX.size() - 1);
                }
            }
            this.fHX.addAll(kVar.bbg());
            bbf();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.bbk());
            b(kVar.bbj());
            d(kVar.bbc());
            T(kVar.WD());
            if (kVar.bbg() != null && kVar.bbg().size() > 0) {
                eW(kVar.SB());
                setPageSize(kVar.bbi());
                setTotalCount(kVar.getTotalCount());
                lJ(kVar.bbh());
                this.fIa = (this.mCurrentPage - (((kVar.bbg().size() - 1) + this.fHZ) / this.fHZ)) + 1;
                if (this.fIa < 0) {
                    this.fIa = 0;
                }
            }
            this.fHX.addAll(kVar.bbg());
        }
    }

    public void bbf() {
        if (this.fIa < 0) {
            this.fIa = this.mCurrentPage;
        } else if (this.fIa > this.mCurrentPage) {
            this.fIa = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bbg() {
        return this.fHX;
    }

    public void ak(ArrayList<PostData> arrayList) {
        this.fHX = arrayList;
    }

    public int bbh() {
        return this.fHY;
    }

    public void lJ(int i) {
        this.fHY = i;
    }

    public int getTotalCount() {
        return this.buO;
    }

    public void setTotalCount(int i) {
        this.buO = i;
    }

    public int bbi() {
        return this.fHZ;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.fHZ = i;
        }
    }

    public int SB() {
        return this.mCurrentPage;
    }

    public void eW(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.fHV = forumData;
    }

    public ForumData bbj() {
        return this.fHV;
    }

    public void b(AntiData antiData) {
        this.fIb = antiData;
    }

    public AntiData bbk() {
        return this.fIb;
    }

    public void T(bd bdVar) {
        this.bZR = bdVar;
    }

    public boolean aLp() {
        return (this.bZR == null || this.fHW == null || this.bZR.zn() == null || this.bZR.zn().getUserId() == null || this.fHW.zn() == null || this.fHW.zn().getUserId() == null || !this.bZR.zn().getUserId().equals(this.fHW.zn().getUserId())) ? false : true;
    }

    public boolean vX() {
        return this.fIc;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fHY;
    }

    public bd WD() {
        return this.bZR;
    }

    public static k a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            k kVar = new k();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            kVar.b(antiData);
            bd bdVar = new bd();
            bdVar.a(dataRes.thread);
            bdVar.eW(2);
            kVar.T(bdVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            kVar.b(forumData);
            PostData postData = new PostData();
            postData.a(dataRes.post, context);
            kVar.d(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            kVar.ak(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            kVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                kVar.eW(intValue3);
                kVar.setPageSize(intValue2);
                kVar.setTotalCount(intValue4);
                kVar.lJ(intValue);
            }
            return kVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
