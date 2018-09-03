package com.baidu.tieba.pb.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class b {
    public static String bae() {
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        if (fontSize == 0) {
            return TbadkCoreApplication.getInst().getString(f.j.toast_font_size_xlarge);
        }
        if (fontSize == 1) {
            return TbadkCoreApplication.getInst().getString(f.j.toast_font_size_big);
        }
        if (fontSize == 2) {
            return TbadkCoreApplication.getInst().getString(f.j.toast_font_size_mid);
        }
        return TbadkCoreApplication.getInst().getString(f.j.toast_font_size_small);
    }

    public static void baf() {
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
        BdToast.a(TbadkCoreApplication.getInst(), bae(), f.C0146f.icon_word_t_size, 0).xm();
    }

    public static void bag() {
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
        BdToast.a(TbadkCoreApplication.getInst(), bae(), f.C0146f.icon_word_t_size, 0).xm();
    }

    public static void qn(int i) {
        if (TbadkCoreApplication.getInst().getFontSize() != i) {
            TbadkCoreApplication.getInst().setFontSize(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004018));
        }
    }
}
