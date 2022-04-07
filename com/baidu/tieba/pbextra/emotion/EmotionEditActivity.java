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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fo;
import com.repackage.hg;
import com.repackage.ig;
import com.repackage.ii;
import com.repackage.mi;
import com.repackage.oi;
import com.repackage.yt4;
import java.io.File;
/* loaded from: classes3.dex */
public class EmotionEditActivity extends BaseActivity implements EmotionEditModel.e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STEP_COMPOSITION = 2;
    public static final int STEP_IDLE = 0;
    public static final int STEP_UEG = 1;
    public static final int STEP_UPLOAD = 3;
    public transient /* synthetic */ FieldHolder $fh;
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
    public yt4 mProgressDialog;
    public View mRootView;
    public View mSend;
    public int mSendInStep;
    public Bitmap mTextBitmap;
    public long startSendTime;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionEditActivity a;

        public a(EmotionEditActivity emotionEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionEditActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.mModel.N(true);
                this.a.recycleTextBitmap();
                this.a.hideProgress();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ChooseColorLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionEditActivity a;

        public b(EmotionEditActivity emotionEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionEditActivity;
        }

        @Override // com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.mEditText.setTextColor(i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionEditActivity a;

        public c(EmotionEditActivity emotionEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionEditActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (z) {
                    EmotionEditActivity emotionEditActivity = this.a;
                    emotionEditActivity.ShowSoftKeyPad(emotionEditActivity.mInputManager, this.a.mEditText.getEditText());
                    return;
                }
                EmotionEditActivity emotionEditActivity2 = this.a;
                emotionEditActivity2.HidenSoftKeyPad(emotionEditActivity2.mInputManager, this.a.mEditText.getEditText());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends hg<fo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionEditActivity a;

        public d(EmotionEditActivity emotionEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionEditActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hg
        public void onLoaded(fo foVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, foVar, str, i) == null) || foVar == null) {
                return;
            }
            this.a.mIsGif = foVar.t();
            if (this.a.mIsGif) {
                foVar.h(this.a.mImageView);
                this.a.mImageView = new GifView(this.a.getPageContext().getPageActivity());
                ((GifView) this.a.mImageView).setSupportNoImage(false);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = this.a.mEmotionImageData.getPicUrl();
                gifInfo.mDynamicUrl = this.a.mEmotionImageData.getPicUrl();
                gifInfo.mStaticUrl = this.a.mEmotionImageData.getThumbUrl();
                this.a.mImageView.setTag(gifInfo.mSharpText);
                ((GifView) this.a.mImageView).g0(gifInfo);
            }
        }
    }

    public EmotionEditActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSendInStep = 0;
    }

    private void addStatisticItem() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
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
    }

    private void checkTextUeg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.mModel.G(this.mEditText.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.mEditText.getTextView().setBackgroundResource(R.drawable.obfuscated_res_0x7f080271);
            this.mProgressDialog.h(false);
            this.isSending = false;
            if (this.mIsGif) {
                ((GifView) this.mImageView).e0();
            }
        }
    }

    private void initEditText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.mEditText = new EmotionEditText(getPageContext().getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.setMargins(0, 0, 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070225));
            this.mEditContainer.addView(this.mEditText, layoutParams);
            this.mEditText.setTextColor(this.mChooseColorLayout.getCurrentChooseColor());
            this.mEditText.getEditText().setOnFocusChangeListener(new c(this));
        }
    }

    private void initImageView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            if (this.mIsGif) {
                GifView gifView = new GifView(getPageContext().getPageActivity());
                this.mImageView = gifView;
                gifView.setSupportNoImage(false);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = this.mEmotionImageData.getPicUrl();
                gifInfo.mDynamicUrl = this.mEmotionImageData.getPicUrl();
                gifInfo.mStaticUrl = this.mEmotionImageData.getThumbUrl();
                this.mImageView.setTag(gifInfo.mSharpText);
                ((GifView) this.mImageView).g0(gifInfo);
            } else {
                TbImageView tbImageView = new TbImageView(getPageContext().getPageActivity());
                this.mImageView = tbImageView;
                tbImageView.setGifIconSupport(false);
                ((TbImageView) this.mImageView).setAutoChangeStyle(false);
                ((TbImageView) this.mImageView).K(this.mEmotionImageData.getPicUrl(), 10, true);
                ig.h().m(this.mEmotionImageData.getPicUrl(), 10, new d(this), getUniqueId());
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
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.mRootView = findViewById(R.id.obfuscated_res_0x7f091ad5);
            this.mEditContainer = (EmotionEditLayout) findViewById(R.id.obfuscated_res_0x7f090853);
            this.mClose = (ImageView) findViewById(R.id.obfuscated_res_0x7f09066c);
            this.mSend = findViewById(R.id.obfuscated_res_0x7f091c82);
            ChooseColorLayout chooseColorLayout = (ChooseColorLayout) findViewById(R.id.obfuscated_res_0x7f09061c);
            this.mChooseColorLayout = chooseColorLayout;
            chooseColorLayout.setOnChooseColorChangeListener(new b(this));
            this.mRootView.setOnClickListener(this);
            this.mClose.setOnClickListener(this);
            this.mSend.setOnClickListener(this);
            this.mContainerSize = oi.k(getPageContext().getPageActivity()) - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07029c);
            initImageView();
            initEditText();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mEditContainer.getLayoutParams();
            layoutParams.width = this.mImageWidth + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
            layoutParams.height = this.mImageHeight + getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
            this.mEditContainer.setLayoutParams(layoutParams);
            this.mEditText.setMaxImageSize(layoutParams.width - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070225), layoutParams.height - getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070225));
            this.mEditContainer.h(this.mEditText);
            this.mChooseColorLayout.setVisibility(8);
        }
    }

    private void processEmotion() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || this.mModel.H()) {
            return;
        }
        this.mEditText.getTextView().setBackgroundColor(getPageContext().getResources().getColor(R.color.transparent));
        if (this.mIsGif) {
            ImageView imageView = this.mImageView;
            if (imageView instanceof GifView) {
                ((GifView) imageView).pause();
                this.mModel.J(((GifView) this.mImageView).getGif());
                return;
            }
            return;
        }
        ImageView imageView2 = this.mImageView;
        if (imageView2 instanceof TbImageView) {
            fo bdImage = ((TbImageView) imageView2).getBdImage();
            if (bdImage != null) {
                if (this.mModel.H()) {
                    return;
                }
                Bitmap addTextToImage = addTextToImage(bdImage.p());
                if (addTextToImage != null) {
                    this.mModel.K(addTextToImage, ii.b + "/" + TbConfig.getTempDirName() + "/emotion.png");
                    return;
                }
                showToast(R.string.obfuscated_res_0x7f0f1499);
                this.mSendInStep = 2;
                hideProgress();
                return;
            }
            showToast(R.string.obfuscated_res_0x7f0f1499);
            this.mSendInStep = 2;
            hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recycleTextBitmap() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || (bitmap = this.mTextBitmap) == null || bitmap.isRecycled()) {
            return;
        }
        this.mTextBitmap.recycle();
        this.mTextBitmap = null;
    }

    private void send() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            if (!mi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c18);
                return;
            }
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(pageActivity) || this.isSending) {
                return;
            }
            this.mModel.N(false);
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
    }

    private void sendEmotion() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, this) == null) || this.mModel.H()) {
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
        showToast(R.string.obfuscated_res_0x7f0f1499);
    }

    private void uploadImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            if (TextUtils.isEmpty(this.mImageFilePath)) {
                hideProgress();
            } else {
                this.mModel.O(this.mImageFilePath, true);
            }
        }
    }

    public Bitmap addTextToImage(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
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
        return (Bitmap) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            overridePendingTransition(R.anim.obfuscated_res_0x7f010063, R.anim.obfuscated_res_0x7f010064);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            overridePendingTransition(R.anim.obfuscated_res_0x7f010063, R.anim.obfuscated_res_0x7f010064);
        }
    }

    public Bitmap getTextBitmap(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
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
        return (Bitmap) invokeII.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBackgroundColor(this.mRootView, R.color.black_alpha40);
            SkinManager.setImageResource(this.mClose, R.drawable.icon_emotion_close_n);
            SkinManager.setViewTextColor(this.mSend, (int) R.color.CAM_X0111);
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.e
    public void onCheckUegFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            showToast(str);
            this.mSendInStep = 1;
            hideProgress();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.e
    public void onCheckUegSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            processEmotion();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.mClose) {
                finish();
            } else if (view2 == this.mSend) {
                send();
            } else if (view2 == this.mRootView) {
                HidenSoftKeyPad(this.mInputManager, this.mEditText.getEditText());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d025b);
            this.mEmotionImageData = (EmotionImageData) getIntent().getSerializableExtra(EmotionEditActivityConfig.EMOTION_DATA);
            this.mIsGif = getIntent().getBooleanExtra(EmotionEditActivityConfig.EMOTION_IS_GIF, false);
            this.mFrom = getIntent().getStringExtra("from");
            initView();
            this.mModel = new EmotionEditModel(this, this);
            addGlobalLayoutListener();
            adjustResizeForSoftInput(R.color.black_alpha40, false);
            this.mInputManager = (InputMethodManager) getSystemService("input_method");
            yt4 yt4Var = new yt4(getPageContext());
            this.mProgressDialog = yt4Var;
            yt4Var.i(R.string.obfuscated_res_0x7f0f0534);
            this.mProgressDialog.e(new a(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            recycleTextBitmap();
            EmotionEditModel emotionEditModel = this.mModel;
            if (emotionEditModel != null) {
                emotionEditModel.cancelLoadData();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            if (z) {
                this.mChooseColorLayout.setVisibility(0);
                this.mEditText.u();
                return;
            }
            this.mChooseColorLayout.setVisibility(8);
            this.mEditText.m();
        }
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.e
    public void onSaveImageSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mEditText.getTextView().setBackgroundResource(R.drawable.obfuscated_res_0x7f080271);
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
    }

    @Override // com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.e
    public void onUploadImageSuccess(ImageUploadResult imageUploadResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, imageUploadResult) == null) {
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
                showToast(R.string.obfuscated_res_0x7f0f1499);
                this.mSendInStep = 3;
                hideProgress();
                return;
            }
            showToast(R.string.obfuscated_res_0x7f0f1499);
            this.mSendInStep = 3;
            hideProgress();
        }
    }
}
