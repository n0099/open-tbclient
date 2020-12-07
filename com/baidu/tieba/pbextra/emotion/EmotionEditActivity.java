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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
/* loaded from: classes22.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView jVn;
    private a jzK;
    private EmotionImageData lIj;
    private String mFrom;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mRootView;
    private EmotionEditLayout mfO;
    private View mfP;
    private ChooseColorLayout mfQ;
    private int mfR;
    private EmotionEditText mfS;
    private EmotionEditModel mfT;
    private String mfU;
    private EmotionImageData mfV;
    private boolean mfW;
    private String mfX;
    private int mfY = 0;
    private Bitmap mfZ;
    private long mga;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.emotion_edit_activity);
        this.lIj = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.mfT = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.jzK = new a(getPageContext());
        this.jzK.setTipString(R.string.emotion_composition);
        this.jzK.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.mfT.wn(true);
                EmotionEditActivity.this.dxt();
                EmotionEditActivity.this.cJL();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.mfO = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.jVn = (ImageView) findViewById(R.id.close);
        this.mfP = findViewById(R.id.send);
        this.mfQ = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.mfQ.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void HX(int i) {
                EmotionEditActivity.this.mfS.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.jVn.setOnClickListener(this);
        this.mfP.setOnClickListener(this);
        this.mfR = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        dxs();
        dxr();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mfO.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mfO.setLayoutParams(layoutParams);
        this.mfS.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mfO.a(this.mfS);
        this.mfQ.setVisibility(8);
    }

    private void dxr() {
        this.mfS = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mfO.addView(this.mfS, layoutParams);
        this.mfS.setTextColor(this.mfQ.getCurrentChooseColor());
        this.mfS.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.mfS.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.mfS.getEditText());
                }
            }
        });
    }

    private void dxs() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.lIj.getPicUrl();
            gifInfo.mDynamicUrl = this.lIj.getPicUrl();
            gifInfo.mStaticUrl = this.lIj.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.lIj.getPicUrl(), 10, true);
            c.mS().a(this.lIj.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.lIj.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.lIj.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.lIj.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.lIj.getWidth();
        this.mImageHeight = this.lIj.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.mfR;
            this.mImageHeight = this.mfR;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.mfR / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.mfR;
        } else {
            this.mImageWidth = (int) ((this.mfR / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.mfR;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.mfO.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jVn) {
            finish();
        } else if (view == this.mfP) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.mfS.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.mfW) {
            this.mfT.wn(false);
            this.mfW = true;
            this.mga = System.currentTimeMillis();
            this.jzK.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.mfS.getEditText());
            if (TextUtils.isEmpty(this.mfS.getText())) {
                this.mfV = this.lIj;
                dxx();
                return;
            }
            String text = this.mfS.getText();
            switch (this.mfY) {
                case 2:
                    if (!TextUtils.isEmpty(this.mfX) && this.mfX.equals(text)) {
                        dxz();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.mfX) && this.mfX.equals(text) && !TextUtils.isEmpty(this.mfU)) {
                        QQ(this.mfU);
                        return;
                    }
                    break;
            }
            dxt();
            this.mfX = this.mfS.getText();
            dxu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxt() {
        if (this.mfZ != null && !this.mfZ.isRecycled()) {
            this.mfZ.recycle();
            this.mfZ = null;
        }
    }

    private void dxu() {
        this.mfT.QR(this.mfS.getText());
    }

    private void dxv() {
        if (!this.mfT.isCancel()) {
            this.mfS.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.mfT.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.mfT.isCancel()) {
                        Bitmap F = F(bdImage.getRawBitmap());
                        if (F != null) {
                            this.mfT.b(F, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.mfY = 2;
                        cJL();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.mfY = 2;
                cJL();
            }
        }
    }

    private void dxw() {
        if (TextUtils.isEmpty(this.mfU)) {
            cJL();
        } else {
            this.mfT.aZ(this.mfU, true);
        }
    }

    private void dxx() {
        if (!this.mfT.isCancel()) {
            this.mfY = 0;
            cJL();
            if (this.mfV != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.mfV);
                setResult(-1, intent);
                finish();
                dxy();
                if (!TextUtils.isEmpty(this.mfU)) {
                    File file = new File(this.mfU);
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

    private void dxy() {
        ar arVar = new ar("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                arVar.al("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                arVar.al("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.mfS.getText())) {
            arVar.al("obj_type", 1);
        } else {
            arVar.al("obj_type", 2);
        }
        TiebaStatic.log(arVar);
    }

    public Bitmap F(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.mfS.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap dk = dk(width, height);
            if (dk != null) {
                canvas.drawBitmap(dk, (width * this.mfS.getLeft()) / i, (height * this.mfS.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap dk(int i, int i2) {
        if (this.mfZ != null) {
            return this.mfZ;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.mfS.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.mfS.getTextView().getDrawingCache();
        this.mfZ = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.mfZ = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.mfZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.mfQ.setVisibility(0);
            this.mfS.dxU();
            return;
        }
        this.mfQ.setVisibility(8);
        this.mfS.dxT();
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
        ap.setBackgroundColor(this.mRootView, R.color.black_alpha40);
        ap.setImageResource(this.jVn, R.drawable.icon_emotion_close_n);
        ap.setViewTextColor(this.mfP, (int) R.color.CAM_X0111);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dxt();
        if (this.mfT != null) {
            this.mfT.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void dxz() {
        dxv();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void QP(String str) {
        showToast(str);
        this.mfY = 1;
        cJL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJL() {
        this.mfS.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.jzK.setDialogVisiable(false);
        this.mfW = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void QQ(String str) {
        this.mfS.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            cJL();
        } else if (!new File(str).exists()) {
            cJL();
        } else {
            this.mfU = str;
            this.mfY = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.mga) + "ms");
            dxw();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.mfV = new EmotionImageData();
                this.mfV.setPicId(uploadedPicInfo.getPic_id());
                this.mfV.setWidth(uploadedPicInfo.getWidth());
                this.mfV.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.lIj.getMemeContSign())) {
                    this.mfV.setMemeContSign(this.lIj.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.mfV.setPicUrl(picinfo.originPic.picUrl);
                    this.mfV.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.mfV.setMemeText(this.mfS.getText());
                this.mfV.setAuthorNameShow(this.lIj.getAuthorNameShow());
                dxx();
                return;
            }
            showToast(R.string.upload_error);
            this.mfY = 3;
            cJL();
            return;
        }
        showToast(R.string.upload_error);
        this.mfY = 3;
        cJL();
    }
}
