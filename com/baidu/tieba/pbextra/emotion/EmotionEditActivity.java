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
    private EmotionImageData lNz;
    private String mFrom;
    private int mImageHeight;
    private ImageView mImageView;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mRootView;
    private EmotionEditLayout mlc;
    private View mld;
    private ChooseColorLayout mle;
    private int mlf;
    private EmotionEditText mlg;
    private EmotionEditModel mlh;
    private String mli;
    private EmotionImageData mlj;
    private boolean mlk;
    private String mll;
    private int mlm = 0;
    private Bitmap mln;
    private long mlo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.emotion_edit_activity);
        this.lNz = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.mlh = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.jMl = new a(getPageContext());
        this.jMl.setTipString(R.string.emotion_composition);
        this.jMl.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.mlh.wo(true);
                EmotionEditActivity.this.dxk();
                EmotionEditActivity.this.cMN();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.mlc = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.kiB = (ImageView) findViewById(R.id.close);
        this.mld = findViewById(R.id.send);
        this.mle = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.mle.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void HQ(int i) {
                EmotionEditActivity.this.mlg.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.kiB.setOnClickListener(this);
        this.mld.setOnClickListener(this);
        this.mlf = l.getEquipmentWidth(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        dxj();
        dxi();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mlc.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mlc.setLayoutParams(layoutParams);
        this.mlg.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mlc.a(this.mlg);
        this.mle.setVisibility(8);
    }

    private void dxi() {
        this.mlg = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mlc.addView(this.mlg, layoutParams);
        this.mlg.setTextColor(this.mle.getCurrentChooseColor());
        this.mlg.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.mlg.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.mlg.getEditText());
                }
            }
        });
    }

    private void dxj() {
        if (this.mIsGif) {
            this.mImageView = new GifView(getPageContext().getPageActivity());
            ((GifView) this.mImageView).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.lNz.getPicUrl();
            gifInfo.mDynamicUrl = this.lNz.getPicUrl();
            gifInfo.mStaticUrl = this.lNz.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).a(gifInfo);
        } else {
            this.mImageView = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.mImageView).setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).startLoad(this.lNz.getPicUrl(), 10, true);
            d.mx().a(this.lNz.getPicUrl(), 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
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
                            gifInfo2.mSharpText = EmotionEditActivity.this.lNz.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.lNz.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.lNz.getThumbUrl();
                            EmotionEditActivity.this.mImageView.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.mImageView).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.lNz.getWidth();
        this.mImageHeight = this.lNz.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.mlf;
            this.mImageHeight = this.mlf;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.mlf / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.mlf;
        } else {
            this.mImageWidth = (int) ((this.mlf / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.mlf;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.mlc.addView(this.mImageView, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kiB) {
            finish();
        } else if (view == this.mld) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.mlg.getEditText());
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
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && !this.mlk) {
            this.mlh.wo(false);
            this.mlk = true;
            this.mlo = System.currentTimeMillis();
            this.jMl.setDialogVisiable(true);
            HidenSoftKeyPad(this.mInputManager, this.mlg.getEditText());
            if (TextUtils.isEmpty(this.mlg.getText())) {
                this.mlj = this.lNz;
                dxo();
                return;
            }
            String text = this.mlg.getText();
            switch (this.mlm) {
                case 2:
                    if (!TextUtils.isEmpty(this.mll) && this.mll.equals(text)) {
                        dxq();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.mll) && this.mll.equals(text) && !TextUtils.isEmpty(this.mli)) {
                        Qv(this.mli);
                        return;
                    }
                    break;
            }
            dxk();
            this.mll = this.mlg.getText();
            dxl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxk() {
        if (this.mln != null && !this.mln.isRecycled()) {
            this.mln.recycle();
            this.mln = null;
        }
    }

    private void dxl() {
        this.mlh.Qw(this.mlg.getText());
    }

    private void dxm() {
        if (!this.mlh.isCancel()) {
            this.mlg.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
            if (this.mIsGif) {
                if (this.mImageView instanceof GifView) {
                    ((GifView) this.mImageView).pause();
                    this.mlh.a(((GifView) this.mImageView).getGif());
                }
            } else if (this.mImageView instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.mImageView).getBdImage();
                if (bdImage != null) {
                    if (!this.mlh.isCancel()) {
                        Bitmap G = G(bdImage.getRawBitmap());
                        if (G != null) {
                            this.mlh.b(G, f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(R.string.upload_error);
                        this.mlm = 2;
                        cMN();
                        return;
                    }
                    return;
                }
                showToast(R.string.upload_error);
                this.mlm = 2;
                cMN();
            }
        }
    }

    private void dxn() {
        if (TextUtils.isEmpty(this.mli)) {
            cMN();
        } else {
            this.mlh.aZ(this.mli, true);
        }
    }

    private void dxo() {
        if (!this.mlh.isCancel()) {
            this.mlm = 0;
            cMN();
            if (this.mlj != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.mlj);
                setResult(-1, intent);
                finish();
                dxp();
                if (!TextUtils.isEmpty(this.mli)) {
                    File file = new File(this.mli);
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

    private void dxp() {
        aq aqVar = new aq("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                aqVar.an("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                aqVar.an("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.mlg.getText())) {
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
        if (!TextUtils.isEmpty(this.mlg.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap dg = dg(width, height);
            if (dg != null) {
                canvas.drawBitmap(dg, (width * this.mlg.getLeft()) / i, (height * this.mlg.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public Bitmap dg(int i, int i2) {
        if (this.mln != null) {
            return this.mln;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.mlg.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.mlg.getTextView().getDrawingCache();
        this.mln = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.mln = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.mln;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.mle.setVisibility(0);
            this.mlg.dxL();
            return;
        }
        this.mle.setVisibility(8);
        this.mlg.dxK();
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
        ao.setViewTextColor(this.mld, R.color.CAM_X0111);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dxk();
        if (this.mlh != null) {
            this.mlh.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void dxq() {
        dxm();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Qu(String str) {
        showToast(str);
        this.mlm = 1;
        cMN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMN() {
        this.mlg.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.jMl.setDialogVisiable(false);
        this.mlk = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void Qv(String str) {
        this.mlg.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            cMN();
        } else if (!new File(str).exists()) {
            cMN();
        } else {
            this.mli = str;
            this.mlm = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.mlo) + "ms");
            dxn();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.mlj = new EmotionImageData();
                this.mlj.setPicId(uploadedPicInfo.getPic_id());
                this.mlj.setWidth(uploadedPicInfo.getWidth());
                this.mlj.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.lNz.getMemeContSign())) {
                    this.mlj.setMemeContSign(this.lNz.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.mlj.setPicUrl(picinfo.originPic.picUrl);
                    this.mlj.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.mlj.setMemeText(this.mlg.getText());
                this.mlj.setAuthorNameShow(this.lNz.getAuthorNameShow());
                dxo();
                return;
            }
            showToast(R.string.upload_error);
            this.mlm = 3;
            cMN();
            return;
        }
        showToast(R.string.upload_error);
        this.mlm = 3;
        cMN();
    }
}
