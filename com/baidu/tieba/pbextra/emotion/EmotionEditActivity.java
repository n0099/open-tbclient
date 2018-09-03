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
import com.baidu.tieba.f;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pbextra.emotion.model.EmotionEditModel;
import com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout;
import com.baidu.tieba.pbextra.emotion.view.EmotionEditLayout;
import com.baidu.tieba.pbextra.emotion.view.EmotionEditText;
import java.io.File;
/* loaded from: classes3.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView baU;
    private a bkZ;
    private ImageView dZJ;
    private com.baidu.tbadk.core.view.a deF;
    private String fQA;
    private EmotionImageData fQB;
    private boolean fQC;
    private String fQD;
    private int fQE = 0;
    private Bitmap fQF;
    private long fQG;
    private EmotionEditLayout fQu;
    private View fQv;
    private ChooseColorLayout fQw;
    private int fQx;
    private EmotionEditText fQy;
    private EmotionEditModel fQz;
    private EmotionImageData fvD;
    private String mFrom;
    private int mImageHeight;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(f.h.emotion_edit_activity);
        this.fvD = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.fQz = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(f.d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.deF = new com.baidu.tbadk.core.view.a(getPageContext());
        this.deF.df(f.j.emotion_composition);
        this.deF.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.fQz.kS(true);
                EmotionEditActivity.this.bgH();
                EmotionEditActivity.this.aAe();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(f.g.root_layout);
        this.fQu = (EmotionEditLayout) findViewById(f.g.edit_container);
        this.dZJ = (ImageView) findViewById(f.g.close);
        this.fQv = findViewById(f.g.send);
        this.fQw = (ChooseColorLayout) findViewById(f.g.choose_color_layout);
        this.fQw.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void rh(int i) {
                EmotionEditActivity.this.fQy.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.dZJ.setOnClickListener(this);
        this.fQv.setOnClickListener(this);
        this.fQx = l.ah(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(f.e.ds300);
        bgG();
        bgF();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fQu.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(f.e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(f.e.ds80);
        this.fQu.setLayoutParams(layoutParams);
        this.fQy.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(f.e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(f.e.ds40));
        this.fQu.a(this.fQy);
        this.fQw.setVisibility(8);
    }

    private void bgF() {
        this.fQy = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(f.e.ds40));
        this.fQu.addView(this.fQy, layoutParams);
        this.fQy.setTextColor(this.fQw.getCurrentChooseColor());
        this.fQy.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.fQy.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.fQy.getEditText());
                }
            }
        });
    }

    private void bgG() {
        if (this.mIsGif) {
            this.baU = new GifView(getPageContext().getPageActivity());
            ((GifView) this.baU).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.fvD.getPicUrl();
            gifInfo.mDynamicUrl = this.fvD.getPicUrl();
            gifInfo.mStaticUrl = this.fvD.getThumbUrl();
            this.baU.setTag(gifInfo.mSharpText);
            ((GifView) this.baU).a(gifInfo);
        } else {
            this.baU = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.baU).setGifIconSupport(false);
            ((TbImageView) this.baU).setAutoChangeStyle(false);
            ((TbImageView) this.baU).startLoad(this.fvD.getPicUrl(), 10, true);
            c.ih().a(this.fvD.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.baU);
                            EmotionEditActivity.this.baU = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.baU).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.fvD.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.fvD.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.fvD.getThumbUrl();
                            EmotionEditActivity.this.baU.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.baU).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.fvD.getWidth();
        this.mImageHeight = this.fvD.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.fQx;
            this.mImageHeight = this.fQx;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.fQx / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.fQx;
        } else {
            this.mImageWidth = (int) ((this.fQx / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.fQx;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.fQu.addView(this.baU, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dZJ) {
            finish();
        } else if (view == this.fQv) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.fQy.getEditText());
        }
    }

    private void send() {
        if (!j.jE()) {
            showToast(f.j.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bkZ == null) {
            this.bkZ = new a();
        }
        this.bkZ.zW();
        this.bkZ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bkZ.u(pageActivity) && !this.fQC) {
            this.fQz.kS(false);
            this.fQC = true;
            this.fQG = System.currentTimeMillis();
            this.deF.aN(true);
            HidenSoftKeyPad(this.mInputManager, this.fQy.getEditText());
            if (TextUtils.isEmpty(this.fQy.getText())) {
                this.fQB = this.fvD;
                bgK();
                return;
            }
            String text = this.fQy.getText();
            switch (this.fQE) {
                case 2:
                    if (!TextUtils.isEmpty(this.fQD) && this.fQD.equals(text)) {
                        bgM();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.fQD) && this.fQD.equals(text) && !TextUtils.isEmpty(this.fQA)) {
                        rL(this.fQA);
                        return;
                    }
                    break;
            }
            bgH();
            this.fQD = this.fQy.getText();
            bgI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgH() {
        if (this.fQF != null && !this.fQF.isRecycled()) {
            this.fQF.recycle();
            this.fQF = null;
        }
    }

    private void bgI() {
        this.fQz.rM(this.fQy.getText());
    }

    private void bgJ() {
        if (!this.fQz.hP()) {
            this.fQy.getTextView().setBackgroundColor(getPageContext().getResources().getColor(f.d.transparent));
            if (this.mIsGif) {
                if (this.baU instanceof GifView) {
                    ((GifView) this.baU).pause();
                    this.fQz.a(((GifView) this.baU).getGif());
                }
            } else if (this.baU instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.baU).getBdImage();
                if (bdImage != null) {
                    if (!this.fQz.hP()) {
                        Bitmap r = r(bdImage.nb());
                        if (r != null) {
                            this.fQz.b(r, com.baidu.adp.lib.util.f.CD + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(f.j.upload_error);
                        this.fQE = 2;
                        aAe();
                        return;
                    }
                    return;
                }
                showToast(f.j.upload_error);
                this.fQE = 2;
                aAe();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.fQA)) {
            aAe();
        } else {
            this.fQz.N(this.fQA, true);
        }
    }

    private void bgK() {
        if (!this.fQz.hP()) {
            this.fQE = 0;
            aAe();
            if (this.fQB != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.fQB);
                setResult(-1, intent);
                finish();
                bgL();
                if (!TextUtils.isEmpty(this.fQA)) {
                    File file = new File(this.fQA);
                    if (file.exists()) {
                        file.delete();
                        return;
                    }
                    return;
                }
                return;
            }
            showToast(f.j.upload_error);
        }
    }

    private void bgL() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.r("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.r("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.fQy.getText())) {
            anVar.r("obj_type", 1);
        } else {
            anVar.r("obj_type", 2);
        }
        TiebaStatic.log(anVar);
    }

    public Bitmap r(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.fQy.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bv = bv(width, height);
            if (bv != null) {
                canvas.drawBitmap(bv, (width * this.fQy.getLeft()) / i, (height * this.fQy.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bv(int i, int i2) {
        if (this.fQF != null) {
            return this.fQF;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.fQy.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.fQy.getTextView().getDrawingCache();
        this.fQF = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.fQF = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.fQF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.fQw.setVisibility(0);
            this.fQy.bhh();
            return;
        }
        this.fQw.setVisibility(8);
        this.fQy.bhg();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(f.a.fade_in, f.a.fade_out);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(f.a.fade_in, f.a.fade_out);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.j(this.mRootView, f.d.black_alpha40);
        am.c(this.dZJ, f.C0146f.icon_emotion_close_n);
        am.h(this.fQv, f.d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bgH();
        if (this.fQz != null) {
            this.fQz.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bgM() {
        bgJ();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void rK(String str) {
        showToast(str);
        this.fQE = 1;
        aAe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAe() {
        this.fQy.getTextView().setBackgroundResource(f.C0146f.bg_emotion_edit);
        this.deF.aN(false);
        this.fQC = false;
        if (this.mIsGif) {
            ((GifView) this.baU).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void rL(String str) {
        this.fQy.getTextView().setBackgroundResource(f.C0146f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            aAe();
        } else if (!new File(str).exists()) {
            aAe();
        } else {
            this.fQA = str;
            this.fQE = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.fQG) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.fQB = new EmotionImageData();
                this.fQB.setPicId(uploadedPicInfo.getPic_id());
                this.fQB.setWidth(uploadedPicInfo.getWidth());
                this.fQB.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.fvD.getMemeContSign())) {
                    this.fQB.setMemeContSign(this.fvD.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.fQB.setPicUrl(picinfo.originPic.picUrl);
                    this.fQB.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.fQB.setMemeText(this.fQy.getText());
                this.fQB.setAuthorNameShow(this.fvD.getAuthorNameShow());
                bgK();
                return;
            }
            showToast(f.j.upload_error);
            this.fQE = 3;
            aAe();
            return;
        }
        showToast(f.j.upload_error);
        this.fQE = 3;
        aAe();
    }
}
