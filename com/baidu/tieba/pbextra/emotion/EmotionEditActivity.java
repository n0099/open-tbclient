package com.baidu.tieba.pbextra.emotion;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pbextra.emotion.model.EmotionEditModel;
import com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout;
import com.baidu.tieba.pbextra.emotion.view.EmotionEditLayout;
import com.baidu.tieba.pbextra.emotion.view.EmotionEditText;
import java.io.File;
/* loaded from: classes3.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private a baE;
    private ImageView dGK;
    private com.baidu.tbadk.core.view.a dsY;
    private EmotionEditLayout fAT;
    private View fAU;
    private ChooseColorLayout fAV;
    private int fAW;
    private EmotionEditText fAX;
    private EmotionEditModel fAY;
    private String fAZ;
    private EmotionImageData fBa;
    private boolean fBb;
    private String fBc;
    private int fBd = 0;
    private Bitmap fBe;
    private long fBf;
    private EmotionImageData fgh;
    private String mFrom;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.i.emotion_edit_activity);
        this.fgh = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.fAY = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0126d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dsY = new com.baidu.tbadk.core.view.a(getPageContext());
        this.dsY.da(d.k.emotion_composition);
        this.dsY.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.fAY.kQ(true);
                EmotionEditActivity.this.bcN();
                EmotionEditActivity.this.auK();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_layout);
        this.fAT = (EmotionEditLayout) findViewById(d.g.edit_container);
        this.dGK = (ImageView) findViewById(d.g.close);
        this.fAU = findViewById(d.g.send);
        this.fAV = (ChooseColorLayout) findViewById(d.g.choose_color_layout);
        this.fAV.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void qP(int i) {
                EmotionEditActivity.this.fAX.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.dGK.setOnClickListener(this);
        this.fAU.setOnClickListener(this);
        this.fAW = l.af(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds300);
        bcM();
        bcL();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fAT.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        this.fAT.setLayoutParams(layoutParams);
        this.fAX.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.fAT.a(this.fAX);
        this.fAV.setVisibility(8);
    }

    private void bcL() {
        this.fAX = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.fAT.addView(this.fAX, layoutParams);
        this.fAX.setTextColor(this.fAV.getCurrentChooseColor());
        this.fAX.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.fAX.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.fAX.getEditText());
                }
            }
        });
    }

    private void bcM() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.fgh.getPicUrl();
            gifInfo.mDynamicUrl = this.fgh.getPicUrl();
            gifInfo.mStaticUrl = this.fgh.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.fgh.getPicUrl(), 10, true);
            c.fp().a(this.fgh.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.mImageView);
                            EmotionEditActivity.this.mImageView = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.mImageView).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.fgh.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.fgh.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.fgh.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.fgh.getWidth();
        this.mImageHeight = this.fgh.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.fAW;
            this.mImageHeight = this.fAW;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.fAW / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.fAW;
        } else {
            this.mImageWidth = (int) ((this.fAW / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.fAW;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.fAT.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.dGK) {
            finish();
        } else if (view2 == this.fAU) {
            send();
        } else if (view2 == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.fAX.getEditText());
        }
    }

    private void send() {
        if (!j.gP()) {
            showToast(d.k.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.baE == null) {
            this.baE = new a();
        }
        this.baE.wt();
        this.baE.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.baE.v(pageActivity) && !this.fBb) {
            this.fAY.kQ(false);
            this.fBb = true;
            this.fBf = System.currentTimeMillis();
            this.dsY.aI(true);
            HidenSoftKeyPad(this.mInputManager, this.fAX.getEditText());
            if (TextUtils.isEmpty(this.fAX.getText())) {
                this.fBa = this.fgh;
                bcQ();
                return;
            }
            String text = this.fAX.getText();
            switch (this.fBd) {
                case 2:
                    if (!TextUtils.isEmpty(this.fBc) && this.fBc.equals(text)) {
                        bcS();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.fBc) && this.fBc.equals(text) && !TextUtils.isEmpty(this.fAZ)) {
                        qZ(this.fAZ);
                        return;
                    }
                    break;
            }
            bcN();
            this.fBc = this.fAX.getText();
            bcO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcN() {
        if (this.fBe != null && !this.fBe.isRecycled()) {
            this.fBe.recycle();
            this.fBe = null;
        }
    }

    private void bcO() {
        this.fAY.ra(this.fAX.getText());
    }

    private void bcP() {
        if (!this.fAY.isCancel()) {
            this.fAX.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.C0126d.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.fAY.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.fAY.isCancel()) {
                        Bitmap t = t(bdImage.kl());
                        if (t != null) {
                            this.fAY.b(t, f.wA + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.k.upload_error);
                        this.fBd = 2;
                        auK();
                        return;
                    }
                    return;
                }
                showToast(d.k.upload_error);
                this.fBd = 2;
                auK();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.fAZ)) {
            auK();
        } else {
            this.fAY.N(this.fAZ, true);
        }
    }

    private void bcQ() {
        if (!this.fAY.isCancel()) {
            this.fBd = 0;
            auK();
            if (this.fBa != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.fBa);
                setResult(-1, intent);
                finish();
                bcR();
                if (!TextUtils.isEmpty(this.fAZ)) {
                    File file = new File(this.fAZ);
                    if (file.exists()) {
                        file.delete();
                        return;
                    }
                    return;
                }
                return;
            }
            showToast(d.k.upload_error);
        }
    }

    private void bcR() {
        al alVar = new al("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                alVar.r("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                alVar.r("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.fAX.getText())) {
            alVar.r("obj_type", 1);
        } else {
            alVar.r("obj_type", 2);
        }
        TiebaStatic.log(alVar);
    }

    public Bitmap t(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int i = this.mImageWidth;
        int i2 = this.mImageHeight;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (!this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / width, i2 / height);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.mIsGif ? width : i, this.mIsGif ? height : i2, config);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        if (!TextUtils.isEmpty(this.fAX.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bt = bt(width, height);
            if (bt != null) {
                canvas.drawBitmap(bt, (width * this.fAX.getLeft()) / i, (height * this.fAX.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bt(int i, int i2) {
        if (this.fBe != null) {
            return this.fBe;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.fAX.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.fAX.getTextView().getDrawingCache();
        this.fBe = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.fBe = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.fBe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.fAV.setVisibility(0);
            this.fAX.bdn();
            return;
        }
        this.fAV.setVisibility(8);
        this.fAX.bdm();
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
        ak.j(this.mRootView, d.C0126d.black_alpha40);
        ak.c(this.dGK, d.f.icon_emotion_close_n);
        ak.h(this.fAU, d.C0126d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bcN();
        if (this.fAY != null) {
            this.fAY.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bcS() {
        bcP();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void qY(String str) {
        showToast(str);
        this.fBd = 1;
        auK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auK() {
        this.fAX.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        this.dsY.aI(false);
        this.fBb = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void qZ(String str) {
        this.fAX.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            auK();
        } else if (!new File(str).exists()) {
            auK();
        } else {
            this.fAZ = str;
            this.fBd = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.fBf) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.fBa = new EmotionImageData();
                this.fBa.setPicId(uploadedPicInfo.getPic_id());
                this.fBa.setWidth(uploadedPicInfo.getWidth());
                this.fBa.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.fgh.getMemeContSign())) {
                    this.fBa.setMemeContSign(this.fgh.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.fBa.setPicUrl(picinfo.originPic.picUrl);
                    this.fBa.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.fBa.setMemeText(this.fAX.getText());
                this.fBa.setAuthorNameShow(this.fgh.getAuthorNameShow());
                bcQ();
                return;
            }
            showToast(d.k.upload_error);
            this.fBd = 3;
            auK();
            return;
        }
        showToast(d.k.upload_error);
        this.fBd = 3;
        auK();
    }
}
