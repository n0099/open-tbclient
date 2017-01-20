package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes.dex */
class c extends com.baidu.adp.base.f {
    private final /* synthetic */ int Vn;
    final /* synthetic */ TopRecActivity dpT;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TopRecActivity topRecActivity, int i, int i2) {
        this.dpT = topRecActivity;
        this.Vn = i;
        this.val$id = i2;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        LikeModel likeModel;
        LikeModel likeModel2;
        d dVar;
        if (this.dpT.dpN != null && this.dpT.dpN.forum_list[this.Vn] != null) {
            likeModel = this.dpT.Fq;
            if (likeModel.getErrorCode() != 22) {
                likeModel2 = this.dpT.Fq;
                if (likeModel2.getErrorCode() != 0) {
                    this.dpT.aU(this.Vn, this.val$id);
                    return;
                } else if (((v) obj) == null) {
                    this.dpT.aU(this.Vn, this.val$id);
                    return;
                } else {
                    this.dpT.axO();
                    TbadkApplication.getInst().addLikeForum(this.dpT.dpN.forum_list[this.Vn].forum_name);
                    return;
                }
            }
            this.dpT.dpN.forum_list[this.Vn].is_like = 1;
            dVar = this.dpT.dpK;
            dVar.notifyDataSetChanged();
        }
    }
}
