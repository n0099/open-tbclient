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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class AddLinkActivity extends BaseActivity {
    private TextView bIw;
    private ViewGroup bgT;
    private TextView gsp;
    private TextView juV;
    private ViewGroup mContentLayout;
    private ViewGroup nYf;
    private EditText nYg;
    private ImageView nYh;
    private TextView nYi;
    private String nYj;
    private boolean nYk;
    private String nYl;
    private WriteTipBubbleController nYm;
    private WriteTipBubbleController.a eTL = new WriteTipBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
        public void f(View view, String str) {
            if (AddLinkActivity.this.nYg != null && AddLinkActivity.this.nYm != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.nYm.VA();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.nYg.setText(str);
                AddLinkActivity.this.nYg.setSelection(AddLinkActivity.this.nYg.getText().length());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.AddLinkActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                AddLinkActivity.this.Ul(UtilHelper.getClipBoardContent());
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
            this.nYj = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.nYk = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.nYl = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.bgT = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.juV = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.bIw = (TextView) findViewById(R.id.tv_title_add_link);
        this.gsp = (TextView) findViewById(R.id.tv_complete_add_link);
        this.nYf = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.nYg = (EditText) findViewById(R.id.et_edit_link);
        this.nYh = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.nYi = (TextView) findViewById(R.id.add_link_tip);
        this.bgT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dVu();
            }
        });
        this.mContentLayout.setClickable(true);
        this.juV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dVu();
            }
        });
        this.gsp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.nYg != null && AddLinkActivity.this.nYg.getText() != null) {
                    String obj = AddLinkActivity.this.nYg.getText().toString();
                    if (!at.isEmpty(obj) && be.bsB().l(obj)) {
                        AddLinkActivity.this.Uk(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.nYf.setClickable(true);
        this.nYg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.gsp.setEnabled(false);
                    AddLinkActivity.this.nYh.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.nYh.setVisibility(0);
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (!Character.isWhitespace(charSequence.charAt(i4))) {
                        AddLinkActivity.this.gsp.setEnabled(true);
                        return;
                    }
                }
                AddLinkActivity.this.gsp.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.nYg.setText(this.nYj);
        this.nYg.setSelection(this.nYg.getText().length());
        this.nYh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.nYg.setText("");
                AddLinkActivity.this.nYg.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.nYg);
        this.nYg.setSelection(this.nYg.length());
        if (this.nYk) {
            this.nYg.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (at.isEmpty(AddLinkActivity.this.nYl)) {
                        AddLinkActivity.this.Ul(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.Ul(AddLinkActivity.this.nYl);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundResource(this.mContentLayout, R.drawable.bg_add_link_content);
        this.juV.setTextColor(ao.oy(R.color.CAM_X0105));
        ao.setViewTextColor(this.bIw, R.color.CAM_X0105);
        dVt();
        ao.setViewTextColor(this.nYg, R.color.CAM_X0105);
        this.nYg.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        com.baidu.tbadk.core.elementsMaven.c.bv(this.nYf).od(R.string.J_X01).setBackGroundColor(R.color.CAM_X0209);
        SvgManager.bsx().a(this.nYh, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setViewTextColor(this.nYi, R.color.CAM_X0110);
    }

    private void dVt() {
        int color = ao.getColor(R.color.CAM_X0302);
        this.gsp.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{com.baidu.tieba.tbadkCore.c.m(color, ao.eYz), com.baidu.tieba.tbadkCore.c.m(color, ao.eYy), color}));
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
    public void dVu() {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uk(String str) {
        Intent intent = new Intent();
        intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ul(final String str) {
        if (this.nYg != null && !at.isEmpty(str) && be.bsB().l(str)) {
            this.nYg.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.nYm == null) {
                        AddLinkActivity.this.nYm = new WriteTipBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.eTL);
                    }
                    AddLinkActivity.this.nYm.a(AddLinkActivity.this.nYg, AddLinkActivity.this.getPageContext().getString(R.string.find_new_link) + "\n" + str, str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
