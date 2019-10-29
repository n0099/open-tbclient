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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes6.dex */
public abstract class a implements com.baidu.tieba.sharesdk.b.a {
    Context context;
    BdUniqueId pageId;
    String tid;

    public a(Context context) {
        this.context = context;
    }

    public void u(BdUniqueId bdUniqueId) {
        this.pageId = bdUniqueId;
    }

    public void onDestroy() {
    }

    public void ai(Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BdUniqueId getPageId() {
        h Z;
        BdUniqueId bdUniqueId = this.pageId;
        if (bdUniqueId == null && (Z = i.Z(this.context)) != null) {
            return Z.getUniqueId();
        }
        return bdUniqueId;
    }

    protected void Do(String str) {
        bk(str, R.drawable.icon_toast_game_error);
    }

    protected void Dp(String str) {
        bk(str, R.drawable.icon_toast_game_ok);
    }

    protected void bk(String str, int i) {
        BdToast.b(getAppContext(), str, i, false).akT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zf(int i) {
        aF(i, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aF(int i, String str) {
        if (i == 1) {
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.share_success, new Object[0]);
            }
            Dp(str);
        } else if (i == 3) {
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.share_cancel, new Object[0]);
            }
            Do(str);
        } else if (i == 2) {
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.share_failed, new Object[0]);
            }
            Do(str);
        }
        if (!TextUtils.isEmpty(this.tid)) {
            zg(i);
        }
    }

    public void zg(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("status", i);
        bundle.putString(IntentConfig.SHARE_THREAD_ID, this.tid);
        com.baidu.tbadk.n.b.a("broadcast_type_share_toast_status", bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getAppContext() {
        return TbadkCoreApplication.getInst().getContext();
    }

    protected String getString(int i, Object... objArr) {
        return getAppContext().getString(i, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap ckI() {
        return BitmapHelper.getCashBitmap(R.drawable.icon);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap zh(int i) {
        return BitmapHelper.getCashBitmap(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap Dq(String str) {
        return BitmapHelper.loadBitmap(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap s(Uri uri) {
        return BitmapHelper.loadBitmap(uri.getPath());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(Uri uri) {
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
    public boolean oY(String str) {
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
        if (shareEntity == null || shareEntity.cyH == null) {
            return null;
        }
        Bundle bundle = shareEntity.cyH;
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
        cVar.setSubFolder(z);
        cVar.setIsFormatData(z4);
        cVar.setSdCard(z2);
        cVar.setSavedCache(z3);
        if (com.baidu.adp.lib.Disk.d.eP().b(cVar) && cVar.isSuccess()) {
            cVar.formatData(cVar.getData());
            Bitmap bitmap = cVar.getBitmap();
            if (bitmap != null) {
                return new com.baidu.adp.widget.ImageView.a(bitmap, cVar.isGif());
            }
            return null;
        }
        return null;
    }

    public void setTid(String str) {
        this.tid = str;
    }
}
