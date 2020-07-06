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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes11.dex */
public class PersonConstellationActivity extends BaseActivity {
    private com.baidu.tbadk.widget.timepicker.a.f.b eml;
    private ImageView gvr;
    private TextView jnD;
    private View kKo;
    private BdSwitchView kKp;
    private RelativeLayout kKq;
    private TextView kKr;
    private TextView kKs;
    private TextView kKt;
    private TextView kKu;
    private TextView kKv;
    private int kKw;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private BdSwitchView.a kKx = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.kKw = 2;
            } else {
                PersonConstellationActivity.this.kKw = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.kKo) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.gvr) {
                if (view == PersonConstellationActivity.this.kKq) {
                    PersonConstellationActivity.this.cSX();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e kKy = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.kKr.setText(ar.m(date));
                PersonConstellationActivity.this.kKs.setText(ar.l(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.kKp.getVisibility() != 0) {
                    PersonConstellationActivity.this.kKt.setVisibility(8);
                    PersonConstellationActivity.this.kKp.setVisibility(0);
                    if (PersonConstellationActivity.this.kKw == 1) {
                        PersonConstellationActivity.this.kKp.turnOn();
                    } else {
                        PersonConstellationActivity.this.kKp.turnOff();
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
        this.kKo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jnD = (TextView) this.kKo.findViewById(R.id.right_textview);
        this.jnD.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.jnD.setText(getPageContext().getString(R.string.person_constellation_complete));
        an.setViewTextColor(this.jnD, R.color.navi_op_text, 1);
        this.kKo.setOnClickListener(this.mClickListener);
        this.gvr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.gvr.setOnClickListener(this.mClickListener);
        an.setImageResource(this.gvr, R.drawable.selector_topbar_return_black);
        this.kKp = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.kKp.setOnSwitchStateChangeListener(this.kKx);
        l.addToParentArea(getPageContext().getPageActivity(), this.kKp, 10, 10, 10, 10);
        this.kKq = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.kKq.setOnClickListener(this.mClickListener);
        this.kKr = (TextView) findViewById(R.id.constellation_name);
        this.kKs = (TextView) findViewById(R.id.constellation_birthday);
        this.kKu = (TextView) findViewById(R.id.birthday_label);
        this.kKv = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.kKt = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.kKt.setVisibility(0);
            this.kKp.setVisibility(8);
            return;
        }
        this.kKt.setVisibility(8);
        this.kKp.setVisibility(0);
        if (this.kKw == 1) {
            this.kKp.turnOnNoCallback();
        } else {
            this.kKp.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.kKr.setText(ar.m(date));
        this.kKs.setText(ar.l(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.kKw = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.kKw);
        setResult(-1, intent);
        finish();
    }

    public void cSX() {
        if (this.eml == null) {
            this.eml = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.kKy).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void be(View view) {
                    an.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.eml != null) {
                                PersonConstellationActivity.this.eml.dismiss();
                            }
                        }
                    });
                    an.setViewTextColor(textView, R.color.cp_cont_b, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    an.setViewTextColor(textView2, R.color.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.eml != null) {
                                PersonConstellationActivity.this.eml.blZ();
                                PersonConstellationActivity.this.eml.dismiss();
                            }
                        }
                    });
                }
            }).oV(18).a(new boolean[]{true, true, true, false, false, false}).b("年", "月", "日", "时", "分", "秒").ae(2.0f).g(0, 0, 0, 0, 0, 0).iX(false).oW(an.getColor(R.color.cp_bg_line_g)).oY(an.getColor(R.color.cp_cont_b)).oZ(an.getColor(R.color.cp_cont_d)).oX(an.getColor(R.color.black_alpha30)).oU(an.getColor(R.color.cp_bg_line_d)).iW(false).C(this.mRootView).blR();
        }
        this.eml.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kKp.setBackgroundRes(an.getBitmap(R.drawable.bg_switch_open), an.getBitmap(R.drawable.bg_switch_close), an.getBitmap(R.drawable.btn_handle));
        an.setViewTextColor(this.kKu, R.color.cp_cont_b, 1, i);
        an.setViewTextColor(this.kKv, R.color.cp_cont_b, 1, i);
        an.setViewTextColor(this.kKr, R.color.cp_cont_d, 1, i);
        an.setViewTextColor(this.kKs, R.color.cp_cont_d, 1, i);
        an.setViewTextColor(this.kKt, R.color.cp_cont_d, 1, i);
        an.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
