package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.tbadkCore.data.q;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class j {
    private bg aMR;
    private int awL;
    private int bLo;
    private ForumData dWV;
    private AntiData dXb;
    public Error dXd;
    private int dWZ = 20;
    private int dXa = -1;
    private boolean dXc = false;
    private q dWW = null;
    private ArrayList<q> dWX = new ArrayList<>();
    private int dWY = 1;

    public Error aIE() {
        return this.dXd;
    }

    public q aIF() {
        return this.dWW;
    }

    public void b(q qVar) {
        this.dWW = qVar;
    }

    public int aIG() {
        if (this.dXa == -1) {
            this.dXa = this.bLo;
        }
        return this.dXa;
    }

    public int aIH() {
        return this.dXa;
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            e(jVar.avW());
            this.dXa = jVar.mi();
            b(jVar.aIL());
            setPageSize(jVar.aIK());
            h(jVar.IU());
            setTotalCount(jVar.getTotalCount());
            nu(jVar.aGa());
            this.dWX.addAll(0, jVar.aIJ());
        }
    }

    public void b(j jVar, boolean z) {
        if (jVar != null) {
            e(jVar.avW());
            b(jVar.aIL());
            b(jVar.aIF());
            h(jVar.IU());
            if (jVar.aIJ() != null && jVar.aIJ().size() > 0) {
                aX(jVar.mi());
                setPageSize(jVar.aIK());
                setTotalCount(jVar.getTotalCount());
                nu(jVar.aGa());
            }
            int size = this.dWX.size();
            if (z && size % this.dWZ != 0) {
                for (int i = 0; i < size % this.dWZ; i++) {
                    this.dWX.remove(this.dWX.size() - 1);
                }
            }
            this.dWX.addAll(jVar.aIJ());
        }
    }

    public void c(j jVar, boolean z) {
        if (jVar != null) {
            e(jVar.avW());
            b(jVar.aIL());
            b(jVar.aIF());
            h(jVar.IU());
            if (jVar.aIJ() != null && jVar.aIJ().size() > 0) {
                aX(jVar.mi());
                setPageSize(jVar.aIK());
                setTotalCount(jVar.getTotalCount());
                nu(jVar.aGa());
            }
            int size = this.dWX.size();
            if (z && size % this.dWZ != 0) {
                for (int i = 0; i < size % this.dWZ; i++) {
                    this.dWX.remove(this.dWX.size() - 1);
                }
            }
            this.dWX.addAll(jVar.aIJ());
            aII();
        }
    }

    public void d(j jVar, boolean z) {
        a(jVar, z);
    }

    public void a(j jVar) {
        if (jVar != null) {
            e(jVar.avW());
            b(jVar.aIL());
            b(jVar.aIF());
            h(jVar.IU());
            if (jVar.aIJ() != null && jVar.aIJ().size() > 0) {
                aX(jVar.mi());
                setPageSize(jVar.aIK());
                setTotalCount(jVar.getTotalCount());
                nu(jVar.aGa());
                this.dXa = (this.bLo - (((jVar.aIJ().size() - 1) + this.dWZ) / this.dWZ)) + 1;
                if (this.dXa < 0) {
                    this.dXa = 0;
                }
            }
            this.dWX.addAll(jVar.aIJ());
        }
    }

    public void aII() {
        if (this.dXa < 0) {
            this.dXa = this.bLo;
        } else if (this.dXa > this.bLo) {
            this.dXa = this.bLo;
        }
    }

    public ArrayList<q> aIJ() {
        return this.dWX;
    }

    public void ae(ArrayList<q> arrayList) {
        this.dWX = arrayList;
    }

    public int aGa() {
        return this.dWY;
    }

    public void nu(int i) {
        this.dWY = i;
    }

    public int getTotalCount() {
        return this.awL;
    }

    public void setTotalCount(int i) {
        this.awL = i;
    }

    public int aIK() {
        return this.dWZ;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.dWZ = i;
        }
    }

    public int mi() {
        return this.bLo;
    }

    public void aX(int i) {
        this.bLo = i;
    }

    public void b(ForumData forumData) {
        this.dWV = forumData;
    }

    public ForumData aIL() {
        return this.dWV;
    }

    public void e(AntiData antiData) {
        this.dXb = antiData;
    }

    public AntiData avW() {
        return this.dXb;
    }

    public void h(bg bgVar) {
        this.aMR = bgVar;
    }

    public boolean asx() {
        return (this.aMR == null || this.dWW == null || this.aMR.getAuthor() == null || this.aMR.getAuthor().getUserId() == null || this.dWW.getAuthor() == null || this.dWW.getAuthor().getUserId() == null || !this.aMR.getAuthor().getUserId().equals(this.dWW.getAuthor().getUserId())) ? false : true;
    }

    public boolean nz() {
        return this.dXc;
    }

    public boolean hasMore() {
        return this.bLo < this.dWY;
    }

    public bg IU() {
        return this.aMR;
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
            bg bgVar = new bg();
            bgVar.a(dataRes.thread);
            jVar.h(bgVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            jVar.b(forumData);
            q qVar = new q();
            qVar.a(dataRes.post, context);
            jVar.b(qVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<q> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                q qVar2 = new q();
                qVar2.a(list.get(i), context);
                arrayList.add(qVar2);
            }
            jVar.ae(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            jVar.e(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                jVar.aX(intValue3);
                jVar.setPageSize(intValue2);
                jVar.setTotalCount(intValue4);
                jVar.nu(intValue);
            }
            return jVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
