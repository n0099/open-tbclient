package com.baidu.tieba.sharesdk.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.h;
import com.baidu.adp.base.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.d;
import java.io.File;
/* loaded from: classes3.dex */
public abstract class a implements com.baidu.tieba.sharesdk.b.a {
    Context context;
    BdUniqueId pageId;

    public a(Context context) {
        this.context = context;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.pageId = bdUniqueId;
    }

    public void onDestroy() {
    }

    public void F(Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BdUniqueId getPageId() {
        h ai;
        BdUniqueId bdUniqueId = this.pageId;
        if (bdUniqueId == null && (ai = i.ai(this.context)) != null) {
            return ai.getUniqueId();
        }
        return bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void si(String str) {
        aI(str, d.f.icon_toast_game_error);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sj(String str) {
        aI(str, d.f.icon_toast_game_ok);
    }

    protected void aI(String str, int i) {
        BdToast.b(getAppContext(), str, i).Bc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uX(int i) {
        ad(i, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ad(int i, String str) {
        if (i == 1) {
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.share_success, new Object[0]);
            }
            sj(str);
        } else if (i == 3) {
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.share_cancel, new Object[0]);
            }
            si(str);
        } else if (i == 2) {
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.share_failed, new Object[0]);
            }
            si(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getAppContext() {
        return TbadkCoreApplication.getInst().getContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getString(int i, Object... objArr) {
        return getAppContext().getString(i, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap bsk() {
        return BitmapHelper.getCashBitmap(d.f.icon);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap sk(String str) {
        return BitmapHelper.loadBitmap(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ri(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.isFile() && file.exists();
    }

    public Bitmap g(Bitmap bitmap, int i) {
        return BitmapHelper.resizeBitmap(bitmap, i, i, false);
    }
}
