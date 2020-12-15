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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.FindNewLinkBubbleController;
/* loaded from: classes3.dex */
public class AddLinkActivity extends BaseActivity {
    private TextView bIt;
    private ViewGroup bke;
    private TextView gmz;
    private TextView jnd;
    private ViewGroup mContentLayout;
    private ImageView oaA;
    private TextView oaB;
    private String oaC;
    private boolean oaD;
    private String oaE;
    private FindNewLinkBubbleController oaF;
    private ViewGroup oay;
    private EditText oaz;
    private FindNewLinkBubbleController.a oaG = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (AddLinkActivity.this.oaz != null && AddLinkActivity.this.oaF != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.oaF.Yk();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.oaz.setText(str);
                AddLinkActivity.this.oaz.setSelection(AddLinkActivity.this.oaz.getText().length());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.AddLinkActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                AddLinkActivity.this.VV(UtilHelper.getClipBoardContent());
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
            this.oaC = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.oaD = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.oaE = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.bke = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.jnd = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.bIt = (TextView) findViewById(R.id.tv_title_add_link);
        this.gmz = (TextView) findViewById(R.id.tv_complete_add_link);
        this.oay = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.oaz = (EditText) findViewById(R.id.et_edit_link);
        this.oaA = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.oaB = (TextView) findViewById(R.id.add_link_tip);
        this.bke.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.eac();
            }
        });
        this.mContentLayout.setClickable(true);
        this.jnd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.eac();
            }
        });
        this.gmz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.oaz != null && AddLinkActivity.this.oaz.getText() != null) {
                    String obj = AddLinkActivity.this.oaz.getText().toString();
                    if (!au.isEmpty(obj) && bf.bua().l(obj)) {
                        AddLinkActivity.this.VU(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.oay.setClickable(true);
        this.oaz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.gmz.setEnabled(false);
                    AddLinkActivity.this.oaA.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.oaA.setVisibility(0);
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (!Character.isWhitespace(charSequence.charAt(i4))) {
                        AddLinkActivity.this.gmz.setEnabled(true);
                        return;
                    }
                }
                AddLinkActivity.this.gmz.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.oaz.setText(this.oaC);
        this.oaz.setSelection(this.oaz.getText().length());
        this.oaA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.oaz.setText("");
                AddLinkActivity.this.oaz.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.oaz);
        this.oaz.setSelection(this.oaz.length());
        if (this.oaD) {
            this.oaz.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (au.isEmpty(AddLinkActivity.this.oaE)) {
                        AddLinkActivity.this.VV(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.VV(AddLinkActivity.this.oaE);
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
        this.jnd.setTextColor(ap.pU(R.color.CAM_X0105));
        ap.setViewTextColor(this.bIt, R.color.CAM_X0105);
        eab();
        ap.setViewTextColor(this.oaz, R.color.CAM_X0105);
        this.oaz.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        com.baidu.tbadk.core.elementsMaven.c.bm(this.oay).pA(R.string.J_X01).setBackGroundColor(R.color.CAM_X0209);
        SvgManager.btW().a(this.oaA, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.oaB, R.color.CAM_X0110);
    }

    private void eab() {
        int color = ap.getColor(R.color.CAM_X0302);
        this.gmz.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{com.baidu.tieba.tbadkCore.c.m(color, ap.eTL), com.baidu.tieba.tbadkCore.c.m(color, ap.eTK), color}));
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
    public void eac() {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VU(String str) {
        Intent intent = new Intent();
        intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VV(final String str) {
        if (this.oaz != null && !au.isEmpty(str) && bf.bua().l(str)) {
            this.oaz.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.oaF == null) {
                        AddLinkActivity.this.oaF = new FindNewLinkBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.oaG);
                    }
                    AddLinkActivity.this.oaF.a(AddLinkActivity.this.oaz, str, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
