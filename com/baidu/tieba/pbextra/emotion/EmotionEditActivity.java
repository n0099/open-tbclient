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
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
/* loaded from: classes2.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView ixA;
    private a jNj;
    private EmotionImageData lRS;
    private String mFrom;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mRootView;
    private View mpA;
    private ChooseColorLayout mpB;
    private int mpC;
    private EmotionEditText mpD;
    private EmotionEditModel mpE;
    private String mpF;
    private EmotionImageData mpG;
    private boolean mpH;
    private String mpI;
    private int mpJ = 0;
    private Bitmap mpK;
    private long mpL;
    private EmotionEditLayout mpz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.emotion_edit_activity);
        this.lRS = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.mpE = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.jNj = new a(getPageContext());
        this.jNj.setTipString(R.string.emotion_composition);
        this.jNj.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.mpE.wB(true);
                EmotionEditActivity.this.dvB();
                EmotionEditActivity.this.cKi();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.mpz = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.ixA = (ImageView) findViewById(R.id.close);
        this.mpA = findViewById(R.id.send);
        this.mpB = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.mpB.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void GC(int i) {
                EmotionEditActivity.this.mpD.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.ixA.setOnClickListener(this);
        this.mpA.setOnClickListener(this);
        this.mpC = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        dvA();
        dvz();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mpz.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mpz.setLayoutParams(layoutParams);
        this.mpD.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mpz.a(this.mpD);
        this.mpB.setVisibility(8);
    }

    private void dvz() {
        this.mpD = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mpz.addView(this.mpD, layoutParams);
        this.mpD.setTextColor(this.mpB.getCurrentChooseColor());
        this.mpD.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.mpD.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.mpD.getEditText());
                }
            }
        });
    }

    private void dvA() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.lRS.getPicUrl();
            gifInfo.mDynamicUrl = this.lRS.getPicUrl();
            gifInfo.mStaticUrl = this.lRS.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.lRS.getPicUrl(), 10, true);
            d.mw().a(this.lRS.getPicUrl(), 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.drawImageTo(EmotionEditActivity.this.mImageView);
                            EmotionEditActivity.this.mImageView = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.mImageView).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.lRS.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.lRS.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.lRS.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.lRS.getWidth();
        this.mImageHeight = this.lRS.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.mpC;
            this.mImageHeight = this.mpC;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.mpC / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.mpC;
        } else {
            this.mImageWidth = (int) ((this.mpC / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.mpC;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.mpz.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ixA) {
            finish();
        } else if (view == this.mpA) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.mpD.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.mpH) {
            this.mpE.wB(false);
            this.mpH = true;
            this.mpL = System.currentTimeMillis();
            this.jNj.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.mpD.getEditText());
            if (TextUtils.isEmpty(this.mpD.getText())) {
                this.mpG = this.lRS;
                dvF();
                return;
            }
            String text = this.mpD.getText();
            switch (this.mpJ) {
                case 2:
                    if (!TextUtils.isEmpty(this.mpI) && this.mpI.equals(text)) {
                        dvH();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.mpI) && this.mpI.equals(text) && !TextUtils.isEmpty(this.mpF)) {
                        Qf(this.mpF);
                        return;
                    }
                    break;
            }
            dvB();
            this.mpI = this.mpD.getText();
            dvC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvB() {
        if (this.mpK != null && !this.mpK.isRecycled()) {
            this.mpK.recycle();
            this.mpK = null;
        }
    }

    private void dvC() {
        this.mpE.Qg(this.mpD.getText());
    }

    private void dvD() {
        if (!this.mpE.isCancel()) {
            this.mpD.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.mpE.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.mpE.isCancel()) {
                        Bitmap F = F(bdImage.getRawBitmap());
                        if (F != null) {
                            this.mpE.b(F, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.mpJ = 2;
                        cKi();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.mpJ = 2;
                cKi();
            }
        }
    }

    private void dvE() {
        if (TextUtils.isEmpty(this.mpF)) {
            cKi();
        } else {
            this.mpE.aZ(this.mpF, true);
        }
    }

    private void dvF() {
        if (!this.mpE.isCancel()) {
            this.mpJ = 0;
            cKi();
            if (this.mpG != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.mpG);
                setResult(-1, intent);
                finish();
                dvG();
                if (!TextUtils.isEmpty(this.mpF)) {
                    File file = new File(this.mpF);
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

    private void dvG() {
        ar arVar = new ar("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                arVar.ap("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                arVar.ap("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.mpD.getText())) {
            arVar.ap("obj_type", 1);
        } else {
            arVar.ap("obj_type", 2);
        }
        TiebaStatic.log(arVar);
    }

    public Bitmap F(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.mpD.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap dd = dd(width, height);
            if (dd != null) {
                canvas.drawBitmap(dd, (width * this.mpD.getLeft()) / i, (height * this.mpD.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public Bitmap dd(int i, int i2) {
        if (this.mpK != null) {
            return this.mpK;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.mpD.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.mpD.getTextView().getDrawingCache();
        this.mpK = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.mpK = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.mpK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.mpB.setVisibility(0);
            this.mpD.dwc();
            return;
        }
        this.mpB.setVisibility(8);
        this.mpD.dwb();
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
        ap.setBackgroundColor(this.mRootView, R.color.black_alpha40);
        ap.setImageResource(this.ixA, R.drawable.icon_emotion_close_n);
        ap.setViewTextColor(this.mpA, R.color.CAM_X0111);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dvB();
        if (this.mpE != null) {
            this.mpE.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void dvH() {
        dvD();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Qe(String str) {
        showToast(str);
        this.mpJ = 1;
        cKi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKi() {
        this.mpD.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.jNj.setDialogVisiable(false);
        this.mpH = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Qf(String str) {
        this.mpD.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            cKi();
        } else if (!new File(str).exists()) {
            cKi();
        } else {
            this.mpF = str;
            this.mpJ = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.mpL) + "ms");
            dvE();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.mpG = new EmotionImageData();
                this.mpG.setPicId(uploadedPicInfo.getPic_id());
                this.mpG.setWidth(uploadedPicInfo.getWidth());
                this.mpG.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.lRS.getMemeContSign())) {
                    this.mpG.setMemeContSign(this.lRS.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.mpG.setPicUrl(picinfo.originPic.picUrl);
                    this.mpG.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.mpG.setMemeText(this.mpD.getText());
                this.mpG.setAuthorNameShow(this.lRS.getAuthorNameShow());
                dvF();
                return;
            }
            showToast(R.string.upload_error);
            this.mpJ = 3;
            cKi();
            return;
        }
        showToast(R.string.upload_error);
        this.mpJ = 3;
        cKi();
    }
}
