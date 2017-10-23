package com.baidu.tieba.pb.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    public static String aNN() {
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        if (fontSize == 0) {
            return TbadkCoreApplication.getInst().getString(d.l.toast_font_size_xlarge);
        }
        if (fontSize == 1) {
            return TbadkCoreApplication.getInst().getString(d.l.toast_font_size_big);
        }
        if (fontSize == 2) {
            return TbadkCoreApplication.getInst().getString(d.l.toast_font_size_mid);
        }
        return TbadkCoreApplication.getInst().getString(d.l.toast_font_size_small);
    }

    public static void aNO() {
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
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD));
        }
        BdToast.a(TbadkCoreApplication.getInst(), aNN(), d.g.icon_word_t_size, 0).tj();
    }

    public static void aNP() {
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
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD));
        }
        BdToast.a(TbadkCoreApplication.getInst(), aNN(), d.g.icon_word_t_size, 0).tj();
    }

    public static void oY(int i) {
        if (TbadkCoreApplication.getInst().getFontSize() != i) {
            TbadkCoreApplication.getInst().setFontSize(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD));
        }
    }
}
