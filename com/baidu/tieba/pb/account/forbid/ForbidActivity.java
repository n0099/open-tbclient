package com.baidu.tieba.pb.account.forbid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.account.forbid.a;
import com.baidu.tieba.pb.account.forbid.b;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private BdListView Hj;
    private RadioGroup eEJ;
    private String eEK;
    private TextView eEL;
    private TextView eEM;
    private a eEN;
    private View.OnClickListener eEO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ForbidActivity.this.eEN != null && !am.isEmpty(ForbidActivity.this.eEN.aPz())) {
                com.baidu.tieba.pb.account.forbid.a.a(ForbidActivity.this.mForumId, ForbidActivity.this.mForumName, ForbidActivity.this.mThreadId, ForbidActivity.this.mUserName, ForbidActivity.this.mPostId, (String) ForbidActivity.this.findViewById(ForbidActivity.this.eEJ.getCheckedRadioButtonId()).getTag(), ForbidActivity.this.eEN.aPz(), new a.b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3.1
                    @Override // com.baidu.tieba.pb.account.forbid.a.b
                    public void a(ForbidResultData forbidResultData) {
                        ForbidActivity.this.showToast(ForbidActivity.this.getPageContext().getString(d.j.forbid_success));
                        ForbidActivity.this.finish();
                    }

                    @Override // com.baidu.tieba.pb.account.forbid.a.b
                    public void b(ForbidResultData forbidResultData) {
                        ForbidActivity.this.showToast(ForbidActivity.this.getPageContext().getString(d.j.forbid_failure));
                    }
                });
            }
        }
    };
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private String mThreadId;
    private String mUserName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11018)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.j.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eEL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.forbid_btn_txt), this.eEO);
        this.eEM = (TextView) findViewById(d.g.forbid_id);
        this.Hj = (BdListView) findViewById(d.g.listview_forbid_reason);
        this.eEJ = (RadioGroup) findViewById(d.g.forbid_days);
        this.eEJ.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ForbidActivity.this.pn(ForbidActivity.this.eEJ.getCheckedRadioButtonId());
            }
        });
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.eEK = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        com.baidu.tieba.pb.account.forbid.b.a(this.mForumId, this.eEK, new b.InterfaceC0111b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.2
            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0111b
            public void a(ForbidTplData forbidTplData) {
                ForbidActivity.this.eEM.setText(ForbidActivity.this.mUserName);
                if (forbidTplData.type == 1 || forbidTplData.type == 2) {
                    ForbidActivity.this.findViewById(d.g.radio_forbid_3).setVisibility(0);
                    ForbidActivity.this.findViewById(d.g.radio_forbid_10).setVisibility(0);
                }
                ForbidActivity.this.eEN = new a(forbidTplData.reason);
                ForbidActivity.this.Hj.setAdapter((ListAdapter) ForbidActivity.this.eEN);
            }

            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0111b
            public void b(ForbidTplData forbidTplData) {
                ForbidActivity.this.showToast(forbidTplData.error.errMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pn(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.eEJ.getChildAt(i2);
            if (radioButton.getId() == i) {
                aj.j(radioButton, d.f.btn_prohibit_day_s);
                aj.c(radioButton, d.C0080d.cp_cont_i, 3);
            } else {
                aj.j(radioButton, d.f.btn_prohibit_day_n);
                aj.c(radioButton, d.C0080d.common_color_10039, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(d.g.root);
        getLayoutMode().ag(z);
        getLayoutMode().t(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eEL.setTextColor(aj.getColor(d.C0080d.cp_cont_f));
        this.Hj.setDivider(aj.getDrawable(d.f.forbid_list_divider));
        this.Hj.setDividerHeight(l.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* loaded from: classes.dex */
    private static class a extends BaseAdapter {
        private String[] eER;
        private int eES = 0;
        private View.OnClickListener bwS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eES = ((b) view.getTag()).mIndex;
                a.this.notifyDataSetChanged();
            }
        };

        public a(String[] strArr) {
            this.eER = strArr;
        }

        public String aPz() {
            if (this.eER == null || this.eES >= this.eER.length) {
                return null;
            }
            return this.eER[this.eES];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eER == null) {
                return 0;
            }
            return this.eER.length;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"ResourceAsColor"})
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.eEU = (TextView) view.findViewById(d.g.reason_text);
                bVar2.eEV = (ImageView) view.findViewById(d.g.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.bwS);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.eEU.setText(this.eER[i]);
            if (bVar.mIndex == this.eES) {
                aj.c(bVar.eEV, d.f.icon_found_information_choose);
                bVar.eEV.setVisibility(0);
                aj.c(bVar.eEU, d.C0080d.common_color_10047, 1);
            } else {
                bVar.eEV.setVisibility(4);
                aj.c(bVar.eEU, d.C0080d.common_color_10039, 1);
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

    /* loaded from: classes.dex */
    private static class b {
        TextView eEU;
        ImageView eEV;
        int mIndex;

        private b() {
        }
    }
}
