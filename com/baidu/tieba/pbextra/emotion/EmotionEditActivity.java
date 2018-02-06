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
    private a bQQ;
    private b dWZ;
    private ImageView ekY;
    private Bitmap gfA;
    private long gfB;
    private EmotionEditLayout gfo;
    private EmotionImageData gfp;
    private View gfq;
    private ChooseColorLayout gfr;
    private int gfs;
    private com.baidu.tieba.pbextra.emotion.view.b gft;
    private EmotionEditModel gfu;
    private String gfv;
    private EmotionImageData gfw;
    private boolean gfx;
    private String gfy;
    private int gfz = 0;
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
        this.gfp = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.gfu = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0140d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dWZ = new b(getPageContext());
        this.dWZ.ga(d.j.emotion_composition);
        this.dWZ.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.gfu.ln(true);
                EmotionEditActivity.this.bhN();
                EmotionEditActivity.this.azT();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_layout);
        this.gfo = (EmotionEditLayout) findViewById(d.g.edit_container);
        this.ekY = (ImageView) findViewById(d.g.close);
        this.gfq = findViewById(d.g.send);
        this.gfr = (ChooseColorLayout) findViewById(d.g.choose_color_layout);
        this.gfr.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void tt(int i) {
                EmotionEditActivity.this.gft.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.ekY.setOnClickListener(this);
        this.gfq.setOnClickListener(this);
        this.gfs = l.ao(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds300);
        bhM();
        bhL();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gfo.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        this.gfo.setLayoutParams(layoutParams);
        this.gft.cu(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.gfo.a(this.gft);
        this.gfr.setVisibility(8);
    }

    private void bhL() {
        this.gft = new com.baidu.tieba.pbextra.emotion.view.b(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.gfo.addView(this.gft, layoutParams);
        this.gft.setTextColor(this.gfr.getCurrentChooseColor());
        this.gft.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.gft.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.gft.getEditText());
                }
            }
        });
    }

    private void bhM() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.gfp.getPicUrl();
            gifInfo.mDynamicUrl = this.gfp.getPicUrl();
            gifInfo.mStaticUrl = this.gfp.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.gfp.getPicUrl(), 10, true);
            c.nm().a(this.gfp.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.gfp.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.gfp.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.gfp.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.gfp.getWidth();
        this.mImageHeight = this.gfp.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.gfs;
            this.mImageHeight = this.gfs;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.gfs / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.gfs;
        } else {
            this.mImageWidth = (int) ((this.gfs / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.gfs;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.gfo.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ekY) {
            finish();
        } else if (view == this.gfq) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.gft.getEditText());
        }
    }

    private void send() {
        if (!j.oJ()) {
            showToast(d.j.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bQQ == null) {
            this.bQQ = new a();
        }
        this.bQQ.DI();
        this.bQQ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bQQ.v(pageActivity) && !this.gfx) {
            this.gfu.ln(false);
            this.gfx = true;
            this.gfB = System.currentTimeMillis();
            this.dWZ.bq(true);
            HidenSoftKeyPad(this.mInputManager, this.gft.getEditText());
            if (TextUtils.isEmpty(this.gft.getText())) {
                this.gfw = this.gfp;
                bhQ();
                return;
            }
            String text = this.gft.getText();
            switch (this.gfz) {
                case 2:
                    if (!TextUtils.isEmpty(this.gfy) && this.gfy.equals(text)) {
                        bhS();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.gfy) && this.gfy.equals(text) && !TextUtils.isEmpty(this.gfv)) {
                        qQ(this.gfv);
                        return;
                    }
                    break;
            }
            bhN();
            this.gfy = this.gft.getText();
            bhO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhN() {
        if (this.gfA != null && !this.gfA.isRecycled()) {
            this.gfA.recycle();
            this.gfA = null;
        }
    }

    private void bhO() {
        this.gfu.qR(this.gft.getText());
    }

    private void bhP() {
        if (!this.gfu.mU()) {
            this.gft.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.C0140d.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.gfu.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.a.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.gfu.mU()) {
                        Bitmap p = p(bdImage.sh());
                        if (p != null) {
                            this.gfu.b(p, f.ame + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.j.upload_error);
                        this.gfz = 2;
                        azT();
                        return;
                    }
                    return;
                }
                showToast(d.j.upload_error);
                this.gfz = 2;
                azT();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.gfv)) {
            azT();
        } else {
            this.gfu.S(this.gfv, true);
        }
    }

    private void bhQ() {
        if (!this.gfu.mU()) {
            this.gfz = 0;
            azT();
            if (this.gfw != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.gfw);
                setResult(-1, intent);
                finish();
                bhR();
                if (!TextUtils.isEmpty(this.gfv)) {
                    File file = new File(this.gfv);
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
        if (!TextUtils.isEmpty(this.gft.getText())) {
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
        if (!TextUtils.isEmpty(this.gft.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap ct = ct(width, height);
            if (ct != null) {
                canvas.drawBitmap(ct, (width * this.gft.getLeft()) / i, (height * this.gft.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap ct(int i, int i2) {
        if (this.gfA != null) {
            return this.gfA;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.gft.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.gft.getTextView().getDrawingCache();
        this.gfA = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.gfA = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.gfA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.gfr.setVisibility(0);
            this.gft.bin();
            return;
        }
        this.gfr.setVisibility(8);
        this.gft.bim();
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
        aj.t(this.mRootView, d.C0140d.black_alpha40);
        aj.c(this.ekY, d.f.icon_emotion_close_n);
        aj.r(this.gfq, d.C0140d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bhN();
        if (this.gfu != null) {
            this.gfu.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bhS() {
        bhP();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void qP(String str) {
        showToast(str);
        this.gfz = 1;
        azT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azT() {
        this.gft.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        this.dWZ.bq(false);
        this.gfx = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void qQ(String str) {
        this.gft.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            azT();
        } else if (!new File(str).exists()) {
            azT();
        } else {
            this.gfv = str;
            this.gfz = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.gfB) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.gfw = new EmotionImageData();
                this.gfw.setPicId(uploadedPicInfo.getPic_id());
                this.gfw.setWidth(uploadedPicInfo.getWidth());
                this.gfw.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.gfp.getMemeContSign())) {
                    this.gfw.setMemeContSign(this.gfp.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.gfw.setPicUrl(picinfo.originPic.picUrl);
                    this.gfw.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.gfw.setMemeText(this.gft.getText());
                this.gfw.setAuthorNameShow(this.gfp.getAuthorNameShow());
                bhQ();
                return;
            }
            showToast(d.j.upload_error);
            this.gfz = 3;
            azT();
            return;
        }
        showToast(d.j.upload_error);
        this.gfz = 3;
        azT();
    }
}
