package com.baidu.tieba.pb.a;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.w;
import com.baidu.tieba.tbadkCore.data.o;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class d {
    private w aUg;
    private int arj;
    private int baQ;
    private ForumData cgY;
    private AntiData che;
    public Error chg;
    private int chc = 20;
    private int chd = -1;
    private boolean chf = false;
    private o cgZ = null;
    private ArrayList<o> cha = new ArrayList<>();
    private int chb = 1;

    public Error afr() {
        return this.chg;
    }

    public o afs() {
        return this.cgZ;
    }

    public void a(o oVar) {
        this.cgZ = oVar;
    }

    public int aft() {
        if (this.chd == -1) {
            this.chd = this.baQ;
        }
        return this.chd;
    }

    public int afu() {
        return this.chd;
    }

    public void a(d dVar, boolean z) {
        if (dVar != null) {
            b(dVar.afA());
            this.chd = dVar.getCurrentPage();
            b(dVar.afz());
            setPageSize(dVar.afy());
            e(dVar.afB());
            setTotalCount(dVar.getTotalCount());
            iV(dVar.afx());
            this.cha.addAll(0, dVar.afw());
        }
    }

    public void b(d dVar, boolean z) {
        if (dVar != null) {
            b(dVar.afA());
            b(dVar.afz());
            a(dVar.afs());
            e(dVar.afB());
            if (dVar.afw() != null && dVar.afw().size() > 0) {
                setCurrentPage(dVar.getCurrentPage());
                setPageSize(dVar.afy());
                setTotalCount(dVar.getTotalCount());
                iV(dVar.afx());
            }
            int size = this.cha.size();
            if (z && size % this.chc != 0) {
                for (int i = 0; i < size % this.chc; i++) {
                    this.cha.remove(this.cha.size() - 1);
                }
            }
            this.cha.addAll(dVar.afw());
        }
    }

    public void c(d dVar, boolean z) {
        if (dVar != null) {
            b(dVar.afA());
            b(dVar.afz());
            a(dVar.afs());
            e(dVar.afB());
            if (dVar.afw() != null && dVar.afw().size() > 0) {
                setCurrentPage(dVar.getCurrentPage());
                setPageSize(dVar.afy());
                setTotalCount(dVar.getTotalCount());
                iV(dVar.afx());
            }
            int size = this.cha.size();
            if (z && size % this.chc != 0) {
                for (int i = 0; i < size % this.chc; i++) {
                    this.cha.remove(this.cha.size() - 1);
                }
            }
            this.cha.addAll(dVar.afw());
            afv();
        }
    }

    public void d(d dVar, boolean z) {
        a(dVar, z);
    }

    public void a(d dVar) {
        if (dVar != null) {
            b(dVar.afA());
            b(dVar.afz());
            a(dVar.afs());
            e(dVar.afB());
            if (dVar.afw() != null && dVar.afw().size() > 0) {
                setCurrentPage(dVar.getCurrentPage());
                setPageSize(dVar.afy());
                setTotalCount(dVar.getTotalCount());
                iV(dVar.afx());
                this.chd = (this.baQ - (((dVar.afw().size() - 1) + this.chc) / this.chc)) + 1;
                if (this.chd < 0) {
                    this.chd = 0;
                }
            }
            this.cha.addAll(dVar.afw());
        }
    }

    public void afv() {
        if (this.chd < 0) {
            this.chd = this.baQ;
        } else if (this.chd > this.baQ) {
            this.chd = this.baQ;
        }
    }

    public ArrayList<o> afw() {
        return this.cha;
    }

    public void P(ArrayList<o> arrayList) {
        this.cha = arrayList;
    }

    public int afx() {
        return this.chb;
    }

    public void iV(int i) {
        this.chb = i;
    }

    public int getTotalCount() {
        return this.arj;
    }

    public void setTotalCount(int i) {
        this.arj = i;
    }

    public int afy() {
        return this.chc;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.chc = i;
        }
    }

    public int getCurrentPage() {
        return this.baQ;
    }

    public void setCurrentPage(int i) {
        this.baQ = i;
    }

    public void b(ForumData forumData) {
        this.cgY = forumData;
    }

    public ForumData afz() {
        return this.cgY;
    }

    public void b(AntiData antiData) {
        this.che = antiData;
    }

    public AntiData afA() {
        return this.che;
    }

    public void e(w wVar) {
        this.aUg = wVar;
    }

    public boolean Xb() {
        return (this.aUg == null || this.cgZ == null || this.aUg.getAuthor() == null || this.aUg.getAuthor().getUserId() == null || this.cgZ.getAuthor() == null || this.cgZ.getAuthor().getUserId() == null || !this.aUg.getAuthor().getUserId().equals(this.cgZ.getAuthor().getUserId())) ? false : true;
    }

    public boolean qi() {
        return this.chf;
    }

    public boolean hasMore() {
        return this.baQ < this.chb;
    }

    public w afB() {
        return this.aUg;
    }

    public static d a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            d dVar = new d();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            dVar.b(antiData);
            w wVar = new w();
            wVar.a(dataRes.thread);
            dVar.e(wVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            dVar.b(forumData);
            o oVar = new o();
            oVar.a(dataRes.post, context);
            dVar.a(oVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<o> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                o oVar2 = new o();
                oVar2.a(list.get(i), context);
                arrayList.add(oVar2);
            }
            dVar.P(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            dVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                dVar.setCurrentPage(intValue3);
                dVar.setPageSize(intValue2);
                dVar.setTotalCount(intValue4);
                dVar.iV(intValue);
            }
            return dVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
