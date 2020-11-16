package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.e;
/* loaded from: classes4.dex */
public class CharmValueView extends FrameLayout {
    private ImageView oji;
    private ImageView ojj;
    private ImageView ojk;
    private TextView ojl;

    public CharmValueView(@NonNull Context context) {
        this(context, null, 0);
    }

    public CharmValueView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CharmValueView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_charm_value_view_layout, this);
        this.oji = (ImageView) findViewById(a.f.yuyin_sdk_wheat_charm_value_bg_1);
        this.ojj = (ImageView) findViewById(a.f.yuyin_sdk_wheat_charm_value_bg_2);
        this.ojk = (ImageView) findViewById(a.f.yuyin_sdk_wheat_charm_value_bg_3);
        this.ojl = (TextView) findViewById(a.f.yuyin_sdk_wheat_charm_value_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap I(Context context, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inInputShareable = true;
        return BitmapFactory.decodeStream(context.getResources().openRawResource(i), null, options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap i(Bitmap bitmap, int i) {
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i2 = (height * i) / 100;
            if (i2 == 0) {
                i2 = 1;
            }
            bitmap2 = Bitmap.createBitmap(bitmap, 0, height - i2, width, i2, (Matrix) null, false);
            if (bitmap != null && !bitmap.equals(bitmap2) && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        return bitmap2;
    }

    public void setProgress(final int i) {
        this.ojk.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.1
            @Override // java.lang.Runnable
            public void run() {
                CharmValueView.this.ojk.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CharmValueView.this.ojk.getLayoutParams();
                layoutParams.height = (e.c(30.0f, CharmValueView.this.getContext()) * i) / 100;
                CharmValueView.this.ojk.setLayoutParams(layoutParams);
                CharmValueView.this.ojk.setImageBitmap(CharmValueView.this.i(CharmValueView.this.I(CharmValueView.this.getContext(), a.e.yuyin_sdk_wheat_charm_value_bg_3), i));
            }
        });
    }

    public void setCharmValue(String str) {
        if (this.ojl != null) {
            this.ojl.setText(str);
        }
    }
}
