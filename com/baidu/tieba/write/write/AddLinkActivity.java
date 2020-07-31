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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.FindNewLinkBubbleController;
/* loaded from: classes3.dex */
public class AddLinkActivity extends BaseActivity {
    private ViewGroup aTt;
    private TextView bjS;
    private TextView foB;
    private TextView hWm;
    private ViewGroup mAf;
    private EditText mAg;
    private ImageView mAh;
    private String mAi;
    private boolean mAj;
    private String mAk;
    private FindNewLinkBubbleController mAl;
    private FindNewLinkBubbleController.a mAm = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (AddLinkActivity.this.mAg != null && AddLinkActivity.this.mAl != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.mAl.KC();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.mAg.setText(str);
                AddLinkActivity.this.mAg.setSelection(AddLinkActivity.this.mAg.getText().length());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.AddLinkActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                AddLinkActivity.this.PT(UtilHelper.getClipBoardContent());
            }
        }
    };
    private ViewGroup mContentLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        initView();
        registerListener(this.mBackgroundListener);
    }

    private void initData() {
        if (getIntent() != null) {
            this.mAi = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.mAj = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.mAk = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.aTt = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.hWm = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.bjS = (TextView) findViewById(R.id.tv_title_add_link);
        this.foB = (TextView) findViewById(R.id.tv_complete_add_link);
        this.mAf = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.mAg = (EditText) findViewById(R.id.et_edit_link);
        this.mAh = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.aTt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dvL();
            }
        });
        this.mContentLayout.setClickable(true);
        this.hWm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dvL();
            }
        });
        this.foB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.mAg != null && AddLinkActivity.this.mAg.getText() != null) {
                    String obj = AddLinkActivity.this.mAg.getText().toString();
                    if (!as.isEmpty(obj) && bd.baV().j(obj)) {
                        AddLinkActivity.this.PS(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.mAf.setClickable(true);
        this.mAg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.foB.setEnabled(false);
                    AddLinkActivity.this.mAh.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.mAh.setVisibility(0);
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (!Character.isWhitespace(charSequence.charAt(i4))) {
                        AddLinkActivity.this.foB.setEnabled(true);
                        return;
                    }
                }
                AddLinkActivity.this.foB.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.mAg.setText(this.mAi);
        this.mAg.setSelection(this.mAg.getText().length());
        this.mAh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.mAg.setText("");
                AddLinkActivity.this.mAg.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.mAg);
        this.mAg.setSelection(this.mAg.length());
        if (this.mAj) {
            this.mAg.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (as.isEmpty(AddLinkActivity.this.mAk)) {
                        AddLinkActivity.this.PT(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.PT(AddLinkActivity.this.mAk);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundResource(this.mContentLayout, R.drawable.bg_add_link_content);
        this.hWm.setTextColor(ao.lN(R.color.cp_cont_b));
        ao.setViewTextColor(this.bjS, R.color.cp_cont_b);
        dvK();
        ao.setViewTextColor(this.mAg, R.color.cp_cont_b);
        this.mAg.setHintTextColor(ao.getColor(R.color.cp_cont_d));
        ao.setBackgroundResource(this.mAf, R.drawable.bg_add_link_edit_area);
        SvgManager.baR().a(this.mAh, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void dvK() {
        int color = ao.getColor(R.color.cp_link_tip_a);
        this.foB.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{com.baidu.tieba.tbadkCore.c.l(color, 0.3f), com.baidu.tieba.tbadkCore.c.l(color, 0.5f), color}));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvL() {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PS(String str) {
        Intent intent = new Intent();
        intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PT(final String str) {
        if (this.mAg != null && !as.isEmpty(str) && bd.baV().j(str)) {
            this.mAg.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.mAl == null) {
                        AddLinkActivity.this.mAl = new FindNewLinkBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.mAm);
                    }
                    AddLinkActivity.this.mAl.a(AddLinkActivity.this.mAg, str, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
