package com.baidu.tieba.personExtra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes18.dex */
public class PersonConstellationActivity extends BaseActivity {
    private com.baidu.tbadk.widget.timepicker.a.f.b esx;
    private ImageView gAO;
    private TextView jwj;
    private View kTr;
    private BdSwitchView kTs;
    private RelativeLayout kTt;
    private TextView kTu;
    private TextView kTv;
    private TextView kTw;
    private TextView kTx;
    private TextView kTy;
    private int kTz;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private BdSwitchView.a kTA = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.kTz = 2;
            } else {
                PersonConstellationActivity.this.kTz = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.kTr) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.gAO) {
                if (view == PersonConstellationActivity.this.kTt) {
                    PersonConstellationActivity.this.cWN();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e kTB = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.kTu.setText(as.p(date));
                PersonConstellationActivity.this.kTv.setText(as.o(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.kTs.getVisibility() != 0) {
                    PersonConstellationActivity.this.kTw.setVisibility(8);
                    PersonConstellationActivity.this.kTs.setVisibility(0);
                    if (PersonConstellationActivity.this.kTz == 1) {
                        PersonConstellationActivity.this.kTs.turnOn();
                    } else {
                        PersonConstellationActivity.this.kTs.turnOff();
                    }
                }
            }
        }
    };

    public static void a(Activity activity, long j, int i) {
        if (activity != null) {
            Intent intent = new Intent();
            intent.setClass(activity, PersonConstellationActivity.class);
            intent.putExtra("constellation_birthday", j);
            intent.putExtra("constellation_show_status", i);
            activity.startActivityForResult(intent, 1001);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_constellation_layout);
        initData();
        this.mRootView = (RelativeLayout) findViewById(R.id.person_constellation_root_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.person_constellation_title)).setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.kTr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jwj = (TextView) this.kTr.findViewById(R.id.right_textview);
        this.jwj.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.jwj.setText(getPageContext().getString(R.string.person_constellation_complete));
        ao.setViewTextColor(this.jwj, R.color.navi_op_text, 1);
        this.kTr.setOnClickListener(this.mClickListener);
        this.gAO = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.gAO.setOnClickListener(this.mClickListener);
        ao.setImageResource(this.gAO, R.drawable.selector_topbar_return_black);
        this.kTs = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.kTs.setOnSwitchStateChangeListener(this.kTA);
        l.addToParentArea(getPageContext().getPageActivity(), this.kTs, 10, 10, 10, 10);
        this.kTt = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.kTt.setOnClickListener(this.mClickListener);
        this.kTu = (TextView) findViewById(R.id.constellation_name);
        this.kTv = (TextView) findViewById(R.id.constellation_birthday);
        this.kTx = (TextView) findViewById(R.id.birthday_label);
        this.kTy = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.kTw = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.kTw.setVisibility(0);
            this.kTs.setVisibility(8);
            return;
        }
        this.kTw.setVisibility(8);
        this.kTs.setVisibility(0);
        if (this.kTz == 1) {
            this.kTs.turnOnNoCallback();
        } else {
            this.kTs.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.kTu.setText(as.p(date));
        this.kTv.setText(as.o(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.kTz = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.kTz);
        setResult(-1, intent);
        finish();
    }

    public void cWN() {
        if (this.esx == null) {
            this.esx = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.kTB).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bk(View view) {
                    ao.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.esx != null) {
                                PersonConstellationActivity.this.esx.dismiss();
                            }
                        }
                    });
                    ao.setViewTextColor(textView, R.color.cp_cont_b, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    ao.setViewTextColor(textView2, R.color.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.esx != null) {
                                PersonConstellationActivity.this.esx.bpT();
                                PersonConstellationActivity.this.esx.dismiss();
                            }
                        }
                    });
                }
            }).pm(18).a(new boolean[]{true, true, true, false, false, false}).b("年", "月", "日", "时", "分", "秒").ae(2.0f).g(0, 0, 0, 0, 0, 0).jC(false).po(ao.getColor(R.color.cp_bg_line_g)).pq(ao.getColor(R.color.cp_cont_b)).pr(ao.getColor(R.color.cp_cont_d)).pp(ao.getColor(R.color.black_alpha30)).pl(ao.getColor(R.color.cp_bg_line_d)).jB(false).D(this.mRootView).bpL();
        }
        this.esx.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kTs.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        ao.setViewTextColor(this.kTx, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.kTy, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.kTu, R.color.cp_cont_d, 1, i);
        ao.setViewTextColor(this.kTv, R.color.cp_cont_d, 1, i);
        ao.setViewTextColor(this.kTw, R.color.cp_cont_d, 1, i);
        ao.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
