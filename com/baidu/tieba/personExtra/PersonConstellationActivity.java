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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes18.dex */
public class PersonConstellationActivity extends BaseActivity {
    private com.baidu.tbadk.widget.timepicker.a.f.b eCQ;
    private ImageView gNl;
    private TextView jLE;
    private View ljh;
    private BdSwitchView lji;
    private RelativeLayout ljj;
    private TextView ljk;
    private TextView ljl;
    private TextView ljm;
    private TextView ljn;
    private TextView ljo;
    private int ljp;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private BdSwitchView.a ljq = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.ljp = 2;
            } else {
                PersonConstellationActivity.this.ljp = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.ljh) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.gNl) {
                if (view == PersonConstellationActivity.this.ljj) {
                    PersonConstellationActivity.this.dhK();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e ljr = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.ljk.setText(at.p(date));
                PersonConstellationActivity.this.ljl.setText(at.o(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.lji.getVisibility() != 0) {
                    PersonConstellationActivity.this.ljm.setVisibility(8);
                    PersonConstellationActivity.this.lji.setVisibility(0);
                    if (PersonConstellationActivity.this.ljp == 1) {
                        PersonConstellationActivity.this.lji.turnOn();
                    } else {
                        PersonConstellationActivity.this.lji.turnOff();
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
        this.ljh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jLE = (TextView) this.ljh.findViewById(R.id.right_textview);
        this.jLE.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.jLE.setText(getPageContext().getString(R.string.person_constellation_complete));
        ap.setViewTextColor(this.jLE, R.color.navi_op_text, 1);
        this.ljh.setOnClickListener(this.mClickListener);
        this.gNl = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.gNl.setOnClickListener(this.mClickListener);
        ap.setImageResource(this.gNl, R.drawable.selector_topbar_return_black);
        this.lji = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.lji.setOnSwitchStateChangeListener(this.ljq);
        l.addToParentArea(getPageContext().getPageActivity(), this.lji, 10, 10, 10, 10);
        this.ljj = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.ljj.setOnClickListener(this.mClickListener);
        this.ljk = (TextView) findViewById(R.id.constellation_name);
        this.ljl = (TextView) findViewById(R.id.constellation_birthday);
        this.ljn = (TextView) findViewById(R.id.birthday_label);
        this.ljo = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.ljm = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.ljm.setVisibility(0);
            this.lji.setVisibility(8);
            return;
        }
        this.ljm.setVisibility(8);
        this.lji.setVisibility(0);
        if (this.ljp == 1) {
            this.lji.turnOnNoCallback();
        } else {
            this.lji.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.ljk.setText(at.p(date));
        this.ljl.setText(at.o(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.ljp = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.ljp);
        setResult(-1, intent);
        finish();
    }

    public void dhK() {
        if (this.eCQ == null) {
            this.eCQ = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.ljr).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bm(View view) {
                    ap.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.eCQ != null) {
                                PersonConstellationActivity.this.eCQ.dismiss();
                            }
                        }
                    });
                    ap.setViewTextColor(textView, R.color.cp_cont_b, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    ap.setViewTextColor(textView2, R.color.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.eCQ != null) {
                                PersonConstellationActivity.this.eCQ.byH();
                                PersonConstellationActivity.this.eCQ.dismiss();
                            }
                        }
                    });
                }
            }).ry(18).a(new boolean[]{true, true, true, false, false, false}).b("年", "月", "日", "时", "分", "秒").aj(2.0f).f(0, 0, 0, 0, 0, 0).ka(false).rz(ap.getColor(R.color.cp_bg_line_g)).rB(ap.getColor(R.color.cp_cont_b)).rC(ap.getColor(R.color.cp_cont_d)).rA(ap.getColor(R.color.black_alpha30)).rx(ap.getColor(R.color.cp_bg_line_d)).jZ(false).E(this.mRootView).byz();
        }
        this.eCQ.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lji.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setViewTextColor(this.ljn, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.ljo, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.ljk, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.ljl, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.ljm, R.color.cp_cont_d, 1, i);
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
