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
/* loaded from: classes6.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView fdH;
    private a gJf;
    private EmotionImageData iCJ;
    private EmotionEditLayout iYG;
    private View iYH;
    private ChooseColorLayout iYI;
    private int iYJ;
    private EmotionEditText iYK;
    private EmotionEditModel iYL;
    private String iYM;
    private EmotionImageData iYN;
    private boolean iYO;
    private String iYP;
    private int iYQ = 0;
    private Bitmap iYR;
    private long iYS;
    private String mFrom;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.emotion_edit_activity);
        this.iCJ = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.iYL = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.gJf = new a(getPageContext());
        this.gJf.setTipString(R.string.emotion_composition);
        this.gJf.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.iYL.setCancel(true);
                EmotionEditActivity.this.crI();
                EmotionEditActivity.this.bHh();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.iYG = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.fdH = (ImageView) findViewById(R.id.close);
        this.iYH = findViewById(R.id.send);
        this.iYI = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.iYI.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void zr(int i) {
                EmotionEditActivity.this.iYK.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.fdH.setOnClickListener(this);
        this.iYH.setOnClickListener(this);
        this.iYJ = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        initImageView();
        crH();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iYG.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.iYG.setLayoutParams(layoutParams);
        this.iYK.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.iYG.a(this.iYK);
        this.iYI.setVisibility(8);
    }

    private void crH() {
        this.iYK = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.iYG.addView(this.iYK, layoutParams);
        this.iYK.setTextColor(this.iYI.getCurrentChooseColor());
        this.iYK.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.iYK.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.iYK.getEditText());
                }
            }
        });
    }

    private void initImageView() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.iCJ.getPicUrl();
            gifInfo.mDynamicUrl = this.iCJ.getPicUrl();
            gifInfo.mStaticUrl = this.iCJ.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.iCJ.getPicUrl(), 10, true);
            c.gs().a(this.iCJ.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.iCJ.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.iCJ.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.iCJ.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.iCJ.getWidth();
        this.mImageHeight = this.iCJ.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.iYJ;
            this.mImageHeight = this.iYJ;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.iYJ / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.iYJ;
        } else {
            this.mImageWidth = (int) ((this.iYJ / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.iYJ;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.iYG.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fdH) {
            finish();
        } else if (view == this.iYH) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.iYK.getEditText());
        }
    }

    private void send() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.iYO) {
            this.iYL.setCancel(false);
            this.iYO = true;
            this.iYS = System.currentTimeMillis();
            this.gJf.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.iYK.getEditText());
            if (TextUtils.isEmpty(this.iYK.getText())) {
                this.iYN = this.iCJ;
                crL();
                return;
            }
            String text = this.iYK.getText();
            switch (this.iYQ) {
                case 2:
                    if (!TextUtils.isEmpty(this.iYP) && this.iYP.equals(text)) {
                        crN();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.iYP) && this.iYP.equals(text) && !TextUtils.isEmpty(this.iYM)) {
                        Ga(this.iYM);
                        return;
                    }
                    break;
            }
            crI();
            this.iYP = this.iYK.getText();
            crJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crI() {
        if (this.iYR != null && !this.iYR.isRecycled()) {
            this.iYR.recycle();
            this.iYR = null;
        }
    }

    private void crJ() {
        this.iYL.Gc(this.iYK.getText());
    }

    private void crK() {
        if (!this.iYL.isCancel()) {
            this.iYK.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.iYL.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.iYL.isCancel()) {
                        Bitmap z = z(bdImage.getRawBitmap());
                        if (z != null) {
                            this.iYL.b(z, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.iYQ = 2;
                        bHh();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.iYQ = 2;
                bHh();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.iYM)) {
            bHh();
        } else {
            this.iYL.av(this.iYM, true);
        }
    }

    private void crL() {
        if (!this.iYL.isCancel()) {
            this.iYQ = 0;
            bHh();
            if (this.iYN != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.iYN);
                setResult(-1, intent);
                finish();
                crM();
                if (!TextUtils.isEmpty(this.iYM)) {
                    File file = new File(this.iYM);
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

    private void crM() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.Z("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.Z("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.iYK.getText())) {
            anVar.Z("obj_type", 1);
        } else {
            anVar.Z("obj_type", 2);
        }
        TiebaStatic.log(anVar);
    }

    public Bitmap z(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.iYK.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cv = cv(width, height);
            if (cv != null) {
                canvas.drawBitmap(cv, (width * this.iYK.getLeft()) / i, (height * this.iYK.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cv(int i, int i2) {
        if (this.iYR != null) {
            return this.iYR;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.iYK.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.iYK.getTextView().getDrawingCache();
        this.iYR = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.iYR = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.iYR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.iYI.setVisibility(0);
            this.iYK.csi();
            return;
        }
        this.iYI.setVisibility(8);
        this.iYK.csh();
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
        am.setImageResource(this.fdH, R.drawable.icon_emotion_close_n);
        am.setViewTextColor(this.iYH, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        crI();
        if (this.iYL != null) {
            this.iYL.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void crN() {
        crK();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void FZ(String str) {
        showToast(str);
        this.iYQ = 1;
        bHh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHh() {
        this.iYK.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.gJf.setDialogVisiable(false);
        this.iYO = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Ga(String str) {
        this.iYK.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bHh();
        } else if (!new File(str).exists()) {
            bHh();
        } else {
            this.iYM = str;
            this.iYQ = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.iYS) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.iYN = new EmotionImageData();
                this.iYN.setPicId(uploadedPicInfo.getPic_id());
                this.iYN.setWidth(uploadedPicInfo.getWidth());
                this.iYN.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.iCJ.getMemeContSign())) {
                    this.iYN.setMemeContSign(this.iCJ.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.iYN.setPicUrl(picinfo.originPic.picUrl);
                    this.iYN.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.iYN.setMemeText(this.iYK.getText());
                this.iYN.setAuthorNameShow(this.iCJ.getAuthorNameShow());
                crL();
                return;
            }
            showToast(R.string.upload_error);
            this.iYQ = 3;
            bHh();
            return;
        }
        showToast(R.string.upload_error);
        this.iYQ = 3;
        bHh();
    }
}
