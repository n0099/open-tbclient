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
import com.baidu.tieba.d;
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

    public void r(BdUniqueId bdUniqueId) {
        this.pageId = bdUniqueId;
    }

    public void onDestroy() {
    }

    public void D(Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BdUniqueId getPageId() {
        h ab;
        BdUniqueId bdUniqueId = this.pageId;
        if (bdUniqueId == null && (ab = i.ab(this.context)) != null) {
            return ab.getUniqueId();
        }
        return bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tj(String str) {
        aN(str, d.f.icon_toast_game_error);
    }

    protected void tk(String str) {
        aN(str, d.f.icon_toast_game_ok);
    }

    protected void aN(String str, int i) {
        BdToast.b(getAppContext(), str, i).xv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sV(int i) {
        ah(i, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ah(int i, String str) {
        if (i == 1) {
            if (TextUtils.isEmpty(str)) {
                str = getString(d.k.share_success, new Object[0]);
            }
            tk(str);
        } else if (i == 3) {
            if (TextUtils.isEmpty(str)) {
                str = getString(d.k.share_cancel, new Object[0]);
            }
            tj(str);
        } else if (i == 2) {
            if (TextUtils.isEmpty(str)) {
                str = getString(d.k.share_failed, new Object[0]);
            }
            tj(str);
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
    public Bitmap bsR() {
        return BitmapHelper.getCashBitmap(d.f.icon);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap tl(String str) {
        return BitmapHelper.loadBitmap(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap g(Uri uri) {
        return BitmapHelper.loadBitmap(uri.getPath());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h(Uri uri) {
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

    public Bitmap e(Bitmap bitmap, int i) {
        return BitmapHelper.resizeBitmap(bitmap, i, i, false);
    }
}
