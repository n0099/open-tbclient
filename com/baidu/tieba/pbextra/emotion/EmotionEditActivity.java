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
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pbextra.emotion.model.EmotionEditModel;
import com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout;
import com.baidu.tieba.pbextra.emotion.view.EmotionEditLayout;
import com.baidu.tieba.pbextra.emotion.view.EmotionEditText;
import java.io.File;
/* loaded from: classes3.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.a {
    private ImageView biG;
    private a buX;
    private d dsB;
    private ImageView eoZ;
    private EmotionImageData fKX;
    private EmotionEditLayout gfm;
    private View gfn;
    private ChooseColorLayout gfo;
    private int gfp;
    private EmotionEditText gfq;
    private EmotionEditModel gfr;
    private String gfs;
    private EmotionImageData gft;
    private boolean gfu;
    private String gfv;
    private int gfw = 0;
    private Bitmap gfx;
    private long gfy;
    private String mFrom;
    private int mImageHeight;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(e.h.emotion_edit_activity);
        this.fKX = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.gfr = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(e.d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dsB = new d(getPageContext());
        this.dsB.dA(e.j.emotion_composition);
        this.dsB.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.gfr.lF(true);
                EmotionEditActivity.this.bmu();
                EmotionEditActivity.this.aFG();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(e.g.root_layout);
        this.gfm = (EmotionEditLayout) findViewById(e.g.edit_container);
        this.eoZ = (ImageView) findViewById(e.g.close);
        this.gfn = findViewById(e.g.send);
        this.gfo = (ChooseColorLayout) findViewById(e.g.choose_color_layout);
        this.gfo.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void sb(int i) {
                EmotionEditActivity.this.gfq.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.eoZ.setOnClickListener(this);
        this.gfn.setOnClickListener(this);
        this.gfp = l.aO(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0175e.ds300);
        bmt();
        bms();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gfm.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0175e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0175e.ds80);
        this.gfm.setLayoutParams(layoutParams);
        this.gfq.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0175e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0175e.ds40));
        this.gfm.a(this.gfq);
        this.gfo.setVisibility(8);
    }

    private void bms() {
        this.gfq = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0175e.ds40));
        this.gfm.addView(this.gfq, layoutParams);
        this.gfq.setTextColor(this.gfo.getCurrentChooseColor());
        this.gfq.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.gfq.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.gfq.getEditText());
                }
            }
        });
    }

    private void bmt() {
        if (this.mIsGif) {
            this.biG = new GifView(getPageContext().getPageActivity());
            ((GifView) this.biG).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.fKX.getPicUrl();
            gifInfo.mDynamicUrl = this.fKX.getPicUrl();
            gifInfo.mStaticUrl = this.fKX.getThumbUrl();
            this.biG.setTag(gifInfo.mSharpText);
            ((GifView) this.biG).a(gifInfo);
        } else {
            this.biG = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.biG).setGifIconSupport(false);
            ((TbImageView) this.biG).setAutoChangeStyle(false);
            ((TbImageView) this.biG).startLoad(this.fKX.getPicUrl(), 10, true);
            c.jC().a(this.fKX.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.biG);
                            EmotionEditActivity.this.biG = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.biG).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.fKX.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.fKX.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.fKX.getThumbUrl();
                            EmotionEditActivity.this.biG.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.biG).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.fKX.getWidth();
        this.mImageHeight = this.fKX.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.gfp;
            this.mImageHeight = this.gfp;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.gfp / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.gfp;
        } else {
            this.mImageWidth = (int) ((this.gfp / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.gfp;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.gfm.addView(this.biG, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eoZ) {
            finish();
        } else if (view == this.gfn) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.gfq.getEditText());
        }
    }

    private void send() {
        if (!j.kX()) {
            showToast(e.j.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.buX == null) {
            this.buX = new a();
        }
        this.buX.Di();
        this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.buX.z(pageActivity) && !this.gfu) {
            this.gfr.lF(false);
            this.gfu = true;
            this.gfy = System.currentTimeMillis();
            this.dsB.bj(true);
            HidenSoftKeyPad(this.mInputManager, this.gfq.getEditText());
            if (TextUtils.isEmpty(this.gfq.getText())) {
                this.gft = this.fKX;
                bmx();
                return;
            }
            String text = this.gfq.getText();
            switch (this.gfw) {
                case 2:
                    if (!TextUtils.isEmpty(this.gfv) && this.gfv.equals(text)) {
                        bmz();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.gfv) && this.gfv.equals(text) && !TextUtils.isEmpty(this.gfs)) {
                        sS(this.gfs);
                        return;
                    }
                    break;
            }
            bmu();
            this.gfv = this.gfq.getText();
            bmv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmu() {
        if (this.gfx != null && !this.gfx.isRecycled()) {
            this.gfx.recycle();
            this.gfx = null;
        }
    }

    private void bmv() {
        this.gfr.sT(this.gfq.getText());
    }

    private void bmw() {
        if (!this.gfr.jk()) {
            this.gfq.getTextView().setBackgroundColor(getPageContext().getResources().getColor(e.d.transparent));
            if (this.mIsGif) {
                if (this.biG instanceof GifView) {
                    ((GifView) this.biG).pause();
                    this.gfr.a(((GifView) this.biG).getGif());
                }
            } else if (this.biG instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.biG).getBdImage();
                if (bdImage != null) {
                    if (!this.gfr.jk()) {
                        Bitmap s = s(bdImage.os());
                        if (s != null) {
                            this.gfr.b(s, f.FH + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(e.j.upload_error);
                        this.gfw = 2;
                        aFG();
                        return;
                    }
                    return;
                }
                showToast(e.j.upload_error);
                this.gfw = 2;
                aFG();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.gfs)) {
            aFG();
        } else {
            this.gfr.V(this.gfs, true);
        }
    }

    private void bmx() {
        if (!this.gfr.jk()) {
            this.gfw = 0;
            aFG();
            if (this.gft != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.gft);
                setResult(-1, intent);
                finish();
                bmy();
                if (!TextUtils.isEmpty(this.gfs)) {
                    File file = new File(this.gfs);
                    if (file.exists()) {
                        file.delete();
                        return;
                    }
                    return;
                }
                return;
            }
            showToast(e.j.upload_error);
        }
    }

    private void bmy() {
        am amVar = new am("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                amVar.x("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                amVar.x("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.gfq.getText())) {
            amVar.x("obj_type", 1);
        } else {
            amVar.x("obj_type", 2);
        }
        TiebaStatic.log(amVar);
    }

    public Bitmap s(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.gfq.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bA = bA(width, height);
            if (bA != null) {
                canvas.drawBitmap(bA, (width * this.gfq.getLeft()) / i, (height * this.gfq.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bA(int i, int i2) {
        if (this.gfx != null) {
            return this.gfx;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.gfq.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.gfq.getTextView().getDrawingCache();
        this.gfx = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.gfx = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.gfx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.gfo.setVisibility(0);
            this.gfq.bmT();
            return;
        }
        this.gfo.setVisibility(8);
        this.gfq.bmS();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(e.a.fade_in, e.a.fade_out);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(e.a.fade_in, e.a.fade_out);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.mRootView, e.d.black_alpha40);
        al.c(this.eoZ, e.f.icon_emotion_close_n);
        al.h(this.gfn, e.d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bmu();
        if (this.gfr != null) {
            this.gfr.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bmz() {
        bmw();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void sR(String str) {
        showToast(str);
        this.gfw = 1;
        aFG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFG() {
        this.gfq.getTextView().setBackgroundResource(e.f.bg_emotion_edit);
        this.dsB.bj(false);
        this.gfu = false;
        if (this.mIsGif) {
            ((GifView) this.biG).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void sS(String str) {
        this.gfq.getTextView().setBackgroundResource(e.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            aFG();
        } else if (!new File(str).exists()) {
            aFG();
        } else {
            this.gfs = str;
            this.gfw = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.gfy) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.gft = new EmotionImageData();
                this.gft.setPicId(uploadedPicInfo.getPic_id());
                this.gft.setWidth(uploadedPicInfo.getWidth());
                this.gft.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.fKX.getMemeContSign())) {
                    this.gft.setMemeContSign(this.fKX.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.gft.setPicUrl(picinfo.originPic.picUrl);
                    this.gft.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.gft.setMemeText(this.gfq.getText());
                this.gft.setAuthorNameShow(this.fKX.getAuthorNameShow());
                bmx();
                return;
            }
            showToast(e.j.upload_error);
            this.gfw = 3;
            aFG();
            return;
        }
        showToast(e.j.upload_error);
        this.gfw = 3;
        aFG();
    }
}
