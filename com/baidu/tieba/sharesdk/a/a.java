package com.baidu.tieba.sharesdk.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.h;
import com.baidu.adp.base.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.e;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
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

    public void H(Intent intent) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void vc(String str) {
        aU(str, e.f.icon_toast_game_error);
    }

    protected void vd(String str) {
        aU(str, e.f.icon_toast_game_ok);
    }

    protected void aU(String str, int i) {
        BdToast.b(getAppContext(), str, i).BN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uR(int i) {
        ah(i, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ah(int i, String str) {
        if (i == 1) {
            if (TextUtils.isEmpty(str)) {
                str = getString(e.j.share_success, new Object[0]);
            }
            vd(str);
        } else if (i == 3) {
            if (TextUtils.isEmpty(str)) {
                str = getString(e.j.share_cancel, new Object[0]);
            }
            vc(str);
        } else if (i == 2) {
            if (TextUtils.isEmpty(str)) {
                str = getString(e.j.share_failed, new Object[0]);
            }
            vc(str);
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
    public Bitmap bzu() {
        return BitmapHelper.getCashBitmap(e.f.icon);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap ve(String str) {
        return BitmapHelper.loadBitmap(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap h(Uri uri) {
        return BitmapHelper.loadBitmap(uri.getPath());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i(Uri uri) {
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

    public Bitmap d(Bitmap bitmap, int i) {
        return BitmapHelper.resizeBitmap(bitmap, i, i, false);
    }
}
