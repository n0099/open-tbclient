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
    private final PbModel fVG;
    private int fVH;
    private int fVI;
    private z.a fVJ;
    private final z.a fVK;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fVH = -1;
        this.fVI = -1;
        this.fVK = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void Q(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                k bhK = MoreGodReplyModel.this.fVG.getPbData().bhK();
                if (bhK != null) {
                    List<PostData> list2 = bhK.fUJ;
                    int size = list2.size();
                    if (!v.I(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fVG.a(MoreGodReplyModel.this.fVG.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fVH > 0) {
                    MoreGodReplyModel.this.fVI = MoreGodReplyModel.this.fVH;
                }
                if (MoreGodReplyModel.this.fVJ != null) {
                    MoreGodReplyModel.this.fVJ.Q(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void j(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fVJ != null) {
                    MoreGodReplyModel.this.fVJ.j(i, str, str2);
                }
            }
        };
        this.fVG = pbModel;
        this.fVG.bkW().b(this.fVK);
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
        com.baidu.tieba.pb.data.d pbData = this.fVG.getPbData();
        if (pbData == null || (bhK = pbData.bhK()) == null) {
            return false;
        }
        if (this.fVI < 0) {
            this.fVI = bhK.getCount();
        }
        List<Long> list = bhK.fUK;
        int size = list.size();
        int i = this.fVI;
        if (size <= i || bhK.fUJ.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fVH = min;
        this.isLoading = true;
        this.fVG.bkW().m21do(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean Fv() {
        return this.isLoading;
    }

    public PbModel biD() {
        return this.fVG;
    }

    public List<h> biE() {
        com.baidu.tieba.pb.data.d pbData = this.fVG.getPbData();
        if (pbData == null || pbData.bhK() == null || v.I(pbData.bhK().fUJ)) {
            return null;
        }
        k bhK = pbData.bhK();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bhK.fUJ;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.hql = i < size + (-1);
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
        this.fVJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasMoreData() {
        k bhK;
        com.baidu.tieba.pb.data.d pbData = this.fVG.getPbData();
        if (pbData == null || (bhK = pbData.bhK()) == null) {
            return false;
        }
        if (this.fVI < 0) {
            this.fVI = bhK.getCount();
        }
        return bhK.fUK.size() > this.fVI && bhK.fUJ.size() < 100;
    }
}
