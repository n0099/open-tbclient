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
    private TextView gmx;
    private TextView jnb;
    private ViewGroup mContentLayout;
    private String oaA;
    private boolean oaB;
    private String oaC;
    private FindNewLinkBubbleController oaD;
    private ViewGroup oaw;
    private EditText oax;
    private ImageView oay;
    private TextView oaz;
    private FindNewLinkBubbleController.a oaE = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (AddLinkActivity.this.oax != null && AddLinkActivity.this.oaD != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.oaD.Yk();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.oax.setText(str);
                AddLinkActivity.this.oax.setSelection(AddLinkActivity.this.oax.getText().length());
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
            this.oaA = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.oaB = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.oaC = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.bke = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.jnb = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.bIt = (TextView) findViewById(R.id.tv_title_add_link);
        this.gmx = (TextView) findViewById(R.id.tv_complete_add_link);
        this.oaw = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.oax = (EditText) findViewById(R.id.et_edit_link);
        this.oay = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.oaz = (TextView) findViewById(R.id.add_link_tip);
        this.bke.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.eab();
            }
        });
        this.mContentLayout.setClickable(true);
        this.jnb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.eab();
            }
        });
        this.gmx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.oax != null && AddLinkActivity.this.oax.getText() != null) {
                    String obj = AddLinkActivity.this.oax.getText().toString();
                    if (!au.isEmpty(obj) && bf.bua().l(obj)) {
                        AddLinkActivity.this.VU(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.oaw.setClickable(true);
        this.oax.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.gmx.setEnabled(false);
                    AddLinkActivity.this.oay.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.oay.setVisibility(0);
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (!Character.isWhitespace(charSequence.charAt(i4))) {
                        AddLinkActivity.this.gmx.setEnabled(true);
                        return;
                    }
                }
                AddLinkActivity.this.gmx.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.oax.setText(this.oaA);
        this.oax.setSelection(this.oax.getText().length());
        this.oay.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.oax.setText("");
                AddLinkActivity.this.oax.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.oax);
        this.oax.setSelection(this.oax.length());
        if (this.oaB) {
            this.oax.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (au.isEmpty(AddLinkActivity.this.oaC)) {
                        AddLinkActivity.this.VV(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.VV(AddLinkActivity.this.oaC);
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
        this.jnb.setTextColor(ap.pU(R.color.CAM_X0105));
        ap.setViewTextColor(this.bIt, R.color.CAM_X0105);
        eaa();
        ap.setViewTextColor(this.oax, R.color.CAM_X0105);
        this.oax.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        com.baidu.tbadk.core.elementsMaven.c.bm(this.oaw).pA(R.string.J_X01).setBackGroundColor(R.color.CAM_X0209);
        SvgManager.btW().a(this.oay, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.oaz, R.color.CAM_X0110);
    }

    private void eaa() {
        int color = ap.getColor(R.color.CAM_X0302);
        this.gmx.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{com.baidu.tieba.tbadkCore.c.m(color, ap.eTL), com.baidu.tieba.tbadkCore.c.m(color, ap.eTK), color}));
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
    public void eab() {
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
        if (this.oax != null && !au.isEmpty(str) && bf.bua().l(str)) {
            this.oax.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.oaD == null) {
                        AddLinkActivity.this.oaD = new FindNewLinkBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.oaE);
                    }
                    AddLinkActivity.this.oaD.a(AddLinkActivity.this.oax, str, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
