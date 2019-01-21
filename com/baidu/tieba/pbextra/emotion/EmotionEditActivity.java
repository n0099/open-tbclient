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
    private ImageView bnH;
    private d dDC;
    private ImageView eAR;
    private EmotionImageData fXc;
    private EmotionEditModel grA;
    private String grB;
    private EmotionImageData grC;
    private boolean grD;
    private String grE;
    private int grF = 0;
    private Bitmap grG;
    private long grH;
    private EmotionEditLayout grv;
    private View grw;
    private ChooseColorLayout grx;
    private int gry;
    private EmotionEditText grz;
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
        setContentView(e.h.emotion_edit_activity);
        this.fXc = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.grA = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(e.d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dDC = new d(getPageContext());
        this.dDC.ec(e.j.emotion_composition);
        this.dDC.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.grA.lW(true);
                EmotionEditActivity.this.bpd();
                EmotionEditActivity.this.aIa();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(e.g.root_layout);
        this.grv = (EmotionEditLayout) findViewById(e.g.edit_container);
        this.eAR = (ImageView) findViewById(e.g.close);
        this.grw = findViewById(e.g.send);
        this.grx = (ChooseColorLayout) findViewById(e.g.choose_color_layout);
        this.grx.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void tf(int i) {
                EmotionEditActivity.this.grz.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.eAR.setOnClickListener(this);
        this.grw.setOnClickListener(this);
        this.gry = l.aO(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds300);
        bpc();
        bpb();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.grv.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds80);
        this.grv.setLayoutParams(layoutParams);
        this.grz.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds40));
        this.grv.a(this.grz);
        this.grx.setVisibility(8);
    }

    private void bpb() {
        this.grz = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds40));
        this.grv.addView(this.grz, layoutParams);
        this.grz.setTextColor(this.grx.getCurrentChooseColor());
        this.grz.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.grz.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.grz.getEditText());
                }
            }
        });
    }

    private void bpc() {
        if (this.mIsGif) {
            this.bnH = new GifView(getPageContext().getPageActivity());
            ((GifView) this.bnH).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.fXc.getPicUrl();
            gifInfo.mDynamicUrl = this.fXc.getPicUrl();
            gifInfo.mStaticUrl = this.fXc.getThumbUrl();
            this.bnH.setTag(gifInfo.mSharpText);
            ((GifView) this.bnH).a(gifInfo);
        } else {
            this.bnH = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.bnH).setGifIconSupport(false);
            ((TbImageView) this.bnH).setAutoChangeStyle(false);
            ((TbImageView) this.bnH).startLoad(this.fXc.getPicUrl(), 10, true);
            c.jA().a(this.fXc.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.bnH);
                            EmotionEditActivity.this.bnH = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.bnH).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.fXc.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.fXc.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.fXc.getThumbUrl();
                            EmotionEditActivity.this.bnH.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.bnH).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.fXc.getWidth();
        this.mImageHeight = this.fXc.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.gry;
            this.mImageHeight = this.gry;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.gry / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.gry;
        } else {
            this.mImageWidth = (int) ((this.gry / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.gry;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.grv.addView(this.bnH, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eAR) {
            finish();
        } else if (view == this.grw) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.grz.getEditText());
        }
    }

    private void send() {
        if (!j.kV()) {
            showToast(e.j.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new a();
        }
        this.mPermissionJudgement.EG();
        this.mPermissionJudgement.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.B(pageActivity) && !this.grD) {
            this.grA.lW(false);
            this.grD = true;
            this.grH = System.currentTimeMillis();
            this.dDC.bB(true);
            HidenSoftKeyPad(this.mInputManager, this.grz.getEditText());
            if (TextUtils.isEmpty(this.grz.getText())) {
                this.grC = this.fXc;
                bpg();
                return;
            }
            String text = this.grz.getText();
            switch (this.grF) {
                case 2:
                    if (!TextUtils.isEmpty(this.grE) && this.grE.equals(text)) {
                        bpi();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.grE) && this.grE.equals(text) && !TextUtils.isEmpty(this.grB)) {
                        tO(this.grB);
                        return;
                    }
                    break;
            }
            bpd();
            this.grE = this.grz.getText();
            bpe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpd() {
        if (this.grG != null && !this.grG.isRecycled()) {
            this.grG.recycle();
            this.grG = null;
        }
    }

    private void bpe() {
        this.grA.tP(this.grz.getText());
    }

    private void bpf() {
        if (!this.grA.ji()) {
            this.grz.getTextView().setBackgroundColor(getPageContext().getResources().getColor(e.d.transparent));
            if (this.mIsGif) {
                if (this.bnH instanceof GifView) {
                    ((GifView) this.bnH).pause();
                    this.grA.a(((GifView) this.bnH).getGif());
                }
            } else if (this.bnH instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.bnH).getBdImage();
                if (bdImage != null) {
                    if (!this.grA.ji()) {
                        Bitmap s = s(bdImage.ot());
                        if (s != null) {
                            this.grA.b(s, f.FL + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(e.j.upload_error);
                        this.grF = 2;
                        aIa();
                        return;
                    }
                    return;
                }
                showToast(e.j.upload_error);
                this.grF = 2;
                aIa();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.grB)) {
            aIa();
        } else {
            this.grA.W(this.grB, true);
        }
    }

    private void bpg() {
        if (!this.grA.ji()) {
            this.grF = 0;
            aIa();
            if (this.grC != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.grC);
                setResult(-1, intent);
                finish();
                bph();
                if (!TextUtils.isEmpty(this.grB)) {
                    File file = new File(this.grB);
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

    private void bph() {
        am amVar = new am("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                amVar.y("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                amVar.y("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.grz.getText())) {
            amVar.y("obj_type", 1);
        } else {
            amVar.y("obj_type", 2);
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
        if (!TextUtils.isEmpty(this.grz.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bB = bB(width, height);
            if (bB != null) {
                canvas.drawBitmap(bB, (width * this.grz.getLeft()) / i, (height * this.grz.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bB(int i, int i2) {
        if (this.grG != null) {
            return this.grG;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.grz.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.grz.getTextView().getDrawingCache();
        this.grG = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.grG = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.grG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.grx.setVisibility(0);
            this.grz.bpC();
            return;
        }
        this.grx.setVisibility(8);
        this.grz.bpB();
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
        al.c(this.eAR, e.f.icon_emotion_close_n);
        al.h(this.grw, e.d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bpd();
        if (this.grA != null) {
            this.grA.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bpi() {
        bpf();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void tN(String str) {
        showToast(str);
        this.grF = 1;
        aIa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIa() {
        this.grz.getTextView().setBackgroundResource(e.f.bg_emotion_edit);
        this.dDC.bB(false);
        this.grD = false;
        if (this.mIsGif) {
            ((GifView) this.bnH).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void tO(String str) {
        this.grz.getTextView().setBackgroundResource(e.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            aIa();
        } else if (!new File(str).exists()) {
            aIa();
        } else {
            this.grB = str;
            this.grF = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.grH) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.grC = new EmotionImageData();
                this.grC.setPicId(uploadedPicInfo.getPic_id());
                this.grC.setWidth(uploadedPicInfo.getWidth());
                this.grC.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.fXc.getMemeContSign())) {
                    this.grC.setMemeContSign(this.fXc.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.grC.setPicUrl(picinfo.originPic.picUrl);
                    this.grC.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.grC.setMemeText(this.grz.getText());
                this.grC.setAuthorNameShow(this.fXc.getAuthorNameShow());
                bpg();
                return;
            }
            showToast(e.j.upload_error);
            this.grF = 3;
            aIa();
            return;
        }
        showToast(e.j.upload_error);
        this.grF = 3;
        aIa();
    }
}
