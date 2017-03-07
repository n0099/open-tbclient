package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.f {
    private final /* synthetic */ int aay;
    final /* synthetic */ TopRecActivity dsm;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.dsm = topRecActivity;
        this.aay = i;
        this.val$id = i2;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        LikeModel likeModel;
        LikeModel likeModel2;
        d dVar;
        if (this.dsm.dsg != null && this.dsm.dsg.forum_list[this.aay] != null) {
            likeModel = this.dsm.brY;
            if (likeModel.getErrorCode() != 22) {
                likeModel2 = this.dsm.brY;
                if (likeModel2.getErrorCode() != 0) {
                    this.dsm.aY(this.aay, this.val$id);
                    return;
                } else if (((v) obj) == null) {
                    this.dsm.aY(this.aay, this.val$id);
                    return;
                } else {
                    this.dsm.axk();
                    TbadkApplication.getInst().addLikeForum(this.dsm.dsg.forum_list[this.aay].forum_name);
                    return;
                }
            }
            this.dsm.dsg.forum_list[this.aay].is_like = 1;
            dVar = this.dsm.dsd;
            dVar.notifyDataSetChanged();
        }
    }
}
