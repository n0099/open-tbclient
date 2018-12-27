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
    protected d bN(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setBarLauncherType(4);
        editorTools.setBackgroundColorId(e.d.cp_bg_line_d);
        return new a(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(d dVar) {
        if (dVar != null) {
            EditorTools LY = dVar.LY();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            LY.w(arrayList);
            k fL = LY.fL(5);
            if (fL != null) {
                fL.ct(false);
                fL.aYY = 0;
            }
            LY.b(new c(LY.getContext()));
            LY.LZ();
            LY.b(new com.baidu.tbadk.editortools.a(35, 5, false));
            LY.hide();
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(d dVar) {
        if (dVar instanceof a) {
            EditorTools LY = dVar.LY();
            final a aVar = (a) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.videoplay.editor.b.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar2) {
                    if (aVar != null && aVar.LY() != null && aVar2 != null) {
                        switch (aVar2.code) {
                            case 4:
                                aVar.hQ((String) aVar2.data);
                                return;
                            case 5:
                            case 6:
                            default:
                                return;
                            case 7:
                                aVar.GD().showToast(e.j.over_limit_tip);
                                return;
                            case 8:
                                aVar.bMC();
                                if (b.this.a(aVar.GD(), 11001)) {
                                    aVar.MQ();
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            LY.setActionListener(4, bVar);
            LY.setActionListener(7, bVar);
            LY.setActionListener(8, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }
}
