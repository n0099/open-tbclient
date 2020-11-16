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
/* loaded from: classes23.dex */
public class PersonConstellationActivity extends BaseActivity {
    private com.baidu.tbadk.widget.timepicker.a.f.b feB;
    private ImageView hxf;
    private TextView kBT;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private View mai;
    private BdSwitchView maj;
    private RelativeLayout mak;
    private TextView mal;
    private TextView mam;
    private TextView man;
    private TextView mao;
    private TextView maq;
    private int mar;
    private BdSwitchView.a mas = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.mar = 2;
            } else {
                PersonConstellationActivity.this.mar = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.mai) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.hxf) {
                if (view == PersonConstellationActivity.this.mak) {
                    PersonConstellationActivity.this.duj();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e mat = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.mal.setText(au.p(date));
                PersonConstellationActivity.this.mam.setText(au.o(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.maj.getVisibility() != 0) {
                    PersonConstellationActivity.this.man.setVisibility(8);
                    PersonConstellationActivity.this.maj.setVisibility(0);
                    if (PersonConstellationActivity.this.mar == 1) {
                        PersonConstellationActivity.this.maj.turnOn();
                    } else {
                        PersonConstellationActivity.this.maj.turnOff();
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
        this.mai = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kBT = (TextView) this.mai.findViewById(R.id.right_textview);
        this.kBT.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.kBT.setText(getPageContext().getString(R.string.person_constellation_complete));
        ap.setViewTextColor(this.kBT, R.color.navi_op_text, 1);
        this.mai.setOnClickListener(this.mClickListener);
        this.hxf = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.hxf.setOnClickListener(this.mClickListener);
        ap.setImageResource(this.hxf, R.drawable.selector_topbar_return_black);
        this.maj = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.maj.setOnSwitchStateChangeListener(this.mas);
        l.addToParentArea(getPageContext().getPageActivity(), this.maj, 10, 10, 10, 10);
        this.mak = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.mak.setOnClickListener(this.mClickListener);
        this.mal = (TextView) findViewById(R.id.constellation_name);
        this.mam = (TextView) findViewById(R.id.constellation_birthday);
        this.mao = (TextView) findViewById(R.id.birthday_label);
        this.maq = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.man = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.man.setVisibility(0);
            this.maj.setVisibility(8);
            return;
        }
        this.man.setVisibility(8);
        this.maj.setVisibility(0);
        if (this.mar == 1) {
            this.maj.turnOnNoCallback();
        } else {
            this.maj.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.mal.setText(au.p(date));
        this.mam.setText(au.o(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.mar = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.mar);
        setResult(-1, intent);
        finish();
    }

    public void duj() {
        if (this.feB == null) {
            this.feB = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.mat).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bA(View view) {
                    ap.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.feB != null) {
                                PersonConstellationActivity.this.feB.dismiss();
                            }
                        }
                    });
                    ap.setViewTextColor(textView, R.color.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    ap.setViewTextColor(textView2, R.color.CAM_X0302, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.feB != null) {
                                PersonConstellationActivity.this.feB.bGm();
                                PersonConstellationActivity.this.feB.dismiss();
                            }
                        }
                    });
                }
            }).tg(18).a(new boolean[]{true, true, true, false, false, false}).c("年", "月", "日", "时", "分", "秒").ar(2.0f).f(0, 0, 0, 0, 0, 0).kY(false).th(ap.getColor(R.color.CAM_X0206)).tj(ap.getColor(R.color.CAM_X0105)).tk(ap.getColor(R.color.CAM_X0109)).ti(ap.getColor(R.color.black_alpha30)).tf(ap.getColor(R.color.CAM_X0201)).kX(false).G(this.mRootView).bGe();
        }
        this.feB.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.maj.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setViewTextColor(this.mao, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.maq, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mal, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.mam, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.man, R.color.CAM_X0109, 1, i);
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201, i);
    }
}
