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
    private a baD;
    private ImageView dFH;
    private com.baidu.tbadk.core.view.a drT;
    private int fAa = 0;
    private Bitmap fAb;
    private long fAc;
    private EmotionImageData ffd;
    private EmotionEditLayout fzQ;
    private View fzR;
    private ChooseColorLayout fzS;
    private int fzT;
    private EmotionEditText fzU;
    private EmotionEditModel fzV;
    private String fzW;
    private EmotionImageData fzX;
    private boolean fzY;
    private String fzZ;
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
        this.ffd = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.fzV = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0126d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.drT = new com.baidu.tbadk.core.view.a(getPageContext());
        this.drT.cZ(d.k.emotion_composition);
        this.drT.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.fzV.kP(true);
                EmotionEditActivity.this.bcN();
                EmotionEditActivity.this.auL();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_layout);
        this.fzQ = (EmotionEditLayout) findViewById(d.g.edit_container);
        this.dFH = (ImageView) findViewById(d.g.close);
        this.fzR = findViewById(d.g.send);
        this.fzS = (ChooseColorLayout) findViewById(d.g.choose_color_layout);
        this.fzS.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void qQ(int i) {
                EmotionEditActivity.this.fzU.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.dFH.setOnClickListener(this);
        this.fzR.setOnClickListener(this);
        this.fzT = l.af(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds300);
        bcM();
        bcL();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzQ.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        this.fzQ.setLayoutParams(layoutParams);
        this.fzU.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.fzQ.a(this.fzU);
        this.fzS.setVisibility(8);
    }

    private void bcL() {
        this.fzU = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.fzQ.addView(this.fzU, layoutParams);
        this.fzU.setTextColor(this.fzS.getCurrentChooseColor());
        this.fzU.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.fzU.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.fzU.getEditText());
                }
            }
        });
    }

    private void bcM() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.ffd.getPicUrl();
            gifInfo.mDynamicUrl = this.ffd.getPicUrl();
            gifInfo.mStaticUrl = this.ffd.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.ffd.getPicUrl(), 10, true);
            c.fp().a(this.ffd.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.ffd.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.ffd.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.ffd.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.ffd.getWidth();
        this.mImageHeight = this.ffd.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.fzT;
            this.mImageHeight = this.fzT;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.fzT / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.fzT;
        } else {
            this.mImageWidth = (int) ((this.fzT / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.fzT;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.fzQ.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.dFH) {
            finish();
        } else if (view2 == this.fzR) {
            send();
        } else if (view2 == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.fzU.getEditText());
        }
    }

    private void send() {
        if (!j.gP()) {
            showToast(d.k.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.baD == null) {
            this.baD = new a();
        }
        this.baD.wu();
        this.baD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.baD.v(pageActivity) && !this.fzY) {
            this.fzV.kP(false);
            this.fzY = true;
            this.fAc = System.currentTimeMillis();
            this.drT.aI(true);
            HidenSoftKeyPad(this.mInputManager, this.fzU.getEditText());
            if (TextUtils.isEmpty(this.fzU.getText())) {
                this.fzX = this.ffd;
                bcQ();
                return;
            }
            String text = this.fzU.getText();
            switch (this.fAa) {
                case 2:
                    if (!TextUtils.isEmpty(this.fzZ) && this.fzZ.equals(text)) {
                        bcS();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.fzZ) && this.fzZ.equals(text) && !TextUtils.isEmpty(this.fzW)) {
                        qW(this.fzW);
                        return;
                    }
                    break;
            }
            bcN();
            this.fzZ = this.fzU.getText();
            bcO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcN() {
        if (this.fAb != null && !this.fAb.isRecycled()) {
            this.fAb.recycle();
            this.fAb = null;
        }
    }

    private void bcO() {
        this.fzV.qX(this.fzU.getText());
    }

    private void bcP() {
        if (!this.fzV.isCancel()) {
            this.fzU.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.C0126d.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.fzV.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.fzV.isCancel()) {
                        Bitmap t = t(bdImage.km());
                        if (t != null) {
                            this.fzV.b(t, f.wB + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.k.upload_error);
                        this.fAa = 2;
                        auL();
                        return;
                    }
                    return;
                }
                showToast(d.k.upload_error);
                this.fAa = 2;
                auL();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.fzW)) {
            auL();
        } else {
            this.fzV.N(this.fzW, true);
        }
    }

    private void bcQ() {
        if (!this.fzV.isCancel()) {
            this.fAa = 0;
            auL();
            if (this.fzX != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.fzX);
                setResult(-1, intent);
                finish();
                bcR();
                if (!TextUtils.isEmpty(this.fzW)) {
                    File file = new File(this.fzW);
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
        if (!TextUtils.isEmpty(this.fzU.getText())) {
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
        if (!TextUtils.isEmpty(this.fzU.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bu = bu(width, height);
            if (bu != null) {
                canvas.drawBitmap(bu, (width * this.fzU.getLeft()) / i, (height * this.fzU.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bu(int i, int i2) {
        if (this.fAb != null) {
            return this.fAb;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.fzU.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.fzU.getTextView().getDrawingCache();
        this.fAb = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.fAb = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.fAb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.fzS.setVisibility(0);
            this.fzU.bdn();
            return;
        }
        this.fzS.setVisibility(8);
        this.fzU.bdm();
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
        ak.c(this.dFH, d.f.icon_emotion_close_n);
        ak.h(this.fzR, d.C0126d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bcN();
        if (this.fzV != null) {
            this.fzV.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bcS() {
        bcP();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void qV(String str) {
        showToast(str);
        this.fAa = 1;
        auL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auL() {
        this.fzU.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        this.drT.aI(false);
        this.fzY = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void qW(String str) {
        this.fzU.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            auL();
        } else if (!new File(str).exists()) {
            auL();
        } else {
            this.fzW = str;
            this.fAa = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.fAc) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.fzX = new EmotionImageData();
                this.fzX.setPicId(uploadedPicInfo.getPic_id());
                this.fzX.setWidth(uploadedPicInfo.getWidth());
                this.fzX.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.ffd.getMemeContSign())) {
                    this.fzX.setMemeContSign(this.ffd.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.fzX.setPicUrl(picinfo.originPic.picUrl);
                    this.fzX.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.fzX.setMemeText(this.fzU.getText());
                this.fzX.setAuthorNameShow(this.ffd.getAuthorNameShow());
                bcQ();
                return;
            }
            showToast(d.k.upload_error);
            this.fAa = 3;
            auL();
            return;
        }
        showToast(d.k.upload_error);
        this.fAa = 3;
        auL();
    }
}
