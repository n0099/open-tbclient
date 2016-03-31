package com.baidu.tieba.pb.pb.a;

import android.media.MediaPlayer;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements MediaPlayer.OnErrorListener {
    final /* synthetic */ r dej;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(r rVar) {
        this.dej = rVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        boolean z;
        z = this.dej.ddZ;
        if (!z) {
            BdToast.b(this.dej.dfw.getPageContext().getPageActivity(), this.dej.dfw.getPageContext().getResources().getString(t.j.pb_play_error), t.f.icon_toast_game_error).ux();
        }
        this.dej.avS();
        return true;
    }
}
