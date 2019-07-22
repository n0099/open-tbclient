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
    private ImageView cHM;
    private b flO;
    private ImageView glb;
    private EmotionImageData hKU;
    private EmotionEditLayout ifM;
    private View ifN;
    private ChooseColorLayout ifO;
    private int ifP;
    private EmotionEditText ifQ;
    private EmotionEditModel ifR;
    private String ifS;
    private EmotionImageData ifT;
    private boolean ifU;
    private String ifV;
    private int ifW = 0;
    private Bitmap ifX;
    private long ifY;
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
        this.hKU = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.ifR = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.flO = new b(getPageContext());
        this.flO.iz(R.string.emotion_composition);
        this.flO.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.ifR.px(true);
                EmotionEditActivity.this.cak();
                EmotionEditActivity.this.brJ();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.ifM = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.glb = (ImageView) findViewById(R.id.close);
        this.ifN = findViewById(R.id.send);
        this.ifO = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.ifO.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void yv(int i) {
                EmotionEditActivity.this.ifQ.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.glb.setOnClickListener(this);
        this.ifN.setOnClickListener(this);
        this.ifP = l.af(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        caj();
        cai();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ifM.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.ifM.setLayoutParams(layoutParams);
        this.ifQ.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.ifM.a(this.ifQ);
        this.ifO.setVisibility(8);
    }

    private void cai() {
        this.ifQ = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.ifM.addView(this.ifQ, layoutParams);
        this.ifQ.setTextColor(this.ifO.getCurrentChooseColor());
        this.ifQ.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.ifQ.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.ifQ.getEditText());
                }
            }
        });
    }

    private void caj() {
        if (this.mIsGif) {
            this.cHM = new GifView(getPageContext().getPageActivity());
            ((GifView) this.cHM).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.hKU.getPicUrl();
            gifInfo.mDynamicUrl = this.hKU.getPicUrl();
            gifInfo.mStaticUrl = this.hKU.getThumbUrl();
            this.cHM.setTag(gifInfo.mSharpText);
            ((GifView) this.cHM).a(gifInfo);
        } else {
            this.cHM = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.cHM).setGifIconSupport(false);
            ((TbImageView) this.cHM).setAutoChangeStyle(false);
            ((TbImageView) this.cHM).startLoad(this.hKU.getPicUrl(), 10, true);
            c.iE().a(this.hKU.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.cHM);
                            EmotionEditActivity.this.cHM = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.cHM).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.hKU.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.hKU.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.hKU.getThumbUrl();
                            EmotionEditActivity.this.cHM.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.cHM).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.hKU.getWidth();
        this.mImageHeight = this.hKU.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.ifP;
            this.mImageHeight = this.ifP;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.ifP / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.ifP;
        } else {
            this.mImageWidth = (int) ((this.ifP / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.ifP;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.ifM.addView(this.cHM, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.glb) {
            finish();
        } else if (view == this.ifN) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.ifQ.getEditText());
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
        this.mPermissionJudgement.ajQ();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.ad(pageActivity) && !this.ifU) {
            this.ifR.px(false);
            this.ifU = true;
            this.ifY = System.currentTimeMillis();
            this.flO.ej(true);
            HidenSoftKeyPad(this.mInputManager, this.ifQ.getEditText());
            if (TextUtils.isEmpty(this.ifQ.getText())) {
                this.ifT = this.hKU;
                can();
                return;
            }
            String text = this.ifQ.getText();
            switch (this.ifW) {
                case 2:
                    if (!TextUtils.isEmpty(this.ifV) && this.ifV.equals(text)) {
                        cap();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.ifV) && this.ifV.equals(text) && !TextUtils.isEmpty(this.ifS)) {
                        Cw(this.ifS);
                        return;
                    }
                    break;
            }
            cak();
            this.ifV = this.ifQ.getText();
            cal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cak() {
        if (this.ifX != null && !this.ifX.isRecycled()) {
            this.ifX.recycle();
            this.ifX = null;
        }
    }

    private void cal() {
        this.ifR.Cy(this.ifQ.getText());
    }

    private void cam() {
        if (!this.ifR.im()) {
            this.ifQ.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.cHM instanceof GifView) {
                    ((GifView) this.cHM).pause();
                    this.ifR.a(((GifView) this.cHM).getGif());
                }
            } else if (this.cHM instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.cHM).getBdImage();
                if (bdImage != null) {
                    if (!this.ifR.im()) {
                        Bitmap B = B(bdImage.nK());
                        if (B != null) {
                            this.ifR.b(B, f.Dz + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.ifW = 2;
                        brJ();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.ifW = 2;
                brJ();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.ifS)) {
            brJ();
        } else {
            this.ifR.av(this.ifS, true);
        }
    }

    private void can() {
        if (!this.ifR.im()) {
            this.ifW = 0;
            brJ();
            if (this.ifT != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.ifT);
                setResult(-1, intent);
                finish();
                cao();
                if (!TextUtils.isEmpty(this.ifS)) {
                    File file = new File(this.ifS);
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

    private void cao() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.P("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.P("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.ifQ.getText())) {
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
        if (!TextUtils.isEmpty(this.ifQ.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap ck = ck(width, height);
            if (ck != null) {
                canvas.drawBitmap(ck, (width * this.ifQ.getLeft()) / i, (height * this.ifQ.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap ck(int i, int i2) {
        if (this.ifX != null) {
            return this.ifX;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.ifQ.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.ifQ.getTextView().getDrawingCache();
        this.ifX = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.ifX = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.ifX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.ifO.setVisibility(0);
            this.ifQ.caJ();
            return;
        }
        this.ifO.setVisibility(8);
        this.ifQ.caI();
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
        am.c(this.glb, (int) R.drawable.icon_emotion_close_n);
        am.j(this.ifN, R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cak();
        if (this.ifR != null) {
            this.ifR.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void cap() {
        cam();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Cv(String str) {
        showToast(str);
        this.ifW = 1;
        brJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brJ() {
        this.ifQ.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.flO.ej(false);
        this.ifU = false;
        if (this.mIsGif) {
            ((GifView) this.cHM).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Cw(String str) {
        this.ifQ.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            brJ();
        } else if (!new File(str).exists()) {
            brJ();
        } else {
            this.ifS = str;
            this.ifW = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.ifY) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.ifT = new EmotionImageData();
                this.ifT.setPicId(uploadedPicInfo.getPic_id());
                this.ifT.setWidth(uploadedPicInfo.getWidth());
                this.ifT.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.hKU.getMemeContSign())) {
                    this.ifT.setMemeContSign(this.hKU.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.ifT.setPicUrl(picinfo.originPic.picUrl);
                    this.ifT.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.ifT.setMemeText(this.ifQ.getText());
                this.ifT.setAuthorNameShow(this.hKU.getAuthorNameShow());
                can();
                return;
            }
            showToast(R.string.upload_error);
            this.ifW = 3;
            brJ();
            return;
        }
        showToast(R.string.upload_error);
        this.ifW = 3;
        brJ();
    }
}
