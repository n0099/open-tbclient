package com.baidu.tieba.pb.pb.main.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.video.g;
import com.baidu.tieba.pb.video.h;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class e {
    private h iMm;
    private g iMn;
    private boolean iMo = false;
    private PbFragment iyA;

    public e(PbFragment pbFragment) {
        this.iyA = pbFragment;
    }

    public void a(f fVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.cih()) {
            if (this.iMm == null) {
                this.iMm = new h(this.iyA, cVar, fVar.chK().azV(), j);
                this.iMm.a(fVar.chK().azV(), fVar.chK(), fVar.getForumId());
                this.iMm.startPlay();
            } else if (this.iMo) {
                this.iMm.a(fVar.chK().azV(), fVar.chK(), fVar.getForumId());
                this.iMm.startPlay();
            } else {
                this.iMm.FW(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.iyA.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.chL() != null && fVar.chL().size() >= 1) {
                bj bjVar = fVar.chL().get(0);
                this.iMm.aG(bjVar);
                this.iMm.FX(bjVar.getTitle());
            }
            this.iMm.b(postData, fVar.chK(), fVar.cig());
            this.iMo = false;
            bdTypeListView.removeHeaderView(this.iMm.cpR());
            bdTypeListView.addHeaderView(this.iMm.cpR(), 0);
            if (this.iMm.aZU() != null && this.iMm.aZU().getParent() == null) {
                frameLayout.addView(this.iMm.aZU());
            }
            if (this.iMn == null) {
                this.iMn = new g(this.iyA.getBaseFragmentActivity());
            }
            this.iMn.b(fVar, str);
            bdTypeListView.removeHeaderView(this.iMn.cpK());
            bdTypeListView.addHeaderView(this.iMn.cpK(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.iMm != null) {
                cVar.qo(false);
                this.iMm.yW(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.iMm != null) {
                bdTypeListView.removeHeaderView(this.iMm.cpR());
            }
            if (this.iMn != null) {
                this.iMn.e(bdTypeListView);
            }
        }
    }

    public void qf(boolean z) {
        this.iMo = z;
    }

    public void S(View.OnClickListener onClickListener) {
        if (this.iMm != null) {
            this.iMm.S(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.iMm != null) {
            TiebaStatic.log(new an("c11997").Z("obj_type", 1));
            this.iMm.coj();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean yV(int i) {
        if (this.iMm != null) {
            return this.iMm.sU(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.iMm != null && this.iMm.aZU() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.iMm.cpR());
                    pbLandscapeListView.addHeaderView(this.iMm.cpR(), 0);
                    return;
                }
                return;
            }
            if (this.iMm != null) {
                pbLandscapeListView.removeHeaderView(this.iMm.cpR());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean cnQ() {
        return this.iMm != null && this.iMm.cnQ();
    }

    public void cnR() {
        if (this.iMm != null) {
            this.iMm.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iMm != null) {
            this.iMm.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.iMm != null) {
            this.iMm.onScrollStateChanged(absListView, i);
        }
    }

    public void qd(boolean z) {
        if (this.iMm != null) {
            this.iMm.qd(z);
        }
    }

    public void coj() {
        if (this.iMm != null) {
            this.iMm.coj();
        }
    }

    public void destroy() {
        if (this.iMm != null) {
            this.iMm.destroy();
        }
    }

    public void onPause() {
        if (this.iMm != null) {
            this.iMm.onPause();
        }
    }

    public void onResume() {
        if (this.iMm != null) {
            this.iMm.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iMm != null) {
            this.iMm.onConfigurationChanged(configuration);
        }
    }

    public void yW(int i) {
        if (this.iMm != null) {
            this.iMm.yW(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iMn != null) {
            this.iMn.onChangeSkinType(i);
        }
    }

    public View aZU() {
        if (this.iMm != null) {
            return this.iMm.aZU();
        }
        return null;
    }

    public int cok() {
        View aZU = aZU();
        if (aZU != null) {
            return aZU.getHeight();
        }
        return 0;
    }

    public int col() {
        if (this.iMm != null) {
            return this.iMm.col();
        }
        return 0;
    }

    public boolean bfB() {
        if (this.iMm != null) {
            return this.iMm.bfB();
        }
        return false;
    }
}
