package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bh;
/* loaded from: classes.dex */
public class o {
    private com.baidu.tbadk.coreExtra.c.c ali = new com.baidu.tbadk.coreExtra.c.c();

    public Bitmap aj(Context context) {
        String sp = this.ali.sp();
        Bitmap bitmap = null;
        if (!StringUtils.isNull(sp)) {
            try {
                bitmap = BitmapFactory.decodeFile(com.baidu.tbadk.core.util.s.ce(bh.cE(sp)).getAbsolutePath());
                if (bitmap == null) {
                    this.ali.sq();
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
