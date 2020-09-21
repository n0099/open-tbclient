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
    private ViewGroup bbg;
    private TextView bsJ;
    private TextView fDo;
    private TextView irD;
    private ViewGroup mContentLayout;
    private ViewGroup ncM;
    private EditText ncN;
    private ImageView ncO;
    private TextView ncP;
    private String ncQ;
    private boolean ncR;
    private String ncS;
    private FindNewLinkBubbleController ncT;
    private FindNewLinkBubbleController.a ncU = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (AddLinkActivity.this.ncN != null && AddLinkActivity.this.ncT != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.ncT.Rc();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.ncN.setText(str);
                AddLinkActivity.this.ncN.setSelection(AddLinkActivity.this.ncN.getText().length());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.AddLinkActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                AddLinkActivity.this.Tr(UtilHelper.getClipBoardContent());
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
            this.ncQ = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.ncR = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.ncS = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.bbg = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.irD = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.bsJ = (TextView) findViewById(R.id.tv_title_add_link);
        this.fDo = (TextView) findViewById(R.id.tv_complete_add_link);
        this.ncM = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.ncN = (EditText) findViewById(R.id.et_edit_link);
        this.ncO = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.ncP = (TextView) findViewById(R.id.add_link_tip);
        this.bbg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dLm();
            }
        });
        this.mContentLayout.setClickable(true);
        this.irD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dLm();
            }
        });
        this.fDo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.ncN != null && AddLinkActivity.this.ncN.getText() != null) {
                    String obj = AddLinkActivity.this.ncN.getText().toString();
                    if (!at.isEmpty(obj) && be.bkp().j(obj)) {
                        AddLinkActivity.this.Tq(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.ncM.setClickable(true);
        this.ncN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.fDo.setEnabled(false);
                    AddLinkActivity.this.ncO.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.ncO.setVisibility(0);
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (!Character.isWhitespace(charSequence.charAt(i4))) {
                        AddLinkActivity.this.fDo.setEnabled(true);
                        return;
                    }
                }
                AddLinkActivity.this.fDo.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.ncN.setText(this.ncQ);
        this.ncN.setSelection(this.ncN.getText().length());
        this.ncO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.ncN.setText("");
                AddLinkActivity.this.ncN.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.ncN);
        this.ncN.setSelection(this.ncN.length());
        if (this.ncR) {
            this.ncN.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (at.isEmpty(AddLinkActivity.this.ncS)) {
                        AddLinkActivity.this.Tr(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.Tr(AddLinkActivity.this.ncS);
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
        this.irD.setTextColor(ap.og(R.color.cp_cont_b));
        ap.setViewTextColor(this.bsJ, R.color.cp_cont_b);
        dLl();
        ap.setViewTextColor(this.ncN, R.color.cp_cont_b);
        this.ncN.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        ap.setBackgroundResource(this.ncM, R.drawable.bg_add_link_edit_area);
        SvgManager.bkl().a(this.ncO, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.ncP, R.color.cp_cont_e);
    }

    private void dLl() {
        int color = ap.getColor(R.color.cp_link_tip_a);
        this.fDo.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{com.baidu.tieba.tbadkCore.c.l(color, 0.3f), com.baidu.tieba.tbadkCore.c.l(color, 0.5f), color}));
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
    public void dLm() {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tq(String str) {
        Intent intent = new Intent();
        intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tr(final String str) {
        if (this.ncN != null && !at.isEmpty(str) && be.bkp().j(str)) {
            this.ncN.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.ncT == null) {
                        AddLinkActivity.this.ncT = new FindNewLinkBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.ncU);
                    }
                    AddLinkActivity.this.ncT.a(AddLinkActivity.this.ncN, str, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
