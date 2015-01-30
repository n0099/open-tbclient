package com.baidu.tieba.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ l bGx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bGx = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        SparseArray sparseArray;
        String str;
        String str2;
        String str3;
        String str4;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        arrayList = this.bGx.bGs;
        if (arrayList != null) {
            arrayList2 = this.bGx.bGs;
            if (i < arrayList2.size()) {
                arrayList3 = this.bGx.bGs;
                if (arrayList3.get(i) != null) {
                    l lVar = this.bGx;
                    arrayList4 = this.bGx.bGs;
                    lVar.bGt = ((com.baidu.tieba.tbadkCore.b.k) arrayList4.get(i)).getId();
                    sparseArray = (SparseArray) view.getTag();
                    if (sparseArray == null && (str = (String) sparseArray.get(w.tag_photo_username)) != null) {
                        String editable = this.bGx.aCF.getEditText().getText().toString();
                        String string = this.bGx.mActivity.getResources().getString(z.reply_sub_floor);
                        String str5 = "^" + string.replace("%s", ".+") + "$";
                        if (bf.isEmpty(editable) || editable.matches(str5)) {
                            str2 = this.bGx.bGu;
                            if (str2 != null) {
                                Pattern compile = Pattern.compile(string.replace("%s", str));
                                str3 = this.bGx.bGu;
                                if (compile.matcher(str3).lookingAt()) {
                                    l lVar2 = this.bGx;
                                    str4 = this.bGx.bGu;
                                    lVar2.hK(str4);
                                } else {
                                    this.bGx.hJ(str);
                                }
                            } else {
                                this.bGx.hJ(str);
                            }
                            this.bGx.b(i, view);
                            return;
                        }
                        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(editable);
                        this.bGx.bGu = editable;
                        if (!matcher.lookingAt()) {
                            this.bGx.hJ(str);
                        } else {
                            this.bGx.hK(editable);
                        }
                        this.bGx.b(i, view);
                        return;
                    }
                }
            }
        }
        this.bGx.bGt = null;
        sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
        }
    }
}
