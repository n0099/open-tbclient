package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class j {
    private int aBk;
    private bj aRF;
    private ForumData ein;
    private AntiData eit;
    public Error eiv;
    private int mCurrentPage;
    private int eir = 20;
    private int eis = -1;
    private boolean eiu = false;
    private PostData eio = null;
    private ArrayList<PostData> eip = new ArrayList<>();
    private int eiq = 1;

    public Error aJN() {
        return this.eiv;
    }

    public PostData aJO() {
        return this.eio;
    }

    public void b(PostData postData) {
        this.eio = postData;
    }

    public int aJP() {
        if (this.eis == -1) {
            this.eis = this.mCurrentPage;
        }
        return this.eis;
    }

    public int aJQ() {
        return this.eis;
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            e(jVar.awz());
            this.eis = jVar.Jg();
            b(jVar.aJU());
            setPageSize(jVar.aJT());
            h(jVar.JN());
            setTotalCount(jVar.getTotalCount());
            gO(jVar.aHn());
            this.eip.addAll(0, jVar.aJS());
        }
    }

    public void b(j jVar, boolean z) {
        if (jVar != null) {
            e(jVar.awz());
            b(jVar.aJU());
            b(jVar.aJO());
            h(jVar.JN());
            if (jVar.aJS() != null && jVar.aJS().size() > 0) {
                bU(jVar.Jg());
                setPageSize(jVar.aJT());
                setTotalCount(jVar.getTotalCount());
                gO(jVar.aHn());
            }
            int size = this.eip.size();
            if (z && size % this.eir != 0) {
                for (int i = 0; i < size % this.eir; i++) {
                    this.eip.remove(this.eip.size() - 1);
                }
            }
            this.eip.addAll(jVar.aJS());
        }
    }

    public void c(j jVar, boolean z) {
        if (jVar != null) {
            e(jVar.awz());
            b(jVar.aJU());
            b(jVar.aJO());
            h(jVar.JN());
            if (jVar.aJS() != null && jVar.aJS().size() > 0) {
                bU(jVar.Jg());
                setPageSize(jVar.aJT());
                setTotalCount(jVar.getTotalCount());
                gO(jVar.aHn());
            }
            int size = this.eip.size();
            if (z && size % this.eir != 0) {
                for (int i = 0; i < size % this.eir; i++) {
                    this.eip.remove(this.eip.size() - 1);
                }
            }
            this.eip.addAll(jVar.aJS());
            aJR();
        }
    }

    public void d(j jVar, boolean z) {
        a(jVar, z);
    }

    public void a(j jVar) {
        if (jVar != null) {
            e(jVar.awz());
            b(jVar.aJU());
            b(jVar.aJO());
            h(jVar.JN());
            if (jVar.aJS() != null && jVar.aJS().size() > 0) {
                bU(jVar.Jg());
                setPageSize(jVar.aJT());
                setTotalCount(jVar.getTotalCount());
                gO(jVar.aHn());
                this.eis = (this.mCurrentPage - (((jVar.aJS().size() - 1) + this.eir) / this.eir)) + 1;
                if (this.eis < 0) {
                    this.eis = 0;
                }
            }
            this.eip.addAll(jVar.aJS());
        }
    }

    public void aJR() {
        if (this.eis < 0) {
            this.eis = this.mCurrentPage;
        } else if (this.eis > this.mCurrentPage) {
            this.eis = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aJS() {
        return this.eip;
    }

    public void aj(ArrayList<PostData> arrayList) {
        this.eip = arrayList;
    }

    public int aHn() {
        return this.eiq;
    }

    public void gO(int i) {
        this.eiq = i;
    }

    public int getTotalCount() {
        return this.aBk;
    }

    public void setTotalCount(int i) {
        this.aBk = i;
    }

    public int aJT() {
        return this.eir;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.eir = i;
        }
    }

    public int Jg() {
        return this.mCurrentPage;
    }

    public void bU(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.ein = forumData;
    }

    public ForumData aJU() {
        return this.ein;
    }

    public void e(AntiData antiData) {
        this.eit = antiData;
    }

    public AntiData awz() {
        return this.eit;
    }

    public void h(bj bjVar) {
        this.aRF = bjVar;
    }

    public boolean asY() {
        return (this.aRF == null || this.eio == null || this.aRF.getAuthor() == null || this.aRF.getAuthor().getUserId() == null || this.eio.getAuthor() == null || this.eio.getAuthor().getUserId() == null || !this.aRF.getAuthor().getUserId().equals(this.eio.getAuthor().getUserId())) ? false : true;
    }

    public boolean nH() {
        return this.eiu;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.eiq;
    }

    public bj JN() {
        return this.aRF;
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
            bj bjVar = new bj();
            bjVar.a(dataRes.thread);
            bjVar.bU(2);
            jVar.h(bjVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            jVar.b(forumData);
            PostData postData = new PostData();
            postData.a(dataRes.post, context);
            jVar.b(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            jVar.aj(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            jVar.e(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                jVar.bU(intValue3);
                jVar.setPageSize(intValue2);
                jVar.setTotalCount(intValue4);
                jVar.gO(intValue);
            }
            return jVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
