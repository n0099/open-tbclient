package com.baidu.tieba;

import android.content.Intent;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.account.ak;
import com.baidu.tieba.c.af;
/* loaded from: classes.dex */
class u implements Handler.Callback {
    final /* synthetic */ TiebaApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        long j;
        switch (message.what) {
            case 1:
                af.b("TiebaApplication", "handleMessage", "Do Aoto Login" + String.valueOf(message.what));
                if (TiebaApplication.g()) {
                    TiebaApplication.a((com.baidu.tieba.a.a) null);
                    MainTabActivity.b(this.a, null, true);
                    break;
                } else {
                    Intent intent = new Intent(TiebaApplication.b(), LoginActivity.class);
                    String string = message.getData().getString("account");
                    if (string == null) {
                        string = "";
                    }
                    intent.putExtra("account", string);
                    intent.putExtra("has_exit_dialog", false);
                    intent.setFlags(268435456);
                    TiebaApplication.b().startActivity(intent);
                    break;
                }
            case 2:
                this.a.U();
                break;
            case 3:
                this.a.V();
                break;
            case 4:
                long nanoTime = System.nanoTime();
                j = this.a.t;
                long j2 = (((nanoTime - j) / 1000000) - 180000) / 1000;
                if (j2 > 0) {
                    new ak("use", String.valueOf(j2)).start();
                }
                this.a.t = 0L;
                break;
            case 5:
                this.a.av();
                String str = "";
                switch (this.a.C) {
                    case 1:
                        str = this.a.getString(R.string.loc_gps_off);
                        break;
                    case 2:
                        str = this.a.getString(R.string.loc_net_off);
                        break;
                    case 3:
                        str = this.a.getString(R.string.loc_gps_net_off);
                        break;
                    case 4:
                        str = this.a.getString(R.string.loc_out_of_time);
                        break;
                }
                this.a.a(this.a.C, str, (Location) null);
                break;
        }
        return false;
    }
}
