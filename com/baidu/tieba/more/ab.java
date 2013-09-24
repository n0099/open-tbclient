package com.baidu.tieba.more;

import com.baidu.tieba.model.MoreModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoreActivity f1474a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(MoreActivity moreActivity) {
        this.f1474a = moreActivity;
    }

    @Override // com.baidu.tieba.more.aa
    public void a(int i) {
        MoreModel moreModel;
        MoreModel moreModel2;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 6) {
                                if (i != 7) {
                                    if (i != 8) {
                                        if (i == 5) {
                                            this.f1474a.b(this.f1474a.getString(R.string.deleting));
                                            moreModel = this.f1474a.b;
                                            if (moreModel != null) {
                                                moreModel2 = this.f1474a.b;
                                                moreModel2.b();
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    this.f1474a.n();
                                    return;
                                }
                                this.f1474a.m();
                                return;
                            }
                            this.f1474a.o();
                            return;
                        }
                        this.f1474a.t();
                        return;
                    }
                    this.f1474a.p();
                    return;
                }
                this.f1474a.q();
                return;
            }
            this.f1474a.r();
            return;
        }
        this.f1474a.s();
    }
}
