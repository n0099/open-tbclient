package com.baidu.wallet.paysdk.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
/* loaded from: classes5.dex */
public class ImageViewDialog extends Dialog implements View.OnClickListener {
    public ImageView mCloseButton;
    public NetImageView mContentImgageView;
    public a mListener;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public ImageViewDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        initView();
    }

    public void initDialog(String str, a aVar) {
        this.mListener = aVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mContentImgageView.setImageUrl(str);
    }

    public void initView() {
        requestWindowFeature(1);
        setContentView(ResUtils.layout(getContext(), "wallet_cashdesk_imageview"));
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = window.getWindowManager().getDefaultDisplay().getHeight();
        attributes.width = -1;
        attributes.height = -1;
        onWindowAttributesChanged(attributes);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "wallet_base_cashdesk_result_dialog_market_close"));
        this.mCloseButton = imageView;
        imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.paysdk.ui.widget.ImageViewDialog.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                    ViewHelper.setAlpha(ImageViewDialog.this.mCloseButton, 1.0f);
                    return false;
                }
                ViewHelper.setAlpha(ImageViewDialog.this.mCloseButton, 0.5f);
                return false;
            }
        });
        this.mContentImgageView = (NetImageView) findViewById(ResUtils.id(getContext(), "wallet_base_cashdesk_result_dialog_market_imageview"));
        this.mCloseButton.setOnClickListener(this);
        this.mContentImgageView.setOnClickListener(this);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mContentImgageView) {
            a aVar = this.mListener;
            if (aVar != null) {
                aVar.a();
            }
        } else if (view == this.mCloseButton) {
            dismiss();
            a aVar2 = this.mListener;
            if (aVar2 != null) {
                aVar2.b();
            }
        }
    }

    public ImageViewDialog(Context context, int i) {
        super(context, i);
        initView();
    }
}
