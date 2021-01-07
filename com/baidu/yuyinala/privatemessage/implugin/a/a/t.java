package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ImageMsg;
import com.baidu.live.sdk.a;
import com.baidu.sumeru.universalimageloader.core.ImageLoader;
import java.io.File;
/* loaded from: classes11.dex */
public class t extends e {
    public ImageView jNe;
    public View mContentView;
    public View mConvertView;
    private ImageView oTE;
    public View oTF;
    private TextView oTG;

    @SuppressLint({"InflateParams"})
    public t(Context context, LayoutInflater layoutInflater) {
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_send_img_item, (ViewGroup) null);
        this.oSk = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oSn = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.oSp = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview_vip);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_layout);
        this.oTF = this.mConvertView.findViewById(a.f.bd_im_chating_msg_uploadingLayout);
        this.oTG = (TextView) this.mConvertView.findViewById(a.f.progressTV);
        this.jNe = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_img);
        this.oTE = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_cover);
        this.oSq = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status);
        this.oSr = this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status_layout);
        this.oSs = (ProgressBar) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_progress);
        this.mConvertView.setTag(this);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.e
    public View getConvertView() {
        return this.mConvertView;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.e
    public View getContentView() {
        return this.mContentView;
    }

    public static t o(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        return (view == null || !(view.getTag() instanceof t)) ? new t(context, layoutInflater) : (t) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.e
    public void b(Context context, ChatMsg chatMsg) {
        RelativeLayout.LayoutParams layoutParams;
        ImageMsg imageMsg = (ImageMsg) chatMsg;
        Pair<Integer, Integer> a2 = a(context, imageMsg);
        if (chatMsg.isReSend()) {
            this.oTF.setVisibility(8);
            this.oTE.setVisibility(8);
        } else {
            if (imageMsg.getProgress() > 0 && imageMsg.getProgress() < 100) {
                this.oTG.setText(String.valueOf(imageMsg.getProgress()) + "%");
            }
            if (chatMsg.isMsgSendSuccess()) {
                this.oTF.setVisibility(8);
                this.oTE.setVisibility(8);
            } else if (chatMsg.getStatus() == 1) {
                if (a2 != null) {
                    layoutParams = new RelativeLayout.LayoutParams(((Integer) a2.first).intValue(), ((Integer) a2.second).intValue());
                } else {
                    layoutParams = new RelativeLayout.LayoutParams(0, 0);
                }
                this.oTE.setLayoutParams(layoutParams);
                this.oTE.setVisibility(0);
                this.oTF.setVisibility(0);
            } else if (chatMsg.getStatus() == 2) {
                this.oTF.setVisibility(8);
                this.oTE.setVisibility(8);
            }
        }
        super.b(context, chatMsg);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Pair<Integer, Integer> a(Context context, ImageMsg imageMsg) {
        String str;
        boolean z;
        Bitmap bitmap;
        Bitmap bitmap2;
        String localUrl = imageMsg.getLocalUrl();
        String[] split = localUrl.split("\\/");
        String str2 = split.length > 0 ? split[split.length - 1] : null;
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.substring(0, str2.lastIndexOf("."));
        }
        if (com.baidu.yuyinala.privatemessage.implugin.util.a.c.getCacheDir() != null) {
            str = com.baidu.yuyinala.privatemessage.implugin.util.a.c.getCacheDir().getAbsolutePath() + File.separator + str2;
            z = true;
        } else {
            str = null;
            z = false;
        }
        if (z && new File(str).isFile()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            float f = options.outWidth;
            float f2 = options.outHeight;
            float max = Math.max(f / ((int) context.getResources().getDimension(a.d.bd_im_image_max_wh)), f2 / ((int) context.getResources().getDimension(a.d.bd_im_image_max_wh)));
            if (max < 1.0f) {
                max = 1.0f;
            }
            options.inJustDecodeBounds = false;
            options.inSampleSize = (int) max;
            if (options.inSampleSize % 2 != 0) {
                int i = 1;
                while (i * 2 < options.inSampleSize) {
                    i *= 2;
                }
                options.inSampleSize = i;
            }
            options.inPurgeable = Build.VERSION.SDK_INT < 21;
            try {
                bitmap = BitmapFactory.decodeFile(str, options);
            } catch (Throwable th) {
                bitmap = null;
            }
            if (bitmap != null) {
                try {
                    bitmap2 = Bitmap.createScaledBitmap(bitmap, (int) f, (int) f2, true);
                } catch (Throwable th2) {
                    bitmap2 = bitmap;
                    if (bitmap2 != null) {
                    }
                }
                if (bitmap2 != bitmap) {
                    bitmap.recycle();
                    if (bitmap2 != null) {
                        this.jNe.setImageBitmap(bitmap2);
                        return new Pair<>(Integer.valueOf(bitmap2.getWidth()), Integer.valueOf(bitmap2.getHeight()));
                    }
                    return null;
                }
            }
            bitmap2 = bitmap;
            if (bitmap2 != null) {
            }
        } else if (!TextUtils.isEmpty(imageMsg.getRemoteUrl())) {
            a(context, imageMsg, this.jNe);
            return null;
        } else {
            try {
                Bitmap a2 = com.baidu.yuyinala.privatemessage.implugin.util.a.b.a(context, localUrl, 250.0f);
                if (!TextUtils.isEmpty(str) && z) {
                    com.baidu.yuyinala.privatemessage.implugin.util.a.b.a(a2, new File(str));
                }
                if (a2 != null) {
                    Bitmap b2 = b(context, a2);
                    this.jNe.setImageBitmap(b2);
                    return new Pair<>(Integer.valueOf(b2.getWidth()), Integer.valueOf(b2.getHeight()));
                }
                return null;
            } catch (Exception e) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("SendImgItem", e.toString());
                return null;
            }
        }
    }

    private Bitmap b(Context context, Bitmap bitmap) {
        int dimension = (int) context.getResources().getDimension(a.d.bd_im_image_min_wh);
        int dimension2 = (int) context.getResources().getDimension(a.d.bd_im_image_min_wh);
        int dimension3 = (int) context.getResources().getDimension(a.d.bd_im_image_max_wh);
        int dimension4 = (int) context.getResources().getDimension(a.d.bd_im_image_max_wh);
        if (bitmap.getWidth() >= bitmap.getHeight()) {
            dimension4 = (int) ((dimension3 / bitmap.getWidth()) * bitmap.getHeight());
        } else {
            dimension3 = (int) ((dimension4 / bitmap.getHeight()) * bitmap.getWidth());
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, dimension3, dimension4, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    private void a(Context context, ChatMsg chatMsg, ImageView imageView) {
        String thumbUrl = ((ImageMsg) chatMsg).getThumbUrl();
        String remoteUrl = ((ImageMsg) chatMsg).getRemoteUrl();
        if (TextUtils.isEmpty(thumbUrl)) {
            thumbUrl = remoteUrl;
        }
        com.baidu.yuyinala.privatemessage.implugin.util.b.hE(context);
        ImageLoader.getInstance().displayImage(thumbUrl, imageView, com.baidu.yuyinala.privatemessage.implugin.util.b.enU());
    }
}
