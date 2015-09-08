package com.baidu.tieba.pb.a;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.x;
import com.baidu.tieba.tbadkCore.data.i;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class c {
    private x aUP;
    private int aue;
    private int bat;
    private ForumData cbd;
    private AntiData cbj;
    public Error cbl;
    private int cbh = 20;
    private int cbi = -1;
    private boolean cbk = false;
    private i cbe = null;
    private ArrayList<i> cbf = new ArrayList<>();
    private int cbg = 1;

    public Error ada() {
        return this.cbl;
    }

    public i adb() {
        return this.cbe;
    }

    public void a(i iVar) {
        this.cbe = iVar;
    }

    public int adc() {
        if (this.cbi == -1) {
            this.cbi = this.bat;
        }
        return this.cbi;
    }

    public int add() {
        return this.cbi;
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            b(cVar.adj());
            this.cbi = cVar.getCurrentPage();
            b(cVar.adi());
            setPageSize(cVar.adh());
            e(cVar.adk());
            setTotalCount(cVar.getTotalCount());
            iy(cVar.adg());
            this.cbf.addAll(0, cVar.adf());
        }
    }

    public void b(c cVar, boolean z) {
        if (cVar != null) {
            b(cVar.adj());
            b(cVar.adi());
            a(cVar.adb());
            e(cVar.adk());
            if (cVar.adf() != null && cVar.adf().size() > 0) {
                setCurrentPage(cVar.getCurrentPage());
                setPageSize(cVar.adh());
                setTotalCount(cVar.getTotalCount());
                iy(cVar.adg());
            }
            int size = this.cbf.size();
            if (z && size % this.cbh != 0) {
                for (int i = 0; i < size % this.cbh; i++) {
                    this.cbf.remove(this.cbf.size() - 1);
                }
            }
            this.cbf.addAll(cVar.adf());
        }
    }

    public void c(c cVar, boolean z) {
        if (cVar != null) {
            b(cVar.adj());
            b(cVar.adi());
            a(cVar.adb());
            e(cVar.adk());
            if (cVar.adf() != null && cVar.adf().size() > 0) {
                setCurrentPage(cVar.getCurrentPage());
                setPageSize(cVar.adh());
                setTotalCount(cVar.getTotalCount());
                iy(cVar.adg());
            }
            int size = this.cbf.size();
            if (z && size % this.cbh != 0) {
                for (int i = 0; i < size % this.cbh; i++) {
                    this.cbf.remove(this.cbf.size() - 1);
                }
            }
            this.cbf.addAll(cVar.adf());
            ade();
        }
    }

    public void d(c cVar, boolean z) {
        a(cVar, z);
    }

    public void a(c cVar) {
        if (cVar != null) {
            b(cVar.adj());
            b(cVar.adi());
            a(cVar.adb());
            e(cVar.adk());
            if (cVar.adf() != null && cVar.adf().size() > 0) {
                setCurrentPage(cVar.getCurrentPage());
                setPageSize(cVar.adh());
                setTotalCount(cVar.getTotalCount());
                iy(cVar.adg());
                this.cbi = (this.bat - (((cVar.adf().size() - 1) + this.cbh) / this.cbh)) + 1;
                if (this.cbi < 0) {
                    this.cbi = 0;
                }
            }
            this.cbf.addAll(cVar.adf());
        }
    }

    public void ade() {
        if (this.cbi < 0) {
            this.cbi = this.bat;
        } else if (this.cbi > this.bat) {
            this.cbi = this.bat;
        }
    }

    public ArrayList<i> adf() {
        return this.cbf;
    }

    public void P(ArrayList<i> arrayList) {
        this.cbf = arrayList;
    }

    public int adg() {
        return this.cbg;
    }

    public void iy(int i) {
        this.cbg = i;
    }

    public int getTotalCount() {
        return this.aue;
    }

    public void setTotalCount(int i) {
        this.aue = i;
    }

    public int adh() {
        return this.cbh;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.cbh = i;
        }
    }

    public int getCurrentPage() {
        return this.bat;
    }

    public void setCurrentPage(int i) {
        this.bat = i;
    }

    public void b(ForumData forumData) {
        this.cbd = forumData;
    }

    public ForumData adi() {
        return this.cbd;
    }

    public void b(AntiData antiData) {
        this.cbj = antiData;
    }

    public AntiData adj() {
        return this.cbj;
    }

    public void e(x xVar) {
        this.aUP = xVar;
    }

    public boolean Wb() {
        return (this.aUP == null || this.cbe == null || this.aUP.getAuthor() == null || this.aUP.getAuthor().getUserId() == null || this.cbe.getAuthor() == null || this.cbe.getAuthor().getUserId() == null || !this.aUP.getAuthor().getUserId().equals(this.cbe.getAuthor().getUserId())) ? false : true;
    }

    public boolean qo() {
        return this.cbk;
    }

    public boolean hasMore() {
        return this.bat < this.cbg;
    }

    public x adk() {
        return this.aUP;
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
            x xVar = new x();
            xVar.a(dataRes.thread);
            cVar.e(xVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            cVar.b(forumData);
            i iVar = new i();
            iVar.a(dataRes.post, context);
            cVar.a(iVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<i> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                i iVar2 = new i();
                iVar2.a(list.get(i), context);
                arrayList.add(iVar2);
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
                cVar.iy(intValue);
            }
            return cVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
