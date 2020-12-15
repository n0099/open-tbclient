package com.baidu.yuyinala.privatemessage.implugin.ui.material.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.util.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements View.OnTouchListener, com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b {
    private Context mContext;
    private LayoutInflater mInflater;
    private WindowManager.LayoutParams mParams;
    private ViewGroup mParentView;
    private View mRootView;
    private WindowManager mWM;
    private ViewGroup oRU;
    private boolean oRV;
    private boolean oRW;
    private ImageView oRY;
    private ImageView oRZ;
    private a oSa;
    private int oRX = 0;
    private List<com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a> oSb = new ArrayList();

    /* loaded from: classes4.dex */
    public interface a {
        void a(b bVar, int i, int i2);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b
    public void emv() {
        if (emK()) {
            emJ();
        }
    }

    @SuppressLint({"RtlHardcoded"})
    private void Ph(int i) {
        this.mInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        this.mWM = (WindowManager) this.mContext.getSystemService("window");
        this.mRootView = (ViewGroup) this.mInflater.inflate(i, (ViewGroup) null);
        this.mParentView = new FrameLayout(this.mContext);
        this.oRU = (ViewGroup) this.mRootView.findViewById(a.f.tracks);
        this.oRY = (ImageView) this.mRootView.findViewById(a.f.arrow_down);
        this.oRZ = (ImageView) this.mRootView.findViewById(a.f.arrow_up);
        this.mParams = new WindowManager.LayoutParams();
        this.mParams.height = -2;
        this.mParams.width = -2;
        this.mParams.format = -3;
        this.mParams.type = 2;
        this.mParams.flags = 262184;
        this.mParams.gravity = 51;
        this.mRootView.setLayoutParams(this.mParams);
    }

    @SuppressLint({"InflateParams"})
    private void z(List<com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a> list, int i) {
        int i2 = 0;
        if (this.mContext == null) {
            Log.i("MenuDialog", "context is null");
            return;
        }
        this.oSb.clear();
        this.oRX = 0;
        this.oSb = list;
        if (list != null && !list.isEmpty()) {
            if (i == 1) {
                Ph(a.g.popup_horizontal);
            } else if (i == 0) {
                Ph(a.g.popup_vertical);
            }
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a aVar = list.get(i3);
                    String title = aVar.getTitle();
                    Drawable icon = aVar.getIcon();
                    View inflate = i == 0 ? this.mInflater.inflate(a.g.popup_item_vertical, (ViewGroup) null) : i == 1 ? this.mInflater.inflate(a.g.popup_item_horizontal, (ViewGroup) null) : null;
                    ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_icon);
                    TextView textView = (TextView) inflate.findViewById(a.f.tv_title);
                    if (icon != null) {
                        imageView.setImageDrawable(icon);
                    } else {
                        imageView.setVisibility(8);
                    }
                    if (title != null) {
                        textView.setText(title);
                    } else {
                        textView.setVisibility(8);
                    }
                    final int enh = aVar.enh();
                    final int i4 = this.oRX;
                    inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.oSa != null) {
                                b.this.oSa.a(b.this, i4, enh);
                            }
                            if (!b.this.Pi(i4).isSticky()) {
                                b.this.emJ();
                            }
                        }
                    });
                    inflate.setFocusable(true);
                    inflate.setClickable(true);
                    this.oRU.addView(inflate, this.oRX);
                    this.oRX++;
                    i2 = i3 + 1;
                } else {
                    this.mRootView.measure(-2, -2);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emI() {
        if (this.oRV) {
            try {
                if (this.mWM != null && this.mParentView != null) {
                    this.mWM.removeView(this.mParentView);
                }
            } catch (Exception e) {
                Log.e("MenuDialog", e.getMessage());
            }
        }
        this.oRV = false;
        this.oRW = false;
    }

    public boolean emJ() {
        if (this.oRW) {
            return this.oRV;
        }
        this.oRW = true;
        boolean z = this.oRV;
        Handler handler = new Handler();
        this.mRootView.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0205a.dimiss_from_top));
        handler.postDelayed(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.emI();
            }
        }, 100L);
        com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.emA().b(null);
        return z;
    }

    public void a(Context context, View view, List<com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a> list, int i) {
        int i2;
        this.mContext = context;
        if (this.mContext == null) {
            Log.i("MenuDialog", "context is null");
            return;
        }
        z(list, i);
        this.oRV = true;
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int measuredHeight = this.mRootView.getMeasuredHeight();
        int measuredWidth = this.mRootView.getMeasuredWidth();
        int centerX = rect.centerX() - (measuredWidth / 2);
        if (centerX < f.dip2px(this.mContext, 10.0f)) {
            centerX = f.dip2px(this.mContext, 10.0f);
        }
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        int dip2px = (displayMetrics.widthPixels - rect.centerX()) - f.dip2px(this.mContext, 10.0f) < measuredWidth / 2 ? (displayMetrics.widthPixels - measuredWidth) - f.dip2px(this.mContext, 10.0f) : centerX;
        int centerX2 = rect.centerX() - dip2px;
        int statusBarHeight = (rect.top - measuredHeight) - f.getStatusBarHeight(this.mContext);
        if (statusBarHeight < f.getStatusBarHeight(this.mContext)) {
            int statusBarHeight2 = f.getStatusBarHeight(this.mContext);
            dT(a.f.arrow_down, centerX2);
            i2 = statusBarHeight2;
        } else {
            int measuredHeight2 = statusBarHeight + this.oRZ.getMeasuredHeight();
            dT(a.f.arrow_down, centerX2);
            i2 = measuredHeight2;
        }
        if (i == 0) {
            this.oRY.setVisibility(8);
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mRootView.getLayoutParams();
        layoutParams.x = dip2px;
        layoutParams.y = i2;
        this.mWM.addView(this.mParentView, layoutParams);
        this.mParentView.addView(this.mRootView);
        this.mParentView.setOnTouchListener(this);
        this.mRootView.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0205a.grow_from_bottom));
        com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.emA().b(this);
    }

    private void dT(int i, int i2) {
        int i3;
        ImageView imageView = this.oRY;
        ImageView imageView2 = this.oRZ;
        if (i == a.f.arrow_down) {
            int measuredWidth = this.oRY.getMeasuredWidth();
            imageView.setVisibility(0);
            imageView2.setVisibility(8);
            i3 = measuredWidth;
        } else {
            int measuredWidth2 = imageView2.getMeasuredWidth();
            imageView.setVisibility(8);
            imageView2.setVisibility(0);
            i3 = measuredWidth2;
        }
        ((ViewGroup.MarginLayoutParams) imageView.getLayoutParams()).leftMargin = i2 - (i3 / 2);
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            emJ();
            return false;
        }
        return false;
    }

    public com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a Pi(int i) {
        return this.oSb.get(i);
    }

    public void a(a aVar) {
        this.oSa = aVar;
    }

    public boolean emK() {
        return this.oRV;
    }
}
