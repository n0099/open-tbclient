package com.baidu.tieba.write;

import android.view.animation.Animation;
import com.baidu.tieba.view.AniImageView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f2666a;
    final /* synthetic */ AudioIcon b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AudioIcon audioIcon, List list) {
        this.b = audioIcon;
        this.f2666a = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        AniImageView aniImageView;
        int i;
        aniImageView = this.b.h;
        List list = this.f2666a;
        i = AudioIcon.g;
        aniImageView.startAnimation((Animation) list.get(i));
    }
}
