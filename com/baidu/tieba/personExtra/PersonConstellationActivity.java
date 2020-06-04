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
    private ImageView giF;
    private TextView iWq;
    private View kqq;
    private BdSwitchView kqr;
    private RelativeLayout kqs;
    private TextView kqt;
    private TextView kqu;
    private TextView kqv;
    private TextView kqw;
    private TextView kqx;
    private int kqy;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private BdSwitchView.a kqz = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.kqy = 2;
            } else {
                PersonConstellationActivity.this.kqy = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.kqq) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.giF) {
                if (view == PersonConstellationActivity.this.kqs) {
                    PersonConstellationActivity.this.cOF();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e kqA = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.kqt.setText(aq.m(date));
                PersonConstellationActivity.this.kqu.setText(aq.l(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.kqr.getVisibility() != 0) {
                    PersonConstellationActivity.this.kqv.setVisibility(8);
                    PersonConstellationActivity.this.kqr.setVisibility(0);
                    if (PersonConstellationActivity.this.kqy == 1) {
                        PersonConstellationActivity.this.kqr.turnOn();
                    } else {
                        PersonConstellationActivity.this.kqr.turnOff();
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
        this.kqq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.iWq = (TextView) this.kqq.findViewById(R.id.right_textview);
        this.iWq.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.iWq.setText(getPageContext().getString(R.string.person_constellation_complete));
        am.setViewTextColor(this.iWq, R.color.navi_op_text, 1);
        this.kqq.setOnClickListener(this.mClickListener);
        this.giF = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.giF.setOnClickListener(this.mClickListener);
        am.setImageResource(this.giF, R.drawable.selector_topbar_return_black);
        this.kqr = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.kqr.setOnSwitchStateChangeListener(this.kqz);
        l.addToParentArea(getPageContext().getPageActivity(), this.kqr, 10, 10, 10, 10);
        this.kqs = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.kqs.setOnClickListener(this.mClickListener);
        this.kqt = (TextView) findViewById(R.id.constellation_name);
        this.kqu = (TextView) findViewById(R.id.constellation_birthday);
        this.kqw = (TextView) findViewById(R.id.birthday_label);
        this.kqx = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.kqv = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.kqv.setVisibility(0);
            this.kqr.setVisibility(8);
            return;
        }
        this.kqv.setVisibility(8);
        this.kqr.setVisibility(0);
        if (this.kqy == 1) {
            this.kqr.turnOnNoCallback();
        } else {
            this.kqr.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.kqt.setText(aq.m(date));
        this.kqu.setText(aq.l(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.kqy = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.kqy);
        setResult(-1, intent);
        finish();
    }

    public void cOF() {
        if (this.edD == null) {
            this.edD = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.kqA).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
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
                                PersonConstellationActivity.this.edD.bjz();
                                PersonConstellationActivity.this.edD.dismiss();
                            }
                        }
                    });
                }
            }).ox(18).a(new boolean[]{true, true, true, false, false, false}).b("年", "月", "日", "时", "分", "秒").ac(2.0f).g(0, 0, 0, 0, 0, 0).iL(false).oy(am.getColor(R.color.cp_bg_line_g)).oA(am.getColor(R.color.cp_cont_b)).oB(am.getColor(R.color.cp_cont_d)).oz(am.getColor(R.color.black_alpha30)).ow(am.getColor(R.color.cp_bg_line_d)).iK(false).A(this.mRootView).bjr();
        }
        this.edD.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kqr.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setViewTextColor(this.kqw, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kqx, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kqt, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.kqu, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.kqv, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
