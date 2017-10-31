package com.baidu.tieba.pb.pb.main.emotion;

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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel;
import com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout;
import com.baidu.tieba.pb.pb.main.emotion.view.EmotionEditLayout;
import java.io.File;
/* loaded from: classes.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private String aiB;
    private EmotionEditLayout eUB;
    private EmotionImageData eUC;
    private ImageView eUD;
    private View eUE;
    private ChooseColorLayout eUF;
    private int eUG;
    private com.baidu.tieba.pb.pb.main.emotion.view.b eUH;
    private EmotionEditModel eUI;
    private String eUJ;
    private EmotionImageData eUK;
    private boolean eUL;
    private String eUM;
    private int eUN = 0;
    private com.baidu.tbadk.core.view.a eUO;
    private Bitmap eUP;
    private long eUQ;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.h.emotion_edit_activity);
        this.eUC = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.aiB = getIntent().getStringExtra("from");
        initView();
        this.eUI = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0080d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eUO = new com.baidu.tbadk.core.view.a(getPageContext());
        this.eUO.db(d.j.emotion_composition);
        this.eUO.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.eUI.jw(true);
                EmotionEditActivity.this.aVk();
                EmotionEditActivity.this.aoi();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_layout);
        this.eUB = (EmotionEditLayout) findViewById(d.g.edit_container);
        this.eUD = (ImageView) findViewById(d.g.close);
        this.eUE = findViewById(d.g.send);
        this.eUF = (ChooseColorLayout) findViewById(d.g.choose_color_layout);
        this.eUF.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.a
            public void pQ(int i) {
                EmotionEditActivity.this.eUH.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.eUD.setOnClickListener(this);
        this.eUE.setOnClickListener(this);
        this.eUG = l.ac(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds300);
        aVj();
        aVi();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eUB.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        this.eUB.setLayoutParams(layoutParams);
        this.eUH.bx(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.eUB.a(this.eUH);
        this.eUF.setVisibility(8);
    }

    private void aVi() {
        this.eUH = new com.baidu.tieba.pb.pb.main.emotion.view.b(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.eUB.addView(this.eUH, layoutParams);
        this.eUH.setTextColor(this.eUF.getCurrentChooseColor());
        this.eUH.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eUH.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eUH.getEditText());
                }
            }
        });
    }

    private void aVj() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.eUC.getPicUrl();
            gifInfo.mDynamicUrl = this.eUC.getPicUrl();
            gifInfo.mStaticUrl = this.eUC.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.eUC.getPicUrl(), 10, true);
            com.baidu.adp.lib.f.c.fJ().a(this.eUC.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.mImageView);
                            EmotionEditActivity.this.mImageView = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.mImageView).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.eUC.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.eUC.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.eUC.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.eUC.getWidth();
        this.mImageHeight = this.eUC.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.eUG;
            this.mImageHeight = this.eUG;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.eUG / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.eUG;
        } else {
            this.mImageWidth = (int) ((this.eUG / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.eUG;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.eUB.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eUD) {
            finish();
        } else if (view == this.eUE) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.eUH.getEditText());
        }
    }

    private void send() {
        if (!j.hh()) {
            showToast(d.j.neterror);
        } else if (!this.eUL) {
            this.eUI.jw(false);
            this.eUL = true;
            this.eUQ = System.currentTimeMillis();
            this.eUO.aE(true);
            HidenSoftKeyPad(this.mInputManager, this.eUH.getEditText());
            if (TextUtils.isEmpty(this.eUH.getText())) {
                this.eUK = this.eUC;
                aVn();
                return;
            }
            String text = this.eUH.getText();
            switch (this.eUN) {
                case 2:
                    if (!TextUtils.isEmpty(this.eUM) && this.eUM.equals(text)) {
                        aVp();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.eUM) && this.eUM.equals(text) && !TextUtils.isEmpty(this.eUJ)) {
                        pH(this.eUJ);
                        return;
                    }
                    break;
            }
            aVk();
            this.eUM = this.eUH.getText();
            aVl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVk() {
        if (this.eUP != null && !this.eUP.isRecycled()) {
            this.eUP.recycle();
            this.eUP = null;
        }
    }

    private void aVl() {
        this.eUI.pK(this.eUH.getText());
    }

    private void aVm() {
        if (!this.eUI.fq()) {
            this.eUH.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.C0080d.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.eUI.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.a.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.eUI.fq()) {
                        Bitmap j = j(bdImage.kK());
                        if (j != null) {
                            this.eUI.b(j, f.xT + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.j.upload_error);
                        this.eUN = 2;
                        aoi();
                        return;
                    }
                    return;
                }
                showToast(d.j.upload_error);
                this.eUN = 2;
                aoi();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.eUJ)) {
            aoi();
        } else {
            this.eUI.Q(this.eUJ, true);
        }
    }

    private void aVn() {
        if (!this.eUI.fq()) {
            this.eUN = 0;
            aoi();
            if (this.eUK != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.eUK);
                setResult(-1, intent);
                finish();
                aVo();
                if (!TextUtils.isEmpty(this.eUJ)) {
                    File file = new File(this.eUJ);
                    if (file.exists()) {
                        file.delete();
                        return;
                    }
                    return;
                }
                return;
            }
            showToast(d.j.upload_error);
        }
    }

    private void aVo() {
        ak akVar = new ak("c12329");
        if (!TextUtils.isEmpty(this.aiB)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.aiB)) {
                akVar.r("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.aiB)) {
                akVar.r("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.eUH.getText())) {
            akVar.r("obj_type", 1);
        } else {
            akVar.r("obj_type", 2);
        }
        TiebaStatic.log(akVar);
    }

    public Bitmap j(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.eUH.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bw = bw(width, height);
            if (bw != null) {
                canvas.drawBitmap(bw, (width * this.eUH.getLeft()) / i, (height * this.eUH.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bw(int i, int i2) {
        if (this.eUP != null) {
            return this.eUP;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.eUH.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.eUH.getTextView().getDrawingCache();
        this.eUP = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.eUP = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.eUP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.eUF.setVisibility(0);
            this.eUH.aVN();
            return;
        }
        this.eUF.setVisibility(8);
        this.eUH.aVM();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(d.a.fade_in, d.a.fade_out);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(d.a.fade_in, d.a.fade_out);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.mRootView, d.C0080d.black_alpha40);
        aj.c(this.eUD, d.f.icon_emotion_close_n);
        aj.i(this.eUE, d.C0080d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aVk();
        if (this.eUI != null) {
            this.eUI.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void aVp() {
        aVm();
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void pG(String str) {
        showToast(str);
        this.eUN = 1;
        aoi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoi() {
        this.eUH.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        this.eUO.aE(false);
        this.eUL = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void pH(String str) {
        this.eUH.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            aoi();
        } else if (!new File(str).exists()) {
            aoi();
        } else {
            this.eUJ = str;
            this.eUN = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.eUQ) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.eUK = new EmotionImageData();
                this.eUK.setPicId(uploadedPicInfo.getPic_id());
                this.eUK.setWidth(uploadedPicInfo.getWidth());
                this.eUK.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.eUC.getMemeContSign())) {
                    this.eUK.setMemeContSign(this.eUC.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.eUK.setPicUrl(picinfo.originPic.picUrl);
                    this.eUK.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.eUK.setMemeText(this.eUH.getText());
                this.eUK.setAuthorNameShow(this.eUC.getAuthorNameShow());
                aVn();
                return;
            }
            showToast(d.j.upload_error);
            this.eUN = 3;
            aoi();
            return;
        }
        showToast(d.j.upload_error);
        this.eUN = 3;
        aoi();
    }
}
