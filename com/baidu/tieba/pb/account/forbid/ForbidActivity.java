package com.baidu.tieba.pb.account.forbid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private RadioGroup cBh;
    private String cBi;
    private TextView cBj;
    private a cBk;
    private View.OnClickListener cBl = new com.baidu.tieba.pb.account.forbid.a(this);
    private String mForumId;
    private String mForumName;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private String mThreadId;
    private String mUserName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(n.j.login_to_use), true, 11018)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(n.j.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(n.j.forbid_btn_txt), this.cBl);
        this.cBj = (TextView) findViewById(n.g.forbid_id);
        this.mListView = (BdListView) findViewById(n.g.listview_forbid_reason);
        this.cBh = (RadioGroup) findViewById(n.g.forbid_days);
        this.cBh.setOnCheckedChangeListener(new c(this));
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.cBi = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        g.a(this.mForumId, this.cBi, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kh(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.cBh.getChildAt(i2);
            if (radioButton.getId() == i) {
                as.i((View) radioButton, n.f.btn_prohibit_day_s);
                as.b(radioButton, n.d.cp_cont_i, 3);
            } else {
                as.i((View) radioButton, n.f.btn_prohibit_day_n);
                as.b(radioButton, n.d.appeal_com_text, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(n.g.root);
        getLayoutMode().ac(z);
        getLayoutMode().k(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mListView.setDivider(as.getDrawable(n.f.forbid_list_divider));
        this.mListView.setDividerHeight(k.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BaseAdapter {
        private String[] cBo;
        private int cBp = 0;
        private View.OnClickListener cgv = new e(this);

        public a(String[] strArr) {
            this.cBo = strArr;
        }

        public String akr() {
            if (this.cBo == null || this.cBp >= this.cBo.length) {
                return null;
            }
            return this.cBo[this.cBp];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cBo == null) {
                return 0;
            }
            return this.cBo.length;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(n.h.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b(null);
                bVar2.cBr = (TextView) view.findViewById(n.g.reason_text);
                bVar2.cBs = (ImageView) view.findViewById(n.g.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.cgv);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.cBr.setText(this.cBo[i]);
            if (bVar.mIndex == this.cBp) {
                as.c(bVar.cBs, n.f.icon_found_information_choose);
                bVar.cBs.setVisibility(0);
                as.b(bVar.cBr, n.d.forbid_selected_txt, 1);
            } else {
                bVar.cBs.setVisibility(4);
                as.b(bVar.cBr, n.d.appeal_com_text, 1);
            }
            return view;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        TextView cBr;
        ImageView cBs;
        int mIndex;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
