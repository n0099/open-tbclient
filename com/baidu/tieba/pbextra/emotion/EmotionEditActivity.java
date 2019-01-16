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
    private ImageView bnG;
    private d dDB;
    private ImageView eAQ;
    private EmotionImageData fXb;
    private String grA;
    private EmotionImageData grB;
    private boolean grC;
    private String grD;
    private int grE = 0;
    private Bitmap grF;
    private long grG;
    private EmotionEditLayout gru;
    private View grv;
    private ChooseColorLayout grw;
    private int grx;
    private EmotionEditText gry;
    private EmotionEditModel grz;
    private String mFrom;
    private int mImageHeight;
    private int mImageWidth;
    private InputMethodManager mInputManager;
    private boolean mIsGif;
    private a mPermissionJudgement;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(e.h.emotion_edit_activity);
        this.fXb = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.grz = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(e.d.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.dDB = new d(getPageContext());
        this.dDB.ec(e.j.emotion_composition);
        this.dDB.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EmotionEditActivity.this.grz.lW(true);
                EmotionEditActivity.this.bpd();
                EmotionEditActivity.this.aIa();
            }
        });
    }

    private void initView() {
        this.mRootView = findViewById(e.g.root_layout);
        this.gru = (EmotionEditLayout) findViewById(e.g.edit_container);
        this.eAQ = (ImageView) findViewById(e.g.close);
        this.grv = findViewById(e.g.send);
        this.grw = (ChooseColorLayout) findViewById(e.g.choose_color_layout);
        this.grw.setOnChooseColorChangeListener(new ChooseColorLayout.a() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.2
            @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.a
            public void tf(int i) {
                EmotionEditActivity.this.gry.setTextColor(i);
            }
        });
        this.mRootView.setOnClickListener(this);
        this.eAQ.setOnClickListener(this);
        this.grv.setOnClickListener(this);
        this.grx = l.aO(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds300);
        bpc();
        bpb();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gru.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds80);
        this.gru.setLayoutParams(layoutParams);
        this.gry.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds40));
        this.gru.a(this.gry);
        this.grw.setVisibility(8);
    }

    private void bpb() {
        this.gry = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(e.C0210e.ds40));
        this.gru.addView(this.gry, layoutParams);
        this.gry.setTextColor(this.grw.getCurrentChooseColor());
        this.gry.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EmotionEditActivity.this.ShowSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.gry.getEditText());
                } else {
                    EmotionEditActivity.this.HidenSoftKeyPad(EmotionEditActivity.this.mInputManager, EmotionEditActivity.this.gry.getEditText());
                }
            }
        });
    }

    private void bpc() {
        if (this.mIsGif) {
            this.bnG = new GifView(getPageContext().getPageActivity());
            ((GifView) this.bnG).setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.fXb.getPicUrl();
            gifInfo.mDynamicUrl = this.fXb.getPicUrl();
            gifInfo.mStaticUrl = this.fXb.getThumbUrl();
            this.bnG.setTag(gifInfo.mSharpText);
            ((GifView) this.bnG).a(gifInfo);
        } else {
            this.bnG = new TbImageView(getPageContext().getPageActivity());
            ((TbImageView) this.bnG).setGifIconSupport(false);
            ((TbImageView) this.bnG).setAutoChangeStyle(false);
            ((TbImageView) this.bnG).startLoad(this.fXb.getPicUrl(), 10, true);
            c.jA().a(this.fXb.getPicUrl(), 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pbextra.emotion.EmotionEditActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        EmotionEditActivity.this.mIsGif = aVar.isGif();
                        if (EmotionEditActivity.this.mIsGif) {
                            aVar.a(EmotionEditActivity.this.bnG);
                            EmotionEditActivity.this.bnG = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                            ((GifView) EmotionEditActivity.this.bnG).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = EmotionEditActivity.this.fXb.getPicUrl();
                            gifInfo2.mDynamicUrl = EmotionEditActivity.this.fXb.getPicUrl();
                            gifInfo2.mStaticUrl = EmotionEditActivity.this.fXb.getThumbUrl();
                            EmotionEditActivity.this.bnG.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionEditActivity.this.bnG).a(gifInfo2);
                        }
                    }
                }
            }, getUniqueId());
        }
        this.mImageWidth = this.fXb.getWidth();
        this.mImageHeight = this.fXb.getHeight();
        if (this.mImageWidth == this.mImageHeight) {
            this.mImageWidth = this.grx;
            this.mImageHeight = this.grx;
        } else if (this.mImageWidth > this.mImageHeight) {
            this.mImageHeight = (int) ((this.grx / this.mImageWidth) * this.mImageHeight);
            this.mImageWidth = this.grx;
        } else {
            this.mImageWidth = (int) ((this.grx / this.mImageHeight) * this.mImageWidth);
            this.mImageHeight = this.grx;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.gru.addView(this.bnG, layoutParams);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eAQ) {
            finish();
        } else if (view == this.grv) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.gry.getEditText());
        }
    }

    private void send() {
        if (!j.kV()) {
            showToast(e.j.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new a();
        }
        this.mPermissionJudgement.EG();
        this.mPermissionJudgement.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.B(pageActivity) && !this.grC) {
            this.grz.lW(false);
            this.grC = true;
            this.grG = System.currentTimeMillis();
            this.dDB.bB(true);
            HidenSoftKeyPad(this.mInputManager, this.gry.getEditText());
            if (TextUtils.isEmpty(this.gry.getText())) {
                this.grB = this.fXb;
                bpg();
                return;
            }
            String text = this.gry.getText();
            switch (this.grE) {
                case 2:
                    if (!TextUtils.isEmpty(this.grD) && this.grD.equals(text)) {
                        bpi();
                        return;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(this.grD) && this.grD.equals(text) && !TextUtils.isEmpty(this.grA)) {
                        tO(this.grA);
                        return;
                    }
                    break;
            }
            bpd();
            this.grD = this.gry.getText();
            bpe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpd() {
        if (this.grF != null && !this.grF.isRecycled()) {
            this.grF.recycle();
            this.grF = null;
        }
    }

    private void bpe() {
        this.grz.tP(this.gry.getText());
    }

    private void bpf() {
        if (!this.grz.ji()) {
            this.gry.getTextView().setBackgroundColor(getPageContext().getResources().getColor(e.d.transparent));
            if (this.mIsGif) {
                if (this.bnG instanceof GifView) {
                    ((GifView) this.bnG).pause();
                    this.grz.a(((GifView) this.bnG).getGif());
                }
            } else if (this.bnG instanceof TbImageView) {
                com.baidu.adp.widget.ImageView.a bdImage = ((TbImageView) this.bnG).getBdImage();
                if (bdImage != null) {
                    if (!this.grz.ji()) {
                        Bitmap s = s(bdImage.ot());
                        if (s != null) {
                            this.grz.b(s, f.FL + "/" + TbConfig.getTempDirName() + "/emotion.png");
                            return;
                        }
                        showToast(e.j.upload_error);
                        this.grE = 2;
                        aIa();
                        return;
                    }
                    return;
                }
                showToast(e.j.upload_error);
                this.grE = 2;
                aIa();
            }
        }
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.grA)) {
            aIa();
        } else {
            this.grz.W(this.grA, true);
        }
    }

    private void bpg() {
        if (!this.grz.ji()) {
            this.grE = 0;
            aIa();
            if (this.grB != null) {
                Intent intent = new Intent();
                intent.putExtra("emotion_data", this.grB);
                setResult(-1, intent);
                finish();
                bph();
                if (!TextUtils.isEmpty(this.grA)) {
                    File file = new File(this.grA);
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

    private void bph() {
        am amVar = new am("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                amVar.y("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                amVar.y("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.gry.getText())) {
            amVar.y("obj_type", 1);
        } else {
            amVar.y("obj_type", 2);
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
        if (!TextUtils.isEmpty(this.gry.getText())) {
            if (!this.mIsGif) {
                height = i2;
                width = i;
            }
            Bitmap bB = bB(width, height);
            if (bB != null) {
                canvas.drawBitmap(bB, (width * this.gry.getLeft()) / i, (height * this.gry.getTop()) / i2, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public Bitmap bB(int i, int i2) {
        if (this.grF != null) {
            return this.grF;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.gry.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.gry.getTextView().getDrawingCache();
        this.grF = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.grF = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.grF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.grw.setVisibility(0);
            this.gry.bpC();
            return;
        }
        this.grw.setVisibility(8);
        this.gry.bpB();
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
        al.c(this.eAQ, e.f.icon_emotion_close_n);
        al.h(this.grv, e.d.cp_cont_g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bpd();
        if (this.grz != null) {
            this.grz.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void bpi() {
        bpf();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void tN(String str) {
        showToast(str);
        this.grE = 1;
        aIa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIa() {
        this.gry.getTextView().setBackgroundResource(e.f.bg_emotion_edit);
        this.dDB.bB(false);
        this.grC = false;
        if (this.mIsGif) {
            ((GifView) this.bnG).resume();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void tO(String str) {
        this.gry.getTextView().setBackgroundResource(e.f.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            aIa();
        } else if (!new File(str).exists()) {
            aIa();
        } else {
            this.grA = str;
            this.grE = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.grG) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.a
    public void c(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                this.grB = new EmotionImageData();
                this.grB.setPicId(uploadedPicInfo.getPic_id());
                this.grB.setWidth(uploadedPicInfo.getWidth());
                this.grB.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.fXb.getMemeContSign())) {
                    this.grB.setMemeContSign(this.fXb.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.grB.setPicUrl(picinfo.originPic.picUrl);
                    this.grB.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.grB.setMemeText(this.gry.getText());
                this.grB.setAuthorNameShow(this.fXb.getAuthorNameShow());
                bpg();
                return;
            }
            showToast(e.j.upload_error);
            this.grE = 3;
            aIa();
            return;
        }
        showToast(e.j.upload_error);
        this.grE = 3;
        aIa();
    }
}
