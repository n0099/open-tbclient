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
    private PbFragment lDI;
    private h lST;
    private g lSU;
    private boolean lSV = false;

    public e(PbFragment pbFragment) {
        this.lDI = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.dnv()) {
            if (this.lST == null) {
                this.lST = new h(this.lDI, cVar, fVar.dmU().bph(), j);
                this.lST.a(fVar.dmU().bph(), fVar.dmU(), fVar.getForumId());
                this.lST.startPlay();
            } else if (this.lSV) {
                this.lST.a(fVar.dmU().bph(), fVar.dmU(), fVar.getForumId());
                this.lST.startPlay();
            } else {
                this.lST.QN(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.lDI.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.dmV() != null && fVar.dmV().size() >= 1) {
                by byVar = fVar.dmV().get(0);
                this.lST.aO(byVar);
                this.lST.QO(byVar.getTitle());
            }
            this.lST.b(postData, fVar.dmU(), fVar.dnu());
            this.lSV = false;
            bdTypeListView.removeHeaderView(this.lST.dvv());
            bdTypeListView.addHeaderView(this.lST.dvv(), 0);
            if (this.lST.bSt() != null && this.lST.bSt().getParent() == null) {
                frameLayout.addView(this.lST.bSt());
            }
            if (this.lSU == null) {
                this.lSU = new g(this.lDI.getBaseFragmentActivity());
            }
            this.lSU.b(fVar, str);
            bdTypeListView.removeHeaderView(this.lSU.dvo());
            bdTypeListView.addHeaderView(this.lSU.dvo(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.lST != null) {
                cVar.vL(false);
                this.lST.Hz(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.lST != null) {
                bdTypeListView.removeHeaderView(this.lST.dvv());
            }
            if (this.lSU != null) {
                this.lSU.e(bdTypeListView);
            }
        }
    }

    public void vB(boolean z) {
        this.lSV = z;
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.lST != null) {
            this.lST.V(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.lST != null) {
            TiebaStatic.log(new ar("c11997").al("obj_type", 1));
            this.lST.dtH();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean Hy(int i) {
        if (this.lST != null) {
            return this.lST.Ap(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.lST != null && this.lST.bSt() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.lST.dvv());
                    pbLandscapeListView.addHeaderView(this.lST.dvv(), 0);
                    return;
                }
                return;
            }
            if (this.lST != null) {
                pbLandscapeListView.removeHeaderView(this.lST.dvv());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean dtk() {
        return this.lST != null && this.lST.dtk();
    }

    public void dtl() {
        if (this.lST != null) {
            this.lST.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.lST != null) {
            this.lST.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lST != null) {
            this.lST.onScrollStateChanged(absListView, i);
        }
    }

    public void vz(boolean z) {
        if (this.lST != null) {
            this.lST.vz(z);
        }
    }

    public void dtH() {
        if (this.lST != null) {
            this.lST.dtH();
        }
    }

    public void destroy() {
        if (this.lST != null) {
            this.lST.destroy();
        }
    }

    public void onPause() {
        if (this.lST != null) {
            this.lST.onPause();
        }
    }

    public void onResume() {
        if (this.lST != null) {
            this.lST.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.lST != null) {
            this.lST.onConfigurationChanged(configuration);
        }
    }

    public void Hz(int i) {
        if (this.lST != null) {
            this.lST.Hz(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lSU != null) {
            this.lSU.onChangeSkinType(i);
        }
    }

    public View bSt() {
        if (this.lST != null) {
            return this.lST.bSt();
        }
        return null;
    }

    public int dtI() {
        View bSt = bSt();
        if (bSt != null) {
            return bSt.getHeight();
        }
        return 0;
    }

    public int dtJ() {
        if (this.lST != null) {
            return this.lST.dtJ();
        }
        return 0;
    }

    public boolean cak() {
        if (this.lST != null) {
            return this.lST.cak();
        }
        return false;
    }
}
