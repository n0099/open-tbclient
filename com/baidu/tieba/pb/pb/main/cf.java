package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.share.AddExperiencedModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf extends com.baidu.tbadk.util.w<Boolean> {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.w
    public Boolean doInBackground() {
        PbModel pbModel;
        pbModel = this.ewh.eue;
        return Boolean.valueOf(AddExperiencedModel.pi(pbModel.getForumId()));
    }
}
