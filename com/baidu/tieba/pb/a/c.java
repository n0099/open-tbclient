package com.baidu.tieba.pb.a;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.w;
import com.baidu.tieba.tbadkCore.data.k;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class c {
    private w aTY;
    private int asC;
    private int bax;
    public Error cgB;
    private ForumData cgt;
    private AntiData cgz;
    private int cgx = 20;
    private int cgy = -1;
    private boolean cgA = false;
    private k cgu = null;
    private ArrayList<k> cgv = new ArrayList<>();
    private int cgw = 1;

    public Error aeU() {
        return this.cgB;
    }

    public k aeV() {
        return this.cgu;
    }

    public void a(k kVar) {
        this.cgu = kVar;
    }

    public int aeW() {
        if (this.cgy == -1) {
            this.cgy = this.bax;
        }
        return this.cgy;
    }

    public int aeX() {
        return this.cgy;
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            b(cVar.afd());
            this.cgy = cVar.getCurrentPage();
            b(cVar.afc());
            setPageSize(cVar.afb());
            e(cVar.afe());
            setTotalCount(cVar.getTotalCount());
            iI(cVar.afa());
            this.cgv.addAll(0, cVar.aeZ());
        }
    }

    public void b(c cVar, boolean z) {
        if (cVar != null) {
            b(cVar.afd());
            b(cVar.afc());
            a(cVar.aeV());
            e(cVar.afe());
            if (cVar.aeZ() != null && cVar.aeZ().size() > 0) {
                setCurrentPage(cVar.getCurrentPage());
                setPageSize(cVar.afb());
                setTotalCount(cVar.getTotalCount());
                iI(cVar.afa());
            }
            int size = this.cgv.size();
            if (z && size % this.cgx != 0) {
                for (int i = 0; i < size % this.cgx; i++) {
                    this.cgv.remove(this.cgv.size() - 1);
                }
            }
            this.cgv.addAll(cVar.aeZ());
        }
    }

    public void c(c cVar, boolean z) {
        if (cVar != null) {
            b(cVar.afd());
            b(cVar.afc());
            a(cVar.aeV());
            e(cVar.afe());
            if (cVar.aeZ() != null && cVar.aeZ().size() > 0) {
                setCurrentPage(cVar.getCurrentPage());
                setPageSize(cVar.afb());
                setTotalCount(cVar.getTotalCount());
                iI(cVar.afa());
            }
            int size = this.cgv.size();
            if (z && size % this.cgx != 0) {
                for (int i = 0; i < size % this.cgx; i++) {
                    this.cgv.remove(this.cgv.size() - 1);
                }
            }
            this.cgv.addAll(cVar.aeZ());
            aeY();
        }
    }

    public void d(c cVar, boolean z) {
        a(cVar, z);
    }

    public void a(c cVar) {
        if (cVar != null) {
            b(cVar.afd());
            b(cVar.afc());
            a(cVar.aeV());
            e(cVar.afe());
            if (cVar.aeZ() != null && cVar.aeZ().size() > 0) {
                setCurrentPage(cVar.getCurrentPage());
                setPageSize(cVar.afb());
                setTotalCount(cVar.getTotalCount());
                iI(cVar.afa());
                this.cgy = (this.bax - (((cVar.aeZ().size() - 1) + this.cgx) / this.cgx)) + 1;
                if (this.cgy < 0) {
                    this.cgy = 0;
                }
            }
            this.cgv.addAll(cVar.aeZ());
        }
    }

    public void aeY() {
        if (this.cgy < 0) {
            this.cgy = this.bax;
        } else if (this.cgy > this.bax) {
            this.cgy = this.bax;
        }
    }

    public ArrayList<k> aeZ() {
        return this.cgv;
    }

    public void P(ArrayList<k> arrayList) {
        this.cgv = arrayList;
    }

    public int afa() {
        return this.cgw;
    }

    public void iI(int i) {
        this.cgw = i;
    }

    public int getTotalCount() {
        return this.asC;
    }

    public void setTotalCount(int i) {
        this.asC = i;
    }

    public int afb() {
        return this.cgx;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.cgx = i;
        }
    }

    public int getCurrentPage() {
        return this.bax;
    }

    public void setCurrentPage(int i) {
        this.bax = i;
    }

    public void b(ForumData forumData) {
        this.cgt = forumData;
    }

    public ForumData afc() {
        return this.cgt;
    }

    public void b(AntiData antiData) {
        this.cgz = antiData;
    }

    public AntiData afd() {
        return this.cgz;
    }

    public void e(w wVar) {
        this.aTY = wVar;
    }

    public boolean WG() {
        return (this.aTY == null || this.cgu == null || this.aTY.getAuthor() == null || this.aTY.getAuthor().getUserId() == null || this.cgu.getAuthor() == null || this.cgu.getAuthor().getUserId() == null || !this.aTY.getAuthor().getUserId().equals(this.cgu.getAuthor().getUserId())) ? false : true;
    }

    public boolean qh() {
        return this.cgA;
    }

    public boolean hasMore() {
        return this.bax < this.cgw;
    }

    public w afe() {
        return this.aTY;
    }

    public static c a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            c cVar = new c();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            cVar.b(antiData);
            w wVar = new w();
            wVar.a(dataRes.thread);
            cVar.e(wVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            cVar.b(forumData);
            k kVar = new k();
            kVar.a(dataRes.post, context);
            cVar.a(kVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<k> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                k kVar2 = new k();
                kVar2.a(list.get(i), context);
                arrayList.add(kVar2);
            }
            cVar.P(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            cVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                cVar.setCurrentPage(intValue3);
                cVar.setPageSize(intValue2);
                cVar.setTotalCount(intValue4);
                cVar.iI(intValue);
            }
            return cVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
