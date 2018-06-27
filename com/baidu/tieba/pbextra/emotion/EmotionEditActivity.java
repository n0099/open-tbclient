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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
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
    private a bkp;
    private ImageView dVU;
    private com.baidu.tbadk.core.view.a dbO;
    private String fQA;
    private int fQB = 0;
    private Bitmap fQC;
    private long fQD;
    private EmotionEditLayout fQr;
    private View fQs;
    private ChooseColorLayout fQt;
    private int fQu;
    private EmotionEditText fQv;
    private EmotionEditModel fQw;
    private String fQx;
    private EmotionImageData fQy;
    private boolean fQz;
    private EmotionImageData fvy;
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
        this.fvy = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.fQw = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0142d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dbO = new com.baidu.tbadk.core.view.a(getPageContext());
        this.dbO.dd(d.k.emotion_composition);
        this.dbO.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.fQw.lg(true);
                EmotionEditActivity.this.bit();
                EmotionEditActivity.this.azA();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_layout);
        this.fQr = (EmotionEditLayout) findViewById(d.g.edit_container);
        this.dVU = (ImageView) findViewById(d.g.close);
        this.fQs = findViewById(d.g.send);
        this.fQt = (ChooseColorLayout) findViewById(d.g.choose_color_layout);
        this.fQt.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void rk(int i) {
                EmotionEditActivity.this.fQv.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.dVU.setOnClickListener(this);
        this.fQs.setOnClickListener(this);
        this.fQu = l.ah(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds300);
        bis();
        bir();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fQr.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        this.fQr.setLayoutParams(layoutParams);
        this.fQv.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.fQr.a(this.fQv);
        this.fQt.setVisibility(8);
    }

    private void bir() {
        this.fQv = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.fQr.addView(this.fQv, layoutParams);
        this.fQv.setTextColor(this.fQt.getCurrentChooseColor());
        this.fQv.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.fQv.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.fQv.getEditText());
                }
            }
        });
    }

    private void bis() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.fvy.getPicUrl();
            gifInfo.mDynamicUrl = this.fvy.getPicUrl();
            gifInfo.mStaticUrl = this.fvy.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.fvy.getPicUrl(), 10, true);
            c.ig().a(this.fvy.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.fvy.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.fvy.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.fvy.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.fvy.getWidth();
        this.mImageHeight = this.fvy.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.fQu;
            this.mImageHeight = this.fQu;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.fQu / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.fQu;
        } else {
            this.mImageWidth = (int) ((this.fQu / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.fQu;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.fQr.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dVU) {
            finish();
        } else if (view == this.fQs) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.fQv.getEditText());
        }
    }

    private void send() {
        if (!j.jD()) {
            showToast(d.k.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bkp == null) {
            this.bkp = new a();
        }
        this.bkp.Aj();
        this.bkp.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bkp.u(pageActivity) && !this.fQz) {
            this.fQw.lg(false);
            this.fQz = true;
            this.fQD = System.currentTimeMillis();
            this.dbO.aO(true);
            HidenSoftKeyPad(this.mInputManager, this.fQv.getEditText());
            if (TextUtils.isEmpty(this.fQv.getText())) {
                this.fQy = this.fvy;
                biw();
                return;
            }
            String text = this.fQv.getText();
            switch (this.fQB) {
                case 2:
                    if (!TextUtils.isEmpty(this.fQA) && this.fQA.equals(text)) {
                        biy();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.fQA) && this.fQA.equals(text) && !TextUtils.isEmpty(this.fQx)) {
                        rO(this.fQx);
                        return;
                    }
                    break;
            }
            bit();
            this.fQA = this.fQv.getText();
            biu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bit() {
        if (this.fQC != null && !this.fQC.isRecycled()) {
            this.fQC.recycle();
            this.fQC = null;
        }
    }

    private void biu() {
        this.fQw.rP(this.fQv.getText());
    }

    private void biv() {
        if (!this.fQw.isCancel()) {
            this.fQv.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.C0142d.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.fQw.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.fQw.isCancel()) {
                        Bitmap s = s(bdImage.mZ());
                        if (s != null) {
                            this.fQw.b(s, f.CH + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.k.upload_error);
                        this.fQB = 2;
                        azA();
                        return;
                    }
                    return;
                }
                showToast(d.k.upload_error);
                this.fQB = 2;
                azA();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.fQx)) {
            azA();
        } else {
            this.fQw.O(this.fQx, true);
        }
    }

    private void biw() {
        if (!this.fQw.isCancel()) {
            this.fQB = 0;
            azA();
            if (this.fQy != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.fQy);
                setResult(-1, intent);
                finish();
                bix();
                if (!TextUtils.isEmpty(this.fQx)) {
                    File file = new File(this.fQx);
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

    private void bix() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.r("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.r("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.fQv.getText())) {
            anVar.r("obj_type", 1);
        } else {
            anVar.r("obj_type", 2);
        }
        TiebaStatic.log(anVar);
    }

    public Bitmap s(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.fQv.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bu = bu(width, height);
            if (bu != null) {
                canvas.drawBitmap(bu, (width * this.fQv.getLeft()) / i, (height * this.fQv.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bu(int i, int i2) {
        if (this.fQC != null) {
            return this.fQC;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.fQv.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.fQv.getTextView().getDrawingCache();
        this.fQC = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.fQC = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.fQC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.fQt.setVisibility(0);
            this.fQv.biT();
            return;
        }
        this.fQt.setVisibility(8);
        this.fQv.biS();
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
        am.j(this.mRootView, d.C0142d.black_alpha40);
        am.c(this.dVU, d.f.icon_emotion_close_n);
        am.h(this.fQs, d.C0142d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bit();
        if (this.fQw != null) {
            this.fQw.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void biy() {
        biv();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void rN(String str) {
        showToast(str);
        this.fQB = 1;
        azA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azA() {
        this.fQv.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        this.dbO.aO(false);
        this.fQz = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void rO(String str) {
        this.fQv.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            azA();
        } else if (!new File(str).exists()) {
            azA();
        } else {
            this.fQx = str;
            this.fQB = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.fQD) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.fQy = new EmotionImageData();
                this.fQy.setPicId(uploadedPicInfo.getPic_id());
                this.fQy.setWidth(uploadedPicInfo.getWidth());
                this.fQy.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.fvy.getMemeContSign())) {
                    this.fQy.setMemeContSign(this.fvy.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.fQy.setPicUrl(picinfo.originPic.picUrl);
                    this.fQy.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.fQy.setMemeText(this.fQv.getText());
                this.fQy.setAuthorNameShow(this.fvy.getAuthorNameShow());
                biw();
                return;
            }
            showToast(d.k.upload_error);
            this.fQB = 3;
            azA();
            return;
        }
        showToast(d.k.upload_error);
        this.fQB = 3;
        azA();
    }
}
