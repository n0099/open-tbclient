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
import com.baidu.adp.lib.f.c;
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
import com.baidu.tbadk.core.util.c.a;
import com.baidu.tbadk.core.view.b;
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
/* loaded from: classes4.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private b fUF;
    private ImageView gmq;
    private EmotionImageData hLx;
    private EmotionEditLayout igG;
    private View igH;
    private ChooseColorLayout igI;
    private int igJ;
    private EmotionEditText igK;
    private EmotionEditModel igL;
    private String igM;
    private EmotionImageData igN;
    private boolean igO;
    private String igP;
    private int igQ = 0;
    private Bitmap igR;
    private long igS;
    private String mFrom;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private a mPermissionJudgement;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.emotion_edit_activity);
        this.hLx = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.igL = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.fUF = new b(getPageContext());
        this.fUF.setTipString(R.string.emotion_composition);
        this.fUF.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.igL.setCancel(true);
                EmotionEditActivity.this.bYq();
                EmotionEditActivity.this.bpL();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.igG = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.gmq = (ImageView) findViewById(R.id.close);
        this.igH = findViewById(R.id.send);
        this.igI = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.igI.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void xf(int i) {
                EmotionEditActivity.this.igK.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.gmq.setOnClickListener(this);
        this.igH.setOnClickListener(this);
        this.igJ = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        bYp();
        bYo();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.igG.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.igG.setLayoutParams(layoutParams);
        this.igK.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.igG.a(this.igK);
        this.igI.setVisibility(8);
    }

    private void bYo() {
        this.igK = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.igG.addView(this.igK, layoutParams);
        this.igK.setTextColor(this.igI.getCurrentChooseColor());
        this.igK.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.igK.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.igK.getEditText());
                }
            }
        });
    }

    private void bYp() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.hLx.getPicUrl();
            gifInfo.mDynamicUrl = this.hLx.getPicUrl();
            gifInfo.mStaticUrl = this.hLx.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.hLx.getPicUrl(), 10, true);
            c.fT().a(this.hLx.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.drawImageTo(EmotionEditActivity.this.mImageView);
                            EmotionEditActivity.this.mImageView = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.mImageView).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.hLx.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.hLx.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.hLx.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.hLx.getWidth();
        this.mImageHeight = this.hLx.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.igJ;
            this.mImageHeight = this.igJ;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.igJ / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.igJ;
        } else {
            this.mImageWidth = (int) ((this.igJ / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.igJ;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.igG.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gmq) {
            finish();
        } else if (view == this.igH) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.igK.getEditText());
        }
    }

    private void send() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new a();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.igO) {
            this.igL.setCancel(false);
            this.igO = true;
            this.igS = System.currentTimeMillis();
            this.fUF.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.igK.getEditText());
            if (TextUtils.isEmpty(this.igK.getText())) {
                this.igN = this.hLx;
                bYt();
                return;
            }
            String text = this.igK.getText();
            switch (this.igQ) {
                case 2:
                    if (!TextUtils.isEmpty(this.igP) && this.igP.equals(text)) {
                        bYv();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.igP) && this.igP.equals(text) && !TextUtils.isEmpty(this.igM)) {
                        Bp(this.igM);
                        return;
                    }
                    break;
            }
            bYq();
            this.igP = this.igK.getText();
            bYr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYq() {
        if (this.igR != null && !this.igR.isRecycled()) {
            this.igR.recycle();
            this.igR = null;
        }
    }

    private void bYr() {
        this.igL.Br(this.igK.getText());
    }

    private void bYs() {
        if (!this.igL.isCancel()) {
            this.igK.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.igL.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.igL.isCancel()) {
                        Bitmap z = z(bdImage.getRawBitmap());
                        if (z != null) {
                            this.igL.b(z, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.igQ = 2;
                        bpL();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.igQ = 2;
                bpL();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.igM)) {
            bpL();
        } else {
            this.igL.aq(this.igM, true);
        }
    }

    private void bYt() {
        if (!this.igL.isCancel()) {
            this.igQ = 0;
            bpL();
            if (this.igN != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.igN);
                setResult(-1, intent);
                finish();
                bYu();
                if (!TextUtils.isEmpty(this.igM)) {
                    File file = new File(this.igM);
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

    private void bYu() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.O("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.O("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.igK.getText())) {
            anVar.O("obj_type", 1);
        } else {
            anVar.O("obj_type", 2);
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
        if (!TextUtils.isEmpty(this.igK.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cb = cb(width, height);
            if (cb != null) {
                canvas.drawBitmap(cb, (width * this.igK.getLeft()) / i, (height * this.igK.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cb(int i, int i2) {
        if (this.igR != null) {
            return this.igR;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.igK.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.igK.getTextView().getDrawingCache();
        this.igR = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.igR = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.igR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.igI.setVisibility(0);
            this.igK.bYP();
            return;
        }
        this.igI.setVisibility(8);
        this.igK.bYO();
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
        am.setImageResource(this.gmq, R.drawable.icon_emotion_close_n);
        am.setViewTextColor(this.igH, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bYq();
        if (this.igL != null) {
            this.igL.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bYv() {
        bYs();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Bo(String str) {
        showToast(str);
        this.igQ = 1;
        bpL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpL() {
        this.igK.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.fUF.setDialogVisiable(false);
        this.igO = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Bp(String str) {
        this.igK.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bpL();
        } else if (!new File(str).exists()) {
            bpL();
        } else {
            this.igM = str;
            this.igQ = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.igS) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.igN = new EmotionImageData();
                this.igN.setPicId(uploadedPicInfo.getPic_id());
                this.igN.setWidth(uploadedPicInfo.getWidth());
                this.igN.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.hLx.getMemeContSign())) {
                    this.igN.setMemeContSign(this.hLx.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.igN.setPicUrl(picinfo.originPic.picUrl);
                    this.igN.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.igN.setMemeText(this.igK.getText());
                this.igN.setAuthorNameShow(this.hLx.getAuthorNameShow());
                bYt();
                return;
            }
            showToast(R.string.upload_error);
            this.igQ = 3;
            bpL();
            return;
        }
        showToast(R.string.upload_error);
        this.igQ = 3;
        bpL();
    }
}
