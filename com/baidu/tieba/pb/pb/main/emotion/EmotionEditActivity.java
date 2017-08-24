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
    private String ajv;
    private ImageView bti;
    private EmotionEditLayout eSU;
    private EmotionImageData eSV;
    private View eSW;
    private ChooseColorLayout eSX;
    private int eSY;
    private com.baidu.tieba.pb.pb.main.emotion.view.b eSZ;
    private EmotionEditModel eTa;
    private String eTb;
    private EmotionImageData eTc;
    private String eTd;
    private int eTe = 0;
    private com.baidu.tbadk.core.view.a eTf;
    private long eTg;
    private boolean ezP;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private View mRootView;
    private boolean tK;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.j.emotion_edit_activity);
        this.eSV = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.tK = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.ajv = getIntent().getStringExtra("from");
        initView();
        this.eTa = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.e.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eTf = new com.baidu.tbadk.core.view.a(getPageContext());
        this.eTf.dc(d.l.emotion_composition);
        this.eTf.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.eTa.jQ(true);
                EmotionEditActivity.this.ajD();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.h.root_layout);
        this.eSU = (EmotionEditLayout) findViewById(d.h.edit_container);
        this.bti = (ImageView) findViewById(d.h.close);
        this.eSW = findViewById(d.h.send);
        this.eSX = (ChooseColorLayout) findViewById(d.h.choose_color_layout);
        this.eSX.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.a
            public void pv(int i) {
                EmotionEditActivity.this.eSZ.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.bti.setOnClickListener(this);
        this.eSW.setOnClickListener(this);
        this.eSY = k.ag(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds300);
        aUx();
        aUw();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eSU.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds80);
        this.eSU.setLayoutParams(layoutParams);
        this.eSZ.bl(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40));
        this.eSU.a(this.eSZ);
        this.eSX.setVisibility(8);
    }

    private void aUw() {
        this.eSZ = new com.baidu.tieba.pb.pb.main.emotion.view.b(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40));
        this.eSU.addView(this.eSZ, layoutParams);
        this.eSZ.setTextColor(this.eSX.getCurrentChooseColor());
        this.eSZ.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eSZ.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eSZ.getEditText());
                }
            }
        });
    }

    private void aUx() {
        if (this.tK) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.eSV.getPicUrl();
            gifInfo.mDynamicUrl = this.eSV.getPicUrl();
            gifInfo.mStaticUrl = this.eSV.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).c(this.eSV.getPicUrl(), 10, true);
            c.fU().a(this.eSV.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.tK = aVar.isGif();
                        if (EmotionEditActivity.this.tK) {
                            aVar.e(EmotionEditActivity.this.mImageView);
                            EmotionEditActivity.this.mImageView = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.mImageView).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.eSV.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.eSV.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.eSV.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.eSV.getWidth();
        this.mImageHeight = this.eSV.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.eSY;
            this.mImageHeight = this.eSY;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.eSY / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.eSY;
        } else {
            this.mImageWidth = (int) ((this.eSY / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.eSY;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.eSU.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bti) {
            finish();
        } else if (view == this.eSW) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.eSZ.getEditText());
        }
    }

    private void send() {
        if (!i.hr()) {
            showToast(d.l.neterror);
        } else if (!this.ezP) {
            this.eTa.jQ(false);
            this.ezP = true;
            this.eTg = System.currentTimeMillis();
            this.eTf.aH(true);
            HidenSoftKeyPad(this.mInputManager, this.eSZ.getEditText());
            if (TextUtils.isEmpty(this.eSZ.getText())) {
                this.eTc = this.eSV;
                aUA();
                return;
            }
            String text = this.eSZ.getText();
            switch (this.eTe) {
                case 2:
                    if (!TextUtils.isEmpty(this.eTd) && this.eTd.equals(text)) {
                        aUC();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.eTd) && this.eTd.equals(text) && !TextUtils.isEmpty(this.eTb)) {
                        pL(this.eTb);
                        return;
                    }
                    break;
            }
            this.eTd = this.eSZ.getText();
            aUy();
        }
    }

    private void aUy() {
        this.eTa.pM(this.eSZ.getText());
    }

    private void aUz() {
        if (!this.eTa.fC()) {
            if (this.tK) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.eTa.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.a.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.eTa.fC()) {
                        Bitmap m = m(bdImage.kW());
                        if (m != null) {
                            this.eTa.a(m, e.zW + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.l.upload_error);
                        this.eTe = 2;
                        ajD();
                        return;
                    }
                    return;
                }
                showToast(d.l.upload_error);
                this.eTe = 2;
                ajD();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.eTb)) {
            ajD();
        } else {
            this.eTa.U(this.eTb, true);
        }
    }

    private void aUA() {
        if (!this.eTa.fC()) {
            this.eTe = 0;
            ajD();
            if (this.eTc != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.eTc);
                setResult(-1, intent);
                finish();
                aUB();
                if (!TextUtils.isEmpty(this.eTb)) {
                    File file = new File(this.eTb);
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

    private void aUB() {
        aj ajVar = new aj("c12329");
        if (!TextUtils.isEmpty(this.ajv)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.ajv)) {
                ajVar.r("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.ajv)) {
                ajVar.r("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.eSZ.getText())) {
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
        if (!this.tK) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / width, i2 / height);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.tK ? width : i, this.tK ? height : i2, config);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        String text = this.eSZ.getText();
        if (!TextUtils.isEmpty(text)) {
            if (!this.tK) {
                height = i2;
                width = i;
            }
            TextPaint textPaint = new TextPaint();
            textPaint.setTypeface(this.eSZ.getTextView().getTypeface());
            textPaint.setAntiAlias(true);
            textPaint.setTextAlign(Paint.Align.LEFT);
            textPaint.setTextSize((this.eSZ.getTextSize() * height) / i2);
            textPaint.setColor(this.eSZ.getTextColor());
            textPaint.setFakeBoldText(true);
            canvas.drawText(k.a(textPaint, text, (width * ((this.eSZ.getTextView().getWidth() - this.eSZ.getTextView().getPaddingLeft()) - this.eSZ.getTextView().getPaddingRight())) / i), ((this.eSZ.getLeft() + this.eSZ.getTextView().getPaddingLeft()) * width) / i, (height * (Math.abs(textPaint.getFontMetrics().ascent) + (this.eSZ.getTop() + this.eSZ.getTextView().getPaddingTop()))) / i2, textPaint);
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
            this.eSX.setVisibility(0);
            this.eSZ.aUZ();
            return;
        }
        this.eSX.setVisibility(8);
        this.eSZ.aUY();
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
        ai.c(this.bti, d.g.icon_emotion_close_n);
        ai.i(this.eSW, d.e.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eTa != null) {
            this.eTa.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void aUC() {
        aUz();
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void pK(String str) {
        showToast(str);
        this.eTe = 1;
        ajD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajD() {
        this.eTf.aH(false);
        this.ezP = false;
        if (this.tK) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void pL(String str) {
        if (TextUtils.isEmpty(str)) {
            ajD();
        } else if (!new File(str).exists()) {
            ajD();
        } else {
            this.eTb = str;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.eTg) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void d(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.eTc = new EmotionImageData();
                this.eTc.setPicId(uploadedPicInfo.getPic_id());
                this.eTc.setWidth(uploadedPicInfo.getWidth());
                this.eTc.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.eSV.getMemeContSign())) {
                    this.eTc.setMemeContSign(this.eSV.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.eTc.setPicUrl(picinfo.originPic.picUrl);
                    this.eTc.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.eTc.setMemeText(this.eSZ.getText());
                aUA();
                return;
            }
            showToast(d.l.upload_error);
            this.eTe = 3;
            ajD();
            return;
        }
        showToast(d.l.upload_error);
        this.eTe = 3;
        ajD();
    }
}
