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
/* loaded from: classes24.dex */
public class PersonConstellationActivity extends BaseActivity {
    private com.baidu.tbadk.widget.timepicker.a.f.b eRg;
    private ImageView hfC;
    private TextView kjm;
    private TextView lHA;
    private TextView lHB;
    private TextView lHC;
    private TextView lHD;
    private TextView lHE;
    private int lHF;
    private View lHx;
    private BdSwitchView lHy;
    private RelativeLayout lHz;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private BdSwitchView.a lHG = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.lHF = 2;
            } else {
                PersonConstellationActivity.this.lHF = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.lHx) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.hfC) {
                if (view == PersonConstellationActivity.this.lHz) {
                    PersonConstellationActivity.this.dpa();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e lHH = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.lHA.setText(at.p(date));
                PersonConstellationActivity.this.lHB.setText(at.o(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.lHy.getVisibility() != 0) {
                    PersonConstellationActivity.this.lHC.setVisibility(8);
                    PersonConstellationActivity.this.lHy.setVisibility(0);
                    if (PersonConstellationActivity.this.lHF == 1) {
                        PersonConstellationActivity.this.lHy.turnOn();
                    } else {
                        PersonConstellationActivity.this.lHy.turnOff();
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
        this.lHx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kjm = (TextView) this.lHx.findViewById(R.id.right_textview);
        this.kjm.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.kjm.setText(getPageContext().getString(R.string.person_constellation_complete));
        ap.setViewTextColor(this.kjm, R.color.navi_op_text, 1);
        this.lHx.setOnClickListener(this.mClickListener);
        this.hfC = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.hfC.setOnClickListener(this.mClickListener);
        ap.setImageResource(this.hfC, R.drawable.selector_topbar_return_black);
        this.lHy = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.lHy.setOnSwitchStateChangeListener(this.lHG);
        l.addToParentArea(getPageContext().getPageActivity(), this.lHy, 10, 10, 10, 10);
        this.lHz = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.lHz.setOnClickListener(this.mClickListener);
        this.lHA = (TextView) findViewById(R.id.constellation_name);
        this.lHB = (TextView) findViewById(R.id.constellation_birthday);
        this.lHD = (TextView) findViewById(R.id.birthday_label);
        this.lHE = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.lHC = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.lHC.setVisibility(0);
            this.lHy.setVisibility(8);
            return;
        }
        this.lHC.setVisibility(8);
        this.lHy.setVisibility(0);
        if (this.lHF == 1) {
            this.lHy.turnOnNoCallback();
        } else {
            this.lHy.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.lHA.setText(at.p(date));
        this.lHB.setText(at.o(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.lHF = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.lHF);
        setResult(-1, intent);
        finish();
    }

    public void dpa() {
        if (this.eRg == null) {
            this.eRg = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.lHH).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bs(View view) {
                    ap.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.eRg != null) {
                                PersonConstellationActivity.this.eRg.dismiss();
                            }
                        }
                    });
                    ap.setViewTextColor(textView, R.color.cp_cont_b, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    ap.setViewTextColor(textView2, R.color.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.eRg != null) {
                                PersonConstellationActivity.this.eRg.bCB();
                                PersonConstellationActivity.this.eRg.dismiss();
                            }
                        }
                    });
                }
            }).sn(18).a(new boolean[]{true, true, true, false, false, false}).b("年", "月", "日", "时", "分", "秒").al(2.0f).f(0, 0, 0, 0, 0, 0).kB(false).so(ap.getColor(R.color.cp_bg_line_g)).sq(ap.getColor(R.color.cp_cont_b)).sr(ap.getColor(R.color.cp_cont_d)).sp(ap.getColor(R.color.black_alpha30)).sm(ap.getColor(R.color.cp_bg_line_d)).kA(false).H(this.mRootView).bCt();
        }
        this.eRg.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lHy.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setViewTextColor(this.lHD, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lHE, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lHA, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.lHB, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.lHC, R.color.cp_cont_d, 1, i);
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
