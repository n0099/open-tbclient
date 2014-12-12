package com.baidu.tieba.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ l bEM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bEM = lVar;
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
        arrayList = this.bEM.bEH;
        if (arrayList != null) {
            arrayList2 = this.bEM.bEH;
            if (i < arrayList2.size()) {
                arrayList3 = this.bEM.bEH;
                if (arrayList3.get(i) != null) {
                    l lVar = this.bEM;
                    arrayList4 = this.bEM.bEH;
                    lVar.bEI = ((com.baidu.tieba.tbadkCore.b.k) arrayList4.get(i)).getId();
                    sparseArray = (SparseArray) view.getTag();
                    if (sparseArray == null && (str = (String) sparseArray.get(w.tag_photo_username)) != null) {
                        String editable = this.bEM.aBE.getEditText().getText().toString();
                        String string = this.bEM.mActivity.getResources().getString(z.reply_sub_floor);
                        String str5 = "^" + string.replace("%s", ".+") + "$";
                        if (ba.isEmpty(editable) || editable.matches(str5)) {
                            str2 = this.bEM.bEJ;
                            if (str2 != null) {
                                Pattern compile = Pattern.compile(string.replace("%s", str));
                                str3 = this.bEM.bEJ;
                                if (compile.matcher(str3).lookingAt()) {
                                    l lVar2 = this.bEM;
                                    str4 = this.bEM.bEJ;
                                    lVar2.hD(str4);
                                } else {
                                    this.bEM.hC(str);
                                }
                            } else {
                                this.bEM.hC(str);
                            }
                            this.bEM.b(i, view);
                            return;
                        }
                        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(editable);
                        this.bEM.bEJ = editable;
                        if (!matcher.lookingAt()) {
                            this.bEM.hC(str);
                        } else {
                            this.bEM.hD(editable);
                        }
                        this.bEM.b(i, view);
                        return;
                    }
                }
            }
        }
        this.bEM.bEI = null;
        sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
        }
    }
}
