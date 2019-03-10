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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.account.forbid.a;
import com.baidu.tieba.pb.account.forbid.b;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private BdListView Pi;
    private String cba;
    private String cbe;
    private RadioGroup hic;
    private String hie;
    private TextView hif;
    private TextView hig;
    private a hih;
    private com.baidu.tbadk.core.dialog.a hii;
    private View.OnClickListener hij = new AnonymousClass3();
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
        this.hif = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.forbid_btn_txt), this.hij);
        this.hig = (TextView) findViewById(d.g.forbid_id);
        this.Pi = (BdListView) findViewById(d.g.listview_forbid_reason);
        this.hic = (RadioGroup) findViewById(d.g.forbid_days);
        this.hic.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ForbidActivity.this.vV(ForbidActivity.this.hic.getCheckedRadioButtonId());
            }
        });
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.hie = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        this.cbe = intent.getStringExtra("name_show");
        this.cba = intent.getStringExtra(IntentConfig.PORTRAIT);
        com.baidu.tieba.pb.account.forbid.b.a(this.mForumId, this.hie, new b.InterfaceC0280b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.2
            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0280b
            public void a(ForbidTplData forbidTplData) {
                ForbidActivity.this.hig.setText(ForbidActivity.this.cbe);
                if (forbidTplData.type == 1 || forbidTplData.type == 2) {
                    ForbidActivity.this.findViewById(d.g.radio_forbid_3).setVisibility(0);
                    ForbidActivity.this.findViewById(d.g.radio_forbid_10).setVisibility(0);
                }
                ForbidActivity.this.hih = new a(forbidTplData.reason);
                ForbidActivity.this.Pi.setAdapter((ListAdapter) ForbidActivity.this.hih);
                if (forbidTplData.reason == null || forbidTplData.reason.length == 0) {
                    ForbidActivity.this.showToast(d.j.no_data_text);
                }
            }

            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0280b
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
    public void vV(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.hic.getChildAt(i2);
            if (radioButton.getId() == i) {
                al.k(radioButton, d.f.btn_prohibit_day_s);
                al.d(radioButton, d.C0236d.cp_btn_a, 3);
            } else {
                al.k(radioButton, d.f.btn_prohibit_day_n);
                al.d(radioButton, d.C0236d.common_color_10039, 3);
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
        this.hif.setTextColor(al.getColor(d.C0236d.cp_cont_f));
        this.Pi.setDivider(al.getDrawable(d.f.forbid_list_divider));
        this.Pi.setDividerHeight(l.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* renamed from: com.baidu.tieba.pb.account.forbid.ForbidActivity$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ForbidActivity.this.hih != null && !ap.isEmpty(ForbidActivity.this.hih.auX())) {
                com.baidu.tieba.pb.account.forbid.a.a(ForbidActivity.this.mForumId, ForbidActivity.this.mForumName, ForbidActivity.this.mThreadId, ForbidActivity.this.mUserName, ForbidActivity.this.mPostId, (String) ForbidActivity.this.findViewById(ForbidActivity.this.hic.getCheckedRadioButtonId()).getTag(), ForbidActivity.this.hih.auX(), ForbidActivity.this.cbe, ForbidActivity.this.cba, new a.b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3.1
                    @Override // com.baidu.tieba.pb.account.forbid.a.b
                    public void a(ForbidResultData forbidResultData) {
                        ForbidActivity.this.showToast(ForbidActivity.this.getPageContext().getString(d.j.forbid_success));
                        ForbidActivity.this.finish();
                    }

                    @Override // com.baidu.tieba.pb.account.forbid.a.b
                    public void b(ForbidResultData forbidResultData) {
                        if (forbidResultData != null) {
                            String str = forbidResultData.error_msg;
                            switch (forbidResultData.error_code) {
                                case 1211067:
                                case 1211068:
                                    if (ForbidActivity.this.hii == null) {
                                        ForbidActivity.this.hii = new com.baidu.tbadk.core.dialog.a(ForbidActivity.this.getActivity());
                                    }
                                    ForbidActivity.this.hii.ly(str);
                                    ForbidActivity.this.hii.a(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3.1.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                            if (aVar != null) {
                                                aVar.dismiss();
                                                ForbidActivity.this.getActivity().finish();
                                            }
                                        }
                                    });
                                    ForbidActivity.this.hii.dr(false);
                                    ForbidActivity.this.hii.b(ForbidActivity.this.getPageContext());
                                    ForbidActivity.this.hii.aaZ();
                                    return;
                                default:
                                    ForbidActivity.this.showToast(ForbidActivity.this.getPageContext().getString(d.j.forbid_failure));
                                    return;
                            }
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class a extends BaseAdapter {
        private String[] hin;
        private int hio = 0;
        private View.OnClickListener dHs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hio = ((b) view.getTag()).mIndex;
                a.this.notifyDataSetChanged();
            }
        };

        public a(String[] strArr) {
            this.hin = strArr;
        }

        public String auX() {
            if (this.hin == null || this.hio >= this.hin.length) {
                return null;
            }
            return this.hin[this.hio];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.hin == null) {
                return 0;
            }
            return this.hin.length;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"ResourceAsColor"})
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.hiq = (TextView) view.findViewById(d.g.reason_text);
                bVar2.hir = (ImageView) view.findViewById(d.g.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.dHs);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.hiq.setText(this.hin[i]);
            if (bVar.mIndex == this.hio) {
                al.c(bVar.hir, d.f.icon_found_information_choose);
                bVar.hir.setVisibility(0);
                al.d(bVar.hiq, d.C0236d.common_color_10047, 1);
            } else {
                bVar.hir.setVisibility(4);
                al.d(bVar.hiq, d.C0236d.common_color_10039, 1);
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

    /* loaded from: classes4.dex */
    private static class b {
        TextView hiq;
        ImageView hir;
        int mIndex;

        private b() {
        }
    }
}
