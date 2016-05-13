package com.baidu.tieba.pb.pb.a;

import android.media.MediaPlayer;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements MediaPlayer.OnErrorListener {
    final /* synthetic */ r dgC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(r rVar) {
        this.dgC = rVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        boolean z;
        z = this.dgC.dgt;
        if (!z) {
            BdToast.b(this.dgC.dhY.getPageContext().getPageActivity(), this.dgC.dhY.getPageContext().getResources().getString(t.j.pb_play_error), t.f.icon_toast_game_error).sd();
        }
        this.dgC.awe();
        return true;
    }
}
