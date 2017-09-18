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
    private String aiO;
    private ImageView buI;
    private long eSA;
    private EmotionEditLayout eSm;
    private EmotionImageData eSn;
    private View eSo;
    private ChooseColorLayout eSp;
    private int eSq;
    private com.baidu.tieba.pb.pb.main.emotion.view.b eSr;
    private EmotionEditModel eSs;
    private String eSt;
    private EmotionImageData eSu;
    private boolean eSv;
    private String eSw;
    private int eSx = 0;
    private com.baidu.tbadk.core.view.a eSy;
    private Bitmap eSz;
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
        this.eSn = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.rw = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.aiO = getIntent().getStringExtra("from");
        initView();
        this.eSs = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.e.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eSy = new com.baidu.tbadk.core.view.a(getPageContext());
        this.eSy.dd(d.l.emotion_composition);
        this.eSy.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.eSs.jQ(true);
                EmotionEditActivity.this.aTS();
                EmotionEditActivity.this.aly();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.h.root_layout);
        this.eSm = (EmotionEditLayout) findViewById(d.h.edit_container);
        this.buI = (ImageView) findViewById(d.h.close);
        this.eSo = findViewById(d.h.send);
        this.eSp = (ChooseColorLayout) findViewById(d.h.choose_color_layout);
        this.eSp.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.a
            public void pB(int i) {
                EmotionEditActivity.this.eSr.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.buI.setOnClickListener(this);
        this.eSo.setOnClickListener(this);
        this.eSq = k.ae(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds300);
        aTR();
        aTQ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eSm.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds80);
        this.eSm.setLayoutParams(layoutParams);
        this.eSr.bo(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40));
        this.eSm.a(this.eSr);
        this.eSp.setVisibility(8);
    }

    private void aTQ() {
        this.eSr = new com.baidu.tieba.pb.pb.main.emotion.view.b(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.f.ds40));
        this.eSm.addView(this.eSr, layoutParams);
        this.eSr.setTextColor(this.eSp.getCurrentChooseColor());
        this.eSr.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eSr.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.eSr.getEditText());
                }
            }
        });
    }

    private void aTR() {
        if (this.rw) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.eSn.getPicUrl();
            gifInfo.mDynamicUrl = this.eSn.getPicUrl();
            gifInfo.mStaticUrl = this.eSn.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).c(this.eSn.getPicUrl(), 10, true);
            c.fK().a(this.eSn.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.eSn.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.eSn.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.eSn.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.eSn.getWidth();
        this.mImageHeight = this.eSn.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.eSq;
            this.mImageHeight = this.eSq;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.eSq / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.eSq;
        } else {
            this.mImageWidth = (int) ((this.eSq / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.eSq;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.eSm.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.buI) {
            finish();
        } else if (view == this.eSo) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.eSr.getEditText());
        }
    }

    private void send() {
        if (!i.hi()) {
            showToast(d.l.neterror);
        } else if (!this.eSv) {
            this.eSs.jQ(false);
            this.eSv = true;
            this.eSA = System.currentTimeMillis();
            this.eSy.aH(true);
            HidenSoftKeyPad(this.mInputManager, this.eSr.getEditText());
            if (TextUtils.isEmpty(this.eSr.getText())) {
                this.eSu = this.eSn;
                aTV();
                return;
            }
            String text = this.eSr.getText();
            switch (this.eSx) {
                case 2:
                    if (!TextUtils.isEmpty(this.eSw) && this.eSw.equals(text)) {
                        aTX();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.eSw) && this.eSw.equals(text) && !TextUtils.isEmpty(this.eSt)) {
                        pz(this.eSt);
                        return;
                    }
                    break;
            }
            aTS();
            this.eSw = this.eSr.getText();
            aTT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTS() {
        if (this.eSz != null && !this.eSz.isRecycled()) {
            this.eSz.recycle();
            this.eSz = null;
        }
    }

    private void aTT() {
        this.eSs.pA(this.eSr.getText());
    }

    private void aTU() {
        if (!this.eSs.fs()) {
            this.eSr.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.e.transparent));
            if (this.rw) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.eSs.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.a.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.eSs.fs()) {
                        Bitmap h = h(bdImage.kO());
                        if (h != null) {
                            this.eSs.b(h, e.xQ + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.l.upload_error);
                        this.eSx = 2;
                        aly();
                        return;
                    }
                    return;
                }
                showToast(d.l.upload_error);
                this.eSx = 2;
                aly();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.eSt)) {
            aly();
        } else {
            this.eSs.V(this.eSt, true);
        }
    }

    private void aTV() {
        if (!this.eSs.fs()) {
            this.eSx = 0;
            aly();
            if (this.eSu != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.eSu);
                setResult(-1, intent);
                finish();
                aTW();
                if (!TextUtils.isEmpty(this.eSt)) {
                    File file = new File(this.eSt);
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

    private void aTW() {
        ak akVar = new ak("c12329");
        if (!TextUtils.isEmpty(this.aiO)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.aiO)) {
                akVar.r("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.aiO)) {
                akVar.r("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.eSr.getText())) {
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
        if (!TextUtils.isEmpty(this.eSr.getText())) {
            if (!this.rw) {
                height = i2;
                width = i;
            }
            Bitmap bn = bn(width, height);
            if (bn != null) {
                canvas.drawBitmap(bn, (width * this.eSr.getLeft()) / i, (height * this.eSr.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bn(int i, int i2) {
        if (this.eSz != null) {
            return this.eSz;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.eSr.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.eSr.getTextView().getDrawingCache();
        this.eSz = drawingCache;
        if (this.rw) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.eSz = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.eSz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.eSp.setVisibility(0);
            this.eSr.aUv();
            return;
        }
        this.eSp.setVisibility(8);
        this.eSr.aUu();
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
        aj.c(this.buI, d.g.icon_emotion_close_n);
        aj.i(this.eSo, d.e.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aTS();
        if (this.eSs != null) {
            this.eSs.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void aTX() {
        aTU();
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void py(String str) {
        showToast(str);
        this.eSx = 1;
        aly();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aly() {
        this.eSr.getTextView().setBackgroundResource(d.g.bg_emotion_edit);
        this.eSy.aH(false);
        this.eSv = false;
        if (this.rw) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void pz(String str) {
        this.eSr.getTextView().setBackgroundResource(d.g.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            aly();
        } else if (!new File(str).exists()) {
            aly();
        } else {
            this.eSt = str;
            this.eSx = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.eSA) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.a
    public void d(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.eSu = new EmotionImageData();
                this.eSu.setPicId(uploadedPicInfo.getPic_id());
                this.eSu.setWidth(uploadedPicInfo.getWidth());
                this.eSu.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.eSn.getMemeContSign())) {
                    this.eSu.setMemeContSign(this.eSn.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.eSu.setPicUrl(picinfo.originPic.picUrl);
                    this.eSu.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.eSu.setMemeText(this.eSr.getText());
                aTV();
                return;
            }
            showToast(d.l.upload_error);
            this.eSx = 3;
            aly();
            return;
        }
        showToast(d.l.upload_error);
        this.eSx = 3;
        aly();
    }
}
