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
    private ImageView fjU;
    private a gOt;
    private EmotionImageData iHT;
    private EmotionEditLayout jdm;
    private View jdn;
    private ChooseColorLayout jdo;
    private int jdp;
    private EmotionEditText jdq;
    private EmotionEditModel jdr;
    private String jds;
    private EmotionImageData jdt;
    private boolean jdu;
    private String jdv;
    private int jdw = 0;
    private Bitmap jdx;
    private long jdy;
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
        this.iHT = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.jdr = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.gOt = new a(getPageContext());
        this.gOt.setTipString(R.string.emotion_composition);
        this.gOt.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.jdr.setCancel(true);
                EmotionEditActivity.this.cum();
                EmotionEditActivity.this.bJN();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.jdm = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.fjU = (ImageView) findViewById(R.id.close);
        this.jdn = findViewById(R.id.send);
        this.jdo = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.jdo.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void zD(int i) {
                EmotionEditActivity.this.jdq.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.fjU.setOnClickListener(this);
        this.jdn.setOnClickListener(this);
        this.jdp = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        initImageView();
        cul();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jdm.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jdm.setLayoutParams(layoutParams);
        this.jdq.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.jdm.a(this.jdq);
        this.jdo.setVisibility(8);
    }

    private void cul() {
        this.jdq = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.jdm.addView(this.jdq, layoutParams);
        this.jdq.setTextColor(this.jdo.getCurrentChooseColor());
        this.jdq.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.jdq.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.jdq.getEditText());
                }
            }
        });
    }

    private void initImageView() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.iHT.getPicUrl();
            gifInfo.mDynamicUrl = this.iHT.getPicUrl();
            gifInfo.mStaticUrl = this.iHT.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.iHT.getPicUrl(), 10, true);
            c.gr().a(this.iHT.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.iHT.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.iHT.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.iHT.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.iHT.getWidth();
        this.mImageHeight = this.iHT.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.jdp;
            this.mImageHeight = this.jdp;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.jdp / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.jdp;
        } else {
            this.mImageWidth = (int) ((this.jdp / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.jdp;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.jdm.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fjU) {
            finish();
        } else if (view == this.jdn) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.jdq.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.jdu) {
            this.jdr.setCancel(false);
            this.jdu = true;
            this.jdy = System.currentTimeMillis();
            this.gOt.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.jdq.getEditText());
            if (TextUtils.isEmpty(this.jdq.getText())) {
                this.jdt = this.iHT;
                cup();
                return;
            }
            String text = this.jdq.getText();
            switch (this.jdw) {
                case 2:
                    if (!TextUtils.isEmpty(this.jdv) && this.jdv.equals(text)) {
                        cur();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.jdv) && this.jdv.equals(text) && !TextUtils.isEmpty(this.jds)) {
                        Gz(this.jds);
                        return;
                    }
                    break;
            }
            cum();
            this.jdv = this.jdq.getText();
            cun();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cum() {
        if (this.jdx != null && !this.jdx.isRecycled()) {
            this.jdx.recycle();
            this.jdx = null;
        }
    }

    private void cun() {
        this.jdr.GA(this.jdq.getText());
    }

    private void cuo() {
        if (!this.jdr.isCancel()) {
            this.jdq.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.jdr.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.jdr.isCancel()) {
                        Bitmap z = z(bdImage.getRawBitmap());
                        if (z != null) {
                            this.jdr.b(z, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.jdw = 2;
                        bJN();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.jdw = 2;
                bJN();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.jds)) {
            bJN();
        } else {
            this.jdr.av(this.jds, true);
        }
    }

    private void cup() {
        if (!this.jdr.isCancel()) {
            this.jdw = 0;
            bJN();
            if (this.jdt != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.jdt);
                setResult(-1, intent);
                finish();
                cuq();
                if (!TextUtils.isEmpty(this.jds)) {
                    File file = new File(this.jds);
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

    private void cuq() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.X("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.X("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.jdq.getText())) {
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
        if (!TextUtils.isEmpty(this.jdq.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cv = cv(width, height);
            if (cv != null) {
                canvas.drawBitmap(cv, (width * this.jdq.getLeft()) / i, (height * this.jdq.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cv(int i, int i2) {
        if (this.jdx != null) {
            return this.jdx;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.jdq.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.jdq.getTextView().getDrawingCache();
        this.jdx = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.jdx = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.jdx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.jdo.setVisibility(0);
            this.jdq.cuM();
            return;
        }
        this.jdo.setVisibility(8);
        this.jdq.cuL();
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
        am.setImageResource(this.fjU, R.drawable.icon_emotion_close_n);
        am.setViewTextColor(this.jdn, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cum();
        if (this.jdr != null) {
            this.jdr.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void cur() {
        cuo();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Gy(String str) {
        showToast(str);
        this.jdw = 1;
        bJN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJN() {
        this.jdq.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.gOt.setDialogVisiable(false);
        this.jdu = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Gz(String str) {
        this.jdq.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bJN();
        } else if (!new File(str).exists()) {
            bJN();
        } else {
            this.jds = str;
            this.jdw = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.jdy) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.jdt = new EmotionImageData();
                this.jdt.setPicId(uploadedPicInfo.getPic_id());
                this.jdt.setWidth(uploadedPicInfo.getWidth());
                this.jdt.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.iHT.getMemeContSign())) {
                    this.jdt.setMemeContSign(this.iHT.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.jdt.setPicUrl(picinfo.originPic.picUrl);
                    this.jdt.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.jdt.setMemeText(this.jdq.getText());
                this.jdt.setAuthorNameShow(this.iHT.getAuthorNameShow());
                cup();
                return;
            }
            showToast(R.string.upload_error);
            this.jdw = 3;
            bJN();
            return;
        }
        showToast(R.string.upload_error);
        this.jdw = 3;
        bJN();
    }
}
