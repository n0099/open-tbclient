package com.baidu.tieba.pb.a;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tieba.tbadkCore.data.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class d {
    private int avG;
    private ah bfH;
    private int bnW;
    private ForumData cJG;
    private AntiData cJM;
    public Error cJO;
    private int cJK = 20;
    private int cJL = -1;
    private boolean cJN = false;
    private r cJH = null;
    private ArrayList<r> cJI = new ArrayList<>();
    private int cJJ = 1;

    public Error aoP() {
        return this.cJO;
    }

    public r aoQ() {
        return this.cJH;
    }

    public void a(r rVar) {
        this.cJH = rVar;
    }

    public int aoR() {
        if (this.cJL == -1) {
            this.cJL = this.bnW;
        }
        return this.cJL;
    }

    public int aoS() {
        return this.cJL;
    }

    public void a(d dVar, boolean z) {
        if (dVar != null) {
            e(dVar.ajb());
            this.cJL = dVar.pf();
            b(dVar.aoX());
            setPageSize(dVar.aoW());
            h(dVar.Ki());
            setTotalCount(dVar.getTotalCount());
            kK(dVar.aoV());
            this.cJI.addAll(0, dVar.aoU());
        }
    }

    public void b(d dVar, boolean z) {
        if (dVar != null) {
            e(dVar.ajb());
            b(dVar.aoX());
            a(dVar.aoQ());
            h(dVar.Ki());
            if (dVar.aoU() != null && dVar.aoU().size() > 0) {
                setCurrentPage(dVar.pf());
                setPageSize(dVar.aoW());
                setTotalCount(dVar.getTotalCount());
                kK(dVar.aoV());
            }
            int size = this.cJI.size();
            if (z && size % this.cJK != 0) {
                for (int i = 0; i < size % this.cJK; i++) {
                    this.cJI.remove(this.cJI.size() - 1);
                }
            }
            this.cJI.addAll(dVar.aoU());
        }
    }

    public void c(d dVar, boolean z) {
        if (dVar != null) {
            e(dVar.ajb());
            b(dVar.aoX());
            a(dVar.aoQ());
            h(dVar.Ki());
            if (dVar.aoU() != null && dVar.aoU().size() > 0) {
                setCurrentPage(dVar.pf());
                setPageSize(dVar.aoW());
                setTotalCount(dVar.getTotalCount());
                kK(dVar.aoV());
            }
            int size = this.cJI.size();
            if (z && size % this.cJK != 0) {
                for (int i = 0; i < size % this.cJK; i++) {
                    this.cJI.remove(this.cJI.size() - 1);
                }
            }
            this.cJI.addAll(dVar.aoU());
            aoT();
        }
    }

    public void d(d dVar, boolean z) {
        a(dVar, z);
    }

    public void a(d dVar) {
        if (dVar != null) {
            e(dVar.ajb());
            b(dVar.aoX());
            a(dVar.aoQ());
            h(dVar.Ki());
            if (dVar.aoU() != null && dVar.aoU().size() > 0) {
                setCurrentPage(dVar.pf());
                setPageSize(dVar.aoW());
                setTotalCount(dVar.getTotalCount());
                kK(dVar.aoV());
                this.cJL = (this.bnW - (((dVar.aoU().size() - 1) + this.cJK) / this.cJK)) + 1;
                if (this.cJL < 0) {
                    this.cJL = 0;
                }
            }
            this.cJI.addAll(dVar.aoU());
        }
    }

    public void aoT() {
        if (this.cJL < 0) {
            this.cJL = this.bnW;
        } else if (this.cJL > this.bnW) {
            this.cJL = this.bnW;
        }
    }

    public ArrayList<r> aoU() {
        return this.cJI;
    }

    public void V(ArrayList<r> arrayList) {
        this.cJI = arrayList;
    }

    public int aoV() {
        return this.cJJ;
    }

    public void kK(int i) {
        this.cJJ = i;
    }

    public int getTotalCount() {
        return this.avG;
    }

    public void setTotalCount(int i) {
        this.avG = i;
    }

    public int aoW() {
        return this.cJK;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.cJK = i;
        }
    }

    public int pf() {
        return this.bnW;
    }

    public void setCurrentPage(int i) {
        this.bnW = i;
    }

    public void b(ForumData forumData) {
        this.cJG = forumData;
    }

    public ForumData aoX() {
        return this.cJG;
    }

    public void e(AntiData antiData) {
        this.cJM = antiData;
    }

    public AntiData ajb() {
        return this.cJM;
    }

    public void h(ah ahVar) {
        this.bfH = ahVar;
    }

    public boolean aen() {
        return (this.bfH == null || this.cJH == null || this.bfH.getAuthor() == null || this.bfH.getAuthor().getUserId() == null || this.cJH.getAuthor() == null || this.cJH.getAuthor().getUserId() == null || !this.bfH.getAuthor().getUserId().equals(this.cJH.getAuthor().getUserId())) ? false : true;
    }

    public boolean qg() {
        return this.cJN;
    }

    public boolean hasMore() {
        return this.bnW < this.cJJ;
    }

    public ah Ki() {
        return this.bfH;
    }

    public static d a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            d dVar = new d();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            dVar.e(antiData);
            ah ahVar = new ah();
            ahVar.a(dataRes.thread);
            dVar.h(ahVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            dVar.b(forumData);
            r rVar = new r();
            rVar.a(dataRes.post, context);
            dVar.a(rVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<r> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                r rVar2 = new r();
                rVar2.a(list.get(i), context);
                arrayList.add(rVar2);
            }
            dVar.V(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            dVar.e(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                dVar.setCurrentPage(intValue3);
                dVar.setPageSize(intValue2);
                dVar.setTotalCount(intValue4);
                dVar.kK(intValue);
            }
            return dVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
