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
    private com.baidu.tbadk.widget.timepicker.a.f.b dpp;
    private ImageView fpa;
    private TextView hWI;
    private View jmZ;
    private BdSwitchView jna;
    private RelativeLayout jnb;
    private TextView jnc;
    private TextView jnd;
    private TextView jne;
    private TextView jnf;
    private TextView jng;
    private int jnh;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private BdSwitchView.a jni = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.jnh = 2;
            } else {
                PersonConstellationActivity.this.jnh = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.jmZ) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.fpa) {
                if (view == PersonConstellationActivity.this.jnb) {
                    PersonConstellationActivity.this.cwH();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e jnj = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.jnc.setText(aq.l(date));
                PersonConstellationActivity.this.jnd.setText(aq.k(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.jna.getVisibility() != 0) {
                    PersonConstellationActivity.this.jne.setVisibility(8);
                    PersonConstellationActivity.this.jna.setVisibility(0);
                    if (PersonConstellationActivity.this.jnh == 1) {
                        PersonConstellationActivity.this.jna.turnOn();
                    } else {
                        PersonConstellationActivity.this.jna.turnOff();
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
        this.jmZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.hWI = (TextView) this.jmZ.findViewById(R.id.right_textview);
        this.hWI.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.hWI.setText(getPageContext().getString(R.string.person_constellation_complete));
        am.setViewTextColor(this.hWI, R.color.navi_op_text, 1);
        this.jmZ.setOnClickListener(this.mClickListener);
        this.fpa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.fpa.setOnClickListener(this.mClickListener);
        am.setImageResource(this.fpa, R.drawable.selector_topbar_return_black);
        this.jna = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.jna.setOnSwitchStateChangeListener(this.jni);
        l.addToParentArea(getPageContext().getPageActivity(), this.jna, 10, 10, 10, 10);
        this.jnb = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.jnb.setOnClickListener(this.mClickListener);
        this.jnc = (TextView) findViewById(R.id.constellation_name);
        this.jnd = (TextView) findViewById(R.id.constellation_birthday);
        this.jnf = (TextView) findViewById(R.id.birthday_label);
        this.jng = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.jne = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.jne.setVisibility(0);
            this.jna.setVisibility(8);
            return;
        }
        this.jne.setVisibility(8);
        this.jna.setVisibility(0);
        if (this.jnh == 1) {
            this.jna.turnOnNoCallback();
        } else {
            this.jna.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.jnc.setText(aq.l(date));
        this.jnd.setText(aq.k(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.jnh = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.jnh);
        setResult(-1, intent);
        finish();
    }

    public void cwH() {
        if (this.dpp == null) {
            this.dpp = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.jnj).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bc(View view) {
                    am.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.dpp != null) {
                                PersonConstellationActivity.this.dpp.dismiss();
                            }
                        }
                    });
                    am.setViewTextColor(textView, R.color.cp_cont_b, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    am.setViewTextColor(textView2, R.color.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.dpp != null) {
                                PersonConstellationActivity.this.dpp.aVe();
                                PersonConstellationActivity.this.dpp.dismiss();
                            }
                        }
                    });
                }
            }).nD(18).a(new boolean[]{true, true, true, false, false, false}).b("年", "月", "日", "时", "分", "秒").au(2.0f).g(0, 0, 0, 0, 0, 0).hq(false).nE(am.getColor(R.color.cp_bg_line_g)).nG(am.getColor(R.color.cp_cont_b)).nH(am.getColor(R.color.cp_cont_d)).nF(am.getColor(R.color.black_alpha30)).nC(am.getColor(R.color.cp_bg_line_d)).hp(false).v(this.mRootView).aUW();
        }
        this.dpp.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jna.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setViewTextColor(this.jnf, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jng, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jnc, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jnd, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jne, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
