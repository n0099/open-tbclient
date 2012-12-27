package com.baidu.tieba;

import android.content.Intent;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.account.ak;
import com.baidu.tieba.c.ae;
/* loaded from: classes.dex */
class r implements Handler.Callback {
    final /* synthetic */ TiebaApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        long j;
        switch (message.what) {
            case 1:
                ae.b("TiebaApplication", "handleMessage", "Do Aoto Login" + String.valueOf(message.what));
                if (!TiebaApplication.f()) {
                    Intent intent = new Intent(TiebaApplication.a(), LoginActivity.class);
                    String string = message.getData().getString("account");
                    if (string == null) {
                        string = "";
                    }
                    intent.putExtra("account", string);
                    intent.putExtra("has_exit_dialog", false);
                    intent.setFlags(268435456);
                    TiebaApplication.a().startActivity(intent);
                    break;
                } else {
                    TiebaApplication.a((com.baidu.tieba.a.a) null);
                    MainTabActivity.b(this.a, null, true);
                    break;
                }
            case 2:
                this.a.Q();
                break;
            case 3:
                this.a.R();
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
                this.a.as();
                String str = "";
                switch (this.a.A) {
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
                this.a.a(this.a.A, str, (Location) null);
                break;
        }
        return false;
    }
}
