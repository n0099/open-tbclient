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
import com.baidu.tbadk.core.util.aq;
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
/* loaded from: classes21.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private a iEn;
    private ImageView iZp;
    private EmotionImageData kMu;
    private EmotionEditLayout ljI;
    private View ljJ;
    private ChooseColorLayout ljK;
    private int ljL;
    private EmotionEditText ljM;
    private EmotionEditModel ljN;
    private String ljO;
    private EmotionImageData ljP;
    private boolean ljQ;
    private String ljR;
    private int ljS = 0;
    private Bitmap ljT;
    private long ljU;
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
        this.kMu = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.ljN = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.iEn = new a(getPageContext());
        this.iEn.setTipString(R.string.emotion_composition);
        this.iEn.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.ljN.uz(true);
                EmotionEditActivity.this.dji();
                EmotionEditActivity.this.cvO();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.ljI = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.iZp = (ImageView) findViewById(R.id.close);
        this.ljJ = findViewById(R.id.send);
        this.ljK = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.ljK.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void Fw(int i) {
                EmotionEditActivity.this.ljM.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.iZp.setOnClickListener(this);
        this.ljJ.setOnClickListener(this);
        this.ljL = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        djh();
        djg();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ljI.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.ljI.setLayoutParams(layoutParams);
        this.ljM.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.ljI.a(this.ljM);
        this.ljK.setVisibility(8);
    }

    private void djg() {
        this.ljM = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.ljI.addView(this.ljM, layoutParams);
        this.ljM.setTextColor(this.ljK.getCurrentChooseColor());
        this.ljM.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.ljM.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.ljM.getEditText());
                }
            }
        });
    }

    private void djh() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.kMu.getPicUrl();
            gifInfo.mDynamicUrl = this.kMu.getPicUrl();
            gifInfo.mStaticUrl = this.kMu.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.kMu.getPicUrl(), 10, true);
            c.mR().a(this.kMu.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.kMu.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.kMu.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.kMu.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.kMu.getWidth();
        this.mImageHeight = this.kMu.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.ljL;
            this.mImageHeight = this.ljL;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.ljL / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.ljL;
        } else {
            this.mImageWidth = (int) ((this.ljL / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.ljL;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.ljI.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iZp) {
            finish();
        } else if (view == this.ljJ) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.ljM.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.ljQ) {
            this.ljN.uz(false);
            this.ljQ = true;
            this.ljU = System.currentTimeMillis();
            this.iEn.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.ljM.getEditText());
            if (TextUtils.isEmpty(this.ljM.getText())) {
                this.ljP = this.kMu;
                djm();
                return;
            }
            String text = this.ljM.getText();
            switch (this.ljS) {
                case 2:
                    if (!TextUtils.isEmpty(this.ljR) && this.ljR.equals(text)) {
                        djo();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.ljR) && this.ljR.equals(text) && !TextUtils.isEmpty(this.ljO)) {
                        OI(this.ljO);
                        return;
                    }
                    break;
            }
            dji();
            this.ljR = this.ljM.getText();
            djj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dji() {
        if (this.ljT != null && !this.ljT.isRecycled()) {
            this.ljT.recycle();
            this.ljT = null;
        }
    }

    private void djj() {
        this.ljN.OJ(this.ljM.getText());
    }

    private void djk() {
        if (!this.ljN.isCancel()) {
            this.ljM.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.ljN.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.ljN.isCancel()) {
                        Bitmap F = F(bdImage.getRawBitmap());
                        if (F != null) {
                            this.ljN.b(F, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.ljS = 2;
                        cvO();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.ljS = 2;
                cvO();
            }
        }
    }

    private void djl() {
        if (TextUtils.isEmpty(this.ljO)) {
            cvO();
        } else {
            this.ljN.aS(this.ljO, true);
        }
    }

    private void djm() {
        if (!this.ljN.isCancel()) {
            this.ljS = 0;
            cvO();
            if (this.ljP != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.ljP);
                setResult(-1, intent);
                finish();
                djn();
                if (!TextUtils.isEmpty(this.ljO)) {
                    File file = new File(this.ljO);
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

    private void djn() {
        aq aqVar = new aq("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                aqVar.ai("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                aqVar.ai("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.ljM.getText())) {
            aqVar.ai("obj_type", 1);
        } else {
            aqVar.ai("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
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
        if (!TextUtils.isEmpty(this.ljM.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap db = db(width, height);
            if (db != null) {
                canvas.drawBitmap(db, (width * this.ljM.getLeft()) / i, (height * this.ljM.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap db(int i, int i2) {
        if (this.ljT != null) {
            return this.ljT;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.ljM.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.ljM.getTextView().getDrawingCache();
        this.ljT = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.ljT = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.ljT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.ljK.setVisibility(0);
            this.ljM.djJ();
            return;
        }
        this.ljK.setVisibility(8);
        this.ljM.djI();
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
        ap.setImageResource(this.iZp, R.drawable.icon_emotion_close_n);
        ap.setViewTextColor(this.ljJ, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dji();
        if (this.ljN != null) {
            this.ljN.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void djo() {
        djk();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void OH(String str) {
        showToast(str);
        this.ljS = 1;
        cvO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvO() {
        this.ljM.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.iEn.setDialogVisiable(false);
        this.ljQ = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void OI(String str) {
        this.ljM.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            cvO();
        } else if (!new File(str).exists()) {
            cvO();
        } else {
            this.ljO = str;
            this.ljS = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.ljU) + "ms");
            djl();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.ljP = new EmotionImageData();
                this.ljP.setPicId(uploadedPicInfo.getPic_id());
                this.ljP.setWidth(uploadedPicInfo.getWidth());
                this.ljP.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.kMu.getMemeContSign())) {
                    this.ljP.setMemeContSign(this.kMu.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.ljP.setPicUrl(picinfo.originPic.picUrl);
                    this.ljP.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.ljP.setMemeText(this.ljM.getText());
                this.ljP.setAuthorNameShow(this.kMu.getAuthorNameShow());
                djm();
                return;
            }
            showToast(R.string.upload_error);
            this.ljS = 3;
            cvO();
            return;
        }
        showToast(R.string.upload_error);
        this.ljS = 3;
        cvO();
    }
}
