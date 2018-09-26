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
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pbextra.emotion.model.EmotionEditModel;
import com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout;
import com.baidu.tieba.pbextra.emotion.view.EmotionEditLayout;
import com.baidu.tieba.pbextra.emotion.view.EmotionEditText;
import java.io.File;
/* loaded from: classes3.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView bem;
    private a bqO;
    private d dkx;
    private ImageView ehf;
    private EmotionImageData fDv;
    private EmotionEditLayout fXK;
    private View fXL;
    private ChooseColorLayout fXM;
    private int fXN;
    private EmotionEditText fXO;
    private EmotionEditModel fXP;
    private String fXQ;
    private EmotionImageData fXR;
    private boolean fXS;
    private String fXT;
    private int fXU = 0;
    private Bitmap fXV;
    private long fXW;
    private String mFrom;
    private int mImageHeight;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(e.h.emotion_edit_activity);
        this.fDv = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.fXP = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(e.d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dkx = new d(getPageContext());
        this.dkx.dq(e.j.emotion_composition);
        this.dkx.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.fXP.lo(true);
                EmotionEditActivity.this.bji();
                EmotionEditActivity.this.aCn();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(e.g.root_layout);
        this.fXK = (EmotionEditLayout) findViewById(e.g.edit_container);
        this.ehf = (ImageView) findViewById(e.g.close);
        this.fXL = findViewById(e.g.send);
        this.fXM = (ChooseColorLayout) findViewById(e.g.choose_color_layout);
        this.fXM.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void rE(int i) {
                EmotionEditActivity.this.fXO.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.ehf.setOnClickListener(this);
        this.fXL.setOnClickListener(this);
        this.fXN = l.aO(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0141e.ds300);
        bjh();
        bjg();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fXK.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0141e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0141e.ds80);
        this.fXK.setLayoutParams(layoutParams);
        this.fXO.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0141e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0141e.ds40));
        this.fXK.a(this.fXO);
        this.fXM.setVisibility(8);
    }

    private void bjg() {
        this.fXO = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0141e.ds40));
        this.fXK.addView(this.fXO, layoutParams);
        this.fXO.setTextColor(this.fXM.getCurrentChooseColor());
        this.fXO.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.fXO.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.fXO.getEditText());
                }
            }
        });
    }

    private void bjh() {
        if (this.mIsGif) {
            this.bem = new GifView(getPageContext().getPageActivity());
            ((GifView) this.bem).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.fDv.getPicUrl();
            gifInfo.mDynamicUrl = this.fDv.getPicUrl();
            gifInfo.mStaticUrl = this.fDv.getThumbUrl();
            this.bem.setTag(gifInfo.mSharpText);
            ((GifView) this.bem).a(gifInfo);
        } else {
            this.bem = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.bem).setGifIconSupport(false);
            ((TbImageView) this.bem).setAutoChangeStyle(false);
            ((TbImageView) this.bem).startLoad(this.fDv.getPicUrl(), 10, true);
            c.jn().a(this.fDv.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.bem);
                            EmotionEditActivity.this.bem = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.bem).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.fDv.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.fDv.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.fDv.getThumbUrl();
                            EmotionEditActivity.this.bem.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.bem).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.fDv.getWidth();
        this.mImageHeight = this.fDv.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.fXN;
            this.mImageHeight = this.fXN;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.fXN / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.fXN;
        } else {
            this.mImageWidth = (int) ((this.fXN / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.fXN;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.fXK.addView(this.bem, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ehf) {
            finish();
        } else if (view == this.fXL) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.fXO.getEditText());
        }
    }

    private void send() {
        if (!j.kK()) {
            showToast(e.j.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bqO == null) {
            this.bqO = new a();
        }
        this.bqO.Bb();
        this.bqO.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bqO.x(pageActivity) && !this.fXS) {
            this.fXP.lo(false);
            this.fXS = true;
            this.fXW = System.currentTimeMillis();
            this.dkx.aZ(true);
            HidenSoftKeyPad(this.mInputManager, this.fXO.getEditText());
            if (TextUtils.isEmpty(this.fXO.getText())) {
                this.fXR = this.fDv;
                bjl();
                return;
            }
            String text = this.fXO.getText();
            switch (this.fXU) {
                case 2:
                    if (!TextUtils.isEmpty(this.fXT) && this.fXT.equals(text)) {
                        bjn();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.fXT) && this.fXT.equals(text) && !TextUtils.isEmpty(this.fXQ)) {
                        ss(this.fXQ);
                        return;
                    }
                    break;
            }
            bji();
            this.fXT = this.fXO.getText();
            bjj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bji() {
        if (this.fXV != null && !this.fXV.isRecycled()) {
            this.fXV.recycle();
            this.fXV = null;
        }
    }

    private void bjj() {
        this.fXP.st(this.fXO.getText());
    }

    private void bjk() {
        if (!this.fXP.iV()) {
            this.fXO.getTextView().setBackgroundColor(getPageContext().getResources().getColor(e.d.transparent));
            if (this.mIsGif) {
                if (this.bem instanceof GifView) {
                    ((GifView) this.bem).pause();
                    this.fXP.a(((GifView) this.bem).getGif());
                }
            } else if (this.bem instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.bem).getBdImage();
                if (bdImage != null) {
                    if (!this.fXP.iV()) {
                        Bitmap s = s(bdImage.oh());
                        if (s != null) {
                            this.fXP.b(s, f.EZ + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(e.j.upload_error);
                        this.fXU = 2;
                        aCn();
                        return;
                    }
                    return;
                }
                showToast(e.j.upload_error);
                this.fXU = 2;
                aCn();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.fXQ)) {
            aCn();
        } else {
            this.fXP.O(this.fXQ, true);
        }
    }

    private void bjl() {
        if (!this.fXP.iV()) {
            this.fXU = 0;
            aCn();
            if (this.fXR != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.fXR);
                setResult(-1, intent);
                finish();
                bjm();
                if (!TextUtils.isEmpty(this.fXQ)) {
                    File file = new File(this.fXQ);
                    if (file.exists()) {
                        file.delete();
                        return;
                    }
                    return;
                }
                return;
            }
            showToast(e.j.upload_error);
        }
    }

    private void bjm() {
        am amVar = new am("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                amVar.w("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                amVar.w("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.fXO.getText())) {
            amVar.w("obj_type", 1);
        } else {
            amVar.w("obj_type", 2);
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
        if (!TextUtils.isEmpty(this.fXO.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bx = bx(width, height);
            if (bx != null) {
                canvas.drawBitmap(bx, (width * this.fXO.getLeft()) / i, (height * this.fXO.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bx(int i, int i2) {
        if (this.fXV != null) {
            return this.fXV;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.fXO.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.fXO.getTextView().getDrawingCache();
        this.fXV = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.fXV = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.fXV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.fXM.setVisibility(0);
            this.fXO.bjI();
            return;
        }
        this.fXM.setVisibility(8);
        this.fXO.bjH();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(e.a.fade_in, e.a.fade_out);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(e.a.fade_in, e.a.fade_out);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.mRootView, e.d.black_alpha40);
        al.c(this.ehf, e.f.icon_emotion_close_n);
        al.h(this.fXL, e.d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bji();
        if (this.fXP != null) {
            this.fXP.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bjn() {
        bjk();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void sq(String str) {
        showToast(str);
        this.fXU = 1;
        aCn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCn() {
        this.fXO.getTextView().setBackgroundResource(e.f.bg_emotion_edit);
        this.dkx.aZ(false);
        this.fXS = false;
        if (this.mIsGif) {
            ((GifView) this.bem).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void ss(String str) {
        this.fXO.getTextView().setBackgroundResource(e.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            aCn();
        } else if (!new File(str).exists()) {
            aCn();
        } else {
            this.fXQ = str;
            this.fXU = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.fXW) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.fXR = new EmotionImageData();
                this.fXR.setPicId(uploadedPicInfo.getPic_id());
                this.fXR.setWidth(uploadedPicInfo.getWidth());
                this.fXR.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.fDv.getMemeContSign())) {
                    this.fXR.setMemeContSign(this.fDv.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.fXR.setPicUrl(picinfo.originPic.picUrl);
                    this.fXR.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.fXR.setMemeText(this.fXO.getText());
                this.fXR.setAuthorNameShow(this.fDv.getAuthorNameShow());
                bjl();
                return;
            }
            showToast(e.j.upload_error);
            this.fXU = 3;
            aCn();
            return;
        }
        showToast(e.j.upload_error);
        this.fXU = 3;
        aCn();
    }
}
