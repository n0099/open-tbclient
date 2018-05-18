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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.account.forbid.a;
import com.baidu.tieba.pb.account.forbid.b;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private BdListView FH;
    private RadioGroup fbg;
    private String fbh;
    private TextView fbi;
    private TextView fbj;
    private a fbk;
    private View.OnClickListener fbl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (ForbidActivity.this.fbk != null && !an.isEmpty(ForbidActivity.this.fbk.aVb())) {
                com.baidu.tieba.pb.account.forbid.a.a(ForbidActivity.this.mForumId, ForbidActivity.this.mForumName, ForbidActivity.this.mThreadId, ForbidActivity.this.mUserName, ForbidActivity.this.mPostId, (String) ForbidActivity.this.findViewById(ForbidActivity.this.fbg.getCheckedRadioButtonId()).getTag(), ForbidActivity.this.fbk.aVb(), new a.b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3.1
                    @Override // com.baidu.tieba.pb.account.forbid.a.b
                    public void a(ForbidResultData forbidResultData) {
                        ForbidActivity.this.showToast(ForbidActivity.this.getPageContext().getString(d.k.forbid_success));
                        ForbidActivity.this.finish();
                    }

                    @Override // com.baidu.tieba.pb.account.forbid.a.b
                    public void b(ForbidResultData forbidResultData) {
                        ForbidActivity.this.showToast(ForbidActivity.this.getPageContext().getString(d.k.forbid_failure));
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
        setContentView(d.i.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.k.login_to_use), true, 11018)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.k.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fbi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.forbid_btn_txt), this.fbl);
        this.fbj = (TextView) findViewById(d.g.forbid_id);
        this.FH = (BdListView) findViewById(d.g.listview_forbid_reason);
        this.fbg = (RadioGroup) findViewById(d.g.forbid_days);
        this.fbg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ForbidActivity.this.pQ(ForbidActivity.this.fbg.getCheckedRadioButtonId());
            }
        });
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.fbh = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        com.baidu.tieba.pb.account.forbid.b.a(this.mForumId, this.fbh, new b.InterfaceC0189b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.2
            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0189b
            public void a(ForbidTplData forbidTplData) {
                ForbidActivity.this.fbj.setText(ForbidActivity.this.mUserName);
                if (forbidTplData.type == 1 || forbidTplData.type == 2) {
                    ForbidActivity.this.findViewById(d.g.radio_forbid_3).setVisibility(0);
                    ForbidActivity.this.findViewById(d.g.radio_forbid_10).setVisibility(0);
                }
                ForbidActivity.this.fbk = new a(forbidTplData.reason);
                ForbidActivity.this.FH.setAdapter((ListAdapter) ForbidActivity.this.fbk);
            }

            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0189b
            public void b(ForbidTplData forbidTplData) {
                ForbidActivity.this.showToast(forbidTplData.error.errMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pQ(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.fbg.getChildAt(i2);
            if (radioButton.getId() == i) {
                ak.i(radioButton, d.f.btn_prohibit_day_s);
                ak.c(radioButton, d.C0126d.cp_cont_i, 3);
            } else {
                ak.i(radioButton, d.f.btn_prohibit_day_n);
                ak.c(radioButton, d.C0126d.common_color_10039, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(d.g.root);
        getLayoutMode().setNightMode(z);
        getLayoutMode().u(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fbi.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
        this.FH.setDivider(ak.getDrawable(d.f.forbid_list_divider));
        this.FH.setDividerHeight(l.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* loaded from: classes2.dex */
    private static class a extends BaseAdapter {
        private String[] fbo;
        private int fbp = 0;
        private View.OnClickListener bNl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.fbp = ((b) view2.getTag()).mIndex;
                a.this.notifyDataSetChanged();
            }
        };

        public a(String[] strArr) {
            this.fbo = strArr;
        }

        public String aVb() {
            if (this.fbo == null || this.fbp >= this.fbo.length) {
                return null;
            }
            return this.fbo[this.fbp];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fbo == null) {
                return 0;
            }
            return this.fbo.length;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"ResourceAsColor"})
        public View getView(int i, View view2, ViewGroup viewGroup) {
            b bVar;
            if (view2 == null) {
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.fbr = (TextView) view2.findViewById(d.g.reason_text);
                bVar2.fbs = (ImageView) view2.findViewById(d.g.check_img);
                view2.setTag(bVar2);
                view2.setOnClickListener(this.bNl);
                bVar = bVar2;
            } else {
                bVar = (b) view2.getTag();
            }
            bVar.mIndex = i;
            bVar.fbr.setText(this.fbo[i]);
            if (bVar.mIndex == this.fbp) {
                ak.c(bVar.fbs, d.f.icon_found_information_choose);
                bVar.fbs.setVisibility(0);
                ak.c(bVar.fbr, d.C0126d.common_color_10047, 1);
            } else {
                bVar.fbs.setVisibility(4);
                ak.c(bVar.fbr, d.C0126d.common_color_10039, 1);
            }
            return view2;
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

    /* loaded from: classes2.dex */
    private static class b {
        TextView fbr;
        ImageView fbs;
        int mIndex;

        private b() {
        }
    }
}
