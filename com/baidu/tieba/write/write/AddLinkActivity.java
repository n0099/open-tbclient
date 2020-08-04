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
    private TextView hWo;
    private ViewGroup mAh;
    private EditText mAi;
    private ImageView mAj;
    private String mAk;
    private boolean mAl;
    private String mAm;
    private FindNewLinkBubbleController mAn;
    private FindNewLinkBubbleController.a mAo = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (AddLinkActivity.this.mAi != null && AddLinkActivity.this.mAn != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.mAn.KC();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.mAi.setText(str);
                AddLinkActivity.this.mAi.setSelection(AddLinkActivity.this.mAi.getText().length());
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
            this.mAk = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.mAl = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.mAm = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.aTt = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.hWo = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.bjS = (TextView) findViewById(R.id.tv_title_add_link);
        this.foB = (TextView) findViewById(R.id.tv_complete_add_link);
        this.mAh = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.mAi = (EditText) findViewById(R.id.et_edit_link);
        this.mAj = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.aTt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dvM();
            }
        });
        this.mContentLayout.setClickable(true);
        this.hWo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dvM();
            }
        });
        this.foB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.mAi != null && AddLinkActivity.this.mAi.getText() != null) {
                    String obj = AddLinkActivity.this.mAi.getText().toString();
                    if (!as.isEmpty(obj) && bd.baV().j(obj)) {
                        AddLinkActivity.this.PS(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.mAh.setClickable(true);
        this.mAi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.foB.setEnabled(false);
                    AddLinkActivity.this.mAj.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.mAj.setVisibility(0);
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
        this.mAi.setText(this.mAk);
        this.mAi.setSelection(this.mAi.getText().length());
        this.mAj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.mAi.setText("");
                AddLinkActivity.this.mAi.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.mAi);
        this.mAi.setSelection(this.mAi.length());
        if (this.mAl) {
            this.mAi.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (as.isEmpty(AddLinkActivity.this.mAm)) {
                        AddLinkActivity.this.PT(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.PT(AddLinkActivity.this.mAm);
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
        this.hWo.setTextColor(ao.lN(R.color.cp_cont_b));
        ao.setViewTextColor(this.bjS, R.color.cp_cont_b);
        dvL();
        ao.setViewTextColor(this.mAi, R.color.cp_cont_b);
        this.mAi.setHintTextColor(ao.getColor(R.color.cp_cont_d));
        ao.setBackgroundResource(this.mAh, R.drawable.bg_add_link_edit_area);
        SvgManager.baR().a(this.mAj, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void dvL() {
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
    public void dvM() {
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
        if (this.mAi != null && !as.isEmpty(str) && bd.baV().j(str)) {
            this.mAi.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.mAn == null) {
                        AddLinkActivity.this.mAn = new FindNewLinkBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.mAo);
                    }
                    AddLinkActivity.this.mAn.a(AddLinkActivity.this.mAi, str, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
