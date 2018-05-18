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
    private ForumData aEY;
    private int aFq;
    private bd bkk;
    private AntiData fdY;
    public Error fea;
    private int mCurrentPage;
    private int fdW = 20;
    private int fdX = -1;
    private boolean fdZ = false;
    private PostData fdT = null;
    private ArrayList<PostData> fdU = new ArrayList<>();
    private int fdV = 1;

    public Error aWb() {
        return this.fea;
    }

    public PostData aWc() {
        return this.fdT;
    }

    public void d(PostData postData) {
        this.fdT = postData;
    }

    public int aWd() {
        if (this.fdX == -1) {
            this.fdX = this.mCurrentPage;
        }
        return this.fdX;
    }

    public int aWe() {
        return this.fdX;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.aWk());
            this.fdX = kVar.KY();
            a(kVar.aWj());
            setPageSize(kVar.aWi());
            T(kVar.Pb());
            setTotalCount(kVar.getTotalCount());
            iS(kVar.aWh());
            this.fdU.addAll(0, kVar.aWg());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.aWk());
            a(kVar.aWj());
            d(kVar.aWc());
            T(kVar.Pb());
            if (kVar.aWg() != null && kVar.aWg().size() > 0) {
                bV(kVar.KY());
                setPageSize(kVar.aWi());
                setTotalCount(kVar.getTotalCount());
                iS(kVar.aWh());
            }
            int size = this.fdU.size();
            if (z && size % this.fdW != 0) {
                for (int i = 0; i < size % this.fdW; i++) {
                    this.fdU.remove(this.fdU.size() - 1);
                }
            }
            this.fdU.addAll(kVar.aWg());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.aWk());
            a(kVar.aWj());
            d(kVar.aWc());
            T(kVar.Pb());
            if (kVar.aWg() != null && kVar.aWg().size() > 0) {
                bV(kVar.KY());
                setPageSize(kVar.aWi());
                setTotalCount(kVar.getTotalCount());
                iS(kVar.aWh());
            }
            int size = this.fdU.size();
            if (z && size % this.fdW != 0) {
                for (int i = 0; i < size % this.fdW; i++) {
                    this.fdU.remove(this.fdU.size() - 1);
                }
            }
            this.fdU.addAll(kVar.aWg());
            aWf();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.aWk());
            a(kVar.aWj());
            d(kVar.aWc());
            T(kVar.Pb());
            if (kVar.aWg() != null && kVar.aWg().size() > 0) {
                bV(kVar.KY());
                setPageSize(kVar.aWi());
                setTotalCount(kVar.getTotalCount());
                iS(kVar.aWh());
                this.fdX = (this.mCurrentPage - (((kVar.aWg().size() - 1) + this.fdW) / this.fdW)) + 1;
                if (this.fdX < 0) {
                    this.fdX = 0;
                }
            }
            this.fdU.addAll(kVar.aWg());
        }
    }

    public void aWf() {
        if (this.fdX < 0) {
            this.fdX = this.mCurrentPage;
        } else if (this.fdX > this.mCurrentPage) {
            this.fdX = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aWg() {
        return this.fdU;
    }

    public void al(ArrayList<PostData> arrayList) {
        this.fdU = arrayList;
    }

    public int aWh() {
        return this.fdV;
    }

    public void iS(int i) {
        this.fdV = i;
    }

    public int getTotalCount() {
        return this.aFq;
    }

    public void setTotalCount(int i) {
        this.aFq = i;
    }

    public int aWi() {
        return this.fdW;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.fdW = i;
        }
    }

    public int KY() {
        return this.mCurrentPage;
    }

    public void bV(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.aEY = forumData;
    }

    public ForumData aWj() {
        return this.aEY;
    }

    public void b(AntiData antiData) {
        this.fdY = antiData;
    }

    public AntiData aWk() {
        return this.fdY;
    }

    public void T(bd bdVar) {
        this.bkk = bdVar;
    }

    public boolean aGl() {
        return (this.bkk == null || this.fdT == null || this.bkk.rP() == null || this.bkk.rP().getUserId() == null || this.fdT.rP() == null || this.fdT.rP().getUserId() == null || !this.bkk.rP().getUserId().equals(this.fdT.rP().getUserId())) ? false : true;
    }

    public boolean oH() {
        return this.fdZ;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fdV;
    }

    public bd Pb() {
        return this.bkk;
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
            bdVar.bV(2);
            kVar.T(bdVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            kVar.a(forumData);
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
            kVar.al(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            kVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                kVar.bV(intValue3);
                kVar.setPageSize(intValue2);
                kVar.setTotalCount(intValue4);
                kVar.iS(intValue);
            }
            return kVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
