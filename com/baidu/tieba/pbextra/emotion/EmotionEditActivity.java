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
/* loaded from: classes22.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView jAO;
    private a jfz;
    private int lLA;
    private EmotionEditText lLB;
    private EmotionEditModel lLC;
    private String lLD;
    private EmotionImageData lLE;
    private boolean lLF;
    private String lLG;
    private int lLH = 0;
    private Bitmap lLI;
    private long lLJ;
    private EmotionEditLayout lLx;
    private View lLy;
    private ChooseColorLayout lLz;
    private EmotionImageData loh;
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
        this.loh = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.lLC = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.jfz = new a(getPageContext());
        this.jfz.setTipString(R.string.emotion_composition);
        this.jfz.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.lLC.vx(true);
                EmotionEditActivity.this.dpZ();
                EmotionEditActivity.this.cCs();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.lLx = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.jAO = (ImageView) findViewById(R.id.close);
        this.lLy = findViewById(R.id.send);
        this.lLz = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.lLz.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void Gv(int i) {
                EmotionEditActivity.this.lLB.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.jAO.setOnClickListener(this);
        this.lLy.setOnClickListener(this);
        this.lLA = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        dpY();
        dpX();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lLx.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.lLx.setLayoutParams(layoutParams);
        this.lLB.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.lLx.a(this.lLB);
        this.lLz.setVisibility(8);
    }

    private void dpX() {
        this.lLB = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.lLx.addView(this.lLB, layoutParams);
        this.lLB.setTextColor(this.lLz.getCurrentChooseColor());
        this.lLB.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.lLB.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.lLB.getEditText());
                }
            }
        });
    }

    private void dpY() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.loh.getPicUrl();
            gifInfo.mDynamicUrl = this.loh.getPicUrl();
            gifInfo.mStaticUrl = this.loh.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.loh.getPicUrl(), 10, true);
            c.mS().a(this.loh.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.loh.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.loh.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.loh.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.loh.getWidth();
        this.mImageHeight = this.loh.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.lLA;
            this.mImageHeight = this.lLA;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.lLA / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.lLA;
        } else {
            this.mImageWidth = (int) ((this.lLA / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.lLA;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.lLx.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jAO) {
            finish();
        } else if (view == this.lLy) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.lLB.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.lLF) {
            this.lLC.vx(false);
            this.lLF = true;
            this.lLJ = System.currentTimeMillis();
            this.jfz.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.lLB.getEditText());
            if (TextUtils.isEmpty(this.lLB.getText())) {
                this.lLE = this.loh;
                dqd();
                return;
            }
            String text = this.lLB.getText();
            switch (this.lLH) {
                case 2:
                    if (!TextUtils.isEmpty(this.lLG) && this.lLG.equals(text)) {
                        dqf();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.lLG) && this.lLG.equals(text) && !TextUtils.isEmpty(this.lLD)) {
                        PV(this.lLD);
                        return;
                    }
                    break;
            }
            dpZ();
            this.lLG = this.lLB.getText();
            dqa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpZ() {
        if (this.lLI != null && !this.lLI.isRecycled()) {
            this.lLI.recycle();
            this.lLI = null;
        }
    }

    private void dqa() {
        this.lLC.PW(this.lLB.getText());
    }

    private void dqb() {
        if (!this.lLC.isCancel()) {
            this.lLB.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.lLC.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.lLC.isCancel()) {
                        Bitmap F = F(bdImage.getRawBitmap());
                        if (F != null) {
                            this.lLC.b(F, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.lLH = 2;
                        cCs();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.lLH = 2;
                cCs();
            }
        }
    }

    private void dqc() {
        if (TextUtils.isEmpty(this.lLD)) {
            cCs();
        } else {
            this.lLC.aY(this.lLD, true);
        }
    }

    private void dqd() {
        if (!this.lLC.isCancel()) {
            this.lLH = 0;
            cCs();
            if (this.lLE != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.lLE);
                setResult(-1, intent);
                finish();
                dqe();
                if (!TextUtils.isEmpty(this.lLD)) {
                    File file = new File(this.lLD);
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

    private void dqe() {
        aq aqVar = new aq("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                aqVar.aj("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                aqVar.aj("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.lLB.getText())) {
            aqVar.aj("obj_type", 1);
        } else {
            aqVar.aj("obj_type", 2);
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
        if (!TextUtils.isEmpty(this.lLB.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap dd = dd(width, height);
            if (dd != null) {
                canvas.drawBitmap(dd, (width * this.lLB.getLeft()) / i, (height * this.lLB.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap dd(int i, int i2) {
        if (this.lLI != null) {
            return this.lLI;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.lLB.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.lLB.getTextView().getDrawingCache();
        this.lLI = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.lLI = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.lLI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.lLz.setVisibility(0);
            this.lLB.dqA();
            return;
        }
        this.lLz.setVisibility(8);
        this.lLB.dqz();
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
        ap.setImageResource(this.jAO, R.drawable.icon_emotion_close_n);
        ap.setViewTextColor(this.lLy, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dpZ();
        if (this.lLC != null) {
            this.lLC.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void dqf() {
        dqb();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void PU(String str) {
        showToast(str);
        this.lLH = 1;
        cCs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCs() {
        this.lLB.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.jfz.setDialogVisiable(false);
        this.lLF = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void PV(String str) {
        this.lLB.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            cCs();
        } else if (!new File(str).exists()) {
            cCs();
        } else {
            this.lLD = str;
            this.lLH = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.lLJ) + "ms");
            dqc();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.lLE = new EmotionImageData();
                this.lLE.setPicId(uploadedPicInfo.getPic_id());
                this.lLE.setWidth(uploadedPicInfo.getWidth());
                this.lLE.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.loh.getMemeContSign())) {
                    this.lLE.setMemeContSign(this.loh.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.lLE.setPicUrl(picinfo.originPic.picUrl);
                    this.lLE.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.lLE.setMemeText(this.lLB.getText());
                this.lLE.setAuthorNameShow(this.loh.getAuthorNameShow());
                dqd();
                return;
            }
            showToast(R.string.upload_error);
            this.lLH = 3;
            cCs();
            return;
        }
        showToast(R.string.upload_error);
        this.lLH = 3;
        cCs();
    }
}
