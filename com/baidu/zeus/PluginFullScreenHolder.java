package com.baidu.zeus;

import android.app.Dialog;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PluginFullScreenHolder extends Dialog {
    private View mContentView;
    private final int mNpp;
    private final WebView mWebView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PluginFullScreenHolder(WebView webView, int i) {
        super(webView.getContext(), 16973831);
        this.mWebView = webView;
        this.mNpp = i;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (view instanceof SurfaceView) {
            ((SurfaceView) view).getHolder().setSizeFromLayout();
        }
        super.setContentView(view);
        this.mContentView = view;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.mWebView.mPrivateHandler.obtainMessage(SocialAPIErrorCodes.ERROR_INVALID_STATE).sendToTarget();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.isSystem()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.mWebView.onKeyDown(i, keyEvent);
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (keyEvent.isSystem()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.mWebView.onKeyUp(i, keyEvent);
        return true;
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.app.Dialog
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        this.mWebView.onTrackballEvent(motionEvent);
        return true;
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        if (this.mContentView != null && this.mContentView.getParent() != null) {
            ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
        }
        this.mWebView.getWebViewCore().sendMessage(182, this.mNpp, 0);
    }
}
