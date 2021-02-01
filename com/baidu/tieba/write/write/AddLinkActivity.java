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
    private TextView guZ;
    private TextView jAB;
    private ViewGroup mContentLayout;
    private ViewGroup oil;
    private EditText oim;
    private ImageView oin;
    private TextView oio;
    private String oip;
    private boolean oiq;
    private String oir;
    private WriteTipBubbleController ois;
    private WriteTipBubbleController.a eWb = new WriteTipBubbleController.a() { // from class: com.baidu.tieba.write.write.AddLinkActivity.1
        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
        public void g(View view, String str) {
            if (AddLinkActivity.this.oim != null && AddLinkActivity.this.ois != null) {
                TiebaStatic.log("c13802");
                AddLinkActivity.this.ois.Xj();
                UtilHelper.clearClipBoard();
                AddLinkActivity.this.oim.setText(str);
                AddLinkActivity.this.oim.setSelection(AddLinkActivity.this.oim.getText().length());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.AddLinkActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                AddLinkActivity.this.Vj(UtilHelper.getClipBoardContent());
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
            this.oip = getIntent().getStringExtra(AddLinkActivityConfig.ORIGINAL_LINK_CONTENT);
            this.oiq = getIntent().getBooleanExtra(AddLinkActivityConfig.IS_SHOW_FIND_NEW_LINK_BUBBLE, false);
            this.oir = getIntent().getStringExtra(AddLinkActivityConfig.BUBBLE_NEW_LINK_CONTENT);
        }
    }

    private void initView() {
        setContentView(R.layout.add_link_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.bkk = (ViewGroup) findViewById(R.id.add_link_activity_layout);
        this.mContentLayout = (ViewGroup) findViewById(R.id.add_link_content_layout);
        this.jAB = (TextView) findViewById(R.id.tv_cancel_add_link);
        this.bMg = (TextView) findViewById(R.id.tv_title_add_link);
        this.guZ = (TextView) findViewById(R.id.tv_complete_add_link);
        this.oil = (ViewGroup) findViewById(R.id.add_link_edit_layout);
        this.oim = (EditText) findViewById(R.id.et_edit_link);
        this.oin = (ImageView) findViewById(R.id.iv_del_edit_link);
        this.oio = (TextView) findViewById(R.id.add_link_tip);
        this.bkk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dXI();
            }
        });
        this.mContentLayout.setClickable(true);
        this.jAB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.dXI();
            }
        });
        this.guZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddLinkActivity.this.oim != null && AddLinkActivity.this.oim.getText() != null) {
                    String obj = AddLinkActivity.this.oim.getText().toString();
                    if (!au.isEmpty(obj) && bf.bsV().l(obj)) {
                        AddLinkActivity.this.Vi(obj);
                    } else {
                        AddLinkActivity.this.showToast(R.string.link_invalid_cant_add);
                    }
                }
            }
        });
        this.oil.setClickable(true);
        this.oim.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AddLinkActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || charSequence.length() == 0) {
                    AddLinkActivity.this.guZ.setEnabled(false);
                    AddLinkActivity.this.oin.setVisibility(8);
                    return;
                }
                AddLinkActivity.this.oin.setVisibility(0);
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (!Character.isWhitespace(charSequence.charAt(i4))) {
                        AddLinkActivity.this.guZ.setEnabled(true);
                        return;
                    }
                }
                AddLinkActivity.this.guZ.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.oim.setText(this.oip);
        this.oim.setSelection(this.oim.getText().length());
        this.oin.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AddLinkActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddLinkActivity.this.oim.setText("");
                AddLinkActivity.this.oim.setSelection(0);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.black_alpha70, true);
        ShowSoftKeyPadDelay(this.oim);
        this.oim.setSelection(this.oim.length());
        if (this.oiq) {
            this.oim.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (au.isEmpty(AddLinkActivity.this.oir)) {
                        AddLinkActivity.this.Vj(UtilHelper.getClipBoardContent());
                    } else {
                        AddLinkActivity.this.Vj(AddLinkActivity.this.oir);
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
        this.jAB.setTextColor(ap.oD(R.color.CAM_X0105));
        ap.setViewTextColor(this.bMg, R.color.CAM_X0105);
        dXH();
        ap.setViewTextColor(this.oim, R.color.CAM_X0105);
        this.oim.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        com.baidu.tbadk.core.elementsMaven.c.br(this.oil).og(R.string.J_X01).setBackGroundColor(R.color.CAM_X0209);
        SvgManager.bsR().a(this.oin, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.oio, R.color.CAM_X0110);
    }

    private void dXH() {
        int color = ap.getColor(R.color.CAM_X0302);
        this.guZ.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{com.baidu.tieba.tbadkCore.c.l(color, ap.faO), com.baidu.tieba.tbadkCore.c.l(color, ap.faN), color}));
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
    public void dXI() {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vi(String str) {
        Intent intent = new Intent();
        intent.putExtra(AddLinkActivityConfig.NEW_LINK_CONTENT, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vj(final String str) {
        if (this.oim != null && !au.isEmpty(str) && bf.bsV().l(str)) {
            this.oim.post(new Runnable() { // from class: com.baidu.tieba.write.write.AddLinkActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (AddLinkActivity.this.ois == null) {
                        AddLinkActivity.this.ois = new WriteTipBubbleController(AddLinkActivity.this.getPageContext(), AddLinkActivity.this.eWb);
                    }
                    AddLinkActivity.this.ois.a(AddLinkActivity.this.oim, AddLinkActivity.this.getPageContext().getString(R.string.find_new_link) + "\n" + str, str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDIT_TEXT);
                }
            });
        }
    }
}
