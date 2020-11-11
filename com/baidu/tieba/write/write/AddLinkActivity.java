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
    private TextView bEW;
    private ViewGroup bhA;
    private TextView geI;
    private TextView iYP;
    private ViewGroup mContentLayout;
    private ViewGroup nKE;
    private EditText nKF;
    private ImageView nKG;
    private TextView nKH;
    private String nKI;
    private boolean nKJ;
    private String nKK;
    private FindNewLinkBubbleController nKL;
    private FindNewLinkBubbleController.a nKM = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (AddLinkActivity.this.nKF != null && AddLinkActivity.this.nKL != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.nKL.Wt();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.nKF.setText(str);
                AddLinkActivity.this.nKF.setSelection(AddLinkActivity.this.nKF.getText().length());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.AddLinkActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                AddLinkActivity.this.UV(UtilHelper.getClipBoardContent());
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
            this.nKI = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.nKJ = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.nKK = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.bhA = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.iYP = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.bEW = (TextView) findViewById(R.id.tv_title_add_link);
        this.geI = (TextView) findViewById(R.id.tv_complete_add_link);
        this.nKE = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.nKF = (EditText) findViewById(R.id.et_edit_link);
        this.nKG = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.nKH = (TextView) findViewById(R.id.add_link_tip);
        this.bhA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dUG();
            }
        });
        this.mContentLayout.setClickable(true);
        this.iYP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dUG();
            }
        });
        this.geI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.nKF != null && AddLinkActivity.this.nKF.getText() != null) {
                    String obj = AddLinkActivity.this.nKF.getText().toString();
                    if (!at.isEmpty(obj) && be.brr().k(obj)) {
                        AddLinkActivity.this.UU(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.nKE.setClickable(true);
        this.nKF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.geI.setEnabled(false);
                    AddLinkActivity.this.nKG.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.nKG.setVisibility(0);
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (!Character.isWhitespace(charSequence.charAt(i4))) {
                        AddLinkActivity.this.geI.setEnabled(true);
                        return;
                    }
                }
                AddLinkActivity.this.geI.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.nKF.setText(this.nKI);
        this.nKF.setSelection(this.nKF.getText().length());
        this.nKG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.nKF.setText("");
                AddLinkActivity.this.nKF.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.nKF);
        this.nKF.setSelection(this.nKF.length());
        if (this.nKJ) {
            this.nKF.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (at.isEmpty(AddLinkActivity.this.nKK)) {
                        AddLinkActivity.this.UV(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.UV(AddLinkActivity.this.nKK);
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
        this.iYP.setTextColor(ap.oY(R.color.cp_cont_b));
        ap.setViewTextColor(this.bEW, R.color.cp_cont_b);
        dUF();
        ap.setViewTextColor(this.nKF, R.color.cp_cont_b);
        this.nKF.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        ap.setBackgroundResource(this.nKE, R.drawable.bg_add_link_edit_area);
        SvgManager.brn().a(this.nKG, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.nKH, R.color.cp_cont_e);
    }

    private void dUF() {
        int color = ap.getColor(R.color.cp_link_tip_a);
        this.geI.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{com.baidu.tieba.tbadkCore.c.m(color, 0.3f), com.baidu.tieba.tbadkCore.c.m(color, 0.5f), color}));
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
    public void dUG() {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UU(String str) {
        Intent intent = new Intent();
        intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UV(final String str) {
        if (this.nKF != null && !at.isEmpty(str) && be.brr().k(str)) {
            this.nKF.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.nKL == null) {
                        AddLinkActivity.this.nKL = new FindNewLinkBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.nKM);
                    }
                    AddLinkActivity.this.nKL.a(AddLinkActivity.this.nKF, str, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
