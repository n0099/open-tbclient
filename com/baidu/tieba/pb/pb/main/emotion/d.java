package com.baidu.tieba.pb.pb.main.emotion;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class d implements BdListView.e {
    final /* synthetic */ PbSearchEmotionActivity evD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbSearchEmotionActivity pbSearchEmotionActivity) {
        this.evD = pbSearchEmotionActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.evD.aNi();
    }
}
