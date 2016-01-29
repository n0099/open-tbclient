package com.baidu.tieba.pb.pb.a;

import android.media.MediaPlayer;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements MediaPlayer.OnErrorListener {
    final /* synthetic */ q cKS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(q qVar) {
        this.cKS = qVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        boolean z;
        z = this.cKS.cKH;
        if (!z) {
            BdToast.b(this.cKS.cNL.getPageContext().getPageActivity(), this.cKS.cNL.getPageContext().getResources().getString(t.j.pb_play_error), t.f.icon_toast_game_error).us();
        }
        this.cKS.apb();
        return true;
    }
}
