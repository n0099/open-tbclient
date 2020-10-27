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
    private ViewGroup orP;
    private boolean orQ;
    private boolean orR;
    private ImageView orT;
    private ImageView orU;
    private a orV;
    private int orS = 0;
    private List<com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a> orW = new ArrayList();

    /* loaded from: classes4.dex */
    public interface a {
        void a(b bVar, int i, int i2);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b
    public void ecT() {
        if (edi()) {
            edh();
        }
    }

    @SuppressLint({"RtlHardcoded"})
    private void Nl(int i) {
        this.mInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        this.mWM = (WindowManager) this.mContext.getSystemService("window");
        this.mRootView = (ViewGroup) this.mInflater.inflate(i, (ViewGroup) null);
        this.mParentView = new FrameLayout(this.mContext);
        this.orP = (ViewGroup) this.mRootView.findViewById(a.g.tracks);
        this.orT = (ImageView) this.mRootView.findViewById(a.g.arrow_down);
        this.orU = (ImageView) this.mRootView.findViewById(a.g.arrow_up);
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
        this.orW.clear();
        this.orS = 0;
        this.orW = list;
        if (list != null && !list.isEmpty()) {
            if (i == 1) {
                Nl(a.h.popup_horizontal);
            } else if (i == 0) {
                Nl(a.h.popup_vertical);
            }
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a aVar = list.get(i3);
                    String title = aVar.getTitle();
                    Drawable icon = aVar.getIcon();
                    View inflate = i == 0 ? this.mInflater.inflate(a.h.popup_item_vertical, (ViewGroup) null) : i == 1 ? this.mInflater.inflate(a.h.popup_item_horizontal, (ViewGroup) null) : null;
                    ImageView imageView = (ImageView) inflate.findViewById(a.g.iv_icon);
                    TextView textView = (TextView) inflate.findViewById(a.g.tv_title);
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
                    final int edE = aVar.edE();
                    final int i4 = this.orS;
                    inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.orV != null) {
                                b.this.orV.a(b.this, i4, edE);
                            }
                            if (!b.this.Nm(i4).isSticky()) {
                                b.this.edh();
                            }
                        }
                    });
                    inflate.setFocusable(true);
                    inflate.setClickable(true);
                    this.orP.addView(inflate, this.orS);
                    this.orS++;
                    i2 = i3 + 1;
                } else {
                    this.mRootView.measure(-2, -2);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edg() {
        if (this.orQ) {
            try {
                if (this.mWM != null && this.mParentView != null) {
                    this.mWM.removeView(this.mParentView);
                }
            } catch (Exception e) {
                Log.e("MenuDialog", e.getMessage());
            }
        }
        this.orQ = false;
        this.orR = false;
    }

    public boolean edh() {
        if (this.orR) {
            return this.orQ;
        }
        this.orR = true;
        boolean z = this.orQ;
        Handler handler = new Handler();
        this.mRootView.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0195a.dimiss_from_top));
        handler.postDelayed(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.edg();
            }
        }, 100L);
        com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.ecY().b(null);
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
        this.orQ = true;
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
            dK(a.g.arrow_down, centerX2);
            i2 = statusBarHeight2;
        } else {
            int measuredHeight2 = statusBarHeight + this.orU.getMeasuredHeight();
            dK(a.g.arrow_down, centerX2);
            i2 = measuredHeight2;
        }
        if (i == 0) {
            this.orT.setVisibility(8);
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mRootView.getLayoutParams();
        layoutParams.x = dip2px;
        layoutParams.y = i2;
        this.mWM.addView(this.mParentView, layoutParams);
        this.mParentView.addView(this.mRootView);
        this.mParentView.setOnTouchListener(this);
        this.mRootView.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0195a.grow_from_bottom));
        com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.ecY().b(this);
    }

    private void dK(int i, int i2) {
        int i3;
        ImageView imageView = this.orT;
        ImageView imageView2 = this.orU;
        if (i == a.g.arrow_down) {
            int measuredWidth = this.orT.getMeasuredWidth();
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
            edh();
            return false;
        }
        return false;
    }

    public com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a Nm(int i) {
        return this.orW.get(i);
    }

    public void a(a aVar) {
        this.orV = aVar;
    }

    public boolean edi() {
        return this.orQ;
    }
}
