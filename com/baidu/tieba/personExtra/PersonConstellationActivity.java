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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes7.dex */
public class PersonConstellationActivity extends BaseActivity {
    private com.baidu.tbadk.widget.timepicker.a.f.b fra;
    private ImageView hOg;
    private TextView kQn;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private View moY;
    private BdSwitchView moZ;
    private RelativeLayout mpa;
    private TextView mpb;
    private TextView mpc;
    private TextView mpd;
    private TextView mpe;
    private TextView mpf;
    private int mpg;
    private BdSwitchView.a mph = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.mpg = 2;
            } else {
                PersonConstellationActivity.this.mpg = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.moY) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.hOg) {
                if (view == PersonConstellationActivity.this.mpa) {
                    PersonConstellationActivity.this.dvA();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e mpi = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.mpb.setText(at.p(date));
                PersonConstellationActivity.this.mpc.setText(at.o(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.moZ.getVisibility() != 0) {
                    PersonConstellationActivity.this.mpd.setVisibility(8);
                    PersonConstellationActivity.this.moZ.setVisibility(0);
                    if (PersonConstellationActivity.this.mpg == 1) {
                        PersonConstellationActivity.this.moZ.turnOn();
                    } else {
                        PersonConstellationActivity.this.moZ.turnOff();
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
        this.moY = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kQn = (TextView) this.moY.findViewById(R.id.right_textview);
        this.kQn.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.kQn.setText(getPageContext().getString(R.string.person_constellation_complete));
        ao.setViewTextColor(this.kQn, R.color.navi_op_text, 1);
        this.moY.setOnClickListener(this.mClickListener);
        this.hOg = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.hOg.setOnClickListener(this.mClickListener);
        ao.setImageResource(this.hOg, R.drawable.selector_topbar_return_black);
        this.moZ = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.moZ.setOnSwitchStateChangeListener(this.mph);
        l.addToParentArea(getPageContext().getPageActivity(), this.moZ, 10, 10, 10, 10);
        this.mpa = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.mpa.setOnClickListener(this.mClickListener);
        this.mpb = (TextView) findViewById(R.id.constellation_name);
        this.mpc = (TextView) findViewById(R.id.constellation_birthday);
        this.mpe = (TextView) findViewById(R.id.birthday_label);
        this.mpf = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.mpd = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.mpd.setVisibility(0);
            this.moZ.setVisibility(8);
            return;
        }
        this.mpd.setVisibility(8);
        this.moZ.setVisibility(0);
        if (this.mpg == 1) {
            this.moZ.turnOnNoCallback();
        } else {
            this.moZ.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.mpb.setText(at.p(date));
        this.mpc.setText(at.o(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.mpg = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.mpg);
        setResult(-1, intent);
        finish();
    }

    public void dvA() {
        if (this.fra == null) {
            this.fra = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.mpi).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bM(View view) {
                    ao.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.fra != null) {
                                PersonConstellationActivity.this.fra.dismiss();
                            }
                        }
                    });
                    ao.setViewTextColor(textView, R.color.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    ao.setViewTextColor(textView2, R.color.CAM_X0302, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.fra != null) {
                                PersonConstellationActivity.this.fra.bIn();
                                PersonConstellationActivity.this.fra.dismiss();
                            }
                        }
                    });
                }
            }).so(18).a(new boolean[]{true, true, true, false, false, false}).d("年", "月", "日", "时", "分", "秒").au(2.0f).h(0, 0, 0, 0, 0, 0).lK(false).sp(ao.getColor(R.color.CAM_X0206)).sr(ao.getColor(R.color.CAM_X0105)).ss(ao.getColor(R.color.CAM_X0109)).sq(ao.getColor(R.color.black_alpha30)).sn(ao.getColor(R.color.CAM_X0201)).lJ(false).N(this.mRootView).bIf();
        }
        this.fra.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.moZ.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        ao.setViewTextColor(this.mpe, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mpf, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mpb, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.mpc, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.mpd, R.color.CAM_X0109, 1, i);
        ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201, i);
    }
}
