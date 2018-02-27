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
    private a bQD;
    private b dWN;
    private ImageView ekM;
    private EmotionEditLayout gfd;
    private EmotionImageData gfe;
    private View gff;
    private ChooseColorLayout gfg;
    private int gfh;
    private com.baidu.tieba.pbextra.emotion.view.b gfi;
    private EmotionEditModel gfj;
    private String gfk;
    private EmotionImageData gfl;
    private boolean gfm;
    private String gfn;
    private int gfo = 0;
    private Bitmap gfp;
    private long gfq;
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
        this.gfe = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.gfj = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0141d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dWN = new b(getPageContext());
        this.dWN.ga(d.j.emotion_composition);
        this.dWN.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.gfj.ln(true);
                EmotionEditActivity.this.bhM();
                EmotionEditActivity.this.azS();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_layout);
        this.gfd = (EmotionEditLayout) findViewById(d.g.edit_container);
        this.ekM = (ImageView) findViewById(d.g.close);
        this.gff = findViewById(d.g.send);
        this.gfg = (ChooseColorLayout) findViewById(d.g.choose_color_layout);
        this.gfg.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void tu(int i) {
                EmotionEditActivity.this.gfi.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.ekM.setOnClickListener(this);
        this.gff.setOnClickListener(this);
        this.gfh = l.ao(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds300);
        bhL();
        bhK();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gfd.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        this.gfd.setLayoutParams(layoutParams);
        this.gfi.cu(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.gfd.a(this.gfi);
        this.gfg.setVisibility(8);
    }

    private void bhK() {
        this.gfi = new com.baidu.tieba.pbextra.emotion.view.b(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.gfd.addView(this.gfi, layoutParams);
        this.gfi.setTextColor(this.gfg.getCurrentChooseColor());
        this.gfi.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.gfi.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.gfi.getEditText());
                }
            }
        });
    }

    private void bhL() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.gfe.getPicUrl();
            gifInfo.mDynamicUrl = this.gfe.getPicUrl();
            gifInfo.mStaticUrl = this.gfe.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.gfe.getPicUrl(), 10, true);
            c.nm().a(this.gfe.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.gfe.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.gfe.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.gfe.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.gfe.getWidth();
        this.mImageHeight = this.gfe.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.gfh;
            this.mImageHeight = this.gfh;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.gfh / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.gfh;
        } else {
            this.mImageWidth = (int) ((this.gfh / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.gfh;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.gfd.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ekM) {
            finish();
        } else if (view == this.gff) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.gfi.getEditText());
        }
    }

    private void send() {
        if (!j.oJ()) {
            showToast(d.j.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bQD == null) {
            this.bQD = new a();
        }
        this.bQD.DH();
        this.bQD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bQD.v(pageActivity) && !this.gfm) {
            this.gfj.ln(false);
            this.gfm = true;
            this.gfq = System.currentTimeMillis();
            this.dWN.bq(true);
            HidenSoftKeyPad(this.mInputManager, this.gfi.getEditText());
            if (TextUtils.isEmpty(this.gfi.getText())) {
                this.gfl = this.gfe;
                bhP();
                return;
            }
            String text = this.gfi.getText();
            switch (this.gfo) {
                case 2:
                    if (!TextUtils.isEmpty(this.gfn) && this.gfn.equals(text)) {
                        bhR();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.gfn) && this.gfn.equals(text) && !TextUtils.isEmpty(this.gfk)) {
                        qQ(this.gfk);
                        return;
                    }
                    break;
            }
            bhM();
            this.gfn = this.gfi.getText();
            bhN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhM() {
        if (this.gfp != null && !this.gfp.isRecycled()) {
            this.gfp.recycle();
            this.gfp = null;
        }
    }

    private void bhN() {
        this.gfj.qR(this.gfi.getText());
    }

    private void bhO() {
        if (!this.gfj.mU()) {
            this.gfi.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.C0141d.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.gfj.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.a.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.gfj.mU()) {
                        Bitmap p = p(bdImage.sh());
                        if (p != null) {
                            this.gfj.b(p, f.alY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.j.upload_error);
                        this.gfo = 2;
                        azS();
                        return;
                    }
                    return;
                }
                showToast(d.j.upload_error);
                this.gfo = 2;
                azS();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.gfk)) {
            azS();
        } else {
            this.gfj.R(this.gfk, true);
        }
    }

    private void bhP() {
        if (!this.gfj.mU()) {
            this.gfo = 0;
            azS();
            if (this.gfl != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.gfl);
                setResult(-1, intent);
                finish();
                bhQ();
                if (!TextUtils.isEmpty(this.gfk)) {
                    File file = new File(this.gfk);
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

    private void bhQ() {
        ak akVar = new ak("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                akVar.s("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                akVar.s("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.gfi.getText())) {
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
        if (!TextUtils.isEmpty(this.gfi.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap ct = ct(width, height);
            if (ct != null) {
                canvas.drawBitmap(ct, (width * this.gfi.getLeft()) / i, (height * this.gfi.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap ct(int i, int i2) {
        if (this.gfp != null) {
            return this.gfp;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.gfi.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.gfi.getTextView().getDrawingCache();
        this.gfp = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.gfp = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.gfp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.gfg.setVisibility(0);
            this.gfi.bim();
            return;
        }
        this.gfg.setVisibility(8);
        this.gfi.bil();
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
        aj.c(this.ekM, d.f.icon_emotion_close_n);
        aj.r(this.gff, d.C0141d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bhM();
        if (this.gfj != null) {
            this.gfj.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bhR() {
        bhO();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void qP(String str) {
        showToast(str);
        this.gfo = 1;
        azS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azS() {
        this.gfi.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        this.dWN.bq(false);
        this.gfm = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void qQ(String str) {
        this.gfi.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            azS();
        } else if (!new File(str).exists()) {
            azS();
        } else {
            this.gfk = str;
            this.gfo = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.gfq) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.gfl = new EmotionImageData();
                this.gfl.setPicId(uploadedPicInfo.getPic_id());
                this.gfl.setWidth(uploadedPicInfo.getWidth());
                this.gfl.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.gfe.getMemeContSign())) {
                    this.gfl.setMemeContSign(this.gfe.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.gfl.setPicUrl(picinfo.originPic.picUrl);
                    this.gfl.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.gfl.setMemeText(this.gfi.getText());
                this.gfl.setAuthorNameShow(this.gfe.getAuthorNameShow());
                bhP();
                return;
            }
            showToast(d.j.upload_error);
            this.gfo = 3;
            azS();
            return;
        }
        showToast(d.j.upload_error);
        this.gfo = 3;
        azS();
    }
}
