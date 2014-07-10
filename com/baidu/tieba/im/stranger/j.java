package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class j implements l {
    final /* synthetic */ StrangerListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(StrangerListActivity strangerListActivity) {
        this.a = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.stranger.l
    public void a() {
        this.a.closeLoadingDialog();
        this.a.finish();
    }
}
