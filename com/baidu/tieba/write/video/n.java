package com.baidu.tieba.write.video;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class n {
    public static int fPw = 31;
    private static int fPx = -100;
    private View buN;
    private TbImageView buP;
    private ImageView buQ;
    private ImageView dCL;
    private EditText fPA;
    private TextView fPB;
    private WriteLocationView fPC;
    private HeadImageView fPD;
    private WriteVideoActivity fPy;
    private TextView fPz;
    private NavigationBar mNavigationBar;

    public n(WriteVideoActivity writeVideoActivity) {
        this.fPy = writeVideoActivity;
        this.fPy.setContentView(w.j.write_video_activity);
        bnh();
        initView();
    }

    private void bnh() {
        this.buN = this.fPy.findViewById(w.h.layout_root);
        this.mNavigationBar = (NavigationBar) this.fPy.findViewById(w.h.navigation_bar);
        this.fPD = (HeadImageView) this.fPy.findViewById(w.h.write_user_head_portrait);
        this.fPA = (EditText) this.fPy.findViewById(w.h.edit_content);
        this.fPB = (TextView) this.fPy.findViewById(w.h.text_content_size);
        this.buP = (TbImageView) this.fPy.findViewById(w.h.image_video);
        this.buQ = (ImageView) this.fPy.findViewById(w.h.image_video_play);
        this.fPC = (WriteLocationView) this.fPy.findViewById(w.h.location);
    }

    private void initView() {
        this.buP.setOnClickListener(this.fPy);
        this.dCL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.nav_close_layout, this.fPy);
        this.mNavigationBar.setCenterTextTitle(this.fPy.getPageContext().getString(w.l.new_video_post));
        this.fPz = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nav_text_send_layout, this.fPy);
        this.fPB.setText(String.valueOf(fPw));
        this.fPD.setIsRound(true);
        this.fPD.setDrawBorder(false);
        this.fPD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dl = q.dl(currentPortrait);
            this.fPD.setUrl(dl);
            this.fPD.c(dl, 12, false);
        }
        this.fPA.addTextChangedListener(new o(this));
        this.fPA.setOnKeyListener(new p(this));
    }

    public void rc(String str) {
        Bitmap rd = rd(str);
        if (rd != null) {
            this.buP.setImageBitmap(rd);
        }
    }

    private Bitmap rd(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            System.gc();
            try {
                return BitmapFactory.decodeFile(str);
            } catch (OutOfMemoryError e2) {
                return null;
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.fPy.getLayoutMode().ai(i == 1);
        this.fPy.getLayoutMode().t(this.buN);
        this.mNavigationBar.onChangeSkinType(this.fPy.getPageContext(), i);
        aq.c(this.dCL, w.g.icon_nav_close_selector);
        aq.c(this.fPz, w.e.cp_link_tip_a, 1);
        if (this.fPC != null) {
            this.fPC.ww();
        }
    }

    public String getContent() {
        if (this.fPA.getText() == null) {
            return null;
        }
        return this.fPA.getText().toString();
    }

    public long bni() {
        if (this.fPA.getText() == null || this.fPA.getText().toString() == null) {
            return 0L;
        }
        return g(this.fPA.getText().toString().trim());
    }

    public static long g(CharSequence charSequence) {
        if (charSequence == null) {
            return 0L;
        }
        double d = 0.0d;
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) > ' ') {
                d += 1.0d;
            }
        }
        return Math.round(d);
    }

    public WriteLocationView bnj() {
        return this.fPC;
    }

    public View bnk() {
        return this.buP;
    }

    public View bnl() {
        return this.fPz;
    }

    public View getBackButton() {
        return this.dCL;
    }

    public View bnm() {
        return this.fPA;
    }

    public void cu(long j) {
        if (this.buP != null) {
            this.buP.setContentDescription(String.valueOf(this.fPy.getResources().getString(w.l.video)) + au.s(j));
        }
    }
}
