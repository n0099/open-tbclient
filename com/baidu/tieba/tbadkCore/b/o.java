package com.baidu.tieba.tbadkCore.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class o {
    private x aDm;
    private int aaO;
    private AntiData bLu;
    private int bWF;
    private ForumData bYV;
    public Error bZc;
    private int bYZ = 10;
    private int bZa = -1;
    private boolean bZb = false;
    private k bYW = null;
    private ArrayList<k> bYX = new ArrayList<>();
    private int bYY = 1;

    public Error ahG() {
        return this.bZc;
    }

    public k ahH() {
        return this.bYW;
    }

    public void d(k kVar) {
        this.bYW = kVar;
    }

    public int ahI() {
        if (this.bZa == -1) {
            this.bZa = this.aaO;
        }
        return this.bZa;
    }

    public void a(o oVar, boolean z) {
        if (oVar != null) {
            b(oVar.abT());
            this.bZa = oVar.getCurrentPage();
            b(oVar.ahL());
            ia(oVar.ahK());
            f(oVar.ahM());
            setTotalCount(oVar.getTotalCount());
            hZ(oVar.getTotalPage());
            this.bYX.addAll(0, oVar.ahJ());
        }
    }

    public void b(o oVar, boolean z) {
        if (oVar != null) {
            b(oVar.abT());
            aL(oVar.getCurrentPage());
            b(oVar.ahL());
            ia(oVar.ahK());
            f(oVar.ahM());
            setTotalCount(oVar.getTotalCount());
            hZ(oVar.getTotalPage());
            int size = this.bYX.size();
            if (z && size % this.bYZ != 0) {
                for (int i = 0; i < size % this.bYZ; i++) {
                    this.bYX.remove(this.bYX.size() - 1);
                }
            }
            this.bYX.addAll(oVar.ahJ());
        }
    }

    public ArrayList<k> ahJ() {
        return this.bYX;
    }

    public void Q(ArrayList<k> arrayList) {
        this.bYX = arrayList;
    }

    public int getTotalPage() {
        return this.bYY;
    }

    public void hZ(int i) {
        this.bYY = i;
    }

    public int getTotalCount() {
        return this.bWF;
    }

    public void setTotalCount(int i) {
        this.bWF = i;
    }

    public int ahK() {
        return this.bYZ;
    }

    public void ia(int i) {
        if (i != 0) {
            this.bYZ = i;
        }
    }

    public int getCurrentPage() {
        return this.aaO;
    }

    public void aL(int i) {
        this.aaO = i;
    }

    public void b(ForumData forumData) {
        this.bYV = forumData;
    }

    public ForumData ahL() {
        return this.bYV;
    }

    public void b(AntiData antiData) {
        this.bLu = antiData;
    }

    public AntiData abT() {
        return this.bLu;
    }

    public void f(x xVar) {
        this.aDm = xVar;
    }

    public boolean RR() {
        return (this.aDm == null || this.bYW == null || this.aDm.getAuthor() == null || this.aDm.getAuthor().getUserId() == null || this.bYW.getAuthor() == null || this.bYW.getAuthor().getUserId() == null || !this.aDm.getAuthor().getUserId().equals(this.bYW.getAuthor().getUserId())) ? false : true;
    }

    public boolean li() {
        return this.bZb;
    }

    public boolean hasMore() {
        return this.aaO < this.bYY && this.aaO * this.bYZ < 200;
    }

    public x ahM() {
        return this.aDm;
    }

    public static o a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            o oVar = new o();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            oVar.b(antiData);
            x xVar = new x();
            xVar.a(dataRes.thread);
            oVar.f(xVar);
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
            oVar.Q(arrayList);
            Page page = dataRes.page;
            int intValue = page.total_page.intValue();
            int intValue2 = page.page_size.intValue() == 0 ? page.page_size.intValue() : 10;
            int intValue3 = page.current_page.intValue();
            int intValue4 = page.total_count.intValue();
            oVar.aL(intValue3);
            oVar.ia(intValue2);
            oVar.setTotalCount(intValue4);
            oVar.hZ(intValue);
            return oVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public void Y(boolean z) {
        this.bZb = z;
    }
}
