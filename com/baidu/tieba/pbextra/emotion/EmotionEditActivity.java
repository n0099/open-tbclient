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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.c.a;
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
    private ImageView cIK;
    private b foa;
    private ImageView gnI;
    private EmotionImageData hNL;
    private EmotionEditLayout iiN;
    private View iiO;
    private ChooseColorLayout iiP;
    private int iiQ;
    private EmotionEditText iiR;
    private EmotionEditModel iiS;
    private String iiT;
    private EmotionImageData iiU;
    private boolean iiV;
    private String iiW;
    private int iiX = 0;
    private Bitmap iiY;
    private long iiZ;
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
        this.hNL = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.iiS = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.foa = new b(getPageContext());
        this.foa.iC(R.string.emotion_composition);
        this.foa.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.iiS.setCancel(true);
                EmotionEditActivity.this.cbq();
                EmotionEditActivity.this.bsJ();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.iiN = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.gnI = (ImageView) findViewById(R.id.close);
        this.iiO = findViewById(R.id.send);
        this.iiP = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.iiP.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void yA(int i) {
                EmotionEditActivity.this.iiR.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.gnI.setOnClickListener(this);
        this.iiO.setOnClickListener(this);
        this.iiQ = l.af(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        cbp();
        cbo();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iiN.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.iiN.setLayoutParams(layoutParams);
        this.iiR.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.iiN.a(this.iiR);
        this.iiP.setVisibility(8);
    }

    private void cbo() {
        this.iiR = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.iiN.addView(this.iiR, layoutParams);
        this.iiR.setTextColor(this.iiP.getCurrentChooseColor());
        this.iiR.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.iiR.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.iiR.getEditText());
                }
            }
        });
    }

    private void cbp() {
        if (this.mIsGif) {
            this.cIK = new GifView(getPageContext().getPageActivity());
            ((GifView) this.cIK).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.hNL.getPicUrl();
            gifInfo.mDynamicUrl = this.hNL.getPicUrl();
            gifInfo.mStaticUrl = this.hNL.getThumbUrl();
            this.cIK.setTag(gifInfo.mSharpText);
            ((GifView) this.cIK).a(gifInfo);
        } else {
            this.cIK = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.cIK).setGifIconSupport(false);
            ((TbImageView) this.cIK).setAutoChangeStyle(false);
            ((TbImageView) this.cIK).startLoad(this.hNL.getPicUrl(), 10, true);
            c.iE().a(this.hNL.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.cIK);
                            EmotionEditActivity.this.cIK = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.cIK).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.hNL.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.hNL.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.hNL.getThumbUrl();
                            EmotionEditActivity.this.cIK.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.cIK).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.hNL.getWidth();
        this.mImageHeight = this.hNL.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.iiQ;
            this.mImageHeight = this.iiQ;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.iiQ / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.iiQ;
        } else {
            this.mImageWidth = (int) ((this.iiQ / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.iiQ;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.iiN.addView(this.cIK, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gnI) {
            finish();
        } else if (view == this.iiO) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.iiR.getEditText());
        }
    }

    private void send() {
        if (!j.kc()) {
            showToast(R.string.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new a();
        }
        this.mPermissionJudgement.ake();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.ad(pageActivity) && !this.iiV) {
            this.iiS.setCancel(false);
            this.iiV = true;
            this.iiZ = System.currentTimeMillis();
            this.foa.em(true);
            HidenSoftKeyPad(this.mInputManager, this.iiR.getEditText());
            if (TextUtils.isEmpty(this.iiR.getText())) {
                this.iiU = this.hNL;
                cbt();
                return;
            }
            String text = this.iiR.getText();
            switch (this.iiX) {
                case 2:
                    if (!TextUtils.isEmpty(this.iiW) && this.iiW.equals(text)) {
                        cbv();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.iiW) && this.iiW.equals(text) && !TextUtils.isEmpty(this.iiT)) {
                        CW(this.iiT);
                        return;
                    }
                    break;
            }
            cbq();
            this.iiW = this.iiR.getText();
            cbr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbq() {
        if (this.iiY != null && !this.iiY.isRecycled()) {
            this.iiY.recycle();
            this.iiY = null;
        }
    }

    private void cbr() {
        this.iiS.CY(this.iiR.getText());
    }

    private void cbs() {
        if (!this.iiS.im()) {
            this.iiR.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.cIK instanceof GifView) {
                    ((GifView) this.cIK).pause();
                    this.iiS.a(((GifView) this.cIK).getGif());
                }
            } else if (this.cIK instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.cIK).getBdImage();
                if (bdImage != null) {
                    if (!this.iiS.im()) {
                        Bitmap B = B(bdImage.nK());
                        if (B != null) {
                            this.iiS.b(B, f.Dz + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.iiX = 2;
                        bsJ();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.iiX = 2;
                bsJ();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.iiT)) {
            bsJ();
        } else {
            this.iiS.av(this.iiT, true);
        }
    }

    private void cbt() {
        if (!this.iiS.im()) {
            this.iiX = 0;
            bsJ();
            if (this.iiU != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.iiU);
                setResult(-1, intent);
                finish();
                cbu();
                if (!TextUtils.isEmpty(this.iiT)) {
                    File file = new File(this.iiT);
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

    private void cbu() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.P("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.P("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.iiR.getText())) {
            anVar.P("obj_type", 1);
        } else {
            anVar.P("obj_type", 2);
        }
        TiebaStatic.log(anVar);
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
        if (!TextUtils.isEmpty(this.iiR.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap ck = ck(width, height);
            if (ck != null) {
                canvas.drawBitmap(ck, (width * this.iiR.getLeft()) / i, (height * this.iiR.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap ck(int i, int i2) {
        if (this.iiY != null) {
            return this.iiY;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.iiR.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.iiR.getTextView().getDrawingCache();
        this.iiY = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.iiY = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.iiY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.iiP.setVisibility(0);
            this.iiR.cbP();
            return;
        }
        this.iiP.setVisibility(8);
        this.iiR.cbO();
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
        am.l(this.mRootView, R.color.black_alpha40);
        am.c(this.gnI, (int) R.drawable.icon_emotion_close_n);
        am.j(this.iiO, R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cbq();
        if (this.iiS != null) {
            this.iiS.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void cbv() {
        cbs();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void CV(String str) {
        showToast(str);
        this.iiX = 1;
        bsJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsJ() {
        this.iiR.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.foa.em(false);
        this.iiV = false;
        if (this.mIsGif) {
            ((GifView) this.cIK).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void CW(String str) {
        this.iiR.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bsJ();
        } else if (!new File(str).exists()) {
            bsJ();
        } else {
            this.iiT = str;
            this.iiX = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.iiZ) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.iiU = new EmotionImageData();
                this.iiU.setPicId(uploadedPicInfo.getPic_id());
                this.iiU.setWidth(uploadedPicInfo.getWidth());
                this.iiU.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.hNL.getMemeContSign())) {
                    this.iiU.setMemeContSign(this.hNL.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.iiU.setPicUrl(picinfo.originPic.picUrl);
                    this.iiU.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.iiU.setMemeText(this.iiR.getText());
                this.iiU.setAuthorNameShow(this.hNL.getAuthorNameShow());
                cbt();
                return;
            }
            showToast(R.string.upload_error);
            this.iiX = 3;
            bsJ();
            return;
        }
        showToast(R.string.upload_error);
        this.iiX = 3;
        bsJ();
    }
}
