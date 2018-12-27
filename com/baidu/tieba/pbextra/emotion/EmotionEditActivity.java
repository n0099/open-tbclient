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
    private ImageView bmS;
    private a bzi;
    private d dCS;
    private ImageView eAf;
    private EmotionImageData fWe;
    private int gqA = 0;
    private Bitmap gqB;
    private long gqC;
    private EmotionEditLayout gqq;
    private View gqr;
    private ChooseColorLayout gqs;
    private int gqt;
    private EmotionEditText gqu;
    private EmotionEditModel gqv;
    private String gqw;
    private EmotionImageData gqx;
    private boolean gqy;
    private String gqz;
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
        this.fWe = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.gqv = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(e.d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dCS = new d(getPageContext());
        this.dCS.ec(e.j.emotion_composition);
        this.dCS.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.gqv.lW(true);
                EmotionEditActivity.this.bou();
                EmotionEditActivity.this.aHD();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(e.g.root_layout);
        this.gqq = (EmotionEditLayout) findViewById(e.g.edit_container);
        this.eAf = (ImageView) findViewById(e.g.close);
        this.gqr = findViewById(e.g.send);
        this.gqs = (ChooseColorLayout) findViewById(e.g.choose_color_layout);
        this.gqs.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void tb(int i) {
                EmotionEditActivity.this.gqu.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.eAf.setOnClickListener(this);
        this.gqr.setOnClickListener(this);
        this.gqt = l.aO(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds300);
        bot();
        bos();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gqq.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds80);
        this.gqq.setLayoutParams(layoutParams);
        this.gqu.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds40));
        this.gqq.a(this.gqu);
        this.gqs.setVisibility(8);
    }

    private void bos() {
        this.gqu = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds40));
        this.gqq.addView(this.gqu, layoutParams);
        this.gqu.setTextColor(this.gqs.getCurrentChooseColor());
        this.gqu.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.gqu.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.gqu.getEditText());
                }
            }
        });
    }

    private void bot() {
        if (this.mIsGif) {
            this.bmS = new GifView(getPageContext().getPageActivity());
            ((GifView) this.bmS).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.fWe.getPicUrl();
            gifInfo.mDynamicUrl = this.fWe.getPicUrl();
            gifInfo.mStaticUrl = this.fWe.getThumbUrl();
            this.bmS.setTag(gifInfo.mSharpText);
            ((GifView) this.bmS).a(gifInfo);
        } else {
            this.bmS = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.bmS).setGifIconSupport(false);
            ((TbImageView) this.bmS).setAutoChangeStyle(false);
            ((TbImageView) this.bmS).startLoad(this.fWe.getPicUrl(), 10, true);
            c.jA().a(this.fWe.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.bmS);
                            EmotionEditActivity.this.bmS = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.bmS).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.fWe.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.fWe.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.fWe.getThumbUrl();
                            EmotionEditActivity.this.bmS.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.bmS).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.fWe.getWidth();
        this.mImageHeight = this.fWe.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.gqt;
            this.mImageHeight = this.gqt;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.gqt / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.gqt;
        } else {
            this.mImageWidth = (int) ((this.gqt / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.gqt;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.gqq.addView(this.bmS, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eAf) {
            finish();
        } else if (view == this.gqr) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.gqu.getEditText());
        }
    }

    private void send() {
        if (!j.kV()) {
            showToast(e.j.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bzi == null) {
            this.bzi = new a();
        }
        this.bzi.Et();
        this.bzi.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bzi.A(pageActivity) && !this.gqy) {
            this.gqv.lW(false);
            this.gqy = true;
            this.gqC = System.currentTimeMillis();
            this.dCS.bA(true);
            HidenSoftKeyPad(this.mInputManager, this.gqu.getEditText());
            if (TextUtils.isEmpty(this.gqu.getText())) {
                this.gqx = this.fWe;
                box();
                return;
            }
            String text = this.gqu.getText();
            switch (this.gqA) {
                case 2:
                    if (!TextUtils.isEmpty(this.gqz) && this.gqz.equals(text)) {
                        boz();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.gqz) && this.gqz.equals(text) && !TextUtils.isEmpty(this.gqw)) {
                        ty(this.gqw);
                        return;
                    }
                    break;
            }
            bou();
            this.gqz = this.gqu.getText();
            bov();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bou() {
        if (this.gqB != null && !this.gqB.isRecycled()) {
            this.gqB.recycle();
            this.gqB = null;
        }
    }

    private void bov() {
        this.gqv.tz(this.gqu.getText());
    }

    private void bow() {
        if (!this.gqv.ji()) {
            this.gqu.getTextView().setBackgroundColor(getPageContext().getResources().getColor(e.d.transparent));
            if (this.mIsGif) {
                if (this.bmS instanceof GifView) {
                    ((GifView) this.bmS).pause();
                    this.gqv.a(((GifView) this.bmS).getGif());
                }
            } else if (this.bmS instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.bmS).getBdImage();
                if (bdImage != null) {
                    if (!this.gqv.ji()) {
                        Bitmap s = s(bdImage.op());
                        if (s != null) {
                            this.gqv.b(s, f.FL + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(e.j.upload_error);
                        this.gqA = 2;
                        aHD();
                        return;
                    }
                    return;
                }
                showToast(e.j.upload_error);
                this.gqA = 2;
                aHD();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.gqw)) {
            aHD();
        } else {
            this.gqv.X(this.gqw, true);
        }
    }

    private void box() {
        if (!this.gqv.ji()) {
            this.gqA = 0;
            aHD();
            if (this.gqx != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.gqx);
                setResult(-1, intent);
                finish();
                boy();
                if (!TextUtils.isEmpty(this.gqw)) {
                    File file = new File(this.gqw);
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

    private void boy() {
        am amVar = new am("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                amVar.x("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                amVar.x("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.gqu.getText())) {
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
        if (!TextUtils.isEmpty(this.gqu.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bB = bB(width, height);
            if (bB != null) {
                canvas.drawBitmap(bB, (width * this.gqu.getLeft()) / i, (height * this.gqu.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bB(int i, int i2) {
        if (this.gqB != null) {
            return this.gqB;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.gqu.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.gqu.getTextView().getDrawingCache();
        this.gqB = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.gqB = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.gqB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.gqs.setVisibility(0);
            this.gqu.boT();
            return;
        }
        this.gqs.setVisibility(8);
        this.gqu.boS();
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
        al.c(this.eAf, e.f.icon_emotion_close_n);
        al.h(this.gqr, e.d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bou();
        if (this.gqv != null) {
            this.gqv.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void boz() {
        bow();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void tx(String str) {
        showToast(str);
        this.gqA = 1;
        aHD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHD() {
        this.gqu.getTextView().setBackgroundResource(e.f.bg_emotion_edit);
        this.dCS.bA(false);
        this.gqy = false;
        if (this.mIsGif) {
            ((GifView) this.bmS).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void ty(String str) {
        this.gqu.getTextView().setBackgroundResource(e.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            aHD();
        } else if (!new File(str).exists()) {
            aHD();
        } else {
            this.gqw = str;
            this.gqA = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.gqC) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.gqx = new EmotionImageData();
                this.gqx.setPicId(uploadedPicInfo.getPic_id());
                this.gqx.setWidth(uploadedPicInfo.getWidth());
                this.gqx.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.fWe.getMemeContSign())) {
                    this.gqx.setMemeContSign(this.fWe.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.gqx.setPicUrl(picinfo.originPic.picUrl);
                    this.gqx.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.gqx.setMemeText(this.gqu.getText());
                this.gqx.setAuthorNameShow(this.fWe.getAuthorNameShow());
                box();
                return;
            }
            showToast(e.j.upload_error);
            this.gqA = 3;
            aHD();
            return;
        }
        showToast(e.j.upload_error);
        this.gqA = 3;
        aHD();
    }
}
