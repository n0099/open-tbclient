package com.baidu.tieba.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ l bAZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bAZ = lVar;
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
        arrayList = this.bAZ.bAU;
        if (arrayList != null) {
            arrayList2 = this.bAZ.bAU;
            if (i < arrayList2.size()) {
                arrayList3 = this.bAZ.bAU;
                if (arrayList3.get(i) != null) {
                    l lVar = this.bAZ;
                    arrayList4 = this.bAZ.bAU;
                    lVar.bAV = ((ak) arrayList4.get(i)).getId();
                    sparseArray = (SparseArray) view.getTag();
                    if (sparseArray == null && (str = (String) sparseArray.get(v.tag_photo_username)) != null) {
                        String editable = this.bAZ.azJ.getEditText().getText().toString();
                        String string = this.bAZ.mActivity.getResources().getString(y.reply_sub_floor);
                        String str5 = "^" + string.replace("%s", ".+") + "$";
                        if (az.aA(editable) || editable.matches(str5)) {
                            str2 = this.bAZ.bAW;
                            if (str2 != null) {
                                Pattern compile = Pattern.compile(string.replace("%s", str));
                                str3 = this.bAZ.bAW;
                                if (compile.matcher(str3).lookingAt()) {
                                    l lVar2 = this.bAZ;
                                    str4 = this.bAZ.bAW;
                                    lVar2.he(str4);
                                } else {
                                    this.bAZ.hd(str);
                                }
                            } else {
                                this.bAZ.hd(str);
                            }
                            this.bAZ.b(i, view);
                            return;
                        }
                        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(editable);
                        this.bAZ.bAW = editable;
                        if (!matcher.lookingAt()) {
                            this.bAZ.hd(str);
                        } else {
                            this.bAZ.he(editable);
                        }
                        this.bAZ.b(i, view);
                        return;
                    }
                }
            }
        }
        this.bAZ.bAV = null;
        sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
        }
    }
}
