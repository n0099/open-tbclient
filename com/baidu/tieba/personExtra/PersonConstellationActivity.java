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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes11.dex */
public class PersonConstellationActivity extends BaseActivity {
    private com.baidu.tbadk.widget.timepicker.a.f.b edD;
    private ImageView giu;
    private TextView iVD;
    private View kpk;
    private BdSwitchView kpl;
    private RelativeLayout kpm;
    private TextView kpn;
    private TextView kpo;
    private TextView kpp;
    private TextView kpq;
    private TextView kpr;
    private int kps;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private BdSwitchView.a kpt = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.kps = 2;
            } else {
                PersonConstellationActivity.this.kps = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.kpk) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.giu) {
                if (view == PersonConstellationActivity.this.kpm) {
                    PersonConstellationActivity.this.cOp();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e kpu = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.kpn.setText(aq.m(date));
                PersonConstellationActivity.this.kpo.setText(aq.l(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.kpl.getVisibility() != 0) {
                    PersonConstellationActivity.this.kpp.setVisibility(8);
                    PersonConstellationActivity.this.kpl.setVisibility(0);
                    if (PersonConstellationActivity.this.kps == 1) {
                        PersonConstellationActivity.this.kpl.turnOn();
                    } else {
                        PersonConstellationActivity.this.kpl.turnOff();
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
        this.kpk = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.iVD = (TextView) this.kpk.findViewById(R.id.right_textview);
        this.iVD.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.iVD.setText(getPageContext().getString(R.string.person_constellation_complete));
        am.setViewTextColor(this.iVD, R.color.navi_op_text, 1);
        this.kpk.setOnClickListener(this.mClickListener);
        this.giu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.giu.setOnClickListener(this.mClickListener);
        am.setImageResource(this.giu, R.drawable.selector_topbar_return_black);
        this.kpl = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.kpl.setOnSwitchStateChangeListener(this.kpt);
        l.addToParentArea(getPageContext().getPageActivity(), this.kpl, 10, 10, 10, 10);
        this.kpm = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.kpm.setOnClickListener(this.mClickListener);
        this.kpn = (TextView) findViewById(R.id.constellation_name);
        this.kpo = (TextView) findViewById(R.id.constellation_birthday);
        this.kpq = (TextView) findViewById(R.id.birthday_label);
        this.kpr = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.kpp = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.kpp.setVisibility(0);
            this.kpl.setVisibility(8);
            return;
        }
        this.kpp.setVisibility(8);
        this.kpl.setVisibility(0);
        if (this.kps == 1) {
            this.kpl.turnOnNoCallback();
        } else {
            this.kpl.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.kpn.setText(aq.m(date));
        this.kpo.setText(aq.l(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.kps = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.kps);
        setResult(-1, intent);
        finish();
    }

    public void cOp() {
        if (this.edD == null) {
            this.edD = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.kpu).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void be(View view) {
                    am.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.edD != null) {
                                PersonConstellationActivity.this.edD.dismiss();
                            }
                        }
                    });
                    am.setViewTextColor(textView, R.color.cp_cont_b, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    am.setViewTextColor(textView2, R.color.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.edD != null) {
                                PersonConstellationActivity.this.edD.bjx();
                                PersonConstellationActivity.this.edD.dismiss();
                            }
                        }
                    });
                }
            }).ov(18).a(new boolean[]{true, true, true, false, false, false}).b("年", "月", "日", "时", "分", "秒").ac(2.0f).g(0, 0, 0, 0, 0, 0).iL(false).ow(am.getColor(R.color.cp_bg_line_g)).oy(am.getColor(R.color.cp_cont_b)).oz(am.getColor(R.color.cp_cont_d)).ox(am.getColor(R.color.black_alpha30)).ou(am.getColor(R.color.cp_bg_line_d)).iK(false).A(this.mRootView).bjp();
        }
        this.edD.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kpl.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setViewTextColor(this.kpq, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kpr, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kpn, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.kpo, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.kpp, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
