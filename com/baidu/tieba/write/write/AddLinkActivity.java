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
    private ViewGroup aYH;
    private TextView bpx;
    private TextView fzY;
    private TextView ikv;
    private ViewGroup mContentLayout;
    private TextView mSA;
    private String mSB;
    private boolean mSD;
    private String mSE;
    private FindNewLinkBubbleController mSF;
    private ViewGroup mSx;
    private EditText mSy;
    private ImageView mSz;
    private FindNewLinkBubbleController.a mSG = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (AddLinkActivity.this.mSy != null && AddLinkActivity.this.mSF != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.mSF.Qu();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.mSy.setText(str);
                AddLinkActivity.this.mSy.setSelection(AddLinkActivity.this.mSy.getText().length());
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
            this.mSB = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.mSD = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.mSE = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.aYH = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.ikv = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.bpx = (TextView) findViewById(R.id.tv_title_add_link);
        this.fzY = (TextView) findViewById(R.id.tv_complete_add_link);
        this.mSx = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.mSy = (EditText) findViewById(R.id.et_edit_link);
        this.mSz = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.mSA = (TextView) findViewById(R.id.add_link_tip);
        this.aYH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dHi();
            }
        });
        this.mContentLayout.setClickable(true);
        this.ikv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dHi();
            }
        });
        this.fzY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.mSy != null && AddLinkActivity.this.mSy.getText() != null) {
                    String obj = AddLinkActivity.this.mSy.getText().toString();
                    if (!at.isEmpty(obj) && be.bju().j(obj)) {
                        AddLinkActivity.this.SQ(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.mSx.setClickable(true);
        this.mSy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.fzY.setEnabled(false);
                    AddLinkActivity.this.mSz.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.mSz.setVisibility(0);
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (!Character.isWhitespace(charSequence.charAt(i4))) {
                        AddLinkActivity.this.fzY.setEnabled(true);
                        return;
                    }
                }
                AddLinkActivity.this.fzY.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.mSy.setText(this.mSB);
        this.mSy.setSelection(this.mSy.getText().length());
        this.mSz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.mSy.setText("");
                AddLinkActivity.this.mSy.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.mSy);
        this.mSy.setSelection(this.mSy.length());
        if (this.mSD) {
            this.mSy.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (at.isEmpty(AddLinkActivity.this.mSE)) {
                        AddLinkActivity.this.SR(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.SR(AddLinkActivity.this.mSE);
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
        this.ikv.setTextColor(ap.nU(R.color.cp_cont_b));
        ap.setViewTextColor(this.bpx, R.color.cp_cont_b);
        dHh();
        ap.setViewTextColor(this.mSy, R.color.cp_cont_b);
        this.mSy.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        ap.setBackgroundResource(this.mSx, R.drawable.bg_add_link_edit_area);
        SvgManager.bjq().a(this.mSz, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mSA, R.color.cp_cont_e);
    }

    private void dHh() {
        int color = ap.getColor(R.color.cp_link_tip_a);
        this.fzY.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{com.baidu.tieba.tbadkCore.c.l(color, 0.3f), com.baidu.tieba.tbadkCore.c.l(color, 0.5f), color}));
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
    public void dHi() {
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
        if (this.mSy != null && !at.isEmpty(str) && be.bju().j(str)) {
            this.mSy.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.mSF == null) {
                        AddLinkActivity.this.mSF = new FindNewLinkBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.mSG);
                    }
                    AddLinkActivity.this.mSF.a(AddLinkActivity.this.mSy, str, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
