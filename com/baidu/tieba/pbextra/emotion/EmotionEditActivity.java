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
/* loaded from: classes22.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private a iTd;
    private ImageView joo;
    private EmotionImageData lbG;
    private EmotionEditLayout lza;
    private View lzb;
    private ChooseColorLayout lzc;
    private int lzd;
    private EmotionEditText lze;
    private EmotionEditModel lzf;
    private String lzg;
    private EmotionImageData lzh;
    private boolean lzi;
    private String lzj;
    private int lzk = 0;
    private Bitmap lzl;
    private long lzm;
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
        this.lbG = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.lzf = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.iTd = new a(getPageContext());
        this.iTd.setTipString(R.string.emotion_composition);
        this.iTd.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.lzf.vg(true);
                EmotionEditActivity.this.dmR();
                EmotionEditActivity.this.czl();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.lza = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.joo = (ImageView) findViewById(R.id.close);
        this.lzb = findViewById(R.id.send);
        this.lzc = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.lzc.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void Gc(int i) {
                EmotionEditActivity.this.lze.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.joo.setOnClickListener(this);
        this.lzb.setOnClickListener(this);
        this.lzd = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        dmQ();
        dmP();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lza.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.lza.setLayoutParams(layoutParams);
        this.lze.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.lza.a(this.lze);
        this.lzc.setVisibility(8);
    }

    private void dmP() {
        this.lze = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.lza.addView(this.lze, layoutParams);
        this.lze.setTextColor(this.lzc.getCurrentChooseColor());
        this.lze.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.lze.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.lze.getEditText());
                }
            }
        });
    }

    private void dmQ() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.lbG.getPicUrl();
            gifInfo.mDynamicUrl = this.lbG.getPicUrl();
            gifInfo.mStaticUrl = this.lbG.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.lbG.getPicUrl(), 10, true);
            c.mS().a(this.lbG.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.lbG.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.lbG.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.lbG.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.lbG.getWidth();
        this.mImageHeight = this.lbG.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.lzd;
            this.mImageHeight = this.lzd;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.lzd / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.lzd;
        } else {
            this.mImageWidth = (int) ((this.lzd / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.lzd;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.lza.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.joo) {
            finish();
        } else if (view == this.lzb) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.lze.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.lzi) {
            this.lzf.vg(false);
            this.lzi = true;
            this.lzm = System.currentTimeMillis();
            this.iTd.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.lze.getEditText());
            if (TextUtils.isEmpty(this.lze.getText())) {
                this.lzh = this.lbG;
                dmV();
                return;
            }
            String text = this.lze.getText();
            switch (this.lzk) {
                case 2:
                    if (!TextUtils.isEmpty(this.lzj) && this.lzj.equals(text)) {
                        dmX();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.lzj) && this.lzj.equals(text) && !TextUtils.isEmpty(this.lzg)) {
                        Px(this.lzg);
                        return;
                    }
                    break;
            }
            dmR();
            this.lzj = this.lze.getText();
            dmS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmR() {
        if (this.lzl != null && !this.lzl.isRecycled()) {
            this.lzl.recycle();
            this.lzl = null;
        }
    }

    private void dmS() {
        this.lzf.Py(this.lze.getText());
    }

    private void dmT() {
        if (!this.lzf.isCancel()) {
            this.lze.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.lzf.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.lzf.isCancel()) {
                        Bitmap F = F(bdImage.getRawBitmap());
                        if (F != null) {
                            this.lzf.b(F, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.lzk = 2;
                        czl();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.lzk = 2;
                czl();
            }
        }
    }

    private void dmU() {
        if (TextUtils.isEmpty(this.lzg)) {
            czl();
        } else {
            this.lzf.aW(this.lzg, true);
        }
    }

    private void dmV() {
        if (!this.lzf.isCancel()) {
            this.lzk = 0;
            czl();
            if (this.lzh != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.lzh);
                setResult(-1, intent);
                finish();
                dmW();
                if (!TextUtils.isEmpty(this.lzg)) {
                    File file = new File(this.lzg);
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

    private void dmW() {
        aq aqVar = new aq("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                aqVar.aj("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                aqVar.aj("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.lze.getText())) {
            aqVar.aj("obj_type", 1);
        } else {
            aqVar.aj("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
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
        if (!TextUtils.isEmpty(this.lze.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap db = db(width, height);
            if (db != null) {
                canvas.drawBitmap(db, (width * this.lze.getLeft()) / i, (height * this.lze.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap db(int i, int i2) {
        if (this.lzl != null) {
            return this.lzl;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.lze.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.lze.getTextView().getDrawingCache();
        this.lzl = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.lzl = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.lzl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.lzc.setVisibility(0);
            this.lze.dnt();
            return;
        }
        this.lzc.setVisibility(8);
        this.lze.dnr();
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
        ap.setImageResource(this.joo, R.drawable.icon_emotion_close_n);
        ap.setViewTextColor(this.lzb, (int) R.color.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dmR();
        if (this.lzf != null) {
            this.lzf.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void dmX() {
        dmT();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Pw(String str) {
        showToast(str);
        this.lzk = 1;
        czl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czl() {
        this.lze.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.iTd.setDialogVisiable(false);
        this.lzi = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Px(String str) {
        this.lze.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            czl();
        } else if (!new File(str).exists()) {
            czl();
        } else {
            this.lzg = str;
            this.lzk = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.lzm) + "ms");
            dmU();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.lzh = new EmotionImageData();
                this.lzh.setPicId(uploadedPicInfo.getPic_id());
                this.lzh.setWidth(uploadedPicInfo.getWidth());
                this.lzh.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.lbG.getMemeContSign())) {
                    this.lzh.setMemeContSign(this.lbG.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.lzh.setPicUrl(picinfo.originPic.picUrl);
                    this.lzh.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.lzh.setMemeText(this.lze.getText());
                this.lzh.setAuthorNameShow(this.lbG.getAuthorNameShow());
                dmV();
                return;
            }
            showToast(R.string.upload_error);
            this.lzk = 3;
            czl();
            return;
        }
        showToast(R.string.upload_error);
        this.lzk = 3;
        czl();
    }
}
