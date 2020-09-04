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
/* loaded from: classes16.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView gIr;
    private a iwR;
    private EmotionImageData kDV;
    private EmotionEditLayout laR;
    private View laS;
    private ChooseColorLayout laT;
    private int laU;
    private EmotionEditText laV;
    private EmotionEditModel laW;
    private String laX;
    private EmotionImageData laY;
    private boolean laZ;
    private String lba;
    private int lbb = 0;
    private Bitmap lbc;
    private long lbd;
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
        this.kDV = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.laW = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.iwR = new a(getPageContext());
        this.iwR.setTipString(R.string.emotion_composition);
        this.iwR.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.laW.ur(true);
                EmotionEditActivity.this.dfF();
                EmotionEditActivity.this.csz();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.laR = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.gIr = (ImageView) findViewById(R.id.close);
        this.laS = findViewById(R.id.send);
        this.laT = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.laT.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void EV(int i) {
                EmotionEditActivity.this.laV.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.gIr.setOnClickListener(this);
        this.laS.setOnClickListener(this);
        this.laU = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        dfE();
        dfD();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.laR.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.laR.setLayoutParams(layoutParams);
        this.laV.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.laR.a(this.laV);
        this.laT.setVisibility(8);
    }

    private void dfD() {
        this.laV = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.laR.addView(this.laV, layoutParams);
        this.laV.setTextColor(this.laT.getCurrentChooseColor());
        this.laV.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.laV.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.laV.getEditText());
                }
            }
        });
    }

    private void dfE() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.kDV.getPicUrl();
            gifInfo.mDynamicUrl = this.kDV.getPicUrl();
            gifInfo.mStaticUrl = this.kDV.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.kDV.getPicUrl(), 10, true);
            c.mM().a(this.kDV.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.kDV.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.kDV.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.kDV.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.kDV.getWidth();
        this.mImageHeight = this.kDV.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.laU;
            this.mImageHeight = this.laU;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.laU / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.laU;
        } else {
            this.mImageWidth = (int) ((this.laU / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.laU;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.laR.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gIr) {
            finish();
        } else if (view == this.laS) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.laV.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.laZ) {
            this.laW.ur(false);
            this.laZ = true;
            this.lbd = System.currentTimeMillis();
            this.iwR.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.laV.getEditText());
            if (TextUtils.isEmpty(this.laV.getText())) {
                this.laY = this.kDV;
                dfJ();
                return;
            }
            String text = this.laV.getText();
            switch (this.lbb) {
                case 2:
                    if (!TextUtils.isEmpty(this.lba) && this.lba.equals(text)) {
                        dfL();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.lba) && this.lba.equals(text) && !TextUtils.isEmpty(this.laX)) {
                        Oh(this.laX);
                        return;
                    }
                    break;
            }
            dfF();
            this.lba = this.laV.getText();
            dfG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfF() {
        if (this.lbc != null && !this.lbc.isRecycled()) {
            this.lbc.recycle();
            this.lbc = null;
        }
    }

    private void dfG() {
        this.laW.Oi(this.laV.getText());
    }

    private void dfH() {
        if (!this.laW.isCancel()) {
            this.laV.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.laW.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.laW.isCancel()) {
                        Bitmap G = G(bdImage.getRawBitmap());
                        if (G != null) {
                            this.laW.b(G, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.lbb = 2;
                        csz();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.lbb = 2;
                csz();
            }
        }
    }

    private void dfI() {
        if (TextUtils.isEmpty(this.laX)) {
            csz();
        } else {
            this.laW.aS(this.laX, true);
        }
    }

    private void dfJ() {
        if (!this.laW.isCancel()) {
            this.lbb = 0;
            csz();
            if (this.laY != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.laY);
                setResult(-1, intent);
                finish();
                dfK();
                if (!TextUtils.isEmpty(this.laX)) {
                    File file = new File(this.laX);
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

    private void dfK() {
        aq aqVar = new aq("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                aqVar.ai("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                aqVar.ai("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.laV.getText())) {
            aqVar.ai("obj_type", 1);
        } else {
            aqVar.ai("obj_type", 2);
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
        if (!TextUtils.isEmpty(this.laV.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cY = cY(width, height);
            if (cY != null) {
                canvas.drawBitmap(cY, (width * this.laV.getLeft()) / i, (height * this.laV.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cY(int i, int i2) {
        if (this.lbc != null) {
            return this.lbc;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.laV.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.laV.getTextView().getDrawingCache();
        this.lbc = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.lbc = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.lbc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.laT.setVisibility(0);
            this.laV.dgg();
            return;
        }
        this.laT.setVisibility(8);
        this.laV.dgf();
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
        ap.setImageResource(this.gIr, R.drawable.icon_emotion_close_n);
        ap.setViewTextColor(this.laS, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dfF();
        if (this.laW != null) {
            this.laW.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void dfL() {
        dfH();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Og(String str) {
        showToast(str);
        this.lbb = 1;
        csz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csz() {
        this.laV.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.iwR.setDialogVisiable(false);
        this.laZ = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Oh(String str) {
        this.laV.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            csz();
        } else if (!new File(str).exists()) {
            csz();
        } else {
            this.laX = str;
            this.lbb = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.lbd) + "ms");
            dfI();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.laY = new EmotionImageData();
                this.laY.setPicId(uploadedPicInfo.getPic_id());
                this.laY.setWidth(uploadedPicInfo.getWidth());
                this.laY.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.kDV.getMemeContSign())) {
                    this.laY.setMemeContSign(this.kDV.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.laY.setPicUrl(picinfo.originPic.picUrl);
                    this.laY.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.laY.setMemeText(this.laV.getText());
                this.laY.setAuthorNameShow(this.kDV.getAuthorNameShow());
                dfJ();
                return;
            }
            showToast(R.string.upload_error);
            this.lbb = 3;
            csz();
            return;
        }
        showToast(R.string.upload_error);
        this.lbb = 3;
        csz();
    }
}
