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
/* loaded from: classes21.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView jHK;
    private a jmh;
    private EmotionEditLayout lRJ;
    private View lRK;
    private ChooseColorLayout lRL;
    private int lRM;
    private EmotionEditText lRN;
    private EmotionEditModel lRO;
    private String lRP;
    private EmotionImageData lRQ;
    private boolean lRR;
    private String lRS;
    private int lRT = 0;
    private Bitmap lRU;
    private long lRV;
    private EmotionImageData luw;
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
        this.luw = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.lRO = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.jmh = new a(getPageContext());
        this.jmh.setTipString(R.string.emotion_composition);
        this.jmh.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.lRO.vJ(true);
                EmotionEditActivity.this.dsb();
                EmotionEditActivity.this.cEy();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.lRJ = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.jHK = (ImageView) findViewById(R.id.close);
        this.lRK = findViewById(R.id.send);
        this.lRL = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.lRL.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void Hg(int i) {
                EmotionEditActivity.this.lRN.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.jHK.setOnClickListener(this);
        this.lRK.setOnClickListener(this);
        this.lRM = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        dsa();
        drZ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lRJ.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.lRJ.setLayoutParams(layoutParams);
        this.lRN.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.lRJ.a(this.lRN);
        this.lRL.setVisibility(8);
    }

    private void drZ() {
        this.lRN = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.lRJ.addView(this.lRN, layoutParams);
        this.lRN.setTextColor(this.lRL.getCurrentChooseColor());
        this.lRN.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.lRN.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.lRN.getEditText());
                }
            }
        });
    }

    private void dsa() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.luw.getPicUrl();
            gifInfo.mDynamicUrl = this.luw.getPicUrl();
            gifInfo.mStaticUrl = this.luw.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.luw.getPicUrl(), 10, true);
            c.mS().a(this.luw.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.luw.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.luw.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.luw.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.luw.getWidth();
        this.mImageHeight = this.luw.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.lRM;
            this.mImageHeight = this.lRM;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.lRM / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.lRM;
        } else {
            this.mImageWidth = (int) ((this.lRM / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.lRM;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.lRJ.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jHK) {
            finish();
        } else if (view == this.lRK) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.lRN.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.lRR) {
            this.lRO.vJ(false);
            this.lRR = true;
            this.lRV = System.currentTimeMillis();
            this.jmh.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.lRN.getEditText());
            if (TextUtils.isEmpty(this.lRN.getText())) {
                this.lRQ = this.luw;
                dsf();
                return;
            }
            String text = this.lRN.getText();
            switch (this.lRT) {
                case 2:
                    if (!TextUtils.isEmpty(this.lRS) && this.lRS.equals(text)) {
                        dsh();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.lRS) && this.lRS.equals(text) && !TextUtils.isEmpty(this.lRP)) {
                        PH(this.lRP);
                        return;
                    }
                    break;
            }
            dsb();
            this.lRS = this.lRN.getText();
            dsc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsb() {
        if (this.lRU != null && !this.lRU.isRecycled()) {
            this.lRU.recycle();
            this.lRU = null;
        }
    }

    private void dsc() {
        this.lRO.PI(this.lRN.getText());
    }

    private void dsd() {
        if (!this.lRO.isCancel()) {
            this.lRN.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.lRO.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.lRO.isCancel()) {
                        Bitmap F = F(bdImage.getRawBitmap());
                        if (F != null) {
                            this.lRO.b(F, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.lRT = 2;
                        cEy();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.lRT = 2;
                cEy();
            }
        }
    }

    private void dse() {
        if (TextUtils.isEmpty(this.lRP)) {
            cEy();
        } else {
            this.lRO.aY(this.lRP, true);
        }
    }

    private void dsf() {
        if (!this.lRO.isCancel()) {
            this.lRT = 0;
            cEy();
            if (this.lRQ != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.lRQ);
                setResult(-1, intent);
                finish();
                dsg();
                if (!TextUtils.isEmpty(this.lRP)) {
                    File file = new File(this.lRP);
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

    private void dsg() {
        ar arVar = new ar("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                arVar.ak("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                arVar.ak("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.lRN.getText())) {
            arVar.ak("obj_type", 1);
        } else {
            arVar.ak("obj_type", 2);
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
        if (!TextUtils.isEmpty(this.lRN.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap df = df(width, height);
            if (df != null) {
                canvas.drawBitmap(df, (width * this.lRN.getLeft()) / i, (height * this.lRN.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap df(int i, int i2) {
        if (this.lRU != null) {
            return this.lRU;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.lRN.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.lRN.getTextView().getDrawingCache();
        this.lRU = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.lRU = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.lRU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.lRL.setVisibility(0);
            this.lRN.dsC();
            return;
        }
        this.lRL.setVisibility(8);
        this.lRN.dsB();
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
        ap.setImageResource(this.jHK, R.drawable.icon_emotion_close_n);
        ap.setViewTextColor(this.lRK, (int) R.color.CAM_X0111);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dsb();
        if (this.lRO != null) {
            this.lRO.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void dsh() {
        dsd();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void PG(String str) {
        showToast(str);
        this.lRT = 1;
        cEy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEy() {
        this.lRN.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.jmh.setDialogVisiable(false);
        this.lRR = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void PH(String str) {
        this.lRN.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            cEy();
        } else if (!new File(str).exists()) {
            cEy();
        } else {
            this.lRP = str;
            this.lRT = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.lRV) + "ms");
            dse();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.lRQ = new EmotionImageData();
                this.lRQ.setPicId(uploadedPicInfo.getPic_id());
                this.lRQ.setWidth(uploadedPicInfo.getWidth());
                this.lRQ.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.luw.getMemeContSign())) {
                    this.lRQ.setMemeContSign(this.luw.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.lRQ.setPicUrl(picinfo.originPic.picUrl);
                    this.lRQ.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.lRQ.setMemeText(this.lRN.getText());
                this.lRQ.setAuthorNameShow(this.luw.getAuthorNameShow());
                dsf();
                return;
            }
            showToast(R.string.upload_error);
            this.lRT = 3;
            cEy();
            return;
        }
        showToast(R.string.upload_error);
        this.lRT = 3;
        cEy();
    }
}
