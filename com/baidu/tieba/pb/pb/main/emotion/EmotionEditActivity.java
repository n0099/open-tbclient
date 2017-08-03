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
    private String aia;
    private ImageView brI;
    private EmotionEditLayout ePM;
    private EmotionImageData ePN;
    private View ePO;
    private ChooseColorLayout ePP;
    private int ePQ;
    private com.baidu.tieba.pb.pb.main.emotion.view.b ePR;
    private EmotionEditModel ePS;
    private String ePT;
    private EmotionImageData ePU;
    private String ePV;
    private int ePW = 0;
    private com.baidu.tbadk.core.view.a ePX;
    private long ePY;
    private boolean ewA;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private View mRootView;
    private boolean sa;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.j.emotion_edit_activity);
        this.ePN = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.sa = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.aia = getIntent().getStringExtra("from");
        initView();
        this.ePS = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.e.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.ePX = new com.baidu.tbadk.core.view.a(getPageContext());
        this.ePX.da(d.l.emotion_composition);
        this.ePX.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.ePS.jN(true);
                EmotionEditActivity.this.aiQ();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.h.root_layout);
        this.ePM = (EmotionEditLayout) findViewById(d.h.edit_container);
        this.brI = (ImageView) findViewById(d.h.close);
        this.ePO = findViewById(d.h.send);
        this.ePP = (ChooseColorLayout) findViewById(d.h.choose_color_layout);
        this.ePP.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.a
            public void pl(int i) {
                EmotionEditActivity.this.ePR.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.brI.setOnClickListener(this);
        this.ePO.setOnClickListener(this);
        this.ePQ = k.af(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds300);
        aTK();
        aTJ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ePM.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds80);
        this.ePM.setLayoutParams(layoutParams);
        this.ePR.bc(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40));
        this.ePM.a(this.ePR);
        this.ePP.setVisibility(8);
    }

    private void aTJ() {
        this.ePR = new com.baidu.tieba.pb.pb.main.emotion.view.b(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40));
        this.ePM.addView(this.ePR, layoutParams);
        this.ePR.setTextColor(this.ePP.getCurrentChooseColor());
        this.ePR.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.ePR.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.ePR.getEditText());
                }
            }
        });
    }

    private void aTK() {
        if (this.sa) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.ePN.getPicUrl();
            gifInfo.mDynamicUrl = this.ePN.getPicUrl();
            gifInfo.mStaticUrl = this.ePN.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).c(this.ePN.getPicUrl(), 10, true);
            c.fJ().a(this.ePN.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.sa = aVar.isGif();
                        if (EmotionEditActivity.this.sa) {
                            aVar.e(EmotionEditActivity.this.mImageView);
                            EmotionEditActivity.this.mImageView = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.mImageView).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.ePN.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.ePN.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.ePN.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.ePN.getWidth();
        this.mImageHeight = this.ePN.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.ePQ;
            this.mImageHeight = this.ePQ;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.ePQ / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.ePQ;
        } else {
            this.mImageWidth = (int) ((this.ePQ / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.ePQ;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.ePM.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.brI) {
            finish();
        } else if (view == this.ePO) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.ePR.getEditText());
        }
    }

    private void send() {
        if (!i.hh()) {
            showToast(d.l.neterror);
        } else if (!this.ewA) {
            this.ePS.jN(false);
            this.ewA = true;
            this.ePY = System.currentTimeMillis();
            this.ePX.aH(true);
            HidenSoftKeyPad(this.mInputManager, this.ePR.getEditText());
            if (TextUtils.isEmpty(this.ePR.getText())) {
                this.ePU = this.ePN;
                aTN();
                return;
            }
            String text = this.ePR.getText();
            switch (this.ePW) {
                case 2:
                    if (!TextUtils.isEmpty(this.ePV) && this.ePV.equals(text)) {
                        aTP();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.ePV) && this.ePV.equals(text) && !TextUtils.isEmpty(this.ePT)) {
                        py(this.ePT);
                        return;
                    }
                    break;
            }
            this.ePV = this.ePR.getText();
            aTL();
        }
    }

    private void aTL() {
        this.ePS.pz(this.ePR.getText());
    }

    private void aTM() {
        if (!this.ePS.fr()) {
            if (this.sa) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.ePS.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.a.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.ePS.fr()) {
                        Bitmap l = l(bdImage.kN());
                        if (l != null) {
                            this.ePS.a(l, e.yu + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.l.upload_error);
                        this.ePW = 2;
                        aiQ();
                        return;
                    }
                    return;
                }
                showToast(d.l.upload_error);
                this.ePW = 2;
                aiQ();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.ePT)) {
            aiQ();
        } else {
            this.ePS.U(this.ePT, true);
        }
    }

    private void aTN() {
        if (!this.ePS.fr()) {
            this.ePW = 0;
            aiQ();
            if (this.ePU != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.ePU);
                setResult(-1, intent);
                finish();
                aTO();
                if (!TextUtils.isEmpty(this.ePT)) {
                    File file = new File(this.ePT);
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

    private void aTO() {
        aj ajVar = new aj("c12329");
        if (!TextUtils.isEmpty(this.aia)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.aia)) {
                ajVar.r("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.aia)) {
                ajVar.r("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.ePR.getText())) {
            ajVar.r("obj_type", 1);
        } else {
            ajVar.r("obj_type", 2);
        }
        TiebaStatic.log(ajVar);
    }

    public Bitmap l(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int i = this.mImageWidth;
        int i2 = this.mImageHeight;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (!this.sa) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / width, i2 / height);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.sa ? width : i, this.sa ? height : i2, config);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        String text = this.ePR.getText();
        if (!TextUtils.isEmpty(text)) {
            if (!this.sa) {
                height = i2;
                width = i;
            }
            TextPaint textPaint = new TextPaint();
            textPaint.setTypeface(this.ePR.getTextView().getTypeface());
            textPaint.setAntiAlias(true);
            textPaint.setTextAlign(Paint.Align.LEFT);
            textPaint.setTextSize((this.ePR.getTextSize() * height) / i2);
            textPaint.setColor(this.ePR.getTextColor());
            textPaint.setFakeBoldText(true);
            canvas.drawText(k.a(textPaint, text, (width * ((this.ePR.getTextView().getWidth() - this.ePR.getTextView().getPaddingLeft()) - this.ePR.getTextView().getPaddingRight())) / i), ((this.ePR.getLeft() + this.ePR.getTextView().getPaddingLeft()) * width) / i, (height * (Math.abs(textPaint.getFontMetrics().ascent) + (this.ePR.getTop() + this.ePR.getTextView().getPaddingTop()))) / i2, textPaint);
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
            this.ePP.setVisibility(0);
            this.ePR.aUm();
            return;
        }
        this.ePP.setVisibility(8);
        this.ePR.aUl();
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
        ai.c(this.brI, d.g.icon_emotion_close_n);
        ai.i(this.ePO, d.e.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ePS != null) {
            this.ePS.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void aTP() {
        aTM();
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void px(String str) {
        showToast(str);
        this.ePW = 1;
        aiQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiQ() {
        this.ePX.aH(false);
        this.ewA = false;
        if (this.sa) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void py(String str) {
        if (TextUtils.isEmpty(str)) {
            aiQ();
        } else if (!new File(str).exists()) {
            aiQ();
        } else {
            this.ePT = str;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.ePY) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void d(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.ePU = new EmotionImageData();
                this.ePU.setPicId(uploadedPicInfo.getPic_id());
                this.ePU.setWidth(uploadedPicInfo.getWidth());
                this.ePU.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.ePN.getMemeContSign())) {
                    this.ePU.setMemeContSign(this.ePN.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.ePU.setPicUrl(picinfo.originPic.picUrl);
                    this.ePU.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.ePU.setMemeText(this.ePR.getText());
                aTN();
                return;
            }
            showToast(d.l.upload_error);
            this.ePW = 3;
            aiQ();
            return;
        }
        showToast(d.l.upload_error);
        this.ePW = 3;
        aiQ();
    }
}
