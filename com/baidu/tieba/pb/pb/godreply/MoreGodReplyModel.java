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
    private final PbModel fui;
    private int fuj;
    private int fuk;
    private z.a ful;
    private final z.a fum;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fuj = -1;
        this.fuk = -1;
        this.fum = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void G(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                l aZt = MoreGodReplyModel.this.fui.getPbData().aZt();
                if (aZt != null) {
                    List<PostData> list2 = aZt.ftu;
                    int size = list2.size();
                    if (!w.z(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fui.a(MoreGodReplyModel.this.fui.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fuj > 0) {
                    MoreGodReplyModel.this.fuk = MoreGodReplyModel.this.fuj;
                }
                if (MoreGodReplyModel.this.ful != null) {
                    MoreGodReplyModel.this.ful.G(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void g(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.ful != null) {
                    MoreGodReplyModel.this.ful.g(i, str, str2);
                }
            }
        };
        this.fui = pbModel;
        this.fui.bcD().b(this.fum);
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

    public boolean ban() {
        l aZt;
        com.baidu.tieba.pb.data.d pbData = this.fui.getPbData();
        if (pbData == null || (aZt = pbData.aZt()) == null) {
            return false;
        }
        if (this.fuk < 0) {
            this.fuk = aZt.getCount();
        }
        List<Long> list = aZt.ftv;
        int size = list.size();
        int i = this.fuk;
        if (size <= i || aZt.ftu.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fuj = min;
        this.isLoading = true;
        this.fui.bcD().cV(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean AB() {
        return this.isLoading;
    }

    public PbModel bao() {
        return this.fui;
    }

    public List<h> bap() {
        com.baidu.tieba.pb.data.d pbData = this.fui.getPbData();
        if (pbData == null || pbData.aZt() == null || w.z(pbData.aZt().ftu)) {
            return null;
        }
        l aZt = pbData.aZt();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = aZt.ftu;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.gOE = i < size + (-1);
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
        this.ful = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean agV() {
        l aZt;
        com.baidu.tieba.pb.data.d pbData = this.fui.getPbData();
        if (pbData == null || (aZt = pbData.aZt()) == null) {
            return false;
        }
        if (this.fuk < 0) {
            this.fuk = aZt.getCount();
        }
        return aZt.ftv.size() > this.fuk && aZt.ftu.size() < 100;
    }
}
