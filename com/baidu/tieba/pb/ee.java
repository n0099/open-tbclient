package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ee implements AdapterView.OnItemClickListener {
    final /* synthetic */ ed a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ee(ed edVar) {
        this.a = edVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str;
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null && (str = (String) sparseArray.get(R.id.tag_photo_username)) != null) {
            String editable = this.a.L.getEditText().getText().toString();
            String str2 = "^" + this.a.e.getResources().getString(R.string.reply_sub_floor).replace("%s", ".+") + "$";
            if (com.baidu.tieba.util.bs.c(editable) || editable.matches(str2)) {
                this.a.b(str);
                this.a.a(i, view);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a.e);
            builder.setTitle(this.a.e.getString(R.string.anti_title));
            builder.setMessage(MessageFormat.format(this.a.e.getString(R.string.reply_sub_floor_confirm), str));
            builder.setPositiveButton(this.a.e.getString(R.string.confirm), new ef(this, str, i, view));
            builder.setNegativeButton(this.a.e.getString(R.string.cancel), new eh(this));
            builder.create().show();
        }
    }
}
