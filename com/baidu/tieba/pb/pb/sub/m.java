package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ l bOf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bOf = lVar;
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
        this.bOf.bOd = true;
        arrayList = this.bOf.bNY;
        if (arrayList != null) {
            arrayList2 = this.bOf.bNY;
            if (i < arrayList2.size()) {
                arrayList3 = this.bOf.bNY;
                if (arrayList3.get(i) != null) {
                    l lVar = this.bOf;
                    arrayList4 = this.bOf.bNY;
                    lVar.bNZ = ((com.baidu.tieba.tbadkCore.c.j) arrayList4.get(i)).getId();
                    sparseArray = (SparseArray) view.getTag();
                    if (sparseArray == null && (str = (String) sparseArray.get(com.baidu.tieba.v.tag_photo_username)) != null) {
                        String editable = this.bOf.aIy.getEditText().getText().toString();
                        String string = this.bOf.mActivity.getResources().getString(y.reply_sub_floor);
                        String str5 = "^" + string.replace("%s", ".+") + "$";
                        if (bd.isEmpty(editable) || editable.matches(str5)) {
                            str2 = this.bOf.bOa;
                            if (str2 != null) {
                                Pattern compile = Pattern.compile(string.replace("%s", str));
                                str3 = this.bOf.bOa;
                                if (compile.matcher(str3).lookingAt()) {
                                    l lVar2 = this.bOf;
                                    str4 = this.bOf.bOa;
                                    lVar2.hR(str4);
                                } else {
                                    this.bOf.hQ(str);
                                }
                            } else {
                                this.bOf.hQ(str);
                            }
                            this.bOf.b(i, view);
                            return;
                        }
                        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(editable);
                        this.bOf.bOa = editable;
                        if (!matcher.lookingAt()) {
                            this.bOf.hQ(str);
                        } else {
                            this.bOf.hR(editable);
                        }
                        this.bOf.b(i, view);
                        return;
                    }
                }
            }
        }
        this.bOf.bNZ = null;
        sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
        }
    }
}
