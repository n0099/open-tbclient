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
    final /* synthetic */ s bPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(s sVar) {
        this.bPT = sVar;
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
        this.bPT.bPR = true;
        arrayList = this.bPT.bPN;
        if (arrayList != null) {
            arrayList2 = this.bPT.bPN;
            if (i < arrayList2.size()) {
                arrayList3 = this.bPT.bPN;
                if (arrayList3.get(i) != null) {
                    s sVar = this.bPT;
                    arrayList4 = this.bPT.bPN;
                    sVar.bPO = ((com.baidu.tieba.tbadkCore.data.j) arrayList4.get(i)).getId();
                    sparseArray = (SparseArray) view.getTag();
                    if (sparseArray == null && (str = (String) sparseArray.get(com.baidu.tieba.q.tag_photo_username)) != null) {
                        pbEditor = this.bPT.aKO;
                        String editable = pbEditor.getEditText().getText().toString();
                        tbPageContext = this.bPT.Yt;
                        String string = tbPageContext.getResources().getString(com.baidu.tieba.t.reply_sub_floor);
                        String str5 = "^" + string.replace("%s", ".+") + "$";
                        if (bb.isEmpty(editable) || editable.matches(str5)) {
                            str2 = this.bPT.bPP;
                            if (str2 != null) {
                                Pattern compile = Pattern.compile(string.replace("%s", str));
                                str3 = this.bPT.bPP;
                                if (compile.matcher(str3).lookingAt()) {
                                    s sVar2 = this.bPT;
                                    str4 = this.bPT.bPP;
                                    sVar2.iv(str4);
                                } else {
                                    this.bPT.iu(str);
                                }
                            } else {
                                this.bPT.iu(str);
                            }
                            this.bPT.d(i, view);
                            return;
                        }
                        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(editable);
                        this.bPT.bPP = editable;
                        if (!matcher.lookingAt()) {
                            this.bPT.iu(str);
                        } else {
                            this.bPT.iv(editable);
                        }
                        this.bPT.d(i, view);
                        return;
                    }
                }
            }
        }
        this.bPT.bPO = null;
        sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
        }
    }
}
