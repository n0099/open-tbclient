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
public class m {
    public static int fRw = 31;
    private static int fRx = -100;
    private View buQ;
    private TbImageView buS;
    private ImageView buU;
    private ImageView dIo;
    private EditText fRA;
    private TextView fRB;
    private WriteLocationView fRC;
    private HeadImageView fRD;
    private WriteVideoActivity fRy;
    private TextView fRz;
    private NavigationBar mNavigationBar;

    public m(WriteVideoActivity writeVideoActivity) {
        this.fRy = writeVideoActivity;
        this.fRy.setContentView(w.j.write_video_activity);
        bpg();
        initView();
    }

    private void bpg() {
        this.buQ = this.fRy.findViewById(w.h.layout_root);
        this.mNavigationBar = (NavigationBar) this.fRy.findViewById(w.h.navigation_bar);
        this.fRD = (HeadImageView) this.fRy.findViewById(w.h.write_user_head_portrait);
        this.fRA = (EditText) this.fRy.findViewById(w.h.edit_content);
        this.fRB = (TextView) this.fRy.findViewById(w.h.text_content_size);
        this.buS = (TbImageView) this.fRy.findViewById(w.h.image_video);
        this.buU = (ImageView) this.fRy.findViewById(w.h.image_video_play);
        this.fRC = (WriteLocationView) this.fRy.findViewById(w.h.location);
    }

    private void initView() {
        this.buS.setOnClickListener(this.fRy);
        this.dIo = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.nav_close_layout, this.fRy);
        this.mNavigationBar.setCenterTextTitle(this.fRy.getPageContext().getString(w.l.new_video_post));
        this.fRz = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nav_text_send_layout, this.fRy);
        this.fRB.setText(String.valueOf(fRw));
        this.fRD.setIsRound(true);
        this.fRD.setDrawBorder(false);
        this.fRD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dn = q.dn(currentPortrait);
            this.fRD.setUrl(dn);
            this.fRD.c(dn, 12, false);
        }
        this.fRA.addTextChangedListener(new n(this));
        this.fRA.setOnKeyListener(new o(this));
    }

    public void rg(String str) {
        Bitmap rh = rh(str);
        if (rh != null) {
            this.buS.setImageBitmap(rh);
        }
    }

    private Bitmap rh(String str) {
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
        this.fRy.getLayoutMode().aj(i == 1);
        this.fRy.getLayoutMode().t(this.buQ);
        this.mNavigationBar.onChangeSkinType(this.fRy.getPageContext(), i);
        aq.c(this.dIo, w.g.icon_nav_close_selector);
        aq.c(this.fRz, w.e.cp_link_tip_a, 1);
        this.fRC.xl();
    }

    public String getContent() {
        if (this.fRA.getText() == null) {
            return null;
        }
        return this.fRA.getText().toString();
    }

    public long bph() {
        if (this.fRA.getText() == null || this.fRA.getText().toString() == null) {
            return 0L;
        }
        return g(this.fRA.getText().toString().trim());
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

    public WriteLocationView bpi() {
        return this.fRC;
    }

    public View bpj() {
        return this.buS;
    }

    public View bpk() {
        return this.fRz;
    }

    public View getBackButton() {
        return this.dIo;
    }

    public View bpl() {
        return this.fRA;
    }

    public void cI(long j) {
        if (this.buS != null) {
            this.buS.setContentDescription(String.valueOf(this.fRy.getResources().getString(w.l.video)) + au.s(j));
        }
    }
}
