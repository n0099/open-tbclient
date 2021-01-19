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
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes2.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private a jHF;
    private ImageView kdU;
    private EmotionImageData lIV;
    private String mFrom;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mRootView;
    private EmotionEditText mgA;
    private EmotionEditModel mgB;
    private String mgC;
    private EmotionImageData mgD;
    private boolean mgE;
    private String mgF;
    private int mgG = 0;
    private Bitmap mgH;
    private long mgI;
    private EmotionEditLayout mgw;
    private View mgx;
    private ChooseColorLayout mgy;
    private int mgz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.emotion_edit_activity);
        this.lIV = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.mgB = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.jHF = new a(getPageContext());
        this.jHF.setTipString(R.string.emotion_composition);
        this.jHF.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.mgB.wk(true);
                EmotionEditActivity.this.dts();
                EmotionEditActivity.this.cIV();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.mgw = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.kdU = (ImageView) findViewById(R.id.close);
        this.mgx = findViewById(R.id.send);
        this.mgy = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.mgy.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void Gk(int i) {
                EmotionEditActivity.this.mgA.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.kdU.setOnClickListener(this);
        this.mgx.setOnClickListener(this);
        this.mgz = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        dtr();
        dtq();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mgw.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mgw.setLayoutParams(layoutParams);
        this.mgA.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mgw.a(this.mgA);
        this.mgy.setVisibility(8);
    }

    private void dtq() {
        this.mgA = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mgw.addView(this.mgA, layoutParams);
        this.mgA.setTextColor(this.mgy.getCurrentChooseColor());
        this.mgA.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.mgA.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.mgA.getEditText());
                }
            }
        });
    }

    private void dtr() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.lIV.getPicUrl();
            gifInfo.mDynamicUrl = this.lIV.getPicUrl();
            gifInfo.mStaticUrl = this.lIV.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.lIV.getPicUrl(), 10, true);
            d.mx().a(this.lIV.getPicUrl(), 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.lIV.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.lIV.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.lIV.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.lIV.getWidth();
        this.mImageHeight = this.lIV.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.mgz;
            this.mImageHeight = this.mgz;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.mgz / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.mgz;
        } else {
            this.mImageWidth = (int) ((this.mgz / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.mgz;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.mgw.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kdU) {
            finish();
        } else if (view == this.mgx) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.mgA.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.mgE) {
            this.mgB.wk(false);
            this.mgE = true;
            this.mgI = System.currentTimeMillis();
            this.jHF.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.mgA.getEditText());
            if (TextUtils.isEmpty(this.mgA.getText())) {
                this.mgD = this.lIV;
                dtw();
                return;
            }
            String text = this.mgA.getText();
            switch (this.mgG) {
                case 2:
                    if (!TextUtils.isEmpty(this.mgF) && this.mgF.equals(text)) {
                        dty();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.mgF) && this.mgF.equals(text) && !TextUtils.isEmpty(this.mgC)) {
                        Po(this.mgC);
                        return;
                    }
                    break;
            }
            dts();
            this.mgF = this.mgA.getText();
            dtt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dts() {
        if (this.mgH != null && !this.mgH.isRecycled()) {
            this.mgH.recycle();
            this.mgH = null;
        }
    }

    private void dtt() {
        this.mgB.Pp(this.mgA.getText());
    }

    private void dtu() {
        if (!this.mgB.isCancel()) {
            this.mgA.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.mgB.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.mgB.isCancel()) {
                        Bitmap G = G(bdImage.getRawBitmap());
                        if (G != null) {
                            this.mgB.b(G, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.mgG = 2;
                        cIV();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.mgG = 2;
                cIV();
            }
        }
    }

    private void dtv() {
        if (TextUtils.isEmpty(this.mgC)) {
            cIV();
        } else {
            this.mgB.aZ(this.mgC, true);
        }
    }

    private void dtw() {
        if (!this.mgB.isCancel()) {
            this.mgG = 0;
            cIV();
            if (this.mgD != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.mgD);
                setResult(-1, intent);
                finish();
                dtx();
                if (!TextUtils.isEmpty(this.mgC)) {
                    File file = new File(this.mgC);
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

    private void dtx() {
        aq aqVar = new aq("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                aqVar.an("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                aqVar.an("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.mgA.getText())) {
            aqVar.an("obj_type", 1);
        } else {
            aqVar.an("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
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
        if (!TextUtils.isEmpty(this.mgA.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap dg = dg(width, height);
            if (dg != null) {
                canvas.drawBitmap(dg, (width * this.mgA.getLeft()) / i, (height * this.mgA.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public Bitmap dg(int i, int i2) {
        if (this.mgH != null) {
            return this.mgH;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.mgA.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.mgA.getTextView().getDrawingCache();
        this.mgH = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.mgH = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.mgH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.mgy.setVisibility(0);
            this.mgA.dtT();
            return;
        }
        this.mgy.setVisibility(8);
        this.mgA.dtS();
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
        ao.setImageResource(this.kdU, R.drawable.icon_emotion_close_n);
        ao.setViewTextColor(this.mgx, R.color.CAM_X0111);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dts();
        if (this.mgB != null) {
            this.mgB.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void dty() {
        dtu();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Pn(String str) {
        showToast(str);
        this.mgG = 1;
        cIV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIV() {
        this.mgA.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.jHF.setDialogVisiable(false);
        this.mgE = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Po(String str) {
        this.mgA.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            cIV();
        } else if (!new File(str).exists()) {
            cIV();
        } else {
            this.mgC = str;
            this.mgG = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.mgI) + "ms");
            dtv();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.mgD = new EmotionImageData();
                this.mgD.setPicId(uploadedPicInfo.getPic_id());
                this.mgD.setWidth(uploadedPicInfo.getWidth());
                this.mgD.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.lIV.getMemeContSign())) {
                    this.mgD.setMemeContSign(this.lIV.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.mgD.setPicUrl(picinfo.originPic.picUrl);
                    this.mgD.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.mgD.setMemeText(this.mgA.getText());
                this.mgD.setAuthorNameShow(this.lIV.getAuthorNameShow());
                dtw();
                return;
            }
            showToast(R.string.upload_error);
            this.mgG = 3;
            cIV();
            return;
        }
        showToast(R.string.upload_error);
        this.mgG = 3;
        cIV();
    }
}
