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
    private long jcA;
    private EmotionEditLayout jco;
    private View jcp;
    private ChooseColorLayout jcq;
    private int jcr;
    private EmotionEditText jcs;
    private EmotionEditModel jct;
    private String jcu;
    private EmotionImageData jcv;
    private boolean jcw;
    private String jcx;
    private int jcy = 0;
    private Bitmap jcz;
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
        this.jct = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.gMs = new a(getPageContext());
        this.gMs.setTipString(R.string.emotion_composition);
        this.gMs.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.jct.setCancel(true);
                EmotionEditActivity.this.csR();
                EmotionEditActivity.this.bIj();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.jco = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.fgN = (ImageView) findViewById(R.id.close);
        this.jcp = findViewById(R.id.send);
        this.jcq = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.jcq.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void zw(int i) {
                EmotionEditActivity.this.jcs.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.fgN.setOnClickListener(this);
        this.jcp.setOnClickListener(this);
        this.jcr = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        initImageView();
        csQ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jco.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jco.setLayoutParams(layoutParams);
        this.jcs.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.jco.a(this.jcs);
        this.jcq.setVisibility(8);
    }

    private void csQ() {
        this.jcs = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.jco.addView(this.jcs, layoutParams);
        this.jcs.setTextColor(this.jcq.getCurrentChooseColor());
        this.jcs.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.jcs.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.jcs.getEditText());
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
            this.mImageWidth = this.jcr;
            this.mImageHeight = this.jcr;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.jcr / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.jcr;
        } else {
            this.mImageWidth = (int) ((this.jcr / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.jcr;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.jco.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fgN) {
            finish();
        } else if (view == this.jcp) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.jcs.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.jcw) {
            this.jct.setCancel(false);
            this.jcw = true;
            this.jcA = System.currentTimeMillis();
            this.gMs.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.jcs.getEditText());
            if (TextUtils.isEmpty(this.jcs.getText())) {
                this.jcv = this.iGn;
                csU();
                return;
            }
            String text = this.jcs.getText();
            switch (this.jcy) {
                case 2:
                    if (!TextUtils.isEmpty(this.jcx) && this.jcx.equals(text)) {
                        csW();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.jcx) && this.jcx.equals(text) && !TextUtils.isEmpty(this.jcu)) {
                        Gk(this.jcu);
                        return;
                    }
                    break;
            }
            csR();
            this.jcx = this.jcs.getText();
            csS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csR() {
        if (this.jcz != null && !this.jcz.isRecycled()) {
            this.jcz.recycle();
            this.jcz = null;
        }
    }

    private void csS() {
        this.jct.Gm(this.jcs.getText());
    }

    private void csT() {
        if (!this.jct.isCancel()) {
            this.jcs.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.jct.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.jct.isCancel()) {
                        Bitmap z = z(bdImage.getRawBitmap());
                        if (z != null) {
                            this.jct.b(z, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.jcy = 2;
                        bIj();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.jcy = 2;
                bIj();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.jcu)) {
            bIj();
        } else {
            this.jct.av(this.jcu, true);
        }
    }

    private void csU() {
        if (!this.jct.isCancel()) {
            this.jcy = 0;
            bIj();
            if (this.jcv != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.jcv);
                setResult(-1, intent);
                finish();
                csV();
                if (!TextUtils.isEmpty(this.jcu)) {
                    File file = new File(this.jcu);
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

    private void csV() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.Z("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.Z("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.jcs.getText())) {
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
        if (!TextUtils.isEmpty(this.jcs.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cu = cu(width, height);
            if (cu != null) {
                canvas.drawBitmap(cu, (width * this.jcs.getLeft()) / i, (height * this.jcs.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cu(int i, int i2) {
        if (this.jcz != null) {
            return this.jcz;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.jcs.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.jcs.getTextView().getDrawingCache();
        this.jcz = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.jcz = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.jcz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.jcq.setVisibility(0);
            this.jcs.ctr();
            return;
        }
        this.jcq.setVisibility(8);
        this.jcs.ctq();
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
        am.setViewTextColor(this.jcp, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        csR();
        if (this.jct != null) {
            this.jct.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void csW() {
        csT();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Gj(String str) {
        showToast(str);
        this.jcy = 1;
        bIj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIj() {
        this.jcs.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.gMs.setDialogVisiable(false);
        this.jcw = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Gk(String str) {
        this.jcs.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bIj();
        } else if (!new File(str).exists()) {
            bIj();
        } else {
            this.jcu = str;
            this.jcy = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.jcA) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.jcv = new EmotionImageData();
                this.jcv.setPicId(uploadedPicInfo.getPic_id());
                this.jcv.setWidth(uploadedPicInfo.getWidth());
                this.jcv.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.iGn.getMemeContSign())) {
                    this.jcv.setMemeContSign(this.iGn.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.jcv.setPicUrl(picinfo.originPic.picUrl);
                    this.jcv.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.jcv.setMemeText(this.jcs.getText());
                this.jcv.setAuthorNameShow(this.iGn.getAuthorNameShow());
                csU();
                return;
            }
            showToast(R.string.upload_error);
            this.jcy = 3;
            bIj();
            return;
        }
        showToast(R.string.upload_error);
        this.jcy = 3;
        bIj();
    }
}
