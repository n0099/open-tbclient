package com.baidu.tieba.write.album;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.base.d<BaseFragmentActivity> {
    private String bHN;
    private String bHO;
    private Fragment[] bdx;
    private TbPageContext iPu;
    private e nTG;
    private String[] nTH;
    private ImageListFragment nTI;
    private AlbumImageBrowseFragment nTJ;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.bHN = "tag_image";
        this.bHO = "tag_b_image";
        this.iPu = tbPageContext;
        this.nTG = eVar;
    }

    public void SN() {
        this.bdx = new Fragment[2];
        this.nTH = new String[2];
        this.nTI = new ImageListFragment();
        this.nTI.a(this.nTG);
        this.bdx[0] = this.nTI;
        this.nTH[0] = this.bHN;
        this.nTJ = new AlbumImageBrowseFragment();
        this.nTJ.a(this.nTG);
        this.bdx[1] = this.nTJ;
        this.nTH[1] = this.bHO;
    }

    public Fragment KN(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bdx[i];
    }

    public String KO(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.nTH[i];
    }

    public void b(NavigationBar navigationBar) {
        this.nTI.b(navigationBar);
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bdx.length) {
                if (this.bdx[i3] != null && (this.bdx[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bdx[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dUw() {
        if (this.nTI == null) {
            return null;
        }
        return this.nTI.dUw();
    }

    public void stopCamera() {
        TbCameraView dUw = dUw();
        if (dUw != null) {
            dUw.stopCamera();
            dUw.setVisibility(4);
        }
    }

    public void openCamera() {
        TbCameraView dUw = dUw();
        if (dUw != null) {
            dUw.setVisibility(0);
            dUw.zg(false);
        }
        if (this.nTI != null && this.nTI.dUH() != null) {
            this.nTI.dUH().Tk();
        }
    }

    public void dUx() {
        if (this.nTI != null) {
            this.nTI.Ti();
        }
    }

    public View SO() {
        if (this.nTI == null) {
            return null;
        }
        return this.nTI.Tf();
    }

    public View SP() {
        if (this.nTI == null) {
            return null;
        }
        return this.nTI.Tj();
    }

    public View SQ() {
        if (this.nTJ == null) {
            return null;
        }
        return this.nTJ.Tf();
    }

    public View SR() {
        if (this.nTJ == null) {
            return null;
        }
        return this.nTJ.Tg();
    }

    public View SS() {
        if (this.nTJ == null) {
            return null;
        }
        return this.nTJ.SS();
    }

    public View ST() {
        if (this.nTI == null) {
            return null;
        }
        return this.nTI.SS();
    }

    public void onDestroy() {
    }

    public ImageListFragment dUy() {
        return this.nTI;
    }

    public void df(boolean z) {
        if (this.nTJ != null) {
            this.nTJ.df(z);
        }
        if (this.nTI != null) {
            this.nTI.df(z);
        }
    }

    public void a(j jVar) {
        if (this.nTI != null) {
            this.nTI.a(jVar);
        }
    }
}
