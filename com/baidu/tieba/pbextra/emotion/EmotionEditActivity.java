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
    private b fVw;
    private ImageView gnh;
    private EmotionImageData hMo;
    private int ihA;
    private EmotionEditText ihB;
    private EmotionEditModel ihC;
    private String ihD;
    private EmotionImageData ihE;
    private boolean ihF;
    private String ihG;
    private int ihH = 0;
    private Bitmap ihI;
    private long ihJ;
    private EmotionEditLayout ihx;
    private View ihy;
    private ChooseColorLayout ihz;
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
        this.hMo = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.ihC = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.fVw = new b(getPageContext());
        this.fVw.setTipString(R.string.emotion_composition);
        this.fVw.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.ihC.setCancel(true);
                EmotionEditActivity.this.bYs();
                EmotionEditActivity.this.bpN();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.ihx = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.gnh = (ImageView) findViewById(R.id.close);
        this.ihy = findViewById(R.id.send);
        this.ihz = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.ihz.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void xg(int i) {
                EmotionEditActivity.this.ihB.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.gnh.setOnClickListener(this);
        this.ihy.setOnClickListener(this);
        this.ihA = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        bYr();
        bYq();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ihx.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.ihx.setLayoutParams(layoutParams);
        this.ihB.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.ihx.a(this.ihB);
        this.ihz.setVisibility(8);
    }

    private void bYq() {
        this.ihB = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.ihx.addView(this.ihB, layoutParams);
        this.ihB.setTextColor(this.ihz.getCurrentChooseColor());
        this.ihB.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.ihB.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.ihB.getEditText());
                }
            }
        });
    }

    private void bYr() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.hMo.getPicUrl();
            gifInfo.mDynamicUrl = this.hMo.getPicUrl();
            gifInfo.mStaticUrl = this.hMo.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.hMo.getPicUrl(), 10, true);
            c.fT().a(this.hMo.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.hMo.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.hMo.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.hMo.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.hMo.getWidth();
        this.mImageHeight = this.hMo.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.ihA;
            this.mImageHeight = this.ihA;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.ihA / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.ihA;
        } else {
            this.mImageWidth = (int) ((this.ihA / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.ihA;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.ihx.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gnh) {
            finish();
        } else if (view == this.ihy) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.ihB.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.ihF) {
            this.ihC.setCancel(false);
            this.ihF = true;
            this.ihJ = System.currentTimeMillis();
            this.fVw.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.ihB.getEditText());
            if (TextUtils.isEmpty(this.ihB.getText())) {
                this.ihE = this.hMo;
                bYv();
                return;
            }
            String text = this.ihB.getText();
            switch (this.ihH) {
                case 2:
                    if (!TextUtils.isEmpty(this.ihG) && this.ihG.equals(text)) {
                        bYx();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.ihG) && this.ihG.equals(text) && !TextUtils.isEmpty(this.ihD)) {
                        Bp(this.ihD);
                        return;
                    }
                    break;
            }
            bYs();
            this.ihG = this.ihB.getText();
            bYt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYs() {
        if (this.ihI != null && !this.ihI.isRecycled()) {
            this.ihI.recycle();
            this.ihI = null;
        }
    }

    private void bYt() {
        this.ihC.Br(this.ihB.getText());
    }

    private void bYu() {
        if (!this.ihC.isCancel()) {
            this.ihB.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.ihC.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.ihC.isCancel()) {
                        Bitmap z = z(bdImage.getRawBitmap());
                        if (z != null) {
                            this.ihC.b(z, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.ihH = 2;
                        bpN();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.ihH = 2;
                bpN();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.ihD)) {
            bpN();
        } else {
            this.ihC.aq(this.ihD, true);
        }
    }

    private void bYv() {
        if (!this.ihC.isCancel()) {
            this.ihH = 0;
            bpN();
            if (this.ihE != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.ihE);
                setResult(-1, intent);
                finish();
                bYw();
                if (!TextUtils.isEmpty(this.ihD)) {
                    File file = new File(this.ihD);
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

    private void bYw() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.O("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.O("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.ihB.getText())) {
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
        if (!TextUtils.isEmpty(this.ihB.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cd = cd(width, height);
            if (cd != null) {
                canvas.drawBitmap(cd, (width * this.ihB.getLeft()) / i, (height * this.ihB.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cd(int i, int i2) {
        if (this.ihI != null) {
            return this.ihI;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.ihB.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.ihB.getTextView().getDrawingCache();
        this.ihI = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.ihI = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.ihI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.ihz.setVisibility(0);
            this.ihB.bYR();
            return;
        }
        this.ihz.setVisibility(8);
        this.ihB.bYQ();
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
        am.setImageResource(this.gnh, R.drawable.icon_emotion_close_n);
        am.setViewTextColor(this.ihy, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bYs();
        if (this.ihC != null) {
            this.ihC.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bYx() {
        bYu();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Bo(String str) {
        showToast(str);
        this.ihH = 1;
        bpN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpN() {
        this.ihB.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.fVw.setDialogVisiable(false);
        this.ihF = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Bp(String str) {
        this.ihB.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bpN();
        } else if (!new File(str).exists()) {
            bpN();
        } else {
            this.ihD = str;
            this.ihH = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.ihJ) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.ihE = new EmotionImageData();
                this.ihE.setPicId(uploadedPicInfo.getPic_id());
                this.ihE.setWidth(uploadedPicInfo.getWidth());
                this.ihE.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.hMo.getMemeContSign())) {
                    this.ihE.setMemeContSign(this.hMo.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.ihE.setPicUrl(picinfo.originPic.picUrl);
                    this.ihE.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.ihE.setMemeText(this.ihB.getText());
                this.ihE.setAuthorNameShow(this.hMo.getAuthorNameShow());
                bYv();
                return;
            }
            showToast(R.string.upload_error);
            this.ihH = 3;
            bpN();
            return;
        }
        showToast(R.string.upload_error);
        this.ihH = 3;
        bpN();
    }
}
