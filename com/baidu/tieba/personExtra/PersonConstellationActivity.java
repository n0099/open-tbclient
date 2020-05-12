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
    private com.baidu.tbadk.widget.timepicker.a.f.b dPm;
    private ImageView fTB;
    private TextView iGF;
    private View jXr;
    private BdSwitchView jXs;
    private RelativeLayout jXt;
    private TextView jXu;
    private TextView jXv;
    private TextView jXw;
    private TextView jXx;
    private TextView jXy;
    private int jXz;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private BdSwitchView.a jXA = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.jXz = 2;
            } else {
                PersonConstellationActivity.this.jXz = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.jXr) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.fTB) {
                if (view == PersonConstellationActivity.this.jXt) {
                    PersonConstellationActivity.this.cHq();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e jXB = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.jXu.setText(aq.l(date));
                PersonConstellationActivity.this.jXv.setText(aq.k(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.jXs.getVisibility() != 0) {
                    PersonConstellationActivity.this.jXw.setVisibility(8);
                    PersonConstellationActivity.this.jXs.setVisibility(0);
                    if (PersonConstellationActivity.this.jXz == 1) {
                        PersonConstellationActivity.this.jXs.turnOn();
                    } else {
                        PersonConstellationActivity.this.jXs.turnOff();
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
        this.jXr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.iGF = (TextView) this.jXr.findViewById(R.id.right_textview);
        this.iGF.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.iGF.setText(getPageContext().getString(R.string.person_constellation_complete));
        am.setViewTextColor(this.iGF, R.color.navi_op_text, 1);
        this.jXr.setOnClickListener(this.mClickListener);
        this.fTB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.fTB.setOnClickListener(this.mClickListener);
        am.setImageResource(this.fTB, R.drawable.selector_topbar_return_black);
        this.jXs = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.jXs.setOnSwitchStateChangeListener(this.jXA);
        l.addToParentArea(getPageContext().getPageActivity(), this.jXs, 10, 10, 10, 10);
        this.jXt = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.jXt.setOnClickListener(this.mClickListener);
        this.jXu = (TextView) findViewById(R.id.constellation_name);
        this.jXv = (TextView) findViewById(R.id.constellation_birthday);
        this.jXx = (TextView) findViewById(R.id.birthday_label);
        this.jXy = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.jXw = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.jXw.setVisibility(0);
            this.jXs.setVisibility(8);
            return;
        }
        this.jXw.setVisibility(8);
        this.jXs.setVisibility(0);
        if (this.jXz == 1) {
            this.jXs.turnOnNoCallback();
        } else {
            this.jXs.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.jXu.setText(aq.l(date));
        this.jXv.setText(aq.k(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.jXz = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.jXz);
        setResult(-1, intent);
        finish();
    }

    public void cHq() {
        if (this.dPm == null) {
            this.dPm = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.jXB).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bd(View view) {
                    am.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.dPm != null) {
                                PersonConstellationActivity.this.dPm.dismiss();
                            }
                        }
                    });
                    am.setViewTextColor(textView, R.color.cp_cont_b, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    am.setViewTextColor(textView2, R.color.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.dPm != null) {
                                PersonConstellationActivity.this.dPm.bdm();
                                PersonConstellationActivity.this.dPm.dismiss();
                            }
                        }
                    });
                }
            }).nQ(18).a(new boolean[]{true, true, true, false, false, false}).b("年", "月", "日", "时", "分", "秒").ae(2.0f).g(0, 0, 0, 0, 0, 0).io(false).nR(am.getColor(R.color.cp_bg_line_g)).nT(am.getColor(R.color.cp_cont_b)).nU(am.getColor(R.color.cp_cont_d)).nS(am.getColor(R.color.black_alpha30)).nP(am.getColor(R.color.cp_bg_line_d)).in(false).w(this.mRootView).bde();
        }
        this.dPm.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jXs.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setViewTextColor(this.jXx, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jXy, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jXu, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jXv, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jXw, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
