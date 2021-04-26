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
import d.a.c.e.p.k;
/* loaded from: classes5.dex */
public class AddLinkActivity extends BaseActivity {
    public TextView mAddLinkTip;
    public String mBubbleNewLinkContent;
    public TextView mCancelBtn;
    public TextView mCompleteBtn;
    public ViewGroup mContentLayout;
    public ImageView mDelBtn;
    public ViewGroup mEditAreaLayout;
    public WriteTipBubbleController mFindNewLinkBubbleController;
    public boolean mIsShowFindNewLinkBubble;
    public EditText mLinkEditView;
    public String mOriginalLinkContent;
    public ViewGroup mRootLayout;
    public TextView mTitleText;
    public WriteTipBubbleController.b mOnBubbleClickListener = new a();
    public CustomMessageListener mBackgroundListener = new b(2001011);

    /* loaded from: classes5.dex */
    public class a implements WriteTipBubbleController.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view, String str) {
            if (AddLinkActivity.this.mLinkEditView == null || AddLinkActivity.this.mFindNewLinkBubbleController == null) {
                return;
            }
            TiebaStatic.log("c13802");
            AddLinkActivity.this.mFindNewLinkBubbleController.c();
            UtilHelper.clearClipBoard();
            AddLinkActivity.this.mLinkEditView.setText(str);
            AddLinkActivity.this.mLinkEditView.setSelection(AddLinkActivity.this.mLinkEditView.getText().length());
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                return;
            }
            AddLinkActivity.this.showNewLinkBubble(UtilHelper.getClipBoardContent());
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AddLinkActivity.this.closePageWithoutData();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AddLinkActivity.this.closePageWithoutData();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AddLinkActivity.this.mLinkEditView == null || AddLinkActivity.this.mLinkEditView.getText() == null) {
                return;
            }
            String obj = AddLinkActivity.this.mLinkEditView.getText().toString();
            if (!k.isEmpty(obj) && UrlManager.getInstance().isUrlValid(obj)) {
                AddLinkActivity.this.closePageWithData(obj);
            } else {
                AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements TextWatcher {
        public f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence == null || charSequence.length() == 0) {
                AddLinkActivity.this.mCompleteBtn.setEnabled(false);
                AddLinkActivity.this.mDelBtn.setVisibility(8);
                return;
            }
            AddLinkActivity.this.mDelBtn.setVisibility(0);
            for (int i5 = 0; i5 < charSequence.length(); i5++) {
                if (!Character.isWhitespace(charSequence.charAt(i5))) {
                    AddLinkActivity.this.mCompleteBtn.setEnabled(true);
                    return;
                }
            }
            AddLinkActivity.this.mCompleteBtn.setEnabled(false);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AddLinkActivity.this.mLinkEditView.setText("");
            AddLinkActivity.this.mLinkEditView.setSelection(0);
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.isEmpty(AddLinkActivity.this.mBubbleNewLinkContent)) {
                AddLinkActivity.this.showNewLinkBubble(UtilHelper.getClipBoardContent());
                return;
            }
            AddLinkActivity addLinkActivity = AddLinkActivity.this;
            addLinkActivity.showNewLinkBubble(addLinkActivity.mBubbleNewLinkContent);
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f22779e;

        public i(String str) {
            this.f22779e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AddLinkActivity.this.mFindNewLinkBubbleController == null) {
                AddLinkActivity addLinkActivity = AddLinkActivity.this;
                addLinkActivity.mFindNewLinkBubbleController = new WriteTipBubbleController(addLinkActivity.getPageContext(), AddLinkActivity.this.mOnBubbleClickListener);
            }
            WriteTipBubbleController writeTipBubbleController = AddLinkActivity.this.mFindNewLinkBubbleController;
            EditText editText = AddLinkActivity.this.mLinkEditView;
            writeTipBubbleController.d(editText, AddLinkActivity.this.getPageContext().getString(R.string.find_new_link) + "\n" + this.f22779e, this.f22779e, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closePageWithData(String str) {
        Intent intent = new Intent();
        intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closePageWithoutData() {
        setResult(0);
        finish();
    }

    private void initData() {
        if (getIntent() != null) {
            this.mOriginalLinkContent = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.mIsShowFindNewLinkBubble = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.mBubbleNewLinkContent = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.mRootLayout = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.mCancelBtn = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.mTitleText = (TextView) findViewById(R.id.tv_title_add_link);
        this.mCompleteBtn = (TextView) findViewById(R.id.tv_complete_add_link);
        this.mEditAreaLayout = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.mLinkEditView = (EditText) findViewById(R.id.et_edit_link);
        this.mDelBtn = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.mAddLinkTip = (TextView) findViewById(R.id.add_link_tip);
        this.mRootLayout.setOnClickListener(new c());
        this.mContentLayout.setClickable(true);
        this.mCancelBtn.setOnClickListener(new d());
        this.mCompleteBtn.setOnClickListener(new e());
        this.mEditAreaLayout.setClickable(true);
        this.mLinkEditView.addTextChangedListener(new f());
        this.mLinkEditView.setText(this.mOriginalLinkContent);
        EditText editText = this.mLinkEditView;
        editText.setSelection(editText.getText().length());
        this.mDelBtn.setOnClickListener(new g());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.mLinkEditView);
        EditText editText2 = this.mLinkEditView;
        editText2.setSelection(editText2.length());
        if (this.mIsShowFindNewLinkBubble) {
            this.mLinkEditView.post(new h());
        }
    }

    private void setCompleteBtnColor() {
        int color = SkinManager.getColor(R.color.CAM_X0302);
        this.mCompleteBtn.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{d.a.j0.d3.c.a(color, SkinManager.RESOURCE_ALPHA_DISABLE), d.a.j0.d3.c.a(color, SkinManager.RESOURCE_ALPHA_PRESS), color}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNewLinkBubble(String str) {
        if (this.mLinkEditView == null || k.isEmpty(str) || !UrlManager.getInstance().isUrlValid(str)) {
            return;
        }
        this.mLinkEditView.post(new i(str));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        SkinManager.setBackgroundResource(this.mContentLayout, R.drawable.bg_add_link_content);
        this.mCancelBtn.setTextColor(SkinManager.getColorStateListWithClickState(R.color.CAM_X0105));
        SkinManager.setViewTextColor(this.mTitleText, R.color.CAM_X0105);
        setCompleteBtnColor();
        SkinManager.setViewTextColor(this.mLinkEditView, R.color.CAM_X0105);
        this.mLinkEditView.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
        d.a.i0.r.u.c d2 = d.a.i0.r.u.c.d(this.mEditAreaLayout);
        d2.k(R.string.J_X01);
        d2.f(R.color.CAM_X0209);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mDelBtn, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setViewTextColor(this.mAddLinkTip, R.color.CAM_X0110);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        initView();
        registerListener(this.mBackgroundListener);
    }
}
