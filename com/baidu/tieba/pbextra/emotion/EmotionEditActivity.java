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
    private ImageView dFE;
    private com.baidu.tbadk.core.view.a drQ;
    private EmotionImageData ffa;
    private EmotionEditLayout fzN;
    private View fzO;
    private ChooseColorLayout fzP;
    private int fzQ;
    private EmotionEditText fzR;
    private EmotionEditModel fzS;
    private String fzT;
    private EmotionImageData fzU;
    private boolean fzV;
    private String fzW;
    private int fzX = 0;
    private Bitmap fzY;
    private long fzZ;
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
        this.ffa = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.fzS = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0126d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.drQ = new com.baidu.tbadk.core.view.a(getPageContext());
        this.drQ.cZ(d.k.emotion_composition);
        this.drQ.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.fzS.kP(true);
                EmotionEditActivity.this.bcN();
                EmotionEditActivity.this.auL();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_layout);
        this.fzN = (EmotionEditLayout) findViewById(d.g.edit_container);
        this.dFE = (ImageView) findViewById(d.g.close);
        this.fzO = findViewById(d.g.send);
        this.fzP = (ChooseColorLayout) findViewById(d.g.choose_color_layout);
        this.fzP.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void qQ(int i) {
                EmotionEditActivity.this.fzR.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.dFE.setOnClickListener(this);
        this.fzO.setOnClickListener(this);
        this.fzQ = l.af(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds300);
        bcM();
        bcL();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzN.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        this.fzN.setLayoutParams(layoutParams);
        this.fzR.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.fzN.a(this.fzR);
        this.fzP.setVisibility(8);
    }

    private void bcL() {
        this.fzR = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.fzN.addView(this.fzR, layoutParams);
        this.fzR.setTextColor(this.fzP.getCurrentChooseColor());
        this.fzR.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.fzR.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.fzR.getEditText());
                }
            }
        });
    }

    private void bcM() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.ffa.getPicUrl();
            gifInfo.mDynamicUrl = this.ffa.getPicUrl();
            gifInfo.mStaticUrl = this.ffa.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.ffa.getPicUrl(), 10, true);
            c.fp().a(this.ffa.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.ffa.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.ffa.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.ffa.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.ffa.getWidth();
        this.mImageHeight = this.ffa.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.fzQ;
            this.mImageHeight = this.fzQ;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.fzQ / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.fzQ;
        } else {
            this.mImageWidth = (int) ((this.fzQ / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.fzQ;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.fzN.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.dFE) {
            finish();
        } else if (view2 == this.fzO) {
            send();
        } else if (view2 == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.fzR.getEditText());
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
        if (!this.baD.v(pageActivity) && !this.fzV) {
            this.fzS.kP(false);
            this.fzV = true;
            this.fzZ = System.currentTimeMillis();
            this.drQ.aI(true);
            HidenSoftKeyPad(this.mInputManager, this.fzR.getEditText());
            if (TextUtils.isEmpty(this.fzR.getText())) {
                this.fzU = this.ffa;
                bcQ();
                return;
            }
            String text = this.fzR.getText();
            switch (this.fzX) {
                case 2:
                    if (!TextUtils.isEmpty(this.fzW) && this.fzW.equals(text)) {
                        bcS();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.fzW) && this.fzW.equals(text) && !TextUtils.isEmpty(this.fzT)) {
                        qW(this.fzT);
                        return;
                    }
                    break;
            }
            bcN();
            this.fzW = this.fzR.getText();
            bcO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcN() {
        if (this.fzY != null && !this.fzY.isRecycled()) {
            this.fzY.recycle();
            this.fzY = null;
        }
    }

    private void bcO() {
        this.fzS.qX(this.fzR.getText());
    }

    private void bcP() {
        if (!this.fzS.isCancel()) {
            this.fzR.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.C0126d.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.fzS.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.fzS.isCancel()) {
                        Bitmap t = t(bdImage.km());
                        if (t != null) {
                            this.fzS.b(t, f.wB + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.k.upload_error);
                        this.fzX = 2;
                        auL();
                        return;
                    }
                    return;
                }
                showToast(d.k.upload_error);
                this.fzX = 2;
                auL();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.fzT)) {
            auL();
        } else {
            this.fzS.N(this.fzT, true);
        }
    }

    private void bcQ() {
        if (!this.fzS.isCancel()) {
            this.fzX = 0;
            auL();
            if (this.fzU != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.fzU);
                setResult(-1, intent);
                finish();
                bcR();
                if (!TextUtils.isEmpty(this.fzT)) {
                    File file = new File(this.fzT);
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
        if (!TextUtils.isEmpty(this.fzR.getText())) {
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
        if (!TextUtils.isEmpty(this.fzR.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bt = bt(width, height);
            if (bt != null) {
                canvas.drawBitmap(bt, (width * this.fzR.getLeft()) / i, (height * this.fzR.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bt(int i, int i2) {
        if (this.fzY != null) {
            return this.fzY;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.fzR.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.fzR.getTextView().getDrawingCache();
        this.fzY = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.fzY = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.fzY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.fzP.setVisibility(0);
            this.fzR.bdn();
            return;
        }
        this.fzP.setVisibility(8);
        this.fzR.bdm();
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
        ak.c(this.dFE, d.f.icon_emotion_close_n);
        ak.h(this.fzO, d.C0126d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bcN();
        if (this.fzS != null) {
            this.fzS.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bcS() {
        bcP();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void qV(String str) {
        showToast(str);
        this.fzX = 1;
        auL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auL() {
        this.fzR.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        this.drQ.aI(false);
        this.fzV = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void qW(String str) {
        this.fzR.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            auL();
        } else if (!new File(str).exists()) {
            auL();
        } else {
            this.fzT = str;
            this.fzX = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.fzZ) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.fzU = new EmotionImageData();
                this.fzU.setPicId(uploadedPicInfo.getPic_id());
                this.fzU.setWidth(uploadedPicInfo.getWidth());
                this.fzU.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.ffa.getMemeContSign())) {
                    this.fzU.setMemeContSign(this.ffa.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.fzU.setPicUrl(picinfo.originPic.picUrl);
                    this.fzU.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.fzU.setMemeText(this.fzR.getText());
                this.fzU.setAuthorNameShow(this.ffa.getAuthorNameShow());
                bcQ();
                return;
            }
            showToast(d.k.upload_error);
            this.fzX = 3;
            auL();
            return;
        }
        showToast(d.k.upload_error);
        this.fzX = 3;
        auL();
    }
}
