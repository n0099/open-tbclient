package com.baidu.tieba.pb.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    public static String aWn() {
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        if (fontSize == 0) {
            return TbadkCoreApplication.getInst().getString(d.k.toast_font_size_xlarge);
        }
        if (fontSize == 1) {
            return TbadkCoreApplication.getInst().getString(d.k.toast_font_size_big);
        }
        if (fontSize == 2) {
            return TbadkCoreApplication.getInst().getString(d.k.toast_font_size_mid);
        }
        return TbadkCoreApplication.getInst().getString(d.k.toast_font_size_small);
    }

    public static void aWo() {
        int i = 1;
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        if (fontSize != 0) {
            if (fontSize == 1) {
                i = 2;
            } else {
                i = fontSize == 2 ? 3 : 3;
            }
        }
        if (fontSize != i) {
            TbadkCoreApplication.getInst().setFontSize(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004018));
        }
        BdToast.a(TbadkCoreApplication.getInst(), aWn(), d.f.icon_word_t_size, 0).tL();
    }

    public static void aWp() {
        int i = 1;
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        if (fontSize == 0) {
            i = 0;
        } else if (fontSize == 1) {
            i = 0;
        } else if (fontSize != 2) {
            i = 2;
        }
        if (fontSize != i) {
            TbadkCoreApplication.getInst().setFontSize(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004018));
        }
        BdToast.a(TbadkCoreApplication.getInst(), aWn(), d.f.icon_word_t_size, 0).tL();
    }

    public static void pY(int i) {
        if (TbadkCoreApplication.getInst().getFontSize() != i) {
            TbadkCoreApplication.getInst().setFontSize(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004018));
        }
    }
}
