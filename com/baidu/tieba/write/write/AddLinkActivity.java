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
    private ViewGroup beQ;
    private TextView bwx;
    private TextView fPx;
    private TextView iGw;
    private ViewGroup mContentLayout;
    private ViewGroup nsl;
    private EditText nsm;
    private ImageView nsn;
    private TextView nso;
    private String nsp;
    private boolean nsq;
    private String nsr;
    private FindNewLinkBubbleController nss;
    private FindNewLinkBubbleController.a nst = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (AddLinkActivity.this.nsm != null && AddLinkActivity.this.nss != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.nss.SU();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.nsm.setText(str);
                AddLinkActivity.this.nsm.setSelection(AddLinkActivity.this.nsm.getText().length());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.AddLinkActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                AddLinkActivity.this.Uf(UtilHelper.getClipBoardContent());
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
            this.nsp = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.nsq = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.nsr = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.beQ = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.iGw = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.bwx = (TextView) findViewById(R.id.tv_title_add_link);
        this.fPx = (TextView) findViewById(R.id.tv_complete_add_link);
        this.nsl = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.nsm = (EditText) findViewById(R.id.et_edit_link);
        this.nsn = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.nso = (TextView) findViewById(R.id.add_link_tip);
        this.beQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dOY();
            }
        });
        this.mContentLayout.setClickable(true);
        this.iGw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dOY();
            }
        });
        this.fPx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.nsm != null && AddLinkActivity.this.nsm.getText() != null) {
                    String obj = AddLinkActivity.this.nsm.getText().toString();
                    if (!at.isEmpty(obj) && be.bmY().k(obj)) {
                        AddLinkActivity.this.Ue(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.nsl.setClickable(true);
        this.nsm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.fPx.setEnabled(false);
                    AddLinkActivity.this.nsn.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.nsn.setVisibility(0);
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (!Character.isWhitespace(charSequence.charAt(i4))) {
                        AddLinkActivity.this.fPx.setEnabled(true);
                        return;
                    }
                }
                AddLinkActivity.this.fPx.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.nsm.setText(this.nsp);
        this.nsm.setSelection(this.nsm.getText().length());
        this.nsn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.nsm.setText("");
                AddLinkActivity.this.nsm.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.nsm);
        this.nsm.setSelection(this.nsm.length());
        if (this.nsq) {
            this.nsm.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (at.isEmpty(AddLinkActivity.this.nsr)) {
                        AddLinkActivity.this.Uf(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.Uf(AddLinkActivity.this.nsr);
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
        this.iGw.setTextColor(ap.oD(R.color.cp_cont_b));
        ap.setViewTextColor(this.bwx, R.color.cp_cont_b);
        dOX();
        ap.setViewTextColor(this.nsm, R.color.cp_cont_b);
        this.nsm.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        ap.setBackgroundResource(this.nsl, R.drawable.bg_add_link_edit_area);
        SvgManager.bmU().a(this.nsn, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.nso, R.color.cp_cont_e);
    }

    private void dOX() {
        int color = ap.getColor(R.color.cp_link_tip_a);
        this.fPx.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{com.baidu.tieba.tbadkCore.c.m(color, 0.3f), com.baidu.tieba.tbadkCore.c.m(color, 0.5f), color}));
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
    public void dOY() {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ue(String str) {
        Intent intent = new Intent();
        intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uf(final String str) {
        if (this.nsm != null && !at.isEmpty(str) && be.bmY().k(str)) {
            this.nsm.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.nss == null) {
                        AddLinkActivity.this.nss = new FindNewLinkBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.nst);
                    }
                    AddLinkActivity.this.nss.a(AddLinkActivity.this.nsm, str, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
