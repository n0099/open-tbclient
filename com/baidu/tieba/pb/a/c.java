package com.baidu.tieba.pb.a;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.v;
import com.baidu.tieba.tbadkCore.data.k;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class c {
    private v aTN;
    private int asB;
    private int bal;
    private ForumData cgi;
    private AntiData cgo;
    public Error cgq;
    private int cgm = 20;
    private int cgn = -1;
    private boolean cgp = false;
    private k cgj = null;
    private ArrayList<k> cgk = new ArrayList<>();
    private int cgl = 1;

    public Error aeY() {
        return this.cgq;
    }

    public k aeZ() {
        return this.cgj;
    }

    public void a(k kVar) {
        this.cgj = kVar;
    }

    public int afa() {
        if (this.cgn == -1) {
            this.cgn = this.bal;
        }
        return this.cgn;
    }

    public int afb() {
        return this.cgn;
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            b(cVar.afh());
            this.cgn = cVar.getCurrentPage();
            b(cVar.afg());
            setPageSize(cVar.aff());
            e(cVar.afi());
            setTotalCount(cVar.getTotalCount());
            iI(cVar.afe());
            this.cgk.addAll(0, cVar.afd());
        }
    }

    public void b(c cVar, boolean z) {
        if (cVar != null) {
            b(cVar.afh());
            b(cVar.afg());
            a(cVar.aeZ());
            e(cVar.afi());
            if (cVar.afd() != null && cVar.afd().size() > 0) {
                setCurrentPage(cVar.getCurrentPage());
                setPageSize(cVar.aff());
                setTotalCount(cVar.getTotalCount());
                iI(cVar.afe());
            }
            int size = this.cgk.size();
            if (z && size % this.cgm != 0) {
                for (int i = 0; i < size % this.cgm; i++) {
                    this.cgk.remove(this.cgk.size() - 1);
                }
            }
            this.cgk.addAll(cVar.afd());
        }
    }

    public void c(c cVar, boolean z) {
        if (cVar != null) {
            b(cVar.afh());
            b(cVar.afg());
            a(cVar.aeZ());
            e(cVar.afi());
            if (cVar.afd() != null && cVar.afd().size() > 0) {
                setCurrentPage(cVar.getCurrentPage());
                setPageSize(cVar.aff());
                setTotalCount(cVar.getTotalCount());
                iI(cVar.afe());
            }
            int size = this.cgk.size();
            if (z && size % this.cgm != 0) {
                for (int i = 0; i < size % this.cgm; i++) {
                    this.cgk.remove(this.cgk.size() - 1);
                }
            }
            this.cgk.addAll(cVar.afd());
            afc();
        }
    }

    public void d(c cVar, boolean z) {
        a(cVar, z);
    }

    public void a(c cVar) {
        if (cVar != null) {
            b(cVar.afh());
            b(cVar.afg());
            a(cVar.aeZ());
            e(cVar.afi());
            if (cVar.afd() != null && cVar.afd().size() > 0) {
                setCurrentPage(cVar.getCurrentPage());
                setPageSize(cVar.aff());
                setTotalCount(cVar.getTotalCount());
                iI(cVar.afe());
                this.cgn = (this.bal - (((cVar.afd().size() - 1) + this.cgm) / this.cgm)) + 1;
                if (this.cgn < 0) {
                    this.cgn = 0;
                }
            }
            this.cgk.addAll(cVar.afd());
        }
    }

    public void afc() {
        if (this.cgn < 0) {
            this.cgn = this.bal;
        } else if (this.cgn > this.bal) {
            this.cgn = this.bal;
        }
    }

    public ArrayList<k> afd() {
        return this.cgk;
    }

    public void P(ArrayList<k> arrayList) {
        this.cgk = arrayList;
    }

    public int afe() {
        return this.cgl;
    }

    public void iI(int i) {
        this.cgl = i;
    }

    public int getTotalCount() {
        return this.asB;
    }

    public void setTotalCount(int i) {
        this.asB = i;
    }

    public int aff() {
        return this.cgm;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.cgm = i;
        }
    }

    public int getCurrentPage() {
        return this.bal;
    }

    public void setCurrentPage(int i) {
        this.bal = i;
    }

    public void b(ForumData forumData) {
        this.cgi = forumData;
    }

    public ForumData afg() {
        return this.cgi;
    }

    public void b(AntiData antiData) {
        this.cgo = antiData;
    }

    public AntiData afh() {
        return this.cgo;
    }

    public void e(v vVar) {
        this.aTN = vVar;
    }

    public boolean WK() {
        return (this.aTN == null || this.cgj == null || this.aTN.getAuthor() == null || this.aTN.getAuthor().getUserId() == null || this.cgj.getAuthor() == null || this.cgj.getAuthor().getUserId() == null || !this.aTN.getAuthor().getUserId().equals(this.cgj.getAuthor().getUserId())) ? false : true;
    }

    public boolean qk() {
        return this.cgp;
    }

    public boolean hasMore() {
        return this.bal < this.cgl;
    }

    public v afi() {
        return this.aTN;
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
            v vVar = new v();
            vVar.a(dataRes.thread);
            cVar.e(vVar);
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
