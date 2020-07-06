package com.baidu.tieba.pb.pb.main.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.video.g;
import com.baidu.tieba.pb.video.h;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class e {
    private PbFragment kbv;
    private h kpI;
    private g kpJ;
    private boolean kpK = false;

    public e(PbFragment pbFragment) {
        this.kbv = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (eVar != null && eVar.cHn()) {
            if (this.kpI == null) {
                this.kpI = new h(this.kbv, cVar, eVar.cGO().aSH(), j);
                this.kpI.a(eVar.cGO().aSH(), eVar.cGO(), eVar.getForumId());
                this.kpI.startPlay();
            } else if (this.kpK) {
                this.kpI.a(eVar.cGO().aSH(), eVar.cGO(), eVar.getForumId());
                this.kpI.startPlay();
            } else {
                this.kpI.Kv(eVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.kbv.getUniqueId(), eVar, postData, 1, 1);
            if (eVar.cGP() != null && eVar.cGP().size() >= 1) {
                bu buVar = eVar.cGP().get(0);
                this.kpI.aN(buVar);
                this.kpI.Kw(buVar.getTitle());
            }
            this.kpI.b(postData, eVar.cGO(), eVar.cHm());
            this.kpK = false;
            bdTypeListView.removeHeaderView(this.kpI.cOY());
            bdTypeListView.addHeaderView(this.kpI.cOY(), 0);
            if (this.kpI.bub() != null && this.kpI.bub().getParent() == null) {
                frameLayout.addView(this.kpI.bub());
            }
            if (this.kpJ == null) {
                this.kpJ = new g(this.kbv.getBaseFragmentActivity());
            }
            this.kpJ.b(eVar, str);
            bdTypeListView.removeHeaderView(this.kpJ.cOR());
            bdTypeListView.addHeaderView(this.kpJ.cOR(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.kpI != null) {
                cVar.sA(false);
                this.kpI.BF(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.kpI != null) {
                bdTypeListView.removeHeaderView(this.kpI.cOY());
            }
            if (this.kpJ != null) {
                this.kpJ.e(bdTypeListView);
            }
        }
    }

    public void sr(boolean z) {
        this.kpK = z;
    }

    public void T(View.OnClickListener onClickListener) {
        if (this.kpI != null) {
            this.kpI.T(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.kpI != null) {
            TiebaStatic.log(new ao("c11997").ag("obj_type", 1));
            this.kpI.cNp();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean BE(int i) {
        if (this.kpI != null) {
            return this.kpI.uR(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.kpI != null && this.kpI.bub() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.kpI.cOY());
                    pbLandscapeListView.addHeaderView(this.kpI.cOY(), 0);
                    return;
                }
                return;
            }
            if (this.kpI != null) {
                pbLandscapeListView.removeHeaderView(this.kpI.cOY());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean cMV() {
        return this.kpI != null && this.kpI.cMV();
    }

    public void cMW() {
        if (this.kpI != null) {
            this.kpI.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.kpI != null) {
            this.kpI.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.kpI != null) {
            this.kpI.onScrollStateChanged(absListView, i);
        }
    }

    public void sp(boolean z) {
        if (this.kpI != null) {
            this.kpI.sp(z);
        }
    }

    public void cNp() {
        if (this.kpI != null) {
            this.kpI.cNp();
        }
    }

    public void destroy() {
        if (this.kpI != null) {
            this.kpI.destroy();
        }
    }

    public void onPause() {
        if (this.kpI != null) {
            this.kpI.onPause();
        }
    }

    public void onResume() {
        if (this.kpI != null) {
            this.kpI.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.kpI != null) {
            this.kpI.onConfigurationChanged(configuration);
        }
    }

    public void BF(int i) {
        if (this.kpI != null) {
            this.kpI.BF(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kpJ != null) {
            this.kpJ.onChangeSkinType(i);
        }
    }

    public View bub() {
        if (this.kpI != null) {
            return this.kpI.bub();
        }
        return null;
    }

    public int cNq() {
        View bub = bub();
        if (bub != null) {
            return bub.getHeight();
        }
        return 0;
    }

    public int cNr() {
        if (this.kpI != null) {
            return this.kpI.cNr();
        }
        return 0;
    }

    public boolean bAs() {
        if (this.kpI != null) {
            return this.kpI.bAs();
        }
        return false;
    }
}
