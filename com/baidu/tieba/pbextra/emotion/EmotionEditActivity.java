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
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
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
/* loaded from: classes2.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView izx;
    private a jPg;
    private EmotionImageData lUj;
    private String mFrom;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mRootView;
    private EmotionEditLayout mrQ;
    private View mrR;
    private ChooseColorLayout mrS;
    private int mrT;
    private EmotionEditText mrU;
    private EmotionEditModel mrV;
    private String mrW;
    private EmotionImageData mrX;
    private boolean mrY;
    private String mrZ;
    private int msa = 0;
    private Bitmap msb;
    private long msc;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.emotion_edit_activity);
        this.lUj = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.mrV = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.jPg = new a(getPageContext());
        this.jPg.setTipString(R.string.emotion_composition);
        this.jPg.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.mrV.wB(true);
                EmotionEditActivity.this.dvR();
                EmotionEditActivity.this.cKv();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.mrQ = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.izx = (ImageView) findViewById(R.id.close);
        this.mrR = findViewById(R.id.send);
        this.mrS = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.mrS.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void GF(int i) {
                EmotionEditActivity.this.mrU.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.izx.setOnClickListener(this);
        this.mrR.setOnClickListener(this);
        this.mrT = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        dvQ();
        dvP();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mrQ.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mrQ.setLayoutParams(layoutParams);
        this.mrU.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mrQ.a(this.mrU);
        this.mrS.setVisibility(8);
    }

    private void dvP() {
        this.mrU = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mrQ.addView(this.mrU, layoutParams);
        this.mrU.setTextColor(this.mrS.getCurrentChooseColor());
        this.mrU.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.mrU.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.mrU.getEditText());
                }
            }
        });
    }

    private void dvQ() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.lUj.getPicUrl();
            gifInfo.mDynamicUrl = this.lUj.getPicUrl();
            gifInfo.mStaticUrl = this.lUj.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.lUj.getPicUrl(), 10, true);
            d.mw().a(this.lUj.getPicUrl(), 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.drawImageTo(EmotionEditActivity.this.mImageView);
                            EmotionEditActivity.this.mImageView = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.mImageView).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.lUj.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.lUj.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.lUj.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.lUj.getWidth();
        this.mImageHeight = this.lUj.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.mrT;
            this.mImageHeight = this.mrT;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.mrT / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.mrT;
        } else {
            this.mImageWidth = (int) ((this.mrT / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.mrT;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.mrQ.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.izx) {
            finish();
        } else if (view == this.mrR) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.mrU.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.mrY) {
            this.mrV.wB(false);
            this.mrY = true;
            this.msc = System.currentTimeMillis();
            this.jPg.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.mrU.getEditText());
            if (TextUtils.isEmpty(this.mrU.getText())) {
                this.mrX = this.lUj;
                dvV();
                return;
            }
            String text = this.mrU.getText();
            switch (this.msa) {
                case 2:
                    if (!TextUtils.isEmpty(this.mrZ) && this.mrZ.equals(text)) {
                        dvX();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.mrZ) && this.mrZ.equals(text) && !TextUtils.isEmpty(this.mrW)) {
                        Qm(this.mrW);
                        return;
                    }
                    break;
            }
            dvR();
            this.mrZ = this.mrU.getText();
            dvS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvR() {
        if (this.msb != null && !this.msb.isRecycled()) {
            this.msb.recycle();
            this.msb = null;
        }
    }

    private void dvS() {
        this.mrV.Qn(this.mrU.getText());
    }

    private void dvT() {
        if (!this.mrV.isCancel()) {
            this.mrU.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.mrV.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.mrV.isCancel()) {
                        Bitmap F = F(bdImage.getRawBitmap());
                        if (F != null) {
                            this.mrV.b(F, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.msa = 2;
                        cKv();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.msa = 2;
                cKv();
            }
        }
    }

    private void dvU() {
        if (TextUtils.isEmpty(this.mrW)) {
            cKv();
        } else {
            this.mrV.aZ(this.mrW, true);
        }
    }

    private void dvV() {
        if (!this.mrV.isCancel()) {
            this.msa = 0;
            cKv();
            if (this.mrX != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.mrX);
                setResult(-1, intent);
                finish();
                dvW();
                if (!TextUtils.isEmpty(this.mrW)) {
                    File file = new File(this.mrW);
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

    private void dvW() {
        ar arVar = new ar("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                arVar.aq("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                arVar.aq("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.mrU.getText())) {
            arVar.aq("obj_type", 1);
        } else {
            arVar.aq("obj_type", 2);
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
        if (!TextUtils.isEmpty(this.mrU.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap de = de(width, height);
            if (de != null) {
                canvas.drawBitmap(de, (width * this.mrU.getLeft()) / i, (height * this.mrU.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public Bitmap de(int i, int i2) {
        if (this.msb != null) {
            return this.msb;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.mrU.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.mrU.getTextView().getDrawingCache();
        this.msb = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.msb = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.msb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.mrS.setVisibility(0);
            this.mrU.dws();
            return;
        }
        this.mrS.setVisibility(8);
        this.mrU.dwr();
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
        ap.setImageResource(this.izx, R.drawable.icon_emotion_close_n);
        ap.setViewTextColor(this.mrR, R.color.CAM_X0111);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dvR();
        if (this.mrV != null) {
            this.mrV.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void dvX() {
        dvT();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Ql(String str) {
        showToast(str);
        this.msa = 1;
        cKv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKv() {
        this.mrU.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.jPg.setDialogVisiable(false);
        this.mrY = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Qm(String str) {
        this.mrU.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            cKv();
        } else if (!new File(str).exists()) {
            cKv();
        } else {
            this.mrW = str;
            this.msa = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.msc) + "ms");
            dvU();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.mrX = new EmotionImageData();
                this.mrX.setPicId(uploadedPicInfo.getPic_id());
                this.mrX.setWidth(uploadedPicInfo.getWidth());
                this.mrX.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.lUj.getMemeContSign())) {
                    this.mrX.setMemeContSign(this.lUj.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.mrX.setPicUrl(picinfo.originPic.picUrl);
                    this.mrX.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.mrX.setMemeText(this.mrU.getText());
                this.mrX.setAuthorNameShow(this.lUj.getAuthorNameShow());
                dvV();
                return;
            }
            showToast(R.string.upload_error);
            this.msa = 3;
            cKv();
            return;
        }
        showToast(R.string.upload_error);
        this.msa = 3;
        cKv();
    }
}
