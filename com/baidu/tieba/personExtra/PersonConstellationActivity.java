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
    private com.baidu.tbadk.widget.timepicker.a.f.b dPh;
    private ImageView fTw;
    private TextView iGz;
    private View jXn;
    private BdSwitchView jXo;
    private RelativeLayout jXp;
    private TextView jXq;
    private TextView jXr;
    private TextView jXs;
    private TextView jXt;
    private TextView jXu;
    private int jXv;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private BdSwitchView.a jXw = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.jXv = 2;
            } else {
                PersonConstellationActivity.this.jXv = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.jXn) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.fTw) {
                if (view == PersonConstellationActivity.this.jXp) {
                    PersonConstellationActivity.this.cHs();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e jXx = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.jXq.setText(aq.l(date));
                PersonConstellationActivity.this.jXr.setText(aq.k(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.jXo.getVisibility() != 0) {
                    PersonConstellationActivity.this.jXs.setVisibility(8);
                    PersonConstellationActivity.this.jXo.setVisibility(0);
                    if (PersonConstellationActivity.this.jXv == 1) {
                        PersonConstellationActivity.this.jXo.turnOn();
                    } else {
                        PersonConstellationActivity.this.jXo.turnOff();
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
        this.jXn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.iGz = (TextView) this.jXn.findViewById(R.id.right_textview);
        this.iGz.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.iGz.setText(getPageContext().getString(R.string.person_constellation_complete));
        am.setViewTextColor(this.iGz, R.color.navi_op_text, 1);
        this.jXn.setOnClickListener(this.mClickListener);
        this.fTw = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.fTw.setOnClickListener(this.mClickListener);
        am.setImageResource(this.fTw, R.drawable.selector_topbar_return_black);
        this.jXo = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.jXo.setOnSwitchStateChangeListener(this.jXw);
        l.addToParentArea(getPageContext().getPageActivity(), this.jXo, 10, 10, 10, 10);
        this.jXp = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.jXp.setOnClickListener(this.mClickListener);
        this.jXq = (TextView) findViewById(R.id.constellation_name);
        this.jXr = (TextView) findViewById(R.id.constellation_birthday);
        this.jXt = (TextView) findViewById(R.id.birthday_label);
        this.jXu = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.jXs = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.jXs.setVisibility(0);
            this.jXo.setVisibility(8);
            return;
        }
        this.jXs.setVisibility(8);
        this.jXo.setVisibility(0);
        if (this.jXv == 1) {
            this.jXo.turnOnNoCallback();
        } else {
            this.jXo.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.jXq.setText(aq.l(date));
        this.jXr.setText(aq.k(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.jXv = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.jXv);
        setResult(-1, intent);
        finish();
    }

    public void cHs() {
        if (this.dPh == null) {
            this.dPh = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.jXx).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bd(View view) {
                    am.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.dPh != null) {
                                PersonConstellationActivity.this.dPh.dismiss();
                            }
                        }
                    });
                    am.setViewTextColor(textView, R.color.cp_cont_b, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    am.setViewTextColor(textView2, R.color.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.dPh != null) {
                                PersonConstellationActivity.this.dPh.bdo();
                                PersonConstellationActivity.this.dPh.dismiss();
                            }
                        }
                    });
                }
            }).nQ(18).a(new boolean[]{true, true, true, false, false, false}).b("年", "月", "日", "时", "分", "秒").ae(2.0f).g(0, 0, 0, 0, 0, 0).io(false).nR(am.getColor(R.color.cp_bg_line_g)).nT(am.getColor(R.color.cp_cont_b)).nU(am.getColor(R.color.cp_cont_d)).nS(am.getColor(R.color.black_alpha30)).nP(am.getColor(R.color.cp_bg_line_d)).in(false).w(this.mRootView).bdg();
        }
        this.dPh.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jXo.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setViewTextColor(this.jXt, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jXu, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jXq, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jXr, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jXs, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
