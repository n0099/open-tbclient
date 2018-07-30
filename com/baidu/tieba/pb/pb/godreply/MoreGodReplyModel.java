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
    private final PbModel fup;
    private int fuq;
    private int fur;
    private z.a fus;
    private final z.a fut;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fuq = -1;
        this.fur = -1;
        this.fut = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void G(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                l aZy = MoreGodReplyModel.this.fup.getPbData().aZy();
                if (aZy != null) {
                    List<PostData> list2 = aZy.ftB;
                    int size = list2.size();
                    if (!w.z(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fup.a(MoreGodReplyModel.this.fup.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fuq > 0) {
                    MoreGodReplyModel.this.fur = MoreGodReplyModel.this.fuq;
                }
                if (MoreGodReplyModel.this.fus != null) {
                    MoreGodReplyModel.this.fus.G(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void g(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fus != null) {
                    MoreGodReplyModel.this.fus.g(i, str, str2);
                }
            }
        };
        this.fup = pbModel;
        this.fup.bcI().b(this.fut);
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

    public boolean bas() {
        l aZy;
        com.baidu.tieba.pb.data.d pbData = this.fup.getPbData();
        if (pbData == null || (aZy = pbData.aZy()) == null) {
            return false;
        }
        if (this.fur < 0) {
            this.fur = aZy.getCount();
        }
        List<Long> list = aZy.ftC;
        int size = list.size();
        int i = this.fur;
        if (size <= i || aZy.ftB.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fuq = min;
        this.isLoading = true;
        this.fup.bcI().cV(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean AE() {
        return this.isLoading;
    }

    public PbModel bat() {
        return this.fup;
    }

    public List<h> bau() {
        com.baidu.tieba.pb.data.d pbData = this.fup.getPbData();
        if (pbData == null || pbData.aZy() == null || w.z(pbData.aZy().ftB)) {
            return null;
        }
        l aZy = pbData.aZy();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = aZy.ftB;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.gOC = i < size + (-1);
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
        this.fus = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean agT() {
        l aZy;
        com.baidu.tieba.pb.data.d pbData = this.fup.getPbData();
        if (pbData == null || (aZy = pbData.aZy()) == null) {
            return false;
        }
        if (this.fur < 0) {
            this.fur = aZy.getCount();
        }
        return aZy.ftC.size() > this.fur && aZy.ftB.size() < 100;
    }
}
