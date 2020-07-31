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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.account.forbid.a;
import com.baidu.tieba.pb.account.forbid.b;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes16.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private BdListView UL;
    private String ets;
    private String etw;
    private RadioGroup kfq;
    private String kfr;
    private TextView kfs;
    private TextView kft;
    private a kfu;
    private com.baidu.tbadk.core.dialog.a kfv;
    private View.OnClickListener kfw = new AnonymousClass3();
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
        this.kfs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.forbid_btn_txt), this.kfw);
        this.kft = (TextView) findViewById(R.id.forbid_id);
        this.UL = (BdListView) findViewById(R.id.listview_forbid_reason);
        this.kfq = (RadioGroup) findViewById(R.id.forbid_days);
        this.kfq.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ForbidActivity.this.Bt(ForbidActivity.this.kfq.getCheckedRadioButtonId());
            }
        });
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.kfr = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        this.etw = intent.getStringExtra("name_show");
        this.ets = intent.getStringExtra("portrait");
        com.baidu.tieba.pb.account.forbid.b.a(this.mForumId, this.kfr, new b.InterfaceC0713b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.2
            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0713b
            public void a(ForbidTplData forbidTplData) {
                ForbidActivity.this.kft.setText(ForbidActivity.this.etw);
                if (forbidTplData.type == 1 || forbidTplData.type == 2) {
                    ForbidActivity.this.findViewById(R.id.radio_forbid_3).setVisibility(0);
                    ForbidActivity.this.findViewById(R.id.radio_forbid_10).setVisibility(0);
                }
                ForbidActivity.this.kfu = new a(forbidTplData.reason);
                ForbidActivity.this.UL.setAdapter((ListAdapter) ForbidActivity.this.kfu);
                if (forbidTplData.reason == null || forbidTplData.reason.length == 0) {
                    ForbidActivity.this.showToast(R.string.no_data_text);
                }
            }

            @Override // com.baidu.tieba.pb.account.forbid.b.InterfaceC0713b
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
    public void Bt(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.kfq.getChildAt(i2);
            if (radioButton.getId() == i) {
                ao.setBackgroundResource(radioButton, R.drawable.btn_prohibit_day_s);
                ao.setViewTextColor(radioButton, R.color.cp_cont_a, 3);
            } else {
                ao.setBackgroundResource(radioButton, R.drawable.btn_prohibit_day_n);
                ao.setViewTextColor(radioButton, R.color.common_color_10039, 3);
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
        this.kfs.setTextColor(ao.getColor(R.color.cp_cont_f));
        this.UL.setDivider(ao.getDrawable(R.drawable.forbid_list_divider));
        this.UL.setDividerHeight(l.dip2px(getPageContext().getPageActivity(), 1.0f));
    }

    /* renamed from: com.baidu.tieba.pb.account.forbid.ForbidActivity$3  reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ForbidActivity.this.kfu != null && !as.isEmpty(ForbidActivity.this.kfu.brm())) {
                com.baidu.tieba.pb.account.forbid.a.a(ForbidActivity.this.mForumId, ForbidActivity.this.mForumName, ForbidActivity.this.mThreadId, ForbidActivity.this.mUserName, ForbidActivity.this.mPostId, (String) ForbidActivity.this.findViewById(ForbidActivity.this.kfq.getCheckedRadioButtonId()).getTag(), ForbidActivity.this.kfu.brm(), ForbidActivity.this.etw, ForbidActivity.this.ets, new a.b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3.1
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
                                    if (ForbidActivity.this.kfv == null) {
                                        ForbidActivity.this.kfv = new com.baidu.tbadk.core.dialog.a(ForbidActivity.this.getActivity());
                                    }
                                    ForbidActivity.this.kfv.xl(str);
                                    ForbidActivity.this.kfv.a(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.3.1.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                            if (aVar != null) {
                                                aVar.dismiss();
                                                ForbidActivity.this.getActivity().finish();
                                            }
                                        }
                                    });
                                    ForbidActivity.this.kfv.hK(false);
                                    ForbidActivity.this.kfv.b(ForbidActivity.this.getPageContext());
                                    ForbidActivity.this.kfv.aYL();
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

    /* loaded from: classes16.dex */
    private static class a extends BaseAdapter {
        private String[] kfA;
        private int foq = 0;
        private View.OnClickListener elT = new View.OnClickListener() { // from class: com.baidu.tieba.pb.account.forbid.ForbidActivity.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.foq = ((b) view.getTag()).mIndex;
                a.this.notifyDataSetChanged();
            }
        };

        public a(String[] strArr) {
            this.kfA = strArr;
        }

        public String brm() {
            if (this.kfA == null || this.foq >= this.kfA.length) {
                return null;
            }
            return this.kfA[this.foq];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.kfA == null) {
                return 0;
            }
            return this.kfA.length;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"ResourceAsColor"})
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.forbid_list_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.kfC = (TextView) view.findViewById(R.id.reason_text);
                bVar2.kfD = (ImageView) view.findViewById(R.id.check_img);
                view.setTag(bVar2);
                view.setOnClickListener(this.elT);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.mIndex = i;
            bVar.kfC.setText(this.kfA[i]);
            if (bVar.mIndex == this.foq) {
                ao.setImageResource(bVar.kfD, R.drawable.icon_found_information_choose);
                bVar.kfD.setVisibility(0);
                ao.setViewTextColor(bVar.kfC, R.color.common_color_10047, 1);
            } else {
                bVar.kfD.setVisibility(4);
                ao.setViewTextColor(bVar.kfC, R.color.common_color_10039, 1);
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

    /* loaded from: classes16.dex */
    private static class b {
        TextView kfC;
        ImageView kfD;
        int mIndex;

        private b() {
        }
    }
}
