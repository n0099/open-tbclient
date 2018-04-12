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
    private BdListView FL;
    private RadioGroup fac;
    private String fad;
    private TextView fae;
    private TextView faf;
    private a fag;
    private View.OnClickListener fah = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (ForbidActivity.this.fag != null && !an.isEmpty(ForbidActivity.this.fag.aVb())) {
                com.baidu.tieba.pb.account.forbid.a.a(ForbidActivity.this.mForumId, ForbidActivity.this.mForumName, ForbidActivity.this.mThreadId, ForbidActivity.this.mUserName, ForbidActivity.this.mPostId, (String) ForbidActivity.this.findViewById(ForbidActivity.this.fac.getCheckedRadioButtonId()).getTag(), ForbidActivity.this.fag.aVb(), new a.b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3.1
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
        this.fae = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.forbid_btn_txt), this.fah);
        this.faf = (TextView) findViewById(d.g.forbid_id);
        this.FL = (BdListView) findViewById(d.g.listview_forbid_reason);
        this.fac = (RadioGroup) findViewById(d.g.forbid_days);
        this.fac.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ForbidActivity.this.pS(ForbidActivity.this.fac.getCheckedRadioButtonId());
            }
        });
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.fad = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        com.baidu.tieba.pb.account.forbid.b.a(this.mForumId, this.fad, new b.InterfaceC0189b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.2
            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0189b
            public void a(ForbidTplData forbidTplData) {
                ForbidActivity.this.faf.setText(ForbidActivity.this.mUserName);
                if (forbidTplData.type == 1 || forbidTplData.type == 2) {
                    ForbidActivity.this.findViewById(d.g.radio_forbid_3).setVisibility(0);
                    ForbidActivity.this.findViewById(d.g.radio_forbid_10).setVisibility(0);
                }
                ForbidActivity.this.fag = new a(forbidTplData.reason);
                ForbidActivity.this.FL.setAdapter((ListAdapter) ForbidActivity.this.fag);
            }

            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0189b
            public void b(ForbidTplData forbidTplData) {
                ForbidActivity.this.showToast(forbidTplData.error.errMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.fac.getChildAt(i2);
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
        this.fae.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
        this.FL.setDivider(ak.getDrawable(d.f.forbid_list_divider));
        this.FL.setDividerHeight(l.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* loaded from: classes2.dex */
    private static class a extends BaseAdapter {
        private String[] fak;
        private int fal = 0;
        private View.OnClickListener bMw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.fal = ((b) view2.getTag()).mIndex;
                a.this.notifyDataSetChanged();
            }
        };

        public a(String[] strArr) {
            this.fak = strArr;
        }

        public String aVb() {
            if (this.fak == null || this.fal >= this.fak.length) {
                return null;
            }
            return this.fak[this.fal];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fak == null) {
                return 0;
            }
            return this.fak.length;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"ResourceAsColor"})
        public View getView(int i, View view2, ViewGroup viewGroup) {
            b bVar;
            if (view2 == null) {
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.fan = (TextView) view2.findViewById(d.g.reason_text);
                bVar2.fao = (ImageView) view2.findViewById(d.g.check_img);
                view2.setTag(bVar2);
                view2.setOnClickListener(this.bMw);
                bVar = bVar2;
            } else {
                bVar = (b) view2.getTag();
            }
            bVar.mIndex = i;
            bVar.fan.setText(this.fak[i]);
            if (bVar.mIndex == this.fal) {
                ak.c(bVar.fao, d.f.icon_found_information_choose);
                bVar.fao.setVisibility(0);
                ak.c(bVar.fan, d.C0126d.common_color_10047, 1);
            } else {
                bVar.fao.setVisibility(4);
                ak.c(bVar.fan, d.C0126d.common_color_10039, 1);
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
        TextView fan;
        ImageView fao;
        int mIndex;

        private b() {
        }
    }
}
