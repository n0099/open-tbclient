package com.baidu.tieba.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ l bAL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bAL = lVar;
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
        arrayList = this.bAL.bAG;
        if (arrayList != null) {
            arrayList2 = this.bAL.bAG;
            if (i < arrayList2.size()) {
                arrayList3 = this.bAL.bAG;
                if (arrayList3.get(i) != null) {
                    l lVar = this.bAL;
                    arrayList4 = this.bAL.bAG;
                    lVar.bAH = ((ak) arrayList4.get(i)).getId();
                    sparseArray = (SparseArray) view.getTag();
                    if (sparseArray == null && (str = (String) sparseArray.get(v.tag_photo_username)) != null) {
                        String editable = this.bAL.azA.getEditText().getText().toString();
                        String string = this.bAL.mActivity.getResources().getString(y.reply_sub_floor);
                        String str5 = "^" + string.replace("%s", ".+") + "$";
                        if (ay.aA(editable) || editable.matches(str5)) {
                            str2 = this.bAL.bAI;
                            if (str2 != null) {
                                Pattern compile = Pattern.compile(string.replace("%s", str));
                                str3 = this.bAL.bAI;
                                if (compile.matcher(str3).lookingAt()) {
                                    l lVar2 = this.bAL;
                                    str4 = this.bAL.bAI;
                                    lVar2.he(str4);
                                } else {
                                    this.bAL.hd(str);
                                }
                            } else {
                                this.bAL.hd(str);
                            }
                            this.bAL.b(i, view);
                            return;
                        }
                        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(editable);
                        this.bAL.bAI = editable;
                        if (!matcher.lookingAt()) {
                            this.bAL.hd(str);
                        } else {
                            this.bAL.he(editable);
                        }
                        this.bAL.b(i, view);
                        return;
                    }
                }
            }
        }
        this.bAL.bAH = null;
        sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
        }
    }
}
