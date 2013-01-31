package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ BrowseSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(BrowseSettingActivity browseSettingActivity) {
        this.a = browseSettingActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        switch (view.getId()) {
            case R.id.show_photo /* 2131230864 */:
                alertDialog = this.a.g;
                if (alertDialog == null) {
                    this.a.g = new AlertDialog.Builder(this.a).setTitle(R.string.show_photo).setItems(R.array.menu_view_images, new w(this)).create();
                }
                alertDialog2 = this.a.g;
                alertDialog2.setCanceledOnTouchOutside(true);
                alertDialog3 = this.a.g;
                alertDialog3.show();
                return;
            default:
                return;
        }
    }
}
