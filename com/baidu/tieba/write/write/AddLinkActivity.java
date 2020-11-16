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
    private TextView bDl;
    private ViewGroup bfO;
    private TextView gep;
    private TextView iZB;
    private ViewGroup mContentLayout;
    private ViewGroup nMf;
    private EditText nMg;
    private ImageView nMh;
    private TextView nMi;
    private String nMj;
    private boolean nMk;
    private String nMl;
    private FindNewLinkBubbleController nMm;
    private FindNewLinkBubbleController.a nMn = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (AddLinkActivity.this.nMg != null && AddLinkActivity.this.nMm != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.nMm.VK();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.nMg.setText(str);
                AddLinkActivity.this.nMg.setSelection(AddLinkActivity.this.nMg.getText().length());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.AddLinkActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                AddLinkActivity.this.UG(UtilHelper.getClipBoardContent());
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
            this.nMj = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.nMk = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.nMl = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.bfO = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.iZB = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.bDl = (TextView) findViewById(R.id.tv_title_add_link);
        this.gep = (TextView) findViewById(R.id.tv_complete_add_link);
        this.nMf = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.nMg = (EditText) findViewById(R.id.et_edit_link);
        this.nMh = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.nMi = (TextView) findViewById(R.id.add_link_tip);
        this.bfO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dUF();
            }
        });
        this.mContentLayout.setClickable(true);
        this.iZB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dUF();
            }
        });
        this.gep.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.nMg != null && AddLinkActivity.this.nMg.getText() != null) {
                    String obj = AddLinkActivity.this.nMg.getText().toString();
                    if (!au.isEmpty(obj) && bf.bqF().l(obj)) {
                        AddLinkActivity.this.UF(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.nMf.setClickable(true);
        this.nMg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.gep.setEnabled(false);
                    AddLinkActivity.this.nMh.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.nMh.setVisibility(0);
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (!Character.isWhitespace(charSequence.charAt(i4))) {
                        AddLinkActivity.this.gep.setEnabled(true);
                        return;
                    }
                }
                AddLinkActivity.this.gep.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.nMg.setText(this.nMj);
        this.nMg.setSelection(this.nMg.getText().length());
        this.nMh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.nMg.setText("");
                AddLinkActivity.this.nMg.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.nMg);
        this.nMg.setSelection(this.nMg.length());
        if (this.nMk) {
            this.nMg.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (au.isEmpty(AddLinkActivity.this.nMl)) {
                        AddLinkActivity.this.UG(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.UG(AddLinkActivity.this.nMl);
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
        this.iZB.setTextColor(ap.pu(R.color.CAM_X0105));
        ap.setViewTextColor(this.bDl, R.color.CAM_X0105);
        dUE();
        ap.setViewTextColor(this.nMg, R.color.CAM_X0105);
        this.nMg.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        com.baidu.tbadk.core.elementsMaven.c.bj(this.nMf).pb(R.string.J_X01).setBackGroundColor(R.color.CAM_X0209);
        SvgManager.bqB().a(this.nMh, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.nMi, R.color.CAM_X0110);
    }

    private void dUE() {
        int color = ap.getColor(R.color.CAM_X0302);
        this.gep.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{com.baidu.tieba.tbadkCore.c.m(color, ap.eMz), com.baidu.tieba.tbadkCore.c.m(color, ap.eMy), color}));
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
    public void dUF() {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UF(String str) {
        Intent intent = new Intent();
        intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UG(final String str) {
        if (this.nMg != null && !au.isEmpty(str) && bf.bqF().l(str)) {
            this.nMg.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.nMm == null) {
                        AddLinkActivity.this.nMm = new FindNewLinkBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.nMn);
                    }
                    AddLinkActivity.this.nMm.a(AddLinkActivity.this.nMg, str, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
