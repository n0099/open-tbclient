package com.baidu.tieba.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class ImageViewDialog extends Dialog {
    private View mConvertView;
    private int mFramePadding;
    private int mImageMaxHeight;
    private int mImageMaxWidth;
    private ImageView mImageView;
    private View.OnTouchListener mOnTouchListener;
    private int mPadding;
    private ProgressBar mProgressBar;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mX;
    private int mY;
    private Window window;

    public ImageViewDialog(Context context, int screen_width, int screen_height) {
        super(context, R.style.big_image_dialog);
        this.window = null;
        this.mImageView = null;
        this.mConvertView = null;
        this.mProgressBar = null;
        this.mOnTouchListener = null;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.mImageMaxWidth = 0;
        this.mImageMaxHeight = 0;
        this.mX = 0;
        this.mY = 0;
        this.mPadding = 0;
        this.mFramePadding = 0;
        this.mPadding = UtilHelper.dip2px(context, 0.0f);
        this.mScreenWidth = screen_width;
        this.mScreenHeight = screen_height;
        if (this.mScreenWidth <= 0) {
            this.mScreenWidth = 1;
        }
        if (this.mScreenHeight <= 0) {
            this.mScreenHeight = 1;
        }
        LayoutInflater mInflater = LayoutInflater.from(context);
        this.mConvertView = mInflater.inflate(R.layout.big_image_dialog, (ViewGroup) null);
        this.mImageView = (ImageView) this.mConvertView.findViewById(R.id.image);
        this.mImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mImageView.setPadding(this.mPadding, this.mPadding, this.mPadding, this.mPadding);
        this.mImageMaxWidth = UtilHelper.dip2px(context, 234.0f);
        if (this.mImageMaxWidth > 350) {
            this.mImageMaxWidth = Config.PB_IMAGE_NEW_MAX_WIDTH;
        }
        this.mImageMaxHeight = (int) (this.mImageMaxWidth * 1.62f);
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(R.id.image_progress);
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.baidu.tieba.view.ImageViewDialog.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == 0) {
                    ImageViewDialog.this.dismiss();
                    return false;
                }
                return false;
            }
        };
    }

    public void ImageError() {
        if (isShowing()) {
            this.mProgressBar.setVisibility(8);
            UtilHelper.showToast(getContext(), getContext().getResources().getString(R.string.image_error));
        }
    }

    public void setImage(Bitmap bm) {
        this.mProgressBar.setVisibility(8);
        if (bm != null) {
            ViewGroup.LayoutParams params = this.mImageView.getLayoutParams();
            if (params.width <= bm.getWidth() + 4) {
                params.width = bm.getWidth();
            }
            if (params.height <= bm.getHeight() + 4) {
                params.height = bm.getHeight();
            }
            this.mImageView.setLayoutParams(params);
            this.mImageView.setImageBitmap(bm);
        }
    }

    public void showDialog(Bitmap bm, boolean loading) {
        initImageView(bm);
        if (!loading) {
            this.mProgressBar.setVisibility(8);
        } else {
            this.mProgressBar.setVisibility(0);
        }
        windowDeploy();
        show();
    }

    private void initImageView(Bitmap bm) {
        int width;
        int height;
        if (bm != null) {
            if (this.mImageMaxWidth / this.mImageMaxHeight > bm.getWidth() / bm.getHeight()) {
                width = (bm.getWidth() * this.mImageMaxHeight) / bm.getHeight();
                height = this.mImageMaxHeight;
            } else {
                width = this.mImageMaxWidth;
                height = (bm.getHeight() * this.mImageMaxWidth) / bm.getWidth();
            }
            ViewGroup.LayoutParams params = this.mImageView.getLayoutParams();
            int width2 = width + (this.mPadding * 2);
            int height2 = height + (this.mPadding * 2);
            params.width = width2;
            params.height = height2;
            this.mImageView.setLayoutParams(params);
            this.mX = (this.mScreenWidth - ((this.mFramePadding * 2) + width2)) / 2;
            this.mY = (this.mScreenHeight - ((this.mFramePadding * 2) + height2)) / 2;
            this.mImageView.setImageBitmap(bm);
        }
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.mProgressBar.setVisibility(8);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.mConvertView);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        getWindow().getDecorView().setOnTouchListener(this.mOnTouchListener);
    }

    public void windowDeploy() {
        this.window = getWindow();
        this.window.setWindowAnimations(R.style.big_image_dialog_anim);
        WindowManager.LayoutParams wl = this.window.getAttributes();
        wl.x = this.mX;
        wl.y = this.mY;
        wl.horizontalMargin = 0.0f;
        wl.verticalMargin = 0.0f;
        wl.gravity = 51;
        this.window.setAttributes(wl);
    }
}
