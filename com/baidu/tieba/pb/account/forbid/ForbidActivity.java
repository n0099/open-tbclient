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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.account.forbid.a;
import com.baidu.tieba.pb.account.forbid.b;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes21.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private BdListView VG;
    private String eFZ;
    private String eGd;
    private RadioGroup kDr;
    private String kDs;
    private TextView kDt;
    private TextView kDu;
    private a kDv;
    private com.baidu.tbadk.core.dialog.a kDw;
    private View.OnClickListener kDx = new AnonymousClass3();
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
        setContentView(R.layout.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_FORBID_USER)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kDt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.forbid_btn_txt), this.kDx);
        this.kDu = (TextView) findViewById(R.id.forbid_id);
        this.VG = (BdListView) findViewById(R.id.listview_forbid_reason);
        this.kDr = (RadioGroup) findViewById(R.id.forbid_days);
        this.kDr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ForbidActivity.this.En(ForbidActivity.this.kDr.getCheckedRadioButtonId());
            }
        });
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.kDs = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        this.eGd = intent.getStringExtra("name_show");
        this.eFZ = intent.getStringExtra("portrait");
        com.baidu.tieba.pb.account.forbid.b.a(this.mForumId, this.kDs, new b.InterfaceC0761b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.2
            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0761b
            public void a(ForbidTplData forbidTplData) {
                ForbidActivity.this.kDu.setText(ForbidActivity.this.eGd);
                if (forbidTplData.type == 1 || forbidTplData.type == 2) {
                    ForbidActivity.this.findViewById(R.id.radio_forbid_3).setVisibility(0);
                    ForbidActivity.this.findViewById(R.id.radio_forbid_10).setVisibility(0);
                }
                ForbidActivity.this.kDv = new a(forbidTplData.reason);
                ForbidActivity.this.VG.setAdapter((ListAdapter) ForbidActivity.this.kDv);
                if (forbidTplData.reason == null || forbidTplData.reason.length == 0) {
                    ForbidActivity.this.showToast(R.string.no_data_text);
                }
            }

            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0761b
            public void b(ForbidTplData forbidTplData) {
                if (StringUtils.isNull(forbidTplData.error.errMsg)) {
                    ForbidActivity.this.showToast(R.string.neterror);
                } else {
                    ForbidActivity.this.showToast(forbidTplData.error.errMsg);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void En(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.kDr.getChildAt(i2);
            if (radioButton.getId() == i) {
                ap.setBackgroundResource(radioButton, R.drawable.btn_prohibit_day_s);
                ap.setViewTextColor(radioButton, R.color.cp_cont_a, 3);
            } else {
                ap.setBackgroundResource(radioButton, R.drawable.btn_prohibit_day_n);
                ap.setViewTextColor(radioButton, R.color.common_color_10039, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(R.id.root);
        getLayoutMode().setNightMode(z);
        getLayoutMode().onModeChanged(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kDt.setTextColor(ap.getColor(R.color.cp_cont_f));
        this.VG.setDivider(ap.getDrawable(R.drawable.forbid_list_divider));
        this.VG.setDividerHeight(l.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* renamed from: com.baidu.tieba.pb.account.forbid.ForbidActivity$3  reason: invalid class name */
    /* loaded from: classes21.dex */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ForbidActivity.this.kDv != null && !at.isEmpty(ForbidActivity.this.kDv.bBt())) {
                com.baidu.tieba.pb.account.forbid.a.a(ForbidActivity.this.mForumId, ForbidActivity.this.mForumName, ForbidActivity.this.mThreadId, ForbidActivity.this.mUserName, ForbidActivity.this.mPostId, (String) ForbidActivity.this.findViewById(ForbidActivity.this.kDr.getCheckedRadioButtonId()).getTag(), ForbidActivity.this.kDv.bBt(), ForbidActivity.this.eGd, ForbidActivity.this.eFZ, new a.b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3.1
                    @Override // com.baidu.tieba.pb.account.forbid.a.b
                    public void a(ForbidResultData forbidResultData) {
                        ForbidActivity.this.showToast(ForbidActivity.this.getPageContext().getString(R.string.forbid_success));
                        ForbidActivity.this.finish();
                    }

                    @Override // com.baidu.tieba.pb.account.forbid.a.b
                    public void b(ForbidResultData forbidResultData) {
                        if (forbidResultData != null) {
                            String str = forbidResultData.error_msg;
                            switch (forbidResultData.error_code) {
                                case 1211067:
                                case 1211068:
                                    if (ForbidActivity.this.kDw == null) {
                                        ForbidActivity.this.kDw = new com.baidu.tbadk.core.dialog.a(ForbidActivity.this.getActivity());
                                    }
                                    ForbidActivity.this.kDw.zV(str);
                                    ForbidActivity.this.kDw.a(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3.1.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                            if (aVar != null) {
                                                aVar.dismiss();
                                                ForbidActivity.this.getActivity().finish();
                                            }
                                        }
                                    });
                                    ForbidActivity.this.kDw.ie(false);
                                    ForbidActivity.this.kDw.b(ForbidActivity.this.getPageContext());
                                    ForbidActivity.this.kDw.bia();
                                    return;
                                default:
                                    ForbidActivity.this.showToast(ForbidActivity.this.getPageContext().getString(R.string.forbid_failure));
                                    return;
                            }
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes21.dex */
    private static class a extends BaseAdapter {
        private String[] kDB;
        private int fDd = 0;
        private View.OnClickListener exX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.fDd = ((b) view.getTag()).mIndex;
                a.this.notifyDataSetChanged();
            }
        };

        public a(String[] strArr) {
            this.kDB = strArr;
        }

        public String bBt() {
            if (this.kDB == null || this.fDd >= this.kDB.length) {
                return null;
            }
            return this.kDB[this.fDd];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.kDB == null) {
                return 0;
            }
            return this.kDB.length;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"ResourceAsColor"})
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.kDD = (TextView) view.findViewById(R.id.reason_text);
                bVar2.kDE = (ImageView) view.findViewById(R.id.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.exX);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.kDD.setText(this.kDB[i]);
            if (bVar.mIndex == this.fDd) {
                ap.setImageResource(bVar.kDE, R.drawable.icon_found_information_choose);
                bVar.kDE.setVisibility(0);
                ap.setViewTextColor(bVar.kDD, R.color.common_color_10047, 1);
            } else {
                bVar.kDE.setVisibility(4);
                ap.setViewTextColor(bVar.kDD, R.color.common_color_10039, 1);
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

    /* loaded from: classes21.dex */
    private static class b {
        TextView kDD;
        ImageView kDE;
        int mIndex;

        private b() {
        }
    }
}
