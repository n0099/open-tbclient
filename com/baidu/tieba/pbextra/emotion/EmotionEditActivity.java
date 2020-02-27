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
    private ImageView fjT;
    private a gOr;
    private EmotionImageData iHR;
    private EmotionEditLayout jdk;
    private View jdl;
    private ChooseColorLayout jdm;
    private int jdn;
    private EmotionEditText jdo;
    private EmotionEditModel jdp;
    private String jdq;
    private EmotionImageData jdr;
    private boolean jds;
    private String jdt;
    private int jdu = 0;
    private Bitmap jdv;
    private long jdw;
    private String mFrom;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.emotion_edit_activity);
        this.iHR = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.jdp = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.gOr = new a(getPageContext());
        this.gOr.setTipString(R.string.emotion_composition);
        this.gOr.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.jdp.setCancel(true);
                EmotionEditActivity.this.cuk();
                EmotionEditActivity.this.bJL();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.jdk = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.fjT = (ImageView) findViewById(R.id.close);
        this.jdl = findViewById(R.id.send);
        this.jdm = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.jdm.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void zD(int i) {
                EmotionEditActivity.this.jdo.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.fjT.setOnClickListener(this);
        this.jdl.setOnClickListener(this);
        this.jdn = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        initImageView();
        cuj();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jdk.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jdk.setLayoutParams(layoutParams);
        this.jdo.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.jdk.a(this.jdo);
        this.jdm.setVisibility(8);
    }

    private void cuj() {
        this.jdo = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.jdk.addView(this.jdo, layoutParams);
        this.jdo.setTextColor(this.jdm.getCurrentChooseColor());
        this.jdo.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.jdo.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.jdo.getEditText());
                }
            }
        });
    }

    private void initImageView() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.iHR.getPicUrl();
            gifInfo.mDynamicUrl = this.iHR.getPicUrl();
            gifInfo.mStaticUrl = this.iHR.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.iHR.getPicUrl(), 10, true);
            c.gr().a(this.iHR.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.iHR.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.iHR.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.iHR.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.iHR.getWidth();
        this.mImageHeight = this.iHR.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.jdn;
            this.mImageHeight = this.jdn;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.jdn / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.jdn;
        } else {
            this.mImageWidth = (int) ((this.jdn / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.jdn;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.jdk.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fjT) {
            finish();
        } else if (view == this.jdl) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.jdo.getEditText());
        }
    }

    private void send() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.jds) {
            this.jdp.setCancel(false);
            this.jds = true;
            this.jdw = System.currentTimeMillis();
            this.gOr.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.jdo.getEditText());
            if (TextUtils.isEmpty(this.jdo.getText())) {
                this.jdr = this.iHR;
                cun();
                return;
            }
            String text = this.jdo.getText();
            switch (this.jdu) {
                case 2:
                    if (!TextUtils.isEmpty(this.jdt) && this.jdt.equals(text)) {
                        cup();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.jdt) && this.jdt.equals(text) && !TextUtils.isEmpty(this.jdq)) {
                        Gz(this.jdq);
                        return;
                    }
                    break;
            }
            cuk();
            this.jdt = this.jdo.getText();
            cul();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuk() {
        if (this.jdv != null && !this.jdv.isRecycled()) {
            this.jdv.recycle();
            this.jdv = null;
        }
    }

    private void cul() {
        this.jdp.GA(this.jdo.getText());
    }

    private void cum() {
        if (!this.jdp.isCancel()) {
            this.jdo.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.jdp.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.jdp.isCancel()) {
                        Bitmap z = z(bdImage.getRawBitmap());
                        if (z != null) {
                            this.jdp.b(z, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.jdu = 2;
                        bJL();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.jdu = 2;
                bJL();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.jdq)) {
            bJL();
        } else {
            this.jdp.av(this.jdq, true);
        }
    }

    private void cun() {
        if (!this.jdp.isCancel()) {
            this.jdu = 0;
            bJL();
            if (this.jdr != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.jdr);
                setResult(-1, intent);
                finish();
                cuo();
                if (!TextUtils.isEmpty(this.jdq)) {
                    File file = new File(this.jdq);
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

    private void cuo() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.X("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.X("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.jdo.getText())) {
            anVar.X("obj_type", 1);
        } else {
            anVar.X("obj_type", 2);
        }
        TiebaStatic.log(anVar);
    }

    public Bitmap z(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.jdo.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cv = cv(width, height);
            if (cv != null) {
                canvas.drawBitmap(cv, (width * this.jdo.getLeft()) / i, (height * this.jdo.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cv(int i, int i2) {
        if (this.jdv != null) {
            return this.jdv;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.jdo.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.jdo.getTextView().getDrawingCache();
        this.jdv = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.jdv = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.jdv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.jdm.setVisibility(0);
            this.jdo.cuK();
            return;
        }
        this.jdm.setVisibility(8);
        this.jdo.cuJ();
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
        am.setImageResource(this.fjT, R.drawable.icon_emotion_close_n);
        am.setViewTextColor(this.jdl, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cuk();
        if (this.jdp != null) {
            this.jdp.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void cup() {
        cum();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Gy(String str) {
        showToast(str);
        this.jdu = 1;
        bJL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJL() {
        this.jdo.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.gOr.setDialogVisiable(false);
        this.jds = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Gz(String str) {
        this.jdo.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bJL();
        } else if (!new File(str).exists()) {
            bJL();
        } else {
            this.jdq = str;
            this.jdu = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.jdw) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.jdr = new EmotionImageData();
                this.jdr.setPicId(uploadedPicInfo.getPic_id());
                this.jdr.setWidth(uploadedPicInfo.getWidth());
                this.jdr.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.iHR.getMemeContSign())) {
                    this.jdr.setMemeContSign(this.iHR.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.jdr.setPicUrl(picinfo.originPic.picUrl);
                    this.jdr.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.jdr.setMemeText(this.jdo.getText());
                this.jdr.setAuthorNameShow(this.iHR.getAuthorNameShow());
                cun();
                return;
            }
            showToast(R.string.upload_error);
            this.jdu = 3;
            bJL();
            return;
        }
        showToast(R.string.upload_error);
        this.jdu = 3;
        bJL();
    }
}
