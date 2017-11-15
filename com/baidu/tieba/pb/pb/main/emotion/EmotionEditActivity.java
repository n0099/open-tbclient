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
    private EmotionEditLayout eUW;
    private EmotionImageData eUX;
    private ImageView eUY;
    private View eUZ;
    private ChooseColorLayout eVa;
    private int eVb;
    private com.baidu.tieba.pb.pb.main.emotion.view.b eVc;
    private EmotionEditModel eVd;
    private String eVe;
    private EmotionImageData eVf;
    private boolean eVg;
    private String eVh;
    private int eVi = 0;
    private com.baidu.tbadk.core.view.a eVj;
    private Bitmap eVk;
    private long eVl;
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
        this.eUX = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.aiB = getIntent().getStringExtra("from");
        initView();
        this.eVd = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0080d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eVj = new com.baidu.tbadk.core.view.a(getPageContext());
        this.eVj.da(d.j.emotion_composition);
        this.eVj.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.eVd.jC(true);
                EmotionEditActivity.this.aVs();
                EmotionEditActivity.this.aox();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_layout);
        this.eUW = (EmotionEditLayout) findViewById(d.g.edit_container);
        this.eUY = (ImageView) findViewById(d.g.close);
        this.eUZ = findViewById(d.g.send);
        this.eVa = (ChooseColorLayout) findViewById(d.g.choose_color_layout);
        this.eVa.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.a
            public void pR(int i) {
                EmotionEditActivity.this.eVc.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.eUY.setOnClickListener(this);
        this.eUZ.setOnClickListener(this);
        this.eVb = l.ac(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds300);
        aVr();
        aVq();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eUW.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        this.eUW.setLayoutParams(layoutParams);
        this.eVc.bw(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.eUW.a(this.eVc);
        this.eVa.setVisibility(8);
    }

    private void aVq() {
        this.eVc = new com.baidu.tieba.pb.pb.main.emotion.view.b(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.eUW.addView(this.eVc, layoutParams);
        this.eVc.setTextColor(this.eVa.getCurrentChooseColor());
        this.eVc.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eVc.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eVc.getEditText());
                }
            }
        });
    }

    private void aVr() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.eUX.getPicUrl();
            gifInfo.mDynamicUrl = this.eUX.getPicUrl();
            gifInfo.mStaticUrl = this.eUX.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.eUX.getPicUrl(), 10, true);
            com.baidu.adp.lib.f.c.fJ().a(this.eUX.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.eUX.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.eUX.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.eUX.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.eUX.getWidth();
        this.mImageHeight = this.eUX.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.eVb;
            this.mImageHeight = this.eVb;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.eVb / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.eVb;
        } else {
            this.mImageWidth = (int) ((this.eVb / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.eVb;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.eUW.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eUY) {
            finish();
        } else if (view == this.eUZ) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.eVc.getEditText());
        }
    }

    private void send() {
        if (!j.hh()) {
            showToast(d.j.neterror);
        } else if (!this.eVg) {
            this.eVd.jC(false);
            this.eVg = true;
            this.eVl = System.currentTimeMillis();
            this.eVj.aE(true);
            HidenSoftKeyPad(this.mInputManager, this.eVc.getEditText());
            if (TextUtils.isEmpty(this.eVc.getText())) {
                this.eVf = this.eUX;
                aVv();
                return;
            }
            String text = this.eVc.getText();
            switch (this.eVi) {
                case 2:
                    if (!TextUtils.isEmpty(this.eVh) && this.eVh.equals(text)) {
                        aVx();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.eVh) && this.eVh.equals(text) && !TextUtils.isEmpty(this.eVe)) {
                        pL(this.eVe);
                        return;
                    }
                    break;
            }
            aVs();
            this.eVh = this.eVc.getText();
            aVt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVs() {
        if (this.eVk != null && !this.eVk.isRecycled()) {
            this.eVk.recycle();
            this.eVk = null;
        }
    }

    private void aVt() {
        this.eVd.pO(this.eVc.getText());
    }

    private void aVu() {
        if (!this.eVd.fq()) {
            this.eVc.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.C0080d.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.eVd.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.a.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.eVd.fq()) {
                        Bitmap j = j(bdImage.kK());
                        if (j != null) {
                            this.eVd.b(j, f.xT + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.j.upload_error);
                        this.eVi = 2;
                        aox();
                        return;
                    }
                    return;
                }
                showToast(d.j.upload_error);
                this.eVi = 2;
                aox();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.eVe)) {
            aox();
        } else {
            this.eVd.Q(this.eVe, true);
        }
    }

    private void aVv() {
        if (!this.eVd.fq()) {
            this.eVi = 0;
            aox();
            if (this.eVf != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.eVf);
                setResult(-1, intent);
                finish();
                aVw();
                if (!TextUtils.isEmpty(this.eVe)) {
                    File file = new File(this.eVe);
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

    private void aVw() {
        ak akVar = new ak("c12329");
        if (!TextUtils.isEmpty(this.aiB)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.aiB)) {
                akVar.r("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.aiB)) {
                akVar.r("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.eVc.getText())) {
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
        if (!TextUtils.isEmpty(this.eVc.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bv = bv(width, height);
            if (bv != null) {
                canvas.drawBitmap(bv, (width * this.eVc.getLeft()) / i, (height * this.eVc.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bv(int i, int i2) {
        if (this.eVk != null) {
            return this.eVk;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.eVc.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.eVc.getTextView().getDrawingCache();
        this.eVk = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.eVk = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.eVk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.eVa.setVisibility(0);
            this.eVc.aVV();
            return;
        }
        this.eVa.setVisibility(8);
        this.eVc.aVU();
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
        aj.c(this.eUY, d.f.icon_emotion_close_n);
        aj.i(this.eUZ, d.C0080d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aVs();
        if (this.eVd != null) {
            this.eVd.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void aVx() {
        aVu();
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void pK(String str) {
        showToast(str);
        this.eVi = 1;
        aox();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aox() {
        this.eVc.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        this.eVj.aE(false);
        this.eVg = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void pL(String str) {
        this.eVc.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            aox();
        } else if (!new File(str).exists()) {
            aox();
        } else {
            this.eVe = str;
            this.eVi = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.eVl) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.eVf = new EmotionImageData();
                this.eVf.setPicId(uploadedPicInfo.getPic_id());
                this.eVf.setWidth(uploadedPicInfo.getWidth());
                this.eVf.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.eUX.getMemeContSign())) {
                    this.eVf.setMemeContSign(this.eUX.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.eVf.setPicUrl(picinfo.originPic.picUrl);
                    this.eVf.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.eVf.setMemeText(this.eVc.getText());
                this.eVf.setAuthorNameShow(this.eUX.getAuthorNameShow());
                aVv();
                return;
            }
            showToast(d.j.upload_error);
            this.eVi = 3;
            aox();
            return;
        }
        showToast(d.j.upload_error);
        this.eVi = 3;
        aox();
    }
}
