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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.FindNewLinkBubbleController;
/* loaded from: classes3.dex */
public class AddLinkActivity extends BaseActivity {
    private ViewGroup bgg;
    private TextView byL;
    private TextView fYQ;
    private TextView iSS;
    private ViewGroup mContentLayout;
    private ViewGroup nEK;
    private EditText nEL;
    private ImageView nEM;
    private TextView nEN;
    private String nEO;
    private boolean nEP;
    private String nEQ;
    private FindNewLinkBubbleController nER;
    private FindNewLinkBubbleController.a nES = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (AddLinkActivity.this.nEL != null && AddLinkActivity.this.nER != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.nER.TT();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.nEL.setText(str);
                AddLinkActivity.this.nEL.setSelection(AddLinkActivity.this.nEL.getText().length());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.AddLinkActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                AddLinkActivity.this.UE(UtilHelper.getClipBoardContent());
            }
        }
    };

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
            this.nEO = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.nEP = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.nEQ = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.bgg = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.iSS = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.byL = (TextView) findViewById(R.id.tv_title_add_link);
        this.fYQ = (TextView) findViewById(R.id.tv_complete_add_link);
        this.nEK = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.nEL = (EditText) findViewById(R.id.et_edit_link);
        this.nEM = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.nEN = (TextView) findViewById(R.id.add_link_tip);
        this.bgg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dSg();
            }
        });
        this.mContentLayout.setClickable(true);
        this.iSS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dSg();
            }
        });
        this.fYQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.nEL != null && AddLinkActivity.this.nEL.getText() != null) {
                    String obj = AddLinkActivity.this.nEL.getText().toString();
                    if (!at.isEmpty(obj) && be.boR().k(obj)) {
                        AddLinkActivity.this.UD(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.nEK.setClickable(true);
        this.nEL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.fYQ.setEnabled(false);
                    AddLinkActivity.this.nEM.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.nEM.setVisibility(0);
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (!Character.isWhitespace(charSequence.charAt(i4))) {
                        AddLinkActivity.this.fYQ.setEnabled(true);
                        return;
                    }
                }
                AddLinkActivity.this.fYQ.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.nEL.setText(this.nEO);
        this.nEL.setSelection(this.nEL.getText().length());
        this.nEM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.nEL.setText("");
                AddLinkActivity.this.nEL.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.nEL);
        this.nEL.setSelection(this.nEL.length());
        if (this.nEP) {
            this.nEL.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (at.isEmpty(AddLinkActivity.this.nEQ)) {
                        AddLinkActivity.this.UE(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.UE(AddLinkActivity.this.nEQ);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundResource(this.mContentLayout, R.drawable.bg_add_link_content);
        this.iSS.setTextColor(ap.oO(R.color.cp_cont_b));
        ap.setViewTextColor(this.byL, R.color.cp_cont_b);
        dSf();
        ap.setViewTextColor(this.nEL, R.color.cp_cont_b);
        this.nEL.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        ap.setBackgroundResource(this.nEK, R.drawable.bg_add_link_edit_area);
        SvgManager.boN().a(this.nEM, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.nEN, R.color.cp_cont_e);
    }

    private void dSf() {
        int color = ap.getColor(R.color.cp_link_tip_a);
        this.fYQ.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{com.baidu.tieba.tbadkCore.c.m(color, 0.3f), com.baidu.tieba.tbadkCore.c.m(color, 0.5f), color}));
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
    public void dSg() {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UD(String str) {
        Intent intent = new Intent();
        intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UE(final String str) {
        if (this.nEL != null && !at.isEmpty(str) && be.boR().k(str)) {
            this.nEL.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.nER == null) {
                        AddLinkActivity.this.nER = new FindNewLinkBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.nES);
                    }
                    AddLinkActivity.this.nER.a(AddLinkActivity.this.nEL, str, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
