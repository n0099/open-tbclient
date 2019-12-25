package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private boolean isLoading;
    private final PbModel iyj;
    private int iyk;
    private int iyl;
    private aa.a iym;
    private final aa.a iyn;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.iyk = -1;
        this.iyl = -1;
        this.iyn = new aa.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.aa.a
            public void onSuccess(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                o chV = MoreGodReplyModel.this.iyj.getPbData().chV();
                if (chV != null) {
                    List<PostData> list2 = chV.ixt;
                    int size = list2.size();
                    if (!v.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.iyj.a(MoreGodReplyModel.this.iyj.getPbData(), size);
                }
                if (MoreGodReplyModel.this.iyk > 0) {
                    MoreGodReplyModel.this.iyl = MoreGodReplyModel.this.iyk;
                }
                if (MoreGodReplyModel.this.iym != null) {
                    MoreGodReplyModel.this.iym.onSuccess(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.aa.a
            public void l(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.iym != null) {
                    MoreGodReplyModel.this.iym.l(i, str, str2);
                }
            }
        };
        this.iyj = pbModel;
        this.iyj.clA().b(this.iyn);
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

    public boolean ciT() {
        o chV;
        f pbData = this.iyj.getPbData();
        if (pbData == null || (chV = pbData.chV()) == null) {
            return false;
        }
        if (this.iyl < 0) {
            this.iyl = chV.getCount();
        }
        List<Long> list = chV.ixu;
        int size = list.size();
        int i = this.iyl;
        if (size <= i || chV.ixt.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.iyk = min;
        this.isLoading = true;
        this.iyj.clA().dK(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel ciU() {
        return this.iyj;
    }

    public List<m> ciV() {
        f pbData = this.iyj.getPbData();
        if (pbData == null || pbData.chV() == null || v.isEmpty(pbData.chV().ixt)) {
            return null;
        }
        o chV = pbData.chV();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = chV.ixt;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.kct = i < size + (-1);
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

    public void a(aa.a aVar) {
        this.iym = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Zn() {
        o chV;
        f pbData = this.iyj.getPbData();
        if (pbData == null || (chV = pbData.chV()) == null) {
            return false;
        }
        if (this.iyl < 0) {
            this.iyl = chV.getCount();
        }
        return chV.ixu.size() > this.iyl && chV.ixt.size() < 100;
    }
}
