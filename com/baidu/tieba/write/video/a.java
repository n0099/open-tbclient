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
    public static int gCo = 31;
    private static int gCp = -100;
    private TbImageView bCQ;
    private ImageView bCR;
    private View bFy;
    private ImageView dZG;
    private WriteVideoActivity gCq;
    private TextView gCr;
    private EditText gCs;
    private TextView gCt;
    private WriteLocationView gCu;
    private HeadImageView gCv;
    private NavigationBar mNavigationBar;

    public a(WriteVideoActivity writeVideoActivity) {
        this.gCq = writeVideoActivity;
        this.gCq.setContentView(d.j.write_video_activity);
        byM();
        initView();
    }

    private void byM() {
        this.bFy = this.gCq.findViewById(d.h.layout_root);
        this.mNavigationBar = (NavigationBar) this.gCq.findViewById(d.h.navigation_bar);
        this.gCv = (HeadImageView) this.gCq.findViewById(d.h.write_user_head_portrait);
        this.gCs = (EditText) this.gCq.findViewById(d.h.edit_content);
        this.gCt = (TextView) this.gCq.findViewById(d.h.text_content_size);
        this.bCQ = (TbImageView) this.gCq.findViewById(d.h.image_video);
        this.bCR = (ImageView) this.gCq.findViewById(d.h.image_video_play);
        this.gCu = (WriteLocationView) this.gCq.findViewById(d.h.location);
    }

    private void initView() {
        this.bCQ.setOnClickListener(this.gCq);
        this.dZG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.nav_close_layout, this.gCq);
        this.mNavigationBar.setCenterTextTitle(this.gCq.getPageContext().getString(d.l.new_video_post));
        this.gCr = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nav_text_send_layout, this.gCq);
        this.gCt.setText(String.valueOf(gCo));
        this.gCv.setIsRound(true);
        this.gCv.setDrawBorder(false);
        this.gCv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dF = n.dF(currentPortrait);
            this.gCv.setUrl(dF);
            this.gCv.c(dF, 12, false);
        }
        this.gCs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.a.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                long byN = a.gCo - a.this.byN();
                if (byN >= 0) {
                    ai.i(a.this.gCt, d.e.cp_cont_e);
                } else {
                    ai.i(a.this.gCt, d.e.cp_cont_h);
                }
                if (byN <= a.gCp) {
                    a.this.gCt.setText(al.vF());
                } else {
                    a.this.gCt.setText(String.valueOf(byN));
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gCs.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.a.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
    }

    public void sV(String str) {
        Bitmap sW = sW(str);
        if (sW != null) {
            this.bCQ.setImageBitmap(sW);
        }
    }

    private Bitmap sW(String str) {
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
        this.gCq.getLayoutMode().ah(i == 1);
        this.gCq.getLayoutMode().t(this.bFy);
        this.mNavigationBar.onChangeSkinType(this.gCq.getPageContext(), i);
        ai.c(this.dZG, d.g.icon_nav_close_selector);
        ai.c(this.gCr, d.e.cp_link_tip_a, 1);
        if (this.gCu != null) {
            this.gCu.wV();
        }
    }

    public String getContent() {
        if (this.gCs.getText() == null) {
            return null;
        }
        return this.gCs.getText().toString();
    }

    public long byN() {
        if (this.gCs.getText() == null || this.gCs.getText().toString() == null) {
            return 0L;
        }
        return g(this.gCs.getText().toString().trim());
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

    public WriteLocationView byO() {
        return this.gCu;
    }

    public View byP() {
        return this.bCQ;
    }

    public View byQ() {
        return this.gCr;
    }

    public View getBackButton() {
        return this.dZG;
    }

    public View byR() {
        return this.gCs;
    }

    public void db(long j) {
        if (this.bCQ != null) {
            this.bCQ.setContentDescription(this.gCq.getResources().getString(d.l.video) + al.t(j));
        }
    }

    public void sX(String str) {
        this.gCs.setText(str);
    }
}
