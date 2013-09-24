package com.baidu.tieba.write;

import android.view.animation.Animation;
import com.baidu.tieba.view.AniImageView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AudioIcon f2121a;
    private final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AudioIcon audioIcon, List list) {
        this.f2121a = audioIcon;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        AniImageView aniImageView;
        int i;
        aniImageView = this.f2121a.h;
        List list = this.b;
        i = AudioIcon.g;
        aniImageView.startAnimation((Animation) list.get(i));
    }
}
