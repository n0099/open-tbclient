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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes24.dex */
public class PersonConstellationActivity extends BaseActivity {
    private com.baidu.tbadk.widget.timepicker.a.f.b fma;
    private ImageView hGK;
    private TextView kPl;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private View moq;
    private BdSwitchView mor;
    private RelativeLayout mos;
    private TextView mot;
    private TextView mou;
    private TextView mov;
    private TextView mow;
    private TextView mox;
    private int moy;
    private BdSwitchView.a moz = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.moy = 2;
            } else {
                PersonConstellationActivity.this.moy = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.moq) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.hGK) {
                if (view == PersonConstellationActivity.this.mos) {
                    PersonConstellationActivity.this.dzB();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e moA = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.mot.setText(au.p(date));
                PersonConstellationActivity.this.mou.setText(au.o(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.mor.getVisibility() != 0) {
                    PersonConstellationActivity.this.mov.setVisibility(8);
                    PersonConstellationActivity.this.mor.setVisibility(0);
                    if (PersonConstellationActivity.this.moy == 1) {
                        PersonConstellationActivity.this.mor.turnOn();
                    } else {
                        PersonConstellationActivity.this.mor.turnOff();
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
        this.moq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kPl = (TextView) this.moq.findViewById(R.id.right_textview);
        this.kPl.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.kPl.setText(getPageContext().getString(R.string.person_constellation_complete));
        ap.setViewTextColor(this.kPl, R.color.navi_op_text, 1);
        this.moq.setOnClickListener(this.mClickListener);
        this.hGK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.hGK.setOnClickListener(this.mClickListener);
        ap.setImageResource(this.hGK, R.drawable.selector_topbar_return_black);
        this.mor = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.mor.setOnSwitchStateChangeListener(this.moz);
        l.addToParentArea(getPageContext().getPageActivity(), this.mor, 10, 10, 10, 10);
        this.mos = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.mos.setOnClickListener(this.mClickListener);
        this.mot = (TextView) findViewById(R.id.constellation_name);
        this.mou = (TextView) findViewById(R.id.constellation_birthday);
        this.mow = (TextView) findViewById(R.id.birthday_label);
        this.mox = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.mov = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.mov.setVisibility(0);
            this.mor.setVisibility(8);
            return;
        }
        this.mov.setVisibility(8);
        this.mor.setVisibility(0);
        if (this.moy == 1) {
            this.mor.turnOnNoCallback();
        } else {
            this.mor.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.mot.setText(au.p(date));
        this.mou.setText(au.o(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.moy = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.moy);
        setResult(-1, intent);
        finish();
    }

    public void dzB() {
        if (this.fma == null) {
            this.fma = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.moA).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bD(View view) {
                    ap.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.fma != null) {
                                PersonConstellationActivity.this.fma.dismiss();
                            }
                        }
                    });
                    ap.setViewTextColor(textView, R.color.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    ap.setViewTextColor(textView2, R.color.CAM_X0302, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.fma != null) {
                                PersonConstellationActivity.this.fma.bJM();
                                PersonConstellationActivity.this.fma.dismiss();
                            }
                        }
                    });
                }
            }).tJ(18).a(new boolean[]{true, true, true, false, false, false}).c("年", "月", "日", "时", "分", "秒").as(2.0f).g(0, 0, 0, 0, 0, 0).ls(false).tK(ap.getColor(R.color.CAM_X0206)).tM(ap.getColor(R.color.CAM_X0105)).tN(ap.getColor(R.color.CAM_X0109)).tL(ap.getColor(R.color.black_alpha30)).tI(ap.getColor(R.color.CAM_X0201)).lr(false).G(this.mRootView).bJE();
        }
        this.fma.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mor.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setViewTextColor(this.mow, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mox, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mot, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.mou, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.mov, R.color.CAM_X0109, 1, i);
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201, i);
    }
}
