package com.baidu.tieba.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ FrsCommonImageLayout a;
    private final int b;

    private p(FrsCommonImageLayout frsCommonImageLayout, int i) {
        this.a = frsCommonImageLayout;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(FrsCommonImageLayout frsCommonImageLayout, int i, p pVar) {
        this(frsCommonImageLayout, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        com.baidu.tbadk.core.data.j[] jVarArr;
        com.baidu.tbadk.core.data.j[] jVarArr2;
        com.baidu.tbadk.core.data.j[] jVarArr3;
        Context context;
        String str;
        String str2;
        String str3;
        boolean z;
        Context context2;
        Context context3;
        com.baidu.tbadk.core.data.j[] jVarArr4;
        q qVar2;
        qVar = this.a.a;
        if (qVar != null) {
            qVar2 = this.a.a;
            qVar2.a(this.b);
            return;
        }
        jVarArr = this.a.c;
        if (jVarArr[this.b].b() != 5) {
            jVarArr2 = this.a.c;
            if (jVarArr2 != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                jVarArr3 = this.a.c;
                for (com.baidu.tbadk.core.data.j jVar : jVarArr3) {
                    if (TextUtils.isEmpty(jVar.a())) {
                        arrayList.add(jVar.c());
                    } else {
                        arrayList.add(jVar.a());
                    }
                }
                MessageManager messageManager = MessageManager.getInstance();
                context = this.a.d;
                com.baidu.tbadk.core.atomData.w wVar = new com.baidu.tbadk.core.atomData.w(context);
                int i = this.b;
                str = this.a.n;
                str2 = this.a.m;
                str3 = this.a.o;
                z = this.a.b;
                messageManager.sendMessage(new CustomMessage((int) CmdConfig.IMAGE_VIEWER_CUSTOM_CMD, wVar.a(arrayList, i, str, str2, str3, z, arrayList.size() > 0 ? arrayList.get(arrayList.size() - 1) : "")));
                context2 = this.a.d;
                TiebaStatic.eventStat(context2, "pic_frs", "");
                return;
            }
            return;
        }
        context3 = this.a.d;
        jVarArr4 = this.a.c;
        com.baidu.tbadk.browser.a.a(context3, jVarArr4[this.b].d());
    }
}
