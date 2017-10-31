package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel eJh;
    private int eJi;
    private int eJj;
    private x.a eJk;
    private final x.a eJl;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.eJi = -1;
        this.eJj = -1;
        this.eJl = new x.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.x.a
            public void B(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                n aPY = MoreGodReplyModel.this.eJh.getPbData().aPY();
                if (aPY != null) {
                    List<PostData> list2 = aPY.eHj;
                    int size = list2.size();
                    if (!v.v(list)) {
                        for (PostData postData : list) {
                            if (!list2.contains(postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.eJh.a(MoreGodReplyModel.this.eJh.getPbData(), size);
                }
                if (MoreGodReplyModel.this.eJi > 0) {
                    MoreGodReplyModel.this.eJj = MoreGodReplyModel.this.eJi;
                }
                if (MoreGodReplyModel.this.eJk != null) {
                    MoreGodReplyModel.this.eJk.B(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.x.a
            public void h(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.eJk != null) {
                    MoreGodReplyModel.this.eJk.h(i, str, str2);
                }
            }
        };
        this.eJh = pbModel;
        this.eJh.aSZ().b(this.eJl);
    }

    public boolean aQR() {
        n aPY;
        f pbData = this.eJh.getPbData();
        if (pbData == null || (aPY = pbData.aPY()) == null) {
            return false;
        }
        if (this.eJj < 0) {
            this.eJj = aPY.getCount();
        }
        List<Long> list = aPY.eHk;
        int size = list.size();
        int i = this.eJj;
        if (size <= i || aPY.eHj.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.eJi = min;
        this.isLoading = true;
        this.eJh.aSZ().cv(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean wz() {
        return this.isLoading;
    }

    public PbModel aQS() {
        return this.eJh;
    }

    public List<com.baidu.adp.widget.ListView.f> aQT() {
        f pbData = this.eJh.getPbData();
        if (pbData == null || pbData.aPY() == null || v.v(pbData.aPY().eHj)) {
            return null;
        }
        n aPY = pbData.aPY();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = aPY.eHj;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.gpT = i < size + (-1);
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

    public void a(x.a aVar) {
        this.eJk = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean XU() {
        n aPY;
        f pbData = this.eJh.getPbData();
        if (pbData == null || (aPY = pbData.aPY()) == null) {
            return false;
        }
        if (this.eJj < 0) {
            this.eJj = aPY.getCount();
        }
        return aPY.eHk.size() > this.eJj && aPY.eHj.size() < 100;
    }
}
