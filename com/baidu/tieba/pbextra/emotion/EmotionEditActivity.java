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
/* loaded from: classes22.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView jVp;
    private a jzM;
    private EmotionImageData lIl;
    private String mFrom;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mRootView;
    private EmotionEditLayout mfQ;
    private View mfR;
    private ChooseColorLayout mfS;
    private int mfT;
    private EmotionEditText mfU;
    private EmotionEditModel mfV;
    private String mfW;
    private EmotionImageData mfX;
    private boolean mfY;
    private String mfZ;
    private int mga = 0;
    private Bitmap mgb;
    private long mgc;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.emotion_edit_activity);
        this.lIl = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.mfV = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.jzM = new a(getPageContext());
        this.jzM.setTipString(R.string.emotion_composition);
        this.jzM.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.mfV.wn(true);
                EmotionEditActivity.this.dxu();
                EmotionEditActivity.this.cJM();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.mfQ = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.jVp = (ImageView) findViewById(R.id.close);
        this.mfR = findViewById(R.id.send);
        this.mfS = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.mfS.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void HX(int i) {
                EmotionEditActivity.this.mfU.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.jVp.setOnClickListener(this);
        this.mfR.setOnClickListener(this);
        this.mfT = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        dxt();
        dxs();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mfQ.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mfQ.setLayoutParams(layoutParams);
        this.mfU.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mfQ.a(this.mfU);
        this.mfS.setVisibility(8);
    }

    private void dxs() {
        this.mfU = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mfQ.addView(this.mfU, layoutParams);
        this.mfU.setTextColor(this.mfS.getCurrentChooseColor());
        this.mfU.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.mfU.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.mfU.getEditText());
                }
            }
        });
    }

    private void dxt() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.lIl.getPicUrl();
            gifInfo.mDynamicUrl = this.lIl.getPicUrl();
            gifInfo.mStaticUrl = this.lIl.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.lIl.getPicUrl(), 10, true);
            c.mS().a(this.lIl.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.lIl.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.lIl.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.lIl.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.lIl.getWidth();
        this.mImageHeight = this.lIl.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.mfT;
            this.mImageHeight = this.mfT;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.mfT / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.mfT;
        } else {
            this.mImageWidth = (int) ((this.mfT / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.mfT;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.mfQ.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jVp) {
            finish();
        } else if (view == this.mfR) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.mfU.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.mfY) {
            this.mfV.wn(false);
            this.mfY = true;
            this.mgc = System.currentTimeMillis();
            this.jzM.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.mfU.getEditText());
            if (TextUtils.isEmpty(this.mfU.getText())) {
                this.mfX = this.lIl;
                dxy();
                return;
            }
            String text = this.mfU.getText();
            switch (this.mga) {
                case 2:
                    if (!TextUtils.isEmpty(this.mfZ) && this.mfZ.equals(text)) {
                        dxA();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.mfZ) && this.mfZ.equals(text) && !TextUtils.isEmpty(this.mfW)) {
                        QQ(this.mfW);
                        return;
                    }
                    break;
            }
            dxu();
            this.mfZ = this.mfU.getText();
            dxv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxu() {
        if (this.mgb != null && !this.mgb.isRecycled()) {
            this.mgb.recycle();
            this.mgb = null;
        }
    }

    private void dxv() {
        this.mfV.QR(this.mfU.getText());
    }

    private void dxw() {
        if (!this.mfV.isCancel()) {
            this.mfU.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.mfV.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.mfV.isCancel()) {
                        Bitmap F = F(bdImage.getRawBitmap());
                        if (F != null) {
                            this.mfV.b(F, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.mga = 2;
                        cJM();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.mga = 2;
                cJM();
            }
        }
    }

    private void dxx() {
        if (TextUtils.isEmpty(this.mfW)) {
            cJM();
        } else {
            this.mfV.aZ(this.mfW, true);
        }
    }

    private void dxy() {
        if (!this.mfV.isCancel()) {
            this.mga = 0;
            cJM();
            if (this.mfX != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.mfX);
                setResult(-1, intent);
                finish();
                dxz();
                if (!TextUtils.isEmpty(this.mfW)) {
                    File file = new File(this.mfW);
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

    private void dxz() {
        ar arVar = new ar("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                arVar.al("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                arVar.al("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.mfU.getText())) {
            arVar.al("obj_type", 1);
        } else {
            arVar.al("obj_type", 2);
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
        if (!TextUtils.isEmpty(this.mfU.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap dk = dk(width, height);
            if (dk != null) {
                canvas.drawBitmap(dk, (width * this.mfU.getLeft()) / i, (height * this.mfU.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap dk(int i, int i2) {
        if (this.mgb != null) {
            return this.mgb;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.mfU.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.mfU.getTextView().getDrawingCache();
        this.mgb = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.mgb = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.mgb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.mfS.setVisibility(0);
            this.mfU.dxV();
            return;
        }
        this.mfS.setVisibility(8);
        this.mfU.dxU();
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
        ap.setImageResource(this.jVp, R.drawable.icon_emotion_close_n);
        ap.setViewTextColor(this.mfR, (int) R.color.CAM_X0111);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dxu();
        if (this.mfV != null) {
            this.mfV.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void dxA() {
        dxw();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void QP(String str) {
        showToast(str);
        this.mga = 1;
        cJM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJM() {
        this.mfU.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.jzM.setDialogVisiable(false);
        this.mfY = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void QQ(String str) {
        this.mfU.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            cJM();
        } else if (!new File(str).exists()) {
            cJM();
        } else {
            this.mfW = str;
            this.mga = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.mgc) + "ms");
            dxx();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.mfX = new EmotionImageData();
                this.mfX.setPicId(uploadedPicInfo.getPic_id());
                this.mfX.setWidth(uploadedPicInfo.getWidth());
                this.mfX.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.lIl.getMemeContSign())) {
                    this.mfX.setMemeContSign(this.lIl.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.mfX.setPicUrl(picinfo.originPic.picUrl);
                    this.mfX.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.mfX.setMemeText(this.mfU.getText());
                this.mfX.setAuthorNameShow(this.lIl.getAuthorNameShow());
                dxy();
                return;
            }
            showToast(R.string.upload_error);
            this.mga = 3;
            cJM();
            return;
        }
        showToast(R.string.upload_error);
        this.mga = 3;
        cJM();
    }
}
