package com.baidu.tieba.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
import com.baidu.tieba.x;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str;
        String str2;
        String str3;
        String str4;
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null && (str = (String) sparseArray.get(u.tag_photo_username)) != null) {
            String editable = this.a.L.getEditText().getText().toString();
            String string = this.a.f.getResources().getString(x.reply_sub_floor);
            String str5 = "^" + string.replace("%s", ".+") + "$";
            if (ba.c(editable) || editable.matches(str5)) {
                str2 = this.a.R;
                if (str2 != null) {
                    Pattern compile = Pattern.compile(string.replace("%s", str));
                    str3 = this.a.R;
                    if (compile.matcher(str3).lookingAt()) {
                        l lVar = this.a;
                        str4 = this.a.R;
                        lVar.d(str4);
                    } else {
                        this.a.b(str);
                    }
                } else {
                    this.a.b(str);
                }
                this.a.a(i, view);
                return;
            }
            Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(editable);
            this.a.R = editable;
            if (!matcher.lookingAt()) {
                this.a.b(str);
            } else {
                this.a.d(editable);
            }
            this.a.a(i, view);
        }
    }
}
