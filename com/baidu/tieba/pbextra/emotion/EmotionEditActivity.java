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
    private ImageView cyh;
    private b eQC;
    private ImageView fNE;
    private boolean hHA;
    private String hHB;
    private int hHC = 0;
    private Bitmap hHD;
    private long hHE;
    private EmotionEditLayout hHs;
    private View hHt;
    private ChooseColorLayout hHu;
    private int hHv;
    private EmotionEditText hHw;
    private EmotionEditModel hHx;
    private String hHy;
    private EmotionImageData hHz;
    private EmotionImageData hnb;
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
        this.hnb = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.hHx = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0277d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eQC = new b(getPageContext());
        this.eQC.hF(d.j.emotion_composition);
        this.eQC.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.hHx.ot(true);
                EmotionEditActivity.this.bPy();
                EmotionEditActivity.this.bin();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_layout);
        this.hHs = (EmotionEditLayout) findViewById(d.g.edit_container);
        this.fNE = (ImageView) findViewById(d.g.close);
        this.hHt = findViewById(d.g.send);
        this.hHu = (ChooseColorLayout) findViewById(d.g.choose_color_layout);
        this.hHu.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void wL(int i) {
                EmotionEditActivity.this.hHw.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.fNE.setOnClickListener(this);
        this.hHt.setOnClickListener(this);
        this.hHv = l.aO(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds300);
        bPx();
        bPw();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hHs.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        this.hHs.setLayoutParams(layoutParams);
        this.hHw.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.hHs.a(this.hHw);
        this.hHu.setVisibility(8);
    }

    private void bPw() {
        this.hHw = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.hHs.addView(this.hHw, layoutParams);
        this.hHw.setTextColor(this.hHu.getCurrentChooseColor());
        this.hHw.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.hHw.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.hHw.getEditText());
                }
            }
        });
    }

    private void bPx() {
        if (this.mIsGif) {
            this.cyh = new GifView(getPageContext().getPageActivity());
            ((GifView) this.cyh).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.hnb.getPicUrl();
            gifInfo.mDynamicUrl = this.hnb.getPicUrl();
            gifInfo.mStaticUrl = this.hnb.getThumbUrl();
            this.cyh.setTag(gifInfo.mSharpText);
            ((GifView) this.cyh).a(gifInfo);
        } else {
            this.cyh = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.cyh).setGifIconSupport(false);
            ((TbImageView) this.cyh).setAutoChangeStyle(false);
            ((TbImageView) this.cyh).startLoad(this.hnb.getPicUrl(), 10, true);
            c.jB().a(this.hnb.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.cyh);
                            EmotionEditActivity.this.cyh = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.cyh).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.hnb.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.hnb.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.hnb.getThumbUrl();
                            EmotionEditActivity.this.cyh.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.cyh).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.hnb.getWidth();
        this.mImageHeight = this.hnb.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.hHv;
            this.mImageHeight = this.hHv;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.hHv / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.hHv;
        } else {
            this.mImageWidth = (int) ((this.hHv / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.hHv;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.hHs.addView(this.cyh, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fNE) {
            finish();
        } else if (view == this.hHt) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.hHw.getEditText());
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
        this.mPermissionJudgement.adN();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.Y(pageActivity) && !this.hHA) {
            this.hHx.ot(false);
            this.hHA = true;
            this.hHE = System.currentTimeMillis();
            this.eQC.dJ(true);
            HidenSoftKeyPad(this.mInputManager, this.hHw.getEditText());
            if (TextUtils.isEmpty(this.hHw.getText())) {
                this.hHz = this.hnb;
                bPB();
                return;
            }
            String text = this.hHw.getText();
            switch (this.hHC) {
                case 2:
                    if (!TextUtils.isEmpty(this.hHB) && this.hHB.equals(text)) {
                        bPD();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.hHB) && this.hHB.equals(text) && !TextUtils.isEmpty(this.hHy)) {
                        As(this.hHy);
                        return;
                    }
                    break;
            }
            bPy();
            this.hHB = this.hHw.getText();
            bPz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPy() {
        if (this.hHD != null && !this.hHD.isRecycled()) {
            this.hHD.recycle();
            this.hHD = null;
        }
    }

    private void bPz() {
        this.hHx.At(this.hHw.getText());
    }

    private void bPA() {
        if (!this.hHx.jk()) {
            this.hHw.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.C0277d.transparent));
            if (this.mIsGif) {
                if (this.cyh instanceof GifView) {
                    ((GifView) this.cyh).pause();
                    this.hHx.a(((GifView) this.cyh).getGif());
                }
            } else if (this.cyh instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.cyh).getBdImage();
                if (bdImage != null) {
                    if (!this.hHx.jk()) {
                        Bitmap A = A(bdImage.oy());
                        if (A != null) {
                            this.hHx.b(A, f.FK + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.j.upload_error);
                        this.hHC = 2;
                        bin();
                        return;
                    }
                    return;
                }
                showToast(d.j.upload_error);
                this.hHC = 2;
                bin();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.hHy)) {
            bin();
        } else {
            this.hHx.ap(this.hHy, true);
        }
    }

    private void bPB() {
        if (!this.hHx.jk()) {
            this.hHC = 0;
            bin();
            if (this.hHz != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.hHz);
                setResult(-1, intent);
                finish();
                bPC();
                if (!TextUtils.isEmpty(this.hHy)) {
                    File file = new File(this.hHy);
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

    private void bPC() {
        am amVar = new am("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                amVar.T("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                amVar.T("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.hHw.getText())) {
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
        if (!TextUtils.isEmpty(this.hHw.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bX = bX(width, height);
            if (bX != null) {
                canvas.drawBitmap(bX, (width * this.hHw.getLeft()) / i, (height * this.hHw.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bX(int i, int i2) {
        if (this.hHD != null) {
            return this.hHD;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.hHw.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.hHw.getTextView().getDrawingCache();
        this.hHD = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.hHD = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.hHD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.hHu.setVisibility(0);
            this.hHw.bPX();
            return;
        }
        this.hHu.setVisibility(8);
        this.hHw.bPW();
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
        al.c(this.fNE, d.f.icon_emotion_close_n);
        al.j(this.hHt, d.C0277d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bPy();
        if (this.hHx != null) {
            this.hHx.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bPD() {
        bPA();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Ar(String str) {
        showToast(str);
        this.hHC = 1;
        bin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bin() {
        this.hHw.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        this.eQC.dJ(false);
        this.hHA = false;
        if (this.mIsGif) {
            ((GifView) this.cyh).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void As(String str) {
        this.hHw.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bin();
        } else if (!new File(str).exists()) {
            bin();
        } else {
            this.hHy = str;
            this.hHC = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.hHE) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.hHz = new EmotionImageData();
                this.hHz.setPicId(uploadedPicInfo.getPic_id());
                this.hHz.setWidth(uploadedPicInfo.getWidth());
                this.hHz.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.hnb.getMemeContSign())) {
                    this.hHz.setMemeContSign(this.hnb.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.hHz.setPicUrl(picinfo.originPic.picUrl);
                    this.hHz.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.hHz.setMemeText(this.hHw.getText());
                this.hHz.setAuthorNameShow(this.hnb.getAuthorNameShow());
                bPB();
                return;
            }
            showToast(d.j.upload_error);
            this.hHC = 3;
            bin();
            return;
        }
        showToast(d.j.upload_error);
        this.hHC = 3;
        bin();
    }
}
