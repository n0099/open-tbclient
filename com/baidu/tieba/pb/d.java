package com.baidu.tieba.pb;

import com.baidu.tieba.view.MultiImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class d implements c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageActivity f1270a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ImageActivity imageActivity) {
        this.f1270a = imageActivity;
    }

    @Override // com.baidu.tieba.pb.c
    public void a(ArrayList arrayList, int i, int i2, boolean z, String str, boolean z2) {
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        MultiImageView multiImageView3;
        MultiImageView multiImageView4;
        MultiImageView multiImageView5;
        int i3;
        MultiImageView multiImageView6;
        MultiImageView multiImageView7;
        MultiImageView multiImageView8;
        MultiImageView multiImageView9;
        MultiImageView multiImageView10;
        MultiImageView multiImageView11;
        MultiImageView multiImageView12;
        MultiImageView multiImageView13;
        MultiImageView multiImageView14;
        if (z2) {
            multiImageView10 = this.f1270a.o;
            if (multiImageView10.getCurrentItem() <= 3) {
                multiImageView11 = this.f1270a.o;
                int itemNum = multiImageView11.getItemNum();
                multiImageView12 = this.f1270a.o;
                multiImageView12.setTempSize(itemNum + 100);
                multiImageView13 = this.f1270a.o;
                multiImageView13.a(itemNum + 90, false);
                multiImageView14 = this.f1270a.o;
                multiImageView14.setTempSize(0);
            }
        }
        multiImageView = this.f1270a.o;
        multiImageView.setUrlData(arrayList);
        multiImageView2 = this.f1270a.o;
        multiImageView2.setHasNext(z);
        multiImageView3 = this.f1270a.o;
        multiImageView3.setNextTitle(str);
        if (i >= 0) {
            multiImageView8 = this.f1270a.o;
            if (i < multiImageView8.getItemNum()) {
                multiImageView9 = this.f1270a.o;
                multiImageView9.a(i, false);
            }
        }
        this.f1270a.e = i2;
        if (arrayList.size() >= 400) {
            multiImageView4 = this.f1270a.o;
            if (multiImageView4.getCurrentItem() > 200) {
                for (int i4 = 0; i4 < 200; i4++) {
                    arrayList.remove(0);
                }
                multiImageView5 = this.f1270a.o;
                multiImageView5.setUrlData(arrayList);
                ImageActivity imageActivity = this.f1270a;
                i3 = imageActivity.b;
                imageActivity.b = i3 + 200;
                multiImageView6 = this.f1270a.o;
                multiImageView7 = this.f1270a.o;
                multiImageView6.a(multiImageView7.getCurrentItem() - 200, false);
            }
        }
        this.f1270a.o();
    }

    @Override // com.baidu.tieba.pb.c
    public void a(int i, String str) {
        ArrayList arrayList;
        this.f1270a.a(str);
        if (i == 40) {
            ImageActivity imageActivity = this.f1270a;
            arrayList = this.f1270a.c;
            imageActivity.e = arrayList.size();
            this.f1270a.o();
        }
    }
}
