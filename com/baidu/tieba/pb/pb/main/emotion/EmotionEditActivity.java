package com.baidu.tieba.pb.pb.main.emotion;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.e;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel;
import com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout;
import com.baidu.tieba.pb.pb.main.emotion.view.EmotionEditLayout;
import java.io.File;
/* loaded from: classes.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private String ajt;
    private ImageView bsS;
    private EmotionEditLayout eQZ;
    private EmotionImageData eRa;
    private View eRb;
    private ChooseColorLayout eRc;
    private int eRd;
    private com.baidu.tieba.pb.pb.main.emotion.view.b eRe;
    private EmotionEditModel eRf;
    private String eRg;
    private EmotionImageData eRh;
    private String eRi;
    private int eRj = 0;
    private com.baidu.tbadk.core.view.a eRk;
    private long eRl;
    private boolean exS;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private View mRootView;
    private boolean tI;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.j.emotion_edit_activity);
        this.eRa = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.tI = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.ajt = getIntent().getStringExtra("from");
        initView();
        this.eRf = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.e.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eRk = new com.baidu.tbadk.core.view.a(getPageContext());
        this.eRk.dc(d.l.emotion_composition);
        this.eRk.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.eRf.jN(true);
                EmotionEditActivity.this.ajc();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.h.root_layout);
        this.eQZ = (EmotionEditLayout) findViewById(d.h.edit_container);
        this.bsS = (ImageView) findViewById(d.h.close);
        this.eRb = findViewById(d.h.send);
        this.eRc = (ChooseColorLayout) findViewById(d.h.choose_color_layout);
        this.eRc.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.a
            public void pl(int i) {
                EmotionEditActivity.this.eRe.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.bsS.setOnClickListener(this);
        this.eRb.setOnClickListener(this);
        this.eRd = k.ag(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds300);
        aTV();
        aTU();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eQZ.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds80);
        this.eQZ.setLayoutParams(layoutParams);
        this.eRe.bd(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40));
        this.eQZ.a(this.eRe);
        this.eRc.setVisibility(8);
    }

    private void aTU() {
        this.eRe = new com.baidu.tieba.pb.pb.main.emotion.view.b(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40));
        this.eQZ.addView(this.eRe, layoutParams);
        this.eRe.setTextColor(this.eRc.getCurrentChooseColor());
        this.eRe.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eRe.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eRe.getEditText());
                }
            }
        });
    }

    private void aTV() {
        if (this.tI) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.eRa.getPicUrl();
            gifInfo.mDynamicUrl = this.eRa.getPicUrl();
            gifInfo.mStaticUrl = this.eRa.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).c(this.eRa.getPicUrl(), 10, true);
            c.fU().a(this.eRa.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.tI = aVar.isGif();
                        if (EmotionEditActivity.this.tI) {
                            aVar.e(EmotionEditActivity.this.mImageView);
                            EmotionEditActivity.this.mImageView = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.mImageView).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.eRa.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.eRa.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.eRa.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.eRa.getWidth();
        this.mImageHeight = this.eRa.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.eRd;
            this.mImageHeight = this.eRd;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.eRd / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.eRd;
        } else {
            this.mImageWidth = (int) ((this.eRd / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.eRd;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.eQZ.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bsS) {
            finish();
        } else if (view == this.eRb) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.eRe.getEditText());
        }
    }

    private void send() {
        if (!i.hr()) {
            showToast(d.l.neterror);
        } else if (!this.exS) {
            this.eRf.jN(false);
            this.exS = true;
            this.eRl = System.currentTimeMillis();
            this.eRk.aH(true);
            HidenSoftKeyPad(this.mInputManager, this.eRe.getEditText());
            if (TextUtils.isEmpty(this.eRe.getText())) {
                this.eRh = this.eRa;
                aTY();
                return;
            }
            String text = this.eRe.getText();
            switch (this.eRj) {
                case 2:
                    if (!TextUtils.isEmpty(this.eRi) && this.eRi.equals(text)) {
                        aUa();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.eRi) && this.eRi.equals(text) && !TextUtils.isEmpty(this.eRg)) {
                        pD(this.eRg);
                        return;
                    }
                    break;
            }
            this.eRi = this.eRe.getText();
            aTW();
        }
    }

    private void aTW() {
        this.eRf.pE(this.eRe.getText());
    }

    private void aTX() {
        if (!this.eRf.fC()) {
            if (this.tI) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.eRf.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.a.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.eRf.fC()) {
                        Bitmap m = m(bdImage.kX());
                        if (m != null) {
                            this.eRf.a(m, e.zU + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.l.upload_error);
                        this.eRj = 2;
                        ajc();
                        return;
                    }
                    return;
                }
                showToast(d.l.upload_error);
                this.eRj = 2;
                ajc();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.eRg)) {
            ajc();
        } else {
            this.eRf.T(this.eRg, true);
        }
    }

    private void aTY() {
        if (!this.eRf.fC()) {
            this.eRj = 0;
            ajc();
            if (this.eRh != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.eRh);
                setResult(-1, intent);
                finish();
                aTZ();
                if (!TextUtils.isEmpty(this.eRg)) {
                    File file = new File(this.eRg);
                    if (file.exists()) {
                        file.delete();
                        return;
                    }
                    return;
                }
                return;
            }
            showToast(d.l.upload_error);
        }
    }

    private void aTZ() {
        aj ajVar = new aj("c12329");
        if (!TextUtils.isEmpty(this.ajt)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.ajt)) {
                ajVar.r("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.ajt)) {
                ajVar.r("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.eRe.getText())) {
            ajVar.r("obj_type", 1);
        } else {
            ajVar.r("obj_type", 2);
        }
        TiebaStatic.log(ajVar);
    }

    public Bitmap m(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int i = this.mImageWidth;
        int i2 = this.mImageHeight;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (!this.tI) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / width, i2 / height);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.tI ? width : i, this.tI ? height : i2, config);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        String text = this.eRe.getText();
        if (!TextUtils.isEmpty(text)) {
            if (!this.tI) {
                height = i2;
                width = i;
            }
            TextPaint textPaint = new TextPaint();
            textPaint.setTypeface(this.eRe.getTextView().getTypeface());
            textPaint.setAntiAlias(true);
            textPaint.setTextAlign(Paint.Align.LEFT);
            textPaint.setTextSize((this.eRe.getTextSize() * height) / i2);
            textPaint.setColor(this.eRe.getTextColor());
            textPaint.setFakeBoldText(true);
            canvas.drawText(k.a(textPaint, text, (width * ((this.eRe.getTextView().getWidth() - this.eRe.getTextView().getPaddingLeft()) - this.eRe.getTextView().getPaddingRight())) / i), ((this.eRe.getLeft() + this.eRe.getTextView().getPaddingLeft()) * width) / i, (height * (Math.abs(textPaint.getFontMetrics().ascent) + (this.eRe.getTop() + this.eRe.getTextView().getPaddingTop()))) / i2, textPaint);
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.eRc.setVisibility(0);
            this.eRe.aUx();
            return;
        }
        this.eRc.setVisibility(8);
        this.eRe.aUw();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(d.a.fade_in, d.a.fade_out);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(d.a.fade_in, d.a.fade_out);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ai.k(this.mRootView, d.e.black_alpha40);
        ai.c(this.bsS, d.g.icon_emotion_close_n);
        ai.i(this.eRb, d.e.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eRf != null) {
            this.eRf.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void aUa() {
        aTX();
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void pC(String str) {
        showToast(str);
        this.eRj = 1;
        ajc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajc() {
        this.eRk.aH(false);
        this.exS = false;
        if (this.tI) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void pD(String str) {
        if (TextUtils.isEmpty(str)) {
            ajc();
        } else if (!new File(str).exists()) {
            ajc();
        } else {
            this.eRg = str;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.eRl) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void d(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.eRh = new EmotionImageData();
                this.eRh.setPicId(uploadedPicInfo.getPic_id());
                this.eRh.setWidth(uploadedPicInfo.getWidth());
                this.eRh.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.eRa.getMemeContSign())) {
                    this.eRh.setMemeContSign(this.eRa.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.eRh.setPicUrl(picinfo.originPic.picUrl);
                    this.eRh.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.eRh.setMemeText(this.eRe.getText());
                aTY();
                return;
            }
            showToast(d.l.upload_error);
            this.eRj = 3;
            ajc();
            return;
        }
        showToast(d.l.upload_error);
        this.eRj = 3;
        ajc();
    }
}
