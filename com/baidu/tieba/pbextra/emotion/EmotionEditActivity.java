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
    private ImageView cGr;
    private b fgM;
    private ImageView geO;
    private EmotionImageData hEG;
    private EmotionEditModel hZA;
    private String hZB;
    private EmotionImageData hZC;
    private boolean hZD;
    private String hZE;
    private int hZF = 0;
    private Bitmap hZG;
    private long hZH;
    private EmotionEditLayout hZv;
    private View hZw;
    private ChooseColorLayout hZx;
    private int hZy;
    private EmotionEditText hZz;
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
        this.hEG = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.hZA = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.fgM = new b(getPageContext());
        this.fgM.it(R.string.emotion_composition);
        this.fgM.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.hZA.pi(true);
                EmotionEditActivity.this.bXu();
                EmotionEditActivity.this.bpG();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.hZv = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.geO = (ImageView) findViewById(R.id.close);
        this.hZw = findViewById(R.id.send);
        this.hZx = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.hZx.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void xR(int i) {
                EmotionEditActivity.this.hZz.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.geO.setOnClickListener(this);
        this.hZw.setOnClickListener(this);
        this.hZy = l.af(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        bXt();
        bXs();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZv.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.hZv.setLayoutParams(layoutParams);
        this.hZz.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.hZv.a(this.hZz);
        this.hZx.setVisibility(8);
    }

    private void bXs() {
        this.hZz = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.hZv.addView(this.hZz, layoutParams);
        this.hZz.setTextColor(this.hZx.getCurrentChooseColor());
        this.hZz.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.hZz.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.hZz.getEditText());
                }
            }
        });
    }

    private void bXt() {
        if (this.mIsGif) {
            this.cGr = new GifView(getPageContext().getPageActivity());
            ((GifView) this.cGr).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.hEG.getPicUrl();
            gifInfo.mDynamicUrl = this.hEG.getPicUrl();
            gifInfo.mStaticUrl = this.hEG.getThumbUrl();
            this.cGr.setTag(gifInfo.mSharpText);
            ((GifView) this.cGr).a(gifInfo);
        } else {
            this.cGr = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.cGr).setGifIconSupport(false);
            ((TbImageView) this.cGr).setAutoChangeStyle(false);
            ((TbImageView) this.cGr).startLoad(this.hEG.getPicUrl(), 10, true);
            c.iv().a(this.hEG.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.cGr);
                            EmotionEditActivity.this.cGr = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.cGr).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.hEG.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.hEG.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.hEG.getThumbUrl();
                            EmotionEditActivity.this.cGr.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.cGr).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.hEG.getWidth();
        this.mImageHeight = this.hEG.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.hZy;
            this.mImageHeight = this.hZy;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.hZy / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.hZy;
        } else {
            this.mImageWidth = (int) ((this.hZy / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.hZy;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.hZv.addView(this.cGr, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.geO) {
            finish();
        } else if (view == this.hZw) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.hZz.getEditText());
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
        if (!this.mPermissionJudgement.aa(pageActivity) && !this.hZD) {
            this.hZA.pi(false);
            this.hZD = true;
            this.hZH = System.currentTimeMillis();
            this.fgM.ef(true);
            HidenSoftKeyPad(this.mInputManager, this.hZz.getEditText());
            if (TextUtils.isEmpty(this.hZz.getText())) {
                this.hZC = this.hEG;
                bXx();
                return;
            }
            String text = this.hZz.getText();
            switch (this.hZF) {
                case 2:
                    if (!TextUtils.isEmpty(this.hZE) && this.hZE.equals(text)) {
                        bXz();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.hZE) && this.hZE.equals(text) && !TextUtils.isEmpty(this.hZB)) {
                        BI(this.hZB);
                        return;
                    }
                    break;
            }
            bXu();
            this.hZE = this.hZz.getText();
            bXv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXu() {
        if (this.hZG != null && !this.hZG.isRecycled()) {
            this.hZG.recycle();
            this.hZG = null;
        }
    }

    private void bXv() {
        this.hZA.BJ(this.hZz.getText());
    }

    private void bXw() {
        if (!this.hZA.ic()) {
            this.hZz.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.cGr instanceof GifView) {
                    ((GifView) this.cGr).pause();
                    this.hZA.a(((GifView) this.cGr).getGif());
                }
            } else if (this.cGr instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.cGr).getBdImage();
                if (bdImage != null) {
                    if (!this.hZA.ic()) {
                        Bitmap B = B(bdImage.ns());
                        if (B != null) {
                            this.hZA.b(B, f.Du + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.hZF = 2;
                        bpG();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.hZF = 2;
                bpG();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.hZB)) {
            bpG();
        } else {
            this.hZA.ar(this.hZB, true);
        }
    }

    private void bXx() {
        if (!this.hZA.ic()) {
            this.hZF = 0;
            bpG();
            if (this.hZC != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.hZC);
                setResult(-1, intent);
                finish();
                bXy();
                if (!TextUtils.isEmpty(this.hZB)) {
                    File file = new File(this.hZB);
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

    private void bXy() {
        am amVar = new am("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                amVar.P("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                amVar.P("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.hZz.getText())) {
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
        if (!TextUtils.isEmpty(this.hZz.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap ce = ce(width, height);
            if (ce != null) {
                canvas.drawBitmap(ce, (width * this.hZz.getLeft()) / i, (height * this.hZz.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap ce(int i, int i2) {
        if (this.hZG != null) {
            return this.hZG;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.hZz.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.hZz.getTextView().getDrawingCache();
        this.hZG = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.hZG = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.hZG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.hZx.setVisibility(0);
            this.hZz.bXT();
            return;
        }
        this.hZx.setVisibility(8);
        this.hZz.bXS();
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
        al.c(this.geO, (int) R.drawable.icon_emotion_close_n);
        al.j(this.hZw, R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bXu();
        if (this.hZA != null) {
            this.hZA.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bXz() {
        bXw();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void BH(String str) {
        showToast(str);
        this.hZF = 1;
        bpG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpG() {
        this.hZz.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.fgM.ef(false);
        this.hZD = false;
        if (this.mIsGif) {
            ((GifView) this.cGr).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void BI(String str) {
        this.hZz.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bpG();
        } else if (!new File(str).exists()) {
            bpG();
        } else {
            this.hZB = str;
            this.hZF = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.hZH) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.hZC = new EmotionImageData();
                this.hZC.setPicId(uploadedPicInfo.getPic_id());
                this.hZC.setWidth(uploadedPicInfo.getWidth());
                this.hZC.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.hEG.getMemeContSign())) {
                    this.hZC.setMemeContSign(this.hEG.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.hZC.setPicUrl(picinfo.originPic.picUrl);
                    this.hZC.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.hZC.setMemeText(this.hZz.getText());
                this.hZC.setAuthorNameShow(this.hEG.getAuthorNameShow());
                bXx();
                return;
            }
            showToast(R.string.upload_error);
            this.hZF = 3;
            bpG();
            return;
        }
        showToast(R.string.upload_error);
        this.hZF = 3;
        bpG();
    }
}
