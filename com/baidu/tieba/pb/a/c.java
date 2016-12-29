package com.baidu.tieba.pb.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c {
    public static String aIM() {
        int fontSize = TbadkCoreApplication.m9getInst().getFontSize();
        if (fontSize == 0) {
            return TbadkCoreApplication.m9getInst().getString(r.j.toast_font_size_xlarge);
        }
        if (fontSize == 1) {
            return TbadkCoreApplication.m9getInst().getString(r.j.toast_font_size_big);
        }
        if (fontSize == 2) {
            return TbadkCoreApplication.m9getInst().getString(r.j.toast_font_size_mid);
        }
        return TbadkCoreApplication.m9getInst().getString(r.j.toast_font_size_small);
    }

    public static void aIN() {
        int i = 1;
        int fontSize = TbadkCoreApplication.m9getInst().getFontSize();
        if (fontSize != 0) {
            i = fontSize == 1 ? 2 : fontSize == 2 ? 3 : 3;
        }
        if (fontSize != i) {
            TbadkCoreApplication.m9getInst().setFontSize(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD));
        }
        BdToast.a(TbadkCoreApplication.m9getInst(), aIM(), r.f.icon_word_t_size, 0).tj();
    }

    public static void aIO() {
        int i = 1;
        int fontSize = TbadkCoreApplication.m9getInst().getFontSize();
        if (fontSize == 0) {
            i = 0;
        } else if (fontSize == 1) {
            i = 0;
        } else if (fontSize != 2) {
            i = 2;
        }
        if (fontSize != i) {
            TbadkCoreApplication.m9getInst().setFontSize(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD));
        }
        BdToast.a(TbadkCoreApplication.m9getInst(), aIM(), r.f.icon_word_t_size, 0).tj();
    }

    public static void nv(int i) {
        if (TbadkCoreApplication.m9getInst().getFontSize() != i) {
            TbadkCoreApplication.m9getInst().setFontSize(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD));
        }
    }
}
