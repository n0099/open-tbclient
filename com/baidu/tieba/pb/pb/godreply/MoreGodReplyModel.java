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
    private final PbModel fLb;
    private int fLc;
    private int fLd;
    private z.a fLe;
    private final z.a fLf;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fLc = -1;
        this.fLd = -1;
        this.fLf = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void P(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                k beE = MoreGodReplyModel.this.fLb.getPbData().beE();
                if (beE != null) {
                    List<PostData> list2 = beE.fKe;
                    int size = list2.size();
                    if (!v.I(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fLb.a(MoreGodReplyModel.this.fLb.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fLc > 0) {
                    MoreGodReplyModel.this.fLd = MoreGodReplyModel.this.fLc;
                }
                if (MoreGodReplyModel.this.fLe != null) {
                    MoreGodReplyModel.this.fLe.P(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void i(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fLe != null) {
                    MoreGodReplyModel.this.fLe.i(i, str, str2);
                }
            }
        };
        this.fLb = pbModel;
        this.fLb.bhL().b(this.fLf);
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

    public boolean bfw() {
        k beE;
        com.baidu.tieba.pb.data.d pbData = this.fLb.getPbData();
        if (pbData == null || (beE = pbData.beE()) == null) {
            return false;
        }
        if (this.fLd < 0) {
            this.fLd = beE.getCount();
        }
        List<Long> list = beE.fKf;
        int size = list.size();
        int i = this.fLd;
        if (size <= i || beE.fKe.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fLc = min;
        this.isLoading = true;
        this.fLb.bhL().di(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean Ee() {
        return this.isLoading;
    }

    public PbModel bfx() {
        return this.fLb;
    }

    public List<h> bfy() {
        com.baidu.tieba.pb.data.d pbData = this.fLb.getPbData();
        if (pbData == null || pbData.beE() == null || v.I(pbData.beE().fKe)) {
            return null;
        }
        k beE = pbData.beE();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = beE.fKe;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.hfb = i < size + (-1);
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
        this.fLe = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasMoreData() {
        k beE;
        com.baidu.tieba.pb.data.d pbData = this.fLb.getPbData();
        if (pbData == null || (beE = pbData.beE()) == null) {
            return false;
        }
        if (this.fLd < 0) {
            this.fLd = beE.getCount();
        }
        return beE.fKf.size() > this.fLd && beE.fKe.size() < 100;
    }
}
