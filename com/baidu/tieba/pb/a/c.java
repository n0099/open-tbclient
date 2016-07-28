package com.baidu.tieba.pb.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class c {
    public static String aHw() {
        int fontSize = TbadkCoreApplication.m10getInst().getFontSize();
        if (fontSize == 0) {
            return TbadkCoreApplication.m10getInst().getString(u.j.toast_font_size_xlarge);
        }
        if (fontSize == 1) {
            return TbadkCoreApplication.m10getInst().getString(u.j.toast_font_size_big);
        }
        if (fontSize == 2) {
            return TbadkCoreApplication.m10getInst().getString(u.j.toast_font_size_mid);
        }
        return TbadkCoreApplication.m10getInst().getString(u.j.toast_font_size_small);
    }

    public static void aHx() {
        int i = 1;
        int fontSize = TbadkCoreApplication.m10getInst().getFontSize();
        if (fontSize != 0) {
            i = fontSize == 1 ? 2 : fontSize == 2 ? 3 : 3;
        }
        if (fontSize != i) {
            TbadkCoreApplication.m10getInst().setFontSize(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD));
        }
        BdToast.a(TbadkCoreApplication.m10getInst(), aHw(), u.f.icon_word_t_size, 0).sa();
    }

    public static void aHy() {
        int i = 1;
        int fontSize = TbadkCoreApplication.m10getInst().getFontSize();
        if (fontSize == 0) {
            i = 0;
        } else if (fontSize == 1) {
            i = 0;
        } else if (fontSize != 2) {
            i = 2;
        }
        if (fontSize != i) {
            TbadkCoreApplication.m10getInst().setFontSize(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD));
        }
        BdToast.a(TbadkCoreApplication.m10getInst(), aHw(), u.f.icon_word_t_size, 0).sa();
    }

    public static void nw(int i) {
        if (TbadkCoreApplication.m10getInst().getFontSize() != i) {
            TbadkCoreApplication.m10getInst().setFontSize(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD));
        }
    }
}
