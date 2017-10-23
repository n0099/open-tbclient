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
    private String aie;
    private ImageView bwg;
    private EmotionEditLayout eLI;
    private EmotionImageData eLJ;
    private View eLK;
    private ChooseColorLayout eLL;
    private int eLM;
    private com.baidu.tieba.pb.pb.main.emotion.view.b eLN;
    private EmotionEditModel eLO;
    private String eLP;
    private EmotionImageData eLQ;
    private boolean eLR;
    private String eLS;
    private int eLT = 0;
    private com.baidu.tbadk.core.view.a eLU;
    private Bitmap eLV;
    private long eLW;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private View mRootView;
    private boolean ry;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.j.emotion_edit_activity);
        this.eLJ = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.ry = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.aie = getIntent().getStringExtra("from");
        initView();
        this.eLO = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.e.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eLU = new com.baidu.tbadk.core.view.a(getPageContext());
        this.eLU.da(d.l.emotion_composition);
        this.eLU.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.eLO.jC(true);
                EmotionEditActivity.this.aRW();
                EmotionEditActivity.this.alx();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.h.root_layout);
        this.eLI = (EmotionEditLayout) findViewById(d.h.edit_container);
        this.bwg = (ImageView) findViewById(d.h.close);
        this.eLK = findViewById(d.h.send);
        this.eLL = (ChooseColorLayout) findViewById(d.h.choose_color_layout);
        this.eLL.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.a
            public void pw(int i) {
                EmotionEditActivity.this.eLN.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.bwg.setOnClickListener(this);
        this.eLK.setOnClickListener(this);
        this.eLM = l.ad(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds300);
        aRV();
        aRU();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eLI.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds80);
        this.eLI.setLayoutParams(layoutParams);
        this.eLN.bv(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40));
        this.eLI.a(this.eLN);
        this.eLL.setVisibility(8);
    }

    private void aRU() {
        this.eLN = new com.baidu.tieba.pb.pb.main.emotion.view.b(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40));
        this.eLI.addView(this.eLN, layoutParams);
        this.eLN.setTextColor(this.eLL.getCurrentChooseColor());
        this.eLN.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eLN.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eLN.getEditText());
                }
            }
        });
    }

    private void aRV() {
        if (this.ry) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.eLJ.getPicUrl();
            gifInfo.mDynamicUrl = this.eLJ.getPicUrl();
            gifInfo.mStaticUrl = this.eLJ.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).c(this.eLJ.getPicUrl(), 10, true);
            com.baidu.adp.lib.f.c.fJ().a(this.eLJ.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.ry = aVar.isGif();
                        if (EmotionEditActivity.this.ry) {
                            aVar.a(EmotionEditActivity.this.mImageView);
                            EmotionEditActivity.this.mImageView = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.mImageView).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.eLJ.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.eLJ.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.eLJ.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.eLJ.getWidth();
        this.mImageHeight = this.eLJ.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.eLM;
            this.mImageHeight = this.eLM;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.eLM / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.eLM;
        } else {
            this.mImageWidth = (int) ((this.eLM / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.eLM;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.eLI.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bwg) {
            finish();
        } else if (view == this.eLK) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.eLN.getEditText());
        }
    }

    private void send() {
        if (!j.hh()) {
            showToast(d.l.neterror);
        } else if (!this.eLR) {
            this.eLO.jC(false);
            this.eLR = true;
            this.eLW = System.currentTimeMillis();
            this.eLU.aG(true);
            HidenSoftKeyPad(this.mInputManager, this.eLN.getEditText());
            if (TextUtils.isEmpty(this.eLN.getText())) {
                this.eLQ = this.eLJ;
                aRZ();
                return;
            }
            String text = this.eLN.getText();
            switch (this.eLT) {
                case 2:
                    if (!TextUtils.isEmpty(this.eLS) && this.eLS.equals(text)) {
                        aSb();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.eLS) && this.eLS.equals(text) && !TextUtils.isEmpty(this.eLP)) {
                        pc(this.eLP);
                        return;
                    }
                    break;
            }
            aRW();
            this.eLS = this.eLN.getText();
            aRX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRW() {
        if (this.eLV != null && !this.eLV.isRecycled()) {
            this.eLV.recycle();
            this.eLV = null;
        }
    }

    private void aRX() {
        this.eLO.pf(this.eLN.getText());
    }

    private void aRY() {
        if (!this.eLO.fq()) {
            this.eLN.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.e.transparent));
            if (this.ry) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.eLO.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.eLO.fq()) {
                        Bitmap j = j(bdImage.kN());
                        if (j != null) {
                            this.eLO.b(j, f.xT + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.l.upload_error);
                        this.eLT = 2;
                        alx();
                        return;
                    }
                    return;
                }
                showToast(d.l.upload_error);
                this.eLT = 2;
                alx();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.eLP)) {
            alx();
        } else {
            this.eLO.S(this.eLP, true);
        }
    }

    private void aRZ() {
        if (!this.eLO.fq()) {
            this.eLT = 0;
            alx();
            if (this.eLQ != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.eLQ);
                setResult(-1, intent);
                finish();
                aSa();
                if (!TextUtils.isEmpty(this.eLP)) {
                    File file = new File(this.eLP);
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

    private void aSa() {
        ak akVar = new ak("c12329");
        if (!TextUtils.isEmpty(this.aie)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.aie)) {
                akVar.r("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.aie)) {
                akVar.r("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.eLN.getText())) {
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
        if (!this.ry) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / width, i2 / height);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.ry ? width : i, this.ry ? height : i2, config);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        if (!TextUtils.isEmpty(this.eLN.getText())) {
            if (!this.ry) {
                height = i2;
                width = i;
            }
            Bitmap bu = bu(width, height);
            if (bu != null) {
                canvas.drawBitmap(bu, (width * this.eLN.getLeft()) / i, (height * this.eLN.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bu(int i, int i2) {
        if (this.eLV != null) {
            return this.eLV;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.eLN.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.eLN.getTextView().getDrawingCache();
        this.eLV = drawingCache;
        if (this.ry) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.eLV = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.eLV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.eLL.setVisibility(0);
            this.eLN.aSz();
            return;
        }
        this.eLL.setVisibility(8);
        this.eLN.aSy();
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
        aj.c(this.bwg, d.g.icon_emotion_close_n);
        aj.i(this.eLK, d.e.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aRW();
        if (this.eLO != null) {
            this.eLO.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void aSb() {
        aRY();
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void pb(String str) {
        showToast(str);
        this.eLT = 1;
        alx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alx() {
        this.eLN.getTextView().setBackgroundResource(d.g.bg_emotion_edit);
        this.eLU.aG(false);
        this.eLR = false;
        if (this.ry) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void pc(String str) {
        this.eLN.getTextView().setBackgroundResource(d.g.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            alx();
        } else if (!new File(str).exists()) {
            alx();
        } else {
            this.eLP = str;
            this.eLT = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.eLW) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.eLQ = new EmotionImageData();
                this.eLQ.setPicId(uploadedPicInfo.getPic_id());
                this.eLQ.setWidth(uploadedPicInfo.getWidth());
                this.eLQ.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.eLJ.getMemeContSign())) {
                    this.eLQ.setMemeContSign(this.eLJ.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.eLQ.setPicUrl(picinfo.originPic.picUrl);
                    this.eLQ.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.eLQ.setMemeText(this.eLN.getText());
                this.eLQ.setAuthorNameShow(this.eLJ.getAuthorNameShow());
                aRZ();
                return;
            }
            showToast(d.l.upload_error);
            this.eLT = 3;
            alx();
            return;
        }
        showToast(d.l.upload_error);
        this.eLT = 3;
        alx();
    }
}
