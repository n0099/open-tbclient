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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
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
    private ImageView gqS;
    private a icD;
    private EmotionEditLayout kBR;
    private View kBS;
    private ChooseColorLayout kBT;
    private int kBU;
    private EmotionEditText kBV;
    private EmotionEditModel kBW;
    private String kBX;
    private EmotionImageData kBY;
    private boolean kBZ;
    private String kCa;
    private int kCb = 0;
    private Bitmap kCc;
    private long kCd;
    private EmotionImageData kfG;
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
        this.kfG = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.kBW = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.icD = new a(getPageContext());
        this.icD.setTipString(R.string.emotion_composition);
        this.icD.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.kBW.setCancel(true);
                EmotionEditActivity.this.cQR();
                EmotionEditActivity.this.cev();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.kBR = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.gqS = (ImageView) findViewById(R.id.close);
        this.kBS = findViewById(R.id.send);
        this.kBT = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.kBT.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void Cb(int i) {
                EmotionEditActivity.this.kBV.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.gqS.setOnClickListener(this);
        this.kBS.setOnClickListener(this);
        this.kBU = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        cQQ();
        cQP();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kBR.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kBR.setLayoutParams(layoutParams);
        this.kBV.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.kBR.a(this.kBV);
        this.kBT.setVisibility(8);
    }

    private void cQP() {
        this.kBV = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.kBR.addView(this.kBV, layoutParams);
        this.kBV.setTextColor(this.kBT.getCurrentChooseColor());
        this.kBV.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.kBV.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.kBV.getEditText());
                }
            }
        });
    }

    private void cQQ() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.kfG.getPicUrl();
            gifInfo.mDynamicUrl = this.kfG.getPicUrl();
            gifInfo.mStaticUrl = this.kfG.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.kfG.getPicUrl(), 10, true);
            c.ln().a(this.kfG.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.kfG.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.kfG.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.kfG.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.kfG.getWidth();
        this.mImageHeight = this.kfG.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.kBU;
            this.mImageHeight = this.kBU;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.kBU / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.kBU;
        } else {
            this.mImageWidth = (int) ((this.kBU / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.kBU;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.kBR.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gqS) {
            finish();
        } else if (view == this.kBS) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.kBV.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.kBZ) {
            this.kBW.setCancel(false);
            this.kBZ = true;
            this.kCd = System.currentTimeMillis();
            this.icD.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.kBV.getEditText());
            if (TextUtils.isEmpty(this.kBV.getText())) {
                this.kBY = this.kfG;
                cQV();
                return;
            }
            String text = this.kBV.getText();
            switch (this.kCb) {
                case 2:
                    if (!TextUtils.isEmpty(this.kCa) && this.kCa.equals(text)) {
                        cQX();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.kCa) && this.kCa.equals(text) && !TextUtils.isEmpty(this.kBX)) {
                        Kz(this.kBX);
                        return;
                    }
                    break;
            }
            cQR();
            this.kCa = this.kBV.getText();
            cQS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQR() {
        if (this.kCc != null && !this.kCc.isRecycled()) {
            this.kCc.recycle();
            this.kCc = null;
        }
    }

    private void cQS() {
        this.kBW.KA(this.kBV.getText());
    }

    private void cQT() {
        if (!this.kBW.isCancel()) {
            this.kBV.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.kBW.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.kBW.isCancel()) {
                        Bitmap D = D(bdImage.getRawBitmap());
                        if (D != null) {
                            this.kBW.b(D, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.kCb = 2;
                        cev();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.kCb = 2;
                cev();
            }
        }
    }

    private void cQU() {
        if (TextUtils.isEmpty(this.kBX)) {
            cev();
        } else {
            this.kBW.aQ(this.kBX, true);
        }
    }

    private void cQV() {
        if (!this.kBW.isCancel()) {
            this.kCb = 0;
            cev();
            if (this.kBY != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.kBY);
                setResult(-1, intent);
                finish();
                cQW();
                if (!TextUtils.isEmpty(this.kBX)) {
                    File file = new File(this.kBX);
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

    private void cQW() {
        ao aoVar = new ao("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                aoVar.ag("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                aoVar.ag("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.kBV.getText())) {
            aoVar.ag("obj_type", 1);
        } else {
            aoVar.ag("obj_type", 2);
        }
        TiebaStatic.log(aoVar);
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
        if (!TextUtils.isEmpty(this.kBV.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cN = cN(width, height);
            if (cN != null) {
                canvas.drawBitmap(cN, (width * this.kBV.getLeft()) / i, (height * this.kBV.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cN(int i, int i2) {
        if (this.kCc != null) {
            return this.kCc;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.kBV.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.kBV.getTextView().getDrawingCache();
        this.kCc = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.kCc = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.kCc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.kBT.setVisibility(0);
            this.kBV.cRs();
            return;
        }
        this.kBT.setVisibility(8);
        this.kBV.cRr();
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
        an.setBackgroundColor(this.mRootView, R.color.black_alpha40);
        an.setImageResource(this.gqS, R.drawable.icon_emotion_close_n);
        an.setViewTextColor(this.kBS, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cQR();
        if (this.kBW != null) {
            this.kBW.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void cQX() {
        cQT();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Ky(String str) {
        showToast(str);
        this.kCb = 1;
        cev();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cev() {
        this.kBV.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.icD.setDialogVisiable(false);
        this.kBZ = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Kz(String str) {
        this.kBV.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            cev();
        } else if (!new File(str).exists()) {
            cev();
        } else {
            this.kBX = str;
            this.kCb = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.kCd) + "ms");
            cQU();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.kBY = new EmotionImageData();
                this.kBY.setPicId(uploadedPicInfo.getPic_id());
                this.kBY.setWidth(uploadedPicInfo.getWidth());
                this.kBY.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.kfG.getMemeContSign())) {
                    this.kBY.setMemeContSign(this.kfG.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.kBY.setPicUrl(picinfo.originPic.picUrl);
                    this.kBY.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.kBY.setMemeText(this.kBV.getText());
                this.kBY.setAuthorNameShow(this.kfG.getAuthorNameShow());
                cQV();
                return;
            }
            showToast(R.string.upload_error);
            this.kCb = 3;
            cev();
            return;
        }
        showToast(R.string.upload_error);
        this.kCb = 3;
        cev();
    }
}
