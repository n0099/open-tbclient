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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
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
import java.io.File;
/* loaded from: classes3.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private a bQG;
    private b dWT;
    private ImageView elc;
    private String gfA;
    private EmotionImageData gfB;
    private boolean gfC;
    private String gfD;
    private int gfE = 0;
    private Bitmap gfF;
    private long gfG;
    private EmotionEditLayout gft;
    private EmotionImageData gfu;
    private View gfv;
    private ChooseColorLayout gfw;
    private int gfx;
    private com.baidu.tieba.pbextra.emotion.view.b gfy;
    private EmotionEditModel gfz;
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
        setContentView(d.h.emotion_edit_activity);
        this.gfu = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.gfz = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0141d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dWT = new b(getPageContext());
        this.dWT.ga(d.j.emotion_composition);
        this.dWT.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.gfz.ls(true);
                EmotionEditActivity.this.bhN();
                EmotionEditActivity.this.azU();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_layout);
        this.gft = (EmotionEditLayout) findViewById(d.g.edit_container);
        this.elc = (ImageView) findViewById(d.g.close);
        this.gfv = findViewById(d.g.send);
        this.gfw = (ChooseColorLayout) findViewById(d.g.choose_color_layout);
        this.gfw.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void tu(int i) {
                EmotionEditActivity.this.gfy.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.elc.setOnClickListener(this);
        this.gfv.setOnClickListener(this);
        this.gfx = l.ao(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds300);
        bhM();
        bhL();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gft.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        this.gft.setLayoutParams(layoutParams);
        this.gfy.cu(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.gft.a(this.gfy);
        this.gfw.setVisibility(8);
    }

    private void bhL() {
        this.gfy = new com.baidu.tieba.pbextra.emotion.view.b(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.gft.addView(this.gfy, layoutParams);
        this.gfy.setTextColor(this.gfw.getCurrentChooseColor());
        this.gfy.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.gfy.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.gfy.getEditText());
                }
            }
        });
    }

    private void bhM() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.gfu.getPicUrl();
            gifInfo.mDynamicUrl = this.gfu.getPicUrl();
            gifInfo.mStaticUrl = this.gfu.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.gfu.getPicUrl(), 10, true);
            c.nm().a(this.gfu.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.mImageView);
                            EmotionEditActivity.this.mImageView = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.mImageView).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.gfu.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.gfu.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.gfu.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.gfu.getWidth();
        this.mImageHeight = this.gfu.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.gfx;
            this.mImageHeight = this.gfx;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.gfx / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.gfx;
        } else {
            this.mImageWidth = (int) ((this.gfx / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.gfx;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.gft.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.elc) {
            finish();
        } else if (view == this.gfv) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.gfy.getEditText());
        }
    }

    private void send() {
        if (!j.oJ()) {
            showToast(d.j.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bQG == null) {
            this.bQG = new a();
        }
        this.bQG.DI();
        this.bQG.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bQG.v(pageActivity) && !this.gfC) {
            this.gfz.ls(false);
            this.gfC = true;
            this.gfG = System.currentTimeMillis();
            this.dWT.bq(true);
            HidenSoftKeyPad(this.mInputManager, this.gfy.getEditText());
            if (TextUtils.isEmpty(this.gfy.getText())) {
                this.gfB = this.gfu;
                bhQ();
                return;
            }
            String text = this.gfy.getText();
            switch (this.gfE) {
                case 2:
                    if (!TextUtils.isEmpty(this.gfD) && this.gfD.equals(text)) {
                        bhS();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.gfD) && this.gfD.equals(text) && !TextUtils.isEmpty(this.gfA)) {
                        qQ(this.gfA);
                        return;
                    }
                    break;
            }
            bhN();
            this.gfD = this.gfy.getText();
            bhO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhN() {
        if (this.gfF != null && !this.gfF.isRecycled()) {
            this.gfF.recycle();
            this.gfF = null;
        }
    }

    private void bhO() {
        this.gfz.qR(this.gfy.getText());
    }

    private void bhP() {
        if (!this.gfz.mU()) {
            this.gfy.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.C0141d.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.gfz.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.a.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.gfz.mU()) {
                        Bitmap p = p(bdImage.sh());
                        if (p != null) {
                            this.gfz.b(p, f.alY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.j.upload_error);
                        this.gfE = 2;
                        azU();
                        return;
                    }
                    return;
                }
                showToast(d.j.upload_error);
                this.gfE = 2;
                azU();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.gfA)) {
            azU();
        } else {
            this.gfz.R(this.gfA, true);
        }
    }

    private void bhQ() {
        if (!this.gfz.mU()) {
            this.gfE = 0;
            azU();
            if (this.gfB != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.gfB);
                setResult(-1, intent);
                finish();
                bhR();
                if (!TextUtils.isEmpty(this.gfA)) {
                    File file = new File(this.gfA);
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

    private void bhR() {
        ak akVar = new ak("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                akVar.s("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                akVar.s("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.gfy.getText())) {
            akVar.s("obj_type", 1);
        } else {
            akVar.s("obj_type", 2);
        }
        TiebaStatic.log(akVar);
    }

    public Bitmap p(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.gfy.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap ct = ct(width, height);
            if (ct != null) {
                canvas.drawBitmap(ct, (width * this.gfy.getLeft()) / i, (height * this.gfy.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap ct(int i, int i2) {
        if (this.gfF != null) {
            return this.gfF;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.gfy.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.gfy.getTextView().getDrawingCache();
        this.gfF = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.gfF = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.gfF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.gfw.setVisibility(0);
            this.gfy.bin();
            return;
        }
        this.gfw.setVisibility(8);
        this.gfy.bim();
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
        aj.t(this.mRootView, d.C0141d.black_alpha40);
        aj.c(this.elc, d.f.icon_emotion_close_n);
        aj.r(this.gfv, d.C0141d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bhN();
        if (this.gfz != null) {
            this.gfz.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bhS() {
        bhP();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void qP(String str) {
        showToast(str);
        this.gfE = 1;
        azU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azU() {
        this.gfy.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        this.dWT.bq(false);
        this.gfC = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void qQ(String str) {
        this.gfy.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            azU();
        } else if (!new File(str).exists()) {
            azU();
        } else {
            this.gfA = str;
            this.gfE = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.gfG) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.gfB = new EmotionImageData();
                this.gfB.setPicId(uploadedPicInfo.getPic_id());
                this.gfB.setWidth(uploadedPicInfo.getWidth());
                this.gfB.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.gfu.getMemeContSign())) {
                    this.gfB.setMemeContSign(this.gfu.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.gfB.setPicUrl(picinfo.originPic.picUrl);
                    this.gfB.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.gfB.setMemeText(this.gfy.getText());
                this.gfB.setAuthorNameShow(this.gfu.getAuthorNameShow());
                bhQ();
                return;
            }
            showToast(d.j.upload_error);
            this.gfE = 3;
            azU();
            return;
        }
        showToast(d.j.upload_error);
        this.gfE = 3;
        azU();
    }
}
