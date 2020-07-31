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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes16.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView gwo;
    private a iiF;
    private EmotionEditLayout kKT;
    private View kKU;
    private ChooseColorLayout kKV;
    private int kKW;
    private EmotionEditText kKX;
    private EmotionEditModel kKY;
    private String kKZ;
    private EmotionImageData kLa;
    private boolean kLb;
    private String kLc;
    private int kLd = 0;
    private Bitmap kLe;
    private long kLf;
    private EmotionImageData kov;
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
        this.kov = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.kKY = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.iiF = new a(getPageContext());
        this.iiF.setTipString(R.string.emotion_composition);
        this.iiF.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.kKY.setCancel(true);
                EmotionEditActivity.this.cUH();
                EmotionEditActivity.this.chU();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.kKT = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.gwo = (ImageView) findViewById(R.id.close);
        this.kKU = findViewById(R.id.send);
        this.kKV = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.kKV.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void CB(int i) {
                EmotionEditActivity.this.kKX.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.gwo.setOnClickListener(this);
        this.kKU.setOnClickListener(this);
        this.kKW = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        cUG();
        cUF();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kKT.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kKT.setLayoutParams(layoutParams);
        this.kKX.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.kKT.a(this.kKX);
        this.kKV.setVisibility(8);
    }

    private void cUF() {
        this.kKX = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.kKT.addView(this.kKX, layoutParams);
        this.kKX.setTextColor(this.kKV.getCurrentChooseColor());
        this.kKX.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.kKX.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.kKX.getEditText());
                }
            }
        });
    }

    private void cUG() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.kov.getPicUrl();
            gifInfo.mDynamicUrl = this.kov.getPicUrl();
            gifInfo.mStaticUrl = this.kov.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.kov.getPicUrl(), 10, true);
            c.ln().a(this.kov.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.kov.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.kov.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.kov.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.kov.getWidth();
        this.mImageHeight = this.kov.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.kKW;
            this.mImageHeight = this.kKW;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.kKW / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.kKW;
        } else {
            this.mImageWidth = (int) ((this.kKW / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.kKW;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.kKT.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gwo) {
            finish();
        } else if (view == this.kKU) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.kKX.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.kLb) {
            this.kKY.setCancel(false);
            this.kLb = true;
            this.kLf = System.currentTimeMillis();
            this.iiF.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.kKX.getEditText());
            if (TextUtils.isEmpty(this.kKX.getText())) {
                this.kLa = this.kov;
                cUL();
                return;
            }
            String text = this.kKX.getText();
            switch (this.kLd) {
                case 2:
                    if (!TextUtils.isEmpty(this.kLc) && this.kLc.equals(text)) {
                        cUN();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.kLc) && this.kLc.equals(text) && !TextUtils.isEmpty(this.kKZ)) {
                        Ln(this.kKZ);
                        return;
                    }
                    break;
            }
            cUH();
            this.kLc = this.kKX.getText();
            cUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUH() {
        if (this.kLe != null && !this.kLe.isRecycled()) {
            this.kLe.recycle();
            this.kLe = null;
        }
    }

    private void cUI() {
        this.kKY.Lo(this.kKX.getText());
    }

    private void cUJ() {
        if (!this.kKY.isCancel()) {
            this.kKX.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.kKY.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.kKY.isCancel()) {
                        Bitmap G = G(bdImage.getRawBitmap());
                        if (G != null) {
                            this.kKY.b(G, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.kLd = 2;
                        chU();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.kLd = 2;
                chU();
            }
        }
    }

    private void cUK() {
        if (TextUtils.isEmpty(this.kKZ)) {
            chU();
        } else {
            this.kKY.aO(this.kKZ, true);
        }
    }

    private void cUL() {
        if (!this.kKY.isCancel()) {
            this.kLd = 0;
            chU();
            if (this.kLa != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.kLa);
                setResult(-1, intent);
                finish();
                cUM();
                if (!TextUtils.isEmpty(this.kKZ)) {
                    File file = new File(this.kKZ);
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

    private void cUM() {
        ap apVar = new ap("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                apVar.ah("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                apVar.ah("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.kKX.getText())) {
            apVar.ah("obj_type", 1);
        } else {
            apVar.ah("obj_type", 2);
        }
        TiebaStatic.log(apVar);
    }

    public Bitmap G(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.kKX.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cQ = cQ(width, height);
            if (cQ != null) {
                canvas.drawBitmap(cQ, (width * this.kKX.getLeft()) / i, (height * this.kKX.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cQ(int i, int i2) {
        if (this.kLe != null) {
            return this.kLe;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.kKX.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.kKX.getTextView().getDrawingCache();
        this.kLe = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.kLe = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.kLe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.kKV.setVisibility(0);
            this.kKX.cVi();
            return;
        }
        this.kKV.setVisibility(8);
        this.kKX.cVh();
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
        ao.setBackgroundColor(this.mRootView, R.color.black_alpha40);
        ao.setImageResource(this.gwo, R.drawable.icon_emotion_close_n);
        ao.setViewTextColor(this.kKU, R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cUH();
        if (this.kKY != null) {
            this.kKY.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void cUN() {
        cUJ();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Lm(String str) {
        showToast(str);
        this.kLd = 1;
        chU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chU() {
        this.kKX.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.iiF.setDialogVisiable(false);
        this.kLb = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Ln(String str) {
        this.kKX.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            chU();
        } else if (!new File(str).exists()) {
            chU();
        } else {
            this.kKZ = str;
            this.kLd = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.kLf) + "ms");
            cUK();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.kLa = new EmotionImageData();
                this.kLa.setPicId(uploadedPicInfo.getPic_id());
                this.kLa.setWidth(uploadedPicInfo.getWidth());
                this.kLa.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.kov.getMemeContSign())) {
                    this.kLa.setMemeContSign(this.kov.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.kLa.setPicUrl(picinfo.originPic.picUrl);
                    this.kLa.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.kLa.setMemeText(this.kKX.getText());
                this.kLa.setAuthorNameShow(this.kov.getAuthorNameShow());
                cUL();
                return;
            }
            showToast(R.string.upload_error);
            this.kLd = 3;
            chU();
            return;
        }
        showToast(R.string.upload_error);
        this.kLd = 3;
        chU();
    }
}
