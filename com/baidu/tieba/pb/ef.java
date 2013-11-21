package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.contact.RContact;
import java.text.MessageFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ef implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ed f2145a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(ed edVar) {
        this.f2145a = edVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str;
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null && (str = (String) sparseArray.get(R.id.tag_photo_username)) != null) {
            String obj = this.f2145a.I.getEditText().getText().toString();
            String str2 = "^" + this.f2145a.e.getResources().getString(R.string.reply_sub_floor).replace("%s", ".+") + RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR;
            if (com.baidu.tieba.util.be.c(obj) || obj.matches(str2)) {
                this.f2145a.c(str);
                this.f2145a.a(i, view);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f2145a.e);
            builder.setTitle(this.f2145a.e.getString(R.string.anti_title));
            builder.setMessage(MessageFormat.format(this.f2145a.e.getString(R.string.reply_sub_floor_confirm), str));
            builder.setPositiveButton(this.f2145a.e.getString(R.string.confirm), new eg(this, str, i, view));
            builder.setNegativeButton(this.f2145a.e.getString(R.string.cancel), new ei(this));
            builder.create().show();
        }
    }
}
