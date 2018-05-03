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
    private final PbModel fdH;
    private int fdI;
    private int fdJ;
    private y.a fdK;
    private final y.a fdL;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fdI = -1;
        this.fdJ = -1;
        this.fdL = new y.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.y.a
            public void D(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                l aVD = MoreGodReplyModel.this.fdH.getPbData().aVD();
                if (aVD != null) {
                    List<PostData> list2 = aVD.fcU;
                    int size = list2.size();
                    if (!v.w(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fdH.a(MoreGodReplyModel.this.fdH.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fdI > 0) {
                    MoreGodReplyModel.this.fdJ = MoreGodReplyModel.this.fdI;
                }
                if (MoreGodReplyModel.this.fdK != null) {
                    MoreGodReplyModel.this.fdK.D(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.y.a
            public void g(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fdK != null) {
                    MoreGodReplyModel.this.fdK.g(i, str, str2);
                }
            }
        };
        this.fdH = pbModel;
        this.fdH.aYJ().b(this.fdL);
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
        com.baidu.tieba.pb.data.d pbData = this.fdH.getPbData();
        if (pbData == null || (aVD = pbData.aVD()) == null) {
            return false;
        }
        if (this.fdJ < 0) {
            this.fdJ = aVD.getCount();
        }
        List<Long> list = aVD.fcV;
        int size = list.size();
        int i = this.fdJ;
        if (size <= i || aVD.fcU.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fdI = min;
        this.isLoading = true;
        this.fdH.aYJ().cN(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean wX() {
        return this.isLoading;
    }

    public PbModel aWx() {
        return this.fdH;
    }

    public List<h> aWy() {
        com.baidu.tieba.pb.data.d pbData = this.fdH.getPbData();
        if (pbData == null || pbData.aVD() == null || v.w(pbData.aVD().fcU)) {
            return null;
        }
        l aVD = pbData.aVD();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = aVD.fcU;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.gxa = i < size + (-1);
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
        this.fdK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean acw() {
        l aVD;
        com.baidu.tieba.pb.data.d pbData = this.fdH.getPbData();
        if (pbData == null || (aVD = pbData.aVD()) == null) {
            return false;
        }
        if (this.fdJ < 0) {
            this.fdJ = aVD.getCount();
        }
        return aVD.fcV.size() > this.fdJ && aVD.fcU.size() < 100;
    }
}
