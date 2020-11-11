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
    private com.baidu.tbadk.widget.timepicker.a.f.b fft;
    private ImageView hxy;
    private TextView kBE;
    private View lZP;
    private BdSwitchView lZQ;
    private RelativeLayout lZR;
    private TextView lZS;
    private TextView lZT;
    private TextView lZU;
    private TextView lZV;
    private TextView lZW;
    private int lZX;
    private long mBirthdayTime;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private BdSwitchView.a lZY = new BdSwitchView.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.1
        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
        public void a(View view, BdSwitchView.SwitchState switchState) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                PersonConstellationActivity.this.lZX = 2;
            } else {
                PersonConstellationActivity.this.lZX = 1;
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PersonConstellationActivity.this.lZP) {
                PersonConstellationActivity.this.finishActivity();
            } else if (view != PersonConstellationActivity.this.hxy) {
                if (view == PersonConstellationActivity.this.lZR) {
                    PersonConstellationActivity.this.duJ();
                }
            } else {
                PersonConstellationActivity.this.finish();
            }
        }
    };
    private com.baidu.tbadk.widget.timepicker.a.d.e lZZ = new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.4
        @Override // com.baidu.tbadk.widget.timepicker.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                if (date.getTime() > System.currentTimeMillis()) {
                    PersonConstellationActivity.this.showToast(R.string.person_center_birthday_time_limit);
                    return;
                }
                PersonConstellationActivity.this.lZS.setText(at.p(date));
                PersonConstellationActivity.this.lZT.setText(at.o(date));
                PersonConstellationActivity.this.mBirthdayTime = date.getTime() / 1000;
                if (PersonConstellationActivity.this.lZQ.getVisibility() != 0) {
                    PersonConstellationActivity.this.lZU.setVisibility(8);
                    PersonConstellationActivity.this.lZQ.setVisibility(0);
                    if (PersonConstellationActivity.this.lZX == 1) {
                        PersonConstellationActivity.this.lZQ.turnOn();
                    } else {
                        PersonConstellationActivity.this.lZQ.turnOff();
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
        this.lZP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kBE = (TextView) this.lZP.findViewById(R.id.right_textview);
        this.kBE.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
        this.kBE.setText(getPageContext().getString(R.string.person_constellation_complete));
        ap.setViewTextColor(this.kBE, R.color.navi_op_text, 1);
        this.lZP.setOnClickListener(this.mClickListener);
        this.hxy = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.hxy.setOnClickListener(this.mClickListener);
        ap.setImageResource(this.hxy, R.drawable.selector_topbar_return_black);
        this.lZQ = (BdSwitchView) findViewById(R.id.person_constellation_switch);
        this.lZQ.setOnSwitchStateChangeListener(this.lZY);
        l.addToParentArea(getPageContext().getPageActivity(), this.lZQ, 10, 10, 10, 10);
        this.lZR = (RelativeLayout) findViewById(R.id.person_constellation_birthday);
        this.lZR.setOnClickListener(this.mClickListener);
        this.lZS = (TextView) findViewById(R.id.constellation_name);
        this.lZT = (TextView) findViewById(R.id.constellation_birthday);
        this.lZV = (TextView) findViewById(R.id.birthday_label);
        this.lZW = (TextView) findViewById(R.id.person_constellation_permission_label);
        this.lZU = (TextView) findViewById(R.id.person_constellation_tip);
        if (this.mBirthdayTime == 0) {
            this.lZU.setVisibility(0);
            this.lZQ.setVisibility(8);
            return;
        }
        this.lZU.setVisibility(8);
        this.lZQ.setVisibility(0);
        if (this.lZX == 1) {
            this.lZQ.turnOnNoCallback();
        } else {
            this.lZQ.turnOffNoCallback();
        }
        Date date = new Date(this.mBirthdayTime * 1000);
        this.lZS.setText(at.p(date));
        this.lZT.setText(at.o(date));
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mBirthdayTime = intent.getLongExtra("constellation_birthday", 0L);
            this.lZX = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("constellation_birthday", this.mBirthdayTime);
        intent.putExtra("constellation_show_status", this.lZX);
        setResult(-1, intent);
        finish();
    }

    public void duJ() {
        if (this.fft == null) {
            this.fft = new com.baidu.tbadk.widget.timepicker.a.b.a(getActivity(), this.lZZ).a(R.layout.person_birthday_select_layout, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3
                @Override // com.baidu.tbadk.widget.timepicker.a.d.a
                public void bx(View view) {
                    ap.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                    TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.fft != null) {
                                PersonConstellationActivity.this.fft.dismiss();
                            }
                        }
                    });
                    ap.setViewTextColor(textView, R.color.cp_cont_b, 1, TbadkCoreApplication.getInst().getSkinType());
                    TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                    ap.setViewTextColor(textView2, R.color.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonConstellationActivity.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PersonConstellationActivity.this.fft != null) {
                                PersonConstellationActivity.this.fft.bGT();
                                PersonConstellationActivity.this.fft.dismiss();
                            }
                        }
                    });
                }
            }).sI(18).a(new boolean[]{true, true, true, false, false, false}).c("年", "月", "日", "时", "分", "秒").ap(2.0f).f(0, 0, 0, 0, 0, 0).kX(false).sJ(ap.getColor(R.color.cp_bg_line_g)).sL(ap.getColor(R.color.cp_cont_b)).sM(ap.getColor(R.color.cp_cont_d)).sK(ap.getColor(R.color.black_alpha30)).sH(ap.getColor(R.color.cp_bg_line_d)).kW(false).K(this.mRootView).bGL();
        }
        this.fft.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lZQ.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setViewTextColor(this.lZV, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lZW, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lZS, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.lZT, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.lZU, R.color.cp_cont_d, 1, i);
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
