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
    private ViewGroup aYJ;
    private TextView bpA;
    private TextView fAc;
    private TextView ikB;
    private ViewGroup mContentLayout;
    private ViewGroup mSR;
    private EditText mSS;
    private ImageView mST;
    private TextView mSU;
    private String mSV;
    private boolean mSW;
    private String mSX;
    private FindNewLinkBubbleController mSY;
    private FindNewLinkBubbleController.a mSZ = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (AddLinkActivity.this.mSS != null && AddLinkActivity.this.mSY != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.mSY.Qu();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.mSS.setText(str);
                AddLinkActivity.this.mSS.setSelection(AddLinkActivity.this.mSS.getText().length());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.AddLinkActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                AddLinkActivity.this.SR(UtilHelper.getClipBoardContent());
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
            this.mSV = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.mSW = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.mSX = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.aYJ = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.ikB = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.bpA = (TextView) findViewById(R.id.tv_title_add_link);
        this.fAc = (TextView) findViewById(R.id.tv_complete_add_link);
        this.mSR = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.mSS = (EditText) findViewById(R.id.et_edit_link);
        this.mST = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.mSU = (TextView) findViewById(R.id.add_link_tip);
        this.aYJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dHr();
            }
        });
        this.mContentLayout.setClickable(true);
        this.ikB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dHr();
            }
        });
        this.fAc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.mSS != null && AddLinkActivity.this.mSS.getText() != null) {
                    String obj = AddLinkActivity.this.mSS.getText().toString();
                    if (!at.isEmpty(obj) && be.bju().j(obj)) {
                        AddLinkActivity.this.SQ(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.mSR.setClickable(true);
        this.mSS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.fAc.setEnabled(false);
                    AddLinkActivity.this.mST.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.mST.setVisibility(0);
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (!Character.isWhitespace(charSequence.charAt(i4))) {
                        AddLinkActivity.this.fAc.setEnabled(true);
                        return;
                    }
                }
                AddLinkActivity.this.fAc.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.mSS.setText(this.mSV);
        this.mSS.setSelection(this.mSS.getText().length());
        this.mST.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.mSS.setText("");
                AddLinkActivity.this.mSS.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.mSS);
        this.mSS.setSelection(this.mSS.length());
        if (this.mSW) {
            this.mSS.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (at.isEmpty(AddLinkActivity.this.mSX)) {
                        AddLinkActivity.this.SR(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.SR(AddLinkActivity.this.mSX);
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
        this.ikB.setTextColor(ap.nU(R.color.cp_cont_b));
        ap.setViewTextColor(this.bpA, R.color.cp_cont_b);
        dHq();
        ap.setViewTextColor(this.mSS, R.color.cp_cont_b);
        this.mSS.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        ap.setBackgroundResource(this.mSR, R.drawable.bg_add_link_edit_area);
        SvgManager.bjq().a(this.mST, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mSU, R.color.cp_cont_e);
    }

    private void dHq() {
        int color = ap.getColor(R.color.cp_link_tip_a);
        this.fAc.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{com.baidu.tieba.tbadkCore.c.l(color, 0.3f), com.baidu.tieba.tbadkCore.c.l(color, 0.5f), color}));
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
    public void dHr() {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SQ(String str) {
        Intent intent = new Intent();
        intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SR(final String str) {
        if (this.mSS != null && !at.isEmpty(str) && be.bju().j(str)) {
            this.mSS.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.mSY == null) {
                        AddLinkActivity.this.mSY = new FindNewLinkBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.mSZ);
                    }
                    AddLinkActivity.this.mSY.a(AddLinkActivity.this.mSS, str, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
