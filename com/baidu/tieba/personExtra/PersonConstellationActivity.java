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
    private com.baidu.tbadk.widget.timepicker.a.f.b doO;
    private ImageView fon;
    private TextView hUU;
    private View jll;
    private BdSwitchView jlm;
    private RelativeLayout jln;
    private TextView jlo;
    private TextView jlp;
    private TextView jlq;
    private TextView jlr;
    private TextView jls;
    private int jlt;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private BdSwitchView.a jlu = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.jlt = 2;
            } else {
                PersonConstellationActivity.this.jlt = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.jll) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.fon) {
                if (view == PersonConstellationActivity.this.jln) {
                    PersonConstellationActivity.this.cwl();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e jlv = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.jlo.setText(aq.l(date));
                PersonConstellationActivity.this.jlp.setText(aq.k(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.jlm.getVisibility() != 0) {
                    PersonConstellationActivity.this.jlq.setVisibility(8);
                    PersonConstellationActivity.this.jlm.setVisibility(0);
                    if (PersonConstellationActivity.this.jlt == 1) {
                        PersonConstellationActivity.this.jlm.turnOn();
                    } else {
                        PersonConstellationActivity.this.jlm.turnOff();
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
        this.jll = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.hUU = (TextView) this.jll.findViewById(R.id.right_textview);
        this.hUU.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.hUU.setText(getPageContext().getString(R.string.person_constellation_complete));
        am.setViewTextColor(this.hUU, R.color.navi_op_text, 1);
        this.jll.setOnClickListener(this.mClickListener);
        this.fon = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.fon.setOnClickListener(this.mClickListener);
        am.setImageResource(this.fon, R.drawable.selector_topbar_return_black);
        this.jlm = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.jlm.setOnSwitchStateChangeListener(this.jlu);
        l.addToParentArea(getPageContext().getPageActivity(), this.jlm, 10, 10, 10, 10);
        this.jln = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.jln.setOnClickListener(this.mClickListener);
        this.jlo = (TextView) findViewById(R.id.constellation_name);
        this.jlp = (TextView) findViewById(R.id.constellation_birthday);
        this.jlr = (TextView) findViewById(R.id.birthday_label);
        this.jls = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.jlq = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.jlq.setVisibility(0);
            this.jlm.setVisibility(8);
            return;
        }
        this.jlq.setVisibility(8);
        this.jlm.setVisibility(0);
        if (this.jlt == 1) {
            this.jlm.turnOnNoCallback();
        } else {
            this.jlm.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.jlo.setText(aq.l(date));
        this.jlp.setText(aq.k(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.jlt = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.jlt);
        setResult(-1, intent);
        finish();
    }

    public void cwl() {
        if (this.doO == null) {
            this.doO = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.jlv).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bc(View view) {
                    am.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.doO != null) {
                                PersonConstellationActivity.this.doO.dismiss();
                            }
                        }
                    });
                    am.setViewTextColor(textView, R.color.cp_cont_b, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    am.setViewTextColor(textView2, R.color.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.doO != null) {
                                PersonConstellationActivity.this.doO.aUX();
                                PersonConstellationActivity.this.doO.dismiss();
                            }
                        }
                    });
                }
            }).nB(18).a(new boolean[]{true, true, true, false, false, false}).b("年", "月", "日", "时", "分", "秒").au(2.0f).g(0, 0, 0, 0, 0, 0).hp(false).nC(am.getColor(R.color.cp_bg_line_g)).nE(am.getColor(R.color.cp_cont_b)).nF(am.getColor(R.color.cp_cont_d)).nD(am.getColor(R.color.black_alpha30)).nA(am.getColor(R.color.cp_bg_line_d)).ho(false).v(this.mRootView).aUP();
        }
        this.doO.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jlm.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setViewTextColor(this.jlr, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jls, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jlo, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jlp, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jlq, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
