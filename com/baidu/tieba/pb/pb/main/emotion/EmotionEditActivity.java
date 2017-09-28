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
    private String aiq;
    private ImageView bws;
    private EmotionEditLayout eLW;
    private EmotionImageData eLX;
    private View eLY;
    private ChooseColorLayout eLZ;
    private int eMa;
    private com.baidu.tieba.pb.pb.main.emotion.view.b eMb;
    private EmotionEditModel eMc;
    private String eMd;
    private EmotionImageData eMe;
    private boolean eMf;
    private String eMg;
    private int eMh = 0;
    private com.baidu.tbadk.core.view.a eMi;
    private Bitmap eMj;
    private long eMk;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private View mRootView;
    private boolean rx;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.j.emotion_edit_activity);
        this.eLX = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.rx = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.aiq = getIntent().getStringExtra("from");
        initView();
        this.eMc = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.e.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eMi = new com.baidu.tbadk.core.view.a(getPageContext());
        this.eMi.db(d.l.emotion_composition);
        this.eMi.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.eMc.jD(true);
                EmotionEditActivity.this.aSb();
                EmotionEditActivity.this.alC();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.h.root_layout);
        this.eLW = (EmotionEditLayout) findViewById(d.h.edit_container);
        this.bws = (ImageView) findViewById(d.h.close);
        this.eLY = findViewById(d.h.send);
        this.eLZ = (ChooseColorLayout) findViewById(d.h.choose_color_layout);
        this.eLZ.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.a
            public void px(int i) {
                EmotionEditActivity.this.eMb.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.bws.setOnClickListener(this);
        this.eLY.setOnClickListener(this);
        this.eMa = l.ad(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds300);
        aSa();
        aRZ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eLW.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds80);
        this.eLW.setLayoutParams(layoutParams);
        this.eMb.bv(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40));
        this.eLW.a(this.eMb);
        this.eLZ.setVisibility(8);
    }

    private void aRZ() {
        this.eMb = new com.baidu.tieba.pb.pb.main.emotion.view.b(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40));
        this.eLW.addView(this.eMb, layoutParams);
        this.eMb.setTextColor(this.eLZ.getCurrentChooseColor());
        this.eMb.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eMb.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eMb.getEditText());
                }
            }
        });
    }

    private void aSa() {
        if (this.rx) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.eLX.getPicUrl();
            gifInfo.mDynamicUrl = this.eLX.getPicUrl();
            gifInfo.mStaticUrl = this.eLX.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).c(this.eLX.getPicUrl(), 10, true);
            com.baidu.adp.lib.f.c.fJ().a(this.eLX.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.rx = aVar.isGif();
                        if (EmotionEditActivity.this.rx) {
                            aVar.a(EmotionEditActivity.this.mImageView);
                            EmotionEditActivity.this.mImageView = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.mImageView).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.eLX.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.eLX.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.eLX.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.eLX.getWidth();
        this.mImageHeight = this.eLX.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.eMa;
            this.mImageHeight = this.eMa;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.eMa / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.eMa;
        } else {
            this.mImageWidth = (int) ((this.eMa / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.eMa;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.eLW.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bws) {
            finish();
        } else if (view == this.eLY) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.eMb.getEditText());
        }
    }

    private void send() {
        if (!j.hh()) {
            showToast(d.l.neterror);
        } else if (!this.eMf) {
            this.eMc.jD(false);
            this.eMf = true;
            this.eMk = System.currentTimeMillis();
            this.eMi.aH(true);
            HidenSoftKeyPad(this.mInputManager, this.eMb.getEditText());
            if (TextUtils.isEmpty(this.eMb.getText())) {
                this.eMe = this.eLX;
                aSe();
                return;
            }
            String text = this.eMb.getText();
            switch (this.eMh) {
                case 2:
                    if (!TextUtils.isEmpty(this.eMg) && this.eMg.equals(text)) {
                        aSg();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.eMg) && this.eMg.equals(text) && !TextUtils.isEmpty(this.eMd)) {
                        pd(this.eMd);
                        return;
                    }
                    break;
            }
            aSb();
            this.eMg = this.eMb.getText();
            aSc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSb() {
        if (this.eMj != null && !this.eMj.isRecycled()) {
            this.eMj.recycle();
            this.eMj = null;
        }
    }

    private void aSc() {
        this.eMc.pg(this.eMb.getText());
    }

    private void aSd() {
        if (!this.eMc.fq()) {
            this.eMb.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.e.transparent));
            if (this.rx) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.eMc.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.eMc.fq()) {
                        Bitmap j = j(bdImage.kN());
                        if (j != null) {
                            this.eMc.b(j, f.xS + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.l.upload_error);
                        this.eMh = 2;
                        alC();
                        return;
                    }
                    return;
                }
                showToast(d.l.upload_error);
                this.eMh = 2;
                alC();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.eMd)) {
            alC();
        } else {
            this.eMc.S(this.eMd, true);
        }
    }

    private void aSe() {
        if (!this.eMc.fq()) {
            this.eMh = 0;
            alC();
            if (this.eMe != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.eMe);
                setResult(-1, intent);
                finish();
                aSf();
                if (!TextUtils.isEmpty(this.eMd)) {
                    File file = new File(this.eMd);
                    if (file.exists()) {
                        file.delete();
                        return;
                    }
                    return;
                }
                return;
            }
            showToast(d.l.upload_error);
        }
    }

    private void aSf() {
        ak akVar = new ak("c12329");
        if (!TextUtils.isEmpty(this.aiq)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.aiq)) {
                akVar.r("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.aiq)) {
                akVar.r("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.eMb.getText())) {
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
        if (!this.rx) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / width, i2 / height);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.rx ? width : i, this.rx ? height : i2, config);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        if (!TextUtils.isEmpty(this.eMb.getText())) {
            if (!this.rx) {
                height = i2;
                width = i;
            }
            Bitmap bu = bu(width, height);
            if (bu != null) {
                canvas.drawBitmap(bu, (width * this.eMb.getLeft()) / i, (height * this.eMb.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bu(int i, int i2) {
        if (this.eMj != null) {
            return this.eMj;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.eMb.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.eMb.getTextView().getDrawingCache();
        this.eMj = drawingCache;
        if (this.rx) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.eMj = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.eMj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.eLZ.setVisibility(0);
            this.eMb.aSE();
            return;
        }
        this.eLZ.setVisibility(8);
        this.eMb.aSD();
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
        aj.k(this.mRootView, d.e.black_alpha40);
        aj.c(this.bws, d.g.icon_emotion_close_n);
        aj.i(this.eLY, d.e.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aSb();
        if (this.eMc != null) {
            this.eMc.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void aSg() {
        aSd();
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void pc(String str) {
        showToast(str);
        this.eMh = 1;
        alC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alC() {
        this.eMb.getTextView().setBackgroundResource(d.g.bg_emotion_edit);
        this.eMi.aH(false);
        this.eMf = false;
        if (this.rx) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void pd(String str) {
        this.eMb.getTextView().setBackgroundResource(d.g.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            alC();
        } else if (!new File(str).exists()) {
            alC();
        } else {
            this.eMd = str;
            this.eMh = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.eMk) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.eMe = new EmotionImageData();
                this.eMe.setPicId(uploadedPicInfo.getPic_id());
                this.eMe.setWidth(uploadedPicInfo.getWidth());
                this.eMe.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.eLX.getMemeContSign())) {
                    this.eMe.setMemeContSign(this.eLX.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.eMe.setPicUrl(picinfo.originPic.picUrl);
                    this.eMe.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.eMe.setMemeText(this.eMb.getText());
                this.eMe.setAuthorNameShow(this.eLX.getAuthorNameShow());
                aSe();
                return;
            }
            showToast(d.l.upload_error);
            this.eMh = 3;
            alC();
            return;
        }
        showToast(d.l.upload_error);
        this.eMh = 3;
        alC();
    }
}
