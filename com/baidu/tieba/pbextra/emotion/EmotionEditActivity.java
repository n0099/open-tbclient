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
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.e.c;
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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.a;
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
/* loaded from: classes9.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView gdY;
    private a hPr;
    private EmotionImageData jLV;
    private EmotionEditLayout kif;
    private View kig;
    private ChooseColorLayout kih;
    private int kii;
    private EmotionEditText kij;
    private EmotionEditModel kik;
    private String kil;
    private EmotionImageData kim;
    private boolean kin;
    private String kio;
    private int kip = 0;
    private Bitmap kiq;
    private long kir;
    private String mFrom;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.emotion_edit_activity);
        this.jLV = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.kik = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.hPr = new a(getPageContext());
        this.hPr.setTipString(R.string.emotion_composition);
        this.hPr.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.kik.setCancel(true);
                EmotionEditActivity.this.cMz();
                EmotionEditActivity.this.cbc();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.kif = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.gdY = (ImageView) findViewById(R.id.close);
        this.kig = findViewById(R.id.send);
        this.kih = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.kih.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void AZ(int i) {
                EmotionEditActivity.this.kij.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.gdY.setOnClickListener(this);
        this.kig.setOnClickListener(this);
        this.kii = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        cMy();
        cMx();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kif.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kif.setLayoutParams(layoutParams);
        this.kij.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.kif.a(this.kij);
        this.kih.setVisibility(8);
    }

    private void cMx() {
        this.kij = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.kif.addView(this.kij, layoutParams);
        this.kij.setTextColor(this.kih.getCurrentChooseColor());
        this.kij.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.kij.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.kij.getEditText());
                }
            }
        });
    }

    private void cMy() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.jLV.getPicUrl();
            gifInfo.mDynamicUrl = this.jLV.getPicUrl();
            gifInfo.mStaticUrl = this.jLV.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.jLV.getPicUrl(), 10, true);
            c.kX().a(this.jLV.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.drawImageTo(EmotionEditActivity.this.mImageView);
                            EmotionEditActivity.this.mImageView = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.mImageView).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.jLV.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.jLV.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.jLV.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.jLV.getWidth();
        this.mImageHeight = this.jLV.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.kii;
            this.mImageHeight = this.kii;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.kii / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.kii;
        } else {
            this.mImageWidth = (int) ((this.kii / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.kii;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.kif.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gdY) {
            finish();
        } else if (view == this.kig) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.kij.getEditText());
        }
    }

    private void send() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.kin) {
            this.kik.setCancel(false);
            this.kin = true;
            this.kir = System.currentTimeMillis();
            this.hPr.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.kij.getEditText());
            if (TextUtils.isEmpty(this.kij.getText())) {
                this.kim = this.jLV;
                cMD();
                return;
            }
            String text = this.kij.getText();
            switch (this.kip) {
                case 2:
                    if (!TextUtils.isEmpty(this.kio) && this.kio.equals(text)) {
                        cMF();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.kio) && this.kio.equals(text) && !TextUtils.isEmpty(this.kil)) {
                        JX(this.kil);
                        return;
                    }
                    break;
            }
            cMz();
            this.kio = this.kij.getText();
            cMA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMz() {
        if (this.kiq != null && !this.kiq.isRecycled()) {
            this.kiq.recycle();
            this.kiq = null;
        }
    }

    private void cMA() {
        this.kik.JY(this.kij.getText());
    }

    private void cMB() {
        if (!this.kik.isCancel()) {
            this.kij.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.kik.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.kik.isCancel()) {
                        Bitmap D = D(bdImage.getRawBitmap());
                        if (D != null) {
                            this.kik.b(D, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.kip = 2;
                        cbc();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.kip = 2;
                cbc();
            }
        }
    }

    private void cMC() {
        if (TextUtils.isEmpty(this.kil)) {
            cbc();
        } else {
            this.kik.aO(this.kil, true);
        }
    }

    private void cMD() {
        if (!this.kik.isCancel()) {
            this.kip = 0;
            cbc();
            if (this.kim != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.kim);
                setResult(-1, intent);
                finish();
                cME();
                if (!TextUtils.isEmpty(this.kil)) {
                    File file = new File(this.kil);
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

    private void cME() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.ag("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.ag("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.kij.getText())) {
            anVar.ag("obj_type", 1);
        } else {
            anVar.ag("obj_type", 2);
        }
        TiebaStatic.log(anVar);
    }

    public Bitmap D(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.kij.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cH = cH(width, height);
            if (cH != null) {
                canvas.drawBitmap(cH, (width * this.kij.getLeft()) / i, (height * this.kij.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cH(int i, int i2) {
        if (this.kiq != null) {
            return this.kiq;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.kij.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.kij.getTextView().getDrawingCache();
        this.kiq = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.kiq = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.kiq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.kih.setVisibility(0);
            this.kij.cNa();
            return;
        }
        this.kih.setVisibility(8);
        this.kij.cMZ();
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
        am.setBackgroundColor(this.mRootView, R.color.black_alpha40);
        am.setImageResource(this.gdY, R.drawable.icon_emotion_close_n);
        am.setViewTextColor(this.kig, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cMz();
        if (this.kik != null) {
            this.kik.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void cMF() {
        cMB();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void JW(String str) {
        showToast(str);
        this.kip = 1;
        cbc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbc() {
        this.kij.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.hPr.setDialogVisiable(false);
        this.kin = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void JX(String str) {
        this.kij.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            cbc();
        } else if (!new File(str).exists()) {
            cbc();
        } else {
            this.kil = str;
            this.kip = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.kir) + "ms");
            cMC();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.kim = new EmotionImageData();
                this.kim.setPicId(uploadedPicInfo.getPic_id());
                this.kim.setWidth(uploadedPicInfo.getWidth());
                this.kim.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.jLV.getMemeContSign())) {
                    this.kim.setMemeContSign(this.jLV.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.kim.setPicUrl(picinfo.originPic.picUrl);
                    this.kim.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.kim.setMemeText(this.kij.getText());
                this.kim.setAuthorNameShow(this.jLV.getAuthorNameShow());
                cMD();
                return;
            }
            showToast(R.string.upload_error);
            this.kip = 3;
            cbc();
            return;
        }
        showToast(R.string.upload_error);
        this.kip = 3;
        cbc();
    }
}
