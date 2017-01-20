package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.tbadkCore.data.p;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class j {
    private bh aLS;
    private int avP;
    private ForumData efR;
    private AntiData efX;
    public Error efZ;
    private int mCurrentPage;
    private int efV = 20;
    private int efW = -1;
    private boolean efY = false;
    private p efS = null;
    private ArrayList<p> efT = new ArrayList<>();
    private int efU = 1;

    public Error aKv() {
        return this.efZ;
    }

    public p aKw() {
        return this.efS;
    }

    public void b(p pVar) {
        this.efS = pVar;
    }

    public int aKx() {
        if (this.efW == -1) {
            this.efW = this.mCurrentPage;
        }
        return this.efW;
    }

    public int aKy() {
        return this.efW;
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            e(jVar.axd());
            this.efW = jVar.ma();
            b(jVar.aKC());
            setPageSize(jVar.aKB());
            h(jVar.Ji());
            setTotalCount(jVar.getTotalCount());
            gR(jVar.aHO());
            this.efT.addAll(0, jVar.aKA());
        }
    }

    public void b(j jVar, boolean z) {
        if (jVar != null) {
            e(jVar.axd());
            b(jVar.aKC());
            b(jVar.aKw());
            h(jVar.Ji());
            if (jVar.aKA() != null && jVar.aKA().size() > 0) {
                aW(jVar.ma());
                setPageSize(jVar.aKB());
                setTotalCount(jVar.getTotalCount());
                gR(jVar.aHO());
            }
            int size = this.efT.size();
            if (z && size % this.efV != 0) {
                for (int i = 0; i < size % this.efV; i++) {
                    this.efT.remove(this.efT.size() - 1);
                }
            }
            this.efT.addAll(jVar.aKA());
        }
    }

    public void c(j jVar, boolean z) {
        if (jVar != null) {
            e(jVar.axd());
            b(jVar.aKC());
            b(jVar.aKw());
            h(jVar.Ji());
            if (jVar.aKA() != null && jVar.aKA().size() > 0) {
                aW(jVar.ma());
                setPageSize(jVar.aKB());
                setTotalCount(jVar.getTotalCount());
                gR(jVar.aHO());
            }
            int size = this.efT.size();
            if (z && size % this.efV != 0) {
                for (int i = 0; i < size % this.efV; i++) {
                    this.efT.remove(this.efT.size() - 1);
                }
            }
            this.efT.addAll(jVar.aKA());
            aKz();
        }
    }

    public void d(j jVar, boolean z) {
        a(jVar, z);
    }

    public void a(j jVar) {
        if (jVar != null) {
            e(jVar.axd());
            b(jVar.aKC());
            b(jVar.aKw());
            h(jVar.Ji());
            if (jVar.aKA() != null && jVar.aKA().size() > 0) {
                aW(jVar.ma());
                setPageSize(jVar.aKB());
                setTotalCount(jVar.getTotalCount());
                gR(jVar.aHO());
                this.efW = (this.mCurrentPage - (((jVar.aKA().size() - 1) + this.efV) / this.efV)) + 1;
                if (this.efW < 0) {
                    this.efW = 0;
                }
            }
            this.efT.addAll(jVar.aKA());
        }
    }

    public void aKz() {
        if (this.efW < 0) {
            this.efW = this.mCurrentPage;
        } else if (this.efW > this.mCurrentPage) {
            this.efW = this.mCurrentPage;
        }
    }

    public ArrayList<p> aKA() {
        return this.efT;
    }

    public void aj(ArrayList<p> arrayList) {
        this.efT = arrayList;
    }

    public int aHO() {
        return this.efU;
    }

    public void gR(int i) {
        this.efU = i;
    }

    public int getTotalCount() {
        return this.avP;
    }

    public void setTotalCount(int i) {
        this.avP = i;
    }

    public int aKB() {
        return this.efV;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.efV = i;
        }
    }

    public int ma() {
        return this.mCurrentPage;
    }

    public void aW(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.efR = forumData;
    }

    public ForumData aKC() {
        return this.efR;
    }

    public void e(AntiData antiData) {
        this.efX = antiData;
    }

    public AntiData axd() {
        return this.efX;
    }

    public void h(bh bhVar) {
        this.aLS = bhVar;
    }

    public boolean atD() {
        return (this.aLS == null || this.efS == null || this.aLS.getAuthor() == null || this.aLS.getAuthor().getUserId() == null || this.efS.getAuthor() == null || this.efS.getAuthor().getUserId() == null || !this.aLS.getAuthor().getUserId().equals(this.efS.getAuthor().getUserId())) ? false : true;
    }

    public boolean nt() {
        return this.efY;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.efU;
    }

    public bh Ji() {
        return this.aLS;
    }

    public static j a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            j jVar = new j();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            jVar.e(antiData);
            bh bhVar = new bh();
            bhVar.a(dataRes.thread);
            bhVar.aW(2);
            jVar.h(bhVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            jVar.b(forumData);
            p pVar = new p();
            pVar.a(dataRes.post, context);
            jVar.b(pVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<p> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                p pVar2 = new p();
                pVar2.a(list.get(i), context);
                arrayList.add(pVar2);
            }
            jVar.aj(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            jVar.e(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                jVar.aW(intValue3);
                jVar.setPageSize(intValue2);
                jVar.setTotalCount(intValue4);
                jVar.gR(intValue);
            }
            return jVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
