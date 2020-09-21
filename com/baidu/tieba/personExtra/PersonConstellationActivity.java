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
/* loaded from: classes23.dex */
public class PersonConstellationActivity extends BaseActivity {
    private com.baidu.tbadk.widget.timepicker.a.f.b eEZ;
    private ImageView gQF;
    private TextView jUm;
    private View lsk;
    private BdSwitchView lsl;
    private RelativeLayout lsm;
    private TextView lsn;
    private TextView lso;
    private TextView lsp;
    private TextView lsq;
    private TextView lsr;
    private int lss;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private BdSwitchView.a lst = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.lss = 2;
            } else {
                PersonConstellationActivity.this.lss = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.lsk) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.gQF) {
                if (view == PersonConstellationActivity.this.lsm) {
                    PersonConstellationActivity.this.dlq();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e lsu = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.lsn.setText(at.p(date));
                PersonConstellationActivity.this.lso.setText(at.o(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.lsl.getVisibility() != 0) {
                    PersonConstellationActivity.this.lsp.setVisibility(8);
                    PersonConstellationActivity.this.lsl.setVisibility(0);
                    if (PersonConstellationActivity.this.lss == 1) {
                        PersonConstellationActivity.this.lsl.turnOn();
                    } else {
                        PersonConstellationActivity.this.lsl.turnOff();
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
        this.lsk = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jUm = (TextView) this.lsk.findViewById(R.id.right_textview);
        this.jUm.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.jUm.setText(getPageContext().getString(R.string.person_constellation_complete));
        ap.setViewTextColor(this.jUm, R.color.navi_op_text, 1);
        this.lsk.setOnClickListener(this.mClickListener);
        this.gQF = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.gQF.setOnClickListener(this.mClickListener);
        ap.setImageResource(this.gQF, R.drawable.selector_topbar_return_black);
        this.lsl = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.lsl.setOnSwitchStateChangeListener(this.lst);
        l.addToParentArea(getPageContext().getPageActivity(), this.lsl, 10, 10, 10, 10);
        this.lsm = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.lsm.setOnClickListener(this.mClickListener);
        this.lsn = (TextView) findViewById(R.id.constellation_name);
        this.lso = (TextView) findViewById(R.id.constellation_birthday);
        this.lsq = (TextView) findViewById(R.id.birthday_label);
        this.lsr = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.lsp = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.lsp.setVisibility(0);
            this.lsl.setVisibility(8);
            return;
        }
        this.lsp.setVisibility(8);
        this.lsl.setVisibility(0);
        if (this.lss == 1) {
            this.lsl.turnOnNoCallback();
        } else {
            this.lsl.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.lsn.setText(at.p(date));
        this.lso.setText(at.o(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.lss = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.lss);
        setResult(-1, intent);
        finish();
    }

    public void dlq() {
        if (this.eEZ == null) {
            this.eEZ = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.lsu).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bo(View view) {
                    ap.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.eEZ != null) {
                                PersonConstellationActivity.this.eEZ.dismiss();
                            }
                        }
                    });
                    ap.setViewTextColor(textView, R.color.cp_cont_b, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    ap.setViewTextColor(textView2, R.color.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.eEZ != null) {
                                PersonConstellationActivity.this.eEZ.bzR();
                                PersonConstellationActivity.this.eEZ.dismiss();
                            }
                        }
                    });
                }
            }).rP(18).a(new boolean[]{true, true, true, false, false, false}).b("年", "月", "日", "时", "分", "秒").aj(2.0f).f(0, 0, 0, 0, 0, 0).kd(false).rQ(ap.getColor(R.color.cp_bg_line_g)).rS(ap.getColor(R.color.cp_cont_b)).rT(ap.getColor(R.color.cp_cont_d)).rR(ap.getColor(R.color.black_alpha30)).rO(ap.getColor(R.color.cp_bg_line_d)).kc(false).F(this.mRootView).bzJ();
        }
        this.eEZ.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lsl.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setViewTextColor(this.lsq, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lsr, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lsn, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.lso, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.lsp, R.color.cp_cont_d, 1, i);
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
