package com.baidu.tieba.pb.pb.main.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.video.g;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class e {
    private PbFragment lIN;
    private g lYe;
    private com.baidu.tieba.pb.video.f lYf;
    private boolean lYg = false;

    public e(PbFragment pbFragment) {
        this.lIN = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.dnf()) {
            if (this.lYe == null) {
                this.lYe = new g(this.lIN, cVar, fVar.dmF().brI(), j);
                this.lYe.a(fVar.dmF().brI(), fVar.dmF(), fVar.getForumId());
                this.lYe.startPlay();
            } else if (this.lYg) {
                this.lYe.a(fVar.dmF().brI(), fVar.dmF(), fVar.getForumId());
                this.lYe.startPlay();
            } else {
                this.lYe.Qs(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.lIN.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.dmG() != null && fVar.dmG().size() >= 1) {
                bz bzVar = fVar.dmG().get(0);
                this.lYe.aP(bzVar);
                this.lYe.Qt(bzVar.getTitle());
            }
            this.lYe.b(postData, fVar.dmF(), fVar.dne());
            this.lYg = false;
            bdTypeListView.removeHeaderView(this.lYe.dvl());
            bdTypeListView.addHeaderView(this.lYe.dvl(), 0);
            if (this.lYe.bUW() != null && this.lYe.bUW().getParent() == null) {
                frameLayout.addView(this.lYe.bUW());
            }
            if (this.lYf == null) {
                this.lYf = new com.baidu.tieba.pb.video.f(this.lIN.getBaseFragmentActivity());
            }
            this.lYf.b(fVar, str);
            bdTypeListView.removeHeaderView(this.lYf.dve());
            bdTypeListView.addHeaderView(this.lYf.dve(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.lYe != null) {
                cVar.vM(false);
                this.lYe.Hs(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.lYe != null) {
                bdTypeListView.removeHeaderView(this.lYe.dvl());
            }
            if (this.lYf != null) {
                this.lYf.e(bdTypeListView);
            }
        }
    }

    public void vC(boolean z) {
        this.lYg = z;
    }

    public void X(View.OnClickListener onClickListener) {
        if (this.lYe != null) {
            this.lYe.X(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.lYe != null) {
            TiebaStatic.log(new aq("c11997").an("obj_type", 1));
            this.lYe.dtx();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean Hr(int i) {
        if (this.lYe != null) {
            return this.lYe.AB(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.lYe != null && this.lYe.bUW() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.lYe.dvl());
                    pbLandscapeListView.addHeaderView(this.lYe.dvl(), 0);
                    return;
                }
                return;
            }
            if (this.lYe != null) {
                pbLandscapeListView.removeHeaderView(this.lYe.dvl());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean dsZ() {
        return this.lYe != null && this.lYe.dsZ();
    }

    public void dta() {
        if (this.lYe != null) {
            this.lYe.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.lYe != null) {
            this.lYe.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lYe != null) {
            this.lYe.onScrollStateChanged(absListView, i);
        }
    }

    public void vA(boolean z) {
        if (this.lYe != null) {
            this.lYe.vA(z);
        }
    }

    public void dtx() {
        if (this.lYe != null) {
            this.lYe.dtx();
        }
    }

    public void destroy() {
        if (this.lYe != null) {
            this.lYe.destroy();
        }
    }

    public void onPause() {
        if (this.lYe != null) {
            this.lYe.onPause();
        }
    }

    public void onResume() {
        if (this.lYe != null) {
            this.lYe.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.lYe != null) {
            this.lYe.onConfigurationChanged(configuration);
        }
    }

    public void Hs(int i) {
        if (this.lYe != null) {
            this.lYe.Hs(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lYf != null) {
            this.lYf.onChangeSkinType(i);
        }
    }

    public View bUW() {
        if (this.lYe != null) {
            return this.lYe.bUW();
        }
        return null;
    }

    public int dty() {
        View bUW = bUW();
        if (bUW != null) {
            return bUW.getHeight();
        }
        return 0;
    }

    public int dtz() {
        if (this.lYe != null) {
            return this.lYe.dtz();
        }
        return 0;
    }

    public boolean isVertical() {
        if (this.lYe != null) {
            return this.lYe.isVertical();
        }
        return false;
    }
}
