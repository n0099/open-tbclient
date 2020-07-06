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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.FindNewLinkBubbleController;
/* loaded from: classes2.dex */
public class AddLinkActivity extends BaseActivity {
    private ViewGroup aSa;
    private TextView bjy;
    private TextView fju;
    private TextView hQn;
    private ViewGroup mContentLayout;
    private ViewGroup msf;
    private EditText msh;
    private ImageView msi;
    private String msj;
    private boolean msk;
    private String msl;
    private FindNewLinkBubbleController msm;
    private FindNewLinkBubbleController.a msn = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (AddLinkActivity.this.msh != null && AddLinkActivity.this.msm != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.msm.Kv();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.msh.setText(str);
                AddLinkActivity.this.msh.setSelection(AddLinkActivity.this.msh.getText().length());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.AddLinkActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                AddLinkActivity.this.Pi(UtilHelper.getClipBoardContent());
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
            this.msj = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.msk = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.msl = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.aSa = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.hQn = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.bjy = (TextView) findViewById(R.id.tv_title_add_link);
        this.fju = (TextView) findViewById(R.id.tv_complete_add_link);
        this.msf = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.msh = (EditText) findViewById(R.id.et_edit_link);
        this.msi = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.aSa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dsz();
            }
        });
        this.mContentLayout.setClickable(true);
        this.hQn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dsz();
            }
        });
        this.fju.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.msh != null && AddLinkActivity.this.msh.getText() != null) {
                    String obj = AddLinkActivity.this.msh.getText().toString();
                    if (!ar.isEmpty(obj) && bc.aWU().j(obj)) {
                        AddLinkActivity.this.Ph(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.msf.setClickable(true);
        this.msh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.fju.setEnabled(false);
                    AddLinkActivity.this.msi.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.msi.setVisibility(0);
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (!Character.isWhitespace(charSequence.charAt(i4))) {
                        AddLinkActivity.this.fju.setEnabled(true);
                        return;
                    }
                }
                AddLinkActivity.this.fju.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.msh.setText(this.msj);
        this.msh.setSelection(this.msh.getText().length());
        this.msi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.msh.setText("");
                AddLinkActivity.this.msh.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.msh);
        this.msh.setSelection(this.msh.length());
        if (this.msk) {
            this.msh.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.isEmpty(AddLinkActivity.this.msl)) {
                        AddLinkActivity.this.Pi(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.Pi(AddLinkActivity.this.msl);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        an.setBackgroundResource(this.mContentLayout, R.drawable.bg_add_link_content);
        this.hQn.setTextColor(an.lt(R.color.cp_cont_b));
        an.setViewTextColor(this.bjy, (int) R.color.cp_cont_b);
        dsy();
        an.setViewTextColor(this.msh, (int) R.color.cp_cont_b);
        this.msh.setHintTextColor(an.getColor(R.color.cp_cont_d));
        an.setBackgroundResource(this.msf, R.drawable.bg_add_link_edit_area);
        SvgManager.aWQ().a(this.msi, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void dsy() {
        int color = an.getColor(R.color.cp_link_tip_a);
        this.fju.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{com.baidu.tieba.tbadkCore.c.l(color, 0.3f), com.baidu.tieba.tbadkCore.c.l(color, 0.5f), color}));
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
    public void dsz() {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph(String str) {
        Intent intent = new Intent();
        intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pi(final String str) {
        if (this.msh != null && !ar.isEmpty(str) && bc.aWU().j(str)) {
            this.msh.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.msm == null) {
                        AddLinkActivity.this.msm = new FindNewLinkBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.msn);
                    }
                    AddLinkActivity.this.msm.a(AddLinkActivity.this.msh, str, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
