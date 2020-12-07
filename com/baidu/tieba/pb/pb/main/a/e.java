package com.baidu.tieba.pb.pb.main.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.video.g;
import com.baidu.tieba.pb.video.h;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class e {
    private PbFragment lDG;
    private h lSR;
    private g lSS;
    private boolean lST = false;

    public e(PbFragment pbFragment) {
        this.lDG = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.dnu()) {
            if (this.lSR == null) {
                this.lSR = new h(this.lDG, cVar, fVar.dmT().bph(), j);
                this.lSR.a(fVar.dmT().bph(), fVar.dmT(), fVar.getForumId());
                this.lSR.startPlay();
            } else if (this.lST) {
                this.lSR.a(fVar.dmT().bph(), fVar.dmT(), fVar.getForumId());
                this.lSR.startPlay();
            } else {
                this.lSR.QN(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.lDG.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.dmU() != null && fVar.dmU().size() >= 1) {
                by byVar = fVar.dmU().get(0);
                this.lSR.aO(byVar);
                this.lSR.QO(byVar.getTitle());
            }
            this.lSR.b(postData, fVar.dmT(), fVar.dnt());
            this.lST = false;
            bdTypeListView.removeHeaderView(this.lSR.dvu());
            bdTypeListView.addHeaderView(this.lSR.dvu(), 0);
            if (this.lSR.bSs() != null && this.lSR.bSs().getParent() == null) {
                frameLayout.addView(this.lSR.bSs());
            }
            if (this.lSS == null) {
                this.lSS = new g(this.lDG.getBaseFragmentActivity());
            }
            this.lSS.b(fVar, str);
            bdTypeListView.removeHeaderView(this.lSS.dvn());
            bdTypeListView.addHeaderView(this.lSS.dvn(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.lSR != null) {
                cVar.vL(false);
                this.lSR.Hz(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.lSR != null) {
                bdTypeListView.removeHeaderView(this.lSR.dvu());
            }
            if (this.lSS != null) {
                this.lSS.e(bdTypeListView);
            }
        }
    }

    public void vB(boolean z) {
        this.lST = z;
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.lSR != null) {
            this.lSR.V(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.lSR != null) {
            TiebaStatic.log(new ar("c11997").al("obj_type", 1));
            this.lSR.dtG();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean Hy(int i) {
        if (this.lSR != null) {
            return this.lSR.Ap(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.lSR != null && this.lSR.bSs() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.lSR.dvu());
                    pbLandscapeListView.addHeaderView(this.lSR.dvu(), 0);
                    return;
                }
                return;
            }
            if (this.lSR != null) {
                pbLandscapeListView.removeHeaderView(this.lSR.dvu());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean dtj() {
        return this.lSR != null && this.lSR.dtj();
    }

    public void dtk() {
        if (this.lSR != null) {
            this.lSR.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.lSR != null) {
            this.lSR.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lSR != null) {
            this.lSR.onScrollStateChanged(absListView, i);
        }
    }

    public void vz(boolean z) {
        if (this.lSR != null) {
            this.lSR.vz(z);
        }
    }

    public void dtG() {
        if (this.lSR != null) {
            this.lSR.dtG();
        }
    }

    public void destroy() {
        if (this.lSR != null) {
            this.lSR.destroy();
        }
    }

    public void onPause() {
        if (this.lSR != null) {
            this.lSR.onPause();
        }
    }

    public void onResume() {
        if (this.lSR != null) {
            this.lSR.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.lSR != null) {
            this.lSR.onConfigurationChanged(configuration);
        }
    }

    public void Hz(int i) {
        if (this.lSR != null) {
            this.lSR.Hz(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lSS != null) {
            this.lSS.onChangeSkinType(i);
        }
    }

    public View bSs() {
        if (this.lSR != null) {
            return this.lSR.bSs();
        }
        return null;
    }

    public int dtH() {
        View bSs = bSs();
        if (bSs != null) {
            return bSs.getHeight();
        }
        return 0;
    }

    public int dtI() {
        if (this.lSR != null) {
            return this.lSR.dtI();
        }
        return 0;
    }

    public boolean caj() {
        if (this.lSR != null) {
            return this.lSR.caj();
        }
        return false;
    }
}
