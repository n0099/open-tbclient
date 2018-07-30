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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.b.a;
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
/* loaded from: classes3.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView baU;
    private a bkU;
    private ImageView dZM;
    private com.baidu.tbadk.core.view.a deH;
    private EmotionEditLayout fQC;
    private View fQD;
    private ChooseColorLayout fQE;
    private int fQF;
    private EmotionEditText fQG;
    private EmotionEditModel fQH;
    private String fQI;
    private EmotionImageData fQJ;
    private boolean fQK;
    private String fQL;
    private int fQM = 0;
    private Bitmap fQN;
    private long fQO;
    private EmotionImageData fvK;
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
        setContentView(d.h.emotion_edit_activity);
        this.fvK = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.fQH = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0140d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.deH = new com.baidu.tbadk.core.view.a(getPageContext());
        this.deH.df(d.j.emotion_composition);
        this.deH.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.fQH.kS(true);
                EmotionEditActivity.this.bgM();
                EmotionEditActivity.this.aAh();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_layout);
        this.fQC = (EmotionEditLayout) findViewById(d.g.edit_container);
        this.dZM = (ImageView) findViewById(d.g.close);
        this.fQD = findViewById(d.g.send);
        this.fQE = (ChooseColorLayout) findViewById(d.g.choose_color_layout);
        this.fQE.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void rh(int i) {
                EmotionEditActivity.this.fQG.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.dZM.setOnClickListener(this);
        this.fQD.setOnClickListener(this);
        this.fQF = l.ah(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds300);
        bgL();
        bgK();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fQC.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds80);
        this.fQC.setLayoutParams(layoutParams);
        this.fQG.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.fQC.a(this.fQG);
        this.fQE.setVisibility(8);
    }

    private void bgK() {
        this.fQG = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(d.e.ds40));
        this.fQC.addView(this.fQG, layoutParams);
        this.fQG.setTextColor(this.fQE.getCurrentChooseColor());
        this.fQG.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.fQG.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.fQG.getEditText());
                }
            }
        });
    }

    private void bgL() {
        if (this.mIsGif) {
            this.baU = new GifView(getPageContext().getPageActivity());
            ((GifView) this.baU).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.fvK.getPicUrl();
            gifInfo.mDynamicUrl = this.fvK.getPicUrl();
            gifInfo.mStaticUrl = this.fvK.getThumbUrl();
            this.baU.setTag(gifInfo.mSharpText);
            ((GifView) this.baU).a(gifInfo);
        } else {
            this.baU = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.baU).setGifIconSupport(false);
            ((TbImageView) this.baU).setAutoChangeStyle(false);
            ((TbImageView) this.baU).startLoad(this.fvK.getPicUrl(), 10, true);
            c.ih().a(this.fvK.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.baU);
                            EmotionEditActivity.this.baU = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.baU).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.fvK.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.fvK.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.fvK.getThumbUrl();
                            EmotionEditActivity.this.baU.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.baU).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.fvK.getWidth();
        this.mImageHeight = this.fvK.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.fQF;
            this.mImageHeight = this.fQF;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.fQF / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.fQF;
        } else {
            this.mImageWidth = (int) ((this.fQF / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.fQF;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.fQC.addView(this.baU, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dZM) {
            finish();
        } else if (view == this.fQD) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.fQG.getEditText());
        }
    }

    private void send() {
        if (!j.jE()) {
            showToast(d.j.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bkU == null) {
            this.bkU = new a();
        }
        this.bkU.zY();
        this.bkU.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bkU.u(pageActivity) && !this.fQK) {
            this.fQH.kS(false);
            this.fQK = true;
            this.fQO = System.currentTimeMillis();
            this.deH.aM(true);
            HidenSoftKeyPad(this.mInputManager, this.fQG.getEditText());
            if (TextUtils.isEmpty(this.fQG.getText())) {
                this.fQJ = this.fvK;
                bgP();
                return;
            }
            String text = this.fQG.getText();
            switch (this.fQM) {
                case 2:
                    if (!TextUtils.isEmpty(this.fQL) && this.fQL.equals(text)) {
                        bgR();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.fQL) && this.fQL.equals(text) && !TextUtils.isEmpty(this.fQI)) {
                        rI(this.fQI);
                        return;
                    }
                    break;
            }
            bgM();
            this.fQL = this.fQG.getText();
            bgN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgM() {
        if (this.fQN != null && !this.fQN.isRecycled()) {
            this.fQN.recycle();
            this.fQN = null;
        }
    }

    private void bgN() {
        this.fQH.rJ(this.fQG.getText());
    }

    private void bgO() {
        if (!this.fQH.hP()) {
            this.fQG.getTextView().setBackgroundColor(getPageContext().getResources().getColor(d.C0140d.transparent));
            if (this.mIsGif) {
                if (this.baU instanceof GifView) {
                    ((GifView) this.baU).pause();
                    this.fQH.a(((GifView) this.baU).getGif());
                }
            } else if (this.baU instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.baU).getBdImage();
                if (bdImage != null) {
                    if (!this.fQH.hP()) {
                        Bitmap r = r(bdImage.nb());
                        if (r != null) {
                            this.fQH.b(r, f.CD + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(d.j.upload_error);
                        this.fQM = 2;
                        aAh();
                        return;
                    }
                    return;
                }
                showToast(d.j.upload_error);
                this.fQM = 2;
                aAh();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.fQI)) {
            aAh();
        } else {
            this.fQH.N(this.fQI, true);
        }
    }

    private void bgP() {
        if (!this.fQH.hP()) {
            this.fQM = 0;
            aAh();
            if (this.fQJ != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.fQJ);
                setResult(-1, intent);
                finish();
                bgQ();
                if (!TextUtils.isEmpty(this.fQI)) {
                    File file = new File(this.fQI);
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

    private void bgQ() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.r("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.r("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.fQG.getText())) {
            anVar.r("obj_type", 1);
        } else {
            anVar.r("obj_type", 2);
        }
        TiebaStatic.log(anVar);
    }

    public Bitmap r(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.fQG.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bv = bv(width, height);
            if (bv != null) {
                canvas.drawBitmap(bv, (width * this.fQG.getLeft()) / i, (height * this.fQG.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bv(int i, int i2) {
        if (this.fQN != null) {
            return this.fQN;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.fQG.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.fQG.getTextView().getDrawingCache();
        this.fQN = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.fQN = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.fQN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.fQE.setVisibility(0);
            this.fQG.bhm();
            return;
        }
        this.fQE.setVisibility(8);
        this.fQG.bhl();
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
        am.j(this.mRootView, d.C0140d.black_alpha40);
        am.c(this.dZM, d.f.icon_emotion_close_n);
        am.h(this.fQD, d.C0140d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bgM();
        if (this.fQH != null) {
            this.fQH.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bgR() {
        bgO();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void rH(String str) {
        showToast(str);
        this.fQM = 1;
        aAh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAh() {
        this.fQG.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        this.deH.aM(false);
        this.fQK = false;
        if (this.mIsGif) {
            ((GifView) this.baU).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void rI(String str) {
        this.fQG.getTextView().setBackgroundResource(d.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            aAh();
        } else if (!new File(str).exists()) {
            aAh();
        } else {
            this.fQI = str;
            this.fQM = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.fQO) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.fQJ = new EmotionImageData();
                this.fQJ.setPicId(uploadedPicInfo.getPic_id());
                this.fQJ.setWidth(uploadedPicInfo.getWidth());
                this.fQJ.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.fvK.getMemeContSign())) {
                    this.fQJ.setMemeContSign(this.fvK.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.fQJ.setPicUrl(picinfo.originPic.picUrl);
                    this.fQJ.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.fQJ.setMemeText(this.fQG.getText());
                this.fQJ.setAuthorNameShow(this.fvK.getAuthorNameShow());
                bgP();
                return;
            }
            showToast(d.j.upload_error);
            this.fQM = 3;
            aAh();
            return;
        }
        showToast(d.j.upload_error);
        this.fQM = 3;
        aAh();
    }
}
