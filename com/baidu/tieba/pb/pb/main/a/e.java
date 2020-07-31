package com.baidu.tieba.pb.pb.main.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.video.g;
import com.baidu.tieba.pb.video.h;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes16.dex */
public class e {
    private PbFragment kjZ;
    private h kyG;
    private g kyH;
    private boolean kyI = false;

    public e(PbFragment pbFragment) {
        this.kjZ = pbFragment;
    }

    public void a(f fVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.cKX()) {
            if (this.kyG == null) {
                this.kyG = new h(this.kjZ, cVar, fVar.cKx().aWD(), j);
                this.kyG.a(fVar.cKx().aWD(), fVar.cKx(), fVar.getForumId());
                this.kyG.startPlay();
            } else if (this.kyI) {
                this.kyG.a(fVar.cKx().aWD(), fVar.cKx(), fVar.getForumId());
                this.kyG.startPlay();
            } else {
                this.kyG.Lj(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.kjZ.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.cKy() != null && fVar.cKy().size() >= 1) {
                bv bvVar = fVar.cKy().get(0);
                this.kyG.aK(bvVar);
                this.kyG.Lk(bvVar.getTitle());
            }
            this.kyG.b(postData, fVar.cKx(), fVar.cKW());
            this.kyI = false;
            bdTypeListView.removeHeaderView(this.kyG.cSL());
            bdTypeListView.addHeaderView(this.kyG.cSL(), 0);
            if (this.kyG.bxk() != null && this.kyG.bxk().getParent() == null) {
                frameLayout.addView(this.kyG.bxk());
            }
            if (this.kyH == null) {
                this.kyH = new g(this.kjZ.getBaseFragmentActivity());
            }
            this.kyH.b(fVar, str);
            bdTypeListView.removeHeaderView(this.kyH.cSE());
            bdTypeListView.addHeaderView(this.kyH.cSE(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.kyG != null) {
                cVar.tg(false);
                this.kyG.Ce(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.kyG != null) {
                bdTypeListView.removeHeaderView(this.kyG.cSL());
            }
            if (this.kyH != null) {
                this.kyH.e(bdTypeListView);
            }
        }
    }

    public void sW(boolean z) {
        this.kyI = z;
    }

    public void U(View.OnClickListener onClickListener) {
        if (this.kyG != null) {
            this.kyG.U(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.kyG != null) {
            TiebaStatic.log(new ap("c11997").ah("obj_type", 1));
            this.kyG.cRc();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean Cd(int i) {
        if (this.kyG != null) {
            return this.kyG.vj(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.kyG != null && this.kyG.bxk() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.kyG.cSL());
                    pbLandscapeListView.addHeaderView(this.kyG.cSL(), 0);
                    return;
                }
                return;
            }
            if (this.kyG != null) {
                pbLandscapeListView.removeHeaderView(this.kyG.cSL());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean cQH() {
        return this.kyG != null && this.kyG.cQH();
    }

    public void cQI() {
        if (this.kyG != null) {
            this.kyG.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.kyG != null) {
            this.kyG.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.kyG != null) {
            this.kyG.onScrollStateChanged(absListView, i);
        }
    }

    public void sU(boolean z) {
        if (this.kyG != null) {
            this.kyG.sU(z);
        }
    }

    public void cRc() {
        if (this.kyG != null) {
            this.kyG.cRc();
        }
    }

    public void destroy() {
        if (this.kyG != null) {
            this.kyG.destroy();
        }
    }

    public void onPause() {
        if (this.kyG != null) {
            this.kyG.onPause();
        }
    }

    public void onResume() {
        if (this.kyG != null) {
            this.kyG.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.kyG != null) {
            this.kyG.onConfigurationChanged(configuration);
        }
    }

    public void Ce(int i) {
        if (this.kyG != null) {
            this.kyG.Ce(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kyH != null) {
            this.kyH.onChangeSkinType(i);
        }
    }

    public View bxk() {
        if (this.kyG != null) {
            return this.kyG.bxk();
        }
        return null;
    }

    public int cRd() {
        View bxk = bxk();
        if (bxk != null) {
            return bxk.getHeight();
        }
        return 0;
    }

    public int cRe() {
        if (this.kyG != null) {
            return this.kyG.cRe();
        }
        return 0;
    }

    public boolean bDD() {
        if (this.kyG != null) {
            return this.kyG.bDD();
        }
        return false;
    }
}
