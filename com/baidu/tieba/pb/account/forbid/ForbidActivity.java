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
import com.baidu.adp.lib.util.k;
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
    private BdListView Hw;
    private RadioGroup eDd;
    private String eDe;
    private TextView eDf;
    private TextView eDg;
    private a eDh;
    private View.OnClickListener eDi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ForbidActivity.this.eDh != null && !am.isEmpty(ForbidActivity.this.eDh.aOK())) {
                com.baidu.tieba.pb.account.forbid.a.a(ForbidActivity.this.mForumId, ForbidActivity.this.mForumName, ForbidActivity.this.mThreadId, ForbidActivity.this.mUserName, ForbidActivity.this.mPostId, (String) ForbidActivity.this.findViewById(ForbidActivity.this.eDd.getCheckedRadioButtonId()).getTag(), ForbidActivity.this.eDh.aOK(), new a.b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3.1
                    @Override // com.baidu.tieba.pb.account.forbid.a.b
                    public void a(ForbidResultData forbidResultData) {
                        ForbidActivity.this.showToast(ForbidActivity.this.getPageContext().getString(d.l.forbid_success));
                        ForbidActivity.this.finish();
                    }

                    @Override // com.baidu.tieba.pb.account.forbid.a.b
                    public void b(ForbidResultData forbidResultData) {
                        ForbidActivity.this.showToast(ForbidActivity.this.getPageContext().getString(d.l.forbid_failure));
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
        setContentView(d.j.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11018)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.l.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eDf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.forbid_btn_txt), this.eDi);
        this.eDg = (TextView) findViewById(d.h.forbid_id);
        this.Hw = (BdListView) findViewById(d.h.listview_forbid_reason);
        this.eDd = (RadioGroup) findViewById(d.h.forbid_days);
        this.eDd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ForbidActivity.this.pb(ForbidActivity.this.eDd.getCheckedRadioButtonId());
            }
        });
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.eDe = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        com.baidu.tieba.pb.account.forbid.b.a(this.mForumId, this.eDe, new b.InterfaceC0111b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.2
            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0111b
            public void a(ForbidTplData forbidTplData) {
                ForbidActivity.this.eDg.setText(ForbidActivity.this.mUserName);
                if (forbidTplData.type == 1 || forbidTplData.type == 2) {
                    ForbidActivity.this.findViewById(d.h.radio_forbid_3).setVisibility(0);
                    ForbidActivity.this.findViewById(d.h.radio_forbid_10).setVisibility(0);
                }
                ForbidActivity.this.eDh = new a(forbidTplData.reason);
                ForbidActivity.this.Hw.setAdapter((ListAdapter) ForbidActivity.this.eDh);
            }

            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0111b
            public void b(ForbidTplData forbidTplData) {
                ForbidActivity.this.showToast(forbidTplData.error.errMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pb(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.eDd.getChildAt(i2);
            if (radioButton.getId() == i) {
                aj.j(radioButton, d.g.btn_prohibit_day_s);
                aj.c(radioButton, d.e.cp_cont_i, 3);
            } else {
                aj.j(radioButton, d.g.btn_prohibit_day_n);
                aj.c(radioButton, d.e.common_color_10039, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(d.h.root);
        getLayoutMode().ah(z);
        getLayoutMode().t(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eDf.setTextColor(aj.getColor(d.e.cp_cont_f));
        this.Hw.setDivider(aj.getDrawable(d.g.forbid_list_divider));
        this.Hw.setDividerHeight(k.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* loaded from: classes.dex */
    private static class a extends BaseAdapter {
        private String[] eDl;
        private int cTg = 0;
        private View.OnClickListener cJD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cTg = ((b) view.getTag()).mIndex;
                a.this.notifyDataSetChanged();
            }
        };

        public a(String[] strArr) {
            this.eDl = strArr;
        }

        public String aOK() {
            if (this.eDl == null || this.cTg >= this.eDl.length) {
                return null;
            }
            return this.eDl[this.cTg];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eDl == null) {
                return 0;
            }
            return this.eDl.length;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"ResourceAsColor"})
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(d.j.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.eDn = (TextView) view.findViewById(d.h.reason_text);
                bVar2.eDo = (ImageView) view.findViewById(d.h.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.cJD);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.eDn.setText(this.eDl[i]);
            if (bVar.mIndex == this.cTg) {
                aj.c(bVar.eDo, d.g.icon_found_information_choose);
                bVar.eDo.setVisibility(0);
                aj.c(bVar.eDn, d.e.common_color_10047, 1);
            } else {
                bVar.eDo.setVisibility(4);
                aj.c(bVar.eDn, d.e.common_color_10039, 1);
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
        TextView eDn;
        ImageView eDo;
        int mIndex;

        private b() {
        }
    }
}
