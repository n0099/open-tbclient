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
    private final PbModel fUJ;
    private int fUK;
    private int fUL;
    private z.a fUM;
    private final z.a fUN;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fUK = -1;
        this.fUL = -1;
        this.fUN = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void P(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                k bhg = MoreGodReplyModel.this.fUJ.getPbData().bhg();
                if (bhg != null) {
                    List<PostData> list2 = bhg.fTM;
                    int size = list2.size();
                    if (!v.I(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fUJ.a(MoreGodReplyModel.this.fUJ.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fUK > 0) {
                    MoreGodReplyModel.this.fUL = MoreGodReplyModel.this.fUK;
                }
                if (MoreGodReplyModel.this.fUM != null) {
                    MoreGodReplyModel.this.fUM.P(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void j(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fUM != null) {
                    MoreGodReplyModel.this.fUM.j(i, str, str2);
                }
            }
        };
        this.fUJ = pbModel;
        this.fUJ.bko().b(this.fUN);
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

    public boolean bhY() {
        k bhg;
        com.baidu.tieba.pb.data.d pbData = this.fUJ.getPbData();
        if (pbData == null || (bhg = pbData.bhg()) == null) {
            return false;
        }
        if (this.fUL < 0) {
            this.fUL = bhg.getCount();
        }
        List<Long> list = bhg.fTN;
        int size = list.size();
        int i = this.fUL;
        if (size <= i || bhg.fTM.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fUK = min;
        this.isLoading = true;
        this.fUJ.bko().dn(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean Fi() {
        return this.isLoading;
    }

    public PbModel bhZ() {
        return this.fUJ;
    }

    public List<h> bia() {
        com.baidu.tieba.pb.data.d pbData = this.fUJ.getPbData();
        if (pbData == null || pbData.bhg() == null || v.I(pbData.bhg().fTM)) {
            return null;
        }
        k bhg = pbData.bhg();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bhg.fTM;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.hpg = i < size + (-1);
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
        this.fUM = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasMoreData() {
        k bhg;
        com.baidu.tieba.pb.data.d pbData = this.fUJ.getPbData();
        if (pbData == null || (bhg = pbData.bhg()) == null) {
            return false;
        }
        if (this.fUL < 0) {
            this.fUL = bhg.getCount();
        }
        return bhg.fTN.size() > this.fUL && bhg.fTM.size() < 100;
    }
}
