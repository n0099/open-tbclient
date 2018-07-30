package com.baidu.tieba.pb.account.forbid;

import android.annotation.SuppressLint;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.account.forbid.a;
import com.baidu.tieba.pb.account.forbid.b;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private BdListView LO;
    private String aFL;
    private String aFP;
    private RadioGroup fqG;
    private String fqH;
    private TextView fqI;
    private TextView fqJ;
    private a fqK;
    private View.OnClickListener fqL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ForbidActivity.this.fqK != null && !ap.isEmpty(ForbidActivity.this.fqK.aYW())) {
                com.baidu.tieba.pb.account.forbid.a.a(ForbidActivity.this.mForumId, ForbidActivity.this.mForumName, ForbidActivity.this.mThreadId, ForbidActivity.this.mUserName, ForbidActivity.this.mPostId, (String) ForbidActivity.this.findViewById(ForbidActivity.this.fqG.getCheckedRadioButtonId()).getTag(), ForbidActivity.this.fqK.aYW(), ForbidActivity.this.aFP, ForbidActivity.this.aFL, new a.b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3.1
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
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11018)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.j.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fqI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.forbid_btn_txt), this.fqL);
        this.fqJ = (TextView) findViewById(d.g.forbid_id);
        this.LO = (BdListView) findViewById(d.g.listview_forbid_reason);
        this.fqG = (RadioGroup) findViewById(d.g.forbid_days);
        this.fqG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ForbidActivity.this.qg(ForbidActivity.this.fqG.getCheckedRadioButtonId());
            }
        });
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.fqH = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        this.aFP = intent.getStringExtra("name_show");
        this.aFL = intent.getStringExtra(IntentConfig.PORTRAIT);
        com.baidu.tieba.pb.account.forbid.b.a(this.mForumId, this.fqH, new b.InterfaceC0206b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.2
            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0206b
            public void a(ForbidTplData forbidTplData) {
                ForbidActivity.this.fqJ.setText(ForbidActivity.this.aFP);
                if (forbidTplData.type == 1 || forbidTplData.type == 2) {
                    ForbidActivity.this.findViewById(d.g.radio_forbid_3).setVisibility(0);
                    ForbidActivity.this.findViewById(d.g.radio_forbid_10).setVisibility(0);
                }
                ForbidActivity.this.fqK = new a(forbidTplData.reason);
                ForbidActivity.this.LO.setAdapter((ListAdapter) ForbidActivity.this.fqK);
                if (forbidTplData.reason == null || forbidTplData.reason.length == 0) {
                    ForbidActivity.this.showToast(d.j.no_data_text);
                }
            }

            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0206b
            public void b(ForbidTplData forbidTplData) {
                if (StringUtils.isNull(forbidTplData.error.errMsg)) {
                    ForbidActivity.this.showToast(d.j.neterror);
                } else {
                    ForbidActivity.this.showToast(forbidTplData.error.errMsg);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.fqG.getChildAt(i2);
            if (radioButton.getId() == i) {
                am.i(radioButton, d.f.btn_prohibit_day_s);
                am.c(radioButton, d.C0140d.cp_cont_i, 3);
            } else {
                am.i(radioButton, d.f.btn_prohibit_day_n);
                am.c(radioButton, d.C0140d.common_color_10039, 3);
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
        this.fqI.setTextColor(am.getColor(d.C0140d.cp_cont_f));
        this.LO.setDivider(am.getDrawable(d.f.forbid_list_divider));
        this.LO.setDividerHeight(l.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* loaded from: classes2.dex */
    private static class a extends BaseAdapter {
        private String[] fqO;
        private int fqP = 0;
        private View.OnClickListener bYH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.fqP = ((b) view.getTag()).mIndex;
                a.this.notifyDataSetChanged();
            }
        };

        public a(String[] strArr) {
            this.fqO = strArr;
        }

        public String aYW() {
            if (this.fqO == null || this.fqP >= this.fqO.length) {
                return null;
            }
            return this.fqO[this.fqP];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fqO == null) {
                return 0;
            }
            return this.fqO.length;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"ResourceAsColor"})
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.fqR = (TextView) view.findViewById(d.g.reason_text);
                bVar2.fqS = (ImageView) view.findViewById(d.g.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.bYH);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.fqR.setText(this.fqO[i]);
            if (bVar.mIndex == this.fqP) {
                am.c(bVar.fqS, d.f.icon_found_information_choose);
                bVar.fqS.setVisibility(0);
                am.c(bVar.fqR, d.C0140d.common_color_10047, 1);
            } else {
                bVar.fqS.setVisibility(4);
                am.c(bVar.fqR, d.C0140d.common_color_10039, 1);
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
        TextView fqR;
        ImageView fqS;
        int mIndex;

        private b() {
        }
    }
}
