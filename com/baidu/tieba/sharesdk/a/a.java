package com.baidu.tieba.sharesdk.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.h;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes6.dex */
public abstract class a implements com.baidu.tieba.sharesdk.b.a {
    Context context;
    BdUniqueId pageId;

    public a(Context context) {
        this.context = context;
    }

    public void r(BdUniqueId bdUniqueId) {
        this.pageId = bdUniqueId;
    }

    public void onDestroy() {
    }

    public void X(Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BdUniqueId getPageId() {
        h aI;
        BdUniqueId bdUniqueId = this.pageId;
        if (bdUniqueId == null && (aI = i.aI(this.context)) != null) {
            return aI.getUniqueId();
        }
        return bdUniqueId;
    }

    protected void BY(String str) {
        bq(str, d.f.icon_toast_game_error);
    }

    protected void BZ(String str) {
        bq(str, d.f.icon_toast_game_ok);
    }

    protected void bq(String str, int i) {
        BdToast.c(getAppContext(), str, i).abh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yJ(int i) {
        az(i, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void az(int i, String str) {
        if (i == 1) {
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.share_success, new Object[0]);
            }
            BZ(str);
        } else if (i == 3) {
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.share_cancel, new Object[0]);
            }
            BY(str);
        } else if (i == 2) {
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.share_failed, new Object[0]);
            }
            BY(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getAppContext() {
        return TbadkCoreApplication.getInst().getContext();
    }

    protected String getString(int i, Object... objArr) {
        return getAppContext().getString(i, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap caV() {
        return BitmapHelper.getCashBitmap(d.f.icon);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap yK(int i) {
        return BitmapHelper.getCashBitmap(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap Ca(String str) {
        return BitmapHelper.loadBitmap(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap p(Uri uri) {
        return BitmapHelper.loadBitmap(uri.getPath());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            File file = new File(new URI(uri.toString()));
            return file.isFile() && file.exists();
        } catch (IllegalArgumentException e) {
            return false;
        } catch (URISyntaxException e2) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean oc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.isFile() && file.exists();
    }

    public Bitmap e(Bitmap bitmap, int i) {
        return BitmapHelper.resizeBitmap(bitmap, i, i, false);
    }

    public Bitmap f(Bitmap bitmap, int i, int i2) {
        return BitmapHelper.resizeBitmap(bitmap, i, i2, false);
    }

    public com.baidu.adp.widget.ImageView.a a(ShareEntity shareEntity) {
        if (shareEntity == null || shareEntity.cbv == null) {
            return null;
        }
        Bundle bundle = shareEntity.cbv;
        String string = bundle.getString("path");
        String string2 = bundle.getString("name");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return null;
        }
        boolean z = bundle.getBoolean("isSubDir", true);
        boolean z2 = bundle.getBoolean("isSdcard", false);
        boolean z3 = bundle.getBoolean("isSavedCache", true);
        boolean z4 = bundle.getBoolean("formatData", true);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(string, string2, DiskFileOperate.Action.READ);
        cVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        cVar.R(z);
        cVar.S(z4);
        cVar.T(z2);
        cVar.U(z3);
        if (com.baidu.adp.lib.Disk.d.hz().b(cVar) && cVar.isSuccess()) {
            cVar.q(cVar.getData());
            Bitmap bitmap = cVar.getBitmap();
            if (bitmap != null) {
                return new com.baidu.adp.widget.ImageView.a(bitmap, cVar.isGif());
            }
            return null;
        }
        return null;
    }
}
