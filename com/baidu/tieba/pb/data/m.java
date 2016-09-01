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
public class m {
    private int awU;
    private bg bPs;
    private int ccg;
    private AntiData ekE;
    public Error ekG;
    private ForumData eky;
    private int ekC = 20;
    private int ekD = -1;
    private boolean ekF = false;
    private q ekz = null;
    private ArrayList<q> ekA = new ArrayList<>();
    private int ekB = 1;

    public Error aMg() {
        return this.ekG;
    }

    public q aMh() {
        return this.ekz;
    }

    public void a(q qVar) {
        this.ekz = qVar;
    }

    public int aMi() {
        if (this.ekD == -1) {
            this.ekD = this.ccg;
        }
        return this.ekD;
    }

    public int aMj() {
        return this.ekD;
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            setAntiData(mVar.getAntiData());
            this.ekD = mVar.mf();
            b(mVar.aMn());
            setPageSize(mVar.aMm());
            r(mVar.Kw());
            setTotalCount(mVar.getTotalCount());
            nY(mVar.aJF());
            this.ekA.addAll(0, mVar.aMl());
        }
    }

    public void b(m mVar, boolean z) {
        if (mVar != null) {
            setAntiData(mVar.getAntiData());
            b(mVar.aMn());
            a(mVar.aMh());
            r(mVar.Kw());
            if (mVar.aMl() != null && mVar.aMl().size() > 0) {
                aW(mVar.mf());
                setPageSize(mVar.aMm());
                setTotalCount(mVar.getTotalCount());
                nY(mVar.aJF());
            }
            int size = this.ekA.size();
            if (z && size % this.ekC != 0) {
                for (int i = 0; i < size % this.ekC; i++) {
                    this.ekA.remove(this.ekA.size() - 1);
                }
            }
            this.ekA.addAll(mVar.aMl());
        }
    }

    public void c(m mVar, boolean z) {
        if (mVar != null) {
            setAntiData(mVar.getAntiData());
            b(mVar.aMn());
            a(mVar.aMh());
            r(mVar.Kw());
            if (mVar.aMl() != null && mVar.aMl().size() > 0) {
                aW(mVar.mf());
                setPageSize(mVar.aMm());
                setTotalCount(mVar.getTotalCount());
                nY(mVar.aJF());
            }
            int size = this.ekA.size();
            if (z && size % this.ekC != 0) {
                for (int i = 0; i < size % this.ekC; i++) {
                    this.ekA.remove(this.ekA.size() - 1);
                }
            }
            this.ekA.addAll(mVar.aMl());
            aMk();
        }
    }

    public void d(m mVar, boolean z) {
        a(mVar, z);
    }

    public void a(m mVar) {
        if (mVar != null) {
            setAntiData(mVar.getAntiData());
            b(mVar.aMn());
            a(mVar.aMh());
            r(mVar.Kw());
            if (mVar.aMl() != null && mVar.aMl().size() > 0) {
                aW(mVar.mf());
                setPageSize(mVar.aMm());
                setTotalCount(mVar.getTotalCount());
                nY(mVar.aJF());
                this.ekD = (this.ccg - (((mVar.aMl().size() - 1) + this.ekC) / this.ekC)) + 1;
                if (this.ekD < 0) {
                    this.ekD = 0;
                }
            }
            this.ekA.addAll(mVar.aMl());
        }
    }

    public void aMk() {
        if (this.ekD < 0) {
            this.ekD = this.ccg;
        } else if (this.ekD > this.ccg) {
            this.ekD = this.ccg;
        }
    }

    public ArrayList<q> aMl() {
        return this.ekA;
    }

    public void ak(ArrayList<q> arrayList) {
        this.ekA = arrayList;
    }

    public int aJF() {
        return this.ekB;
    }

    public void nY(int i) {
        this.ekB = i;
    }

    public int getTotalCount() {
        return this.awU;
    }

    public void setTotalCount(int i) {
        this.awU = i;
    }

    public int aMm() {
        return this.ekC;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.ekC = i;
        }
    }

    public int mf() {
        return this.ccg;
    }

    public void aW(int i) {
        this.ccg = i;
    }

    public void b(ForumData forumData) {
        this.eky = forumData;
    }

    public ForumData aMn() {
        return this.eky;
    }

    public void setAntiData(AntiData antiData) {
        this.ekE = antiData;
    }

    public AntiData getAntiData() {
        return this.ekE;
    }

    public void r(bg bgVar) {
        this.bPs = bgVar;
    }

    public boolean avC() {
        return (this.bPs == null || this.ekz == null || this.bPs.getAuthor() == null || this.bPs.getAuthor().getUserId() == null || this.ekz.getAuthor() == null || this.ekz.getAuthor().getUserId() == null || !this.bPs.getAuthor().getUserId().equals(this.ekz.getAuthor().getUserId())) ? false : true;
    }

    public boolean nv() {
        return this.ekF;
    }

    public boolean hasMore() {
        return this.ccg < this.ekB;
    }

    public bg Kw() {
        return this.bPs;
    }

    public static m a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            m mVar = new m();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            mVar.setAntiData(antiData);
            bg bgVar = new bg();
            bgVar.a(dataRes.thread);
            mVar.r(bgVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            mVar.b(forumData);
            q qVar = new q();
            qVar.a(dataRes.post, context);
            mVar.a(qVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<q> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                q qVar2 = new q();
                qVar2.a(list.get(i), context);
                arrayList.add(qVar2);
            }
            mVar.ak(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            mVar.setAntiData(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                mVar.aW(intValue3);
                mVar.setPageSize(intValue2);
                mVar.setTotalCount(intValue4);
                mVar.nY(intValue);
            }
            return mVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
