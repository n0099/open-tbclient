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
    private ImageView fPd;
    private a hzR;
    private EmotionEditLayout jPg;
    private View jPh;
    private ChooseColorLayout jPi;
    private int jPj;
    private EmotionEditText jPk;
    private EmotionEditModel jPl;
    private String jPm;
    private EmotionImageData jPn;
    private boolean jPo;
    private String jPp;
    private int jPq = 0;
    private Bitmap jPr;
    private long jPs;
    private EmotionImageData jtR;
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
        this.jtR = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.jPl = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.hzR = new a(getPageContext());
        this.hzR.setTipString(R.string.emotion_composition);
        this.hzR.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.jPl.setCancel(true);
                EmotionEditActivity.this.cFk();
                EmotionEditActivity.this.bUw();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.jPg = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.fPd = (ImageView) findViewById(R.id.close);
        this.jPh = findViewById(R.id.send);
        this.jPi = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.jPi.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void Am(int i) {
                EmotionEditActivity.this.jPk.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.fPd.setOnClickListener(this);
        this.jPh.setOnClickListener(this);
        this.jPj = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        cFj();
        cFi();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jPg.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jPg.setLayoutParams(layoutParams);
        this.jPk.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.jPg.a(this.jPk);
        this.jPi.setVisibility(8);
    }

    private void cFi() {
        this.jPk = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.jPg.addView(this.jPk, layoutParams);
        this.jPk.setTextColor(this.jPi.getCurrentChooseColor());
        this.jPk.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.jPk.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.jPk.getEditText());
                }
            }
        });
    }

    private void cFj() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.jtR.getPicUrl();
            gifInfo.mDynamicUrl = this.jtR.getPicUrl();
            gifInfo.mStaticUrl = this.jtR.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.jtR.getPicUrl(), 10, true);
            c.kV().a(this.jtR.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.jtR.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.jtR.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.jtR.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.jtR.getWidth();
        this.mImageHeight = this.jtR.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.jPj;
            this.mImageHeight = this.jPj;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.jPj / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.jPj;
        } else {
            this.mImageWidth = (int) ((this.jPj / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.jPj;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.jPg.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fPd) {
            finish();
        } else if (view == this.jPh) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.jPk.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.jPo) {
            this.jPl.setCancel(false);
            this.jPo = true;
            this.jPs = System.currentTimeMillis();
            this.hzR.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.jPk.getEditText());
            if (TextUtils.isEmpty(this.jPk.getText())) {
                this.jPn = this.jtR;
                cFn();
                return;
            }
            String text = this.jPk.getText();
            switch (this.jPq) {
                case 2:
                    if (!TextUtils.isEmpty(this.jPp) && this.jPp.equals(text)) {
                        cFp();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.jPp) && this.jPp.equals(text) && !TextUtils.isEmpty(this.jPm)) {
                        Ik(this.jPm);
                        return;
                    }
                    break;
            }
            cFk();
            this.jPp = this.jPk.getText();
            cFl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFk() {
        if (this.jPr != null && !this.jPr.isRecycled()) {
            this.jPr.recycle();
            this.jPr = null;
        }
    }

    private void cFl() {
        this.jPl.Il(this.jPk.getText());
    }

    private void cFm() {
        if (!this.jPl.isCancel()) {
            this.jPk.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.jPl.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.jPl.isCancel()) {
                        Bitmap B = B(bdImage.getRawBitmap());
                        if (B != null) {
                            this.jPl.b(B, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.jPq = 2;
                        bUw();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.jPq = 2;
                bUw();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.jPm)) {
            bUw();
        } else {
            this.jPl.aB(this.jPm, true);
        }
    }

    private void cFn() {
        if (!this.jPl.isCancel()) {
            this.jPq = 0;
            bUw();
            if (this.jPn != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.jPn);
                setResult(-1, intent);
                finish();
                cFo();
                if (!TextUtils.isEmpty(this.jPm)) {
                    File file = new File(this.jPm);
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

    private void cFo() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.af("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.af("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.jPk.getText())) {
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
        if (!TextUtils.isEmpty(this.jPk.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cC = cC(width, height);
            if (cC != null) {
                canvas.drawBitmap(cC, (width * this.jPk.getLeft()) / i, (height * this.jPk.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cC(int i, int i2) {
        if (this.jPr != null) {
            return this.jPr;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.jPk.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.jPk.getTextView().getDrawingCache();
        this.jPr = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.jPr = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.jPr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.jPi.setVisibility(0);
            this.jPk.cFK();
            return;
        }
        this.jPi.setVisibility(8);
        this.jPk.cFJ();
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
        am.setImageResource(this.fPd, R.drawable.icon_emotion_close_n);
        am.setViewTextColor(this.jPh, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cFk();
        if (this.jPl != null) {
            this.jPl.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void cFp() {
        cFm();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Ij(String str) {
        showToast(str);
        this.jPq = 1;
        bUw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUw() {
        this.jPk.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.hzR.setDialogVisiable(false);
        this.jPo = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Ik(String str) {
        this.jPk.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bUw();
        } else if (!new File(str).exists()) {
            bUw();
        } else {
            this.jPm = str;
            this.jPq = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.jPs) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.jPn = new EmotionImageData();
                this.jPn.setPicId(uploadedPicInfo.getPic_id());
                this.jPn.setWidth(uploadedPicInfo.getWidth());
                this.jPn.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.jtR.getMemeContSign())) {
                    this.jPn.setMemeContSign(this.jtR.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.jPn.setPicUrl(picinfo.originPic.picUrl);
                    this.jPn.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.jPn.setMemeText(this.jPk.getText());
                this.jPn.setAuthorNameShow(this.jtR.getAuthorNameShow());
                cFn();
                return;
            }
            showToast(R.string.upload_error);
            this.jPq = 3;
            bUw();
            return;
        }
        showToast(R.string.upload_error);
        this.jPq = 3;
        bUw();
    }
}
