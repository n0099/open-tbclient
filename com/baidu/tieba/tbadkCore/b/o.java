package com.baidu.tieba.tbadkCore.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class o {
    private w aCl;
    private int aan;
    private AntiData bJJ;
    private int bUM;
    private ForumData bXc;
    public Error bXj;
    private int bXg = 10;
    private int bXh = -1;
    private boolean bXi = false;
    private k bXd = null;
    private ArrayList<k> bXe = new ArrayList<>();
    private int bXf = 1;

    public Error ahb() {
        return this.bXj;
    }

    public k ahc() {
        return this.bXd;
    }

    public void d(k kVar) {
        this.bXd = kVar;
    }

    public int ahd() {
        if (this.bXh == -1) {
            this.bXh = this.aan;
        }
        return this.bXh;
    }

    public void a(o oVar, boolean z) {
        if (oVar != null) {
            a(oVar.abp());
            this.bXh = oVar.getCurrentPage();
            b(oVar.ahg());
            hR(oVar.ahf());
            f(oVar.ahh());
            setTotalCount(oVar.getTotalCount());
            hQ(oVar.getTotalPage());
            this.bXe.addAll(0, oVar.ahe());
        }
    }

    public void b(o oVar, boolean z) {
        if (oVar != null) {
            a(oVar.abp());
            aG(oVar.getCurrentPage());
            b(oVar.ahg());
            hR(oVar.ahf());
            f(oVar.ahh());
            setTotalCount(oVar.getTotalCount());
            hQ(oVar.getTotalPage());
            int size = this.bXe.size();
            if (z && size % this.bXg != 0) {
                for (int i = 0; i < size % this.bXg; i++) {
                    this.bXe.remove(this.bXe.size() - 1);
                }
            }
            this.bXe.addAll(oVar.ahe());
        }
    }

    public ArrayList<k> ahe() {
        return this.bXe;
    }

    public void P(ArrayList<k> arrayList) {
        this.bXe = arrayList;
    }

    public int getTotalPage() {
        return this.bXf;
    }

    public void hQ(int i) {
        this.bXf = i;
    }

    public int getTotalCount() {
        return this.bUM;
    }

    public void setTotalCount(int i) {
        this.bUM = i;
    }

    public int ahf() {
        return this.bXg;
    }

    public void hR(int i) {
        if (i != 0) {
            this.bXg = i;
        }
    }

    public int getCurrentPage() {
        return this.aan;
    }

    public void aG(int i) {
        this.aan = i;
    }

    public void b(ForumData forumData) {
        this.bXc = forumData;
    }

    public ForumData ahg() {
        return this.bXc;
    }

    public void a(AntiData antiData) {
        this.bJJ = antiData;
    }

    public AntiData abp() {
        return this.bJJ;
    }

    public void f(w wVar) {
        this.aCl = wVar;
    }

    public boolean Rv() {
        return (this.aCl == null || this.bXd == null || this.aCl.getAuthor() == null || this.aCl.getAuthor().getUserId() == null || this.bXd.getAuthor() == null || this.bXd.getAuthor().getUserId() == null || !this.aCl.getAuthor().getUserId().equals(this.bXd.getAuthor().getUserId())) ? false : true;
    }

    public boolean li() {
        return this.bXi;
    }

    public boolean hasMore() {
        return this.aan < this.bXf && this.aan * this.bXg < 200;
    }

    public w ahh() {
        return this.aCl;
    }

    public static o a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            o oVar = new o();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            oVar.a(antiData);
            w wVar = new w();
            wVar.a(dataRes.thread);
            oVar.f(wVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            oVar.b(forumData);
            k kVar = new k();
            kVar.a(dataRes.post, context);
            oVar.d(kVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<k> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                k kVar2 = new k();
                kVar2.a(list.get(i), context);
                arrayList.add(kVar2);
            }
            oVar.P(arrayList);
            Page page = dataRes.page;
            int intValue = page.total_page.intValue();
            int intValue2 = page.page_size.intValue() == 0 ? page.page_size.intValue() : 10;
            int intValue3 = page.current_page.intValue();
            int intValue4 = page.total_count.intValue();
            oVar.aG(intValue3);
            oVar.hR(intValue2);
            oVar.setTotalCount(intValue4);
            oVar.hQ(intValue);
            return oVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public void Y(boolean z) {
        this.bXi = z;
    }
}
