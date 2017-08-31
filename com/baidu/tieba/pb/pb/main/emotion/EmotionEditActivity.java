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
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.e;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
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
    private String aiP;
    private ImageView btT;
    private EmotionImageData eRA;
    private boolean eRB;
    private String eRC;
    private int eRD = 0;
    private com.baidu.tbadk.core.view.a eRE;
    private Bitmap eRF;
    private long eRG;
    private EmotionEditLayout eRs;
    private EmotionImageData eRt;
    private View eRu;
    private ChooseColorLayout eRv;
    private int eRw;
    private com.baidu.tieba.pb.pb.main.emotion.view.b eRx;
    private EmotionEditModel eRy;
    private String eRz;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private View mRootView;
    private boolean rw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.j.emotion_edit_activity);
        this.eRt = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.rw = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.aiP = getIntent().getStringExtra("from");
        initView();
        this.eRy = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.e.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eRE = new com.baidu.tbadk.core.view.a(getPageContext());
        this.eRE.dd(d.l.emotion_composition);
        this.eRE.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.eRy.jP(true);
                EmotionEditActivity.this.aTH();
                EmotionEditActivity.this.aln();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.h.root_layout);
        this.eRs = (EmotionEditLayout) findViewById(d.h.edit_container);
        this.btT = (ImageView) findViewById(d.h.close);
        this.eRu = findViewById(d.h.send);
        this.eRv = (ChooseColorLayout) findViewById(d.h.choose_color_layout);
        this.eRv.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.a
            public void pz(int i) {
                EmotionEditActivity.this.eRx.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.btT.setOnClickListener(this);
        this.eRu.setOnClickListener(this);
        this.eRw = k.ad(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds300);
        aTG();
        aTF();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRs.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds80);
        this.eRs.setLayoutParams(layoutParams);
        this.eRx.bk(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40));
        this.eRs.a(this.eRx);
        this.eRv.setVisibility(8);
    }

    private void aTF() {
        this.eRx = new com.baidu.tieba.pb.pb.main.emotion.view.b(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40));
        this.eRs.addView(this.eRx, layoutParams);
        this.eRx.setTextColor(this.eRv.getCurrentChooseColor());
        this.eRx.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eRx.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eRx.getEditText());
                }
            }
        });
    }

    private void aTG() {
        if (this.rw) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.eRt.getPicUrl();
            gifInfo.mDynamicUrl = this.eRt.getPicUrl();
            gifInfo.mStaticUrl = this.eRt.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).c(this.eRt.getPicUrl(), 10, true);
            c.fK().a(this.eRt.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.rw = aVar.isGif();
                        if (EmotionEditActivity.this.rw) {
                            aVar.a(EmotionEditActivity.this.mImageView);
                            EmotionEditActivity.this.mImageView = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.mImageView).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.eRt.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.eRt.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.eRt.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.eRt.getWidth();
        this.mImageHeight = this.eRt.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.eRw;
            this.mImageHeight = this.eRw;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.eRw / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.eRw;
        } else {
            this.mImageWidth = (int) ((this.eRw / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.eRw;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.eRs.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.btT) {
            finish();
        } else if (view == this.eRu) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.eRx.getEditText());
        }
    }

    private void send() {
        if (!i.hi()) {
            showToast(d.l.neterror);
        } else if (!this.eRB) {
            this.eRy.jP(false);
            this.eRB = true;
            this.eRG = System.currentTimeMillis();
            this.eRE.aH(true);
            HidenSoftKeyPad(this.mInputManager, this.eRx.getEditText());
            if (TextUtils.isEmpty(this.eRx.getText())) {
                this.eRA = this.eRt;
                aTK();
                return;
            }
            String text = this.eRx.getText();
            switch (this.eRD) {
                case 2:
                    if (!TextUtils.isEmpty(this.eRC) && this.eRC.equals(text)) {
                        aTM();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.eRC) && this.eRC.equals(text) && !TextUtils.isEmpty(this.eRz)) {
                        px(this.eRz);
                        return;
                    }
                    break;
            }
            aTH();
            this.eRC = this.eRx.getText();
            aTI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTH() {
        if (this.eRF != null && !this.eRF.isRecycled()) {
            this.eRF.recycle();
            this.eRF = null;
        }
    }

    private void aTI() {
        this.eRy.py(this.eRx.getText());
    }

    private void aTJ() {
        if (!this.eRy.fs()) {
            this.eRx.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.e.transparent));
            if (this.rw) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.eRy.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.a.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.eRy.fs()) {
                        Bitmap h = h(bdImage.kO());
                        if (h != null) {
                            this.eRy.b(h, e.xQ + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.l.upload_error);
                        this.eRD = 2;
                        aln();
                        return;
                    }
                    return;
                }
                showToast(d.l.upload_error);
                this.eRD = 2;
                aln();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.eRz)) {
            aln();
        } else {
            this.eRy.V(this.eRz, true);
        }
    }

    private void aTK() {
        if (!this.eRy.fs()) {
            this.eRD = 0;
            aln();
            if (this.eRA != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.eRA);
                setResult(-1, intent);
                finish();
                aTL();
                if (!TextUtils.isEmpty(this.eRz)) {
                    File file = new File(this.eRz);
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

    private void aTL() {
        ak akVar = new ak("c12329");
        if (!TextUtils.isEmpty(this.aiP)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.aiP)) {
                akVar.r("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.aiP)) {
                akVar.r("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.eRx.getText())) {
            akVar.r("obj_type", 1);
        } else {
            akVar.r("obj_type", 2);
        }
        TiebaStatic.log(akVar);
    }

    public Bitmap h(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int i = this.mImageWidth;
        int i2 = this.mImageHeight;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (!this.rw) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / width, i2 / height);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.rw ? width : i, this.rw ? height : i2, config);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        if (!TextUtils.isEmpty(this.eRx.getText())) {
            if (!this.rw) {
                height = i2;
                width = i;
            }
            Bitmap bj = bj(width, height);
            if (bj != null) {
                canvas.drawBitmap(bj, (width * this.eRx.getLeft()) / i, (height * this.eRx.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bj(int i, int i2) {
        if (this.eRF != null) {
            return this.eRF;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.eRx.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.eRx.getTextView().getDrawingCache();
        this.eRF = drawingCache;
        if (this.rw) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.eRF = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.eRF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.eRv.setVisibility(0);
            this.eRx.aUk();
            return;
        }
        this.eRv.setVisibility(8);
        this.eRx.aUj();
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
        aj.c(this.btT, d.g.icon_emotion_close_n);
        aj.i(this.eRu, d.e.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aTH();
        if (this.eRy != null) {
            this.eRy.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void aTM() {
        aTJ();
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void pw(String str) {
        showToast(str);
        this.eRD = 1;
        aln();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aln() {
        this.eRx.getTextView().setBackgroundResource(d.g.bg_emotion_edit);
        this.eRE.aH(false);
        this.eRB = false;
        if (this.rw) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void px(String str) {
        this.eRx.getTextView().setBackgroundResource(d.g.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            aln();
        } else if (!new File(str).exists()) {
            aln();
        } else {
            this.eRz = str;
            this.eRD = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.eRG) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void d(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.eRA = new EmotionImageData();
                this.eRA.setPicId(uploadedPicInfo.getPic_id());
                this.eRA.setWidth(uploadedPicInfo.getWidth());
                this.eRA.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.eRt.getMemeContSign())) {
                    this.eRA.setMemeContSign(this.eRt.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.eRA.setPicUrl(picinfo.originPic.picUrl);
                    this.eRA.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.eRA.setMemeText(this.eRx.getText());
                aTK();
                return;
            }
            showToast(d.l.upload_error);
            this.eRD = 3;
            aln();
            return;
        }
        showToast(d.l.upload_error);
        this.eRD = 3;
        aln();
    }
}
