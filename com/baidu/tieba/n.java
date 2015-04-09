package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes.dex */
public class n {
    private com.baidu.tbadk.coreExtra.c.c atL = new com.baidu.tbadk.coreExtra.c.c();

    public Bitmap am(Context context) {
        CustomResponsedMessage runTask;
        String vR = this.atL.vR();
        Bitmap bitmap = null;
        if (!StringUtils.isNull(vR)) {
            try {
                bitmap = BitmapFactory.decodeFile(com.baidu.tbadk.core.util.o.cm(bf.cN(vR)).getAbsolutePath());
                if (bitmap == null) {
                    this.atL.vS();
                }
            } catch (Throwable th) {
            }
        }
        if (bitmap == null && TbadkCoreApplication.m411getInst().appResponseToCmd(2001301) && TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.isMem + TbadkCoreApplication.getCurrentAccount(), false) && (runTask = MessageManager.getInstance().runTask(2001301, com.baidu.tieba.tbadkCore.g.a.class)) != null && runTask.getData() != null) {
            return ((com.baidu.tieba.tbadkCore.g.a) runTask.getData()).aw(context);
        }
        return bitmap;
    }
}
