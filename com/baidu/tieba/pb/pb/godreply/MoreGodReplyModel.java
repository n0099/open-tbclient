package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel fue;
    private int fuf;
    private int fug;
    private z.a fuh;
    private final z.a fui;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fuf = -1;
        this.fug = -1;
        this.fui = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void H(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                l bbg = MoreGodReplyModel.this.fue.getPbData().bbg();
                if (bbg != null) {
                    List<PostData> list2 = bbg.ftq;
                    int size = list2.size();
                    if (!w.A(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fue.a(MoreGodReplyModel.this.fue.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fuf > 0) {
                    MoreGodReplyModel.this.fug = MoreGodReplyModel.this.fuf;
                }
                if (MoreGodReplyModel.this.fuh != null) {
                    MoreGodReplyModel.this.fuh.H(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void g(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fuh != null) {
                    MoreGodReplyModel.this.fuh.g(i, str, str2);
                }
            }
        };
        this.fue = pbModel;
        this.fue.bep().b(this.fui);
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

    public boolean bbZ() {
        l bbg;
        com.baidu.tieba.pb.data.d pbData = this.fue.getPbData();
        if (pbData == null || (bbg = pbData.bbg()) == null) {
            return false;
        }
        if (this.fug < 0) {
            this.fug = bbg.getCount();
        }
        List<Long> list = bbg.ftr;
        int size = list.size();
        int i = this.fug;
        if (size <= i || bbg.ftq.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fuf = min;
        this.isLoading = true;
        this.fue.bep().cZ(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean AO() {
        return this.isLoading;
    }

    public PbModel bca() {
        return this.fue;
    }

    public List<h> bcb() {
        com.baidu.tieba.pb.data.d pbData = this.fue.getPbData();
        if (pbData == null || pbData.bbg() == null || w.A(pbData.bbg().ftq)) {
            return null;
        }
        l bbg = pbData.bbg();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bbg.ftq;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.gNE = i < size + (-1);
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

    public void a(z.a aVar) {
        this.fuh = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean agy() {
        l bbg;
        com.baidu.tieba.pb.data.d pbData = this.fue.getPbData();
        if (pbData == null || (bbg = pbData.bbg()) == null) {
            return false;
        }
        if (this.fug < 0) {
            this.fug = bbg.getCount();
        }
        return bbg.ftr.size() > this.fug && bbg.ftq.size() < 100;
    }
}
