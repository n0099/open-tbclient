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
/* loaded from: classes21.dex */
public class e {
    private PbFragment kHX;
    private h kWW;
    private g kWX;
    private boolean kWY = false;

    public e(PbFragment pbFragment) {
        this.kHX = pbFragment;
    }

    public void a(f fVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.cZr()) {
            if (this.kWW == null) {
                this.kWW = new h(this.kHX, cVar, fVar.cYR().bfQ(), j);
                this.kWW.a(fVar.cYR().bfQ(), fVar.cYR(), fVar.getForumId());
                this.kWW.startPlay();
            } else if (this.kWY) {
                this.kWW.a(fVar.cYR().bfQ(), fVar.cYR(), fVar.getForumId());
                this.kWW.startPlay();
            } else {
                this.kWW.OE(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.kHX.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.cYS() != null && fVar.cYS().size() >= 1) {
                bw bwVar = fVar.cYS().get(0);
                this.kWW.aM(bwVar);
                this.kWW.OF(bwVar.getTitle());
            }
            this.kWW.b(postData, fVar.cYR(), fVar.cZq());
            this.kWY = false;
            bdTypeListView.removeHeaderView(this.kWW.dhi());
            bdTypeListView.addHeaderView(this.kWW.dhi(), 0);
            if (this.kWW.bHA() != null && this.kWW.bHA().getParent() == null) {
                frameLayout.addView(this.kWW.bHA());
            }
            if (this.kWX == null) {
                this.kWX = new g(this.kHX.getBaseFragmentActivity());
            }
            this.kWX.b(fVar, str);
            bdTypeListView.removeHeaderView(this.kWX.dhb());
            bdTypeListView.addHeaderView(this.kWX.dhb(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.kWW != null) {
                cVar.tY(false);
                this.kWW.EZ(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.kWW != null) {
                bdTypeListView.removeHeaderView(this.kWW.dhi());
            }
            if (this.kWX != null) {
                this.kWX.e(bdTypeListView);
            }
        }
    }

    public void tO(boolean z) {
        this.kWY = z;
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.kWW != null) {
            this.kWW.V(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.kWW != null) {
            TiebaStatic.log(new aq("c11997").ai("obj_type", 1));
            this.kWW.dfx();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean EY(int i) {
        if (this.kWW != null) {
            return this.kWW.ya(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.kWW != null && this.kWW.bHA() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.kWW.dhi());
                    pbLandscapeListView.addHeaderView(this.kWW.dhi(), 0);
                    return;
                }
                return;
            }
            if (this.kWW != null) {
                pbLandscapeListView.removeHeaderView(this.kWW.dhi());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean dfb() {
        return this.kWW != null && this.kWW.dfb();
    }

    public void dfc() {
        if (this.kWW != null) {
            this.kWW.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.kWW != null) {
            this.kWW.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.kWW != null) {
            this.kWW.onScrollStateChanged(absListView, i);
        }
    }

    public void tM(boolean z) {
        if (this.kWW != null) {
            this.kWW.tM(z);
        }
    }

    public void dfx() {
        if (this.kWW != null) {
            this.kWW.dfx();
        }
    }

    public void destroy() {
        if (this.kWW != null) {
            this.kWW.destroy();
        }
    }

    public void onPause() {
        if (this.kWW != null) {
            this.kWW.onPause();
        }
    }

    public void onResume() {
        if (this.kWW != null) {
            this.kWW.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.kWW != null) {
            this.kWW.onConfigurationChanged(configuration);
        }
    }

    public void EZ(int i) {
        if (this.kWW != null) {
            this.kWW.EZ(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kWX != null) {
            this.kWX.onChangeSkinType(i);
        }
    }

    public View bHA() {
        if (this.kWW != null) {
            return this.kWW.bHA();
        }
        return null;
    }

    public int dfy() {
        View bHA = bHA();
        if (bHA != null) {
            return bHA.getHeight();
        }
        return 0;
    }

    public int dfz() {
        if (this.kWW != null) {
            return this.kWW.dfz();
        }
        return 0;
    }

    public boolean bOo() {
        if (this.kWW != null) {
            return this.kWW.bOo();
        }
        return false;
    }
}
