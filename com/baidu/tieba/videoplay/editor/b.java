package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b extends com.baidu.tbadk.editortools.c {
    @Override // com.baidu.tbadk.editortools.c
    protected d aZ(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setBarLauncherType(4);
        editorTools.setBackgroundColorId(d.C0141d.cp_bg_line_d);
        return new a(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            EditorTools Hg = dVar.Hg();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            Hg.F(arrayList);
            k eM = Hg.eM(5);
            if (eM != null) {
                eM.bE(false);
                eM.aLW = 0;
            }
            Hg.b(new c(Hg.getContext()));
            Hg.Hh();
            Hg.b(new com.baidu.tbadk.editortools.a(35, 5, false));
            Hg.hide();
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof a) {
            EditorTools Hg = dVar.Hg();
            final a aVar = (a) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.videoplay.editor.b.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar2) {
                    if (aVar != null && aVar.Hg() != null && aVar2 != null) {
                        switch (aVar2.code) {
                            case 4:
                                aVar.gM((String) aVar2.data);
                                return;
                            case 5:
                            case 6:
                            default:
                                return;
                            case 7:
                                aVar.BR().showToast(d.k.over_limit_tip);
                                return;
                            case 8:
                                aVar.bET();
                                if (b.this.a(aVar.BR(), 11001)) {
                                    aVar.HY();
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            Hg.setActionListener(4, bVar);
            Hg.setActionListener(7, bVar);
            Hg.setActionListener(8, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.k.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
