package com.baidu.tieba.pb.sub;

import android.app.AlertDialog;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.y;
import java.text.MessageFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str;
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null && (str = (String) sparseArray.get(com.baidu.tieba.v.tag_photo_username)) != null) {
            String editable = this.a.L.getEditText().getText().toString();
            String str2 = "^" + this.a.f.getResources().getString(y.reply_sub_floor).replace("%s", ".+") + "$";
            if (bg.c(editable) || editable.matches(str2)) {
                this.a.b(str);
                this.a.a(i, view);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a.f);
            builder.setTitle(this.a.f.getString(y.anti_title));
            builder.setMessage(MessageFormat.format(this.a.f.getString(y.reply_sub_floor_confirm), str));
            builder.setPositiveButton(this.a.f.getString(y.confirm), new o(this, str, i, view));
            builder.setNegativeButton(this.a.f.getString(y.cancel), new q(this));
            builder.create().show();
        }
    }
}
