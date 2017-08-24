package com.baidu.tieba.write.video;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a {
    public static int gFr = 31;
    private static int gFs = -100;
    private TbImageView bEK;
    private ImageView bEL;
    private View bHs;
    private ImageView ecT;
    private WriteVideoActivity gFt;
    private TextView gFu;
    private EditText gFv;
    private TextView gFw;
    private WriteLocationView gFx;
    private HeadImageView gFy;
    private NavigationBar mNavigationBar;

    public a(WriteVideoActivity writeVideoActivity) {
        this.gFt = writeVideoActivity;
        this.gFt.setContentView(d.j.write_video_activity);
        bzs();
        initView();
    }

    private void bzs() {
        this.bHs = this.gFt.findViewById(d.h.layout_root);
        this.mNavigationBar = (NavigationBar) this.gFt.findViewById(d.h.navigation_bar);
        this.gFy = (HeadImageView) this.gFt.findViewById(d.h.write_user_head_portrait);
        this.gFv = (EditText) this.gFt.findViewById(d.h.edit_content);
        this.gFw = (TextView) this.gFt.findViewById(d.h.text_content_size);
        this.bEK = (TbImageView) this.gFt.findViewById(d.h.image_video);
        this.bEL = (ImageView) this.gFt.findViewById(d.h.image_video_play);
        this.gFx = (WriteLocationView) this.gFt.findViewById(d.h.location);
    }

    private void initView() {
        this.bEK.setOnClickListener(this.gFt);
        this.ecT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.nav_close_layout, this.gFt);
        this.mNavigationBar.setCenterTextTitle(this.gFt.getPageContext().getString(d.l.new_video_post));
        this.gFu = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nav_text_send_layout, this.gFt);
        this.gFw.setText(String.valueOf(gFr));
        this.gFy.setIsRound(true);
        this.gFy.setDrawBorder(false);
        this.gFy.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dP = n.dP(currentPortrait);
            this.gFy.setUrl(dP);
            this.gFy.c(dP, 12, false);
        }
        this.gFv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.a.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                long bzt = a.gFr - a.this.bzt();
                if (bzt >= 0) {
                    ai.i(a.this.gFw, d.e.cp_cont_e);
                } else {
                    ai.i(a.this.gFw, d.e.cp_cont_h);
                }
                if (bzt <= a.gFs) {
                    a.this.gFw.setText(al.vQ());
                } else {
                    a.this.gFw.setText(String.valueOf(bzt));
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gFv.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.a.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
    }

    public void th(String str) {
        Bitmap ti = ti(str);
        if (ti != null) {
            this.bEK.setImageBitmap(ti);
        }
    }

    private Bitmap ti(String str) {
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
        this.gFt.getLayoutMode().ah(i == 1);
        this.gFt.getLayoutMode().t(this.bHs);
        this.mNavigationBar.onChangeSkinType(this.gFt.getPageContext(), i);
        ai.c(this.ecT, d.g.icon_nav_close_selector);
        ai.c(this.gFu, d.e.cp_link_tip_a, 1);
        if (this.gFx != null) {
            this.gFx.xd();
        }
    }

    public String getContent() {
        if (this.gFv.getText() == null) {
            return null;
        }
        return this.gFv.getText().toString();
    }

    public long bzt() {
        if (this.gFv.getText() == null || this.gFv.getText().toString() == null) {
            return 0L;
        }
        return g(this.gFv.getText().toString().trim());
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

    public WriteLocationView bzu() {
        return this.gFx;
    }

    public View bzv() {
        return this.bEK;
    }

    public View bzw() {
        return this.gFu;
    }

    public View getBackButton() {
        return this.ecT;
    }

    public View bzx() {
        return this.gFv;
    }

    public void db(long j) {
        if (this.bEK != null) {
            this.bEK.setContentDescription(this.gFt.getResources().getString(d.l.video) + al.t(j));
        }
    }

    public void tj(String str) {
        this.gFv.setText(str);
    }
}
