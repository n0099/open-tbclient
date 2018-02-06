package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel fKa;
    private int fKb;
    private int fKc;
    private y.a fKd;
    private final y.a fKe;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fKb = -1;
        this.fKc = -1;
        this.fKe = new y.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.y.a
            public void L(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                l baF = MoreGodReplyModel.this.fKa.getPbData().baF();
                if (baF != null) {
                    List<PostData> list2 = baF.fIp;
                    int size = list2.size();
                    if (!v.E(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fKa.a(MoreGodReplyModel.this.fKa.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fKb > 0) {
                    MoreGodReplyModel.this.fKc = MoreGodReplyModel.this.fKb;
                }
                if (MoreGodReplyModel.this.fKd != null) {
                    MoreGodReplyModel.this.fKd.L(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.y.a
            public void h(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fKd != null) {
                    MoreGodReplyModel.this.fKd.h(i, str, str2);
                }
            }
        };
        this.fKa = pbModel;
        this.fKa.bdM().b(this.fKe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(List<PostData> list, PostData postData) {
        if (list != null && postData != null) {
            for (PostData postData2 : list) {
                if (postData2 != null) {
                    if (postData2 == postData) {
                        return true;
                    }
                    if (postData2.getId() != null && postData.getId() != null && postData2.getId().equals(postData.getId())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean bbz() {
        l baF;
        com.baidu.tieba.pb.data.d pbData = this.fKa.getPbData();
        if (pbData == null || (baF = pbData.baF()) == null) {
            return false;
        }
        if (this.fKc < 0) {
            this.fKc = baF.getCount();
        }
        List<Long> list = baF.fIq;
        int size = list.size();
        int i = this.fKc;
        if (size <= i || baF.fIp.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fKb = min;
        this.isLoading = true;
        this.fKa.bdM().cV(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean El() {
        return this.isLoading;
    }

    public PbModel bbA() {
        return this.fKa;
    }

    public List<i> bbB() {
        com.baidu.tieba.pb.data.d pbData = this.fKa.getPbData();
        if (pbData == null || pbData.baF() == null || v.E(pbData.baF().fIp)) {
            return null;
        }
        l baF = pbData.baF();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = baF.fIp;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.hby = i < size + (-1);
            }
            i++;
        }
        return arrayList;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.isLoading = false;
        return false;
    }

    public void a(y.a aVar) {
        this.fKd = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aiq() {
        l baF;
        com.baidu.tieba.pb.data.d pbData = this.fKa.getPbData();
        if (pbData == null || (baF = pbData.baF()) == null) {
            return false;
        }
        if (this.fKc < 0) {
            this.fKc = baF.getCount();
        }
        return baF.fIq.size() > this.fKc && baF.fIp.size() < 100;
    }
}
