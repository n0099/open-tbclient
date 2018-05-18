package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel feO;
    private int feP;
    private int feQ;
    private y.a feR;
    private final y.a feS;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.feP = -1;
        this.feQ = -1;
        this.feS = new y.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.y.a
            public void D(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                l aVD = MoreGodReplyModel.this.feO.getPbData().aVD();
                if (aVD != null) {
                    List<PostData> list2 = aVD.feb;
                    int size = list2.size();
                    if (!v.w(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.feO.a(MoreGodReplyModel.this.feO.getPbData(), size);
                }
                if (MoreGodReplyModel.this.feP > 0) {
                    MoreGodReplyModel.this.feQ = MoreGodReplyModel.this.feP;
                }
                if (MoreGodReplyModel.this.feR != null) {
                    MoreGodReplyModel.this.feR.D(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.y.a
            public void g(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.feR != null) {
                    MoreGodReplyModel.this.feR.g(i, str, str2);
                }
            }
        };
        this.feO = pbModel;
        this.feO.aYJ().b(this.feS);
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

    public boolean aWw() {
        l aVD;
        com.baidu.tieba.pb.data.d pbData = this.feO.getPbData();
        if (pbData == null || (aVD = pbData.aVD()) == null) {
            return false;
        }
        if (this.feQ < 0) {
            this.feQ = aVD.getCount();
        }
        List<Long> list = aVD.fec;
        int size = list.size();
        int i = this.feQ;
        if (size <= i || aVD.feb.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.feP = min;
        this.isLoading = true;
        this.feO.aYJ().cQ(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean wW() {
        return this.isLoading;
    }

    public PbModel aWx() {
        return this.feO;
    }

    public List<h> aWy() {
        com.baidu.tieba.pb.data.d pbData = this.feO.getPbData();
        if (pbData == null || pbData.aVD() == null || v.w(pbData.aVD().feb)) {
            return null;
        }
        l aVD = pbData.aVD();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = aVD.feb;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.gye = i < size + (-1);
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
        this.feR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean acw() {
        l aVD;
        com.baidu.tieba.pb.data.d pbData = this.feO.getPbData();
        if (pbData == null || (aVD = pbData.aVD()) == null) {
            return false;
        }
        if (this.feQ < 0) {
            this.feQ = aVD.getCount();
        }
        return aVD.fec.size() > this.feQ && aVD.feb.size() < 100;
    }
}
