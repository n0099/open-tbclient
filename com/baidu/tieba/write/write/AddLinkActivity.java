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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class AddLinkActivity extends BaseActivity {
    private TextView bNG;
    private ViewGroup blK;
    private TextView gwW;
    private TextView jCy;
    private ViewGroup mContentLayout;
    private ViewGroup okQ;
    private EditText okR;
    private ImageView okS;
    private TextView okT;
    private String okU;
    private boolean okV;
    private String okW;
    private WriteTipBubbleController okX;
    private WriteTipBubbleController.a eXA = new WriteTipBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
        public void g(View view, String str) {
            if (AddLinkActivity.this.okR != null && AddLinkActivity.this.okX != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.okX.Xm();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.okR.setText(str);
                AddLinkActivity.this.okR.setSelection(AddLinkActivity.this.okR.getText().length());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.AddLinkActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                AddLinkActivity.this.VC(UtilHelper.getClipBoardContent());
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
            this.okU = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.okV = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.okW = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.blK = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.jCy = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.bNG = (TextView) findViewById(R.id.tv_title_add_link);
        this.gwW = (TextView) findViewById(R.id.tv_complete_add_link);
        this.okQ = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.okR = (EditText) findViewById(R.id.et_edit_link);
        this.okS = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.okT = (TextView) findViewById(R.id.add_link_tip);
        this.blK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dXY();
            }
        });
        this.mContentLayout.setClickable(true);
        this.jCy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dXY();
            }
        });
        this.gwW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.okR != null && AddLinkActivity.this.okR.getText() != null) {
                    String obj = AddLinkActivity.this.okR.getText().toString();
                    if (!au.isEmpty(obj) && bf.bsY().l(obj)) {
                        AddLinkActivity.this.VB(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.okQ.setClickable(true);
        this.okR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.gwW.setEnabled(false);
                    AddLinkActivity.this.okS.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.okS.setVisibility(0);
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
        this.okR.setText(this.okU);
        this.okR.setSelection(this.okR.getText().length());
        this.okS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.okR.setText("");
                AddLinkActivity.this.okR.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.okR);
        this.okR.setSelection(this.okR.length());
        if (this.okV) {
            this.okR.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (au.isEmpty(AddLinkActivity.this.okW)) {
                        AddLinkActivity.this.VC(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.VC(AddLinkActivity.this.okW);
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
        this.jCy.setTextColor(ap.oE(R.color.CAM_X0105));
        ap.setViewTextColor(this.bNG, R.color.CAM_X0105);
        dXX();
        ap.setViewTextColor(this.okR, R.color.CAM_X0105);
        this.okR.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        com.baidu.tbadk.core.elementsMaven.c.br(this.okQ).oh(R.string.J_X01).setBackGroundColor(R.color.CAM_X0209);
        SvgManager.bsU().a(this.okS, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.okT, R.color.CAM_X0110);
    }

    private void dXX() {
        int color = ap.getColor(R.color.CAM_X0302);
        this.gwW.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{com.baidu.tieba.tbadkCore.c.l(color, ap.fcn), com.baidu.tieba.tbadkCore.c.l(color, ap.fcm), color}));
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
    public void dXY() {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VB(String str) {
        Intent intent = new Intent();
        intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VC(final String str) {
        if (this.okR != null && !au.isEmpty(str) && bf.bsY().l(str)) {
            this.okR.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.okX == null) {
                        AddLinkActivity.this.okX = new WriteTipBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.eXA);
                    }
                    AddLinkActivity.this.okX.a(AddLinkActivity.this.okR, AddLinkActivity.this.getPageContext().getString(R.string.find_new_link) + "\n" + str, str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
