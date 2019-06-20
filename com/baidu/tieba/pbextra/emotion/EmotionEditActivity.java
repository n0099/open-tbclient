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
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pbextra.emotion.model.EmotionEditModel;
import com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout;
import com.baidu.tieba.pbextra.emotion.view.EmotionEditLayout;
import com.baidu.tieba.pbextra.emotion.view.EmotionEditText;
import java.io.File;
/* loaded from: classes4.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView cGs;
    private b fgM;
    private ImageView geQ;
    private EmotionImageData hEH;
    private EmotionEditText hZA;
    private EmotionEditModel hZB;
    private String hZC;
    private EmotionImageData hZD;
    private boolean hZE;
    private String hZF;
    private int hZG = 0;
    private Bitmap hZH;
    private long hZI;
    private EmotionEditLayout hZw;
    private View hZx;
    private ChooseColorLayout hZy;
    private int hZz;
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
        setContentView(R.layout.emotion_edit_activity);
        this.hEH = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.hZB = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.fgM = new b(getPageContext());
        this.fgM.it(R.string.emotion_composition);
        this.fgM.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.hZB.pj(true);
                EmotionEditActivity.this.bXv();
                EmotionEditActivity.this.bpI();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.hZw = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.geQ = (ImageView) findViewById(R.id.close);
        this.hZx = findViewById(R.id.send);
        this.hZy = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.hZy.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void xR(int i) {
                EmotionEditActivity.this.hZA.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.geQ.setOnClickListener(this);
        this.hZx.setOnClickListener(this);
        this.hZz = l.af(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        bXu();
        bXt();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZw.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.hZw.setLayoutParams(layoutParams);
        this.hZA.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.hZw.a(this.hZA);
        this.hZy.setVisibility(8);
    }

    private void bXt() {
        this.hZA = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.hZw.addView(this.hZA, layoutParams);
        this.hZA.setTextColor(this.hZy.getCurrentChooseColor());
        this.hZA.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.hZA.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.hZA.getEditText());
                }
            }
        });
    }

    private void bXu() {
        if (this.mIsGif) {
            this.cGs = new GifView(getPageContext().getPageActivity());
            ((GifView) this.cGs).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.hEH.getPicUrl();
            gifInfo.mDynamicUrl = this.hEH.getPicUrl();
            gifInfo.mStaticUrl = this.hEH.getThumbUrl();
            this.cGs.setTag(gifInfo.mSharpText);
            ((GifView) this.cGs).a(gifInfo);
        } else {
            this.cGs = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.cGs).setGifIconSupport(false);
            ((TbImageView) this.cGs).setAutoChangeStyle(false);
            ((TbImageView) this.cGs).startLoad(this.hEH.getPicUrl(), 10, true);
            c.iv().a(this.hEH.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.cGs);
                            EmotionEditActivity.this.cGs = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.cGs).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.hEH.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.hEH.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.hEH.getThumbUrl();
                            EmotionEditActivity.this.cGs.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.cGs).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.hEH.getWidth();
        this.mImageHeight = this.hEH.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.hZz;
            this.mImageHeight = this.hZz;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.hZz / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.hZz;
        } else {
            this.mImageWidth = (int) ((this.hZz / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.hZz;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.hZw.addView(this.cGs, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.geQ) {
            finish();
        } else if (view == this.hZx) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.hZA.getEditText());
        }
    }

    private void send() {
        if (!j.jS()) {
            showToast(R.string.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new a();
        }
        this.mPermissionJudgement.aiM();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.aa(pageActivity) && !this.hZE) {
            this.hZB.pj(false);
            this.hZE = true;
            this.hZI = System.currentTimeMillis();
            this.fgM.ef(true);
            HidenSoftKeyPad(this.mInputManager, this.hZA.getEditText());
            if (TextUtils.isEmpty(this.hZA.getText())) {
                this.hZD = this.hEH;
                bXy();
                return;
            }
            String text = this.hZA.getText();
            switch (this.hZG) {
                case 2:
                    if (!TextUtils.isEmpty(this.hZF) && this.hZF.equals(text)) {
                        bXA();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.hZF) && this.hZF.equals(text) && !TextUtils.isEmpty(this.hZC)) {
                        BK(this.hZC);
                        return;
                    }
                    break;
            }
            bXv();
            this.hZF = this.hZA.getText();
            bXw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXv() {
        if (this.hZH != null && !this.hZH.isRecycled()) {
            this.hZH.recycle();
            this.hZH = null;
        }
    }

    private void bXw() {
        this.hZB.BL(this.hZA.getText());
    }

    private void bXx() {
        if (!this.hZB.ic()) {
            this.hZA.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.cGs instanceof GifView) {
                    ((GifView) this.cGs).pause();
                    this.hZB.a(((GifView) this.cGs).getGif());
                }
            } else if (this.cGs instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.cGs).getBdImage();
                if (bdImage != null) {
                    if (!this.hZB.ic()) {
                        Bitmap B = B(bdImage.ns());
                        if (B != null) {
                            this.hZB.b(B, f.Dt + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.hZG = 2;
                        bpI();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.hZG = 2;
                bpI();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.hZC)) {
            bpI();
        } else {
            this.hZB.ar(this.hZC, true);
        }
    }

    private void bXy() {
        if (!this.hZB.ic()) {
            this.hZG = 0;
            bpI();
            if (this.hZD != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.hZD);
                setResult(-1, intent);
                finish();
                bXz();
                if (!TextUtils.isEmpty(this.hZC)) {
                    File file = new File(this.hZC);
                    if (file.exists()) {
                        file.delete();
                        return;
                    }
                    return;
                }
                return;
            }
            showToast(R.string.upload_error);
        }
    }

    private void bXz() {
        am amVar = new am("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                amVar.P("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                amVar.P("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.hZA.getText())) {
            amVar.P("obj_type", 1);
        } else {
            amVar.P("obj_type", 2);
        }
        TiebaStatic.log(amVar);
    }

    public Bitmap B(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.hZA.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap ce = ce(width, height);
            if (ce != null) {
                canvas.drawBitmap(ce, (width * this.hZA.getLeft()) / i, (height * this.hZA.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap ce(int i, int i2) {
        if (this.hZH != null) {
            return this.hZH;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.hZA.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.hZA.getTextView().getDrawingCache();
        this.hZH = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.hZH = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.hZH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.hZy.setVisibility(0);
            this.hZA.bXU();
            return;
        }
        this.hZy.setVisibility(8);
        this.hZA.bXT();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.l(this.mRootView, R.color.black_alpha40);
        al.c(this.geQ, (int) R.drawable.icon_emotion_close_n);
        al.j(this.hZx, R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bXv();
        if (this.hZB != null) {
            this.hZB.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bXA() {
        bXx();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void BJ(String str) {
        showToast(str);
        this.hZG = 1;
        bpI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpI() {
        this.hZA.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.fgM.ef(false);
        this.hZE = false;
        if (this.mIsGif) {
            ((GifView) this.cGs).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void BK(String str) {
        this.hZA.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bpI();
        } else if (!new File(str).exists()) {
            bpI();
        } else {
            this.hZC = str;
            this.hZG = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.hZI) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.hZD = new EmotionImageData();
                this.hZD.setPicId(uploadedPicInfo.getPic_id());
                this.hZD.setWidth(uploadedPicInfo.getWidth());
                this.hZD.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.hEH.getMemeContSign())) {
                    this.hZD.setMemeContSign(this.hEH.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.hZD.setPicUrl(picinfo.originPic.picUrl);
                    this.hZD.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.hZD.setMemeText(this.hZA.getText());
                this.hZD.setAuthorNameShow(this.hEH.getAuthorNameShow());
                bXy();
                return;
            }
            showToast(R.string.upload_error);
            this.hZG = 3;
            bpI();
            return;
        }
        showToast(R.string.upload_error);
        this.hZG = 3;
        bpI();
    }
}
