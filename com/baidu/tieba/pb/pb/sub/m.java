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
    final /* synthetic */ l bOv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bOv = lVar;
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
        this.bOv.bOt = true;
        arrayList = this.bOv.bOo;
        if (arrayList != null) {
            arrayList2 = this.bOv.bOo;
            if (i < arrayList2.size()) {
                arrayList3 = this.bOv.bOo;
                if (arrayList3.get(i) != null) {
                    l lVar = this.bOv;
                    arrayList4 = this.bOv.bOo;
                    lVar.bOp = ((com.baidu.tieba.tbadkCore.c.j) arrayList4.get(i)).getId();
                    sparseArray = (SparseArray) view.getTag();
                    if (sparseArray == null && (str = (String) sparseArray.get(com.baidu.tieba.v.tag_photo_username)) != null) {
                        String editable = this.bOv.aIG.getEditText().getText().toString();
                        String string = this.bOv.mActivity.getResources().getString(y.reply_sub_floor);
                        String str5 = "^" + string.replace("%s", ".+") + "$";
                        if (bd.isEmpty(editable) || editable.matches(str5)) {
                            str2 = this.bOv.bOq;
                            if (str2 != null) {
                                Pattern compile = Pattern.compile(string.replace("%s", str));
                                str3 = this.bOv.bOq;
                                if (compile.matcher(str3).lookingAt()) {
                                    l lVar2 = this.bOv;
                                    str4 = this.bOv.bOq;
                                    lVar2.hU(str4);
                                } else {
                                    this.bOv.hT(str);
                                }
                            } else {
                                this.bOv.hT(str);
                            }
                            this.bOv.b(i, view);
                            return;
                        }
                        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(editable);
                        this.bOv.bOq = editable;
                        if (!matcher.lookingAt()) {
                            this.bOv.hT(str);
                        } else {
                            this.bOv.hU(editable);
                        }
                        this.bOv.b(i, view);
                        return;
                    }
                }
            }
        }
        this.bOv.bOp = null;
        sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
        }
    }
}
