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
    private ImageView bth;
    private EmotionEditLayout eSS;
    private EmotionImageData eST;
    private View eSU;
    private ChooseColorLayout eSV;
    private int eSW;
    private com.baidu.tieba.pb.pb.main.emotion.view.b eSX;
    private EmotionEditModel eSY;
    private String eSZ;
    private EmotionImageData eTa;
    private String eTb;
    private int eTc = 0;
    private com.baidu.tbadk.core.view.a eTd;
    private long eTe;
    private boolean ezN;
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
        this.eST = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.tK = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.ajv = getIntent().getStringExtra("from");
        initView();
        this.eSY = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.e.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eTd = new com.baidu.tbadk.core.view.a(getPageContext());
        this.eTd.dc(d.l.emotion_composition);
        this.eTd.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.eSY.jQ(true);
                EmotionEditActivity.this.ajJ();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.h.root_layout);
        this.eSS = (EmotionEditLayout) findViewById(d.h.edit_container);
        this.bth = (ImageView) findViewById(d.h.close);
        this.eSU = findViewById(d.h.send);
        this.eSV = (ChooseColorLayout) findViewById(d.h.choose_color_layout);
        this.eSV.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.a
            public void pv(int i) {
                EmotionEditActivity.this.eSX.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.bth.setOnClickListener(this);
        this.eSU.setOnClickListener(this);
        this.eSW = k.ag(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds300);
        aUC();
        aUB();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eSS.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds80);
        this.eSS.setLayoutParams(layoutParams);
        this.eSX.bl(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40));
        this.eSS.a(this.eSX);
        this.eSV.setVisibility(8);
    }

    private void aUB() {
        this.eSX = new com.baidu.tieba.pb.pb.main.emotion.view.b(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40));
        this.eSS.addView(this.eSX, layoutParams);
        this.eSX.setTextColor(this.eSV.getCurrentChooseColor());
        this.eSX.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eSX.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eSX.getEditText());
                }
            }
        });
    }

    private void aUC() {
        if (this.tK) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.eST.getPicUrl();
            gifInfo.mDynamicUrl = this.eST.getPicUrl();
            gifInfo.mStaticUrl = this.eST.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).c(this.eST.getPicUrl(), 10, true);
            c.fU().a(this.eST.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.eST.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.eST.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.eST.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.eST.getWidth();
        this.mImageHeight = this.eST.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.eSW;
            this.mImageHeight = this.eSW;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.eSW / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.eSW;
        } else {
            this.mImageWidth = (int) ((this.eSW / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.eSW;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.eSS.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bth) {
            finish();
        } else if (view == this.eSU) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.eSX.getEditText());
        }
    }

    private void send() {
        if (!i.hr()) {
            showToast(d.l.neterror);
        } else if (!this.ezN) {
            this.eSY.jQ(false);
            this.ezN = true;
            this.eTe = System.currentTimeMillis();
            this.eTd.aH(true);
            HidenSoftKeyPad(this.mInputManager, this.eSX.getEditText());
            if (TextUtils.isEmpty(this.eSX.getText())) {
                this.eTa = this.eST;
                aUF();
                return;
            }
            String text = this.eSX.getText();
            switch (this.eTc) {
                case 2:
                    if (!TextUtils.isEmpty(this.eTb) && this.eTb.equals(text)) {
                        aUH();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.eTb) && this.eTb.equals(text) && !TextUtils.isEmpty(this.eSZ)) {
                        pG(this.eSZ);
                        return;
                    }
                    break;
            }
            this.eTb = this.eSX.getText();
            aUD();
        }
    }

    private void aUD() {
        this.eSY.pH(this.eSX.getText());
    }

    private void aUE() {
        if (!this.eSY.fC()) {
            if (this.tK) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.eSY.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.a.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.eSY.fC()) {
                        Bitmap m = m(bdImage.kX());
                        if (m != null) {
                            this.eSY.a(m, e.zW + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.l.upload_error);
                        this.eTc = 2;
                        ajJ();
                        return;
                    }
                    return;
                }
                showToast(d.l.upload_error);
                this.eTc = 2;
                ajJ();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.eSZ)) {
            ajJ();
        } else {
            this.eSY.U(this.eSZ, true);
        }
    }

    private void aUF() {
        if (!this.eSY.fC()) {
            this.eTc = 0;
            ajJ();
            if (this.eTa != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.eTa);
                setResult(-1, intent);
                finish();
                aUG();
                if (!TextUtils.isEmpty(this.eSZ)) {
                    File file = new File(this.eSZ);
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

    private void aUG() {
        aj ajVar = new aj("c12329");
        if (!TextUtils.isEmpty(this.ajv)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.ajv)) {
                ajVar.r("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.ajv)) {
                ajVar.r("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.eSX.getText())) {
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
        String text = this.eSX.getText();
        if (!TextUtils.isEmpty(text)) {
            if (!this.tK) {
                height = i2;
                width = i;
            }
            TextPaint textPaint = new TextPaint();
            textPaint.setTypeface(this.eSX.getTextView().getTypeface());
            textPaint.setAntiAlias(true);
            textPaint.setTextAlign(Paint.Align.LEFT);
            textPaint.setTextSize((this.eSX.getTextSize() * height) / i2);
            textPaint.setColor(this.eSX.getTextColor());
            textPaint.setFakeBoldText(true);
            canvas.drawText(k.a(textPaint, text, (width * ((this.eSX.getTextView().getWidth() - this.eSX.getTextView().getPaddingLeft()) - this.eSX.getTextView().getPaddingRight())) / i), ((this.eSX.getLeft() + this.eSX.getTextView().getPaddingLeft()) * width) / i, (height * (Math.abs(textPaint.getFontMetrics().ascent) + (this.eSX.getTop() + this.eSX.getTextView().getPaddingTop()))) / i2, textPaint);
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
            this.eSV.setVisibility(0);
            this.eSX.aVe();
            return;
        }
        this.eSV.setVisibility(8);
        this.eSX.aVd();
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
        ai.c(this.bth, d.g.icon_emotion_close_n);
        ai.i(this.eSU, d.e.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eSY != null) {
            this.eSY.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void aUH() {
        aUE();
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void pF(String str) {
        showToast(str);
        this.eTc = 1;
        ajJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajJ() {
        this.eTd.aH(false);
        this.ezN = false;
        if (this.tK) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void pG(String str) {
        if (TextUtils.isEmpty(str)) {
            ajJ();
        } else if (!new File(str).exists()) {
            ajJ();
        } else {
            this.eSZ = str;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.eTe) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void d(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.eTa = new EmotionImageData();
                this.eTa.setPicId(uploadedPicInfo.getPic_id());
                this.eTa.setWidth(uploadedPicInfo.getWidth());
                this.eTa.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.eST.getMemeContSign())) {
                    this.eTa.setMemeContSign(this.eST.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.eTa.setPicUrl(picinfo.originPic.picUrl);
                    this.eTa.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.eTa.setMemeText(this.eSX.getText());
                aUF();
                return;
            }
            showToast(d.l.upload_error);
            this.eTc = 3;
            ajJ();
            return;
        }
        showToast(d.l.upload_error);
        this.eTc = 3;
        ajJ();
    }
}
