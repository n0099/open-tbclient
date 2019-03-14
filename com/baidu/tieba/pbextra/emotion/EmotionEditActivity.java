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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.view.b;
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
/* loaded from: classes4.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView cyf;
    private b eQQ;
    private ImageView fNQ;
    private EmotionEditLayout hHG;
    private View hHH;
    private ChooseColorLayout hHI;
    private int hHJ;
    private EmotionEditText hHK;
    private EmotionEditModel hHL;
    private String hHM;
    private EmotionImageData hHN;
    private boolean hHO;
    private String hHP;
    private int hHQ = 0;
    private Bitmap hHR;
    private long hHS;
    private EmotionImageData hno;
    private String mFrom;
    private int mImageHeight;
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
        setContentView(d.h.emotion_edit_activity);
        this.hno = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.hHL = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0277d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eQQ = new b(getPageContext());
        this.eQQ.hG(d.j.emotion_composition);
        this.eQQ.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.hHL.ot(true);
                EmotionEditActivity.this.bPB();
                EmotionEditActivity.this.bip();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_layout);
        this.hHG = (EmotionEditLayout) findViewById(d.g.edit_container);
        this.fNQ = (ImageView) findViewById(d.g.close);
        this.hHH = findViewById(d.g.send);
        this.hHI = (ChooseColorLayout) findViewById(d.g.choose_color_layout);
        this.hHI.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void wP(int i) {
                EmotionEditActivity.this.hHK.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.fNQ.setOnClickListener(this);
        this.hHH.setOnClickListener(this);
        this.hHJ = l.aO(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds300);
        bPA();
        bPz();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hHG.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        this.hHG.setLayoutParams(layoutParams);
        this.hHK.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.hHG.a(this.hHK);
        this.hHI.setVisibility(8);
    }

    private void bPz() {
        this.hHK = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.hHG.addView(this.hHK, layoutParams);
        this.hHK.setTextColor(this.hHI.getCurrentChooseColor());
        this.hHK.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.hHK.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.hHK.getEditText());
                }
            }
        });
    }

    private void bPA() {
        if (this.mIsGif) {
            this.cyf = new GifView(getPageContext().getPageActivity());
            ((GifView) this.cyf).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.hno.getPicUrl();
            gifInfo.mDynamicUrl = this.hno.getPicUrl();
            gifInfo.mStaticUrl = this.hno.getThumbUrl();
            this.cyf.setTag(gifInfo.mSharpText);
            ((GifView) this.cyf).a(gifInfo);
        } else {
            this.cyf = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.cyf).setGifIconSupport(false);
            ((TbImageView) this.cyf).setAutoChangeStyle(false);
            ((TbImageView) this.cyf).startLoad(this.hno.getPicUrl(), 10, true);
            c.jB().a(this.hno.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.cyf);
                            EmotionEditActivity.this.cyf = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.cyf).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.hno.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.hno.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.hno.getThumbUrl();
                            EmotionEditActivity.this.cyf.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.cyf).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.hno.getWidth();
        this.mImageHeight = this.hno.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.hHJ;
            this.mImageHeight = this.hHJ;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.hHJ / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.hHJ;
        } else {
            this.mImageWidth = (int) ((this.hHJ / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.hHJ;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.hHG.addView(this.cyf, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fNQ) {
            finish();
        } else if (view == this.hHH) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.hHK.getEditText());
        }
    }

    private void send() {
        if (!j.kY()) {
            showToast(d.j.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new a();
        }
        this.mPermissionJudgement.adQ();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.Y(pageActivity) && !this.hHO) {
            this.hHL.ot(false);
            this.hHO = true;
            this.hHS = System.currentTimeMillis();
            this.eQQ.dJ(true);
            HidenSoftKeyPad(this.mInputManager, this.hHK.getEditText());
            if (TextUtils.isEmpty(this.hHK.getText())) {
                this.hHN = this.hno;
                bPE();
                return;
            }
            String text = this.hHK.getText();
            switch (this.hHQ) {
                case 2:
                    if (!TextUtils.isEmpty(this.hHP) && this.hHP.equals(text)) {
                        bPG();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.hHP) && this.hHP.equals(text) && !TextUtils.isEmpty(this.hHM)) {
                        At(this.hHM);
                        return;
                    }
                    break;
            }
            bPB();
            this.hHP = this.hHK.getText();
            bPC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPB() {
        if (this.hHR != null && !this.hHR.isRecycled()) {
            this.hHR.recycle();
            this.hHR = null;
        }
    }

    private void bPC() {
        this.hHL.Au(this.hHK.getText());
    }

    private void bPD() {
        if (!this.hHL.jk()) {
            this.hHK.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.C0277d.transparent));
            if (this.mIsGif) {
                if (this.cyf instanceof GifView) {
                    ((GifView) this.cyf).pause();
                    this.hHL.a(((GifView) this.cyf).getGif());
                }
            } else if (this.cyf instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.cyf).getBdImage();
                if (bdImage != null) {
                    if (!this.hHL.jk()) {
                        Bitmap A = A(bdImage.oy());
                        if (A != null) {
                            this.hHL.b(A, f.FK + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.j.upload_error);
                        this.hHQ = 2;
                        bip();
                        return;
                    }
                    return;
                }
                showToast(d.j.upload_error);
                this.hHQ = 2;
                bip();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.hHM)) {
            bip();
        } else {
            this.hHL.ap(this.hHM, true);
        }
    }

    private void bPE() {
        if (!this.hHL.jk()) {
            this.hHQ = 0;
            bip();
            if (this.hHN != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.hHN);
                setResult(-1, intent);
                finish();
                bPF();
                if (!TextUtils.isEmpty(this.hHM)) {
                    File file = new File(this.hHM);
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

    private void bPF() {
        am amVar = new am("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                amVar.T("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                amVar.T("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.hHK.getText())) {
            amVar.T("obj_type", 1);
        } else {
            amVar.T("obj_type", 2);
        }
        TiebaStatic.log(amVar);
    }

    public Bitmap A(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.hHK.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bX = bX(width, height);
            if (bX != null) {
                canvas.drawBitmap(bX, (width * this.hHK.getLeft()) / i, (height * this.hHK.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bX(int i, int i2) {
        if (this.hHR != null) {
            return this.hHR;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.hHK.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.hHK.getTextView().getDrawingCache();
        this.hHR = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.hHR = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.hHR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.hHI.setVisibility(0);
            this.hHK.bQa();
            return;
        }
        this.hHI.setVisibility(8);
        this.hHK.bPZ();
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
        al.l(this.mRootView, d.C0277d.black_alpha40);
        al.c(this.fNQ, d.f.icon_emotion_close_n);
        al.j(this.hHH, d.C0277d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bPB();
        if (this.hHL != null) {
            this.hHL.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bPG() {
        bPD();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void As(String str) {
        showToast(str);
        this.hHQ = 1;
        bip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bip() {
        this.hHK.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        this.eQQ.dJ(false);
        this.hHO = false;
        if (this.mIsGif) {
            ((GifView) this.cyf).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void At(String str) {
        this.hHK.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bip();
        } else if (!new File(str).exists()) {
            bip();
        } else {
            this.hHM = str;
            this.hHQ = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.hHS) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.hHN = new EmotionImageData();
                this.hHN.setPicId(uploadedPicInfo.getPic_id());
                this.hHN.setWidth(uploadedPicInfo.getWidth());
                this.hHN.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.hno.getMemeContSign())) {
                    this.hHN.setMemeContSign(this.hno.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.hHN.setPicUrl(picinfo.originPic.picUrl);
                    this.hHN.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.hHN.setMemeText(this.hHK.getText());
                this.hHN.setAuthorNameShow(this.hno.getAuthorNameShow());
                bPE();
                return;
            }
            showToast(d.j.upload_error);
            this.hHQ = 3;
            bip();
            return;
        }
        showToast(d.j.upload_error);
        this.hHQ = 3;
        bip();
    }
}
