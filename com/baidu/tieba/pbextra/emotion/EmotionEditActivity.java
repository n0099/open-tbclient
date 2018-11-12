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
    private ImageView bjr;
    private a bvI;
    private d dtG;
    private ImageView eqs;
    private EmotionImageData fMw;
    private EmotionEditLayout ggI;
    private View ggJ;
    private ChooseColorLayout ggK;
    private int ggL;
    private EmotionEditText ggM;
    private EmotionEditModel ggN;
    private String ggO;
    private EmotionImageData ggP;
    private boolean ggQ;
    private String ggR;
    private int ggS = 0;
    private Bitmap ggT;
    private long ggU;
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
        this.fMw = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.ggN = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(e.d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dtG = new d(getPageContext());
        this.dtG.dO(e.j.emotion_composition);
        this.dtG.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.ggN.lQ(true);
                EmotionEditActivity.this.blQ();
                EmotionEditActivity.this.aFc();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(e.g.root_layout);
        this.ggI = (EmotionEditLayout) findViewById(e.g.edit_container);
        this.eqs = (ImageView) findViewById(e.g.close);
        this.ggJ = findViewById(e.g.send);
        this.ggK = (ChooseColorLayout) findViewById(e.g.choose_color_layout);
        this.ggK.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void su(int i) {
                EmotionEditActivity.this.ggM.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.eqs.setOnClickListener(this);
        this.ggJ.setOnClickListener(this);
        this.ggL = l.aO(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0200e.ds300);
        blP();
        blO();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ggI.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0200e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0200e.ds80);
        this.ggI.setLayoutParams(layoutParams);
        this.ggM.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0200e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0200e.ds40));
        this.ggI.a(this.ggM);
        this.ggK.setVisibility(8);
    }

    private void blO() {
        this.ggM = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0200e.ds40));
        this.ggI.addView(this.ggM, layoutParams);
        this.ggM.setTextColor(this.ggK.getCurrentChooseColor());
        this.ggM.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.ggM.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.ggM.getEditText());
                }
            }
        });
    }

    private void blP() {
        if (this.mIsGif) {
            this.bjr = new GifView(getPageContext().getPageActivity());
            ((GifView) this.bjr).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.fMw.getPicUrl();
            gifInfo.mDynamicUrl = this.fMw.getPicUrl();
            gifInfo.mStaticUrl = this.fMw.getThumbUrl();
            this.bjr.setTag(gifInfo.mSharpText);
            ((GifView) this.bjr).a(gifInfo);
        } else {
            this.bjr = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.bjr).setGifIconSupport(false);
            ((TbImageView) this.bjr).setAutoChangeStyle(false);
            ((TbImageView) this.bjr).startLoad(this.fMw.getPicUrl(), 10, true);
            c.jA().a(this.fMw.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.bjr);
                            EmotionEditActivity.this.bjr = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.bjr).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.fMw.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.fMw.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.fMw.getThumbUrl();
                            EmotionEditActivity.this.bjr.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.bjr).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.fMw.getWidth();
        this.mImageHeight = this.fMw.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.ggL;
            this.mImageHeight = this.ggL;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.ggL / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.ggL;
        } else {
            this.mImageWidth = (int) ((this.ggL / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.ggL;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.ggI.addView(this.bjr, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eqs) {
            finish();
        } else if (view == this.ggJ) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.ggM.getEditText());
        }
    }

    private void send() {
        if (!j.kV()) {
            showToast(e.j.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bvI == null) {
            this.bvI = new a();
        }
        this.bvI.Dp();
        this.bvI.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bvI.A(pageActivity) && !this.ggQ) {
            this.ggN.lQ(false);
            this.ggQ = true;
            this.ggU = System.currentTimeMillis();
            this.dtG.bz(true);
            HidenSoftKeyPad(this.mInputManager, this.ggM.getEditText());
            if (TextUtils.isEmpty(this.ggM.getText())) {
                this.ggP = this.fMw;
                blT();
                return;
            }
            String text = this.ggM.getText();
            switch (this.ggS) {
                case 2:
                    if (!TextUtils.isEmpty(this.ggR) && this.ggR.equals(text)) {
                        blV();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.ggR) && this.ggR.equals(text) && !TextUtils.isEmpty(this.ggO)) {
                        sT(this.ggO);
                        return;
                    }
                    break;
            }
            blQ();
            this.ggR = this.ggM.getText();
            blR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blQ() {
        if (this.ggT != null && !this.ggT.isRecycled()) {
            this.ggT.recycle();
            this.ggT = null;
        }
    }

    private void blR() {
        this.ggN.sU(this.ggM.getText());
    }

    private void blS() {
        if (!this.ggN.ji()) {
            this.ggM.getTextView().setBackgroundColor(getPageContext().getResources().getColor(e.d.transparent));
            if (this.mIsGif) {
                if (this.bjr instanceof GifView) {
                    ((GifView) this.bjr).pause();
                    this.ggN.a(((GifView) this.bjr).getGif());
                }
            } else if (this.bjr instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.bjr).getBdImage();
                if (bdImage != null) {
                    if (!this.ggN.ji()) {
                        Bitmap s = s(bdImage.oq());
                        if (s != null) {
                            this.ggN.b(s, f.FL + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(e.j.upload_error);
                        this.ggS = 2;
                        aFc();
                        return;
                    }
                    return;
                }
                showToast(e.j.upload_error);
                this.ggS = 2;
                aFc();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.ggO)) {
            aFc();
        } else {
            this.ggN.V(this.ggO, true);
        }
    }

    private void blT() {
        if (!this.ggN.ji()) {
            this.ggS = 0;
            aFc();
            if (this.ggP != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.ggP);
                setResult(-1, intent);
                finish();
                blU();
                if (!TextUtils.isEmpty(this.ggO)) {
                    File file = new File(this.ggO);
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

    private void blU() {
        am amVar = new am("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                amVar.x("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                amVar.x("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.ggM.getText())) {
            amVar.x("obj_type", 1);
        } else {
            amVar.x("obj_type", 2);
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
        if (!TextUtils.isEmpty(this.ggM.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bC = bC(width, height);
            if (bC != null) {
                canvas.drawBitmap(bC, (width * this.ggM.getLeft()) / i, (height * this.ggM.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bC(int i, int i2) {
        if (this.ggT != null) {
            return this.ggT;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.ggM.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.ggM.getTextView().getDrawingCache();
        this.ggT = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.ggT = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.ggT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.ggK.setVisibility(0);
            this.ggM.bmp();
            return;
        }
        this.ggK.setVisibility(8);
        this.ggM.bmo();
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
        al.c(this.eqs, e.f.icon_emotion_close_n);
        al.h(this.ggJ, e.d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        blQ();
        if (this.ggN != null) {
            this.ggN.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void blV() {
        blS();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void sS(String str) {
        showToast(str);
        this.ggS = 1;
        aFc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFc() {
        this.ggM.getTextView().setBackgroundResource(e.f.bg_emotion_edit);
        this.dtG.bz(false);
        this.ggQ = false;
        if (this.mIsGif) {
            ((GifView) this.bjr).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void sT(String str) {
        this.ggM.getTextView().setBackgroundResource(e.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            aFc();
        } else if (!new File(str).exists()) {
            aFc();
        } else {
            this.ggO = str;
            this.ggS = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.ggU) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.ggP = new EmotionImageData();
                this.ggP.setPicId(uploadedPicInfo.getPic_id());
                this.ggP.setWidth(uploadedPicInfo.getWidth());
                this.ggP.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.fMw.getMemeContSign())) {
                    this.ggP.setMemeContSign(this.fMw.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.ggP.setPicUrl(picinfo.originPic.picUrl);
                    this.ggP.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.ggP.setMemeText(this.ggM.getText());
                this.ggP.setAuthorNameShow(this.fMw.getAuthorNameShow());
                blT();
                return;
            }
            showToast(e.j.upload_error);
            this.ggS = 3;
            aFc();
            return;
        }
        showToast(e.j.upload_error);
        this.ggS = 3;
        aFc();
    }
}
