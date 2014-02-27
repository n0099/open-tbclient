package com.baidu.tieba.more;
/* loaded from: classes.dex */
final class ac implements ab {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // com.baidu.tieba.more.ab
    public final void a(int i) {
        if (i == 0) {
            MoreActivity.b(this.a);
        } else if (i == 1) {
            MoreActivity.c(this.a);
        } else if (i == 2) {
            MoreActivity.d(this.a);
        } else if (i != 3) {
            if (i != 4) {
                if (i != 6) {
                    if (i != 7) {
                        if (i == 8) {
                            MoreActivity.i(this.a);
                            return;
                        } else if (i == 5) {
                            SystemHelpSettingActivity.a(this.a);
                            return;
                        } else if (i != 9) {
                            return;
                        } else {
                            SecretSettingActivity.a(this.a);
                            return;
                        }
                    }
                    this.a.b();
                    return;
                }
                AboutActivity.a(this.a);
                return;
            }
            MsgRemindActivity.a(this.a);
        } else {
            BrowseSettingActivity.a(this.a);
        }
    }
}
