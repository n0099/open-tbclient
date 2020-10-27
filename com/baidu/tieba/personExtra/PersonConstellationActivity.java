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
    private com.baidu.tbadk.widget.timepicker.a.f.b eZC;
    private ImageView hrB;
    private TextView kvJ;
    private View lTT;
    private BdSwitchView lTU;
    private RelativeLayout lTV;
    private TextView lTW;
    private TextView lTX;
    private TextView lTY;
    private TextView lTZ;
    private TextView lUa;
    private int lUb;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private BdSwitchView.a lUc = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.lUb = 2;
            } else {
                PersonConstellationActivity.this.lUb = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.lTT) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.hrB) {
                if (view == PersonConstellationActivity.this.lTV) {
                    PersonConstellationActivity.this.dsh();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e lUd = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.lTW.setText(at.p(date));
                PersonConstellationActivity.this.lTX.setText(at.o(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.lTU.getVisibility() != 0) {
                    PersonConstellationActivity.this.lTY.setVisibility(8);
                    PersonConstellationActivity.this.lTU.setVisibility(0);
                    if (PersonConstellationActivity.this.lUb == 1) {
                        PersonConstellationActivity.this.lTU.turnOn();
                    } else {
                        PersonConstellationActivity.this.lTU.turnOff();
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
        this.lTT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kvJ = (TextView) this.lTT.findViewById(R.id.right_textview);
        this.kvJ.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.kvJ.setText(getPageContext().getString(R.string.person_constellation_complete));
        ap.setViewTextColor(this.kvJ, R.color.navi_op_text, 1);
        this.lTT.setOnClickListener(this.mClickListener);
        this.hrB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.hrB.setOnClickListener(this.mClickListener);
        ap.setImageResource(this.hrB, R.drawable.selector_topbar_return_black);
        this.lTU = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.lTU.setOnSwitchStateChangeListener(this.lUc);
        l.addToParentArea(getPageContext().getPageActivity(), this.lTU, 10, 10, 10, 10);
        this.lTV = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.lTV.setOnClickListener(this.mClickListener);
        this.lTW = (TextView) findViewById(R.id.constellation_name);
        this.lTX = (TextView) findViewById(R.id.constellation_birthday);
        this.lTZ = (TextView) findViewById(R.id.birthday_label);
        this.lUa = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.lTY = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.lTY.setVisibility(0);
            this.lTU.setVisibility(8);
            return;
        }
        this.lTY.setVisibility(8);
        this.lTU.setVisibility(0);
        if (this.lUb == 1) {
            this.lTU.turnOnNoCallback();
        } else {
            this.lTU.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.lTW.setText(at.p(date));
        this.lTX.setText(at.o(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.lUb = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.lUb);
        setResult(-1, intent);
        finish();
    }

    public void dsh() {
        if (this.eZC == null) {
            this.eZC = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.lUd).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bt(View view) {
                    ap.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.eZC != null) {
                                PersonConstellationActivity.this.eZC.dismiss();
                            }
                        }
                    });
                    ap.setViewTextColor(textView, R.color.cp_cont_b, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    ap.setViewTextColor(textView2, R.color.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.eZC != null) {
                                PersonConstellationActivity.this.eZC.bEu();
                                PersonConstellationActivity.this.eZC.dismiss();
                            }
                        }
                    });
                }
            }).sy(18).a(new boolean[]{true, true, true, false, false, false}).c("年", "月", "日", "时", "分", "秒").an(2.0f).f(0, 0, 0, 0, 0, 0).kO(false).sz(ap.getColor(R.color.cp_bg_line_g)).sB(ap.getColor(R.color.cp_cont_b)).sC(ap.getColor(R.color.cp_cont_d)).sA(ap.getColor(R.color.black_alpha30)).sx(ap.getColor(R.color.cp_bg_line_d)).kN(false).I(this.mRootView).bEm();
        }
        this.eZC.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lTU.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setViewTextColor(this.lTZ, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lUa, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lTW, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.lTX, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.lTY, R.color.cp_cont_d, 1, i);
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
