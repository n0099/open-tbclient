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
    private ImageView ixO;
    private a jNx;
    private EmotionImageData lSh;
    private String mFrom;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mRootView;
    private EmotionEditLayout mpO;
    private View mpP;
    private ChooseColorLayout mpQ;
    private int mpR;
    private EmotionEditText mpS;
    private EmotionEditModel mpT;
    private String mpU;
    private EmotionImageData mpV;
    private boolean mpW;
    private String mpX;
    private int mpY = 0;
    private Bitmap mpZ;
    private long mqa;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.emotion_edit_activity);
        this.lSh = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.mpT = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.jNx = new a(getPageContext());
        this.jNx.setTipString(R.string.emotion_composition);
        this.jNx.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.mpT.wB(true);
                EmotionEditActivity.this.dvI();
                EmotionEditActivity.this.cKp();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.mpO = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.ixO = (ImageView) findViewById(R.id.close);
        this.mpP = findViewById(R.id.send);
        this.mpQ = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.mpQ.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void GC(int i) {
                EmotionEditActivity.this.mpS.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.ixO.setOnClickListener(this);
        this.mpP.setOnClickListener(this);
        this.mpR = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        dvH();
        dvG();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mpO.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mpO.setLayoutParams(layoutParams);
        this.mpS.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mpO.a(this.mpS);
        this.mpQ.setVisibility(8);
    }

    private void dvG() {
        this.mpS = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mpO.addView(this.mpS, layoutParams);
        this.mpS.setTextColor(this.mpQ.getCurrentChooseColor());
        this.mpS.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.mpS.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.mpS.getEditText());
                }
            }
        });
    }

    private void dvH() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.lSh.getPicUrl();
            gifInfo.mDynamicUrl = this.lSh.getPicUrl();
            gifInfo.mStaticUrl = this.lSh.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.lSh.getPicUrl(), 10, true);
            d.mw().a(this.lSh.getPicUrl(), 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.lSh.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.lSh.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.lSh.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.lSh.getWidth();
        this.mImageHeight = this.lSh.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.mpR;
            this.mImageHeight = this.mpR;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.mpR / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.mpR;
        } else {
            this.mImageWidth = (int) ((this.mpR / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.mpR;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.mpO.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ixO) {
            finish();
        } else if (view == this.mpP) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.mpS.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.mpW) {
            this.mpT.wB(false);
            this.mpW = true;
            this.mqa = System.currentTimeMillis();
            this.jNx.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.mpS.getEditText());
            if (TextUtils.isEmpty(this.mpS.getText())) {
                this.mpV = this.lSh;
                dvM();
                return;
            }
            String text = this.mpS.getText();
            switch (this.mpY) {
                case 2:
                    if (!TextUtils.isEmpty(this.mpX) && this.mpX.equals(text)) {
                        dvO();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.mpX) && this.mpX.equals(text) && !TextUtils.isEmpty(this.mpU)) {
                        Qg(this.mpU);
                        return;
                    }
                    break;
            }
            dvI();
            this.mpX = this.mpS.getText();
            dvJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvI() {
        if (this.mpZ != null && !this.mpZ.isRecycled()) {
            this.mpZ.recycle();
            this.mpZ = null;
        }
    }

    private void dvJ() {
        this.mpT.Qh(this.mpS.getText());
    }

    private void dvK() {
        if (!this.mpT.isCancel()) {
            this.mpS.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.mpT.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.mpT.isCancel()) {
                        Bitmap F = F(bdImage.getRawBitmap());
                        if (F != null) {
                            this.mpT.b(F, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.mpY = 2;
                        cKp();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.mpY = 2;
                cKp();
            }
        }
    }

    private void dvL() {
        if (TextUtils.isEmpty(this.mpU)) {
            cKp();
        } else {
            this.mpT.aZ(this.mpU, true);
        }
    }

    private void dvM() {
        if (!this.mpT.isCancel()) {
            this.mpY = 0;
            cKp();
            if (this.mpV != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.mpV);
                setResult(-1, intent);
                finish();
                dvN();
                if (!TextUtils.isEmpty(this.mpU)) {
                    File file = new File(this.mpU);
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

    private void dvN() {
        ar arVar = new ar("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                arVar.ap("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                arVar.ap("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.mpS.getText())) {
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
        if (!TextUtils.isEmpty(this.mpS.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap de = de(width, height);
            if (de != null) {
                canvas.drawBitmap(de, (width * this.mpS.getLeft()) / i, (height * this.mpS.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public Bitmap de(int i, int i2) {
        if (this.mpZ != null) {
            return this.mpZ;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.mpS.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.mpS.getTextView().getDrawingCache();
        this.mpZ = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.mpZ = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.mpZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.mpQ.setVisibility(0);
            this.mpS.dwj();
            return;
        }
        this.mpQ.setVisibility(8);
        this.mpS.dwi();
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
        ap.setImageResource(this.ixO, R.drawable.icon_emotion_close_n);
        ap.setViewTextColor(this.mpP, R.color.CAM_X0111);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dvI();
        if (this.mpT != null) {
            this.mpT.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void dvO() {
        dvK();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Qf(String str) {
        showToast(str);
        this.mpY = 1;
        cKp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKp() {
        this.mpS.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.jNx.setDialogVisiable(false);
        this.mpW = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Qg(String str) {
        this.mpS.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            cKp();
        } else if (!new File(str).exists()) {
            cKp();
        } else {
            this.mpU = str;
            this.mpY = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.mqa) + "ms");
            dvL();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.mpV = new EmotionImageData();
                this.mpV.setPicId(uploadedPicInfo.getPic_id());
                this.mpV.setWidth(uploadedPicInfo.getWidth());
                this.mpV.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.lSh.getMemeContSign())) {
                    this.mpV.setMemeContSign(this.lSh.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.mpV.setPicUrl(picinfo.originPic.picUrl);
                    this.mpV.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.mpV.setMemeText(this.mpS.getText());
                this.mpV.setAuthorNameShow(this.lSh.getAuthorNameShow());
                dvM();
                return;
            }
            showToast(R.string.upload_error);
            this.mpY = 3;
            cKp();
            return;
        }
        showToast(R.string.upload_error);
        this.mpY = 3;
        cKp();
    }
}
