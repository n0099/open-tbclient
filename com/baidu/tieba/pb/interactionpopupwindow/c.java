package com.baidu.tieba.pb.interactionpopupwindow;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.pb.b;
/* loaded from: classes.dex */
public class c {
    public static f a(TbPageContext tbPageContext, IBaseDialogData iBaseDialogData) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null || iBaseDialogData == null) {
            return null;
        }
        switch (iBaseDialogData.getType()) {
            case 1:
                an anVar = new an(b.a.hGN);
                int i = 0;
                switch (iBaseDialogData.getFrom()) {
                    case 0:
                        i = 2;
                        break;
                    case 1:
                        i = 3;
                        break;
                    case 2:
                        i = 4;
                        break;
                }
                anVar.O("obj_type", i);
                TiebaStatic.log(anVar);
                return new d(tbPageContext, (CustomDialogData) iBaseDialogData);
            default:
                return null;
        }
    }
}
