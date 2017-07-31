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
    private TbImageView bEa;
    private ImageView bEb;
    private View bGI;
    private ImageView eaX;
    private WriteVideoActivity gDB;
    private TextView gDC;
    private EditText gDD;
    private TextView gDE;
    private WriteLocationView gDF;
    private HeadImageView gDG;
    private NavigationBar mNavigationBar;
    public static int gDz = 31;
    private static int gDA = -100;

    public a(WriteVideoActivity writeVideoActivity) {
        this.gDB = writeVideoActivity;
        this.gDB.setContentView(d.j.write_video_activity);
        byT();
        initView();
    }

    private void byT() {
        this.bGI = this.gDB.findViewById(d.h.layout_root);
        this.mNavigationBar = (NavigationBar) this.gDB.findViewById(d.h.navigation_bar);
        this.gDG = (HeadImageView) this.gDB.findViewById(d.h.write_user_head_portrait);
        this.gDD = (EditText) this.gDB.findViewById(d.h.edit_content);
        this.gDE = (TextView) this.gDB.findViewById(d.h.text_content_size);
        this.bEa = (TbImageView) this.gDB.findViewById(d.h.image_video);
        this.bEb = (ImageView) this.gDB.findViewById(d.h.image_video_play);
        this.gDF = (WriteLocationView) this.gDB.findViewById(d.h.location);
    }

    private void initView() {
        this.bEa.setOnClickListener(this.gDB);
        this.eaX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.nav_close_layout, this.gDB);
        this.mNavigationBar.setCenterTextTitle(this.gDB.getPageContext().getString(d.l.new_video_post));
        this.gDC = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nav_text_send_layout, this.gDB);
        this.gDE.setText(String.valueOf(gDz));
        this.gDG.setIsRound(true);
        this.gDG.setDrawBorder(false);
        this.gDG.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dL = n.dL(currentPortrait);
            this.gDG.setUrl(dL);
            this.gDG.c(dL, 12, false);
        }
        this.gDD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.a.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                long byU = a.gDz - a.this.byU();
                if (byU >= 0) {
                    ai.i(a.this.gDE, d.e.cp_cont_e);
                } else {
                    ai.i(a.this.gDE, d.e.cp_cont_h);
                }
                if (byU <= a.gDA) {
                    a.this.gDE.setText(al.vP());
                } else {
                    a.this.gDE.setText(String.valueOf(byU));
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gDD.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.a.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
    }

    public void ta(String str) {
        Bitmap tb = tb(str);
        if (tb != null) {
            this.bEa.setImageBitmap(tb);
        }
    }

    private Bitmap tb(String str) {
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
        this.gDB.getLayoutMode().ah(i == 1);
        this.gDB.getLayoutMode().t(this.bGI);
        this.mNavigationBar.onChangeSkinType(this.gDB.getPageContext(), i);
        ai.c(this.eaX, d.g.icon_nav_close_selector);
        ai.c(this.gDC, d.e.cp_link_tip_a, 1);
        if (this.gDF != null) {
            this.gDF.xd();
        }
    }

    public String getContent() {
        if (this.gDD.getText() == null) {
            return null;
        }
        return this.gDD.getText().toString();
    }

    public long byU() {
        if (this.gDD.getText() == null || this.gDD.getText().toString() == null) {
            return 0L;
        }
        return g(this.gDD.getText().toString().trim());
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

    public WriteLocationView byV() {
        return this.gDF;
    }

    public View byW() {
        return this.bEa;
    }

    public View byX() {
        return this.gDC;
    }

    public View getBackButton() {
        return this.eaX;
    }

    public View byY() {
        return this.gDD;
    }

    public void db(long j) {
        if (this.bEa != null) {
            this.bEa.setContentDescription(this.gDB.getResources().getString(d.l.video) + al.t(j));
        }
    }

    public void tc(String str) {
        this.gDD.setText(str);
    }
}
