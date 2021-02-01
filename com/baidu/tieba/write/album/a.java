package com.baidu.tieba.write.album;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes8.dex */
public class a extends com.baidu.adp.base.d<BaseFragmentActivity> {
    private String bLx;
    private String bLy;
    private Fragment[] bgH;
    private TbPageContext iVb;
    private e odM;
    private String[] odN;
    private ImageListFragment odO;
    private AlbumImageBrowseFragment odP;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.bLx = "tag_image";
        this.bLy = "tag_b_image";
        this.iVb = tbPageContext;
        this.odM = eVar;
    }

    public void Uu() {
        this.bgH = new Fragment[2];
        this.odN = new String[2];
        this.odO = new ImageListFragment();
        this.odO.a(this.odM);
        this.bgH[0] = this.odO;
        this.odN[0] = this.bLx;
        this.odP = new AlbumImageBrowseFragment();
        this.odP.a(this.odM);
        this.bgH[1] = this.odP;
        this.odN[1] = this.bLy;
    }

    public Fragment Li(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bgH[i];
    }

    public String Lj(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.odN[i];
    }

    public void b(NavigationBar navigationBar) {
        this.odO.b(navigationBar);
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bgH.length) {
                if (this.bgH[i3] != null && (this.bgH[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bgH[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dWK() {
        if (this.odO == null) {
            return null;
        }
        return this.odO.dWK();
    }

    public void stopCamera() {
        TbCameraView dWK = dWK();
        if (dWK != null) {
            dWK.stopCamera();
            dWK.setVisibility(4);
        }
    }

    public void openCamera() {
        TbCameraView dWK = dWK();
        if (dWK != null) {
            dWK.setVisibility(0);
            dWK.zC(false);
        }
        if (this.odO != null && this.odO.dWV() != null) {
            this.odO.dWV().UR();
        }
    }

    public void dWL() {
        if (this.odO != null) {
            this.odO.UP();
        }
    }

    public View Uv() {
        if (this.odO == null) {
            return null;
        }
        return this.odO.UM();
    }

    public View Uw() {
        if (this.odO == null) {
            return null;
        }
        return this.odO.UQ();
    }

    public View Ux() {
        if (this.odP == null) {
            return null;
        }
        return this.odP.UM();
    }

    public View Uy() {
        if (this.odP == null) {
            return null;
        }
        return this.odP.UN();
    }

    public View Uz() {
        if (this.odP == null) {
            return null;
        }
        return this.odP.Uz();
    }

    public View UA() {
        if (this.odO == null) {
            return null;
        }
        return this.odO.Uz();
    }

    public void onDestroy() {
    }

    public ImageListFragment dWM() {
        return this.odO;
    }

    public void dn(boolean z) {
        if (this.odP != null) {
            this.odP.dn(z);
        }
        if (this.odO != null) {
            this.odO.dn(z);
        }
    }

    public void a(j jVar) {
        if (this.odO != null) {
            this.odO.a(jVar);
        }
    }
}
