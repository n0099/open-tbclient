package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class o {
    private com.baidu.tbadk.coreExtra.c.c akD = new com.baidu.tbadk.coreExtra.c.c();

    public Bitmap aj(Context context) {
        String sf = this.akD.sf();
        Bitmap bitmap = null;
        if (!StringUtils.isNull(sf)) {
            try {
                bitmap = BitmapFactory.decodeFile(com.baidu.tbadk.core.util.s.cj(bc.cI(sf)).getAbsolutePath());
                if (bitmap == null) {
                    this.akD.sg();
                }
            } catch (Throwable th) {
            }
        }
        if (bitmap == null) {
            if (TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.isMem + TbadkCoreApplication.getCurrentAccount(), false)) {
                return com.baidu.tbadk.core.util.d.f(context, v.logo_vip);
            }
            return com.baidu.tbadk.core.util.d.f(context, v.logo);
        }
        return bitmap;
    }
}
