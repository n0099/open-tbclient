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
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class AddLinkActivity extends BaseActivity {
    private TextView bNi;
    private ViewGroup blI;
    private TextView gwW;
    private TextView jzB;
    private ViewGroup mContentLayout;
    private ViewGroup ocL;
    private EditText ocM;
    private ImageView ocN;
    private TextView ocO;
    private String ocP;
    private boolean ocQ;
    private String ocR;
    private WriteTipBubbleController ocS;
    private WriteTipBubbleController.a eYw = new WriteTipBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
        public void f(View view, String str) {
            if (AddLinkActivity.this.ocM != null && AddLinkActivity.this.ocS != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.ocS.Zt();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.ocM.setText(str);
                AddLinkActivity.this.ocM.setSelection(AddLinkActivity.this.ocM.getText().length());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.AddLinkActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                AddLinkActivity.this.Vs(UtilHelper.getClipBoardContent());
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
            this.ocP = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.ocQ = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.ocR = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.blI = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.jzB = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.bNi = (TextView) findViewById(R.id.tv_title_add_link);
        this.gwW = (TextView) findViewById(R.id.tv_complete_add_link);
        this.ocL = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.ocM = (EditText) findViewById(R.id.et_edit_link);
        this.ocN = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.ocO = (TextView) findViewById(R.id.add_link_tip);
        this.blI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dZm();
            }
        });
        this.mContentLayout.setClickable(true);
        this.jzB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dZm();
            }
        });
        this.gwW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.ocM != null && AddLinkActivity.this.ocM.getText() != null) {
                    String obj = AddLinkActivity.this.ocM.getText().toString();
                    if (!at.isEmpty(obj) && be.bwv().l(obj)) {
                        AddLinkActivity.this.Vr(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.ocL.setClickable(true);
        this.ocM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.gwW.setEnabled(false);
                    AddLinkActivity.this.ocN.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.ocN.setVisibility(0);
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (!Character.isWhitespace(charSequence.charAt(i4))) {
                        AddLinkActivity.this.gwW.setEnabled(true);
                        return;
                    }
                }
                AddLinkActivity.this.gwW.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.ocM.setText(this.ocP);
        this.ocM.setSelection(this.ocM.getText().length());
        this.ocN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.ocM.setText("");
                AddLinkActivity.this.ocM.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.ocM);
        this.ocM.setSelection(this.ocM.length());
        if (this.ocQ) {
            this.ocM.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (at.isEmpty(AddLinkActivity.this.ocR)) {
                        AddLinkActivity.this.Vs(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.Vs(AddLinkActivity.this.ocR);
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
        this.jzB.setTextColor(ao.qf(R.color.CAM_X0105));
        ao.setViewTextColor(this.bNi, R.color.CAM_X0105);
        dZl();
        ao.setViewTextColor(this.ocM, R.color.CAM_X0105);
        this.ocM.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        com.baidu.tbadk.core.elementsMaven.c.bv(this.ocL).pK(R.string.J_X01).setBackGroundColor(R.color.CAM_X0209);
        SvgManager.bwr().a(this.ocN, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setViewTextColor(this.ocO, R.color.CAM_X0110);
    }

    private void dZl() {
        int color = ao.getColor(R.color.CAM_X0302);
        this.gwW.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{com.baidu.tieba.tbadkCore.c.m(color, ao.fdi), com.baidu.tieba.tbadkCore.c.m(color, ao.fdh), color}));
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
    public void dZm() {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vr(String str) {
        Intent intent = new Intent();
        intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vs(final String str) {
        if (this.ocM != null && !at.isEmpty(str) && be.bwv().l(str)) {
            this.ocM.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.ocS == null) {
                        AddLinkActivity.this.ocS = new WriteTipBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.eYw);
                    }
                    AddLinkActivity.this.ocS.a(AddLinkActivity.this.ocM, AddLinkActivity.this.getPageContext().getString(R.string.find_new_link) + "\n" + str, str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
