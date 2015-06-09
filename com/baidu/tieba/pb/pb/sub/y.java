package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements AdapterView.OnItemClickListener {
    final /* synthetic */ s bPU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(s sVar) {
        this.bPU = sVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        SparseArray sparseArray;
        String str;
        PbEditor pbEditor;
        TbPageContext tbPageContext;
        String str2;
        String str3;
        String str4;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        this.bPU.bPS = true;
        arrayList = this.bPU.bPO;
        if (arrayList != null) {
            arrayList2 = this.bPU.bPO;
            if (i < arrayList2.size()) {
                arrayList3 = this.bPU.bPO;
                if (arrayList3.get(i) != null) {
                    s sVar = this.bPU;
                    arrayList4 = this.bPU.bPO;
                    sVar.bPP = ((com.baidu.tieba.tbadkCore.data.j) arrayList4.get(i)).getId();
                    sparseArray = (SparseArray) view.getTag();
                    if (sparseArray == null && (str = (String) sparseArray.get(com.baidu.tieba.q.tag_photo_username)) != null) {
                        pbEditor = this.bPU.aKP;
                        String editable = pbEditor.getEditText().getText().toString();
                        tbPageContext = this.bPU.Yt;
                        String string = tbPageContext.getResources().getString(com.baidu.tieba.t.reply_sub_floor);
                        String str5 = "^" + string.replace("%s", ".+") + "$";
                        if (bb.isEmpty(editable) || editable.matches(str5)) {
                            str2 = this.bPU.bPQ;
                            if (str2 != null) {
                                Pattern compile = Pattern.compile(string.replace("%s", str));
                                str3 = this.bPU.bPQ;
                                if (compile.matcher(str3).lookingAt()) {
                                    s sVar2 = this.bPU;
                                    str4 = this.bPU.bPQ;
                                    sVar2.iv(str4);
                                } else {
                                    this.bPU.iu(str);
                                }
                            } else {
                                this.bPU.iu(str);
                            }
                            this.bPU.d(i, view);
                            return;
                        }
                        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(editable);
                        this.bPU.bPQ = editable;
                        if (!matcher.lookingAt()) {
                            this.bPU.iu(str);
                        } else {
                            this.bPU.iv(editable);
                        }
                        this.bPU.d(i, view);
                        return;
                    }
                }
            }
        }
        this.bPU.bPP = null;
        sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
        }
    }
}
