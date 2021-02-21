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
/* loaded from: classes8.dex */
public class PersonConstellationActivity extends BaseActivity {
    private com.baidu.tbadk.widget.timepicker.a.f.b ftu;
    private ImageView hSQ;
    private TextView kYD;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private View myn;
    private BdSwitchView myo;
    private RelativeLayout myp;
    private TextView myq;
    private TextView myr;
    private TextView mys;
    private TextView myt;
    private TextView myu;
    private int myv;
    private BdSwitchView.a myw = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.myv = 2;
            } else {
                PersonConstellationActivity.this.myv = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.myn) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.hSQ) {
                if (view == PersonConstellationActivity.this.myp) {
                    PersonConstellationActivity.this.dxQ();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e myx = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.myq.setText(au.p(date));
                PersonConstellationActivity.this.myr.setText(au.o(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.myo.getVisibility() != 0) {
                    PersonConstellationActivity.this.mys.setVisibility(8);
                    PersonConstellationActivity.this.myo.setVisibility(0);
                    if (PersonConstellationActivity.this.myv == 1) {
                        PersonConstellationActivity.this.myo.turnOn();
                    } else {
                        PersonConstellationActivity.this.myo.turnOff();
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
        this.myn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kYD = (TextView) this.myn.findViewById(R.id.right_textview);
        this.kYD.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.kYD.setText(getPageContext().getString(R.string.person_constellation_complete));
        ap.setViewTextColor(this.kYD, R.color.navi_op_text, 1);
        this.myn.setOnClickListener(this.mClickListener);
        this.hSQ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.hSQ.setOnClickListener(this.mClickListener);
        ap.setImageResource(this.hSQ, R.drawable.selector_topbar_return_black);
        this.myo = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.myo.setOnSwitchStateChangeListener(this.myw);
        l.addToParentArea(getPageContext().getPageActivity(), this.myo, 10, 10, 10, 10);
        this.myp = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.myp.setOnClickListener(this.mClickListener);
        this.myq = (TextView) findViewById(R.id.constellation_name);
        this.myr = (TextView) findViewById(R.id.constellation_birthday);
        this.myt = (TextView) findViewById(R.id.birthday_label);
        this.myu = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.mys = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.mys.setVisibility(0);
            this.myo.setVisibility(8);
            return;
        }
        this.mys.setVisibility(8);
        this.myo.setVisibility(0);
        if (this.myv == 1) {
            this.myo.turnOnNoCallback();
        } else {
            this.myo.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.myq.setText(au.p(date));
        this.myr.setText(au.o(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.myv = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.myv);
        setResult(-1, intent);
        finish();
    }

    public void dxQ() {
        if (this.ftu == null) {
            this.ftu = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.myx).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bI(View view) {
                    ap.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.ftu != null) {
                                PersonConstellationActivity.this.ftu.dismiss();
                            }
                        }
                    });
                    ap.setViewTextColor(textView, R.color.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    ap.setViewTextColor(textView2, R.color.CAM_X0302, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.ftu != null) {
                                PersonConstellationActivity.this.ftu.bIG();
                                PersonConstellationActivity.this.ftu.dismiss();
                            }
                        }
                    });
                }
            }).st(18).a(new boolean[]{true, true, true, false, false, false}).d("年", "月", "日", "时", "分", "秒").av(2.0f).h(0, 0, 0, 0, 0, 0).lO(false).su(ap.getColor(R.color.CAM_X0206)).sw(ap.getColor(R.color.CAM_X0105)).sx(ap.getColor(R.color.CAM_X0109)).sv(ap.getColor(R.color.black_alpha30)).ss(ap.getColor(R.color.CAM_X0201)).lN(false).L(this.mRootView).bIy();
        }
        this.ftu.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.myo.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setViewTextColor(this.myt, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.myu, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.myq, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.myr, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.mys, R.color.CAM_X0109, 1, i);
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201, i);
    }
}
