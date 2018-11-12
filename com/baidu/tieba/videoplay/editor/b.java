package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b extends com.baidu.tbadk.editortools.c {
    @Override // com.baidu.tbadk.editortools.c
    protected d bK(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setBarLauncherType(4);
        editorTools.setBackgroundColorId(e.d.cp_bg_line_d);
        return new a(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(d dVar) {
        if (dVar != null) {
            EditorTools KT = dVar.KT();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            KT.w(arrayList);
            k fw = KT.fw(5);
            if (fw != null) {
                fw.cs(false);
                fw.aVy = 0;
            }
            KT.b(new c(KT.getContext()));
            KT.KU();
            KT.b(new com.baidu.tbadk.editortools.a(35, 5, false));
            KT.hide();
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(d dVar) {
        if (dVar instanceof a) {
            EditorTools KT = dVar.KT();
            final a aVar = (a) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.videoplay.editor.b.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar2) {
                    if (aVar != null && aVar.KT() != null && aVar2 != null) {
                        switch (aVar2.code) {
                            case 4:
                                aVar.hx((String) aVar2.data);
                                return;
                            case 5:
                            case 6:
                            default:
                                return;
                            case 7:
                                aVar.Fy().showToast(e.j.over_limit_tip);
                                return;
                            case 8:
                                aVar.bJI();
                                if (b.this.a(aVar.Fy(), 11001)) {
                                    aVar.LL();
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            KT.setActionListener(4, bVar);
            KT.setActionListener(7, bVar);
            KT.setActionListener(8, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }
}
