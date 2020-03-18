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
    private ImageView fkG;
    private a gPM;
    private EmotionImageData iJG;
    private EmotionEditLayout jeX;
    private View jeY;
    private ChooseColorLayout jeZ;
    private int jfa;
    private EmotionEditText jfb;
    private EmotionEditModel jfc;
    private String jfd;
    private EmotionImageData jfe;
    private boolean jff;
    private String jfg;
    private int jfh = 0;
    private Bitmap jfi;
    private long jfj;
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
        this.iJG = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.jfc = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.gPM = new a(getPageContext());
        this.gPM.setTipString(R.string.emotion_composition);
        this.gPM.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.jfc.setCancel(true);
                EmotionEditActivity.this.cuG();
                EmotionEditActivity.this.bKb();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.jeX = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.fkG = (ImageView) findViewById(R.id.close);
        this.jeY = findViewById(R.id.send);
        this.jeZ = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.jeZ.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void zL(int i) {
                EmotionEditActivity.this.jfb.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.fkG.setOnClickListener(this);
        this.jeY.setOnClickListener(this);
        this.jfa = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        initImageView();
        cuF();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jeX.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jeX.setLayoutParams(layoutParams);
        this.jfb.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.jeX.a(this.jfb);
        this.jeZ.setVisibility(8);
    }

    private void cuF() {
        this.jfb = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.jeX.addView(this.jfb, layoutParams);
        this.jfb.setTextColor(this.jeZ.getCurrentChooseColor());
        this.jfb.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.jfb.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.jfb.getEditText());
                }
            }
        });
    }

    private void initImageView() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.iJG.getPicUrl();
            gifInfo.mDynamicUrl = this.iJG.getPicUrl();
            gifInfo.mStaticUrl = this.iJG.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.iJG.getPicUrl(), 10, true);
            c.gr().a(this.iJG.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.iJG.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.iJG.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.iJG.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.iJG.getWidth();
        this.mImageHeight = this.iJG.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.jfa;
            this.mImageHeight = this.jfa;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.jfa / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.jfa;
        } else {
            this.mImageWidth = (int) ((this.jfa / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.jfa;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.jeX.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fkG) {
            finish();
        } else if (view == this.jeY) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.jfb.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.jff) {
            this.jfc.setCancel(false);
            this.jff = true;
            this.jfj = System.currentTimeMillis();
            this.gPM.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.jfb.getEditText());
            if (TextUtils.isEmpty(this.jfb.getText())) {
                this.jfe = this.iJG;
                cuJ();
                return;
            }
            String text = this.jfb.getText();
            switch (this.jfh) {
                case 2:
                    if (!TextUtils.isEmpty(this.jfg) && this.jfg.equals(text)) {
                        cuL();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.jfg) && this.jfg.equals(text) && !TextUtils.isEmpty(this.jfd)) {
                        Gz(this.jfd);
                        return;
                    }
                    break;
            }
            cuG();
            this.jfg = this.jfb.getText();
            cuH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuG() {
        if (this.jfi != null && !this.jfi.isRecycled()) {
            this.jfi.recycle();
            this.jfi = null;
        }
    }

    private void cuH() {
        this.jfc.GA(this.jfb.getText());
    }

    private void cuI() {
        if (!this.jfc.isCancel()) {
            this.jfb.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.jfc.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.jfc.isCancel()) {
                        Bitmap z = z(bdImage.getRawBitmap());
                        if (z != null) {
                            this.jfc.b(z, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.jfh = 2;
                        bKb();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.jfh = 2;
                bKb();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.jfd)) {
            bKb();
        } else {
            this.jfc.av(this.jfd, true);
        }
    }

    private void cuJ() {
        if (!this.jfc.isCancel()) {
            this.jfh = 0;
            bKb();
            if (this.jfe != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.jfe);
                setResult(-1, intent);
                finish();
                cuK();
                if (!TextUtils.isEmpty(this.jfd)) {
                    File file = new File(this.jfd);
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

    private void cuK() {
        an anVar = new an("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                anVar.X("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                anVar.X("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.jfb.getText())) {
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
        if (!TextUtils.isEmpty(this.jfb.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cw = cw(width, height);
            if (cw != null) {
                canvas.drawBitmap(cw, (width * this.jfb.getLeft()) / i, (height * this.jfb.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cw(int i, int i2) {
        if (this.jfi != null) {
            return this.jfi;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.jfb.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.jfb.getTextView().getDrawingCache();
        this.jfi = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.jfi = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.jfi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.jeZ.setVisibility(0);
            this.jfb.cvg();
            return;
        }
        this.jeZ.setVisibility(8);
        this.jfb.cvf();
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
        am.setImageResource(this.fkG, R.drawable.icon_emotion_close_n);
        am.setViewTextColor(this.jeY, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cuG();
        if (this.jfc != null) {
            this.jfc.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void cuL() {
        cuI();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Gy(String str) {
        showToast(str);
        this.jfh = 1;
        bKb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKb() {
        this.jfb.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.gPM.setDialogVisiable(false);
        this.jff = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Gz(String str) {
        this.jfb.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            bKb();
        } else if (!new File(str).exists()) {
            bKb();
        } else {
            this.jfd = str;
            this.jfh = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.jfj) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.jfe = new EmotionImageData();
                this.jfe.setPicId(uploadedPicInfo.getPic_id());
                this.jfe.setWidth(uploadedPicInfo.getWidth());
                this.jfe.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.iJG.getMemeContSign())) {
                    this.jfe.setMemeContSign(this.iJG.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.jfe.setPicUrl(picinfo.originPic.picUrl);
                    this.jfe.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.jfe.setMemeText(this.jfb.getText());
                this.jfe.setAuthorNameShow(this.iJG.getAuthorNameShow());
                cuJ();
                return;
            }
            showToast(R.string.upload_error);
            this.jfh = 3;
            bKb();
            return;
        }
        showToast(R.string.upload_error);
        this.jfh = 3;
        bKb();
    }
}
