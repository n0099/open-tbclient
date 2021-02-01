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
    private ImageView hSC;
    private TextView kYp;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private View mxY;
    private BdSwitchView mxZ;
    private RelativeLayout mya;
    private TextView myb;
    private TextView myc;
    private TextView myd;
    private TextView mye;
    private TextView myf;
    private int myg;
    private BdSwitchView.a myh = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.myg = 2;
            } else {
                PersonConstellationActivity.this.myg = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.mxY) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.hSC) {
                if (view == PersonConstellationActivity.this.mya) {
                    PersonConstellationActivity.this.dxJ();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e myi = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.myb.setText(au.p(date));
                PersonConstellationActivity.this.myc.setText(au.o(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.mxZ.getVisibility() != 0) {
                    PersonConstellationActivity.this.myd.setVisibility(8);
                    PersonConstellationActivity.this.mxZ.setVisibility(0);
                    if (PersonConstellationActivity.this.myg == 1) {
                        PersonConstellationActivity.this.mxZ.turnOn();
                    } else {
                        PersonConstellationActivity.this.mxZ.turnOff();
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
        this.mxY = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kYp = (TextView) this.mxY.findViewById(R.id.right_textview);
        this.kYp.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.kYp.setText(getPageContext().getString(R.string.person_constellation_complete));
        ap.setViewTextColor(this.kYp, R.color.navi_op_text, 1);
        this.mxY.setOnClickListener(this.mClickListener);
        this.hSC = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.hSC.setOnClickListener(this.mClickListener);
        ap.setImageResource(this.hSC, R.drawable.selector_topbar_return_black);
        this.mxZ = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.mxZ.setOnSwitchStateChangeListener(this.myh);
        l.addToParentArea(getPageContext().getPageActivity(), this.mxZ, 10, 10, 10, 10);
        this.mya = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.mya.setOnClickListener(this.mClickListener);
        this.myb = (TextView) findViewById(R.id.constellation_name);
        this.myc = (TextView) findViewById(R.id.constellation_birthday);
        this.mye = (TextView) findViewById(R.id.birthday_label);
        this.myf = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.myd = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.myd.setVisibility(0);
            this.mxZ.setVisibility(8);
            return;
        }
        this.myd.setVisibility(8);
        this.mxZ.setVisibility(0);
        if (this.myg == 1) {
            this.mxZ.turnOnNoCallback();
        } else {
            this.mxZ.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.myb.setText(au.p(date));
        this.myc.setText(au.o(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.myg = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.myg);
        setResult(-1, intent);
        finish();
    }

    public void dxJ() {
        if (this.ftu == null) {
            this.ftu = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.myi).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
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
        this.mxZ.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setViewTextColor(this.mye, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.myf, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.myb, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.myc, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.myd, R.color.CAM_X0109, 1, i);
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201, i);
    }
}
