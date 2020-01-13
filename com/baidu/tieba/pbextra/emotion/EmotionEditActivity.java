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
/* loaded from: classes7.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView fgN;
    private a gMs;
    private EmotionImageData iGn;
    private EmotionEditLayout jcj;
    private View jck;
    private ChooseColorLayout jcl;
    private int jcm;
    private EmotionEditText jcn;
    private EmotionEditModel jco;
    private String jcp;
    private EmotionImageData jcq;
    private boolean jcr;
    private String jcs;
    private int jct = 0;
    private Bitmap jcu;
    private long jcv;
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
        this.iGn = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.jco = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.gMs = new a(getPageContext());
        this.gMs.setTipString(R.string.emotion_composition);
        this.gMs.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.jco.setCancel(true);
                EmotionEditActivity.this.csP();
                EmotionEditActivity.this.bIj();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.jcj = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.fgN = (ImageView) findViewById(R.id.close);
        this.jck = findViewById(R.id.send);
        this.jcl = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.jcl.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void zw(int i) {
                EmotionEditActivity.this.jcn.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.fgN.setOnClickListener(this);
        this.jck.setOnClickListener(this);
        this.jcm = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        initImageView();
        csO();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jcj.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jcj.setLayoutParams(layoutParams);
        this.jcn.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.jcj.a(this.jcn);
        this.jcl.setVisibility(8);
    }

    private void csO() {
        this.jcn = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.jcj.addView(this.jcn, layoutParams);
        this.jcn.setTextColor(this.jcl.getCurrentChooseColor());
        this.jcn.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.jcn.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.jcn.getEditText());
                }
            }
        });
    }

    private void initImageView() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.iGn.getPicUrl();
            gifInfo.mDynamicUrl = this.iGn.getPicUrl();
            gifInfo.mStaticUrl = this.iGn.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.iGn.getPicUrl(), 10, true);
            c.gr().a(this.iGn.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.iGn.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.iGn.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.iGn.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.iGn.getWidth();
        this.mImageHeight = this.iGn.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.jcm;
            this.mImageHeight = this.jcm;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.jcm / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.jcm;
        } else {
            this.mImageWidth = (int) ((this.jcm / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.jcm;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.jcj.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fgN) {
            finish();
        } else if (view == this.jck) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.jcn.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.jcr) {
            this.jco.setCancel(false);
            this.jcr = true;
            this.jcv = System.currentTimeMillis();
            this.gMs.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.jcn.getEditText());
            if (TextUtils.isEmpty(this.jcn.getText())) {
                this.jcq = this.iGn;
                csS();
                return;
            }
            String text = this.jcn.getText();
            switch (this.jct) {
                case 2:
                    if (!TextUtils.isEmpty(this.jcs) && this.jcs.equals(text)) {
                        csU();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.jcs) && this.jcs.equals(text) && !TextUtils.isEmpty(this.jcp)) {
                        Gk(this.jcp);
                        return;
                    }
                    break;
            }
            csP();
            this.jcs = this.jcn.getText();
            csQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csP() {
        if (this.jcu != null && !this.jcu.isRecycled()) {
            this.jcu.recycle();
            this.jcu = null;
        }
    }

    private void csQ() {
        this.jco.Gm(this.jcn.getText());
    }

    private void csR() {
        if (!this.jco.isCancel()) {
            this.jcn.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.jco.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.jco.isCancel()) {
                        Bitmap z = z(bdImage.getRawBitmap());
                        if (z != null) {
                            this.jco.b(z, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.jct = 2;
                        bIj();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.jct = 2;
                bIj();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.jcp)) {
            bIj();
        } else {
            this.jco.av(this.jcp, true);
        }
    }

    private void csS() {
        if (!this.jco.isCancel()) {
            this.jct = 0;
            bIj();
            if (this.jcq != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.jcq);
                setResult(-1, intent);
                finish();
                csT();
                if (!TextUtils.isEmpty(this.jcp)) {
                    File file = new File(this.jcp);
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

    private void csT() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.Z("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.Z("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.jcn.getText())) {
            anVar.Z("obj_type", 1);
        } else {
            anVar.Z("obj_type", 2);
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
        if (!TextUtils.isEmpty(this.jcn.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cu = cu(width, height);
            if (cu != null) {
                canvas.drawBitmap(cu, (width * this.jcn.getLeft()) / i, (height * this.jcn.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cu(int i, int i2) {
        if (this.jcu != null) {
            return this.jcu;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.jcn.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.jcn.getTextView().getDrawingCache();
        this.jcu = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.jcu = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.jcu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.jcl.setVisibility(0);
            this.jcn.ctp();
            return;
        }
        this.jcl.setVisibility(8);
        this.jcn.cto();
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
        am.setImageResource(this.fgN, R.drawable.icon_emotion_close_n);
        am.setViewTextColor(this.jck, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        csP();
        if (this.jco != null) {
            this.jco.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void csU() {
        csR();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Gj(String str) {
        showToast(str);
        this.jct = 1;
        bIj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIj() {
        this.jcn.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.gMs.setDialogVisiable(false);
        this.jcr = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Gk(String str) {
        this.jcn.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bIj();
        } else if (!new File(str).exists()) {
            bIj();
        } else {
            this.jcp = str;
            this.jct = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.jcv) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.jcq = new EmotionImageData();
                this.jcq.setPicId(uploadedPicInfo.getPic_id());
                this.jcq.setWidth(uploadedPicInfo.getWidth());
                this.jcq.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.iGn.getMemeContSign())) {
                    this.jcq.setMemeContSign(this.iGn.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.jcq.setPicUrl(picinfo.originPic.picUrl);
                    this.jcq.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.jcq.setMemeText(this.jcn.getText());
                this.jcq.setAuthorNameShow(this.iGn.getAuthorNameShow());
                csS();
                return;
            }
            showToast(R.string.upload_error);
            this.jct = 3;
            bIj();
            return;
        }
        showToast(R.string.upload_error);
        this.jct = 3;
        bIj();
    }
}
