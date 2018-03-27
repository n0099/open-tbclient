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
    private final PbModel fKf;
    private int fKg;
    private int fKh;
    private y.a fKi;
    private final y.a fKj;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fKg = -1;
        this.fKh = -1;
        this.fKj = new y.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.y.a
            public void L(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                l baF = MoreGodReplyModel.this.fKf.getPbData().baF();
                if (baF != null) {
                    List<PostData> list2 = baF.fIu;
                    int size = list2.size();
                    if (!v.E(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fKf.a(MoreGodReplyModel.this.fKf.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fKg > 0) {
                    MoreGodReplyModel.this.fKh = MoreGodReplyModel.this.fKg;
                }
                if (MoreGodReplyModel.this.fKi != null) {
                    MoreGodReplyModel.this.fKi.L(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.y.a
            public void h(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fKi != null) {
                    MoreGodReplyModel.this.fKi.h(i, str, str2);
                }
            }
        };
        this.fKf = pbModel;
        this.fKf.bdM().b(this.fKj);
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
        com.baidu.tieba.pb.data.d pbData = this.fKf.getPbData();
        if (pbData == null || (baF = pbData.baF()) == null) {
            return false;
        }
        if (this.fKh < 0) {
            this.fKh = baF.getCount();
        }
        List<Long> list = baF.fIv;
        int size = list.size();
        int i = this.fKh;
        if (size <= i || baF.fIu.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fKg = min;
        this.isLoading = true;
        this.fKf.bdM().cV(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean El() {
        return this.isLoading;
    }

    public PbModel bbA() {
        return this.fKf;
    }

    public List<i> bbB() {
        com.baidu.tieba.pb.data.d pbData = this.fKf.getPbData();
        if (pbData == null || pbData.baF() == null || v.E(pbData.baF().fIu)) {
            return null;
        }
        l baF = pbData.baF();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = baF.fIu;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.hbH = i < size + (-1);
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
        this.fKi = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aiq() {
        l baF;
        com.baidu.tieba.pb.data.d pbData = this.fKf.getPbData();
        if (pbData == null || (baF = pbData.baF()) == null) {
            return false;
        }
        if (this.fKh < 0) {
            this.fKh = baF.getCount();
        }
        return baF.fIv.size() > this.fKh && baF.fIu.size() < 100;
    }
}
