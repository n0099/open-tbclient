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
    private ImageView fkh;
    private a gOF;
    private EmotionImageData iIf;
    private ChooseColorLayout jdA;
    private int jdB;
    private EmotionEditText jdC;
    private EmotionEditModel jdD;
    private String jdE;
    private EmotionImageData jdF;
    private boolean jdG;
    private String jdH;
    private int jdI = 0;
    private Bitmap jdJ;
    private long jdK;
    private EmotionEditLayout jdy;
    private View jdz;
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
        this.iIf = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.jdD = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.gOF = new a(getPageContext());
        this.gOF.setTipString(R.string.emotion_composition);
        this.gOF.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.jdD.setCancel(true);
                EmotionEditActivity.this.cun();
                EmotionEditActivity.this.bJO();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.jdy = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.fkh = (ImageView) findViewById(R.id.close);
        this.jdz = findViewById(R.id.send);
        this.jdA = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.jdA.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void zD(int i) {
                EmotionEditActivity.this.jdC.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.fkh.setOnClickListener(this);
        this.jdz.setOnClickListener(this);
        this.jdB = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        initImageView();
        cum();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jdy.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jdy.setLayoutParams(layoutParams);
        this.jdC.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.jdy.a(this.jdC);
        this.jdA.setVisibility(8);
    }

    private void cum() {
        this.jdC = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.jdy.addView(this.jdC, layoutParams);
        this.jdC.setTextColor(this.jdA.getCurrentChooseColor());
        this.jdC.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.jdC.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.jdC.getEditText());
                }
            }
        });
    }

    private void initImageView() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.iIf.getPicUrl();
            gifInfo.mDynamicUrl = this.iIf.getPicUrl();
            gifInfo.mStaticUrl = this.iIf.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.iIf.getPicUrl(), 10, true);
            c.gr().a(this.iIf.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.iIf.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.iIf.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.iIf.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.iIf.getWidth();
        this.mImageHeight = this.iIf.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.jdB;
            this.mImageHeight = this.jdB;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.jdB / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.jdB;
        } else {
            this.mImageWidth = (int) ((this.jdB / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.jdB;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.jdy.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fkh) {
            finish();
        } else if (view == this.jdz) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.jdC.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.jdG) {
            this.jdD.setCancel(false);
            this.jdG = true;
            this.jdK = System.currentTimeMillis();
            this.gOF.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.jdC.getEditText());
            if (TextUtils.isEmpty(this.jdC.getText())) {
                this.jdF = this.iIf;
                cuq();
                return;
            }
            String text = this.jdC.getText();
            switch (this.jdI) {
                case 2:
                    if (!TextUtils.isEmpty(this.jdH) && this.jdH.equals(text)) {
                        cus();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.jdH) && this.jdH.equals(text) && !TextUtils.isEmpty(this.jdE)) {
                        GA(this.jdE);
                        return;
                    }
                    break;
            }
            cun();
            this.jdH = this.jdC.getText();
            cuo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cun() {
        if (this.jdJ != null && !this.jdJ.isRecycled()) {
            this.jdJ.recycle();
            this.jdJ = null;
        }
    }

    private void cuo() {
        this.jdD.GB(this.jdC.getText());
    }

    private void cup() {
        if (!this.jdD.isCancel()) {
            this.jdC.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.jdD.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.jdD.isCancel()) {
                        Bitmap z = z(bdImage.getRawBitmap());
                        if (z != null) {
                            this.jdD.b(z, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.jdI = 2;
                        bJO();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.jdI = 2;
                bJO();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.jdE)) {
            bJO();
        } else {
            this.jdD.av(this.jdE, true);
        }
    }

    private void cuq() {
        if (!this.jdD.isCancel()) {
            this.jdI = 0;
            bJO();
            if (this.jdF != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.jdF);
                setResult(-1, intent);
                finish();
                cur();
                if (!TextUtils.isEmpty(this.jdE)) {
                    File file = new File(this.jdE);
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

    private void cur() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.X("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.X("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.jdC.getText())) {
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
        if (!TextUtils.isEmpty(this.jdC.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cv = cv(width, height);
            if (cv != null) {
                canvas.drawBitmap(cv, (width * this.jdC.getLeft()) / i, (height * this.jdC.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cv(int i, int i2) {
        if (this.jdJ != null) {
            return this.jdJ;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.jdC.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.jdC.getTextView().getDrawingCache();
        this.jdJ = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.jdJ = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.jdJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.jdA.setVisibility(0);
            this.jdC.cuN();
            return;
        }
        this.jdA.setVisibility(8);
        this.jdC.cuM();
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
        am.setImageResource(this.fkh, R.drawable.icon_emotion_close_n);
        am.setViewTextColor(this.jdz, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cun();
        if (this.jdD != null) {
            this.jdD.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void cus() {
        cup();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Gz(String str) {
        showToast(str);
        this.jdI = 1;
        bJO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJO() {
        this.jdC.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.gOF.setDialogVisiable(false);
        this.jdG = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void GA(String str) {
        this.jdC.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bJO();
        } else if (!new File(str).exists()) {
            bJO();
        } else {
            this.jdE = str;
            this.jdI = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.jdK) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.jdF = new EmotionImageData();
                this.jdF.setPicId(uploadedPicInfo.getPic_id());
                this.jdF.setWidth(uploadedPicInfo.getWidth());
                this.jdF.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.iIf.getMemeContSign())) {
                    this.jdF.setMemeContSign(this.iIf.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.jdF.setPicUrl(picinfo.originPic.picUrl);
                    this.jdF.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.jdF.setMemeText(this.jdC.getText());
                this.jdF.setAuthorNameShow(this.iIf.getAuthorNameShow());
                cuq();
                return;
            }
            showToast(R.string.upload_error);
            this.jdI = 3;
            bJO();
            return;
        }
        showToast(R.string.upload_error);
        this.jdI = 3;
        bJO();
    }
}
