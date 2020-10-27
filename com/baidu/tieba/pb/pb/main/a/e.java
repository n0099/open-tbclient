package com.baidu.tieba.pb.pb.main.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.video.g;
import com.baidu.tieba.pb.video.h;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class e {
    private PbFragment ljH;
    private h lyN;
    private g lyO;
    private boolean lyP = false;

    public e(PbFragment pbFragment) {
        this.ljH = pbFragment;
    }

    public void a(f fVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.dgi()) {
            if (this.lyN == null) {
                this.lyN = new h(this.ljH, cVar, fVar.dfI().bks(), j);
                this.lyN.a(fVar.dfI().bks(), fVar.dfI(), fVar.getForumId());
                this.lyN.startPlay();
            } else if (this.lyP) {
                this.lyN.a(fVar.dfI().bks(), fVar.dfI(), fVar.getForumId());
                this.lyN.startPlay();
            } else {
                this.lyN.PR(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.ljH.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.dfJ() != null && fVar.dfJ().size() >= 1) {
                bw bwVar = fVar.dfJ().get(0);
                this.lyN.aM(bwVar);
                this.lyN.PS(bwVar.getTitle());
            }
            this.lyN.b(postData, fVar.dfI(), fVar.dgh());
            this.lyP = false;
            bdTypeListView.removeHeaderView(this.lyN.dnZ());
            bdTypeListView.addHeaderView(this.lyN.dnZ(), 0);
            if (this.lyN.bMO() != null && this.lyN.bMO().getParent() == null) {
                frameLayout.addView(this.lyN.bMO());
            }
            if (this.lyO == null) {
                this.lyO = new g(this.ljH.getBaseFragmentActivity());
            }
            this.lyO.b(fVar, str);
            bdTypeListView.removeHeaderView(this.lyO.dnS());
            bdTypeListView.addHeaderView(this.lyO.dnS(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.lyN != null) {
                cVar.uW(false);
                this.lyN.FY(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.lyN != null) {
                bdTypeListView.removeHeaderView(this.lyN.dnZ());
            }
            if (this.lyO != null) {
                this.lyO.e(bdTypeListView);
            }
        }
    }

    public void uM(boolean z) {
        this.lyP = z;
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.lyN != null) {
            this.lyN.V(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.lyN != null) {
            TiebaStatic.log(new aq("c11997").aj("obj_type", 1));
            this.lyN.dmn();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean FX(int i) {
        if (this.lyN != null) {
            return this.lyN.yZ(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.lyN != null && this.lyN.bMO() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.lyN.dnZ());
                    pbLandscapeListView.addHeaderView(this.lyN.dnZ(), 0);
                    return;
                }
                return;
            }
            if (this.lyN != null) {
                pbLandscapeListView.removeHeaderView(this.lyN.dnZ());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean dlR() {
        return this.lyN != null && this.lyN.dlR();
    }

    public void dlS() {
        if (this.lyN != null) {
            this.lyN.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.lyN != null) {
            this.lyN.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lyN != null) {
            this.lyN.onScrollStateChanged(absListView, i);
        }
    }

    public void uK(boolean z) {
        if (this.lyN != null) {
            this.lyN.uK(z);
        }
    }

    public void dmn() {
        if (this.lyN != null) {
            this.lyN.dmn();
        }
    }

    public void destroy() {
        if (this.lyN != null) {
            this.lyN.destroy();
        }
    }

    public void onPause() {
        if (this.lyN != null) {
            this.lyN.onPause();
        }
    }

    public void onResume() {
        if (this.lyN != null) {
            this.lyN.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.lyN != null) {
            this.lyN.onConfigurationChanged(configuration);
        }
    }

    public void FY(int i) {
        if (this.lyN != null) {
            this.lyN.FY(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lyO != null) {
            this.lyO.onChangeSkinType(i);
        }
    }

    public View bMO() {
        if (this.lyN != null) {
            return this.lyN.bMO();
        }
        return null;
    }

    public int dmo() {
        View bMO = bMO();
        if (bMO != null) {
            return bMO.getHeight();
        }
        return 0;
    }

    public int dmp() {
        if (this.lyN != null) {
            return this.lyN.dmp();
        }
        return 0;
    }

    public boolean bUC() {
        if (this.lyN != null) {
            return this.lyN.bUC();
        }
        return false;
    }
}
