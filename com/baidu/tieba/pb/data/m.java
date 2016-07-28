package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.tbadkCore.data.s;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class m {
    private int atN;
    private be bDO;
    private int bQX;
    private AntiData dYA;
    public Error dYC;
    private ForumData dYu;
    private int dYy = 20;
    private int dYz = -1;
    private boolean dYB = false;
    private s dYv = null;
    private ArrayList<s> dYw = new ArrayList<>();
    private int dYx = 1;

    public Error aHo() {
        return this.dYC;
    }

    public s aHp() {
        return this.dYv;
    }

    public void a(s sVar) {
        this.dYv = sVar;
    }

    public int aHq() {
        if (this.dYz == -1) {
            this.dYz = this.bQX;
        }
        return this.dYz;
    }

    public int aHr() {
        return this.dYz;
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            setAntiData(mVar.getAntiData());
            this.dYz = mVar.lk();
            b(mVar.aHv());
            setPageSize(mVar.aHu());
            r(mVar.Iw());
            setTotalCount(mVar.getTotalCount());
            nv(mVar.aEN());
            this.dYw.addAll(0, mVar.aHt());
        }
    }

    public void b(m mVar, boolean z) {
        if (mVar != null) {
            setAntiData(mVar.getAntiData());
            b(mVar.aHv());
            a(mVar.aHp());
            r(mVar.Iw());
            if (mVar.aHt() != null && mVar.aHt().size() > 0) {
                aJ(mVar.lk());
                setPageSize(mVar.aHu());
                setTotalCount(mVar.getTotalCount());
                nv(mVar.aEN());
            }
            int size = this.dYw.size();
            if (z && size % this.dYy != 0) {
                for (int i = 0; i < size % this.dYy; i++) {
                    this.dYw.remove(this.dYw.size() - 1);
                }
            }
            this.dYw.addAll(mVar.aHt());
        }
    }

    public void c(m mVar, boolean z) {
        if (mVar != null) {
            setAntiData(mVar.getAntiData());
            b(mVar.aHv());
            a(mVar.aHp());
            r(mVar.Iw());
            if (mVar.aHt() != null && mVar.aHt().size() > 0) {
                aJ(mVar.lk());
                setPageSize(mVar.aHu());
                setTotalCount(mVar.getTotalCount());
                nv(mVar.aEN());
            }
            int size = this.dYw.size();
            if (z && size % this.dYy != 0) {
                for (int i = 0; i < size % this.dYy; i++) {
                    this.dYw.remove(this.dYw.size() - 1);
                }
            }
            this.dYw.addAll(mVar.aHt());
            aHs();
        }
    }

    public void d(m mVar, boolean z) {
        a(mVar, z);
    }

    public void a(m mVar) {
        if (mVar != null) {
            setAntiData(mVar.getAntiData());
            b(mVar.aHv());
            a(mVar.aHp());
            r(mVar.Iw());
            if (mVar.aHt() != null && mVar.aHt().size() > 0) {
                aJ(mVar.lk());
                setPageSize(mVar.aHu());
                setTotalCount(mVar.getTotalCount());
                nv(mVar.aEN());
                this.dYz = (this.bQX - (((mVar.aHt().size() - 1) + this.dYy) / this.dYy)) + 1;
                if (this.dYz < 0) {
                    this.dYz = 0;
                }
            }
            this.dYw.addAll(mVar.aHt());
        }
    }

    public void aHs() {
        if (this.dYz < 0) {
            this.dYz = this.bQX;
        } else if (this.dYz > this.bQX) {
            this.dYz = this.bQX;
        }
    }

    public ArrayList<s> aHt() {
        return this.dYw;
    }

    public void al(ArrayList<s> arrayList) {
        this.dYw = arrayList;
    }

    public int aEN() {
        return this.dYx;
    }

    public void nv(int i) {
        this.dYx = i;
    }

    public int getTotalCount() {
        return this.atN;
    }

    public void setTotalCount(int i) {
        this.atN = i;
    }

    public int aHu() {
        return this.dYy;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.dYy = i;
        }
    }

    public int lk() {
        return this.bQX;
    }

    public void aJ(int i) {
        this.bQX = i;
    }

    public void b(ForumData forumData) {
        this.dYu = forumData;
    }

    public ForumData aHv() {
        return this.dYu;
    }

    public void setAntiData(AntiData antiData) {
        this.dYA = antiData;
    }

    public AntiData getAntiData() {
        return this.dYA;
    }

    public void r(be beVar) {
        this.bDO = beVar;
    }

    public boolean aqO() {
        return (this.bDO == null || this.dYv == null || this.bDO.getAuthor() == null || this.bDO.getAuthor().getUserId() == null || this.dYv.getAuthor() == null || this.dYv.getAuthor().getUserId() == null || !this.bDO.getAuthor().getUserId().equals(this.dYv.getAuthor().getUserId())) ? false : true;
    }

    public boolean mA() {
        return this.dYB;
    }

    public boolean hasMore() {
        return this.bQX < this.dYx;
    }

    public be Iw() {
        return this.bDO;
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
            be beVar = new be();
            beVar.a(dataRes.thread);
            mVar.r(beVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            mVar.b(forumData);
            s sVar = new s();
            sVar.a(dataRes.post, context);
            mVar.a(sVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<s> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                s sVar2 = new s();
                sVar2.a(list.get(i), context);
                arrayList.add(sVar2);
            }
            mVar.al(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            mVar.setAntiData(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                mVar.aJ(intValue3);
                mVar.setPageSize(intValue2);
                mVar.setTotalCount(intValue4);
                mVar.nv(intValue);
            }
            return mVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
