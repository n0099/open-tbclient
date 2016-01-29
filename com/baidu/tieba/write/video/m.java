package com.baidu.tieba.write.video;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class m {
    private static int epS = 31;
    private static int epT = -100;
    private View aCv;
    private View aQK;
    private TbImageView aQN;
    private ImageView aQO;
    private WriteVideoActivity epU;
    private TextView epV;
    private EditText epW;
    private TextView epX;
    private WriteLocationView epY;
    private NavigationBar mNavigationBar;

    public m(WriteVideoActivity writeVideoActivity) {
        this.epU = writeVideoActivity;
        this.epU.setContentView(t.h.write_video_activity);
        aTK();
        initView();
    }

    private void aTK() {
        this.aQK = this.epU.findViewById(t.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.epU.findViewById(t.g.navigation_bar);
        this.epW = (EditText) this.epU.findViewById(t.g.edit_content);
        this.epX = (TextView) this.epU.findViewById(t.g.text_content_size);
        this.aQN = (TbImageView) this.epU.findViewById(t.g.image_video);
        this.aQO = (ImageView) this.epU.findViewById(t.g.image_video_play);
        this.epY = (WriteLocationView) this.epU.findViewById(t.g.location);
    }

    private void initView() {
        this.aQN.setOnClickListener(this.epU);
        this.aCv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.epU);
        this.mNavigationBar.setTitleText(this.epU.getPageContext().getString(t.j.new_video_post));
        this.epV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.epU.getResources().getString(t.j.publish), this.epU, true);
        this.epX.setText(String.valueOf(epS));
        this.epW.addTextChangedListener(new n(this));
        this.epW.setOnKeyListener(new o(this));
    }

    public void nF(String str) {
        Bitmap nG = nG(str);
        if (nG != null) {
            this.aQN.setImageBitmap(nG);
        }
    }

    private Bitmap nG(String str) {
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
        this.epU.getLayoutMode().ac(i == 1);
        this.epU.getLayoutMode().x(this.aQK);
        this.mNavigationBar.onChangeSkinType(this.epU.getPageContext(), i);
        ar.k(this.epV, t.f.s_navbar_button_bg);
        this.epY.xf();
    }

    public String getContent() {
        if (this.epW.getText() == null) {
            return null;
        }
        return this.epW.getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTL() {
        if (epS - aTM() < 0) {
            this.epV.setEnabled(false);
        } else {
            this.epV.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aTM() {
        if (this.epW.getText() == null || this.epW.getText().toString() == null) {
            return 0L;
        }
        return g(this.epW.getText().toString().trim());
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

    public WriteLocationView aTN() {
        return this.epY;
    }

    public View aTO() {
        return this.aQN;
    }

    public View aTP() {
        return this.epV;
    }

    public View aay() {
        return this.aCv;
    }

    public View aTQ() {
        return this.epW;
    }
}
