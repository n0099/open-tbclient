package com.baidu.tieba.pb;

import com.baidu.tieba.view.MultiImageView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageActivity f2115a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ImageActivity imageActivity) {
        this.f2115a = imageActivity;
    }

    @Override // com.baidu.tieba.pb.c
    public void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2) {
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        MultiImageView multiImageView3;
        MultiImageView multiImageView4;
        MultiImageView multiImageView5;
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
            multiImageView10 = this.f2115a.m;
            if (multiImageView10.getCurrentItem() <= 3) {
                multiImageView11 = this.f2115a.m;
                int itemNum = multiImageView11.getItemNum();
                multiImageView12 = this.f2115a.m;
                multiImageView12.setTempSize(itemNum + 100);
                multiImageView13 = this.f2115a.m;
                multiImageView13.a(itemNum + 90, false);
                multiImageView14 = this.f2115a.m;
                multiImageView14.setTempSize(0);
            }
        }
        multiImageView = this.f2115a.m;
        multiImageView.setUrlData(arrayList);
        multiImageView2 = this.f2115a.m;
        multiImageView2.setHasNext(z);
        multiImageView3 = this.f2115a.m;
        multiImageView3.setNextTitle(str);
        if (i >= 0) {
            multiImageView8 = this.f2115a.m;
            if (i < multiImageView8.getItemNum()) {
                multiImageView9 = this.f2115a.m;
                multiImageView9.a(i, false);
            }
        }
        this.f2115a.e = i2;
        if (arrayList.size() >= 400) {
            multiImageView4 = this.f2115a.m;
            if (multiImageView4.getCurrentItem() > 200) {
                for (int i3 = 0; i3 < 200; i3++) {
                    arrayList.remove(0);
                }
                multiImageView5 = this.f2115a.m;
                multiImageView5.setUrlData(arrayList);
                ImageActivity.b(this.f2115a, 200);
                multiImageView6 = this.f2115a.m;
                multiImageView7 = this.f2115a.m;
                multiImageView6.a(multiImageView7.getCurrentItem() - 200, false);
            }
        }
        this.f2115a.f();
    }

    @Override // com.baidu.tieba.pb.c
    public void a(int i, String str) {
        ArrayList arrayList;
        this.f2115a.showToast(str);
        if (i == 40) {
            ImageActivity imageActivity = this.f2115a;
            arrayList = this.f2115a.c;
            imageActivity.e = arrayList.size();
            this.f2115a.f();
        }
    }
}
