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
        if (eVar != null && eVar.cHm()) {
            if (this.kpI == null) {
                this.kpI = new h(this.kbv, cVar, eVar.cGN().aSH(), j);
                this.kpI.a(eVar.cGN().aSH(), eVar.cGN(), eVar.getForumId());
                this.kpI.startPlay();
            } else if (this.kpK) {
                this.kpI.a(eVar.cGN().aSH(), eVar.cGN(), eVar.getForumId());
                this.kpI.startPlay();
            } else {
                this.kpI.Kv(eVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.kbv.getUniqueId(), eVar, postData, 1, 1);
            if (eVar.cGO() != null && eVar.cGO().size() >= 1) {
                bu buVar = eVar.cGO().get(0);
                this.kpI.aN(buVar);
                this.kpI.Kw(buVar.getTitle());
            }
            this.kpI.b(postData, eVar.cGN(), eVar.cHl());
            this.kpK = false;
            bdTypeListView.removeHeaderView(this.kpI.cOX());
            bdTypeListView.addHeaderView(this.kpI.cOX(), 0);
            if (this.kpI.bua() != null && this.kpI.bua().getParent() == null) {
                frameLayout.addView(this.kpI.bua());
            }
            if (this.kpJ == null) {
                this.kpJ = new g(this.kbv.getBaseFragmentActivity());
            }
            this.kpJ.b(eVar, str);
            bdTypeListView.removeHeaderView(this.kpJ.cOQ());
            bdTypeListView.addHeaderView(this.kpJ.cOQ(), 1);
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
                bdTypeListView.removeHeaderView(this.kpI.cOX());
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
            this.kpI.cNo();
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
            if (this.kpI != null && this.kpI.bua() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.kpI.cOX());
                    pbLandscapeListView.addHeaderView(this.kpI.cOX(), 0);
                    return;
                }
                return;
            }
            if (this.kpI != null) {
                pbLandscapeListView.removeHeaderView(this.kpI.cOX());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean cMU() {
        return this.kpI != null && this.kpI.cMU();
    }

    public void cMV() {
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

    public void cNo() {
        if (this.kpI != null) {
            this.kpI.cNo();
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

    public View bua() {
        if (this.kpI != null) {
            return this.kpI.bua();
        }
        return null;
    }

    public int cNp() {
        View bua = bua();
        if (bua != null) {
            return bua.getHeight();
        }
        return 0;
    }

    public int cNq() {
        if (this.kpI != null) {
            return this.kpI.cNq();
        }
        return 0;
    }

    public boolean bAr() {
        if (this.kpI != null) {
            return this.kpI.bAr();
        }
        return false;
    }
}
