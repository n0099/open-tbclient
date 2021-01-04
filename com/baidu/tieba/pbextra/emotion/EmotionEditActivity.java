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
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes2.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private a jMl;
    private ImageView kiB;
    private EmotionImageData lNA;
    private String mFrom;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mRootView;
    private EmotionEditLayout mld;
    private View mle;
    private ChooseColorLayout mlf;
    private int mlg;
    private EmotionEditText mlh;
    private EmotionEditModel mli;
    private String mlj;
    private EmotionImageData mlk;
    private boolean mll;
    private String mlm;
    private int mln = 0;
    private Bitmap mlo;
    private long mlp;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.emotion_edit_activity);
        this.lNA = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.mli = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.jMl = new a(getPageContext());
        this.jMl.setTipString(R.string.emotion_composition);
        this.jMl.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.mli.wo(true);
                EmotionEditActivity.this.dxj();
                EmotionEditActivity.this.cMM();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.mld = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.kiB = (ImageView) findViewById(R.id.close);
        this.mle = findViewById(R.id.send);
        this.mlf = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.mlf.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void HQ(int i) {
                EmotionEditActivity.this.mlh.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.kiB.setOnClickListener(this);
        this.mle.setOnClickListener(this);
        this.mlg = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        dxi();
        dxh();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mld.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mld.setLayoutParams(layoutParams);
        this.mlh.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mld.a(this.mlh);
        this.mlf.setVisibility(8);
    }

    private void dxh() {
        this.mlh = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mld.addView(this.mlh, layoutParams);
        this.mlh.setTextColor(this.mlf.getCurrentChooseColor());
        this.mlh.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.mlh.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.mlh.getEditText());
                }
            }
        });
    }

    private void dxi() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.lNA.getPicUrl();
            gifInfo.mDynamicUrl = this.lNA.getPicUrl();
            gifInfo.mStaticUrl = this.lNA.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.lNA.getPicUrl(), 10, true);
            d.mx().a(this.lNA.getPicUrl(), 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.lNA.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.lNA.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.lNA.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.lNA.getWidth();
        this.mImageHeight = this.lNA.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.mlg;
            this.mImageHeight = this.mlg;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.mlg / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.mlg;
        } else {
            this.mImageWidth = (int) ((this.mlg / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.mlg;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.mld.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kiB) {
            finish();
        } else if (view == this.mle) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.mlh.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.mll) {
            this.mli.wo(false);
            this.mll = true;
            this.mlp = System.currentTimeMillis();
            this.jMl.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.mlh.getEditText());
            if (TextUtils.isEmpty(this.mlh.getText())) {
                this.mlk = this.lNA;
                dxn();
                return;
            }
            String text = this.mlh.getText();
            switch (this.mln) {
                case 2:
                    if (!TextUtils.isEmpty(this.mlm) && this.mlm.equals(text)) {
                        dxp();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.mlm) && this.mlm.equals(text) && !TextUtils.isEmpty(this.mlj)) {
                        Qw(this.mlj);
                        return;
                    }
                    break;
            }
            dxj();
            this.mlm = this.mlh.getText();
            dxk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxj() {
        if (this.mlo != null && !this.mlo.isRecycled()) {
            this.mlo.recycle();
            this.mlo = null;
        }
    }

    private void dxk() {
        this.mli.Qx(this.mlh.getText());
    }

    private void dxl() {
        if (!this.mli.isCancel()) {
            this.mlh.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.mli.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.mli.isCancel()) {
                        Bitmap G = G(bdImage.getRawBitmap());
                        if (G != null) {
                            this.mli.b(G, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.mln = 2;
                        cMM();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.mln = 2;
                cMM();
            }
        }
    }

    private void dxm() {
        if (TextUtils.isEmpty(this.mlj)) {
            cMM();
        } else {
            this.mli.aZ(this.mlj, true);
        }
    }

    private void dxn() {
        if (!this.mli.isCancel()) {
            this.mln = 0;
            cMM();
            if (this.mlk != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.mlk);
                setResult(-1, intent);
                finish();
                dxo();
                if (!TextUtils.isEmpty(this.mlj)) {
                    File file = new File(this.mlj);
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

    private void dxo() {
        aq aqVar = new aq("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                aqVar.an("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                aqVar.an("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.mlh.getText())) {
            aqVar.an("obj_type", 1);
        } else {
            aqVar.an("obj_type", 2);
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
        if (!TextUtils.isEmpty(this.mlh.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap dg = dg(width, height);
            if (dg != null) {
                canvas.drawBitmap(dg, (width * this.mlh.getLeft()) / i, (height * this.mlh.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public Bitmap dg(int i, int i2) {
        if (this.mlo != null) {
            return this.mlo;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.mlh.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.mlh.getTextView().getDrawingCache();
        this.mlo = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.mlo = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.mlo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.mlf.setVisibility(0);
            this.mlh.dxK();
            return;
        }
        this.mlf.setVisibility(8);
        this.mlh.dxJ();
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
        ao.setBackgroundColor(this.mRootView, R.color.black_alpha40);
        ao.setImageResource(this.kiB, R.drawable.icon_emotion_close_n);
        ao.setViewTextColor(this.mle, R.color.CAM_X0111);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dxj();
        if (this.mli != null) {
            this.mli.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void dxp() {
        dxl();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Qv(String str) {
        showToast(str);
        this.mln = 1;
        cMM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMM() {
        this.mlh.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.jMl.setDialogVisiable(false);
        this.mll = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Qw(String str) {
        this.mlh.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            cMM();
        } else if (!new File(str).exists()) {
            cMM();
        } else {
            this.mlj = str;
            this.mln = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.mlp) + "ms");
            dxm();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.mlk = new EmotionImageData();
                this.mlk.setPicId(uploadedPicInfo.getPic_id());
                this.mlk.setWidth(uploadedPicInfo.getWidth());
                this.mlk.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.lNA.getMemeContSign())) {
                    this.mlk.setMemeContSign(this.lNA.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.mlk.setPicUrl(picinfo.originPic.picUrl);
                    this.mlk.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.mlk.setMemeText(this.mlh.getText());
                this.mlk.setAuthorNameShow(this.lNA.getAuthorNameShow());
                dxn();
                return;
            }
            showToast(R.string.upload_error);
            this.mln = 3;
            cMM();
            return;
        }
        showToast(R.string.upload_error);
        this.mln = 3;
        cMM();
    }
}
