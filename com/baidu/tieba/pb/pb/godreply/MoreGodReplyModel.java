package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel fVH;
    private int fVI;
    private int fVJ;
    private z.a fVK;
    private final z.a fVL;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fVI = -1;
        this.fVJ = -1;
        this.fVL = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void Q(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                k bhK = MoreGodReplyModel.this.fVH.getPbData().bhK();
                if (bhK != null) {
                    List<PostData> list2 = bhK.fUK;
                    int size = list2.size();
                    if (!v.I(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fVH.a(MoreGodReplyModel.this.fVH.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fVI > 0) {
                    MoreGodReplyModel.this.fVJ = MoreGodReplyModel.this.fVI;
                }
                if (MoreGodReplyModel.this.fVK != null) {
                    MoreGodReplyModel.this.fVK.Q(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void j(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fVK != null) {
                    MoreGodReplyModel.this.fVK.j(i, str, str2);
                }
            }
        };
        this.fVH = pbModel;
        this.fVH.bkW().b(this.fVL);
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

    public boolean biC() {
        k bhK;
        com.baidu.tieba.pb.data.d pbData = this.fVH.getPbData();
        if (pbData == null || (bhK = pbData.bhK()) == null) {
            return false;
        }
        if (this.fVJ < 0) {
            this.fVJ = bhK.getCount();
        }
        List<Long> list = bhK.fUL;
        int size = list.size();
        int i = this.fVJ;
        if (size <= i || bhK.fUK.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fVI = min;
        this.isLoading = true;
        this.fVH.bkW().m21do(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean Fv() {
        return this.isLoading;
    }

    public PbModel biD() {
        return this.fVH;
    }

    public List<h> biE() {
        com.baidu.tieba.pb.data.d pbData = this.fVH.getPbData();
        if (pbData == null || pbData.bhK() == null || v.I(pbData.bhK().fUK)) {
            return null;
        }
        k bhK = pbData.bhK();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bhK.fUK;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.hqm = i < size + (-1);
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
        this.fVK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasMoreData() {
        k bhK;
        com.baidu.tieba.pb.data.d pbData = this.fVH.getPbData();
        if (pbData == null || (bhK = pbData.bhK()) == null) {
            return false;
        }
        if (this.fVJ < 0) {
            this.fVJ = bhK.getCount();
        }
        return bhK.fUL.size() > this.fVJ && bhK.fUK.size() < 100;
    }
}
