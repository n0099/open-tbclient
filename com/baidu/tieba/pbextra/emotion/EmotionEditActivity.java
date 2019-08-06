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
    private ImageView cHT;
    private b fmn;
    private ImageView glR;
    private EmotionImageData hLO;
    private EmotionEditLayout igO;
    private View igP;
    private ChooseColorLayout igQ;
    private int igR;
    private EmotionEditText igS;
    private EmotionEditModel igT;
    private String igU;
    private EmotionImageData igV;
    private boolean igW;
    private String igX;
    private int igY = 0;
    private Bitmap igZ;
    private long iha;
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
        this.hLO = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.igT = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.fmn = new b(getPageContext());
        this.fmn.iz(R.string.emotion_composition);
        this.fmn.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.igT.py(true);
                EmotionEditActivity.this.caC();
                EmotionEditActivity.this.brW();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.igO = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.glR = (ImageView) findViewById(R.id.close);
        this.igP = findViewById(R.id.send);
        this.igQ = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.igQ.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void yx(int i) {
                EmotionEditActivity.this.igS.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.glR.setOnClickListener(this);
        this.igP.setOnClickListener(this);
        this.igR = l.af(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        caB();
        caA();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.igO.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.igO.setLayoutParams(layoutParams);
        this.igS.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.igO.a(this.igS);
        this.igQ.setVisibility(8);
    }

    private void caA() {
        this.igS = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.igO.addView(this.igS, layoutParams);
        this.igS.setTextColor(this.igQ.getCurrentChooseColor());
        this.igS.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.igS.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.igS.getEditText());
                }
            }
        });
    }

    private void caB() {
        if (this.mIsGif) {
            this.cHT = new GifView(getPageContext().getPageActivity());
            ((GifView) this.cHT).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.hLO.getPicUrl();
            gifInfo.mDynamicUrl = this.hLO.getPicUrl();
            gifInfo.mStaticUrl = this.hLO.getThumbUrl();
            this.cHT.setTag(gifInfo.mSharpText);
            ((GifView) this.cHT).a(gifInfo);
        } else {
            this.cHT = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.cHT).setGifIconSupport(false);
            ((TbImageView) this.cHT).setAutoChangeStyle(false);
            ((TbImageView) this.cHT).startLoad(this.hLO.getPicUrl(), 10, true);
            c.iE().a(this.hLO.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.cHT);
                            EmotionEditActivity.this.cHT = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.cHT).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.hLO.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.hLO.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.hLO.getThumbUrl();
                            EmotionEditActivity.this.cHT.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.cHT).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.hLO.getWidth();
        this.mImageHeight = this.hLO.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.igR;
            this.mImageHeight = this.igR;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.igR / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.igR;
        } else {
            this.mImageWidth = (int) ((this.igR / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.igR;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.igO.addView(this.cHT, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.glR) {
            finish();
        } else if (view == this.igP) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.igS.getEditText());
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
        this.mPermissionJudgement.ajS();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.ad(pageActivity) && !this.igW) {
            this.igT.py(false);
            this.igW = true;
            this.iha = System.currentTimeMillis();
            this.fmn.ej(true);
            HidenSoftKeyPad(this.mInputManager, this.igS.getEditText());
            if (TextUtils.isEmpty(this.igS.getText())) {
                this.igV = this.hLO;
                caF();
                return;
            }
            String text = this.igS.getText();
            switch (this.igY) {
                case 2:
                    if (!TextUtils.isEmpty(this.igX) && this.igX.equals(text)) {
                        caH();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.igX) && this.igX.equals(text) && !TextUtils.isEmpty(this.igU)) {
                        Cx(this.igU);
                        return;
                    }
                    break;
            }
            caC();
            this.igX = this.igS.getText();
            caD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caC() {
        if (this.igZ != null && !this.igZ.isRecycled()) {
            this.igZ.recycle();
            this.igZ = null;
        }
    }

    private void caD() {
        this.igT.Cz(this.igS.getText());
    }

    private void caE() {
        if (!this.igT.im()) {
            this.igS.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.cHT instanceof GifView) {
                    ((GifView) this.cHT).pause();
                    this.igT.a(((GifView) this.cHT).getGif());
                }
            } else if (this.cHT instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.cHT).getBdImage();
                if (bdImage != null) {
                    if (!this.igT.im()) {
                        Bitmap B = B(bdImage.nK());
                        if (B != null) {
                            this.igT.b(B, f.Dz + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.igY = 2;
                        brW();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.igY = 2;
                brW();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.igU)) {
            brW();
        } else {
            this.igT.av(this.igU, true);
        }
    }

    private void caF() {
        if (!this.igT.im()) {
            this.igY = 0;
            brW();
            if (this.igV != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.igV);
                setResult(-1, intent);
                finish();
                caG();
                if (!TextUtils.isEmpty(this.igU)) {
                    File file = new File(this.igU);
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

    private void caG() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.P("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.P("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.igS.getText())) {
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
        if (!TextUtils.isEmpty(this.igS.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap ck = ck(width, height);
            if (ck != null) {
                canvas.drawBitmap(ck, (width * this.igS.getLeft()) / i, (height * this.igS.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap ck(int i, int i2) {
        if (this.igZ != null) {
            return this.igZ;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.igS.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.igS.getTextView().getDrawingCache();
        this.igZ = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.igZ = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.igZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.igQ.setVisibility(0);
            this.igS.cbb();
            return;
        }
        this.igQ.setVisibility(8);
        this.igS.cba();
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
        am.c(this.glR, (int) R.drawable.icon_emotion_close_n);
        am.j(this.igP, R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        caC();
        if (this.igT != null) {
            this.igT.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void caH() {
        caE();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Cw(String str) {
        showToast(str);
        this.igY = 1;
        brW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brW() {
        this.igS.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.fmn.ej(false);
        this.igW = false;
        if (this.mIsGif) {
            ((GifView) this.cHT).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Cx(String str) {
        this.igS.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            brW();
        } else if (!new File(str).exists()) {
            brW();
        } else {
            this.igU = str;
            this.igY = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.iha) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.igV = new EmotionImageData();
                this.igV.setPicId(uploadedPicInfo.getPic_id());
                this.igV.setWidth(uploadedPicInfo.getWidth());
                this.igV.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.hLO.getMemeContSign())) {
                    this.igV.setMemeContSign(this.hLO.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.igV.setPicUrl(picinfo.originPic.picUrl);
                    this.igV.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.igV.setMemeText(this.igS.getText());
                this.igV.setAuthorNameShow(this.hLO.getAuthorNameShow());
                caF();
                return;
            }
            showToast(R.string.upload_error);
            this.igY = 3;
            brW();
            return;
        }
        showToast(R.string.upload_error);
        this.igY = 3;
        brW();
    }
}
