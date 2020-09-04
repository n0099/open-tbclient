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
    private com.baidu.tbadk.widget.timepicker.a.f.b eCU;
    private ImageView gNp;
    private TextView jLK;
    private View ljo;
    private BdSwitchView ljp;
    private RelativeLayout ljq;
    private TextView ljr;
    private TextView ljs;
    private TextView ljt;
    private TextView lju;
    private TextView ljv;
    private int ljw;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private BdSwitchView.a ljx = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.ljw = 2;
            } else {
                PersonConstellationActivity.this.ljw = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.ljo) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.gNp) {
                if (view == PersonConstellationActivity.this.ljq) {
                    PersonConstellationActivity.this.dhL();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e ljy = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.ljr.setText(at.p(date));
                PersonConstellationActivity.this.ljs.setText(at.o(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.ljp.getVisibility() != 0) {
                    PersonConstellationActivity.this.ljt.setVisibility(8);
                    PersonConstellationActivity.this.ljp.setVisibility(0);
                    if (PersonConstellationActivity.this.ljw == 1) {
                        PersonConstellationActivity.this.ljp.turnOn();
                    } else {
                        PersonConstellationActivity.this.ljp.turnOff();
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
        this.ljo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jLK = (TextView) this.ljo.findViewById(R.id.right_textview);
        this.jLK.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.jLK.setText(getPageContext().getString(R.string.person_constellation_complete));
        ap.setViewTextColor(this.jLK, R.color.navi_op_text, 1);
        this.ljo.setOnClickListener(this.mClickListener);
        this.gNp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.gNp.setOnClickListener(this.mClickListener);
        ap.setImageResource(this.gNp, R.drawable.selector_topbar_return_black);
        this.ljp = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.ljp.setOnSwitchStateChangeListener(this.ljx);
        l.addToParentArea(getPageContext().getPageActivity(), this.ljp, 10, 10, 10, 10);
        this.ljq = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.ljq.setOnClickListener(this.mClickListener);
        this.ljr = (TextView) findViewById(R.id.constellation_name);
        this.ljs = (TextView) findViewById(R.id.constellation_birthday);
        this.lju = (TextView) findViewById(R.id.birthday_label);
        this.ljv = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.ljt = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.ljt.setVisibility(0);
            this.ljp.setVisibility(8);
            return;
        }
        this.ljt.setVisibility(8);
        this.ljp.setVisibility(0);
        if (this.ljw == 1) {
            this.ljp.turnOnNoCallback();
        } else {
            this.ljp.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.ljr.setText(at.p(date));
        this.ljs.setText(at.o(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.ljw = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.ljw);
        setResult(-1, intent);
        finish();
    }

    public void dhL() {
        if (this.eCU == null) {
            this.eCU = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.ljy).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bm(View view) {
                    ap.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.eCU != null) {
                                PersonConstellationActivity.this.eCU.dismiss();
                            }
                        }
                    });
                    ap.setViewTextColor(textView, R.color.cp_cont_b, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    ap.setViewTextColor(textView2, R.color.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.eCU != null) {
                                PersonConstellationActivity.this.eCU.byI();
                                PersonConstellationActivity.this.eCU.dismiss();
                            }
                        }
                    });
                }
            }).ry(18).a(new boolean[]{true, true, true, false, false, false}).b("年", "月", "日", "时", "分", "秒").aj(2.0f).f(0, 0, 0, 0, 0, 0).kc(false).rz(ap.getColor(R.color.cp_bg_line_g)).rB(ap.getColor(R.color.cp_cont_b)).rC(ap.getColor(R.color.cp_cont_d)).rA(ap.getColor(R.color.black_alpha30)).rx(ap.getColor(R.color.cp_bg_line_d)).kb(false).E(this.mRootView).byA();
        }
        this.eCU.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ljp.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setViewTextColor(this.lju, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.ljv, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.ljr, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.ljs, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.ljt, R.color.cp_cont_d, 1, i);
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
