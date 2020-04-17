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
    private ImageView fOY;
    private a hzL;
    private EmotionEditLayout jPc;
    private View jPd;
    private ChooseColorLayout jPe;
    private int jPf;
    private EmotionEditText jPg;
    private EmotionEditModel jPh;
    private String jPi;
    private EmotionImageData jPj;
    private boolean jPk;
    private String jPl;
    private int jPm = 0;
    private Bitmap jPn;
    private long jPo;
    private EmotionImageData jtN;
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
        this.jtN = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.jPh = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.hzL = new a(getPageContext());
        this.hzL.setTipString(R.string.emotion_composition);
        this.hzL.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.jPh.setCancel(true);
                EmotionEditActivity.this.cFn();
                EmotionEditActivity.this.bUy();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.jPc = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.fOY = (ImageView) findViewById(R.id.close);
        this.jPd = findViewById(R.id.send);
        this.jPe = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.jPe.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void Am(int i) {
                EmotionEditActivity.this.jPg.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.fOY.setOnClickListener(this);
        this.jPd.setOnClickListener(this);
        this.jPf = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        cFm();
        cFl();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jPc.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jPc.setLayoutParams(layoutParams);
        this.jPg.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.jPc.a(this.jPg);
        this.jPe.setVisibility(8);
    }

    private void cFl() {
        this.jPg = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.jPc.addView(this.jPg, layoutParams);
        this.jPg.setTextColor(this.jPe.getCurrentChooseColor());
        this.jPg.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.jPg.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.jPg.getEditText());
                }
            }
        });
    }

    private void cFm() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.jtN.getPicUrl();
            gifInfo.mDynamicUrl = this.jtN.getPicUrl();
            gifInfo.mStaticUrl = this.jtN.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.jtN.getPicUrl(), 10, true);
            c.kV().a(this.jtN.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.jtN.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.jtN.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.jtN.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.jtN.getWidth();
        this.mImageHeight = this.jtN.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.jPf;
            this.mImageHeight = this.jPf;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.jPf / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.jPf;
        } else {
            this.mImageWidth = (int) ((this.jPf / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.jPf;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.jPc.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fOY) {
            finish();
        } else if (view == this.jPd) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.jPg.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.jPk) {
            this.jPh.setCancel(false);
            this.jPk = true;
            this.jPo = System.currentTimeMillis();
            this.hzL.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.jPg.getEditText());
            if (TextUtils.isEmpty(this.jPg.getText())) {
                this.jPj = this.jtN;
                cFq();
                return;
            }
            String text = this.jPg.getText();
            switch (this.jPm) {
                case 2:
                    if (!TextUtils.isEmpty(this.jPl) && this.jPl.equals(text)) {
                        cFs();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.jPl) && this.jPl.equals(text) && !TextUtils.isEmpty(this.jPi)) {
                        Ih(this.jPi);
                        return;
                    }
                    break;
            }
            cFn();
            this.jPl = this.jPg.getText();
            cFo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFn() {
        if (this.jPn != null && !this.jPn.isRecycled()) {
            this.jPn.recycle();
            this.jPn = null;
        }
    }

    private void cFo() {
        this.jPh.Ii(this.jPg.getText());
    }

    private void cFp() {
        if (!this.jPh.isCancel()) {
            this.jPg.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.jPh.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.jPh.isCancel()) {
                        Bitmap B = B(bdImage.getRawBitmap());
                        if (B != null) {
                            this.jPh.b(B, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.jPm = 2;
                        bUy();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.jPm = 2;
                bUy();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.jPi)) {
            bUy();
        } else {
            this.jPh.aB(this.jPi, true);
        }
    }

    private void cFq() {
        if (!this.jPh.isCancel()) {
            this.jPm = 0;
            bUy();
            if (this.jPj != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.jPj);
                setResult(-1, intent);
                finish();
                cFr();
                if (!TextUtils.isEmpty(this.jPi)) {
                    File file = new File(this.jPi);
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

    private void cFr() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.af("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.af("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.jPg.getText())) {
            anVar.af("obj_type", 1);
        } else {
            anVar.af("obj_type", 2);
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
        if (!TextUtils.isEmpty(this.jPg.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cC = cC(width, height);
            if (cC != null) {
                canvas.drawBitmap(cC, (width * this.jPg.getLeft()) / i, (height * this.jPg.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cC(int i, int i2) {
        if (this.jPn != null) {
            return this.jPn;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.jPg.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.jPg.getTextView().getDrawingCache();
        this.jPn = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.jPn = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.jPn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.jPe.setVisibility(0);
            this.jPg.cFN();
            return;
        }
        this.jPe.setVisibility(8);
        this.jPg.cFM();
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
        am.setImageResource(this.fOY, R.drawable.icon_emotion_close_n);
        am.setViewTextColor(this.jPd, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cFn();
        if (this.jPh != null) {
            this.jPh.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void cFs() {
        cFp();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Ig(String str) {
        showToast(str);
        this.jPm = 1;
        bUy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUy() {
        this.jPg.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.hzL.setDialogVisiable(false);
        this.jPk = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Ih(String str) {
        this.jPg.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bUy();
        } else if (!new File(str).exists()) {
            bUy();
        } else {
            this.jPi = str;
            this.jPm = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.jPo) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.jPj = new EmotionImageData();
                this.jPj.setPicId(uploadedPicInfo.getPic_id());
                this.jPj.setWidth(uploadedPicInfo.getWidth());
                this.jPj.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.jtN.getMemeContSign())) {
                    this.jPj.setMemeContSign(this.jtN.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.jPj.setPicUrl(picinfo.originPic.picUrl);
                    this.jPj.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.jPj.setMemeText(this.jPg.getText());
                this.jPj.setAuthorNameShow(this.jtN.getAuthorNameShow());
                cFq();
                return;
            }
            showToast(R.string.upload_error);
            this.jPm = 3;
            bUy();
            return;
        }
        showToast(R.string.upload_error);
        this.jPm = 3;
        bUy();
    }
}
