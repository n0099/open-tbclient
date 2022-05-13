package com.baidu.tieba.write.write;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.di8;
import com.repackage.gs4;
import com.repackage.li;
/* loaded from: classes4.dex */
public class AddLinkActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mAddLinkTip;
    public CustomMessageListener mBackgroundListener;
    public String mBubbleNewLinkContent;
    public TextView mCancelBtn;
    public TextView mCompleteBtn;
    public ViewGroup mContentLayout;
    public ImageView mDelBtn;
    public ViewGroup mEditAreaLayout;
    public WriteTipBubbleController mFindNewLinkBubbleController;
    public boolean mIsShowFindNewLinkBubble;
    public EditText mLinkEditView;
    public WriteTipBubbleController.b mOnBubbleClickListener;
    public String mOriginalLinkContent;
    public ViewGroup mRootLayout;
    public TextView mTitleText;

    /* loaded from: classes4.dex */
    public class a implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddLinkActivity a;

        public a(AddLinkActivity addLinkActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addLinkActivity;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, str) == null) || this.a.mLinkEditView == null || this.a.mFindNewLinkBubbleController == null) {
                return;
            }
            TiebaStatic.log("c13802");
            this.a.mFindNewLinkBubbleController.c();
            UtilHelper.clearClipBoard();
            this.a.mLinkEditView.setText(str);
            this.a.mLinkEditView.setSelection(this.a.mLinkEditView.getText().length());
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddLinkActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AddLinkActivity addLinkActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addLinkActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                return;
            }
            this.a.showNewLinkBubble(UtilHelper.getClipBoardContent());
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddLinkActivity a;

        public c(AddLinkActivity addLinkActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addLinkActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.closePageWithoutData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddLinkActivity a;

        public d(AddLinkActivity addLinkActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addLinkActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.closePageWithoutData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddLinkActivity a;

        public e(AddLinkActivity addLinkActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addLinkActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.mLinkEditView == null || this.a.mLinkEditView.getText() == null) {
                return;
            }
            String obj = this.a.mLinkEditView.getText().toString();
            if (!li.isEmpty(obj) && UrlManager.getInstance().isUrlValid(obj)) {
                this.a.closePageWithData(obj);
            } else {
                this.a.showToast(R.string.obfuscated_res_0x7f0f09ea);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddLinkActivity a;

        public f(AddLinkActivity addLinkActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addLinkActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                if (charSequence == null || charSequence.length() == 0) {
                    this.a.mCompleteBtn.setEnabled(false);
                    this.a.mDelBtn.setVisibility(8);
                    return;
                }
                this.a.mDelBtn.setVisibility(0);
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (!Character.isWhitespace(charSequence.charAt(i4))) {
                        this.a.mCompleteBtn.setEnabled(true);
                        return;
                    }
                }
                this.a.mCompleteBtn.setEnabled(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddLinkActivity a;

        public g(AddLinkActivity addLinkActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addLinkActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mLinkEditView.setText("");
                this.a.mLinkEditView.setSelection(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddLinkActivity a;

        public h(AddLinkActivity addLinkActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addLinkActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (li.isEmpty(this.a.mBubbleNewLinkContent)) {
                    this.a.showNewLinkBubble(UtilHelper.getClipBoardContent());
                    return;
                }
                AddLinkActivity addLinkActivity = this.a;
                addLinkActivity.showNewLinkBubble(addLinkActivity.mBubbleNewLinkContent);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ AddLinkActivity b;

        public i(AddLinkActivity addLinkActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addLinkActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = addLinkActivity;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.mFindNewLinkBubbleController == null) {
                    AddLinkActivity addLinkActivity = this.b;
                    addLinkActivity.mFindNewLinkBubbleController = new WriteTipBubbleController(addLinkActivity.getPageContext(), this.b.mOnBubbleClickListener);
                }
                WriteTipBubbleController writeTipBubbleController = this.b.mFindNewLinkBubbleController;
                EditText editText = this.b.mLinkEditView;
                writeTipBubbleController.d(editText, this.b.getPageContext().getString(R.string.obfuscated_res_0x7f0f061e) + "\n" + this.a, this.a, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
            }
        }
    }

    public AddLinkActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOnBubbleClickListener = new a(this);
        this.mBackgroundListener = new b(this, 2001011);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closePageWithData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            Intent intent = new Intent();
            intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closePageWithoutData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            setResult(0);
            finish();
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || getIntent() == null) {
            return;
        }
        this.mOriginalLinkContent = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
        this.mIsShowFindNewLinkBubble = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
        this.mBubbleNewLinkContent = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d0079);
            setActivityBgTransparent();
            setSwipeBackEnabled(false);
            this.mRootLayout = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090113);
            this.mContentLayout = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090114);
            this.mCancelBtn = (TextView) findViewById(R.id.obfuscated_res_0x7f0921c9);
            this.mTitleText = (TextView) findViewById(R.id.obfuscated_res_0x7f09225b);
            this.mCompleteBtn = (TextView) findViewById(R.id.obfuscated_res_0x7f0921d0);
            this.mEditAreaLayout = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090115);
            this.mLinkEditView = (EditText) findViewById(R.id.obfuscated_res_0x7f090910);
            this.mDelBtn = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fd5);
            this.mAddLinkTip = (TextView) findViewById(R.id.obfuscated_res_0x7f090116);
            this.mRootLayout.setOnClickListener(new c(this));
            this.mContentLayout.setClickable(true);
            this.mCancelBtn.setOnClickListener(new d(this));
            this.mCompleteBtn.setOnClickListener(new e(this));
            this.mEditAreaLayout.setClickable(true);
            this.mLinkEditView.addTextChangedListener(new f(this));
            this.mLinkEditView.setText(this.mOriginalLinkContent);
            EditText editText = this.mLinkEditView;
            editText.setSelection(editText.getText().length());
            this.mDelBtn.setOnClickListener(new g(this));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            addGlobalLayoutListener();
            adjustResizeForSoftInput(R.color.black_alpha70, true);
            ShowSoftKeyPadDelay(this.mLinkEditView);
            EditText editText2 = this.mLinkEditView;
            editText2.setSelection(editText2.length());
            if (this.mIsShowFindNewLinkBubble) {
                this.mLinkEditView.post(new h(this));
            }
        }
    }

    private void setCompleteBtnColor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            int color = SkinManager.getColor(R.color.CAM_X0302);
            this.mCompleteBtn.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{di8.a(color, SkinManager.RESOURCE_ALPHA_DISABLE), di8.a(color, SkinManager.RESOURCE_ALPHA_PRESS), color}));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNewLinkBubble(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, this, str) == null) || this.mLinkEditView == null || li.isEmpty(str) || !UrlManager.getInstance().isUrlValid(str)) {
            return;
        }
        this.mLinkEditView.post(new i(this, str));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundResource(this.mContentLayout, R.drawable.bg_add_link_content);
            this.mCancelBtn.setTextColor(SkinManager.getColorStateListWithClickState(R.color.CAM_X0105));
            SkinManager.setViewTextColor(this.mTitleText, (int) R.color.CAM_X0105);
            setCompleteBtnColor();
            SkinManager.setViewTextColor(this.mLinkEditView, (int) R.color.CAM_X0105);
            this.mLinkEditView.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            gs4 d2 = gs4.d(this.mEditAreaLayout);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0209);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mDelBtn, R.drawable.obfuscated_res_0x7f08099e, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.mAddLinkTip, (int) R.color.CAM_X0110);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            initData();
            initView();
            registerListener(this.mBackgroundListener);
        }
    }
}
