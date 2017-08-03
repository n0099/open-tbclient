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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.account.forbid.a;
import com.baidu.tieba.pb.account.forbid.b;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private BdListView Ib;
    private RadioGroup eAH;
    private String eAI;
    private TextView eAJ;
    private TextView eAK;
    private a eAL;
    private View.OnClickListener eAM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ForbidActivity.this.eAL != null && !al.isEmpty(ForbidActivity.this.eAL.aOA())) {
                com.baidu.tieba.pb.account.forbid.a.a(ForbidActivity.this.mForumId, ForbidActivity.this.mForumName, ForbidActivity.this.mThreadId, ForbidActivity.this.mUserName, ForbidActivity.this.mPostId, (String) ForbidActivity.this.findViewById(ForbidActivity.this.eAH.getCheckedRadioButtonId()).getTag(), ForbidActivity.this.eAL.aOA(), new a.b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3.1
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
        this.eAJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.forbid_btn_txt), this.eAM);
        this.eAK = (TextView) findViewById(d.h.forbid_id);
        this.Ib = (BdListView) findViewById(d.h.listview_forbid_reason);
        this.eAH = (RadioGroup) findViewById(d.h.forbid_days);
        this.eAH.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ForbidActivity.this.oI(ForbidActivity.this.eAH.getCheckedRadioButtonId());
            }
        });
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.eAI = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        com.baidu.tieba.pb.account.forbid.b.a(this.mForumId, this.eAI, new b.InterfaceC0110b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.2
            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0110b
            public void a(ForbidTplData forbidTplData) {
                ForbidActivity.this.eAK.setText(ForbidActivity.this.mUserName);
                if (forbidTplData.type == 1 || forbidTplData.type == 2) {
                    ForbidActivity.this.findViewById(d.h.radio_forbid_3).setVisibility(0);
                    ForbidActivity.this.findViewById(d.h.radio_forbid_10).setVisibility(0);
                }
                ForbidActivity.this.eAL = new a(forbidTplData.reason);
                ForbidActivity.this.Ib.setAdapter((ListAdapter) ForbidActivity.this.eAL);
            }

            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0110b
            public void b(ForbidTplData forbidTplData) {
                ForbidActivity.this.showToast(forbidTplData.error.errMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oI(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.eAH.getChildAt(i2);
            if (radioButton.getId() == i) {
                ai.j(radioButton, d.g.btn_prohibit_day_s);
                ai.c(radioButton, d.e.cp_cont_i, 3);
            } else {
                ai.j(radioButton, d.g.btn_prohibit_day_n);
                ai.c(radioButton, d.e.common_color_10039, 3);
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
        this.eAJ.setTextColor(ai.getColor(d.e.cp_cont_f));
        this.Ib.setDivider(ai.getDrawable(d.g.forbid_list_divider));
        this.Ib.setDividerHeight(k.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* loaded from: classes.dex */
    private static class a extends BaseAdapter {
        private int cID = 0;
        private View.OnClickListener czb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cID = ((b) view.getTag()).mIndex;
                a.this.notifyDataSetChanged();
            }
        };
        private String[] eAP;

        public a(String[] strArr) {
            this.eAP = strArr;
        }

        public String aOA() {
            if (this.eAP == null || this.cID >= this.eAP.length) {
                return null;
            }
            return this.eAP[this.cID];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eAP == null) {
                return 0;
            }
            return this.eAP.length;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"ResourceAsColor"})
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(d.j.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.eAR = (TextView) view.findViewById(d.h.reason_text);
                bVar2.eAS = (ImageView) view.findViewById(d.h.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.czb);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.eAR.setText(this.eAP[i]);
            if (bVar.mIndex == this.cID) {
                ai.c(bVar.eAS, d.g.icon_found_information_choose);
                bVar.eAS.setVisibility(0);
                ai.c(bVar.eAR, d.e.common_color_10047, 1);
            } else {
                bVar.eAS.setVisibility(4);
                ai.c(bVar.eAR, d.e.common_color_10039, 1);
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
        TextView eAR;
        ImageView eAS;
        int mIndex;

        private b() {
        }
    }
}
