package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ae;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private boolean isLoading;
    private PbModel jGo;
    private int jGp;
    private int jGq;
    private ae.a jGr;
    private final ae.a jGs;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.jGp = -1;
        this.jGq = -1;
        this.jGs = new ae.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ae.a
            public void aN(List<PostData> list) {
                p cCw;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.jGo != null && MoreGodReplyModel.this.jGo.getPbData() != null && (cCw = MoreGodReplyModel.this.jGo.getPbData().cCw()) != null) {
                    List<PostData> list2 = cCw.jFy;
                    int size = list2.size();
                    if (!v.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.jGo.b(MoreGodReplyModel.this.jGo.getPbData(), size);
                }
                if (MoreGodReplyModel.this.jGp > 0) {
                    MoreGodReplyModel.this.jGq = MoreGodReplyModel.this.jGp;
                }
                if (MoreGodReplyModel.this.jGr != null) {
                    MoreGodReplyModel.this.jGr.aN(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ae.a
            public void m(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.jGr != null) {
                    MoreGodReplyModel.this.jGr.m(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.jGo = pbModel;
            ae cFX = pbModel.cFX();
            if (cFX != null) {
                cFX.b(this.jGs);
            }
        }
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

    public boolean cDx() {
        p cCw;
        com.baidu.tieba.pb.data.e pbData = this.jGo.getPbData();
        if (pbData == null || (cCw = pbData.cCw()) == null) {
            return false;
        }
        if (this.jGq < 0) {
            this.jGq = cCw.getCount();
        }
        List<Long> list = cCw.jFz;
        int size = list.size();
        int i = this.jGq;
        if (size <= i || cCw.jFy.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.jGp = min;
        this.isLoading = true;
        this.jGo.cFX().dX(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel cDy() {
        return this.jGo;
    }

    public List<o> cDz() {
        com.baidu.tieba.pb.data.e pbData;
        if (this.jGo == null || (pbData = this.jGo.getPbData()) == null || pbData.cCw() == null || v.isEmpty(pbData.cCw().jFy)) {
            return null;
        }
        p cCw = pbData.cCw();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = cCw.jFy;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.llu = i < size + (-1);
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

    public void a(ae.a aVar) {
        this.jGr = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean anV() {
        com.baidu.tieba.pb.data.e pbData;
        p cCw;
        if (this.jGo == null || (pbData = this.jGo.getPbData()) == null || (cCw = pbData.cCw()) == null) {
            return false;
        }
        if (this.jGq < 0) {
            this.jGq = cCw.getCount();
        }
        return cCw.jFz.size() > this.jGq && cCw.jFy.size() < 100;
    }
}
