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
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pbextra.emotion.model.EmotionEditModel;
import com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout;
import com.baidu.tieba.pbextra.emotion.view.EmotionEditLayout;
import com.baidu.tieba.pbextra.emotion.view.EmotionEditText;
import java.io.File;
/* loaded from: classes4.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView cGr;
    private b fgL;
    private ImageView geN;
    private EmotionImageData hED;
    private boolean hZA;
    private String hZB;
    private int hZC = 0;
    private Bitmap hZD;
    private long hZE;
    private EmotionEditLayout hZs;
    private View hZt;
    private ChooseColorLayout hZu;
    private int hZv;
    private EmotionEditText hZw;
    private EmotionEditModel hZx;
    private String hZy;
    private EmotionImageData hZz;
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
        setContentView(R.layout.emotion_edit_activity);
        this.hED = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.hZx = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.fgL = new b(getPageContext());
        this.fgL.it(R.string.emotion_composition);
        this.fgL.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.hZx.pi(true);
                EmotionEditActivity.this.bXr();
                EmotionEditActivity.this.bpD();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.hZs = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.geN = (ImageView) findViewById(R.id.close);
        this.hZt = findViewById(R.id.send);
        this.hZu = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.hZu.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void xR(int i) {
                EmotionEditActivity.this.hZw.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.geN.setOnClickListener(this);
        this.hZt.setOnClickListener(this);
        this.hZv = l.af(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        bXq();
        bXp();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZs.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.hZs.setLayoutParams(layoutParams);
        this.hZw.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.hZs.a(this.hZw);
        this.hZu.setVisibility(8);
    }

    private void bXp() {
        this.hZw = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.hZs.addView(this.hZw, layoutParams);
        this.hZw.setTextColor(this.hZu.getCurrentChooseColor());
        this.hZw.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.hZw.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.hZw.getEditText());
                }
            }
        });
    }

    private void bXq() {
        if (this.mIsGif) {
            this.cGr = new GifView(getPageContext().getPageActivity());
            ((GifView) this.cGr).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.hED.getPicUrl();
            gifInfo.mDynamicUrl = this.hED.getPicUrl();
            gifInfo.mStaticUrl = this.hED.getThumbUrl();
            this.cGr.setTag(gifInfo.mSharpText);
            ((GifView) this.cGr).a(gifInfo);
        } else {
            this.cGr = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.cGr).setGifIconSupport(false);
            ((TbImageView) this.cGr).setAutoChangeStyle(false);
            ((TbImageView) this.cGr).startLoad(this.hED.getPicUrl(), 10, true);
            c.iv().a(this.hED.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.cGr);
                            EmotionEditActivity.this.cGr = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.cGr).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.hED.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.hED.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.hED.getThumbUrl();
                            EmotionEditActivity.this.cGr.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.cGr).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.hED.getWidth();
        this.mImageHeight = this.hED.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.hZv;
            this.mImageHeight = this.hZv;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.hZv / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.hZv;
        } else {
            this.mImageWidth = (int) ((this.hZv / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.hZv;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.hZs.addView(this.cGr, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.geN) {
            finish();
        } else if (view == this.hZt) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.hZw.getEditText());
        }
    }

    private void send() {
        if (!j.jS()) {
            showToast(R.string.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new a();
        }
        this.mPermissionJudgement.aiM();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.aa(pageActivity) && !this.hZA) {
            this.hZx.pi(false);
            this.hZA = true;
            this.hZE = System.currentTimeMillis();
            this.fgL.ef(true);
            HidenSoftKeyPad(this.mInputManager, this.hZw.getEditText());
            if (TextUtils.isEmpty(this.hZw.getText())) {
                this.hZz = this.hED;
                bXu();
                return;
            }
            String text = this.hZw.getText();
            switch (this.hZC) {
                case 2:
                    if (!TextUtils.isEmpty(this.hZB) && this.hZB.equals(text)) {
                        bXw();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.hZB) && this.hZB.equals(text) && !TextUtils.isEmpty(this.hZy)) {
                        BI(this.hZy);
                        return;
                    }
                    break;
            }
            bXr();
            this.hZB = this.hZw.getText();
            bXs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXr() {
        if (this.hZD != null && !this.hZD.isRecycled()) {
            this.hZD.recycle();
            this.hZD = null;
        }
    }

    private void bXs() {
        this.hZx.BJ(this.hZw.getText());
    }

    private void bXt() {
        if (!this.hZx.ic()) {
            this.hZw.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.cGr instanceof GifView) {
                    ((GifView) this.cGr).pause();
                    this.hZx.a(((GifView) this.cGr).getGif());
                }
            } else if (this.cGr instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.cGr).getBdImage();
                if (bdImage != null) {
                    if (!this.hZx.ic()) {
                        Bitmap B = B(bdImage.ns());
                        if (B != null) {
                            this.hZx.b(B, f.Du + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.hZC = 2;
                        bpD();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.hZC = 2;
                bpD();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.hZy)) {
            bpD();
        } else {
            this.hZx.ar(this.hZy, true);
        }
    }

    private void bXu() {
        if (!this.hZx.ic()) {
            this.hZC = 0;
            bpD();
            if (this.hZz != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.hZz);
                setResult(-1, intent);
                finish();
                bXv();
                if (!TextUtils.isEmpty(this.hZy)) {
                    File file = new File(this.hZy);
                    if (file.exists()) {
                        file.delete();
                        return;
                    }
                    return;
                }
                return;
            }
            showToast(R.string.upload_error);
        }
    }

    private void bXv() {
        am amVar = new am("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                amVar.P("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                amVar.P("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.hZw.getText())) {
            amVar.P("obj_type", 1);
        } else {
            amVar.P("obj_type", 2);
        }
        TiebaStatic.log(amVar);
    }

    public Bitmap B(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.hZw.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap ce = ce(width, height);
            if (ce != null) {
                canvas.drawBitmap(ce, (width * this.hZw.getLeft()) / i, (height * this.hZw.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap ce(int i, int i2) {
        if (this.hZD != null) {
            return this.hZD;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.hZw.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.hZw.getTextView().getDrawingCache();
        this.hZD = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.hZD = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.hZD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.hZu.setVisibility(0);
            this.hZw.bXQ();
            return;
        }
        this.hZu.setVisibility(8);
        this.hZw.bXP();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.l(this.mRootView, R.color.black_alpha40);
        al.c(this.geN, (int) R.drawable.icon_emotion_close_n);
        al.j(this.hZt, R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bXr();
        if (this.hZx != null) {
            this.hZx.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bXw() {
        bXt();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void BH(String str) {
        showToast(str);
        this.hZC = 1;
        bpD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpD() {
        this.hZw.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.fgL.ef(false);
        this.hZA = false;
        if (this.mIsGif) {
            ((GifView) this.cGr).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void BI(String str) {
        this.hZw.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bpD();
        } else if (!new File(str).exists()) {
            bpD();
        } else {
            this.hZy = str;
            this.hZC = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.hZE) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.hZz = new EmotionImageData();
                this.hZz.setPicId(uploadedPicInfo.getPic_id());
                this.hZz.setWidth(uploadedPicInfo.getWidth());
                this.hZz.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.hED.getMemeContSign())) {
                    this.hZz.setMemeContSign(this.hED.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.hZz.setPicUrl(picinfo.originPic.picUrl);
                    this.hZz.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.hZz.setMemeText(this.hZw.getText());
                this.hZz.setAuthorNameShow(this.hED.getAuthorNameShow());
                bXu();
                return;
            }
            showToast(R.string.upload_error);
            this.hZC = 3;
            bpD();
            return;
        }
        showToast(R.string.upload_error);
        this.hZC = 3;
        bpD();
    }
}
