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
/* loaded from: classes8.dex */
public class AddLinkActivity extends BaseActivity {
    private TextView bMg;
    private ViewGroup bkk;
    private TextView gvn;
    private TextView jAP;
    private ViewGroup mContentLayout;
    private ViewGroup oiL;
    private EditText oiM;
    private ImageView oiN;
    private TextView oiO;
    private String oiP;
    private boolean oiQ;
    private String oiR;
    private WriteTipBubbleController oiS;
    private WriteTipBubbleController.a eWb = new WriteTipBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
        public void g(View view, String str) {
            if (AddLinkActivity.this.oiM != null && AddLinkActivity.this.oiS != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.oiS.Xj();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.oiM.setText(str);
                AddLinkActivity.this.oiM.setSelection(AddLinkActivity.this.oiM.getText().length());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.AddLinkActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                AddLinkActivity.this.Vv(UtilHelper.getClipBoardContent());
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
            this.oiP = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.oiQ = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.oiR = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.bkk = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.jAP = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.bMg = (TextView) findViewById(R.id.tv_title_add_link);
        this.gvn = (TextView) findViewById(R.id.tv_complete_add_link);
        this.oiL = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.oiM = (EditText) findViewById(R.id.et_edit_link);
        this.oiN = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.oiO = (TextView) findViewById(R.id.add_link_tip);
        this.bkk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dXQ();
            }
        });
        this.mContentLayout.setClickable(true);
        this.jAP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dXQ();
            }
        });
        this.gvn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.oiM != null && AddLinkActivity.this.oiM.getText() != null) {
                    String obj = AddLinkActivity.this.oiM.getText().toString();
                    if (!au.isEmpty(obj) && bf.bsV().l(obj)) {
                        AddLinkActivity.this.Vu(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.oiL.setClickable(true);
        this.oiM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.gvn.setEnabled(false);
                    AddLinkActivity.this.oiN.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.oiN.setVisibility(0);
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (!Character.isWhitespace(charSequence.charAt(i4))) {
                        AddLinkActivity.this.gvn.setEnabled(true);
                        return;
                    }
                }
                AddLinkActivity.this.gvn.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.oiM.setText(this.oiP);
        this.oiM.setSelection(this.oiM.getText().length());
        this.oiN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.oiM.setText("");
                AddLinkActivity.this.oiM.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.oiM);
        this.oiM.setSelection(this.oiM.length());
        if (this.oiQ) {
            this.oiM.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (au.isEmpty(AddLinkActivity.this.oiR)) {
                        AddLinkActivity.this.Vv(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.Vv(AddLinkActivity.this.oiR);
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
        this.jAP.setTextColor(ap.oD(R.color.CAM_X0105));
        ap.setViewTextColor(this.bMg, R.color.CAM_X0105);
        dXP();
        ap.setViewTextColor(this.oiM, R.color.CAM_X0105);
        this.oiM.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        com.baidu.tbadk.core.elementsMaven.c.br(this.oiL).og(R.string.J_X01).setBackGroundColor(R.color.CAM_X0209);
        SvgManager.bsR().a(this.oiN, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.oiO, R.color.CAM_X0110);
    }

    private void dXP() {
        int color = ap.getColor(R.color.CAM_X0302);
        this.gvn.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{com.baidu.tieba.tbadkCore.c.l(color, ap.faO), com.baidu.tieba.tbadkCore.c.l(color, ap.faN), color}));
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
    public void dXQ() {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vu(String str) {
        Intent intent = new Intent();
        intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vv(final String str) {
        if (this.oiM != null && !au.isEmpty(str) && bf.bsV().l(str)) {
            this.oiM.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.oiS == null) {
                        AddLinkActivity.this.oiS = new WriteTipBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.eWb);
                    }
                    AddLinkActivity.this.oiS.a(AddLinkActivity.this.oiM, AddLinkActivity.this.getPageContext().getString(R.string.find_new_link) + "\n" + str, str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
