package com.baidu.tieba.pb.pb.main.view;

import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.pb.main.ak;
/* loaded from: classes22.dex */
public class c {
    private ImageView agS;
    public TextView eWM;
    public final View fxJ;
    private ImageView gFB;
    private final ImageView kdr;
    private final LinearLayout kds;
    public TextView lHn;
    public View lHo;
    public LinearLayout lHp;
    public BarImageView lHq;
    private PopupWindow lHu;
    private int lHv;
    private int lHw;
    private int lHx;
    private int lHy;
    private PbFragment lpI;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private boolean lCx = false;
    private AlertDialog lHr = null;
    private aj lHs = null;
    private boolean lHt = false;
    private boolean lHz = true;
    private Runnable jkr = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.cGC();
        }
    };
    private View.OnClickListener jks = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dpn();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.lHv = 0;
        this.lHw = 0;
        this.lHx = 0;
        this.lHy = 0;
        this.lpI = pbFragment;
        this.lHv = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.lHw = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.lHx = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.lHx - dimens > 0) {
            this.lHx -= dimens;
        }
        this.lHy = (equipmentWidth - (this.lHx * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.lpI.cyL();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.fxJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.iKb);
        this.lHn = this.mNavigationBar.setCenterTextTitle("");
        this.kdr = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.kds = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.kds.setPadding(dimens2, 0, dimens2, 0);
        ap.setNavbarIconSrc(this.kdr, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.kdr.setVisibility(8);
        this.lHn.setOnClickListener(pbFragment.iKb);
        this.kdr.setOnClickListener(pbFragment.iKb);
        this.gFB = (ImageView) this.fxJ.findViewById(R.id.widget_navi_back_button);
        if (this.lHp == null) {
            this.lHp = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.lHq = (BarImageView) this.lHp.findViewById(R.id.pb_nav_title_forum_image);
            this.lHq.setShowOval(true);
            this.lHq.setOnClickListener(pbFragment.iKb);
            this.eWM = (TextView) this.lHp.findViewById(R.id.pb_nav_title_forum_name);
            this.eWM.setOnClickListener(pbFragment.iKb);
            if (this.lHp.getLayoutParams() != null && (this.lHp.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.lHx > 0 && this.lHy > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lHp.getLayoutParams();
                marginLayoutParams.leftMargin = this.lHx;
                marginLayoutParams.rightMargin = this.lHx;
                this.lHp.setLayoutParams(marginLayoutParams);
            }
            if (this.lHp.getVisibility() == 8) {
                this.lHp.setVisibility(0);
            }
            if (this.lHp.getAlpha() != 1.0f) {
                this.lHp.setAlpha(1.0f);
            }
        }
    }

    public void vf(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.lCx = z;
        if (this.lHo == null && this.agS == null) {
            this.lHo = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.lpI.iKb);
            this.agS = (ImageView) this.lHo.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.lHv, this.lHv);
            layoutParams.rightMargin = this.lHw;
            this.lHo.setLayoutParams(layoutParams);
            SvgManager.brn().a(this.agS, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.lHo.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void uK(boolean z) {
        if (this.lHo != null) {
            this.lHo.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar dpf() {
        return this.mNavigationBar;
    }

    public void vg(boolean z) {
        if (z) {
            this.fxJ.setVisibility(0);
        } else {
            this.fxJ.setVisibility(8);
        }
        vi(z);
    }

    public void NF(String str) {
        if (!TextUtils.isEmpty(str) && !this.lCx) {
            this.lHn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            vi(true);
            k.bjH().setForumNameForWaterImage(str);
            return;
        }
        vi(false);
    }

    public void a(ak akVar) {
        if (!this.lpI.getBaseFragmentActivity().isProgressBarShown()) {
            this.lHs = new aj(this.lpI, this.lpI.iKb);
            this.lHr = new AlertDialog.Builder(this.lpI.getContext(), R.style.DialogTheme).create();
            this.lHr.setCanceledOnTouchOutside(true);
            g.showDialog(this.lHr, this.lpI.getFragmentActivity());
            Window window = this.lHr.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.lHs.getView());
            this.lHs.uz(akVar == null ? false : akVar.lze);
            this.lHs.uA(akVar == null ? false : akVar.lzi);
            this.lHs.uB(akVar == null ? false : akVar.lzm);
            this.lHs.uD(akVar == null ? false : akVar.lzj);
            this.lHs.uE(akVar == null ? true : akVar.lzg);
            if (akVar == null) {
                this.lHs.ao(false, false);
                this.lHs.ap(false, false);
            } else {
                this.lHs.ao(akVar.lzk, akVar.lzq);
                this.lHs.ap(akVar.lzl, akVar.lzp);
            }
            boolean z = akVar == null ? false : akVar.Fc;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.lzh;
            boolean z4 = akVar == null ? false : akVar.lzf;
            boolean z5 = akVar == null ? false : akVar.lzo;
            boolean z6 = akVar == null ? false : akVar.lzn;
            this.lHs.an(z3, z2);
            this.lHs.aq(z4, z);
            this.lHs.ar(z6, z5);
            if (akVar != null) {
                this.lHs.lzb = akVar.lzr;
                if (akVar.lzr) {
                    this.lHs.dmK().setText(R.string.report_text);
                    this.lHs.uD(false);
                }
            }
            this.lHs.uC(akVar != null ? akVar.lzs : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.lpI.djz() != null && this.lpI.djz().getPbData() != null && this.lpI.djz().getPbData().getThreadId() != null && this.lpI.djz().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.lHs.dmN().setText(R.string.have_called_fans_short);
            }
            dpg();
        }
    }

    private void dpg() {
        if (this.lHs != null) {
            this.lHs.dmR();
        }
    }

    public void aZC() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.lHr != null) {
                        g.dismissDialog(c.this.lHr, c.this.lpI.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.mY().postDelayed(this.runnable, 100L);
    }

    public void dph() {
        if (this.lHr != null) {
            g.dismissDialog(this.lHr, this.lpI.getPageContext().getPageActivity());
        }
    }

    public aj dpi() {
        return this.lHs;
    }

    public View dpj() {
        return this.kdr;
    }

    public boolean dpk() {
        return this.lHr != null && this.lHr.isShowing();
    }

    public void releaseResources() {
        if (this.lHs != null) {
            this.lHs.release();
        }
        this.lHr = null;
        this.lHs = null;
        e.mY().removeCallbacks(this.runnable);
    }

    public void dpl() {
        if (this.lHo != null) {
            this.lHo.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.lpI.getPageContext(), i);
            ap.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.brn().a(this.gFB, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.brn().a(this.agS, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.lHn, R.color.cp_cont_b, R.color.s_navbar_title_color);
        ap.setViewTextColor(this.eWM, R.color.cp_cont_b);
        dpg();
    }

    public void Gl(int i) {
        this.mNavigationBar.onChangeSkinType(this.lpI.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.agS != null) {
            SvgManager.brn().a(this.agS, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.lHn.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.brn().a(this.gFB, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void dpm() {
        this.gFB.setVisibility(0);
        vi(false);
        if (this.lHo != null) {
            this.lHo.setVisibility(8);
        }
    }

    public void vh(boolean z) {
        this.gFB.setVisibility(0);
        vi(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.lHo != null) {
                this.lHo.setVisibility(0);
            }
        } else if (this.lHo != null) {
            this.lHo.setVisibility(8);
        }
    }

    public void vi(boolean z) {
        if (!this.lCx && z && !"".equals(this.lHn.getText().toString())) {
            this.lHn.setVisibility(0);
        } else {
            this.lHn.setVisibility(8);
        }
    }

    public void vj(boolean z) {
        this.lHt = z;
    }

    public void dnO() {
        if ((!this.lHt || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.lpI.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.lpI.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.lpI.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.jks);
            this.lHu = new PopupWindow(inflate, -2, -2);
        }
    }

    public void dpn() {
        if (this.jkr != null) {
            e.mY().removeCallbacks(this.jkr);
        }
        cGC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGC() {
        g.dismissPopupWindow(this.lHu);
    }

    public void dr(View view) {
    }

    public void fU(String str, String str2) {
        if (this.lpI != null && this.lHp != null) {
            if (StringUtils.isNull(str)) {
                this.lHq.setVisibility(8);
                this.eWM.setText("贴吧动态");
                return;
            }
            this.lHq.setVisibility(0);
            this.mForumName = str;
            ay.a(this.eWM, str, R.string.forum, R.dimen.tbds0, 1, this.lHy, false);
            k.bjH().setForumNameForWaterImage(str);
            this.lHq.startLoad(str2, 10, false);
        }
    }
}
