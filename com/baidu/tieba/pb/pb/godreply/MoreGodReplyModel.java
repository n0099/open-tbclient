package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel fql;
    private int fqm;
    private int fqn;
    private y.a fqo;
    private final y.a fqp;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fqm = -1;
        this.fqn = -1;
        this.fqp = new y.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.y.a
            public void G(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                l baz = MoreGodReplyModel.this.fql.getPbData().baz();
                if (baz != null) {
                    List<PostData> list2 = baz.fpy;
                    int size = list2.size();
                    if (!w.z(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fql.a(MoreGodReplyModel.this.fql.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fqm > 0) {
                    MoreGodReplyModel.this.fqn = MoreGodReplyModel.this.fqm;
                }
                if (MoreGodReplyModel.this.fqo != null) {
                    MoreGodReplyModel.this.fqo.G(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.y.a
            public void g(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fqo != null) {
                    MoreGodReplyModel.this.fqo.g(i, str, str2);
                }
            }
        };
        this.fql = pbModel;
        this.fql.bdH().b(this.fqp);
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

    public boolean bbs() {
        l baz;
        com.baidu.tieba.pb.data.d pbData = this.fql.getPbData();
        if (pbData == null || (baz = pbData.baz()) == null) {
            return false;
        }
        if (this.fqn < 0) {
            this.fqn = baz.getCount();
        }
        List<Long> list = baz.fpz;
        int size = list.size();
        int i = this.fqn;
        if (size <= i || baz.fpy.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fqm = min;
        this.isLoading = true;
        this.fql.bdH().cV(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean Ax() {
        return this.isLoading;
    }

    public PbModel bbt() {
        return this.fql;
    }

    public List<h> bbu() {
        com.baidu.tieba.pb.data.d pbData = this.fql.getPbData();
        if (pbData == null || pbData.baz() == null || w.z(pbData.baz().fpy)) {
            return null;
        }
        l baz = pbData.baz();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = baz.fpy;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.gJD = i < size + (-1);
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
        this.fqo = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean afT() {
        l baz;
        com.baidu.tieba.pb.data.d pbData = this.fql.getPbData();
        if (pbData == null || (baz = pbData.baz()) == null) {
            return false;
        }
        if (this.fqn < 0) {
            this.fqn = baz.getCount();
        }
        return baz.fpz.size() > this.fqn && baz.fpy.size() < 100;
    }
}
