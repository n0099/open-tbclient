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
            EditorTools Mp = dVar.Mp();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            Mp.w(arrayList);
            k fL = Mp.fL(5);
            if (fL != null) {
                fL.cw(false);
                fL.aZI = 0;
            }
            Mp.b(new c(Mp.getContext()));
            Mp.Mq();
            Mp.b(new com.baidu.tbadk.editortools.a(35, 5, false));
            Mp.hide();
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(d dVar) {
        if (dVar instanceof a) {
            EditorTools Mp = dVar.Mp();
            final a aVar = (a) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.videoplay.editor.b.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar2) {
                    if (aVar != null && aVar.Mp() != null && aVar2 != null) {
                        switch (aVar2.code) {
                            case 4:
                                aVar.m22if((String) aVar2.data);
                                return;
                            case 5:
                            case 6:
                            default:
                                return;
                            case 7:
                                aVar.GQ().showToast(e.j.over_limit_tip);
                                return;
                            case 8:
                                aVar.bNk();
                                if (b.this.a(aVar.GQ(), 11001)) {
                                    aVar.Nh();
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            Mp.setActionListener(4, bVar);
            Mp.setActionListener(7, bVar);
            Mp.setActionListener(8, bVar);
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
