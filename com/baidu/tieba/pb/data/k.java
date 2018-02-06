package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes2.dex */
public class k {
    private int bvb;
    private bd cad;
    private ForumData fIg;
    private AntiData fIm;
    public Error fIo;
    private int mCurrentPage;
    private int fIk = 20;
    private int fIl = -1;
    private boolean fIn = false;
    private PostData fIh = null;
    private ArrayList<PostData> fIi = new ArrayList<>();
    private int fIj = 1;

    public Error bbc() {
        return this.fIo;
    }

    public PostData bbd() {
        return this.fIh;
    }

    public void d(PostData postData) {
        this.fIh = postData;
    }

    public int bbe() {
        if (this.fIl == -1) {
            this.fIl = this.mCurrentPage;
        }
        return this.fIl;
    }

    public int bbf() {
        return this.fIl;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.bbl());
            this.fIl = kVar.SC();
            b(kVar.bbk());
            setPageSize(kVar.bbj());
            T(kVar.WE());
            setTotalCount(kVar.getTotalCount());
            lJ(kVar.bbi());
            this.fIi.addAll(0, kVar.bbh());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.bbl());
            b(kVar.bbk());
            d(kVar.bbd());
            T(kVar.WE());
            if (kVar.bbh() != null && kVar.bbh().size() > 0) {
                eW(kVar.SC());
                setPageSize(kVar.bbj());
                setTotalCount(kVar.getTotalCount());
                lJ(kVar.bbi());
            }
            int size = this.fIi.size();
            if (z && size % this.fIk != 0) {
                for (int i = 0; i < size % this.fIk; i++) {
                    this.fIi.remove(this.fIi.size() - 1);
                }
            }
            this.fIi.addAll(kVar.bbh());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.bbl());
            b(kVar.bbk());
            d(kVar.bbd());
            T(kVar.WE());
            if (kVar.bbh() != null && kVar.bbh().size() > 0) {
                eW(kVar.SC());
                setPageSize(kVar.bbj());
                setTotalCount(kVar.getTotalCount());
                lJ(kVar.bbi());
            }
            int size = this.fIi.size();
            if (z && size % this.fIk != 0) {
                for (int i = 0; i < size % this.fIk; i++) {
                    this.fIi.remove(this.fIi.size() - 1);
                }
            }
            this.fIi.addAll(kVar.bbh());
            bbg();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.bbl());
            b(kVar.bbk());
            d(kVar.bbd());
            T(kVar.WE());
            if (kVar.bbh() != null && kVar.bbh().size() > 0) {
                eW(kVar.SC());
                setPageSize(kVar.bbj());
                setTotalCount(kVar.getTotalCount());
                lJ(kVar.bbi());
                this.fIl = (this.mCurrentPage - (((kVar.bbh().size() - 1) + this.fIk) / this.fIk)) + 1;
                if (this.fIl < 0) {
                    this.fIl = 0;
                }
            }
            this.fIi.addAll(kVar.bbh());
        }
    }

    public void bbg() {
        if (this.fIl < 0) {
            this.fIl = this.mCurrentPage;
        } else if (this.fIl > this.mCurrentPage) {
            this.fIl = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bbh() {
        return this.fIi;
    }

    public void ak(ArrayList<PostData> arrayList) {
        this.fIi = arrayList;
    }

    public int bbi() {
        return this.fIj;
    }

    public void lJ(int i) {
        this.fIj = i;
    }

    public int getTotalCount() {
        return this.bvb;
    }

    public void setTotalCount(int i) {
        this.bvb = i;
    }

    public int bbj() {
        return this.fIk;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.fIk = i;
        }
    }

    public int SC() {
        return this.mCurrentPage;
    }

    public void eW(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.fIg = forumData;
    }

    public ForumData bbk() {
        return this.fIg;
    }

    public void b(AntiData antiData) {
        this.fIm = antiData;
    }

    public AntiData bbl() {
        return this.fIm;
    }

    public void T(bd bdVar) {
        this.cad = bdVar;
    }

    public boolean aLq() {
        return (this.cad == null || this.fIh == null || this.cad.zn() == null || this.cad.zn().getUserId() == null || this.fIh.zn() == null || this.fIh.zn().getUserId() == null || !this.cad.zn().getUserId().equals(this.fIh.zn().getUserId())) ? false : true;
    }

    public boolean vX() {
        return this.fIn;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fIj;
    }

    public bd WE() {
        return this.cad;
    }

    public static k a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            k kVar = new k();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            kVar.b(antiData);
            bd bdVar = new bd();
            bdVar.a(dataRes.thread);
            bdVar.eW(2);
            kVar.T(bdVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            kVar.b(forumData);
            PostData postData = new PostData();
            postData.a(dataRes.post, context);
            kVar.d(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            kVar.ak(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            kVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                kVar.eW(intValue3);
                kVar.setPageSize(intValue2);
                kVar.setTotalCount(intValue4);
                kVar.lJ(intValue);
            }
            return kVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
