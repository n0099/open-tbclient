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
/* loaded from: classes7.dex */
public class e {
    private PbFragment iCe;
    private h iPQ;
    private g iPR;
    private boolean iPS = false;

    public e(PbFragment pbFragment) {
        this.iCe = pbFragment;
    }

    public void a(f fVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.cjp()) {
            if (this.iPQ == null) {
                this.iPQ = new h(this.iCe, cVar, fVar.ciS().aAo(), j);
                this.iPQ.a(fVar.ciS().aAo(), fVar.ciS(), fVar.getForumId());
                this.iPQ.startPlay();
            } else if (this.iPS) {
                this.iPQ.a(fVar.ciS().aAo(), fVar.ciS(), fVar.getForumId());
                this.iPQ.startPlay();
            } else {
                this.iPQ.Gg(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.iCe.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.ciT() != null && fVar.ciT().size() >= 1) {
                bj bjVar = fVar.ciT().get(0);
                this.iPQ.aH(bjVar);
                this.iPQ.Gh(bjVar.getTitle());
            }
            this.iPQ.b(postData, fVar.ciS(), fVar.cjo());
            this.iPS = false;
            bdTypeListView.removeHeaderView(this.iPQ.cra());
            bdTypeListView.addHeaderView(this.iPQ.cra(), 0);
            if (this.iPQ.bat() != null && this.iPQ.bat().getParent() == null) {
                frameLayout.addView(this.iPQ.bat());
            }
            if (this.iPR == null) {
                this.iPR = new g(this.iCe.getBaseFragmentActivity());
            }
            this.iPR.b(fVar, str);
            bdTypeListView.removeHeaderView(this.iPR.cqT());
            bdTypeListView.addHeaderView(this.iPR.cqT(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.iPQ != null) {
                cVar.qA(false);
                this.iPQ.zb(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.iPQ != null) {
                bdTypeListView.removeHeaderView(this.iPQ.cra());
            }
            if (this.iPR != null) {
                this.iPR.e(bdTypeListView);
            }
        }
    }

    public void qr(boolean z) {
        this.iPS = z;
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.iPQ != null) {
            this.iPQ.R(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.iPQ != null) {
            TiebaStatic.log(new an("c11997").Z("obj_type", 1));
            this.iPQ.cpq();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean za(int i) {
        if (this.iPQ != null) {
            return this.iPQ.sZ(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.iPQ != null && this.iPQ.bat() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.iPQ.cra());
                    pbLandscapeListView.addHeaderView(this.iPQ.cra(), 0);
                    return;
                }
                return;
            }
            if (this.iPQ != null) {
                pbLandscapeListView.removeHeaderView(this.iPQ.cra());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean coX() {
        return this.iPQ != null && this.iPQ.coX();
    }

    public void coY() {
        if (this.iPQ != null) {
            this.iPQ.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iPQ != null) {
            this.iPQ.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.iPQ != null) {
            this.iPQ.onScrollStateChanged(absListView, i);
        }
    }

    public void qp(boolean z) {
        if (this.iPQ != null) {
            this.iPQ.qp(z);
        }
    }

    public void cpq() {
        if (this.iPQ != null) {
            this.iPQ.cpq();
        }
    }

    public void destroy() {
        if (this.iPQ != null) {
            this.iPQ.destroy();
        }
    }

    public void onPause() {
        if (this.iPQ != null) {
            this.iPQ.onPause();
        }
    }

    public void onResume() {
        if (this.iPQ != null) {
            this.iPQ.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iPQ != null) {
            this.iPQ.onConfigurationChanged(configuration);
        }
    }

    public void zb(int i) {
        if (this.iPQ != null) {
            this.iPQ.zb(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iPR != null) {
            this.iPR.onChangeSkinType(i);
        }
    }

    public View bat() {
        if (this.iPQ != null) {
            return this.iPQ.bat();
        }
        return null;
    }

    public int cpr() {
        View bat = bat();
        if (bat != null) {
            return bat.getHeight();
        }
        return 0;
    }

    public int cps() {
        if (this.iPQ != null) {
            return this.iPQ.cps();
        }
        return 0;
    }

    public boolean bgb() {
        if (this.iPQ != null) {
            return this.iPQ.bgb();
        }
        return false;
    }
}
