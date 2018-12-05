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
    private ImageView bmP;
    private a bzf;
    private d dAf;
    private ImageView exm;
    private EmotionImageData fTm;
    private View gnA;
    private ChooseColorLayout gnB;
    private int gnC;
    private EmotionEditText gnD;
    private EmotionEditModel gnE;
    private String gnF;
    private EmotionImageData gnG;
    private boolean gnH;
    private String gnI;
    private int gnJ = 0;
    private Bitmap gnK;
    private long gnL;
    private EmotionEditLayout gnz;
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
        this.fTm = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.gnE = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(e.d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dAf = new d(getPageContext());
        this.dAf.ec(e.j.emotion_composition);
        this.dAf.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.gnE.lT(true);
                EmotionEditActivity.this.bnJ();
                EmotionEditActivity.this.aGO();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(e.g.root_layout);
        this.gnz = (EmotionEditLayout) findViewById(e.g.edit_container);
        this.exm = (ImageView) findViewById(e.g.close);
        this.gnA = findViewById(e.g.send);
        this.gnB = (ChooseColorLayout) findViewById(e.g.choose_color_layout);
        this.gnB.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void sO(int i) {
                EmotionEditActivity.this.gnD.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.exm.setOnClickListener(this);
        this.gnA.setOnClickListener(this);
        this.gnC = l.aO(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds300);
        bnI();
        bnH();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gnz.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds80);
        this.gnz.setLayoutParams(layoutParams);
        this.gnD.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds40));
        this.gnz.a(this.gnD);
        this.gnB.setVisibility(8);
    }

    private void bnH() {
        this.gnD = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds40));
        this.gnz.addView(this.gnD, layoutParams);
        this.gnD.setTextColor(this.gnB.getCurrentChooseColor());
        this.gnD.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.gnD.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.gnD.getEditText());
                }
            }
        });
    }

    private void bnI() {
        if (this.mIsGif) {
            this.bmP = new GifView(getPageContext().getPageActivity());
            ((GifView) this.bmP).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.fTm.getPicUrl();
            gifInfo.mDynamicUrl = this.fTm.getPicUrl();
            gifInfo.mStaticUrl = this.fTm.getThumbUrl();
            this.bmP.setTag(gifInfo.mSharpText);
            ((GifView) this.bmP).a(gifInfo);
        } else {
            this.bmP = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.bmP).setGifIconSupport(false);
            ((TbImageView) this.bmP).setAutoChangeStyle(false);
            ((TbImageView) this.bmP).startLoad(this.fTm.getPicUrl(), 10, true);
            c.jA().a(this.fTm.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.bmP);
                            EmotionEditActivity.this.bmP = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.bmP).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.fTm.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.fTm.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.fTm.getThumbUrl();
                            EmotionEditActivity.this.bmP.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.bmP).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.fTm.getWidth();
        this.mImageHeight = this.fTm.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.gnC;
            this.mImageHeight = this.gnC;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.gnC / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.gnC;
        } else {
            this.mImageWidth = (int) ((this.gnC / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.gnC;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.gnz.addView(this.bmP, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.exm) {
            finish();
        } else if (view == this.gnA) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.gnD.getEditText());
        }
    }

    private void send() {
        if (!j.kV()) {
            showToast(e.j.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bzf == null) {
            this.bzf = new a();
        }
        this.bzf.Et();
        this.bzf.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bzf.A(pageActivity) && !this.gnH) {
            this.gnE.lT(false);
            this.gnH = true;
            this.gnL = System.currentTimeMillis();
            this.dAf.bA(true);
            HidenSoftKeyPad(this.mInputManager, this.gnD.getEditText());
            if (TextUtils.isEmpty(this.gnD.getText())) {
                this.gnG = this.fTm;
                bnM();
                return;
            }
            String text = this.gnD.getText();
            switch (this.gnJ) {
                case 2:
                    if (!TextUtils.isEmpty(this.gnI) && this.gnI.equals(text)) {
                        bnO();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.gnI) && this.gnI.equals(text) && !TextUtils.isEmpty(this.gnF)) {
                        tv(this.gnF);
                        return;
                    }
                    break;
            }
            bnJ();
            this.gnI = this.gnD.getText();
            bnK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnJ() {
        if (this.gnK != null && !this.gnK.isRecycled()) {
            this.gnK.recycle();
            this.gnK = null;
        }
    }

    private void bnK() {
        this.gnE.tw(this.gnD.getText());
    }

    private void bnL() {
        if (!this.gnE.ji()) {
            this.gnD.getTextView().setBackgroundColor(getPageContext().getResources().getColor(e.d.transparent));
            if (this.mIsGif) {
                if (this.bmP instanceof GifView) {
                    ((GifView) this.bmP).pause();
                    this.gnE.a(((GifView) this.bmP).getGif());
                }
            } else if (this.bmP instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.bmP).getBdImage();
                if (bdImage != null) {
                    if (!this.gnE.ji()) {
                        Bitmap s = s(bdImage.op());
                        if (s != null) {
                            this.gnE.b(s, f.FL + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(e.j.upload_error);
                        this.gnJ = 2;
                        aGO();
                        return;
                    }
                    return;
                }
                showToast(e.j.upload_error);
                this.gnJ = 2;
                aGO();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.gnF)) {
            aGO();
        } else {
            this.gnE.X(this.gnF, true);
        }
    }

    private void bnM() {
        if (!this.gnE.ji()) {
            this.gnJ = 0;
            aGO();
            if (this.gnG != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.gnG);
                setResult(-1, intent);
                finish();
                bnN();
                if (!TextUtils.isEmpty(this.gnF)) {
                    File file = new File(this.gnF);
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

    private void bnN() {
        am amVar = new am("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                amVar.x("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                amVar.x("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.gnD.getText())) {
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
        if (!TextUtils.isEmpty(this.gnD.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bA = bA(width, height);
            if (bA != null) {
                canvas.drawBitmap(bA, (width * this.gnD.getLeft()) / i, (height * this.gnD.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bA(int i, int i2) {
        if (this.gnK != null) {
            return this.gnK;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.gnD.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.gnD.getTextView().getDrawingCache();
        this.gnK = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.gnK = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.gnK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.gnB.setVisibility(0);
            this.gnD.boi();
            return;
        }
        this.gnB.setVisibility(8);
        this.gnD.boh();
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
        al.c(this.exm, e.f.icon_emotion_close_n);
        al.h(this.gnA, e.d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bnJ();
        if (this.gnE != null) {
            this.gnE.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bnO() {
        bnL();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void tu(String str) {
        showToast(str);
        this.gnJ = 1;
        aGO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGO() {
        this.gnD.getTextView().setBackgroundResource(e.f.bg_emotion_edit);
        this.dAf.bA(false);
        this.gnH = false;
        if (this.mIsGif) {
            ((GifView) this.bmP).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void tv(String str) {
        this.gnD.getTextView().setBackgroundResource(e.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            aGO();
        } else if (!new File(str).exists()) {
            aGO();
        } else {
            this.gnF = str;
            this.gnJ = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.gnL) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.gnG = new EmotionImageData();
                this.gnG.setPicId(uploadedPicInfo.getPic_id());
                this.gnG.setWidth(uploadedPicInfo.getWidth());
                this.gnG.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.fTm.getMemeContSign())) {
                    this.gnG.setMemeContSign(this.fTm.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.gnG.setPicUrl(picinfo.originPic.picUrl);
                    this.gnG.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.gnG.setMemeText(this.gnD.getText());
                this.gnG.setAuthorNameShow(this.fTm.getAuthorNameShow());
                bnM();
                return;
            }
            showToast(e.j.upload_error);
            this.gnJ = 3;
            aGO();
            return;
        }
        showToast(e.j.upload_error);
        this.gnJ = 3;
        aGO();
    }
}
