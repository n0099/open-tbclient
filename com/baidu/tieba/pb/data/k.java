package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes2.dex */
public class k {
    private AntiData aBQ;
    private int aOH;
    private ForumData aOp;
    private bb buw;
    public boolean dJR;
    public Error ftA;
    private int mCurrentPage;
    private int dVc = 20;
    private int fty = -1;
    private boolean ftz = false;
    private PostData ftv = null;
    private ArrayList<PostData> ftw = new ArrayList<>();
    private int ftx = 1;

    public Error aZY() {
        return this.ftA;
    }

    public PostData aZZ() {
        return this.ftv;
    }

    public void d(PostData postData) {
        this.ftv = postData;
    }

    public int baa() {
        if (this.fty == -1) {
            this.fty = this.mCurrentPage;
        }
        return this.fty;
    }

    public int bab() {
        return this.fty;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.Ce());
            this.fty = kVar.OW();
            a(kVar.bag());
            setPageSize(kVar.baf());
            Z(kVar.Td());
            setTotalCount(kVar.getTotalCount());
            je(kVar.bae());
            this.ftw.addAll(0, kVar.bad());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.Ce());
            a(kVar.bag());
            d(kVar.aZZ());
            Z(kVar.Td());
            if (kVar.bad() != null && kVar.bad().size() > 0) {
                ca(kVar.OW());
                setPageSize(kVar.baf());
                setTotalCount(kVar.getTotalCount());
                je(kVar.bae());
            }
            int size = this.ftw.size();
            if (z && size % this.dVc != 0) {
                for (int i = 0; i < size % this.dVc; i++) {
                    this.ftw.remove(this.ftw.size() - 1);
                }
            }
            this.ftw.addAll(kVar.bad());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.Ce());
            a(kVar.bag());
            d(kVar.aZZ());
            Z(kVar.Td());
            if (kVar.bad() != null && kVar.bad().size() > 0) {
                ca(kVar.OW());
                setPageSize(kVar.baf());
                setTotalCount(kVar.getTotalCount());
                je(kVar.bae());
            }
            int size = this.ftw.size();
            if (z && size % this.dVc != 0) {
                for (int i = 0; i < size % this.dVc; i++) {
                    this.ftw.remove(this.ftw.size() - 1);
                }
            }
            this.ftw.addAll(kVar.bad());
            bac();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.Ce());
            a(kVar.bag());
            d(kVar.aZZ());
            Z(kVar.Td());
            if (kVar.bad() != null && kVar.bad().size() > 0) {
                ca(kVar.OW());
                setPageSize(kVar.baf());
                setTotalCount(kVar.getTotalCount());
                je(kVar.bae());
                this.fty = (this.mCurrentPage - (((kVar.bad().size() - 1) + this.dVc) / this.dVc)) + 1;
                if (this.fty < 0) {
                    this.fty = 0;
                }
            }
            this.ftw.addAll(kVar.bad());
        }
    }

    public void bac() {
        if (this.fty < 0) {
            this.fty = this.mCurrentPage;
        } else if (this.fty > this.mCurrentPage) {
            this.fty = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bad() {
        return this.ftw;
    }

    public void an(ArrayList<PostData> arrayList) {
        this.ftw = arrayList;
    }

    public int bae() {
        return this.ftx;
    }

    public void je(int i) {
        this.ftx = i;
    }

    public int getTotalCount() {
        return this.aOH;
    }

    public void setTotalCount(int i) {
        this.aOH = i;
    }

    public int baf() {
        return this.dVc;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.dVc = i;
        }
    }

    public int OW() {
        return this.mCurrentPage;
    }

    public void ca(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.aOp = forumData;
    }

    public ForumData bag() {
        return this.aOp;
    }

    public void b(AntiData antiData) {
        this.aBQ = antiData;
    }

    public AntiData Ce() {
        return this.aBQ;
    }

    public void Z(bb bbVar) {
        this.buw = bbVar;
    }

    public boolean aMN() {
        return (this.buw == null || this.ftv == null || this.buw.vk() == null || this.buw.vk().getUserId() == null || this.ftv.vk() == null || this.ftv.vk().getUserId() == null || !this.buw.vk().getUserId().equals(this.ftv.vk().getUserId())) ? false : true;
    }

    public boolean rN() {
        return this.ftz;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.ftx;
    }

    public bb Td() {
        return this.buw;
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
            bb bbVar = new bb();
            bbVar.a(dataRes.thread);
            bbVar.ca(2);
            kVar.Z(bbVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            kVar.a(forumData);
            kVar.dJR = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.js(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            kVar.d(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.js(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            kVar.an(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            kVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                kVar.ca(intValue3);
                kVar.setPageSize(intValue2);
                kVar.setTotalCount(intValue4);
                kVar.je(intValue);
            }
            return kVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
