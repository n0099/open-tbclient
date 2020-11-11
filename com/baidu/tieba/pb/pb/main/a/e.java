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
    private h lEJ;
    private g lEK;
    private boolean lEL = false;
    private PbFragment lpI;

    public e(PbFragment pbFragment) {
        this.lpI = pbFragment;
    }

    public void a(f fVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.diK()) {
            if (this.lEJ == null) {
                this.lEJ = new h(this.lpI, cVar, fVar.dik().bmS(), j);
                this.lEJ.a(fVar.dik().bmS(), fVar.dik(), fVar.getForumId());
                this.lEJ.startPlay();
            } else if (this.lEL) {
                this.lEJ.a(fVar.dik().bmS(), fVar.dik(), fVar.getForumId());
                this.lEJ.startPlay();
            } else {
                this.lEJ.Qi(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.lpI.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.dil() != null && fVar.dil().size() >= 1) {
                bw bwVar = fVar.dil().get(0);
                this.lEJ.aM(bwVar);
                this.lEJ.Qj(bwVar.getTitle());
            }
            this.lEJ.b(postData, fVar.dik(), fVar.diJ());
            this.lEL = false;
            bdTypeListView.removeHeaderView(this.lEJ.dqB());
            bdTypeListView.addHeaderView(this.lEJ.dqB(), 0);
            if (this.lEJ.bPo() != null && this.lEJ.bPo().getParent() == null) {
                frameLayout.addView(this.lEJ.bPo());
            }
            if (this.lEK == null) {
                this.lEK = new g(this.lpI.getBaseFragmentActivity());
            }
            this.lEK.b(fVar, str);
            bdTypeListView.removeHeaderView(this.lEK.dqu());
            bdTypeListView.addHeaderView(this.lEK.dqu(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.lEJ != null) {
                cVar.vf(false);
                this.lEJ.Gl(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.lEJ != null) {
                bdTypeListView.removeHeaderView(this.lEJ.dqB());
            }
            if (this.lEK != null) {
                this.lEK.e(bdTypeListView);
            }
        }
    }

    public void uV(boolean z) {
        this.lEL = z;
    }

    public void W(View.OnClickListener onClickListener) {
        if (this.lEJ != null) {
            this.lEJ.W(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.lEJ != null) {
            TiebaStatic.log(new aq("c11997").al("obj_type", 1));
            this.lEJ.doQ();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean Gk(int i) {
        if (this.lEJ != null) {
            return this.lEJ.zm(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.lEJ != null && this.lEJ.bPo() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.lEJ.dqB());
                    pbLandscapeListView.addHeaderView(this.lEJ.dqB(), 0);
                    return;
                }
                return;
            }
            if (this.lEJ != null) {
                pbLandscapeListView.removeHeaderView(this.lEJ.dqB());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean dou() {
        return this.lEJ != null && this.lEJ.dou();
    }

    public void dov() {
        if (this.lEJ != null) {
            this.lEJ.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.lEJ != null) {
            this.lEJ.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lEJ != null) {
            this.lEJ.onScrollStateChanged(absListView, i);
        }
    }

    public void uT(boolean z) {
        if (this.lEJ != null) {
            this.lEJ.uT(z);
        }
    }

    public void doQ() {
        if (this.lEJ != null) {
            this.lEJ.doQ();
        }
    }

    public void destroy() {
        if (this.lEJ != null) {
            this.lEJ.destroy();
        }
    }

    public void onPause() {
        if (this.lEJ != null) {
            this.lEJ.onPause();
        }
    }

    public void onResume() {
        if (this.lEJ != null) {
            this.lEJ.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.lEJ != null) {
            this.lEJ.onConfigurationChanged(configuration);
        }
    }

    public void Gl(int i) {
        if (this.lEJ != null) {
            this.lEJ.Gl(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lEK != null) {
            this.lEK.onChangeSkinType(i);
        }
    }

    public View bPo() {
        if (this.lEJ != null) {
            return this.lEJ.bPo();
        }
        return null;
    }

    public int doR() {
        View bPo = bPo();
        if (bPo != null) {
            return bPo.getHeight();
        }
        return 0;
    }

    public int doS() {
        if (this.lEJ != null) {
            return this.lEJ.doS();
        }
        return 0;
    }

    public boolean bXc() {
        if (this.lEJ != null) {
            return this.lEJ.bXc();
        }
        return false;
    }
}
