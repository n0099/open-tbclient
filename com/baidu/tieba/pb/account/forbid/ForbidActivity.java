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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private BdListView Ck;
    private RadioGroup dUK;
    private String dUL;
    private TextView dUM;
    private TextView dUN;
    private a dUO;
    private View.OnClickListener dUP = new com.baidu.tieba.pb.account.forbid.a(this);
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
        setContentView(r.h.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(r.j.login_to_use), true, 11018)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(r.j.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dUM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(r.j.forbid_btn_txt), this.dUP);
        this.dUN = (TextView) findViewById(r.g.forbid_id);
        this.Ck = (BdListView) findViewById(r.g.listview_forbid_reason);
        this.dUK = (RadioGroup) findViewById(r.g.forbid_days);
        this.dUK.setOnCheckedChangeListener(new c(this));
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.dUL = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        g.a(this.mForumId, this.dUL, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.dUK.getChildAt(i2);
            if (radioButton.getId() == i) {
                ar.k(radioButton, r.f.btn_prohibit_day_s);
                ar.c(radioButton, r.d.cp_cont_i, 3);
            } else {
                ar.k(radioButton, r.f.btn_prohibit_day_n);
                ar.c(radioButton, r.d.common_color_10039, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(r.g.root);
        getLayoutMode().ai(z);
        getLayoutMode().x(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dUM.setTextColor(ar.getColor(r.d.cp_cont_f));
        this.Ck.setDivider(ar.getDrawable(r.f.forbid_list_divider));
        this.Ck.setDividerHeight(k.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BaseAdapter {
        private String[] dUS;
        private int chA = 0;
        private View.OnClickListener aTB = new e(this);

        public a(String[] strArr) {
            this.dUS = strArr;
        }

        public String aHO() {
            if (this.dUS == null || this.chA >= this.dUS.length) {
                return null;
            }
            return this.dUS[this.chA];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dUS == null) {
                return 0;
            }
            return this.dUS.length;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(r.h.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b(null);
                bVar2.dUU = (TextView) view.findViewById(r.g.reason_text);
                bVar2.dUV = (ImageView) view.findViewById(r.g.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.aTB);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.dUU.setText(this.dUS[i]);
            if (bVar.mIndex == this.chA) {
                ar.c(bVar.dUV, r.f.icon_found_information_choose);
                bVar.dUV.setVisibility(0);
                ar.c(bVar.dUU, r.d.common_color_10047, 1);
            } else {
                bVar.dUV.setVisibility(4);
                ar.c(bVar.dUU, r.d.common_color_10039, 1);
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
        TextView dUU;
        ImageView dUV;
        int mIndex;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }
}
