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
/* loaded from: classes8.dex */
public class PersonConstellationActivity extends BaseActivity {
    private com.baidu.tbadk.widget.timepicker.a.f.b dkr;
    private ImageView fiz;
    private TextView hPs;
    private View jgK;
    private BdSwitchView jgL;
    private RelativeLayout jgM;
    private TextView jgN;
    private TextView jgO;
    private TextView jgP;
    private TextView jgQ;
    private TextView jgR;
    private int jgS;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private BdSwitchView.a jgT = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.jgS = 2;
            } else {
                PersonConstellationActivity.this.jgS = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.jgK) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.fiz) {
                if (view == PersonConstellationActivity.this.jgM) {
                    PersonConstellationActivity.this.ctJ();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e jgU = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.jgN.setText(aq.l(date));
                PersonConstellationActivity.this.jgO.setText(aq.k(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.jgL.getVisibility() != 0) {
                    PersonConstellationActivity.this.jgP.setVisibility(8);
                    PersonConstellationActivity.this.jgL.setVisibility(0);
                    if (PersonConstellationActivity.this.jgS == 1) {
                        PersonConstellationActivity.this.jgL.turnOn();
                    } else {
                        PersonConstellationActivity.this.jgL.turnOff();
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
        this.jgK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.hPs = (TextView) this.jgK.findViewById(R.id.right_textview);
        this.hPs.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.hPs.setText(getPageContext().getString(R.string.person_constellation_complete));
        am.setViewTextColor(this.hPs, R.color.navi_op_text, 1);
        this.jgK.setOnClickListener(this.mClickListener);
        this.fiz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.fiz.setOnClickListener(this.mClickListener);
        am.setImageResource(this.fiz, R.drawable.selector_topbar_return_black);
        this.jgL = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.jgL.setOnSwitchStateChangeListener(this.jgT);
        l.addToParentArea(getPageContext().getPageActivity(), this.jgL, 10, 10, 10, 10);
        this.jgM = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.jgM.setOnClickListener(this.mClickListener);
        this.jgN = (TextView) findViewById(R.id.constellation_name);
        this.jgO = (TextView) findViewById(R.id.constellation_birthday);
        this.jgQ = (TextView) findViewById(R.id.birthday_label);
        this.jgR = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.jgP = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.jgP.setVisibility(0);
            this.jgL.setVisibility(8);
            return;
        }
        this.jgP.setVisibility(8);
        this.jgL.setVisibility(0);
        if (this.jgS == 1) {
            this.jgL.turnOnNoCallback();
        } else {
            this.jgL.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.jgN.setText(aq.l(date));
        this.jgO.setText(aq.k(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.jgS = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.jgS);
        setResult(-1, intent);
        finish();
    }

    public void ctJ() {
        if (this.dkr == null) {
            this.dkr = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.jgU).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void aY(View view) {
                    am.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.dkr != null) {
                                PersonConstellationActivity.this.dkr.dismiss();
                            }
                        }
                    });
                    am.setViewTextColor(textView, R.color.cp_cont_b, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    am.setViewTextColor(textView2, R.color.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.dkr != null) {
                                PersonConstellationActivity.this.dkr.aSm();
                                PersonConstellationActivity.this.dkr.dismiss();
                            }
                        }
                    });
                }
            }).nk(18).a(new boolean[]{true, true, true, false, false, false}).b("年", "月", "日", "时", "分", "秒").aw(2.0f).g(0, 0, 0, 0, 0, 0).hd(false).nl(am.getColor(R.color.cp_bg_line_g)).nn(am.getColor(R.color.cp_cont_b)).no(am.getColor(R.color.cp_cont_d)).nm(am.getColor(R.color.black_alpha30)).nj(am.getColor(R.color.cp_bg_line_d)).hc(false).r(this.mRootView).aSe();
        }
        this.dkr.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jgL.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setViewTextColor(this.jgQ, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jgR, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jgN, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jgO, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jgP, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
