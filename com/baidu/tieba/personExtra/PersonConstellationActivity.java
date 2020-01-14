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
/* loaded from: classes9.dex */
public class PersonConstellationActivity extends BaseActivity {
    private com.baidu.tbadk.widget.timepicker.a.f.b dkH;
    private ImageView flK;
    private TextView hSW;
    private int jkA;
    private View jks;
    private BdSwitchView jkt;
    private RelativeLayout jku;
    private TextView jkv;
    private TextView jkw;
    private TextView jkx;
    private TextView jky;
    private TextView jkz;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private BdSwitchView.a jkB = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.jkA = 2;
            } else {
                PersonConstellationActivity.this.jkA = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.jks) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.flK) {
                if (view == PersonConstellationActivity.this.jku) {
                    PersonConstellationActivity.this.cuS();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e jkC = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.jkv.setText(aq.l(date));
                PersonConstellationActivity.this.jkw.setText(aq.k(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.jkt.getVisibility() != 0) {
                    PersonConstellationActivity.this.jkx.setVisibility(8);
                    PersonConstellationActivity.this.jkt.setVisibility(0);
                    if (PersonConstellationActivity.this.jkA == 1) {
                        PersonConstellationActivity.this.jkt.turnOn();
                    } else {
                        PersonConstellationActivity.this.jkt.turnOff();
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
        this.jks = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.hSW = (TextView) this.jks.findViewById(R.id.right_textview);
        this.hSW.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.hSW.setText(getPageContext().getString(R.string.person_constellation_complete));
        am.setViewTextColor(this.hSW, R.color.navi_op_text, 1);
        this.jks.setOnClickListener(this.mClickListener);
        this.flK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.flK.setOnClickListener(this.mClickListener);
        am.setImageResource(this.flK, R.drawable.selector_topbar_return_black);
        this.jkt = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.jkt.setOnSwitchStateChangeListener(this.jkB);
        l.addToParentArea(getPageContext().getPageActivity(), this.jkt, 10, 10, 10, 10);
        this.jku = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.jku.setOnClickListener(this.mClickListener);
        this.jkv = (TextView) findViewById(R.id.constellation_name);
        this.jkw = (TextView) findViewById(R.id.constellation_birthday);
        this.jky = (TextView) findViewById(R.id.birthday_label);
        this.jkz = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.jkx = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.jkx.setVisibility(0);
            this.jkt.setVisibility(8);
            return;
        }
        this.jkx.setVisibility(8);
        this.jkt.setVisibility(0);
        if (this.jkA == 1) {
            this.jkt.turnOnNoCallback();
        } else {
            this.jkt.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.jkv.setText(aq.l(date));
        this.jkw.setText(aq.k(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.jkA = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.jkA);
        setResult(-1, intent);
        finish();
    }

    public void cuS() {
        if (this.dkH == null) {
            this.dkH = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.jkC).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bc(View view) {
                    am.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.dkH != null) {
                                PersonConstellationActivity.this.dkH.dismiss();
                            }
                        }
                    });
                    am.setViewTextColor(textView, R.color.cp_cont_b, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    am.setViewTextColor(textView2, R.color.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.dkH != null) {
                                PersonConstellationActivity.this.dkH.aSG();
                                PersonConstellationActivity.this.dkH.dismiss();
                            }
                        }
                    });
                }
            }).nk(18).a(new boolean[]{true, true, true, false, false, false}).b("年", "月", "日", "时", "分", "秒").av(2.0f).g(0, 0, 0, 0, 0, 0).hi(false).nl(am.getColor(R.color.cp_bg_line_g)).nn(am.getColor(R.color.cp_cont_b)).no(am.getColor(R.color.cp_cont_d)).nm(am.getColor(R.color.black_alpha30)).nj(am.getColor(R.color.cp_bg_line_d)).hh(false).u(this.mRootView).aSy();
        }
        this.dkH.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jkt.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setViewTextColor(this.jky, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jkz, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jkv, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jkw, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.jkx, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
