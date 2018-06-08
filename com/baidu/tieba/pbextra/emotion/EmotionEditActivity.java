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
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pbextra.emotion.model.EmotionEditModel;
import com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout;
import com.baidu.tieba.pbextra.emotion.view.EmotionEditLayout;
import com.baidu.tieba.pbextra.emotion.view.EmotionEditText;
import java.io.File;
/* loaded from: classes3.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private a biP;
    private com.baidu.tbadk.core.view.a dCl;
    private ImageView dSa;
    private long fMA;
    private EmotionEditLayout fMo;
    private View fMp;
    private ChooseColorLayout fMq;
    private int fMr;
    private EmotionEditText fMs;
    private EmotionEditModel fMt;
    private String fMu;
    private EmotionImageData fMv;
    private boolean fMw;
    private String fMx;
    private int fMy = 0;
    private Bitmap fMz;
    private EmotionImageData frG;
    private String mFrom;
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
        setContentView(d.i.emotion_edit_activity);
        this.frG = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.fMt = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0141d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dCl = new com.baidu.tbadk.core.view.a(getPageContext());
        this.dCl.dc(d.k.emotion_composition);
        this.dCl.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.fMt.kW(true);
                EmotionEditActivity.this.bhN();
                EmotionEditActivity.this.ayU();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_layout);
        this.fMo = (EmotionEditLayout) findViewById(d.g.edit_container);
        this.dSa = (ImageView) findViewById(d.g.close);
        this.fMp = findViewById(d.g.send);
        this.fMq = (ChooseColorLayout) findViewById(d.g.choose_color_layout);
        this.fMq.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void rb(int i) {
                EmotionEditActivity.this.fMs.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.dSa.setOnClickListener(this);
        this.fMp.setOnClickListener(this);
        this.fMr = l.ah(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds300);
        bhM();
        bhL();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fMo.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        this.fMo.setLayoutParams(layoutParams);
        this.fMs.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.fMo.a(this.fMs);
        this.fMq.setVisibility(8);
    }

    private void bhL() {
        this.fMs = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.fMo.addView(this.fMs, layoutParams);
        this.fMs.setTextColor(this.fMq.getCurrentChooseColor());
        this.fMs.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.fMs.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.fMs.getEditText());
                }
            }
        });
    }

    private void bhM() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.frG.getPicUrl();
            gifInfo.mDynamicUrl = this.frG.getPicUrl();
            gifInfo.mStaticUrl = this.frG.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.frG.getPicUrl(), 10, true);
            c.ig().a(this.frG.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.mImageView);
                            EmotionEditActivity.this.mImageView = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.mImageView).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.frG.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.frG.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.frG.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.frG.getWidth();
        this.mImageHeight = this.frG.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.fMr;
            this.mImageHeight = this.fMr;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.fMr / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.fMr;
        } else {
            this.mImageWidth = (int) ((this.fMr / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.fMr;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.fMo.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dSa) {
            finish();
        } else if (view == this.fMp) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.fMs.getEditText());
        }
    }

    private void send() {
        if (!j.jD()) {
            showToast(d.k.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.biP == null) {
            this.biP = new a();
        }
        this.biP.zU();
        this.biP.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.biP.u(pageActivity) && !this.fMw) {
            this.fMt.kW(false);
            this.fMw = true;
            this.fMA = System.currentTimeMillis();
            this.dCl.aM(true);
            HidenSoftKeyPad(this.mInputManager, this.fMs.getEditText());
            if (TextUtils.isEmpty(this.fMs.getText())) {
                this.fMv = this.frG;
                bhQ();
                return;
            }
            String text = this.fMs.getText();
            switch (this.fMy) {
                case 2:
                    if (!TextUtils.isEmpty(this.fMx) && this.fMx.equals(text)) {
                        bhS();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.fMx) && this.fMx.equals(text) && !TextUtils.isEmpty(this.fMu)) {
                        rP(this.fMu);
                        return;
                    }
                    break;
            }
            bhN();
            this.fMx = this.fMs.getText();
            bhO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhN() {
        if (this.fMz != null && !this.fMz.isRecycled()) {
            this.fMz.recycle();
            this.fMz = null;
        }
    }

    private void bhO() {
        this.fMt.rQ(this.fMs.getText());
    }

    private void bhP() {
        if (!this.fMt.isCancel()) {
            this.fMs.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.C0141d.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.fMt.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.fMt.isCancel()) {
                        Bitmap s = s(bdImage.mZ());
                        if (s != null) {
                            this.fMt.b(s, f.CF + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.k.upload_error);
                        this.fMy = 2;
                        ayU();
                        return;
                    }
                    return;
                }
                showToast(d.k.upload_error);
                this.fMy = 2;
                ayU();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.fMu)) {
            ayU();
        } else {
            this.fMt.N(this.fMu, true);
        }
    }

    private void bhQ() {
        if (!this.fMt.isCancel()) {
            this.fMy = 0;
            ayU();
            if (this.fMv != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.fMv);
                setResult(-1, intent);
                finish();
                bhR();
                if (!TextUtils.isEmpty(this.fMu)) {
                    File file = new File(this.fMu);
                    if (file.exists()) {
                        file.delete();
                        return;
                    }
                    return;
                }
                return;
            }
            showToast(d.k.upload_error);
        }
    }

    private void bhR() {
        am amVar = new am("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                amVar.r("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                amVar.r("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.fMs.getText())) {
            amVar.r("obj_type", 1);
        } else {
            amVar.r("obj_type", 2);
        }
        TiebaStatic.log(amVar);
    }

    public Bitmap s(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.fMs.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bv = bv(width, height);
            if (bv != null) {
                canvas.drawBitmap(bv, (width * this.fMs.getLeft()) / i, (height * this.fMs.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bv(int i, int i2) {
        if (this.fMz != null) {
            return this.fMz;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.fMs.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.fMs.getTextView().getDrawingCache();
        this.fMz = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.fMz = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.fMz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.fMq.setVisibility(0);
            this.fMs.bin();
            return;
        }
        this.fMq.setVisibility(8);
        this.fMs.bim();
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
        al.j(this.mRootView, d.C0141d.black_alpha40);
        al.c(this.dSa, d.f.icon_emotion_close_n);
        al.h(this.fMp, d.C0141d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bhN();
        if (this.fMt != null) {
            this.fMt.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bhS() {
        bhP();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void rO(String str) {
        showToast(str);
        this.fMy = 1;
        ayU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayU() {
        this.fMs.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        this.dCl.aM(false);
        this.fMw = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void rP(String str) {
        this.fMs.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            ayU();
        } else if (!new File(str).exists()) {
            ayU();
        } else {
            this.fMu = str;
            this.fMy = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.fMA) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.fMv = new EmotionImageData();
                this.fMv.setPicId(uploadedPicInfo.getPic_id());
                this.fMv.setWidth(uploadedPicInfo.getWidth());
                this.fMv.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.frG.getMemeContSign())) {
                    this.fMv.setMemeContSign(this.frG.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.fMv.setPicUrl(picinfo.originPic.picUrl);
                    this.fMv.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.fMv.setMemeText(this.fMs.getText());
                this.fMv.setAuthorNameShow(this.frG.getAuthorNameShow());
                bhQ();
                return;
            }
            showToast(d.k.upload_error);
            this.fMy = 3;
            ayU();
            return;
        }
        showToast(d.k.upload_error);
        this.fMy = 3;
        ayU();
    }
}
