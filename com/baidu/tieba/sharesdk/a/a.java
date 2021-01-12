package com.baidu.tieba.sharesdk.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.base.j;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes7.dex */
public abstract class a implements com.baidu.tieba.sharesdk.b.a {
    public static String nas = n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME;
    public static String nau = "temp_video_thumb.png";
    public static String nav = "_temp_share_pic.png";
    Context context;
    String extLiveInfo;
    BdUniqueId pageId;
    String tid;

    public a(Context context) {
        this.context = context;
    }

    public void y(BdUniqueId bdUniqueId) {
        this.pageId = bdUniqueId;
    }

    public void onDestroy() {
    }

    public void N(Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BdUniqueId getPageId() {
        i I;
        BdUniqueId bdUniqueId = this.pageId;
        if (bdUniqueId == null && (I = j.I(this.context)) != null) {
            return I.getUniqueId();
        }
        return bdUniqueId;
    }

    protected void Ru(String str) {
        bT(str, R.drawable.icon_toast_game_error);
    }

    protected void Rv(String str) {
        bT(str, R.drawable.icon_toast_game_ok);
    }

    protected void bT(String str, int i) {
        BdToast.b(getAppContext(), str, i, false).bqk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dp(int i, int i2) {
        h(i, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(int i, String str, int i2) {
        if (i == 1) {
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.share_success, new Object[0]);
            }
            Rv(str);
        } else if (i == 3) {
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.share_cancel, new Object[0]);
            }
            Ru(str);
        } else if (i == 2) {
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.share_failed, new Object[0]);
            }
            Ru(str);
        }
        if (!TextUtils.isEmpty(this.tid)) {
            dq(i, i2);
        } else if (!StringUtils.isNull(this.extLiveInfo)) {
            dq(i, i2);
        }
    }

    public void dq(int i, int i2) {
        ShareEvent shareEvent = new ShareEvent();
        shareEvent.status = i;
        shareEvent.tid = this.tid;
        shareEvent.channel = i2;
        shareEvent.extLiveInfo = this.extLiveInfo;
        g.publishEvent(shareEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getAppContext() {
        return TbadkCoreApplication.getInst().getContext();
    }

    protected String getString(int i, Object... objArr) {
        return getAppContext().getString(i, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap dGW() {
        return BitmapHelper.getCashBitmap(R.drawable.tb_launcher_icon);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap Ix(int i) {
        return BitmapHelper.getCashBitmap(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap Rw(String str) {
        return BitmapHelper.loadBitmap(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap G(Uri uri) {
        return BitmapHelper.loadBitmap(uri.getPath());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z(Uri uri) {
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
    public boolean BU(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.isFile() && file.exists();
    }

    public Bitmap h(Bitmap bitmap, int i) {
        return BitmapHelper.resizeBitmap(bitmap, i, i, false);
    }

    public Bitmap g(Bitmap bitmap, int i, int i2) {
        return BitmapHelper.resizeBitmap(bitmap, i, i2, false);
    }

    public com.baidu.adp.widget.ImageView.a a(ShareEntity shareEntity) {
        if (shareEntity == null || shareEntity.diskPicOperate == null) {
            return null;
        }
        Bundle bundle = shareEntity.diskPicOperate;
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
        if (com.baidu.adp.lib.Disk.d.lh().b(cVar) && cVar.isSuccess()) {
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

    public void Rs(String str) {
        this.extLiveInfo = str;
    }

    public Bitmap a(Bitmap bitmap, ShareEntity shareEntity, boolean z) {
        if (bitmap == null) {
            return null;
        }
        Bitmap h = h(bitmap, (l.getDimens(this.context, R.dimen.tbds113) * Math.max(bitmap.getWidth(), bitmap.getHeight())) / Math.min(bitmap.getWidth(), bitmap.getHeight()));
        Bitmap createBitmap = Bitmap.createBitmap(h.getWidth(), h.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(h, 0.0f, 0.0f, (Paint) null);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, h.getHeight(), this.context.getResources().getColor(R.color.CAM_X0601), this.context.getResources().getColor(R.color.CAM_X0605), Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(linearGradient);
        canvas.drawRect(0.0f, 0.0f, h.getWidth(), h.getHeight(), paint);
        Drawable a2 = SvgManager.bsx().a(R.drawable.ic_icon_share_play_20, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null, false);
        if (a2 != null) {
            int min = (int) (Math.min(h.getWidth(), h.getHeight()) * 0.3f);
            int width = (h.getWidth() - min) / 2;
            int height = (h.getHeight() - min) / 2;
            a2.setBounds(width, height, width + min, min + height);
            a2.draw(canvas);
        }
        if (z) {
            String saveFileAsPNG = n.saveFileAsPNG(nas, nau, createBitmap, 100);
            if (!StringUtils.isNull(saveFileAsPNG)) {
                shareEntity.setImageUri(Uri.parse(saveFileAsPNG));
            }
        }
        return createBitmap;
    }
}
