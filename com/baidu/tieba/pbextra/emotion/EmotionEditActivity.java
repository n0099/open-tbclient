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
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.e.c;
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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.a;
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
/* loaded from: classes9.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView gdN;
    private a hOE;
    private EmotionImageData jKP;
    private EmotionEditLayout kgY;
    private View kgZ;
    private ChooseColorLayout kha;
    private int khb;
    private EmotionEditText khc;
    private EmotionEditModel khd;
    private String khe;
    private EmotionImageData khf;
    private boolean khg;
    private String khh;
    private int khi = 0;
    private Bitmap khj;
    private long khk;
    private String mFrom;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.emotion_edit_activity);
        this.jKP = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.khd = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.hOE = new a(getPageContext());
        this.hOE.setTipString(R.string.emotion_composition);
        this.hOE.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.khd.setCancel(true);
                EmotionEditActivity.this.cMj();
                EmotionEditActivity.this.caU();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.kgY = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.gdN = (ImageView) findViewById(R.id.close);
        this.kgZ = findViewById(R.id.send);
        this.kha = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.kha.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void AX(int i) {
                EmotionEditActivity.this.khc.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.gdN.setOnClickListener(this);
        this.kgZ.setOnClickListener(this);
        this.khb = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        cMi();
        cMh();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kgY.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kgY.setLayoutParams(layoutParams);
        this.khc.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.kgY.a(this.khc);
        this.kha.setVisibility(8);
    }

    private void cMh() {
        this.khc = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.kgY.addView(this.khc, layoutParams);
        this.khc.setTextColor(this.kha.getCurrentChooseColor());
        this.khc.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.khc.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.khc.getEditText());
                }
            }
        });
    }

    private void cMi() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.jKP.getPicUrl();
            gifInfo.mDynamicUrl = this.jKP.getPicUrl();
            gifInfo.mStaticUrl = this.jKP.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.jKP.getPicUrl(), 10, true);
            c.kX().a(this.jKP.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.drawImageTo(EmotionEditActivity.this.mImageView);
                            EmotionEditActivity.this.mImageView = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.mImageView).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.jKP.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.jKP.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.jKP.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.jKP.getWidth();
        this.mImageHeight = this.jKP.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.khb;
            this.mImageHeight = this.khb;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.khb / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.khb;
        } else {
            this.mImageWidth = (int) ((this.khb / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.khb;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.kgY.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gdN) {
            finish();
        } else if (view == this.kgZ) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.khc.getEditText());
        }
    }

    private void send() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.khg) {
            this.khd.setCancel(false);
            this.khg = true;
            this.khk = System.currentTimeMillis();
            this.hOE.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.khc.getEditText());
            if (TextUtils.isEmpty(this.khc.getText())) {
                this.khf = this.jKP;
                cMn();
                return;
            }
            String text = this.khc.getText();
            switch (this.khi) {
                case 2:
                    if (!TextUtils.isEmpty(this.khh) && this.khh.equals(text)) {
                        cMp();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.khh) && this.khh.equals(text) && !TextUtils.isEmpty(this.khe)) {
                        JW(this.khe);
                        return;
                    }
                    break;
            }
            cMj();
            this.khh = this.khc.getText();
            cMk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMj() {
        if (this.khj != null && !this.khj.isRecycled()) {
            this.khj.recycle();
            this.khj = null;
        }
    }

    private void cMk() {
        this.khd.JX(this.khc.getText());
    }

    private void cMl() {
        if (!this.khd.isCancel()) {
            this.khc.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.khd.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.khd.isCancel()) {
                        Bitmap D = D(bdImage.getRawBitmap());
                        if (D != null) {
                            this.khd.b(D, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.khi = 2;
                        caU();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.khi = 2;
                caU();
            }
        }
    }

    private void cMm() {
        if (TextUtils.isEmpty(this.khe)) {
            caU();
        } else {
            this.khd.aO(this.khe, true);
        }
    }

    private void cMn() {
        if (!this.khd.isCancel()) {
            this.khi = 0;
            caU();
            if (this.khf != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.khf);
                setResult(-1, intent);
                finish();
                cMo();
                if (!TextUtils.isEmpty(this.khe)) {
                    File file = new File(this.khe);
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

    private void cMo() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.ag("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.ag("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.khc.getText())) {
            anVar.ag("obj_type", 1);
        } else {
            anVar.ag("obj_type", 2);
        }
        TiebaStatic.log(anVar);
    }

    public Bitmap D(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.khc.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cH = cH(width, height);
            if (cH != null) {
                canvas.drawBitmap(cH, (width * this.khc.getLeft()) / i, (height * this.khc.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cH(int i, int i2) {
        if (this.khj != null) {
            return this.khj;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.khc.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.khc.getTextView().getDrawingCache();
        this.khj = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.khj = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.khj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.kha.setVisibility(0);
            this.khc.cMK();
            return;
        }
        this.kha.setVisibility(8);
        this.khc.cMJ();
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
        am.setBackgroundColor(this.mRootView, R.color.black_alpha40);
        am.setImageResource(this.gdN, R.drawable.icon_emotion_close_n);
        am.setViewTextColor(this.kgZ, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cMj();
        if (this.khd != null) {
            this.khd.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void cMp() {
        cMl();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void JV(String str) {
        showToast(str);
        this.khi = 1;
        caU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caU() {
        this.khc.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.hOE.setDialogVisiable(false);
        this.khg = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void JW(String str) {
        this.khc.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            caU();
        } else if (!new File(str).exists()) {
            caU();
        } else {
            this.khe = str;
            this.khi = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.khk) + "ms");
            cMm();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.khf = new EmotionImageData();
                this.khf.setPicId(uploadedPicInfo.getPic_id());
                this.khf.setWidth(uploadedPicInfo.getWidth());
                this.khf.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.jKP.getMemeContSign())) {
                    this.khf.setMemeContSign(this.jKP.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.khf.setPicUrl(picinfo.originPic.picUrl);
                    this.khf.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.khf.setMemeText(this.khc.getText());
                this.khf.setAuthorNameShow(this.jKP.getAuthorNameShow());
                cMn();
                return;
            }
            showToast(R.string.upload_error);
            this.khi = 3;
            caU();
            return;
        }
        showToast(R.string.upload_error);
        this.khi = 3;
        caU();
    }
}
