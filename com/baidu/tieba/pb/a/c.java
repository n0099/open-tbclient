package com.baidu.tieba.pb.a;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.v;
import com.baidu.tieba.tbadkCore.data.i;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class c {
    private v aUA;
    private int aZY;
    private int asu;
    private ForumData cai;
    private AntiData cao;
    public Error caq;
    private int cam = 20;
    private int can = -1;
    private boolean cap = false;
    private i caj = null;
    private ArrayList<i> cak = new ArrayList<>();
    private int cal = 1;

    public Error acP() {
        return this.caq;
    }

    public i acQ() {
        return this.caj;
    }

    public void a(i iVar) {
        this.caj = iVar;
    }

    public int acR() {
        if (this.can == -1) {
            this.can = this.aZY;
        }
        return this.can;
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            b(cVar.acW());
            this.can = cVar.getCurrentPage();
            b(cVar.acV());
            setPageSize(cVar.acU());
            d(cVar.acX());
            setTotalCount(cVar.getTotalCount());
            in(cVar.acT());
            this.cak.addAll(0, cVar.acS());
        }
    }

    public void b(c cVar, boolean z) {
        if (cVar != null) {
            b(cVar.acW());
            b(cVar.acV());
            a(cVar.acQ());
            d(cVar.acX());
            if (cVar.acS() != null && cVar.acS().size() > 0) {
                setCurrentPage(cVar.getCurrentPage());
                setPageSize(cVar.acU());
                setTotalCount(cVar.getTotalCount());
                in(cVar.acT());
            }
            int size = this.cak.size();
            if (z && size % this.cam != 0) {
                for (int i = 0; i < size % this.cam; i++) {
                    this.cak.remove(this.cak.size() - 1);
                }
            }
            this.cak.addAll(cVar.acS());
        }
    }

    public ArrayList<i> acS() {
        return this.cak;
    }

    public void P(ArrayList<i> arrayList) {
        this.cak = arrayList;
    }

    public int acT() {
        return this.cal;
    }

    public void in(int i) {
        this.cal = i;
    }

    public int getTotalCount() {
        return this.asu;
    }

    public void setTotalCount(int i) {
        this.asu = i;
    }

    public int acU() {
        return this.cam;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.cam = i;
        }
    }

    public int getCurrentPage() {
        return this.aZY;
    }

    public void setCurrentPage(int i) {
        this.aZY = i;
    }

    public void b(ForumData forumData) {
        this.cai = forumData;
    }

    public ForumData acV() {
        return this.cai;
    }

    public void b(AntiData antiData) {
        this.cao = antiData;
    }

    public AntiData acW() {
        return this.cao;
    }

    public void d(v vVar) {
        this.aUA = vVar;
    }

    public boolean VZ() {
        return (this.aUA == null || this.caj == null || this.aUA.getAuthor() == null || this.aUA.getAuthor().getUserId() == null || this.caj.getAuthor() == null || this.caj.getAuthor().getUserId() == null || !this.aUA.getAuthor().getUserId().equals(this.caj.getAuthor().getUserId())) ? false : true;
    }

    public boolean qr() {
        return this.cap;
    }

    public boolean hasMore() {
        return this.aZY < this.cal;
    }

    public v acX() {
        return this.aUA;
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
            cVar.d(vVar);
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
                cVar.in(intValue);
            }
            return cVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
