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
import com.baidu.tbadk.core.util.aq;
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
/* loaded from: classes16.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView gIn;
    private a iwL;
    private EmotionImageData kDO;
    private EmotionEditLayout laK;
    private View laL;
    private ChooseColorLayout laM;
    private int laN;
    private EmotionEditText laO;
    private EmotionEditModel laP;
    private String laQ;
    private EmotionImageData laR;
    private boolean laS;
    private String laT;
    private int laU = 0;
    private Bitmap laV;
    private long laW;
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
        this.kDO = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.laP = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.iwL = new a(getPageContext());
        this.iwL.setTipString(R.string.emotion_composition);
        this.iwL.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.laP.up(true);
                EmotionEditActivity.this.dfE();
                EmotionEditActivity.this.csy();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.laK = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.gIn = (ImageView) findViewById(R.id.close);
        this.laL = findViewById(R.id.send);
        this.laM = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.laM.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void EV(int i) {
                EmotionEditActivity.this.laO.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.gIn.setOnClickListener(this);
        this.laL.setOnClickListener(this);
        this.laN = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        dfD();
        dfC();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.laK.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.laK.setLayoutParams(layoutParams);
        this.laO.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.laK.a(this.laO);
        this.laM.setVisibility(8);
    }

    private void dfC() {
        this.laO = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.laK.addView(this.laO, layoutParams);
        this.laO.setTextColor(this.laM.getCurrentChooseColor());
        this.laO.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.laO.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.laO.getEditText());
                }
            }
        });
    }

    private void dfD() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.kDO.getPicUrl();
            gifInfo.mDynamicUrl = this.kDO.getPicUrl();
            gifInfo.mStaticUrl = this.kDO.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.kDO.getPicUrl(), 10, true);
            c.mM().a(this.kDO.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.kDO.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.kDO.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.kDO.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.kDO.getWidth();
        this.mImageHeight = this.kDO.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.laN;
            this.mImageHeight = this.laN;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.laN / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.laN;
        } else {
            this.mImageWidth = (int) ((this.laN / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.laN;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.laK.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gIn) {
            finish();
        } else if (view == this.laL) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.laO.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.laS) {
            this.laP.up(false);
            this.laS = true;
            this.laW = System.currentTimeMillis();
            this.iwL.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.laO.getEditText());
            if (TextUtils.isEmpty(this.laO.getText())) {
                this.laR = this.kDO;
                dfI();
                return;
            }
            String text = this.laO.getText();
            switch (this.laU) {
                case 2:
                    if (!TextUtils.isEmpty(this.laT) && this.laT.equals(text)) {
                        dfK();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.laT) && this.laT.equals(text) && !TextUtils.isEmpty(this.laQ)) {
                        Og(this.laQ);
                        return;
                    }
                    break;
            }
            dfE();
            this.laT = this.laO.getText();
            dfF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfE() {
        if (this.laV != null && !this.laV.isRecycled()) {
            this.laV.recycle();
            this.laV = null;
        }
    }

    private void dfF() {
        this.laP.Oh(this.laO.getText());
    }

    private void dfG() {
        if (!this.laP.isCancel()) {
            this.laO.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.laP.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.laP.isCancel()) {
                        Bitmap G = G(bdImage.getRawBitmap());
                        if (G != null) {
                            this.laP.b(G, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.laU = 2;
                        csy();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.laU = 2;
                csy();
            }
        }
    }

    private void dfH() {
        if (TextUtils.isEmpty(this.laQ)) {
            csy();
        } else {
            this.laP.aS(this.laQ, true);
        }
    }

    private void dfI() {
        if (!this.laP.isCancel()) {
            this.laU = 0;
            csy();
            if (this.laR != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.laR);
                setResult(-1, intent);
                finish();
                dfJ();
                if (!TextUtils.isEmpty(this.laQ)) {
                    File file = new File(this.laQ);
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

    private void dfJ() {
        aq aqVar = new aq("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                aqVar.ai("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                aqVar.ai("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.laO.getText())) {
            aqVar.ai("obj_type", 1);
        } else {
            aqVar.ai("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
    }

    public Bitmap G(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.laO.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap cY = cY(width, height);
            if (cY != null) {
                canvas.drawBitmap(cY, (width * this.laO.getLeft()) / i, (height * this.laO.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap cY(int i, int i2) {
        if (this.laV != null) {
            return this.laV;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.laO.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.laO.getTextView().getDrawingCache();
        this.laV = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.laV = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.laV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.laM.setVisibility(0);
            this.laO.dgf();
            return;
        }
        this.laM.setVisibility(8);
        this.laO.dge();
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
        ap.setImageResource(this.gIn, R.drawable.icon_emotion_close_n);
        ap.setViewTextColor(this.laL, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dfE();
        if (this.laP != null) {
            this.laP.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void dfK() {
        dfG();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Of(String str) {
        showToast(str);
        this.laU = 1;
        csy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csy() {
        this.laO.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.iwL.setDialogVisiable(false);
        this.laS = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Og(String str) {
        this.laO.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            csy();
        } else if (!new File(str).exists()) {
            csy();
        } else {
            this.laQ = str;
            this.laU = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.laW) + "ms");
            dfH();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.laR = new EmotionImageData();
                this.laR.setPicId(uploadedPicInfo.getPic_id());
                this.laR.setWidth(uploadedPicInfo.getWidth());
                this.laR.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.kDO.getMemeContSign())) {
                    this.laR.setMemeContSign(this.kDO.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.laR.setPicUrl(picinfo.originPic.picUrl);
                    this.laR.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.laR.setMemeText(this.laO.getText());
                this.laR.setAuthorNameShow(this.kDO.getAuthorNameShow());
                dfI();
                return;
            }
            showToast(R.string.upload_error);
            this.laU = 3;
            csy();
            return;
        }
        showToast(R.string.upload_error);
        this.laU = 3;
        csy();
    }
}
