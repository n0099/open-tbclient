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
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.view.b;
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
/* loaded from: classes4.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView cyi;
    private b eQD;
    private ImageView fNE;
    private EmotionImageData hHA;
    private boolean hHB;
    private String hHC;
    private int hHD = 0;
    private Bitmap hHE;
    private long hHF;
    private EmotionEditLayout hHt;
    private View hHu;
    private ChooseColorLayout hHv;
    private int hHw;
    private EmotionEditText hHx;
    private EmotionEditModel hHy;
    private String hHz;
    private EmotionImageData hnc;
    private String mFrom;
    private int mImageHeight;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private a mPermissionJudgement;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.h.emotion_edit_activity);
        this.hnc = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.hHy = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0277d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eQD = new b(getPageContext());
        this.eQD.hF(d.j.emotion_composition);
        this.eQD.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.hHy.ot(true);
                EmotionEditActivity.this.bPy();
                EmotionEditActivity.this.bin();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_layout);
        this.hHt = (EmotionEditLayout) findViewById(d.g.edit_container);
        this.fNE = (ImageView) findViewById(d.g.close);
        this.hHu = findViewById(d.g.send);
        this.hHv = (ChooseColorLayout) findViewById(d.g.choose_color_layout);
        this.hHv.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void wL(int i) {
                EmotionEditActivity.this.hHx.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.fNE.setOnClickListener(this);
        this.hHu.setOnClickListener(this);
        this.hHw = l.aO(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds300);
        bPx();
        bPw();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hHt.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        this.hHt.setLayoutParams(layoutParams);
        this.hHx.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.hHt.a(this.hHx);
        this.hHv.setVisibility(8);
    }

    private void bPw() {
        this.hHx = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.hHt.addView(this.hHx, layoutParams);
        this.hHx.setTextColor(this.hHv.getCurrentChooseColor());
        this.hHx.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.hHx.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.hHx.getEditText());
                }
            }
        });
    }

    private void bPx() {
        if (this.mIsGif) {
            this.cyi = new GifView(getPageContext().getPageActivity());
            ((GifView) this.cyi).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.hnc.getPicUrl();
            gifInfo.mDynamicUrl = this.hnc.getPicUrl();
            gifInfo.mStaticUrl = this.hnc.getThumbUrl();
            this.cyi.setTag(gifInfo.mSharpText);
            ((GifView) this.cyi).a(gifInfo);
        } else {
            this.cyi = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.cyi).setGifIconSupport(false);
            ((TbImageView) this.cyi).setAutoChangeStyle(false);
            ((TbImageView) this.cyi).startLoad(this.hnc.getPicUrl(), 10, true);
            c.jB().a(this.hnc.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.cyi);
                            EmotionEditActivity.this.cyi = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.cyi).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.hnc.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.hnc.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.hnc.getThumbUrl();
                            EmotionEditActivity.this.cyi.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.cyi).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.hnc.getWidth();
        this.mImageHeight = this.hnc.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.hHw;
            this.mImageHeight = this.hHw;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.hHw / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.hHw;
        } else {
            this.mImageWidth = (int) ((this.hHw / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.hHw;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.hHt.addView(this.cyi, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fNE) {
            finish();
        } else if (view == this.hHu) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.hHx.getEditText());
        }
    }

    private void send() {
        if (!j.kY()) {
            showToast(d.j.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new a();
        }
        this.mPermissionJudgement.adN();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.Y(pageActivity) && !this.hHB) {
            this.hHy.ot(false);
            this.hHB = true;
            this.hHF = System.currentTimeMillis();
            this.eQD.dJ(true);
            HidenSoftKeyPad(this.mInputManager, this.hHx.getEditText());
            if (TextUtils.isEmpty(this.hHx.getText())) {
                this.hHA = this.hnc;
                bPB();
                return;
            }
            String text = this.hHx.getText();
            switch (this.hHD) {
                case 2:
                    if (!TextUtils.isEmpty(this.hHC) && this.hHC.equals(text)) {
                        bPD();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.hHC) && this.hHC.equals(text) && !TextUtils.isEmpty(this.hHz)) {
                        As(this.hHz);
                        return;
                    }
                    break;
            }
            bPy();
            this.hHC = this.hHx.getText();
            bPz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPy() {
        if (this.hHE != null && !this.hHE.isRecycled()) {
            this.hHE.recycle();
            this.hHE = null;
        }
    }

    private void bPz() {
        this.hHy.At(this.hHx.getText());
    }

    private void bPA() {
        if (!this.hHy.jk()) {
            this.hHx.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.C0277d.transparent));
            if (this.mIsGif) {
                if (this.cyi instanceof GifView) {
                    ((GifView) this.cyi).pause();
                    this.hHy.a(((GifView) this.cyi).getGif());
                }
            } else if (this.cyi instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.cyi).getBdImage();
                if (bdImage != null) {
                    if (!this.hHy.jk()) {
                        Bitmap A = A(bdImage.oy());
                        if (A != null) {
                            this.hHy.b(A, f.FK + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.j.upload_error);
                        this.hHD = 2;
                        bin();
                        return;
                    }
                    return;
                }
                showToast(d.j.upload_error);
                this.hHD = 2;
                bin();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.hHz)) {
            bin();
        } else {
            this.hHy.ap(this.hHz, true);
        }
    }

    private void bPB() {
        if (!this.hHy.jk()) {
            this.hHD = 0;
            bin();
            if (this.hHA != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.hHA);
                setResult(-1, intent);
                finish();
                bPC();
                if (!TextUtils.isEmpty(this.hHz)) {
                    File file = new File(this.hHz);
                    if (file.exists()) {
                        file.delete();
                        return;
                    }
                    return;
                }
                return;
            }
            showToast(d.j.upload_error);
        }
    }

    private void bPC() {
        am amVar = new am("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                amVar.T("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                amVar.T("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.hHx.getText())) {
            amVar.T("obj_type", 1);
        } else {
            amVar.T("obj_type", 2);
        }
        TiebaStatic.log(amVar);
    }

    public Bitmap A(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.hHx.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bX = bX(width, height);
            if (bX != null) {
                canvas.drawBitmap(bX, (width * this.hHx.getLeft()) / i, (height * this.hHx.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bX(int i, int i2) {
        if (this.hHE != null) {
            return this.hHE;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.hHx.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.hHx.getTextView().getDrawingCache();
        this.hHE = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.hHE = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.hHE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.hHv.setVisibility(0);
            this.hHx.bPX();
            return;
        }
        this.hHv.setVisibility(8);
        this.hHx.bPW();
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
        al.l(this.mRootView, d.C0277d.black_alpha40);
        al.c(this.fNE, d.f.icon_emotion_close_n);
        al.j(this.hHu, d.C0277d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bPy();
        if (this.hHy != null) {
            this.hHy.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bPD() {
        bPA();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Ar(String str) {
        showToast(str);
        this.hHD = 1;
        bin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bin() {
        this.hHx.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        this.eQD.dJ(false);
        this.hHB = false;
        if (this.mIsGif) {
            ((GifView) this.cyi).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void As(String str) {
        this.hHx.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bin();
        } else if (!new File(str).exists()) {
            bin();
        } else {
            this.hHz = str;
            this.hHD = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.hHF) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.hHA = new EmotionImageData();
                this.hHA.setPicId(uploadedPicInfo.getPic_id());
                this.hHA.setWidth(uploadedPicInfo.getWidth());
                this.hHA.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.hnc.getMemeContSign())) {
                    this.hHA.setMemeContSign(this.hnc.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.hHA.setPicUrl(picinfo.originPic.picUrl);
                    this.hHA.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.hHA.setMemeText(this.hHx.getText());
                this.hHA.setAuthorNameShow(this.hnc.getAuthorNameShow());
                bPB();
                return;
            }
            showToast(d.j.upload_error);
            this.hHD = 3;
            bin();
            return;
        }
        showToast(d.j.upload_error);
        this.hHD = 3;
        bin();
    }
}
