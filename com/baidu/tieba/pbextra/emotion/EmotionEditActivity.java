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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity;
import com.baidu.tieba.pbextra.emotion.model.EmotionEditModel;
import com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout;
import com.baidu.tieba.pbextra.emotion.view.EmotionEditLayout;
import com.baidu.tieba.pbextra.emotion.view.EmotionEditText;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.b.e.p.f;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import java.io.File;
/* loaded from: classes5.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.e {
    public static final int STEP_COMPOSITION = 2;
    public static final int STEP_IDLE = 0;
    public static final int STEP_UEG = 1;
    public static final int STEP_UPLOAD = 3;
    public boolean isSending;
    public ChooseColorLayout mChooseColorLayout;
    public ImageView mClose;
    public int mContainerSize;
    public EmotionEditLayout mEditContainer;
    public EmotionEditText mEditText;
    public EmotionImageData mEmotionImageData;
    public EmotionImageData mEmotionResultData;
    public String mFrom;
    public String mImageFilePath;
    public int mImageHeight;
    public ImageView mImageView;
    public int mImageWidth;
    public InputMethodManager mInputManager;
    public boolean mIsGif;
    public String mLastSendText;
    public EmotionEditModel mModel;
    public PermissionJudgePolicy mPermissionJudgement;
    public d.b.h0.r.f0.a mProgressDialog;
    public View mRootView;
    public View mSend;
    public int mSendInStep = 0;
    public Bitmap mTextBitmap;
    public long startSendTime;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            EmotionEditActivity.this.mModel.H(true);
            EmotionEditActivity.this.recycleTextBitmap();
            EmotionEditActivity.this.hideProgress();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ChooseColorLayout.b {
        public b() {
        }

        @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.b
        public void a(int i) {
            EmotionEditActivity.this.mEditText.setTextColor(i);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnFocusChangeListener {
        public c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                EmotionEditActivity emotionEditActivity = EmotionEditActivity.this;
                emotionEditActivity.ShowSoftKeyPad(emotionEditActivity.mInputManager, EmotionEditActivity.this.mEditText.getEditText());
                return;
            }
            EmotionEditActivity emotionEditActivity2 = EmotionEditActivity.this;
            emotionEditActivity2.HidenSoftKeyPad(emotionEditActivity2.mInputManager, EmotionEditActivity.this.mEditText.getEditText());
        }
    }

    /* loaded from: classes5.dex */
    public class d extends d.b.b.e.l.c<d.b.b.j.d.a> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            if (aVar != null) {
                EmotionEditActivity.this.mIsGif = aVar.t();
                if (EmotionEditActivity.this.mIsGif) {
                    aVar.h(EmotionEditActivity.this.mImageView);
                    EmotionEditActivity.this.mImageView = new GifView(EmotionEditActivity.this.getPageContext().getPageActivity());
                    ((GifView) EmotionEditActivity.this.mImageView).setSupportNoImage(false);
                    GifInfo gifInfo = new GifInfo();
                    gifInfo.mSharpText = EmotionEditActivity.this.mEmotionImageData.getPicUrl();
                    gifInfo.mDynamicUrl = EmotionEditActivity.this.mEmotionImageData.getPicUrl();
                    gifInfo.mStaticUrl = EmotionEditActivity.this.mEmotionImageData.getThumbUrl();
                    EmotionEditActivity.this.mImageView.setTag(gifInfo.mSharpText);
                    ((GifView) EmotionEditActivity.this.mImageView).w0(gifInfo);
                }
            }
        }
    }

    private void addStatisticItem() {
        StatisticItem statisticItem = new StatisticItem("c12329");
        if (!TextUtils.isEmpty(this.mFrom)) {
            if (EmotionEditActivityConfig.FROM_PB_BOTTOM.equals(this.mFrom)) {
                statisticItem.param("obj_locate", 1);
            } else if (EmotionEditActivityConfig.FROM_PB_SEARCH.equals(this.mFrom)) {
                statisticItem.param("obj_locate", 2);
            }
        }
        if (!TextUtils.isEmpty(this.mEditText.getText())) {
            statisticItem.param("obj_type", 1);
        } else {
            statisticItem.param("obj_type", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    private void checkTextUeg() {
        this.mModel.A(this.mEditText.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        this.mEditText.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        this.mProgressDialog.h(false);
        this.isSending = false;
        if (this.mIsGif) {
            ((GifView) this.mImageView).u0();
        }
    }

    private void initEditText() {
        this.mEditText = new EmotionEditText(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mEditContainer.addView(this.mEditText, layoutParams);
        this.mEditText.setTextColor(this.mChooseColorLayout.getCurrentChooseColor());
        this.mEditText.getEditText().setOnFocusChangeListener(new c());
    }

    private void initImageView() {
        if (this.mIsGif) {
            GifView gifView = new GifView(getPageContext().getPageActivity());
            this.mImageView = gifView;
            gifView.setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.mEmotionImageData.getPicUrl();
            gifInfo.mDynamicUrl = this.mEmotionImageData.getPicUrl();
            gifInfo.mStaticUrl = this.mEmotionImageData.getThumbUrl();
            this.mImageView.setTag(gifInfo.mSharpText);
            ((GifView) this.mImageView).w0(gifInfo);
        } else {
            TbImageView tbImageView = new TbImageView(getPageContext().getPageActivity());
            this.mImageView = tbImageView;
            tbImageView.setGifIconSupport(false);
            ((TbImageView) this.mImageView).setAutoChangeStyle(false);
            ((TbImageView) this.mImageView).W(this.mEmotionImageData.getPicUrl(), 10, true);
            d.b.b.e.l.d.h().m(this.mEmotionImageData.getPicUrl(), 10, new d(), getUniqueId());
        }
        this.mImageWidth = this.mEmotionImageData.getWidth();
        int height = this.mEmotionImageData.getHeight();
        this.mImageHeight = height;
        int i = this.mImageWidth;
        if (i == height) {
            int i2 = this.mContainerSize;
            this.mImageWidth = i2;
            this.mImageHeight = i2;
        } else if (i > height) {
            int i3 = this.mContainerSize;
            this.mImageHeight = (int) ((i3 / i) * height);
            this.mImageWidth = i3;
        } else {
            int i4 = this.mContainerSize;
            this.mImageWidth = (int) ((i4 / height) * i);
            this.mImageHeight = i4;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        layoutParams.gravity = 17;
        this.mEditContainer.addView(this.mImageView, layoutParams);
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.mEditContainer = (EmotionEditLayout) findViewById(R.id.edit_container);
        this.mClose = (ImageView) findViewById(R.id.close);
        this.mSend = findViewById(R.id.send);
        ChooseColorLayout chooseColorLayout = (ChooseColorLayout) findViewById(R.id.choose_color_layout);
        this.mChooseColorLayout = chooseColorLayout;
        chooseColorLayout.setOnChooseColorChangeListener(new b());
        this.mRootView.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
        this.mSend.setOnClickListener(this);
        this.mContainerSize = l.k(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds300);
        initImageView();
        initEditText();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mEditContainer.getLayoutParams();
        layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mEditContainer.setLayoutParams(layoutParams);
        this.mEditText.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds40));
        this.mEditContainer.h(this.mEditText);
        this.mChooseColorLayout.setVisibility(8);
    }

    private void processEmotion() {
        if (this.mModel.B()) {
            return;
        }
        this.mEditText.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
        if (this.mIsGif) {
            ImageView imageView = this.mImageView;
            if (imageView instanceof GifView) {
                ((GifView) imageView).pause();
                this.mModel.D(((GifView) this.mImageView).getGif());
                return;
            }
            return;
        }
        ImageView imageView2 = this.mImageView;
        if (imageView2 instanceof TbImageView) {
            d.b.b.j.d.a bdImage = ((TbImageView) imageView2).getBdImage();
            if (bdImage != null) {
                if (this.mModel.B()) {
                    return;
                }
                Bitmap addTextToImage = addTextToImage(bdImage.p());
                if (addTextToImage != null) {
                    this.mModel.E(addTextToImage, f.f42002b + "/" + TbConfig.getTempDirName() + "/emotion.png");
                    return;
                }
                showToast(R.string.upload_error);
                this.mSendInStep = 2;
                hideProgress();
                return;
            }
            showToast(R.string.upload_error);
            this.mSendInStep = 2;
            hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recycleTextBitmap() {
        Bitmap bitmap = this.mTextBitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.mTextBitmap.recycle();
        this.mTextBitmap = null;
    }

    private void send() {
        if (!j.z()) {
            showToast(R.string.neterror);
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (this.mPermissionJudgement.startRequestPermission(pageActivity) || this.isSending) {
            return;
        }
        this.mModel.H(false);
        this.isSending = true;
        this.startSendTime = System.currentTimeMillis();
        this.mProgressDialog.h(true);
        HidenSoftKeyPad(this.mInputManager, this.mEditText.getEditText());
        if (TextUtils.isEmpty(this.mEditText.getText())) {
            this.mEmotionResultData = this.mEmotionImageData;
            sendEmotion();
            return;
        }
        String text = this.mEditText.getText();
        int i = this.mSendInStep;
        if (i != 2) {
            if (i == 3 && !TextUtils.isEmpty(this.mLastSendText) && this.mLastSendText.equals(text) && !TextUtils.isEmpty(this.mImageFilePath)) {
                onSaveImageSuccess(this.mImageFilePath);
                return;
            }
        } else if (!TextUtils.isEmpty(this.mLastSendText) && this.mLastSendText.equals(text)) {
            onCheckUegSuccess();
            return;
        }
        recycleTextBitmap();
        this.mLastSendText = this.mEditText.getText();
        checkTextUeg();
    }

    private void sendEmotion() {
        if (this.mModel.B()) {
            return;
        }
        this.mSendInStep = 0;
        hideProgress();
        if (this.mEmotionResultData != null) {
            Intent intent = new Intent();
            intent.putExtra(PbSearchEmotionActivity.EMOTION_BACK_DATA, this.mEmotionResultData);
            setResult(-1, intent);
            finish();
            addStatisticItem();
            if (TextUtils.isEmpty(this.mImageFilePath)) {
                return;
            }
            File file = new File(this.mImageFilePath);
            if (file.exists()) {
                file.delete();
                return;
            }
            return;
        }
        showToast(R.string.upload_error);
    }

    private void uploadImage() {
        if (TextUtils.isEmpty(this.mImageFilePath)) {
            hideProgress();
        } else {
            this.mModel.I(this.mImageFilePath, true);
        }
    }

    public Bitmap addTextToImage(Bitmap bitmap) {
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
        if (!TextUtils.isEmpty(this.mEditText.getText())) {
            if (!this.mIsGif) {
                width = i;
                height = i2;
            }
            Bitmap textBitmap = getTextBitmap(width, height);
            if (textBitmap != null) {
                canvas.drawBitmap(textBitmap, (this.mEditText.getLeft() * width) / i, (this.mEditText.getTop() * height) / i2, (Paint) null);
            }
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public Bitmap getTextBitmap(int i, int i2) {
        Bitmap bitmap = this.mTextBitmap;
        if (bitmap != null) {
            return bitmap;
        }
        int i3 = this.mImageWidth;
        int i4 = this.mImageHeight;
        this.mEditText.getTextView().buildDrawingCache();
        Bitmap drawingCache = this.mEditText.getTextView().getDrawingCache();
        this.mTextBitmap = drawingCache;
        if (this.mIsGif) {
            Matrix matrix = new Matrix();
            matrix.postScale(i / i3, i2 / i4);
            this.mTextBitmap = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        }
        return this.mTextBitmap;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setBackgroundColor(this.mRootView, R.color.black_alpha40);
        SkinManager.setImageResource(this.mClose, R.drawable.icon_emotion_close_n);
        SkinManager.setViewTextColor(this.mSend, R.color.CAM_X0111);
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.e
    public void onCheckUegFail(String str) {
        showToast(str);
        this.mSendInStep = 1;
        hideProgress();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.e
    public void onCheckUegSuccess() {
        processEmotion();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mClose) {
            finish();
        } else if (view == this.mSend) {
            send();
        } else if (view == this.mRootView) {
            HidenSoftKeyPad(this.mInputManager, this.mEditText.getEditText());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.emotion_edit_activity);
        this.mEmotionImageData = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
        this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
        this.mFrom = getIntent().getStringExtra("from");
        initView();
        this.mModel = new EmotionEditModel(this, this);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha40, false);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        d.b.h0.r.f0.a aVar = new d.b.h0.r.f0.a(getPageContext());
        this.mProgressDialog = aVar;
        aVar.i(R.string.emotion_composition);
        this.mProgressDialog.e(new a());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        recycleTextBitmap();
        EmotionEditModel emotionEditModel = this.mModel;
        if (emotionEditModel != null) {
            emotionEditModel.cancelLoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            this.mChooseColorLayout.setVisibility(0);
            this.mEditText.u();
            return;
        }
        this.mChooseColorLayout.setVisibility(8);
        this.mEditText.m();
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.e
    public void onSaveImageSuccess(String str) {
        this.mEditText.getTextView().setBackgroundResource(R.drawable.bg_emotion_edit);
        if (TextUtils.isEmpty(str)) {
            hideProgress();
        } else if (!new File(str).exists()) {
            hideProgress();
        } else {
            this.mImageFilePath = str;
            this.mSendInStep = 3;
            BdLog.e("cost time = " + (System.currentTimeMillis() - this.startSendTime) + "ms");
            uploadImage();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.e
    public void onUploadImageSuccess(ImageUploadResult imageUploadResult) {
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null) {
                EmotionImageData emotionImageData = new EmotionImageData();
                this.mEmotionResultData = emotionImageData;
                emotionImageData.setPicId(uploadedPicInfo.getPic_id());
                this.mEmotionResultData.setWidth(uploadedPicInfo.getWidth());
                this.mEmotionResultData.setHeight(uploadedPicInfo.getHeight());
                if (!TextUtils.isEmpty(this.mEmotionImageData.getMemeContSign())) {
                    this.mEmotionResultData.setMemeContSign(this.mEmotionImageData.getMemeContSign());
                }
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null) {
                    this.mEmotionResultData.setPicUrl(picinfo.originPic.picUrl);
                    this.mEmotionResultData.setThumbUrl(picinfo.smallPic.picUrl);
                }
                this.mEmotionResultData.setMemeText(this.mEditText.getText());
                this.mEmotionResultData.setAuthorNameShow(this.mEmotionImageData.getAuthorNameShow());
                sendEmotion();
                return;
            }
            showToast(R.string.upload_error);
            this.mSendInStep = 3;
            hideProgress();
            return;
        }
        showToast(R.string.upload_error);
        this.mSendInStep = 3;
        hideProgress();
    }
}
