package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.utils.SapiGIDEvent;
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
    protected d ba(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setBarLauncherType(4);
        editorTools.setBackgroundColorId(d.C0140d.cp_bg_line_d);
        return new a(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            EditorTools Ht = dVar.Ht();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            Ht.F(arrayList);
            k eO = Ht.eO(5);
            if (eO != null) {
                eO.bF(false);
                eO.aMS = 0;
            }
            Ht.b(new c(Ht.getContext()));
            Ht.Hu();
            Ht.b(new com.baidu.tbadk.editortools.a(35, 5, false));
            Ht.hide();
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof a) {
            EditorTools Ht = dVar.Ht();
            final a aVar = (a) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.videoplay.editor.b.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar2) {
                    if (aVar != null && aVar.Ht() != null && aVar2 != null) {
                        switch (aVar2.code) {
                            case 4:
                                aVar.gM((String) aVar2.data);
                                return;
                            case 5:
                            case 6:
                            default:
                                return;
                            case 7:
                                aVar.Ca().showToast(d.j.over_limit_tip);
                                return;
                            case 8:
                                aVar.bEe();
                                if (b.this.a(aVar.Ca(), SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                                    aVar.Il();
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            Ht.setActionListener(4, bVar);
            Ht.setActionListener(7, bVar);
            Ht.setActionListener(8, bVar);
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
