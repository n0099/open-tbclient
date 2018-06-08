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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.account.forbid.a;
import com.baidu.tieba.pb.account.forbid.b;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private BdListView LQ;
    private String aEV;
    private RadioGroup fmB;
    private String fmC;
    private TextView fmD;
    private TextView fmE;
    private a fmF;
    private View.OnClickListener fmG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ForbidActivity.this.fmF != null && !ao.isEmpty(ForbidActivity.this.fmF.aZX())) {
                com.baidu.tieba.pb.account.forbid.a.a(ForbidActivity.this.mForumId, ForbidActivity.this.mForumName, ForbidActivity.this.mThreadId, ForbidActivity.this.mUserName, ForbidActivity.this.mPostId, (String) ForbidActivity.this.findViewById(ForbidActivity.this.fmB.getCheckedRadioButtonId()).getTag(), ForbidActivity.this.fmF.aZX(), new a.b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3.1
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
        this.fmD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.forbid_btn_txt), this.fmG);
        this.fmE = (TextView) findViewById(d.g.forbid_id);
        this.LQ = (BdListView) findViewById(d.g.listview_forbid_reason);
        this.fmB = (RadioGroup) findViewById(d.g.forbid_days);
        this.fmB.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ForbidActivity.this.qc(ForbidActivity.this.fmB.getCheckedRadioButtonId());
            }
        });
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.fmC = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        this.aEV = intent.getStringExtra("name_show");
        com.baidu.tieba.pb.account.forbid.b.a(this.mForumId, this.fmC, new b.InterfaceC0205b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.2
            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0205b
            public void a(ForbidTplData forbidTplData) {
                ForbidActivity.this.fmE.setText(ForbidActivity.this.aEV);
                if (forbidTplData.type == 1 || forbidTplData.type == 2) {
                    ForbidActivity.this.findViewById(d.g.radio_forbid_3).setVisibility(0);
                    ForbidActivity.this.findViewById(d.g.radio_forbid_10).setVisibility(0);
                }
                ForbidActivity.this.fmF = new a(forbidTplData.reason);
                ForbidActivity.this.LQ.setAdapter((ListAdapter) ForbidActivity.this.fmF);
                if (forbidTplData.reason == null || forbidTplData.reason.length == 0) {
                    ForbidActivity.this.showToast(d.k.no_data_text);
                }
            }

            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0205b
            public void b(ForbidTplData forbidTplData) {
                if (StringUtils.isNull(forbidTplData.error.errMsg)) {
                    ForbidActivity.this.showToast(d.k.neterror);
                } else {
                    ForbidActivity.this.showToast(forbidTplData.error.errMsg);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.fmB.getChildAt(i2);
            if (radioButton.getId() == i) {
                al.i(radioButton, d.f.btn_prohibit_day_s);
                al.c(radioButton, d.C0141d.cp_cont_i, 3);
            } else {
                al.i(radioButton, d.f.btn_prohibit_day_n);
                al.c(radioButton, d.C0141d.common_color_10039, 3);
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
        getLayoutMode().onModeChanged(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fmD.setTextColor(al.getColor(d.C0141d.cp_cont_f));
        this.LQ.setDivider(al.getDrawable(d.f.forbid_list_divider));
        this.LQ.setDividerHeight(l.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* loaded from: classes2.dex */
    private static class a extends BaseAdapter {
        private String[] fmJ;
        private int fmK = 0;
        private View.OnClickListener bVm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.fmK = ((b) view.getTag()).mIndex;
                a.this.notifyDataSetChanged();
            }
        };

        public a(String[] strArr) {
            this.fmJ = strArr;
        }

        public String aZX() {
            if (this.fmJ == null || this.fmK >= this.fmJ.length) {
                return null;
            }
            return this.fmJ[this.fmK];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fmJ == null) {
                return 0;
            }
            return this.fmJ.length;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"ResourceAsColor"})
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.fmM = (TextView) view.findViewById(d.g.reason_text);
                bVar2.fmN = (ImageView) view.findViewById(d.g.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.bVm);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.fmM.setText(this.fmJ[i]);
            if (bVar.mIndex == this.fmK) {
                al.c(bVar.fmN, d.f.icon_found_information_choose);
                bVar.fmN.setVisibility(0);
                al.c(bVar.fmM, d.C0141d.common_color_10047, 1);
            } else {
                bVar.fmN.setVisibility(4);
                al.c(bVar.fmM, d.C0141d.common_color_10039, 1);
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

    /* loaded from: classes2.dex */
    private static class b {
        TextView fmM;
        ImageView fmN;
        int mIndex;

        private b() {
        }
    }
}
