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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private String ajl;
    private RadioGroup bYm;
    private String bYn;
    private TextView bYo;
    private a bYp;
    private View.OnClickListener bYq = new com.baidu.tieba.pb.account.forbid.a(this);
    private String mForumId;
    private String mForumName;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private String mThreadId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.C0057i.login_to_use), true, 11018)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(i.C0057i.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.C0057i.forbid_btn_txt), this.bYq);
        this.bYo = (TextView) findViewById(i.f.forbid_id);
        this.mListView = (BdListView) findViewById(i.f.listview_forbid_reason);
        this.bYm = (RadioGroup) findViewById(i.f.forbid_days);
        this.bYm.setOnCheckedChangeListener(new c(this));
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.bYn = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.ajl = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        g.a(this.mForumId, this.bYn, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ik(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.bYm.getChildAt(i2);
            if (radioButton.getId() == i) {
                al.i((View) radioButton, i.e.btn_prohibit_day_s);
                al.b(radioButton, i.c.cp_cont_i, 3);
            } else {
                al.i((View) radioButton, i.e.btn_prohibit_day_n);
                al.b(radioButton, i.c.appeal_com_text, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(i.f.root);
        getLayoutMode().ad(z);
        getLayoutMode().k(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mListView.setDivider(al.getDrawable(i.e.forbid_list_divider));
        this.mListView.setDividerHeight(k.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BaseAdapter {
        private String[] bYt;
        private int bYu = 0;
        private View.OnClickListener bIZ = new e(this);

        public a(String[] strArr) {
            this.bYt = strArr;
        }

        public String acv() {
            if (this.bYt == null || this.bYu >= this.bYt.length) {
                return null;
            }
            return this.bYt[this.bYu];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bYt == null) {
                return 0;
            }
            return this.bYt.length;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(i.g.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b(null);
                bVar2.bYw = (TextView) view.findViewById(i.f.reason_text);
                bVar2.bYx = (ImageView) view.findViewById(i.f.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.bIZ);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.bYw.setText(this.bYt[i]);
            if (bVar.mIndex == this.bYu) {
                al.c(bVar.bYx, i.e.icon_found_information_choose);
                bVar.bYx.setVisibility(0);
                al.b(bVar.bYw, i.c.forbid_selected_txt, 1);
            } else {
                bVar.bYx.setVisibility(4);
                al.b(bVar.bYw, i.c.appeal_com_text, 1);
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
        TextView bYw;
        ImageView bYx;
        int mIndex;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
